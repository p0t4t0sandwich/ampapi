package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * CPU information object
 * @param Cores Number of CPU cores
 * @param ModelName CPU model name
 * @param Sockets Number of CPU sockets
 * @param Threads Number of CPU threads
 * @param TotalCores Total number of CPU cores
 * @param TotalThreads Total number of CPU threads
 * @param Vendor CPU vendor
 */
public record ProcessorInfo(Integer Cores, String ModelName, Integer Sockets, Integer Threads, Integer TotalCores, Integer TotalThreads, String Vendor) {}
