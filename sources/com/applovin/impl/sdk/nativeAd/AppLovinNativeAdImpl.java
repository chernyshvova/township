package com.applovin.impl.sdk.nativeAd;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.p007a.C0631a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p024a.C1020e;
import com.applovin.impl.sdk.p028d.C1093a;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinPostbackListener;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppLovinNativeAdImpl extends AppLovinAdBase implements AppLovinNativeAd {
    public static final String AD_RESPONSE_TYPE_APPLOVIN = "applovin";
    public static final String AD_RESPONSE_TYPE_ORTB = "ortb";
    public static final String AD_RESPONSE_TYPE_UNDEFINED = "undefined";
    public final C1020e adEventTracker;
    public final String advertiser;
    public final String body;
    public final String callToAction;
    public final Uri clickDestinationBackupUri;
    public final Uri clickDestinationUri;
    public final C1203a clickHandler;
    public final List<String> clickTrackingUrls;
    public AppLovinNativeAdEventListener eventListener;
    public Uri iconUri;
    public final List<String> impressionUrls;
    public Uri mainImageUri;
    public AppLovinMediaView mediaView;
    public AppLovinOptionsView optionsView;
    public final Uri privacyDestinationUri;
    public final List<View> registeredViews;
    public final String tag;
    public final String title;
    public final C0631a vastAd;
    public final List<String> viewableMRC100Urls;
    public final List<String> viewableMRC50Urls;
    public final List<String> viewableVideo50Urls;

    public static class Builder {
        public final JSONObject adObject;
        public String advertiser;
        public String body;
        public String callToAction;
        public Uri clickDestinationBackupUri;
        public Uri clickDestinationUri;
        public List<String> clickTrackingUrls;
        public final JSONObject fullResponse;
        public Uri iconUri;
        public List<String> impressionUrls;
        public Uri mainImageUri;
        public Uri privacyDestinationUri;
        public final C1188m sdk;
        public String title;
        public C0631a vastAd;
        public List<String> viewableMRC100Urls;
        public List<String> viewableMRC50Urls;
        public List<String> viewableVideo50Urls;

        public Builder(JSONObject jSONObject, JSONObject jSONObject2, C1188m mVar) {
            this.adObject = jSONObject;
            this.fullResponse = jSONObject2;
            this.sdk = mVar;
        }

        public AppLovinNativeAdImpl build() {
            return new AppLovinNativeAdImpl(this);
        }

        public Builder setAdvertiser(String str) {
            this.advertiser = str;
            return this;
        }

        public Builder setBody(String str) {
            this.body = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.callToAction = str;
            return this;
        }

        public Builder setClickDestinationBackupUri(Uri uri) {
            this.clickDestinationBackupUri = uri;
            return this;
        }

        public Builder setClickDestinationUri(Uri uri) {
            this.clickDestinationUri = uri;
            return this;
        }

        public Builder setClickTrackingUrls(List<String> list) {
            this.clickTrackingUrls = list;
            return this;
        }

        public Builder setIconUri(Uri uri) {
            this.iconUri = uri;
            return this;
        }

        public Builder setImpressionUrls(List<String> list) {
            this.impressionUrls = list;
            return this;
        }

        public Builder setMainImageUri(Uri uri) {
            this.mainImageUri = uri;
            return this;
        }

        public Builder setPrivacyDestinationUri(Uri uri) {
            this.privacyDestinationUri = uri;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setVastAd(C0631a aVar) {
            this.vastAd = aVar;
            return this;
        }

        public Builder setViewableMRC100Urls(List<String> list) {
            this.viewableMRC100Urls = list;
            return this;
        }

        public Builder setViewableMRC50Urls(List<String> list) {
            this.viewableMRC50Urls = list;
            return this;
        }

        public Builder setViewableVideo50Urls(List<String> list) {
            this.viewableVideo50Urls = list;
            return this;
        }
    }

    /* renamed from: com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl$a */
    public static class C1203a implements View.OnClickListener, AppLovinTouchToClickListener.OnClickListener {

        /* renamed from: a */
        public final AppLovinNativeAdImpl f2245a;

        public C1203a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
            this.f2245a = appLovinNativeAdImpl;
        }

        /* renamed from: a */
        private void m2176a(Context context) {
            this.f2245a.sdk.mo11005u().maybeSubmitPersistentPostbacks(this.f2245a.getDirectClickTrackingPostbacks());
            for (String dispatchPostbackAsync : this.f2245a.clickTrackingUrls) {
                this.f2245a.sdk.mo10943X().dispatchPostbackAsync(dispatchPostbackAsync, (AppLovinPostbackListener) null);
            }
            if (Utils.openUri(context, this.f2245a.clickDestinationUri, this.f2245a.sdk) || Utils.openUri(context, this.f2245a.clickDestinationBackupUri, this.f2245a.sdk)) {
                C1267j.m2544a(this.f2245a.eventListener, (AppLovinNativeAd) this.f2245a);
            }
        }

        /* renamed from: a */
        public AppLovinNativeAdImpl mo11073a() {
            return this.f2245a;
        }

        /* renamed from: a */
        public boolean mo11074a(Object obj) {
            return obj instanceof C1203a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1203a)) {
                return false;
            }
            C1203a aVar = (C1203a) obj;
            if (!aVar.mo11074a((Object) this)) {
                return false;
            }
            AppLovinNativeAdImpl a = mo11073a();
            AppLovinNativeAdImpl a2 = aVar.mo11073a();
            return a != null ? a.equals(a2) : a2 == null;
        }

        public int hashCode() {
            AppLovinNativeAdImpl a = mo11073a();
            return 59 + (a == null ? 43 : a.hashCode());
        }

        public void onClick(View view) {
            m2176a(view.getContext());
        }

        public void onClick(View view, PointF pointF) {
            m2176a(view.getContext());
        }

        public String toString() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinNativeAdImpl.ClickHandler(ad=");
            outline24.append(mo11073a());
            outline24.append(")");
            return outline24.toString();
        }
    }

    public AppLovinNativeAdImpl(Builder builder) {
        super(builder.adObject, builder.fullResponse, builder.sdk);
        this.registeredViews = new ArrayList();
        this.clickHandler = new C1203a(this);
        this.adEventTracker = new C1020e(this);
        this.title = builder.title;
        this.advertiser = builder.advertiser;
        this.body = builder.body;
        this.callToAction = builder.callToAction;
        this.iconUri = builder.iconUri;
        this.mainImageUri = builder.mainImageUri;
        this.vastAd = builder.vastAd;
        this.privacyDestinationUri = builder.privacyDestinationUri;
        this.clickDestinationUri = builder.clickDestinationUri;
        this.clickDestinationBackupUri = builder.clickDestinationBackupUri;
        this.clickTrackingUrls = builder.clickTrackingUrls;
        this.impressionUrls = builder.impressionUrls;
        this.viewableMRC50Urls = builder.viewableMRC50Urls;
        this.viewableMRC100Urls = builder.viewableMRC100Urls;
        this.viewableVideo50Urls = builder.viewableVideo50Urls;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinNativeAd:");
        outline24.append(getAdIdNumber());
        this.tag = outline24.toString();
    }

    /* access modifiers changed from: private */
    public List<C1093a> getDirectClickTrackingPostbacks() {
        List<C1093a> postbacks;
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("click_tracking_urls", this.adObject, getClCode(), getStringFromAdObject("click_tracking_url", (String) null), this.sdk);
        }
        return postbacks;
    }

    public C1020e getAdEventTracker() {
        return this.adEventTracker;
    }

    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1);
    }

    public String getAdvertiser() {
        return this.advertiser;
    }

    public String getBody() {
        return this.body;
    }

    @Nullable
    public String getCachePrefix() {
        return getStringFromAdObject("cache_prefix", (String) null);
    }

    public String getCallToAction() {
        return this.callToAction;
    }

    public C1203a getClickHandler() {
        return this.clickHandler;
    }

    public Uri getIconUri() {
        return this.iconUri;
    }

    public List<String> getImpressionUrls() {
        return this.impressionUrls;
    }

    public Uri getMainImageUri() {
        return this.mainImageUri;
    }

    public AppLovinMediaView getMediaView() {
        return this.mediaView;
    }

    @Nullable
    public String getOpenMeasurementContentUrl() {
        return getStringFromAdObject("omid_content_url", (String) null);
    }

    public String getOpenMeasurementCustomReferenceData() {
        return getStringFromAdObject("omid_custom_ref_data", "");
    }

    public List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.adObjectLock) {
            JSONArray jSONArray = JsonUtils.getJSONArray(this.adObject, "omid_verification_script_resources", (JSONArray) null);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
                    try {
                        URL url = new URL(JsonUtils.getString(jSONObject, "url", (String) null));
                        String string = JsonUtils.getString(jSONObject, "vendor_key", (String) null);
                        String string2 = JsonUtils.getString(jSONObject, "parameters", (String) null);
                        arrayList.add((!StringUtils.isValidString(string) || !StringUtils.isValidString(string2)) ? VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url) : VerificationScriptResource.createVerificationScriptResourceWithParameters(string, url, string2));
                    } catch (Throwable th) {
                        this.sdk.mo10922B().mo11373b(this.tag, "Failed to parse OMID verification script resource", th);
                    }
                }
            }
        }
        return arrayList;
    }

    public AppLovinOptionsView getOptionsView() {
        return this.optionsView;
    }

    public Uri getPrivacyDestinationUri() {
        return this.privacyDestinationUri;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return getStringFromAdObject("type", "undefined");
    }

    public C0631a getVastAd() {
        return this.vastAd;
    }

    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", Boolean.FALSE);
    }

    public void registerViewsForInteraction(List<View> list) {
        if (this.clickDestinationUri != null || this.clickDestinationBackupUri != null) {
            for (View next : list) {
                if (next.hasOnClickListeners()) {
                    C1314v B = this.sdk.mo10922B();
                    String str = this.tag;
                    B.mo11376e(str, "View has an onClickListener already - " + next);
                }
                next.setOnClickListener(this.clickHandler);
                this.registeredViews.add(next);
            }
            C1314v B2 = this.sdk.mo10922B();
            String str2 = this.tag;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Registered views: ");
            outline24.append(this.registeredViews);
            B2.mo11372b(str2, outline24.toString());
        }
    }

    public void setEventListener(AppLovinNativeAdEventListener appLovinNativeAdEventListener) {
        this.eventListener = appLovinNativeAdEventListener;
    }

    public void setIconUri(Uri uri) {
        this.iconUri = uri;
    }

    public void setMainImageUri(Uri uri) {
        this.mainImageUri = uri;
    }

    public void setUpNativeAdViewComponents() {
        C1188m mVar = this.sdk;
        this.mediaView = new AppLovinMediaView(this, mVar, mVar.mo10932L());
        Uri uri = this.privacyDestinationUri;
        C1188m mVar2 = this.sdk;
        this.optionsView = new AppLovinOptionsView(uri, mVar2, mVar2.mo10932L());
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinNativeAd{adIdNumber=");
        outline24.append(getAdIdNumber());
        outline24.append(" - ");
        outline24.append(getTitle());
        outline24.append("}");
        return outline24.toString();
    }

    public void unregisterViewsForInteraction() {
        for (View onClickListener : this.registeredViews) {
            onClickListener.setOnClickListener((View.OnClickListener) null);
        }
        C1314v B = this.sdk.mo10922B();
        String str = this.tag;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unregistered views: ");
        outline24.append(this.registeredViews);
        B.mo11372b(str, outline24.toString());
        this.registeredViews.clear();
    }
}
