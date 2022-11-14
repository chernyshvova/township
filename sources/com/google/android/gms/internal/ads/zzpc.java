package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import com.playrix.gplay.billing.Base64;
import com.unity3d.services.banners.UnityBannerSize;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzpc {
    public static final /* synthetic */ int zza = 0;
    public static final int[] zzb = {1, 2, 3, 6};
    public static final int[] zzc = {48000, 44100, 32000};
    public static final int[] zzd = {24000, 22050, 16000};
    public static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    public static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, DrawerLayout.PEEK_DELAY, 192, 224, 256, UnityBannerSize.BannerSize.STANDARD_WIDTH, 384, 448, 512, 576, 640};
    public static final int[] zzg = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzkc zza(zzakr zzakr, String str, String str2, @Nullable zzsa zzsa) {
        int i = zzc[(zzakr.zzn() & 192) >> 6];
        int zzn = zzakr.zzn();
        int i2 = zze[(zzn & 56) >> 3];
        if ((zzn & 4) != 0) {
            i2++;
        }
        zzkb zzkb = new zzkb();
        zzkb.zza(str);
        zzkb.zzj("audio/ac3");
        zzkb.zzw(i2);
        zzkb.zzx(i);
        zzkb.zzm(zzsa);
        zzkb.zzd(str2);
        return zzkb.zzD();
    }

    public static zzkc zzb(zzakr zzakr, String str, String str2, @Nullable zzsa zzsa) {
        zzakr.zzk(2);
        int i = zzc[(zzakr.zzn() & 192) >> 6];
        int zzn = zzakr.zzn();
        int i2 = zze[(zzn & 14) >> 1];
        if ((zzn & 1) != 0) {
            i2++;
        }
        if (((zzakr.zzn() & 30) >> 1) > 0 && (2 & zzakr.zzn()) != 0) {
            i2 += 2;
        }
        String str3 = (zzakr.zzd() <= 0 || (zzakr.zzn() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc";
        zzkb zzkb = new zzkb();
        zzkb.zza(str);
        zzkb.zzj(str3);
        zzkb.zzw(i2);
        zzkb.zzx(i);
        zzkb.zzm(zzsa);
        zzkb.zzd(str2);
        return zzkb.zzD();
    }

    public static zzpb zzc(zzakq zzakq) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        zzakq zzakq2 = zzakq;
        int zzc2 = zzakq.zzc();
        zzakq2.zzf(40);
        int zzh = zzakq2.zzh(5);
        zzakq2.zzd(zzc2);
        int i12 = -1;
        if (zzh > 10) {
            zzakq2.zzf(16);
            int zzh2 = zzakq2.zzh(2);
            if (zzh2 == 0) {
                i12 = 0;
            } else if (zzh2 == 1) {
                i12 = 1;
            } else if (zzh2 == 2) {
                i12 = 2;
            }
            zzakq2.zzf(3);
            int zzh3 = zzakq2.zzh(11) + 1;
            int i13 = zzh3 + zzh3;
            int zzh4 = zzakq2.zzh(2);
            if (zzh4 == 3) {
                i6 = zzd[zzakq2.zzh(2)];
                i8 = 3;
                i7 = 6;
            } else {
                i8 = zzakq2.zzh(2);
                i7 = zzb[i8];
                i6 = zzc[zzh4];
            }
            int i14 = i7 * 256;
            int zzh5 = zzakq2.zzh(3);
            boolean zzg2 = zzakq.zzg();
            int i15 = zze[zzh5] + (zzg2 ? 1 : 0);
            zzakq2.zzf(10);
            if (zzakq.zzg()) {
                zzakq2.zzf(8);
            }
            if (zzh5 == 0) {
                zzakq2.zzf(5);
                if (zzakq.zzg()) {
                    zzakq2.zzf(8);
                }
                i9 = 0;
                zzh5 = 0;
            } else {
                i9 = zzh5;
            }
            if (i12 == 1) {
                if (zzakq.zzg()) {
                    zzakq2.zzf(16);
                }
                i10 = 1;
            } else {
                i10 = i12;
            }
            if (zzakq.zzg()) {
                if (i9 > 2) {
                    zzakq2.zzf(2);
                }
                if ((i9 & 1) != 0 && i9 > 2) {
                    zzakq2.zzf(6);
                }
                if ((i9 & 4) != 0) {
                    zzakq2.zzf(6);
                }
                if (zzg2 && zzakq.zzg()) {
                    zzakq2.zzf(5);
                }
                if (i10 == 0) {
                    if (zzakq.zzg()) {
                        zzakq2.zzf(6);
                    }
                    if (i9 == 0 && zzakq.zzg()) {
                        zzakq2.zzf(6);
                    }
                    if (zzakq.zzg()) {
                        zzakq2.zzf(6);
                    }
                    int zzh6 = zzakq2.zzh(2);
                    if (zzh6 == 1) {
                        zzakq2.zzf(5);
                    } else if (zzh6 == 2) {
                        zzakq2.zzf(12);
                    } else if (zzh6 == 3) {
                        int zzh7 = zzakq2.zzh(5);
                        if (zzakq.zzg()) {
                            zzakq2.zzf(5);
                            if (zzakq.zzg()) {
                                zzakq2.zzf(4);
                            }
                            if (zzakq.zzg()) {
                                zzakq2.zzf(4);
                            }
                            if (zzakq.zzg()) {
                                zzakq2.zzf(4);
                            }
                            if (zzakq.zzg()) {
                                zzakq2.zzf(4);
                            }
                            if (zzakq.zzg()) {
                                zzakq2.zzf(4);
                            }
                            if (zzakq.zzg()) {
                                zzakq2.zzf(4);
                            }
                            if (zzakq.zzg()) {
                                zzakq2.zzf(4);
                            }
                            if (zzakq.zzg()) {
                                if (zzakq.zzg()) {
                                    zzakq2.zzf(4);
                                }
                                if (zzakq.zzg()) {
                                    zzakq2.zzf(4);
                                }
                            }
                        }
                        if (zzakq.zzg()) {
                            zzakq2.zzf(5);
                            if (zzakq.zzg()) {
                                zzakq2.zzf(7);
                                if (zzakq.zzg()) {
                                    zzakq2.zzf(8);
                                    zzakq2.zzf((zzh7 + 2) * 8);
                                    zzakq.zzj();
                                }
                            }
                        }
                        zzakq2.zzf((zzh7 + 2) * 8);
                        zzakq.zzj();
                    }
                    if (i9 < 2) {
                        if (zzakq.zzg()) {
                            zzakq2.zzf(14);
                        }
                        if (zzh5 == 0 && zzakq.zzg()) {
                            zzakq2.zzf(14);
                        }
                    }
                    if (zzakq.zzg()) {
                        if (i8 == 0) {
                            zzakq2.zzf(5);
                            i10 = 0;
                            i8 = 0;
                        } else {
                            for (int i16 = 0; i16 < i7; i16++) {
                                if (zzakq.zzg()) {
                                    zzakq2.zzf(5);
                                }
                            }
                        }
                    }
                    i10 = 0;
                }
            }
            if (zzakq.zzg()) {
                zzakq2.zzf(5);
                if (i9 == 2) {
                    zzakq2.zzf(4);
                    i9 = 2;
                }
                if (i9 >= 6) {
                    zzakq2.zzf(2);
                }
                if (zzakq.zzg()) {
                    i11 = 8;
                    zzakq2.zzf(8);
                } else {
                    i11 = 8;
                }
                if (i9 == 0 && zzakq.zzg()) {
                    zzakq2.zzf(i11);
                }
                if (zzh4 < 3) {
                    zzakq.zze();
                }
            }
            if (i10 == 0 && i8 != 3) {
                zzakq.zze();
            }
            if (i10 == 2 && (i8 == 3 || zzakq.zzg())) {
                zzakq2.zzf(6);
            }
            str = (zzakq.zzg() && zzakq2.zzh(6) == 1 && zzakq2.zzh(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i5 = i12;
            i2 = i13;
            i = i14;
            i3 = i6;
            i4 = i15;
        } else {
            zzakq2.zzf(32);
            int zzh8 = zzakq2.zzh(2);
            String str2 = zzh8 == 3 ? null : "audio/ac3";
            int zze2 = zze(zzh8, zzakq2.zzh(6));
            zzakq2.zzf(8);
            int zzh9 = zzakq2.zzh(3);
            if (!((zzh9 & 1) == 0 || zzh9 == 1)) {
                zzakq2.zzf(2);
            }
            if ((zzh9 & 4) != 0) {
                zzakq2.zzf(2);
            }
            if (zzh9 == 2) {
                zzakq2.zzf(2);
            }
            str = str2;
            i2 = zze2;
            i3 = zzh8 < 3 ? zzc[zzh8] : -1;
            i4 = zze[zzh9] + (zzakq.zzg() ? 1 : 0);
            i5 = -1;
            i = 1536;
        }
        return new zzpb(str, i5, i4, i3, i2, i, (zzpa) null);
    }

    public static int zzd(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            int i = ((bArr[3] & Base64.EQUALS_SIGN_ENC) | ((bArr[2] & 7) << 8)) + 1;
            return i + i;
        }
        byte b = bArr[4];
        return zze((b & 192) >> 6, b & 63);
    }

    public static int zze(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= 3 || i2 < 0 || i3 >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
