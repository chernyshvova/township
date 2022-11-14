package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;

public final class zzcf implements DrivePreferencesApi.FileUploadPreferencesResult {
    public final Status zzdy;
    public final FileUploadPreferences zzfm;

    public zzcf(zzcb zzcb, Status status, FileUploadPreferences fileUploadPreferences) {
        this.zzdy = status;
        this.zzfm = fileUploadPreferences;
    }

    public final FileUploadPreferences getFileUploadPreferences() {
        return this.zzfm;
    }

    public final Status getStatus() {
        return this.zzdy;
    }

    public /* synthetic */ zzcf(zzcb zzcb, Status status, FileUploadPreferences fileUploadPreferences, zzcc zzcc) {
        this(zzcb, status, fileUploadPreferences);
    }
}
