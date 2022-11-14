package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzbh;
import com.google.android.gms.internal.ads.zzcgr;
import com.google.android.gms.internal.ads.zzk;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbk extends zzbh {
    public final /* synthetic */ byte[] zza;
    public final /* synthetic */ Map zzb;
    public final /* synthetic */ zzcgr zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbk(zzbp zzbp, int i, String str, zzah zzah, zzag zzag, byte[] bArr, Map map, zzcgr zzcgr) {
        super(i, str, zzah, zzag);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzcgr;
    }

    public final Map<String, String> zzm() throws zzk {
        Map<String, String> map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    public final byte[] zzn() throws zzk {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    /* renamed from: zzz */
    public final void zzs(String str) {
        this.zzc.zze(str);
        super.zzs(str);
    }
}
