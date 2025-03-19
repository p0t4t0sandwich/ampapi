/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * A chunk of file data
 *
 * @param Base64Data The base64 data
 * @param BytesLength The length of the data in bytes
 */
public record FileChunkData(String Base64Data, Integer BytesLength) {}
