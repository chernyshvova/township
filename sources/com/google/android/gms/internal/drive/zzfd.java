package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;

public final class zzfd extends zzkk<zzfd, zza> implements zzls {
    public static volatile zzmb<zzfd> zzhk;
    public static final zzfd zzhq;
    public int zzhd;
    public long zzhg = -1;
    public byte zzhi = 2;
    public long zzhn = -1;

    public static final class zza extends zzkk.zza<zzfd, zza> implements zzls {
        public zza() {
            super(zzfd.zzhq);
        }

        public final zza zzi(long j) {
            zzdb();
            ((zzfd) this.zzru).zzf(j);
            return this;
        }

        public final zza zzj(long j) {
            zzdb();
            ((zzfd) this.zzru).zza(j);
            return this;
        }

        public /* synthetic */ zza(zzfe zzfe) {
            this();
        }
    }

    static {
        zzfd zzfd = new zzfd();
        zzhq = zzfd;
        zzkk.zza(zzfd.class, zzfd);
    }

    /* access modifiers changed from: private */
    public final void zza(long j) {
        this.zzhd |= 2;
        this.zzhg = j;
    }

    public static zza zzap() {
        return (zza) zzhq.zzcw();
    }

    /* access modifiers changed from: private */
    public final void zzf(long j) {
        this.zzhd |= 1;
        this.zzhn = j;
    }

    /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.drive.zzmb<com.google.android.gms.internal.drive.zzfd>, com.google.android.gms.internal.drive.zzkk$zzb] */
    public final Object zza(int i, Object obj, Object obj2) {
        zzmb<zzfd> zzmb;
        int i2 = 1;
        switch (zzfe.zzhl[i - 1]) {
            case 1:
                return new zzfd();
            case 2:
                return new zza((zzfe) null);
            case 3:
                return zzkk.zza((zzlq) zzhq, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԑ\u0000\u0002Ԑ\u0001", new Object[]{"zzhd", "zzhn", "zzhg"});
            case 4:
                return zzhq;
            case 5:
                zzmb<zzfd> zzmb2 = zzhk;
                zzmb<zzfd> zzmb3 = zzmb2;
                if (zzmb2 == null) {
                    synchronized (zzfd.class) {
                        zzmb<zzfd> zzmb4 = zzhk;
                        zzmb = zzmb4;
                        if (zzmb4 == null) {
                            ? zzb = new zzkk.zzb(zzhq);
                            zzhk = zzb;
                            zzmb = zzb;
                        }
                    }
                    zzmb3 = zzmb;
                }
                return zzmb3;
            case 6:
                return Byte.valueOf(this.zzhi);
            case 7:
                if (obj == null) {
                    i2 = 0;
                }
                this.zzhi = (byte) i2;
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
