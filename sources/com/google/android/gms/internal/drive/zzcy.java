package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.zzn;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcy extends TaskApiCall<zzaw, Void> {
    public final /* synthetic */ MetadataChangeSet zzew;
    public final /* synthetic */ DriveContents zzfx;
    public final /* synthetic */ zzn zzfy;

    public zzcy(zzch zzch, zzn zzn, DriveContents driveContents, MetadataChangeSet metadataChangeSet) {
        this.zzfy = zzn;
        this.zzfx = driveContents;
        this.zzew = metadataChangeSet;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        try {
            this.zzfy.zza(zzaw);
        } catch (IllegalStateException e) {
            taskCompletionSource.setException(e);
        }
        this.zzfx.zzj();
        this.zzew.zzq().zza(zzaw.getContext());
        ((zzeo) zzaw.getService()).zza(new zzm(this.zzfx.getDriveId(), this.zzew.zzq(), this.zzfx.zzi().getRequestId(), this.zzfx.zzi().zzb(), this.zzfy), (zzeq) new zzhr(taskCompletionSource));
    }
}
