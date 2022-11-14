package com.google.android.gms.internal.drive;

import android.os.Parcelable;

public final class zzx implements Parcelable.Creator<zzw> {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r13) {
        /*
            r12 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r13)
            r1 = 0
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r9 = r6
            r8 = 0
            r10 = 0
            r11 = 0
        L_0x000d:
            int r1 = r13.dataPosition()
            if (r1 >= r0) goto L_0x0059
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r13)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r3) {
                case 2: goto L_0x004f;
                case 3: goto L_0x0045;
                case 4: goto L_0x003b;
                case 5: goto L_0x0036;
                case 6: goto L_0x0031;
                case 7: goto L_0x002c;
                case 8: goto L_0x0027;
                case 9: goto L_0x0022;
                default: goto L_0x001e;
            }
        L_0x001e:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r13, r1)
            goto L_0x000d
        L_0x0022:
            int r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r13, r1)
            goto L_0x000d
        L_0x0027:
            int r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r13, r1)
            goto L_0x000d
        L_0x002c:
            java.lang.String r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r13, r1)
            goto L_0x000d
        L_0x0031:
            boolean r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r13, r1)
            goto L_0x000d
        L_0x0036:
            java.lang.Integer r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIntegerObject(r13, r1)
            goto L_0x000d
        L_0x003b:
            android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r3 = com.google.android.gms.drive.Contents.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r3)
            r6 = r1
            com.google.android.gms.drive.Contents r6 = (com.google.android.gms.drive.Contents) r6
            goto L_0x000d
        L_0x0045:
            android.os.Parcelable$Creator<com.google.android.gms.drive.metadata.internal.MetadataBundle> r3 = com.google.android.gms.drive.metadata.internal.MetadataBundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r3)
            r5 = r1
            com.google.android.gms.drive.metadata.internal.MetadataBundle r5 = (com.google.android.gms.drive.metadata.internal.MetadataBundle) r5
            goto L_0x000d
        L_0x004f:
            android.os.Parcelable$Creator<com.google.android.gms.drive.DriveId> r3 = com.google.android.gms.drive.DriveId.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r13, r1, r3)
            r4 = r1
            com.google.android.gms.drive.DriveId r4 = (com.google.android.gms.drive.DriveId) r4
            goto L_0x000d
        L_0x0059:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r13, r0)
            com.google.android.gms.internal.drive.zzw r13 = new com.google.android.gms.internal.drive.zzw
            int r7 = r2.intValue()
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzx.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzw[i];
    }
}
