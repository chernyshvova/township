package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzjt {
    public static final zzjr zza = zzc();
    public static final zzjr zzb = new zzjq();

    public static zzjr zza() {
        return zza;
    }

    public static zzjr zzb() {
        return zzb;
    }

    public static zzjr zzc() {
        try {
            return (zzjr) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
