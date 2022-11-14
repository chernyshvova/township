package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzall implements Parcelable {
    public static final Parcelable.Creator<zzall> CREATOR = new zzalk();
    public final int zza;
    public final int zzb;
    public final int zzc;
    @Nullable
    public final byte[] zzd;
    public int zze;

    public zzall(int i, int i2, int i3, @Nullable byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = bArr;
    }

    public zzall(Parcel parcel) {
        this.zza = parcel.readInt();
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = zzalh.zzn(parcel) ? parcel.createByteArray() : null;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzall.class == obj.getClass()) {
            zzall zzall = (zzall) obj;
            return this.zza == zzall.zza && this.zzb == zzall.zzb && this.zzc == zzall.zzc && Arrays.equals(this.zzd, zzall.zzd);
        }
    }

    public final int hashCode() {
        int i = this.zze;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzd) + ((((((this.zza + 527) * 31) + this.zzb) * 31) + this.zzc) * 31);
        this.zze = hashCode;
        return hashCode;
    }

    public final String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        int i3 = this.zzc;
        boolean z = this.zzd != null;
        StringBuilder outline22 = GeneratedOutlineSupport.outline22(55, "ColorInfo(", i, RESTClient.COMMA_SEPARATOR, i2);
        outline22.append(RESTClient.COMMA_SEPARATOR);
        outline22.append(i3);
        outline22.append(RESTClient.COMMA_SEPARATOR);
        outline22.append(z);
        outline22.append(")");
        return outline22.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        zzalh.zzo(parcel, this.zzd != null);
        byte[] bArr = this.zzd;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
