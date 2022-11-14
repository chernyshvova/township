package com.helpshift.configuration.domainmodel;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.account.domainmodel.UserManagerDM;
import com.helpshift.common.AutoRetriableDM;
import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.ETagNetwork;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GETNetwork;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.NetworkConstants;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.NetworkErrorCodes;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.common.platform.network.ResponseParser;
import com.helpshift.configuration.response.RootServerConfig;
import com.helpshift.redaction.RedactionAgent;
import com.helpshift.util.Callback;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConfigFetchDM implements AutoRetriableDM {
    public static final String TAG = "Helpshift_CnfgFtch";
    public Domain domain;
    public final AtomicBoolean isInProgress = new AtomicBoolean(false);
    public WeakReference<Callback<Void, Void>> listener;
    public Platform platform;
    public ResponseParser responseParser;
    public SDKConfigurationDM sdkConfigurationDM;

    public ConfigFetchDM(Platform platform2, Domain domain2) {
        this.platform = platform2;
        this.domain = domain2;
        this.sdkConfigurationDM = domain2.getSDKConfigurationDM();
        this.responseParser = platform2.getResponseParser();
        this.domain.getAutoRetryFailedEventDM().register(AutoRetryFailedEventDM.EventType.CONFIG, this);
    }

    /* access modifiers changed from: private */
    public void callListener(boolean z) {
        Callback callback;
        WeakReference<Callback<Void, Void>> weakReference = this.listener;
        if (weakReference != null && (callback = (Callback) weakReference.get()) != null) {
            if (z) {
                callback.onSuccess(null);
            } else {
                callback.onFailure(null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void fetchServerConfigInternal() {
        this.isInProgress.set(true);
        HSLogger.m3237d(TAG, "Fetching config.");
        UserManagerDM userManagerDM = this.domain.getUserManagerDM();
        UserDM activeUser = userManagerDM.getActiveUser();
        String str = NetworkConstants.SUPPORT_CONFIG_ROUTE;
        RootServerConfig rootServerConfig = null;
        try {
            Response makeRequest = new GuardOKNetwork(new ETagNetwork(new TSCorrectedNetwork(new FailedAPICallNetworkDecorator(new GETNetwork(str, this.domain, this.platform)), this.platform), this.platform, str)).makeRequest(new RequestData((Map<String, String>) NetworkDataRequestUtil.getUserRequestData(activeUser)));
            HSLogger.m3237d(TAG, "SDK config fetched successfully");
            rootServerConfig = this.responseParser.parseConfigResponse(makeRequest.responseString);
            this.sdkConfigurationDM.updateServerConfig(rootServerConfig);
            this.sdkConfigurationDM.updateUserConfig(activeUser, rootServerConfig, userManagerDM);
            this.sdkConfigurationDM.updateLastSuccessfulConfigFetchTime();
            HSLogger.m3237d(TAG, "SDK config data updated successfully");
            callListener(true);
        } catch (RootAPIException e) {
            if ((e.exceptionType instanceof NetworkException) && ((NetworkException) e.exceptionType).serverStatusCode == NetworkErrorCodes.CONTENT_UNCHANGED.intValue()) {
                HSLogger.m3237d(TAG, "SDK config fetched successfully, content unchanged");
                this.sdkConfigurationDM.updateLastSuccessfulConfigFetchTime();
                callListener(true);
            } else if (e.exceptionType != NetworkException.NON_RETRIABLE) {
                throw e;
            }
        } catch (Throwable th) {
            this.isInProgress.set(false);
            throw th;
        }
        this.isInProgress.set(false);
        if (rootServerConfig != null) {
            new RedactionAgent(this.platform, this.domain).checkAndUpdateRedactionState(activeUser, rootServerConfig.profileCreatedAt, rootServerConfig.lastRedactionAt);
        }
    }

    public void fetchServerConfig(final boolean z) {
        if (this.isInProgress.get()) {
            HSLogger.m3237d(TAG, "Config fetch already in progress, skipping.");
        } else {
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    try {
                        ConfigFetchDM.this.fetchServerConfigInternal();
                    } catch (RootAPIException e) {
                        if (z && e.exceptionType != NetworkException.NON_RETRIABLE) {
                            ConfigFetchDM.this.domain.getAutoRetryFailedEventDM().scheduleRetryTaskForEventType(AutoRetryFailedEventDM.EventType.CONFIG, e.getServerStatusCode());
                        }
                        ConfigFetchDM.this.callListener(false);
                        throw e;
                    }
                }
            });
        }
    }

    public boolean isFetchInProgress() {
        return this.isInProgress.get();
    }

    public void sendFailedApiCalls(AutoRetryFailedEventDM.EventType eventType) {
        if (eventType == AutoRetryFailedEventDM.EventType.CONFIG && !this.isInProgress.get() && StringUtils.isEmpty(this.platform.getNetworkRequestDAO().getETag(NetworkConstants.SUPPORT_CONFIG_ROUTE))) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Retrying failed api call for config: ");
            outline24.append(this.listener);
            HSLogger.m3237d(TAG, outline24.toString());
            fetchServerConfigInternal();
        }
    }

    public void setListener(Callback<Void, Void> callback) {
        this.listener = callback == null ? null : new WeakReference<>(callback);
    }
}
