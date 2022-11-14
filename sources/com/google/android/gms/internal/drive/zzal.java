package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;

public final class zzal implements Releasable, DriveApi.DriveContentsResult {
    public final Status zzdy;
    public final DriveContents zzo;

    public zzal(Status status, DriveContents driveContents) {
        this.zzdy = status;
        this.zzo = driveContents;
    }

    public final DriveContents getDriveContents() {
        return this.zzo;
    }

    public final Status getStatus() {
        return this.zzdy;
    }

    public final void release() {
        DriveContents driveContents = this.zzo;
        if (driveContents != null) {
            driveContents.zzj();
        }
    }
}
