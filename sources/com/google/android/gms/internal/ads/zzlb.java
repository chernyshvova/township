package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzlb implements zzaef, zzse {
    public final /* synthetic */ zzlf zza;
    public final zzld zzb;
    public zzaee zzc;
    public zzsd zzd;

    public zzlb(zzlf zzlf, zzld zzld) {
        this.zza = zzlf;
        this.zzc = zzlf.zze;
        this.zzd = zzlf.zzf;
        this.zzb = zzld;
    }

    private final boolean zzf(int i, @Nullable zzadv zzadv) {
        zzadv zzadv2 = null;
        if (zzadv != null) {
            zzld zzld = this.zzb;
            int i2 = 0;
            while (true) {
                if (i2 >= zzld.zzc.size()) {
                    break;
                } else if (zzld.zzc.get(i2).zzd == zzadv.zzd) {
                    zzadv2 = zzadv.zzc(Pair.create(zzld.zzb, zzadv.zza));
                    break;
                } else {
                    i2++;
                }
            }
            if (zzadv2 == null) {
                return false;
            }
        }
        int i3 = i + this.zzb.zzd;
        zzaee zzaee = this.zzc;
        if (zzaee.zza != i3 || !zzalh.zzc(zzaee.zzb, zzadv2)) {
            this.zzc = this.zza.zze.zza(i3, zzadv2, 0);
        }
        zzsd zzsd = this.zzd;
        if (zzsd.zza == i3 && zzalh.zzc(zzsd.zzb, zzadv2)) {
            return true;
        }
        this.zzd = this.zza.zzf.zza(i3, zzadv2);
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
