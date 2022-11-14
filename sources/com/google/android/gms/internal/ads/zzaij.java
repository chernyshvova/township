package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaij extends zzahm {
    @Nullable
    public RandomAccessFile zza;
    @Nullable
    public Uri zzb;
    public long zzc;
    public boolean zzd;

    public zzaij() {
        super(false);
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzaii {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zzc;
        if (j == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.zza;
            int i3 = zzalh.zza;
            int read = randomAccessFile.read(bArr, i, (int) Math.min(j, (long) i2));
            if (read > 0) {
                this.zzc -= (long) read;
                zzi(read);
            }
            return read;
        } catch (IOException e) {
            throw new zzaii(e);
        }
    }

    public final long zzc(zzahx zzahx) throws zzaii {
        Uri uri;
        try {
            uri = zzahx.zza;
            this.zzb = uri;
            zzg(zzahx);
            String path = uri.getPath();
            if (path != null) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(path, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
                this.zza = randomAccessFile;
                randomAccessFile.seek(zzahx.zzf);
                long j = zzahx.zzg;
                if (j == -1) {
                    j = this.zza.length() - zzahx.zzf;
                }
                this.zzc = j;
                if (j >= 0) {
                    this.zzd = true;
                    zzh(zzahx);
                    return this.zzc;
                }
                throw new zzahu(0);
            }
            throw null;
        } catch (FileNotFoundException e) {
            if (TextUtils.isEmpty(uri.getQuery())) {
                if (TextUtils.isEmpty(uri.getFragment())) {
                    throw new zzaii(e);
                }
            }
            throw new zzaii(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri.getPath(), uri.getQuery(), uri.getFragment()}), e);
        } catch (zzaii e2) {
            throw e2;
        } catch (IOException e3) {
            throw new zzaii(e3);
        }
    }

    @Nullable
    public final Uri zzd() {
        return this.zzb;
    }

    public final void zzf() throws zzaii {
        this.zzb = null;
        try {
            RandomAccessFile randomAccessFile = this.zza;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzj();
            }
        } catch (IOException e) {
            throw new zzaii(e);
        } catch (Throwable th) {
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzj();
            }
            throw th;
        }
    }
}
