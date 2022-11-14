package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzje {
    public static final zzjc zza = zzc();
    public static final zzjc zzb = new zzjf();

    public static zzjc zza() {
        return zza;
    }

    public static zzjc zzb() {
        return zzb;
    }

    public static zzjc zzc() {
        try {
            return (zzjc) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
