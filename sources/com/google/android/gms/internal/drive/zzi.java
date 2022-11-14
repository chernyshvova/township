package com.google.android.gms.internal.drive;

import android.os.Parcelable;

public final class zzi implements Parcelable.Creator<zzh> {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r14) {
        /*
            r13 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r14)
            r1 = 0
            r3 = 0
            r4 = 0
            r9 = r1
            r11 = r9
            r7 = r4
            r6 = 0
            r8 = 0
        L_0x000d:
            int r1 = r14.dataPosition()
            if (r1 >= r0) goto L_0x004c
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r14)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r3 = 2
            if (r2 == r3) goto L_0x0047
            r3 = 3
            if (r2 == r3) goto L_0x003d
            r3 = 4
            if (r2 == r3) goto L_0x0038
            r3 = 5
            if (r2 == r3) goto L_0x0033
            r3 = 6
            if (r2 == r3) goto L_0x002e
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r14, r1)
            goto L_0x000d
        L_0x002e:
            long r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r14, r1)
            goto L_0x000d
        L_0x0033:
            long r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r14, r1)
            goto L_0x000d
        L_0x0038:
            int r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x000d
        L_0x003d:
            android.os.Parcelable$Creator<com.google.android.gms.drive.DriveId> r2 = com.google.android.gms.drive.DriveId.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r2)
            r7 = r1
            com.google.android.gms.drive.DriveId r7 = (com.google.android.gms.drive.DriveId) r7
            goto L_0x000d
        L_0x0047:
            int r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x000d
        L_0x004c:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r14, r0)
            com.google.android.gms.internal.drive.zzh r14 = new com.google.android.gms.internal.drive.zzh
            r5 = r14
            r5.<init>(r6, r7, r8, r9, r11)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzi.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzh[i];
    }
}
