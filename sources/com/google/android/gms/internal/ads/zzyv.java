package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyv implements zzss {
    public final zzale zza;
    public final zzakr zzb = new zzakr();

    public /* synthetic */ zzyv(zzale zzale, zzyu zzyu) {
        this.zza = zzale;
    }

    public final zzsr zza(zztb zztb, long j) throws IOException {
        int zzh;
        long j2;
        long zzn = zztb.zzn();
        int min = (int) Math.min(20000, zztb.zzo() - zzn);
        this.zzb.zza(min);
        ((zzsx) zztb).zzh(this.zzb.zzi(), 0, min, false);
        zzakr zzakr = this.zzb;
        int i = -1;
        long j3 = -9223372036854775807L;
        int i2 = -1;
        while (zzakr.zzd() >= 4) {
            if (zzyw.zzh(zzakr.zzi(), zzakr.zzg()) != 442) {
                zzakr.zzk(1);
            } else {
                zzakr.zzk(4);
                long zze = zzyx.zze(zzakr);
                if (zze != -9223372036854775807L) {
                    long zze2 = this.zza.zze(zze);
                    if (zze2 > j) {
                        if (j3 == -9223372036854775807L) {
                            return zzsr.zza(zze2, zzn);
                        }
                        j2 = (long) i2;
                    } else if (100000 + zze2 > j) {
                        j2 = (long) zzakr.zzg();
                    } else {
                        i2 = zzakr.zzg();
                        j3 = zze2;
                    }
                    return zzsr.zzc(zzn + j2);
                }
                int zze3 = zzakr.zze();
                if (zzakr.zzd() >= 10) {
                    zzakr.zzk(9);
                    int zzn2 = zzakr.zzn() & 7;
                    if (zzakr.zzd() >= zzn2) {
                        zzakr.zzk(zzn2);
                        if (zzakr.zzd() >= 4) {
                            if (zzyw.zzh(zzakr.zzi(), zzakr.zzg()) == 443) {
                                zzakr.zzk(4);
                                int zzo = zzakr.zzo();
                                if (zzakr.zzd() < zzo) {
                                    zzakr.zzh(zze3);
                                } else {
                                    zzakr.zzk(zzo);
                                }
                            }
                            while (true) {
                                if (zzakr.zzd() < 4 || (zzh = zzyw.zzh(zzakr.zzi(), zzakr.zzg())) == 442 || zzh == 441 || (zzh >>> 8) != 1) {
                                    break;
                                }
                                zzakr.zzk(4);
                                if (zzakr.zzd() < 2) {
                                    zzakr.zzh(zze3);
                                    break;
                                }
                                zzakr.zzh(Math.min(zzakr.zze(), zzakr.zzg() + zzakr.zzo()));
                            }
                        } else {
                            zzakr.zzh(zze3);
                        }
                    } else {
                        zzakr.zzh(zze3);
                    }
                } else {
                    zzakr.zzh(zze3);
                }
                i = zzakr.zzg();
            }
        }
        return j3 != -9223372036854775807L ? zzsr.zzb(j3, zzn + ((long) i)) : zzsr.zza;
    }

    public final void zzb() {
        zzakr zzakr = this.zzb;
        byte[] bArr = zzalh.zzf;
        int length = bArr.length;
        zzakr.zzb(bArr, 0);
    }
}
