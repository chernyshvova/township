package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzabt extends zzacg {
    public static final Parcelable.Creator<zzabt> CREATOR = new zzabs();
    public final byte[] zza;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzabt(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = com.google.android.gms.internal.ads.zzalh.zza
            r2.<init>(r0)
            byte[] r3 = r3.createByteArray()
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzalh.zzd(r3)
            byte[] r3 = (byte[]) r3
            r2.zza = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabt.<init>(android.os.Parcel):void");
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzabt.class == obj.getClass()) {
            zzabt zzabt = (zzabt) obj;
            return this.zzf.equals(zzabt.zzf) && Arrays.equals(this.zza, zzabt.zza);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza) + GeneratedOutlineSupport.outline4(this.zzf, 527, 31);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzf);
        parcel.writeByteArray(this.zza);
    }

    public zzabt(String str, byte[] bArr) {
        super(str);
        this.zza = bArr;
    }
}
