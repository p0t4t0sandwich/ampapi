package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the state of an instance's application
 * Undefined: Undefined
 * Stopped: Stopped
 * PreStart: The server is performing some first-time-start configuration.
 * Configuring: The server is performing some first-time-start configuration.
 * Starting: Starting
 * Ready: Ready
 * Restarting: Server is in the middle of stopping, but once shutdown has finished it will automatically restart.
 * Stopping: Stopping
 * PreparingForSleep: Preparing for sleep
 * Sleeping: The application should be able to be resumed quickly if using this state. Otherwise use Stopped.
 * Waiting: The application is waiting for some external service/application to respond/become available.
 * Installing: Installing
 * Updating: Updating
 * AwaitingUserInput: Used during installation, means that some user input is required to complete setup (authentication etc).
 * Failed: Failed
 * Suspended: Suspended
 * Maintainence: Maintainence
 * Indeterminate: The state is unknown, or doesn't apply (for modules that don't start an external process)
 */
public enum ApplicationState {
    @SerializedName("-1")
    Undefined(-1),
    @SerializedName("0")
    Stopped(0),
    @SerializedName("5")
    PreStart(5),
    @SerializedName("7")
    Configuring(7),
    @SerializedName("10")
    Starting(10),
    @SerializedName("20")
    Ready(20),
    @SerializedName("30")
    Restarting(30),
    @SerializedName("40")
    Stopping(40),
    @SerializedName("45")
    PreparingForSleep(45),
    @SerializedName("50")
    Sleeping(50),
    @SerializedName("60")
    Waiting(60),
    @SerializedName("70")
    Installing(70),
    @SerializedName("75")
    Updating(75),
    @SerializedName("80")
    AwaitingUserInput(80),
    @SerializedName("100")
    Failed(100),
    @SerializedName("200")
    Suspended(200),
    @SerializedName("250")
    Maintainence(250),
    @SerializedName("999")
    Indeterminate(999);

    /** The value of the enum. */
    private final int value;

    ApplicationState(int i) {
        this.value = i;
    }

    ApplicationState(double i) {
        this.value = (int) i;
    }
}
