package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaft implements Parcelable {
    public static final Parcelable.Creator<zzaft> CREATOR = new zzafs();
    public static final zzaft zza = new zzaft(new zzafr[0]);
    public final int zzb;
    public final zzafr[] zzc;
    public int zzd;

    public zzaft(Parcel parcel) {
        int readInt = parcel.readInt();
        this.zzb = readInt;
        this.zzc = new zzafr[readInt];
        for (int i = 0; i < this.zzb; i++) {
            this.zzc[i] = (zzafr) parcel.readParcelable(zzafr.class.getClassLoader());
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaft.class == obj.getClass()) {
            zzaft zzaft = (zzaft) obj;
            return this.zzb == zzaft.zzb && Arrays.equals(this.zzc, zzaft.zzc);
        }
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzc);
        this.zzd = hashCode;
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzb);
        for (int i2 = 0; i2 < this.zzb; i2++) {
            parcel.writeParcelable(this.zzc[i2], 0);
        }
    }

    public final zzafr zza(int i) {
        return this.zzc[i];
    }

    public final int zzb(zzafr zzafr) {
        for (int i = 0; i < this.zzb; i++) {
            if (this.zzc[i] == zzafr) {
                return i;
            }
        }
        return -1;
    }

    public zzaft(zzafr... zzafrArr) {
        this.zzc = zzafrArr;
        this.zzb = zzafrArr.length;
    }
}
