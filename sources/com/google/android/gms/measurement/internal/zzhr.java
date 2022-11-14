package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhr implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb = null;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzhb zzf;

    public zzhr(zzhb zzhb, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.zzf = zzhb;
        this.zza = atomicReference;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
    }

    public final void run() {
        this.zzf.zzy.zzv().zza(this.zza, (String) null, this.zzc, this.zzd, this.zze);
    }
}
