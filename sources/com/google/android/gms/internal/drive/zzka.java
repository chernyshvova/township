package com.google.android.gms.internal.drive;

public final class zzka {
    public static final zzjy<?> zzoq = new zzjz();
    public static final zzjy<?> zzor = zzck();

    public static zzjy<?> zzck() {
        try {
            return (zzjy) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static zzjy<?> zzcl() {
        return zzoq;
    }

    public static zzjy<?> zzcm() {
        zzjy<?> zzjy = zzor;
        if (zzjy != null) {
            return zzjy;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
