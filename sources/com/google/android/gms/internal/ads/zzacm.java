package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzacm extends zzacg {
    public static final Parcelable.Creator<zzacm> CREATOR = new zzacl();
    public final String zza;
    public final byte[] zzb;

    public zzacm(Parcel parcel) {
        super("PRIV");
        String readString = parcel.readString();
        int i = zzalh.zza;
        this.zza = readString;
        this.zzb = (byte[]) zzalh.zzd(parcel.createByteArray());
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzacm.class == obj.getClass()) {
            zzacm zzacm = (zzacm) obj;
            return zzalh.zzc(this.zza, zzacm.zza) && Arrays.equals(this.zzb, zzacm.zzb);
        }
    }

    public final int hashCode() {
        String str = this.zza;
        return Arrays.hashCode(this.zzb) + (((str != null ? str.hashCode() : 0) + 527) * 31);
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        return GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(str).length() + 8 + String.valueOf(str2).length()), str, ": owner=", str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
    }

    public zzacm(String str, byte[] bArr) {
        super("PRIV");
        this.zza = str;
        this.zzb = bArr;
    }
}
