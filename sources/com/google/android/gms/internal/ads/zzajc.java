package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzajc implements zzaht {
    public final zzaht zza;
    public long zzb;
    public Uri zzc;
    public Map<String, List<String>> zzd;

    public zzajc(zzaht zzaht) {
        if (zzaht != null) {
            this.zza = zzaht;
            this.zzc = Uri.EMPTY;
            this.zzd = Collections.emptyMap();
            return;
        }
        throw null;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int zza2 = this.zza.zza(bArr, i, i2);
        if (zza2 != -1) {
            this.zzb += (long) zza2;
        }
        return zza2;
    }

    public final void zzb(zzajd zzajd) {
        if (zzajd != null) {
            this.zza.zzb(zzajd);
            return;
        }
        throw null;
    }

    public final long zzc(zzahx zzahx) throws IOException {
        this.zzc = zzahx.zza;
        this.zzd = Collections.emptyMap();
        long zzc2 = this.zza.zzc(zzahx);
        Uri zzd2 = zzd();
        if (zzd2 != null) {
            this.zzc = zzd2;
            this.zzd = zze();
            return zzc2;
        }
        throw null;
    }

    @Nullable
    public final Uri zzd() {
        return this.zza.zzd();
    }

    public final Map<String, List<String>> zze() {
        return this.zza.zze();
    }

    public final void zzf() throws IOException {
        this.zza.zzf();
    }

    public final long zzg() {
        return this.zzb;
    }

    public final Uri zzh() {
        return this.zzc;
    }

    public final Map<String, List<String>> zzi() {
        return this.zzd;
    }
}
