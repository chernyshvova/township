package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzatx {
    public final Uri zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;

    public zzatx(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = false;
        zzaul.zza(j >= 0);
        zzaul.zza(j2 >= 0);
        zzaul.zza((j3 > 0 || j3 == -1) ? true : z);
        this.zza = uri;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String arrays = Arrays.toString((byte[]) null);
        long j = this.zzb;
        long j2 = this.zzc;
        long j3 = this.zzd;
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(valueOf.length(), 93, String.valueOf(arrays).length(), "null".length()));
        GeneratedOutlineSupport.outline34(sb, "DataSpec[", valueOf, RESTClient.COMMA_SEPARATOR, arrays);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(j);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(j2);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(j3);
        sb.append(", null, 0]");
        return sb.toString();
    }
}
