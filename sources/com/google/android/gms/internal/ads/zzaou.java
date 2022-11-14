package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaou extends zzare implements zzaup {
    public final zzaog zzb;
    public final zzaoq zzc = new zzaoq((zzanx) null, new zzanz[0], new zzaot(this, (zzaos) null));
    public boolean zzd;
    public int zze;
    public int zzf;
    public long zzg;
    public boolean zzh;

    public zzaou(zzarg zzarg, zzapi zzapi, boolean z, Handler handler, zzaoh zzaoh) {
        super(1, zzarg, (zzapi) null, true);
        this.zzb = new zzaog(handler, zzaoh);
    }

    public final boolean zzE() {
        return this.zzc.zzh() || super.zzE();
    }

    public final boolean zzF() {
        return super.zzF() && this.zzc.zzg();
    }

    public final int zzH(zzarg zzarg, zzank zzank) throws zzarj {
        int i;
        int i2;
        String str = zzank.zzf;
        if (!zzauq.zza(str)) {
            return 0;
        }
        int i3 = zzava.zza >= 21 ? 16 : 0;
        zzarc zza = zzarn.zza(str, false);
        if (zza == null) {
            return 1;
        }
        int i4 = 2;
        if (zzava.zza < 21 || (((i = zzank.zzs) == -1 || zza.zzg(i)) && ((i2 = zzank.zzr) == -1 || zza.zzh(i2)))) {
            i4 = 3;
        }
        return i3 | 4 | i4;
    }

    public final zzarc zzI(zzarg zzarg, zzank zzank, boolean z) throws zzarj {
        return super.zzI(zzarg, zzank, false);
    }

    public final void zzJ(zzarc zzarc, MediaCodec mediaCodec, zzank zzank, MediaCrypto mediaCrypto) {
        String str = zzarc.zza;
        boolean z = true;
        if (zzava.zza >= 24 || !"OMX.SEC.aac.dec".equals(str) || !"samsung".equals(zzava.zzc) || (!zzava.zzb.startsWith("zeroflte") && !zzava.zzb.startsWith("herolte") && !zzava.zzb.startsWith("heroqlte"))) {
            z = false;
        }
        this.zzd = z;
        mediaCodec.configure(zzank.zzl(), (Surface) null, (MediaCrypto) null, 0);
    }

    public final void zzK(String str, long j, long j2) {
        this.zzb.zzb(str, j, j2);
    }

    public final void zzL(zzank zzank) throws zzamw {
        super.zzL(zzank);
        this.zzb.zzc(zzank);
        this.zze = "audio/raw".equals(zzank.zzf) ? zzank.zzt : 2;
        this.zzf = zzank.zzr;
    }

    public final void zzM(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzamw {
        int[] iArr;
        int i;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.zzd || integer != 6) {
            i = integer;
            iArr = null;
        } else {
            int i2 = this.zzf;
            if (i2 < 6) {
                int[] iArr2 = new int[i2];
                for (int i3 = 0; i3 < this.zzf; i3++) {
                    iArr2[i3] = i3;
                }
                iArr = iArr2;
            } else {
                iArr = null;
            }
            i = 6;
        }
        try {
            this.zzc.zzb("audio/raw", i, integer2, this.zze, 0, iArr);
        } catch (zzaol e) {
            throw zzamw.zza(e, zzz());
        }
    }

    public final long zzN() {
        long zza = this.zzc.zza(zzF());
        if (zza != Long.MIN_VALUE) {
            if (!this.zzh) {
                zza = Math.max(this.zzg, zza);
            }
            this.zzg = zza;
            this.zzh = false;
        }
        return this.zzg;
    }

    public final zzano zzO(zzano zzano) {
        return this.zzc.zzi(zzano);
    }

    public final zzano zzP() {
        return this.zzc.zzj();
    }

    public final boolean zzQ(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzamw {
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zza.zze++;
            this.zzc.zzd();
            return true;
        }
        try {
            if (!this.zzc.zze(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.zza.zzd++;
            return true;
        } catch (zzaom | zzaop e) {
            throw zzamw.zza(e, zzz());
        }
    }

    public final void zzR() throws zzamw {
        try {
            this.zzc.zzf();
        } catch (zzaop e) {
            throw zzamw.zza(e, zzz());
        }
    }

    public final zzaup zzd() {
        return this;
    }

    public final void zzr(int i, Object obj) throws zzamw {
        if (i == 2) {
            this.zzc.zzk(((Float) obj).floatValue());
        }
    }

    public final void zzs(boolean z) throws zzamw {
        super.zzs(z);
        this.zzb.zza(this.zza);
        int i = zzy().zzb;
    }

    public final void zzu(long j, boolean z) throws zzamw {
        super.zzu(j, z);
        this.zzc.zzm();
        this.zzg = j;
        this.zzh = true;
    }

    public final void zzv() {
        this.zzc.zzc();
    }

    public final void zzw() {
        this.zzc.zzl();
    }

    public final void zzx() {
        try {
            this.zzc.zzn();
            try {
                super.zzx();
            } finally {
                this.zza.zza();
                this.zzb.zze(this.zza);
            }
        } catch (Throwable th) {
            super.zzx();
            throw th;
        } finally {
            this.zza.zza();
            this.zzb.zze(this.zza);
        }
    }
}
