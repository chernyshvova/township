package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "VersionInfoParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcgy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcgy> CREATOR = new zzcgz();
    @SafeParcelable.Field(mo17147id = 2)
    public String zza;
    @SafeParcelable.Field(mo17147id = 3)
    public int zzb;
    @SafeParcelable.Field(mo17147id = 4)
    public int zzc;
    @SafeParcelable.Field(mo17147id = 5)
    public boolean zzd;
    @SafeParcelable.Field(mo17147id = 6)
    public boolean zze;

    public zzcgy(int i, int i2, boolean z, boolean z2) {
        this(212104000, i2, true, false, false);
    }

    public static zzcgy zza() {
        return new zzcgy((int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, (int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, true, false, false);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcgy(int r8, int r9, boolean r10, boolean r11, boolean r12) {
        /*
            r7 = this;
            if (r10 == 0) goto L_0x0005
            java.lang.String r11 = "0"
            goto L_0x0007
        L_0x0005:
            java.lang.String r11 = "1"
        L_0x0007:
            int r12 = r11.length()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r12 = r12 + 36
            r0.<init>(r12)
            java.lang.String r12 = "afma-sdk-a-v"
            r0.append(r12)
            r0.append(r8)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r9)
            java.lang.String r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline18(r0, r12, r11)
            r6 = 0
            r1 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r1.<init>((java.lang.String) r2, (int) r3, (int) r4, (boolean) r5, (boolean) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgy.<init>(int, int, boolean, boolean, boolean):void");
    }

    @SafeParcelable.Constructor
    public zzcgy(@SafeParcelable.Param(mo17150id = 2) String str, @SafeParcelable.Param(mo17150id = 3) int i, @SafeParcelable.Param(mo17150id = 4) int i2, @SafeParcelable.Param(mo17150id = 5) boolean z, @SafeParcelable.Param(mo17150id = 6) boolean z2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = z;
        this.zze = z2;
    }
}
