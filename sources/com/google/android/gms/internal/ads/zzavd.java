package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzavd implements Parcelable {
    public static final Parcelable.Creator<zzavd> CREATOR = new zzavc();
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final byte[] zzd;
    public int zze;

    public zzavd(int i, int i2, int i3, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = bArr;
    }

    public zzavd(Parcel parcel) {
        this.zza = parcel.readInt();
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzavd.class == obj.getClass()) {
            zzavd zzavd = (zzavd) obj;
            return this.zza == zzavd.zza && this.zzb == zzavd.zzb && this.zzc == zzavd.zzc && Arrays.equals(this.zzd, zzavd.zzd);
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
        parcel.writeInt(this.zzd != null ? 1 : 0);
        byte[] bArr = this.zzd;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
