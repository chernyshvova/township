package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.vungle.warren.VisionController;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdla implements zzdmi {
    public final Context zza;
    public final zzdml zzb;
    public final JSONObject zzc;
    public final zzdqu zzd;
    public final zzdma zze;
    public final zzfb zzf;
    public final zzdbv zzg;
    public final zzdbb zzh;
    public final zzeye zzi;
    public final zzcgy zzj;
    public final zzeyw zzk;
    public final zzcts zzl;
    public final zzdnc zzm;
    public final Clock zzn;
    public final zzdib zzo;
    public final zzfdz zzp;
    public boolean zzq = false;
    public boolean zzr;
    public boolean zzs = false;
    public boolean zzt = false;
    public Point zzu = new Point();
    public Point zzv = new Point();
    public long zzw = 0;
    public long zzx = 0;
    public zzbgm zzy;

    public zzdla(Context context, zzdml zzdml, JSONObject jSONObject, zzdqu zzdqu, zzdma zzdma, zzfb zzfb, zzdbv zzdbv, zzdbb zzdbb, zzeye zzeye, zzcgy zzcgy, zzeyw zzeyw, zzcts zzcts, zzdnc zzdnc, Clock clock, zzdib zzdib, zzfdz zzfdz) {
        this.zza = context;
        this.zzb = zzdml;
        this.zzc = jSONObject;
        this.zzd = zzdqu;
        this.zze = zzdma;
        this.zzf = zzfb;
        this.zzg = zzdbv;
        this.zzh = zzdbb;
        this.zzi = zzeye;
        this.zzj = zzcgy;
        this.zzk = zzeyw;
        this.zzl = zzcts;
        this.zzm = zzdnc;
        this.zzn = clock;
        this.zzo = zzdib;
        this.zzp = zzfdz;
    }

    private final boolean zzA(String str) {
        JSONObject optJSONObject = this.zzc.optJSONObject("allow_pub_event_reporting");
        if (optJSONObject == null || !optJSONObject.optBoolean(str, false)) {
            return false;
        }
        return true;
    }

    @Nullable
    private final String zzB(@Nullable View view, @Nullable Map<String, WeakReference<View>> map) {
        if (!(map == null || view == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (view.equals((View) ((WeakReference) next.getValue()).get())) {
                    return (String) next.getKey();
                }
            }
        }
        int zzv2 = this.zze.zzv();
        if (zzv2 == 1) {
            return "1099";
        }
        if (zzv2 == 2) {
            return "2099";
        }
        if (zzv2 != 6) {
            return null;
        }
        return "3099";
    }

    private final boolean zzC() {
        return this.zzc.optBoolean("allow_custom_click_gesture", false);
    }

    private final boolean zzD(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, boolean z) {
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzc);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbW)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            Context context = this.zza;
            JSONObject jSONObject7 = new JSONObject();
            zzs.zzc();
            DisplayMetrics zzy2 = zzr.zzy((WindowManager) context.getSystemService(VisionController.WINDOW));
            try {
                jSONObject7.put("width", zzbev.zza().zza(context, zzy2.widthPixels));
                jSONObject7.put("height", zzbev.zza().zza(context, zzy2.heightPixels));
            } catch (JSONException unused) {
                jSONObject7 = null;
            }
            jSONObject6.put("screen", jSONObject7);
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfO)).booleanValue()) {
                this.zzd.zzd("/clickRecorded", new zzdky(this, (zzdkw) null));
            } else {
                this.zzd.zzd("/logScionEvent", new zzdkx(this, (zzdkw) null));
            }
            this.zzd.zzd("/nativeImpression", new zzdkz(this, (zzdkw) null));
            zzchh.zza(this.zzd.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.zzq) {
                return true;
            }
            this.zzq = zzs.zzm().zzg(this.zza, this.zzj.zza, this.zzi.zzC.toString(), this.zzk.zzf);
            return true;
        } catch (JSONException e) {
            zzcgs.zzg("Unable to create impression JSON.", e);
            return false;
        }
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzu = new Point();
        this.zzv = new Point();
        if (!this.zzr) {
            this.zzo.zza(view);
            this.zzr = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzl.zzj(this);
        boolean zza2 = zzby.zza(this.zzj.zzc);
        if (map != null) {
            for (Map.Entry<String, WeakReference<View>> value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    if (zza2) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Map.Entry<String, WeakReference<View>> value2 : map2.entrySet()) {
                View view3 = (View) ((WeakReference) value2.getValue()).get();
                if (view3 != null) {
                    if (zza2) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    public final void zzb(@Nullable View view, @Nullable Map<String, WeakReference<View>> map) {
        this.zzu = new Point();
        this.zzv = new Point();
        if (view != null) {
            this.zzo.zzb(view);
        }
        this.zzr = false;
    }

    public final void zzc(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        View view3 = view2;
        Map<String, WeakReference<View>> map3 = map;
        JSONObject zze2 = zzby.zze(this.zza, map, map2, view2);
        JSONObject zzb2 = zzby.zzb(this.zza, view2);
        JSONObject zzc2 = zzby.zzc(view2);
        JSONObject zzd2 = zzby.zzd(this.zza, view2);
        View view4 = view;
        String zzB = zzB(view, map);
        zzi(true == ((Boolean) zzbex.zzc().zzb(zzbjn.zzbX)).booleanValue() ? view3 : view4, zzb2, zze2, zzc2, zzd2, zzB, zzby.zzf(zzB, this.zza, this.zzv, this.zzu), (JSONObject) null, z, false);
    }

    public final void zzd(String str) {
        zzi((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, (JSONObject) null, (JSONObject) null, false, false);
    }

    public final void zze(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzcgs.zzd("Click data is null. No click is reported.");
        } else if (!zzA("click_reporting")) {
            zzcgs.zzf("The ad slot cannot handle external click events. You must be part of the allow list to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zzi((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, bundle2 != null ? bundle2.getString("asset_id") : null, (JSONObject) null, zzs.zzc().zzg(bundle, (JSONObject) null), false, false);
        }
    }

    public final void zzf(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        View view2 = view;
        Map<String, WeakReference<View>> map3 = map;
        if (!this.zzt) {
            zzcgs.zzd("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!zzC()) {
            zzcgs.zzd("Custom click reporting failed. Ad unit id not in the allow list.");
        } else {
            Map<String, WeakReference<View>> map4 = map2;
            JSONObject zze2 = zzby.zze(this.zza, map, map2, view);
            JSONObject zzb2 = zzby.zzb(this.zza, view);
            JSONObject zzc2 = zzby.zzc(view);
            JSONObject zzd2 = zzby.zzd(this.zza, view);
            String zzB = zzB((View) null, map);
            zzi(view, zzb2, zze2, zzc2, zzd2, zzB, zzby.zzf(zzB, this.zza, this.zzv, this.zzu), (JSONObject) null, z, true);
        }
    }

    public final void zzg() {
        this.zzt = true;
    }

    public final boolean zzh() {
        return zzC();
    }

    @VisibleForTesting
    public final void zzi(@Nullable View view, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, @Nullable JSONObject jSONObject6, boolean z, boolean z2) {
        String str2;
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzc);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            boolean z3 = false;
            jSONObject7.put("has_custom_click_handler", this.zzb.zzg(this.zze.zzQ()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zze.zzv());
            jSONObject8.put("view_aware_api_used", z);
            zzblw zzblw = this.zzk.zzi;
            jSONObject8.put("custom_mute_requested", zzblw != null && zzblw.zzg);
            jSONObject8.put("custom_mute_enabled", !this.zze.zzC().isEmpty() && this.zze.zzD() != null);
            if (this.zzm.zzb() != null && this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzn.currentTimeMillis());
            if (this.zzt && zzC()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            if (this.zzb.zzg(this.zze.zzQ()) != null) {
                z3 = true;
            }
            jSONObject8.put("has_custom_click_handler", z3);
            try {
                JSONObject optJSONObject = this.zzc.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                str2 = this.zzf.zzb().zzg(this.zza, optJSONObject.optString("click_string"), view);
            } catch (Exception e) {
                zzcgs.zzg("Exception obtaining click signals", e);
                str2 = null;
            }
            jSONObject8.put("click_signals", str2);
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzcS)).booleanValue()) {
                jSONObject8.put("open_chrome_custom_tab", true);
            }
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfS)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("try_fallback_for_deep_link", true);
            }
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfT)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("in_app_link_handling_for_android_11_enabled", true);
            }
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzn.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzw);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzx);
            jSONObject7.put("touch_signal", jSONObject9);
            zzchh.zza(this.zzd.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e2) {
            zzcgs.zzg("Unable to create click JSON.", e2);
        }
    }

    public final void zzj(@Nullable View view, MotionEvent motionEvent, @Nullable View view2) {
        this.zzu = zzby.zzh(motionEvent, view2);
        long currentTimeMillis = this.zzn.currentTimeMillis();
        this.zzx = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzw = currentTimeMillis;
            this.zzv = this.zzu;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        Point point = this.zzu;
        obtain.setLocation((float) point.x, (float) point.y);
        this.zzf.zzd(obtain);
        obtain.recycle();
    }

    public final void zzk(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzcgs.zzd("Touch event data is null. No touch event is reported.");
        } else if (!zzA("touch_reporting")) {
            zzcgs.zzf("The ad slot cannot handle external touch events. You must be in the allow list to be able to report your touch events.");
        } else {
            float f = bundle.getFloat("x");
            float f2 = bundle.getFloat("y");
            this.zzf.zzb().zze((int) f, (int) f2, bundle.getInt("duration_ms"));
        }
    }

    @Nullable
    public final JSONObject zzl(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        JSONObject zze2 = zzby.zze(this.zza, map, map2, view);
        JSONObject zzb2 = zzby.zzb(this.zza, view);
        JSONObject zzc2 = zzby.zzc(view);
        JSONObject zzd2 = zzby.zzd(this.zza, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", zze2);
            jSONObject.put("ad_view_signal", zzb2);
            jSONObject.put("scroll_view_signal", zzc2);
            jSONObject.put("lock_screen_signal", zzd2);
            return jSONObject;
        } catch (JSONException e) {
            zzcgs.zzg("Unable to create native ad view signals JSON.", e);
            return null;
        }
    }

    @Nullable
    public final JSONObject zzm(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        JSONObject zzl2 = zzl(view, map, map2);
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.zzt && zzC()) {
                jSONObject.put("custom_click_gesture_eligible", true);
            }
            if (zzl2 != null) {
                jSONObject.put("nas", zzl2);
            }
        } catch (JSONException e) {
            zzcgs.zzg("Unable to create native click meta data JSON.", e);
        }
        return jSONObject;
    }

    public final void zzn() {
        zzD((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, (JSONObject) null, false);
    }

    public final void zzo(View view) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzcgs.zzi("setClickConfirmingView: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzdnc zzdnc = this.zzm;
        if (view != null) {
            view.setOnClickListener(zzdnc);
            view.setClickable(true);
            zzdnc.zzc = new WeakReference<>(view);
        }
    }

    public final void zzp(zzboc zzboc) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzcgs.zzi("setUnconfirmedClickListener: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzm.zza(zzboc);
        }
    }

    public final void zzq() {
        if (this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzm.zzc();
        }
    }

    public final void zzr(@Nullable zzbgq zzbgq) {
        try {
            if (!this.zzs) {
                if (zzbgq == null) {
                    if (this.zze.zzD() != null) {
                        this.zzs = true;
                        this.zzp.zzb(this.zze.zzD().zzf());
                        zzt();
                        return;
                    }
                }
                this.zzs = true;
                this.zzp.zzb(zzbgq.zzf());
                zzt();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzs(zzbgm zzbgm) {
        this.zzy = zzbgm;
    }

    public final void zzt() {
        try {
            zzbgm zzbgm = this.zzy;
            if (zzbgm != null) {
                zzbgm.zze();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzu(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        String str;
        JSONObject zze2 = zzby.zze(this.zza, map, map2, view);
        JSONObject zzb2 = zzby.zzb(this.zza, view);
        JSONObject zzc2 = zzby.zzc(view);
        JSONObject zzd2 = zzby.zzd(this.zza, view);
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbW)).booleanValue()) {
            try {
                str = this.zzf.zzb().zzi(this.zza, view, (Activity) null);
            } catch (Exception unused) {
                zzcgs.zzf("Exception getting data.");
            }
            zzD(zzb2, zze2, zzc2, zzd2, str, (JSONObject) null, zzby.zzi(this.zza, this.zzi));
        }
        str = null;
        zzD(zzb2, zze2, zzc2, zzd2, str, (JSONObject) null, zzby.zzi(this.zza, this.zzi));
    }

    public final void zzv() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzc);
            zzchh.zza(this.zzd.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzcgs.zzg("", e);
        }
    }

    public final boolean zzw(Bundle bundle) {
        if (!zzA("impression_reporting")) {
            zzcgs.zzf("The ad slot cannot handle external impression events. You must be in the allow list to be able to report your impression events.");
            return false;
        }
        return zzD((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, zzs.zzc().zzg(bundle, (JSONObject) null), false);
    }

    public final void zzx() {
        this.zzd.zzb();
    }
}
