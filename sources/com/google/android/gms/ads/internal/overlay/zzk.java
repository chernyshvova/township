package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzk extends zzb {
    public final /* synthetic */ zzl zza;

    public /* synthetic */ zzk(zzl zzl, zzf zzf) {
        this.zza = zzl;
    }

    public final void zza() {
        Bitmap zza2 = zzs.zzv().zza(Integer.valueOf(this.zza.zzc.zzo.zzf));
        if (zza2 != null) {
            zzac zze = zzs.zze();
            zzl zzl = this.zza;
            Activity activity = zzl.zzb;
            zzj zzj = zzl.zzc.zzo;
            zzr.zza.post(new zzj(this, zze.zzd(activity, zza2, zzj.zzd, zzj.zze)));
        }
    }
}
