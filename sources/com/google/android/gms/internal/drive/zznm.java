package com.google.android.gms.internal.drive;

public enum zznm {
    DOUBLE(zznr.DOUBLE, 1),
    FLOAT(zznr.FLOAT, 5),
    INT64(zznr.LONG, 0),
    UINT64(zznr.LONG, 0),
    INT32(zznr.INT, 0),
    FIXED64(zznr.LONG, 1),
    FIXED32(zznr.INT, 5),
    BOOL(zznr.BOOLEAN, 0),
    STRING(zznr.STRING, 2),
    GROUP(zznr.MESSAGE, 3),
    MESSAGE(zznr.MESSAGE, 2),
    BYTES(zznr.BYTE_STRING, 2),
    UINT32(zznr.INT, 0),
    ENUM(zznr.ENUM, 0),
    SFIXED32(zznr.INT, 5),
    SFIXED64(zznr.LONG, 1),
    SINT32(zznr.INT, 0),
    SINT64(zznr.LONG, 0);
    
    public final zznr zzxm;
    public final int zzxn;

    /* access modifiers changed from: public */
    zznm(zznr zznr, int i) {
        this.zzxm = zznr;
        this.zzxn = i;
    }

    public final zznr zzfj() {
        return this.zzxm;
    }

    public final int zzfk() {
        return this.zzxn;
    }
}
