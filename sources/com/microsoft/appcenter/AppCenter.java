package com.microsoft.appcenter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.DefaultChannel;
import com.microsoft.appcenter.channel.OneCollectorChannelListener;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.HttpUtils;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.StartServiceLog;
import com.microsoft.appcenter.ingestion.models.json.CustomPropertiesLogFactory;
import com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.ingestion.models.json.StartServiceLogFactory;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.ApplicationLifecycleListener;
import com.microsoft.appcenter.utils.InstrumentationRegistryHelper;
import com.microsoft.appcenter.utils.NetworkStateHelper;
import com.microsoft.appcenter.utils.context.SessionContext;
import com.microsoft.appcenter.utils.storage.FileManager;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import com.vungle.warren.CleverCacheSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppCenter {
    @SuppressLint({"StaticFieldLeak"})
    public static AppCenter sInstance;
    public AppCenterHandler mAppCenterHandler;
    public String mAppSecret;
    public Application mApplication;
    public ApplicationLifecycleListener mApplicationLifecycleListener;
    public Channel mChannel;
    public boolean mConfiguredFromApp;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public boolean mLogLevelConfigured;
    public DefaultLogSerializer mLogSerializer;
    public long mMaxStorageSizeInBytes = 10485760;
    public OneCollectorChannelListener mOneCollectorChannelListener;
    public Set<AppCenterService> mServices;
    public Set<AppCenterService> mServicesStartedFromLibrary;
    public final List<String> mStartedServicesNamesToLog = new ArrayList();
    public String mTransmissionTargetToken;
    public UncaughtExceptionHandler mUncaughtExceptionHandler;

    public static synchronized AppCenter getInstance() {
        AppCenter appCenter;
        synchronized (AppCenter.class) {
            if (sInstance == null) {
                sInstance = new AppCenter();
            }
            appCenter = sInstance;
        }
        return appCenter;
    }

    public final void configureAndStartServices(Application application, String str, final boolean z, Class<? extends AppCenterService>[] clsArr) {
        int i;
        boolean z2;
        synchronized (this) {
            if (application == null) {
                AppCenterLog.error("AppCenter", "Application context may not be null.");
            } else {
                if (!this.mLogLevelConfigured && (application.getApplicationInfo().flags & 2) == 2) {
                    AppCenterLog.sLogLevel = 5;
                }
                String str2 = this.mAppSecret;
                if (!z || configureSecretString(str)) {
                    if (this.mHandler == null) {
                        this.mApplication = application;
                        HandlerThread handlerThread = new HandlerThread("AppCenter.Looper");
                        this.mHandlerThread = handlerThread;
                        handlerThread.start();
                        this.mHandler = new Handler(this.mHandlerThread.getLooper());
                        this.mAppCenterHandler = new AppCenterHandler() {
                            /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
                                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
                                	at java.base/java.util.Objects.checkIndex(Objects.java:372)
                                	at java.base/java.util.ArrayList.get(ArrayList.java:458)
                                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
                                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
                                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                                	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
                                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                                	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
                                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
                                */
                            public void post(@androidx.annotation.NonNull java.lang.Runnable r5, java.lang.Runnable r6) {
                                /*
                                    r4 = this;
                                    com.microsoft.appcenter.AppCenter r0 = com.microsoft.appcenter.AppCenter.this
                                    monitor-enter(r0)
                                    monitor-enter(r0)     // Catch:{ all -> 0x003c }
                                    monitor-enter(r0)     // Catch:{ all -> 0x0039 }
                                    android.app.Application r1 = r0.mApplication     // Catch:{ all -> 0x0036 }
                                    r2 = 1
                                    r3 = 0
                                    if (r1 == 0) goto L_0x000d
                                    r1 = 1
                                    goto L_0x000e
                                L_0x000d:
                                    r1 = 0
                                L_0x000e:
                                    monitor-exit(r0)     // Catch:{ all -> 0x0039 }
                                    if (r1 == 0) goto L_0x0013
                                    monitor-exit(r0)     // Catch:{ all -> 0x003c }
                                    goto L_0x001c
                                L_0x0013:
                                    java.lang.String r1 = "AppCenter"
                                    java.lang.String r2 = "App Center hasn't been configured. You need to call AppCenter.start with appSecret or AppCenter.configure first."
                                    com.microsoft.appcenter.utils.AppCenterLog.error(r1, r2)     // Catch:{ all -> 0x0039 }
                                    monitor-exit(r0)     // Catch:{ all -> 0x003c }
                                    r2 = 0
                                L_0x001c:
                                    if (r2 == 0) goto L_0x0034
                                    com.microsoft.appcenter.AppCenter$7 r1 = new com.microsoft.appcenter.AppCenter$7     // Catch:{ all -> 0x003c }
                                    r1.<init>(r5, r6)     // Catch:{ all -> 0x003c }
                                    java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003c }
                                    android.os.HandlerThread r2 = r0.mHandlerThread     // Catch:{ all -> 0x003c }
                                    if (r6 != r2) goto L_0x002f
                                    r5.run()     // Catch:{ all -> 0x003c }
                                    goto L_0x0034
                                L_0x002f:
                                    android.os.Handler r5 = r0.mHandler     // Catch:{ all -> 0x003c }
                                    r5.post(r1)     // Catch:{ all -> 0x003c }
                                L_0x0034:
                                    monitor-exit(r0)
                                    return
                                L_0x0036:
                                    r5 = move-exception
                                    monitor-exit(r0)     // Catch:{ all -> 0x0039 }
                                    throw r5     // Catch:{ all -> 0x0039 }
                                L_0x0039:
                                    r5 = move-exception
                                    monitor-exit(r0)     // Catch:{ all -> 0x003c }
                                    throw r5     // Catch:{ all -> 0x003c }
                                L_0x003c:
                                    r5 = move-exception
                                    monitor-exit(r0)
                                    throw r5
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.AppCenter.C29315.post(java.lang.Runnable, java.lang.Runnable):void");
                            }
                        };
                        ApplicationLifecycleListener applicationLifecycleListener = new ApplicationLifecycleListener(this.mHandler);
                        this.mApplicationLifecycleListener = applicationLifecycleListener;
                        this.mApplication.registerActivityLifecycleCallbacks(applicationLifecycleListener);
                        this.mServices = new HashSet();
                        this.mServicesStartedFromLibrary = new HashSet();
                        this.mHandler.post(new Runnable() {
                            public void run() {
                                AppCenter appCenter = AppCenter.this;
                                boolean z = z;
                                Application application = appCenter.mApplication;
                                if (application != null) {
                                    try {
                                        Constants.FILES_PATH = application.getFilesDir().getAbsolutePath();
                                    } catch (Exception e) {
                                        AppCenterLog.error("AppCenter", "Exception thrown when accessing the application filesystem", e);
                                    }
                                }
                                if (!(application == null || application.getApplicationInfo() == null)) {
                                    Constants.APPLICATION_DEBUGGABLE = (application.getApplicationInfo().flags & 2) > 0;
                                }
                                Application application2 = appCenter.mApplication;
                                synchronized (FileManager.class) {
                                    if (FileManager.sContext == null) {
                                        FileManager.sContext = application2;
                                    }
                                }
                                Application application3 = appCenter.mApplication;
                                synchronized (SharedPreferencesManager.class) {
                                    if (SharedPreferencesManager.sContext == null) {
                                        SharedPreferencesManager.sContext = application3;
                                        SharedPreferencesManager.sSharedPreferences = application3.getSharedPreferences("AppCenter", 0);
                                    }
                                }
                                SessionContext.getInstance();
                                boolean isInstanceEnabled = appCenter.isInstanceEnabled();
                                HttpClient createHttpClient = HttpUtils.createHttpClient(appCenter.mApplication);
                                DefaultLogSerializer defaultLogSerializer = new DefaultLogSerializer();
                                appCenter.mLogSerializer = defaultLogSerializer;
                                defaultLogSerializer.mLogFactories.put("startService", new StartServiceLogFactory());
                                appCenter.mLogSerializer.mLogFactories.put("customProperties", new CustomPropertiesLogFactory());
                                DefaultChannel defaultChannel = new DefaultChannel(appCenter.mApplication, appCenter.mAppSecret, appCenter.mLogSerializer, createHttpClient, appCenter.mHandler);
                                appCenter.mChannel = defaultChannel;
                                if (z) {
                                    defaultChannel.setMaxStorageSize(appCenter.mMaxStorageSizeInBytes);
                                } else {
                                    defaultChannel.setMaxStorageSize(10485760);
                                }
                                DefaultChannel defaultChannel2 = (DefaultChannel) appCenter.mChannel;
                                if (defaultChannel2.mEnabled != isInstanceEnabled) {
                                    if (isInstanceEnabled) {
                                        defaultChannel2.mEnabled = true;
                                        defaultChannel2.mDiscardLogs = false;
                                        defaultChannel2.mCurrentState++;
                                        for (Ingestion reopen : defaultChannel2.mIngestions) {
                                            reopen.reopen();
                                        }
                                        for (DefaultChannel.GroupState checkPendingLogs : defaultChannel2.mGroupStates.values()) {
                                            defaultChannel2.checkPendingLogs(checkPendingLogs);
                                        }
                                    } else {
                                        defaultChannel2.mEnabled = false;
                                        defaultChannel2.suspend(true, new CancellationException());
                                    }
                                    for (Channel.Listener onGloballyEnabled : defaultChannel2.mListeners) {
                                        onGloballyEnabled.onGloballyEnabled(isInstanceEnabled);
                                    }
                                }
                                ((DefaultChannel) appCenter.mChannel).addGroup("group_core", 50, 3000, 3, (Ingestion) null, (Channel.GroupListener) null);
                                OneCollectorChannelListener oneCollectorChannelListener = new OneCollectorChannelListener(appCenter.mChannel, appCenter.mLogSerializer, createHttpClient, zzam.getInstallId());
                                appCenter.mOneCollectorChannelListener = oneCollectorChannelListener;
                                ((DefaultChannel) appCenter.mChannel).mListeners.add(oneCollectorChannelListener);
                                if (!isInstanceEnabled) {
                                    NetworkStateHelper.getSharedInstance(appCenter.mApplication).close();
                                }
                                UncaughtExceptionHandler uncaughtExceptionHandler = new UncaughtExceptionHandler(appCenter.mHandler, appCenter.mChannel);
                                appCenter.mUncaughtExceptionHandler = uncaughtExceptionHandler;
                                if (isInstanceEnabled) {
                                    uncaughtExceptionHandler.mDefaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                                    Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                                }
                                AppCenterLog.debug("AppCenter", "App Center initialized.");
                            }
                        });
                        AppCenterLog.info("AppCenter", "App Center SDK configured successfully.");
                    } else if (this.mAppSecret != null && !this.mAppSecret.equals(str2)) {
                        this.mHandler.post(new Runnable() {
                            public void run() {
                                AppCenter appCenter = AppCenter.this;
                                DefaultChannel defaultChannel = (DefaultChannel) appCenter.mChannel;
                                defaultChannel.mAppSecret = appCenter.mAppSecret;
                                if (defaultChannel.mEnabled) {
                                    for (DefaultChannel.GroupState next : defaultChannel.mGroupStates.values()) {
                                        if (next.mIngestion == defaultChannel.mIngestion) {
                                            defaultChannel.checkPendingLogs(next);
                                        }
                                    }
                                }
                                AppCenter appCenter2 = AppCenter.this;
                                ((DefaultChannel) appCenter2.mChannel).setMaxStorageSize(appCenter2.mMaxStorageSizeInBytes);
                            }
                        });
                    }
                    z2 = true;
                }
            }
            z2 = false;
        }
        if (z2) {
            synchronized (this) {
                if (clsArr == null) {
                    AppCenterLog.error("AppCenter", "Cannot start services, services array is null. Failed to start services.");
                } else if (this.mApplication == null) {
                    StringBuilder sb = new StringBuilder();
                    for (Class<? extends AppCenterService> name : clsArr) {
                        sb.append("\t");
                        sb.append(name.getName());
                        sb.append("\n");
                    }
                    AppCenterLog.error("AppCenter", "Cannot start services, App Center has not been configured. Failed to start the following services:\n" + sb);
                } else {
                    final ArrayList arrayList = new ArrayList();
                    final ArrayList arrayList2 = new ArrayList();
                    for (Class<? extends AppCenterService> cls : clsArr) {
                        if (cls == null) {
                            AppCenterLog.warn("AppCenter", "Skipping null service, please check your varargs/array does not contain any null reference.");
                        } else {
                            try {
                                startOrUpdateService((AppCenterService) cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]), arrayList, arrayList2, z);
                            } catch (Exception e) {
                                AppCenterLog.error("AppCenter", "Failed to get service instance '" + cls.getName() + "', skipping it.", e);
                            }
                        }
                    }
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            AppCenter appCenter = AppCenter.this;
                            Collection<AppCenterService> collection = arrayList2;
                            Collection<AppCenterService> collection2 = arrayList;
                            boolean z = z;
                            if (appCenter != null) {
                                for (AppCenterService appCenterService : collection) {
                                    appCenterService.onConfigurationUpdated(appCenter.mAppSecret, appCenter.mTransmissionTargetToken);
                                    AppCenterLog.info("AppCenter", appCenterService.getClass().getSimpleName() + " service configuration updated.");
                                }
                                boolean isInstanceEnabled = appCenter.isInstanceEnabled();
                                for (AppCenterService appCenterService2 : collection2) {
                                    Map<String, LogFactory> logFactories = appCenterService2.getLogFactories();
                                    if (logFactories != null) {
                                        for (Map.Entry next : logFactories.entrySet()) {
                                            appCenter.mLogSerializer.mLogFactories.put((String) next.getKey(), (LogFactory) next.getValue());
                                        }
                                    }
                                    if (!isInstanceEnabled && appCenterService2.isInstanceEnabled()) {
                                        appCenterService2.setInstanceEnabled(false);
                                    }
                                    if (z) {
                                        appCenterService2.onStarted(appCenter.mApplication, appCenter.mChannel, appCenter.mAppSecret, appCenter.mTransmissionTargetToken, true);
                                        AppCenterLog.info("AppCenter", appCenterService2.getClass().getSimpleName() + " service started from application.");
                                    } else {
                                        appCenterService2.onStarted(appCenter.mApplication, appCenter.mChannel, (String) null, (String) null, false);
                                        AppCenterLog.info("AppCenter", appCenterService2.getClass().getSimpleName() + " service started from library.");
                                    }
                                }
                                if (z) {
                                    for (AppCenterService serviceName : collection) {
                                        appCenter.mStartedServicesNamesToLog.add(serviceName.getServiceName());
                                    }
                                    for (AppCenterService serviceName2 : collection2) {
                                        appCenter.mStartedServicesNamesToLog.add(serviceName2.getServiceName());
                                    }
                                    if (!appCenter.mStartedServicesNamesToLog.isEmpty() && appCenter.isInstanceEnabled()) {
                                        ArrayList arrayList = new ArrayList(appCenter.mStartedServicesNamesToLog);
                                        appCenter.mStartedServicesNamesToLog.clear();
                                        StartServiceLog startServiceLog = new StartServiceLog();
                                        startServiceLog.services = arrayList;
                                        ((DefaultChannel) appCenter.mChannel).enqueue(startServiceLog, "group_core", 1);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            throw null;
                        }
                    });
                }
            }
        }
    }

    public final boolean configureSecretString(String str) {
        if (this.mConfiguredFromApp) {
            AppCenterLog.warn("AppCenter", "App Center may only be configured once.");
            return false;
        }
        this.mConfiguredFromApp = true;
        if (str != null) {
            for (String split : str.split(";")) {
                String[] split2 = split.split("=", -1);
                String str2 = split2[0];
                if (split2.length == 1) {
                    if (!str2.isEmpty()) {
                        this.mAppSecret = str2;
                    }
                } else if (!split2[1].isEmpty()) {
                    String str3 = split2[1];
                    if ("appsecret".equals(str2)) {
                        this.mAppSecret = str3;
                    } else if (AnimatedVectorDrawableCompat.TARGET.equals(str2)) {
                        this.mTransmissionTargetToken = str3;
                    }
                }
            }
        }
        return true;
    }

    public boolean isInstanceEnabled() {
        return SharedPreferencesManager.getBoolean(CleverCacheSettings.KEY_ENABLED, true);
    }

    public final void startOrUpdateService(AppCenterService appCenterService, Collection<AppCenterService> collection, Collection<AppCenterService> collection2, boolean z) {
        if (z) {
            String serviceName = appCenterService.getServiceName();
            if (this.mServices.contains(appCenterService)) {
                if (this.mServicesStartedFromLibrary.remove(appCenterService)) {
                    collection2.add(appCenterService);
                    return;
                }
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("App Center has already started the service with class name: ");
                outline24.append(appCenterService.getServiceName());
                AppCenterLog.warn("AppCenter", outline24.toString());
            } else if (this.mAppSecret != null || !appCenterService.isAppSecretRequired()) {
                startService(appCenterService, collection);
            } else {
                AppCenterLog.error("AppCenter", "App Center was started without app secret, but the service requires it; not starting service " + serviceName + CodelessMatcher.CURRENT_CLASS_NAME);
            }
        } else if (!this.mServices.contains(appCenterService)) {
            String serviceName2 = appCenterService.getServiceName();
            if (appCenterService.isAppSecretRequired()) {
                AppCenterLog.error("AppCenter", "This service cannot be started from a library: " + serviceName2 + CodelessMatcher.CURRENT_CLASS_NAME);
            } else if (startService(appCenterService, collection)) {
                this.mServicesStartedFromLibrary.add(appCenterService);
            }
        }
    }

    public final boolean startService(AppCenterService appCenterService, Collection<AppCenterService> collection) {
        boolean z;
        String serviceName = appCenterService.getServiceName();
        try {
            String string = InstrumentationRegistryHelper.getArguments().getString("APP_CENTER_DISABLE");
            if (string != null) {
                String[] split = string.split(",");
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String trim = split[i].trim();
                    if (trim.equals("All") || trim.equals(serviceName)) {
                        z = true;
                    } else {
                        i++;
                    }
                }
            }
        } catch (IllegalStateException | LinkageError unused) {
            AppCenterLog.debug("AppCenter", "Cannot read instrumentation variables in a non-test environment.");
        }
        z = false;
        if (z) {
            AppCenterLog.debug("AppCenter", "Instrumentation variable to disable service has been set; not starting service " + serviceName + CodelessMatcher.CURRENT_CLASS_NAME);
            return false;
        }
        appCenterService.onStarting(this.mAppCenterHandler);
        this.mApplicationLifecycleListener.mLifecycleCallbacks.add(appCenterService);
        this.mApplication.registerActivityLifecycleCallbacks(appCenterService);
        this.mServices.add(appCenterService);
        collection.add(appCenterService);
        return true;
    }
}
