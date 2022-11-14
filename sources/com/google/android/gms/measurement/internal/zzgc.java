package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzgc implements Callable<List<zzkw>> {
    public final /* synthetic */ zzn zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzfz zzd;

    public zzgc(zzfz zzfz, zzn zzn, String str, String str2) {
        this.zzd = zzfz;
        this.zza = zzn;
        this.zzb = str;
        this.zzc = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzd.zza.zzr();
        return this.zzd.zza.zze().zza(this.zza.zza, this.zzb, this.zzc);
    }
}
