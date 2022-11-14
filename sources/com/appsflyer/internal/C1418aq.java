package com.appsflyer.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.aq */
public final class C1418aq extends C1413al {
    public C1419d AFInAppEventParameterName;
    public boolean AFInAppEventType = false;
    public String AppsFlyer2dXConversionCallback;
    public String getLevel;

    /* renamed from: com.appsflyer.internal.aq$d */
    public interface C1419d {
        void AFKeystoreWrapper(Map<String, String> map);

        void valueOf(String str);
    }

    public C1418aq(Uri uri, C1387af afVar, Context context) {
        super(afVar, context, "GET");
        if (!TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            String[] strArr = {"onelink.me", "onelnk.com", "app.aflink.com"};
            boolean z = false;
            for (int i = 0; i < 3; i++) {
                if (uri.getHost().contains(strArr[i])) {
                    z = true;
                }
            }
            if (C1474f.AFLogger$LogLevel != null) {
                StringBuilder sb = new StringBuilder("Validate if link ");
                sb.append(uri);
                sb.append(" belongs to custom domains: ");
                sb.append(Arrays.asList(C1474f.AFLogger$LogLevel));
                AFLogger.AFKeystoreWrapper(sb.toString());
                for (String str : C1474f.AFLogger$LogLevel) {
                    if (uri.getHost().contains(str) && !TextUtils.isEmpty(str)) {
                        AFLogger.AFInAppEventType("Link matches custom domain: ".concat(String.valueOf(str)));
                        this.AFInAppEventType = true;
                        z = true;
                    }
                }
            }
            String[] split = uri.getPath().split("/");
            if (z && split.length == 3) {
                this.values = split[1];
                this.AppsFlyer2dXConversionCallback = split[2];
                this.getLevel = uri.toString();
            }
        }
    }

    public final void AFInAppEventType(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.setRequestProperty("Af-UUID", this.AFLogger$LogLevel);
        String valueOf = String.valueOf(this.AFVersionDeclaration.get("build_number"));
        httpsURLConnection.setRequestProperty("Af-Meta-Sdk-Ver", valueOf);
        httpsURLConnection.setRequestProperty("Af-Meta-Counter", String.valueOf(this.AFVersionDeclaration.get("counter")));
        httpsURLConnection.setRequestProperty("Af-Meta-Model", String.valueOf(this.AFVersionDeclaration.get(DeviceRequestsHelper.DEVICE_INFO_MODEL)));
        httpsURLConnection.setRequestProperty("Af-Meta-Platform", String.valueOf(this.AFVersionDeclaration.get("platformextension")));
        httpsURLConnection.setRequestProperty("Af-Meta-System-Version", String.valueOf(this.AFVersionDeclaration.get("sdk")));
        AFKeystoreWrapper(httpsURLConnection, this.AFKeystoreWrapper, this.AFLogger$LogLevel, this.values, this.AppsFlyer2dXConversionCallback, valueOf);
    }

    public final boolean AFKeystoreWrapper() {
        return !TextUtils.isEmpty(this.values) && !TextUtils.isEmpty(this.AppsFlyer2dXConversionCallback) && !this.values.equals("app");
    }

    public final void valueOf() {
        String str = this.getLevel;
        if (str == null) {
            str = "Can't get OneLink data";
        }
        this.AFInAppEventParameterName.valueOf(str);
    }

    public final void values(String str) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            this.AFInAppEventParameterName.AFKeystoreWrapper(hashMap);
        } catch (JSONException e) {
            this.AFInAppEventParameterName.valueOf("Can't parse OneLink data");
            AFLogger.values("Error while parsing to json ".concat(String.valueOf(str)), e);
        }
    }

    public final String AFInAppEventType() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(C1413al.valueOf, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), C1387af.AFInAppEventParameterName().getHostName()}));
        sb.append("/");
        sb.append(this.values);
        sb.append("?id=");
        sb.append(this.AppsFlyer2dXConversionCallback);
        return sb.toString();
    }
}
