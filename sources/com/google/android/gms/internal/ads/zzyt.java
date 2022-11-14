package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyt implements zzzp {
    public final zzyc zza;
    public final zzakq zzb = new zzakq(new byte[10], 10);
    public int zzc = 0;
    public int zzd;
    public zzale zze;
    public boolean zzf;
    public boolean zzg;
    public boolean zzh;
    public int zzi;
    public int zzj;
    public boolean zzk;

    public zzyt(zzyc zzyc) {
        this.zza = zzyc;
    }

    private final void zzd(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zze(zzakr zzakr, @Nullable byte[] bArr, int i) {
        int min = Math.min(zzakr.zzd(), i - this.zzd);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            zzakr.zzk(min);
        } else {
            zzakr.zzm(bArr, this.zzd, min);
        }
        int i2 = this.zzd + min;
        this.zzd = i2;
        if (i2 == i) {
            return true;
        }
        return false;
    }

    public final void zza(zzale zzale, zztd zztd, zzzo zzzo) {
        this.zze = zzale;
        this.zza.zzb(zztd, zzzo);
    }

    public final void zzb() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zza();
    }

    public final void zzc(zzakr zzakr, int i) throws zzlg {
        int i2;
        long j;
        zzajg.zze(this.zze);
        int i3 = -1;
        int i4 = 2;
        if ((i & 1) != 0) {
            int i5 = this.zzc;
            if (!(i5 == 0 || i5 == 1)) {
                if (i5 != 2) {
                    int i6 = this.zzj;
                    if (i6 != -1) {
                        StringBuilder sb = new StringBuilder(59);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i6);
                        sb.append(" more bytes");
                        Log.w("PesReader", sb.toString());
                    }
                    this.zza.zze();
                } else {
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zzd(1);
        }
        while (zzakr.zzd() > 0) {
            int i7 = this.zzc;
            if (i7 != 0) {
                int i8 = 0;
                if (i7 != 1) {
                    if (i7 != i4) {
                        int zzd2 = zzakr.zzd();
                        int i9 = this.zzj;
                        if (i9 != i3) {
                            i8 = zzd2 - i9;
                        }
                        if (i8 > 0) {
                            zzd2 -= i8;
                            zzakr.zzf(zzakr.zzg() + zzd2);
                        }
                        this.zza.zzd(zzakr);
                        int i10 = this.zzj;
                        if (i10 != i3) {
                            int i11 = i10 - zzd2;
                            this.zzj = i11;
                            if (i11 == 0) {
                                this.zza.zze();
                                zzd(1);
                            }
                        }
                    } else {
                        if (zze(zzakr, this.zzb.zza, Math.min(10, this.zzi)) && zze(zzakr, (byte[]) null, this.zzi)) {
                            this.zzb.zzd(0);
                            if (this.zzf) {
                                this.zzb.zzf(4);
                                int zzh2 = this.zzb.zzh(3);
                                this.zzb.zzf(1);
                                int zzh3 = this.zzb.zzh(15);
                                this.zzb.zzf(1);
                                long zzh4 = (((long) zzh2) << 30) | ((long) (zzh3 << 15)) | ((long) this.zzb.zzh(15));
                                this.zzb.zzf(1);
                                if (!this.zzh && this.zzg) {
                                    this.zzb.zzf(4);
                                    int zzh5 = this.zzb.zzh(3);
                                    this.zzb.zzf(1);
                                    int zzh6 = this.zzb.zzh(15);
                                    this.zzb.zzf(1);
                                    int zzh7 = this.zzb.zzh(15);
                                    this.zzb.zzf(1);
                                    this.zze.zze(((long) (zzh6 << 15)) | (((long) zzh5) << 30) | ((long) zzh7));
                                    this.zzh = true;
                                }
                                j = this.zze.zze(zzh4);
                            } else {
                                j = -9223372036854775807L;
                            }
                            i |= true != this.zzk ? 0 : 4;
                            this.zza.zzc(j, i);
                            zzd(3);
                        }
                    }
                } else if (zze(zzakr, this.zzb.zza, 9)) {
                    int i12 = 0;
                    this.zzb.zzd(0);
                    int zzh8 = this.zzb.zzh(24);
                    if (zzh8 != 1) {
                        GeneratedOutlineSupport.outline29(41, "Unexpected start code prefix: ", zzh8, "PesReader");
                        i2 = -1;
                        this.zzj = -1;
                    } else {
                        this.zzb.zzf(8);
                        int zzh9 = this.zzb.zzh(16);
                        this.zzb.zzf(5);
                        this.zzk = this.zzb.zzg();
                        this.zzb.zzf(2);
                        this.zzf = this.zzb.zzg();
                        this.zzg = this.zzb.zzg();
                        this.zzb.zzf(6);
                        int zzh10 = this.zzb.zzh(8);
                        this.zzi = zzh10;
                        if (zzh9 == 0) {
                            this.zzj = -1;
                        } else {
                            int i13 = (zzh9 - 3) - zzh10;
                            this.zzj = i13;
                            if (i13 < 0) {
                                GeneratedOutlineSupport.outline29(47, "Found negative packet payload size: ", i13, "PesReader");
                                i2 = -1;
                                this.zzj = -1;
                                i12 = 2;
                            }
                        }
                        i2 = -1;
                        i12 = 2;
                    }
                    zzd(i12);
                    i3 = i2;
                }
                i3 = -1;
            } else {
                zzakr.zzk(zzakr.zzd());
            }
            i4 = 2;
        }
    }
}
