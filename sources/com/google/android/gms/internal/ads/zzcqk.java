package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcqk implements zzdwc {
    public final /* synthetic */ zzcra zza;
    public Context zzb;
    public zzbqn zzc;

    public /* synthetic */ zzcqk(zzcra zzcra, zzcpp zzcpp) {
        this.zza = zzcra;
    }

    public final zzdwd zza() {
        zzgjp.zzc(this.zzb, Context.class);
        zzgjp.zzc(this.zzc, zzbqn.class);
        return new zzcqn(this.zza, this.zzb, this.zzc, (zzcpp) null);
    }

    public final /* bridge */ /* synthetic */ zzdwc zzb(zzbqn zzbqn) {
        if (zzbqn != null) {
            this.zzc = zzbqn;
            return this;
        }
        throw null;
    }

    public final /* bridge */ /* synthetic */ zzdwc zzc(Context context) {
        if (context != null) {
            this.zzb = context;
            return this;
        }
        throw null;
    }
}
