package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzrg extends zzql {
    public int zzd;
    public boolean zze;
    public byte[] zzf;
    public byte[] zzg;
    public int zzh;
    public int zzi;
    public int zzj;
    public boolean zzk;
    public long zzl;

    public zzrg() {
        byte[] bArr = zzalh.zzf;
        this.zzf = bArr;
        this.zzg = bArr;
    }

    private final void zzq(byte[] bArr, int i) {
        zzi(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.zzk = true;
        }
    }

    private final void zzr(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int min = Math.min(byteBuffer.remaining(), this.zzj);
        int i2 = this.zzj - min;
        System.arraycopy(bArr, i - i2, this.zzg, 0, i2);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.zzg, i2, min);
    }

    private final int zzs(long j) {
        return (int) ((j * ((long) this.zzb.zzb)) / 1000000);
    }

    private final int zzt(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs(byteBuffer.getShort(position)) > 1024) {
                int i = this.zzd;
                return (position / i) * i;
            }
        }
        return byteBuffer.limit();
    }

    public final boolean zzb() {
        return this.zze;
    }

    public final void zzc(ByteBuffer byteBuffer) {
        int position;
        while (byteBuffer.hasRemaining() && !zzj()) {
            int i = this.zzh;
            if (i == 0) {
                int limit = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.zzf.length));
                int limit2 = byteBuffer.limit();
                while (true) {
                    limit2 -= 2;
                    if (limit2 >= byteBuffer.position()) {
                        if (Math.abs(byteBuffer.getShort(limit2)) > 1024) {
                            int i2 = this.zzd;
                            position = ((limit2 / i2) * i2) + i2;
                            break;
                        }
                    } else {
                        position = byteBuffer.position();
                        break;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.zzh = 1;
                } else {
                    byteBuffer.limit(position);
                    int remaining = byteBuffer.remaining();
                    zzi(remaining).put(byteBuffer).flip();
                    if (remaining > 0) {
                        this.zzk = true;
                    }
                }
                byteBuffer.limit(limit);
            } else if (i != 1) {
                int limit3 = byteBuffer.limit();
                int zzt = zzt(byteBuffer);
                byteBuffer.limit(zzt);
                this.zzl += (long) (byteBuffer.remaining() / this.zzd);
                zzr(byteBuffer, this.zzg, this.zzj);
                if (zzt < limit3) {
                    zzq(this.zzg, this.zzj);
                    this.zzh = 0;
                    byteBuffer.limit(limit3);
                }
            } else {
                int limit4 = byteBuffer.limit();
                int zzt2 = zzt(byteBuffer);
                int position2 = zzt2 - byteBuffer.position();
                byte[] bArr = this.zzf;
                int length = bArr.length;
                int i3 = this.zzi;
                int i4 = length - i3;
                if (zzt2 >= limit4 || position2 >= i4) {
                    int min = Math.min(position2, i4);
                    byteBuffer.limit(byteBuffer.position() + min);
                    byteBuffer.get(this.zzf, this.zzi, min);
                    int i5 = this.zzi + min;
                    this.zzi = i5;
                    byte[] bArr2 = this.zzf;
                    if (i5 == bArr2.length) {
                        if (this.zzk) {
                            zzq(bArr2, this.zzj);
                            long j = this.zzl;
                            int i6 = this.zzi;
                            int i7 = this.zzj;
                            this.zzl = j + ((long) ((i6 - (i7 + i7)) / this.zzd));
                            i5 = i6;
                        } else {
                            this.zzl += (long) ((i5 - this.zzj) / this.zzd);
                        }
                        zzr(byteBuffer, this.zzf, i5);
                        this.zzi = 0;
                        this.zzh = 2;
                    }
                    byteBuffer.limit(limit4);
                } else {
                    zzq(bArr, i3);
                    this.zzi = 0;
                    this.zzh = 0;
                }
            }
        }
    }

    public final zzpl zzk(zzpl zzpl) throws zzpm {
        if (zzpl.zzd == 2) {
            return this.zze ? zzpl : zzpl.zza;
        }
        throw new zzpm(zzpl);
    }

    public final void zzl() {
        int i = this.zzi;
        if (i > 0) {
            zzq(this.zzf, i);
        }
        if (!this.zzk) {
            this.zzl += (long) (this.zzj / this.zzd);
        }
    }

    public final void zzm() {
        if (this.zze) {
            this.zzd = this.zzb.zze;
            int zzs = zzs(150000) * this.zzd;
            if (this.zzf.length != zzs) {
                this.zzf = new byte[zzs];
            }
            int zzs2 = zzs(20000) * this.zzd;
            this.zzj = zzs2;
            if (this.zzg.length != zzs2) {
                this.zzg = new byte[zzs2];
            }
        }
        this.zzh = 0;
        this.zzl = 0;
        this.zzi = 0;
        this.zzk = false;
    }

    public final void zzn() {
        this.zze = false;
        this.zzj = 0;
        byte[] bArr = zzalh.zzf;
        this.zzf = bArr;
        this.zzg = bArr;
    }

    public final void zzo(boolean z) {
        this.zze = z;
    }

    public final long zzp() {
        return this.zzl;
    }
}
