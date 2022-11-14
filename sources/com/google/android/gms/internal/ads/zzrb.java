package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzrb extends zzaaj implements zzakc {
    public final Context zzb;
    public final zzpy zzc;
    public final zzqf zzd;
    public int zze;
    public boolean zzf;
    @Nullable
    public zzkc zzg;
    public long zzh;
    public boolean zzi;
    public boolean zzj;
    public boolean zzk;
    @Nullable
    public zzlz zzl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzrb(Context context, zzaal zzaal, @Nullable Handler handler, @Nullable zzpz zzpz) {
        super(1, zzaae.zza, zzaal, false, 44100.0f);
        zzqw zzqw = new zzqw((zzpj) null, new zzpn[0], false);
        this.zzb = context.getApplicationContext();
        this.zzd = zzqw;
        this.zzc = new zzpy(handler, zzpz);
        zzqw.zza(new zzra(this, (zzqz) null));
    }

    private final void zzaA() {
        long zzd2 = this.zzd.zzd(zzM());
        if (zzd2 != Long.MIN_VALUE) {
            if (!this.zzj) {
                zzd2 = Math.max(this.zzh, zzd2);
            }
            this.zzh = zzd2;
            this.zzj = false;
        }
    }

    private final int zzaz(zzaah zzaah, zzkc zzkc) {
        int i;
        if (!"OMX.google.raw.decoder".equals(zzaah.zza) || (i = zzalh.zza) >= 24 || (i == 23 && zzalh.zzV(this.zzb))) {
            return zzkc.zzm;
        }
        return -1;
    }

    public final void zzA() {
        try {
            super.zzA();
            if (this.zzk) {
                this.zzk = false;
                this.zzd.zzw();
            }
        } catch (Throwable th) {
            if (this.zzk) {
                this.zzk = false;
                this.zzd.zzw();
            }
            throw th;
        }
    }

    public final String zzJ() {
        return "MediaCodecAudioRenderer";
    }

    public final boolean zzL() {
        return this.zzd.zzk() || super.zzL();
    }

    public final boolean zzM() {
        return super.zzM() && this.zzd.zzj();
    }

    public final int zzO(zzaal zzaal, zzkc zzkc) throws zzaas {
        if (!zzakg.zza(zzkc.zzl)) {
            return 0;
        }
        int i = zzalh.zza >= 21 ? 32 : 0;
        Class cls = zzkc.zzE;
        boolean zzax = zzaaj.zzax(zzkc);
        if (zzax && this.zzd.zzb(zzkc) && (cls == null || zzaax.zza() != null)) {
            return i | 12;
        }
        if (("audio/raw".equals(zzkc.zzl) && !this.zzd.zzb(zzkc)) || !this.zzd.zzb(zzalh.zzL(2, zzkc.zzy, zzkc.zzz))) {
            return 1;
        }
        List<zzaah> zzP = zzP(zzaal, zzkc, false);
        if (zzP.isEmpty()) {
            return 1;
        }
        if (!zzax) {
            return 2;
        }
        zzaah zzaah = zzP.get(0);
        boolean zzc2 = zzaah.zzc(zzkc);
        int i2 = 8;
        if (zzc2 && zzaah.zzd(zzkc)) {
            i2 = 16;
        }
        return (true != zzc2 ? 3 : 4) | i2 | i;
    }

    public final List<zzaah> zzP(zzaal zzaal, zzkc zzkc, boolean z) throws zzaas {
        zzaah zza;
        String str = zzkc.zzl;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.zzd.zzb(zzkc) && (zza = zzaax.zza()) != null) {
            return Collections.singletonList(zza);
        }
        List<zzaah> zzd2 = zzaax.zzd(zzaax.zzc(str, false, false), zzkc);
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList = new ArrayList(zzd2);
            arrayList.addAll(zzaax.zzc("audio/eac3", false, false));
            zzd2 = arrayList;
        }
        return Collections.unmodifiableList(zzd2);
    }

    public final boolean zzQ(zzkc zzkc) {
        return this.zzd.zzb(zzkc);
    }

    public final zzaad zzR(zzaah zzaah, zzkc zzkc, @Nullable MediaCrypto mediaCrypto, float f) {
        zzkc[] zzC = zzC();
        int zzaz = zzaz(zzaah, zzkc);
        if (r1 != 1) {
            for (zzkc zzkc2 : zzC) {
                if (zzaah.zze(zzkc, zzkc2).zzd != 0) {
                    zzaz = Math.max(zzaz, zzaz(zzaah, zzkc2));
                }
            }
        }
        this.zze = zzaz;
        this.zzf = zzalh.zza < 24 && "OMX.SEC.aac.dec".equals(zzaah.zza) && "samsung".equals(zzalh.zzc) && (zzalh.zzb.startsWith("zeroflte") || zzalh.zzb.startsWith("herolte") || zzalh.zzb.startsWith("heroqlte"));
        String str = zzaah.zzc;
        int i = this.zze;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", zzkc.zzy);
        mediaFormat.setInteger("sample-rate", zzkc.zzz);
        zzakd.zza(mediaFormat, zzkc.zzn);
        zzakd.zzb(mediaFormat, "max-input-size", i);
        if (zzalh.zza >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && (zzalh.zza != 23 || (!"ZTE B2017G".equals(zzalh.zzd) && !"AXON 7 mini".equals(zzalh.zzd)))) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (zzalh.zza <= 28 && "audio/ac4".equals(zzkc.zzl)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (zzalh.zza >= 24 && this.zzd.zzc(zzalh.zzL(4, zzkc.zzy, zzkc.zzz)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        zzkc zzkc3 = null;
        if ("audio/raw".equals(zzaah.zzb) && !"audio/raw".equals(zzkc.zzl)) {
            zzkc3 = zzkc;
        }
        this.zzg = zzkc3;
        return new zzaad(zzaah, mediaFormat, zzkc, (Surface) null, (MediaCrypto) null, 0);
    }

    public final zzrs zzS(zzaah zzaah, zzkc zzkc, zzkc zzkc2) {
        int i;
        int i2;
        zzrs zze2 = zzaah.zze(zzkc, zzkc2);
        int i3 = zze2.zze;
        if (zzaz(zzaah, zzkc2) > this.zze) {
            i3 |= 64;
        }
        String str = zzaah.zza;
        if (i3 != 0) {
            i = i3;
            i2 = 0;
        } else {
            i2 = zze2.zzd;
            i = 0;
        }
        return new zzrs(str, zzkc, zzkc2, i2, i);
    }

    public final float zzT(float f, zzkc zzkc, zzkc[] zzkcArr) {
        int i = -1;
        for (zzkc zzkc2 : zzkcArr) {
            int i2 = zzkc2.zzz;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return ((float) i) * f;
    }

    public final void zzU(String str, long j, long j2) {
        this.zzc.zzb(str, j, j2);
    }

    public final void zzV(String str) {
        this.zzc.zzf(str);
    }

    public final void zzW(Exception exc) {
        zzaka.zzb("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zzj(exc);
    }

    @Nullable
    public final zzrs zzX(zzkd zzkd) throws zzio {
        zzrs zzX = super.zzX(zzkd);
        this.zzc.zzc(zzkd.zza, zzX);
        return zzX;
    }

    public final void zzY(zzkc zzkc, @Nullable MediaFormat mediaFormat) throws zzio {
        int i;
        int i2;
        zzkc zzkc2 = this.zzg;
        int[] iArr = null;
        if (zzkc2 != null) {
            zzkc = zzkc2;
        } else if (zzay() != null) {
            if ("audio/raw".equals(zzkc.zzl)) {
                i = zzkc.zzA;
            } else if (zzalh.zza >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i = zzalh.zzM(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i = "audio/raw".equals(zzkc.zzl) ? zzkc.zzA : 2;
            }
            zzkb zzkb = new zzkb();
            zzkb.zzj("audio/raw");
            zzkb.zzy(i);
            zzkb.zzz(zzkc.zzB);
            zzkb.zzA(zzkc.zzC);
            zzkb.zzw(mediaFormat.getInteger("channel-count"));
            zzkb.zzx(mediaFormat.getInteger("sample-rate"));
            zzkc zzD = zzkb.zzD();
            if (this.zzf && zzD.zzy == 6 && (i2 = zzkc.zzy) < 6) {
                iArr = new int[i2];
                for (int i3 = 0; i3 < zzkc.zzy; i3++) {
                    iArr[i3] = i3;
                }
            }
            zzkc = zzD;
        }
        try {
            this.zzd.zze(zzkc, 0, iArr);
        } catch (zzqa e) {
            throw zzE(e, e.zza, false);
        }
    }

    @CallSuper
    public final void zzZ() {
        this.zzj = true;
    }

    public final void zzaa(zzrr zzrr) {
        if (this.zzi && !zzrr.zzb()) {
            if (Math.abs(zzrr.zzd - this.zzh) > 500000) {
                this.zzh = zzrr.zzd;
            }
            this.zzi = false;
        }
    }

    public final void zzab() {
        this.zzd.zzg();
    }

    public final void zzac() throws zzio {
        try {
            this.zzd.zzi();
        } catch (zzqe e) {
            throw zzE(e, e.zzb, e.zza);
        }
    }

    public final boolean zzaf(long j, long j2, @Nullable zzabb zzabb, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzkc zzkc) throws zzio {
        if (byteBuffer == null) {
            throw null;
        } else if (this.zzg == null || (i2 & 2) == 0) {
            if (z) {
                if (zzabb != null) {
                    zzabb.zzh(i, false);
                }
                this.zza.zzf += i3;
                this.zzd.zzg();
                return true;
            }
            try {
                if (!this.zzd.zzh(byteBuffer, j3, i3)) {
                    return false;
                }
                if (zzabb != null) {
                    zzabb.zzh(i, false);
                }
                this.zza.zze += i3;
                return true;
            } catch (zzqb e) {
                throw zzE(e, e.zzb, false);
            } catch (zzqe e2) {
                throw zzE(e2, zzkc, e2.zza);
            }
        } else if (zzabb != null) {
            zzabb.zzh(i, false);
            return true;
        } else {
            throw null;
        }
    }

    @Nullable
    public final zzakc zzd() {
        return this;
    }

    public final long zzg() {
        if (zze() == 2) {
            zzaA();
        }
        return this.zzh;
    }

    public final void zzh(zzll zzll) {
        this.zzd.zzl(zzll);
    }

    public final zzll zzi() {
        return this.zzd.zzm();
    }

    public final void zzt(int i, @Nullable Object obj) throws zzio {
        if (i == 2) {
            this.zzd.zzt(((Float) obj).floatValue());
        } else if (i == 3) {
            this.zzd.zzo((zzpi) obj);
        } else if (i != 5) {
            switch (i) {
                case 101:
                    this.zzd.zzn(((Boolean) obj).booleanValue());
                    return;
                case 102:
                    this.zzd.zzp(((Integer) obj).intValue());
                    return;
                case 103:
                    this.zzl = (zzlz) obj;
                    return;
                default:
                    return;
            }
        } else {
            this.zzd.zzq((zzqk) obj);
        }
    }

    public final void zzu(boolean z, boolean z2) throws zzio {
        super.zzu(z, z2);
        this.zzc.zza(this.zza);
        if (zzD().zzb) {
            this.zzd.zzr();
        } else {
            this.zzd.zzs();
        }
    }

    public final void zzw(long j, boolean z) throws zzio {
        super.zzw(j, z);
        this.zzd.zzv();
        this.zzh = j;
        this.zzi = true;
        this.zzj = true;
    }

    public final void zzx() {
        this.zzd.zzf();
    }

    public final void zzy() {
        zzaA();
        this.zzd.zzu();
    }

    public final void zzz() {
        this.zzk = true;
        try {
            this.zzd.zzv();
            try {
                super.zzz();
            } finally {
                this.zzc.zzg(this.zza);
            }
        } catch (Throwable th) {
            super.zzz();
            throw th;
        } finally {
            this.zzc.zzg(this.zza);
        }
    }
}
