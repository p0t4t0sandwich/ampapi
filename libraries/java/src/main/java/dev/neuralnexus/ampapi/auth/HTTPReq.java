/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import dev.neuralnexus.ampapi.exceptions.AMPAPIException;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Map;
import java.util.Optional;

public class HTTPReq {
    private static final Gson gson =
            new GsonBuilder().registerTypeAdapterFactory(OptionalTypeAdapter.FACTORY).create();

    public static @NotNull <T> T APICall(
            String endpoint, String requestMethod, Map<String, Object> args, Type returnType) {
        try {
            HttpURLConnection con =
                    (HttpURLConnection) URI.create(endpoint).toURL().openConnection();
            con.setDoOutput(true);
            con.setRequestMethod(requestMethod);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("User-Agent", "ampapi-java/1.3.0");
            con.setConnectTimeout(5000);
            con.getOutputStream().write(gson.toJson(args).getBytes());

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String jsonString = br.readLine();
            br.close();

            if (jsonString.contains("Title")
                    && jsonString.contains("Message")
                    && jsonString.contains("StackTrace")) {
                throw new AMPAPIException(
                        gson.fromJson(jsonString, AMPAPIException.APIError.class));
            }
            if (returnType == Void.class) {
                return null;
            }
            return gson.fromJson(jsonString, returnType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Type adapter for Optional, <a
     * href="https://stackoverflow.com/questions/12161366/how-to-serialize-optionalt-classes-with-gson/25078422#25078422">
     * found in this StackOverflow post</a>
     *
     * @param <E> The inner type of the Optional
     */
    public static class OptionalTypeAdapter<E> extends TypeAdapter<Optional<E>> {
        public static final TypeAdapterFactory FACTORY =
                new TypeAdapterFactory() {
                    @SuppressWarnings({"rawtypes", "unchecked"})
                    @Override
                    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
                        Class<T> rawType = (Class<T>) type.getRawType();
                        if (rawType != Optional.class) {
                            return null;
                        }
                        final ParameterizedType parameterizedType =
                                (ParameterizedType) type.getType();
                        final Type actualType = parameterizedType.getActualTypeArguments()[0];
                        final TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(actualType));
                        return new OptionalTypeAdapter(adapter);
                    }
                };
        private final TypeAdapter<E> adapter;

        public OptionalTypeAdapter(TypeAdapter<E> adapter) {

            this.adapter = adapter;
        }

        @Override
        public void write(JsonWriter out, Optional<E> value) throws IOException {
            if (value.isPresent()) {
                adapter.write(out, value.get());
            } else {
                out.nullValue();
            }
        }

        @Override
        public Optional<E> read(JsonReader in) throws IOException {
            final JsonToken peek = in.peek();
            if (peek != JsonToken.NULL) {
                return Optional.ofNullable(adapter.read(in));
            }

            in.nextNull();
            return Optional.empty();
        }
    }
}
