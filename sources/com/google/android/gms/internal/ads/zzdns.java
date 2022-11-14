package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.zzb;
import com.swrve.sdk.SwrveImp;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdns {
    public final zzdsf zza;
    public final zzdqu zzb;
    public ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdns(zzdsf zzdsf, zzdqu zzdqu) {
        this.zza = zzdsf;
        this.zzb = zzdqu;
    }

    public static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzbev.zza();
        return zzcgl.zzs(context, i);
    }

    public final View zza(@NonNull View view, @NonNull WindowManager windowManager) throws zzcnc {
        zzcmr zza2 = this.zza.zza(zzbdp.zzb(), (zzeye) null, (zzeyh) null);
        View view2 = (View) zza2;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zza2.zzab("/sendMessageToSdk", new zzdnm(this));
        zza2.zzab("/hideValidatorOverlay", new zzdnn(this, windowManager, view));
        zza2.zzab("/open", new zzbqd((zzb) null, (zzbyk) null, (zzedb) null, (zzduu) null, (zzfdh) null));
        this.zzb.zzh(new WeakReference(zza2), "/loadNativeAdPolicyViolations", new zzdno(this, view, windowManager));
        this.zzb.zzh(new WeakReference(zza2), "/showValidatorOverlay", zzdnp.zza);
        return (View) zza2;
    }

    public final /* synthetic */ void zzb(View view, WindowManager windowManager, zzcmr zzcmr, Map map) {
        int i;
        zzcmr.zzR().zzw(new zzdnr(this, map));
        if (map != null) {
            Context context = view.getContext();
            int zzf = zzf(context, (String) map.get("validator_width"), ((Integer) zzbex.zzc().zzb(zzbjn.zzfw)).intValue());
            int zzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) zzbex.zzc().zzb(zzbjn.zzfx)).intValue());
            int zzf3 = zzf(context, (String) map.get("validator_x"), 0);
            int zzf4 = zzf(context, (String) map.get("validator_y"), 0);
            zzcmr.zzaf(zzcoh.zzc(zzf, zzf2));
            try {
                zzcmr.zzG().getSettings().setUseWideViewPort(((Boolean) zzbex.zzc().zzb(zzbjn.zzfy)).booleanValue());
                zzcmr.zzG().getSettings().setLoadWithOverviewMode(((Boolean) zzbex.zzc().zzb(zzbjn.zzfz)).booleanValue());
            } catch (NullPointerException unused) {
            }
            WindowManager.LayoutParams zzj = zzby.zzj();
            zzj.x = zzf3;
            zzj.y = zzf4;
            windowManager.updateViewLayout(zzcmr.zzH(), zzj);
            String str = (String) map.get("orientation");
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(str) || SwrveImp.CAMPAIGN_RESPONSE_VERSION.equals(str)) {
                    i = rect.bottom;
                } else {
                    i = rect.top;
                }
                this.zzc = new zzdnq(view, zzcmr, str, zzj, i - zzf4, windowManager);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.zzc);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzcmr.loadUrl(str2);
            }
        }
    }

    public final /* synthetic */ void zzc(Map map, boolean z) {
        HashMap outline28 = GeneratedOutlineSupport.outline28("messageType", "validatorHtmlLoaded");
        outline28.put("id", (String) map.get("id"));
        this.zzb.zzf("sendMessageToNativeJs", outline28);
    }

    public final /* synthetic */ void zzd(WindowManager windowManager, View view, zzcmr zzcmr, Map map) {
        zzcgs.zzd("Hide native ad policy validator overlay.");
        zzcmr.zzH().setVisibility(8);
        if (zzcmr.zzH().getWindowToken() != null) {
            windowManager.removeView(zzcmr.zzH());
        }
        zzcmr.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzc);
        }
    }

    public final /* synthetic */ void zze(zzcmr zzcmr, Map map) {
        this.zzb.zzf("sendMessageToNativeJs", map);
    }
}
