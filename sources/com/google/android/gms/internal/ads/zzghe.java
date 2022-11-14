package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzghe {
    DOUBLE(zzghf.DOUBLE, 1),
    FLOAT(zzghf.FLOAT, 5),
    INT64(zzghf.LONG, 0),
    UINT64(zzghf.LONG, 0),
    INT32(zzghf.INT, 0),
    FIXED64(zzghf.LONG, 1),
    FIXED32(zzghf.INT, 5),
    BOOL(zzghf.BOOLEAN, 0),
    STRING(zzghf.STRING, 2),
    GROUP(zzghf.MESSAGE, 3),
    MESSAGE(zzghf.MESSAGE, 2),
    BYTES(zzghf.BYTE_STRING, 2),
    UINT32(zzghf.INT, 0),
    ENUM(zzghf.ENUM, 0),
    SFIXED32(zzghf.INT, 5),
    SFIXED64(zzghf.LONG, 1),
    SINT32(zzghf.INT, 0),
    SINT64(zzghf.LONG, 0);
    
    public final zzghf zzs;

    /* access modifiers changed from: public */
    zzghe(zzghf zzghf, int i) {
        this.zzs = zzghf;
    }

    public final zzghf zza() {
        return this.zzs;
    }
}
