package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaci extends zzacg {
    public static final Parcelable.Creator<zzaci> CREATOR = new zzach();
    public final String zza;
    public final String zzb;
    public final String zzc;

    public zzaci(Parcel parcel) {
        super("----");
        String readString = parcel.readString();
        int i = zzalh.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaci.class == obj.getClass()) {
            zzaci zzaci = (zzaci) obj;
            return zzalh.zzc(this.zzb, zzaci.zzb) && zzalh.zzc(this.zza, zzaci.zza) && zzalh.zzc(this.zzc, zzaci.zzc);
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
        return hashCode2 + i;
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(str).length(), 23, String.valueOf(str2).length(), String.valueOf(str3).length()));
        GeneratedOutlineSupport.outline34(sb, str, ": domain=", str2, ", description=");
        sb.append(str3);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzc);
    }

    public zzaci(String str, String str2, String str3) {
        super("----");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }
}
