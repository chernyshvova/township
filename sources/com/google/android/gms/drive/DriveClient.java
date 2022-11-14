package com.google.android.gms.drive;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.tasks.Task;

@Deprecated
public abstract class DriveClient extends GoogleApi<Drive.zza> {
    public DriveClient(@NonNull Context context, @NonNull Drive.zza zza) {
        super(context, Drive.zzw, zza, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Deprecated
    public abstract Task<DriveId> getDriveId(@NonNull String str);

    @Deprecated
    public abstract Task<TransferPreferences> getUploadPreferences();

    @Deprecated
    public abstract Task<IntentSender> newCreateFileActivityIntentSender(CreateFileActivityOptions createFileActivityOptions);

    @Deprecated
    public abstract Task<IntentSender> newOpenFileActivityIntentSender(OpenFileActivityOptions openFileActivityOptions);

    @Deprecated
    public abstract Task<Void> requestSync();

    @Deprecated
    public abstract Task<Void> setUploadPreferences(@NonNull TransferPreferences transferPreferences);

    public DriveClient(@NonNull Activity activity, @Nullable Drive.zza zza) {
        super(activity, Drive.zzw, zza, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
