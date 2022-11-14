package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzwr implements zzta, zztv {
    public static final zztg zza = zzwp.zza;
    public final zzakr zzb;
    public final zzakr zzc;
    public final zzakr zzd;
    public final zzakr zze;
    public final ArrayDeque<zzvx> zzf;
    public final zzwt zzg;
    public final List<zzabd> zzh;
    public int zzi;
    public int zzj;
    public long zzk;
    public int zzl;
    @Nullable
    public zzakr zzm;
    public int zzn;
    public int zzo;
    public int zzp;
    public int zzq;
    public zztd zzr;
    public zzwq[] zzs;
    public long[][] zzt;
    public int zzu;
    public long zzv;
    public int zzw;
    @Nullable
    public zzacu zzx;

    public zzwr() {
        this(0);
    }

    private final void zzh() {
        this.zzi = 0;
        this.zzl = 0;
    }

    private final void zzi(long j) throws zzlg {
        zzwr zzwr;
        zzabe zzabe;
        zzabe zzabe2;
        long j2;
        int i;
        List<zzwy> list;
        zzwr zzwr2;
        zzabe zzabe3;
        char c;
        int i2;
        zzwr zzwr3 = this;
        while (!zzwr3.zzf.isEmpty() && zzwr3.zzf.peek().zza == j) {
            zzvx pop = zzwr3.zzf.pop();
            if (pop.zzd == 1836019574) {
                ArrayList arrayList = new ArrayList();
                boolean z = zzwr3.zzw == 1;
                zztp zztp = new zztp();
                zzvy zzc2 = pop.zzc(1969517665);
                if (zzc2 != null) {
                    Pair<zzabe, zzabe> zzb2 = zzwg.zzb(zzc2);
                    zzabe zzabe4 = (zzabe) zzb2.first;
                    zzabe zzabe5 = (zzabe) zzb2.second;
                    if (zzabe4 != null) {
                        zztp.zza(zzabe4);
                    }
                    zzabe2 = zzabe5;
                    zzabe = zzabe4;
                } else {
                    zzabe2 = null;
                    zzabe = null;
                }
                zzvx zzd2 = pop.zzd(1835365473);
                zzabe zzc3 = zzd2 != null ? zzwg.zzc(zzd2) : null;
                List<zzwy> zza2 = zzwg.zza(pop, zztp, -9223372036854775807L, (zzsa) null, false, z, zzwo.zza);
                zztd zztd = zzwr3.zzr;
                if (zztd != null) {
                    int size = zza2.size();
                    long j3 = -9223372036854775807L;
                    long j4 = -9223372036854775807L;
                    int i3 = 0;
                    int i4 = -1;
                    while (true) {
                        j2 = 0;
                        if (i3 >= size) {
                            break;
                        }
                        zzwy zzwy = zza2.get(i3);
                        if (zzwy.zzb == 0) {
                            zzwr2 = zzwr3;
                            list = zza2;
                            i = size;
                        } else {
                            zzwv zzwv = zzwy.zza;
                            ArrayList arrayList2 = arrayList;
                            long j5 = zzwv.zze;
                            if (j5 == j3) {
                                j5 = zzwy.zzh;
                            }
                            long max = Math.max(j4, j5);
                            zzwq zzwq = new zzwq(zzwv, zzwy, zztd.zza(i3, zzwv.zzb));
                            int i5 = zzwy.zze;
                            list = zza2;
                            zzkb zza3 = zzwv.zzf.zza();
                            zza3.zzk(i5 + 30);
                            i = size;
                            if (zzwv.zzb == 2 && j5 > 0 && (i2 = zzwy.zzb) > 1) {
                                zza3.zzq(((float) i2) / (((float) j5) / 1000000.0f));
                            }
                            if (zzwv.zzb == 1 && zztp.zzb()) {
                                zza3.zzz(zztp.zza);
                                zza3.zzA(zztp.zzb);
                            }
                            int i6 = zzwv.zzb;
                            zzabe[] zzabeArr = new zzabe[2];
                            zzabeArr[0] = zzabe2;
                            zzwr2 = this;
                            if (zzwr2.zzh.isEmpty()) {
                                c = 1;
                                zzabe3 = null;
                            } else {
                                zzabe3 = new zzabe((List<? extends zzabd>) zzwr2.zzh);
                                c = 1;
                            }
                            zzabeArr[c] = zzabe3;
                            long j6 = max;
                            zzabe zzabe6 = new zzabe(new zzabd[0]);
                            if (i6 == 1) {
                                if (zzabe != null) {
                                    zzabe6 = zzabe;
                                }
                            } else if (i6 == 2 && zzc3 != null) {
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= zzc3.zza()) {
                                        break;
                                    }
                                    zzabd zzb3 = zzc3.zzb(i7);
                                    if (zzb3 instanceof zzacs) {
                                        zzacs zzacs = (zzacs) zzb3;
                                        if ("com.android.capture.fps".equals(zzacs.zza)) {
                                            zzabe6 = new zzabe(zzacs);
                                            break;
                                        }
                                    }
                                    i7++;
                                }
                            }
                            for (int i8 = 0; i8 < 2; i8++) {
                                zzabe6 = zzabe6.zzc(zzabeArr[i8]);
                            }
                            if (zzabe6.zza() > 0) {
                                zza3.zzi(zzabe6);
                            }
                            zzwq.zzc.zza(zza3.zzD());
                            if (zzwv.zzb == 2) {
                                if (i4 == -1) {
                                    i4 = arrayList2.size();
                                }
                            }
                            arrayList = arrayList2;
                            arrayList.add(zzwq);
                            j4 = j6;
                        }
                        i3++;
                        zzwr3 = zzwr2;
                        zza2 = list;
                        size = i;
                        j3 = -9223372036854775807L;
                    }
                    zzwr = zzwr3;
                    zzwr.zzu = i4;
                    zzwr.zzv = j4;
                    zzwq[] zzwqArr = (zzwq[]) arrayList.toArray(new zzwq[0]);
                    zzwr.zzs = zzwqArr;
                    int length = zzwqArr.length;
                    long[][] jArr = new long[length][];
                    int[] iArr = new int[length];
                    long[] jArr2 = new long[length];
                    boolean[] zArr = new boolean[length];
                    for (int i9 = 0; i9 < zzwqArr.length; i9++) {
                        jArr[i9] = new long[zzwqArr[i9].zzb.zzb];
                        jArr2[i9] = zzwqArr[i9].zzb.zzf[0];
                    }
                    int i10 = 0;
                    while (i10 < zzwqArr.length) {
                        long j7 = RecyclerView.FOREVER_NS;
                        int i11 = -1;
                        for (int i12 = 0; i12 < zzwqArr.length; i12++) {
                            if (!zArr[i12]) {
                                long j8 = jArr2[i12];
                                if (j8 <= j7) {
                                    i11 = i12;
                                    j7 = j8;
                                }
                            }
                        }
                        int i13 = iArr[i11];
                        long[] jArr3 = jArr[i11];
                        jArr3[i13] = j2;
                        zzwy zzwy2 = zzwqArr[i11].zzb;
                        j2 += (long) zzwy2.zzd[i13];
                        int i14 = i13 + 1;
                        iArr[i11] = i14;
                        if (i14 < jArr3.length) {
                            jArr2[i11] = zzwy2.zzf[i14];
                        } else {
                            zArr[i11] = true;
                            i10++;
                        }
                    }
                    zzwr.zzt = jArr;
                    zztd.zzbl();
                    zztd.zzbm(zzwr);
                    zzwr.zzf.clear();
                    zzwr.zzi = 2;
                } else {
                    zzwr zzwr4 = zzwr3;
                    throw null;
                }
            } else {
                zzwr = zzwr3;
                if (!zzwr.zzf.isEmpty()) {
                    zzwr.zzf.peek().zzb(pop);
                }
            }
            zzwr3 = zzwr;
        }
        if (zzwr3.zzi != 2) {
            zzh();
        }
    }

    public static long zzj(zzwy zzwy, long j, long j2) {
        int zzk2 = zzk(zzwy, j);
        if (zzk2 == -1) {
            return j2;
        }
        return Math.min(zzwy.zzc[zzk2], j2);
    }

    public static int zzk(zzwy zzwy, long j) {
        int zza2 = zzwy.zza(j);
        return zza2 == -1 ? zzwy.zzb(j) : zza2;
    }

    public static int zzl(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    public final boolean zza() {
        return true;
    }

    public final zztt zzb(long j) {
        long j2;
        long j3;
        int zzb2;
        zzwq[] zzwqArr = this.zzs;
        if (zzwqArr == null) {
            throw null;
        } else if (zzwqArr.length == 0) {
            zztw zztw = zztw.zza;
            return new zztt(zztw, zztw);
        } else {
            int i = this.zzu;
            long j4 = -1;
            if (i != -1) {
                zzwy zzwy = zzwqArr[i].zzb;
                int zzk2 = zzk(zzwy, j);
                if (zzk2 == -1) {
                    zztw zztw2 = zztw.zza;
                    return new zztt(zztw2, zztw2);
                }
                long j5 = zzwy.zzf[zzk2];
                j2 = zzwy.zzc[zzk2];
                if (j5 >= j || zzk2 >= zzwy.zzb - 1 || (zzb2 = zzwy.zzb(j)) == -1 || zzb2 == zzk2) {
                    j3 = -9223372036854775807L;
                } else {
                    j3 = zzwy.zzf[zzb2];
                    j4 = zzwy.zzc[zzb2];
                }
                j = j5;
            } else {
                j2 = RecyclerView.FOREVER_NS;
                j3 = -9223372036854775807L;
            }
            int i2 = 0;
            while (true) {
                zzwq[] zzwqArr2 = this.zzs;
                if (i2 >= zzwqArr2.length) {
                    break;
                }
                if (i2 != this.zzu) {
                    zzwy zzwy2 = zzwqArr2[i2].zzb;
                    long zzj2 = zzj(zzwy2, j, j2);
                    if (j3 != -9223372036854775807L) {
                        j4 = zzj(zzwy2, j3, j4);
                    }
                    j2 = zzj2;
                }
                i2++;
            }
            zztw zztw3 = new zztw(j, j2);
            if (j3 == -9223372036854775807L) {
                return new zztt(zztw3, zztw3);
            }
            return new zztt(zztw3, new zztw(j3, j4));
        }
    }

    public final long zzc() {
        return this.zzv;
    }

    public final boolean zzd(zztb zztb) throws IOException {
        return zzwu.zzb(zztb, false);
    }

    public final void zze(zztd zztd) {
        this.zzr = zztd;
    }

    /* JADX WARNING: Removed duplicated region for block: B:202:0x008d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzf(com.google.android.gms.internal.ads.zztb r33, com.google.android.gms.internal.ads.zzts r34) throws java.io.IOException {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            r2 = r34
        L_0x0006:
            int r3 = r0.zzi
            r4 = 1718909296(0x66747970, float:2.8862439E23)
            r6 = 0
            r8 = -1
            r9 = 8
            r10 = 1
            if (r3 == 0) goto L_0x0239
            r13 = 262144(0x40000, double:1.295163E-318)
            if (r3 == r10) goto L_0x01b9
            long r3 = r33.zzn()
            int r9 = r0.zzn
            if (r9 != r8) goto L_0x00ab
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r18 = r16
            r22 = r18
            r25 = r22
            r9 = 0
            r20 = -1
            r21 = 1
            r24 = 1
            r27 = -1
        L_0x0034:
            com.google.android.gms.internal.ads.zzwq[] r5 = r0.zzs
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzalh.zzd(r5)
            com.google.android.gms.internal.ads.zzwq[] r5 = (com.google.android.gms.internal.ads.zzwq[]) r5
            int r5 = r5.length
            if (r9 >= r5) goto L_0x0090
            com.google.android.gms.internal.ads.zzwq[] r5 = r0.zzs
            r5 = r5[r9]
            int r15 = r5.zzd
            com.google.android.gms.internal.ads.zzwy r5 = r5.zzb
            int r12 = r5.zzb
            if (r15 != r12) goto L_0x004c
            goto L_0x008d
        L_0x004c:
            long[] r5 = r5.zzc
            r28 = r5[r15]
            long[][] r5 = r0.zzt
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzalh.zzd(r5)
            long[][] r5 = (long[][]) r5
            r5 = r5[r9]
            r30 = r5[r15]
            long r28 = r28 - r3
            int r5 = (r28 > r6 ? 1 : (r28 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x0069
            int r5 = (r28 > r13 ? 1 : (r28 == r13 ? 0 : -1))
            if (r5 < 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r5 = 0
            goto L_0x006a
        L_0x0069:
            r5 = 1
        L_0x006a:
            if (r5 != 0) goto L_0x0070
            if (r24 != 0) goto L_0x0078
            r12 = 0
            goto L_0x0072
        L_0x0070:
            r12 = r24
        L_0x0072:
            if (r5 != r12) goto L_0x0081
            int r15 = (r28 > r22 ? 1 : (r28 == r22 ? 0 : -1))
            if (r15 >= 0) goto L_0x0081
        L_0x0078:
            r24 = r5
            r20 = r9
            r22 = r28
            r25 = r30
            goto L_0x0083
        L_0x0081:
            r24 = r12
        L_0x0083:
            int r12 = (r30 > r18 ? 1 : (r30 == r18 ? 0 : -1))
            if (r12 >= 0) goto L_0x008d
            r21 = r5
            r27 = r9
            r18 = r30
        L_0x008d:
            int r9 = r9 + 1
            goto L_0x0034
        L_0x0090:
            int r5 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r5 == 0) goto L_0x00a3
            if (r21 == 0) goto L_0x00a3
            r15 = 10485760(0xa00000, double:5.180654E-317)
            long r18 = r18 + r15
            int r5 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r5 >= 0) goto L_0x00a0
            goto L_0x00a3
        L_0x00a0:
            r5 = r27
            goto L_0x00a5
        L_0x00a3:
            r5 = r20
        L_0x00a5:
            r0.zzn = r5
            if (r5 != r8) goto L_0x00ab
            goto L_0x01b8
        L_0x00ab:
            com.google.android.gms.internal.ads.zzwq[] r5 = r0.zzs
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzalh.zzd(r5)
            com.google.android.gms.internal.ads.zzwq[] r5 = (com.google.android.gms.internal.ads.zzwq[]) r5
            int r9 = r0.zzn
            r5 = r5[r9]
            com.google.android.gms.internal.ads.zztz r15 = r5.zzc
            int r9 = r5.zzd
            com.google.android.gms.internal.ads.zzwy r12 = r5.zzb
            long[] r8 = r12.zzc
            r10 = r8[r9]
            int[] r8 = r12.zzd
            r8 = r8[r9]
            long r3 = r10 - r3
            int r12 = r0.zzo
            long r13 = (long) r12
            long r3 = r3 + r13
            int r12 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r12 < 0) goto L_0x01b5
            r6 = 262144(0x40000, double:1.295163E-318)
            int r12 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r12 < 0) goto L_0x00d8
            goto L_0x01b5
        L_0x00d8:
            com.google.android.gms.internal.ads.zzwv r2 = r5.zza
            int r2 = r2.zzg
            r6 = 1
            if (r2 != r6) goto L_0x00e4
            r6 = 8
            long r3 = r3 + r6
            int r8 = r8 + -8
        L_0x00e4:
            int r2 = (int) r3
            r1.zzf(r2)
            com.google.android.gms.internal.ads.zzwv r2 = r5.zza
            int r3 = r2.zzj
            if (r3 == 0) goto L_0x0153
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            byte[] r2 = r2.zzi()
            r3 = 0
            r2[r3] = r3
            r4 = 1
            r2[r4] = r3
            r4 = 2
            r2[r4] = r3
            com.google.android.gms.internal.ads.zzwv r3 = r5.zza
            int r3 = r3.zzj
            int r4 = 4 - r3
        L_0x0103:
            int r6 = r0.zzp
            if (r6 >= r8) goto L_0x0190
            int r6 = r0.zzq
            if (r6 != 0) goto L_0x013e
            r1.zzc(r2, r4, r3)
            int r6 = r0.zzo
            int r6 = r6 + r3
            r0.zzo = r6
            com.google.android.gms.internal.ads.zzakr r6 = r0.zzc
            r7 = 0
            r6.zzh(r7)
            com.google.android.gms.internal.ads.zzakr r6 = r0.zzc
            int r6 = r6.zzv()
            if (r6 < 0) goto L_0x0135
            r0.zzq = r6
            com.google.android.gms.internal.ads.zzakr r6 = r0.zzb
            r6.zzh(r7)
            com.google.android.gms.internal.ads.zzakr r6 = r0.zzb
            r7 = 4
            com.google.android.gms.internal.ads.zztx.zzb(r15, r6, r7)
            int r6 = r0.zzp
            int r6 = r6 + r7
            r0.zzp = r6
            int r8 = r8 + r4
            goto L_0x0103
        L_0x0135:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r2 = "Invalid NAL length"
            r3 = 0
            r1.<init>(r2, r3)
            throw r1
        L_0x013e:
            r7 = 0
            int r6 = com.google.android.gms.internal.ads.zztx.zza(r15, r1, r6, r7)
            int r7 = r0.zzo
            int r7 = r7 + r6
            r0.zzo = r7
            int r7 = r0.zzp
            int r7 = r7 + r6
            r0.zzp = r7
            int r7 = r0.zzq
            int r7 = r7 - r6
            r0.zzq = r7
            goto L_0x0103
        L_0x0153:
            com.google.android.gms.internal.ads.zzkc r2 = r2.zzf
            java.lang.String r2 = r2.zzl
            java.lang.String r3 = "audio/ac4"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0175
            int r2 = r0.zzp
            if (r2 != 0) goto L_0x0173
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzd
            com.google.android.gms.internal.ads.zzpf.zzb(r8, r2)
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzd
            r3 = 7
            com.google.android.gms.internal.ads.zztx.zzb(r15, r2, r3)
            int r2 = r0.zzp
            int r2 = r2 + r3
            r0.zzp = r2
        L_0x0173:
            int r8 = r8 + 7
        L_0x0175:
            int r2 = r0.zzp
            if (r2 >= r8) goto L_0x0190
            int r2 = r8 - r2
            r3 = 0
            int r2 = com.google.android.gms.internal.ads.zztx.zza(r15, r1, r2, r3)
            int r3 = r0.zzo
            int r3 = r3 + r2
            r0.zzo = r3
            int r3 = r0.zzp
            int r3 = r3 + r2
            r0.zzp = r3
            int r3 = r0.zzq
            int r3 = r3 - r2
            r0.zzq = r3
            goto L_0x0175
        L_0x0190:
            r19 = r8
            com.google.android.gms.internal.ads.zzwy r1 = r5.zzb
            long[] r2 = r1.zzf
            r16 = r2[r9]
            int[] r1 = r1.zzg
            r18 = r1[r9]
            r20 = 0
            r21 = 0
            r15.zzd(r16, r18, r19, r20, r21)
            int r1 = r5.zzd
            r2 = 1
            int r1 = r1 + r2
            r5.zzd = r1
            r1 = -1
            r0.zzn = r1
            r1 = 0
            r0.zzo = r1
            r0.zzp = r1
            r0.zzq = r1
            r8 = 0
            goto L_0x01b8
        L_0x01b5:
            r2.zza = r10
            r8 = 1
        L_0x01b8:
            return r8
        L_0x01b9:
            long r5 = r0.zzk
            int r3 = r0.zzl
            long r7 = (long) r3
            long r5 = r5 - r7
            long r7 = r33.zzn()
            long r7 = r7 + r5
            com.google.android.gms.internal.ads.zzakr r3 = r0.zzm
            if (r3 == 0) goto L_0x0218
            byte[] r10 = r3.zzi()
            int r11 = r0.zzl
            int r6 = (int) r5
            r1.zzc(r10, r11, r6)
            int r5 = r0.zzj
            if (r5 != r4) goto L_0x01fd
            r3.zzh(r9)
            int r4 = r3.zzv()
            int r4 = zzl(r4)
            if (r4 == 0) goto L_0x01e4
            goto L_0x01fa
        L_0x01e4:
            r4 = 4
            r3.zzk(r4)
        L_0x01e8:
            int r4 = r3.zzd()
            if (r4 <= 0) goto L_0x01f9
            int r4 = r3.zzv()
            int r4 = zzl(r4)
            if (r4 == 0) goto L_0x01e8
            goto L_0x01fa
        L_0x01f9:
            r4 = 0
        L_0x01fa:
            r0.zzw = r4
            goto L_0x0223
        L_0x01fd:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzvx> r4 = r0.zzf
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0223
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzvx> r4 = r0.zzf
            java.lang.Object r4 = r4.peek()
            com.google.android.gms.internal.ads.zzvx r4 = (com.google.android.gms.internal.ads.zzvx) r4
            com.google.android.gms.internal.ads.zzvy r5 = new com.google.android.gms.internal.ads.zzvy
            int r6 = r0.zzj
            r5.<init>(r6, r3)
            r4.zza(r5)
            goto L_0x0223
        L_0x0218:
            r3 = 262144(0x40000, double:1.295163E-318)
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 >= 0) goto L_0x0225
            int r3 = (int) r5
            r1.zzf(r3)
        L_0x0223:
            r11 = 0
            goto L_0x022d
        L_0x0225:
            long r3 = r33.zzn()
            long r3 = r3 + r5
            r2.zza = r3
            r11 = 1
        L_0x022d:
            r0.zzi(r7)
            if (r11 == 0) goto L_0x0006
            int r3 = r0.zzi
            r4 = 2
            if (r3 == r4) goto L_0x0006
            r3 = 1
            return r3
        L_0x0239:
            r3 = 1
            int r5 = r0.zzl
            if (r5 != 0) goto L_0x0264
            com.google.android.gms.internal.ads.zzakr r5 = r0.zze
            byte[] r5 = r5.zzi()
            r8 = 0
            boolean r5 = r1.zzb(r5, r8, r9, r3)
            if (r5 != 0) goto L_0x024d
            r3 = -1
            return r3
        L_0x024d:
            r0.zzl = r9
            com.google.android.gms.internal.ads.zzakr r3 = r0.zze
            r3.zzh(r8)
            com.google.android.gms.internal.ads.zzakr r3 = r0.zze
            long r10 = r3.zzt()
            r0.zzk = r10
            com.google.android.gms.internal.ads.zzakr r3 = r0.zze
            int r3 = r3.zzv()
            r0.zzj = r3
        L_0x0264:
            long r10 = r0.zzk
            r12 = 1
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 != 0) goto L_0x0283
            com.google.android.gms.internal.ads.zzakr r3 = r0.zze
            byte[] r3 = r3.zzi()
            r1.zzc(r3, r9, r9)
            int r3 = r0.zzl
            int r3 = r3 + r9
            r0.zzl = r3
            com.google.android.gms.internal.ads.zzakr r3 = r0.zze
            long r5 = r3.zzD()
            r0.zzk = r5
            goto L_0x02ac
        L_0x0283:
            int r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x02ac
            long r5 = r33.zzo()
            r7 = -1
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x029d
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzvx> r3 = r0.zzf
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzvx r3 = (com.google.android.gms.internal.ads.zzvx) r3
            if (r3 == 0) goto L_0x029d
            long r5 = r3.zza
        L_0x029d:
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x02ac
            long r7 = r33.zzn()
            long r5 = r5 - r7
            int r3 = r0.zzl
            long r7 = (long) r3
            long r5 = r5 + r7
            r0.zzk = r5
        L_0x02ac:
            long r5 = r0.zzk
            int r3 = r0.zzl
            long r7 = (long) r3
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 < 0) goto L_0x03e9
            int r5 = r0.zzj
            r6 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r5 == r6) goto L_0x0397
            r6 = 1953653099(0x7472616b, float:7.681346E31)
            if (r5 == r6) goto L_0x0397
            r6 = 1835297121(0x6d646961, float:4.4181236E27)
            if (r5 == r6) goto L_0x0397
            r6 = 1835626086(0x6d696e66, float:4.515217E27)
            if (r5 == r6) goto L_0x0397
            r6 = 1937007212(0x7374626c, float:1.9362132E31)
            if (r5 == r6) goto L_0x0397
            r6 = 1701082227(0x65647473, float:6.742798E22)
            if (r5 == r6) goto L_0x0397
            if (r5 != r7) goto L_0x02dc
            goto L_0x0397
        L_0x02dc:
            r6 = 1835296868(0x6d646864, float:4.418049E27)
            if (r5 == r6) goto L_0x0363
            r6 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r5 == r6) goto L_0x0363
            r6 = 1751411826(0x68646c72, float:4.3148E24)
            if (r5 == r6) goto L_0x0363
            r6 = 1937011556(0x73747364, float:1.9367383E31)
            if (r5 == r6) goto L_0x0363
            r6 = 1937011827(0x73747473, float:1.9367711E31)
            if (r5 == r6) goto L_0x0363
            r6 = 1937011571(0x73747373, float:1.9367401E31)
            if (r5 == r6) goto L_0x0363
            r6 = 1668576371(0x63747473, float:4.5093966E21)
            if (r5 == r6) goto L_0x0363
            r6 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r5 == r6) goto L_0x0363
            r6 = 1937011555(0x73747363, float:1.9367382E31)
            if (r5 == r6) goto L_0x0363
            r6 = 1937011578(0x7374737a, float:1.936741E31)
            if (r5 == r6) goto L_0x0363
            r6 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r5 == r6) goto L_0x0363
            r6 = 1937007471(0x7374636f, float:1.9362445E31)
            if (r5 == r6) goto L_0x0363
            r6 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r5 == r6) goto L_0x0363
            r6 = 1953196132(0x746b6864, float:7.46037E31)
            if (r5 == r6) goto L_0x0363
            if (r5 == r4) goto L_0x0363
            r4 = 1969517665(0x75647461, float:2.8960062E32)
            if (r5 == r4) goto L_0x0363
            r4 = 1801812339(0x6b657973, float:2.7741754E26)
            if (r5 == r4) goto L_0x0363
            r4 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r5 != r4) goto L_0x0334
            goto L_0x0363
        L_0x0334:
            long r3 = r33.zzn()
            int r5 = r0.zzl
            long r5 = (long) r5
            long r10 = r3 - r5
            int r3 = r0.zzj
            r4 = 1836086884(0x6d707664, float:4.6512205E27)
            if (r3 != r4) goto L_0x035b
            com.google.android.gms.internal.ads.zzacu r3 = new com.google.android.gms.internal.ads.zzacu
            r8 = 0
            long r14 = r10 + r5
            long r12 = r0.zzk
            long r5 = r12 - r5
            r7 = r3
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r16 = r5
            r7.<init>(r8, r10, r12, r14, r16)
            r0.zzx = r3
        L_0x035b:
            r3 = 0
            r0.zzm = r3
            r3 = 1
            r0.zzi = r3
            goto L_0x0006
        L_0x0363:
            if (r3 != r9) goto L_0x0367
            r3 = 1
            goto L_0x0368
        L_0x0367:
            r3 = 0
        L_0x0368:
            com.google.android.gms.internal.ads.zzajg.zzd(r3)
            long r3 = r0.zzk
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x0376
            r3 = 1
            goto L_0x0377
        L_0x0376:
            r3 = 0
        L_0x0377:
            com.google.android.gms.internal.ads.zzajg.zzd(r3)
            com.google.android.gms.internal.ads.zzakr r3 = new com.google.android.gms.internal.ads.zzakr
            long r4 = r0.zzk
            int r5 = (int) r4
            r3.<init>((int) r5)
            com.google.android.gms.internal.ads.zzakr r4 = r0.zze
            byte[] r4 = r4.zzi()
            byte[] r5 = r3.zzi()
            r6 = 0
            java.lang.System.arraycopy(r4, r6, r5, r6, r9)
            r0.zzm = r3
            r3 = 1
            r0.zzi = r3
            goto L_0x0006
        L_0x0397:
            long r3 = r33.zzn()
            long r5 = r0.zzk
            int r8 = r0.zzl
            long r10 = (long) r8
            long r3 = r3 + r5
            long r3 = r3 - r10
            int r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x03ca
            int r5 = r0.zzj
            if (r5 != r7) goto L_0x03ca
            com.google.android.gms.internal.ads.zzakr r5 = r0.zzd
            r5.zza(r9)
            com.google.android.gms.internal.ads.zzakr r5 = r0.zzd
            byte[] r5 = r5.zzi()
            r6 = 0
            r1.zzi(r5, r6, r9)
            com.google.android.gms.internal.ads.zzakr r5 = r0.zzd
            com.google.android.gms.internal.ads.zzwg.zzd(r5)
            com.google.android.gms.internal.ads.zzakr r5 = r0.zzd
            int r5 = r5.zzg()
            r1.zzf(r5)
            r33.zzl()
        L_0x03ca:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzvx> r5 = r0.zzf
            com.google.android.gms.internal.ads.zzvx r6 = new com.google.android.gms.internal.ads.zzvx
            int r7 = r0.zzj
            r6.<init>(r7, r3)
            r5.push(r6)
            long r5 = r0.zzk
            int r7 = r0.zzl
            long r7 = (long) r7
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x03e4
            r0.zzi(r3)
            goto L_0x0006
        L_0x03e4:
            r32.zzh()
            goto L_0x0006
        L_0x03e9:
            com.google.android.gms.internal.ads.zzlg r1 = new com.google.android.gms.internal.ads.zzlg
            java.lang.String r2 = "Atom size less than header length (unsupported)."
            r3 = 0
            r1.<init>(r2, r3)
            goto L_0x03f3
        L_0x03f2:
            throw r1
        L_0x03f3:
            goto L_0x03f2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwr.zzf(com.google.android.gms.internal.ads.zztb, com.google.android.gms.internal.ads.zzts):int");
    }

    public final void zzg(long j, long j2) {
        this.zzf.clear();
        this.zzl = 0;
        this.zzn = -1;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        if (j == 0) {
            zzh();
            return;
        }
        zzwq[] zzwqArr = this.zzs;
        if (zzwqArr != null) {
            for (zzwq zzwq : zzwqArr) {
                zzwy zzwy = zzwq.zzb;
                int zza2 = zzwy.zza(j2);
                if (zza2 == -1) {
                    zza2 = zzwy.zzb(j2);
                }
                zzwq.zzd = zza2;
            }
        }
    }

    public zzwr(int i) {
        this.zzi = 0;
        this.zzg = new zzwt();
        this.zzh = new ArrayList();
        this.zze = new zzakr(16);
        this.zzf = new ArrayDeque<>();
        this.zzb = new zzakr(zzakj.zza);
        this.zzc = new zzakr(4);
        this.zzd = new zzakr();
        this.zzn = -1;
    }
}
