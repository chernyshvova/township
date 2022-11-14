package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzano {
    public static final zzano zza = new zzano(1.0f, 1.0f);
    public final float zzb;
    public final float zzc = 1.0f;
    public final int zzd;

    public zzano(float f, float f2) {
        this.zzb = f;
        this.zzd = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzano.class == obj.getClass() && this.zzb == ((zzano) obj).zzb;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(1.0f) + ((Float.floatToRawIntBits(this.zzb) + 527) * 31);
    }

    public final long zza(long j) {
        return j * ((long) this.zzd);
    }
}
