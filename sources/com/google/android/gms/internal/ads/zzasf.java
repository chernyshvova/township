package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzasf {
    public final zzapl[] zza;
    public final zzapm zzb;
    public zzapl zzc;

    public zzasf(zzapl[] zzaplArr, zzapm zzapm) {
        this.zza = zzaplArr;
        this.zzb = zzapm;
    }

    public final void zza() {
        if (this.zzc != null) {
            this.zzc = null;
        }
    }

    public final zzapl zzb(zzapk zzapk, Uri uri) throws IOException, InterruptedException {
        zzapl zzapl = this.zzc;
        if (zzapl != null) {
            return zzapl;
        }
        zzapl[] zzaplArr = this.zza;
        int length = zzaplArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzapl zzapl2 = zzaplArr[i];
            try {
                if (zzapl2.zzf(zzapk)) {
                    this.zzc = zzapl2;
                    zzapk.zzg();
                    break;
                }
                zzapk.zzg();
                i++;
            } catch (EOFException unused) {
            } catch (Throwable th) {
                zzapk.zzg();
                throw th;
            }
        }
        zzapl zzapl3 = this.zzc;
        if (zzapl3 != null) {
            zzapl3.zzd(this.zzb);
            return this.zzc;
        }
        String zzn = zzava.zzn(this.zza);
        throw new zzatd(GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(zzn).length() + 58), "None of the available extractors (", zzn, ") could read the stream."), uri);
    }
}
