package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzot {
    public final zzms zza;
    public zzfml<zzadv> zzb = zzfml.zzi();
    public zzfmp<zzadv, zzmv> zzc = zzfmp.zza();
    @Nullable
    public zzadv zzd;
    public zzadv zze;
    public zzadv zzf;

    public zzot(zzms zzms) {
        this.zza = zzms;
    }

    private final void zzj(zzmv zzmv) {
        zzfmo zzfmo = new zzfmo();
        if (this.zzb.isEmpty()) {
            zzk(zzfmo, this.zze, zzmv);
            if (!zzfka.zza(this.zzf, this.zze)) {
                zzk(zzfmo, this.zzf, zzmv);
            }
            if (!zzfka.zza(this.zzd, this.zze) && !zzfka.zza(this.zzd, this.zzf)) {
                zzk(zzfmo, this.zzd, zzmv);
            }
        } else {
            for (int i = 0; i < this.zzb.size(); i++) {
                zzk(zzfmo, this.zzb.get(i), zzmv);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzfmo, this.zzd, zzmv);
            }
        }
        this.zzc = zzfmo.zzc();
    }

    private final void zzk(zzfmo<zzadv, zzmv> zzfmo, @Nullable zzadv zzadv, zzmv zzmv) {
        if (zzadv != null) {
            if (zzmv.zzh(zzadv.zza) != -1) {
                zzfmo.zza(zzadv, zzmv);
                return;
            }
            zzmv zzmv2 = this.zzc.get(zzadv);
            if (zzmv2 != null) {
                zzfmo.zza(zzadv, zzmv2);
            }
        }
    }

    @Nullable
    public static zzadv zzl(zzlu zzlu, zzfml<zzadv> zzfml, @Nullable zzadv zzadv, zzms zzms) {
        zzmv zzC = zzlu.zzC();
        int zzs = zzlu.zzs();
        Object zzi = zzC.zzt() ? null : zzC.zzi(zzs);
        int zzf2 = (zzlu.zzy() || zzC.zzt()) ? -1 : zzC.zzg(zzs, zzms, false).zzf(zzig.zzb(zzlu.zzv()));
        for (int i = 0; i < zzfml.size(); i++) {
            zzadv zzadv2 = zzfml.get(i);
            boolean zzy = zzlu.zzy();
            int zzz = zzlu.zzz();
            zzlu.zzA();
            if (zzm(zzadv2, zzi, zzy, zzz, -1, zzf2)) {
                return zzadv2;
            }
        }
        if (zzfml.isEmpty() && zzadv != null) {
            boolean zzy2 = zzlu.zzy();
            int zzz2 = zzlu.zzz();
            zzlu.zzA();
            if (zzm(zzadv, zzi, zzy2, zzz2, -1, zzf2)) {
                return zzadv;
            }
        }
        return null;
    }

    public static boolean zzm(zzadv zzadv, @Nullable Object obj, boolean z, int i, int i2, int i3) {
        if (!zzadv.zza.equals(obj)) {
            return false;
        }
        if (z) {
            return zzadv.zzb == i;
        }
        if (zzadv.zzb == -1 && zzadv.zze == i3) {
            return true;
        }
        return false;
    }

    @Nullable
    public final zzadv zza() {
        return this.zzd;
    }

    @Nullable
    public final zzadv zzb() {
        return this.zze;
    }

    @Nullable
    public final zzadv zzc() {
        return this.zzf;
    }

    @Nullable
    public final zzadv zzd() {
        T t;
        T next;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzfml<zzadv> zzfml = this.zzb;
        if (!(zzfml instanceof List)) {
            Iterator<T> it = zzfml.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            t = next;
        } else if (!zzfml.isEmpty()) {
            t = zzfml.get(zzfml.size() - 1);
        } else {
            throw new NoSuchElementException();
        }
        return (zzadv) t;
    }

    @Nullable
    public final zzmv zze(zzadv zzadv) {
        return this.zzc.get(zzadv);
    }

    public final void zzf(zzlu zzlu) {
        this.zzd = zzl(zzlu, this.zzb, this.zze, this.zza);
    }

    public final void zzg(zzlu zzlu) {
        this.zzd = zzl(zzlu, this.zzb, this.zze, this.zza);
        zzj(zzlu.zzC());
    }

    public final void zzh(List<zzadv> list, @Nullable zzadv zzadv, zzlu zzlu) {
        this.zzb = zzfml.zzp(list);
        if (!list.isEmpty()) {
            this.zze = list.get(0);
            if (zzadv != null) {
                this.zzf = zzadv;
            } else {
                throw null;
            }
        }
        if (this.zzd == null) {
            this.zzd = zzl(zzlu, this.zzb, this.zze, this.zza);
        }
        zzj(zzlu.zzC());
    }
}
