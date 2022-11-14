package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzary extends zzarw {
    public static final Parcelable.Creator<zzary> CREATOR = new zzarx();
    public final String zza;
    public final String zzb;

    public zzary(Parcel parcel) {
        super(parcel.readString());
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzary.class == obj.getClass()) {
            zzary zzary = (zzary) obj;
            return this.zze.equals(zzary.zze) && zzava.zza(this.zza, zzary.zza) && zzava.zza(this.zzb, zzary.zzb);
        }
    }

    public final int hashCode() {
        int outline4 = GeneratedOutlineSupport.outline4(this.zze, 527, 31);
        String str = this.zza;
        int i = 0;
        int hashCode = (outline4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zze);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    public zzary(String str, String str2, String str3) {
        super(str);
        this.zza = null;
        this.zzb = str3;
    }
}
