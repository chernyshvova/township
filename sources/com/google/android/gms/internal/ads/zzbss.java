package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzbss implements Runnable {
    public final zzbsw zza;
    public final String zzb;

    public zzbss(zzbsw zzbsw, String str) {
        this.zza = zzbsw;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzn(this.zzb);
    }
}
