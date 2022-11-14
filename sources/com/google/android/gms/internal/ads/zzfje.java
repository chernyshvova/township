package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzfje extends zzfix {
    public zzfkn<Integer> zza;
    public zzfkn<Integer> zzb;
    @Nullable
    public zzfjd zzc = null;
    @Nullable
    public HttpURLConnection zzd;

    public zzfje() {
        zzfkn<Integer> zzfkn = zzfiz.zza;
        zzfkn<Integer> zzfkn2 = zzfja.zza;
        this.zza = zzfkn;
        this.zzb = zzfkn2;
    }

    public final void close() {
        HttpURLConnection httpURLConnection = this.zzd;
        zzfiy.zzb();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public final HttpURLConnection zzb(zzfjd zzfjd, int i, int i2) throws IOException {
        this.zza = new zzfjb(265);
        this.zzb = new zzfjc(-1);
        this.zzc = zzfjd;
        zzfiy.zza(this.zza.zza().intValue(), this.zzb.zza().intValue());
        zzfjd zzfjd2 = this.zzc;
        if (zzfjd2 != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) zzfjd2.zza();
            this.zzd = httpURLConnection;
            return httpURLConnection;
        }
        throw null;
    }
}
