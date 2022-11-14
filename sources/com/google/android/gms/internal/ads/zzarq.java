package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzarq implements Parcelable {
    public static final Parcelable.Creator<zzarq> CREATOR = new zzaro();
    public final zzarp[] zza;

    public zzarq(Parcel parcel) {
        this.zza = new zzarp[parcel.readInt()];
        int i = 0;
        while (true) {
            zzarp[] zzarpArr = this.zza;
            if (i < zzarpArr.length) {
                zzarpArr[i] = (zzarp) parcel.readParcelable(zzarp.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzarq.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzarq) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza.length);
        for (zzarp writeParcelable : this.zza) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public final int zza() {
        return this.zza.length;
    }

    public final zzarp zzb(int i) {
        return this.zza[i];
    }

    public zzarq(List<? extends zzarp> list) {
        zzarp[] zzarpArr = new zzarp[list.size()];
        this.zza = zzarpArr;
        list.toArray(zzarpArr);
    }
}
