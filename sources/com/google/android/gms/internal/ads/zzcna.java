package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcna implements zzfkn {
    public final Context zza;
    public final zzcoh zzb;
    public final String zzc;
    public final boolean zzd;
    public final boolean zze;
    public final zzfb zzf;
    public final zzbkm zzg;
    public final zzcgy zzh;
    public final zzl zzi;
    public final zza zzj;
    public final zzayx zzk;
    public final zzeye zzl;
    public final zzeyh zzm;

    public zzcna(Context context, zzcoh zzcoh, String str, boolean z, boolean z2, zzfb zzfb, zzbkm zzbkm, zzcgy zzcgy, zzbkc zzbkc, zzl zzl2, zza zza2, zzayx zzayx, zzeye zzeye, zzeyh zzeyh) {
        this.zza = context;
        this.zzb = zzcoh;
        this.zzc = str;
        this.zzd = z;
        this.zze = z2;
        this.zzf = zzfb;
        this.zzg = zzbkm;
        this.zzh = zzcgy;
        this.zzi = zzl2;
        this.zzj = zza2;
        this.zzk = zzayx;
        this.zzl = zzeye;
        this.zzm = zzeyh;
    }

    public final Object zza() {
        Context context = this.zza;
        zzcoh zzcoh = this.zzb;
        String str = this.zzc;
        boolean z = this.zzd;
        boolean z2 = this.zze;
        zzfb zzfb = this.zzf;
        zzbkm zzbkm = this.zzg;
        zzcgy zzcgy = this.zzh;
        zzl zzl2 = this.zzi;
        zza zza2 = this.zzj;
        zzayx zzayx = this.zzk;
        zzeye zzeye = this.zzl;
        zzeyh zzeyh = this.zzm;
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = zzcnk.zza;
            zzcng zzcng = new zzcng(new zzcnk(new zzcog(context), zzcoh, str, z, z2, zzfb, zzbkm, zzcgy, (zzbkc) null, zzl2, zza2, zzayx, zzeye, zzeyh));
            zzcng.setWebViewClient(zzs.zze().zzl(zzcng, zzayx, z2));
            zzcng.setWebChromeClient(new zzcmq(zzcng));
            return zzcng;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
