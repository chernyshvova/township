package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcelable;

public final class zzm implements Parcelable.Creator<zzl> {
    /* JADX WARNING: type inference failed for: r1v9, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r10)
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r1 = 0
            r3 = 0
            r4 = 0
            r4 = r1
            r6 = r4
            r5 = 0
        L_0x000f:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x0064
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r10)
            int r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r8 = 1
            if (r7 == r8) goto L_0x0058
            r8 = 2
            if (r7 == r8) goto L_0x004a
            r8 = 3
            if (r7 == r8) goto L_0x003e
            r8 = 4
            if (r7 == r8) goto L_0x002d
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r10, r1)
            goto L_0x000f
        L_0x002d:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.accounttransfer.zzo> r6 = com.google.android.gms.auth.api.accounttransfer.zzo.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r10, r1, r6)
            r6 = r1
            com.google.android.gms.auth.api.accounttransfer.zzo r6 = (com.google.android.gms.auth.api.accounttransfer.zzo) r6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r2.add(r1)
            goto L_0x000f
        L_0x003e:
            int r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r10, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r2.add(r1)
            goto L_0x000f
        L_0x004a:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.accounttransfer.zzr> r4 = com.google.android.gms.auth.api.accounttransfer.zzr.CREATOR
            java.util.ArrayList r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r10, r1, r4)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r2.add(r1)
            goto L_0x000f
        L_0x0058:
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r10, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r2.add(r1)
            goto L_0x000f
        L_0x0064:
            int r1 = r10.dataPosition()
            if (r1 != r0) goto L_0x0071
            com.google.android.gms.auth.api.accounttransfer.zzl r10 = new com.google.android.gms.auth.api.accounttransfer.zzl
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return r10
        L_0x0071:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException r1 = new com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException
            r2 = 37
            java.lang.String r3 = "Overread allowed size end="
            java.lang.String r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r2, r3, r0)
            r1.<init>(r0, r10)
            goto L_0x0080
        L_0x007f:
            throw r1
        L_0x0080:
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.accounttransfer.zzm.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzl[i];
    }
}
