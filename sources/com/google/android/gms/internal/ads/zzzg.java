package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzg {
    public final zzale zza = new zzale(0);
    public final zzakr zzb = new zzakr();
    public boolean zzc;
    public boolean zzd;
    public boolean zze;
    public long zzf = -9223372036854775807L;
    public long zzg = -9223372036854775807L;
    public long zzh = -9223372036854775807L;

    public zzzg(int i) {
    }

    private final int zze(zztb zztb) {
        zzakr zzakr = this.zzb;
        byte[] bArr = zzalh.zzf;
        int length = bArr.length;
        zzakr.zzb(bArr, 0);
        this.zzc = true;
        zztb.zzl();
        return 0;
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final int zzb(zztb zztb, zzts zzts, int i) throws IOException {
        if (i <= 0) {
            zze(zztb);
            return 0;
        }
        long j = -9223372036854775807L;
        if (!this.zze) {
            long zzo = zztb.zzo();
            int min = (int) Math.min(112800, zzo);
            long j2 = zzo - ((long) min);
            if (zztb.zzn() != j2) {
                zzts.zza = j2;
                return 1;
            }
            this.zzb.zza(min);
            zztb.zzl();
            ((zzsx) zztb).zzh(this.zzb.zzi(), 0, min, false);
            zzakr zzakr = this.zzb;
            int zzg2 = zzakr.zzg();
            int zze2 = zzakr.zze();
            while (true) {
                zze2--;
                if (zze2 < zzg2) {
                    break;
                } else if (zzakr.zzi()[zze2] == 71) {
                    long zzb2 = zzzq.zzb(zzakr, zze2, i);
                    if (zzb2 != -9223372036854775807L) {
                        j = zzb2;
                        break;
                    }
                }
            }
            this.zzg = j;
            this.zze = true;
            return 0;
        } else if (this.zzg == -9223372036854775807L) {
            zze(zztb);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(112800, zztb.zzo());
            if (zztb.zzn() != 0) {
                zzts.zza = 0;
                return 1;
            }
            this.zzb.zza(min2);
            zztb.zzl();
            ((zzsx) zztb).zzh(this.zzb.zzi(), 0, min2, false);
            zzakr zzakr2 = this.zzb;
            int zzg3 = zzakr2.zzg();
            int zze3 = zzakr2.zze();
            while (true) {
                if (zzg3 >= zze3) {
                    break;
                }
                if (zzakr2.zzi()[zzg3] == 71) {
                    long zzb3 = zzzq.zzb(zzakr2, zzg3, i);
                    if (zzb3 != -9223372036854775807L) {
                        j = zzb3;
                        break;
                    }
                }
                zzg3++;
            }
            this.zzf = j;
            this.zzd = true;
            return 0;
        } else {
            long j3 = this.zzf;
            if (j3 == -9223372036854775807L) {
                zze(zztb);
                return 0;
            }
            this.zzh = this.zza.zze(this.zzg) - this.zza.zze(j3);
            zze(zztb);
            return 0;
        }
    }

    public final long zzc() {
        return this.zzh;
    }

    public final zzale zzd() {
        return this.zza;
    }
}
