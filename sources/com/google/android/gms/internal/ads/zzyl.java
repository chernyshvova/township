package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyl implements zzyc {
    public final zzzd zza;
    public final zzyr zzb = new zzyr(7, 128);
    public final zzyr zzc = new zzyr(8, 128);
    public final zzyr zzd = new zzyr(6, 128);
    public long zze;
    public final boolean[] zzf = new boolean[3];
    public String zzg;
    public zztz zzh;
    public zzyk zzi;
    public boolean zzj;
    public long zzk;
    public boolean zzl;
    public final zzakr zzm = new zzakr();

    public zzyl(zzzd zzzd, boolean z, boolean z2) {
        this.zza = zzzd;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i, int i2) {
        if (!this.zzj) {
            this.zzb.zzd(bArr, i, i2);
            this.zzc.zzd(bArr, i, i2);
        }
        this.zzd.zzd(bArr, i, i2);
    }

    public final void zza() {
        this.zze = 0;
        this.zzl = false;
        zzakj.zze(this.zzf);
        this.zzb.zza();
        this.zzc.zza();
        this.zzd.zza();
        zzyk zzyk = this.zzi;
        if (zzyk != null) {
            zzyk.zzc();
        }
    }

    public final void zzb(zztd zztd, zzzo zzzo) {
        zzzo.zza();
        this.zzg = zzzo.zzc();
        zztz zza2 = zztd.zza(zzzo.zzb(), 2);
        this.zzh = zza2;
        this.zzi = new zzyk(zza2, false, false);
        this.zza.zza(zztd, zzzo);
    }

    public final void zzc(long j, int i) {
        this.zzk = j;
        this.zzl |= (i & 2) != 0;
    }

    public final void zzd(zzakr zzakr) {
        zzajg.zze(this.zzh);
        int i = zzalh.zza;
        int zzg2 = zzakr.zzg();
        int zze2 = zzakr.zze();
        byte[] zzi2 = zzakr.zzi();
        this.zze += (long) zzakr.zzd();
        zztx.zzb(this.zzh, zzakr, zzakr.zzd());
        while (true) {
            int zzd2 = zzakj.zzd(zzi2, zzg2, zze2, this.zzf);
            if (zzd2 != zze2) {
                int i2 = zzd2 + 3;
                byte b = zzi2[i2] & 31;
                int i3 = zzd2 - zzg2;
                if (i3 > 0) {
                    zzf(zzi2, zzg2, zzd2);
                }
                int i4 = zze2 - zzd2;
                long j = this.zze - ((long) i4);
                int i5 = i3 < 0 ? -i3 : 0;
                long j2 = this.zzk;
                if (!this.zzj) {
                    this.zzb.zze(i5);
                    this.zzc.zze(i5);
                    if (!this.zzj) {
                        if (this.zzb.zzb() && this.zzc.zzb()) {
                            ArrayList arrayList = new ArrayList();
                            zzyr zzyr = this.zzb;
                            arrayList.add(Arrays.copyOf(zzyr.zza, zzyr.zzb));
                            zzyr zzyr2 = this.zzc;
                            arrayList.add(Arrays.copyOf(zzyr2.zza, zzyr2.zzb));
                            zzyr zzyr3 = this.zzb;
                            zzaki zzb2 = zzakj.zzb(zzyr3.zza, 3, zzyr3.zzb);
                            zzyr zzyr4 = this.zzc;
                            zzakh zzc2 = zzakj.zzc(zzyr4.zza, 3, zzyr4.zzb);
                            String zza2 = zzaji.zza(zzb2.zza, zzb2.zzb, zzb2.zzc);
                            zztz zztz = this.zzh;
                            zzkb zzkb = new zzkb();
                            zzkb.zza(this.zzg);
                            zzkb.zzj("video/avc");
                            zzkb.zzh(zza2);
                            zzkb.zzo(zzb2.zze);
                            zzkb.zzp(zzb2.zzf);
                            zzkb.zzs(zzb2.zzg);
                            zzkb.zzl(arrayList);
                            zztz.zza(zzkb.zzD());
                            this.zzj = true;
                            this.zzi.zza(zzb2);
                            this.zzi.zzb(zzc2);
                            this.zzb.zza();
                            this.zzc.zza();
                        }
                    } else if (this.zzb.zzb()) {
                        zzyr zzyr5 = this.zzb;
                        this.zzi.zza(zzakj.zzb(zzyr5.zza, 3, zzyr5.zzb));
                        this.zzb.zza();
                    } else if (this.zzc.zzb()) {
                        zzyr zzyr6 = this.zzc;
                        this.zzi.zzb(zzakj.zzc(zzyr6.zza, 3, zzyr6.zzb));
                        this.zzc.zza();
                    }
                }
                if (this.zzd.zze(i5)) {
                    zzyr zzyr7 = this.zzd;
                    this.zzm.zzb(this.zzd.zza, zzakj.zza(zzyr7.zza, zzyr7.zzb));
                    this.zzm.zzh(4);
                    this.zza.zzb(j2, this.zzm);
                }
                if (this.zzi.zze(j, i4, this.zzj, this.zzl)) {
                    this.zzl = false;
                }
                long j3 = this.zzk;
                if (!this.zzj) {
                    this.zzb.zzc(b);
                    this.zzc.zzc(b);
                }
                this.zzd.zzc(b);
                this.zzi.zzd(j, b, j3);
                zzg2 = i2;
            } else {
                zzf(zzi2, zzg2, zze2);
                return;
            }
        }
    }

    public final void zze() {
    }
}
