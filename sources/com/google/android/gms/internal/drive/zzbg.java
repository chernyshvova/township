package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.CreateFileActivityOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbg extends TaskApiCall<zzaw, IntentSender> {
    public final /* synthetic */ CreateFileActivityOptions zzer;

    public zzbg(zzbb zzbb, CreateFileActivityOptions createFileActivityOptions) {
        this.zzer = createFileActivityOptions;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        this.zzer.zzde.zza(zzaw.getContext());
        CreateFileActivityOptions createFileActivityOptions = this.zzer;
        MetadataBundle metadataBundle = createFileActivityOptions.zzde;
        int intValue = createFileActivityOptions.zzdk.intValue();
        CreateFileActivityOptions createFileActivityOptions2 = this.zzer;
        taskCompletionSource.setResult(((zzeo) zzaw.getService()).zza(new zzu(metadataBundle, intValue, createFileActivityOptions2.zzba, createFileActivityOptions2.zzbd, Integer.valueOf(createFileActivityOptions2.zzdl))));
    }
}
