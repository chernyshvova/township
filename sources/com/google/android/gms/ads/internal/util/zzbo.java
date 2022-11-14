package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzac;
import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzaz;
import com.google.android.gms.internal.ads.zzcgr;
import com.google.android.gms.internal.ads.zzchj;
import com.google.android.gms.internal.ads.zzy;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbo extends zzac<zzy> {
    public final zzchj<zzy> zza;
    public final zzcgr zzb;

    public zzbo(String str, Map<String, String> map, zzchj<zzy> zzchj) {
        super(0, str, new zzbn(zzchj));
        this.zza = zzchj;
        zzcgr zzcgr = new zzcgr((String) null);
        this.zzb = zzcgr;
        zzcgr.zzb(str, "GET", (Map<String, ?>) null, (byte[]) null);
    }

    public final zzai<zzy> zzr(zzy zzy) {
        return zzai.zza(zzy, zzaz.zza(zzy));
    }

    public final /* bridge */ /* synthetic */ void zzs(Object obj) {
        zzy zzy = (zzy) obj;
        this.zzb.zzd(zzy.zzc, zzy.zza);
        zzcgr zzcgr = this.zzb;
        byte[] bArr = zzy.zzb;
        if (zzcgr.zzj() && bArr != null) {
            zzcgr.zzf(bArr);
        }
        this.zza.zzc(zzy);
    }
}
