package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.rest.RESTClient;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaoq {
    public Method zzA;
    public int zzB;
    public long zzC;
    public long zzD;
    public int zzE;
    public long zzF;
    public long zzG;
    public int zzH;
    public int zzI;
    public long zzJ;
    public long zzK;
    public long zzL;
    public float zzM;
    public zzanz[] zzN;
    public ByteBuffer[] zzO;
    public ByteBuffer zzP;
    public ByteBuffer zzQ;
    public byte[] zzR;
    public int zzS;
    public int zzT;
    public boolean zzU;
    public boolean zzV;
    public int zzW;
    public boolean zzX;
    public long zzY;
    public final zzaor zza;
    public final zzaox zzb;
    public final zzanz[] zzc;
    public final zzaon zzd;
    public final ConditionVariable zze = new ConditionVariable(true);
    public final long[] zzf;
    public final zzaoj zzg;
    public final LinkedList<zzaoo> zzh;
    public AudioTrack zzi;
    public int zzj;
    public int zzk;
    public int zzl;
    public int zzm;
    public boolean zzn;
    public int zzo;
    public long zzp;
    public zzano zzq;
    public zzano zzr;
    public long zzs;
    public long zzt;
    public int zzu;
    public int zzv;
    public long zzw;
    public long zzx;
    public boolean zzy;
    public long zzz;

    public zzaoq(zzanx zzanx, zzanz[] zzanzArr, zzaon zzaon) {
        this.zzd = zzaon;
        if (zzava.zza >= 18) {
            try {
                this.zzA = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzava.zza >= 19) {
            this.zzg = new zzaok();
        } else {
            this.zzg = new zzaoj((zzaoi) null);
        }
        this.zza = new zzaor();
        this.zzb = new zzaox();
        zzanz[] zzanzArr2 = new zzanz[3];
        this.zzc = zzanzArr2;
        zzanzArr2[0] = new zzaov();
        zzanz[] zzanzArr3 = this.zzc;
        zzanzArr3[1] = this.zza;
        System.arraycopy(zzanzArr, 0, zzanzArr3, 2, 0);
        this.zzc[2] = this.zzb;
        this.zzf = new long[10];
        this.zzM = 1.0f;
        this.zzI = 0;
        this.zzW = 0;
        this.zzr = zzano.zza;
        this.zzT = -1;
        this.zzN = new zzanz[0];
        this.zzO = new ByteBuffer[0];
        this.zzh = new LinkedList<>();
    }

    private final void zzp() {
        ArrayList arrayList = new ArrayList();
        zzanz[] zzanzArr = this.zzc;
        for (int i = 0; i < 3; i++) {
            zzanz zzanz = zzanzArr[i];
            if (zzanz.zzb()) {
                arrayList.add(zzanz);
            } else {
                zzanz.zzi();
            }
        }
        int size = arrayList.size();
        this.zzN = (zzanz[]) arrayList.toArray(new zzanz[size]);
        this.zzO = new ByteBuffer[size];
        for (int i2 = 0; i2 < size; i2++) {
            zzanz zzanz2 = this.zzN[i2];
            zzanz2.zzi();
            this.zzO[i2] = zzanz2.zzg();
        }
    }

    private final void zzq(long j) throws zzaop {
        ByteBuffer byteBuffer;
        int length = this.zzN.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzO[i - 1];
            } else {
                byteBuffer = this.zzP;
                if (byteBuffer == null) {
                    byteBuffer = zzanz.zza;
                }
            }
            if (i == length) {
                zzr(byteBuffer, j);
            } else {
                zzanz zzanz = this.zzN[i];
                zzanz.zze(byteBuffer);
                ByteBuffer zzg2 = zzanz.zzg();
                this.zzO[i] = zzg2;
                if (zzg2.hasRemaining()) {
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

    private final boolean zzr(ByteBuffer byteBuffer, long j) throws zzaop {
        int i;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        ByteBuffer byteBuffer2 = this.zzQ;
        if (byteBuffer2 != null) {
            zzaul.zza(byteBuffer2 == byteBuffer);
        } else {
            this.zzQ = byteBuffer;
            if (zzava.zza < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.zzR;
                if (bArr == null || bArr.length < remaining) {
                    this.zzR = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.zzR, 0, remaining);
                byteBuffer.position(position);
                this.zzS = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (zzava.zza < 21) {
            int zzd2 = this.zzo - ((int) (this.zzF - (this.zzg.zzd() * ((long) this.zzE))));
            if (zzd2 > 0) {
                i = this.zzi.write(this.zzR, this.zzS, Math.min(remaining2, zzd2));
                if (i > 0) {
                    this.zzS += i;
                    byteBuffer.position(byteBuffer.position() + i);
                }
            } else {
                i = 0;
            }
        } else {
            i = this.zzi.write(byteBuffer, remaining2, 1);
        }
        this.zzY = SystemClock.elapsedRealtime();
        if (i >= 0) {
            boolean z = this.zzn;
            if (!z) {
                this.zzF += (long) i;
            }
            if (i != remaining2) {
                return false;
            }
            if (z) {
                this.zzG += (long) this.zzH;
            }
            this.zzQ = null;
            return true;
        }
        throw new zzaop(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzs() throws com.google.android.gms.internal.ads.zzaop {
        /*
            r9 = this;
            int r0 = r9.zzT
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r9.zzn
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzanz[] r0 = r9.zzN
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r9.zzT = r0
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r9.zzT
            com.google.android.gms.internal.ads.zzanz[] r5 = r9.zzN
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.zzf()
        L_0x0028:
            r9.zzq(r7)
            boolean r0 = r4.zzh()
            if (r0 != 0) goto L_0x0032
            return r3
        L_0x0032:
            int r0 = r9.zzT
            int r0 = r0 + r2
            r9.zzT = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.zzQ
            if (r0 == 0) goto L_0x0044
            r9.zzr(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzQ
            if (r0 == 0) goto L_0x0044
            return r3
        L_0x0044:
            r9.zzT = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoq.zzs():boolean");
    }

    private final void zzt() {
        if (zzu()) {
            if (zzava.zza >= 21) {
                this.zzi.setVolume(this.zzM);
                return;
            }
            AudioTrack audioTrack = this.zzi;
            float f = this.zzM;
            audioTrack.setStereoVolume(f, f);
        }
    }

    private final boolean zzu() {
        return this.zzi != null;
    }

    private final long zzv(long j) {
        return (j * 1000000) / ((long) this.zzj);
    }

    private final long zzw(long j) {
        return (j * ((long) this.zzj)) / 1000000;
    }

    private final long zzx() {
        return this.zzn ? this.zzG : this.zzF / ((long) this.zzE);
    }

    private final void zzy() {
        this.zzw = 0;
        this.zzv = 0;
        this.zzu = 0;
        this.zzx = 0;
        this.zzy = false;
        this.zzz = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r4.zzm;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzz() {
        /*
            r4 = this;
            int r0 = com.google.android.gms.internal.ads.zzava.zza
            r1 = 1
            r2 = 0
            r3 = 23
            if (r0 >= r3) goto L_0x0012
            int r0 = r4.zzm
            r3 = 5
            if (r0 == r3) goto L_0x0013
            r3 = 6
            if (r0 == r3) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            return r1
        L_0x0012:
            r1 = 0
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoq.zzz():boolean");
    }

    public final long zza(boolean z) {
        long j;
        long j2;
        if (!zzu() || this.zzI == 0) {
            return Long.MIN_VALUE;
        }
        if (this.zzi.getPlayState() == 3) {
            long zze2 = this.zzg.zze();
            if (zze2 != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzx >= 30000) {
                    long[] jArr = this.zzf;
                    int i = this.zzu;
                    jArr[i] = zze2 - nanoTime;
                    this.zzu = (i + 1) % 10;
                    int i2 = this.zzv;
                    if (i2 < 10) {
                        this.zzv = i2 + 1;
                    }
                    this.zzx = nanoTime;
                    this.zzw = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzv;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzw = (this.zzf[i3] / ((long) i4)) + this.zzw;
                        i3++;
                    }
                }
                if (!zzz() && nanoTime - this.zzz >= 500000) {
                    boolean zzf2 = this.zzg.zzf();
                    this.zzy = zzf2;
                    if (zzf2) {
                        long zzg2 = this.zzg.zzg() / 1000;
                        long zzh2 = this.zzg.zzh();
                        if (zzg2 < this.zzK) {
                            this.zzy = false;
                        } else if (Math.abs(zzg2 - nanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(zzh2);
                            sb.append(RESTClient.COMMA_SEPARATOR);
                            sb.append(zzg2);
                            sb.append(RESTClient.COMMA_SEPARATOR);
                            sb.append(nanoTime);
                            sb.append(RESTClient.COMMA_SEPARATOR);
                            sb.append(zze2);
                            Log.w("AudioTrack", sb.toString());
                            this.zzy = false;
                        } else if (Math.abs(zzv(zzh2) - zze2) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(zzh2);
                            sb2.append(RESTClient.COMMA_SEPARATOR);
                            sb2.append(zzg2);
                            sb2.append(RESTClient.COMMA_SEPARATOR);
                            sb2.append(nanoTime);
                            sb2.append(RESTClient.COMMA_SEPARATOR);
                            sb2.append(zze2);
                            Log.w("AudioTrack", sb2.toString());
                            this.zzy = false;
                        }
                    }
                    Method method = this.zzA;
                    if (method != null && !this.zzn) {
                        try {
                            long intValue = (((long) ((Integer) method.invoke(this.zzi, (Object[]) null)).intValue()) * 1000) - this.zzp;
                            this.zzL = intValue;
                            long max = Math.max(intValue, 0);
                            this.zzL = max;
                            if (max > 5000000) {
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(max);
                                Log.w("AudioTrack", sb3.toString());
                                this.zzL = 0;
                            }
                        } catch (Exception unused) {
                            this.zzA = null;
                        }
                    }
                    this.zzz = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzy) {
            j = zzv(this.zzg.zzh() + zzw(nanoTime2 - (this.zzg.zzg() / 1000)));
        } else {
            j = this.zzv == 0 ? this.zzg.zze() : nanoTime2 + this.zzw;
            if (!z) {
                j -= this.zzL;
            }
        }
        long j3 = this.zzJ;
        while (!this.zzh.isEmpty() && j >= this.zzh.getFirst().zzc) {
            zzaoo remove = this.zzh.remove();
            this.zzr = remove.zza;
            this.zzt = remove.zzc;
            this.zzs = remove.zzb - this.zzJ;
        }
        if (this.zzr.zzb == 1.0f) {
            j2 = (j + this.zzs) - this.zzt;
        } else if (!this.zzh.isEmpty() || this.zzb.zzn() < 1024) {
            long j4 = this.zzs;
            double d = (double) this.zzr.zzb;
            double d2 = (double) (j - this.zzt);
            Double.isNaN(d);
            Double.isNaN(d2);
            j2 = ((long) (d * d2)) + j4;
        } else {
            j2 = zzava.zzj(j - this.zzt, this.zzb.zzm(), this.zzb.zzn()) + this.zzs;
        }
        return j3 + j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00aa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.String r6, int r7, int r8, int r9, int r10, int[] r11) throws com.google.android.gms.internal.ads.zzaol {
        /*
            r5 = this;
            int r6 = com.google.android.gms.internal.ads.zzava.zzp(r9, r7)
            r5.zzB = r6
            com.google.android.gms.internal.ads.zzaor r6 = r5.zza
            r6.zzk(r11)
            com.google.android.gms.internal.ads.zzanz[] r6 = r5.zzc
            r10 = 0
            r11 = 0
            r0 = 0
        L_0x0010:
            r1 = 3
            r2 = 2
            if (r11 >= r1) goto L_0x0033
            r1 = r6[r11]
            boolean r2 = r1.zza(r8, r7, r9)     // Catch:{ zzany -> 0x002c }
            r0 = r0 | r2
            boolean r2 = r1.zzb()
            if (r2 == 0) goto L_0x0029
            int r7 = r1.zzc()
            r1.zzd()
            r9 = 2
        L_0x0029:
            int r11 = r11 + 1
            goto L_0x0010
        L_0x002c:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzaol r7 = new com.google.android.gms.internal.ads.zzaol
            r7.<init>((java.lang.Throwable) r6)
            throw r7
        L_0x0033:
            if (r0 == 0) goto L_0x0038
            r5.zzp()
        L_0x0038:
            r6 = 252(0xfc, float:3.53E-43)
            switch(r7) {
                case 1: goto L_0x0060;
                case 2: goto L_0x005d;
                case 3: goto L_0x005a;
                case 4: goto L_0x0057;
                case 5: goto L_0x0054;
                case 6: goto L_0x0051;
                case 7: goto L_0x004e;
                case 8: goto L_0x004b;
                default: goto L_0x003d;
            }
        L_0x003d:
            com.google.android.gms.internal.ads.zzaol r6 = new com.google.android.gms.internal.ads.zzaol
            r8 = 38
            java.lang.String r9 = "Unsupported channel count: "
            java.lang.String r7 = com.android.tools.p006r8.GeneratedOutlineSupport.outline9(r8, r9, r7)
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x004b:
            int r11 = com.google.android.gms.internal.ads.zzamv.zza
            goto L_0x0061
        L_0x004e:
            r11 = 1276(0x4fc, float:1.788E-42)
            goto L_0x0061
        L_0x0051:
            r11 = 252(0xfc, float:3.53E-43)
            goto L_0x0061
        L_0x0054:
            r11 = 220(0xdc, float:3.08E-43)
            goto L_0x0061
        L_0x0057:
            r11 = 204(0xcc, float:2.86E-43)
            goto L_0x0061
        L_0x005a:
            r11 = 28
            goto L_0x0061
        L_0x005d:
            r11 = 12
            goto L_0x0061
        L_0x0060:
            r11 = 4
        L_0x0061:
            int r3 = com.google.android.gms.internal.ads.zzava.zza
            r4 = 23
            if (r3 > r4) goto L_0x0087
            java.lang.String r3 = com.google.android.gms.internal.ads.zzava.zzb
            java.lang.String r4 = "foster"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0087
            java.lang.String r3 = com.google.android.gms.internal.ads.zzava.zzc
            java.lang.String r4 = "NVIDIA"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0087
            if (r7 == r1) goto L_0x0088
            r1 = 5
            if (r7 == r1) goto L_0x0088
            r6 = 7
            if (r7 == r6) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            int r6 = com.google.android.gms.internal.ads.zzamv.zza
            goto L_0x0088
        L_0x0087:
            r6 = r11
        L_0x0088:
            int r11 = com.google.android.gms.internal.ads.zzava.zza
            r1 = 25
            if (r11 > r1) goto L_0x0095
            java.lang.String r11 = com.google.android.gms.internal.ads.zzava.zzb
            java.lang.String r1 = "fugu"
            r1.equals(r11)
        L_0x0095:
            if (r0 != 0) goto L_0x00ab
            boolean r11 = r5.zzu()
            if (r11 == 0) goto L_0x00ab
            int r11 = r5.zzl
            if (r11 != r9) goto L_0x00ab
            int r11 = r5.zzj
            if (r11 != r8) goto L_0x00ab
            int r11 = r5.zzk
            if (r11 == r6) goto L_0x00aa
            goto L_0x00ab
        L_0x00aa:
            return
        L_0x00ab:
            r5.zzm()
            r5.zzl = r9
            r5.zzn = r10
            r5.zzj = r8
            r5.zzk = r6
            r5.zzm = r2
            int r7 = com.google.android.gms.internal.ads.zzava.zzp(r2, r7)
            r5.zzE = r7
            int r7 = r5.zzm
            int r6 = android.media.AudioTrack.getMinBufferSize(r8, r6, r7)
            r7 = -2
            if (r6 == r7) goto L_0x00c8
            r10 = 1
        L_0x00c8:
            com.google.android.gms.internal.ads.zzaul.zzd(r10)
            int r7 = r6 * 4
            r8 = 250000(0x3d090, double:1.235164E-318)
            long r8 = r5.zzw(r8)
            int r9 = (int) r8
            int r8 = r5.zzE
            int r9 = r9 * r8
            long r10 = (long) r6
            r0 = 750000(0xb71b0, double:3.70549E-318)
            long r0 = r5.zzw(r0)
            int r6 = r5.zzE
            long r2 = (long) r6
            long r0 = r0 * r2
            long r10 = java.lang.Math.max(r10, r0)
            int r6 = (int) r10
            if (r7 >= r9) goto L_0x00ef
            r7 = r9
            goto L_0x00f2
        L_0x00ef:
            if (r7 <= r6) goto L_0x00f2
            r7 = r6
        L_0x00f2:
            r5.zzo = r7
            int r6 = r5.zzE
            int r7 = r7 / r6
            long r6 = (long) r7
            long r6 = r5.zzv(r6)
            r5.zzp = r6
            com.google.android.gms.internal.ads.zzano r6 = r5.zzr
            r5.zzi(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoq.zzb(java.lang.String, int, int, int, int, int[]):void");
    }

    public final void zzc() {
        this.zzV = true;
        if (zzu()) {
            this.zzK = System.nanoTime() / 1000;
            this.zzi.play();
        }
    }

    public final void zzd() {
        if (this.zzI == 1) {
            this.zzI = 2;
        }
    }

    public final boolean zze(ByteBuffer byteBuffer, long j) throws zzaom, zzaop {
        long j2;
        int i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = j;
        ByteBuffer byteBuffer3 = this.zzP;
        zzaul.zza(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (!zzu()) {
            this.zze.block();
            int i2 = this.zzW;
            if (i2 == 0) {
                this.zzi = new AudioTrack(3, this.zzj, this.zzk, this.zzm, this.zzo, 1);
            } else {
                this.zzi = new AudioTrack(3, this.zzj, this.zzk, this.zzm, this.zzo, 1, i2);
            }
            int state = this.zzi.getState();
            if (state == 1) {
                int audioSessionId = this.zzi.getAudioSessionId();
                if (this.zzW != audioSessionId) {
                    this.zzW = audioSessionId;
                    ((zzaot) this.zzd).zza.zzb.zzf(audioSessionId);
                }
                this.zzg.zza(this.zzi, zzz());
                zzt();
                this.zzX = false;
                if (this.zzV) {
                    zzc();
                }
            } else {
                try {
                    this.zzi.release();
                } catch (Exception unused) {
                } finally {
                    this.zzi = null;
                }
                throw new zzaom(state, this.zzj, this.zzk, this.zzo);
            }
        }
        if (zzz()) {
            if (this.zzi.getPlayState() == 2) {
                this.zzX = false;
                return false;
            } else if (this.zzi.getPlayState() == 1 && this.zzg.zzd() != 0) {
                return false;
            }
        }
        boolean z = this.zzX;
        boolean zzh2 = zzh();
        this.zzX = zzh2;
        if (z && !zzh2 && this.zzi.getPlayState() != 1) {
            ((zzaot) this.zzd).zza.zzb.zzd(this.zzo, zzamv.zza(this.zzp), SystemClock.elapsedRealtime() - this.zzY);
        }
        if (this.zzP == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzn && this.zzH == 0) {
                int i3 = this.zzm;
                if (i3 == 7 || i3 == 8) {
                    int position = byteBuffer.position();
                    i = ((((byteBuffer2.get(position + 5) & 252) >> 2) | ((byteBuffer2.get(position + 4) & 1) << 6)) + 1) * 32;
                } else if (i3 == 5) {
                    i = 1536;
                } else if (i3 == 6) {
                    i = zzanw.zzc(byteBuffer);
                } else {
                    throw new IllegalStateException(GeneratedOutlineSupport.outline9(38, "Unexpected audio encoding: ", i3));
                }
                this.zzH = i;
            }
            if (this.zzq != null) {
                if (!zzs()) {
                    return false;
                }
                this.zzh.add(new zzaoo(this.zzq, Math.max(0, j3), zzv(zzx()), (zzaoi) null));
                this.zzq = null;
                zzp();
            }
            if (this.zzI == 0) {
                this.zzJ = Math.max(0, j3);
                this.zzI = 1;
            } else {
                long j4 = this.zzJ;
                if (this.zzn) {
                    j2 = this.zzD;
                } else {
                    j2 = this.zzC / ((long) this.zzB);
                }
                long zzv2 = j4 + zzv(j2);
                if (this.zzI == 1 && Math.abs(zzv2 - j3) > 200000) {
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Discontinuity detected [expected ");
                    sb.append(zzv2);
                    sb.append(", got ");
                    sb.append(j3);
                    sb.append("]");
                    Log.e("AudioTrack", sb.toString());
                    this.zzI = 2;
                }
                if (this.zzI == 2) {
                    this.zzJ = (j3 - zzv2) + this.zzJ;
                    this.zzI = 1;
                    boolean unused2 = ((zzaot) this.zzd).zza.zzh = true;
                }
            }
            if (this.zzn) {
                this.zzD += (long) this.zzH;
            } else {
                this.zzC += (long) byteBuffer.remaining();
            }
            this.zzP = byteBuffer2;
        }
        if (this.zzn) {
            zzr(this.zzP, j3);
        } else {
            zzq(j3);
        }
        if (this.zzP.hasRemaining()) {
            return false;
        }
        this.zzP = null;
        return true;
    }

    public final void zzf() throws zzaop {
        if (!this.zzU && zzu() && zzs()) {
            this.zzg.zzb(zzx());
            this.zzU = true;
        }
    }

    public final boolean zzg() {
        return !zzu() || (this.zzU && !zzh());
    }

    public final boolean zzh() {
        if (zzu()) {
            if (zzx() > this.zzg.zzd()) {
                return true;
            }
            if (zzz() && this.zzi.getPlayState() == 2 && this.zzi.getPlaybackHeadPosition() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final zzano zzi(zzano zzano) {
        if (this.zzn) {
            zzano zzano2 = zzano.zza;
            this.zzr = zzano2;
            return zzano2;
        }
        float zzk2 = this.zzb.zzk(zzano.zzb);
        this.zzb.zzl(1.0f);
        zzano zzano3 = new zzano(zzk2, 1.0f);
        zzano zzano4 = this.zzq;
        if (zzano4 == null) {
            if (!this.zzh.isEmpty()) {
                zzano4 = this.zzh.getLast().zza;
            } else {
                zzano4 = this.zzr;
            }
        }
        if (!zzano3.equals(zzano4)) {
            if (zzu()) {
                this.zzq = zzano3;
            } else {
                this.zzr = zzano3;
            }
        }
        return this.zzr;
    }

    public final zzano zzj() {
        return this.zzr;
    }

    public final void zzk(float f) {
        if (this.zzM != f) {
            this.zzM = f;
            zzt();
        }
    }

    public final void zzl() {
        this.zzV = false;
        if (zzu()) {
            zzy();
            this.zzg.zzc();
        }
    }

    public final void zzm() {
        if (zzu()) {
            this.zzC = 0;
            this.zzD = 0;
            this.zzF = 0;
            this.zzG = 0;
            this.zzH = 0;
            zzano zzano = this.zzq;
            if (zzano != null) {
                this.zzr = zzano;
                this.zzq = null;
            } else if (!this.zzh.isEmpty()) {
                this.zzr = this.zzh.getLast().zza;
            }
            this.zzh.clear();
            this.zzs = 0;
            this.zzt = 0;
            this.zzP = null;
            this.zzQ = null;
            int i = 0;
            while (true) {
                zzanz[] zzanzArr = this.zzN;
                if (i >= zzanzArr.length) {
                    break;
                }
                zzanz zzanz = zzanzArr[i];
                zzanz.zzi();
                this.zzO[i] = zzanz.zzg();
                i++;
            }
            this.zzU = false;
            this.zzT = -1;
            this.zzI = 0;
            this.zzL = 0;
            zzy();
            if (this.zzi.getPlayState() == 3) {
                this.zzi.pause();
            }
            AudioTrack audioTrack = this.zzi;
            this.zzi = null;
            this.zzg.zza((AudioTrack) null, false);
            this.zze.close();
            new zzaoi(this, audioTrack).start();
        }
    }

    public final void zzn() {
        zzm();
        zzanz[] zzanzArr = this.zzc;
        for (int i = 0; i < 3; i++) {
            zzanzArr[i].zzj();
        }
        this.zzW = 0;
        this.zzV = false;
    }
}
