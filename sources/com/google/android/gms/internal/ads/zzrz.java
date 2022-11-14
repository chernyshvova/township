package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzrz implements Parcelable {
    public static final Parcelable.Creator<zzrz> CREATOR = new zzry();
    public final UUID zza;
    @Nullable
    public final String zzb;
    public final String zzc;
    @Nullable
    public final byte[] zzd;
    public int zze;

    public zzrz(Parcel parcel) {
        this.zza = new UUID(parcel.readLong(), parcel.readLong());
        this.zzb = parcel.readString();
        String readString = parcel.readString();
        int i = zzalh.zza;
        this.zzc = readString;
        this.zzd = parcel.createByteArray();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzrz)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzrz zzrz = (zzrz) obj;
        return zzalh.zzc(this.zzb, zzrz.zzb) && zzalh.zzc(this.zzc, zzrz.zzc) && zzalh.zzc(this.zza, zzrz.zza) && Arrays.equals(this.zzd, zzrz.zzd);
    }

    public final int hashCode() {
        int i;
        int i2 = this.zze;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = this.zza.hashCode() * 31;
        String str = this.zzb;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int outline4 = GeneratedOutlineSupport.outline4(this.zzc, (hashCode + i) * 31, 31) + Arrays.hashCode(this.zzd);
        this.zze = outline4;
        return outline4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zza.getMostSignificantBits());
        parcel.writeLong(this.zza.getLeastSignificantBits());
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzrz(UUID uuid, @Nullable String str, String str2, @Nullable byte[] bArr) {
        if (uuid != null) {
            this.zza = uuid;
            this.zzb = null;
            this.zzc = str2;
            this.zzd = bArr;
            return;
        }
        throw null;
    }
}
