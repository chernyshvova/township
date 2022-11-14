package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyg {
    public final zztz zza;
    public boolean zzb;
    public boolean zzc;
    public boolean zzd;
    public int zze;
    public int zzf;
    public long zzg;
    public long zzh;

    public zzyg(zztz zztz) {
        this.zza = zztz;
    }

    public final void zza() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = false;
        this.zze = -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(int r5, long r6) {
        /*
            r4 = this;
            r4.zze = r5
            r0 = 0
            r4.zzd = r0
            r1 = 179(0xb3, float:2.51E-43)
            r2 = 182(0xb6, float:2.55E-43)
            r3 = 1
            if (r5 == r2) goto L_0x0013
            if (r5 != r1) goto L_0x0011
            r5 = 179(0xb3, float:2.51E-43)
            goto L_0x0013
        L_0x0011:
            r1 = 0
            goto L_0x0014
        L_0x0013:
            r1 = 1
        L_0x0014:
            r4.zzb = r1
            if (r5 != r2) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r3 = 0
        L_0x001a:
            r4.zzc = r3
            r4.zzf = r0
            r4.zzh = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyg.zzb(int, long):void");
    }

    public final void zzc(byte[] bArr, int i, int i2) {
        if (this.zzc) {
            int i3 = this.zzf;
            int i4 = (i + 1) - i3;
            if (i4 < i2) {
                this.zzd = ((bArr[i4] & 192) >> 6) == 0;
                this.zzc = false;
                return;
            }
            this.zzf = (i2 - i) + i3;
        }
    }

    public final void zzd(long j, int i, boolean z) {
        if (this.zze == 182 && z && this.zzb) {
            long j2 = this.zzg;
            this.zza.zzd(this.zzh, this.zzd ? 1 : 0, (int) (j - j2), i, (zzty) null);
        }
        if (this.zze != 179) {
            this.zzg = j;
        }
    }
}
