package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzapg implements Parcelable {
    public static final Parcelable.Creator<zzapg> CREATOR = new zzapf();
    public final String zza;
    public final byte[] zzb;
    public final boolean zzc;
    public int zzd;
    public final UUID zze;

    public zzapg(Parcel parcel) {
        this.zze = new UUID(parcel.readLong(), parcel.readLong());
        this.zza = parcel.readString();
        this.zzb = parcel.createByteArray();
        this.zzc = parcel.readByte() != 0;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzapg)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzapg zzapg = (zzapg) obj;
        return this.zza.equals(zzapg.zza) && zzava.zza(this.zze, zzapg.zze) && Arrays.equals(this.zzb, zzapg.zzb);
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int outline4 = GeneratedOutlineSupport.outline4(this.zza, this.zze.hashCode() * 31, 31) + Arrays.hashCode(this.zzb);
        this.zzd = outline4;
        return outline4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zze.getMostSignificantBits());
        parcel.writeLong(this.zze.getLeastSignificantBits());
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeByte(this.zzc ? (byte) 1 : 0);
    }

    public zzapg(UUID uuid, String str, byte[] bArr, boolean z) {
        if (uuid != null) {
            this.zze = uuid;
            this.zza = str;
            if (bArr != null) {
                this.zzb = bArr;
                this.zzc = false;
                return;
            }
            throw null;
        }
        throw null;
    }
}
