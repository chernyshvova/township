package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcbx extends zzcbz {
    public final String zza;
    public final int zzb;

    public zzcbx(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzcbx)) {
            zzcbx zzcbx = (zzcbx) obj;
            if (!Objects.equal(this.zza, zzcbx.zza) || !Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzcbx.zzb))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final String zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }
}
