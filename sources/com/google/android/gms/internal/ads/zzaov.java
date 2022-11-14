package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaov implements zzanz {
    public int zzb = -1;
    public int zzc = -1;
    public int zzd = 0;
    public ByteBuffer zze;
    public ByteBuffer zzf;
    public boolean zzg;

    public zzaov() {
        ByteBuffer byteBuffer = zzanz.zza;
        this.zze = byteBuffer;
        this.zzf = byteBuffer;
    }

    public final boolean zza(int i, int i2, int i3) throws zzany {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new zzany(i, i2, i3);
        } else if (this.zzb == i && this.zzc == i2 && this.zzd == i3) {
            return false;
        } else {
            this.zzb = i;
            this.zzc = i2;
            this.zzd = i3;
            if (i3 != 2) {
                return true;
            }
            this.zze = zzanz.zza;
            return true;
        }
    }

    public final boolean zzb() {
        int i = this.zzd;
        return (i == 0 || i == 2) ? false : true;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080 A[LOOP:2: B:23:0x0080->B:24:0x0082, LOOP_START, PHI: r0 
      PHI: (r0v2 int) = (r0v0 int), (r0v3 int) binds: [B:14:0x0040, B:24:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(java.nio.ByteBuffer r8) {
        /*
            r7 = this;
            int r0 = r8.position()
            int r1 = r8.limit()
            int r2 = r1 - r0
            int r3 = r7.zzd
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 3
            if (r3 == r5) goto L_0x0020
            if (r3 == r6) goto L_0x0021
            if (r3 != r4) goto L_0x001a
            int r2 = r2 / 2
            goto L_0x0022
        L_0x001a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x0020:
            int r2 = r2 / r6
        L_0x0021:
            int r2 = r2 + r2
        L_0x0022:
            java.nio.ByteBuffer r3 = r7.zze
            int r3 = r3.capacity()
            if (r3 >= r2) goto L_0x0039
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocateDirect(r2)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            r7.zze = r2
            goto L_0x003e
        L_0x0039:
            java.nio.ByteBuffer r2 = r7.zze
            r2.clear()
        L_0x003e:
            int r2 = r7.zzd
            if (r2 == r5) goto L_0x0080
            if (r2 == r6) goto L_0x0067
            if (r2 != r4) goto L_0x0061
        L_0x0046:
            if (r0 >= r1) goto L_0x009b
            java.nio.ByteBuffer r2 = r7.zze
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zze
            int r3 = r0 + 3
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 4
            goto L_0x0046
        L_0x0061:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x0067:
            if (r0 >= r1) goto L_0x009b
            java.nio.ByteBuffer r2 = r7.zze
            r3 = 0
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zze
            byte r3 = r8.get(r0)
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + -128
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 1
            goto L_0x0067
        L_0x0080:
            if (r0 >= r1) goto L_0x009b
            java.nio.ByteBuffer r2 = r7.zze
            int r3 = r0 + 1
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zze
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 3
            goto L_0x0080
        L_0x009b:
            int r0 = r8.limit()
            r8.position(r0)
            java.nio.ByteBuffer r8 = r7.zze
            r8.flip()
            java.nio.ByteBuffer r8 = r7.zze
            r7.zzf = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaov.zze(java.nio.ByteBuffer):void");
    }

    public final void zzf() {
        this.zzg = true;
    }

    public final ByteBuffer zzg() {
        ByteBuffer byteBuffer = this.zzf;
        this.zzf = zzanz.zza;
        return byteBuffer;
    }

    public final boolean zzh() {
        return this.zzg && this.zzf == zzanz.zza;
    }

    public final void zzi() {
        this.zzf = zzanz.zza;
        this.zzg = false;
    }

    public final void zzj() {
        zzi();
        this.zze = zzanz.zza;
        this.zzb = -1;
        this.zzc = -1;
        this.zzd = 0;
    }
}
