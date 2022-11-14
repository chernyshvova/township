package com.applovin.impl.mediation.p012c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.applinks.FacebookAppLinkResolver;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.vungle.warren.BuildConfig;
import com.vungle.warren.VisionController;
import com.vungle.warren.VungleApiClient;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.c */
public class C0867c {

    /* renamed from: a */
    public static final TreeMap<String, String> f779a;

    /* renamed from: b */
    public static final List<String> f780b = new ArrayList(f779a.keySet());

    /* renamed from: c */
    public static JSONArray f781c;

    static {
        TreeMap<String, String> treeMap = new TreeMap<>();
        f779a = treeMap;
        treeMap.put("com.applovin.mediation.adapters.AdColonyMediationAdapter", "AdColony");
        f779a.put("com.applovin.mediation.adapters.AmazonMediationAdapter", VungleApiClient.MANUFACTURER_AMAZON);
        f779a.put("com.applovin.mediation.adapters.AmazonPublisherServicesMediationAdapter", "Amazon Publisher Services");
        f779a.put("com.applovin.mediation.adapters.AmazonAdMarketplaceMediationAdapter", "Amazon Publisher Services");
        f779a.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", "AppLovin");
        f779a.put("com.applovin.mediation.adapters.ByteDanceMediationAdapter", "Pangle");
        f779a.put("com.applovin.mediation.adapters.ChartboostMediationAdapter", "Chartboost");
        f779a.put("com.applovin.mediation.adapters.DataseatMediationAdapter", "Dataseat");
        f779a.put("com.applovin.mediation.adapters.FacebookMediationAdapter", "Facebook");
        f779a.put("com.applovin.mediation.adapters.GoogleMediationAdapter", "AdMob");
        f779a.put("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter", "Google Ad Manager");
        f779a.put("com.applovin.mediation.adapters.HyprMXMediationAdapter", "HyprMX");
        f779a.put("com.applovin.mediation.adapters.IMobileMediationAdapter", "i-mobile");
        f779a.put("com.applovin.mediation.adapters.InMobiMediationAdapter", "InMobi");
        f779a.put("com.applovin.mediation.adapters.InneractiveMediationAdapter", "Fyber");
        f779a.put("com.applovin.mediation.adapters.IronSourceMediationAdapter", "ironSource");
        f779a.put("com.applovin.mediation.adapters.LeadboltMediationAdapter", "Leadbolt");
        f779a.put("com.applovin.mediation.adapters.LineMediationAdapter", "LINE");
        f779a.put("com.applovin.mediation.adapters.MadvertiseMediationAdapter", "madvertise");
        f779a.put("com.applovin.mediation.adapters.MaioMediationAdapter", "Maio");
        f779a.put("com.applovin.mediation.adapters.MintegralMediationAdapter", "Mintegral");
        f779a.put("com.applovin.mediation.adapters.MoPubMediationAdapter", "MoPub");
        f779a.put("com.applovin.mediation.adapters.MyTargetMediationAdapter", "myTarget");
        f779a.put("com.applovin.mediation.adapters.NendMediationAdapter", "Nend");
        f779a.put("com.applovin.mediation.adapters.OguryMediationAdapter", "Ogury");
        f779a.put("com.applovin.mediation.adapters.OguryPresageMediationAdapter", "Ogury Presage");
        f779a.put("com.applovin.mediation.adapters.SayGamesMediationAdapter", "SayGames");
        f779a.put("com.applovin.mediation.adapters.SmaatoMediationAdapter", "Smaato");
        f779a.put("com.applovin.mediation.adapters.SnapMediationAdapter", "Snap");
        f779a.put("com.applovin.mediation.adapters.TapjoyMediationAdapter", "Tapjoy");
        f779a.put("com.applovin.mediation.adapters.TencentMediationAdapter", "Tencent");
        f779a.put("com.applovin.mediation.adapters.UnityAdsMediationAdapter", "Unity Ads");
        f779a.put("com.applovin.mediation.adapters.VerizonAdsMediationAdapter", "Verizon");
        f779a.put("com.applovin.mediation.adapters.VerveMediationAdapter", "Verve");
        f779a.put("com.applovin.mediation.adapters.VungleMediationAdapter", BuildConfig.OMSDK_PARTNER_NAME);
        f779a.put("com.applovin.mediation.adapters.YandexMediationAdapter", "Yandex");
    }

    /* renamed from: a */
    public static C1140o.C1142a m935a(MaxAdFormat maxAdFormat) {
        return maxAdFormat == MaxAdFormat.INTERSTITIAL ? C1140o.C1142a.MEDIATION_INTERSTITIAL : maxAdFormat == MaxAdFormat.REWARDED ? C1140o.C1142a.MEDIATION_INCENTIVIZED : maxAdFormat == MaxAdFormat.REWARDED_INTERSTITIAL ? C1140o.C1142a.MEDIATION_REWARDED_INTERSTITIAL : C1140o.C1142a.MEDIATION_BANNER;
    }

    /* renamed from: a */
    public static AppLovinSdkUtils.Size m936a(int i, MaxAdFormat maxAdFormat, Context context) {
        if (i < 0) {
            try {
                Display defaultDisplay = (context instanceof Activity ? ((Activity) context).getWindowManager() : (WindowManager) context.getSystemService(VisionController.WINDOW)).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                i = AppLovinSdkUtils.pxToDp(context, displayMetrics.widthPixels);
            } catch (Throwable th) {
                C1314v.m2659c("MediationUtils", "Failed to get adaptive banner size. Will fallback to using format specific ad view ad size.", th);
                return maxAdFormat.getSize();
            }
        }
        Class<?> cls = Class.forName("com.google.android.gms.ads.AdSize");
        Method method = cls.getMethod("getCurrentOrientationAnchoredAdaptiveBannerAdSize", new Class[]{Context.class, Integer.TYPE});
        Method method2 = cls.getMethod("getWidth", new Class[0]);
        Method method3 = cls.getMethod("getHeight", new Class[0]);
        Object invoke = method.invoke((Object) null, new Object[]{context, Integer.valueOf(i)});
        return new AppLovinSdkUtils.Size(((Integer) method2.invoke(invoke, new Object[0])).intValue(), ((Integer) method3.invoke(invoke, new Object[0])).intValue());
    }

    /* renamed from: a */
    public static JSONArray m937a(C1188m mVar) {
        JSONArray jSONArray;
        if (!((Boolean) mVar.mo10946a(C1084a.f1505P)).booleanValue() && (jSONArray = f781c) != null) {
            return jSONArray;
        }
        if (f781c != null) {
            m941b(mVar);
            return f781c;
        }
        f781c = new JSONArray();
        for (String next : f780b) {
            MaxAdapter b = m940b(next, mVar);
            if (b != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", f779a.get(next));
                    jSONObject.put(FacebookAppLinkResolver.APP_LINK_TARGET_CLASS_KEY, next);
                    jSONObject.put(FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION, b.getSdkVersion());
                    jSONObject.put("version", b.getAdapterVersion());
                } catch (Throwable unused) {
                }
                f781c.put(jSONObject);
            }
        }
        return f781c;
    }

    /* renamed from: a */
    public static JSONObject m938a(String str, C1188m mVar) {
        JSONArray a = m937a(mVar);
        for (int i = 0; i < a.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(a, i, (JSONObject) null);
            if (jSONObject != null && str.equals(JsonUtils.getString(jSONObject, FacebookAppLinkResolver.APP_LINK_TARGET_CLASS_KEY, (String) null))) {
                return jSONObject;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m939a(Object obj) {
        return (obj instanceof C1057e) && StringUtils.isValidString(((C1057e) obj).mo10563I());
    }

    /* renamed from: b */
    public static MaxAdapter m940b(String str, C1188m mVar) {
        Class<MaxAdapter> cls = MaxAdapter.class;
        if (TextUtils.isEmpty(str)) {
            mVar.mo10922B().mo11376e(AppLovinSdk.TAG, "Failed to create adapter instance. No class name provided");
            return null;
        }
        try {
            Class<?> cls2 = Class.forName(str);
            if (cls.isAssignableFrom(cls2)) {
                return (MaxAdapter) cls2.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{mVar.mo10944Y()});
            }
            C1314v B = mVar.mo10922B();
            B.mo11376e(AppLovinSdk.TAG, str + " error: not an instance of '" + cls.getName() + "'.");
            return null;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            C1314v B2 = mVar.mo10922B();
            B2.mo11373b(AppLovinSdk.TAG, "Failed to load: " + str, th);
        }
    }

    /* renamed from: b */
    public static void m941b(C1188m mVar) {
        MaxAdapter b;
        for (int i = 0; i < f781c.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(f781c, i, (JSONObject) null);
            String string = JsonUtils.getString(jSONObject, FacebookAppLinkResolver.APP_LINK_TARGET_CLASS_KEY, "");
            if (!StringUtils.isValidString(JsonUtils.getString(jSONObject, FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION, "")) && (b = m940b(string, mVar)) != null) {
                JsonUtils.putString(jSONObject, FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION, b.getSdkVersion());
            }
        }
    }

    /* renamed from: b */
    public static boolean m942b(Object obj) {
        return (obj instanceof C0801a) && "APPLOVIN".equals(((C0801a) obj).mo9899Q());
    }
}
