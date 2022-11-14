package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaow {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final short[] zzf;
    public int zzg;
    public short[] zzh;
    public int zzi;
    public short[] zzj;
    public int zzk;
    public short[] zzl;
    public int zzm = 0;
    public int zzn = 0;
    public float zzo = 1.0f;
    public float zzp = 1.0f;
    public int zzq;
    public int zzr;
    public int zzs;
    public int zzt;
    public int zzu = 0;
    public int zzv;
    public int zzw;
    public int zzx;

    public zzaow(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i / 400;
        int i3 = i / 65;
        this.zzd = i3;
        int i4 = i3 + i3;
        this.zze = i4;
        this.zzf = new short[i4];
        this.zzg = i4;
        int i5 = i2 * i4;
        this.zzh = new short[i5];
        this.zzi = i4;
        this.zzj = new short[i5];
        this.zzk = i4;
        this.zzl = new short[i5];
    }

    private final void zzg(int i) {
        int i2 = this.zzr;
        int i3 = this.zzi;
        if (i2 + i > i3) {
            int i4 = (i3 / 2) + i + i3;
            this.zzi = i4;
            this.zzj = Arrays.copyOf(this.zzj, i4 * this.zzb);
        }
    }

    private final void zzh(int i) {
        int i2 = this.zzq;
        int i3 = this.zzg;
        if (i2 + i > i3) {
            int i4 = (i3 / 2) + i + i3;
            this.zzg = i4;
            this.zzh = Arrays.copyOf(this.zzh, i4 * this.zzb);
        }
    }

    private final void zzi(short[] sArr, int i, int i2) {
        zzg(i2);
        int i3 = this.zzb;
        System.arraycopy(sArr, i * i3, this.zzj, this.zzr * i3, i3 * i2);
        this.zzr += i2;
    }

    private final void zzj(short[] sArr, int i, int i2) {
        int i3 = this.zze / i2;
        int i4 = this.zzb;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.zzf[i7] = (short) (i8 / i5);
        }
    }

    private final int zzk(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.zzb;
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            int i11 = i9 * i7;
            int i12 = i5 * i2;
            if (i11 < i12) {
                i5 = i9;
            }
            if (i11 < i12) {
                i7 = i2;
            }
            int i13 = i9 * i6;
            int i14 = i8 * i2;
            if (i13 > i14) {
                i8 = i9;
            }
            if (i13 > i14) {
                i6 = i2;
            }
            i2++;
        }
        this.zzw = i5 / i7;
        this.zzx = i8 / i6;
        return i7;
    }

    private final void zzl() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = this.zzr;
        float f = this.zzo / this.zzp;
        double d = (double) f;
        int i10 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i11 = this.zzq;
            if (i11 >= this.zze) {
                int i12 = 0;
                while (true) {
                    int i13 = this.zzt;
                    if (i13 > 0) {
                        int min = Math.min(this.zze, i13);
                        zzi(this.zzh, i12, min);
                        this.zzt -= min;
                        i12 += min;
                    } else {
                        short[] sArr = this.zzh;
                        int i14 = this.zza;
                        int i15 = i14 > 4000 ? i14 / 4000 : 1;
                        if (this.zzb == i10 && i15 == i10) {
                            i5 = zzk(sArr, i12, this.zzc, this.zzd);
                        } else {
                            zzj(sArr, i12, i15);
                            int zzk2 = zzk(this.zzf, 0, this.zzc / i15, this.zzd / i15);
                            if (i15 != i10) {
                                int i16 = zzk2 * i15;
                                int i17 = i15 * 4;
                                int i18 = i16 - i17;
                                int i19 = i16 + i17;
                                int i20 = this.zzc;
                                if (i18 < i20) {
                                    i18 = i20;
                                }
                                int i21 = this.zzd;
                                if (i19 > i21) {
                                    i19 = i21;
                                }
                                if (this.zzb == i10) {
                                    i5 = zzk(sArr, i12, i18, i19);
                                } else {
                                    zzj(sArr, i12, i10);
                                    i5 = zzk(this.zzf, 0, i18, i19);
                                }
                            } else {
                                i5 = zzk2;
                            }
                        }
                        int i22 = this.zzw;
                        int i23 = (i22 == 0 || (i8 = this.zzu) == 0 || this.zzx > i22 * 3 || i22 + i22 <= this.zzv * 3) ? i5 : i8;
                        this.zzv = i22;
                        this.zzu = i5;
                        if (d > 1.0d) {
                            short[] sArr2 = this.zzh;
                            if (f >= 2.0f) {
                                i7 = (int) (((float) i23) / (-1.0f + f));
                            } else {
                                this.zzt = (int) (((2.0f - f) * ((float) i23)) / (-1.0f + f));
                                i7 = i23;
                            }
                            zzg(i7);
                            int i24 = i7;
                            zzm(i7, this.zzb, this.zzj, this.zzr, sArr2, i12, sArr2, i12 + i23);
                            this.zzr += i24;
                            i12 = i23 + i24 + i12;
                        } else {
                            int i25 = i23;
                            short[] sArr3 = this.zzh;
                            if (f < 0.5f) {
                                i6 = (int) ((((float) i25) * f) / (1.0f - f));
                            } else {
                                this.zzt = (int) ((((f + f) - 4.0f) * ((float) i25)) / (1.0f - f));
                                i6 = i25;
                            }
                            int i26 = i25 + i6;
                            zzg(i26);
                            int i27 = this.zzb;
                            System.arraycopy(sArr3, i12 * i27, this.zzj, this.zzr * i27, i27 * i25);
                            zzm(i6, this.zzb, this.zzj, this.zzr + i25, sArr3, i25 + i12, sArr3, i12);
                            this.zzr += i26;
                            i12 += i6;
                        }
                    }
                    if (this.zze + i12 > i11) {
                        break;
                    }
                    i10 = 1;
                }
                int i28 = this.zzq - i12;
                short[] sArr4 = this.zzh;
                int i29 = this.zzb;
                System.arraycopy(sArr4, i12 * i29, sArr4, 0, i29 * i28);
                this.zzq = i28;
            }
        } else {
            zzi(this.zzh, 0, this.zzq);
            this.zzq = 0;
        }
        float f2 = this.zzp;
        if (f2 != 1.0f && this.zzr != i9) {
            int i30 = this.zza;
            int i31 = (int) (((float) i30) / f2);
            while (true) {
                if (i31 <= 16384 && i30 <= 16384) {
                    break;
                }
                i31 /= 2;
                i30 /= 2;
            }
            int i32 = this.zzr - i9;
            int i33 = this.zzs;
            int i34 = this.zzk;
            if (i33 + i32 > i34) {
                int i35 = (i34 / 2) + i32 + i34;
                this.zzk = i35;
                this.zzl = Arrays.copyOf(this.zzl, i35 * this.zzb);
            }
            short[] sArr5 = this.zzj;
            int i36 = this.zzb;
            System.arraycopy(sArr5, i9 * i36, this.zzl, this.zzs * i36, i36 * i32);
            this.zzr = i9;
            this.zzs += i32;
            int i37 = 0;
            while (true) {
                i = this.zzs;
                i2 = i - 1;
                if (i37 >= i2) {
                    break;
                }
                while (true) {
                    i3 = this.zzm + 1;
                    i4 = this.zzn;
                    if (i3 * i31 <= i4 * i30) {
                        break;
                    }
                    zzg(1);
                    int i38 = 0;
                    while (true) {
                        int i39 = this.zzb;
                        if (i38 >= i39) {
                            break;
                        }
                        short[] sArr6 = this.zzj;
                        int i40 = this.zzr;
                        short[] sArr7 = this.zzl;
                        int i41 = (i37 * i39) + i38;
                        short s = sArr7[i41];
                        short s2 = sArr7[i41 + i39];
                        int i42 = this.zzn;
                        int i43 = this.zzm;
                        int i44 = (i43 + 1) * i31;
                        int i45 = i44 - (i42 * i30);
                        int i46 = i44 - (i43 * i31);
                        sArr6[(i40 * i39) + i38] = (short) ((((i46 - i45) * s2) + (s * i45)) / i46);
                        i38++;
                    }
                    this.zzn++;
                    this.zzr++;
                }
                this.zzm = i3;
                if (i3 == i30) {
                    this.zzm = 0;
                    zzaul.zzd(i4 == i31);
                    this.zzn = 0;
                }
                i37++;
            }
            if (i2 != 0) {
                short[] sArr8 = this.zzl;
                int i47 = this.zzb;
                System.arraycopy(sArr8, i2 * i47, sArr8, 0, (i - i2) * i47);
                this.zzs -= i2;
            }
        }
    }

    public static void zzm(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr3[i8] * i10) + ((i - i10) * sArr2[i9])) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    public final void zza(float f) {
        this.zzo = f;
    }

    public final void zzb(float f) {
        this.zzp = f;
    }

    public final void zzc(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzb;
        int i2 = remaining / i;
        int i3 = i * i2;
        zzh(i2);
        shortBuffer.get(this.zzh, this.zzq * this.zzb, (i3 + i3) / 2);
        this.zzq += i2;
        zzl();
    }

    public final void zzd(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzb, this.zzr);
        shortBuffer.put(this.zzj, 0, this.zzb * min);
        int i = this.zzr - min;
        this.zzr = i;
        short[] sArr = this.zzj;
        int i2 = this.zzb;
        System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    public final void zze() {
        int i;
        int i2 = this.zzq;
        float f = this.zzo;
        float f2 = this.zzp;
        int i3 = this.zzr + ((int) ((((((float) i2) / (f / f2)) + ((float) this.zzs)) / f2) + 0.5f));
        int i4 = this.zze;
        zzh(i4 + i4 + i2);
        int i5 = 0;
        while (true) {
            int i6 = this.zze;
            i = i6 + i6;
            int i7 = this.zzb;
            if (i5 >= i * i7) {
                break;
            }
            this.zzh[(i7 * i2) + i5] = 0;
            i5++;
        }
        this.zzq += i;
        zzl();
        if (this.zzr > i3) {
            this.zzr = i3;
        }
        this.zzq = 0;
        this.zzt = 0;
        this.zzs = 0;
    }

    public final int zzf() {
        return this.zzr;
    }
}
