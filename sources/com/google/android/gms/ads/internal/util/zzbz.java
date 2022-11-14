package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzcgx;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbz extends zzb {
    public final zzcgx zza;
    public final String zzb;

    public zzbz(Context context, String str, String str2) {
        this.zza = new zzcgx(zzs.zzc().zze(context, str));
        this.zzb = str2;
    }

    public final void zza() {
        this.zza.zza(this.zzb);
    }
}
