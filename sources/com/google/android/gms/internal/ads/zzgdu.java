package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzgdu {
    DOUBLE(0, 1, zzgeq.DOUBLE),
    FLOAT(1, 1, zzgeq.FLOAT),
    INT64(2, 1, zzgeq.LONG),
    UINT64(3, 1, zzgeq.LONG),
    INT32(4, 1, zzgeq.INT),
    FIXED64(5, 1, zzgeq.LONG),
    FIXED32(6, 1, zzgeq.INT),
    BOOL(7, 1, zzgeq.BOOLEAN),
    STRING(8, 1, zzgeq.STRING),
    MESSAGE(9, 1, zzgeq.MESSAGE),
    BYTES(10, 1, zzgeq.BYTE_STRING),
    UINT32(11, 1, zzgeq.INT),
    ENUM(12, 1, zzgeq.ENUM),
    SFIXED32(13, 1, zzgeq.INT),
    SFIXED64(14, 1, zzgeq.LONG),
    SINT32(15, 1, zzgeq.INT),
    SINT64(16, 1, zzgeq.LONG),
    GROUP(17, 1, zzgeq.MESSAGE),
    DOUBLE_LIST(18, 2, zzgeq.DOUBLE),
    FLOAT_LIST(19, 2, zzgeq.FLOAT),
    INT64_LIST(20, 2, zzgeq.LONG),
    UINT64_LIST(21, 2, zzgeq.LONG),
    INT32_LIST(22, 2, zzgeq.INT),
    FIXED64_LIST(23, 2, zzgeq.LONG),
    FIXED32_LIST(24, 2, zzgeq.INT),
    BOOL_LIST(25, 2, zzgeq.BOOLEAN),
    STRING_LIST(26, 2, zzgeq.STRING),
    MESSAGE_LIST(27, 2, zzgeq.MESSAGE),
    BYTES_LIST(28, 2, zzgeq.BYTE_STRING),
    UINT32_LIST(29, 2, zzgeq.INT),
    ENUM_LIST(30, 2, zzgeq.ENUM),
    SFIXED32_LIST(31, 2, zzgeq.INT),
    SFIXED64_LIST(32, 2, zzgeq.LONG),
    SINT32_LIST(33, 2, zzgeq.INT),
    SINT64_LIST(34, 2, zzgeq.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzgeq.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzgeq.FLOAT),
    INT64_LIST_PACKED(37, 3, zzgeq.LONG),
    UINT64_LIST_PACKED(38, 3, zzgeq.LONG),
    INT32_LIST_PACKED(39, 3, zzgeq.INT),
    FIXED64_LIST_PACKED(40, 3, zzgeq.LONG),
    FIXED32_LIST_PACKED(41, 3, zzgeq.INT),
    BOOL_LIST_PACKED(42, 3, zzgeq.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzgeq.INT),
    ENUM_LIST_PACKED(44, 3, zzgeq.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzgeq.INT),
    SFIXED64_LIST_PACKED(46, 3, zzgeq.LONG),
    SINT32_LIST_PACKED(47, 3, zzgeq.INT),
    SINT64_LIST_PACKED(48, 3, zzgeq.LONG),
    GROUP_LIST(49, 2, zzgeq.MESSAGE),
    MAP(50, 4, zzgeq.VOID);
    
    public static final zzgdu[] zzac = null;
    public final zzgeq zzZ;
    public final int zzaa;
    public final Class<?> zzab;

    /* access modifiers changed from: public */
    static {
        int i;
        zzac = new zzgdu[r1];
        for (zzgdu zzgdu : values()) {
            zzac[zzgdu.zzaa] = zzgdu;
        }
    }

    /* access modifiers changed from: public */
    zzgdu(int i, int i2, zzgeq zzgeq) {
        this.zzaa = i;
        this.zzZ = zzgeq;
        zzgeq zzgeq2 = zzgeq.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzab = zzgeq.zza();
        } else if (i3 != 3) {
            this.zzab = null;
        } else {
            this.zzab = zzgeq.zza();
        }
        if (i2 == 1) {
            zzgeq.ordinal();
        }
    }

    public final int zza() {
        return this.zzaa;
    }
}
