package com.microsoft.appcenter.ingestion;

import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.ServiceCall;
import com.microsoft.appcenter.http.ServiceCallback;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Map;

public abstract class AbstractAppCenterIngestion implements Ingestion {
    public HttpClient mHttpClient;
    public String mLogUrl;

    public AbstractAppCenterIngestion(HttpClient httpClient, String str) {
        this.mLogUrl = str;
        this.mHttpClient = httpClient;
    }

    public void close() throws IOException {
        this.mHttpClient.close();
    }

    public ServiceCall getServiceCall(String str, String str2, Map<String, String> map, HttpClient.CallTemplate callTemplate, ServiceCallback serviceCallback) {
        if (SharedPreferencesManager.getBoolean("allowedNetworkRequests", true)) {
            return this.mHttpClient.callAsync(str, str2, map, callTemplate, serviceCallback);
        }
        serviceCallback.onCallFailed(new ConnectException("SDK is in offline mode."));
        return null;
    }

    public boolean isEnabled() {
        return SharedPreferencesManager.getBoolean("allowedNetworkRequests", true);
    }

    public void reopen() {
        this.mHttpClient.reopen();
    }
}
