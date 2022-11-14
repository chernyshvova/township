package com.vungle.warren;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.swrve.sdk.SwrveImp;
import com.vungle.warren.AdConfig;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.VungleSettings;
import com.vungle.warren.downloader.DownloadRequest;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.log.LogManager;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.AnalyticUrl;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.p037ui.contract.AdContract;
import com.vungle.warren.p037ui.view.VungleNativeView;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.FutureResult;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.AnalyticsJob;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.utility.ActivityManager;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.TimeoutProvider;
import com.vungle.warren.utility.platform.Platform;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Keep
public class Vungle {
    public static final String TAG = Vungle.class.getCanonicalName();
    public static final Vungle _instance = new Vungle();
    public static CacheManager.Listener cacheListener = new CacheManager.Listener() {
        public void onCacheChanged() {
            if (Vungle._instance.context != null) {
                Vungle.stopPlaying();
                ServiceLocator instance = ServiceLocator.getInstance(Vungle._instance.context);
                CacheManager cacheManager = (CacheManager) instance.getService(CacheManager.class);
                Downloader downloader = (Downloader) instance.getService(Downloader.class);
                if (cacheManager.getCache() != null) {
                    List<DownloadRequest> allRequests = downloader.getAllRequests();
                    String path = cacheManager.getCache().getPath();
                    for (DownloadRequest next : allRequests) {
                        if (!next.path.startsWith(path)) {
                            downloader.cancel(next);
                        }
                    }
                }
                downloader.init();
            }
        }
    };
    public static AtomicBoolean isDepInit = new AtomicBoolean(false);
    public static volatile boolean isInitialized;
    public static AtomicBoolean isInitializing = new AtomicBoolean(false);
    public volatile String appID;
    public final AtomicReference<Consent> ccpaStatus = new AtomicReference<>();
    public final AtomicReference<Consent> consent = new AtomicReference<>();
    public volatile String consentVersion;
    public Context context;
    public final AtomicReference<Boolean> coppaStatus = new AtomicReference<>();
    public final AtomicReference<Boolean> disableAdIdIfCoppa = new AtomicReference<>();
    public Gson gson = new GsonBuilder().create();
    public AtomicInteger hbpOrdinalViewCount = new AtomicInteger(0);
    public Map<String, Boolean> playOperations = new ConcurrentHashMap();

    @Keep
    public enum Consent {
        OPTED_IN,
        OPTED_OUT
    }

    @Nullable
    public static Context appContext() {
        Vungle vungle = _instance;
        if (vungle != null) {
            return vungle.context;
        }
        return null;
    }

    public static boolean canPlayAd(@NonNull String str) {
        return canPlayAd(str, (String) null);
    }

    public static void clearAdvertisements() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            return;
        }
        final ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                ((Downloader) ServiceLocator.this.getService(Downloader.class)).cancelAll();
                ((AdLoader) ServiceLocator.this.getService(AdLoader.class)).clear();
                final Repository repository = (Repository) ServiceLocator.this.getService(Repository.class);
                ((Executors) ServiceLocator.this.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        List<Advertisement> list = repository.loadAll(Advertisement.class).get();
                        if (list != null) {
                            for (Advertisement id : list) {
                                try {
                                    repository.deleteAdvertisement(id.getId());
                                } catch (DatabaseHelper.DBException unused) {
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    public static void clearCache() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            return;
        }
        final ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                ((Downloader) ServiceLocator.this.getService(Downloader.class)).cancelAll();
                ((AdLoader) ServiceLocator.this.getService(AdLoader.class)).clear();
                ((Repository) ServiceLocator.this.getService(Repository.class)).clearAllData();
                Vungle._instance.playOperations.clear();
                Vungle._instance.ccpaStatus.set((Object) null);
                Vungle._instance.configure(((RuntimeValues) ServiceLocator.this.getService(RuntimeValues.class)).initCallback.get(), true);
            }
        });
    }

    private void clearCacheForCoppa(Repository repository, boolean z) throws DatabaseHelper.DBException {
        Cookie cookie = repository.load(Cookie.COPPA_COOKIE, Cookie.class).get();
        if ((z && _instance.coppaStatus.get().booleanValue()) || (_instance.disableAdIdIfCoppa.get().booleanValue() && cookie != null && cookie.getBoolean(Cookie.COPPA_FLAG_SWITCHED_TRUE).booleanValue())) {
            cookie.putValue(Cookie.COPPA_FLAG_SWITCHED_TRUE, Boolean.FALSE);
            repository.save(cookie);
            repository.deleteAll(Advertisement.class);
            repository.deleteAll(AnalyticUrl.class);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:183|184) */
    /* JADX WARNING: Code restructure failed: missing block: B:184:?, code lost:
        android.util.Log.e(TAG, "not able to apply vision data config");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:183:0x0403 */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x04f8  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0504  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void configure(@androidx.annotation.NonNull com.vungle.warren.InitCallback r32, boolean r33) {
        /*
            r31 = this;
            r1 = r31
            r2 = r32
            java.lang.String r0 = "cache_bust"
            java.lang.String r3 = "session"
            java.lang.Class<com.vungle.warren.log.LogManager> r4 = com.vungle.warren.log.LogManager.class
            java.lang.String r5 = "crash_report"
            java.lang.Class<com.vungle.warren.model.Cookie> r6 = com.vungle.warren.model.Cookie.class
            java.lang.String r7 = "consentIsImportantToVungle"
            java.lang.String r8 = "logging"
            java.lang.String r9 = "gdpr"
            java.lang.String r10 = "clever_cache"
            java.lang.String r11 = "button_deny"
            java.lang.String r12 = "button_accept"
            java.lang.String r13 = "consent_message_version"
            java.lang.String r14 = "consent_message"
            java.lang.String r15 = "consent_title"
            r16 = r0
            java.lang.String r0 = "is_country_data_protected"
            r17 = r3
            android.content.Context r3 = r1.context     // Catch:{ all -> 0x04e1 }
            if (r3 == 0) goto L_0x04d6
            android.content.Context r3 = r1.context     // Catch:{ all -> 0x04e1 }
            com.vungle.warren.ServiceLocator r3 = com.vungle.warren.ServiceLocator.getInstance(r3)     // Catch:{ all -> 0x04e1 }
            r18 = r5
            java.lang.Class<com.vungle.warren.VungleApiClient> r5 = com.vungle.warren.VungleApiClient.class
            java.lang.Object r5 = r3.getService(r5)     // Catch:{ all -> 0x04e1 }
            com.vungle.warren.VungleApiClient r5 = (com.vungle.warren.VungleApiClient) r5     // Catch:{ all -> 0x04e1 }
            r19 = r4
            java.lang.String r4 = r1.appID     // Catch:{ all -> 0x04e1 }
            r5.setAppId(r4)     // Catch:{ all -> 0x04e1 }
            java.lang.Class<com.vungle.warren.persistence.Repository> r4 = com.vungle.warren.persistence.Repository.class
            java.lang.Object r4 = r3.getService(r4)     // Catch:{ all -> 0x04e1 }
            com.vungle.warren.persistence.Repository r4 = (com.vungle.warren.persistence.Repository) r4     // Catch:{ all -> 0x04e1 }
            java.lang.Class<com.vungle.warren.tasks.JobRunner> r1 = com.vungle.warren.tasks.JobRunner.class
            java.lang.Object r1 = r3.getService(r1)     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.tasks.JobRunner r1 = (com.vungle.warren.tasks.JobRunner) r1     // Catch:{ all -> 0x04d2 }
            r20 = r8
            com.vungle.warren.network.Response r8 = r5.config()     // Catch:{ all -> 0x04d2 }
            if (r8 != 0) goto L_0x006e
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x04d2 }
            r1 = 2
            r0.<init>(r1)     // Catch:{ all -> 0x04d2 }
            onInitError(r2, r0)     // Catch:{ all -> 0x04d2 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x04d2 }
            r1 = 0
            r0.set(r1)     // Catch:{ all -> 0x0069 }
            return
        L_0x0069:
            r0 = move-exception
            r6 = r31
            goto L_0x04e4
        L_0x006e:
            boolean r21 = r8.isSuccessful()     // Catch:{ all -> 0x04d2 }
            r22 = 0
            if (r21 != 0) goto L_0x00ae
            long r3 = r5.getRetryAfterHeaderValue(r8)     // Catch:{ all -> 0x04d2 }
            int r0 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r0 <= 0) goto L_0x009e
            com.vungle.warren.Vungle r0 = _instance     // Catch:{ all -> 0x04d2 }
            java.lang.String r0 = r0.appID     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.tasks.JobInfo r0 = com.vungle.warren.tasks.ReconfigJob.makeJobInfo(r0)     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.tasks.JobInfo r0 = r0.setDelay(r3)     // Catch:{ all -> 0x04d2 }
            r1.execute(r0)     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x04d2 }
            r1 = 14
            r0.<init>(r1)     // Catch:{ all -> 0x04d2 }
            onInitError(r2, r0)     // Catch:{ all -> 0x04d2 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x04d2 }
            r1 = 0
            r0.set(r1)     // Catch:{ all -> 0x0069 }
            return
        L_0x009e:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x04d2 }
            r1 = 3
            r0.<init>(r1)     // Catch:{ all -> 0x04d2 }
            onInitError(r2, r0)     // Catch:{ all -> 0x04d2 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x04d2 }
            r1 = 0
            r0.set(r1)     // Catch:{ all -> 0x0069 }
            return
        L_0x00ae:
            r21 = r1
            java.lang.Class<com.vungle.warren.persistence.FilePreferences> r1 = com.vungle.warren.persistence.FilePreferences.class
            java.lang.Object r1 = r3.getService(r1)     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.persistence.FilePreferences r1 = (com.vungle.warren.persistence.FilePreferences) r1     // Catch:{ all -> 0x04d2 }
            java.lang.Object r8 = r8.body()     // Catch:{ all -> 0x04d2 }
            com.google.gson.JsonObject r8 = (com.google.gson.JsonObject) r8     // Catch:{ all -> 0x04d2 }
            r24 = r5
            java.lang.String r5 = "placements"
            com.google.gson.JsonArray r5 = r8.getAsJsonArray(r5)     // Catch:{ all -> 0x04d2 }
            if (r5 != 0) goto L_0x00d8
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException     // Catch:{ all -> 0x04d2 }
            r1 = 3
            r0.<init>(r1)     // Catch:{ all -> 0x04d2 }
            onInitError(r2, r0)     // Catch:{ all -> 0x04d2 }
            java.util.concurrent.atomic.AtomicBoolean r0 = isInitializing     // Catch:{ all -> 0x04d2 }
            r1 = 0
            r0.set(r1)     // Catch:{ all -> 0x0069 }
            return
        L_0x00d8:
            com.vungle.warren.CleverCacheSettings r25 = com.vungle.warren.CleverCacheSettings.fromJson(r8)     // Catch:{ all -> 0x04d2 }
            java.lang.Class<com.vungle.warren.downloader.Downloader> r2 = com.vungle.warren.downloader.Downloader.class
            java.lang.Object r2 = r3.getService(r2)     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.downloader.Downloader r2 = (com.vungle.warren.downloader.Downloader) r2     // Catch:{ all -> 0x04d2 }
            r26 = r11
            if (r25 == 0) goto L_0x0121
            r11 = 0
            java.lang.String r11 = r1.getString(r10, r11)     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.CleverCacheSettings r11 = com.vungle.warren.CleverCacheSettings.deserializeFromString(r11)     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0102
            long r27 = r11.getTimestamp()     // Catch:{ all -> 0x04d2 }
            long r29 = r25.getTimestamp()     // Catch:{ all -> 0x04d2 }
            int r11 = (r27 > r29 ? 1 : (r27 == r29 ? 0 : -1))
            if (r11 == 0) goto L_0x0100
            goto L_0x0102
        L_0x0100:
            r11 = 0
            goto L_0x0103
        L_0x0102:
            r11 = 1
        L_0x0103:
            boolean r27 = r25.isEnabled()     // Catch:{ all -> 0x04d2 }
            if (r27 == 0) goto L_0x010b
            if (r11 == 0) goto L_0x010e
        L_0x010b:
            r2.clearCache()     // Catch:{ all -> 0x04d2 }
        L_0x010e:
            boolean r11 = r25.isEnabled()     // Catch:{ all -> 0x04d2 }
            r2.setCacheEnabled(r11)     // Catch:{ all -> 0x04d2 }
            java.lang.String r2 = r25.serializeToString()     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.persistence.FilePreferences r2 = r1.put((java.lang.String) r10, (java.lang.String) r2)     // Catch:{ all -> 0x04d2 }
            r2.apply()     // Catch:{ all -> 0x04d2 }
            goto L_0x0125
        L_0x0121:
            r10 = 1
            r2.setCacheEnabled(r10)     // Catch:{ all -> 0x04d2 }
        L_0x0125:
            java.lang.Class<com.vungle.warren.AdLoader> r2 = com.vungle.warren.AdLoader.class
            java.lang.Object r2 = r3.getService(r2)     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.AdLoader r2 = (com.vungle.warren.AdLoader) r2     // Catch:{ all -> 0x04d2 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x04d2 }
            r10.<init>()     // Catch:{ all -> 0x04d2 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x04d2 }
        L_0x0136:
            boolean r11 = r5.hasNext()     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0153
            java.lang.Object r11 = r5.next()     // Catch:{ all -> 0x04d2 }
            com.google.gson.JsonElement r11 = (com.google.gson.JsonElement) r11     // Catch:{ all -> 0x04d2 }
            r25 = r5
            com.vungle.warren.model.Placement r5 = new com.vungle.warren.model.Placement     // Catch:{ all -> 0x04d2 }
            com.google.gson.JsonObject r11 = r11.getAsJsonObject()     // Catch:{ all -> 0x04d2 }
            r5.<init>((com.google.gson.JsonObject) r11)     // Catch:{ all -> 0x04d2 }
            r10.add(r5)     // Catch:{ all -> 0x04d2 }
            r5 = r25
            goto L_0x0136
        L_0x0153:
            r4.setValidPlacements(r10)     // Catch:{ all -> 0x04d2 }
            boolean r5 = r8.has(r9)     // Catch:{ all -> 0x04d2 }
            if (r5 == 0) goto L_0x024b
            com.vungle.warren.persistence.FutureResult r5 = r4.load(r7, r6)     // Catch:{ all -> 0x04d2 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.model.Cookie r5 = (com.vungle.warren.model.Cookie) r5     // Catch:{ all -> 0x04d2 }
            if (r5 != 0) goto L_0x0184
            com.vungle.warren.model.Cookie r5 = new com.vungle.warren.model.Cookie     // Catch:{ all -> 0x04d2 }
            r5.<init>(r7)     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = "consent_status"
            java.lang.String r10 = "unknown"
            r5.putValue(r7, r10)     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = "consent_source"
            java.lang.String r10 = "no_interaction"
            r5.putValue(r7, r10)     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = "timestamp"
            java.lang.Long r10 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x04d2 }
            r5.putValue(r7, r10)     // Catch:{ all -> 0x04d2 }
        L_0x0184:
            com.google.gson.JsonObject r7 = r8.getAsJsonObject(r9)     // Catch:{ all -> 0x04d2 }
            boolean r9 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r0)     // Catch:{ all -> 0x04d2 }
            if (r9 == 0) goto L_0x019a
            com.google.gson.JsonElement r9 = r7.get(r0)     // Catch:{ all -> 0x04d2 }
            boolean r9 = r9.getAsBoolean()     // Catch:{ all -> 0x04d2 }
            if (r9 == 0) goto L_0x019a
            r9 = 1
            goto L_0x019b
        L_0x019a:
            r9 = 0
        L_0x019b:
            boolean r10 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r15)     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = ""
            if (r10 == 0) goto L_0x01ac
            com.google.gson.JsonElement r10 = r7.get(r15)     // Catch:{ all -> 0x04d2 }
            java.lang.String r10 = r10.getAsString()     // Catch:{ all -> 0x04d2 }
            goto L_0x01ad
        L_0x01ac:
            r10 = r11
        L_0x01ad:
            boolean r22 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r14)     // Catch:{ all -> 0x04d2 }
            if (r22 == 0) goto L_0x01bc
            com.google.gson.JsonElement r22 = r7.get(r14)     // Catch:{ all -> 0x04d2 }
            java.lang.String r22 = r22.getAsString()     // Catch:{ all -> 0x04d2 }
            goto L_0x01be
        L_0x01bc:
            r22 = r11
        L_0x01be:
            boolean r23 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r13)     // Catch:{ all -> 0x04d2 }
            if (r23 == 0) goto L_0x01cd
            com.google.gson.JsonElement r23 = r7.get(r13)     // Catch:{ all -> 0x04d2 }
            java.lang.String r23 = r23.getAsString()     // Catch:{ all -> 0x04d2 }
            goto L_0x01cf
        L_0x01cd:
            r23 = r11
        L_0x01cf:
            boolean r25 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r12)     // Catch:{ all -> 0x04d2 }
            if (r25 == 0) goto L_0x01de
            com.google.gson.JsonElement r25 = r7.get(r12)     // Catch:{ all -> 0x04d2 }
            java.lang.String r25 = r25.getAsString()     // Catch:{ all -> 0x04d2 }
            goto L_0x01e0
        L_0x01de:
            r25 = r11
        L_0x01e0:
            r27 = r11
            r11 = r26
            boolean r26 = com.vungle.warren.model.JsonUtil.hasNonNull(r7, r11)     // Catch:{ all -> 0x04d2 }
            if (r26 == 0) goto L_0x01f3
            com.google.gson.JsonElement r7 = r7.get(r11)     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r7.getAsString()     // Catch:{ all -> 0x04d2 }
            goto L_0x01f5
        L_0x01f3:
            r7 = r27
        L_0x01f5:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x04d2 }
            r5.putValue(r0, r9)     // Catch:{ all -> 0x04d2 }
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x04d2 }
            if (r0 == 0) goto L_0x0204
            java.lang.String r10 = "Targeted Ads"
        L_0x0204:
            r5.putValue(r15, r10)     // Catch:{ all -> 0x04d2 }
            boolean r0 = android.text.TextUtils.isEmpty(r22)     // Catch:{ all -> 0x04d2 }
            if (r0 == 0) goto L_0x020f
            java.lang.String r22 = "To receive more relevant ad content based on your interactions with our ads, click \"I Consent\" below. Either way, you will see the same amount of ads."
        L_0x020f:
            r0 = r22
            r5.putValue(r14, r0)     // Catch:{ all -> 0x04d2 }
            java.lang.String r0 = "consent_source"
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x04d2 }
            java.lang.String r9 = "publisher"
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch:{ all -> 0x04d2 }
            if (r0 != 0) goto L_0x0230
            boolean r0 = android.text.TextUtils.isEmpty(r23)     // Catch:{ all -> 0x04d2 }
            if (r0 == 0) goto L_0x022b
            r0 = r27
            goto L_0x022d
        L_0x022b:
            r0 = r23
        L_0x022d:
            r5.putValue(r13, r0)     // Catch:{ all -> 0x04d2 }
        L_0x0230:
            boolean r0 = android.text.TextUtils.isEmpty(r25)     // Catch:{ all -> 0x04d2 }
            if (r0 == 0) goto L_0x0238
            java.lang.String r25 = "I Consent"
        L_0x0238:
            r0 = r25
            r5.putValue(r12, r0)     // Catch:{ all -> 0x04d2 }
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x04d2 }
            if (r0 == 0) goto L_0x0245
            java.lang.String r7 = "I Do Not Consent"
        L_0x0245:
            r5.putValue(r11, r7)     // Catch:{ all -> 0x04d2 }
            r4.save(r5)     // Catch:{ all -> 0x04d2 }
        L_0x024b:
            r0 = r20
            boolean r5 = r8.has(r0)     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = "enabled"
            if (r5 == 0) goto L_0x0275
            r5 = r19
            java.lang.Object r9 = r3.getService(r5)     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.log.LogManager r9 = (com.vungle.warren.log.LogManager) r9     // Catch:{ all -> 0x04d2 }
            com.google.gson.JsonObject r0 = r8.getAsJsonObject(r0)     // Catch:{ all -> 0x04d2 }
            boolean r10 = com.vungle.warren.model.JsonUtil.hasNonNull(r0, r7)     // Catch:{ all -> 0x04d2 }
            if (r10 == 0) goto L_0x0270
            com.google.gson.JsonElement r0 = r0.get(r7)     // Catch:{ all -> 0x04d2 }
            boolean r0 = r0.getAsBoolean()     // Catch:{ all -> 0x04d2 }
            goto L_0x0271
        L_0x0270:
            r0 = 0
        L_0x0271:
            r9.setLoggingEnabled(r0)     // Catch:{ all -> 0x04d2 }
            goto L_0x0277
        L_0x0275:
            r5 = r19
        L_0x0277:
            r0 = r18
            boolean r9 = r8.has(r0)     // Catch:{ all -> 0x04d2 }
            if (r9 == 0) goto L_0x02c5
            java.lang.Object r5 = r3.getService(r5)     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.log.LogManager r5 = (com.vungle.warren.log.LogManager) r5     // Catch:{ all -> 0x04d2 }
            com.google.gson.JsonObject r0 = r8.getAsJsonObject(r0)     // Catch:{ all -> 0x04d2 }
            boolean r9 = com.vungle.warren.model.JsonUtil.hasNonNull(r0, r7)     // Catch:{ all -> 0x04d2 }
            if (r9 == 0) goto L_0x0298
            com.google.gson.JsonElement r9 = r0.get(r7)     // Catch:{ all -> 0x04d2 }
            boolean r9 = r9.getAsBoolean()     // Catch:{ all -> 0x04d2 }
            goto L_0x0299
        L_0x0298:
            r9 = 0
        L_0x0299:
            java.lang.String r10 = "collect_filter"
            boolean r10 = com.vungle.warren.model.JsonUtil.hasNonNull(r0, r10)     // Catch:{ all -> 0x04d2 }
            if (r10 == 0) goto L_0x02ac
            java.lang.String r10 = "collect_filter"
            com.google.gson.JsonElement r10 = r0.get(r10)     // Catch:{ all -> 0x04d2 }
            java.lang.String r10 = r10.getAsString()     // Catch:{ all -> 0x04d2 }
            goto L_0x02ae
        L_0x02ac:
            java.lang.String r10 = com.vungle.warren.log.LogManager.sDefaultCollectFilter     // Catch:{ all -> 0x04d2 }
        L_0x02ae:
            java.lang.String r11 = "max_send_amount"
            boolean r11 = com.vungle.warren.model.JsonUtil.hasNonNull(r0, r11)     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x02c1
            java.lang.String r11 = "max_send_amount"
            com.google.gson.JsonElement r0 = r0.get(r11)     // Catch:{ all -> 0x04d2 }
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x04d2 }
            goto L_0x02c2
        L_0x02c1:
            r0 = 5
        L_0x02c2:
            r5.updateCrashReportConfig(r9, r10, r0)     // Catch:{ all -> 0x04d2 }
        L_0x02c5:
            r0 = 900(0x384, float:1.261E-42)
            r5 = r17
            boolean r9 = r8.has(r5)     // Catch:{ all -> 0x04d2 }
            if (r9 == 0) goto L_0x02e5
            com.google.gson.JsonObject r5 = r8.getAsJsonObject(r5)     // Catch:{ all -> 0x04d2 }
            java.lang.String r9 = "timeout"
            boolean r9 = r5.has(r9)     // Catch:{ all -> 0x04d2 }
            if (r9 == 0) goto L_0x02e5
            java.lang.String r0 = "timeout"
            com.google.gson.JsonElement r0 = r5.get(r0)     // Catch:{ all -> 0x04d2 }
            int r0 = r0.getAsInt()     // Catch:{ all -> 0x04d2 }
        L_0x02e5:
            r5 = r16
            boolean r9 = r8.has(r5)     // Catch:{ all -> 0x04d2 }
            if (r9 == 0) goto L_0x0318
            com.google.gson.JsonObject r5 = r8.getAsJsonObject(r5)     // Catch:{ all -> 0x04d2 }
            boolean r9 = r5.has(r7)     // Catch:{ all -> 0x04d2 }
            if (r9 == 0) goto L_0x0300
            com.google.gson.JsonElement r9 = r5.get(r7)     // Catch:{ all -> 0x04d2 }
            boolean r9 = r9.getAsBoolean()     // Catch:{ all -> 0x04d2 }
            goto L_0x0301
        L_0x0300:
            r9 = 0
        L_0x0301:
            java.lang.String r10 = "interval"
            boolean r10 = r5.has(r10)     // Catch:{ all -> 0x04d2 }
            if (r10 == 0) goto L_0x0316
            java.lang.String r10 = "interval"
            com.google.gson.JsonElement r5 = r5.get(r10)     // Catch:{ all -> 0x04d2 }
            int r5 = r5.getAsInt()     // Catch:{ all -> 0x04d2 }
            int r5 = r5 * 1000
            goto L_0x031a
        L_0x0316:
            r5 = 0
            goto L_0x031a
        L_0x0318:
            r5 = 0
            r9 = 0
        L_0x031a:
            java.lang.String r10 = "ad_load_optimization"
            com.google.gson.JsonObject r10 = r8.getAsJsonObject(r10)     // Catch:{ all -> 0x04d2 }
            r11 = 0
            boolean r10 = com.vungle.warren.model.JsonUtil.getAsBoolean(r10, r7, r11)     // Catch:{ all -> 0x04d2 }
            r2.setAdLoadOptimizationEnabled(r10)     // Catch:{ all -> 0x04d2 }
            java.lang.String r10 = "configSettings"
            com.vungle.warren.persistence.FutureResult r6 = r4.load(r10, r6)     // Catch:{ all -> 0x04d2 }
            java.lang.Object r6 = r6.get()     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.model.Cookie r6 = (com.vungle.warren.model.Cookie) r6     // Catch:{ all -> 0x04d2 }
            if (r6 != 0) goto L_0x033d
            com.vungle.warren.model.Cookie r6 = new com.vungle.warren.model.Cookie     // Catch:{ all -> 0x04d2 }
            java.lang.String r10 = "configSettings"
            r6.<init>(r10)     // Catch:{ all -> 0x04d2 }
        L_0x033d:
            java.lang.String r10 = "ri"
            boolean r10 = r8.has(r10)     // Catch:{ all -> 0x04d2 }
            if (r10 == 0) goto L_0x035c
            java.lang.String r10 = "ri"
            com.google.gson.JsonObject r10 = r8.getAsJsonObject(r10)     // Catch:{ all -> 0x04d2 }
            com.google.gson.JsonElement r7 = r10.get(r7)     // Catch:{ all -> 0x04d2 }
            boolean r7 = r7.getAsBoolean()     // Catch:{ all -> 0x04d2 }
            java.lang.String r10 = "isReportIncentivizedEnabled"
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x04d2 }
            r6.putValue(r10, r7)     // Catch:{ all -> 0x04d2 }
        L_0x035c:
            r4.save(r6)     // Catch:{ all -> 0x04d2 }
            java.lang.String r6 = "disable_ad_id_if_coppa"
            r7 = 1
            boolean r6 = com.vungle.warren.model.JsonUtil.getAsBoolean(r8, r6, r7)     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.Vungle r7 = _instance     // Catch:{ all -> 0x04d2 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r7 = r7.disableAdIdIfCoppa     // Catch:{ all -> 0x04d2 }
            java.lang.Object r7 = r7.get()     // Catch:{ all -> 0x04d2 }
            if (r7 == 0) goto L_0x0384
            com.vungle.warren.Vungle r7 = _instance     // Catch:{ all -> 0x04d2 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r7 = r7.disableAdIdIfCoppa     // Catch:{ all -> 0x04d2 }
            java.lang.Object r7 = r7.get()     // Catch:{ all -> 0x04d2 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x04d2 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x04d2 }
            if (r7 != 0) goto L_0x0384
            if (r6 == 0) goto L_0x0384
            r7 = 1
            goto L_0x0385
        L_0x0384:
            r7 = 0
        L_0x0385:
            com.vungle.warren.Vungle r10 = _instance     // Catch:{ all -> 0x04d2 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r10 = r10.disableAdIdIfCoppa     // Catch:{ all -> 0x04d2 }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x04d2 }
            r10.set(r11)     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.Vungle r10 = _instance     // Catch:{ all -> 0x04d2 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r10 = r10.coppaStatus     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.Vungle r11 = _instance     // Catch:{ all -> 0x04d2 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r11 = r11.disableAdIdIfCoppa     // Catch:{ all -> 0x04d2 }
            r12 = r24
            r12.setCoppaFlags(r10, r11)     // Catch:{ all -> 0x04d2 }
            java.lang.String r10 = "coppa_cookie"
            java.lang.String r11 = "disable_id"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x04d2 }
            com.vungle.warren.utility.CookieUtil.update(r4, r10, r11, r6)     // Catch:{ all -> 0x04d2 }
            r6 = r31
            r6.clearCacheForCoppa(r4, r7)     // Catch:{ all -> 0x04df }
            java.lang.String r7 = "config"
            boolean r7 = r8.has(r7)     // Catch:{ all -> 0x04df }
            if (r7 == 0) goto L_0x03d5
            java.lang.String r7 = "config"
            com.google.gson.JsonObject r7 = r8.getAsJsonObject(r7)     // Catch:{ all -> 0x04df }
            java.lang.String r10 = "refresh_time"
            com.google.gson.JsonElement r7 = r7.get(r10)     // Catch:{ all -> 0x04df }
            long r10 = r7.getAsLong()     // Catch:{ all -> 0x04df }
            java.lang.String r7 = r6.appID     // Catch:{ all -> 0x04df }
            com.vungle.warren.tasks.JobInfo r7 = com.vungle.warren.tasks.ReconfigJob.makeJobInfo(r7)     // Catch:{ all -> 0x04df }
            com.vungle.warren.tasks.JobInfo r7 = r7.setDelay(r10)     // Catch:{ all -> 0x04df }
            r10 = r21
            r10.execute(r7)     // Catch:{ all -> 0x04df }
            goto L_0x03d7
        L_0x03d5:
            r10 = r21
        L_0x03d7:
            java.lang.Class<com.vungle.warren.VisionController> r7 = com.vungle.warren.VisionController.class
            java.lang.Object r7 = r3.getService(r7)     // Catch:{ DBException -> 0x0403 }
            com.vungle.warren.VisionController r7 = (com.vungle.warren.VisionController) r7     // Catch:{ DBException -> 0x0403 }
            java.lang.String r11 = "vision"
            boolean r11 = com.vungle.warren.model.JsonUtil.hasNonNull(r8, r11)     // Catch:{ DBException -> 0x0403 }
            if (r11 == 0) goto L_0x03fa
            com.google.gson.Gson r11 = r6.gson     // Catch:{ DBException -> 0x0403 }
            java.lang.String r13 = "vision"
            com.google.gson.JsonObject r8 = r8.getAsJsonObject(r13)     // Catch:{ DBException -> 0x0403 }
            java.lang.Class<com.vungle.warren.vision.VisionConfig> r13 = com.vungle.warren.vision.VisionConfig.class
            java.lang.Object r8 = r11.fromJson((com.google.gson.JsonElement) r8, r13)     // Catch:{ DBException -> 0x0403 }
            com.vungle.warren.vision.VisionConfig r8 = (com.vungle.warren.vision.VisionConfig) r8     // Catch:{ DBException -> 0x0403 }
            goto L_0x03ff
        L_0x03fa:
            com.vungle.warren.vision.VisionConfig r8 = new com.vungle.warren.vision.VisionConfig     // Catch:{ DBException -> 0x0403 }
            r8.<init>()     // Catch:{ DBException -> 0x0403 }
        L_0x03ff:
            r7.setConfig(r8)     // Catch:{ DBException -> 0x0403 }
            goto L_0x040a
        L_0x0403:
            java.lang.String r7 = TAG     // Catch:{ all -> 0x04df }
            java.lang.String r8 = "not able to apply vision data config"
            android.util.Log.e(r7, r8)     // Catch:{ all -> 0x04df }
        L_0x040a:
            r7 = 1
            isInitialized = r7     // Catch:{ all -> 0x04df }
            r32.onSuccess()     // Catch:{ all -> 0x04df }
            java.lang.String r8 = "Vungle#init"
            java.lang.String r11 = "onSuccess"
            com.vungle.warren.VungleLogger.debug(r8, r11)     // Catch:{ all -> 0x04df }
            java.util.concurrent.atomic.AtomicBoolean r8 = isInitializing     // Catch:{ all -> 0x04df }
            r11 = 0
            r8.set(r11)     // Catch:{ all -> 0x04df }
            com.vungle.warren.SessionData r8 = new com.vungle.warren.SessionData     // Catch:{ all -> 0x04df }
            r8.<init>()     // Catch:{ all -> 0x04df }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x04df }
            r8.setInitTimeStamp(r13)     // Catch:{ all -> 0x04df }
            long r13 = (long) r0     // Catch:{ all -> 0x04df }
            r8.setTimeout(r13)     // Catch:{ all -> 0x04df }
            android.content.Context r0 = r6.context     // Catch:{ all -> 0x04df }
            com.vungle.warren.ServiceLocator r0 = com.vungle.warren.ServiceLocator.getInstance(r0)     // Catch:{ all -> 0x04df }
            java.lang.Class<com.vungle.warren.RuntimeValues> r11 = com.vungle.warren.RuntimeValues.class
            java.lang.Object r0 = r0.getService(r11)     // Catch:{ all -> 0x04df }
            com.vungle.warren.RuntimeValues r0 = (com.vungle.warren.RuntimeValues) r0     // Catch:{ all -> 0x04df }
            java.util.concurrent.atomic.AtomicReference<com.vungle.warren.SessionData> r0 = r0.sessionData     // Catch:{ all -> 0x04df }
            r0.set(r8)     // Catch:{ all -> 0x04df }
            android.content.Context r0 = r6.context     // Catch:{ all -> 0x04df }
            com.vungle.warren.ServiceLocator r0 = com.vungle.warren.ServiceLocator.getInstance(r0)     // Catch:{ all -> 0x04df }
            java.lang.Class<com.vungle.warren.utility.AppSession> r11 = com.vungle.warren.utility.AppSession.class
            java.lang.Object r0 = r0.getService(r11)     // Catch:{ all -> 0x04df }
            com.vungle.warren.utility.AppSession r0 = (com.vungle.warren.utility.AppSession) r0     // Catch:{ all -> 0x04df }
            com.vungle.warren.utility.AppSession r0 = r0.setSessionData(r8)     // Catch:{ all -> 0x04df }
            com.vungle.warren.Vungle$3 r8 = new com.vungle.warren.Vungle$3     // Catch:{ all -> 0x04df }
            r8.<init>()     // Catch:{ all -> 0x04df }
            com.vungle.warren.utility.AppSession r0 = r0.setSessionCallback(r8)     // Catch:{ all -> 0x04df }
            r0.observe()     // Catch:{ all -> 0x04df }
            com.vungle.warren.persistence.FutureResult r0 = r4.loadValidPlacements()     // Catch:{ all -> 0x04df }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x04df }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x04df }
            com.vungle.warren.tasks.JobInfo r4 = com.vungle.warren.tasks.CleanupJob.makeJobInfo()     // Catch:{ all -> 0x04df }
            r10.execute(r4)     // Catch:{ all -> 0x04df }
            if (r0 == 0) goto L_0x0499
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x04df }
            r4.<init>(r0)     // Catch:{ all -> 0x04df }
            com.vungle.warren.Vungle$4 r0 = new com.vungle.warren.Vungle$4     // Catch:{ all -> 0x04df }
            r0.<init>()     // Catch:{ all -> 0x04df }
            java.util.Collections.sort(r4, r0)     // Catch:{ all -> 0x04df }
            java.lang.String r0 = TAG     // Catch:{ all -> 0x04df }
            java.lang.String r8 = "starting jobs for autocached advs"
            android.util.Log.d(r0, r8)     // Catch:{ all -> 0x04df }
            java.lang.Class<com.vungle.warren.utility.Executors> r0 = com.vungle.warren.utility.Executors.class
            java.lang.Object r0 = r3.getService(r0)     // Catch:{ all -> 0x04df }
            com.vungle.warren.utility.Executors r0 = (com.vungle.warren.utility.Executors) r0     // Catch:{ all -> 0x04df }
            java.util.concurrent.ExecutorService r0 = r0.getUIExecutor()     // Catch:{ all -> 0x04df }
            com.vungle.warren.Vungle$5 r8 = new com.vungle.warren.Vungle$5     // Catch:{ all -> 0x04df }
            r8.<init>(r4, r2)     // Catch:{ all -> 0x04df }
            r0.execute(r8)     // Catch:{ all -> 0x04df }
        L_0x0499:
            if (r9 == 0) goto L_0x04aa
            java.lang.Class<com.vungle.warren.CacheBustManager> r0 = com.vungle.warren.CacheBustManager.class
            java.lang.Object r0 = r3.getService(r0)     // Catch:{ all -> 0x04df }
            com.vungle.warren.CacheBustManager r0 = (com.vungle.warren.CacheBustManager) r0     // Catch:{ all -> 0x04df }
            long r2 = (long) r5     // Catch:{ all -> 0x04df }
            r0.setRefreshRate(r2)     // Catch:{ all -> 0x04df }
            r0.startBust()     // Catch:{ all -> 0x04df }
        L_0x04aa:
            if (r33 != 0) goto L_0x04ad
            goto L_0x04ae
        L_0x04ad:
            r7 = 0
        L_0x04ae:
            com.vungle.warren.tasks.JobInfo r0 = com.vungle.warren.tasks.SendReportsJob.makeJobInfo(r7)     // Catch:{ all -> 0x04df }
            r10.execute(r0)     // Catch:{ all -> 0x04df }
            com.vungle.warren.tasks.JobInfo r0 = com.vungle.warren.tasks.SendLogsJob.makeJobInfo()     // Catch:{ all -> 0x04df }
            r10.execute(r0)     // Catch:{ all -> 0x04df }
            java.lang.String r0 = "reported"
            r2 = 0
            boolean r0 = r1.getBoolean(r0, r2)     // Catch:{ all -> 0x04df }
            if (r0 != 0) goto L_0x0532
            com.vungle.warren.network.Call r0 = r12.reportNew()     // Catch:{ all -> 0x04df }
            com.vungle.warren.Vungle$6 r2 = new com.vungle.warren.Vungle$6     // Catch:{ all -> 0x04df }
            r2.<init>(r1)     // Catch:{ all -> 0x04df }
            r0.enqueue(r2)     // Catch:{ all -> 0x04df }
            goto L_0x0532
        L_0x04d2:
            r0 = move-exception
            r6 = r31
            goto L_0x04e3
        L_0x04d6:
            r6 = r1
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x04df }
            java.lang.String r1 = "Context is null"
            r0.<init>(r1)     // Catch:{ all -> 0x04df }
            throw r0     // Catch:{ all -> 0x04df }
        L_0x04df:
            r0 = move-exception
            goto L_0x04e3
        L_0x04e1:
            r0 = move-exception
            r6 = r1
        L_0x04e3:
            r1 = 0
        L_0x04e4:
            isInitialized = r1
            java.util.concurrent.atomic.AtomicBoolean r2 = isInitializing
            r2.set(r1)
            java.lang.String r1 = TAG
            java.lang.String r2 = android.util.Log.getStackTraceString(r0)
            android.util.Log.e(r1, r2)
            boolean r1 = r0 instanceof com.vungle.warren.network.HttpException
            if (r1 == 0) goto L_0x0504
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r1 = 3
            r0.<init>(r1)
            r1 = r32
            onInitError(r1, r0)
            goto L_0x0532
        L_0x0504:
            r1 = r32
            boolean r2 = r0 instanceof com.vungle.warren.persistence.DatabaseHelper.DBException
            if (r2 == 0) goto L_0x0515
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r2 = 26
            r0.<init>(r2)
            onInitError(r1, r0)
            goto L_0x0532
        L_0x0515:
            boolean r2 = r0 instanceof java.net.UnknownHostException
            if (r2 != 0) goto L_0x0528
            boolean r0 = r0 instanceof java.lang.SecurityException
            if (r0 == 0) goto L_0x051e
            goto L_0x0528
        L_0x051e:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r2 = 2
            r0.<init>(r2)
            onInitError(r1, r0)
            goto L_0x0532
        L_0x0528:
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r2 = 33
            r0.<init>(r2)
            onInitError(r1, r0)
        L_0x0532:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Vungle.configure(com.vungle.warren.InitCallback, boolean):void");
    }

    public static void deInit() {
        Class cls = AdLoader.class;
        Class cls2 = Downloader.class;
        Class cls3 = CacheManager.class;
        Context context2 = _instance.context;
        if (context2 != null) {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            if (instance.isCreated(cls3)) {
                ((CacheManager) instance.getService(cls3)).removeListener(cacheListener);
            }
            if (instance.isCreated(cls2)) {
                ((Downloader) instance.getService(cls2)).cancelAll();
            }
            if (instance.isCreated(cls)) {
                ((AdLoader) instance.getService(cls)).clear();
            }
            _instance.playOperations.clear();
        }
        ServiceLocator.deInit();
        isInitialized = false;
        isDepInit.set(false);
        isInitializing.set(false);
    }

    public static Context getAppContext() {
        return _instance.context;
    }

    public static String getAvailableBidTokens(@NonNull Context context2) {
        return getAvailableBidTokensBySize(context2, 0);
    }

    @Nullable
    public static String getAvailableBidTokensBySize(@NonNull final Context context2, final int i) {
        if (context2 == null) {
            Log.e(TAG, "Context is null");
            return null;
        }
        if (i <= 0) {
            i = 2147483646;
        }
        ServiceLocator instance = ServiceLocator.getInstance(context2);
        return (String) new FutureResult(((Executors) instance.getService(Executors.class)).getApiExecutor().submit(new Callable<String>() {
            public String call() throws Exception {
                Vungle._instance.hbpOrdinalViewCount.incrementAndGet();
                List list = ((Repository) ServiceLocator.getInstance(context2).getService(Repository.class)).getAvailableBidTokens(Vungle.getAvailableSizeForHBT(i, SwrveImp.CAMPAIGN_RESPONSE_VERSION, Vungle._instance.hbpOrdinalViewCount.toString()), ",".getBytes().length).get();
                StringBuilder outline26 = GeneratedOutlineSupport.outline26((list == null || list.isEmpty()) ? "" : TextUtils.join(",", list), CertificateUtil.DELIMITER);
                outline26.append(Vungle._instance.hbpOrdinalViewCount.toString());
                return GeneratedOutlineSupport.outline17(SwrveImp.CAMPAIGN_RESPONSE_VERSION, CertificateUtil.DELIMITER, new String(Base64.encode(outline26.toString().getBytes(), 2), Charset.defaultCharset()));
            }
        })).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
    }

    @VisibleForTesting
    public static int getAvailableSizeForHBT(int i, String str, String str2) {
        double length = (double) CertificateUtil.DELIMITER.getBytes().length;
        Double.isNaN(length);
        double floor = (Math.floor((double) (((i - str.getBytes().length) - CertificateUtil.DELIMITER.getBytes().length) / 4)) * 3.0d) - length;
        double length2 = (double) str2.getBytes().length;
        Double.isNaN(length2);
        double d = (double) ((int) (floor - length2));
        Double.isNaN(d);
        return (int) Math.max(Math.round(d / 4.0d) * 4, 0);
    }

    @Nullable
    public static Consent getCCPAStatus() {
        return _instance.ccpaStatus.get();
    }

    public static Consent getConsent(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return Cookie.CONSENT_STATUS_OPTED_IN.equals(cookie.getString("consent_status")) ? Consent.OPTED_IN : Consent.OPTED_OUT;
    }

    public static String getConsentMessageVersion() {
        return _instance.consentVersion;
    }

    @Nullable
    public static Consent getConsentStatus() {
        if (!isInitialized() || !isDepInit.get()) {
            return _instance.consent.get();
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        Cookie cookie = ((Repository) instance.getService(Repository.class)).load(Cookie.CONSENT_COOKIE, Cookie.class).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        if (cookie == null) {
            return null;
        }
        String string = cookie.getString("consent_status");
        char c = 65535;
        int hashCode = string.hashCode();
        if (hashCode != -83053070) {
            if (hashCode != 1230717015) {
                if (hashCode == 1720328225 && string.equals(Cookie.CONSENT_STATUS_OPTED_OUT)) {
                    c = 1;
                }
            } else if (string.equals("opted_out_by_timeout")) {
                c = 0;
            }
        } else if (string.equals(Cookie.CONSENT_STATUS_OPTED_IN)) {
            c = 2;
        }
        if (c == 0 || c == 1) {
            _instance.consent.set(Consent.OPTED_OUT);
            return Consent.OPTED_OUT;
        } else if (c != 2) {
            return null;
        } else {
            _instance.consent.set(Consent.OPTED_IN);
            return Consent.OPTED_IN;
        }
    }

    @Deprecated
    @Nullable
    public static VungleNativeAd getNativeAd(@NonNull String str, @Nullable AdConfig adConfig, @Nullable PlayAdCallback playAdCallback) {
        return getNativeAd(str, (String) null, adConfig, playAdCallback);
    }

    @Nullable
    public static VungleNativeView getNativeAdInternal(String str, AdMarkup adMarkup, AdConfig adConfig, PlayAdCallback playAdCallback) {
        String str2 = str;
        PlayAdCallback playAdCallback2 = playAdCallback;
        if (_instance.context == null) {
            Log.e(TAG, "Vungle is not initialized, returned VungleNativeAd = null");
            onPlayError(str2, playAdCallback2, new VungleException(9));
            return null;
        } else if (TextUtils.isEmpty(str)) {
            onPlayError(str2, playAdCallback2, new VungleException(13));
            return null;
        } else {
            ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
            AdLoader adLoader = (AdLoader) instance.getService(AdLoader.class);
            AdRequest adRequest = new AdRequest(str2, adMarkup);
            boolean isLoading = adLoader.isLoading(adRequest);
            if (Boolean.TRUE.equals(_instance.playOperations.get(str2)) || isLoading) {
                String str3 = TAG;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Playing or Loading operation ongoing. Playing ");
                outline24.append(_instance.playOperations.get(adRequest.getPlacementId()));
                outline24.append(" Loading: ");
                outline24.append(isLoading);
                Log.e(str3, outline24.toString());
                onPlayError(str2, playAdCallback2, new VungleException(8));
                return null;
            }
            try {
                AdRequest adRequest2 = adRequest;
                PlayAdCallback playAdCallback3 = playAdCallback;
                AdRequest adRequest3 = adRequest;
                return new VungleNativeView(_instance.context.getApplicationContext(), adRequest3, adConfig, (PresentationFactory) instance.getService(PresentationFactory.class), new AdEventListener(adRequest2, _instance.playOperations, playAdCallback3, (Repository) instance.getService(Repository.class), adLoader, (JobRunner) instance.getService(JobRunner.class), (VisionController) instance.getService(VisionController.class), (Placement) null, (Advertisement) null));
            } catch (Exception e) {
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Native ad fail: ");
                outline242.append(e.getLocalizedMessage());
                VungleLogger.error("Vungle#playAd", outline242.toString());
                if (playAdCallback2 != null) {
                    playAdCallback2.onError(str2, new VungleException(10));
                }
                return null;
            }
        }
    }

    @VisibleForTesting
    public static Collection<Advertisement> getValidAdvertisementModels(@NonNull String str) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        Collection<Advertisement> collection = ((Repository) instance.getService(Repository.class)).findValidAdvertisementsForPlacement(str, (String) null).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        return collection == null ? Collections.emptyList() : collection;
    }

    @VisibleForTesting
    public static Collection<Placement> getValidPlacementModels() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        Collection<Placement> collection = ((Repository) instance.getService(Repository.class)).loadValidPlacements().get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        return collection == null ? Collections.emptyList() : collection;
    }

    public static Collection<String> getValidPlacements() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized return empty placements list");
            return Collections.emptyList();
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        Collection<String> collection = ((Repository) instance.getService(Repository.class)).getValidPlacementIds().get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS);
        return collection == null ? Collections.emptyList() : collection;
    }

    @Deprecated
    public static void init(@NonNull Collection<String> collection, @NonNull String str, @NonNull Context context2, @NonNull InitCallback initCallback) throws IllegalArgumentException {
        init(str, context2, initCallback, new VungleSettings.Builder().build());
    }

    public static boolean isInitialized() {
        return isInitialized && _instance.context != null;
    }

    public static void loadAd(@NonNull String str, @Nullable LoadAdCallback loadAdCallback) {
        loadAd(str, new AdConfig(), loadAdCallback);
    }

    public static void loadAdInternal(@NonNull String str, @Nullable AdMarkup adMarkup, @Nullable AdConfig adConfig, @Nullable LoadAdCallback loadAdCallback) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            onLoadError(str, loadAdCallback, new VungleException(9));
            return;
        }
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        LoadAdCallbackWrapper loadAdCallbackWrapper = new LoadAdCallbackWrapper(((Executors) instance.getService(Executors.class)).getUIExecutor(), loadAdCallback);
        AdLoader adLoader = (AdLoader) instance.getService(AdLoader.class);
        AdRequest adRequest = new AdRequest(str, adMarkup);
        if (adConfig == null) {
            adConfig = new AdConfig();
        }
        adLoader.load(adRequest, adConfig, loadAdCallbackWrapper);
    }

    public static void onInitError(InitCallback initCallback, VungleException vungleException) {
        if (initCallback != null) {
            initCallback.onError(vungleException);
        }
        if (vungleException != null) {
            VungleLogger.error("Vungle#init", (vungleException.getLocalizedMessage() == null || !vungleException.getLocalizedMessage().isEmpty()) ? Integer.toString(vungleException.getExceptionCode()) : vungleException.getLocalizedMessage());
        }
    }

    public static void onLoadError(String str, @Nullable LoadAdCallback loadAdCallback, VungleException vungleException) {
        if (loadAdCallback != null) {
            loadAdCallback.onError(str, vungleException);
        }
        if (vungleException != null) {
            VungleLogger.error("Vungle#loadAd", (vungleException.getLocalizedMessage() == null || !vungleException.getLocalizedMessage().isEmpty()) ? Integer.toString(vungleException.getExceptionCode()) : vungleException.getLocalizedMessage());
        }
    }

    public static void onPlayError(String str, PlayAdCallback playAdCallback, VungleException vungleException) {
        if (playAdCallback != null) {
            playAdCallback.onError(str, vungleException);
        }
        if (vungleException != null) {
            VungleLogger.error("Vungle#playAd", (vungleException.getLocalizedMessage() == null || !vungleException.getLocalizedMessage().isEmpty()) ? Integer.toString(vungleException.getExceptionCode()) : vungleException.getLocalizedMessage());
        }
    }

    public static void playAd(@NonNull String str, AdConfig adConfig, @Nullable PlayAdCallback playAdCallback) {
        playAd(str, (String) null, adConfig, playAdCallback);
    }

    public static void reConfigure() {
        Context context2 = _instance.context;
        if (context2 != null) {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            Executors executors = (Executors) instance.getService(Executors.class);
            final RuntimeValues runtimeValues = (RuntimeValues) instance.getService(RuntimeValues.class);
            if (isInitialized()) {
                executors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        Vungle._instance.configure(RuntimeValues.this.initCallback.get(), true);
                    }
                });
            } else {
                init(_instance.appID, _instance.context, runtimeValues.initCallback.get());
            }
        }
    }

    public static synchronized void renderAd(@NonNull AdRequest adRequest, @Nullable PlayAdCallback playAdCallback, Placement placement, Advertisement advertisement) {
        synchronized (Vungle.class) {
            if (!isInitialized()) {
                Log.e(TAG, "Sdk is not initialized");
                return;
            }
            ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
            AdActivity.setEventListener(new AdEventListener(adRequest, _instance.playOperations, playAdCallback, (Repository) instance.getService(Repository.class), (AdLoader) instance.getService(AdLoader.class), (JobRunner) instance.getService(JobRunner.class), (VisionController) instance.getService(VisionController.class), placement, advertisement) {
                public void onFinished() {
                    super.onFinished();
                    AdActivity.setEventListener((AdContract.AdvertisementPresenter.EventListener) null);
                }
            });
            AdRequest adRequest2 = adRequest;
            ActivityManager.startWhenForeground(_instance.context, AdActivity.createIntent(_instance.context, adRequest), (ActivityManager.LeftApplicationCallback) null);
        }
    }

    public static void saveGDPRConsent(@NonNull final Repository repository, @NonNull final Consent consent2, @Nullable final String str) {
        repository.load(Cookie.CONSENT_COOKIE, Cookie.class, new Repository.LoadCallback<Cookie>() {
            public void onLoaded(Cookie cookie) {
                if (cookie == null) {
                    cookie = new Cookie(Cookie.CONSENT_COOKIE);
                }
                cookie.putValue("consent_status", Consent.this == Consent.OPTED_IN ? Cookie.CONSENT_STATUS_OPTED_IN : Cookie.CONSENT_STATUS_OPTED_OUT);
                cookie.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                cookie.putValue("consent_source", "publisher");
                String str = str;
                if (str == null) {
                    str = "";
                }
                cookie.putValue("consent_message_version", str);
                repository.save(cookie, (Repository.SaveCallback) null, false);
            }
        });
    }

    public static void setHeaderBiddingCallback(HeaderBiddingCallback headerBiddingCallback) {
        Context context2 = _instance.context;
        if (context2 != null) {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            ((RuntimeValues) instance.getService(RuntimeValues.class)).headerBiddingCallback.set(new HeaderBiddingCallbackWrapper(((Executors) instance.getService(Executors.class)).getUIExecutor(), headerBiddingCallback));
        }
    }

    public static void setIncentivizedFields(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Context context2 = _instance.context;
        if (context2 == null) {
            Log.e(TAG, "Vungle is not initialized, context is null");
            return;
        }
        final ServiceLocator instance = ServiceLocator.getInstance(context2);
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final String str9 = str5;
        final String str10 = str;
        ((Executors) instance.getService(Executors.class)).getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                if (!Vungle.isInitialized()) {
                    Log.e(Vungle.TAG, "Vungle is not initialized");
                    return;
                }
                Repository repository = (Repository) ServiceLocator.this.getService(Repository.class);
                Cookie cookie = repository.load(Cookie.INCENTIVIZED_TEXT_COOKIE, Cookie.class).get();
                if (cookie == null) {
                    cookie = new Cookie(Cookie.INCENTIVIZED_TEXT_COOKIE);
                }
                String str = "";
                String str2 = TextUtils.isEmpty(str6) ? str : str6;
                String str3 = TextUtils.isEmpty(str7) ? str : str7;
                String str4 = TextUtils.isEmpty(str8) ? str : str8;
                String str5 = TextUtils.isEmpty(str9) ? str : str9;
                if (!TextUtils.isEmpty(str10)) {
                    str = str10;
                }
                cookie.putValue("title", str2);
                cookie.putValue("body", str3);
                cookie.putValue("continue", str4);
                cookie.putValue("close", str5);
                cookie.putValue("userID", str);
                try {
                    repository.save(cookie);
                } catch (DatabaseHelper.DBException e) {
                    Log.e(Vungle.TAG, "Cannot save incentivized cookie", e);
                }
            }
        });
    }

    public static void stopPlaying() {
        if (_instance.context != null) {
            Intent intent = new Intent(AdContract.AdvertisementBus.ACTION);
            intent.putExtra(AdContract.AdvertisementBus.COMMAND, AdContract.AdvertisementBus.STOP_ALL);
            LocalBroadcastManager.getInstance(_instance.context).sendBroadcast(intent);
        }
    }

    public static void updateCCPAStatus(@NonNull Consent consent2) {
        if (consent2 == null) {
            Log.e(TAG, "Unable to update CCPA status, Invalid input parameter.");
            return;
        }
        _instance.ccpaStatus.set(consent2);
        if (!isInitialized() || !isDepInit.get()) {
            Log.e(TAG, "Vungle is not initialized");
        } else {
            updateCCPAStatus((Repository) ServiceLocator.getInstance(_instance.context).getService(Repository.class), consent2);
        }
    }

    public static void updateCOPPAStatus(boolean z) {
        ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
        final Repository repository = (Repository) instance.getService(Repository.class);
        Vungle vungle = _instance;
        ((VungleApiClient) instance.getService(VungleApiClient.class)).setCoppaFlags(vungle.coppaStatus, vungle.disableAdIdIfCoppa);
        repository.load(Cookie.COPPA_COOKIE, Cookie.class, new Repository.LoadCallback<Cookie>() {
            public void onLoaded(Cookie cookie) {
                if (cookie == null) {
                    cookie = new Cookie(Cookie.COPPA_COOKIE);
                }
                if (!cookie.getBoolean(Cookie.COPPA_STATUS_KEY).booleanValue() && ((Boolean) Vungle._instance.coppaStatus.get()).booleanValue()) {
                    cookie.putValue(Cookie.COPPA_FLAG_SWITCHED_TRUE, Boolean.TRUE);
                } else if (cookie.getBoolean(Cookie.COPPA_STATUS_KEY).booleanValue() && !((Boolean) Vungle._instance.coppaStatus.get()).booleanValue()) {
                    cookie.putValue(Cookie.COPPA_FLAG_SWITCHED_TRUE, Boolean.FALSE);
                }
                cookie.putValue(Cookie.COPPA_STATUS_KEY, Vungle._instance.coppaStatus.get());
                Repository.this.save(cookie, (Repository.SaveCallback) null, false);
            }
        });
    }

    public static void updateConsentStatus(@NonNull Consent consent2, @Nullable String str) {
        if (consent2 == null) {
            Log.e(TAG, "Cannot set consent with a null consent, please check your code");
            return;
        }
        _instance.consent.set(consent2);
        _instance.consentVersion = str;
        if (!isInitialized() || !isDepInit.get()) {
            Log.e(TAG, "Vungle is not initialized");
        } else {
            saveGDPRConsent((Repository) ServiceLocator.getInstance(_instance.context).getService(Repository.class), _instance.consent.get(), _instance.consentVersion);
        }
    }

    public static void updateUserCoppaStatus(boolean z) {
        _instance.coppaStatus.set(Boolean.valueOf(z));
        if (!isInitialized() || !isDepInit.get()) {
            Log.e(TAG, "Vungle is not initialized");
        } else {
            updateCOPPAStatus(z);
        }
    }

    public static boolean canPlayAd(@NonNull final String str, @Nullable final String str2) {
        final Context context2 = _instance.context;
        if (context2 == null) {
            Log.e(TAG, "Context is null");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "AdMarkup/PlacementId is null");
            return false;
        } else {
            ServiceLocator instance = ServiceLocator.getInstance(context2);
            return Boolean.TRUE.equals(new FutureResult(((Executors) instance.getService(Executors.class)).getApiExecutor().submit(new Callable<Boolean>() {
                public Boolean call() {
                    if (!Vungle.isInitialized()) {
                        Log.e(Vungle.TAG, "Vungle is not initialized");
                        return Boolean.FALSE;
                    }
                    Repository repository = (Repository) ServiceLocator.getInstance(context2).getService(Repository.class);
                    AdRequest adRequest = new AdRequest(str, AdMarkup.fromString(str2));
                    Placement placement = repository.load(str, Placement.class).get();
                    if (placement == null || !placement.isValid()) {
                        return Boolean.FALSE;
                    }
                    if (placement.isMultipleHBPEnabled() && adRequest.getEventId() == null) {
                        return Boolean.FALSE;
                    }
                    Advertisement advertisement = repository.findValidAdvertisementForPlacement(str, adRequest.getEventId()).get();
                    if (advertisement == null) {
                        return Boolean.FALSE;
                    }
                    if (placement.getPlacementAdType() == 1 || (!AdConfig.AdSize.isDefaultAdSize(placement.getAdSize()) && !placement.getAdSize().equals(advertisement.getAdConfig().getAdSize()))) {
                        return Boolean.FALSE;
                    }
                    return Boolean.valueOf(Vungle.canPlayAd(advertisement));
                }
            })).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS));
        }
    }

    public static Consent getCCPAStatus(@Nullable Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return Cookie.CONSENT_STATUS_OPTED_OUT.equals(cookie.getString(Cookie.CCPA_CONSENT_STATUS)) ? Consent.OPTED_OUT : Consent.OPTED_IN;
    }

    public static String getConsentMessageVersion(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return cookie.getString("consent_message_version");
    }

    @Nullable
    public static VungleNativeAd getNativeAd(@NonNull String str, @Nullable String str2, @Nullable AdConfig adConfig, @Nullable PlayAdCallback playAdCallback) {
        if (adConfig == null) {
            adConfig = new AdConfig();
        }
        if (AdConfig.AdSize.isDefaultAdSize(adConfig.getAdSize())) {
            return getNativeAdInternal(str, AdMarkup.fromString(str2), adConfig, playAdCallback);
        }
        if (playAdCallback == null) {
            return null;
        }
        Log.e(TAG, "Please use Banners.getBanner(... ) to retrieve Banner Ad");
        playAdCallback.onError(str, new VungleException(29));
        return null;
    }

    public static void init(@NonNull String str, @NonNull Context context2, @NonNull InitCallback initCallback) throws IllegalArgumentException {
        init(str, context2, initCallback, new VungleSettings.Builder().build());
    }

    public static void loadAd(@NonNull String str, @Nullable AdConfig adConfig, @Nullable LoadAdCallback loadAdCallback) {
        loadAd(str, (String) null, adConfig, loadAdCallback);
    }

    public static void playAd(@NonNull String str, @Nullable String str2, AdConfig adConfig, @Nullable PlayAdCallback playAdCallback) {
        VungleLogger.debug("Vungle#playAd", "playAd call invoked");
        if (!isInitialized()) {
            Log.e(TAG, "Locator is not initialized");
            if (playAdCallback != null) {
                onPlayError(str, playAdCallback, new VungleException(9));
            }
        } else if (TextUtils.isEmpty(str)) {
            onPlayError(str, playAdCallback, new VungleException(13));
        } else {
            ServiceLocator instance = ServiceLocator.getInstance(_instance.context);
            final Executors executors = (Executors) instance.getService(Executors.class);
            final Repository repository = (Repository) instance.getService(Repository.class);
            final AdLoader adLoader = (AdLoader) instance.getService(AdLoader.class);
            final VungleApiClient vungleApiClient = (VungleApiClient) instance.getService(VungleApiClient.class);
            final PlayAdCallbackWrapper playAdCallbackWrapper = new PlayAdCallbackWrapper(executors.getUIExecutor(), playAdCallback);
            final String str3 = str;
            final String str4 = str2;
            final AdConfig adConfig2 = adConfig;
            executors.getBackgroundExecutor().execute(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:36:0x00e5  */
                /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r10 = this;
                        com.vungle.warren.AdRequest r3 = new com.vungle.warren.AdRequest
                        java.lang.String r0 = r3
                        java.lang.String r1 = r4
                        com.vungle.warren.AdMarkup r1 = com.vungle.warren.AdMarkup.fromString(r1)
                        r3.<init>(r0, r1)
                        java.lang.Boolean r0 = java.lang.Boolean.TRUE
                        com.vungle.warren.Vungle r1 = com.vungle.warren.Vungle._instance
                        java.util.Map r1 = r1.playOperations
                        java.lang.String r2 = r3
                        java.lang.Object r1 = r1.get(r2)
                        boolean r0 = r0.equals(r1)
                        if (r0 != 0) goto L_0x0133
                        com.vungle.warren.AdLoader r0 = r5
                        boolean r0 = r0.isLoading(r3)
                        if (r0 == 0) goto L_0x002b
                        goto L_0x0133
                    L_0x002b:
                        com.vungle.warren.persistence.Repository r0 = r7
                        java.lang.String r1 = r3
                        java.lang.Class<com.vungle.warren.model.Placement> r2 = com.vungle.warren.model.Placement.class
                        com.vungle.warren.persistence.FutureResult r0 = r0.load(r1, r2)
                        java.lang.Object r0 = r0.get()
                        r4 = r0
                        com.vungle.warren.model.Placement r4 = (com.vungle.warren.model.Placement) r4
                        if (r4 != 0) goto L_0x004d
                        java.lang.String r0 = r3
                        com.vungle.warren.PlayAdCallback r1 = r6
                        com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException
                        r3 = 13
                        r2.<init>(r3)
                        com.vungle.warren.Vungle.onPlayError(r0, r1, r2)
                        return
                    L_0x004d:
                        com.vungle.warren.AdConfig$AdSize r0 = r4.getAdSize()
                        boolean r0 = com.vungle.warren.AdConfig.AdSize.isBannerAdSize(r0)
                        if (r0 == 0) goto L_0x006f
                        java.lang.String r0 = com.vungle.warren.Vungle.TAG
                        java.lang.String r1 = "Incorrect API for Banners and MREC"
                        android.util.Log.e(r0, r1)
                        java.lang.String r0 = r3
                        com.vungle.warren.PlayAdCallback r1 = r6
                        com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException
                        r3 = 28
                        r2.<init>(r3)
                        com.vungle.warren.Vungle.onPlayError(r0, r1, r2)
                        return
                    L_0x006f:
                        com.vungle.warren.persistence.Repository r0 = r7
                        java.lang.String r1 = r3
                        java.lang.String r2 = r3.getEventId()
                        com.vungle.warren.persistence.FutureResult r0 = r0.findPotentiallyExpiredAd(r1, r2)
                        java.lang.Object r0 = r0.get()
                        r5 = r0
                        com.vungle.warren.model.Advertisement r5 = (com.vungle.warren.model.Advertisement) r5
                        long r0 = java.lang.System.currentTimeMillis()     // Catch:{ DBException -> 0x0124 }
                        r6 = 1000(0x3e8, double:4.94E-321)
                        long r0 = r0 / r6
                        r2 = 0
                        r6 = 1
                        if (r5 == 0) goto L_0x0097
                        long r7 = r5.getExpireTime()     // Catch:{ DBException -> 0x0124 }
                        int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                        if (r9 >= 0) goto L_0x0097
                        r0 = 1
                        goto L_0x0098
                    L_0x0097:
                        r0 = 0
                    L_0x0098:
                        boolean r1 = com.vungle.warren.Vungle.canPlayAd((com.vungle.warren.model.Advertisement) r5)     // Catch:{ DBException -> 0x0124 }
                        if (r1 == 0) goto L_0x00ac
                        if (r0 == 0) goto L_0x00a1
                        goto L_0x00ac
                    L_0x00a1:
                        com.vungle.warren.AdConfig r0 = r8     // Catch:{ DBException -> 0x0124 }
                        r5.configure(r0)     // Catch:{ DBException -> 0x0124 }
                        com.vungle.warren.persistence.Repository r0 = r7     // Catch:{ DBException -> 0x0124 }
                        r0.save(r5)     // Catch:{ DBException -> 0x0124 }
                        goto L_0x00dd
                    L_0x00ac:
                        if (r5 == 0) goto L_0x00c9
                        int r1 = r5.getState()     // Catch:{ DBException -> 0x0124 }
                        if (r1 == r6) goto L_0x00b6
                        if (r0 == 0) goto L_0x00c9
                    L_0x00b6:
                        com.vungle.warren.persistence.Repository r1 = r7     // Catch:{ DBException -> 0x0124 }
                        java.lang.String r2 = r3     // Catch:{ DBException -> 0x0124 }
                        r7 = 4
                        r1.saveAndApplyState(r5, r2, r7)     // Catch:{ DBException -> 0x0124 }
                        com.vungle.warren.AdLoader r1 = r5     // Catch:{ DBException -> 0x0124 }
                        com.vungle.warren.AdConfig$AdSize r2 = r4.getAdSize()     // Catch:{ DBException -> 0x0124 }
                        r7 = 0
                        r1.loadEndlessIfNeeded(r4, r2, r7)     // Catch:{ DBException -> 0x0124 }
                    L_0x00c9:
                        if (r0 == 0) goto L_0x00dc
                        java.lang.String r0 = r3.getPlacementId()     // Catch:{ DBException -> 0x0124 }
                        com.vungle.warren.PlayAdCallback r1 = r6     // Catch:{ DBException -> 0x0124 }
                        com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException     // Catch:{ DBException -> 0x0124 }
                        r3 = 37
                        r2.<init>(r3)     // Catch:{ DBException -> 0x0124 }
                        com.vungle.warren.Vungle.onPlayError(r0, r1, r2)     // Catch:{ DBException -> 0x0124 }
                        return
                    L_0x00dc:
                        r2 = 1
                    L_0x00dd:
                        com.vungle.warren.Vungle r0 = com.vungle.warren.Vungle._instance
                        android.content.Context r0 = r0.context
                        if (r0 == 0) goto L_0x0123
                        com.vungle.warren.VungleApiClient r0 = r9
                        boolean r0 = r0.canCallWillPlayAd()
                        if (r0 == 0) goto L_0x010f
                        com.vungle.warren.VungleApiClient r0 = r9
                        java.lang.String r1 = r4.getId()
                        boolean r6 = r4.isAutoCached()
                        if (r2 == 0) goto L_0x00fc
                        java.lang.String r7 = ""
                        goto L_0x0100
                    L_0x00fc:
                        java.lang.String r7 = r5.getAdToken()
                    L_0x0100:
                        com.vungle.warren.network.Call r6 = r0.willPlayAd(r1, r6, r7)
                        com.vungle.warren.Vungle$9$1 r7 = new com.vungle.warren.Vungle$9$1
                        r0 = r7
                        r1 = r10
                        r0.<init>(r2, r3, r4, r5)
                        r6.enqueue(r7)
                        goto L_0x0123
                    L_0x010f:
                        if (r2 == 0) goto L_0x011e
                        java.lang.String r0 = r3
                        com.vungle.warren.PlayAdCallback r1 = r6
                        com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException
                        r2.<init>(r6)
                        com.vungle.warren.Vungle.onPlayError(r0, r1, r2)
                        goto L_0x0123
                    L_0x011e:
                        com.vungle.warren.PlayAdCallback r0 = r6
                        com.vungle.warren.Vungle.renderAd(r3, r0, r4, r5)
                    L_0x0123:
                        return
                    L_0x0124:
                        java.lang.String r0 = r3
                        com.vungle.warren.PlayAdCallback r1 = r6
                        com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException
                        r3 = 26
                        r2.<init>(r3)
                        com.vungle.warren.Vungle.onPlayError(r0, r1, r2)
                        return
                    L_0x0133:
                        java.lang.String r0 = r3
                        com.vungle.warren.PlayAdCallback r1 = r6
                        com.vungle.warren.error.VungleException r2 = new com.vungle.warren.error.VungleException
                        r3 = 8
                        r2.<init>(r3)
                        com.vungle.warren.Vungle.onPlayError(r0, r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Vungle.C19449.run():void");
                }
            });
        }
    }

    public static void init(@NonNull final String str, @NonNull final Context context2, @NonNull InitCallback initCallback, @NonNull VungleSettings vungleSettings) throws IllegalArgumentException {
        VungleLogger.debug("Vungle#init", "init request");
        if (initCallback == null) {
            throw new IllegalArgumentException("A valid InitCallback required to ensure API calls are being made after initialize is successful");
        } else if (context2 == null) {
            initCallback.onError(new VungleException(6));
        } else {
            final ServiceLocator instance = ServiceLocator.getInstance(context2);
            if (!((Platform) instance.getService(Platform.class)).isAtLeastMinimumSDK()) {
                Log.e(TAG, "SDK is supported only for API versions 21 and above");
                initCallback.onError(new VungleException(35));
                return;
            }
            final RuntimeValues runtimeValues = (RuntimeValues) ServiceLocator.getInstance(context2).getService(RuntimeValues.class);
            runtimeValues.settings.set(vungleSettings);
            Executors executors = (Executors) instance.getService(Executors.class);
            if (!(initCallback instanceof InitCallbackWrapper)) {
                initCallback = new InitCallbackWrapper(executors.getUIExecutor(), initCallback);
            }
            if (str == null || str.isEmpty()) {
                initCallback.onError(new VungleException(6));
            } else if (!(context2 instanceof Application)) {
                initCallback.onError(new VungleException(7));
            } else if (isInitialized()) {
                Log.d(TAG, "init already complete");
                initCallback.onSuccess();
                VungleLogger.debug("Vungle#init", "init already complete");
            } else if (isInitializing.getAndSet(true)) {
                Log.d(TAG, "init ongoing");
                onInitError(initCallback, new VungleException(8));
            } else if (PermissionChecker.checkCallingOrSelfPermission(context2, "android.permission.ACCESS_NETWORK_STATE") == 0 && PermissionChecker.checkCallingOrSelfPermission(context2, "android.permission.INTERNET") == 0) {
                runtimeValues.initCallback.set(initCallback);
                executors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        Class cls = VungleApiClient.class;
                        Class cls2 = JobRunner.class;
                        Class cls3 = Repository.class;
                        Class<Cookie> cls4 = Cookie.class;
                        String unused = Vungle._instance.appID = str;
                        InitCallback initCallback = runtimeValues.initCallback.get();
                        if (!Vungle.isDepInit.getAndSet(true)) {
                            VungleLogger.setupLoggerWithLogLevel((LogManager) instance.getService(LogManager.class), VungleLogger.LoggerLevel.DEBUG, 100);
                            CacheManager cacheManager = (CacheManager) instance.getService(CacheManager.class);
                            VungleSettings vungleSettings = runtimeValues.settings.get();
                            if (vungleSettings == null || cacheManager.getBytesAvailable() >= vungleSettings.getMinimumSpaceForInit()) {
                                cacheManager.addListener(Vungle.cacheListener);
                                Context unused2 = Vungle._instance.context = context2;
                                Repository repository = (Repository) instance.getService(cls3);
                                try {
                                    repository.init();
                                    VungleApiClient vungleApiClient = (VungleApiClient) instance.getService(cls);
                                    vungleApiClient.init();
                                    if (vungleSettings != null) {
                                        vungleApiClient.setDefaultIdFallbackDisabled(vungleSettings.getAndroidIdOptOut());
                                    }
                                    ((AdLoader) instance.getService(AdLoader.class)).init((JobRunner) instance.getService(cls2));
                                    if (Vungle._instance.consent.get() != null) {
                                        Vungle.saveGDPRConsent(repository, (Consent) Vungle._instance.consent.get(), Vungle._instance.consentVersion);
                                    } else {
                                        Cookie cookie = repository.load(Cookie.CONSENT_COOKIE, cls4).get();
                                        if (cookie == null) {
                                            Vungle._instance.consent.set((Object) null);
                                            String unused3 = Vungle._instance.consentVersion = null;
                                        } else {
                                            Vungle._instance.consent.set(Vungle.getConsent(cookie));
                                            String unused4 = Vungle._instance.consentVersion = Vungle.getConsentMessageVersion(cookie);
                                        }
                                    }
                                    if (Vungle._instance.ccpaStatus.get() != null) {
                                        Vungle.updateCCPAStatus(repository, (Consent) Vungle._instance.ccpaStatus.get());
                                    } else {
                                        Vungle._instance.ccpaStatus.set(Vungle.getCCPAStatus(repository.load(Cookie.CCPA_COOKIE, cls4).get()));
                                    }
                                    Cookie cookie2 = repository.load(Cookie.COPPA_COOKIE, cls4).get();
                                    if (cookie2 != null) {
                                        Vungle._instance.disableAdIdIfCoppa.set(cookie2.getBooleanOrNull(Cookie.COPPA_DISABLE_ID));
                                    }
                                    if (Vungle._instance.coppaStatus.get() != null) {
                                        Vungle.updateCOPPAStatus(((Boolean) Vungle._instance.coppaStatus.get()).booleanValue());
                                    } else if (cookie2 != null) {
                                        Vungle._instance.coppaStatus.set(cookie2.getBooleanOrNull(Cookie.COPPA_STATUS_KEY));
                                        ((VungleApiClient) instance.getService(cls)).setCoppaFlags(Vungle._instance.coppaStatus, Vungle._instance.disableAdIdIfCoppa);
                                    }
                                } catch (DatabaseHelper.DBException unused5) {
                                    Vungle.onInitError(initCallback, new VungleException(26));
                                    Vungle.deInit();
                                    return;
                                }
                            } else {
                                Vungle.onInitError(initCallback, new VungleException(16));
                                Vungle.deInit();
                                return;
                            }
                        }
                        Repository repository2 = (Repository) instance.getService(cls3);
                        Cookie cookie3 = repository2.load("appId", cls4).get();
                        if (cookie3 == null) {
                            cookie3 = new Cookie("appId");
                        }
                        cookie3.putValue("appId", str);
                        try {
                            repository2.save(cookie3);
                            Vungle._instance.configure(initCallback, false);
                            ((JobRunner) instance.getService(cls2)).execute(AnalyticsJob.makeJob(2, (String) null, (String[]) null, 1));
                        } catch (DatabaseHelper.DBException unused6) {
                            if (initCallback != null) {
                                Vungle.onInitError(initCallback, new VungleException(26));
                            }
                            Vungle.isInitializing.set(false);
                        }
                    }
                });
            } else {
                Log.e(TAG, "Network permissions not granted");
                onInitError(initCallback, new VungleException(34));
                isInitializing.set(false);
            }
        }
    }

    public static void loadAd(@NonNull String str, @Nullable String str2, @Nullable AdConfig adConfig, @Nullable LoadAdCallback loadAdCallback) {
        VungleLogger.debug("Vungle#loadAd", "loadAd API call invoked");
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            onLoadError(str, loadAdCallback, new VungleException(9));
        } else if (adConfig == null || AdConfig.AdSize.isDefaultAdSize(adConfig.getAdSize())) {
            loadAdInternal(str, AdMarkup.fromString(str2), adConfig, loadAdCallback);
        } else {
            onLoadError(str, loadAdCallback, new VungleException(29));
        }
    }

    public static void updateCCPAStatus(@NonNull final Repository repository, @NonNull final Consent consent2) {
        repository.load(Cookie.CCPA_COOKIE, Cookie.class, new Repository.LoadCallback<Cookie>() {
            public void onLoaded(Cookie cookie) {
                if (cookie == null) {
                    cookie = new Cookie(Cookie.CCPA_COOKIE);
                }
                cookie.putValue(Cookie.CCPA_CONSENT_STATUS, Consent.this == Consent.OPTED_OUT ? Cookie.CONSENT_STATUS_OPTED_OUT : Cookie.CONSENT_STATUS_OPTED_IN);
                repository.save(cookie, (Repository.SaveCallback) null, false);
            }
        });
    }

    public static boolean canPlayAd(Advertisement advertisement) {
        Context context2 = _instance.context;
        if (context2 == null) {
            return false;
        }
        return ((AdLoader) ServiceLocator.getInstance(context2).getService(AdLoader.class)).canPlayAd(advertisement);
    }
}
