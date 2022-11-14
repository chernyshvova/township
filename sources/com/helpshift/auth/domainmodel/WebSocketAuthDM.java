package com.helpshift.auth.domainmodel;

import com.helpshift.auth.dto.WebSocketAuthData;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.GETNetwork;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.KVStore;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.ResponseParser;
import com.helpshift.util.HSLogger;
import java.util.HashMap;
import java.util.Map;

public class WebSocketAuthDM {
    public static final String TAG = "Helpshift_WebSocketAuthDM";
    public static final String WEBSOCKET_AUTH_DATA = "websocket_auth_data";
    public WebSocketAuthData cachedAuthData;
    public Domain domain;
    public final Object fetchSyncObject = new Object();
    public KVStore kvStore;
    public Platform platform;
    public ResponseParser responseParser;

    public WebSocketAuthDM(Domain domain2, Platform platform2) {
        this.domain = domain2;
        this.platform = platform2;
        this.responseParser = platform2.getResponseParser();
        this.kvStore = platform2.getKVStore();
    }

    private WebSocketAuthData fetchNewTokenInternal() {
        WebSocketAuthData webSocketAuthData;
        synchronized (this.fetchSyncObject) {
            HSLogger.m3237d(TAG, "Fetching auth token");
            webSocketAuthData = null;
            try {
                webSocketAuthData = this.responseParser.parseAuthToken(new GuardOKNetwork(new GETNetwork("/ws-config/", this.domain, this.platform)).makeRequest(getRequestData()).responseString);
                HSLogger.m3237d(TAG, "Auth token fetch successful");
            } catch (RootAPIException e) {
                HSLogger.m3242e(TAG, "Exception in fetching auth token", e);
            }
        }
        return webSocketAuthData;
    }

    private RequestData getRequestData() {
        HashMap hashMap = new HashMap();
        hashMap.put("platform-id", this.platform.getAppId());
        return new RequestData((Map<String, String>) hashMap);
    }

    public WebSocketAuthData getAuthToken() {
        if (this.cachedAuthData == null) {
            Object serializable = this.kvStore.getSerializable(WEBSOCKET_AUTH_DATA);
            if (serializable instanceof WebSocketAuthData) {
                this.cachedAuthData = (WebSocketAuthData) serializable;
            }
        }
        if (this.cachedAuthData == null) {
            WebSocketAuthData fetchNewTokenInternal = fetchNewTokenInternal();
            this.cachedAuthData = fetchNewTokenInternal;
            this.kvStore.setSerializable(WEBSOCKET_AUTH_DATA, fetchNewTokenInternal);
        }
        return this.cachedAuthData;
    }

    public WebSocketAuthData refreshAuthToken() {
        WebSocketAuthData fetchNewTokenInternal = fetchNewTokenInternal();
        this.cachedAuthData = fetchNewTokenInternal;
        this.kvStore.setSerializable(WEBSOCKET_AUTH_DATA, fetchNewTokenInternal);
        return this.cachedAuthData;
    }
}
