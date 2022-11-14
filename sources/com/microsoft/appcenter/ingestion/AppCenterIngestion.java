package com.microsoft.appcenter.ingestion;

import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.microsoft.appcenter.http.AbstractAppCallTemplate;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.ServiceCall;
import com.microsoft.appcenter.http.ServiceCallback;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONStringer;

public class AppCenterIngestion extends AbstractAppCenterIngestion {
    public final DefaultLogSerializer mLogSerializer;

    public static class IngestionCallTemplate extends AbstractAppCallTemplate {
        public final LogContainer mLogContainer;
        public final DefaultLogSerializer mLogSerializer;

        public IngestionCallTemplate(DefaultLogSerializer defaultLogSerializer, LogContainer logContainer) {
            this.mLogSerializer = defaultLogSerializer;
            this.mLogContainer = logContainer;
        }

        public String buildRequestBody() throws JSONException {
            DefaultLogSerializer defaultLogSerializer = this.mLogSerializer;
            LogContainer logContainer = this.mLogContainer;
            if (defaultLogSerializer != null) {
                JSONStringer jSONStringer = new JSONStringer();
                jSONStringer.object();
                jSONStringer.key("logs").array();
                for (Log write : logContainer.logs) {
                    jSONStringer.object();
                    write.write(jSONStringer);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
                return jSONStringer.toString();
            }
            throw null;
        }
    }

    public AppCenterIngestion(@NonNull HttpClient httpClient, @NonNull DefaultLogSerializer defaultLogSerializer) {
        super(httpClient, "https://in.appcenter.ms");
        this.mLogSerializer = defaultLogSerializer;
    }

    public ServiceCall sendAsync(String str, UUID uuid, LogContainer logContainer, ServiceCallback serviceCallback) throws IllegalArgumentException {
        HashMap hashMap = new HashMap();
        hashMap.put("Install-ID", uuid.toString());
        hashMap.put("App-Secret", str);
        return getServiceCall(GeneratedOutlineSupport.outline18(new StringBuilder(), this.mLogUrl, "/logs?api-version=1.0.0"), "POST", hashMap, new IngestionCallTemplate(this.mLogSerializer, logContainer), serviceCallback);
    }
}
