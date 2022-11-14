package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzabi implements zzabd {
    public static final Parcelable.Creator<zzabi> CREATOR = new zzabh();
    public static final zzkc zzf;
    public static final zzkc zzg;
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    public int zzh;

    static {
        zzkb zzkb = new zzkb();
        zzkb.zzj("application/id3");
        zzf = zzkb.zzD();
        zzkb zzkb2 = new zzkb();
        zzkb2.zzj("application/x-scte35");
        zzg = zzkb2.zzD();
    }

    public zzabi(Parcel parcel) {
        String readString = parcel.readString();
        int i = zzalh.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = (byte[]) zzalh.zzd(parcel.createByteArray());
    }

    public zzabi(String str, String str2, long j, long j2, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = bArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzabi.class == obj.getClass()) {
            zzabi zzabi = (zzabi) obj;
            return this.zzc == zzabi.zzc && this.zzd == zzabi.zzd && zzalh.zzc(this.zza, zzabi.zza) && zzalh.zzc(this.zzb, zzabi.zzb) && Arrays.equals(this.zze, zzabi.zze);
        }
    }

    public final int hashCode() {
        int i = this.zzh;
        if (i != 0) {
            return i;
        }
        String str = this.zza;
        int i2 = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        long j = this.zzc;
        long j2 = this.zzd;
        int hashCode2 = ((((((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + Arrays.hashCode(this.zze);
        this.zzh = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        String str = this.zza;
        long j = this.zzd;
        long j2 = this.zzc;
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 79 + String.valueOf(str2).length());
        sb.append("EMSG: scheme=");
        sb.append(str);
        sb.append(", id=");
        sb.append(j);
        sb.append(", durationMs=");
        sb.append(j2);
        sb.append(", value=");
        sb.append(str2);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeByteArray(this.zze);
    }

    public final void zza(zzkt zzkt) {
    }
}
