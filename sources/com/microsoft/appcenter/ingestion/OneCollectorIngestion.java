package com.microsoft.appcenter.ingestion;

import androidx.annotation.NonNull;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.HttpUtils;
import com.microsoft.appcenter.http.ServiceCall;
import com.microsoft.appcenter.http.ServiceCallback;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.TicketCache;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

public class OneCollectorIngestion extends AbstractAppCenterIngestion {
    public final DefaultLogSerializer mLogSerializer;

    public static class IngestionCallTemplate implements HttpClient.CallTemplate {
        public final LogContainer mLogContainer;
        public final DefaultLogSerializer mLogSerializer;

        public IngestionCallTemplate(DefaultLogSerializer defaultLogSerializer, LogContainer logContainer) {
            this.mLogSerializer = defaultLogSerializer;
            this.mLogContainer = logContainer;
        }

        public String buildRequestBody() throws JSONException {
            StringBuilder sb = new StringBuilder();
            for (Log serializeLog : this.mLogContainer.logs) {
                sb.append(this.mLogSerializer.serializeLog(serializeLog));
                sb.append(10);
            }
            return sb.toString();
        }

        public void onBeforeCalling(URL url, Map<String, String> map) {
            if (AppCenterLog.sLogLevel <= 2) {
                AppCenterLog.verbose("AppCenter", "Calling " + url + "...");
                HashMap hashMap = new HashMap(map);
                String str = (String) hashMap.get("apikey");
                if (str != null) {
                    StringBuilder sb = new StringBuilder();
                    Matcher matcher = HttpUtils.API_KEY_PATTERN.matcher(str);
                    int i = 0;
                    while (matcher.find()) {
                        sb.append(str.substring(i, matcher.start()));
                        sb.append("-***");
                        sb.append(matcher.group(1));
                        i = matcher.end();
                    }
                    if (i < str.length()) {
                        sb.append(str.substring(i));
                    }
                    hashMap.put("apikey", sb.toString());
                }
                String str2 = (String) hashMap.get("Tickets");
                if (str2 != null) {
                    hashMap.put("Tickets", HttpUtils.TOKEN_VALUE_PATTERN.matcher(str2).replaceAll(":***"));
                }
                AppCenterLog.verbose("AppCenter", "Headers: " + hashMap);
            }
        }
    }

    public OneCollectorIngestion(@NonNull HttpClient httpClient, @NonNull DefaultLogSerializer defaultLogSerializer) {
        super(httpClient, "https://mobile.events.data.microsoft.com/OneCollector/1.0");
        this.mLogSerializer = defaultLogSerializer;
    }

    public ServiceCall sendAsync(String str, UUID uuid, LogContainer logContainer, ServiceCallback serviceCallback) throws IllegalArgumentException {
        HashMap hashMap = new HashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Log transmissionTargetTokens : logContainer.logs) {
            linkedHashSet.addAll(transmissionTargetTokens.getTransmissionTargetTokens());
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(",");
        }
        if (!linkedHashSet.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        hashMap.put("apikey", sb.toString());
        JSONObject jSONObject = new JSONObject();
        Iterator<Log> it2 = logContainer.logs.iterator();
        while (it2.hasNext()) {
            List<String> list = ((CommonSchemaLog) it2.next()).ext.protocol.ticketKeys;
            if (list != null) {
                for (String next : list) {
                    String str2 = TicketCache.sTickets.get(next);
                    if (str2 != null) {
                        try {
                            jSONObject.put(next, str2);
                        } catch (JSONException e) {
                            AppCenterLog.error("AppCenter", "Cannot serialize tickets, sending log anonymously", e);
                        }
                    }
                }
            }
        }
        if (jSONObject.length() > 0) {
            hashMap.put("Tickets", jSONObject.toString());
            if (Constants.APPLICATION_DEBUGGABLE) {
                hashMap.put("Strict", Boolean.TRUE.toString());
            }
        }
        hashMap.put("Content-Type", "application/x-json-stream; charset=utf-8");
        hashMap.put("Client-Version", String.format("ACS-Android-Java-no-%s-no", new Object[]{"4.3.1"}));
        hashMap.put("Upload-Time", String.valueOf(System.currentTimeMillis()));
        return getServiceCall(this.mLogUrl, "POST", hashMap, new IngestionCallTemplate(this.mLogSerializer, logContainer), serviceCallback);
    }
}
