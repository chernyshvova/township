package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzs;
import com.helpshift.analytics.AnalyticsEventKey;
import com.vungle.warren.analytics.AnalyticsEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdoz {
    public final Context zza;
    public final zzdoi zzb;
    public final zzfb zzc;
    public final zzcgy zzd;
    public final zza zze;
    public final zzayx zzf;
    public final Executor zzg;
    public final zzblw zzh;
    public final zzdpr zzi;
    public final zzdsf zzj;
    public final ScheduledExecutorService zzk;
    public final zzdra zzl;
    public final zzduu zzm;
    public final zzfdh zzn;
    public final zzfdz zzo;
    public final zzedb zzp;

    public zzdoz(Context context, zzdoi zzdoi, zzfb zzfb, zzcgy zzcgy, zza zza2, zzayx zzayx, Executor executor, zzeyw zzeyw, zzdpr zzdpr, zzdsf zzdsf, ScheduledExecutorService scheduledExecutorService, zzduu zzduu, zzfdh zzfdh, zzfdz zzfdz, zzedb zzedb, zzdra zzdra) {
        this.zza = context;
        this.zzb = zzdoi;
        this.zzc = zzfb;
        this.zzd = zzcgy;
        this.zze = zza2;
        this.zzf = zzayx;
        this.zzg = executor;
        this.zzh = zzeyw.zzi;
        this.zzi = zzdpr;
        this.zzj = zzdsf;
        this.zzk = scheduledExecutorService;
        this.zzm = zzduu;
        this.zzn = zzfdh;
        this.zzo = zzfdz;
        this.zzp = zzedb;
        this.zzl = zzdra;
    }

    @Nullable
    public static final zzbhx zzi(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject(AnalyticsEvent.C1956Ad.mute);
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(optJSONObject);
    }

    public static final List<zzbhx> zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(AnalyticsEvent.C1956Ad.mute);
        if (optJSONObject == null) {
            return zzfml.zzi();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzfml.zzi();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzbhx zzr = zzr(optJSONArray.optJSONObject(i));
            if (zzr != null) {
                arrayList.add(zzr);
            }
        }
        return zzfml.zzp(arrayList);
    }

    private final zzfqn<List<zzbls>> zzk(@Nullable JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzfqe.zza(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zzl(jSONArray.optJSONObject(i), z));
        }
        return zzfqe.zzj(zzfqe.zzk(arrayList), zzdoo.zza, this.zzg);
    }

    private final zzfqn<zzbls> zzl(@Nullable JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzfqe.zza(null);
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzfqe.zza(null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzfqe.zza(new zzbls((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zzp(jSONObject.optBoolean("require"), zzfqe.zzj(this.zzb.zza(optString, optDouble, optBoolean), new zzdoq(optString, optDouble, optInt, optInt2), this.zzg), (Object) null);
    }

    public static Integer zzm(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    private final zzfqn<zzcmr> zzn(JSONObject jSONObject, zzeye zzeye, zzeyh zzeyh) {
        zzfqn<zzcmr> zzb2 = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString("html"), zzeye, zzeyh, zzq(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzfqe.zzi(zzb2, new zzdov(zzb2), zzche.zzf);
    }

    public static <T> zzfqn<T> zzo(zzfqn<T> zzfqn, T t) {
        return zzfqe.zzg(zzfqn, Exception.class, new zzdow((Object) null), zzche.zzf);
    }

    public static <T> zzfqn<T> zzp(boolean z, zzfqn<T> zzfqn, T t) {
        if (z) {
            return zzfqe.zzi(zzfqn, new zzdox(zzfqn), zzche.zzf);
        }
        return zzo(zzfqn, (Object) null);
    }

    private final zzbdp zzq(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return zzbdp.zzb();
            }
            i = 0;
        }
        return new zzbdp(this.zza, new AdSize(i, i2));
    }

    @Nullable
    public static final zzbhx zzr(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzbhx(optString, optString2);
    }

    public final zzfqn<zzbls> zza(JSONObject jSONObject, String str) {
        return zzl(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final zzfqn<List<zzbls>> zzb(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        zzblw zzblw = this.zzh;
        return zzk(optJSONArray, zzblw.zzb, zzblw.zzd);
    }

    public final zzfqn<zzcmr> zzc(JSONObject jSONObject, String str, zzeye zzeye, zzeyh zzeyh) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgz)).booleanValue()) {
            return zzfqe.zza(null);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzfqe.zza(null);
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return zzfqe.zza(null);
        }
        String optString = optJSONObject.optString("base_url");
        String optString2 = optJSONObject.optString("html");
        zzbdp zzq = zzq(optJSONObject.optInt("width", 0), optJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(optString2)) {
            return zzfqe.zza(null);
        }
        zzfqn zzi2 = zzfqe.zzi(zzfqe.zza(null), new zzdor(this, zzq, zzeye, zzeyh, optString, optString2), zzche.zze);
        return zzfqe.zzi(zzi2, new zzdos(zzi2), zzche.zzf);
    }

    public final zzfqn<zzblp> zzd(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzfqe.zza(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zzp(optJSONObject.optBoolean("require"), zzfqe.zzj(zzk(optJSONArray, false, true), new zzdot(this, optJSONObject), this.zzg), (Object) null);
    }

    public final zzfqn<zzcmr> zze(JSONObject jSONObject, zzeye zzeye, zzeyh zzeyh) {
        zzfqn<zzcmr> zzfqn;
        JSONObject zzh2 = zzbv.zzh(jSONObject, "html_containers", "instream");
        if (zzh2 != null) {
            return zzn(zzh2, zzeye, zzeyh);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject == null) {
            return zzfqe.zza(null);
        }
        String optString = optJSONObject.optString("vast_xml");
        boolean z = false;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgy)).booleanValue() && optJSONObject.has("html")) {
            z = true;
        }
        if (TextUtils.isEmpty(optString)) {
            if (!z) {
                zzcgs.zzi("Required field 'vast_xml' or 'html' is missing");
                return zzfqe.zza(null);
            }
        } else if (!z) {
            zzfqn = this.zzi.zza(optJSONObject);
            return zzo(zzfqe.zzh(zzfqn, (long) ((Integer) zzbex.zzc().zzb(zzbjn.zzcf)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
        }
        zzfqn = zzn(optJSONObject, zzeye, zzeyh);
        return zzo(zzfqe.zzh(zzfqn, (long) ((Integer) zzbex.zzc().zzb(zzbjn.zzcf)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
    }

    public final /* synthetic */ zzfqn zzf(String str, Object obj) throws Exception {
        zzs.zzd();
        zzcmr zza2 = zzcnd.zza(this.zza, zzcoh.zzb(), "native-omid", false, false, this.zzc, (zzbkm) null, this.zzd, (zzbkc) null, (zzl) null, this.zze, this.zzf, (zzeye) null, (zzeyh) null);
        zzchi zza3 = zzchi.zza(zza2);
        zza2.zzR().zzw(new zzdoy(zza3));
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdw)).booleanValue()) {
            zza2.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
        } else {
            zza2.loadData(str, "text/html", "UTF-8");
        }
        return zza3;
    }

    public final /* synthetic */ zzblp zzg(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzm2 = zzm(jSONObject, "bg_color");
        Integer zzm3 = zzm(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzblp(optString, list, zzm2, zzm3, num, optInt3 + optInt2, this.zzh.zze, optBoolean);
    }

    public final /* synthetic */ zzfqn zzh(zzbdp zzbdp, zzeye zzeye, zzeyh zzeyh, String str, String str2, Object obj) throws Exception {
        zzcmr zza2 = this.zzj.zza(zzbdp, zzeye, zzeyh);
        zzchi zza3 = zzchi.zza(zza2);
        zzdqx zza4 = this.zzl.zza();
        zzcof zzR = zza2.zzR();
        zzb zzb2 = new zzb(this.zza, (zzcdz) null, (zzcay) null);
        zzedb zzedb = this.zzp;
        zzedb zzedb2 = zzedb;
        zzR.zzK(zza4, zza4, zza4, zza4, zza4, false, (zzbpv) null, zzb2, (zzbyr) null, (zzcdz) null, zzedb2, this.zzo, this.zzm, this.zzn, (zzbpt) null);
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzce)).booleanValue()) {
            zza2.zzab("/getNativeAdViewSignals", zzbpr.zzt);
        }
        zza2.zzab("/getNativeClickMeta", zzbpr.zzu);
        zza2.zzR().zzw(new zzdop(zza3));
        zza2.zzat(str, str2, (String) null);
        return zza3;
    }
}
