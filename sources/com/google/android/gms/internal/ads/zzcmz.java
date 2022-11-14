package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcmz implements zzfpl {
    public final Context zza;
    public final zzfb zzb;
    public final zzcgy zzc;
    public final zza zzd;
    public final String zze;

    public zzcmz(Context context, zzfb zzfb, zzcgy zzcgy, zza zza2, String str) {
        this.zza = context;
        this.zzb = zzfb;
        this.zzc = zzcgy;
        this.zzd = zza2;
        this.zze = str;
    }

    public final zzfqn zza(Object obj) {
        Context context = this.zza;
        zzfb zzfb = this.zzb;
        zzcgy zzcgy = this.zzc;
        zza zza2 = this.zzd;
        String str = this.zze;
        zzs.zzd();
        zzcmr zza3 = zzcnd.zza(context, zzcoh.zzb(), "", false, false, zzfb, (zzbkm) null, zzcgy, (zzbkc) null, (zzl) null, zza2, zzayx.zza(), (zzeye) null, (zzeyh) null);
        zzchi zza4 = zzchi.zza(zza3);
        zza3.zzR().zzw(new zzcnb(zza4));
        zza3.loadUrl(str);
        return zza4;
    }
}
