package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public enum zzhs {
    DOUBLE(0, zzhu.SCALAR, zzil.DOUBLE),
    FLOAT(1, zzhu.SCALAR, zzil.FLOAT),
    INT64(2, zzhu.SCALAR, zzil.LONG),
    UINT64(3, zzhu.SCALAR, zzil.LONG),
    INT32(4, zzhu.SCALAR, zzil.INT),
    FIXED64(5, zzhu.SCALAR, zzil.LONG),
    FIXED32(6, zzhu.SCALAR, zzil.INT),
    BOOL(7, zzhu.SCALAR, zzil.BOOLEAN),
    STRING(8, zzhu.SCALAR, zzil.STRING),
    MESSAGE(9, zzhu.SCALAR, zzil.MESSAGE),
    BYTES(10, zzhu.SCALAR, zzil.BYTE_STRING),
    UINT32(11, zzhu.SCALAR, zzil.INT),
    ENUM(12, zzhu.SCALAR, zzil.ENUM),
    SFIXED32(13, zzhu.SCALAR, zzil.INT),
    SFIXED64(14, zzhu.SCALAR, zzil.LONG),
    SINT32(15, zzhu.SCALAR, zzil.INT),
    SINT64(16, zzhu.SCALAR, zzil.LONG),
    GROUP(17, zzhu.SCALAR, zzil.MESSAGE),
    DOUBLE_LIST(18, zzhu.VECTOR, zzil.DOUBLE),
    FLOAT_LIST(19, zzhu.VECTOR, zzil.FLOAT),
    INT64_LIST(20, zzhu.VECTOR, zzil.LONG),
    UINT64_LIST(21, zzhu.VECTOR, zzil.LONG),
    INT32_LIST(22, zzhu.VECTOR, zzil.INT),
    FIXED64_LIST(23, zzhu.VECTOR, zzil.LONG),
    FIXED32_LIST(24, zzhu.VECTOR, zzil.INT),
    BOOL_LIST(25, zzhu.VECTOR, zzil.BOOLEAN),
    STRING_LIST(26, zzhu.VECTOR, zzil.STRING),
    MESSAGE_LIST(27, zzhu.VECTOR, zzil.MESSAGE),
    BYTES_LIST(28, zzhu.VECTOR, zzil.BYTE_STRING),
    UINT32_LIST(29, zzhu.VECTOR, zzil.INT),
    ENUM_LIST(30, zzhu.VECTOR, zzil.ENUM),
    SFIXED32_LIST(31, zzhu.VECTOR, zzil.INT),
    SFIXED64_LIST(32, zzhu.VECTOR, zzil.LONG),
    SINT32_LIST(33, zzhu.VECTOR, zzil.INT),
    SINT64_LIST(34, zzhu.VECTOR, zzil.LONG),
    DOUBLE_LIST_PACKED(35, zzhu.PACKED_VECTOR, zzil.DOUBLE),
    FLOAT_LIST_PACKED(36, zzhu.PACKED_VECTOR, zzil.FLOAT),
    INT64_LIST_PACKED(37, zzhu.PACKED_VECTOR, zzil.LONG),
    UINT64_LIST_PACKED(38, zzhu.PACKED_VECTOR, zzil.LONG),
    INT32_LIST_PACKED(39, zzhu.PACKED_VECTOR, zzil.INT),
    FIXED64_LIST_PACKED(40, zzhu.PACKED_VECTOR, zzil.LONG),
    FIXED32_LIST_PACKED(41, zzhu.PACKED_VECTOR, zzil.INT),
    BOOL_LIST_PACKED(42, zzhu.PACKED_VECTOR, zzil.BOOLEAN),
    UINT32_LIST_PACKED(43, zzhu.PACKED_VECTOR, zzil.INT),
    ENUM_LIST_PACKED(44, zzhu.PACKED_VECTOR, zzil.ENUM),
    SFIXED32_LIST_PACKED(45, zzhu.PACKED_VECTOR, zzil.INT),
    SFIXED64_LIST_PACKED(46, zzhu.PACKED_VECTOR, zzil.LONG),
    SINT32_LIST_PACKED(47, zzhu.PACKED_VECTOR, zzil.INT),
    SINT64_LIST_PACKED(48, zzhu.PACKED_VECTOR, zzil.LONG),
    GROUP_LIST(49, zzhu.VECTOR, zzil.MESSAGE),
    MAP(50, zzhu.MAP, zzil.VOID);
    
    public static final zzhs[] zzbe = null;
    public static final Type[] zzbf = null;
    public final zzil zzaz;
    public final int zzba;
    public final zzhu zzbb;
    public final Class<?> zzbc;
    public final boolean zzbd;

    /* access modifiers changed from: public */
    static {
        int i;
        zzbf = new Type[0];
        zzhs[] values = values();
        zzbe = new zzhs[values.length];
        for (zzhs zzhs : values) {
            zzbe[zzhs.zzba] = zzhs;
        }
    }

    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r5 = com.google.android.gms.internal.measurement.zzhv.zzb[r6.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzhs(int r4, com.google.android.gms.internal.measurement.zzhu r5, com.google.android.gms.internal.measurement.zzil r6) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r1.zzba = r4
            r1.zzbb = r5
            r1.zzaz = r6
            int[] r2 = com.google.android.gms.internal.measurement.zzhv.zza
            int r3 = r5.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x0022
            if (r2 == r3) goto L_0x001b
            r2 = 0
            r1.zzbc = r2
            goto L_0x0028
        L_0x001b:
            java.lang.Class r2 = r6.zza()
            r1.zzbc = r2
            goto L_0x0028
        L_0x0022:
            java.lang.Class r2 = r6.zza()
            r1.zzbc = r2
        L_0x0028:
            r2 = 0
            com.google.android.gms.internal.measurement.zzhu r0 = com.google.android.gms.internal.measurement.zzhu.SCALAR
            if (r5 != r0) goto L_0x003d
            int[] r5 = com.google.android.gms.internal.measurement.zzhv.zzb
            int r6 = r6.ordinal()
            r5 = r5[r6]
            if (r5 == r4) goto L_0x003d
            if (r5 == r3) goto L_0x003d
            r3 = 3
            if (r5 == r3) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r4 = 0
        L_0x003e:
            r1.zzbd = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhs.<init>(java.lang.String, int, int, com.google.android.gms.internal.measurement.zzhu, com.google.android.gms.internal.measurement.zzil):void");
    }

    public final int zza() {
        return this.zzba;
    }
}
