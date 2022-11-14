package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaar {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzaar(String str, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzaar.class) {
            zzaar zzaar = (zzaar) obj;
            return TextUtils.equals(this.zza, zzaar.zza) && this.zzb == zzaar.zzb && this.zzc == zzaar.zzc;
        }
    }

    public final int hashCode() {
        int i = 1237;
        int outline4 = (GeneratedOutlineSupport.outline4(this.zza, 31, 31) + (true != this.zzb ? 1237 : 1231)) * 31;
        if (true == this.zzc) {
            i = 1231;
        }
        return outline4 + i;
    }
}
