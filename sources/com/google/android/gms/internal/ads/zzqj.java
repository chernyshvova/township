package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqj {
    public long zzA;
    public long zzB;
    public long zzC;
    public boolean zzD;
    public long zzE;
    public long zzF;
    public final zzqi zza;
    public final long[] zzb;
    @Nullable
    public AudioTrack zzc;
    public int zzd;
    public int zze;
    @Nullable
    public zzqh zzf;
    public int zzg;
    public boolean zzh;
    public long zzi;
    public float zzj;
    public boolean zzk;
    public long zzl;
    public long zzm;
    @Nullable
    public Method zzn;
    public long zzo;
    public boolean zzp;
    public boolean zzq;
    public long zzr;
    public long zzs;
    public long zzt;
    public long zzu;
    public int zzv;
    public int zzw;
    public long zzx;
    public long zzy;
    public long zzz;

    public zzqj(zzqi zzqi) {
        this.zza = zzqi;
        if (zzalh.zza >= 18) {
            try {
                this.zzn = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.zzb = new long[10];
    }

    private final long zzm(long j) {
        return (j * 1000000) / ((long) this.zzg);
    }

    private final void zzn() {
        this.zzl = 0;
        this.zzw = 0;
        this.zzv = 0;
        this.zzm = 0;
        this.zzC = 0;
        this.zzF = 0;
        this.zzk = false;
    }

    private final long zzo() {
        AudioTrack audioTrack = this.zzc;
        if (audioTrack == null) {
            throw null;
        } else if (this.zzx != -9223372036854775807L) {
            return Math.min(this.zzA, ((((SystemClock.elapsedRealtime() * 1000) - this.zzx) * ((long) this.zzg)) / 1000000) + this.zzz);
        } else {
            int playState = audioTrack.getPlayState();
            if (playState == 1) {
                return 0;
            }
            long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
            if (this.zzh) {
                if (playState == 2) {
                    if (playbackHeadPosition == 0) {
                        this.zzu = this.zzs;
                    }
                    playState = 2;
                }
                playbackHeadPosition += this.zzu;
            }
            if (zzalh.zza <= 29) {
                if (playbackHeadPosition == 0 && this.zzs > 0 && playState == 3) {
                    if (this.zzy == -9223372036854775807L) {
                        this.zzy = SystemClock.elapsedRealtime();
                    }
                    return this.zzs;
                }
                this.zzy = -9223372036854775807L;
            }
            if (this.zzs > playbackHeadPosition) {
                this.zzt++;
            }
            this.zzs = playbackHeadPosition;
            return playbackHeadPosition + (this.zzt << 32);
        }
    }

    public final void zza(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        this.zzc = audioTrack;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = new zzqh(audioTrack);
        this.zzg = audioTrack.getSampleRate();
        this.zzh = false;
        boolean zzN = zzalh.zzN(i);
        this.zzq = zzN;
        this.zzi = zzN ? zzm((long) (i3 / i2)) : -9223372036854775807L;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzp = false;
        this.zzx = -9223372036854775807L;
        this.zzy = -9223372036854775807L;
        this.zzr = 0;
        this.zzo = 0;
        this.zzj = 1.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0250  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(boolean r24) {
        /*
            r23 = this;
            r0 = r23
            android.media.AudioTrack r1 = r0.zzc
            if (r1 == 0) goto L_0x0252
            int r1 = r1.getPlayState()
            r3 = 3
            r4 = 1
            r5 = 0
            r7 = 1000(0x3e8, double:4.94E-321)
            if (r1 != r3) goto L_0x0199
            long r9 = r23.zzo()
            long r9 = r0.zzm(r9)
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0020
            goto L_0x0199
        L_0x0020:
            long r11 = java.lang.System.nanoTime()
            long r11 = r11 / r7
            long r13 = r0.zzm
            long r13 = r11 - r13
            r15 = 30000(0x7530, double:1.4822E-319)
            int r3 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r3 < 0) goto L_0x0060
            long[] r3 = r0.zzb
            int r13 = r0.zzv
            long r14 = r9 - r11
            r3[r13] = r14
            int r13 = r13 + r4
            r3 = 10
            int r13 = r13 % r3
            r0.zzv = r13
            int r13 = r0.zzw
            if (r13 >= r3) goto L_0x0044
            int r13 = r13 + r4
            r0.zzw = r13
        L_0x0044:
            r0.zzm = r11
            r0.zzl = r5
            r3 = 0
        L_0x0049:
            int r13 = r0.zzw
            if (r3 >= r13) goto L_0x0060
            long r14 = r0.zzl
            long[] r4 = r0.zzb
            r17 = r4[r3]
            long r5 = (long) r13
            long r17 = r17 / r5
            long r4 = r17 + r14
            r0.zzl = r4
            int r3 = r3 + 1
            r4 = 1
            r5 = 0
            goto L_0x0049
        L_0x0060:
            boolean r3 = r0.zzh
            if (r3 != 0) goto L_0x0199
            com.google.android.gms.internal.ads.zzqh r3 = r0.zzf
            if (r3 == 0) goto L_0x0197
            boolean r4 = r3.zza(r11)
            java.lang.String r5 = "DefaultAudioSink"
            r13 = 5000000(0x4c4b40, double:2.470328E-317)
            if (r4 != 0) goto L_0x0075
            goto L_0x0134
        L_0x0075:
            long r7 = r3.zzf()
            long r1 = r3.zzg()
            long r19 = r7 - r11
            long r19 = java.lang.Math.abs(r19)
            java.lang.String r15 = ", "
            int r21 = (r19 > r13 ? 1 : (r19 == r13 ? 0 : -1))
            if (r21 <= 0) goto L_0x00d6
            com.google.android.gms.internal.ads.zzqi r4 = r0.zza
            com.google.android.gms.internal.ads.zzqs r4 = (com.google.android.gms.internal.ads.zzqs) r4
            com.google.android.gms.internal.ads.zzqw r6 = r4.zza
            long r13 = r6.zzP()
            com.google.android.gms.internal.ads.zzqw r4 = r4.zza
            r6 = r3
            long r3 = r4.zzQ()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r22 = r6
            r6 = 180(0xb4, float:2.52E-43)
            r0.<init>(r6)
            java.lang.String r6 = "Spurious audio timestamp (system clock mismatch): "
            r0.append(r6)
            r0.append(r1)
            r0.append(r15)
            r0.append(r7)
            r0.append(r15)
            r0.append(r11)
            r0.append(r15)
            r0.append(r9)
            r0.append(r15)
            r0.append(r13)
            r0.append(r15)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r5, r0)
            r22.zzb()
        L_0x00d3:
            r0 = r23
            goto L_0x0134
        L_0x00d6:
            r22 = r3
            long r3 = r0.zzm(r1)
            long r3 = r3 - r9
            long r3 = java.lang.Math.abs(r3)
            r13 = 5000000(0x4c4b40, double:2.470328E-317)
            int r6 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r6 <= 0) goto L_0x0130
            com.google.android.gms.internal.ads.zzqi r3 = r0.zza
            com.google.android.gms.internal.ads.zzqs r3 = (com.google.android.gms.internal.ads.zzqs) r3
            com.google.android.gms.internal.ads.zzqw r4 = r3.zza
            long r13 = r4.zzP()
            com.google.android.gms.internal.ads.zzqw r3 = r3.zza
            long r3 = r3.zzQ()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r0 = 182(0xb6, float:2.55E-43)
            r6.<init>(r0)
            java.lang.String r0 = "Spurious audio timestamp (frame position mismatch): "
            r6.append(r0)
            r6.append(r1)
            r6.append(r15)
            r6.append(r7)
            r6.append(r15)
            r6.append(r11)
            r6.append(r15)
            r6.append(r9)
            r6.append(r15)
            r6.append(r13)
            r6.append(r15)
            r6.append(r3)
            java.lang.String r0 = r6.toString()
            android.util.Log.w(r5, r0)
            r22.zzb()
            goto L_0x00d3
        L_0x0130:
            r22.zzc()
            goto L_0x00d3
        L_0x0134:
            boolean r1 = r0.zzq
            if (r1 == 0) goto L_0x0199
            java.lang.reflect.Method r1 = r0.zzn
            if (r1 == 0) goto L_0x0199
            long r2 = r0.zzr
            long r2 = r11 - r2
            r6 = 500000(0x7a120, double:2.47033E-318)
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 < 0) goto L_0x0199
            android.media.AudioTrack r2 = r0.zzc     // Catch:{ Exception -> 0x0191 }
            if (r2 == 0) goto L_0x018f
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0191 }
            java.lang.Object r1 = r1.invoke(r2, r3)     // Catch:{ Exception -> 0x0191 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0191 }
            int r2 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0191 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0191 }
            long r1 = (long) r1     // Catch:{ Exception -> 0x0191 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            long r3 = r0.zzi     // Catch:{ Exception -> 0x0191 }
            long r1 = r1 - r3
            r0.zzo = r1     // Catch:{ Exception -> 0x0191 }
            r3 = 0
            long r1 = java.lang.Math.max(r1, r3)     // Catch:{ Exception -> 0x0191 }
            r0.zzo = r1     // Catch:{ Exception -> 0x0191 }
            r3 = 5000000(0x4c4b40, double:2.470328E-317)
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x018d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0191 }
            r4 = 61
            r3.<init>(r4)     // Catch:{ Exception -> 0x0191 }
            java.lang.String r4 = "Ignoring impossibly large audio latency: "
            r3.append(r4)     // Catch:{ Exception -> 0x0191 }
            r3.append(r1)     // Catch:{ Exception -> 0x0191 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0191 }
            android.util.Log.w(r5, r1)     // Catch:{ Exception -> 0x0191 }
            r1 = 0
            r0.zzo = r1     // Catch:{ Exception -> 0x0191 }
        L_0x018d:
            r1 = 0
            goto L_0x0194
        L_0x018f:
            r1 = 0
            throw r1     // Catch:{ Exception -> 0x0192 }
        L_0x0191:
            r1 = 0
        L_0x0192:
            r0.zzn = r1
        L_0x0194:
            r0.zzr = r11
            goto L_0x0199
        L_0x0197:
            r1 = 0
            throw r1
        L_0x0199:
            long r1 = java.lang.System.nanoTime()
            r5 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r5
            com.google.android.gms.internal.ads.zzqh r3 = r0.zzf
            if (r3 == 0) goto L_0x0250
            boolean r4 = r3.zzd()
            if (r4 == 0) goto L_0x01c0
            long r5 = r3.zzg()
            long r5 = r0.zzm(r5)
            long r7 = r3.zzf()
            long r7 = r1 - r7
            float r3 = r0.zzj
            long r7 = com.google.android.gms.internal.ads.zzalh.zzH(r7, r3)
            long r7 = r7 + r5
            goto L_0x01dc
        L_0x01c0:
            int r3 = r0.zzw
            if (r3 != 0) goto L_0x01cd
            long r5 = r23.zzo()
            long r5 = r0.zzm(r5)
            goto L_0x01d0
        L_0x01cd:
            long r5 = r0.zzl
            long r5 = r5 + r1
        L_0x01d0:
            r7 = r5
            if (r24 != 0) goto L_0x01dc
            long r5 = r0.zzo
            long r7 = r7 - r5
            r5 = 0
            long r7 = java.lang.Math.max(r5, r7)
        L_0x01dc:
            boolean r3 = r0.zzD
            if (r3 == r4) goto L_0x01e8
            long r5 = r0.zzC
            r0.zzF = r5
            long r5 = r0.zzB
            r0.zzE = r5
        L_0x01e8:
            long r5 = r0.zzF
            long r5 = r1 - r5
            r9 = 1000000(0xf4240, double:4.940656E-318)
            int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r3 >= 0) goto L_0x020a
            r11 = 1000(0x3e8, double:4.94E-321)
            long r13 = r5 * r11
            long r13 = r13 / r9
            long r7 = r7 * r13
            long r9 = r11 - r13
            long r13 = r0.zzE
            float r3 = r0.zzj
            long r5 = com.google.android.gms.internal.ads.zzalh.zzH(r5, r3)
            long r5 = r5 + r13
            long r5 = r5 * r9
            long r5 = r5 + r7
            long r7 = r5 / r11
        L_0x020a:
            boolean r3 = r0.zzk
            if (r3 != 0) goto L_0x0249
            long r5 = r0.zzB
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0249
            r3 = 1
            r0.zzk = r3
            long r5 = r7 - r5
            long r5 = com.google.android.gms.internal.ads.zzig.zza(r5)
            float r3 = r0.zzj
            long r5 = com.google.android.gms.internal.ads.zzalh.zzI(r5, r3)
            long r9 = java.lang.System.currentTimeMillis()
            long r5 = com.google.android.gms.internal.ads.zzig.zza(r5)
            long r9 = r9 - r5
            com.google.android.gms.internal.ads.zzqi r3 = r0.zza
            com.google.android.gms.internal.ads.zzqs r3 = (com.google.android.gms.internal.ads.zzqs) r3
            com.google.android.gms.internal.ads.zzqw r5 = r3.zza
            com.google.android.gms.internal.ads.zzqc r5 = r5.zzk
            if (r5 == 0) goto L_0x0249
            com.google.android.gms.internal.ads.zzqw r3 = r3.zza
            com.google.android.gms.internal.ads.zzqc r3 = r3.zzk
            com.google.android.gms.internal.ads.zzra r3 = (com.google.android.gms.internal.ads.zzra) r3
            com.google.android.gms.internal.ads.zzrb r3 = r3.zza
            com.google.android.gms.internal.ads.zzpy r3 = r3.zzc
            r3.zzd(r9)
        L_0x0249:
            r0.zzC = r1
            r0.zzB = r7
            r0.zzD = r4
            return r7
        L_0x0250:
            r1 = 0
            throw r1
        L_0x0252:
            r1 = 0
            goto L_0x0255
        L_0x0254:
            throw r1
        L_0x0255:
            goto L_0x0254
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqj.zzb(boolean):long");
    }

    public final void zzc() {
        zzqh zzqh = this.zzf;
        if (zzqh != null) {
            zzqh.zze();
            return;
        }
        throw null;
    }

    public final boolean zzd() {
        AudioTrack audioTrack = this.zzc;
        if (audioTrack != null) {
            return audioTrack.getPlayState() == 3;
        }
        throw null;
    }

    public final boolean zze(long j) {
        AudioTrack audioTrack = this.zzc;
        if (audioTrack != null) {
            int playState = audioTrack.getPlayState();
            if (this.zzh) {
                if (playState == 2) {
                    this.zzp = false;
                    return false;
                } else if (playState == 1) {
                    if (zzo() == 0) {
                        return false;
                    }
                    playState = 1;
                }
            }
            boolean z = this.zzp;
            boolean zzj2 = zzj(j);
            this.zzp = zzj2;
            if (z && !zzj2 && playState != 1) {
                zzqi zzqi = this.zza;
                int i = this.zze;
                long zza2 = zzig.zza(this.zzi);
                zzqs zzqs = (zzqs) zzqi;
                if (zzqs.zza.zzk != null) {
                    ((zzra) zzqs.zza.zzk).zza.zzc.zze(i, zza2, SystemClock.elapsedRealtime() - zzqs.zza.zzP);
                }
            }
            return true;
        }
        throw null;
    }

    public final int zzf(long j) {
        return this.zze - ((int) (j - (zzo() * ((long) this.zzd))));
    }

    public final long zzg(long j) {
        return zzig.zza(zzm(-zzo()));
    }

    public final boolean zzh(long j) {
        return this.zzy != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.zzy >= 200;
    }

    public final void zzi(long j) {
        this.zzz = zzo();
        this.zzx = SystemClock.elapsedRealtime() * 1000;
        this.zzA = j;
    }

    public final boolean zzj(long j) {
        if (j > zzo()) {
            return true;
        }
        if (!this.zzh) {
            return false;
        }
        AudioTrack audioTrack = this.zzc;
        if (audioTrack != null) {
            return audioTrack.getPlayState() == 2 && zzo() == 0;
        }
        throw null;
    }

    public final boolean zzk() {
        zzn();
        if (this.zzx != -9223372036854775807L) {
            return false;
        }
        zzqh zzqh = this.zzf;
        if (zzqh != null) {
            zzqh.zze();
            return true;
        }
        throw null;
    }

    public final void zzl() {
        zzn();
        this.zzc = null;
        this.zzf = null;
    }
}
