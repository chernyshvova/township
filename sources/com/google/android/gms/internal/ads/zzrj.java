package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzrj extends zzql {
    public int zzd;
    public int zze;
    public boolean zzf;
    public int zzg;
    public byte[] zzh = zzalh.zzf;
    public int zzi;
    public long zzj;

    public final void zzc(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (i != 0) {
            int min = Math.min(i, this.zzg);
            this.zzj += (long) (min / this.zzb.zze);
            this.zzg -= min;
            byteBuffer.position(position + min);
            if (this.zzg <= 0) {
                int i2 = i - min;
                int length = (this.zzi + i2) - this.zzh.length;
                ByteBuffer zzi2 = zzi(length);
                int zzx = zzalh.zzx(length, 0, this.zzi);
                zzi2.put(this.zzh, 0, zzx);
                int zzx2 = zzalh.zzx(length - zzx, 0, i2);
                byteBuffer.limit(byteBuffer.position() + zzx2);
                zzi2.put(byteBuffer);
                byteBuffer.limit(limit);
                int i3 = i2 - zzx2;
                int i4 = this.zzi - zzx;
                this.zzi = i4;
                byte[] bArr = this.zzh;
                System.arraycopy(bArr, zzx, bArr, 0, i4);
                byteBuffer.get(this.zzh, this.zzi, i3);
                this.zzi += i3;
                zzi2.flip();
            }
        }
    }

    public final ByteBuffer zze() {
        int i;
        if (super.zzf() && (i = this.zzi) > 0) {
            zzi(i).put(this.zzh, 0, this.zzi).flip();
            this.zzi = 0;
        }
        return super.zze();
    }

    public final boolean zzf() {
        return super.zzf() && this.zzi == 0;
    }

    public final zzpl zzk(zzpl zzpl) throws zzpm {
        if (zzpl.zzd == 2) {
            this.zzf = true;
            return (this.zzd == 0 && this.zze == 0) ? zzpl.zza : zzpl;
        }
        throw new zzpm(zzpl);
    }

    public final void zzl() {
        if (this.zzf) {
            int i = this.zzi;
            if (i > 0) {
                this.zzj += (long) (i / this.zzb.zze);
            }
            this.zzi = 0;
        }
    }

    public final void zzm() {
        if (this.zzf) {
            this.zzf = false;
            int i = this.zze;
            int i2 = this.zzb.zze;
            this.zzh = new byte[(i * i2)];
            this.zzg = this.zzd * i2;
        }
        this.zzi = 0;
    }

    public final void zzn() {
        this.zzh = zzalh.zzf;
    }

    public final void zzo(int i, int i2) {
        this.zzd = i;
        this.zze = i2;
    }

    public final void zzp() {
        this.zzj = 0;
    }

    public final long zzq() {
        return this.zzj;
    }
}
