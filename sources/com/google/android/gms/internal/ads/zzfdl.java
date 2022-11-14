package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfdl {
    @NonNull
    public final String zza;
    @NonNull
    public final String zzb;

    public zzfdl(@NonNull String str, @NonNull String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfdl)) {
            return false;
        }
        zzfdl zzfdl = (zzfdl) obj;
        return this.zza.equals(zzfdl.zza) && this.zzb.equals(zzfdl.zzb);
    }

    public final int hashCode() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        return (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).hashCode();
    }
}
