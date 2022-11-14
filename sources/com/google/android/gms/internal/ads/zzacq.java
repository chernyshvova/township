package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzacq extends zzacg {
    public static final Parcelable.Creator<zzacq> CREATOR = new zzacp();
    @Nullable
    public final String zza;
    public final String zzb;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzacq(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = com.google.android.gms.internal.ads.zzalh.zza
            r2.<init>(r0)
            java.lang.String r0 = r3.readString()
            r2.zza = r0
            java.lang.String r3 = r3.readString()
            r2.zzb = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacq.<init>(android.os.Parcel):void");
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzacq.class == obj.getClass()) {
            zzacq zzacq = (zzacq) obj;
            return this.zzf.equals(zzacq.zzf) && zzalh.zzc(this.zza, zzacq.zza) && zzalh.zzc(this.zzb, zzacq.zzb);
        }
    }

    public final int hashCode() {
        int outline4 = GeneratedOutlineSupport.outline4(this.zzf, 527, 31);
        String str = this.zza;
        int i = 0;
        int hashCode = (outline4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zzb;
        return GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(str).length() + 6 + String.valueOf(str2).length()), str, ": url=", str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    public zzacq(String str, @Nullable String str2, String str3) {
        super(str);
        this.zza = str2;
        this.zzb = str3;
    }
}
