package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzena implements zzeqp<zzenb> {
    public final zzfqo zza;
    public final Context zzb;

    public zzena(zzfqo zzfqo, Context context) {
        this.zza = zzfqo;
        this.zzb = context;
    }

    public final zzfqn<zzenb> zza() {
        return this.zza.zzb(new zzemz(this));
    }

    public final /* synthetic */ zzenb zzb() throws Exception {
        AudioManager audioManager = (AudioManager) this.zzb.getSystemService("audio");
        return new zzenb(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzs.zzh().zzb(), zzs.zzh().zzd());
    }
}
