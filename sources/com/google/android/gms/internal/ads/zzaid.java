package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaid implements zzahs {
    public final Context zza;
    public final zzahs zzb;

    public zzaid(Context context, @Nullable String str, @Nullable zzajd zzajd) {
        zzaif zzaif = new zzaif();
        zzaif.zzb((String) null);
        this.zza = context.getApplicationContext();
        this.zzb = zzaif;
    }

    public final /* bridge */ /* synthetic */ zzaht zza() {
        return new zzaic(this.zza, ((zzaif) this.zzb).zza());
    }
}
