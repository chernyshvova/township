package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcmw implements zzfqa<Map<String, String>> {
    public final /* synthetic */ List zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Uri zzc;
    public final /* synthetic */ zzcmy zzd;

    public zzcmw(zzcmy zzcmy, List list, String str, Uri uri) {
        this.zzd = zzcmy;
        this.zza = list;
        this.zzb = str;
        this.zzc = uri;
    }

    public final void zza(Throwable th) {
        String valueOf = String.valueOf(this.zzc);
        StringBuilder sb = new StringBuilder(valueOf.length() + 33);
        sb.append("Failed to parse gmsg params for: ");
        sb.append(valueOf);
        zzcgs.zzi(sb.toString());
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzd.zzP((Map) obj, this.zza, this.zzb);
    }
}
