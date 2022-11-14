package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzgk implements Callable<byte[]> {
    public final /* synthetic */ zzaq zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzfz zzc;

    public zzgk(zzfz zzfz, zzaq zzaq, String str) {
        this.zzc = zzfz;
        this.zza = zzaq;
        this.zzb = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzc.zza.zzr();
        return this.zzc.zza.zzg().zza(this.zza, this.zzb);
    }
}
