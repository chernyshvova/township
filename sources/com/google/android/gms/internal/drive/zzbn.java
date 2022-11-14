package com.google.android.gms.internal.drive;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;

public final class zzbn extends zzdp implements DriveFile {
    public zzbn(DriveId driveId) {
        super(driveId);
    }

    public final PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient googleApiClient, int i, @Nullable DriveFile.DownloadProgressListener downloadProgressListener) {
        zzbp zzbp;
        if (i == 268435456 || i == 536870912 || i == 805306368) {
            if (downloadProgressListener == null) {
                zzbp = null;
            } else {
                zzbp = new zzbp(googleApiClient.registerListener(downloadProgressListener));
            }
            return googleApiClient.enqueue(new zzbo(this, googleApiClient, i, zzbp));
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
