package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefs implements zzdkb {
    public final zzeye zza;
    public final zzbxo zzb;
    public final boolean zzc;
    @Nullable
    public zzdbv zzd = null;

    public zzefs(zzeye zzeye, zzbxo zzbxo, boolean z) {
        this.zza = zzeye;
        this.zzb = zzbxo;
        this.zzc = z;
    }

    public final void zza(boolean z, Context context, zzdbq zzdbq) throws zzdka {
        boolean z2;
        try {
            if (this.zzc) {
                z2 = this.zzb.zzm(ObjectWrapper.wrap(context));
            } else {
                z2 = this.zzb.zzk(ObjectWrapper.wrap(context));
            }
            if (!z2) {
                throw new zzdka("Adapter failed to show.");
            } else if (this.zzd != null) {
                if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzba)).booleanValue() && this.zza.zzT == 2) {
                    this.zzd.zza();
                }
            }
        } catch (Throwable th) {
            throw new zzdka(th);
        }
    }

    public final void zzb(zzdbv zzdbv) {
        this.zzd = zzdbv;
    }
}
