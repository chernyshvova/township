package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfag {
    public final LinkedList<zzfaq<?, ?>> zza = new LinkedList<>();
    public final int zzb;
    public final int zzc;
    public final zzfbf zzd;

    public zzfag(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = new zzfbf();
    }

    private final void zzi() {
        while (!this.zza.isEmpty() && zzs.zzj().currentTimeMillis() - this.zza.getFirst().zzd >= ((long) this.zzc)) {
            this.zzd.zzc();
            this.zza.remove();
        }
    }

    public final boolean zza(zzfaq<?, ?> zzfaq) {
        this.zzd.zza();
        zzi();
        if (this.zza.size() == this.zzb) {
            return false;
        }
        this.zza.add(zzfaq);
        return true;
    }

    public final zzfaq<?, ?> zzb() {
        this.zzd.zza();
        zzi();
        if (this.zza.isEmpty()) {
            return null;
        }
        zzfaq<?, ?> remove = this.zza.remove();
        if (remove != null) {
            this.zzd.zzb();
        }
        return remove;
    }

    public final int zzc() {
        zzi();
        return this.zza.size();
    }

    public final long zzd() {
        return this.zzd.zzd();
    }

    public final long zze() {
        return this.zzd.zze();
    }

    public final int zzf() {
        return this.zzd.zzf();
    }

    public final String zzg() {
        return this.zzd.zzh();
    }

    public final zzfbe zzh() {
        return this.zzd.zzg();
    }
}
