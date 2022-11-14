package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzum implements zzta {
    public static final zztg zza = zzul.zza;
    public final byte[] zzb;
    public final zzakr zzc;
    public final zzth zzd;
    public zztd zze;
    public zztz zzf;
    public int zzg;
    @Nullable
    public zzabe zzh;
    public zztn zzi;
    public int zzj;
    public int zzk;
    public zzuk zzl;
    public int zzm;
    public long zzn;

    public zzum() {
        this(0);
    }

    private final long zza(zzakr zzakr, boolean z) {
        boolean z2;
        if (this.zzi != null) {
            int zzg2 = zzakr.zzg();
            while (zzg2 <= zzakr.zze() - 16) {
                zzakr.zzh(zzg2);
                if (zzti.zza(zzakr, this.zzi, this.zzk, this.zzd)) {
                    zzakr.zzh(zzg2);
                    return this.zzd.zza;
                }
                zzg2++;
            }
            if (z) {
                while (zzg2 <= zzakr.zze() - this.zzj) {
                    zzakr.zzh(zzg2);
                    try {
                        z2 = zzti.zza(zzakr, this.zzi, this.zzk, this.zzd);
                    } catch (IndexOutOfBoundsException unused) {
                        z2 = false;
                    }
                    if (zzakr.zzg() <= zzakr.zze() && z2) {
                        zzakr.zzh(zzg2);
                        return this.zzd.zza;
                    }
                    zzg2++;
                }
                zzakr.zzh(zzakr.zze());
                return -1;
            }
            zzakr.zzh(zzg2);
            return -1;
        }
        throw null;
    }

    private final void zzb() {
        long j = this.zzn;
        zztn zztn = this.zzi;
        int i = zzalh.zza;
        this.zzf.zzd((j * 1000000) / ((long) zztn.zze), 1, this.zzm, 0, (zzty) null);
    }

    public final boolean zzd(zztb zztb) throws IOException {
        zztk.zza(zztb, false);
        zzakr zzakr = new zzakr(4);
        ((zzsx) zztb).zzh(zzakr.zzi(), 0, 4, false);
        if (zzakr.zzt() == 1716281667) {
            return true;
        }
        return false;
    }

    public final void zze(zztd zztd) {
        this.zze = zztd;
        this.zzf = zztd.zza(0, 1);
        zztd.zzbl();
    }

    public final int zzf(zztb zztb, zzts zzts) throws IOException {
        boolean zzg2;
        zztn zztn;
        zztv zztv;
        zztb zztb2 = zztb;
        int i = this.zzg;
        boolean z = true;
        if (i == 0) {
            zztb.zzl();
            long zzm2 = zztb.zzm();
            zzabe zza2 = zztk.zza(zztb2, true);
            ((zzsx) zztb2).zze((int) (zztb.zzm() - zzm2), false);
            this.zzh = zza2;
            this.zzg = 1;
            return 0;
        } else if (i == 1) {
            ((zzsx) zztb2).zzh(this.zzb, 0, 42, false);
            zztb.zzl();
            this.zzg = 2;
            return 0;
        } else if (i == 2) {
            zzakr zzakr = new zzakr(4);
            ((zzsx) zztb2).zzb(zzakr.zzi(), 0, 4, false);
            if (zzakr.zzt() == 1716281667) {
                this.zzg = 3;
                return 0;
            }
            throw new zzlg("Failed to read FLAC stream marker.", (Throwable) null);
        } else if (i == 3) {
            zztj zztj = new zztj(this.zzi);
            do {
                zztb.zzl();
                zzakq zzakq = new zzakq(new byte[4], 4);
                zzsx zzsx = (zzsx) zztb2;
                zzsx.zzh(zzakq.zza, 0, 4, false);
                zzg2 = zzakq.zzg();
                int zzh2 = zzakq.zzh(7);
                int zzh3 = zzakq.zzh(24) + 4;
                if (zzh2 == 0) {
                    byte[] bArr = new byte[38];
                    zzsx.zzb(bArr, 0, 38, false);
                    zztj.zza = new zztn(bArr, 4);
                } else {
                    zztn zztn2 = zztj.zza;
                    if (zztn2 == null) {
                        throw new IllegalArgumentException();
                    } else if (zzh2 == 3) {
                        zzakr zzakr2 = new zzakr(zzh3);
                        zzsx.zzb(zzakr2.zzi(), 0, zzh3, false);
                        zztj.zza = zztn2.zze(zztk.zzb(zzakr2));
                    } else if (zzh2 == 4) {
                        zzakr zzakr3 = new zzakr(zzh3);
                        zzsx.zzb(zzakr3.zzi(), 0, zzh3, false);
                        zzakr3.zzk(4);
                        zztj.zza = zztn2.zzf(Arrays.asList(zzue.zzb(zzakr3, false, false).zzb));
                    } else if (zzh2 == 6) {
                        zzakr zzakr4 = new zzakr(zzh3);
                        zzsx.zzb(zzakr4.zzi(), 0, zzh3, false);
                        zzakr4.zzk(4);
                        int zzv = zzakr4.zzv();
                        String zzE = zzakr4.zzE(zzakr4.zzv(), zzfjs.zza);
                        String zzE2 = zzakr4.zzE(zzakr4.zzv(), zzfjs.zzc);
                        int zzv2 = zzakr4.zzv();
                        int zzv3 = zzakr4.zzv();
                        int zzv4 = zzakr4.zzv();
                        int zzv5 = zzakr4.zzv();
                        int zzv6 = zzakr4.zzv();
                        byte[] bArr2 = new byte[zzv6];
                        zzakr4.zzm(bArr2, 0, zzv6);
                        zztj.zza = zztn2.zzg(Collections.singletonList(new zzabl(zzv, zzE, zzE2, zzv2, zzv3, zzv4, zzv5, bArr2)));
                    } else {
                        zzsx.zze(zzh3, false);
                    }
                }
                zztn = zztj.zza;
                int i2 = zzalh.zza;
                this.zzi = zztn;
            } while (!zzg2);
            if (zztn != null) {
                this.zzj = Math.max(zztn.zzc, 6);
                this.zzf.zza(this.zzi.zzc(this.zzb, this.zzh));
                this.zzg = 4;
                return 0;
            }
            throw null;
        } else if (i == 4) {
            zztb.zzl();
            zzakr zzakr5 = new zzakr(2);
            ((zzsx) zztb2).zzh(zzakr5.zzi(), 0, 2, false);
            int zzo = zzakr5.zzo();
            if ((zzo >> 2) == 16382) {
                zztb.zzl();
                this.zzk = zzo;
                zztd zztd = this.zze;
                int i3 = zzalh.zza;
                long zzn2 = zztb.zzn();
                long zzo2 = zztb.zzo();
                zztn zztn3 = this.zzi;
                if (zztn3 != null) {
                    if (zztn3.zzk != null) {
                        zztv = new zztl(zztn3, zzn2);
                    } else if (zzo2 == -1 || zztn3.zzj <= 0) {
                        zztv = new zztu(zztn3.zza(), 0);
                    } else {
                        zzuk zzuk = new zzuk(zztn3, this.zzk, zzn2, zzo2);
                        this.zzl = zzuk;
                        zztv = zzuk.zza();
                    }
                    zztd.zzbm(zztv);
                    this.zzg = 5;
                    return 0;
                }
                throw null;
            }
            zztb.zzl();
            throw new zzlg("First frame does not start with sync code.", (Throwable) null);
        } else if (this.zzf == null) {
            throw null;
        } else if (this.zzi != null) {
            zzuk zzuk2 = this.zzl;
            if (zzuk2 != null && zzuk2.zzc()) {
                return this.zzl.zzd(zztb2, zzts);
            }
            if (this.zzn == -1) {
                this.zzn = zzti.zzb(zztb2, this.zzi);
                return 0;
            }
            int zze2 = this.zzc.zze();
            if (zze2 < 32768) {
                int zza3 = zztb2.zza(this.zzc.zzi(), zze2, 32768 - zze2);
                if (zza3 != -1) {
                    z = false;
                }
                if (!z) {
                    this.zzc.zzf(zze2 + zza3);
                } else if (this.zzc.zzd() == 0) {
                    zzb();
                    return -1;
                }
            } else {
                z = false;
            }
            int zzg3 = this.zzc.zzg();
            int i4 = this.zzm;
            int i5 = this.zzj;
            if (i4 < i5) {
                zzakr zzakr6 = this.zzc;
                zzakr6.zzk(Math.min(i5 - i4, zzakr6.zzd()));
            }
            long zza4 = zza(this.zzc, z);
            int zzg4 = this.zzc.zzg() - zzg3;
            this.zzc.zzh(zzg3);
            zztx.zzb(this.zzf, this.zzc, zzg4);
            this.zzm += zzg4;
            if (zza4 != -1) {
                zzb();
                this.zzm = 0;
                this.zzn = zza4;
            }
            if (this.zzc.zzd() >= 16) {
                return 0;
            }
            int zzd2 = this.zzc.zzd();
            System.arraycopy(this.zzc.zzi(), this.zzc.zzg(), this.zzc.zzi(), 0, zzd2);
            this.zzc.zzh(0);
            this.zzc.zzf(zzd2);
            return 0;
        } else {
            throw null;
        }
    }

    public final void zzg(long j, long j2) {
        long j3 = 0;
        if (j == 0) {
            this.zzg = 0;
        } else {
            zzuk zzuk = this.zzl;
            if (zzuk != null) {
                zzuk.zzb(j2);
            }
        }
        if (j2 != 0) {
            j3 = -1;
        }
        this.zzn = j3;
        this.zzm = 0;
        this.zzc.zza(0);
    }

    public zzum(int i) {
        this.zzb = new byte[42];
        this.zzc = new zzakr(new byte[32768], 0);
        this.zzd = new zzth();
        this.zzg = 0;
    }
}
