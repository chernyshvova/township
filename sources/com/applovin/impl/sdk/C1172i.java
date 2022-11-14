package com.applovin.impl.sdk;

import android.os.Bundle;
import android.view.View;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.C0791c;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.mediation.p010a.C0802b;
import com.applovin.impl.mediation.p012c.C0867c;
import com.applovin.impl.sdk.network.C1211a;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.network.C1226g;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.i */
public class C1172i implements AppLovinCommunicatorPublisher, AppLovinCommunicatorSubscriber {

    /* renamed from: a */
    public final C1188m f2120a;

    /* renamed from: b */
    public final AppLovinCommunicator f2121b;

    public C1172i(C1188m mVar) {
        this.f2120a = mVar;
        this.f2121b = AppLovinCommunicator.getInstance(mVar.mo10932L());
        if (!mVar.mo10988e()) {
            this.f2121b.mo9283a(mVar);
            this.f2121b.subscribe((AppLovinCommunicatorSubscriber) this, C0791c.f536a);
        }
    }

    /* renamed from: b */
    private Bundle m2002b(C0801a aVar) {
        String str;
        Bundle bundle = new Bundle();
        bundle.putString("id", aVar.mo9833f());
        bundle.putString("network_name", aVar.mo9898P());
        bundle.putString("max_ad_unit_id", aVar.getAdUnitId());
        bundle.putString("third_party_ad_placement_id", aVar.mo9849m());
        bundle.putString(FirebaseAnalytics.Param.AD_FORMAT, aVar.getFormat().getLabel());
        if (StringUtils.isValidString(aVar.getCreativeId())) {
            bundle.putString("creative_id", aVar.getCreativeId());
        }
        bundle.putAll(JsonUtils.toBundle(aVar.mo9829b()));
        if (aVar instanceof C0802b) {
            View x = ((C0802b) aVar).mo9864x();
            if (x != null) {
                str = x.getClass().getName() + '@' + Integer.toHexString(x.hashCode());
            } else {
                str = "N/A";
            }
            bundle.putString("ad_view", str);
        }
        return bundle;
    }

    /* renamed from: a */
    public void mo10892a() {
        mo10893a(new Bundle(), "privacy_setting_updated");
    }

    /* renamed from: a */
    public void mo10893a(Bundle bundle, String str) {
        if (!this.f2120a.mo10988e()) {
            this.f2121b.getMessagingService().publish(CommunicatorMessageImpl.create(bundle, str, this, this.f2120a.mo10980b(C1085b.f1804fa).contains(str)));
        }
    }

    /* renamed from: a */
    public void mo10894a(C0801a aVar) {
        Bundle b = m2002b(aVar);
        b.putAll(JsonUtils.toBundle(aVar.mo9830c()));
        b.putString("country_code", this.f2120a.mo11002s().getCountryCode());
        BundleUtils.putStringIfValid("user_segment", this.f2120a.mo11000q().getName(), b);
        mo10893a(b, "max_revenue_events");
    }

    /* renamed from: a */
    public void mo10895a(C0801a aVar, String str) {
        Bundle b = m2002b(aVar);
        b.putString("type", str);
        C1314v B = this.f2120a.mo10922B();
        B.mo11372b("CommunicatorService", "Sending \"max_ad_events\" message: " + b);
        mo10893a(b, "max_ad_events");
    }

    /* renamed from: a */
    public void mo10896a(MaxAdapter.InitializationStatus initializationStatus, String str) {
        Bundle outline5 = GeneratedOutlineSupport.outline5("adapter_class", str);
        outline5.putInt("init_status", initializationStatus.getCode());
        mo10893a(outline5, "adapter_initialization_status");
    }

    /* renamed from: a */
    public void mo10897a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("adapter_class", str2);
        bundle.putString(FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION, str);
        mo10893a(bundle, "network_sdk_version_updated");
    }

    /* renamed from: a */
    public void mo10898a(String str, String str2, int i, Object obj, String str3, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putString("url", str2);
        bundle.putInt("code", i);
        bundle.putBundle("body", JsonUtils.toBundle(obj));
        bundle.putBoolean("success", z);
        BundleUtils.putString("error_message", str3, bundle);
        mo10893a(bundle, "receive_http_response");
    }

    /* renamed from: a */
    public void mo10899a(String str, String str2, String str3) {
        String maybeConvertToIndentedString = JsonUtils.maybeConvertToIndentedString(str3, 2);
        String maybeConvertToIndentedString2 = JsonUtils.maybeConvertToIndentedString(str, 2);
        Bundle bundle = new Bundle();
        bundle.putString("request_url", str2);
        bundle.putString("request_body", maybeConvertToIndentedString);
        bundle.putString(AnalyticsEventKey.RESPONSE, maybeConvertToIndentedString2);
        mo10893a(bundle, "responses");
    }

    /* renamed from: a */
    public void mo10900a(JSONObject jSONObject, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2120a.mo11010z());
        bundle.putString("applovin_random_token", this.f2120a.mo10998o());
        bundle.putString("compass_random_token", this.f2120a.mo10997n());
        bundle.putString("device_type", AppLovinSdkUtils.isTablet(this.f2120a.mo10932L()) ? "tablet" : "phone");
        bundle.putString("init_success", String.valueOf(z));
        bundle.putParcelableArrayList("installed_mediation_adapters", JsonUtils.toBundle(C0867c.m937a(this.f2120a)));
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "communicator_settings", new JSONObject());
        Bundle bundle2 = (Bundle) bundle.clone();
        JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "user_engagement_sdk_settings", new JSONObject());
        JsonUtils.putString(jSONObject3, "lsc", "Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U=");
        JsonUtils.putString(jSONObject3, "psp", "Y29tLmFuZHJvaWQudmVuZGluZw==");
        bundle2.putBundle("settings", JsonUtils.toBundle(jSONObject3));
        mo10893a(bundle2, "user_engagement_sdk_init");
        Bundle bundle3 = (Bundle) bundle.clone();
        bundle3.putBundle("settings", JsonUtils.toBundle(JsonUtils.getJSONObject(jSONObject2, "safedk_settings", new JSONObject())));
        C1314v B = this.f2120a.mo10922B();
        B.mo11372b("CommunicatorService", "Sending \"safedk_init\" message: " + bundle);
        mo10893a(bundle3, "safedk_init");
        Bundle bundle4 = (Bundle) bundle.clone();
        bundle4.putBundle("settings", JsonUtils.toBundle(JsonUtils.getJSONObject(jSONObject2, "adjust_settings", new JSONObject())));
        mo10893a(bundle4, "adjust_init");
        Bundle bundle5 = (Bundle) bundle.clone();
        bundle5.putBundle("settings", JsonUtils.toBundle(JsonUtils.getJSONObject(jSONObject2, "discovery_settings", new JSONObject())));
        mo10893a(bundle5, "discovery_init");
    }

    /* renamed from: a */
    public boolean mo10901a(String str) {
        return C0791c.f536a.contains(str);
    }

    public String getCommunicatorId() {
        return "applovin_sdk";
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        int i;
        Map<String, Object> map;
        if ("send_http_request".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            Map<String, String> stringMap = BundleUtils.toStringMap(messageData.getBundle("query_params"));
            Map<String, Object> map2 = BundleUtils.toMap(messageData.getBundle("post_body"));
            Map<String, String> stringMap2 = BundleUtils.toStringMap(messageData.getBundle("headers"));
            String string = messageData.getString("id", "");
            if (!map2.containsKey(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY)) {
                map2.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2120a.mo11010z());
            }
            this.f2120a.mo10940U().mo11145a(new C1226g.C1228a().mo11174c(messageData.getString("url")).mo11177d(messageData.getString("backup_url")).mo11168a(stringMap).mo11175c(map2).mo11172b(stringMap2).mo11169a(((Boolean) this.f2120a.mo10946a(C1085b.f1797et)).booleanValue()).mo11167a(string).mo11170a());
        } else if ("send_http_request_v2".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData2 = appLovinCommunicatorMessage.getMessageData();
            String string2 = messageData2.getString("http_method", "POST");
            long millis = messageData2.containsKey("timeout_sec") ? TimeUnit.SECONDS.toMillis(messageData2.getLong("timeout_sec")) : ((Long) this.f2120a.mo10946a(C1085b.f1735dj)).longValue();
            int i2 = messageData2.getInt("retry_count", ((Integer) this.f2120a.mo10946a(C1085b.f1736dk)).intValue());
            long millis2 = messageData2.containsKey("retry_delay_sec") ? TimeUnit.SECONDS.toMillis(messageData2.getLong("retry_delay_sec")) : ((Long) this.f2120a.mo10946a(C1085b.f1737dl)).longValue();
            Map<String, String> stringMap3 = BundleUtils.toStringMap(messageData2.getBundle("query_params"));
            long j = millis2;
            if ("GET".equalsIgnoreCase(string2)) {
                if (messageData2.getBoolean("include_data_collector_info", true)) {
                    stringMap3.putAll(BundleUtils.toStringMap(CollectionUtils.toBundle(this.f2120a.mo10941V().mo11205a((Map<String, String>) null, false, false))));
                }
                i = i2;
                map = null;
            } else {
                map = BundleUtils.toMap(messageData2.getBundle("post_body"));
                if (messageData2.getBoolean("include_data_collector_info", true)) {
                    Map<String, Object> h = this.f2120a.mo10941V().mo11213h();
                    Map<String, Object> d = this.f2120a.mo10941V().mo11209d();
                    if (!d.containsKey("idfv") || !d.containsKey("idfv_scope")) {
                        i = i2;
                    } else {
                        i = i2;
                        int intValue = ((Integer) d.get("idfv_scope")).intValue();
                        d.remove("idfv");
                        d.remove("idfv_scope");
                        h.put("idfv", (String) d.get("idfv"));
                        h.put("idfv_scope", Integer.valueOf(intValue));
                    }
                    h.put("server_installed_at", this.f2120a.mo10946a(C1085b.f1580al));
                    h.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2120a.mo11010z());
                    map.put("app", h);
                    map.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, d);
                } else {
                    i = i2;
                }
            }
            this.f2120a.mo10938S().mo10829a((C1109a) new C1211a(appLovinCommunicatorMessage.getPublisherId(), C1217c.m2223a(this.f2120a).mo11127a(messageData2.getString("url")).mo11137c(messageData2.getString("backup_url")).mo11128a(stringMap3).mo11133b(string2).mo11134b(BundleUtils.toStringMap(messageData2.getBundle("headers"))).mo11129a(map != null ? new JSONObject(map) : null).mo11132b((int) millis).mo11125a(i).mo11136c((int) j).mo11126a(new JSONObject()).mo11138c(messageData2.getBoolean("is_encoding_enabled", false)).mo11131a(), this.f2120a), C1140o.C1142a.MAIN);
        } else if ("set_ad_request_query_params".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
            this.f2120a.mo11005u().addCustomQueryParams(Utils.stringifyObjectMap(BundleUtils.toMap(appLovinCommunicatorMessage.getMessageData())));
        } else if ("set_ad_request_post_body".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
            this.f2120a.mo11005u().setCustomPostBody(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
        } else if ("set_mediate_request_post_body_data".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
            this.f2120a.mo10925E().setCustomPostBodyData(BundleUtils.toJSONObject(appLovinCommunicatorMessage.getMessageData()));
        }
    }
}
