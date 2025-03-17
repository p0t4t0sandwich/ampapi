package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * A schedule entry definition
 * @param EnabledState The enabled state
 * @param ErrorBehaviour The error behaviour
 * @param Id The ID
 * @param LastErrorReason The last error reason
 * @param LastExecuteError Whether the last execution had an error
 * @param Locked Whether the entry is locked
 * @param Order The order
 * @param ParameterMapping The parameter mapping
 * @param TaskMethodName The task method name
 * @param WaitForComplete Whether to wait for completion
 * @param CreatedBy The creator
 */
public record ScheduleEntryDefinition(ScheduleEnabledState EnabledState, ScheduleErrorBehaviour ErrorBehaviour, UUID Id, String LastErrorReason, Boolean LastExecuteError, Boolean Locked, Integer Order, Map<String, String> ParameterMapping, String TaskMethodName, Boolean WaitForComplete, Optional<UUID> CreatedBy) {}
