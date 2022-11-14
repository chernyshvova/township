package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdnv implements zzdbx {
    public final zzdma zza;
    public final zzdmf zzb;

    public zzdnv(zzdma zzdma, zzdmf zzdmf) {
        this.zza = zzdma;
        this.zzb = zzdmf;
    }

    public final void zzbF() {
        if (this.zza.zzU() != null) {
            zzcmr zzT = this.zza.zzT();
            zzcmr zzR = this.zza.zzR();
            if (zzT == null) {
                zzT = zzR != null ? zzR : null;
            }
            if (this.zzb.zzd() && zzT != null) {
                zzT.zze("onSdkImpression", new ArrayMap());
            }
        }
    }
}
