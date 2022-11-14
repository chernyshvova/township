package com.google.android.gms.internal.games_v2;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzc {
    public static final ClassLoader zza = zzc.class.getClassLoader();

    public static <T extends Parcelable> T zza(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void zzb(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static void zzc(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    public static void zzd(Parcel parcel, Parcelable parcelable) {
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 1);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.os.IInterface, android.os.IBinder] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zze(android.os.Parcel r0, android.os.IInterface r1) {
        /*
            if (r1 != 0) goto L_0x0007
            r1 = 0
            r0.writeStrongBinder(r1)
            return
        L_0x0007:
            r0.writeStrongBinder(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.games_v2.zzc.zze(android.os.Parcel, android.os.IInterface):void");
    }

    public static boolean zzf(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
