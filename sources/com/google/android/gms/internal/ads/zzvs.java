package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzvs implements zzta {
    public static final zztg zza = zzvq.zza;
    public static final zzacd zzb = zzvr.zza;
    public final zzakr zzc;
    public final zzrc zzd;
    public final zztp zze;
    public final zztq zzf;
    public final zztz zzg;
    public zztd zzh;
    public zztz zzi;
    public zztz zzj;
    public int zzk;
    @Nullable
    public zzabe zzl;
    public long zzm;
    public long zzn;
    public long zzo;
    public int zzp;
    public zzvu zzq;
    public boolean zzr;

    public zzvs() {
        this(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0163  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput", "realTrackOutput"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzb(com.google.android.gms.internal.ads.zztb r17) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r0.zzk
            r3 = -1
            r4 = 0
            if (r2 != 0) goto L_0x000f
            r0.zzh(r1, r4)     // Catch:{ EOFException -> 0x000e }
            goto L_0x000f
        L_0x000e:
            return r3
        L_0x000f:
            com.google.android.gms.internal.ads.zzvu r2 = r0.zzq
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = 1
            if (r2 != 0) goto L_0x01b9
            com.google.android.gms.internal.ads.zzakr r14 = new com.google.android.gms.internal.ads.zzakr
            com.google.android.gms.internal.ads.zzrc r2 = r0.zzd
            int r2 = r2.zzc
            r14.<init>((int) r2)
            byte[] r2 = r14.zzi()
            com.google.android.gms.internal.ads.zzrc r9 = r0.zzd
            int r9 = r9.zzc
            r10 = r1
            com.google.android.gms.internal.ads.zzsx r10 = (com.google.android.gms.internal.ads.zzsx) r10
            r10.zzh(r2, r4, r9, r4)
            com.google.android.gms.internal.ads.zzrc r2 = r0.zzd
            int r9 = r2.zza
            r9 = r9 & r8
            r10 = 36
            r11 = 21
            if (r9 == 0) goto L_0x0042
            int r2 = r2.zze
            if (r2 == r8) goto L_0x0046
            r2 = 36
            goto L_0x004d
        L_0x0042:
            int r2 = r2.zze
            if (r2 == r8) goto L_0x0049
        L_0x0046:
            r2 = 21
            goto L_0x004d
        L_0x0049:
            r11 = 13
            r2 = 13
        L_0x004d:
            int r9 = r14.zze()
            int r11 = r2 + 4
            r12 = 1483304551(0x58696e67, float:1.02664153E15)
            r13 = 1447187017(0x56425249, float:5.3414667E13)
            r15 = 1231971951(0x496e666f, float:976486.94)
            if (r9 < r11) goto L_0x006f
            r14.zzh(r2)
            int r9 = r14.zzv()
            if (r9 == r12) goto L_0x006d
            if (r9 != r15) goto L_0x006f
            r11 = 1231971951(0x496e666f, float:976486.94)
            goto L_0x0085
        L_0x006d:
            r11 = r9
            goto L_0x0085
        L_0x006f:
            int r9 = r14.zze()
            r11 = 40
            if (r9 < r11) goto L_0x0084
            r14.zzh(r10)
            int r9 = r14.zzv()
            if (r9 != r13) goto L_0x0084
            r11 = 1447187017(0x56425249, float:5.3414667E13)
            goto L_0x0085
        L_0x0084:
            r11 = 0
        L_0x0085:
            if (r11 == r12) goto L_0x00aa
            if (r11 != r15) goto L_0x008a
            goto L_0x00aa
        L_0x008a:
            if (r11 != r13) goto L_0x00a5
            long r9 = r17.zzo()
            long r11 = r17.zzn()
            com.google.android.gms.internal.ads.zzrc r13 = r0.zzd
            com.google.android.gms.internal.ads.zzvv r2 = com.google.android.gms.internal.ads.zzvv.zzd(r9, r11, r13, r14)
            com.google.android.gms.internal.ads.zzrc r9 = r0.zzd
            int r9 = r9.zzc
            r10 = r1
            com.google.android.gms.internal.ads.zzsx r10 = (com.google.android.gms.internal.ads.zzsx) r10
            r10.zze(r9, r4)
            goto L_0x010d
        L_0x00a5:
            r17.zzl()
            r2 = 0
            goto L_0x010d
        L_0x00aa:
            long r9 = r17.zzo()
            long r12 = r17.zzn()
            com.google.android.gms.internal.ads.zzrc r8 = r0.zzd
            r7 = r11
            r11 = r12
            r13 = r8
            com.google.android.gms.internal.ads.zzvw r8 = com.google.android.gms.internal.ads.zzvw.zzd(r9, r11, r13, r14)
            if (r8 == 0) goto L_0x00f3
            com.google.android.gms.internal.ads.zztp r9 = r0.zze
            boolean r9 = r9.zzb()
            if (r9 != 0) goto L_0x00f3
            r17.zzl()
            r9 = r1
            com.google.android.gms.internal.ads.zzsx r9 = (com.google.android.gms.internal.ads.zzsx) r9
            int r2 = r2 + 141
            r9.zzj(r2, r4)
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            byte[] r2 = r2.zzi()
            r10 = 3
            r9.zzh(r2, r4, r10, r4)
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            r2.zzh(r4)
            com.google.android.gms.internal.ads.zztp r2 = r0.zze
            com.google.android.gms.internal.ads.zzakr r9 = r0.zzc
            int r9 = r9.zzr()
            int r10 = r9 >> 12
            r9 = r9 & 4095(0xfff, float:5.738E-42)
            if (r10 > 0) goto L_0x00ef
            if (r9 <= 0) goto L_0x00f3
        L_0x00ef:
            r2.zza = r10
            r2.zzb = r9
        L_0x00f3:
            com.google.android.gms.internal.ads.zzrc r2 = r0.zzd
            int r2 = r2.zzc
            r9 = r1
            com.google.android.gms.internal.ads.zzsx r9 = (com.google.android.gms.internal.ads.zzsx) r9
            r9.zze(r2, r4)
            if (r8 == 0) goto L_0x010c
            boolean r2 = r8.zza()
            if (r2 != 0) goto L_0x010c
            if (r7 != r15) goto L_0x010c
            com.google.android.gms.internal.ads.zzvu r2 = r16.zzj(r17)
            goto L_0x010d
        L_0x010c:
            r2 = r8
        L_0x010d:
            com.google.android.gms.internal.ads.zzabe r7 = r0.zzl
            long r8 = r17.zzn()
            if (r7 == 0) goto L_0x0158
            int r10 = r7.zza()
            r11 = 0
        L_0x011a:
            if (r11 >= r10) goto L_0x0158
            com.google.android.gms.internal.ads.zzabd r12 = r7.zzb(r11)
            boolean r13 = r12 instanceof com.google.android.gms.internal.ads.zzack
            if (r13 == 0) goto L_0x0155
            com.google.android.gms.internal.ads.zzack r12 = (com.google.android.gms.internal.ads.zzack) r12
            int r10 = r7.zza()
            r11 = 0
        L_0x012b:
            if (r11 >= r10) goto L_0x014f
            com.google.android.gms.internal.ads.zzabd r13 = r7.zzb(r11)
            boolean r14 = r13 instanceof com.google.android.gms.internal.ads.zzaco
            if (r14 == 0) goto L_0x014c
            com.google.android.gms.internal.ads.zzaco r13 = (com.google.android.gms.internal.ads.zzaco) r13
            java.lang.String r14 = r13.zzf
            java.lang.String r15 = "TLEN"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x014c
            java.lang.String r7 = r13.zzb
            long r10 = java.lang.Long.parseLong(r7)
            long r10 = com.google.android.gms.internal.ads.zzig.zzb(r10)
            goto L_0x0150
        L_0x014c:
            int r11 = r11 + 1
            goto L_0x012b
        L_0x014f:
            r10 = r5
        L_0x0150:
            com.google.android.gms.internal.ads.zzvp r7 = com.google.android.gms.internal.ads.zzvp.zzd(r8, r12, r10)
            goto L_0x0159
        L_0x0155:
            int r11 = r11 + 1
            goto L_0x011a
        L_0x0158:
            r7 = 0
        L_0x0159:
            boolean r8 = r0.zzr
            if (r8 == 0) goto L_0x0163
            com.google.android.gms.internal.ads.zzvt r2 = new com.google.android.gms.internal.ads.zzvt
            r2.<init>()
            goto L_0x0170
        L_0x0163:
            if (r7 == 0) goto L_0x0167
            r2 = r7
            goto L_0x016a
        L_0x0167:
            if (r2 != 0) goto L_0x016a
            r2 = 0
        L_0x016a:
            if (r2 != 0) goto L_0x0170
            com.google.android.gms.internal.ads.zzvu r2 = r16.zzj(r17)
        L_0x0170:
            r0.zzq = r2
            com.google.android.gms.internal.ads.zztd r7 = r0.zzh
            r7.zzbm(r2)
            com.google.android.gms.internal.ads.zztz r2 = r0.zzj
            com.google.android.gms.internal.ads.zzkb r7 = new com.google.android.gms.internal.ads.zzkb
            r7.<init>()
            com.google.android.gms.internal.ads.zzrc r8 = r0.zzd
            java.lang.String r8 = r8.zzb
            r7.zzj(r8)
            r8 = 4096(0x1000, float:5.74E-42)
            r7.zzk(r8)
            com.google.android.gms.internal.ads.zzrc r8 = r0.zzd
            int r8 = r8.zze
            r7.zzw(r8)
            com.google.android.gms.internal.ads.zzrc r8 = r0.zzd
            int r8 = r8.zzd
            r7.zzx(r8)
            com.google.android.gms.internal.ads.zztp r8 = r0.zze
            int r8 = r8.zza
            r7.zzz(r8)
            com.google.android.gms.internal.ads.zztp r8 = r0.zze
            int r8 = r8.zzb
            r7.zzA(r8)
            com.google.android.gms.internal.ads.zzabe r8 = r0.zzl
            r7.zzi(r8)
            com.google.android.gms.internal.ads.zzkc r7 = r7.zzD()
            r2.zza(r7)
            long r7 = r17.zzn()
            r0.zzo = r7
            goto L_0x01d3
        L_0x01b9:
            long r7 = r0.zzo
            r9 = 0
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x01d3
            long r7 = r17.zzn()
            long r9 = r0.zzo
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x01d3
            r2 = r1
            com.google.android.gms.internal.ads.zzsx r2 = (com.google.android.gms.internal.ads.zzsx) r2
            long r9 = r9 - r7
            int r7 = (int) r9
            r2.zze(r7, r4)
        L_0x01d3:
            int r2 = r0.zzp
            if (r2 != 0) goto L_0x0237
            r17.zzl()
            boolean r2 = r16.zzi(r17)
            if (r2 == 0) goto L_0x01e1
            goto L_0x0249
        L_0x01e1:
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            r2.zzh(r4)
            com.google.android.gms.internal.ads.zzakr r2 = r0.zzc
            int r2 = r2.zzv()
            int r7 = r0.zzk
            long r7 = (long) r7
            boolean r7 = zzk(r2, r7)
            if (r7 == 0) goto L_0x022e
            int r7 = com.google.android.gms.internal.ads.zzrd.zza(r2)
            if (r7 != r3) goto L_0x01fc
            goto L_0x022e
        L_0x01fc:
            com.google.android.gms.internal.ads.zzrc r7 = r0.zzd
            r7.zza(r2)
            long r7 = r0.zzm
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0213
            com.google.android.gms.internal.ads.zzvu r2 = r0.zzq
            long r5 = r17.zzn()
            long r5 = r2.zze(r5)
            r0.zzm = r5
        L_0x0213:
            com.google.android.gms.internal.ads.zzrc r2 = r0.zzd
            int r5 = r2.zzc
            r0.zzp = r5
            com.google.android.gms.internal.ads.zzvu r6 = r0.zzq
            boolean r7 = r6 instanceof com.google.android.gms.internal.ads.zzvo
            if (r7 != 0) goto L_0x0221
            r2 = r5
            goto L_0x0237
        L_0x0221:
            com.google.android.gms.internal.ads.zzvo r6 = (com.google.android.gms.internal.ads.zzvo) r6
            long r3 = r0.zzn
            int r1 = r2.zzg
            long r1 = (long) r1
            long r3 = r3 + r1
            r0.zzc(r3)
            r1 = 0
            throw r1
        L_0x022e:
            com.google.android.gms.internal.ads.zzsx r1 = (com.google.android.gms.internal.ads.zzsx) r1
            r5 = 1
            r1.zze(r5, r4)
            r0.zzk = r4
            goto L_0x0248
        L_0x0237:
            r5 = 1
            com.google.android.gms.internal.ads.zztz r6 = r0.zzj
            int r1 = r6.zze(r1, r2, r5)
            if (r1 != r3) goto L_0x0241
            goto L_0x0249
        L_0x0241:
            int r2 = r0.zzp
            int r2 = r2 - r1
            r0.zzp = r2
            if (r2 <= 0) goto L_0x024a
        L_0x0248:
            r3 = 0
        L_0x0249:
            return r3
        L_0x024a:
            com.google.android.gms.internal.ads.zztz r5 = r0.zzj
            long r1 = r0.zzn
            long r6 = r0.zzc(r1)
            r8 = 1
            com.google.android.gms.internal.ads.zzrc r1 = r0.zzd
            int r9 = r1.zzc
            r10 = 0
            r11 = 0
            r5.zzd(r6, r8, r9, r10, r11)
            long r1 = r0.zzn
            com.google.android.gms.internal.ads.zzrc r3 = r0.zzd
            int r3 = r3.zzg
            long r5 = (long) r3
            long r1 = r1 + r5
            r0.zzn = r1
            r0.zzp = r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvs.zzb(com.google.android.gms.internal.ads.zztb):int");
    }

    private final long zzc(long j) {
        return ((j * 1000000) / ((long) this.zzd.zzd)) + this.zzm;
    }

    private final boolean zzh(zztb zztb, boolean z) throws IOException {
        int i;
        int i2;
        int zza2;
        int i3 = true != z ? 131072 : 32768;
        zztb.zzl();
        if (zztb.zzn() == 0) {
            zzabe zza3 = this.zzf.zza(zztb, (zzacd) null);
            this.zzl = zza3;
            if (zza3 != null) {
                this.zze.zza(zza3);
            }
            i = (int) zztb.zzm();
            if (!z) {
                ((zzsx) zztb).zze(i, false);
            }
            i2 = 0;
        } else {
            i2 = 0;
            i = 0;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (!zzi(zztb)) {
                this.zzc.zzh(0);
                int zzv = this.zzc.zzv();
                if ((i2 == 0 || zzk(zzv, (long) i2)) && (zza2 = zzrd.zza(zzv)) != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                    } else {
                        this.zzd.zza(zzv);
                        i2 = zzv;
                    }
                    ((zzsx) zztb).zzj(zza2 - 4, false);
                } else {
                    int i6 = i5 + 1;
                    if (i5 != i3) {
                        if (z) {
                            zztb.zzl();
                            ((zzsx) zztb).zzj(i + i6, false);
                        } else {
                            ((zzsx) zztb).zze(1, false);
                        }
                        i5 = i6;
                        i2 = 0;
                        i4 = 0;
                    } else if (z) {
                        return false;
                    } else {
                        throw new zzlg("Searched too many bytes.", (Throwable) null);
                    }
                }
            } else if (i4 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            ((zzsx) zztb).zze(i + i5, false);
        } else {
            zztb.zzl();
        }
        this.zzk = i2;
        return true;
    }

    private final boolean zzi(zztb zztb) throws IOException {
        zzvu zzvu = this.zzq;
        if (zzvu != null) {
            long zzf2 = zzvu.zzf();
            if (zzf2 != -1 && zztb.zzm() > zzf2 - 4) {
                return true;
            }
        }
        try {
            return !zztb.zzh(this.zzc.zzi(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final zzvu zzj(zztb zztb) throws IOException {
        ((zzsx) zztb).zzh(this.zzc.zzi(), 0, 4, false);
        this.zzc.zzh(0);
        this.zzd.zza(this.zzc.zzv());
        return new zzvn(zztb.zzo(), zztb.zzn(), this.zzd);
    }

    public static boolean zzk(int i, long j) {
        return ((long) (i & -128000)) == (j & -128000);
    }

    public final void zza() {
        this.zzr = true;
    }

    public final boolean zzd(zztb zztb) throws IOException {
        return zzh(zztb, true);
    }

    public final void zze(zztd zztd) {
        this.zzh = zztd;
        zztz zza2 = zztd.zza(0, 1);
        this.zzi = zza2;
        this.zzj = zza2;
        this.zzh.zzbl();
    }

    public final int zzf(zztb zztb, zzts zzts) throws IOException {
        zzajg.zze(this.zzi);
        int i = zzalh.zza;
        int zzb2 = zzb(zztb);
        if (zzb2 == -1 && (this.zzq instanceof zzvo)) {
            if (this.zzq.zzc() != zzc(this.zzn)) {
                zzvo zzvo = (zzvo) this.zzq;
                throw null;
            }
        }
        return zzb2;
    }

    public final void zzg(long j, long j2) {
        this.zzk = 0;
        this.zzm = -9223372036854775807L;
        this.zzn = 0;
        this.zzp = 0;
        zzvu zzvu = this.zzq;
        if (zzvu instanceof zzvo) {
            zzvo zzvo = (zzvo) zzvu;
            throw null;
        }
    }

    public zzvs(int i) {
        this.zzc = new zzakr(10);
        this.zzd = new zzrc();
        this.zze = new zztp();
        this.zzm = -9223372036854775807L;
        this.zzf = new zztq();
        zzsz zzsz = new zzsz();
        this.zzg = zzsz;
        this.zzj = zzsz;
    }
}
