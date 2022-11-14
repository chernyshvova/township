package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbve;
import com.google.android.gms.internal.ads.zzbzf;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class OfflinePingSender extends Worker {
    public final zzbzf zza;

    public OfflinePingSender(@RecentlyNonNull Context context, @RecentlyNonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zza = zzbev.zzb().zzi(context, new zzbve());
    }

    @RecentlyNonNull
    public final ListenableWorker.Result doWork() {
        try {
            this.zza.zzg();
            return ListenableWorker.Result.success();
        } catch (RemoteException unused) {
            return ListenableWorker.Result.failure();
        }
    }
}
