package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.swrve.sdk.rest.RESTClient;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzatt implements zzatv {
    public final byte[] zza;
    public Uri zzb;
    public int zzc;
    public int zzd;

    public zzatt(byte[] bArr) {
        zzaul.zza(bArr.length > 0);
        this.zza = bArr;
    }

    public final long zza(zzatx zzatx) throws IOException {
        this.zzb = zzatx.zza;
        long j = zzatx.zzc;
        int i = (int) j;
        this.zzc = i;
        long j2 = zzatx.zzd;
        int length = (int) (j2 == -1 ? ((long) this.zza.length) - j : j2);
        this.zzd = length;
        if (length > 0 && i + length <= this.zza.length) {
            return (long) length;
        }
        byte[] bArr = this.zza;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(j2);
        sb.append("], length: ");
        sb.append(bArr.length);
        throw new IOException(sb.toString());
    }

    public final int zzb(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.zza, this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        return min;
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws IOException {
        this.zzb = null;
    }
}
