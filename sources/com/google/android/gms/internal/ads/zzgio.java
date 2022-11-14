package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzgio extends zzgir implements zzbp {
    public zzbq zza;
    public final String zzb = "moov";

    public zzgio(String str) {
    }

    public final void zza(zzbq zzbq) {
        this.zza = zzbq;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final void zzc(zzgis zzgis, ByteBuffer byteBuffer, long j, zzbm zzbm) throws IOException {
        zzgis.zzc();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzd = zzgis;
        this.zzf = zzgis.zzc();
        zzgis.zzd(zzgis.zzc() + j);
        this.zzg = zzgis.zzc();
        this.zzc = zzbm;
    }
}
