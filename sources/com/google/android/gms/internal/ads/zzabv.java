package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzabv extends zzacg {
    public static final Parcelable.Creator<zzabv> CREATOR = new zzabu();
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    public final zzacg[] zzg;

    public zzabv(Parcel parcel) {
        super("CHAP");
        String readString = parcel.readString();
        int i = zzalh.zza;
        this.zza = readString;
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzg = new zzacg[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.zzg[i2] = (zzacg) parcel.readParcelable(zzacg.class.getClassLoader());
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzabv.class == obj.getClass()) {
            zzabv zzabv = (zzabv) obj;
            return this.zzb == zzabv.zzb && this.zzc == zzabv.zzc && this.zzd == zzabv.zzd && this.zze == zzabv.zze && zzalh.zzc(this.zza, zzabv.zza) && Arrays.equals(this.zzg, zzabv.zzg);
        }
    }

    public final int hashCode() {
        int i = (((((((this.zzb + 527) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + ((int) this.zze)) * 31;
        String str = this.zza;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
        parcel.writeInt(this.zzg.length);
        for (zzacg writeParcelable : this.zzg) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public zzabv(String str, int i, int i2, long j, long j2, zzacg[] zzacgArr) {
        super("CHAP");
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = j2;
        this.zzg = zzacgArr;
    }
}
