package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzal;
import com.google.android.gms.internal.ads.zzcgs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbj implements zzag {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzbm zzb;

    public zzbj(zzbp zzbp, String str, zzbm zzbm) {
        this.zza = str;
        this.zzb = zzbm;
    }

    public final void zza(zzal zzal) {
        String str = this.zza;
        String exc = zzal.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(exc).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(exc);
        zzcgs.zzi(sb.toString());
        this.zzb.zza(null);
    }
}
