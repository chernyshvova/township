package com.google.android.gms.internal.ads;

import android.os.IBinder;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeim implements zzdcm {
    public boolean zza = false;
    public final /* synthetic */ zzedq zzb;
    public final /* synthetic */ zzchj zzc;
    public final /* synthetic */ zzein zzd;

    public zzeim(zzein zzein, zzedq zzedq, zzchj zzchj) {
        this.zzd = zzein;
        this.zzb = zzedq;
        this.zzc = zzchj;
    }

    private final void zze(zzbdd zzbdd) {
        int i = 1;
        if (true == ((Boolean) zzbex.zzc().zzb(zzbjn.zzdL)).booleanValue()) {
            i = 3;
        }
        this.zzc.zzd(new zzedr(i, zzbdd));
    }

    public final synchronized void zza() {
        this.zzc.zzc(null);
    }

    public final void zzb(int i) {
        if (!this.zza) {
            zze(new zzbdd(i, zzein.zze(this.zzb.zza, i), "undefined", (zzbdd) null, (IBinder) null));
        }
    }

    public final synchronized void zzc(int i, @Nullable String str) {
        if (!this.zza) {
            this.zza = true;
            if (str == null) {
                str = zzein.zze(this.zzb.zza, i);
            }
            zze(new zzbdd(i, str, "undefined", (zzbdd) null, (IBinder) null));
        }
    }

    public final synchronized void zzd(zzbdd zzbdd) {
        this.zza = true;
        zze(zzbdd);
    }
}
