package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A chunk of file data
 * @param Base64Data The base64 data
 * @param BytesLength The length of the data in bytes
 */
public record FileChunkData(String Base64Data, Integer BytesLength) {}
