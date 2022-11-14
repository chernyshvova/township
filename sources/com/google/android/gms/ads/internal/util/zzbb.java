package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzezr;
import com.google.android.gms.internal.ads.zzfkm;

@SafeParcelable.Class(creator = "ExceptionParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbb> CREATOR = new zzbc();
    @SafeParcelable.Field(mo17147id = 1)
    public final String zza;
    @SafeParcelable.Field(mo17147id = 2)
    public final int zzb;

    @SafeParcelable.Constructor
    public zzbb(@SafeParcelable.Param(mo17150id = 1) @Nullable String str, @SafeParcelable.Param(mo17150id = 2) int i) {
        this.zza = str == null ? "" : str;
        this.zzb = i;
    }

    @Nullable
    public static zzbb zza(Throwable th) {
        String str;
        zzbdd zza2 = zzezr.zza(th);
        if (zzfkm.zzc(th.getMessage())) {
            str = zza2.zzb;
        } else {
            str = th.getMessage();
        }
        return new zzbb(str, zza2.zza);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
