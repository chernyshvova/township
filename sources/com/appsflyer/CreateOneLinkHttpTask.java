package com.appsflyer;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.appsflyer.internal.C1387af;
import com.appsflyer.internal.C1413al;
import com.appsflyer.internal.C1482k;
import com.appsflyer.share.LinkGenerator;
import com.helpshift.p042db.conversation.tables.ConversationTable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class CreateOneLinkHttpTask extends C1413al {
    public ResponseListener AFInAppEventParameterName;
    public String AFInAppEventType;
    public String AppsFlyer2dXConversionCallback = "";
    public final String getLevel;
    public final Map<String, String> init;
    public final boolean onInstallConversionFailureNative;

    public interface ResponseListener {
        @WorkerThread
        void onResponse(String str);

        @WorkerThread
        void onResponseError(String str);
    }

    public CreateOneLinkHttpTask(@NonNull String str, @NonNull Map<String, String> map, C1387af afVar, @NonNull Context context, boolean z) {
        super(afVar, context, "POST");
        this.onInstallConversionFailureNative = z;
        if (context != null) {
            this.AppsFlyer2dXConversionCallback = context.getPackageName();
        } else {
            AFLogger.AFVersionDeclaration("CreateOneLinkHttpTask: context can't be null");
        }
        this.values = str;
        this.getLevel = "-1";
        this.init = map;
    }

    public final void AFInAppEventType(HttpsURLConnection httpsURLConnection) throws IOException {
        if (!this.onInstallConversionFailureNative) {
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            HashMap hashMap = new HashMap();
            hashMap.put("ttl", this.getLevel);
            hashMap.put(ConversationTable.Columns.LOCAL_UUID, this.AFLogger$LogLevel);
            hashMap.put("data", this.init);
            hashMap.put("meta", this.AFVersionDeclaration);
            String str = this.AFInAppEventType;
            if (str != null) {
                hashMap.put("brand_domain", str);
            }
            String jSONObject = C1482k.values((Map<String, ?>) hashMap).toString();
            AFKeystoreWrapper(httpsURLConnection, this.AFKeystoreWrapper, jSONObject);
            httpsURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            dataOutputStream.writeBytes(jSONObject);
            dataOutputStream.flush();
            dataOutputStream.close();
        }
    }

    public final void valueOf() {
        LinkGenerator addParameters = new LinkGenerator("af_app_invites").setBaseURL(this.values, AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_DOMAIN), this.AppsFlyer2dXConversionCallback).addParameter("af_siteid", this.AppsFlyer2dXConversionCallback).addParameters(this.init);
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string != null) {
            addParameters.setReferrerCustomerId(string);
        }
        this.AFInAppEventParameterName.onResponse(addParameters.generateLink());
    }

    public final void values(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                this.AFInAppEventParameterName.onResponse(jSONObject.optString(keys.next()));
            }
        } catch (JSONException e) {
            this.AFInAppEventParameterName.onResponseError("Can't parse one link data");
            AFLogger.values("Error while parsing to json ".concat(String.valueOf(str)), e);
        }
    }

    public final String AFInAppEventType() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(C1413al.valueOf, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), C1387af.AFInAppEventParameterName().getHostName()}));
        sb.append("/");
        sb.append(this.values);
        return sb.toString();
    }
}
