package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.events.OpenFileCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcu extends RegisterListenerMethod<zzaw, OpenFileCallback> {
    public final /* synthetic */ DriveFile zzfs;
    public final /* synthetic */ int zzft;
    public final /* synthetic */ zzg zzfu;
    public final /* synthetic */ ListenerHolder zzfv;
    public final /* synthetic */ zzch zzfw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcu(zzch zzch, ListenerHolder listenerHolder, DriveFile driveFile, int i, zzg zzg, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.zzfw = zzch;
        this.zzfs = driveFile;
        this.zzft = i;
        this.zzfu = zzg;
        this.zzfv = listenerHolder2;
    }

    public final /* synthetic */ void registerListener(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzfu.setCancelToken(ICancelToken.Stub.asInterface(((zzeo) ((zzaw) anyClient).getService()).zza(new zzgj(this.zzfs.getDriveId(), this.zzft, 0), (zzeq) new zzdk(this.zzfw, this.zzfu, this.zzfv)).zzgs));
        taskCompletionSource.setResult(null);
    }
}
