package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import com.playrix.gplay.billing.Base64;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxy implements zzyc {
    public static final byte[] zza = {73, 68, 51};
    public final boolean zzb;
    public final zzakq zzc = new zzakq(new byte[7], 7);
    public final zzakr zzd = new zzakr(Arrays.copyOf(zza, 10));
    @Nullable
    public final String zze;
    public String zzf;
    public zztz zzg;
    public zztz zzh;
    public int zzi;
    public int zzj;
    public int zzk;
    public boolean zzl;
    public boolean zzm;
    public int zzn;
    public int zzo;
    public int zzp;
    public boolean zzq;
    public long zzr;
    public int zzs;
    public long zzt;
    public zztz zzu;
    public long zzv;

    public zzxy(boolean z, @Nullable String str) {
        zzi();
        this.zzn = -1;
        this.zzo = -1;
        this.zzr = -9223372036854775807L;
        this.zzb = z;
        this.zze = str;
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzm = false;
        zzi();
    }

    private final boolean zzh(zzakr zzakr, byte[] bArr, int i) {
        int min = Math.min(zzakr.zzd(), i - this.zzj);
        zzakr.zzm(bArr, this.zzj, min);
        int i2 = this.zzj + min;
        this.zzj = i2;
        return i2 == i;
    }

    private final void zzi() {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 256;
    }

    private final void zzj(zztz zztz, long j, int i, int i2) {
        this.zzi = 4;
        this.zzj = i;
        this.zzu = zztz;
        this.zzv = j;
        this.zzs = i2;
    }

    private final void zzk() {
        this.zzi = 3;
        this.zzj = 0;
    }

    public static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & Base64.EQUALS_SIGN_ENC) | 65280);
    }

    public static final boolean zzm(zzakr zzakr, byte[] bArr, int i) {
        if (zzakr.zzd() < i) {
            return false;
        }
        zzakr.zzm(bArr, 0, i);
        return true;
    }

    public final void zza() {
        zzg();
    }

    public final void zzb(zztd zztd, zzzo zzzo) {
        zzzo.zza();
        this.zzf = zzzo.zzc();
        zztz zza2 = zztd.zza(zzzo.zzb(), 1);
        this.zzg = zza2;
        this.zzu = zza2;
        if (this.zzb) {
            zzzo.zza();
            zztz zza3 = zztd.zza(zzzo.zzb(), 5);
            this.zzh = zza3;
            zzkb zzkb = new zzkb();
            zzkb.zza(zzzo.zzc());
            zzkb.zzj("application/id3");
            zza3.zza(zzkb.zzD());
            return;
        }
        this.zzh = new zzsz();
    }

    public final void zzc(long j, int i) {
        this.zzt = j;
    }

    public final void zzd(zzakr zzakr) throws zzlg {
        int i;
        byte b;
        int i2;
        zzakr zzakr2 = zzakr;
        if (this.zzg != null) {
            int i3 = zzalh.zza;
            while (zzakr.zzd() > 0) {
                int i4 = this.zzi;
                int i5 = 13;
                int i6 = 2;
                if (i4 == 0) {
                    byte[] zzi2 = zzakr.zzi();
                    int zzg2 = zzakr.zzg();
                    int zze2 = zzakr.zze();
                    while (true) {
                        if (zzg2 >= zze2) {
                            zzakr2.zzh(zzg2);
                            break;
                        }
                        i = zzg2 + 1;
                        b = zzi2[zzg2] & Base64.EQUALS_SIGN_ENC;
                        if (this.zzk == 512 && zzl((byte) -1, (byte) b)) {
                            if (this.zzm) {
                                break;
                            }
                            int i7 = i - 2;
                            zzakr2.zzh(i7 + 1);
                            if (zzm(zzakr2, this.zzc.zza, 1)) {
                                this.zzc.zzd(4);
                                int zzh2 = this.zzc.zzh(1);
                                int i8 = this.zzn;
                                if (i8 == -1 || zzh2 == i8) {
                                    if (this.zzo != -1) {
                                        if (!zzm(zzakr2, this.zzc.zza, 1)) {
                                            break;
                                        }
                                        this.zzc.zzd(i6);
                                        if (this.zzc.zzh(4) == this.zzo) {
                                            zzakr2.zzh(i7 + 2);
                                        }
                                    }
                                    if (!zzm(zzakr2, this.zzc.zza, 4)) {
                                        break;
                                    }
                                    this.zzc.zzd(14);
                                    int zzh3 = this.zzc.zzh(i5);
                                    if (zzh3 >= 7) {
                                        byte[] zzi3 = zzakr.zzi();
                                        int zze3 = zzakr.zze();
                                        int i9 = i7 + zzh3;
                                        if (i9 >= zze3) {
                                            break;
                                        }
                                        if ((r8 = zzi3[i9]) != -1) {
                                        }
                                    }
                                }
                            }
                        }
                        int i10 = this.zzk;
                        byte b2 = i10 | b;
                        if (b2 == 329) {
                            i2 = 768;
                        } else if (b2 == 511) {
                            i2 = 512;
                        } else if (b2 != 836) {
                            if (b2 == 1075) {
                                this.zzi = 2;
                                this.zzj = 3;
                                this.zzs = 0;
                                this.zzd.zzh(0);
                                zzakr2.zzh(i);
                                break;
                            } else if (i10 != 256) {
                                this.zzk = 256;
                                zzg2 = i - 1;
                                i5 = 13;
                                i6 = 2;
                            } else {
                                zzg2 = i;
                                i5 = 13;
                                i6 = 2;
                            }
                        } else {
                            i2 = 1024;
                        }
                        this.zzk = i2;
                        zzg2 = i;
                        i5 = 13;
                        i6 = 2;
                    }
                    this.zzp = (b & 8) >> 3;
                    this.zzl = 1 == ((b & 1) ^ 1);
                    if (!this.zzm) {
                        this.zzi = 1;
                        this.zzj = 0;
                    } else {
                        zzk();
                    }
                    zzakr2.zzh(i);
                } else if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            int min = Math.min(zzakr.zzd(), this.zzs - this.zzj);
                            this.zzu.zzf(zzakr2, min);
                            int i11 = this.zzj + min;
                            this.zzj = i11;
                            int i12 = this.zzs;
                            if (i11 == i12) {
                                this.zzu.zzd(this.zzt, 1, i12, 0, (zzty) null);
                                this.zzt += this.zzv;
                                zzi();
                            }
                        } else {
                            if (zzh(zzakr2, this.zzc.zza, true != this.zzl ? 5 : 7)) {
                                this.zzc.zzd(0);
                                if (!this.zzq) {
                                    int zzh4 = this.zzc.zzh(2) + 1;
                                    if (zzh4 != 2) {
                                        StringBuilder sb = new StringBuilder(61);
                                        sb.append("Detected audio object type: ");
                                        sb.append(zzh4);
                                        sb.append(", but assuming AAC LC.");
                                        Log.w("AdtsReader", sb.toString());
                                    }
                                    this.zzc.zzf(5);
                                    int zzh5 = this.zzc.zzh(3);
                                    int i13 = this.zzo;
                                    byte[] bArr = {(byte) (((i13 >> 1) & 7) | 16), (byte) (((zzh5 << 3) & 120) | ((i13 << 7) & 128))};
                                    zzoy zza2 = zzoz.zza(bArr);
                                    zzkb zzkb = new zzkb();
                                    zzkb.zza(this.zzf);
                                    zzkb.zzj("audio/mp4a-latm");
                                    zzkb.zzh(zza2.zzc);
                                    zzkb.zzw(zza2.zzb);
                                    zzkb.zzx(zza2.zza);
                                    zzkb.zzl(Collections.singletonList(bArr));
                                    zzkb.zzd(this.zze);
                                    zzkc zzD = zzkb.zzD();
                                    this.zzr = 1024000000 / ((long) zzD.zzz);
                                    this.zzg.zza(zzD);
                                    this.zzq = true;
                                } else {
                                    this.zzc.zzf(10);
                                }
                                this.zzc.zzf(4);
                                int zzh6 = this.zzc.zzh(13) - 7;
                                if (this.zzl) {
                                    zzh6 -= 2;
                                }
                                zzj(this.zzg, this.zzr, 0, zzh6);
                            }
                        }
                    } else if (zzh(zzakr2, this.zzd.zzi(), 10)) {
                        this.zzh.zzf(this.zzd, 10);
                        this.zzd.zzh(6);
                        zzj(this.zzh, 0, 10, 10 + this.zzd.zzA());
                    }
                } else if (zzakr.zzd() != 0) {
                    this.zzc.zza[0] = zzakr.zzi()[zzakr.zzg()];
                    this.zzc.zzd(2);
                    int zzh7 = this.zzc.zzh(4);
                    int i14 = this.zzo;
                    if (i14 == -1 || zzh7 == i14) {
                        if (!this.zzm) {
                            this.zzm = true;
                            this.zzn = this.zzp;
                            this.zzo = zzh7;
                        }
                        zzk();
                    } else {
                        zzg();
                    }
                }
            }
            return;
        }
        throw null;
    }

    public final void zze() {
    }
}
