package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzabl implements zzabd {
    public static final Parcelable.Creator<zzabl> CREATOR = new zzabk();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzabl(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = bArr;
    }

    public zzabl(Parcel parcel) {
        this.zza = parcel.readInt();
        String readString = parcel.readString();
        int i = zzalh.zza;
        this.zzb = readString;
        this.zzc = parcel.readString();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzh = (byte[]) zzalh.zzd(parcel.createByteArray());
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzabl.class == obj.getClass()) {
            zzabl zzabl = (zzabl) obj;
            return this.zza == zzabl.zza && this.zzb.equals(zzabl.zzb) && this.zzc.equals(zzabl.zzc) && this.zzd == zzabl.zzd && this.zze == zzabl.zze && this.zzf == zzabl.zzf && this.zzg == zzabl.zzg && Arrays.equals(this.zzh, zzabl.zzh);
        }
    }

    public final int hashCode() {
        int outline4 = GeneratedOutlineSupport.outline4(this.zzb, (this.zza + 527) * 31, 31);
        return Arrays.hashCode(this.zzh) + ((((((((GeneratedOutlineSupport.outline4(this.zzc, outline4, 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31);
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zzc;
        return GeneratedOutlineSupport.outline20(new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(str2).length()), "Picture: mimeType=", str, ", description=", str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeByteArray(this.zzh);
    }

    public final void zza(zzkt zzkt) {
    }
}
