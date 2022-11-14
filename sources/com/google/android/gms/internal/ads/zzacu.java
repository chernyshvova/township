package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzacu implements zzabd {
    public static final Parcelable.Creator<zzacu> CREATOR = new zzact();
    public final long zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;

    public zzacu(long j, long j2, long j3, long j4, long j5) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = j5;
    }

    public /* synthetic */ zzacu(Parcel parcel, zzact zzact) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzacu.class == obj.getClass()) {
            zzacu zzacu = (zzacu) obj;
            return this.zza == zzacu.zza && this.zzb == zzacu.zzb && this.zzc == zzacu.zzc && this.zzd == zzacu.zzd && this.zze == zzacu.zze;
        }
    }

    public final int hashCode() {
        long j = this.zza;
        long j2 = this.zzb;
        long j3 = this.zzc;
        long j4 = this.zzd;
        long j5 = this.zze;
        return ((((((((((int) (j ^ (j >>> 32))) + 527) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31) + ((int) ((j4 >>> 32) ^ j4))) * 31) + ((int) ((j5 >>> 32) ^ j5));
    }

    public final String toString() {
        long j = this.zza;
        long j2 = this.zzb;
        long j3 = this.zzc;
        long j4 = this.zzd;
        long j5 = this.zze;
        StringBuilder sb = new StringBuilder(218);
        sb.append("Motion photo metadata: photoStartPosition=");
        sb.append(j);
        sb.append(", photoSize=");
        sb.append(j2);
        sb.append(", photoPresentationTimestampUs=");
        sb.append(j3);
        sb.append(", videoStartPosition=");
        sb.append(j4);
        sb.append(", videoSize=");
        sb.append(j5);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
    }

    public final void zza(zzkt zzkt) {
    }
}
