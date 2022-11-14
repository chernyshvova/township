package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfis {
    public final /* synthetic */ zzfit zza;
    public final byte[] zzb;
    public int zzc;
    public int zzd;

    public /* synthetic */ zzfis(zzfit zzfit, byte[] bArr, zzfir zzfir) {
        this.zza = zzfit;
        this.zzb = bArr;
    }

    public final synchronized void zza() {
        try {
            zzfit zzfit = this.zza;
            if (zzfit.zza) {
                zzfit.zzb.zzg(this.zzb);
                this.zza.zzb.zzh(this.zzc);
                this.zza.zzb.zzi(this.zzd);
                this.zza.zzb.zzf((int[]) null);
                this.zza.zzb.zze();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }

    public final zzfis zzb(int i) {
        this.zzc = i;
        return this;
    }

    public final zzfis zzc(int i) {
        this.zzd = i;
        return this;
    }
}
