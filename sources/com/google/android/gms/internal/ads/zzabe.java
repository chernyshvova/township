package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzabe implements Parcelable {
    public static final Parcelable.Creator<zzabe> CREATOR = new zzabc();
    public final zzabd[] zza;

    public zzabe(Parcel parcel) {
        this.zza = new zzabd[parcel.readInt()];
        int i = 0;
        while (true) {
            zzabd[] zzabdArr = this.zza;
            if (i < zzabdArr.length) {
                zzabdArr[i] = (zzabd) parcel.readParcelable(zzabd.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public zzabe(zzabd... zzabdArr) {
        this.zza = zzabdArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzabe.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzabe) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.zza));
        return valueOf.length() != 0 ? "entries=".concat(valueOf) : new String("entries=");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza.length);
        for (zzabd writeParcelable : this.zza) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public final int zza() {
        return this.zza.length;
    }

    public final zzabd zzb(int i) {
        return this.zza[i];
    }

    public final zzabe zzc(@Nullable zzabe zzabe) {
        return zzabe == null ? this : zzd(zzabe.zza);
    }

    public final zzabe zzd(zzabd... zzabdArr) {
        if (zzabdArr.length == 0) {
            return this;
        }
        return new zzabe((zzabd[]) zzalh.zzg(this.zza, zzabdArr));
    }

    public zzabe(List<? extends zzabd> list) {
        this.zza = (zzabd[]) list.toArray(new zzabd[0]);
    }
}
