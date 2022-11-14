package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbd;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbts extends zzchq<zzbso> {
    public final Object zza = new Object();
    public final zzbd<zzbso> zzb;
    public boolean zzc;
    public int zzd;

    public zzbts(zzbd<zzbso> zzbd) {
        this.zzb = zzbd;
        this.zzc = false;
        this.zzd = 0;
    }

    public final zzbtn zza() {
        zzbtn zzbtn = new zzbtn(this);
        synchronized (this.zza) {
            zze(new zzbto(this, zzbtn), new zzbtp(this, zzbtn));
            Preconditions.checkState(this.zzd >= 0);
            this.zzd++;
        }
        return zzbtn;
    }

    public final void zzb() {
        synchronized (this.zza) {
            Preconditions.checkState(this.zzd > 0);
            zze.zza("Releasing 1 reference for JS Engine");
            this.zzd--;
            zzd();
        }
    }

    public final void zzc() {
        synchronized (this.zza) {
            Preconditions.checkState(this.zzd >= 0);
            zze.zza("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzc = true;
            zzd();
        }
    }

    public final void zzd() {
        synchronized (this.zza) {
            Preconditions.checkState(this.zzd >= 0);
            if (!this.zzc || this.zzd != 0) {
                zze.zza("There are still references to the engine. Not destroying.");
            } else {
                zze.zza("No reference is left (including root). Cleaning up engine.");
                zze(new zzbtr(this), new zzchm());
            }
        }
    }
}
