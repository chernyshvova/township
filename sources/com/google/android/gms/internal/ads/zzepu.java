package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzepu implements zzfju {
    public final String zza;

    public zzepu(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        String valueOf = String.valueOf(this.zza);
        zzcgs.zzf(valueOf.length() != 0 ? "Error calling adapter: ".concat(valueOf) : new String("Error calling adapter: "));
        return null;
    }
}
