package com.google.android.gms.games.internal.p034v2.resolution;

import android.content.Intent;

/* renamed from: com.google.android.gms.games.internal.v2.resolution.zzc */
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzc {
    public final boolean zza;
    public final Intent zzb;

    public zzc(boolean z, Intent intent) {
        this.zza = z;
        this.zzb = intent;
    }

    public static zzc zzb(Intent intent) {
        return new zzc(false, intent);
    }

    public static zzc zzc(Intent intent) {
        return new zzc(true, intent);
    }

    public final Intent zza() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zza;
    }
}
