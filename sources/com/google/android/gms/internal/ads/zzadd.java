package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzadd implements zzaef, zzse {
    public final /* synthetic */ zzadf zza;
    public final Object zzb;
    public zzaee zzc;
    public zzsd zzd;

    public zzadd(zzadf zzadf, Object obj) {
        this.zza = zzadf;
        this.zzc = zzadf.zzf((zzadv) null);
        this.zzd = zzadf.zzh((zzadv) null);
        this.zzb = obj;
    }

    private final boolean zzf(int i, @Nullable zzadv zzadv) {
        zzadv zzadv2;
        if (zzadv != null) {
            zzadv2 = this.zza.zzx(this.zzb, zzadv);
            if (zzadv2 == null) {
                return false;
            }
        } else {
            zzadv2 = null;
        }
        zzaee zzaee = this.zzc;
        if (zzaee.zza != i || !zzalh.zzc(zzaee.zzb, zzadv2)) {
            this.zzc = this.zza.zzg(i, zzadv2, 0);
        }
        zzsd zzsd = this.zzd;
        if (zzsd.zza == i && zzalh.zzc(zzsd.zzb, zzadv2)) {
            return true;
        }
        this.zzd = this.zza.zzi(i, zzadv2);
        return true;
    }

    public final void zza(int i, @Nullable zzadv zzadv, zzadm zzadm, zzadr zzadr) {
        if (zzf(i, zzadv)) {
            this.zzc.zze(zzadm, zzadr);
        }
    }

    public final void zzb(int i, @Nullable zzadv zzadv, zzadm zzadm, zzadr zzadr) {
        if (zzf(i, zzadv)) {
            this.zzc.zzg(zzadm, zzadr);
        }
    }

    public final void zzbf(int i, @Nullable zzadv zzadv, zzadm zzadm, zzadr zzadr) {
        if (zzf(i, zzadv)) {
            this.zzc.zzi(zzadm, zzadr);
        }
    }

    public final void zzbg(int i, @Nullable zzadv zzadv, zzadm zzadm, zzadr zzadr, IOException iOException, boolean z) {
        if (zzf(i, zzadv)) {
            this.zzc.zzk(zzadm, zzadr, iOException, z);
        }
    }

    public final void zzbh(int i, @Nullable zzadv zzadv, zzadr zzadr) {
        if (zzf(i, zzadv)) {
            this.zzc.zzm(zzadr);
        }
    }
}
