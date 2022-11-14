package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzacw implements zzabd {
    public static final Parcelable.Creator<zzacw> CREATOR = new zzacv();
    public final float zza;
    public final int zzb;

    public zzacw(float f, int i) {
        this.zza = f;
        this.zzb = i;
    }

    public /* synthetic */ zzacw(Parcel parcel, zzacv zzacv) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzacw.class == obj.getClass()) {
            zzacw zzacw = (zzacw) obj;
            return this.zza == zzacw.zza && this.zzb == zzacw.zzb;
        }
    }

    public final int hashCode() {
        return ((Float.valueOf(this.zza).hashCode() + 527) * 31) + this.zzb;
    }

    public final String toString() {
        float f = this.zza;
        int i = this.zzb;
        StringBuilder sb = new StringBuilder(73);
        sb.append("smta: captureFrameRate=");
        sb.append(f);
        sb.append(", svcTemporalLayerCount=");
        sb.append(i);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.zza);
        parcel.writeInt(this.zzb);
    }

    public final void zza(zzkt zzkt) {
    }
}
