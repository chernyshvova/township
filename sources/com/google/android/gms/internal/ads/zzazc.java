package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzazc {
    public final /* synthetic */ zzazd zza;
    public final byte[] zzb;
    public int zzc;

    public /* synthetic */ zzazc(zzazd zzazd, byte[] bArr, zzazb zzazb) {
        this.zza = zzazd;
        this.zzb = bArr;
    }

    public final synchronized void zza() {
        try {
            zzazd zzazd = this.zza;
            if (zzazd.zzb) {
                zzazd.zza.zzh(this.zzb);
                this.zza.zza.zzi(0);
                this.zza.zza.zzj(this.zzc);
                this.zza.zza.zzg((int[]) null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e) {
            zzcgs.zze("Clearcut log failed", e);
        }
    }

    public final zzazc zzb(int i) {
        this.zzc = i;
        return this;
    }
}
