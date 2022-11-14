package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import com.playrix.gplay.billing.Base64;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(19)
@TargetApi(19)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzare extends zzamu {
    public static final byte[] zzb = zzava.zzm("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    public boolean zzA;
    public int zzB;
    public int zzC;
    public boolean zzD;
    public boolean zzE;
    public boolean zzF;
    public boolean zzG;
    public boolean zzH;
    public zzapc zza;
    public final zzarg zzc;
    public final zzapd zzd;
    public final zzapd zze;
    public final zzanl zzf;
    public final List<Long> zzg;
    public final MediaCodec.BufferInfo zzh;
    public zzank zzi;
    public MediaCodec zzj;
    public zzarc zzk;
    public boolean zzl;
    public boolean zzm;
    public boolean zzn;
    public boolean zzo;
    public boolean zzp;
    public boolean zzq;
    public boolean zzr;
    public boolean zzs;
    public boolean zzt;
    public ByteBuffer[] zzu;
    public ByteBuffer[] zzv;
    public long zzw;
    public int zzx;
    public int zzy;
    public boolean zzz;

    public zzare(int i, zzarg zzarg, zzapi zzapi, boolean z) {
        super(i);
        zzaul.zzd(zzava.zza >= 16);
        this.zzc = zzarg;
        this.zzd = new zzapd(0);
        this.zze = new zzapd(0);
        this.zzf = new zzanl();
        this.zzg = new ArrayList();
        this.zzh = new MediaCodec.BufferInfo();
        this.zzB = 0;
        this.zzC = 0;
    }

    private final boolean zzN() throws zzamw {
        MediaCodec mediaCodec = this.zzj;
        if (mediaCodec == null || this.zzC == 2 || this.zzF) {
            return false;
        }
        if (this.zzx < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0);
            this.zzx = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            zzapd zzapd = this.zzd;
            zzapd.zzb = this.zzu[dequeueInputBuffer];
            zzapd.zza();
        }
        if (this.zzC == 1) {
            if (!this.zzo) {
                this.zzE = true;
                this.zzj.queueInputBuffer(this.zzx, 0, 0, 0, 4);
                this.zzx = -1;
            }
            this.zzC = 2;
            return false;
        } else if (this.zzs) {
            this.zzs = false;
            this.zzd.zzb.put(zzb);
            MediaCodec mediaCodec2 = this.zzj;
            int i = this.zzx;
            int length = zzb.length;
            mediaCodec2.queueInputBuffer(i, 0, 38, 0, 0);
            this.zzx = -1;
            this.zzD = true;
            return true;
        } else {
            if (this.zzB == 1) {
                for (int i2 = 0; i2 < this.zzi.zzh.size(); i2++) {
                    this.zzd.zzb.put(this.zzi.zzh.get(i2));
                }
                this.zzB = 2;
            }
            int position = this.zzd.zzb.position();
            int zzA2 = zzA(this.zzf, this.zzd, false);
            if (zzA2 == -3) {
                return false;
            }
            if (zzA2 == -5) {
                if (this.zzB == 2) {
                    this.zzd.zza();
                    this.zzB = 1;
                }
                zzL(this.zzf.zza);
                return true;
            } else if (this.zzd.zzc()) {
                if (this.zzB == 2) {
                    this.zzd.zza();
                    this.zzB = 1;
                }
                this.zzF = true;
                if (!this.zzD) {
                    zzO();
                    return false;
                }
                try {
                    if (!this.zzo) {
                        this.zzE = true;
                        this.zzj.queueInputBuffer(this.zzx, 0, 0, 0, 4);
                        this.zzx = -1;
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw zzamw.zza(e, zzz());
                }
            } else if (!this.zzH || this.zzd.zzd()) {
                this.zzH = false;
                boolean zzi2 = this.zzd.zzi();
                if (this.zzl && !zzi2) {
                    ByteBuffer byteBuffer = this.zzd.zzb;
                    byte[] bArr = zzaur.zza;
                    int position2 = byteBuffer.position();
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        int i5 = i3 + 1;
                        if (i5 >= position2) {
                            byteBuffer.clear();
                            break;
                        }
                        byte b = byteBuffer.get(i3) & Base64.EQUALS_SIGN_ENC;
                        if (i4 == 3) {
                            if (b == 1) {
                                if ((byteBuffer.get(i5) & 31) == 7) {
                                    ByteBuffer duplicate = byteBuffer.duplicate();
                                    duplicate.position(i3 - 3);
                                    duplicate.limit(position2);
                                    byteBuffer.position(0);
                                    byteBuffer.put(duplicate);
                                    break;
                                }
                                b = 1;
                            }
                        } else if (b == 0) {
                            i4++;
                        }
                        if (b != 0) {
                            i4 = 0;
                        }
                        i3 = i5;
                    }
                    if (this.zzd.zzb.position() == 0) {
                        return true;
                    }
                    this.zzl = false;
                }
                try {
                    zzapd zzapd2 = this.zzd;
                    long j = zzapd2.zzc;
                    if (zzapd2.zzb()) {
                        this.zzg.add(Long.valueOf(j));
                    }
                    this.zzd.zzb.flip();
                    zzZ(this.zzd);
                    if (zzi2) {
                        MediaCodec.CryptoInfo zzb2 = this.zzd.zza.zzb();
                        if (position != 0) {
                            if (zzb2.numBytesOfClearData == null) {
                                zzb2.numBytesOfClearData = new int[1];
                            }
                            int[] iArr = zzb2.numBytesOfClearData;
                            iArr[0] = iArr[0] + position;
                        }
                        this.zzj.queueSecureInputBuffer(this.zzx, 0, zzb2, j, 0);
                    } else {
                        this.zzj.queueInputBuffer(this.zzx, 0, this.zzd.zzb.limit(), j, 0);
                    }
                    this.zzx = -1;
                    this.zzD = true;
                    this.zzB = 0;
                    this.zza.zzc++;
                    return true;
                } catch (MediaCodec.CryptoException e2) {
                    throw zzamw.zza(e2, zzz());
                }
            } else {
                this.zzd.zza();
                if (this.zzB == 2) {
                    this.zzB = 1;
                }
                return true;
            }
        }
    }

    private final void zzO() throws zzamw {
        if (this.zzC == 2) {
            zzY();
            zzU();
            return;
        }
        this.zzG = true;
        zzR();
    }

    public final void zzD(long j, long j2) throws zzamw {
        boolean z;
        int i;
        boolean z2;
        if (this.zzG) {
            zzR();
            return;
        }
        if (this.zzi == null) {
            this.zze.zza();
            int zzA2 = zzA(this.zzf, this.zze, true);
            if (zzA2 == -5) {
                zzL(this.zzf.zza);
            } else if (zzA2 == -4) {
                zzaul.zzd(this.zze.zzc());
                this.zzF = true;
                zzO();
                return;
            } else {
                return;
            }
        }
        zzU();
        if (this.zzj != null) {
            zzauy.zza("drainAndFeed");
            while (true) {
                if (this.zzy < 0) {
                    if (!this.zzq || !this.zzE) {
                        i = this.zzj.dequeueOutputBuffer(this.zzh, 0);
                        this.zzy = i;
                    } else {
                        try {
                            i = this.zzj.dequeueOutputBuffer(this.zzh, 0);
                            this.zzy = i;
                        } catch (IllegalStateException unused) {
                            zzO();
                            if (this.zzG) {
                                zzY();
                            }
                        }
                    }
                    if (i >= 0) {
                        if (this.zzt) {
                            this.zzt = false;
                            this.zzj.releaseOutputBuffer(i, false);
                            this.zzy = -1;
                        } else {
                            MediaCodec.BufferInfo bufferInfo = this.zzh;
                            if ((bufferInfo.flags & 4) != 0) {
                                zzO();
                                this.zzy = -1;
                                break;
                            }
                            ByteBuffer byteBuffer = this.zzv[this.zzy];
                            if (byteBuffer != null) {
                                byteBuffer.position(bufferInfo.offset);
                                MediaCodec.BufferInfo bufferInfo2 = this.zzh;
                                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                            }
                            long j3 = this.zzh.presentationTimeUs;
                            int size = this.zzg.size();
                            int i2 = 0;
                            while (true) {
                                if (i2 >= size) {
                                    z2 = false;
                                    break;
                                } else if (this.zzg.get(i2).longValue() == j3) {
                                    this.zzg.remove(i2);
                                    z2 = true;
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            this.zzz = z2;
                        }
                    } else if (i == -2) {
                        MediaFormat outputFormat = this.zzj.getOutputFormat();
                        if (this.zzn && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                            this.zzt = true;
                        } else {
                            if (this.zzr) {
                                outputFormat.setInteger("channel-count", 1);
                            }
                            zzM(this.zzj, outputFormat);
                        }
                    } else if (i == -3) {
                        this.zzv = this.zzj.getOutputBuffers();
                    } else if (this.zzo && (this.zzF || this.zzC == 2)) {
                        zzO();
                    }
                }
                if (!this.zzq || !this.zzE) {
                    MediaCodec mediaCodec = this.zzj;
                    ByteBuffer[] byteBufferArr = this.zzv;
                    int i3 = this.zzy;
                    ByteBuffer byteBuffer2 = byteBufferArr[i3];
                    MediaCodec.BufferInfo bufferInfo3 = this.zzh;
                    z = zzQ(j, j2, mediaCodec, byteBuffer2, i3, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.zzz);
                } else {
                    try {
                        MediaCodec mediaCodec2 = this.zzj;
                        ByteBuffer[] byteBufferArr2 = this.zzv;
                        int i4 = this.zzy;
                        z = zzQ(j, j2, mediaCodec2, byteBufferArr2[i4], i4, this.zzh.flags, this.zzh.presentationTimeUs, this.zzz);
                    } catch (IllegalStateException unused2) {
                        zzO();
                        if (this.zzG) {
                            zzY();
                        }
                    }
                }
                if (!z) {
                    break;
                }
                long j4 = this.zzh.presentationTimeUs;
                this.zzy = -1;
            }
            do {
            } while (zzN());
            zzauy.zzb();
        } else {
            zzB(j);
            this.zze.zza();
            int zzA3 = zzA(this.zzf, this.zze, false);
            if (zzA3 == -5) {
                zzL(this.zzf.zza);
            } else if (zzA3 == -4) {
                zzaul.zzd(this.zze.zzc());
                this.zzF = true;
                zzO();
            }
        }
        this.zza.zza();
    }

    public boolean zzE() {
        if (this.zzi != null) {
            if (zzC() || this.zzy >= 0) {
                return true;
            }
            if (this.zzw == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.zzw) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean zzF() {
        return this.zzG;
    }

    public final int zzG(zzank zzank) throws zzamw {
        try {
            return zzH(this.zzc, zzank);
        } catch (zzarj e) {
            throw zzamw.zza(e, zzz());
        }
    }

    public abstract int zzH(zzarg zzarg, zzank zzank) throws zzarj;

    public zzarc zzI(zzarg zzarg, zzank zzank, boolean z) throws zzarj {
        return zzarn.zza(zzank.zzf, false);
    }

    public abstract void zzJ(zzarc zzarc, MediaCodec mediaCodec, zzank zzank, MediaCrypto mediaCrypto) throws zzarj;

    public void zzK(String str, long j, long j2) {
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r6.zzk == r0.zzk) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzL(com.google.android.gms.internal.ads.zzank r6) throws com.google.android.gms.internal.ads.zzamw {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzank r0 = r5.zzi
            r5.zzi = r6
            com.google.android.gms.internal.ads.zzaph r6 = r6.zzi
            if (r0 != 0) goto L_0x000a
            r1 = 0
            goto L_0x000c
        L_0x000a:
            com.google.android.gms.internal.ads.zzaph r1 = r0.zzi
        L_0x000c:
            boolean r6 = com.google.android.gms.internal.ads.zzava.zza(r6, r1)
            if (r6 != 0) goto L_0x0029
            com.google.android.gms.internal.ads.zzank r6 = r5.zzi
            com.google.android.gms.internal.ads.zzaph r6 = r6.zzi
            if (r6 != 0) goto L_0x0019
            goto L_0x0029
        L_0x0019:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r6.<init>(r0)
            int r0 = r5.zzz()
            com.google.android.gms.internal.ads.zzamw r6 = com.google.android.gms.internal.ads.zzamw.zza(r6, r0)
            throw r6
        L_0x0029:
            android.media.MediaCodec r6 = r5.zzj
            r1 = 1
            if (r6 == 0) goto L_0x0056
            com.google.android.gms.internal.ads.zzarc r2 = r5.zzk
            boolean r2 = r2.zzb
            com.google.android.gms.internal.ads.zzank r3 = r5.zzi
            boolean r6 = r5.zzaa(r6, r2, r0, r3)
            if (r6 == 0) goto L_0x0056
            r5.zzA = r1
            r5.zzB = r1
            boolean r6 = r5.zzn
            r2 = 0
            if (r6 == 0) goto L_0x0052
            com.google.android.gms.internal.ads.zzank r6 = r5.zzi
            int r3 = r6.zzj
            int r4 = r0.zzj
            if (r3 != r4) goto L_0x0052
            int r6 = r6.zzk
            int r0 = r0.zzk
            if (r6 != r0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            r5.zzs = r1
            return
        L_0x0056:
            boolean r6 = r5.zzD
            if (r6 == 0) goto L_0x005d
            r5.zzC = r1
            return
        L_0x005d:
            r5.zzY()
            r5.zzU()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzare.zzL(com.google.android.gms.internal.ads.zzank):void");
    }

    public void zzM(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzamw {
        throw null;
    }

    public abstract boolean zzQ(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzamw;

    public void zzR() throws zzamw {
    }

    public final void zzU() throws zzamw {
        zzank zzank;
        boolean z;
        String str;
        if (this.zzj == null && (zzank = this.zzi) != null) {
            zzarc zzarc = this.zzk;
            if (zzarc == null) {
                try {
                    zzarc = zzI(this.zzc, zzank, false);
                    this.zzk = zzarc;
                    if (zzarc == null) {
                        throw zzamw.zza(new zzard(this.zzi, (Throwable) null, false, -49999), zzz());
                    }
                } catch (zzarj e) {
                    throw zzamw.zza(new zzard(this.zzi, (Throwable) e, false, -49998), zzz());
                }
            }
            if (zzV(zzarc)) {
                String str2 = this.zzk.zza;
                this.zzl = zzava.zza < 21 && this.zzi.zzh.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
                int i = zzava.zza;
                this.zzm = i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzava.zza == 19 && zzava.zzd.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
                this.zzn = zzava.zza < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzava.zzb) || "flounder_lte".equals(zzava.zzb) || "grouper".equals(zzava.zzb) || "tilapia".equals(zzava.zzb));
                this.zzo = zzava.zza <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
                if ((zzava.zza > 23 || !"OMX.google.vorbis.decoder".equals(str2)) && (zzava.zza > 19 || !"hb2000".equals(zzava.zzb) || (!"OMX.amlogic.avc.decoder.awesome".equals(str2) && !"OMX.amlogic.avc.decoder.awesome.secure".equals(str2)))) {
                    z = false;
                } else {
                    z = true;
                }
                this.zzp = z;
                this.zzq = zzava.zza == 21 && "OMX.google.aac.decoder".equals(str2);
                this.zzr = zzava.zza <= 18 && this.zzi.zzr == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    String valueOf = String.valueOf(str2);
                    if (valueOf.length() != 0) {
                        str = "createCodec:".concat(valueOf);
                    } else {
                        str = new String("createCodec:");
                    }
                    zzauy.zza(str);
                    this.zzj = MediaCodec.createByCodecName(str2);
                    zzauy.zzb();
                    zzauy.zza("configureCodec");
                    zzJ(this.zzk, this.zzj, this.zzi, (MediaCrypto) null);
                    zzauy.zzb();
                    zzauy.zza("startCodec");
                    this.zzj.start();
                    zzauy.zzb();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    zzK(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.zzu = this.zzj.getInputBuffers();
                    this.zzv = this.zzj.getOutputBuffers();
                    this.zzw = zze() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.zzx = -1;
                    this.zzy = -1;
                    this.zzH = true;
                    this.zza.zza++;
                } catch (Exception e2) {
                    throw zzamw.zza(new zzard(this.zzi, (Throwable) e2, false, str2), zzz());
                }
            }
        }
    }

    public boolean zzV(zzarc zzarc) {
        return true;
    }

    public final MediaCodec zzW() {
        return this.zzj;
    }

    public final zzarc zzX() {
        return this.zzk;
    }

    public void zzY() {
        this.zzw = -9223372036854775807L;
        this.zzx = -1;
        this.zzy = -1;
        this.zzz = false;
        this.zzg.clear();
        this.zzu = null;
        this.zzv = null;
        this.zzk = null;
        this.zzA = false;
        this.zzD = false;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = false;
        this.zzp = false;
        this.zzr = false;
        this.zzs = false;
        this.zzt = false;
        this.zzE = false;
        this.zzB = 0;
        this.zzC = 0;
        this.zzd.zzb = null;
        MediaCodec mediaCodec = this.zzj;
        if (mediaCodec != null) {
            this.zza.zzb++;
            try {
                mediaCodec.stop();
                try {
                    this.zzj.release();
                } finally {
                    this.zzj = null;
                }
            } catch (Throwable th) {
                this.zzj.release();
                throw th;
            } finally {
                this.zzj = null;
            }
        }
    }

    public void zzZ(zzapd zzapd) {
    }

    public boolean zzaa(MediaCodec mediaCodec, boolean z, zzank zzank, zzank zzank2) {
        return false;
    }

    public final int zzq() {
        return 4;
    }

    public void zzs(boolean z) throws zzamw {
        this.zza = new zzapc();
    }

    public void zzu(long j, boolean z) throws zzamw {
        this.zzF = false;
        this.zzG = false;
        if (this.zzj != null) {
            this.zzw = -9223372036854775807L;
            this.zzx = -1;
            this.zzy = -1;
            this.zzH = true;
            this.zzz = false;
            this.zzg.clear();
            this.zzs = false;
            this.zzt = false;
            if (this.zzm || (this.zzp && this.zzE)) {
                zzY();
                zzU();
            } else if (this.zzC != 0) {
                zzY();
                zzU();
            } else {
                this.zzj.flush();
                this.zzD = false;
            }
            if (this.zzA && this.zzi != null) {
                this.zzB = 1;
            }
        }
    }

    public void zzx() {
        this.zzi = null;
        zzY();
    }
}
