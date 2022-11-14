package com.unity3d.services.core.properties;

import android.content.Context;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.unity3d.ads.BuildConfig;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.cache.CacheDirectory;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicReference;

public class SdkProperties {
    public static final String CACHE_DIR_NAME = "UnityAdsCache";
    public static final String CHINA_ISO_ALPHA_2_CODE = "CN";
    public static final String CHINA_ISO_ALPHA_3_CODE = "CHN";
    public static final String LOCAL_CACHE_FILE_PREFIX = "UnityAdsCache-";
    public static final String LOCAL_STORAGE_FILE_PREFIX = "UnityAdsStorage-";
    public static CacheDirectory _cacheDirectory;
    public static String _configUrl;
    public static AtomicReference<InitializationState> _currentInitializationState = new AtomicReference<>(InitializationState.NOT_INITIALIZED);
    public static boolean _debugMode = false;
    public static LinkedHashSet<IUnityAdsInitializationListener> _initializationListeners = new LinkedHashSet<>();
    public static long _initializationTime;
    public static boolean _initialized = false;
    public static Configuration _latestConfiguration;
    public static boolean _reinitialized = false;
    public static boolean _testMode = false;

    public enum InitializationState {
        NOT_INITIALIZED,
        INITIALIZING,
        INITIALIZED_SUCCESSFULLY,
        INITIALIZED_FAILED
    }

    public static void addInitializationListener(IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        if (iUnityAdsInitializationListener != null) {
            synchronized (_initializationListeners) {
                _initializationListeners.add(iUnityAdsInitializationListener);
            }
        }
    }

    public static File getCacheDirectory() {
        return getCacheDirectory(ClientProperties.getApplicationContext());
    }

    public static String getCacheDirectoryName() {
        return CACHE_DIR_NAME;
    }

    public static CacheDirectory getCacheDirectoryObject() {
        return _cacheDirectory;
    }

    public static String getCacheFilePrefix() {
        return LOCAL_CACHE_FILE_PREFIX;
    }

    public static String getConfigUrl() {
        if (_configUrl == null) {
            _configUrl = getDefaultConfigUrl("release");
        }
        return _configUrl;
    }

    public static InitializationState getCurrentInitializationState() {
        return _currentInitializationState.get();
    }

    public static boolean getDebugMode() {
        return _debugMode;
    }

    public static String getDefaultConfigUrl(String str) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(isChinaLocale(Device.getNetworkCountryISO()) ? "https://config.unityads.unitychina.cn/webview/" : "https://config.unityads.unity3d.com/webview/");
        outline24.append(getWebViewBranch());
        outline24.append("/");
        outline24.append(str);
        outline24.append("/config.json");
        return outline24.toString();
    }

    public static IUnityAdsInitializationListener[] getInitializationListeners() {
        IUnityAdsInitializationListener[] iUnityAdsInitializationListenerArr;
        synchronized (_initializationListeners) {
            iUnityAdsInitializationListenerArr = new IUnityAdsInitializationListener[_initializationListeners.size()];
            _initializationListeners.toArray(iUnityAdsInitializationListenerArr);
        }
        return iUnityAdsInitializationListenerArr;
    }

    public static long getInitializationTime() {
        return _initializationTime;
    }

    public static Configuration getLatestConfiguration() {
        return _latestConfiguration;
    }

    public static String getLocalConfigurationFilepath() {
        return getCacheDirectory().getAbsolutePath() + "/UnityAdsWebViewConfiguration.json";
    }

    public static String getLocalStorageFilePrefix() {
        return LOCAL_STORAGE_FILE_PREFIX;
    }

    public static String getLocalWebViewFile() {
        return getCacheDirectory().getAbsolutePath() + "/UnityAdsWebApp.html";
    }

    public static String getLocalWebViewFileUpdated() {
        return getLocalWebViewFile() + ".new";
    }

    public static int getVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public static String getVersionName() {
        return "4.0.1";
    }

    public static String getWebViewBranch() {
        return getVersionName();
    }

    public static boolean isChinaLocale(String str) {
        return str.equalsIgnoreCase(CHINA_ISO_ALPHA_2_CODE) || str.equalsIgnoreCase(CHINA_ISO_ALPHA_3_CODE);
    }

    public static boolean isInitialized() {
        return _initialized;
    }

    public static boolean isReinitialized() {
        return _reinitialized;
    }

    public static boolean isTestMode() {
        return _testMode;
    }

    public static void notifyInitializationComplete() {
        setInitializeState(InitializationState.INITIALIZED_SUCCESSFULLY);
        for (IUnityAdsInitializationListener onInitializationComplete : getInitializationListeners()) {
            onInitializationComplete.onInitializationComplete();
        }
        resetInitializationListeners();
    }

    public static void notifyInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
        setInitializeState(InitializationState.INITIALIZED_FAILED);
        for (IUnityAdsInitializationListener onInitializationFailed : getInitializationListeners()) {
            onInitializationFailed.onInitializationFailed(unityAdsInitializationError, str);
        }
        resetInitializationListeners();
    }

    public static void resetInitializationListeners() {
        synchronized (_initializationListeners) {
            _initializationListeners.clear();
        }
    }

    public static void setCacheDirectory(CacheDirectory cacheDirectory) {
        _cacheDirectory = cacheDirectory;
    }

    public static void setConfigUrl(String str) throws URISyntaxException, MalformedURLException {
        if (str == null) {
            throw new MalformedURLException();
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            new URL(str).toURI();
            _configUrl = str;
        } else {
            throw new MalformedURLException();
        }
    }

    public static void setDebugMode(boolean z) {
        _debugMode = z;
        if (z) {
            DeviceLog.setLogLevel(8);
        } else {
            DeviceLog.setLogLevel(4);
        }
    }

    public static void setInitializationTime(long j) {
        _initializationTime = j;
    }

    public static void setInitializeState(InitializationState initializationState) {
        _currentInitializationState.set(initializationState);
    }

    public static void setInitialized(boolean z) {
        _initialized = z;
    }

    public static void setLatestConfiguration(Configuration configuration) {
        _latestConfiguration = configuration;
    }

    public static void setReinitialized(boolean z) {
        _reinitialized = z;
    }

    public static void setTestMode(boolean z) {
        _testMode = z;
    }

    public static File getCacheDirectory(Context context) {
        if (_cacheDirectory == null) {
            setCacheDirectory(new CacheDirectory(CACHE_DIR_NAME));
        }
        return _cacheDirectory.getCacheDirectory(context);
    }
}
