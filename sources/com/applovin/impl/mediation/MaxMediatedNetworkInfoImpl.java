package com.applovin.impl.mediation;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.facebook.applinks.FacebookAppLinkResolver;
import com.facebook.internal.FetchedAppGateKeepersManager;
import org.json.JSONObject;

public class MaxMediatedNetworkInfoImpl implements MaxMediatedNetworkInfo {

    /* renamed from: a */
    public final JSONObject f553a;

    public MaxMediatedNetworkInfoImpl(JSONObject jSONObject) {
        this.f553a = jSONObject;
    }

    public String getAdapterClassName() {
        return JsonUtils.getString(this.f553a, FacebookAppLinkResolver.APP_LINK_TARGET_CLASS_KEY, "");
    }

    public String getAdapterVersion() {
        return JsonUtils.getString(this.f553a, "version", "");
    }

    public String getName() {
        return JsonUtils.getString(this.f553a, "name", "");
    }

    public String getSdkVersion() {
        return JsonUtils.getString(this.f553a, FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION, "");
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("MaxMediatedNetworkInfo{name=");
        outline24.append(getName());
        outline24.append(", adapterClassName=");
        outline24.append(getAdapterClassName());
        outline24.append(", adapterVersion=");
        outline24.append(getAdapterVersion());
        outline24.append(", sdkVersion=");
        outline24.append(getSdkVersion());
        outline24.append('}');
        return outline24.toString();
    }
}
