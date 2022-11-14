package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzab;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdp;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzbga;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbmm;
import com.google.android.gms.internal.ads.zzbms;
import com.google.android.gms.internal.ads.zzbqn;
import com.google.android.gms.internal.ads.zzbqq;
import com.google.android.gms.internal.ads.zzbvh;
import com.google.android.gms.internal.ads.zzbzf;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzccd;
import com.google.android.gms.internal.ads.zzcct;
import com.google.android.gms.internal.ads.zzcfo;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzcop;
import com.google.android.gms.internal.ads.zzdmt;
import com.google.android.gms.internal.ads.zzdmv;
import com.google.android.gms.internal.ads.zzdwc;
import com.google.android.gms.internal.ads.zzejv;
import com.google.android.gms.internal.ads.zzeti;
import com.google.android.gms.internal.ads.zzetj;
import com.google.android.gms.internal.ads.zzeut;
import com.google.android.gms.internal.ads.zzewl;
import com.google.android.gms.internal.ads.zzexx;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class ClientApi extends zzbga {
    public final zzbfr zzb(IObjectWrapper iObjectWrapper, zzbdp zzbdp, String str, zzbvh zzbvh, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzeut zzl = zzcop.zza(context, zzbvh, i).zzl();
        zzl.zzd(context);
        zzl.zzb(zzbdp);
        zzl.zzc(str);
        return zzl.zza().zza();
    }

    public final zzbfr zzc(IObjectWrapper iObjectWrapper, zzbdp zzbdp, String str, zzbvh zzbvh, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzewl zzq = zzcop.zza(context, zzbvh, i).zzq();
        zzq.zzd(context);
        zzq.zzb(zzbdp);
        zzq.zzc(str);
        return zzq.zza().zza();
    }

    public final zzbfn zzd(IObjectWrapper iObjectWrapper, String str, zzbvh zzbvh, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzejv(zzcop.zza(context, zzbvh, i), context, str);
    }

    public final zzbmm zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdmv((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 212104000);
    }

    public final zzccd zzf(IObjectWrapper iObjectWrapper, zzbvh zzbvh, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzexx zzt = zzcop.zza(context, zzbvh, i).zzt();
        zzt.zzc(context);
        return zzt.zza().zza();
    }

    public final zzbzr zzg(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (zza == null) {
            return new zzs(activity);
        }
        int i = zza.zzk;
        if (i == 1) {
            return new zzr(activity);
        }
        if (i == 2) {
            return new zzaa(activity);
        }
        if (i == 3) {
            return new zzab(activity);
        }
        if (i == 4) {
            return new zzu(activity, zza);
        }
        if (i != 5) {
            return new zzs(activity);
        }
        return new zzy(activity);
    }

    public final zzbgi zzh(IObjectWrapper iObjectWrapper, int i) {
        return zzcop.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), i).zzj();
    }

    public final zzbfr zzi(IObjectWrapper iObjectWrapper, zzbdp zzbdp, String str, int i) {
        return new zzr((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbdp, str, new zzcgy(212104000, i, true, false));
    }

    public final zzbms zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdmt((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzcct zzk(IObjectWrapper iObjectWrapper, String str, zzbvh zzbvh, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzexx zzt = zzcop.zza(context, zzbvh, i).zzt();
        zzt.zzc(context);
        zzt.zzb(str);
        return zzt.zza().zzb();
    }

    public final zzbfr zzl(IObjectWrapper iObjectWrapper, zzbdp zzbdp, String str, zzbvh zzbvh, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzeti zzo = zzcop.zza(context, zzbvh, i).zzo();
        zzo.zzb(str);
        zzo.zzc(context);
        zzetj zza = zzo.zza();
        if (i >= ((Integer) zzbex.zzc().zzb(zzbjn.zzdB)).intValue()) {
            return zza.zzb();
        }
        return zza.zza();
    }

    public final zzcfo zzm(IObjectWrapper iObjectWrapper, zzbvh zzbvh, int i) {
        return zzcop.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbvh, i).zzv();
    }

    public final zzbzf zzn(IObjectWrapper iObjectWrapper, zzbvh zzbvh, int i) {
        return zzcop.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbvh, i).zzx();
    }

    public final zzbqq zzo(IObjectWrapper iObjectWrapper, zzbvh zzbvh, int i, zzbqn zzbqn) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdwc zzC = zzcop.zza(context, zzbvh, i).zzC();
        zzC.zzc(context);
        zzC.zzb(zzbqn);
        return zzC.zza().zza();
    }
}
