package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzars extends zzarw {
    public static final Parcelable.Creator<zzars> CREATOR = new zzarr();
    public final String zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    public zzars(Parcel parcel) {
        super("APIC");
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
        this.zzc = parcel.readInt();
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzars.class == obj.getClass()) {
            zzars zzars = (zzars) obj;
            return this.zzc == zzars.zzc && zzava.zza(this.zza, zzars.zza) && zzava.zza(this.zzb, zzars.zzb) && Arrays.equals(this.zzd, zzars.zzd);
        }
    }

    public final int hashCode() {
        int i = (this.zzc + 527) * 31;
        String str = this.zza;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return Arrays.hashCode(this.zzd) + ((hashCode + i2) * 31);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzars(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.zza = str;
        this.zzb = null;
        this.zzc = 3;
        this.zzd = bArr;
    }
}
