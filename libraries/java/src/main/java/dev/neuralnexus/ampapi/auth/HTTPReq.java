/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi-java/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dev.neuralnexus.ampapi.exceptions.AMPAPIException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Map;

public class HTTPReq {
    private static final Gson gson = new GsonBuilder().create();

    public static <T> T APICall(
            String endpoint, String requestMethod, Map<String, Object> args, Type returnType) {
        try {
            HttpURLConnection con = (HttpURLConnection) URI.create(endpoint).toURL().openConnection();
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
                throw new AMPAPIException(gson.fromJson(jsonString, AMPAPIException.Data.class));
            }
            if (returnType == Void.class) {
                return null;
            }
            return gson.fromJson(jsonString, returnType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
