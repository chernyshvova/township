package com.google.android.gms.drive;

import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import java.io.InputStream;
import java.io.OutputStream;

public interface DriveContents {
    @Deprecated
    PendingResult<Status> commit(GoogleApiClient googleApiClient, @Nullable MetadataChangeSet metadataChangeSet);

    @Deprecated
    PendingResult<Status> commit(GoogleApiClient googleApiClient, @Nullable MetadataChangeSet metadataChangeSet, @Nullable ExecutionOptions executionOptions);

    @Deprecated
    void discard(GoogleApiClient googleApiClient);

    DriveId getDriveId();

    InputStream getInputStream();

    int getMode();

    OutputStream getOutputStream();

    ParcelFileDescriptor getParcelFileDescriptor();

    @Deprecated
    PendingResult<DriveApi.DriveContentsResult> reopenForWrite(GoogleApiClient googleApiClient);

    Contents zzi();

    void zzj();

    boolean zzk();
}
