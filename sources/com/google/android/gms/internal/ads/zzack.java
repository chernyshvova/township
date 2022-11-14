package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzack extends zzacg {
    public static final Parcelable.Creator<zzack> CREATOR = new zzacj();
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int[] zzd;
    public final int[] zze;

    public zzack(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = iArr;
        this.zze = iArr2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzack.class == obj.getClass()) {
            zzack zzack = (zzack) obj;
            return this.zza == zzack.zza && this.zzb == zzack.zzb && this.zzc == zzack.zzc && Arrays.equals(this.zzd, zzack.zzd) && Arrays.equals(this.zze, zzack.zze);
        }
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.zzd);
        return Arrays.hashCode(this.zze) + ((hashCode + ((((((this.zza + 527) * 31) + this.zzb) * 31) + this.zzc) * 31)) * 31);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeIntArray(this.zzd);
        parcel.writeIntArray(this.zze);
    }

    public zzack(Parcel parcel) {
        super("MLLT");
        this.zza = parcel.readInt();
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = (int[]) zzalh.zzd(parcel.createIntArray());
        this.zze = (int[]) zzalh.zzd(parcel.createIntArray());
    }
}
