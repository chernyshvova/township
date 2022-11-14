package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzabx extends zzacg {
    public static final Parcelable.Creator<zzabx> CREATOR = new zzabw();
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    public final zzacg[] zze;

    public zzabx(Parcel parcel) {
        super("CTOC");
        String readString = parcel.readString();
        int i = zzalh.zza;
        this.zza = readString;
        boolean z = true;
        this.zzb = parcel.readByte() != 0;
        this.zzc = parcel.readByte() == 0 ? false : z;
        this.zzd = (String[]) zzalh.zzd(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.zze = new zzacg[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.zze[i2] = (zzacg) parcel.readParcelable(zzacg.class.getClassLoader());
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzabx.class == obj.getClass()) {
            zzabx zzabx = (zzabx) obj;
            return this.zzb == zzabx.zzb && this.zzc == zzabx.zzc && zzalh.zzc(this.zza, zzabx.zza) && Arrays.equals(this.zzd, zzabx.zzd) && Arrays.equals(this.zze, zzabx.zze);
        }
    }

    public final int hashCode() {
        int i = ((((this.zzb ? 1 : 0) + true) * 31) + (this.zzc ? 1 : 0)) * 31;
        String str = this.zza;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByte(this.zzb ? (byte) 1 : 0);
        parcel.writeByte(this.zzc ? (byte) 1 : 0);
        parcel.writeStringArray(this.zzd);
        parcel.writeInt(this.zze.length);
        for (zzacg writeParcelable : this.zze) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public zzabx(String str, boolean z, boolean z2, String[] strArr, zzacg[] zzacgArr) {
        super("CTOC");
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = strArr;
        this.zze = zzacgArr;
    }
}
