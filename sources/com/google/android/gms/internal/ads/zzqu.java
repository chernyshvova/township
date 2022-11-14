package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqu extends AudioTrack.StreamEventCallback {
    public final /* synthetic */ zzqw zza;
    public final /* synthetic */ zzqv zzb;

    public zzqu(zzqv zzqv, zzqw zzqw) {
        this.zzb = zzqv;
        this.zza = zzqw;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i) {
        zzajg.zzd(audioTrack == this.zzb.zza.zzn);
        if (this.zzb.zza.zzk != null && this.zzb.zza.zzK) {
            this.zzb.zza.zzk.zza();
        }
    }

    public final void onTearDown(@NonNull AudioTrack audioTrack) {
        zzajg.zzd(audioTrack == this.zzb.zza.zzn);
        if (this.zzb.zza.zzk != null && this.zzb.zza.zzK) {
            this.zzb.zza.zzk.zza();
        }
    }
}
