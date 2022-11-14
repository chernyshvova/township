package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzkn implements zzez {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzkl zzb;

    public zzkn(zzkl zzkl, String str) {
        this.zzb = zzkl;
        this.zza = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(i, th, bArr, this.zza);
    }
}
