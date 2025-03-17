/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * CPU information object
 *
 * @param Cores Number of CPU cores
 * @param ModelName CPU model name
 * @param Sockets Number of CPU sockets
 * @param Threads Number of CPU threads
 * @param TotalCores Total number of CPU cores
 * @param TotalThreads Total number of CPU threads
 * @param Vendor CPU vendor
 */
public record ProcessorInfo(
        Integer Cores,
        String ModelName,
        Integer Sockets,
        Integer Threads,
        Integer TotalCores,
        Integer TotalThreads,
        String Vendor) {}
