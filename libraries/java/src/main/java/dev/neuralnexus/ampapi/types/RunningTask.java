/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.Optional;
import java.util.UUID;

/**
 * A running task object
 *
 * @param Description The description
 * @param DontPropagate Whether the task should not propagate
 * @param FastDismiss Whether the task can be dismissed quickly
 * @param HideFromUI Whether the task is hidden from the UI
 * @param Id The task ID
 * @param IsCancellable Whether the task is cancellable
 * @param IsIndeterminate Whether the task is indeterminate
 * @param IsPrimaryTask Whether the task is primary
 * @param LastUpdatePushed The last update pushed
 * @param Name The name
 * @param Origin The origin
 * @param ProgressPercent The progress percentage
 * @param Speed The speed
 * @param StartTime The start time
 * @param State The state
 * @param StateMessage The state message
 * @param RemoteInstanceId The remote instance ID
 * @param EndTime The end time
 * @param ParentTaskId The parent task ID
 */
public record RunningTask(
        String Description,
        Boolean DontPropagate,
        Boolean FastDismiss,
        Boolean HideFromUI,
        UUID Id,
        Boolean IsCancellable,
        Boolean IsIndeterminate,
        Boolean IsPrimaryTask,
        String LastUpdatePushed,
        String Name,
        String Origin,
        Integer ProgressPercent,
        String Speed,
        String StartTime,
        TaskState State,
        String StateMessage,
        Optional<UUID> RemoteInstanceId,
        Optional<String> EndTime,
        Optional<UUID> ParentTaskId) {}
