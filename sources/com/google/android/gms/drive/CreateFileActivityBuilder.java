package com.google.android.gms.drive;

import android.content.IntentSender;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.drive.zzbi;
import com.google.android.gms.internal.drive.zzt;

@Deprecated
public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    public final zzt zzn = new zzt(0);
    @Nullable
    public DriveContents zzo;
    public boolean zzp;

    public IntentSender build(GoogleApiClient googleApiClient) {
        Preconditions.checkState(googleApiClient.isConnected(), "Client must be connected");
        zzg();
        return this.zzn.build(googleApiClient);
    }

    public final int getRequestId() {
        return this.zzn.getRequestId();
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.zzn.zza(driveId);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String str) {
        this.zzn.zzc(str);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(@Nullable DriveContents driveContents) {
        if (driveContents == null) {
            this.zzn.zzd(1);
        } else if (!(driveContents instanceof zzbi)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (!driveContents.zzk()) {
            this.zzn.zzd(driveContents.zzi().zzj);
            this.zzo = driveContents;
        } else {
            throw new IllegalArgumentException("DriveContents are already closed.");
        }
        this.zzp = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.zzn.zza(metadataChangeSet);
        return this;
    }

    public final MetadataChangeSet zzc() {
        return this.zzn.zzc();
    }

    public final DriveId zzd() {
        return this.zzn.zzd();
    }

    public final String zze() {
        return this.zzn.zze();
    }

    public final int zzf() {
        return 0;
    }

    public final void zzg() {
        Preconditions.checkState(this.zzp, "Must call setInitialDriveContents.");
        DriveContents driveContents = this.zzo;
        if (driveContents != null) {
            driveContents.zzj();
        }
        this.zzn.zzg();
    }
}
