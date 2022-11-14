package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.zzk;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzdh extends TaskApiCall<zzaw, DriveFile> {
    public final DriveFolder zzfj;
    public final MetadataChangeSet zzgc;
    public ExecutionOptions zzgd;
    public String zzge = null;
    public zzk zzgf;
    public final DriveContents zzo;

    public zzdh(@NonNull DriveFolder driveFolder, @NonNull MetadataChangeSet metadataChangeSet, @Nullable DriveContents driveContents, @NonNull ExecutionOptions executionOptions, @Nullable String str) {
        this.zzfj = driveFolder;
        this.zzgc = metadataChangeSet;
        this.zzo = driveContents;
        this.zzgd = executionOptions;
        Preconditions.checkNotNull(driveFolder, "DriveFolder must not be null");
        Preconditions.checkNotNull(driveFolder.getDriveId(), "Folder's DriveId must not be null");
        Preconditions.checkNotNull(metadataChangeSet, "MetadataChangeSet must not be null");
        Preconditions.checkNotNull(executionOptions, "ExecutionOptions must not be null");
        zzk zzg = zzk.zzg(metadataChangeSet.getMimeType());
        this.zzgf = zzg;
        if (zzg != null && zzg.isFolder()) {
            throw new IllegalArgumentException("May not create folders using this method. Use DriveFolderManagerClient#createFolder() instead of mime type application/vnd.google-apps.folder");
        } else if (driveContents == null) {
        } else {
            if (!(driveContents instanceof zzbi)) {
                throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
            } else if (driveContents.getDriveId() != null) {
                throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
            } else if (driveContents.zzk()) {
                throw new IllegalArgumentException("DriveContents are already closed.");
            }
        }
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        this.zzgd.zza(zzaw);
        MetadataChangeSet metadataChangeSet = this.zzgc;
        metadataChangeSet.zzq().zza(zzaw.getContext());
        int zza = zzbs.zza(this.zzo, this.zzgf);
        zzk zzk = this.zzgf;
        ((zzeo) zzaw.getService()).zza(new zzw(this.zzfj.getDriveId(), metadataChangeSet.zzq(), zza, (zzk == null || !zzk.zzbh()) ? 0 : 1, this.zzgd), (zzeq) new zzhj(taskCompletionSource));
    }
}
