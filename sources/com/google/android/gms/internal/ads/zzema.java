package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.facebook.internal.FetchedAppSettings;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzema implements zzeqp<zzemb> {
    public final zzeqp<zzequ> zza;
    public final zzeyw zzb;
    public final Context zzc;
    public final zzcgd zzd;

    public zzema(zzenl<zzequ> zzenl, zzeyw zzeyw, Context context, zzcgd zzcgd) {
        this.zza = zzenl;
        this.zzb = zzeyw;
        this.zzc = context;
        this.zzd = zzcgd;
    }

    public final zzfqn<zzemb> zza() {
        return zzfqe.zzj(this.zza.zza(), new zzelz(this), zzche.zzf);
    }

    public final /* synthetic */ zzemb zzb(zzequ zzequ) {
        boolean z;
        String str;
        int i;
        int i2;
        float f;
        String str2;
        int i3;
        DisplayMetrics displayMetrics;
        zzbdp zzbdp = this.zzb.zze;
        zzbdp[] zzbdpArr = zzbdp.zzg;
        if (zzbdpArr != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzbdp zzbdp2 : zzbdpArr) {
                boolean z4 = zzbdp2.zzi;
                if (!z4 && !z2) {
                    str = zzbdp2.zza;
                    z2 = true;
                }
                if (z4) {
                    if (!z3) {
                        z3 = true;
                        z = true;
                    } else {
                        z3 = true;
                    }
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzbdp.zza;
            z = zzbdp.zzi;
        }
        Resources resources = this.zzc.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i2 = 0;
            i = 0;
        } else {
            float f2 = displayMetrics.density;
            int i4 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
            str2 = this.zzd.zzl().zzz();
            i2 = i4;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        zzbdp[] zzbdpArr2 = zzbdp.zzg;
        if (zzbdpArr2 != null) {
            boolean z5 = false;
            for (zzbdp zzbdp3 : zzbdpArr2) {
                if (zzbdp3.zzi) {
                    z5 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append(FetchedAppSettings.DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR);
                    }
                    int i5 = zzbdp3.zze;
                    if (i5 == -1) {
                        i5 = f != 0.0f ? (int) (((float) zzbdp3.zzf) / f) : -1;
                    }
                    sb.append(i5);
                    sb.append("x");
                    int i6 = zzbdp3.zzb;
                    if (i6 == -2) {
                        i6 = f != 0.0f ? (int) (((float) zzbdp3.zzc) / f) : -2;
                    }
                    sb.append(i6);
                }
            }
            if (z5) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, FetchedAppSettings.DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR);
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzemb(zzbdp, str, z, sb.toString(), f, i2, i, str2, this.zzb.zzp);
    }
}
