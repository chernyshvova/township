package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaic implements zzaht {
    public final Context zza;
    public final List<zzajd> zzb = new ArrayList();
    public final zzaht zzc;
    @Nullable
    public zzaht zzd;
    @Nullable
    public zzaht zze;
    @Nullable
    public zzaht zzf;
    @Nullable
    public zzaht zzg;
    @Nullable
    public zzaht zzh;
    @Nullable
    public zzaht zzi;
    @Nullable
    public zzaht zzj;
    @Nullable
    public zzaht zzk;

    public zzaic(Context context, zzaht zzaht) {
        this.zza = context.getApplicationContext();
        this.zzc = zzaht;
    }

    private final zzaht zzg() {
        if (this.zze == null) {
            zzahg zzahg = new zzahg(this.zza);
            this.zze = zzahg;
            zzh(zzahg);
        }
        return this.zze;
    }

    private final void zzh(zzaht zzaht) {
        for (int i = 0; i < this.zzb.size(); i++) {
            zzaht.zzb(this.zzb.get(i));
        }
    }

    public static final void zzi(@Nullable zzaht zzaht, zzajd zzajd) {
        if (zzaht != null) {
            zzaht.zzb(zzajd);
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        zzaht zzaht = this.zzk;
        if (zzaht != null) {
            return zzaht.zza(bArr, i, i2);
        }
        throw null;
    }

    public final void zzb(zzajd zzajd) {
        if (zzajd != null) {
            this.zzc.zzb(zzajd);
            this.zzb.add(zzajd);
            zzi(this.zzd, zzajd);
            zzi(this.zze, zzajd);
            zzi(this.zzf, zzajd);
            zzi(this.zzg, zzajd);
            zzi(this.zzh, zzajd);
            zzi(this.zzi, zzajd);
            zzi(this.zzj, zzajd);
            return;
        }
        throw null;
    }

    public final long zzc(zzahx zzahx) throws IOException {
        zzaht zzaht;
        zzajg.zzd(this.zzk == null);
        String scheme = zzahx.zza.getScheme();
        if (zzalh.zzb(zzahx.zza)) {
            String path = zzahx.zza.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    zzaij zzaij = new zzaij();
                    this.zzd = zzaij;
                    zzh(zzaij);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzg();
            }
        } else if ("asset".equals(scheme)) {
            this.zzk = zzg();
        } else if ("content".equals(scheme)) {
            if (this.zzf == null) {
                zzahp zzahp = new zzahp(this.zza);
                this.zzf = zzahp;
                zzh(zzahp);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    zzaht zzaht2 = (zzaht) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.zzg = zzaht2;
                    zzh(zzaht2);
                } catch (ClassNotFoundException unused) {
                    Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                zzajf zzajf = new zzajf(2000);
                this.zzh = zzajf;
                zzh(zzajf);
            }
            this.zzk = this.zzh;
        } else if ("data".equals(scheme)) {
            if (this.zzi == null) {
                zzahr zzahr = new zzahr();
                this.zzi = zzahr;
                zzh(zzahr);
            }
            this.zzk = this.zzi;
        } else {
            if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.zzj == null) {
                    zzajb zzajb = new zzajb(this.zza);
                    this.zzj = zzajb;
                    zzh(zzajb);
                }
                zzaht = this.zzj;
            } else {
                zzaht = this.zzc;
            }
            this.zzk = zzaht;
        }
        return this.zzk.zzc(zzahx);
    }

    @Nullable
    public final Uri zzd() {
        zzaht zzaht = this.zzk;
        if (zzaht == null) {
            return null;
        }
        return zzaht.zzd();
    }

    public final Map<String, List<String>> zze() {
        zzaht zzaht = this.zzk;
        return zzaht == null ? Collections.emptyMap() : zzaht.zze();
    }

    public final void zzf() throws IOException {
        zzaht zzaht = this.zzk;
        if (zzaht != null) {
            try {
                zzaht.zzf();
            } finally {
                this.zzk = null;
            }
        }
    }
}
