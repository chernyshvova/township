package com.google.android.gms.internal.drive;

public final class zzma {
    public static final zzly zzuu = zzei();
    public static final zzly zzuv = new zzlz();

    public static zzly zzeg() {
        return zzuu;
    }

    public static zzly zzeh() {
        return zzuv;
    }

    public static zzly zzei() {
        try {
            return (zzly) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
