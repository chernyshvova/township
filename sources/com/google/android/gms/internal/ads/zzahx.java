package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzahx {
    public final Uri zza;
    public final int zzb;
    @Nullable
    public final byte[] zzc;
    public final Map<String, String> zzd;
    @Deprecated
    public final long zze;
    public final long zzf;
    public final long zzg;
    @Nullable
    public final String zzh;
    public final int zzi;

    public zzahx(Uri uri, long j, int i, @Nullable byte[] bArr, Map<String, String> map, long j2, long j3, @Nullable String str, int i2, @Nullable Object obj) {
        long j4 = j + j2;
        boolean z = false;
        zzajg.zza(j4 >= 0);
        zzajg.zza(j2 >= 0);
        zzajg.zza((j3 > 0 || j3 == -1) ? true : z);
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zzf = j2;
        this.zze = j4;
        this.zzg = j3;
        this.zzh = null;
        this.zzi = i2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        long j = this.zzf;
        long j2 = this.zzg;
        int i = this.zzi;
        StringBuilder sb = new StringBuilder(valueOf.length() + 73 + "null".length());
        GeneratedOutlineSupport.outline34(sb, "DataSpec[", "GET", " ", valueOf);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(j);
        sb.append(RESTClient.COMMA_SEPARATOR);
        sb.append(j2);
        sb.append(", null, ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    public final boolean zza(int i) {
        return (this.zzi & i) == i;
    }

    public /* synthetic */ zzahx(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj, zzahv zzahv) {
        this(uri, 0, 1, (byte[]) null, map, j2, -1, (String) null, i2, (Object) null);
    }

    @Deprecated
    public zzahx(Uri uri, @Nullable byte[] bArr, long j, long j2, long j3, @Nullable String str, int i) {
        this(uri, j - j2, 1, (byte[]) null, Collections.emptyMap(), j2, j3, (String) null, i, (Object) null);
    }
}
