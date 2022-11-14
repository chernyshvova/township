package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqw implements zzqf {
    public float zzA;
    public zzpn[] zzB;
    public ByteBuffer[] zzC;
    @Nullable
    public ByteBuffer zzD;
    @Nullable
    public ByteBuffer zzE;
    public byte[] zzF;
    public int zzG;
    public int zzH;
    public boolean zzI;
    public boolean zzJ;
    public boolean zzK;
    public boolean zzL;
    public int zzM;
    public zzqk zzN;
    public boolean zzO;
    public long zzP;
    public boolean zzQ;
    public boolean zzR;
    public final zzqp zzS;
    public final zzqm zza = new zzqm();
    public final zzrj zzb = new zzrj();
    public final zzpn[] zzc;
    public final zzpn[] zzd;
    public final ConditionVariable zze = new ConditionVariable(true);
    public final zzqj zzf = new zzqj(new zzqs(this, (zzqn) null));
    public final ArrayDeque<zzqq> zzg;
    public zzqv zzh;
    public final zzqr<zzqb> zzi;
    public final zzqr<zzqe> zzj;
    @Nullable
    public zzqc zzk;
    @Nullable
    public zzqo zzl;
    public zzqo zzm;
    @Nullable
    public AudioTrack zzn;
    public zzpi zzo;
    @Nullable
    public zzqq zzp;
    public zzqq zzq;
    public final zzll zzr;
    @Nullable
    public ByteBuffer zzs;
    public int zzt;
    public long zzu;
    public long zzv;
    public long zzw;
    public boolean zzx;
    public boolean zzy;
    public long zzz;

    public zzqw(@Nullable zzpj zzpj, zzpn[] zzpnArr, boolean z) {
        zzqp zzqp = new zzqp(zzpnArr);
        this.zzS = zzqp;
        int i = zzalh.zza;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new zzql[]{new zzrf(), this.zza, this.zzb});
        Collections.addAll(arrayList, zzqp.zza());
        this.zzc = (zzpn[]) arrayList.toArray(new zzpn[0]);
        this.zzd = new zzpn[]{new zzqy()};
        this.zzA = 1.0f;
        this.zzo = zzpi.zza;
        this.zzM = 0;
        this.zzN = new zzqk(0, 0.0f);
        this.zzq = new zzqq(zzll.zza, false, 0, 0, (zzqn) null);
        this.zzr = zzll.zza;
        this.zzH = -1;
        this.zzB = new zzpn[0];
        this.zzC = new ByteBuffer[0];
        this.zzg = new ArrayDeque<>();
        this.zzi = new zzqr<>(100);
        this.zzj = new zzqr<>(100);
    }

    private final void zzF() {
        int i = 0;
        while (true) {
            zzpn[] zzpnArr = this.zzB;
            if (i < zzpnArr.length) {
                zzpn zzpn = zzpnArr[i];
                zzpn.zzg();
                this.zzC[i] = zzpn.zze();
                i++;
            } else {
                return;
            }
        }
    }

    private final void zzG(long j) throws zzqe {
        ByteBuffer byteBuffer;
        int length = this.zzB.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzC[i - 1];
            } else {
                byteBuffer = this.zzD;
                if (byteBuffer == null) {
                    byteBuffer = zzpn.zza;
                }
            }
            if (i == length) {
                zzH(byteBuffer, j);
            } else {
                zzpn zzpn = this.zzB[i];
                if (i > this.zzH) {
                    zzpn.zzc(byteBuffer);
                }
                ByteBuffer zze2 = zzpn.zze();
                this.zzC[i] = zze2;
                if (zze2.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r15 < r14) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzH(java.nio.ByteBuffer r13, long r14) throws com.google.android.gms.internal.ads.zzqe {
        /*
            r12 = this;
            boolean r0 = r13.hasRemaining()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.nio.ByteBuffer r0 = r12.zzE
            r1 = 21
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0018
            if (r0 != r13) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            com.google.android.gms.internal.ads.zzajg.zza(r0)
            goto L_0x003b
        L_0x0018:
            r12.zzE = r13
            int r0 = com.google.android.gms.internal.ads.zzalh.zza
            if (r0 >= r1) goto L_0x003b
            int r0 = r13.remaining()
            byte[] r4 = r12.zzF
            if (r4 == 0) goto L_0x0029
            int r4 = r4.length
            if (r4 >= r0) goto L_0x002d
        L_0x0029:
            byte[] r4 = new byte[r0]
            r12.zzF = r4
        L_0x002d:
            int r4 = r13.position()
            byte[] r5 = r12.zzF
            r13.get(r5, r3, r0)
            r13.position(r4)
            r12.zzG = r3
        L_0x003b:
            int r0 = r13.remaining()
            int r4 = com.google.android.gms.internal.ads.zzalh.zza
            if (r4 >= r1) goto L_0x006f
            com.google.android.gms.internal.ads.zzqj r14 = r12.zzf
            long r4 = r12.zzv
            int r14 = r14.zzf(r4)
            if (r14 <= 0) goto L_0x006c
            int r14 = java.lang.Math.min(r0, r14)
            android.media.AudioTrack r15 = r12.zzn
            byte[] r1 = r12.zzF
            int r4 = r12.zzG
            int r14 = r15.write(r1, r4, r14)
            if (r14 <= 0) goto L_0x00f5
            int r15 = r12.zzG
            int r15 = r15 + r14
            r12.zzG = r15
            int r15 = r13.position()
            int r15 = r15 + r14
            r13.position(r15)
            goto L_0x00f5
        L_0x006c:
            r14 = 0
            goto L_0x00f5
        L_0x006f:
            boolean r1 = r12.zzO
            if (r1 == 0) goto L_0x00ef
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x007e
            r1 = 1
            goto L_0x007f
        L_0x007e:
            r1 = 0
        L_0x007f:
            com.google.android.gms.internal.ads.zzajg.zzd(r1)
            android.media.AudioTrack r6 = r12.zzn
            int r1 = com.google.android.gms.internal.ads.zzalh.zza
            r4 = 26
            r7 = 1000(0x3e8, double:4.94E-321)
            if (r1 < r4) goto L_0x0096
            r9 = 1
            long r10 = r14 * r7
            r7 = r13
            r8 = r0
            int r14 = r6.write(r7, r8, r9, r10)
            goto L_0x00f5
        L_0x0096:
            java.nio.ByteBuffer r1 = r12.zzs
            if (r1 != 0) goto L_0x00af
            r1 = 16
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)
            r12.zzs = r1
            java.nio.ByteOrder r4 = java.nio.ByteOrder.BIG_ENDIAN
            r1.order(r4)
            java.nio.ByteBuffer r1 = r12.zzs
            r4 = 1431633921(0x55550001, float:1.46372496E13)
            r1.putInt(r4)
        L_0x00af:
            int r1 = r12.zzt
            if (r1 != 0) goto L_0x00c9
            java.nio.ByteBuffer r1 = r12.zzs
            r4 = 4
            r1.putInt(r4, r0)
            java.nio.ByteBuffer r1 = r12.zzs
            r4 = 8
            long r14 = r14 * r7
            r1.putLong(r4, r14)
            java.nio.ByteBuffer r14 = r12.zzs
            r14.position(r3)
            r12.zzt = r0
        L_0x00c9:
            java.nio.ByteBuffer r14 = r12.zzs
            int r14 = r14.remaining()
            if (r14 <= 0) goto L_0x00e0
            java.nio.ByteBuffer r15 = r12.zzs
            int r15 = r6.write(r15, r14, r2)
            if (r15 >= 0) goto L_0x00dd
            r12.zzt = r3
            r14 = r15
            goto L_0x00f5
        L_0x00dd:
            if (r15 >= r14) goto L_0x00e0
            goto L_0x006c
        L_0x00e0:
            int r14 = r6.write(r13, r0, r2)
            if (r14 >= 0) goto L_0x00e9
            r12.zzt = r3
            goto L_0x00f5
        L_0x00e9:
            int r13 = r12.zzt
            int r13 = r13 - r14
            r12.zzt = r13
            goto L_0x00f5
        L_0x00ef:
            android.media.AudioTrack r14 = r12.zzn
            int r14 = r14.write(r13, r0, r2)
        L_0x00f5:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r12.zzP = r4
            if (r14 >= 0) goto L_0x0127
            int r13 = com.google.android.gms.internal.ads.zzalh.zza
            r15 = 24
            if (r13 < r15) goto L_0x0106
            r13 = -6
            if (r14 == r13) goto L_0x010c
        L_0x0106:
            r13 = -32
            if (r14 != r13) goto L_0x010b
            goto L_0x010c
        L_0x010b:
            r2 = 0
        L_0x010c:
            com.google.android.gms.internal.ads.zzqe r13 = new com.google.android.gms.internal.ads.zzqe
            com.google.android.gms.internal.ads.zzqo r15 = r12.zzm
            com.google.android.gms.internal.ads.zzkc r15 = r15.zza
            r13.<init>(r14, r15, r2)
            com.google.android.gms.internal.ads.zzqc r14 = r12.zzk
            if (r14 == 0) goto L_0x011c
            r14.zzb(r13)
        L_0x011c:
            boolean r14 = r13.zza
            if (r14 != 0) goto L_0x0126
            com.google.android.gms.internal.ads.zzqr<com.google.android.gms.internal.ads.zzqe> r14 = r12.zzj
            r14.zza(r13)
            return
        L_0x0126:
            throw r13
        L_0x0127:
            com.google.android.gms.internal.ads.zzqr<com.google.android.gms.internal.ads.zzqe> r13 = r12.zzj
            r13.zzb()
            android.media.AudioTrack r13 = r12.zzn
            boolean r13 = zzR(r13)
            if (r13 == 0) goto L_0x015f
            boolean r13 = r12.zzK
            if (r13 == 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzqc r13 = r12.zzk
            if (r13 == 0) goto L_0x015f
            if (r14 >= r0) goto L_0x015f
            boolean r13 = r12.zzR
            if (r13 != 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzqj r13 = r12.zzf
            r1 = 0
            long r1 = r13.zzg(r1)
            com.google.android.gms.internal.ads.zzqc r13 = r12.zzk
            com.google.android.gms.internal.ads.zzra r13 = (com.google.android.gms.internal.ads.zzra) r13
            com.google.android.gms.internal.ads.zzrb r15 = r13.zza
            com.google.android.gms.internal.ads.zzlz r15 = r15.zzl
            if (r15 == 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzrb r13 = r13.zza
            com.google.android.gms.internal.ads.zzlz r13 = r13.zzl
            r13.zza(r1)
        L_0x015f:
            com.google.android.gms.internal.ads.zzqo r13 = r12.zzm
            int r13 = r13.zzc
            long r1 = r12.zzv
            long r3 = (long) r14
            long r1 = r1 + r3
            r12.zzv = r1
            if (r14 != r0) goto L_0x016e
            r13 = 0
            r12.zzE = r13
        L_0x016e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqw.zzH(java.nio.ByteBuffer, long):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzI() throws com.google.android.gms.internal.ads.zzqe {
        /*
            r9 = this;
            int r0 = r9.zzH
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x000b
            r9.zzH = r3
        L_0x0009:
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            int r4 = r9.zzH
            com.google.android.gms.internal.ads.zzpn[] r5 = r9.zzB
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x002f
            r4 = r5[r4]
            if (r0 == 0) goto L_0x001f
            r4.zzd()
        L_0x001f:
            r9.zzG(r7)
            boolean r0 = r4.zzf()
            if (r0 != 0) goto L_0x0029
            return r3
        L_0x0029:
            int r0 = r9.zzH
            int r0 = r0 + r2
            r9.zzH = r0
            goto L_0x0009
        L_0x002f:
            java.nio.ByteBuffer r0 = r9.zzE
            if (r0 == 0) goto L_0x003b
            r9.zzH(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzE
            if (r0 == 0) goto L_0x003b
            return r3
        L_0x003b:
            r9.zzH = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqw.zzI():boolean");
    }

    private final void zzJ() {
        if (zzO()) {
            if (zzalh.zza >= 21) {
                this.zzn.setVolume(this.zzA);
                return;
            }
            AudioTrack audioTrack = this.zzn;
            float f = this.zzA;
            audioTrack.setStereoVolume(f, f);
        }
    }

    private final void zzK(zzll zzll, boolean z) {
        zzqq zzL2 = zzL();
        if (!zzll.equals(zzL2.zza) || z != zzL2.zzb) {
            zzqq zzqq = new zzqq(zzll, z, -9223372036854775807L, -9223372036854775807L, (zzqn) null);
            if (zzO()) {
                this.zzp = zzqq;
            } else {
                this.zzq = zzqq;
            }
        }
    }

    private final zzqq zzL() {
        zzqq zzqq = this.zzp;
        if (zzqq != null) {
            return zzqq;
        }
        return !this.zzg.isEmpty() ? this.zzg.getLast() : this.zzq;
    }

    private final void zzM(long j) {
        zzll zzll;
        boolean z;
        if (zzN()) {
            zzqp zzqp = this.zzS;
            zzll = zzL().zza;
            zzqp.zzb(zzll);
        } else {
            zzll = zzll.zza;
        }
        zzll zzll2 = zzll;
        if (zzN()) {
            zzqp zzqp2 = this.zzS;
            boolean z2 = zzL().zzb;
            zzqp2.zzc(z2);
            z = z2;
        } else {
            z = false;
        }
        this.zzg.add(new zzqq(zzll2, z, Math.max(0, j), this.zzm.zza(zzQ()), (zzqn) null));
        zzpn[] zzpnArr = this.zzm.zzi;
        ArrayList arrayList = new ArrayList();
        for (zzpn zzpn : zzpnArr) {
            if (zzpn.zzb()) {
                arrayList.add(zzpn);
            } else {
                zzpn.zzg();
            }
        }
        int size = arrayList.size();
        this.zzB = (zzpn[]) arrayList.toArray(new zzpn[size]);
        this.zzC = new ByteBuffer[size];
        zzF();
        zzqc zzqc = this.zzk;
        if (zzqc != null) {
            ((zzra) zzqc).zza.zzc.zzh(z);
        }
    }

    private final boolean zzN() {
        if (this.zzO || !"audio/raw".equals(this.zzm.zza.zzl)) {
            return false;
        }
        int i = this.zzm.zza.zzA;
        return true;
    }

    private final boolean zzO() {
        return this.zzn != null;
    }

    /* access modifiers changed from: private */
    public final long zzP() {
        zzqo zzqo = this.zzm;
        int i = zzqo.zzc;
        return this.zzu / ((long) zzqo.zzb);
    }

    /* access modifiers changed from: private */
    public final long zzQ() {
        zzqo zzqo = this.zzm;
        int i = zzqo.zzc;
        return this.zzv / ((long) zzqo.zzd);
    }

    public static boolean zzR(AudioTrack audioTrack) {
        return zzalh.zza >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final void zzS() {
        if (!this.zzJ) {
            this.zzJ = true;
            this.zzf.zzi(zzQ());
            this.zzn.stop();
            this.zzt = 0;
        }
    }

    public final void zza(zzqc zzqc) {
        this.zzk = zzqc;
    }

    public final boolean zzb(zzkc zzkc) {
        return zzc(zzkc) != 0;
    }

    public final int zzc(zzkc zzkc) {
        if (!"audio/raw".equals(zzkc.zzl)) {
            int i = zzalh.zza;
            return 0;
        } else if (zzalh.zzN(zzkc.zzA)) {
            return zzkc.zzA != 2 ? 1 : 2;
        } else {
            GeneratedOutlineSupport.outline29(33, "Invalid PCM encoding: ", zzkc.zzA, "DefaultAudioSink");
            return 0;
        }
    }

    public final long zzd(boolean z) {
        long j;
        if (!zzO() || this.zzy) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.zzf.zzb(z), this.zzm.zza(zzQ()));
        while (!this.zzg.isEmpty() && min >= this.zzg.getFirst().zzd) {
            this.zzq = this.zzg.remove();
        }
        zzqq zzqq = this.zzq;
        long j2 = min - zzqq.zzd;
        if (zzqq.zza.equals(zzll.zza)) {
            j = this.zzq.zzc + j2;
        } else if (this.zzg.isEmpty()) {
            j = this.zzS.zzd(j2) + this.zzq.zzc;
        } else {
            zzqq first = this.zzg.getFirst();
            j = first.zzc - zzalh.zzH(first.zzd - min, this.zzq.zza.zzb);
        }
        return this.zzm.zza(this.zzS.zze()) + j;
    }

    public final void zze(zzkc zzkc, int i, @Nullable int[] iArr) throws zzqa {
        if ("audio/raw".equals(zzkc.zzl)) {
            zzajg.zza(zzalh.zzN(zzkc.zzA));
            int zzQ2 = zzalh.zzQ(zzkc.zzA, zzkc.zzy);
            zzpn[] zzpnArr = this.zzc;
            this.zzb.zzo(zzkc.zzB, zzkc.zzC);
            if (zzalh.zza < 21 && zzkc.zzy == 8 && iArr == null) {
                iArr = new int[6];
                for (int i2 = 0; i2 < 6; i2++) {
                    iArr[i2] = i2;
                }
            }
            this.zza.zzo(iArr);
            zzpl zzpl = new zzpl(zzkc.zzz, zzkc.zzy, zzkc.zzA);
            int length = zzpnArr.length;
            int i3 = 0;
            while (i3 < length) {
                zzpn zzpn = zzpnArr[i3];
                try {
                    zzpl zza2 = zzpn.zza(zzpl);
                    if (true == zzpn.zzb()) {
                        zzpl = zza2;
                    }
                    i3++;
                } catch (zzpm e) {
                    throw new zzqa((Throwable) e, zzkc);
                }
            }
            int i4 = zzpl.zzd;
            int i5 = zzpl.zzb;
            int zzP2 = zzalh.zzP(zzpl.zzc);
            int zzQ3 = zzalh.zzQ(i4, zzpl.zzc);
            if (i4 == 0) {
                String valueOf = String.valueOf(zzkc);
                throw new zzqa(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf.length() + 48), "Invalid output encoding (mode=0) for: ", valueOf), zzkc);
            } else if (zzP2 != 0) {
                this.zzQ = false;
                zzqo zzqo = new zzqo(zzkc, zzQ2, 0, zzQ3, i5, zzP2, i4, 0, false, zzpnArr);
                if (zzO()) {
                    this.zzl = zzqo;
                } else {
                    this.zzm = zzqo;
                }
            } else {
                String valueOf2 = String.valueOf(zzkc);
                throw new zzqa(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf2.length() + 54), "Invalid output channel config (mode=0) for: ", valueOf2), zzkc);
            }
        } else {
            int i6 = zzalh.zza;
            String valueOf3 = String.valueOf(zzkc);
            throw new zzqa(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf3.length() + 37), "Unable to configure passthrough for: ", valueOf3), zzkc);
        }
    }

    public final void zzf() {
        this.zzK = true;
        if (zzO()) {
            this.zzf.zzc();
            this.zzn.play();
        }
    }

    public final void zzg() {
        this.zzx = true;
    }

    public final boolean zzh(ByteBuffer byteBuffer, long j, int i) throws zzqb, zzqe {
        ByteBuffer byteBuffer2 = this.zzD;
        zzajg.zza(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.zzl != null) {
            if (!zzI()) {
                return false;
            }
            zzqo zzqo = this.zzl;
            zzqo zzqo2 = this.zzm;
            int i2 = zzqo2.zzc;
            int i3 = zzqo.zzc;
            if (zzqo2.zzg == zzqo.zzg && zzqo2.zze == zzqo.zze && zzqo2.zzf == zzqo.zzf && zzqo2.zzd == zzqo.zzd) {
                this.zzm = zzqo;
                this.zzl = null;
                if (zzR(this.zzn)) {
                    this.zzn.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.zzn;
                    zzkc zzkc = this.zzm.zza;
                    audioTrack.setOffloadDelayPadding(zzkc.zzB, zzkc.zzC);
                    this.zzR = true;
                }
            } else {
                zzS();
                if (zzk()) {
                    return false;
                }
                zzv();
            }
            zzM(j);
        }
        if (!zzO()) {
            try {
                this.zze.block();
                zzqo zzqo3 = this.zzm;
                if (zzqo3 != null) {
                    AudioTrack zzc2 = zzqo3.zzc(this.zzO, this.zzo, this.zzM);
                    this.zzn = zzc2;
                    if (zzR(zzc2)) {
                        AudioTrack audioTrack2 = this.zzn;
                        if (this.zzh == null) {
                            this.zzh = new zzqv(this);
                        }
                        this.zzh.zza(audioTrack2);
                        AudioTrack audioTrack3 = this.zzn;
                        zzkc zzkc2 = this.zzm.zza;
                        audioTrack3.setOffloadDelayPadding(zzkc2.zzB, zzkc2.zzC);
                    }
                    this.zzM = this.zzn.getAudioSessionId();
                    zzqj zzqj = this.zzf;
                    AudioTrack audioTrack4 = this.zzn;
                    zzqo zzqo4 = this.zzm;
                    int i4 = zzqo4.zzc;
                    zzqj.zza(audioTrack4, false, zzqo4.zzg, zzqo4.zzd, zzqo4.zzh);
                    zzJ();
                    int i5 = this.zzN.zza;
                    this.zzy = true;
                } else {
                    throw null;
                }
            } catch (zzqb e) {
                zzqc zzqc = this.zzk;
                if (zzqc != null) {
                    zzqc.zzb(e);
                }
                throw e;
            } catch (zzqb e2) {
                this.zzi.zza(e2);
                return false;
            }
        }
        this.zzi.zzb();
        if (this.zzy) {
            this.zzz = Math.max(0, j);
            this.zzx = false;
            this.zzy = false;
            zzM(j);
            if (this.zzK) {
                zzf();
            }
        }
        if (!this.zzf.zze(zzQ())) {
            return false;
        }
        if (this.zzD == null) {
            zzajg.zza(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            int i6 = this.zzm.zzc;
            if (this.zzp != null) {
                if (!zzI()) {
                    return false;
                }
                zzM(j);
                this.zzp = null;
            }
            long zzP2 = (((zzP() - this.zzb.zzq()) * 1000000) / ((long) this.zzm.zza.zzz)) + this.zzz;
            if (!this.zzx && Math.abs(zzP2 - j) > 200000) {
                this.zzk.zzb(new zzqd(j, zzP2));
                this.zzx = true;
            }
            if (this.zzx) {
                if (!zzI()) {
                    return false;
                }
                long j2 = j - zzP2;
                this.zzz += j2;
                this.zzx = false;
                zzM(j);
                zzqc zzqc2 = this.zzk;
                if (!(zzqc2 == null || j2 == 0)) {
                    ((zzra) zzqc2).zza.zzZ();
                }
            }
            int i7 = this.zzm.zzc;
            this.zzu += (long) byteBuffer.remaining();
            this.zzD = byteBuffer;
        }
        zzG(j);
        if (!this.zzD.hasRemaining()) {
            this.zzD = null;
            return true;
        } else if (!this.zzf.zzh(zzQ())) {
            return false;
        } else {
            Log.w("DefaultAudioSink", "Resetting stalled audio track");
            zzv();
            return true;
        }
    }

    public final void zzi() throws zzqe {
        if (!this.zzI && zzO() && zzI()) {
            zzS();
            this.zzI = true;
        }
    }

    public final boolean zzj() {
        return !zzO() || (this.zzI && !zzk());
    }

    public final boolean zzk() {
        return zzO() && this.zzf.zzj(zzQ());
    }

    public final void zzl(zzll zzll) {
        zzK(new zzll(zzalh.zzz(zzll.zzb, 0.1f, 8.0f), zzalh.zzz(zzll.zzc, 0.1f, 8.0f)), zzL().zzb);
    }

    public final zzll zzm() {
        return zzL().zza;
    }

    public final void zzn(boolean z) {
        zzK(zzL().zza, z);
    }

    public final void zzo(zzpi zzpi) {
        if (!this.zzo.equals(zzpi)) {
            this.zzo = zzpi;
            if (!this.zzO) {
                zzv();
            }
        }
    }

    public final void zzp(int i) {
        if (this.zzM != i) {
            this.zzM = i;
            this.zzL = i != 0;
            zzv();
        }
    }

    public final void zzq(zzqk zzqk) {
        if (!this.zzN.equals(zzqk)) {
            int i = zzqk.zza;
            if (this.zzn != null) {
                int i2 = this.zzN.zza;
            }
            this.zzN = zzqk;
        }
    }

    public final void zzr() {
        zzajg.zzd(zzalh.zza >= 21);
        zzajg.zzd(this.zzL);
        if (!this.zzO) {
            this.zzO = true;
            zzv();
        }
    }

    public final void zzs() {
        if (this.zzO) {
            this.zzO = false;
            zzv();
        }
    }

    public final void zzt(float f) {
        if (this.zzA != f) {
            this.zzA = f;
            zzJ();
        }
    }

    public final void zzu() {
        this.zzK = false;
        if (zzO() && this.zzf.zzk()) {
            this.zzn.pause();
        }
    }

    public final void zzv() {
        if (zzO()) {
            this.zzu = 0;
            this.zzv = 0;
            this.zzw = 0;
            this.zzR = false;
            this.zzq = new zzqq(zzL().zza, zzL().zzb, 0, 0, (zzqn) null);
            this.zzz = 0;
            this.zzp = null;
            this.zzg.clear();
            this.zzD = null;
            this.zzE = null;
            this.zzJ = false;
            this.zzI = false;
            this.zzH = -1;
            this.zzs = null;
            this.zzt = 0;
            this.zzb.zzp();
            zzF();
            if (this.zzf.zzd()) {
                this.zzn.pause();
            }
            if (zzR(this.zzn)) {
                zzqv zzqv = this.zzh;
                if (zzqv != null) {
                    zzqv.zzb(this.zzn);
                } else {
                    throw null;
                }
            }
            AudioTrack audioTrack = this.zzn;
            this.zzn = null;
            if (zzalh.zza < 21 && !this.zzL) {
                this.zzM = 0;
            }
            zzqo zzqo = this.zzl;
            if (zzqo != null) {
                this.zzm = zzqo;
                this.zzl = null;
            }
            this.zzf.zzl();
            this.zze.close();
            new zzqn(this, "ExoPlayer:AudioTrackReleaseThread", audioTrack).start();
        }
        this.zzj.zzb();
        this.zzi.zzb();
    }

    public final void zzw() {
        zzv();
        for (zzpn zzh2 : this.zzc) {
            zzh2.zzh();
        }
        zzpn[] zzpnArr = this.zzd;
        int length = zzpnArr.length;
        for (int i = 0; i <= 0; i++) {
            zzpnArr[i].zzh();
        }
        this.zzK = false;
        this.zzQ = false;
    }
}
