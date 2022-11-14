package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzctf implements zzfqa<String> {
    public final /* synthetic */ zzcth zza;

    public zzctf(zzcth zzcth) {
        this.zza = zzcth;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        zzezg zzo = this.zza.zzh;
        List<String> zzb = this.zza.zzg.zzb(this.zza.zze, this.zza.zzf, false, "", (String) obj, this.zza.zzf.zzc);
        zzs.zzc();
        int i = 1;
        if (true == zzr.zzI(this.zza.zza)) {
            i = 2;
        }
        zzo.zzb(zzb, i);
    }
}
