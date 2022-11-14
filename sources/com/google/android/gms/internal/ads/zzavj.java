package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.facebook.internal.WebDialog;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzavj extends zzare {
    public static final int[] zzb = {1920, 1600, 1440, WebDialog.MAX_PADDING_SCREEN_HEIGHT, 960, 854, 640, 540, WebDialog.NO_PADDING_SCREEN_WIDTH};
    public long zzA;
    public int zzB;
    public final Context zzc;
    public final zzavl zzd;
    public final zzavt zze;
    public final boolean zzf;
    public final long[] zzg;
    public zzank[] zzh;
    public zzavi zzi;
    public Surface zzj;
    public Surface zzk;
    public boolean zzl;
    public long zzm;
    public long zzn;
    public int zzo;
    public int zzp;
    public int zzq;
    public float zzr;
    public int zzs;
    public int zzt;
    public int zzu;
    public float zzv;
    public int zzw;
    public int zzx;
    public int zzy;
    public float zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzavj(Context context, zzarg zzarg, long j, Handler handler, zzavu zzavu, int i) {
        super(2, zzarg, (zzapi) null, false);
        boolean z = false;
        this.zzc = context.getApplicationContext();
        this.zzd = new zzavl(context);
        this.zze = new zzavt(handler, zzavu);
        if (zzava.zza <= 22 && "foster".equals(zzava.zzb) && "NVIDIA".equals(zzava.zzc)) {
            z = true;
        }
        this.zzf = z;
        this.zzg = new long[10];
        this.zzA = -9223372036854775807L;
        this.zzm = -9223372036854775807L;
        this.zzs = -1;
        this.zzt = -1;
        this.zzv = -1.0f;
        this.zzr = -1.0f;
        zzab();
    }

    private final boolean zzT(boolean z) {
        if (zzava.zza < 23 || (z && !zzavg.zza(this.zzc))) {
            return false;
        }
        return true;
    }

    private final void zzab() {
        this.zzw = -1;
        this.zzx = -1;
        this.zzz = -1.0f;
        this.zzy = -1;
    }

    private final void zzac() {
        int i = this.zzw;
        int i2 = this.zzs;
        if (i != i2 || this.zzx != this.zzt || this.zzy != this.zzu || this.zzz != this.zzv) {
            this.zze.zze(i2, this.zzt, this.zzu, this.zzv);
            this.zzw = this.zzs;
            this.zzx = this.zzt;
            this.zzy = this.zzu;
            this.zzz = this.zzv;
        }
    }

    private final void zzad() {
        if (this.zzw != -1 || this.zzx != -1) {
            this.zze.zze(this.zzs, this.zzt, this.zzu, this.zzv);
        }
    }

    private final void zzae() {
        if (this.zzo > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zze.zzd(this.zzo, elapsedRealtime - this.zzn);
            this.zzo = 0;
            this.zzn = elapsedRealtime;
        }
    }

    public static boolean zzaf(long j) {
        return j < -30000;
    }

    public static int zzag(zzank zzank) {
        int i = zzank.zzg;
        if (i != -1) {
            return i;
        }
        return zzah(zzank.zzf, zzank.zzj, zzank.zzk);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzah(java.lang.String r7, int r8, int r9) {
        /*
            r0 = -1
            if (r8 == r0) goto L_0x0083
            if (r9 != r0) goto L_0x0007
            goto L_0x0083
        L_0x0007:
            int r1 = r7.hashCode()
            r2 = 5
            r3 = 1
            r4 = 4
            r5 = 3
            r6 = 2
            switch(r1) {
                case -1664118616: goto L_0x0046;
                case -1662541442: goto L_0x003c;
                case 1187890754: goto L_0x0032;
                case 1331836730: goto L_0x0028;
                case 1599127256: goto L_0x001e;
                case 1599127257: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0050
        L_0x0014:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 5
            goto L_0x0051
        L_0x001e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 3
            goto L_0x0051
        L_0x0028:
            java.lang.String r1 = "video/avc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 2
            goto L_0x0051
        L_0x0032:
            java.lang.String r1 = "video/mp4v-es"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 1
            goto L_0x0051
        L_0x003c:
            java.lang.String r1 = "video/hevc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 4
            goto L_0x0051
        L_0x0046:
            java.lang.String r1 = "video/3gpp"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 0
            goto L_0x0051
        L_0x0050:
            r7 = -1
        L_0x0051:
            if (r7 == 0) goto L_0x007b
            if (r7 == r3) goto L_0x007b
            if (r7 == r6) goto L_0x0061
            if (r7 == r5) goto L_0x007b
            if (r7 == r4) goto L_0x005e
            if (r7 == r2) goto L_0x005e
            return r0
        L_0x005e:
            int r8 = r8 * r9
            goto L_0x007e
        L_0x0061:
            java.lang.String r7 = com.google.android.gms.internal.ads.zzava.zzd
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x006c
            return r0
        L_0x006c:
            r7 = 16
            int r8 = com.google.android.gms.internal.ads.zzava.zze(r8, r7)
            int r7 = com.google.android.gms.internal.ads.zzava.zze(r9, r7)
            int r7 = r7 * r8
            int r8 = r7 * 256
            goto L_0x007d
        L_0x007b:
            int r8 = r8 * r9
        L_0x007d:
            r4 = 2
        L_0x007e:
            int r8 = r8 * 3
            int r4 = r4 + r4
            int r8 = r8 / r4
            return r8
        L_0x0083:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavj.zzah(java.lang.String, int, int):int");
    }

    public static boolean zzai(boolean z, zzank zzank, zzank zzank2) {
        if (zzank.zzf.equals(zzank2.zzf) && zzaj(zzank) == zzaj(zzank2)) {
            if (z) {
                return true;
            }
            if (zzank.zzj == zzank2.zzj && zzank.zzk == zzank2.zzk) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static int zzaj(zzank zzank) {
        int i = zzank.zzm;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    public final boolean zzE() {
        Surface surface;
        if (super.zzE() && (this.zzl || (((surface = this.zzk) != null && this.zzj == surface) || zzW() == null))) {
            this.zzm = -9223372036854775807L;
            return true;
        } else if (this.zzm == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzm) {
                return true;
            }
            this.zzm = -9223372036854775807L;
            return false;
        }
    }

    public final int zzH(zzarg zzarg, zzank zzank) throws zzarj {
        boolean z;
        int i;
        int i2;
        String str = zzank.zzf;
        int i3 = 0;
        if (!zzauq.zzb(str)) {
            return 0;
        }
        zzaph zzaph = zzank.zzi;
        if (zzaph != null) {
            z = false;
            for (int i4 = 0; i4 < zzaph.zza; i4++) {
                z |= zzaph.zza(i4).zzc;
            }
        } else {
            z = false;
        }
        zzarc zza = zzarn.zza(str, z);
        if (zza == null) {
            return 1;
        }
        boolean zzd2 = zza.zzd(zzank.zzc);
        if (zzd2 && (i = zzank.zzj) > 0 && (i2 = zzank.zzk) > 0) {
            if (zzava.zza >= 21) {
                zzd2 = zza.zze(i, i2, (double) zzank.zzl);
            } else {
                zzd2 = i * i2 <= zzarn.zzc();
                if (!zzd2) {
                    int i5 = zzank.zzj;
                    int i6 = zzank.zzk;
                    String str2 = zzava.zze;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i5);
                    sb.append("x");
                    sb.append(i6);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
            }
        }
        int i7 = true != zza.zzb ? 4 : 8;
        if (true == zza.zzc) {
            i3 = 16;
        }
        return (true != zzd2 ? 2 : 3) | i7 | i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d8, code lost:
        r10 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzJ(com.google.android.gms.internal.ads.zzarc r20, android.media.MediaCodec r21, com.google.android.gms.internal.ads.zzank r22, android.media.MediaCrypto r23) throws com.google.android.gms.internal.ads.zzarj {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            com.google.android.gms.internal.ads.zzank[] r3 = r0.zzh
            int r4 = r2.zzj
            int r5 = r2.zzk
            int r6 = zzag(r22)
            int r7 = r3.length
            r8 = -1
            r9 = 1
            if (r7 != r9) goto L_0x001c
            com.google.android.gms.internal.ads.zzavi r3 = new com.google.android.gms.internal.ads.zzavi
            r3.<init>(r4, r5, r6)
            goto L_0x0101
        L_0x001c:
            r9 = 0
            r10 = 0
        L_0x001e:
            if (r9 >= r7) goto L_0x004c
            r11 = r3[r9]
            boolean r12 = r1.zzb
            boolean r12 = zzai(r12, r2, r11)
            if (r12 == 0) goto L_0x0049
            int r12 = r11.zzj
            if (r12 == r8) goto L_0x0035
            int r13 = r11.zzk
            if (r13 != r8) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r13 = 0
            goto L_0x0036
        L_0x0035:
            r13 = 1
        L_0x0036:
            r10 = r10 | r13
            int r4 = java.lang.Math.max(r4, r12)
            int r12 = r11.zzk
            int r5 = java.lang.Math.max(r5, r12)
            int r11 = zzag(r11)
            int r6 = java.lang.Math.max(r6, r11)
        L_0x0049:
            int r9 = r9 + 1
            goto L_0x001e
        L_0x004c:
            if (r10 == 0) goto L_0x00fc
            r3 = 66
            java.lang.String r7 = "Resolutions unknown. Codec max resolution: "
            java.lang.String r8 = "x"
            java.lang.String r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline11(r3, r7, r4, r8, r5)
            java.lang.String r7 = "MediaCodecVideoRenderer"
            android.util.Log.w(r7, r3)
            int r3 = r2.zzk
            int r9 = r2.zzj
            if (r3 <= r9) goto L_0x0065
            r10 = r3
            goto L_0x0066
        L_0x0065:
            r10 = r9
        L_0x0066:
            if (r3 > r9) goto L_0x006a
            r11 = r3
            goto L_0x006b
        L_0x006a:
            r11 = r9
        L_0x006b:
            float r12 = (float) r11
            float r13 = (float) r10
            float r12 = r12 / r13
            int[] r13 = zzb
            int r14 = r13.length
            r14 = 0
        L_0x0072:
            r15 = 9
            if (r14 >= r15) goto L_0x00d8
            r15 = r13[r14]
            r23 = r13
            float r13 = (float) r15
            float r13 = r13 * r12
            int r13 = (int) r13
            if (r15 <= r10) goto L_0x00d8
            if (r13 > r11) goto L_0x0083
            goto L_0x00d8
        L_0x0083:
            r16 = r10
            int r10 = com.google.android.gms.internal.ads.zzava.zza
            r17 = r11
            r11 = 21
            if (r10 < r11) goto L_0x00ab
            if (r3 > r9) goto L_0x0091
            r10 = r15
            goto L_0x0092
        L_0x0091:
            r10 = r13
        L_0x0092:
            if (r3 > r9) goto L_0x0095
            r15 = r13
        L_0x0095:
            android.graphics.Point r10 = r1.zzf(r10, r15)
            float r11 = r2.zzl
            int r13 = r10.x
            int r15 = r10.y
            r18 = r10
            double r10 = (double) r11
            boolean r10 = r1.zze(r13, r15, r10)
            if (r10 == 0) goto L_0x00cf
            r10 = r18
            goto L_0x00d9
        L_0x00ab:
            r10 = 16
            int r11 = com.google.android.gms.internal.ads.zzava.zze(r15, r10)
            int r11 = r11 * 16
            int r10 = com.google.android.gms.internal.ads.zzava.zze(r13, r10)
            int r10 = r10 * 16
            int r13 = r11 * r10
            int r15 = com.google.android.gms.internal.ads.zzarn.zzc()
            if (r13 > r15) goto L_0x00cf
            if (r3 > r9) goto L_0x00c5
            r12 = r11
            goto L_0x00c6
        L_0x00c5:
            r12 = r10
        L_0x00c6:
            if (r3 > r9) goto L_0x00c9
            r11 = r10
        L_0x00c9:
            android.graphics.Point r10 = new android.graphics.Point
            r10.<init>(r12, r11)
            goto L_0x00d9
        L_0x00cf:
            int r14 = r14 + 1
            r13 = r23
            r10 = r16
            r11 = r17
            goto L_0x0072
        L_0x00d8:
            r10 = 0
        L_0x00d9:
            if (r10 == 0) goto L_0x00fc
            int r3 = r10.x
            int r4 = java.lang.Math.max(r4, r3)
            int r3 = r10.y
            int r5 = java.lang.Math.max(r5, r3)
            java.lang.String r3 = r2.zzf
            int r3 = zzah(r3, r4, r5)
            int r6 = java.lang.Math.max(r6, r3)
            r3 = 57
            java.lang.String r9 = "Codec max resolution adjusted to: "
            java.lang.String r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline11(r3, r9, r4, r8, r5)
            android.util.Log.w(r7, r3)
        L_0x00fc:
            com.google.android.gms.internal.ads.zzavi r3 = new com.google.android.gms.internal.ads.zzavi
            r3.<init>(r4, r5, r6)
        L_0x0101:
            r0.zzi = r3
            boolean r4 = r0.zzf
            android.media.MediaFormat r2 = r22.zzl()
            int r5 = r3.zza
            java.lang.String r6 = "max-width"
            r2.setInteger(r6, r5)
            int r5 = r3.zzb
            java.lang.String r6 = "max-height"
            r2.setInteger(r6, r5)
            int r3 = r3.zzc
            r5 = -1
            if (r3 == r5) goto L_0x0121
            java.lang.String r5 = "max-input-size"
            r2.setInteger(r5, r3)
        L_0x0121:
            if (r4 == 0) goto L_0x0129
            java.lang.String r3 = "auto-frc"
            r4 = 0
            r2.setInteger(r3, r4)
        L_0x0129:
            android.view.Surface r3 = r0.zzj
            if (r3 != 0) goto L_0x0148
            boolean r3 = r1.zzd
            boolean r3 = r0.zzT(r3)
            com.google.android.gms.internal.ads.zzaul.zzd(r3)
            android.view.Surface r3 = r0.zzk
            if (r3 != 0) goto L_0x0144
            android.content.Context r3 = r0.zzc
            boolean r1 = r1.zzd
            com.google.android.gms.internal.ads.zzavg r1 = com.google.android.gms.internal.ads.zzavg.zzb(r3, r1)
            r0.zzk = r1
        L_0x0144:
            android.view.Surface r1 = r0.zzk
            r0.zzj = r1
        L_0x0148:
            android.view.Surface r1 = r0.zzj
            r3 = 0
            r4 = 0
            r5 = r21
            r5.configure(r2, r1, r3, r4)
            int r1 = com.google.android.gms.internal.ads.zzava.zza
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavj.zzJ(com.google.android.gms.internal.ads.zzarc, android.media.MediaCodec, com.google.android.gms.internal.ads.zzank, android.media.MediaCrypto):void");
    }

    public final void zzK(String str, long j, long j2) {
        this.zze.zzb(str, j, j2);
    }

    public final void zzL(zzank zzank) throws zzamw {
        super.zzL(zzank);
        this.zze.zzc(zzank);
        float f = zzank.zzn;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.zzr = f;
        this.zzq = zzaj(zzank);
    }

    public final void zzM(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = false;
        if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            z = true;
        }
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.zzs = i;
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.zzt = i2;
        this.zzv = this.zzr;
        if (zzava.zza >= 21) {
            int i3 = this.zzq;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.zzs;
                this.zzs = this.zzt;
                this.zzt = i4;
                this.zzv = 1.0f / this.zzv;
            }
        } else {
            this.zzu = this.zzq;
        }
        mediaCodec.setVideoScalingMode(1);
    }

    public final void zzN(MediaCodec mediaCodec, int i, long j) {
        zzauy.zza("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzauy.zzb();
        this.zza.zze++;
    }

    public final void zzO(MediaCodec mediaCodec, int i, long j) {
        zzac();
        zzauy.zza("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzauy.zzb();
        this.zza.zzd++;
        this.zzp = 0;
        zzS();
    }

    @TargetApi(21)
    public final void zzP(MediaCodec mediaCodec, int i, long j, long j2) {
        zzac();
        zzauy.zza("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzauy.zzb();
        this.zza.zzd++;
        this.zzp = 0;
        zzS();
    }

    public final boolean zzQ(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j4 = j3;
        while (true) {
            int i4 = this.zzB;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.zzg;
            long j5 = jArr[0];
            if (j4 < j5) {
                break;
            }
            this.zzA = j5;
            int i5 = i4 - 1;
            this.zzB = i5;
            System.arraycopy(jArr, 1, jArr, 0, i5);
        }
        long j6 = j4 - this.zzA;
        if (z) {
            zzN(mediaCodec2, i3, j6);
            return true;
        }
        long j7 = j4 - j;
        if (this.zzj == this.zzk) {
            if (!zzaf(j7)) {
                return false;
            }
            zzN(mediaCodec2, i3, j6);
            return true;
        } else if (!this.zzl) {
            if (zzava.zza >= 21) {
                zzP(mediaCodec, i, j6, System.nanoTime());
            } else {
                zzO(mediaCodec2, i3, j6);
            }
            return true;
        } else if (zze() != 2) {
            return false;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long nanoTime = System.nanoTime();
            long zzc2 = this.zzd.zzc(j4, ((j7 - ((elapsedRealtime * 1000) - j2)) * 1000) + nanoTime);
            long j8 = (zzc2 - nanoTime) / 1000;
            if (zzaf(j8)) {
                zzauy.zza("dropVideoBuffer");
                mediaCodec2.releaseOutputBuffer(i3, false);
                zzauy.zzb();
                zzapc zzapc = this.zza;
                zzapc.zzf++;
                this.zzo++;
                int i6 = this.zzp + 1;
                this.zzp = i6;
                zzapc.zzg = Math.max(i6, zzapc.zzg);
                if (this.zzo == -1) {
                    zzae();
                }
                return true;
            }
            if (zzava.zza >= 21) {
                if (j8 < 50000) {
                    zzP(mediaCodec, i, j6, zzc2);
                    return true;
                }
            } else if (j8 < 30000) {
                if (j8 > 11000) {
                    try {
                        Thread.sleep((j8 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzO(mediaCodec2, i3, j6);
                return true;
            }
            return false;
        }
    }

    public final void zzS() {
        if (!this.zzl) {
            this.zzl = true;
            this.zze.zzf(this.zzj);
        }
    }

    public final boolean zzV(zzarc zzarc) {
        return this.zzj != null || zzT(zzarc.zzd);
    }

    public final void zzY() {
        try {
            super.zzY();
        } finally {
            Surface surface = this.zzk;
            if (surface != null) {
                if (this.zzj == surface) {
                    this.zzj = null;
                }
                surface.release();
                this.zzk = null;
            }
        }
    }

    public final void zzZ(zzapd zzapd) {
        int i = zzava.zza;
    }

    public final boolean zzaa(MediaCodec mediaCodec, boolean z, zzank zzank, zzank zzank2) {
        if (!zzai(z, zzank, zzank2)) {
            return false;
        }
        int i = zzank2.zzj;
        zzavi zzavi = this.zzi;
        return i <= zzavi.zza && zzank2.zzk <= zzavi.zzb && zzank2.zzg <= zzavi.zzc;
    }

    public final void zzr(int i, Object obj) throws zzamw {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.zzk;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzarc zzX = zzX();
                    if (zzX != null && zzT(zzX.zzd)) {
                        surface = zzavg.zzb(this.zzc, zzX.zzd);
                        this.zzk = surface;
                    }
                }
            }
            if (this.zzj != surface) {
                this.zzj = surface;
                int zze2 = zze();
                if (zze2 == 1 || zze2 == 2) {
                    MediaCodec zzW = zzW();
                    if (zzava.zza < 23 || zzW == null || surface == null) {
                        zzY();
                        zzU();
                    } else {
                        zzW.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzk) {
                    zzab();
                    this.zzl = false;
                    int i2 = zzava.zza;
                    return;
                }
                zzad();
                this.zzl = false;
                int i3 = zzava.zza;
                if (zze2 == 2) {
                    this.zzm = -9223372036854775807L;
                }
            } else if (surface != null && surface != this.zzk) {
                zzad();
                if (this.zzl) {
                    this.zze.zzf(this.zzj);
                }
            }
        }
    }

    public final void zzs(boolean z) throws zzamw {
        super.zzs(z);
        int i = zzy().zzb;
        this.zze.zza(this.zza);
        this.zzd.zza();
    }

    public final void zzt(zzank[] zzankArr, long j) throws zzamw {
        this.zzh = zzankArr;
        if (this.zzA == -9223372036854775807L) {
            this.zzA = j;
            return;
        }
        int i = this.zzB;
        if (i == 10) {
            long j2 = this.zzg[9];
            StringBuilder sb = new StringBuilder(65);
            sb.append("Too many stream changes, so dropping offset: ");
            sb.append(j2);
            Log.w("MediaCodecVideoRenderer", sb.toString());
        } else {
            this.zzB = i + 1;
        }
        this.zzg[this.zzB - 1] = j;
    }

    public final void zzu(long j, boolean z) throws zzamw {
        super.zzu(j, z);
        this.zzl = false;
        int i = zzava.zza;
        this.zzp = 0;
        int i2 = this.zzB;
        if (i2 != 0) {
            this.zzA = this.zzg[i2 - 1];
            this.zzB = 0;
        }
        this.zzm = -9223372036854775807L;
    }

    public final void zzv() {
        this.zzo = 0;
        this.zzn = SystemClock.elapsedRealtime();
        this.zzm = -9223372036854775807L;
    }

    public final void zzw() {
        zzae();
    }

    public final void zzx() {
        this.zzs = -1;
        this.zzt = -1;
        this.zzv = -1.0f;
        this.zzr = -1.0f;
        this.zzA = -9223372036854775807L;
        this.zzB = 0;
        zzab();
        this.zzl = false;
        int i = zzava.zza;
        this.zzd.zzb();
        try {
            super.zzx();
        } finally {
            this.zza.zza();
            this.zze.zzg(this.zza);
        }
    }
}
