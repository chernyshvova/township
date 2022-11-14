package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzra implements zzqc {
    public final /* synthetic */ zzrb zza;

    public /* synthetic */ zzra(zzrb zzrb, zzqz zzqz) {
        this.zza = zzrb;
    }

    public final void zza() {
        if (this.zza.zzl != null) {
            this.zza.zzl.zzb();
        }
    }

    public final void zzb(Exception exc) {
        zzaka.zzb("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzi(exc);
    }
}
