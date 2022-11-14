package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzari {
    public final String zza;
    public final boolean zzb;

    public zzari(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzari.class) {
            zzari zzari = (zzari) obj;
            return TextUtils.equals(this.zza, zzari.zza) && this.zzb == zzari.zzb;
        }
    }

    public final int hashCode() {
        String str = this.zza;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (true != this.zzb ? 1237 : 1231);
    }
}
