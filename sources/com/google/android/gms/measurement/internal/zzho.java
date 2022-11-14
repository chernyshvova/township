package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzho implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb = null;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ zzhb zze;

    public zzho(zzhb zzhb, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zze = zzhb;
        this.zza = atomicReference;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final void run() {
        this.zze.zzy.zzv().zza((AtomicReference<List<zzz>>) this.zza, (String) null, this.zzc, this.zzd);
    }
}
