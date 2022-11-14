package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzri implements zzpn {
    public int zzb;
    public float zzc = 1.0f;
    public float zzd = 1.0f;
    public zzpl zze;
    public zzpl zzf;
    public zzpl zzg;
    public zzpl zzh;
    public boolean zzi;
    @Nullable
    public zzrh zzj;
    public ByteBuffer zzk;
    public ShortBuffer zzl;
    public ByteBuffer zzm;
    public long zzn;
    public long zzo;
    public boolean zzp;

    public zzri() {
        zzpl zzpl = zzpl.zza;
        this.zze = zzpl;
        this.zzf = zzpl;
        this.zzg = zzpl;
        this.zzh = zzpl;
        ByteBuffer byteBuffer = zzpn.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = zzpn.zza;
        this.zzb = -1;
    }

    public final zzpl zza(zzpl zzpl) throws zzpm {
        if (zzpl.zzd == 2) {
            int i = this.zzb;
            if (i == -1) {
                i = zzpl.zzb;
            }
            this.zze = zzpl;
            zzpl zzpl2 = new zzpl(i, zzpl.zzc, 2);
            this.zzf = zzpl2;
            this.zzi = true;
            return zzpl2;
        }
        throw new zzpm(zzpl);
    }

    public final boolean zzb() {
        if (this.zzf.zzb != -1) {
            return Math.abs(this.zzc + -1.0f) >= 1.0E-4f || Math.abs(this.zzd + -1.0f) >= 1.0E-4f || this.zzf.zzb != this.zze.zzb;
        }
        return false;
    }

    public final void zzc(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzrh zzrh = this.zzj;
            if (zzrh != null) {
                ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
                int remaining = byteBuffer.remaining();
                this.zzn += (long) remaining;
                zzrh.zzb(asShortBuffer);
                byteBuffer.position(byteBuffer.position() + remaining);
                return;
            }
            throw null;
        }
    }

    public final void zzd() {
        zzrh zzrh = this.zzj;
        if (zzrh != null) {
            zzrh.zzd();
        }
        this.zzp = true;
    }

    public final ByteBuffer zze() {
        int zzf2;
        zzrh zzrh = this.zzj;
        if (zzrh != null && (zzf2 = zzrh.zzf()) > 0) {
            if (this.zzk.capacity() < zzf2) {
                ByteBuffer order = ByteBuffer.allocateDirect(zzf2).order(ByteOrder.nativeOrder());
                this.zzk = order;
                this.zzl = order.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzrh.zzc(this.zzl);
            this.zzo += (long) zzf2;
            this.zzk.limit(zzf2);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zzpn.zza;
        return byteBuffer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r3.zzj;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzf() {
        /*
            r3 = this;
            boolean r0 = r3.zzp
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzrh r0 = r3.zzj
            if (r0 == 0) goto L_0x0013
            int r0 = r0.zzf()
            if (r0 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            return r1
        L_0x0012:
            r1 = 0
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzri.zzf():boolean");
    }

    public final void zzg() {
        if (zzb()) {
            zzpl zzpl = this.zze;
            this.zzg = zzpl;
            zzpl zzpl2 = this.zzf;
            this.zzh = zzpl2;
            if (this.zzi) {
                this.zzj = new zzrh(zzpl.zzb, zzpl.zzc, this.zzc, this.zzd, zzpl2.zzb);
            } else {
                zzrh zzrh = this.zzj;
                if (zzrh != null) {
                    zzrh.zze();
                }
            }
        }
        this.zzm = zzpn.zza;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final void zzh() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        zzpl zzpl = zzpl.zza;
        this.zze = zzpl;
        this.zzf = zzpl;
        this.zzg = zzpl;
        this.zzh = zzpl;
        ByteBuffer byteBuffer = zzpn.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = zzpn.zza;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final void zzi(float f) {
        if (this.zzc != f) {
            this.zzc = f;
            this.zzi = true;
        }
    }

    public final void zzj(float f) {
        if (this.zzd != f) {
            this.zzd = f;
            this.zzi = true;
        }
    }

    public final long zzk(long j) {
        if (this.zzo >= 1024) {
            long j2 = this.zzn;
            zzrh zzrh = this.zzj;
            if (zzrh != null) {
                long zza = j2 - ((long) zzrh.zza());
                int i = this.zzh.zzb;
                int i2 = this.zzg.zzb;
                if (i == i2) {
                    return zzalh.zzF(j, zza, this.zzo);
                }
                return zzalh.zzF(j, zza * ((long) i), this.zzo * ((long) i2));
            }
            throw null;
        }
        double d = (double) this.zzc;
        double d2 = (double) j;
        Double.isNaN(d);
        Double.isNaN(d2);
        return (long) (d * d2);
    }
}
