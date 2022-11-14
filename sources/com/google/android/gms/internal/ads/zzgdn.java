package com.google.android.gms.internal.ads;

import androidx.core.internal.view.SupportMenu;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgdn {
    public final Object zza;
    public final int zzb;

    public zzgdn(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgdn)) {
            return false;
        }
        zzgdn zzgdn = (zzgdn) obj;
        if (this.zza == zzgdn.zza && this.zzb == zzgdn.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * SupportMenu.USER_MASK) + this.zzb;
    }
}
