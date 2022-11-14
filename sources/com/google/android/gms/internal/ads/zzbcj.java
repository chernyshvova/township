package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzbcj implements zzgee {
    VIDEO_ERROR_CODE_UNSPECIFIED(0),
    OPENGL_RENDERING_FAILED(1),
    CACHE_LOAD_FAILED(2),
    ANDROID_TARGET_API_TOO_LOW(3);
    
    public static final zzgef<zzbcj> zze = null;
    public final int zzf;

    /* access modifiers changed from: public */
    static {
        zze = new zzbch();
    }

    /* access modifiers changed from: public */
    zzbcj(int i) {
        this.zzf = i;
    }

    public static zzbcj zza(int i) {
        if (i == 0) {
            return VIDEO_ERROR_CODE_UNSPECIFIED;
        }
        if (i == 1) {
            return OPENGL_RENDERING_FAILED;
        }
        if (i == 2) {
            return CACHE_LOAD_FAILED;
        }
        if (i != 3) {
            return null;
        }
        return ANDROID_TARGET_API_TOO_LOW;
    }

    public static zzgeg zzb() {
        return zzbci.zza;
    }

    public final String toString() {
        return "<" + zzbcj.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
    }
}
