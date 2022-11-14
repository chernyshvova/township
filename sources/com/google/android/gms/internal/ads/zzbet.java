package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.p033h5.OnH5AdsEventListener;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbet {
    public final zzbdj zza;
    public final zzbdh zzb;
    public final zzbia zzc;
    public final zzboh zzd;
    public final zzcdf zze;
    public final zzbzo zzf;
    public final zzboi zzg;
    public zzcau zzh;

    public zzbet(zzbdj zzbdj, zzbdh zzbdh, zzbia zzbia, zzboh zzboh, zzcdf zzcdf, zzbzo zzbzo, zzboi zzboi) {
        this.zza = zzbdj;
        this.zzb = zzbdh;
        this.zzc = zzbia;
        this.zzd = zzboh;
        this.zze = zzcdf;
        this.zzf = zzbzo;
        this.zzg = zzboi;
    }

    public static /* synthetic */ void zzl(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzbev.zza().zze(context, zzbev.zzd().zza, "gmob-apps", bundle, true);
    }

    public final zzbfr zza(Context context, zzbdp zzbdp, String str, zzbvh zzbvh) {
        return (zzbfr) new zzbeh(this, context, zzbdp, str, zzbvh).zzd(context, false);
    }

    public final zzbfr zzb(Context context, zzbdp zzbdp, String str, zzbvh zzbvh) {
        return (zzbfr) new zzbej(this, context, zzbdp, str, zzbvh).zzd(context, false);
    }

    public final zzbfn zzc(Context context, String str, zzbvh zzbvh) {
        return (zzbfn) new zzbel(this, context, str, zzbvh).zzd(context, false);
    }

    public final zzbmm zzd(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbmm) new zzbep(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzbms zze(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzbms) new zzber(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzcct zzf(Context context, String str, zzbvh zzbvh) {
        return (zzcct) new zzbes(this, context, str, zzbvh).zzd(context, false);
    }

    @Nullable
    public final zzbzr zzg(Activity activity) {
        zzbdz zzbdz = new zzbdz(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzcgs.zzf("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzbzr) zzbdz.zzd(activity, z);
    }

    @Nullable
    public final zzcfo zzh(Context context, zzbvh zzbvh) {
        return (zzcfo) new zzbeb(this, context, zzbvh).zzd(context, false);
    }

    @Nullable
    public final zzbzf zzi(Context context, zzbvh zzbvh) {
        return (zzbzf) new zzbed(this, context, zzbvh).zzd(context, false);
    }

    @RequiresApi(api = 21)
    public final zzbqq zzj(Context context, zzbvh zzbvh, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbqq) new zzbef(this, context, zzbvh, onH5AdsEventListener).zzd(context, false);
    }
}
