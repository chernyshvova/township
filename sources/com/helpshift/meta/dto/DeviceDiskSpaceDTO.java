package com.helpshift.meta.dto;

public class DeviceDiskSpaceDTO {
    public final String phoneFreeSpace;
    public final String phoneTotalSpace;

    public DeviceDiskSpaceDTO(String str, String str2, String str3, String str4) {
        this.phoneTotalSpace = str;
        this.phoneFreeSpace = str2;
    }
}
