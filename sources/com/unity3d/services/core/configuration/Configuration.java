package com.unity3d.services.core.configuration;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.conversation.domainmodel.ConversationController;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.WebRequest;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class Configuration {
    public String _configJsonString;
    public String _configUrl;
    public int _connectedEventThresholdInMs;
    public boolean _delayWebViewUpdate;
    public int _loadTimeout;
    public int _maxRetries;
    public int _maximumConnectedEvents;
    public double _metricSampleRate;
    public String _metricsUrl;
    public String[] _moduleConfigurationList = {"com.unity3d.services.core.configuration.CoreModuleConfiguration", "com.unity3d.services.ads.configuration.AdsModuleConfiguration", "com.unity3d.services.analytics.core.configuration.AnalyticsModuleConfiguration", "com.unity3d.services.banners.configuration.BannersModuleConfiguration", "com.unity3d.services.store.core.configuration.StoreModuleConfiguration"};
    public Map<String, IModuleConfiguration> _moduleConfigurations;
    public long _networkErrorTimeout;
    public int _resetWebAppTimeout;
    public long _retryDelay;
    public double _retryScalingFactor;
    public String _sdkVersion;
    public int _showTimeout;
    public Class[] _webAppApiClassList;
    public long _webViewAppCreateTimeout;
    public int _webViewBridgeTimeout;
    public String _webViewData;
    public String _webViewHash;
    public String _webViewUrl;
    public String _webViewVersion;

    public Configuration() {
        setOptionalFields(new JSONObject());
    }

    private void createWebAppApiClassList() {
        ArrayList arrayList = new ArrayList();
        for (String moduleConfiguration : getModuleConfigurationList()) {
            IModuleConfiguration moduleConfiguration2 = getModuleConfiguration(moduleConfiguration);
            if (!(moduleConfiguration2 == null || moduleConfiguration2.getWebAppApiClassList() == null)) {
                arrayList.addAll(Arrays.asList(moduleConfiguration2.getWebAppApiClassList()));
            }
        }
        this._webAppApiClassList = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleConfigurationData(org.json.JSONObject r5) throws java.net.MalformedURLException {
        /*
            r4 = this;
            java.lang.String r0 = "hash"
            java.lang.String r1 = "url"
            r2 = 0
            boolean r3 = r5.isNull(r1)     // Catch:{ JSONException -> 0x0010 }
            if (r3 != 0) goto L_0x0010
            java.lang.String r1 = r5.getString(r1)     // Catch:{ JSONException -> 0x0010 }
            goto L_0x0011
        L_0x0010:
            r1 = r2
        L_0x0011:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0034
            r4._webViewUrl = r1
            boolean r1 = r5.isNull(r0)     // Catch:{ JSONException -> 0x0028 }
            if (r1 != 0) goto L_0x0024
            java.lang.String r0 = r5.getString(r0)     // Catch:{ JSONException -> 0x0028 }
            goto L_0x0025
        L_0x0024:
            r0 = r2
        L_0x0025:
            r4._webViewHash = r0     // Catch:{ JSONException -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            r4._webViewHash = r2
        L_0x002a:
            r4.setOptionalFields(r5)
            java.lang.String r5 = r5.toString()
            r4._configJsonString = r5
            return
        L_0x0034:
            java.net.MalformedURLException r5 = new java.net.MalformedURLException
            java.lang.String r0 = "WebView URL is null or empty"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.configuration.Configuration.handleConfigurationData(org.json.JSONObject):void");
    }

    private void setOptionalFields(JSONObject jSONObject) {
        this._webViewVersion = jSONObject.optString("version", (String) null);
        this._delayWebViewUpdate = jSONObject.optBoolean("dwu", false);
        this._resetWebAppTimeout = jSONObject.optInt("rwt", 10000);
        this._maxRetries = jSONObject.optInt("mr", 6);
        this._retryDelay = jSONObject.optLong("rd", 5000);
        this._retryScalingFactor = jSONObject.optDouble("rcf", 2.0d);
        this._connectedEventThresholdInMs = jSONObject.optInt("cet", 10000);
        this._maximumConnectedEvents = jSONObject.optInt("mce", 500);
        this._networkErrorTimeout = jSONObject.optLong("net", ConversationController.ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT);
        this._sdkVersion = jSONObject.optString("sdkv", "");
        this._showTimeout = jSONObject.optInt("sto", 10000);
        this._loadTimeout = jSONObject.optInt("lto", 30000);
        this._webViewBridgeTimeout = jSONObject.optInt("wto", 5000);
        this._metricsUrl = jSONObject.optString("murl", "");
        this._metricSampleRate = jSONObject.optDouble("msr", 100.0d);
        this._webViewAppCreateTimeout = jSONObject.optLong("wct", ConversationController.ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT);
    }

    public String buildQueryString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("?ts=");
        outline24.append(System.currentTimeMillis());
        outline24.append("&sdkVersion=");
        outline24.append(SdkProperties.getVersionCode());
        outline24.append("&sdkVersionName=");
        outline24.append(SdkProperties.getVersionName());
        return outline24.toString();
    }

    public String getConfigUrl() {
        return this._configUrl;
    }

    public int getConnectedEventThreshold() {
        return this._connectedEventThresholdInMs;
    }

    public boolean getDelayWebViewUpdate() {
        return this._delayWebViewUpdate;
    }

    public String getJSONString() {
        return this._configJsonString;
    }

    public int getLoadTimeout() {
        return this._loadTimeout;
    }

    public int getMaxRetries() {
        return this._maxRetries;
    }

    public int getMaximumConnectedEvents() {
        return this._maximumConnectedEvents;
    }

    public double getMetricSampleRate() {
        return this._metricSampleRate;
    }

    public String getMetricsUrl() {
        return this._metricsUrl;
    }

    public IModuleConfiguration getModuleConfiguration(String str) {
        Map<String, IModuleConfiguration> map = this._moduleConfigurations;
        if (map != null && map.containsKey(str)) {
            return this._moduleConfigurations.get(str);
        }
        try {
            IModuleConfiguration iModuleConfiguration = (IModuleConfiguration) Class.forName(str).newInstance();
            if (iModuleConfiguration != null) {
                if (this._moduleConfigurations == null) {
                    HashMap hashMap = new HashMap();
                    this._moduleConfigurations = hashMap;
                    hashMap.put(str, iModuleConfiguration);
                }
                return iModuleConfiguration;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public String[] getModuleConfigurationList() {
        return this._moduleConfigurationList;
    }

    public long getNetworkErrorTimeout() {
        return this._networkErrorTimeout;
    }

    public int getResetWebappTimeout() {
        return this._resetWebAppTimeout;
    }

    public long getRetryDelay() {
        return this._retryDelay;
    }

    public double getRetryScalingFactor() {
        return this._retryScalingFactor;
    }

    public String getSdkVersion() {
        return this._sdkVersion;
    }

    public int getShowTimeout() {
        return this._showTimeout;
    }

    public Class[] getWebAppApiClassList() {
        if (this._webAppApiClassList == null) {
            createWebAppApiClassList();
        }
        return this._webAppApiClassList;
    }

    public long getWebViewAppCreateTimeout() {
        return this._webViewAppCreateTimeout;
    }

    public int getWebViewBridgeTimeout() {
        return this._webViewBridgeTimeout;
    }

    public String getWebViewData() {
        return this._webViewData;
    }

    public String getWebViewHash() {
        return this._webViewHash;
    }

    public String getWebViewUrl() {
        return this._webViewUrl;
    }

    public String getWebViewVersion() {
        return this._webViewVersion;
    }

    public void makeRequest() throws Exception {
        if (this._configUrl != null) {
            String str = this._configUrl + buildQueryString();
            DeviceLog.debug("Requesting configuration with: " + str);
            try {
                handleConfigurationData(new JSONObject(new WebRequest(str, "GET", (Map<String, List<String>>) null).makeRequest()));
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new MalformedURLException("Base URL is null");
        }
    }

    public void setWebViewData(String str) {
        this._webViewData = str;
    }

    public void setWebViewHash(String str) {
        this._webViewHash = str;
    }

    public void setWebViewUrl(String str) {
        this._webViewUrl = str;
    }

    public Configuration(String str) {
        this._configUrl = str;
        setOptionalFields(new JSONObject());
    }

    public Configuration(JSONObject jSONObject) throws MalformedURLException {
        handleConfigurationData(jSONObject);
    }
}
