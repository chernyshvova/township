package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzahw {
    @Nullable
    public Uri zza;
    public Map<String, String> zzb = Collections.emptyMap();
    public long zzc;
    public int zzd;

    public final zzahw zza(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzahw zzb(Map<String, String> map) {
        this.zzb = map;
        return this;
    }

    public final zzahw zzc(long j) {
        this.zzc = j;
        return this;
    }

    public final zzahw zzd(int i) {
        this.zzd = 6;
        return this;
    }

    public final zzahx zze() {
        Uri uri = this.zza;
        if (uri != null) {
            return new zzahx(uri, 0, 1, (byte[]) null, this.zzb, this.zzc, -1, (String) null, this.zzd, (Object) null, (zzahv) null);
        }
        throw new IllegalStateException("The uri must be set.");
    }
}
