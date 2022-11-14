package com.applovin.impl.mediation.ads;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1231i;
import com.applovin.impl.sdk.utils.C1301k;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.mediation.ads.a */
public abstract class C0836a {
    @Nullable

    /* renamed from: a */
    public static C1188m f699a;
    public final MaxAdFormat adFormat;
    public MaxAdListener adListener = null;
    public final String adUnitId;
    @Nullable
    public String customPostbackData;
    public final C1231i.C1233a loadRequestBuilder;
    public final Map<String, Object> localExtraParameters = Collections.synchronizedMap(new HashMap());
    public final C1314v logger;
    @Nullable
    public MaxAdRevenueListener revenueListener = null;
    public final C1188m sdk;
    public final String tag;

    /* renamed from: com.applovin.impl.mediation.ads.a$a */
    public interface C0837a extends MaxAdListener, MaxAdRevenueListener {
    }

    public C0836a(String str, MaxAdFormat maxAdFormat, String str2, C1188m mVar) {
        this.adUnitId = str;
        this.adFormat = maxAdFormat;
        this.sdk = mVar;
        this.tag = str2;
        this.logger = mVar.mo10922B();
        this.loadRequestBuilder = new C1231i.C1233a();
    }

    public static void logApiCall(String str, String str2) {
        C1188m mVar = f699a;
        if (mVar != null) {
            mVar.mo10922B().mo11372b(str, str2);
            return;
        }
        for (AppLovinSdk appLovinSdk : AppLovinSdk.m2713a()) {
            C1188m mVar2 = appLovinSdk.coreSdk;
            if (!mVar2.mo10988e()) {
                mVar2.mo10922B().mo11372b(str, str2);
                f699a = mVar2;
            }
        }
    }

    /* renamed from: a */
    public void mo9986a(C0801a aVar) {
        C1301k kVar = new C1301k();
        kVar.mo11316a().mo11322a("MAX Ad").mo11319a(aVar).mo11316a();
        C1314v.m2660f(this.tag, kVar.toString());
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public void logApiCall(String str) {
        this.logger.mo11372b(this.tag, str);
    }

    public void setCustomPostbackData(@Nullable String str) {
        this.customPostbackData = str;
        this.loadRequestBuilder.mo11199a(str);
        if (str != null && str.length() > 8192) {
            String str2 = this.tag;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Provided custom postback data parameter longer than supported (");
            outline24.append(str.length());
            outline24.append(" bytes, ");
            outline24.append(8192);
            outline24.append(" maximum)");
            C1314v.m2662h(str2, outline24.toString());
        }
    }

    public void setExtraParameter(String str, String str2) {
        if (str != null) {
            if (this.adFormat.isAdViewAd() && "ad_refresh_seconds".equals(str) && StringUtils.isValidString(str2)) {
                int parseInt = Integer.parseInt(str2);
                if (((long) parseInt) > TimeUnit.MINUTES.toSeconds(2)) {
                    String str3 = this.tag;
                    C1314v.m2663i(str3, "Attempting to set extra parameter \"ad_refresh_seconds\" to over 2 minutes (" + parseInt + "s) - this will be ignored");
                }
            }
            this.loadRequestBuilder.mo11200a(str, str2);
            return;
        }
        throw new IllegalArgumentException("No key specified");
    }

    public void setListener(MaxAdListener maxAdListener) {
        C1314v vVar = this.logger;
        String str = this.tag;
        vVar.mo11372b(str, "Setting listener: " + maxAdListener);
        this.adListener = maxAdListener;
    }

    public void setLocalExtraParameter(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        } else if (obj instanceof Activity) {
            this.logger.mo11376e(this.tag, "Ignoring setting local extra parameter to Activity instance - please pass a WeakReference of it instead!");
        } else {
            if ("amazon_ad_response".equals(str) || "amazon_ad_error".equals(str)) {
                setExtraParameter("is_amazon_integration", Boolean.toString(true));
            }
            this.localExtraParameters.put(str, obj);
        }
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        C1314v vVar = this.logger;
        String str = this.tag;
        vVar.mo11372b(str, "Setting revenue listener: " + maxAdRevenueListener);
        this.revenueListener = maxAdRevenueListener;
    }
}
