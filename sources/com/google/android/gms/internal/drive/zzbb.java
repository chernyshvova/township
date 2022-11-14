package com.google.android.gms.internal.drive;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.CreateFileActivityOptions;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveClient;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.OpenFileActivityOptions;
import com.google.android.gms.drive.TransferPreferences;
import com.google.android.gms.tasks.Task;

public final class zzbb extends DriveClient {
    public zzbb(@NonNull Context context, @Nullable Drive.zza zza) {
        super(context, zza);
    }

    public final Task<DriveId> getDriveId(@NonNull String str) {
        Preconditions.checkNotNull(str, "resourceId must not be null");
        return doRead(new zzbc(this, str));
    }

    public final Task<TransferPreferences> getUploadPreferences() {
        return doRead(new zzbd(this));
    }

    public final Task<IntentSender> newCreateFileActivityIntentSender(CreateFileActivityOptions createFileActivityOptions) {
        return doRead(new zzbg(this, createFileActivityOptions));
    }

    public final Task<IntentSender> newOpenFileActivityIntentSender(OpenFileActivityOptions openFileActivityOptions) {
        return doRead(new zzbf(this, openFileActivityOptions));
    }

    public final Task<Void> requestSync() {
        return doWrite(new zzbh(this));
    }

    public final Task<Void> setUploadPreferences(@NonNull TransferPreferences transferPreferences) {
        Preconditions.checkNotNull(transferPreferences, "transferPreferences cannot be null.");
        return doWrite(new zzbe(this, transferPreferences));
    }

    public zzbb(@NonNull Activity activity, @Nullable Drive.zza zza) {
        super(activity, zza);
    }
}
