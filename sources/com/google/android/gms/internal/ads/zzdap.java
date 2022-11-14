package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdap {
    public final Context zza;
    public final zzeyw zzb;
    public final Bundle zzc;
    @Nullable
    public final zzeyr zzd;

    public /* synthetic */ zzdap(zzdao zzdao, zzdan zzdan) {
        this.zza = zzdao.zza;
        this.zzb = zzdao.zzb;
        this.zzc = zzdao.zzc;
        this.zzd = zzdao.zzd;
    }

    public final zzdao zza() {
        zzdao zzdao = new zzdao();
        zzdao.zza(this.zza);
        zzdao.zzb(this.zzb);
        zzdao.zzc(this.zzc);
        return zzdao;
    }

    public final zzeyw zzb() {
        return this.zzb;
    }

    @Nullable
    public final zzeyr zzc() {
        return this.zzd;
    }

    @Nullable
    public final Bundle zzd() {
        return this.zzc;
    }

    public final Context zze(Context context) {
        return this.zza;
    }
}
