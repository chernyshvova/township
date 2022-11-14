package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcqt implements zzexx {
    public final /* synthetic */ zzcra zza;
    public Context zzb;
    public String zzc;

    public /* synthetic */ zzcqt(zzcra zzcra, zzcpp zzcpp) {
        this.zza = zzcra;
    }

    public final zzexy zza() {
        zzgjp.zzc(this.zzb, Context.class);
        return new zzcqu(this.zza, this.zzb, this.zzc, (zzcpp) null);
    }

    public final /* bridge */ /* synthetic */ zzexx zzb(String str) {
        this.zzc = str;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzexx zzc(Context context) {
        if (context != null) {
            this.zzb = context;
            return this;
        }
        throw null;
    }
}
