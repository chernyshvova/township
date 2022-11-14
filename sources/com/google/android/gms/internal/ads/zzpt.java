package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzpt implements Runnable {
    public final zzpy zza;
    public final String zzb;

    public zzpt(zzpy zzpy, String str) {
        this.zza = zzpy;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
