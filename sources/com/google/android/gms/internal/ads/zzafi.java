package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzafi implements zztz {
    @Nullable
    public zzkc zzA;
    public boolean zzB;
    public boolean zzC;
    @Nullable
    public zzsj zzD;
    public final zzafc zza;
    public final zzaff zzb = new zzaff();
    public final zzafp<zzafg> zzc = new zzafp<>(zzafd.zza);
    @Nullable
    public final zzsi zzd;
    @Nullable
    public final zzsd zze;
    @Nullable
    public final Looper zzf;
    @Nullable
    public zzafh zzg;
    @Nullable
    public zzkc zzh;
    public int zzi = 1000;
    public int[] zzj = new int[1000];
    public long[] zzk = new long[1000];
    public int[] zzl = new int[1000];
    public int[] zzm = new int[1000];
    public long[] zzn = new long[1000];
    public zzty[] zzo = new zzty[1000];
    public int zzp;
    public int zzq;
    public int zzr;
    public int zzs;
    public long zzt = Long.MIN_VALUE;
    public long zzu = Long.MIN_VALUE;
    public long zzv = Long.MIN_VALUE;
    public boolean zzw;
    public boolean zzx = true;
    public boolean zzy = true;
    @Nullable
    public zzkc zzz;

    public zzafi(zzahy zzahy, @Nullable Looper looper, @Nullable zzsi zzsi, @Nullable zzsd zzsd, byte[] bArr) {
        this.zzf = looper;
        this.zzd = zzsi;
        this.zze = zzsd;
        this.zza = new zzafc(zzahy, (byte[]) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized int zzA(com.google.android.gms.internal.ads.zzkd r6, com.google.android.gms.internal.ads.zzrr r7, boolean r8, boolean r9, com.google.android.gms.internal.ads.zzaff r10) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r7.zzc = r0     // Catch:{ all -> 0x0083 }
            boolean r0 = r5.zzG()     // Catch:{ all -> 0x0083 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x002b
            if (r9 != 0) goto L_0x0025
            boolean r9 = r5.zzw     // Catch:{ all -> 0x0083 }
            if (r9 == 0) goto L_0x0014
            goto L_0x0025
        L_0x0014:
            com.google.android.gms.internal.ads.zzkc r7 = r5.zzA     // Catch:{ all -> 0x0083 }
            if (r7 == 0) goto L_0x0023
            if (r8 != 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzkc r8 = r5.zzh     // Catch:{ all -> 0x0083 }
            if (r7 == r8) goto L_0x0023
        L_0x001e:
            r5.zzH(r7, r6)     // Catch:{ all -> 0x0083 }
            monitor-exit(r5)
            return r1
        L_0x0023:
            monitor-exit(r5)
            return r2
        L_0x0025:
            r6 = 4
            r7.zzf(r6)     // Catch:{ all -> 0x0083 }
            monitor-exit(r5)
            return r3
        L_0x002b:
            com.google.android.gms.internal.ads.zzafp<com.google.android.gms.internal.ads.zzafg> r9 = r5.zzc     // Catch:{ all -> 0x0083 }
            int r0 = r5.zzq     // Catch:{ all -> 0x0083 }
            int r4 = r5.zzs     // Catch:{ all -> 0x0083 }
            int r0 = r0 + r4
            java.lang.Object r9 = r9.zza(r0)     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzafg r9 = (com.google.android.gms.internal.ads.zzafg) r9     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzkc r9 = r9.zza     // Catch:{ all -> 0x0083 }
            if (r8 != 0) goto L_0x007e
            com.google.android.gms.internal.ads.zzkc r8 = r5.zzh     // Catch:{ all -> 0x0083 }
            if (r9 == r8) goto L_0x0041
            goto L_0x007e
        L_0x0041:
            int r6 = r5.zzs     // Catch:{ all -> 0x0083 }
            int r6 = r5.zzL(r6)     // Catch:{ all -> 0x0083 }
            boolean r8 = r5.zzI(r6)     // Catch:{ all -> 0x0083 }
            if (r8 != 0) goto L_0x0052
            r6 = 1
            r7.zzc = r6     // Catch:{ all -> 0x0083 }
            monitor-exit(r5)
            return r2
        L_0x0052:
            int[] r8 = r5.zzm     // Catch:{ all -> 0x0083 }
            r8 = r8[r6]     // Catch:{ all -> 0x0083 }
            r7.zzf(r8)     // Catch:{ all -> 0x0083 }
            long[] r8 = r5.zzn     // Catch:{ all -> 0x0083 }
            r0 = r8[r6]     // Catch:{ all -> 0x0083 }
            r7.zzd = r0     // Catch:{ all -> 0x0083 }
            long r8 = r5.zzt     // Catch:{ all -> 0x0083 }
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x006a
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r7.zzg(r8)     // Catch:{ all -> 0x0083 }
        L_0x006a:
            int[] r7 = r5.zzl     // Catch:{ all -> 0x0083 }
            r7 = r7[r6]     // Catch:{ all -> 0x0083 }
            r10.zza = r7     // Catch:{ all -> 0x0083 }
            long[] r7 = r5.zzk     // Catch:{ all -> 0x0083 }
            r8 = r7[r6]     // Catch:{ all -> 0x0083 }
            r10.zzb = r8     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzty[] r7 = r5.zzo     // Catch:{ all -> 0x0083 }
            r6 = r7[r6]     // Catch:{ all -> 0x0083 }
            r10.zzc = r6     // Catch:{ all -> 0x0083 }
            monitor-exit(r5)
            return r3
        L_0x007e:
            r5.zzH(r9, r6)     // Catch:{ all -> 0x0083 }
            monitor-exit(r5)
            return r1
        L_0x0083:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafi.zzA(com.google.android.gms.internal.ads.zzkd, com.google.android.gms.internal.ads.zzrr, boolean, boolean, com.google.android.gms.internal.ads.zzaff):int");
    }

    private final synchronized boolean zzB(zzkc zzkc) {
        this.zzy = false;
        if (zzalh.zzc(zzkc, this.zzA)) {
            return false;
        }
        if (this.zzc.zzf() || !this.zzc.zzc().zza.equals(zzkc)) {
            this.zzA = zzkc;
        } else {
            this.zzA = this.zzc.zzc().zza;
        }
        zzkc zzkc2 = this.zzA;
        this.zzB = zzakg.zzc(zzkc2.zzl, zzkc2.zzi);
        this.zzC = false;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized long zzC(long r10, boolean r12, boolean r13) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r12 = r9.zzp     // Catch:{ all -> 0x002f }
            r0 = -1
            if (r12 == 0) goto L_0x002d
            long[] r2 = r9.zzn     // Catch:{ all -> 0x002f }
            int r4 = r9.zzr     // Catch:{ all -> 0x002f }
            r5 = r2[r4]     // Catch:{ all -> 0x002f }
            int r2 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0012
            goto L_0x002d
        L_0x0012:
            if (r13 == 0) goto L_0x001a
            int r13 = r9.zzs     // Catch:{ all -> 0x002f }
            if (r13 == r12) goto L_0x001a
            int r12 = r13 + 1
        L_0x001a:
            r5 = r12
            r8 = 0
            r3 = r9
            r6 = r10
            int r10 = r3.zzJ(r4, r5, r6, r8)     // Catch:{ all -> 0x002f }
            r11 = -1
            if (r10 != r11) goto L_0x0027
            monitor-exit(r9)
            return r0
        L_0x0027:
            long r10 = r9.zzK(r10)     // Catch:{ all -> 0x002f }
            monitor-exit(r9)
            return r10
        L_0x002d:
            monitor-exit(r9)
            return r0
        L_0x002f:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafi.zzC(long, boolean, boolean):long");
    }

    private final synchronized long zzD() {
        int i = this.zzp;
        if (i == 0) {
            return -1;
        }
        return zzK(i);
    }

    private final void zzE() {
        if (this.zzD != null) {
            this.zzD = null;
            this.zzh = null;
        }
    }

    private final synchronized void zzF(long j, int i, long j2, int i2, @Nullable zzty zzty) {
        int i3 = this.zzp;
        if (i3 > 0) {
            int zzL = zzL(i3 - 1);
            zzajg.zza(this.zzk[zzL] + ((long) this.zzl[zzL]) <= j2);
        }
        this.zzw = (536870912 & i) != 0;
        this.zzv = Math.max(this.zzv, j);
        int zzL2 = zzL(this.zzp);
        this.zzn[zzL2] = j;
        this.zzk[zzL2] = j2;
        this.zzl[zzL2] = i2;
        this.zzm[zzL2] = i;
        this.zzo[zzL2] = zzty;
        this.zzj[zzL2] = 0;
        if (this.zzc.zzf() || !this.zzc.zzc().zza.equals(this.zzA)) {
            zzsh zzsh = zzsh.zzb;
            zzafp<zzafg> zzafp = this.zzc;
            int i4 = this.zzq + this.zzp;
            zzkc zzkc = this.zzA;
            if (zzkc != null) {
                zzafp.zzb(i4, new zzafg(zzkc, zzsh, (zzafe) null));
            } else {
                throw null;
            }
        }
        int i5 = this.zzp + 1;
        this.zzp = i5;
        int i6 = this.zzi;
        if (i5 == i6) {
            int i7 = i6 + 1000;
            int[] iArr = new int[i7];
            long[] jArr = new long[i7];
            long[] jArr2 = new long[i7];
            int[] iArr2 = new int[i7];
            int[] iArr3 = new int[i7];
            zzty[] zztyArr = new zzty[i7];
            int i8 = this.zzr;
            int i9 = i6 - i8;
            System.arraycopy(this.zzk, i8, jArr, 0, i9);
            System.arraycopy(this.zzn, this.zzr, jArr2, 0, i9);
            System.arraycopy(this.zzm, this.zzr, iArr2, 0, i9);
            System.arraycopy(this.zzl, this.zzr, iArr3, 0, i9);
            System.arraycopy(this.zzo, this.zzr, zztyArr, 0, i9);
            System.arraycopy(this.zzj, this.zzr, iArr, 0, i9);
            int i10 = this.zzr;
            System.arraycopy(this.zzk, 0, jArr, i9, i10);
            System.arraycopy(this.zzn, 0, jArr2, i9, i10);
            System.arraycopy(this.zzm, 0, iArr2, i9, i10);
            System.arraycopy(this.zzl, 0, iArr3, i9, i10);
            System.arraycopy(this.zzo, 0, zztyArr, i9, i10);
            System.arraycopy(this.zzj, 0, iArr, i9, i10);
            this.zzk = jArr;
            this.zzn = jArr2;
            this.zzm = iArr2;
            this.zzl = iArr3;
            this.zzo = zztyArr;
            this.zzj = iArr;
            this.zzr = 0;
            this.zzi = i7;
        }
    }

    private final boolean zzG() {
        return this.zzs != this.zzp;
    }

    private final void zzH(zzkc zzkc, zzkd zzkd) {
        zzkc zzkc2 = this.zzh;
        zzsj zzsj = null;
        zzsa zzsa = zzkc2 == null ? null : zzkc2.zzo;
        this.zzh = zzkc;
        zzsa zzsa2 = zzkc.zzo;
        zzkd.zza = zzkc.zzb(this.zzd.zza(zzkc));
        zzkd.zzb = this.zzD;
        if (zzkc2 == null || !zzalh.zzc(zzsa, zzsa2)) {
            if (zzkc.zzo != null) {
                zzsj = new zzsj(new zzsb(new zzsl(1)));
            }
            this.zzD = zzsj;
            zzkd.zzb = zzsj;
        }
    }

    private final boolean zzI(int i) {
        if (this.zzD != null) {
            return (this.zzm[i] & 1073741824) != 0 ? false : false;
        }
        return true;
    }

    private final int zzJ(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.zzn[i];
            if (j2 > j) {
                return i3;
            }
            if (!z || (this.zzm[i] & 1) != 0) {
                if (j2 == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.zzi) {
                i = 0;
            }
        }
        return i3;
    }

    @GuardedBy("this")
    private final long zzK(int i) {
        long j = this.zzu;
        long j2 = Long.MIN_VALUE;
        if (i != 0) {
            int zzL = zzL(i - 1);
            for (int i2 = 0; i2 < i; i2++) {
                j2 = Math.max(j2, this.zzn[zzL]);
                if ((this.zzm[zzL] & 1) != 0) {
                    break;
                }
                zzL--;
                if (zzL == -1) {
                    zzL = this.zzi - 1;
                }
            }
        }
        this.zzu = Math.max(j, j2);
        this.zzp -= i;
        int i3 = this.zzq + i;
        this.zzq = i3;
        int i4 = this.zzr + i;
        this.zzr = i4;
        int i5 = this.zzi;
        if (i4 >= i5) {
            this.zzr = i4 - i5;
        }
        int i6 = this.zzs - i;
        this.zzs = i6;
        if (i6 < 0) {
            this.zzs = 0;
        }
        this.zzc.zzd(i3);
        if (this.zzp != 0) {
            return this.zzk[this.zzr];
        }
        int i7 = this.zzr;
        if (i7 == 0) {
            i7 = this.zzi;
        }
        int i8 = i7 - 1;
        return this.zzk[i8] + ((long) this.zzl[i8]);
    }

    private final int zzL(int i) {
        int i2 = this.zzr + i;
        int i3 = this.zzi;
        return i2 < i3 ? i2 : i2 - i3;
    }

    private final synchronized void zzz() {
        this.zzs = 0;
        this.zza.zzb();
    }

    public final void zza(zzkc zzkc) {
        this.zzz = zzkc;
        boolean zzB2 = zzB(zzkc);
        zzafh zzafh = this.zzg;
        if (zzafh != null && zzB2) {
            zzafh.zzw(zzkc);
        }
    }

    public final int zzb(zzahq zzahq, int i, boolean z, int i2) throws IOException {
        return this.zza.zzg(zzahq, i, z);
    }

    public final void zzc(zzakr zzakr, int i, int i2) {
        this.zza.zzh(zzakr, i);
    }

    public final void zzd(long j, int i, int i2, int i3, @Nullable zzty zzty) {
        int i4 = i & 1;
        if (this.zzx) {
            if (i4 != 0) {
                this.zzx = false;
            } else {
                return;
            }
        }
        if (this.zzB) {
            if (j >= this.zzt) {
                if (i4 == 0) {
                    if (!this.zzC) {
                        String valueOf = String.valueOf(this.zzA);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 50);
                        sb.append("Overriding unexpected non-sync sample for format: ");
                        sb.append(valueOf);
                        Log.w("SampleQueue", sb.toString());
                        this.zzC = true;
                    }
                    i |= 1;
                }
            } else {
                return;
            }
        }
        zzF(j, i, (this.zza.zzf() - ((long) i2)) - ((long) i3), i2, zzty);
    }

    public final int zze(zzahq zzahq, int i, boolean z) throws IOException {
        return zztx.zza(this, zzahq, i, true);
    }

    public final void zzf(zzakr zzakr, int i) {
        zztx.zzb(this, zzakr, i);
    }

    @CallSuper
    public final void zzg() {
        zzh(true);
        zzE();
    }

    @CallSuper
    public final void zzh(boolean z) {
        this.zza.zza();
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzx = true;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = Long.MIN_VALUE;
        this.zzw = false;
        this.zzc.zze();
        if (z) {
            this.zzz = null;
            this.zzA = null;
            this.zzy = true;
        }
    }

    public final void zzi(long j) {
        this.zzt = j;
    }

    public final int zzj() {
        return this.zzq + this.zzp;
    }

    @CallSuper
    public final void zzk() {
        zzw();
        zzE();
    }

    @CallSuper
    public final void zzl() throws IOException {
        zzsj zzsj = this.zzD;
        if (zzsj != null) {
            throw zzsj.zza();
        }
    }

    public final int zzm() {
        return this.zzq + this.zzs;
    }

    @Nullable
    public final synchronized zzkc zzn() {
        if (this.zzy) {
            return null;
        }
        return this.zzA;
    }

    public final synchronized long zzo() {
        return this.zzv;
    }

    public final synchronized boolean zzp() {
        return this.zzw;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001c, code lost:
        return r1;
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzq(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzG()     // Catch:{ all -> 0x003e }
            r1 = 1
            if (r0 != 0) goto L_0x001d
            r0 = 0
            if (r4 != 0) goto L_0x001b
            boolean r4 = r3.zzw     // Catch:{ all -> 0x003e }
            if (r4 != 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzkc r4 = r3.zzA     // Catch:{ all -> 0x003e }
            if (r4 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzkc r2 = r3.zzh     // Catch:{ all -> 0x003e }
            if (r4 == r2) goto L_0x0018
            goto L_0x001b
        L_0x0018:
            monitor-exit(r3)
            return r0
        L_0x001a:
            r1 = 0
        L_0x001b:
            monitor-exit(r3)
            return r1
        L_0x001d:
            com.google.android.gms.internal.ads.zzafp<com.google.android.gms.internal.ads.zzafg> r4 = r3.zzc     // Catch:{ all -> 0x003e }
            int r0 = r3.zzq     // Catch:{ all -> 0x003e }
            int r2 = r3.zzs     // Catch:{ all -> 0x003e }
            int r0 = r0 + r2
            java.lang.Object r4 = r4.zza(r0)     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzafg r4 = (com.google.android.gms.internal.ads.zzafg) r4     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzkc r4 = r4.zza     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzkc r0 = r3.zzh     // Catch:{ all -> 0x003e }
            if (r4 == r0) goto L_0x0032
            monitor-exit(r3)
            return r1
        L_0x0032:
            int r4 = r3.zzs     // Catch:{ all -> 0x003e }
            int r4 = r3.zzL(r4)     // Catch:{ all -> 0x003e }
            boolean r4 = r3.zzI(r4)     // Catch:{ all -> 0x003e }
            monitor-exit(r3)
            return r4
        L_0x003e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafi.zzq(boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (r9 != 0) goto L_0x003d;
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzr(com.google.android.gms.internal.ads.zzkd r9, com.google.android.gms.internal.ads.zzrr r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = r11 & 2
            r1 = 1
            if (r0 == 0) goto L_0x0007
            r5 = 1
            goto L_0x0009
        L_0x0007:
            r0 = 0
            r5 = 0
        L_0x0009:
            com.google.android.gms.internal.ads.zzaff r7 = r8.zzb
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            int r9 = r2.zzA(r3, r4, r5, r6, r7)
            r12 = -4
            if (r9 != r12) goto L_0x003e
            boolean r9 = r10.zzc()
            if (r9 != 0) goto L_0x003d
            r9 = r11 & 1
            r11 = r11 & 4
            if (r11 != 0) goto L_0x0034
            if (r9 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzafc r9 = r8.zza
            com.google.android.gms.internal.ads.zzaff r11 = r8.zzb
            r9.zzd(r10, r11)
            goto L_0x003d
        L_0x002c:
            com.google.android.gms.internal.ads.zzafc r9 = r8.zza
            com.google.android.gms.internal.ads.zzaff r11 = r8.zzb
            r9.zzc(r10, r11)
            goto L_0x0037
        L_0x0034:
            if (r9 == 0) goto L_0x0037
            goto L_0x003d
        L_0x0037:
            int r9 = r8.zzs
            int r9 = r9 + r1
            r8.zzs = r9
            return r12
        L_0x003d:
            r9 = -4
        L_0x003e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafi.zzr(com.google.android.gms.internal.ads.zzkd, com.google.android.gms.internal.ads.zzrr, int, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzs(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.zzz()     // Catch:{ all -> 0x003f }
            int r0 = r8.zzs     // Catch:{ all -> 0x003f }
            int r2 = r8.zzL(r0)     // Catch:{ all -> 0x003f }
            boolean r0 = r8.zzG()     // Catch:{ all -> 0x003f }
            r7 = 0
            if (r0 == 0) goto L_0x003d
            long[] r0 = r8.zzn     // Catch:{ all -> 0x003f }
            r3 = r0[r2]     // Catch:{ all -> 0x003f }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x003d
            long r0 = r8.zzv     // Catch:{ all -> 0x003f }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0021
            if (r11 == 0) goto L_0x003d
        L_0x0021:
            int r11 = r8.zzp     // Catch:{ all -> 0x003f }
            int r0 = r8.zzs     // Catch:{ all -> 0x003f }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r11 = r1.zzJ(r2, r3, r4, r6)     // Catch:{ all -> 0x003f }
            r0 = -1
            if (r11 != r0) goto L_0x0033
            monitor-exit(r8)
            return r7
        L_0x0033:
            r8.zzt = r9     // Catch:{ all -> 0x003f }
            int r9 = r8.zzs     // Catch:{ all -> 0x003f }
            int r9 = r9 + r11
            r8.zzs = r9     // Catch:{ all -> 0x003f }
            r9 = 1
            monitor-exit(r8)
            return r9
        L_0x003d:
            monitor-exit(r8)
            return r7
        L_0x003f:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafi.zzs(long, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        if (r9 != -1) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zzt(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.zzs     // Catch:{ all -> 0x003c }
            int r2 = r8.zzL(r0)     // Catch:{ all -> 0x003c }
            boolean r0 = r8.zzG()     // Catch:{ all -> 0x003c }
            r7 = 0
            if (r0 == 0) goto L_0x003a
            long[] r0 = r8.zzn     // Catch:{ all -> 0x003c }
            r3 = r0[r2]     // Catch:{ all -> 0x003c }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0017
            goto L_0x003a
        L_0x0017:
            long r0 = r8.zzv     // Catch:{ all -> 0x003c }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0027
            if (r11 != 0) goto L_0x0020
            goto L_0x0027
        L_0x0020:
            int r9 = r8.zzp     // Catch:{ all -> 0x003c }
            int r10 = r8.zzs     // Catch:{ all -> 0x003c }
            int r9 = r9 - r10
            monitor-exit(r8)
            return r9
        L_0x0027:
            int r11 = r8.zzp     // Catch:{ all -> 0x003c }
            int r0 = r8.zzs     // Catch:{ all -> 0x003c }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.zzJ(r2, r3, r4, r6)     // Catch:{ all -> 0x003c }
            r10 = -1
            monitor-exit(r8)
            if (r9 != r10) goto L_0x0039
            return r7
        L_0x0039:
            return r9
        L_0x003a:
            monitor-exit(r8)
            return r7
        L_0x003c:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafi.zzt(long, boolean):int");
    }

    public final synchronized void zzu(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.zzs + i <= this.zzp) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzajg.zza(z);
        this.zzs += i;
    }

    public final void zzv(long j, boolean z, boolean z2) {
        this.zza.zze(zzC(j, false, z2));
    }

    public final void zzw() {
        this.zza.zze(zzD());
    }

    public final void zzx(@Nullable zzafh zzafh) {
        this.zzg = zzafh;
    }
}
