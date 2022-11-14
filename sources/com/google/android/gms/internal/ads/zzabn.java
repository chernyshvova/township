package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzabn implements zzabd {
    public static final Parcelable.Creator<zzabn> CREATOR = new zzabm();
    public final String zza;
    public final String zzb;

    public zzabn(Parcel parcel) {
        String readString = parcel.readString();
        int i = zzalh.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
    }

    public zzabn(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzabn.class == obj.getClass()) {
            zzabn zzabn = (zzabn) obj;
            return this.zza.equals(zzabn.zza) && this.zzb.equals(zzabn.zzb);
        }
    }

    public final int hashCode() {
        return this.zzb.hashCode() + GeneratedOutlineSupport.outline4(this.zza, 527, 31);
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return GeneratedOutlineSupport.outline20(new StringBuilder(String.valueOf(str).length() + 5 + String.valueOf(str2).length()), "VC: ", str, "=", str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    public final void zza(zzkt zzkt) {
    }
}
