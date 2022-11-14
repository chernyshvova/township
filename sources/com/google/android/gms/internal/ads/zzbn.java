package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbn extends zzgir implements Closeable {
    public static final zzgiy zza = zzgiy.zzb(zzbn.class);

    public zzbn(zzgis zzgis, zzbm zzbm) throws IOException {
        zze(zzgis, zzgis.zzb(), zzbm);
    }

    public final void close() throws IOException {
    }

    public final String toString() {
        String obj = this.zzd.toString();
        return GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(obj).length() + 7), "model(", obj, ")");
    }
}
