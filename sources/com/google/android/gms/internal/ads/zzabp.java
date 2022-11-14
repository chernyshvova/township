package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzabp implements zzabd {
    public static final Parcelable.Creator<zzabp> CREATOR = new zzabo();
    public final int zza;
    @Nullable
    public final String zzb;
    @Nullable
    public final String zzc;
    @Nullable
    public final String zzd;
    public final boolean zze;
    public final int zzf;

    public zzabp(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, int i2) {
        boolean z2 = true;
        if (i2 != -1 && i2 <= 0) {
            z2 = false;
        }
        zzajg.zza(z2);
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
        this.zzf = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzabp.class == obj.getClass()) {
            zzabp zzabp = (zzabp) obj;
            return this.zza == zzabp.zza && zzalh.zzc(this.zzb, zzabp.zzb) && zzalh.zzc(this.zzc, zzabp.zzc) && zzalh.zzc(this.zzd, zzabp.zzd) && this.zze == zzabp.zze && this.zzf == zzabp.zzf;
        }
    }

    public final int hashCode() {
        int i = (this.zza + 527) * 31;
        String str = this.zzb;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.zzc;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zzd;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((((hashCode2 + i2) * 31) + (this.zze ? 1 : 0)) * 31) + this.zzf;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zzb;
        int i = this.zza;
        int i2 = this.zzf;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 80 + String.valueOf(str2).length());
        GeneratedOutlineSupport.outline34(sb, "IcyHeaders: name=\"", str, "\", genre=\"", str2);
        sb.append("\", bitrate=");
        sb.append(i);
        sb.append(", metadataInterval=");
        sb.append(i2);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeString(this.zzd);
        zzalh.zzo(parcel, this.zze);
        parcel.writeInt(this.zzf);
    }

    public final void zza(zzkt zzkt) {
    }

    public zzabp(Parcel parcel) {
        this.zza = parcel.readInt();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.readString();
        this.zze = zzalh.zzn(parcel);
        this.zzf = parcel.readInt();
    }
}
