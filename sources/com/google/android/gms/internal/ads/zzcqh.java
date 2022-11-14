package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcqh implements zzeut {
    public final /* synthetic */ zzcra zza;
    public Context zzb;
    public String zzc;
    public zzbdp zzd;

    public /* synthetic */ zzcqh(zzcra zzcra, zzcpp zzcpp) {
        this.zza = zzcra;
    }

    public final zzeuu zza() {
        zzgjp.zzc(this.zzb, Context.class);
        zzgjp.zzc(this.zzc, String.class);
        zzgjp.zzc(this.zzd, zzbdp.class);
        return new zzcqi(this.zza, this.zzb, this.zzc, this.zzd, (zzcpp) null);
    }

    public final /* bridge */ /* synthetic */ zzeut zzb(zzbdp zzbdp) {
        if (zzbdp != null) {
            this.zzd = zzbdp;
            return this;
        }
        throw null;
    }

    public final /* bridge */ /* synthetic */ zzeut zzc(String str) {
        if (str != null) {
            this.zzc = str;
            return this;
        }
        throw null;
    }

    public final /* bridge */ /* synthetic */ zzeut zzd(Context context) {
        if (context != null) {
            this.zzb = context;
            return this;
        }
        throw null;
    }
}
