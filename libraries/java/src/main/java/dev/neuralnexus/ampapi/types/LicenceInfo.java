package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A struct to represent the object returned by Core#ActivateAMPLicence(Guid, Boolean)
 * @param Expires The expiry date
 * @param Grade The grade
 * @param GradeName The grade name
 * @param LicenceKey The licence key
 * @param Product The product
 * @param ProductName The product name
 * @param Usage The usage
 */
public record LicenceInfo(String Expires, UUID Grade, String GradeName, UUID LicenceKey, UUID Product, String ProductName, Integer Usage) {}
