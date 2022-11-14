package com.unity3d.services.core.configuration;

import android.annotation.TargetApi;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.api.DownloadLatestWebViewStatus;
import com.unity3d.services.core.api.Lifecycle;
import com.unity3d.services.core.cache.CacheDirectory;
import com.unity3d.services.core.connectivity.ConnectivityMonitor;
import com.unity3d.services.core.connectivity.IConnectivityListener;
import com.unity3d.services.core.lifecycle.LifecycleListener;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.SDKMetrics;
import com.unity3d.services.core.request.WebRequest;
import com.unity3d.services.core.webview.WebView;
import com.unity3d.services.core.webview.WebViewApp;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class InitializeThread extends Thread {
    public static InitializeThread _thread;
    public InitializeState _state;
    public boolean _stopThread = false;

    public static abstract class InitializeState {
        public InitializeState() {
        }

        public abstract InitializeState execute();
    }

    public static class InitializeStateCheckForCachedWebViewUpdate extends InitializeState {
        public Configuration _configuration;

        public InitializeStateCheckForCachedWebViewUpdate(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public InitializeState execute() {
            try {
                byte[] access$100 = InitializeThread.loadCachedFileToByteArray(new File(SdkProperties.getLocalWebViewFile()));
                if (Utilities.Sha256(access$100).equals(this._configuration.getWebViewHash())) {
                    return new InitializeStateUpdateCache(this._configuration, new String(access$100, "UTF-8"));
                }
            } catch (Exception unused) {
            }
            return new InitializeStateDownloadWebView(this._configuration);
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }
    }

    public static class InitializeStateCheckForUpdatedWebView extends InitializeState {
        public Configuration _configuration;
        public Configuration _localWebViewConfiguration;
        public byte[] _localWebViewData;

        public InitializeStateCheckForUpdatedWebView(Configuration configuration, byte[] bArr, Configuration configuration2) {
            super();
            this._configuration = configuration;
            this._localWebViewData = bArr;
            this._localWebViewConfiguration = configuration2;
        }

        public InitializeState execute() {
            try {
                String Sha256 = Utilities.Sha256(this._localWebViewData);
                if (!Sha256.equals(this._configuration.getWebViewHash())) {
                    SdkProperties.setLatestConfiguration(this._configuration);
                }
                if (!TextUtils.isEmpty(Sha256)) {
                    if (this._localWebViewConfiguration != null) {
                        if (this._localWebViewConfiguration.getWebViewHash() != null && this._localWebViewConfiguration.getWebViewHash().equals(Sha256) && SdkProperties.getVersionName().equals(this._localWebViewConfiguration.getSdkVersion())) {
                            return new InitializeStateCreate(this._localWebViewConfiguration, new String(this._localWebViewData, "UTF-8"));
                        }
                    }
                    if (this._configuration != null && this._configuration.getWebViewHash().equals(Sha256)) {
                        return new InitializeStateCreate(this._configuration, new String(this._localWebViewData, "UTF-8"));
                    }
                }
            } catch (Exception unused) {
            }
            return new InitializeStateCleanCache(this._configuration, new InitializeStateLoadWeb(this._configuration));
        }
    }

    public static class InitializeStateCleanCache extends InitializeState {
        public Configuration _configuration;
        public InitializeState _nextState;

        public InitializeStateCleanCache(Configuration configuration, InitializeState initializeState) {
            super();
            this._configuration = configuration;
            this._nextState = initializeState;
        }

        public InitializeState execute() {
            try {
                File file = new File(SdkProperties.getLocalConfigurationFilepath());
                File file2 = new File(SdkProperties.getLocalWebViewFile());
                file.delete();
                file2.delete();
            } catch (Exception e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failure trying to clean cache: ");
                outline24.append(e.getMessage());
                DeviceLog.error(outline24.toString());
            }
            return this._nextState;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }
    }

    public static class InitializeStateCleanCacheIgnoreError extends InitializeStateCleanCache {
        public InitializeStateCleanCacheIgnoreError(Configuration configuration, InitializeState initializeState) {
            super(configuration, initializeState);
        }

        public InitializeState execute() {
            try {
                InitializeState execute = super.execute();
                if (!(execute instanceof InitializeStateError)) {
                    return execute;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class InitializeStateComplete extends InitializeState {
        public Configuration _configuration;

        public InitializeStateComplete(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public InitializeState execute() {
            for (String moduleConfiguration : this._configuration.getModuleConfigurationList()) {
                IModuleConfiguration moduleConfiguration2 = this._configuration.getModuleConfiguration(moduleConfiguration);
                if (moduleConfiguration2 != null) {
                    moduleConfiguration2.initCompleteState(this._configuration);
                }
            }
            return null;
        }
    }

    public static class InitializeStateConfig extends InitializeState {
        public Configuration _configuration = new Configuration(SdkProperties.getConfigUrl());
        public Configuration _localConfig;
        public int _maxRetries;
        public int _retries = 0;
        public long _retryDelay;
        public double _scalingFactor;

        public InitializeStateConfig(Configuration configuration) {
            super();
            this._retryDelay = configuration.getRetryDelay();
            this._maxRetries = configuration.getMaxRetries();
            this._scalingFactor = configuration.getRetryScalingFactor();
            this._localConfig = configuration;
        }

        public InitializeState execute() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unity Ads init: load configuration from ");
            outline24.append(SdkProperties.getConfigUrl());
            DeviceLog.info(outline24.toString());
            try {
                this._configuration.makeRequest();
                if (this._configuration.getDelayWebViewUpdate()) {
                    return new InitializeStateLoadCacheConfigAndWebView(this._configuration, this._localConfig);
                }
                return new InitializeStateLoadCache(this._configuration);
            } catch (Exception e) {
                int i = this._retries;
                if (i >= this._maxRetries) {
                    return new InitializeStateNetworkError("network config request", e, this, this._localConfig);
                }
                double d = (double) this._retryDelay;
                double d2 = this._scalingFactor;
                Double.isNaN(d);
                long j = (long) (d * d2);
                this._retryDelay = j;
                this._retries = i + 1;
                return new InitializeStateRetry(this, j);
            }
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }
    }

    public static class InitializeStateCreate extends InitializeState {
        public static final String InitializeStateCreateStateName = "create webapp";
        public Configuration _configuration;
        public String _webViewData;

        public InitializeStateCreate(Configuration configuration, String str) {
            super();
            this._configuration = configuration;
            this._webViewData = str;
        }

        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: creating webapp");
            Configuration configuration = this._configuration;
            configuration.setWebViewData(this._webViewData);
            try {
                if (WebViewApp.create(configuration)) {
                    return new InitializeStateComplete(this._configuration);
                }
                String webAppFailureMessage = WebViewApp.getCurrentApp().getWebAppFailureMessage() != null ? WebViewApp.getCurrentApp().getWebAppFailureMessage() : "Unity Ads WebApp creation failed";
                DeviceLog.error(webAppFailureMessage);
                return new InitializeStateError(InitializeStateCreateStateName, new Exception(webAppFailureMessage), this._configuration);
            } catch (IllegalThreadStateException e) {
                DeviceLog.exception("Illegal Thread", e);
                return new InitializeStateError(InitializeStateCreateStateName, e, this._configuration);
            }
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        public String getWebData() {
            return this._webViewData;
        }
    }

    public static class InitializeStateDownloadWebView extends InitializeState {
        public Configuration _configuration;
        public int _retries = 0;
        public long _retryDelay;

        public InitializeStateDownloadWebView(Configuration configuration) {
            super();
            this._configuration = configuration;
            this._retryDelay = configuration.getRetryDelay();
        }

        public InitializeState execute() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unity Ads init: downloading webapp from ");
            outline24.append(this._configuration.getWebViewUrl());
            DeviceLog.info(outline24.toString());
            try {
                try {
                    String makeRequest = new WebRequest(this._configuration.getWebViewUrl(), "GET", (Map<String, List<String>>) null).makeRequest();
                    String webViewHash = this._configuration.getWebViewHash();
                    if (makeRequest == null || webViewHash == null || !Utilities.Sha256(makeRequest).equals(webViewHash)) {
                        return null;
                    }
                    return new InitializeStateUpdateCache(this._configuration, makeRequest);
                } catch (Exception unused) {
                    if (this._retries >= this._configuration.getMaxRetries()) {
                        return null;
                    }
                    double d = (double) this._retryDelay;
                    double retryScalingFactor = this._configuration.getRetryScalingFactor();
                    Double.isNaN(d);
                    long j = (long) (retryScalingFactor * d);
                    this._retryDelay = j;
                    this._retries++;
                    return new InitializeStateRetry(this, j);
                }
            } catch (Exception e) {
                DeviceLog.exception("Malformed URL", e);
                return null;
            }
        }
    }

    public static class InitializeStateError extends InitializeState {
        public Configuration _configuration;
        public Exception _exception;
        public String _state;

        public InitializeStateError(String str, Exception exc, Configuration configuration) {
            super();
            this._state = str;
            this._exception = exc;
            this._configuration = configuration;
        }

        public InitializeState execute() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unity Ads init: halting init in ");
            outline24.append(this._state);
            outline24.append(": ");
            outline24.append(this._exception.getMessage());
            DeviceLog.error(outline24.toString());
            for (String moduleConfiguration : this._configuration.getModuleConfigurationList()) {
                IModuleConfiguration moduleConfiguration2 = this._configuration.getModuleConfiguration(moduleConfiguration);
                if (moduleConfiguration2 != null) {
                    moduleConfiguration2.initErrorState(this._configuration, this._state, this._exception.getMessage());
                }
            }
            SDKMetrics.getInstance().sendEventWithTags("native_initialization_failed", new HashMap<String, String>() {
                {
                    put("stt", InitializeStateError.this._state.replaceAll(" ", "_"));
                }
            });
            return null;
        }
    }

    public static class InitializeStateForceReset extends InitializeStateReset {
        public InitializeStateForceReset() {
            super(new Configuration());
        }

        public InitializeState execute() {
            SdkProperties.setInitializeState(SdkProperties.InitializationState.NOT_INITIALIZED);
            super.execute();
            return null;
        }
    }

    public static class InitializeStateInitModules extends InitializeState {
        public static final String InitializeStateInitModuleStateName = "init modules";
        public Configuration _configuration;

        public InitializeStateInitModules(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public InitializeState execute() {
            for (String moduleConfiguration : this._configuration.getModuleConfigurationList()) {
                IModuleConfiguration moduleConfiguration2 = this._configuration.getModuleConfiguration(moduleConfiguration);
                if (moduleConfiguration2 != null && !moduleConfiguration2.initModuleState(this._configuration)) {
                    return new InitializeStateError(InitializeStateInitModuleStateName, new Exception("Unity Ads config server resolves to loopback address (due to ad blocker?)"), this._configuration);
                }
            }
            return new InitializeStateConfig(this._configuration);
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }
    }

    public static class InitializeStateLoadCache extends InitializeState {
        public Configuration _configuration;

        public InitializeStateLoadCache(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: check if webapp can be loaded from local cache");
            try {
                byte[] readFileBytes = Utilities.readFileBytes(new File(SdkProperties.getLocalWebViewFile()));
                String Sha256 = Utilities.Sha256(readFileBytes);
                if (Sha256 == null || !Sha256.equals(this._configuration.getWebViewHash())) {
                    return new InitializeStateLoadWeb(this._configuration);
                }
                try {
                    String str = new String(readFileBytes, "UTF-8");
                    DeviceLog.info("Unity Ads init: webapp loaded from local cache");
                    return new InitializeStateCreate(this._configuration, str);
                } catch (Exception e) {
                    return new InitializeStateError("load cache", e, this._configuration);
                }
            } catch (Exception e2) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unity Ads init: webapp not found in local cache: ");
                outline24.append(e2.getMessage());
                DeviceLog.debug(outline24.toString());
                return new InitializeStateLoadWeb(this._configuration);
            }
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }
    }

    public static class InitializeStateLoadCacheConfigAndWebView extends InitializeState {
        public Configuration _configuration;
        public Configuration _localConfig;

        public InitializeStateLoadCacheConfigAndWebView(Configuration configuration, Configuration configuration2) {
            super();
            this._configuration = configuration;
            this._localConfig = configuration2;
        }

        public InitializeState execute() {
            try {
                return new InitializeStateCheckForUpdatedWebView(this._configuration, InitializeThread.loadCachedFileToByteArray(new File(SdkProperties.getLocalWebViewFile())), this._localConfig);
            } catch (Exception unused) {
                return new InitializeStateCleanCache(this._configuration, new InitializeStateLoadWeb(this._configuration));
            }
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }
    }

    public static class InitializeStateLoadConfigFile extends InitializeState {
        public Configuration _configuration;

        public InitializeStateLoadConfigFile(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: Loading Config File Parameters");
            File file = new File(SdkProperties.getLocalConfigurationFilepath());
            if (!file.exists()) {
                return new InitializeStateReset(this._configuration);
            }
            try {
                Configuration configuration = new Configuration(new JSONObject(new String(Utilities.readFileBytes(file))));
                if (SdkProperties.getVersionName().equals(configuration.getSdkVersion())) {
                    this._configuration = configuration;
                }
                return new InitializeStateReset(this._configuration);
            } catch (Exception unused) {
                DeviceLog.debug("Unity Ads init: Using default configuration parameters");
                return new InitializeStateReset(this._configuration);
            } catch (Throwable unused2) {
                return new InitializeStateReset(this._configuration);
            }
        }
    }

    public static class InitializeStateLoadWeb extends InitializeState {
        public Configuration _configuration;
        public int _maxRetries;
        public int _retries = 0;
        public long _retryDelay;
        public double _scalingFactor;

        public InitializeStateLoadWeb(Configuration configuration) {
            super();
            this._configuration = configuration;
            this._retryDelay = configuration.getRetryDelay();
            this._maxRetries = configuration.getMaxRetries();
            this._scalingFactor = configuration.getRetryScalingFactor();
        }

        public InitializeState execute() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unity Ads init: loading webapp from ");
            outline24.append(this._configuration.getWebViewUrl());
            DeviceLog.info(outline24.toString());
            try {
                try {
                    String makeRequest = new WebRequest(this._configuration.getWebViewUrl(), "GET", (Map<String, List<String>>) null).makeRequest();
                    String webViewHash = this._configuration.getWebViewHash();
                    if (webViewHash != null && !Utilities.Sha256(makeRequest).equals(webViewHash)) {
                        return new InitializeStateError("invalid hash", new Exception("Invalid webViewHash"), this._configuration);
                    }
                    if (webViewHash != null) {
                        Utilities.writeFile(new File(SdkProperties.getLocalWebViewFile()), makeRequest);
                    }
                    return new InitializeStateCreate(this._configuration, makeRequest);
                } catch (Exception e) {
                    int i = this._retries;
                    if (i >= this._maxRetries) {
                        return new InitializeStateNetworkError("network webview request", e, this, this._configuration);
                    }
                    double d = (double) this._retryDelay;
                    double d2 = this._scalingFactor;
                    Double.isNaN(d);
                    long j = (long) (d * d2);
                    this._retryDelay = j;
                    this._retries = i + 1;
                    return new InitializeStateRetry(this, j);
                }
            } catch (MalformedURLException e2) {
                DeviceLog.exception("Malformed URL", e2);
                return new InitializeStateError("malformed webview request", e2, this._configuration);
            }
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }
    }

    public static class InitializeStateNetworkError extends InitializeStateError implements IConnectivityListener {
        public static long _lastConnectedEventTimeMs;
        public static int _receivedConnectedEvents;
        public ConditionVariable _conditionVariable;
        public int _connectedEventThreshold;
        public InitializeState _erroredState;
        public int _maximumConnectedEvents;
        public long _networkErrorTimeout;
        public String _state;

        public InitializeStateNetworkError(String str, Exception exc, InitializeState initializeState, Configuration configuration) {
            super(str, exc, configuration);
            this._state = str;
            _receivedConnectedEvents = 0;
            _lastConnectedEventTimeMs = 0;
            this._erroredState = initializeState;
            this._networkErrorTimeout = configuration.getNetworkErrorTimeout();
            this._maximumConnectedEvents = configuration.getMaximumConnectedEvents();
            this._connectedEventThreshold = configuration.getConnectedEventThreshold();
        }

        private boolean shouldHandleConnectedEvent() {
            return System.currentTimeMillis() - _lastConnectedEventTimeMs >= ((long) this._connectedEventThreshold) && _receivedConnectedEvents <= this._maximumConnectedEvents;
        }

        public InitializeState execute() {
            DeviceLog.error("Unity Ads init: network error, waiting for connection events");
            this._conditionVariable = new ConditionVariable();
            ConnectivityMonitor.addListener(this);
            if (this._conditionVariable.block(this._networkErrorTimeout)) {
                ConnectivityMonitor.removeListener(this);
                return this._erroredState;
            }
            ConnectivityMonitor.removeListener(this);
            return new InitializeStateError(this._state, new Exception("No connected events within the timeout!"), this._configuration);
        }

        public void onConnected() {
            _receivedConnectedEvents++;
            DeviceLog.debug("Unity Ads init got connected event");
            if (shouldHandleConnectedEvent()) {
                this._conditionVariable.open();
            }
            if (_receivedConnectedEvents > this._maximumConnectedEvents) {
                ConnectivityMonitor.removeListener(this);
            }
            _lastConnectedEventTimeMs = System.currentTimeMillis();
        }

        public void onDisconnected() {
            DeviceLog.debug("Unity Ads init got disconnected event");
        }
    }

    public static class InitializeStateReset extends InitializeState {
        public Configuration _configuration;
        public int _resetWebAppTimeout;

        public InitializeStateReset(Configuration configuration) {
            super();
            this._configuration = configuration;
            this._resetWebAppTimeout = configuration.getResetWebappTimeout();
        }

        @TargetApi(14)
        private void unregisterLifecycleCallbacks() {
            if (Lifecycle.getLifecycleListener() != null) {
                if (ClientProperties.getApplication() != null) {
                    ClientProperties.getApplication().unregisterActivityLifecycleCallbacks(Lifecycle.getLifecycleListener());
                }
                Lifecycle.setLifecycleListener((LifecycleListener) null);
            }
        }

        public InitializeState execute() {
            boolean z;
            DeviceLog.debug("Unity Ads init: starting init");
            final ConditionVariable conditionVariable = new ConditionVariable();
            final WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null) {
                currentApp.resetWebViewAppInitialization();
                if (currentApp.getWebView() != null) {
                    Utilities.runOnUiThread(new Runnable() {
                        public void run() {
                            currentApp.getWebView().destroy();
                            currentApp.setWebView((WebView) null);
                            conditionVariable.open();
                        }
                    });
                    z = conditionVariable.block((long) this._resetWebAppTimeout);
                } else {
                    z = true;
                }
                if (!z) {
                    return new InitializeStateError("reset webapp", new Exception("Reset failed on opening ConditionVariable"), this._configuration);
                }
            }
            unregisterLifecycleCallbacks();
            SdkProperties.setCacheDirectory((CacheDirectory) null);
            if (SdkProperties.getCacheDirectory() == null) {
                return new InitializeStateError("reset webapp", new Exception("Cache directory is NULL"), this._configuration);
            }
            SdkProperties.setInitialized(false);
            for (String moduleConfiguration : this._configuration.getModuleConfigurationList()) {
                IModuleConfiguration moduleConfiguration2 = this._configuration.getModuleConfiguration(moduleConfiguration);
                if (moduleConfiguration2 != null) {
                    moduleConfiguration2.resetState(this._configuration);
                }
            }
            return new InitializeStateInitModules(this._configuration);
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }
    }

    public static class InitializeStateRetry extends InitializeState {
        public long _delay;
        public InitializeState _state;

        public InitializeStateRetry(InitializeState initializeState, long j) {
            super();
            this._state = initializeState;
            this._delay = j;
        }

        public InitializeState execute() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unity Ads init: retrying in ");
            outline24.append(this._delay);
            outline24.append(" milliseconds");
            DeviceLog.debug(outline24.toString());
            try {
                Thread.sleep(this._delay);
            } catch (Exception e) {
                DeviceLog.exception("Init retry interrupted", e);
            }
            return this._state;
        }
    }

    public static class InitializeStateUpdateCache extends InitializeState {
        public Configuration _configuration;
        public String _webViewData;

        public InitializeStateUpdateCache(Configuration configuration, String str) {
            super();
            this._configuration = configuration;
            this._webViewData = str;
        }

        public InitializeState execute() {
            if (!(this._configuration == null || this._webViewData == null)) {
                try {
                    Utilities.writeFile(new File(SdkProperties.getLocalWebViewFile()), this._webViewData);
                    Utilities.writeFile(new File(SdkProperties.getLocalConfigurationFilepath()), this._configuration.getJSONString());
                } catch (Exception unused) {
                    return new InitializeStateCleanCacheIgnoreError(this._configuration, (InitializeState) null);
                }
            }
            return null;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }
    }

    public InitializeThread(InitializeState initializeState) {
        this._state = initializeState;
    }

    public static synchronized DownloadLatestWebViewStatus downloadLatestWebView() {
        synchronized (InitializeThread.class) {
            if (_thread != null) {
                DownloadLatestWebViewStatus downloadLatestWebViewStatus = DownloadLatestWebViewStatus.INIT_QUEUE_NOT_EMPTY;
                return downloadLatestWebViewStatus;
            } else if (SdkProperties.getLatestConfiguration() == null) {
                DownloadLatestWebViewStatus downloadLatestWebViewStatus2 = DownloadLatestWebViewStatus.MISSING_LATEST_CONFIG;
                return downloadLatestWebViewStatus2;
            } else {
                InitializeThread initializeThread = new InitializeThread(new InitializeStateCheckForCachedWebViewUpdate(SdkProperties.getLatestConfiguration()));
                _thread = initializeThread;
                initializeThread.setName("UnityAdsDownloadThread");
                _thread.start();
                DownloadLatestWebViewStatus downloadLatestWebViewStatus3 = DownloadLatestWebViewStatus.BACKGROUND_DOWNLOAD_STARTED;
                return downloadLatestWebViewStatus3;
            }
        }
    }

    public static synchronized void initialize(Configuration configuration) {
        synchronized (InitializeThread.class) {
            if (_thread == null) {
                InitializeThread initializeThread = new InitializeThread(new InitializeStateLoadConfigFile(configuration));
                _thread = initializeThread;
                initializeThread.setName("UnityAdsInitializeThread");
                _thread.start();
            }
        }
    }

    public static byte[] loadCachedFileToByteArray(File file) throws IOException {
        if (file == null || !file.exists()) {
            throw new IOException("file not found");
        }
        try {
            return Utilities.readFileBytes(file);
        } catch (IOException unused) {
            throw new IOException("could not read from file");
        }
    }

    public static synchronized void reset() {
        synchronized (InitializeThread.class) {
            if (_thread == null) {
                InitializeThread initializeThread = new InitializeThread(new InitializeStateForceReset());
                _thread = initializeThread;
                initializeThread.setName("UnityAdsResetThread");
                _thread.start();
            }
        }
    }

    public void quit() {
        this._stopThread = true;
    }

    public void run() {
        while (this._state != null && !this._stopThread) {
            try {
                try {
                    this._state = this._state.execute();
                } catch (Exception e) {
                    DeviceLog.exception("Unity Ads SDK encountered an error during initialization, cancel initialization", e);
                    Utilities.runOnUiThread(new Runnable() {
                        public void run() {
                            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK encountered an error during initialization, cancel initialization");
                        }
                    });
                    this._state = new InitializeStateForceReset();
                } catch (OutOfMemoryError e2) {
                    DeviceLog.exception("Unity Ads SDK failed to initialize due to application doesn't have enough memory to initialize Unity Ads SDK", new Exception(e2));
                    Utilities.runOnUiThread(new Runnable() {
                        public void run() {
                            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to application doesn't have enough memory to initialize Unity Ads SDK");
                        }
                    });
                    this._state = new InitializeStateForceReset();
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        _thread = null;
    }
}
