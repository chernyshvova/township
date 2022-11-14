package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcqb implements zzeti {
    public final /* synthetic */ zzcra zza;
    public Context zzb;
    public String zzc;

    public /* synthetic */ zzcqb(zzcra zzcra, zzcpp zzcpp) {
        this.zza = zzcra;
    }

    public final zzetj zza() {
        zzgjp.zzc(this.zzb, Context.class);
        zzgjp.zzc(this.zzc, String.class);
        return new zzcqc(this.zza, this.zzb, this.zzc, (zzcpp) null);
    }

    public final /* bridge */ /* synthetic */ zzeti zzb(String str) {
        if (str != null) {
            this.zzc = str;
            return this;
        }
        throw null;
    }

    public final /* bridge */ /* synthetic */ zzeti zzc(Context context) {
        if (context != null) {
            this.zzb = context;
            return this;
        }
        throw null;
    }
}
