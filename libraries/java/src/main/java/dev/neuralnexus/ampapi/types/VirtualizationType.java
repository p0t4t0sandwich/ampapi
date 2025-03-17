package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the virtualization type
 * None_: None/Bare Metal
 * VMware: VMware
 * VMwareESX: VMware ESX
 * VirtualBox: VirtualBox
 * Xen: Xen
 * QEMU_KVM: QEMU KVM
 * OpenVZ: OpenVZ
 * HyperV: HyperV
 * Docker: Docker
 * LXC: LXC
 * WSL: Windows Subsystem for Linux
 * ProxmoxVM: ProxmoxVM
 * ProxmoxLXC: Proxmox LXC Container
 */
public enum VirtualizationType {
    @SerializedName("0")
    None_(0),
    @SerializedName("1")
    VMware(1),
    @SerializedName("2")
    VMwareESX(2),
    @SerializedName("3")
    VirtualBox(3),
    @SerializedName("4")
    Xen(4),
    @SerializedName("5")
    QEMU_KVM(5),
    @SerializedName("6")
    OpenVZ(6),
    @SerializedName("7")
    HyperV(7),
    @SerializedName("8")
    Docker(8),
    @SerializedName("9")
    LXC(9),
    @SerializedName("10")
    WSL(10),
    @SerializedName("11")
    ProxmoxVM(11),
    @SerializedName("12")
    ProxmoxLXC(12);

    /** The value of the enum. */
    private final int value;

    VirtualizationType(int i) {
        this.value = i;
    }

    VirtualizationType(double i) {
        this.value = (int) i;
    }
}
