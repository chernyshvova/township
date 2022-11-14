package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzho {
    public static final zzhn<?> zza = new zzhp();
    public static final zzhn<?> zzb = zzc();

    public static zzhn<?> zza() {
        return zza;
    }

    public static zzhn<?> zzb() {
        zzhn<?> zzhn = zzb;
        if (zzhn != null) {
            return zzhn;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzhn<?> zzc() {
        try {
            return (zzhn) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
