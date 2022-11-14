package com.appsflyer.share;

import android.content.Context;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.internal.C1387af;
import com.appsflyer.internal.C1460bv;
import com.appsflyer.internal.C1486n;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class LinkGenerator {
    public String AFInAppEventParameterName;
    public String AFInAppEventType;
    public String AFKeystoreWrapper;
    public String AFLogger$LogLevel;
    public String AFVersionDeclaration;
    public String AppsFlyer2dXConversionCallback;
    public String getLevel;
    public String init;
    public String onAppOpenAttributionNative;
    public String onAttributionFailureNative;
    public Map<String, String> onDeepLinkingNative = new HashMap();
    public Map<String, String> onInstallConversionDataLoadedNative = new HashMap();
    public String valueOf;
    public String values;

    public LinkGenerator(String str) {
        this.AFInAppEventType = str;
    }

    private StringBuilder AFKeystoreWrapper() {
        StringBuilder sb = new StringBuilder();
        String str = this.AFKeystoreWrapper;
        if (str == null || !str.startsWith("http")) {
            sb.append(String.format(C1460bv.AFKeystoreWrapper, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), C1387af.AFInAppEventParameterName().getHostName()}));
        } else {
            sb.append(this.AFKeystoreWrapper);
        }
        if (this.values != null) {
            sb.append('/');
            sb.append(this.values);
        }
        this.onInstallConversionDataLoadedNative.put("pid", this.AFInAppEventType);
        sb.append('?');
        sb.append("pid=");
        sb.append(valueOf(this.AFInAppEventType, "media source"));
        String str2 = this.AppsFlyer2dXConversionCallback;
        if (str2 != null) {
            this.onInstallConversionDataLoadedNative.put("af_referrer_uid", str2);
            sb.append('&');
            sb.append("af_referrer_uid=");
            sb.append(valueOf(this.AppsFlyer2dXConversionCallback, "referrerUID"));
        }
        String str3 = this.AFInAppEventParameterName;
        if (str3 != null) {
            this.onInstallConversionDataLoadedNative.put(AFInAppEventParameterName.AF_CHANNEL, str3);
            sb.append('&');
            sb.append("af_channel=");
            sb.append(valueOf(this.AFInAppEventParameterName, "channel"));
        }
        String str4 = this.init;
        if (str4 != null) {
            this.onInstallConversionDataLoadedNative.put("af_referrer_customer_id", str4);
            sb.append('&');
            sb.append("af_referrer_customer_id=");
            sb.append(valueOf(this.init, "referrerCustomerId"));
        }
        String str5 = this.valueOf;
        if (str5 != null) {
            this.onInstallConversionDataLoadedNative.put("c", str5);
            sb.append('&');
            sb.append("c=");
            sb.append(valueOf(this.valueOf, "campaign"));
        }
        String str6 = this.AFLogger$LogLevel;
        if (str6 != null) {
            this.onInstallConversionDataLoadedNative.put("af_referrer_name", str6);
            sb.append('&');
            sb.append("af_referrer_name=");
            sb.append(valueOf(this.AFLogger$LogLevel, "referrerName"));
        }
        String str7 = this.AFVersionDeclaration;
        if (str7 != null) {
            this.onInstallConversionDataLoadedNative.put("af_referrer_image_url", str7);
            sb.append('&');
            sb.append("af_referrer_image_url=");
            sb.append(valueOf(this.AFVersionDeclaration, "referrerImageURL"));
        }
        if (this.onAppOpenAttributionNative != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.onAppOpenAttributionNative);
            String str8 = "";
            sb2.append(this.onAppOpenAttributionNative.endsWith("/") ? str8 : "/");
            String str9 = this.getLevel;
            if (str9 != null) {
                sb2.append(str9);
            }
            this.onInstallConversionDataLoadedNative.put("af_dp", sb2.toString());
            sb.append('&');
            sb.append("af_dp=");
            sb.append(valueOf(this.onAppOpenAttributionNative, "baseDeeplink"));
            if (this.getLevel != null) {
                if (!this.onAppOpenAttributionNative.endsWith("/")) {
                    str8 = "%2F";
                }
                sb.append(str8);
                sb.append(valueOf(this.getLevel, "deeplinkPath"));
            }
        }
        for (String next : this.onDeepLinkingNative.keySet()) {
            String obj = sb.toString();
            StringBuilder outline26 = GeneratedOutlineSupport.outline26(next, "=");
            outline26.append(valueOf(this.onDeepLinkingNative.get(next), next));
            if (!obj.contains(outline26.toString())) {
                sb.append('&');
                sb.append(next);
                sb.append('=');
                sb.append(valueOf(this.onDeepLinkingNative.get(next), next));
            }
        }
        return sb;
    }

    public static String valueOf(String str, String str2) {
        try {
            return URLEncoder.encode(str, "utf8");
        } catch (UnsupportedEncodingException e) {
            StringBuilder sb = new StringBuilder("Illegal ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            AFLogger.values(sb.toString(), e);
            return "";
        } catch (Throwable th) {
            AFLogger.AFInAppEventType(th);
            return "";
        }
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.onDeepLinkingNative.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.onDeepLinkingNative.putAll(map);
        }
        return this;
    }

    public String generateLink() {
        return AFKeystoreWrapper().toString();
    }

    public String getBrandDomain() {
        return this.onAttributionFailureNative;
    }

    public String getCampaign() {
        return this.valueOf;
    }

    public String getChannel() {
        return this.AFInAppEventParameterName;
    }

    public String getMediaSource() {
        return this.AFInAppEventType;
    }

    public Map<String, String> getParameters() {
        return this.onDeepLinkingNative;
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.onAppOpenAttributionNative = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        if (str == null || str.length() <= 0) {
            this.AFKeystoreWrapper = String.format("https://%s/%s", new Object[]{String.format("%sapp.%s", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), C1387af.AFInAppEventParameterName().getHostName()}), str3});
        } else {
            if (str2 == null || str2.length() < 5) {
                str2 = "go.onelink.me";
            }
            this.AFKeystoreWrapper = String.format("https://%s/%s", new Object[]{str2, str});
        }
        return this;
    }

    public LinkGenerator setBrandDomain(String str) {
        this.onAttributionFailureNative = str;
        return this;
    }

    public LinkGenerator setCampaign(String str) {
        this.valueOf = str;
        return this;
    }

    public LinkGenerator setChannel(String str) {
        this.AFInAppEventParameterName = str;
        return this;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.getLevel = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.init = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.AFVersionDeclaration = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.AFLogger$LogLevel = str;
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.AppsFlyer2dXConversionCallback = str;
        return this;
    }

    public void generateLink(Context context, CreateOneLinkHttpTask.ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        if (!this.onDeepLinkingNative.isEmpty()) {
            for (Map.Entry next : this.onDeepLinkingNative.entrySet()) {
                this.onInstallConversionDataLoadedNative.put(next.getKey(), next.getValue());
            }
        }
        AFKeystoreWrapper();
        String str = this.onAttributionFailureNative;
        Map<String, String> map = this.onInstallConversionDataLoadedNative;
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.AFInAppEventParameterName("CustomerUserId not set, generate User Invite Link is disabled", true);
            return;
        }
        CreateOneLinkHttpTask createOneLinkHttpTask = new CreateOneLinkHttpTask(string, map, C1387af.AFInAppEventParameterName(), context, AppsFlyerLib.getInstance().isStopped());
        createOneLinkHttpTask.AFInAppEventParameterName = responseListener;
        createOneLinkHttpTask.AFInAppEventType = str;
        if (C1486n.valueOf == null) {
            C1486n.valueOf = new C1486n();
        }
        C1486n.valueOf.AFInAppEventParameterName().execute(createOneLinkHttpTask);
    }
}
