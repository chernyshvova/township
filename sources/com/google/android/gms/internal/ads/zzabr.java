package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzabr extends zzacg {
    public static final Parcelable.Creator<zzabr> CREATOR = new zzabq();
    public final String zza;
    @Nullable
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    public zzabr(Parcel parcel) {
        super("APIC");
        String readString = parcel.readString();
        int i = zzalh.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readInt();
        this.zzd = (byte[]) zzalh.zzd(parcel.createByteArray());
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzabr.class == obj.getClass()) {
            zzabr zzabr = (zzabr) obj;
            return this.zzc == zzabr.zzc && zzalh.zzc(this.zza, zzabr.zza) && zzalh.zzc(this.zzb, zzabr.zzb) && Arrays.equals(this.zzd, zzabr.zzd);
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

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(str).length(), 25, String.valueOf(str2).length(), String.valueOf(str3).length()));
        GeneratedOutlineSupport.outline34(sb, str, ": mimeType=", str2, ", description=");
        sb.append(str3);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public final void zza(zzkt zzkt) {
        zzkt.zze(this.zzd);
    }

    public zzabr(String str, @Nullable String str2, int i, byte[] bArr) {
        super("APIC");
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = bArr;
    }
}
