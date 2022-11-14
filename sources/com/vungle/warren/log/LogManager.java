package com.vungle.warren.log;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.gson.Gson;
import com.vungle.warren.Vungle;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.FilePreferences;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class LogManager {
    public static final boolean DEFAULT_CRASH_COLLECT_ENABLED = false;
    public static final int DEFAULT_CRASH_SEND_BATCH_MAX = 5;
    public static final boolean DEFAULT_LOGGING_ENABLED = false;
    public static final String LOGGER_PREFS_FILENAME = "com.vungle.sdk";
    public static final String PREFS_CRASH_BATCH_MAX_KEY = "crash_batch_max";
    public static final String PREFS_CRASH_COLLECT_FILTER_KEY = "crash_collect_filter";
    public static final String PREFS_CRASH_REPORT_ENABLED_KEY = "crash_report_enabled";
    @VisibleForTesting
    public static final String PREFS_LOGGING_ENABLED_KEY = "logging_enabled";
    public static final String TAG = "LogManager";
    public static String sDefaultCollectFilter = "com.vungle";
    public final String bundleID;
    public AtomicInteger crashBatchMax;
    public String crashCollectFilter;
    public final AtomicBoolean crashReportEnabled;
    public final Map<String, String> customDataMap;
    public Gson gson;
    public final Executor ioExecutor;
    public boolean isCrashReportInit;
    public JVMCrashCollector jvmCrashCollector;
    public final LogPersister logPersister;
    public final LogSender logSender;
    public final AtomicBoolean loggingEnabled;
    public final FilePreferences prefs;
    public SdkLoggingEventListener sdkLoggingEventListener;

    public interface SdkLoggingEventListener {
        boolean isCrashReportEnabled();

        void saveLog(@NonNull VungleLogger.LoggerLevel loggerLevel, @NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4);

        void sendPendingLogs();
    }

    public LogManager(@NonNull Context context, @NonNull CacheManager cacheManager, @NonNull VungleApiClient vungleApiClient, @NonNull Executor executor, @NonNull FilePreferences filePreferences) {
        this(context, new LogPersister(cacheManager.getCache()), new LogSender(vungleApiClient, filePreferences), executor, filePreferences);
    }

    /* access modifiers changed from: private */
    public String getCustomData() {
        if (this.customDataMap.isEmpty()) {
            return null;
        }
        return this.gson.toJson((Object) this.customDataMap);
    }

    private void sendCrashLogs() {
        if (!isCrashReportEnabled()) {
            Log.d(TAG, "Crash report disabled, no need to send crash log files.");
            return;
        }
        File[] crashReportFiles = this.logPersister.getCrashReportFiles(this.crashBatchMax.get());
        if (crashReportFiles == null || crashReportFiles.length == 0) {
            Log.d(TAG, "No need to send empty crash log files.");
        } else {
            this.logSender.sendLogs(crashReportFiles);
        }
    }

    /* access modifiers changed from: private */
    public void sendPendingLogs() {
        if (!isLoggingEnabled()) {
            Log.d(TAG, "Logging disabled, no need to send log files.");
            return;
        }
        File[] pendingFiles = this.logPersister.getPendingFiles();
        if (pendingFiles == null || pendingFiles.length == 0) {
            Log.d(TAG, "No need to send empty files.");
        } else {
            this.logSender.sendLogs(pendingFiles);
        }
    }

    public void addCustomData(@NonNull String str, @NonNull String str2) {
        this.customDataMap.put(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initJvmCollector() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isCrashReportInit     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x002b
            boolean r0 = r2.isCrashReportEnabled()     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = TAG     // Catch:{ all -> 0x002d }
            java.lang.String r1 = "crash report is disabled."
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x002d }
            monitor-exit(r2)
            return
        L_0x0014:
            com.vungle.warren.log.JVMCrashCollector r0 = r2.jvmCrashCollector     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x0021
            com.vungle.warren.log.JVMCrashCollector r0 = new com.vungle.warren.log.JVMCrashCollector     // Catch:{ all -> 0x002d }
            com.vungle.warren.log.LogManager$SdkLoggingEventListener r1 = r2.sdkLoggingEventListener     // Catch:{ all -> 0x002d }
            r0.<init>(r1)     // Catch:{ all -> 0x002d }
            r2.jvmCrashCollector = r0     // Catch:{ all -> 0x002d }
        L_0x0021:
            com.vungle.warren.log.JVMCrashCollector r0 = r2.jvmCrashCollector     // Catch:{ all -> 0x002d }
            java.lang.String r1 = r2.crashCollectFilter     // Catch:{ all -> 0x002d }
            r0.updateConfig(r1)     // Catch:{ all -> 0x002d }
            r0 = 1
            r2.isCrashReportInit = r0     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r2)
            return
        L_0x002d:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.log.LogManager.initJvmCollector():void");
    }

    public boolean isCrashReportEnabled() {
        return this.crashReportEnabled.get();
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled.get();
    }

    public void removeCustomData(@NonNull String str) {
        this.customDataMap.remove(str);
    }

    public void saveLog(@NonNull VungleLogger.LoggerLevel loggerLevel, @NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4) {
        final String headerUa = VungleApiClient.getHeaderUa();
        if (loggerLevel != VungleLogger.LoggerLevel.CRASH || !isCrashReportEnabled()) {
            final String str5 = str2;
            final VungleLogger.LoggerLevel loggerLevel2 = loggerLevel;
            final String str6 = str;
            final String str7 = str3;
            final String str8 = str4;
            this.ioExecutor.execute(new Runnable() {
                public void run() {
                    if (LogManager.this.isLoggingEnabled()) {
                        LogManager.this.logPersister.saveLogData(str5, loggerLevel2.toString(), str6, "", headerUa, LogManager.this.bundleID, LogManager.this.getCustomData(), str7, str8);
                    }
                }
            });
            return;
        }
        synchronized (this) {
            this.logPersister.saveCrashLogData(str2, loggerLevel.toString(), str, "", headerUa, this.bundleID, getCustomData(), str3, str4);
        }
    }

    public void sendSdkLogs() {
        sendCrashLogs();
        sendPendingLogs();
    }

    public void setLoggingEnabled(boolean z) {
        if (this.loggingEnabled.compareAndSet(!z, z)) {
            this.prefs.put(PREFS_LOGGING_ENABLED_KEY, z);
            this.prefs.apply();
        }
    }

    public void setMaxEntries(int i) {
        this.logPersister.setMaximumEntries(i);
    }

    public synchronized void updateCrashReportConfig(boolean z, @Nullable String str, int i) {
        boolean z2 = true;
        boolean z3 = this.crashReportEnabled.get() != z;
        boolean z4 = !TextUtils.isEmpty(str) && !str.equals(this.crashCollectFilter);
        int max = Math.max(i, 0);
        if (this.crashBatchMax.get() == max) {
            z2 = false;
        }
        if (z3 || z4 || z2) {
            if (z3) {
                this.crashReportEnabled.set(z);
                this.prefs.put(PREFS_CRASH_REPORT_ENABLED_KEY, z);
            }
            if (z4) {
                if ("*".equals(str)) {
                    this.crashCollectFilter = "";
                } else {
                    this.crashCollectFilter = str;
                }
                this.prefs.put(PREFS_CRASH_COLLECT_FILTER_KEY, this.crashCollectFilter);
            }
            if (z2) {
                this.crashBatchMax.set(max);
                this.prefs.put(PREFS_CRASH_BATCH_MAX_KEY, max);
            }
            this.prefs.apply();
            if (this.jvmCrashCollector != null) {
                this.jvmCrashCollector.updateConfig(this.crashCollectFilter);
            }
            if (z) {
                initJvmCollector();
            }
        }
    }

    @VisibleForTesting
    public LogManager(@NonNull Context context, @NonNull LogPersister logPersister2, @NonNull LogSender logSender2, @NonNull Executor executor, @NonNull FilePreferences filePreferences) {
        this.loggingEnabled = new AtomicBoolean(false);
        this.crashReportEnabled = new AtomicBoolean(false);
        this.crashCollectFilter = sDefaultCollectFilter;
        this.crashBatchMax = new AtomicInteger(5);
        this.isCrashReportInit = false;
        this.customDataMap = new ConcurrentHashMap();
        this.gson = new Gson();
        this.sdkLoggingEventListener = new SdkLoggingEventListener() {
            public boolean isCrashReportEnabled() {
                return LogManager.this.isCrashReportEnabled();
            }

            public void saveLog(@NonNull VungleLogger.LoggerLevel loggerLevel, @NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4) {
                LogManager.this.saveLog(loggerLevel, str, str2, str3, str4);
            }

            public void sendPendingLogs() {
                LogManager.this.sendPendingLogs();
            }
        };
        this.bundleID = context.getPackageName();
        this.logSender = logSender2;
        this.logPersister = logPersister2;
        this.ioExecutor = executor;
        this.prefs = filePreferences;
        logPersister2.setSdkLoggingEventListener(this.sdkLoggingEventListener);
        Package packageR = Vungle.class.getPackage();
        if (packageR != null) {
            sDefaultCollectFilter = packageR.getName();
        }
        this.loggingEnabled.set(filePreferences.getBoolean(PREFS_LOGGING_ENABLED_KEY, false));
        this.crashReportEnabled.set(filePreferences.getBoolean(PREFS_CRASH_REPORT_ENABLED_KEY, false));
        this.crashCollectFilter = filePreferences.getString(PREFS_CRASH_COLLECT_FILTER_KEY, sDefaultCollectFilter);
        this.crashBatchMax.set(filePreferences.getInt(PREFS_CRASH_BATCH_MAX_KEY, 5));
        initJvmCollector();
    }
}
