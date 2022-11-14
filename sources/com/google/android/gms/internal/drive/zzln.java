package com.google.android.gms.internal.drive;

public final class zzln {
    public static final zzll zztz = zzeb();
    public static final zzll zzua = new zzlm();

    public static zzll zzdz() {
        return zztz;
    }

    public static zzll zzea() {
        return zzua;
    }

    public static zzll zzeb() {
        try {
            return (zzll) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
