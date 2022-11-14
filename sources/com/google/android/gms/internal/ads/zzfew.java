package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfew {
    public static final zzfew zza = new zzfew();
    public final ArrayList<zzfel> zzb = new ArrayList<>();
    public final ArrayList<zzfel> zzc = new ArrayList<>();

    public static zzfew zza() {
        return zza;
    }

    public final void zzb(zzfel zzfel) {
        this.zzb.add(zzfel);
    }

    public final void zzc(zzfel zzfel) {
        boolean zzg = zzg();
        this.zzc.add(zzfel);
        if (!zzg) {
            zzffd.zza().zzc();
        }
    }

    public final void zzd(zzfel zzfel) {
        boolean zzg = zzg();
        this.zzb.remove(zzfel);
        this.zzc.remove(zzfel);
        if (zzg && !zzg()) {
            zzffd.zza().zzd();
        }
    }

    public final Collection<zzfel> zze() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final Collection<zzfel> zzf() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
