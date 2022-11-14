package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzky {
    public final zzms zza = new zzms();
    public final zzmu zzb = new zzmu();
    @Nullable
    public final zzou zzc;
    public final Handler zzd;
    public long zze;
    public int zzf;
    public boolean zzg;
    @Nullable
    public zzkv zzh;
    @Nullable
    public zzkv zzi;
    @Nullable
    public zzkv zzj;
    public int zzk;
    @Nullable
    public Object zzl;
    public long zzm;

    public zzky(@Nullable zzou zzou, Handler handler) {
        this.zzc = zzou;
        this.zzd = handler;
    }

    private final boolean zzA(zzmv zzmv, zzadv zzadv, boolean z) {
        int zzh2 = zzmv.zzh(zzadv.zza);
        if (!zzmv.zze(zzmv.zzg(zzh2, this.zza, false).zzc, this.zzb, 0).zzh) {
            if (zzmv.zzu(zzh2, this.zza, this.zzb, this.zzf, this.zzg) != -1 || !z) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final long zzB(zzmv zzmv, Object obj, int i) {
        zzmv.zzf(obj, this.zza);
        long zzb2 = this.zza.zzb(i);
        if (zzb2 == Long.MIN_VALUE) {
            return this.zza.zzd;
        }
        return this.zza.zzk(i) + zzb2;
    }

    public static final boolean zzC(zzadv zzadv) {
        return !zzadv.zzb() && zzadv.zze == -1;
    }

    private final void zzs() {
        zzadv zzadv;
        if (this.zzc != null) {
            zzfmi zzu = zzfml.zzu();
            for (zzkv zzkv = this.zzh; zzkv != null; zzkv = zzkv.zzo()) {
                zzu.zze(zzkv.zzf.zza);
            }
            zzkv zzkv2 = this.zzi;
            if (zzkv2 == null) {
                zzadv = null;
            } else {
                zzadv = zzkv2.zzf.zza;
            }
            this.zzd.post(new zzkx(this, zzu, zzadv));
        }
    }

    public static zzadv zzt(zzmv zzmv, Object obj, long j, long j2, zzms zzms) {
        zzmv.zzf(obj, zzms);
        zzms.zze(j);
        return new zzadv(obj, j2, zzms.zzf(j));
    }

    private final boolean zzu(zzmv zzmv) {
        zzkv zzkv = this.zzh;
        if (zzkv == null) {
            return true;
        }
        int zzh2 = zzmv.zzh(zzkv.zzb);
        while (true) {
            zzh2 = zzmv.zzu(zzh2, this.zza, this.zzb, this.zzf, this.zzg);
            while (zzkv.zzo() != null && !zzkv.zzf.zzg) {
                zzkv = zzkv.zzo();
            }
            zzkv zzo = zzkv.zzo();
            if (zzh2 == -1 || zzo == null || zzmv.zzh(zzo.zzb) != zzh2) {
                boolean zzl2 = zzl(zzkv);
                zzkv.zzf = zzo(zzmv, zzkv.zzf);
            } else {
                zzkv = zzo;
            }
        }
        boolean zzl22 = zzl(zzkv);
        zzkv.zzf = zzo(zzmv, zzkv.zzf);
        if (!zzl22) {
            return true;
        }
        return false;
    }

    @Nullable
    private final zzkw zzv(zzmv zzmv, zzkv zzkv, long j) {
        long j2;
        zzmv zzmv2 = zzmv;
        zzkw zzkw = zzkv.zzf;
        long zza2 = (zzkv.zza() + zzkw.zze) - j;
        if (zzkw.zzg) {
            long j3 = 0;
            int zzu = zzmv.zzu(zzmv2.zzh(zzkw.zza.zza), this.zza, this.zzb, this.zzf, this.zzg);
            if (zzu == -1) {
                return null;
            }
            int i = zzmv2.zzg(zzu, this.zza, true).zzc;
            Object obj = this.zza.zzb;
            long j4 = zzkw.zza.zzd;
            if (zzmv2.zze(i, this.zzb, 0).zzn == zzu) {
                Pair<Object, Long> zzw = zzmv.zzw(this.zzb, this.zza, i, -9223372036854775807L, Math.max(0, zza2));
                if (zzw == null) {
                    return null;
                }
                obj = zzw.first;
                long longValue = ((Long) zzw.second).longValue();
                zzkv zzo = zzkv.zzo();
                if (zzo == null || !zzo.zzb.equals(obj)) {
                    j4 = this.zze;
                    this.zze = 1 + j4;
                } else {
                    j4 = zzo.zzf.zza.zzd;
                }
                j2 = longValue;
                j3 = -9223372036854775807L;
            } else {
                j2 = 0;
            }
            return zzw(zzmv, zzt(zzmv, obj, j2, j4, this.zza), j3, j2);
        }
        zzadv zzadv = zzkw.zza;
        zzmv2.zzf(zzadv.zza, this.zza);
        if (zzadv.zzb()) {
            int i2 = zzadv.zzb;
            int zzg2 = this.zza.zzg(i2);
            if (zzg2 == -1) {
                return null;
            }
            int zzd2 = this.zza.zzd(i2, -1);
            if (zzd2 < zzg2) {
                return zzx(zzmv, zzadv.zza, i2, zzd2, zzkw.zzc, zzadv.zzd);
            }
            long j5 = zzkw.zzc;
            if (j5 == -9223372036854775807L) {
                zzmu zzmu = this.zzb;
                zzms zzms = this.zza;
                Pair<Object, Long> zzw2 = zzmv.zzw(zzmu, zzms, zzms.zzc, -9223372036854775807L, Math.max(0, zza2));
                if (zzw2 == null) {
                    return null;
                }
                j5 = ((Long) zzw2.second).longValue();
            }
            return zzy(zzmv, zzadv.zza, Math.max(zzB(zzmv2, zzadv.zza, zzadv.zzb), j5), zzkw.zzc, zzadv.zzd);
        }
        int zzc2 = this.zza.zzc(zzadv.zze);
        if (zzc2 == this.zza.zzg(zzadv.zze)) {
            return zzy(zzmv, zzadv.zza, zzB(zzmv2, zzadv.zza, zzadv.zze), zzkw.zze, zzadv.zzd);
        }
        return zzx(zzmv, zzadv.zza, zzadv.zze, zzc2, zzkw.zze, zzadv.zzd);
    }

    @Nullable
    private final zzkw zzw(zzmv zzmv, zzadv zzadv, long j, long j2) {
        zzadv zzadv2 = zzadv;
        zzmv zzmv2 = zzmv;
        zzmv.zzf(zzadv2.zza, this.zza);
        if (zzadv.zzb()) {
            return zzx(zzmv, zzadv2.zza, zzadv2.zzb, -1, j, zzadv2.zzd);
        }
        return zzy(zzmv, zzadv2.zza, j2, j, zzadv2.zzd);
    }

    private final zzkw zzx(zzmv zzmv, Object obj, int i, int i2, long j, long j2) {
        zzadv zzadv = new zzadv(obj, i, -1, j2);
        long zzh2 = zzmv.zzf(zzadv.zza, this.zza).zzh(zzadv.zzb, -1);
        if (this.zza.zzc(i) == -1) {
            this.zza.zzi();
        }
        boolean zzj2 = this.zza.zzj(zzadv.zzb);
        long j3 = 0;
        if (zzh2 != -9223372036854775807L && zzh2 <= 0) {
            j3 = Math.max(0, -1 + zzh2);
        }
        return new zzkw(zzadv, j3, j, -9223372036854775807L, zzh2, zzj2, false, false, false);
    }

    private final zzkw zzy(zzmv zzmv, Object obj, long j, long j2, long j3) {
        zzmv zzmv2 = zzmv;
        Object obj2 = obj;
        long j4 = j;
        zzmv2.zzf(obj2, this.zza);
        int zzf2 = this.zza.zzf(j4);
        zzadv zzadv = new zzadv(obj2, j3, zzf2);
        boolean zzC = zzC(zzadv);
        boolean zzz = zzz(zzmv2, zzadv);
        boolean zzA = zzA(zzmv2, zzadv, zzC);
        boolean z = zzf2 != -1 && this.zza.zzj(zzf2);
        long zzb2 = zzf2 != -1 ? this.zza.zzb(zzf2) : -9223372036854775807L;
        long j5 = (zzb2 == -9223372036854775807L || zzb2 == Long.MIN_VALUE) ? this.zza.zzd : zzb2;
        if (j5 != -9223372036854775807L && j4 >= j5) {
            j4 = Math.max(0, -1 + j5);
        }
        return new zzkw(zzadv, j4, j2, zzb2, j5, z, zzC, zzz, zzA);
    }

    private final boolean zzz(zzmv zzmv, zzadv zzadv) {
        if (!zzC(zzadv)) {
            return false;
        }
        int i = zzmv.zzf(zzadv.zza, this.zza).zzc;
        if (zzmv.zze(i, this.zzb, 0).zzo == zzmv.zzh(zzadv.zza)) {
            return true;
        }
        return false;
    }

    public final boolean zza(zzmv zzmv, int i) {
        this.zzf = i;
        return zzu(zzmv);
    }

    public final boolean zzb(zzmv zzmv, boolean z) {
        this.zzg = z;
        return zzu(zzmv);
    }

    public final boolean zzc(zzadt zzadt) {
        zzkv zzkv = this.zzj;
        return zzkv != null && zzkv.zza == zzadt;
    }

    public final void zzd(long j) {
        zzkv zzkv = this.zzj;
        if (zzkv != null) {
            zzkv.zzh(j);
        }
    }

    public final boolean zze() {
        zzkv zzkv = this.zzj;
        if (zzkv != null) {
            return !zzkv.zzf.zzi && zzkv.zzd() && this.zzj.zzf.zze != -9223372036854775807L && this.zzk < 100;
        }
        return true;
    }

    @Nullable
    public final zzkw zzf(long j, zzlj zzlj) {
        zzkv zzkv = this.zzj;
        if (zzkv != null) {
            return zzv(zzlj.zza, zzkv, j);
        }
        return zzw(zzlj.zza, zzlj.zzb, zzlj.zzc, zzlj.zzs);
    }

    @Nullable
    public final zzkv zzg() {
        return this.zzj;
    }

    @Nullable
    public final zzkv zzh() {
        return this.zzh;
    }

    @Nullable
    public final zzkv zzi() {
        return this.zzi;
    }

    public final zzkv zzj() {
        zzkv zzkv = this.zzi;
        boolean z = false;
        if (!(zzkv == null || zzkv.zzo() == null)) {
            z = true;
        }
        zzajg.zzd(z);
        this.zzi = this.zzi.zzo();
        zzs();
        return this.zzi;
    }

    @Nullable
    public final zzkv zzk() {
        zzkv zzkv = this.zzh;
        if (zzkv == null) {
            return null;
        }
        if (zzkv == this.zzi) {
            this.zzi = zzkv.zzo();
        }
        this.zzh.zzm();
        int i = this.zzk - 1;
        this.zzk = i;
        if (i == 0) {
            this.zzj = null;
            zzkv zzkv2 = this.zzh;
            this.zzl = zzkv2.zzb;
            this.zzm = zzkv2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzo();
        zzs();
        return this.zzh;
    }

    public final boolean zzl(zzkv zzkv) {
        boolean z = false;
        zzajg.zzd(zzkv != null);
        if (zzkv.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzkv;
        while (zzkv.zzo() != null) {
            zzkv = zzkv.zzo();
            if (zzkv == this.zzi) {
                this.zzi = this.zzh;
                z = true;
            }
            zzkv.zzm();
            this.zzk--;
        }
        this.zzj.zzn((zzkv) null);
        zzs();
        return z;
    }

    public final void zzm() {
        if (this.zzk != 0) {
            zzkv zzkv = this.zzh;
            zzajg.zze(zzkv);
            this.zzl = zzkv.zzb;
            this.zzm = zzkv.zzf.zza.zzd;
            while (zzkv != null) {
                zzkv.zzm();
                zzkv = zzkv.zzo();
            }
            this.zzh = null;
            this.zzj = null;
            this.zzi = null;
            this.zzk = 0;
            zzs();
        }
    }

    public final boolean zzn(zzmv zzmv, long j, long j2) {
        zzkw zzkw;
        long j3;
        zzmv zzmv2 = zzmv;
        zzkv zzkv = this.zzh;
        zzkv zzkv2 = null;
        while (zzkv != null) {
            zzkw zzkw2 = zzkv.zzf;
            if (zzkv2 == null) {
                zzkw = zzo(zzmv2, zzkw2);
                long j4 = j;
            } else {
                zzkw zzv = zzv(zzmv2, zzkv2, j);
                if (zzv == null) {
                    return !zzl(zzkv2);
                }
                if (zzkw2.zzb != zzv.zzb || !zzkw2.zza.equals(zzv.zza)) {
                    return !zzl(zzkv2);
                }
                zzkw = zzv;
            }
            zzkv.zzf = zzkw.zzb(zzkw2.zzc);
            long j5 = zzkw2.zze;
            long j6 = zzkw.zze;
            if (j5 == -9223372036854775807L || j5 == j6) {
                zzkv2 = zzkv;
                zzkv = zzkv.zzo();
            } else {
                zzkv.zzr();
                long j7 = zzkw.zze;
                if (j7 == -9223372036854775807L) {
                    j3 = RecyclerView.FOREVER_NS;
                } else {
                    j3 = j7 + zzkv.zza();
                }
                return !zzl(zzkv) && !(zzkv == this.zzi && !zzkv.zzf.zzf && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1)) >= 0));
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0029, code lost:
        r1 = r3.zze;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzkw zzo(com.google.android.gms.internal.ads.zzmv r19, com.google.android.gms.internal.ads.zzkw r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.gms.internal.ads.zzadv r3 = r2.zza
            boolean r12 = zzC(r3)
            boolean r13 = r0.zzz(r1, r3)
            boolean r14 = r0.zzA(r1, r3, r12)
            com.google.android.gms.internal.ads.zzadv r4 = r2.zza
            java.lang.Object r4 = r4.zza
            com.google.android.gms.internal.ads.zzms r5 = r0.zza
            r1.zzf(r4, r5)
            boolean r1 = r3.zzb()
            r4 = -1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0035
            int r1 = r3.zze
            if (r1 != r4) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            com.google.android.gms.internal.ads.zzms r7 = r0.zza
            long r7 = r7.zzb(r1)
            goto L_0x0036
        L_0x0035:
            r7 = r5
        L_0x0036:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzms r1 = r0.zza
            int r5 = r3.zzb
            long r5 = r1.zzh(r5, r4)
        L_0x0044:
            r9 = r5
            goto L_0x0058
        L_0x0046:
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0053
            r5 = -9223372036854775808
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r9 = r7
            goto L_0x0058
        L_0x0053:
            com.google.android.gms.internal.ads.zzms r1 = r0.zza
            long r5 = r1.zzd
            goto L_0x0044
        L_0x0058:
            boolean r1 = r3.zzb()
            r5 = 0
            if (r1 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzms r1 = r0.zza
            int r4 = r3.zzb
            boolean r1 = r1.zzj(r4)
            r11 = r1
            goto L_0x0079
        L_0x0069:
            int r1 = r3.zze
            if (r1 == r4) goto L_0x0078
            com.google.android.gms.internal.ads.zzms r4 = r0.zza
            boolean r1 = r4.zzj(r1)
            if (r1 == 0) goto L_0x0078
            r1 = 1
            r11 = 1
            goto L_0x0079
        L_0x0078:
            r11 = 0
        L_0x0079:
            com.google.android.gms.internal.ads.zzkw r15 = new com.google.android.gms.internal.ads.zzkw
            long r4 = r2.zzb
            long r1 = r2.zzc
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzky.zzo(com.google.android.gms.internal.ads.zzmv, com.google.android.gms.internal.ads.zzkw):com.google.android.gms.internal.ads.zzkw");
    }

    public final zzadv zzp(zzmv zzmv, Object obj, long j) {
        long j2;
        int zzh2;
        int i = zzmv.zzf(obj, this.zza).zzc;
        Object obj2 = this.zzl;
        if (obj2 == null || (zzh2 = zzmv.zzh(obj2)) == -1 || zzmv.zzg(zzh2, this.zza, false).zzc != i) {
            zzkv zzkv = this.zzh;
            while (true) {
                if (zzkv == null) {
                    zzkv zzkv2 = this.zzh;
                    while (true) {
                        if (zzkv2 != null) {
                            int zzh3 = zzmv.zzh(zzkv2.zzb);
                            if (zzh3 != -1 && zzmv.zzg(zzh3, this.zza, false).zzc == i) {
                                j2 = zzkv2.zzf.zza.zzd;
                                break;
                            }
                            zzkv2 = zzkv2.zzo();
                        } else {
                            j2 = this.zze;
                            this.zze = 1 + j2;
                            if (this.zzh == null) {
                                this.zzl = obj;
                                this.zzm = j2;
                            }
                        }
                    }
                } else if (zzkv.zzb.equals(obj)) {
                    j2 = zzkv.zzf.zza.zzd;
                    break;
                } else {
                    zzkv = zzkv.zzo();
                }
            }
        } else {
            j2 = this.zzm;
        }
        return zzt(zzmv, obj, j, j2, this.zza);
    }

    public final /* synthetic */ void zzq(zzfmi zzfmi, zzadv zzadv) {
        this.zzc.zzR(zzfmi.zzf(), zzadv);
    }

    public final zzkv zzr(zzmb[] zzmbArr, zzahc zzahc, zzahy zzahy, zzlf zzlf, zzkw zzkw, zzahd zzahd) {
        long j;
        zzkw zzkw2 = zzkw;
        zzkv zzkv = this.zzj;
        if (zzkv == null) {
            if (zzkw2.zza.zzb()) {
                long j2 = zzkw2.zzc;
                if (j2 != -9223372036854775807L) {
                    j = j2;
                }
            }
            j = 0;
        } else {
            j = (zzkv.zza() + this.zzj.zzf.zze) - zzkw2.zzb;
        }
        zzkv zzkv2 = new zzkv(zzmbArr, j, zzahc, zzahy, zzlf, zzkw, zzahd, (byte[]) null);
        zzkv zzkv3 = this.zzj;
        if (zzkv3 != null) {
            zzkv3.zzn(zzkv2);
        } else {
            this.zzh = zzkv2;
            this.zzi = zzkv2;
        }
        this.zzl = null;
        this.zzj = zzkv2;
        this.zzk++;
        zzs();
        return zzkv2;
    }
}
