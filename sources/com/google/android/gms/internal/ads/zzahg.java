package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzahg extends zzahm {
    public final AssetManager zza;
    @Nullable
    public Uri zzb;
    @Nullable
    public InputStream zzc;
    public long zzd;
    public boolean zze;

    public zzahg(Context context) {
        super(false);
        this.zza = context.getAssets();
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzahf {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zzd;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzahf(e);
            }
        }
        InputStream inputStream = this.zzc;
        int i3 = zzalh.zza;
        int read = inputStream.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.zzd;
        if (j2 != -1) {
            this.zzd = j2 - ((long) read);
        }
        zzi(read);
        return read;
    }

    public final long zzc(zzahx zzahx) throws zzahf {
        try {
            Uri uri = zzahx.zza;
            this.zzb = uri;
            String path = uri.getPath();
            if (path != null) {
                if (path.startsWith("/android_asset/")) {
                    path = path.substring(15);
                } else if (path.startsWith("/")) {
                    path = path.substring(1);
                }
                zzg(zzahx);
                InputStream open = this.zza.open(path, 1);
                this.zzc = open;
                if (open.skip(zzahx.zzf) >= zzahx.zzf) {
                    long j = zzahx.zzg;
                    if (j != -1) {
                        this.zzd = j;
                    } else {
                        long available = (long) this.zzc.available();
                        this.zzd = available;
                        if (available == 2147483647L) {
                            this.zzd = -1;
                        }
                    }
                    this.zze = true;
                    zzh(zzahx);
                    return this.zzd;
                }
                throw new zzahu(0);
            }
            throw null;
        } catch (IOException e) {
            throw new zzahf(e);
        }
    }

    @Nullable
    public final Uri zzd() {
        return this.zzb;
    }

    public final void zzf() throws zzahf {
        this.zzb = null;
        try {
            InputStream inputStream = this.zzc;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzj();
            }
        } catch (IOException e) {
            throw new zzahf(e);
        } catch (Throwable th) {
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzj();
            }
            throw th;
        }
    }
}
