package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzacb extends zzacg {
    public static final Parcelable.Creator<zzacb> CREATOR = new zzaca();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;

    public zzacb(Parcel parcel) {
        super("GEOB");
        String readString = parcel.readString();
        int i = zzalh.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = (byte[]) zzalh.zzd(parcel.createByteArray());
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzacb.class == obj.getClass()) {
            zzacb zzacb = (zzacb) obj;
            return zzalh.zzc(this.zza, zzacb.zza) && zzalh.zzc(this.zzb, zzacb.zzb) && zzalh.zzc(this.zzc, zzacb.zzc) && Arrays.equals(this.zzd, zzacb.zzd);
        }
    }

    public final int hashCode() {
        String str = this.zza;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.zzb;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zzc;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return Arrays.hashCode(this.zzd) + ((hashCode2 + i) * 31);
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        String str4 = this.zzc;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 36 + length2 + String.valueOf(str3).length() + String.valueOf(str4).length());
        GeneratedOutlineSupport.outline34(sb, str, ": mimeType=", str2, ", filename=");
        return GeneratedOutlineSupport.outline19(sb, str3, ", description=", str4);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzacb(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bArr;
    }
}
