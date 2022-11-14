package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaad {
    public final zzaah zza;
    public final MediaFormat zzb;
    public final zzkc zzc;
    @Nullable
    public final Surface zzd;
    @Nullable
    public final MediaCrypto zze = null;

    public zzaad(zzaah zzaah, MediaFormat mediaFormat, zzkc zzkc, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i) {
        this.zza = zzaah;
        this.zzb = mediaFormat;
        this.zzc = zzkc;
        this.zzd = surface;
    }
}
