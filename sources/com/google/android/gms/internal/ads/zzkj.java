package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzkj {
    @Nullable
    public String zza;
    @Nullable
    public Uri zzb;
    public final Map<String, String> zzc = Collections.emptyMap();
    public final List<Integer> zzd = Collections.emptyList();
    public final List zze = Collections.emptyList();
    public final List zzf = Collections.emptyList();

    public final zzkj zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzkj zzb(@Nullable Uri uri) {
        this.zzb = uri;
        return this;
    }

    public final zzkq zzc() {
        Uri uri = this.zzb;
        zzkp zzkp = uri != null ? new zzkp(uri, (String) null, (zzkm) null, (zzki) null, this.zze, (String) null, this.zzf, (Object) null, (zzkh) null) : null;
        String str = this.zza;
        if (str == null) {
            str = "";
        }
        return new zzkq(str, new zzkl(0, Long.MIN_VALUE, false, false, false, (zzkh) null), zzkp, new zzko(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38f, -3.4028235E38f), zzku.zza, (zzkh) null);
    }
}
