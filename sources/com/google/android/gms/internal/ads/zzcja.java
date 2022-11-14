package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcja {
    public final Context zza;
    public final String zzb;
    public final zzcgy zzc;
    @Nullable
    public final zzbjz zzd;
    @Nullable
    public final zzbkc zze;
    public final zzbh zzf;
    public final long[] zzg;
    public final String[] zzh;
    public boolean zzi = false;
    public boolean zzj = false;
    public boolean zzk = false;
    public boolean zzl = false;
    public boolean zzm;
    public zzcig zzn;
    public boolean zzo;
    public boolean zzp;
    public long zzq = -1;

    public zzcja(Context context, zzcgy zzcgy, String str, @Nullable zzbkc zzbkc, @Nullable zzbjz zzbjz) {
        zzbg zzbg = new zzbg();
        zzbg zzbg2 = zzbg;
        zzbg2.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbg2.zza("1_5", 1.0d, 5.0d);
        zzbg2.zza("5_10", 5.0d, 10.0d);
        zzbg2.zza("10_20", 10.0d, 20.0d);
        zzbg2.zza("20_30", 20.0d, 30.0d);
        zzbg2.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzf = zzbg.zzb();
        this.zza = context;
        this.zzc = zzcgy;
        this.zzb = str;
        this.zze = zzbkc;
        this.zzd = zzbjz;
        String str2 = (String) zzbex.zzc().zzb(zzbjn.zzv);
        if (str2 == null) {
            this.zzh = new String[0];
            this.zzg = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        int length = split.length;
        this.zzh = new String[length];
        this.zzg = new long[length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzg[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzcgs.zzj("Unable to parse frame hash target time number.", e);
                this.zzg[i] = -1;
            }
        }
    }

    public final void zza(zzcig zzcig) {
        zzbju.zza(this.zze, this.zzd, "vpc2");
        this.zzi = true;
        this.zze.zzd("vpn", zzcig.zza());
        this.zzn = zzcig;
    }

    public final void zzb() {
        if (this.zzi && !this.zzj) {
            zzbju.zza(this.zze, this.zzd, "vfr2");
            this.zzj = true;
        }
    }

    public final void zzc() {
        String str;
        if (zzblm.zza.zze().booleanValue() && !this.zzo) {
            Bundle outline5 = GeneratedOutlineSupport.outline5("type", "native-player-metrics");
            outline5.putString("request", this.zzb);
            outline5.putString("player", this.zzn.zza());
            for (zzbf next : this.zzf.zzb()) {
                String valueOf = String.valueOf(next.zza);
                if (valueOf.length() != 0) {
                    str = "fps_c_".concat(valueOf);
                } else {
                    str = new String("fps_c_");
                }
                outline5.putString(str, Integer.toString(next.zze));
                String valueOf2 = String.valueOf(next.zza);
                outline5.putString(valueOf2.length() != 0 ? "fps_p_".concat(valueOf2) : new String("fps_p_"), Double.toString(next.zzd));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.zzg;
                if (i < jArr.length) {
                    String str2 = this.zzh[i];
                    if (str2 != null) {
                        String valueOf3 = String.valueOf(Long.valueOf(jArr[i]));
                        StringBuilder sb = new StringBuilder(valueOf3.length() + 3);
                        sb.append("fh_");
                        sb.append(valueOf3);
                        outline5.putString(sb.toString(), str2);
                    }
                    i++;
                } else {
                    zzs.zzc().zzj(this.zza, this.zzc.zza, "gmob-apps", outline5, true);
                    this.zzo = true;
                    return;
                }
            }
        }
    }

    public final void zzd(zzcig zzcig) {
        if (this.zzk && !this.zzl) {
            if (zze.zzc() && !this.zzl) {
                zze.zza("VideoMetricsMixin first frame");
            }
            zzbju.zza(this.zze, this.zzd, "vff2");
            this.zzl = true;
        }
        long nanoTime = zzs.zzj().nanoTime();
        if (this.zzm && this.zzp && this.zzq != -1) {
            long nanos = TimeUnit.SECONDS.toNanos(1);
            long j = this.zzq;
            zzbh zzbh = this.zzf;
            double d = (double) nanos;
            double d2 = (double) (nanoTime - j);
            Double.isNaN(d);
            Double.isNaN(d2);
            zzbh.zza(d / d2);
        }
        this.zzp = this.zzm;
        this.zzq = nanoTime;
        long longValue = ((Long) zzbex.zzc().zzb(zzbjn.zzw)).longValue();
        long zzh2 = (long) zzcig.zzh();
        int i = 0;
        while (true) {
            String[] strArr = this.zzh;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] == null && longValue > Math.abs(zzh2 - this.zzg[i])) {
                String[] strArr2 = this.zzh;
                int i2 = 8;
                Bitmap bitmap = zzcig.getBitmap(8, 8);
                long j2 = 63;
                long j3 = 0;
                int i3 = 0;
                while (i3 < i2) {
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j3 |= (Color.green(pixel) + (Color.red(pixel) + Color.blue(pixel)) > 128 ? 1 : 0) << ((int) j2);
                        i4++;
                        j2--;
                        i2 = 8;
                    }
                    i3++;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", new Object[]{Long.valueOf(j3)});
                return;
            }
            zzcig zzcig2 = zzcig;
            i++;
        }
    }

    public final void zze() {
        this.zzm = true;
        if (this.zzj && !this.zzk) {
            zzbju.zza(this.zze, this.zzd, "vfp2");
            this.zzk = true;
        }
    }

    public final void zzf() {
        this.zzm = false;
    }
}
