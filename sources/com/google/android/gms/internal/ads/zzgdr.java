package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgdr {
    public static final zzgdp<?> zza = new zzgdq();
    public static final zzgdp<?> zzb;

    static {
        zzgdp<?> zzgdp;
        try {
            zzgdp = (zzgdp) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgdp = null;
        }
        zzb = zzgdp;
    }

    public static zzgdp<?> zza() {
        return zza;
    }

    public static zzgdp<?> zzb() {
        zzgdp<?> zzgdp = zzb;
        if (zzgdp != null) {
            return zzgdp;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
