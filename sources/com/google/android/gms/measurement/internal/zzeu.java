package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzeu {
    @NonNull
    public String zza;
    @NonNull
    public Bundle zzb;
    @NonNull
    public String zzc;
    public long zzd;

    public zzeu(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j) {
        this.zza = str;
        this.zzc = str2;
        this.zzb = bundle == null ? new Bundle() : bundle;
        this.zzd = j;
    }

    public static zzeu zza(zzaq zzaq) {
        return new zzeu(zzaq.zza, zzaq.zzc, zzaq.zzb.zzb(), zzaq.zzd);
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        return GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline23(valueOf.length() + GeneratedOutlineSupport.outline3(str2, GeneratedOutlineSupport.outline3(str, 21)), "origin=", str, ",name=", str2), ",params=", valueOf);
    }

    public final zzaq zza() {
        return new zzaq(this.zza, new zzap(new Bundle(this.zzb)), this.zzc, this.zzd);
    }
}
