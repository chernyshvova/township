package com.google.android.gms.games.internal;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzba {
    public static final zzba zza = new zzba();
    public volatile boolean zzb = false;

    public static zzba zza() {
        return zza;
    }

    public final void zzb() {
        this.zzb = true;
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
