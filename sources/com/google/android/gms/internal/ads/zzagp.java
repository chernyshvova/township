package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzagp implements Parcelable {
    public static final Parcelable.Creator<zzagp> CREATOR = new zzago();
    public final int zza;
    public final int[] zzb;
    public final int zzc;

    public zzagp(Parcel parcel) {
        this.zza = parcel.readInt();
        int[] iArr = new int[parcel.readByte()];
        this.zzb = iArr;
        parcel.readIntArray(iArr);
        this.zzc = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagp.class == obj.getClass()) {
            zzagp zzagp = (zzagp) obj;
            return this.zza == zzagp.zza && Arrays.equals(this.zzb, zzagp.zzb) && this.zzc == zzagp.zzc;
        }
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.zzb) + (this.zza * 31)) * 31) + this.zzc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb.length);
        parcel.writeIntArray(this.zzb);
        parcel.writeInt(this.zzc);
    }
}
