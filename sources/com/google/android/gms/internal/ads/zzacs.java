package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzacs implements zzabd {
    public static final Parcelable.Creator<zzacs> CREATOR = new zzacr();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public /* synthetic */ zzacs(Parcel parcel, zzacr zzacr) {
        String readString = parcel.readString();
        int i = zzalh.zza;
        this.zza = readString;
        this.zzb = (byte[]) zzalh.zzd(parcel.createByteArray());
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
    }

    public zzacs(String str, byte[] bArr, int i, int i2) {
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzacs.class == obj.getClass()) {
            zzacs zzacs = (zzacs) obj;
            return this.zza.equals(zzacs.zza) && Arrays.equals(this.zzb, zzacs.zzb) && this.zzc == zzacs.zzc && this.zzd == zzacs.zzd;
        }
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.zzb) + GeneratedOutlineSupport.outline4(this.zza, 527, 31)) * 31) + this.zzc) * 31) + this.zzd;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return valueOf.length() != 0 ? "mdta: key=".concat(valueOf) : new String("mdta: key=");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    public final void zza(zzkt zzkt) {
    }
}
