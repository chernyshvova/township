package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzase implements zzauh {
    public final /* synthetic */ zzash zza;
    public final Uri zzb;
    public final zzatv zzc;
    public final zzasf zzd;
    public final zzaun zze;
    public final zzapq zzf;
    public volatile boolean zzg;
    public boolean zzh;
    public long zzi;
    public long zzj;

    public zzase(zzash zzash, Uri uri, zzatv zzatv, zzasf zzasf, zzaun zzaun) {
        this.zza = zzash;
        if (uri != null) {
            this.zzb = uri;
            if (zzatv != null) {
                this.zzc = zzatv;
                if (zzasf != null) {
                    this.zzd = zzasf;
                    this.zze = zzaun;
                    this.zzf = new zzapq();
                    this.zzh = true;
                    this.zzj = -1;
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public final void zza(long j, long j2) {
        this.zzf.zza = j;
        this.zzi = j2;
        this.zzh = true;
    }

    public final void zzb() {
        this.zzg = true;
    }

    public final boolean zzc() {
        return this.zzg;
    }

    public final void zzd() throws IOException, InterruptedException {
        zzapk zzapk;
        long j;
        while (!this.zzg) {
            int i = 0;
            try {
                long j2 = this.zzf.zza;
                zzatv zzatv = this.zzc;
                zzatx zzatx = r4;
                long j3 = j2;
                zzatx zzatx2 = new zzatx(this.zzb, (byte[]) null, j2, j2, -1, (String) null, 0);
                long zza2 = zzatv.zza(zzatx);
                this.zzj = zza2;
                if (zza2 != -1) {
                    j = j3;
                    zza2 += j;
                    this.zzj = zza2;
                } else {
                    j = j3;
                }
                zzapk = new zzapk(this.zzc, j, zza2);
                try {
                    zzapl zzb2 = this.zzd.zzb(zzapk, this.zzc.zzc());
                    if (this.zzh) {
                        zzb2.zze(j, this.zzi);
                        this.zzh = false;
                    }
                    long j4 = j;
                    int i2 = 0;
                    while (true) {
                        if (i2 != 0) {
                            break;
                        }
                        try {
                            if (this.zzg) {
                                i2 = 0;
                                break;
                            }
                            this.zze.zzc();
                            i2 = zzb2.zzg(zzapk, this.zzf);
                            if (zzapk.zzh() > this.zza.zzg + j4) {
                                j4 = zzapk.zzh();
                                this.zze.zzb();
                                this.zza.zzm.post(this.zza.zzl);
                            }
                        } catch (Throwable th) {
                            th = th;
                            i = i2;
                            this.zzf.zza = zzapk.zzh();
                            zzava.zzc(this.zzc);
                            throw th;
                        }
                    }
                    if (i2 != 1) {
                        this.zzf.zza = zzapk.zzh();
                        i = i2;
                    }
                    zzava.zzc(this.zzc);
                    if (i != 0) {
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.zzf.zza = zzapk.zzh();
                    zzava.zzc(this.zzc);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zzapk = null;
                if (!(i == 1 || zzapk == null)) {
                    this.zzf.zza = zzapk.zzh();
                }
                zzava.zzc(this.zzc);
                throw th;
            }
        }
    }
}
