package com.vungle.warren;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vungle.warren.AdConfig;
import com.vungle.warren.OperationSequence;
import com.vungle.warren.downloader.AssetDownloadListener;
import com.vungle.warren.downloader.AssetPriority;
import com.vungle.warren.downloader.DownloadRequest;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.AdAsset;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.JsonUtil;
import com.vungle.warren.model.Placement;
import com.vungle.warren.network.Call;
import com.vungle.warren.network.Callback;
import com.vungle.warren.network.Response;
import com.vungle.warren.omsdk.OMInjector;
import com.vungle.warren.p037ui.HackMraid;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.DownloadJob;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.FileUtility;
import com.vungle.warren.utility.UnzipUtility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class AdLoader {
    public static final boolean DEFAULT_LOAD_OPTIMIZATION_ENABLED = false;
    public static final String DOWNLOAD_AD_ASSETS_CONTEXT = "AdLoader#downloadAdAssets; loadAd sequence";
    public static final String DOWNLOAD_AD_CALLBACK_ON_DOWNLOAD_COMPLETED_CONTEXT = "AdLoader#DownloadAdCallback#onDownloadCompleted; loadAd sequence";
    public static final long EXPONENTIAL_RATE = 2;
    public static final String FETCH_AD_METADATA_CONTEXT = "AdLoader#fetchAdMetadata; loadAd sequence";
    public static final String GET_ASSET_DOWNLOAD_LISTENER_CONTEXT = "AdLoader#getAssetDownloadListener; loadAd sequence";
    public static final String LOAD_AD_EXECUTE_CONTEXT = "AdLoader#loadAd#execute; loadAd sequence";
    public static final String NOT_A_DIR = "not a dir";
    public static final String ON_ASSET_DOWNLOAD_FINISHED_CONTEXT = "AdLoader#onAssetDownloadFinished; loadAd sequence";
    public static final String OP_ID_AND_ADVERTISEMENT_FORMAT = "request = %1$s; advertisement = %2$s";
    public static final String PLACEMENT_ID_AND_ADVERTISEMENT_FORMAT_2_3 = "request = %2$s; advertisement = %3$s";
    public static final String PLACEMENT_ID_AND_ADVERTISEMENT_FORMAT_3_4 = "request = %3$s; advertisement = %4$s";
    public static final int RETRY_COUNT = 5;
    public static final long RETRY_DELAY = 2000;
    public static final String STRING_AND_OP_ID_FORMAT = "%1$s; request = %2$s";
    public static final String TAG = "com.vungle.warren.AdLoader";
    public static final String TT_DOWNLOAD_CONTEXT = "ttDownloadContext";
    public boolean adLoadOptimizationEnabled = false;
    @NonNull
    public final CacheManager cacheManager;
    @NonNull
    public final Downloader downloader;
    @NonNull
    public final AtomicReference<JobRunner> jobRunnerRef = new AtomicReference<>();
    public final Map<AdRequest, Operation> loadOperations = new ConcurrentHashMap();
    @NonNull
    public final OMInjector omInjector;
    public final Map<AdRequest, Operation> pendingOperations = new ConcurrentHashMap();
    @NonNull
    public final Repository repository;
    @NonNull
    public final RuntimeValues runtimeValues;
    @NonNull
    public final Executors sdkExecutors;
    public final OperationSequence sequence;
    @Nullable
    public AdRequest sequenceLoadingRequest = null;
    public final List<Operation> startingOperations = new CopyOnWriteArrayList();
    @NonNull
    public final VisionController visionController;
    @NonNull
    public final VungleStaticApi vungleApi;
    @NonNull
    public final VungleApiClient vungleApiClient;

    public class DownloadAdCallback implements DownloadCallback {
        public DownloadAdCallback() {
        }

        public void onDownloadCompleted(@NonNull AdRequest adRequest, @NonNull String str) {
            Advertisement advertisement;
            String access$1300 = AdLoader.TAG;
            Log.d(access$1300, "download completed " + adRequest);
            Placement placement = AdLoader.this.repository.load(adRequest.getPlacementId(), Placement.class).get();
            if (placement == null) {
                VungleLogger.error(AdLoader.DOWNLOAD_AD_CALLBACK_ON_DOWNLOAD_COMPLETED_CONTEXT, String.format("loaded placement is null: request = %1$s; advertisementId = %2$s", new Object[]{adRequest, str}));
                onDownloadFailed(new VungleException(13), adRequest, str);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                advertisement = null;
            } else {
                advertisement = AdLoader.this.repository.load(str, Advertisement.class).get();
            }
            if (advertisement == null) {
                VungleLogger.error(AdLoader.DOWNLOAD_AD_CALLBACK_ON_DOWNLOAD_COMPLETED_CONTEXT, String.format("advertisement is null: request = %1$s; advertisementId = %2$s", new Object[]{adRequest, str}));
                onDownloadFailed(new VungleException(11), adRequest, str);
                return;
            }
            advertisement.setFinishedDownloadingTime(System.currentTimeMillis());
            try {
                AdLoader.this.repository.saveAndApplyState(advertisement, adRequest.getPlacementId(), 1);
                onReady(adRequest, placement, advertisement);
            } catch (DatabaseHelper.DBException e) {
                VungleLogger.error(AdLoader.DOWNLOAD_AD_CALLBACK_ON_DOWNLOAD_COMPLETED_CONTEXT, String.format("Can't save/apply state READY: exception = %1$s;request = %2$s; advertisement = %3$s", new Object[]{e, adRequest, advertisement}));
                onDownloadFailed(new VungleException(26), adRequest, str);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:45:0x00d3 A[SYNTHETIC, Splitter:B:45:0x00d3] */
        /* JADX WARNING: Removed duplicated region for block: B:76:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onDownloadFailed(@androidx.annotation.NonNull com.vungle.warren.error.VungleException r12, @androidx.annotation.NonNull com.vungle.warren.AdRequest r13, @androidx.annotation.Nullable java.lang.String r14) {
            /*
                r11 = this;
                com.vungle.warren.AdLoader r0 = com.vungle.warren.AdLoader.this
                java.util.Map r0 = r0.loadOperations
                java.lang.Object r0 = r0.remove(r13)
                com.vungle.warren.AdLoader$Operation r0 = (com.vungle.warren.AdLoader.Operation) r0
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this
                r1.tryLoadNextInQueue(r13)
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this
                com.vungle.warren.persistence.Repository r1 = r1.repository
                java.lang.String r2 = r13.getPlacementId()
                java.lang.Class<com.vungle.warren.model.Placement> r3 = com.vungle.warren.model.Placement.class
                com.vungle.warren.persistence.FutureResult r1 = r1.load(r2, r3)
                java.lang.Object r1 = r1.get()
                com.vungle.warren.model.Placement r1 = (com.vungle.warren.model.Placement) r1
                if (r14 != 0) goto L_0x002b
                r14 = 0
                goto L_0x003d
            L_0x002b:
                com.vungle.warren.AdLoader r2 = com.vungle.warren.AdLoader.this
                com.vungle.warren.persistence.Repository r2 = r2.repository
                java.lang.Class<com.vungle.warren.model.Advertisement> r3 = com.vungle.warren.model.Advertisement.class
                com.vungle.warren.persistence.FutureResult r14 = r2.load(r14, r3)
                java.lang.Object r14 = r14.get()
                com.vungle.warren.model.Advertisement r14 = (com.vungle.warren.model.Advertisement) r14
            L_0x003d:
                r2 = 26
                r3 = 4
                r4 = 0
                if (r1 != 0) goto L_0x007a
                if (r14 == 0) goto L_0x0058
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0053 }
                com.vungle.warren.persistence.Repository r1 = r1.repository     // Catch:{ DBException -> 0x0053 }
                java.lang.String r5 = r13.getPlacementId()     // Catch:{ DBException -> 0x0053 }
                r1.saveAndApplyState(r14, r5, r3)     // Catch:{ DBException -> 0x0053 }
                goto L_0x0058
            L_0x0053:
                com.vungle.warren.error.VungleException r12 = new com.vungle.warren.error.VungleException
                r12.<init>(r2)
            L_0x0058:
                if (r0 == 0) goto L_0x0074
                java.util.Set<com.vungle.warren.LoadAdCallback> r14 = r0.loadAdCallbacks
                java.util.Iterator r14 = r14.iterator()
            L_0x0060:
                boolean r0 = r14.hasNext()
                if (r0 == 0) goto L_0x0074
                java.lang.Object r0 = r14.next()
                com.vungle.warren.LoadAdCallback r0 = (com.vungle.warren.LoadAdCallback) r0
                java.lang.String r1 = r13.getPlacementId()
                r0.onError(r1, r12)
                goto L_0x0060
            L_0x0074:
                com.vungle.warren.AdLoader r12 = com.vungle.warren.AdLoader.this
                r12.setLoading(r13, r4)
                return
            L_0x007a:
                int r1 = r12.getExceptionCode()
                r5 = 1
                if (r1 == r5) goto L_0x00a7
                r6 = 14
                if (r1 == r6) goto L_0x00a7
                r6 = 20
                if (r1 == r6) goto L_0x00a4
                r6 = 25
                if (r1 == r6) goto L_0x00a7
                r6 = 36
                if (r1 == r6) goto L_0x00a7
                r6 = 22
                if (r1 == r6) goto L_0x00a4
                r6 = 23
                if (r1 == r6) goto L_0x009a
                goto L_0x00a0
            L_0x009a:
                if (r14 == 0) goto L_0x00a0
                r1 = 0
                r6 = 1
                r7 = 0
                goto L_0x00a9
            L_0x00a0:
                r1 = 0
            L_0x00a1:
                r6 = 0
            L_0x00a2:
                r7 = 4
                goto L_0x00a9
            L_0x00a4:
                r1 = 0
                r6 = 1
                goto L_0x00a2
            L_0x00a7:
                r1 = 1
                goto L_0x00a1
            L_0x00a9:
                if (r0 == 0) goto L_0x00af
                boolean r8 = r0.logError
                if (r8 == 0) goto L_0x00cc
            L_0x00af:
                java.lang.String r8 = com.vungle.warren.AdLoader.TAG
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r10 = "Failed to load Ad/Assets for "
                r9.append(r10)
                r9.append(r13)
                java.lang.String r10 = ". Cause : "
                r9.append(r10)
                java.lang.String r9 = r9.toString()
                android.util.Log.e(r8, r9, r12)
            L_0x00cc:
                com.vungle.warren.AdLoader r8 = com.vungle.warren.AdLoader.this
                r8.setLoading(r13, r4)
                if (r0 == 0) goto L_0x0172
                int r8 = r0.policy     // Catch:{ DBException -> 0x0153 }
                r9 = 2
                if (r8 != 0) goto L_0x010b
                int r1 = r0.retry     // Catch:{ DBException -> 0x0153 }
                int r4 = r0.retryLimit     // Catch:{ DBException -> 0x0153 }
                if (r1 >= r4) goto L_0x0143
                if (r6 == 0) goto L_0x0143
                if (r14 == 0) goto L_0x00f0
                com.vungle.warren.AdLoader r12 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0153 }
                com.vungle.warren.persistence.Repository r12 = r12.repository     // Catch:{ DBException -> 0x0153 }
                java.lang.String r1 = r13.getPlacementId()     // Catch:{ DBException -> 0x0153 }
                r12.saveAndApplyState(r14, r1, r7)     // Catch:{ DBException -> 0x0153 }
            L_0x00f0:
                com.vungle.warren.AdLoader r12 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0153 }
                long r3 = r0.retryDelay     // Catch:{ DBException -> 0x0153 }
                com.vungle.warren.AdLoader$Operation r14 = r0.delay(r3)     // Catch:{ DBException -> 0x0153 }
                long r3 = r0.retryDelay     // Catch:{ DBException -> 0x0153 }
                long r3 = r3 * r9
                com.vungle.warren.AdLoader$Operation r14 = r14.retryDelay(r3)     // Catch:{ DBException -> 0x0153 }
                int r1 = r0.retry     // Catch:{ DBException -> 0x0153 }
                int r1 = r1 + r5
                com.vungle.warren.AdLoader$Operation r14 = r14.retry(r1)     // Catch:{ DBException -> 0x0153 }
                r12.load(r14)     // Catch:{ DBException -> 0x0153 }
                return
            L_0x010b:
                int r8 = r0.policy     // Catch:{ DBException -> 0x0153 }
                if (r8 != r5) goto L_0x0143
                if (r1 != 0) goto L_0x0143
                int r12 = r0.retry     // Catch:{ DBException -> 0x0153 }
                int r1 = r0.retryLimit     // Catch:{ DBException -> 0x0153 }
                if (r12 >= r1) goto L_0x011c
                if (r6 == 0) goto L_0x011c
                int r4 = r12 + 1
                r3 = r7
            L_0x011c:
                if (r14 == 0) goto L_0x012b
                com.vungle.warren.AdLoader r12 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0153 }
                com.vungle.warren.persistence.Repository r12 = r12.repository     // Catch:{ DBException -> 0x0153 }
                java.lang.String r1 = r13.getPlacementId()     // Catch:{ DBException -> 0x0153 }
                r12.saveAndApplyState(r14, r1, r3)     // Catch:{ DBException -> 0x0153 }
            L_0x012b:
                com.vungle.warren.AdLoader r12 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0153 }
                long r5 = r0.retryDelay     // Catch:{ DBException -> 0x0153 }
                com.vungle.warren.AdLoader$Operation r14 = r0.delay(r5)     // Catch:{ DBException -> 0x0153 }
                long r5 = r0.retryDelay     // Catch:{ DBException -> 0x0153 }
                long r5 = r5 * r9
                com.vungle.warren.AdLoader$Operation r14 = r14.retryDelay(r5)     // Catch:{ DBException -> 0x0153 }
                com.vungle.warren.AdLoader$Operation r14 = r14.retry(r4)     // Catch:{ DBException -> 0x0153 }
                r12.load(r14)     // Catch:{ DBException -> 0x0153 }
                return
            L_0x0143:
                if (r14 == 0) goto L_0x0158
                com.vungle.warren.AdLoader r1 = com.vungle.warren.AdLoader.this     // Catch:{ DBException -> 0x0153 }
                com.vungle.warren.persistence.Repository r1 = r1.repository     // Catch:{ DBException -> 0x0153 }
                java.lang.String r4 = r13.getPlacementId()     // Catch:{ DBException -> 0x0153 }
                r1.saveAndApplyState(r14, r4, r3)     // Catch:{ DBException -> 0x0153 }
                goto L_0x0158
            L_0x0153:
                com.vungle.warren.error.VungleException r12 = new com.vungle.warren.error.VungleException
                r12.<init>(r2)
            L_0x0158:
                java.util.Set<com.vungle.warren.LoadAdCallback> r14 = r0.loadAdCallbacks
                java.util.Iterator r14 = r14.iterator()
            L_0x015e:
                boolean r0 = r14.hasNext()
                if (r0 == 0) goto L_0x0172
                java.lang.Object r0 = r14.next()
                com.vungle.warren.LoadAdCallback r0 = (com.vungle.warren.LoadAdCallback) r0
                java.lang.String r1 = r13.getPlacementId()
                r0.onError(r1, r12)
                goto L_0x015e
            L_0x0172:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.DownloadAdCallback.onDownloadFailed(com.vungle.warren.error.VungleException, com.vungle.warren.AdRequest, java.lang.String):void");
        }

        public void onReady(@NonNull AdRequest adRequest, @NonNull Placement placement, @Nullable Advertisement advertisement) {
            AdLoader.this.setLoading(adRequest, false);
            HeaderBiddingCallback headerBiddingCallback = AdLoader.this.runtimeValues.headerBiddingCallback.get();
            if (!(advertisement == null || !placement.isHeaderBidding() || headerBiddingCallback == null)) {
                headerBiddingCallback.adAvailableForBidToken(adRequest.getPlacementId(), advertisement.getBidToken());
            }
            String access$1300 = AdLoader.TAG;
            Log.i(access$1300, "found already cached valid adv, calling onAdLoad callback for request " + adRequest);
            InitCallback initCallback = AdLoader.this.runtimeValues.initCallback.get();
            int type = adRequest.getType();
            if (placement.isAutoCached() && initCallback != null && (type == 2 || type == 0)) {
                initCallback.onAutoCacheAdAvailable(adRequest.getPlacementId());
            }
            Operation operation = (Operation) AdLoader.this.loadOperations.remove(adRequest);
            String id = advertisement != null ? advertisement.getId() : null;
            if (operation != null) {
                placement.setAdSize(operation.size);
                try {
                    AdLoader.this.repository.save(placement);
                    String access$13002 = AdLoader.TAG;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("loading took ");
                    outline24.append(System.currentTimeMillis() - adRequest.timeStamp.get());
                    outline24.append("ms for:");
                    outline24.append(adRequest);
                    Log.i(access$13002, outline24.toString());
                    for (LoadAdCallback onAdLoad : operation.loadAdCallbacks) {
                        onAdLoad.onAdLoad(adRequest.getPlacementId());
                    }
                } catch (DatabaseHelper.DBException e) {
                    VungleLogger.error("AdLoader#DownloadAdCallback#onReady; loadAd sequence", String.format("Can't save placement: exception = %1$s;placement = %2$s; advertisement = %3$s", new Object[]{e, placement, advertisement}));
                    onDownloadFailed(new VungleException(26), adRequest, id);
                }
            }
        }
    }

    public interface DownloadCallback {
        void onDownloadCompleted(@NonNull AdRequest adRequest, @NonNull String str);

        void onDownloadFailed(@NonNull VungleException vungleException, @NonNull AdRequest adRequest, @Nullable String str);

        void onReady(@NonNull AdRequest adRequest, @NonNull Placement placement, @Nullable Advertisement advertisement);
    }

    public static class Operation {
        public long delay;
        @NonNull
        public final Set<LoadAdCallback> loadAdCallbacks = new CopyOnWriteArraySet();
        @NonNull
        public final AtomicBoolean loading;
        public boolean logError;
        public int policy;
        @Priority
        public int priority;
        @NonNull
        public final AdRequest request;
        public List<DownloadRequest> requests = new CopyOnWriteArrayList();
        public int retry;
        public long retryDelay;
        public int retryLimit;
        @NonNull
        public final AdConfig.AdSize size;

        public Operation(@NonNull AdRequest adRequest, @NonNull AdConfig.AdSize adSize, long j, long j2, int i, int i2, int i3, boolean z, @Priority int i4, @Nullable LoadAdCallback... loadAdCallbackArr) {
            this.request = adRequest;
            this.delay = j;
            this.retryDelay = j2;
            this.retryLimit = i;
            this.policy = i2;
            this.retry = i3;
            this.loading = new AtomicBoolean();
            this.size = adSize;
            this.logError = z;
            this.priority = i4;
            if (loadAdCallbackArr != null) {
                this.loadAdCallbacks.addAll(Arrays.asList(loadAdCallbackArr));
            }
        }

        public Operation delay(long j) {
            return new Operation(this.request, this.size, j, this.retryDelay, this.retryLimit, this.policy, this.retry, this.logError, this.priority, (LoadAdCallback[]) this.loadAdCallbacks.toArray(new LoadAdCallback[0]));
        }

        public boolean getLogError() {
            return this.logError;
        }

        @Priority
        public int getPriority() {
            return this.priority;
        }

        @VisibleForTesting
        @NonNull
        public AdRequest getRequest() {
            return this.request;
        }

        @NonNull
        public AdConfig.AdSize getSize() {
            return this.size;
        }

        public void merge(Operation operation) {
            this.delay = Math.min(this.delay, operation.delay);
            this.retryDelay = Math.min(this.retryDelay, operation.retryDelay);
            this.retryLimit = Math.min(this.retryLimit, operation.retryLimit);
            int i = operation.policy;
            if (i != 0) {
                i = this.policy;
            }
            this.policy = i;
            this.retry = Math.min(this.retry, operation.retry);
            this.logError |= operation.logError;
            this.priority = Math.min(this.priority, operation.priority);
            this.loadAdCallbacks.addAll(operation.loadAdCallbacks);
        }

        public Operation retry(int i) {
            return new Operation(this.request, this.size, this.delay, this.retryDelay, this.retryLimit, this.policy, i, this.logError, this.priority, (LoadAdCallback[]) this.loadAdCallbacks.toArray(new LoadAdCallback[0]));
        }

        public Operation retryDelay(long j) {
            return new Operation(this.request, this.size, this.delay, j, this.retryLimit, this.policy, this.retry, this.logError, this.priority, (LoadAdCallback[]) this.loadAdCallbacks.toArray(new LoadAdCallback[0]));
        }

        @NonNull
        public String toString() {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("request=");
            outline24.append(this.request.toString());
            outline24.append(" size=");
            outline24.append(this.size.toString());
            outline24.append(" priority=");
            outline24.append(this.priority);
            outline24.append(" policy=");
            outline24.append(this.policy);
            outline24.append(" retry=");
            outline24.append(this.retry);
            outline24.append("/");
            outline24.append(this.retryLimit);
            outline24.append(" delay=");
            outline24.append(this.delay);
            outline24.append("->");
            outline24.append(this.retryDelay);
            outline24.append(" log=");
            outline24.append(this.logError);
            return outline24.toString();
        }
    }

    public @interface Priority {
        public static final int HIGH = 1;
        public static final int HIGHEST = 0;
        public static final int LOWEST = Integer.MAX_VALUE;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReschedulePolicy {
        public static final int EXPONENTIAL = 0;
        public static final int EXPONENTIAL_ENDLESS_AD = 1;
    }

    public AdLoader(@NonNull Executors executors, @NonNull Repository repository2, @NonNull VungleApiClient vungleApiClient2, @NonNull CacheManager cacheManager2, @NonNull Downloader downloader2, @NonNull RuntimeValues runtimeValues2, @NonNull VungleStaticApi vungleStaticApi, @NonNull VisionController visionController2, @NonNull OperationSequence operationSequence, @NonNull OMInjector oMInjector) {
        this.sdkExecutors = executors;
        this.repository = repository2;
        this.vungleApiClient = vungleApiClient2;
        this.cacheManager = cacheManager2;
        this.downloader = downloader2;
        this.runtimeValues = runtimeValues2;
        this.vungleApi = vungleStaticApi;
        this.visionController = visionController2;
        this.sequence = operationSequence;
        this.omInjector = oMInjector;
    }

    /* access modifiers changed from: private */
    public boolean canReDownload(Advertisement advertisement) {
        List<AdAsset> list;
        if (advertisement == null || ((advertisement.getState() != 0 && advertisement.getState() != 1) || (list = this.repository.loadAllAdAssets(advertisement.getId()).get()) == null || list.size() == 0)) {
            return false;
        }
        for (AdAsset adAsset : list) {
            if (adAsset.fileType == 1) {
                if (!fileIsValid(new File(adAsset.localPath), adAsset)) {
                    return false;
                }
            } else if (TextUtils.isEmpty(adAsset.serverPath)) {
                return false;
            }
        }
        return true;
    }

    private void checkAndUpdateHBPPlacementBannerSize(String str, final AdConfig.AdSize adSize) {
        this.repository.load(str, Placement.class, new Repository.LoadCallback<Placement>() {
            public void onLoaded(Placement placement) {
                AdConfig.AdSize adSize;
                if (placement != null && placement.isMultipleHBPEnabled() && placement.getPlacementAdType() == 1 && placement.getAdSize() != (adSize = adSize)) {
                    placement.setAdSize(adSize);
                    AdLoader.this.repository.save(placement, (Repository.SaveCallback) null, false);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void downloadAdAssets(com.vungle.warren.AdLoader.Operation r12, com.vungle.warren.model.Advertisement r13, com.vungle.warren.AdLoader.DownloadCallback r14) {
        /*
            r11 = this;
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r0 = r12.requests
            r0.clear()
            java.util.Map r0 = r13.getDownloadableUrls()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0011:
            boolean r1 = r0.hasNext()
            java.lang.String r2 = "AdLoader#downloadAdAssets; loadAd sequence"
            r3 = 0
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x007b
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r6 = r1.getKey()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0046
            java.lang.Object r6 = r1.getValue()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0046
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = android.webkit.URLUtil.isValidUrl(r1)
            if (r1 != 0) goto L_0x0011
        L_0x0046:
            java.lang.Object[] r0 = new java.lang.Object[r4]
            com.vungle.warren.AdRequest r1 = r12.request
            r0[r3] = r1
            r0[r5] = r13
            java.lang.String r1 = "One or more ad asset URLs is empty or not valid;request = %1$s; advertisement = %2$s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            com.vungle.warren.VungleLogger.error(r2, r0)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r1 = 11
            r0.<init>(r1)
            com.vungle.warren.AdRequest r12 = r12.request
            r1 = 0
            r14.onDownloadFailed(r0, r12, r1)
            java.lang.String r12 = TAG
            java.lang.String r14 = "Aborting, Failed to download Ad assets for: "
            java.lang.StringBuilder r14 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r14)
            java.lang.String r13 = r13.getId()
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            android.util.Log.e(r12, r13)
            return
        L_0x007b:
            com.vungle.warren.DownloadCallbackWrapper r6 = new com.vungle.warren.DownloadCallbackWrapper
            com.vungle.warren.utility.Executors r0 = r11.sdkExecutors
            java.util.concurrent.ExecutorService r0 = r0.getUIExecutor()
            r6.<init>(r0, r14)
            r0 = 26
            com.vungle.warren.persistence.Repository r1 = r11.repository     // Catch:{ DBException -> 0x01e6 }
            r1.save(r13)     // Catch:{ DBException -> 0x01e6 }
            com.vungle.warren.persistence.Repository r14 = r11.repository
            java.lang.String r1 = r13.getId()
            com.vungle.warren.persistence.FutureResult r14 = r14.loadAllAdAssets(r1)
            java.lang.Object r14 = r14.get()
            java.util.List r14 = (java.util.List) r14
            if (r14 != 0) goto L_0x00bf
            java.lang.Object[] r14 = new java.lang.Object[r4]
            com.vungle.warren.AdRequest r1 = r12.request
            r14[r3] = r1
            r14[r5] = r13
            java.lang.String r1 = "Cannot load all ad assets; op.request = %1$s; advertisement = %2$s"
            java.lang.String r14 = java.lang.String.format(r1, r14)
            com.vungle.warren.VungleLogger.error(r2, r14)
            com.vungle.warren.error.VungleException r14 = new com.vungle.warren.error.VungleException
            r14.<init>(r0)
            com.vungle.warren.AdRequest r12 = r12.request
            java.lang.String r13 = r13.getId()
            r6.onDownloadFailed(r14, r12, r13)
            return
        L_0x00bf:
            java.util.Iterator r14 = r14.iterator()
        L_0x00c3:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x0194
            java.lang.Object r1 = r14.next()
            com.vungle.warren.model.AdAsset r1 = (com.vungle.warren.model.AdAsset) r1
            int r7 = r1.status
            r8 = 3
            r9 = 24
            if (r7 != r8) goto L_0x0108
            java.io.File r7 = new java.io.File
            java.lang.String r8 = r1.localPath
            r7.<init>(r8)
            boolean r7 = r11.fileIsValid(r7, r1)
            if (r7 == 0) goto L_0x00e4
            goto L_0x00c3
        L_0x00e4:
            int r7 = r1.fileType
            if (r7 != r5) goto L_0x0108
            java.lang.Object[] r14 = new java.lang.Object[r4]
            com.vungle.warren.AdRequest r0 = r12.request
            r14[r3] = r0
            r14[r5] = r13
            java.lang.String r0 = "Cannot download ad assets - asset filetype is zip_asset;request = %1$s; advertisement = %2$s"
            java.lang.String r14 = java.lang.String.format(r0, r14)
            com.vungle.warren.VungleLogger.error(r2, r14)
            com.vungle.warren.error.VungleException r14 = new com.vungle.warren.error.VungleException
            r14.<init>(r9)
            com.vungle.warren.AdRequest r12 = r12.request
            java.lang.String r13 = r13.getId()
            r6.onDownloadFailed(r14, r12, r13)
            return
        L_0x0108:
            int r7 = r1.status
            r8 = 4
            if (r7 != r8) goto L_0x0112
            int r7 = r1.fileType
            if (r7 != 0) goto L_0x0112
            goto L_0x00c3
        L_0x0112:
            java.lang.String r7 = r1.serverPath
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x013a
            java.lang.Object[] r14 = new java.lang.Object[r4]
            com.vungle.warren.AdRequest r0 = r12.request
            r14[r3] = r0
            r14[r5] = r13
            java.lang.String r0 = "Cannot download ad assets - empty ;request = %1$s; advertisement = %2$s"
            java.lang.String r14 = java.lang.String.format(r0, r14)
            com.vungle.warren.VungleLogger.error(r2, r14)
            com.vungle.warren.error.VungleException r14 = new com.vungle.warren.error.VungleException
            r14.<init>(r9)
            com.vungle.warren.AdRequest r12 = r12.request
            java.lang.String r13 = r13.getId()
            r6.onDownloadFailed(r14, r12, r13)
            return
        L_0x013a:
            int r7 = r12.priority
            com.vungle.warren.downloader.DownloadRequest r7 = r11.getDownloadRequest(r7, r1)
            int r8 = r1.status
            if (r8 != r5) goto L_0x0151
            com.vungle.warren.downloader.Downloader r8 = r11.downloader
            r9 = 1000(0x3e8, double:4.94E-321)
            r8.cancelAndAwait(r7, r9)
            int r7 = r12.priority
            com.vungle.warren.downloader.DownloadRequest r7 = r11.getDownloadRequest(r7, r1)
        L_0x0151:
            java.lang.String r8 = TAG
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Starting download for "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r8, r9)
            r1.status = r5
            com.vungle.warren.persistence.Repository r8 = r11.repository     // Catch:{ DBException -> 0x0175 }
            r8.save(r1)     // Catch:{ DBException -> 0x0175 }
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r1 = r12.requests
            r1.add(r7)
            goto L_0x00c3
        L_0x0175:
            r14 = move-exception
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r3] = r1
            r4[r5] = r14
            java.lang.String r14 = "Can't save asset %1$s; exception = %2$s"
            java.lang.String r14 = java.lang.String.format(r14, r4)
            com.vungle.warren.VungleLogger.error(r2, r14)
            com.vungle.warren.error.VungleException r14 = new com.vungle.warren.error.VungleException
            r14.<init>(r0)
            com.vungle.warren.AdRequest r12 = r12.request
            java.lang.String r13 = r13.getId()
            r6.onDownloadFailed(r14, r12, r13)
            return
        L_0x0194:
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r14 = r12.requests
            int r14 = r14.size()
            if (r14 != 0) goto L_0x01ac
            java.lang.String r3 = r13.getId()
            java.util.List r4 = java.util.Collections.emptyList()
            r5 = 1
            r0 = r11
            r1 = r12
            r2 = r6
            r0.onAssetDownloadFinished(r1, r2, r3, r4, r5)
            return
        L_0x01ac:
            java.lang.String r14 = TAG
            java.lang.Object[] r0 = new java.lang.Object[r4]
            com.vungle.warren.AdRequest r1 = r12.request
            r0[r3] = r1
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0[r5] = r1
            java.lang.String r1 = "Start to download assets,  request = %1$s at: %2$d"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            java.lang.String r1 = "ttDownloadContext"
            com.vungle.warren.VungleLogger.verbose(r5, r14, r1, r0)
            com.vungle.warren.downloader.AssetDownloadListener r13 = r11.getAssetDownloadListener(r13, r12, r6)
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r12 = r12.requests
            java.util.Iterator r12 = r12.iterator()
        L_0x01d3:
            boolean r14 = r12.hasNext()
            if (r14 == 0) goto L_0x01e5
            java.lang.Object r14 = r12.next()
            com.vungle.warren.downloader.DownloadRequest r14 = (com.vungle.warren.downloader.DownloadRequest) r14
            com.vungle.warren.downloader.Downloader r0 = r11.downloader
            r0.download(r14, r13)
            goto L_0x01d3
        L_0x01e5:
            return
        L_0x01e6:
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.vungle.warren.AdRequest r4 = r12.request
            r1[r3] = r4
            r1[r5] = r13
            java.lang.String r3 = "Cannot save advertisement op.request = %1$s; advertisement = %2$s"
            java.lang.String r1 = java.lang.String.format(r3, r1)
            com.vungle.warren.VungleLogger.error(r2, r1)
            com.vungle.warren.error.VungleException r1 = new com.vungle.warren.error.VungleException
            r1.<init>(r0)
            com.vungle.warren.AdRequest r12 = r12.request
            java.lang.String r13 = r13.getId()
            r14.onDownloadFailed(r1, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.downloadAdAssets(com.vungle.warren.AdLoader$Operation, com.vungle.warren.model.Advertisement, com.vungle.warren.AdLoader$DownloadCallback):void");
    }

    /* access modifiers changed from: private */
    public void fetchAdMetadata(@NonNull Operation operation, @NonNull Placement placement, @NonNull DownloadCallback downloadCallback) {
        final HeaderBiddingCallback headerBiddingCallback = this.runtimeValues.headerBiddingCallback.get();
        final long currentTimeMillis = System.currentTimeMillis();
        VungleLogger.verbose(true, TAG, TT_DOWNLOAD_CONTEXT, String.format("Start to request ad, request = %1$s, at: %2$d", new Object[]{operation.request, Long.valueOf(currentTimeMillis)}));
        final Operation operation2 = operation;
        final DownloadCallback downloadCallback2 = downloadCallback;
        this.vungleApiClient.requestAd(operation.request.getPlacementId(), AdConfig.AdSize.isNonMrecBannerAdSize(operation.size) ? operation.size.getName() : "", placement.isHeaderBidding(), this.visionController.isEnabled() ? this.visionController.getPayload() : null).enqueue(new Callback<JsonObject>() {
            public void onFailure(Call<JsonObject> call, Throwable th) {
                VungleLogger.verbose(true, AdLoader.TAG, AdLoader.TT_DOWNLOAD_CONTEXT, String.format("Request ad failed, request = %1$s, elapsed time = %2$dms", new Object[]{operation2.request, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
                VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("failed to request ad, request = %1$s, throwable = %2$s", new Object[]{operation2.request, th}));
                downloadCallback2.onDownloadFailed(AdLoader.this.retrofitToVungleException(th), operation2.request, (String) null);
            }

            public void onResponse(Call<JsonObject> call, final Response<JsonObject> response) {
                VungleLogger.verbose(true, AdLoader.TAG, AdLoader.TT_DOWNLOAD_CONTEXT, String.format("Request ad got response, request = %1$s, elapsed time = %2$dms", new Object[]{operation2.request, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        int state;
                        Placement placement = AdLoader.this.repository.load(operation2.request.getPlacementId(), Placement.class).get();
                        if (placement == null) {
                            Log.e(AdLoader.TAG, "Placement metadata not found for requested advertisement.");
                            VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, "Placement metadata not found for requested advertisement. request = " + operation2.request);
                            downloadCallback2.onDownloadFailed(new VungleException(2), operation2.request, (String) null);
                        } else if (!response.isSuccessful()) {
                            long retryAfterHeaderValue = AdLoader.this.vungleApiClient.getRetryAfterHeaderValue(response);
                            if (retryAfterHeaderValue <= 0 || (!placement.isAutoCached() && !placement.isMultipleHBPEnabled())) {
                                Log.e(AdLoader.TAG, "Failed to retrieve advertisement information");
                                VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("Response was not successful, not retrying;request = %1$s; responseCode = %2$s", new Object[]{operation2.request, Integer.valueOf(response.code())}));
                                C18675 r0 = C18675.this;
                                downloadCallback2.onDownloadFailed(AdLoader.this.reposeCodeToVungleException(response.code()), operation2.request, (String) null);
                                return;
                            }
                            C18675 r4 = C18675.this;
                            AdLoader.this.loadEndlessIfNeeded(placement, operation2.size, retryAfterHeaderValue);
                            VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, "Response was not successful, retrying; request = " + operation2.request);
                            downloadCallback2.onDownloadFailed(new VungleException(14), operation2.request, (String) null);
                        } else {
                            JsonObject jsonObject = (JsonObject) response.body();
                            String access$1300 = AdLoader.TAG;
                            Log.d(access$1300, "Ads Response: " + jsonObject);
                            if (jsonObject == null || !jsonObject.has("ads") || jsonObject.get("ads").isJsonNull()) {
                                VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("Response has no ads; placement = %1$s;op.request = %2$s; response = %3$s", new Object[]{placement, operation2.request, jsonObject}));
                                downloadCallback2.onDownloadFailed(new VungleException(1), operation2.request, (String) null);
                                return;
                            }
                            JsonArray asJsonArray = jsonObject.getAsJsonArray("ads");
                            if (asJsonArray == null || asJsonArray.size() == 0) {
                                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Response was successful, but no ads; request = ");
                                outline24.append(operation2.request);
                                VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, outline24.toString());
                                downloadCallback2.onDownloadFailed(new VungleException(1), operation2.request, (String) null);
                                return;
                            }
                            JsonObject asJsonObject = asJsonArray.get(0).getAsJsonObject();
                            try {
                                Advertisement advertisement = new Advertisement(asJsonObject);
                                if (AdLoader.this.visionController.isEnabled()) {
                                    JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("ad_markup");
                                    if (JsonUtil.hasNonNull(asJsonObject2, VisionController.DATA_SCIENCE_CACHE)) {
                                        AdLoader.this.visionController.setDataScienceCache(asJsonObject2.get(VisionController.DATA_SCIENCE_CACHE).getAsString());
                                    } else {
                                        AdLoader.this.visionController.setDataScienceCache((String) null);
                                    }
                                }
                                Advertisement advertisement2 = AdLoader.this.repository.load(advertisement.getId(), Advertisement.class).get();
                                if (advertisement2 == null || !((state = advertisement2.getState()) == 0 || state == 1 || state == 2)) {
                                    if (placement.isHeaderBidding() && headerBiddingCallback != null) {
                                        headerBiddingCallback.onBidTokenAvailable(operation2.request.getPlacementId(), advertisement.getBidToken());
                                    }
                                    AdLoader.this.repository.deleteAdvertisement(advertisement.getId());
                                    Set<Map.Entry<String, String>> entrySet = advertisement.getDownloadableUrls().entrySet();
                                    File destinationDir = AdLoader.this.getDestinationDir(advertisement);
                                    if (destinationDir != null) {
                                        if (destinationDir.isDirectory()) {
                                            for (Map.Entry next : entrySet) {
                                                if (AdLoader.this.isUrlValid((String) next.getValue())) {
                                                    AdLoader.this.saveAsset(advertisement, destinationDir, (String) next.getKey(), (String) next.getValue());
                                                } else {
                                                    VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("Response was successful, but one of downloadable urls is neither http nor https : url = %1$s; op.request = %2$s, ad.getId() = %3$s", new Object[]{next.getValue(), operation2.request, advertisement.getId()}));
                                                    downloadCallback2.onDownloadFailed(new VungleException(11), operation2.request, advertisement.getId());
                                                    return;
                                                }
                                            }
                                            if (placement.getPlacementAdType() != 1 || (advertisement.getAdType() == 1 && "banner".equals(advertisement.getTemplateType()))) {
                                                advertisement.getAdConfig().setAdSize(operation2.size);
                                                advertisement.setAdRequestStartTime(currentTimeMillis);
                                                advertisement.setAssetDownloadStartTime(System.currentTimeMillis());
                                                AdLoader.this.repository.saveAndApplyState(advertisement, operation2.request.getPlacementId(), 0);
                                                int type = operation2.request.getType();
                                                if (type != 0) {
                                                    if (type != 2) {
                                                        if (operation2.request.getType() != 1) {
                                                            return;
                                                        }
                                                        if (AdLoader.this.isReadyForHBP(operation2, AdLoader.this.repository)) {
                                                            AdLoader.this.tryLoadNextInQueue(operation2.request);
                                                            downloadCallback2.onReady(operation2.request, placement, (Advertisement) null);
                                                            return;
                                                        }
                                                        AdLoader.this.fetchAdMetadata(operation2, placement, downloadCallback2);
                                                        return;
                                                    }
                                                }
                                                AdLoader.this.tryLoadNextInQueue(operation2.request);
                                                AdLoader.this.downloadAdAssets(operation2, advertisement, downloadCallback2);
                                                return;
                                            }
                                            Object[] objArr = new Object[3];
                                            objArr[0] = advertisement.getAdType() != 1 ? "ad type is not MRAID" : "advertisement template type is not banner";
                                            objArr[1] = operation2.request;
                                            objArr[2] = advertisement.getId();
                                            VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("Response was successful, but placement is banner while %1$s; op.request = %2$s, ad.getId() = %3$s", objArr));
                                            downloadCallback2.onDownloadFailed(new VungleException(1), operation2.request, advertisement.getId());
                                            return;
                                        }
                                    }
                                    Object[] objArr2 = new Object[3];
                                    objArr2[0] = destinationDir == null ? "null" : AdLoader.NOT_A_DIR;
                                    objArr2[1] = operation2.request;
                                    objArr2[2] = advertisement.getId();
                                    VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("Response was successful, but adv directory is %1$s; op.request = %2$s, ad.getId() = %3$s", objArr2));
                                    downloadCallback2.onDownloadFailed(new VungleException(26), operation2.request, advertisement.getId());
                                    return;
                                }
                                Log.d(AdLoader.TAG, "Operation Cancelled");
                                downloadCallback2.onDownloadFailed(new VungleException(25), operation2.request, (String) null);
                            } catch (IllegalArgumentException unused) {
                                JsonObject asJsonObject3 = asJsonObject.getAsJsonObject("ad_markup");
                                if (asJsonObject3.has("sleep")) {
                                    long asInt = (long) asJsonObject3.get("sleep").getAsInt();
                                    placement.snooze(asInt);
                                    try {
                                        VungleLogger.warn(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("badAd - snoozed placement %1$s; request = %2$s", new Object[]{placement, operation2.request}));
                                        AdLoader.this.repository.save(placement);
                                        C18675 r6 = C18675.this;
                                        AdLoader.this.loadEndlessIfNeeded(placement, operation2.size, asInt * 1000);
                                    } catch (DatabaseHelper.DBException unused2) {
                                        VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("badAd - can't save snoozed placement %1$s; request = %2$s", new Object[]{placement, operation2.request}));
                                        downloadCallback2.onDownloadFailed(new VungleException(26), operation2.request, (String) null);
                                        return;
                                    }
                                }
                                VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("badAd; can't proceed %1$s; request = %2$s", new Object[]{placement, operation2.request}));
                                downloadCallback2.onDownloadFailed(new VungleException(1), operation2.request, (String) null);
                            } catch (DatabaseHelper.DBException e) {
                                VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("BadAd - DBException; can't proceed; placement = %1$s; op.request = %2$s; exception = %3$s", new Object[]{placement, operation2.request, e}));
                                downloadCallback2.onDownloadFailed(new VungleException(26), operation2.request, (String) null);
                            }
                        }
                    }
                });
            }
        });
    }

    private boolean fileIsValid(File file, AdAsset adAsset) {
        return file.exists() && file.length() == adAsset.fileSize;
    }

    @NonNull
    private AssetDownloadListener getAssetDownloadListener(final Advertisement advertisement, final Operation operation, final DownloadCallback downloadCallback) {
        return new AssetDownloadListener() {
            public AtomicLong downloadCount = new AtomicLong((long) operation.requests.size());
            public List<AssetDownloadListener.DownloadError> errors = Collections.synchronizedList(new ArrayList());

            public void onError(@NonNull final AssetDownloadListener.DownloadError downloadError, @Nullable final DownloadRequest downloadRequest) {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        AdAsset adAsset;
                        Log.e(AdLoader.TAG, "Download Failed");
                        DownloadRequest downloadRequest = downloadRequest;
                        if (downloadRequest != null) {
                            String str = downloadRequest.cookieString;
                            if (TextUtils.isEmpty(str)) {
                                adAsset = null;
                            } else {
                                adAsset = AdLoader.this.repository.load(str, AdAsset.class).get();
                            }
                            if (adAsset != null) {
                                C18696.this.errors.add(downloadError);
                                adAsset.status = 2;
                                try {
                                    AdLoader.this.repository.save(adAsset);
                                } catch (DatabaseHelper.DBException unused) {
                                    C18696.this.errors.add(new AssetDownloadListener.DownloadError(-1, new VungleException(26), 4));
                                }
                            } else {
                                C18696.this.errors.add(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), 1));
                            }
                        } else {
                            C18696.this.errors.add(new AssetDownloadListener.DownloadError(-1, new RuntimeException("error in request"), 4));
                        }
                        if (C18696.this.downloadCount.decrementAndGet() <= 0) {
                            C18696 r0 = C18696.this;
                            AdLoader.this.onAssetDownloadFinished(operation, downloadCallback, advertisement.getId(), C18696.this.errors, true);
                        }
                    }
                });
            }

            public void onProgress(@NonNull AssetDownloadListener.Progress progress, @NonNull DownloadRequest downloadRequest) {
            }

            public void onSuccess(@NonNull final File file, @NonNull final DownloadRequest downloadRequest) {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        AdAsset adAsset;
                        if (!file.exists()) {
                            VungleLogger.error(AdLoader.GET_ASSET_DOWNLOAD_LISTENER_CONTEXT, String.format("Downloaded file %1$s doesn't exist", new Object[]{file.getPath()}));
                            C18696.this.onError(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), 3), downloadRequest);
                            return;
                        }
                        String str = downloadRequest.cookieString;
                        if (str == null) {
                            adAsset = null;
                        } else {
                            adAsset = AdLoader.this.repository.load(str, AdAsset.class).get();
                        }
                        if (adAsset == null) {
                            Object[] objArr = new Object[2];
                            objArr[0] = str == null ? "id is null" : "repository returned null";
                            objArr[1] = downloadRequest;
                            VungleLogger.error(AdLoader.GET_ASSET_DOWNLOAD_LISTENER_CONTEXT, String.format("adAsset is null because %1$s, downloadRequest = %2$s", objArr));
                            C18696.this.onError(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), 1), downloadRequest);
                            return;
                        }
                        adAsset.fileType = AdLoader.this.isZip(file) ? 0 : 2;
                        adAsset.fileSize = file.length();
                        adAsset.status = 3;
                        try {
                            AdLoader.this.repository.save(adAsset);
                            if (AdLoader.this.isZip(file)) {
                                C18696 r0 = C18696.this;
                                boolean unused = AdLoader.this.injectOMIfNeeded(operation, advertisement, downloadCallback);
                                C18696 r02 = C18696.this;
                                AdLoader.this.processTemplate(operation, downloadCallback, adAsset, advertisement);
                            }
                            if (C18696.this.downloadCount.decrementAndGet() <= 0) {
                                C18696 r03 = C18696.this;
                                AdLoader adLoader = AdLoader.this;
                                Operation operation = operation;
                                DownloadCallback downloadCallback = downloadCallback;
                                String id = advertisement.getId();
                                C18696 r04 = C18696.this;
                                adLoader.onAssetDownloadFinished(operation, downloadCallback, id, r04.errors, !AdLoader.this.isAdLoadOptimizationEnabled(advertisement));
                            }
                        } catch (DatabaseHelper.DBException e) {
                            VungleLogger.error(AdLoader.GET_ASSET_DOWNLOAD_LISTENER_CONTEXT, String.format("Can't save adAsset %1$s; exception = %2$s", new Object[]{adAsset, e}));
                            C18696.this.onError(new AssetDownloadListener.DownloadError(-1, new VungleException(26), 4), downloadRequest);
                        }
                    }
                });
            }
        };
    }

    private AssetPriority getAssetPriority(@Priority int i, @NonNull String str) {
        return new AssetPriority(Math.max(-2147483646, i), getAssetPriority(str, this.adLoadOptimizationEnabled));
    }

    private DownloadRequest getDownloadRequest(@Priority int i, AdAsset adAsset) {
        return new DownloadRequest(3, getAssetPriority(i, adAsset.localPath), adAsset.serverPath, adAsset.localPath, false, adAsset.identifier);
    }

    /* access modifiers changed from: private */
    public boolean injectOMIfNeeded(@NonNull Operation operation, @NonNull Advertisement advertisement, @NonNull DownloadCallback downloadCallback) {
        if (advertisement.getOmEnabled()) {
            try {
                File destinationDir = getDestinationDir(advertisement);
                if (destinationDir != null) {
                    if (destinationDir.isDirectory()) {
                        for (File next : this.omInjector.injectJsFiles(destinationDir)) {
                            AdAsset adAsset = new AdAsset(advertisement.getId(), (String) null, next.getPath());
                            adAsset.fileSize = next.length();
                            adAsset.fileType = 2;
                            adAsset.status = 3;
                            this.repository.save(adAsset);
                        }
                    }
                }
                Object[] objArr = new Object[3];
                objArr[0] = destinationDir == null ? "null" : NOT_A_DIR;
                objArr[1] = operation.request;
                objArr[2] = advertisement;
                VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Mraid ad; bad destinationDir - %1$srequest = %2$s; advertisement = %3$s", objArr));
                downloadCallback.onDownloadFailed(new VungleException(26), operation.request, advertisement.getId());
                return false;
            } catch (IOException unused) {
                downloadCallback.onDownloadFailed(new VungleException(24), operation.request, advertisement.getId());
                return false;
            } catch (DatabaseHelper.DBException unused2) {
                downloadCallback.onDownloadFailed(new VungleException(26), operation.request, advertisement.getId());
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean isAdLoadOptimizationEnabled(Advertisement advertisement) {
        return this.adLoadOptimizationEnabled && advertisement != null && advertisement.getAdType() == 1;
    }

    /* access modifiers changed from: private */
    public boolean isReadyForHBP(@NonNull Operation operation, @NonNull Repository repository2) {
        List list = repository2.findValidAdvertisementsForPlacement(operation.request.getPlacementId(), (String) null).get();
        return list != null && ((long) list.size()) >= operation.request.getAdCount();
    }

    /* access modifiers changed from: private */
    public boolean isSizeInvalid(Placement placement, AdConfig.AdSize adSize) {
        if (placement.getPlacementAdType() == 1 && !AdConfig.AdSize.isNonMrecBannerAdSize(adSize)) {
            return true;
        }
        if (placement.getPlacementAdType() != 0 || AdConfig.AdSize.isDefaultAdSize(adSize)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean isUrlValid(String str) {
        return !TextUtils.isEmpty(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str));
    }

    /* access modifiers changed from: private */
    public boolean isZip(File file) {
        return file.getName().equals(Advertisement.KEY_POSTROLL) || file.getName().equals("template");
    }

    private void loadAd(@NonNull Operation operation, @NonNull DownloadCallbackWrapper downloadCallbackWrapper) {
        final long currentTimeMillis = System.currentTimeMillis();
        final DownloadCallbackWrapper downloadCallbackWrapper2 = downloadCallbackWrapper;
        final Operation operation2 = operation;
        this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                Advertisement advertisement;
                List<Advertisement> list;
                if (!AdLoader.this.vungleApi.isInitialized()) {
                    VungleLogger.error(AdLoader.LOAD_AD_EXECUTE_CONTEXT, "Vungle is not initialized");
                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(9), operation2.request, (String) null);
                    return;
                }
                Placement placement = AdLoader.this.repository.load(operation2.request.getPlacementId(), Placement.class).get();
                if (placement == null) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("placement not found for ");
                    outline24.append(operation2.request);
                    VungleLogger.error(AdLoader.LOAD_AD_EXECUTE_CONTEXT, outline24.toString());
                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(13), operation2.request, (String) null);
                } else if (!placement.isValid()) {
                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(5), operation2.request, (String) null);
                } else if (AdLoader.this.isSizeInvalid(placement, operation2.size)) {
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("size is invalid, size = ");
                    outline242.append(operation2.size);
                    VungleLogger.error(AdLoader.LOAD_AD_EXECUTE_CONTEXT, outline242.toString());
                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(28), operation2.request, (String) null);
                } else {
                    if (placement.getPlacementAdType() == 1 && !placement.isMultipleHBPEnabled() && (list = AdLoader.this.repository.findValidAdvertisementsForPlacement(placement.getId(), operation2.request.getEventId()).get()) != null) {
                        boolean z = false;
                        for (Advertisement advertisement2 : list) {
                            if (advertisement2.getAdConfig().getAdSize() != operation2.size) {
                                try {
                                    AdLoader.this.repository.deleteAdvertisement(advertisement2.getId());
                                    z = true;
                                } catch (DatabaseHelper.DBException unused) {
                                    StringBuilder outline243 = GeneratedOutlineSupport.outline24("cannot delete advertisement, request = ");
                                    outline243.append(operation2.request);
                                    VungleLogger.error(AdLoader.LOAD_AD_EXECUTE_CONTEXT, outline243.toString());
                                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(26), operation2.request, (String) null);
                                    return;
                                }
                            }
                        }
                        if (z) {
                            AdLoader.this.loadEndlessIfNeeded(placement, operation2.size, 0);
                        }
                    }
                    int type = operation2.request.getType();
                    if (type == 0 || type == 2) {
                        String eventId = operation2.request.getEventId();
                        advertisement = AdLoader.this.repository.findValidAdvertisementForPlacement(placement.getId(), eventId).get();
                        if (placement.isMultipleHBPEnabled() && operation2.request.getType() == 0) {
                            if (eventId == null) {
                                downloadCallbackWrapper2.onDownloadFailed(new VungleException(36), operation2.request, (String) null);
                                return;
                            } else if (advertisement == null) {
                                downloadCallbackWrapper2.onDownloadFailed(new VungleException(10), operation2.request, (String) null);
                                return;
                            }
                        }
                        if (advertisement != null && AdLoader.this.canPlayAd(advertisement)) {
                            AdLoader.this.tryLoadNextInQueue(operation2.request);
                            downloadCallbackWrapper2.onReady(operation2.request, placement, advertisement);
                            return;
                        } else if (AdLoader.this.canReDownload(advertisement)) {
                            Log.d(AdLoader.TAG, "Found valid adv but not ready - downloading content");
                            VungleSettings vungleSettings = AdLoader.this.runtimeValues.settings.get();
                            if (vungleSettings == null || AdLoader.this.cacheManager.getBytesAvailable() < vungleSettings.getMinimumSpaceForAd()) {
                                if (advertisement.getState() != 4) {
                                    try {
                                        AdLoader.this.repository.saveAndApplyState(advertisement, operation2.request.getPlacementId(), 4);
                                    } catch (DatabaseHelper.DBException unused2) {
                                        StringBuilder outline244 = GeneratedOutlineSupport.outline24("cannot save/apply ERROR state, request = ");
                                        outline244.append(operation2.request);
                                        VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence; canReDownload branch", outline244.toString());
                                        downloadCallbackWrapper2.onDownloadFailed(new VungleException(26), operation2.request, (String) null);
                                        return;
                                    }
                                }
                                StringBuilder outline245 = GeneratedOutlineSupport.outline24("failed to download assets, no space; request = ");
                                outline245.append(operation2.request);
                                VungleLogger.error(AdLoader.LOAD_AD_EXECUTE_CONTEXT, outline245.toString());
                                downloadCallbackWrapper2.onDownloadFailed(new VungleException(19), operation2.request, (String) null);
                                return;
                            }
                            AdLoader.this.setLoading(operation2.request, true);
                            if (advertisement.getState() != 0) {
                                try {
                                    AdLoader.this.repository.saveAndApplyState(advertisement, operation2.request.getPlacementId(), 0);
                                } catch (DatabaseHelper.DBException unused3) {
                                    StringBuilder outline246 = GeneratedOutlineSupport.outline24("cannot save/apply NEW state, request = ");
                                    outline246.append(operation2.request);
                                    VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence; canReDownload branch", outline246.toString());
                                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(26), operation2.request, (String) null);
                                    return;
                                }
                            }
                            advertisement.setAdRequestStartTime(currentTimeMillis);
                            advertisement.setAssetDownloadStartTime(System.currentTimeMillis());
                            AdLoader.this.tryLoadNextInQueue(operation2.request);
                            AdLoader.this.downloadAdAssets(operation2, advertisement, downloadCallbackWrapper2);
                            return;
                        }
                    } else {
                        if (operation2.request.getType() == 1) {
                            AdLoader adLoader = AdLoader.this;
                            if (adLoader.isReadyForHBP(operation2, adLoader.repository)) {
                                AdLoader.this.tryLoadNextInQueue(operation2.request);
                                downloadCallbackWrapper2.onReady(operation2.request, placement, (Advertisement) null);
                                return;
                            }
                        }
                        advertisement = null;
                    }
                    if (placement.getWakeupTime() > System.currentTimeMillis()) {
                        downloadCallbackWrapper2.onDownloadFailed(new VungleException(1), operation2.request, (String) null);
                        VungleLogger.warn("AdLoader#loadAd#execute; loadAd sequence; snoozed branch", String.format("Placement with id %s is snoozed ", new Object[]{placement.getId()}));
                        String access$1300 = AdLoader.TAG;
                        StringBuilder outline247 = GeneratedOutlineSupport.outline24("Placement ");
                        outline247.append(placement.getId());
                        outline247.append(" is  snoozed");
                        Log.w(access$1300, outline247.toString());
                        String access$13002 = AdLoader.TAG;
                        StringBuilder outline248 = GeneratedOutlineSupport.outline24("Placement ");
                        outline248.append(placement.getId());
                        outline248.append(" is sleeping rescheduling it ");
                        Log.d(access$13002, outline248.toString());
                        AdLoader.this.loadEndlessIfNeeded(placement, operation2.size, placement.getWakeupTime() - System.currentTimeMillis());
                        return;
                    }
                    String str = operation2.request.getType() == 1 ? "advs" : "adv";
                    String access$13003 = AdLoader.TAG;
                    StringBuilder outline27 = GeneratedOutlineSupport.outline27("didn't find cached ", str, " for ");
                    outline27.append(operation2.request);
                    outline27.append(" downloading");
                    Log.i(access$13003, outline27.toString());
                    if (advertisement != null) {
                        try {
                            AdLoader.this.repository.saveAndApplyState(advertisement, operation2.request.getPlacementId(), 4);
                        } catch (DatabaseHelper.DBException unused4) {
                            StringBuilder outline249 = GeneratedOutlineSupport.outline24("cannot save/apply ERROR state, request = ");
                            outline249.append(operation2.request);
                            VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence; last else branch", outline249.toString());
                            downloadCallbackWrapper2.onDownloadFailed(new VungleException(26), operation2.request, (String) null);
                            return;
                        }
                    }
                    VungleSettings vungleSettings2 = AdLoader.this.runtimeValues.settings.get();
                    if (vungleSettings2 == null || AdLoader.this.cacheManager.getBytesAvailable() >= vungleSettings2.getMinimumSpaceForAd()) {
                        String access$13004 = AdLoader.TAG;
                        StringBuilder outline272 = GeneratedOutlineSupport.outline27("No ", str, " for placement ");
                        outline272.append(placement.getId());
                        outline272.append(" getting new data ");
                        Log.d(access$13004, outline272.toString());
                        AdLoader.this.setLoading(operation2.request, true);
                        AdLoader.this.fetchAdMetadata(operation2, placement, downloadCallbackWrapper2);
                        return;
                    }
                    VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence; last else branch", String.format("no space to load, isAutoCached = %1$s, request = %2$s", new Object[]{Boolean.valueOf(placement.isAutoCached()), operation2.request}));
                    downloadCallbackWrapper2.onDownloadFailed(new VungleException(placement.isAutoCached() ? 18 : 17), operation2.request, (String) null);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void onAssetDownloadFinished(@NonNull Operation operation, @NonNull DownloadCallback downloadCallback, @NonNull String str, @NonNull List<AssetDownloadListener.DownloadError> list, boolean z) {
        Operation operation2 = operation;
        DownloadCallback downloadCallback2 = downloadCallback;
        String str2 = str;
        VungleLogger.verbose(true, TAG, TT_DOWNLOAD_CONTEXT, String.format("Assets download completed, request  = %1$s, at: %2$d", new Object[]{operation2.request, Long.valueOf(System.currentTimeMillis())}));
        if (list.isEmpty()) {
            Advertisement advertisement = this.repository.load(str2, Advertisement.class).get();
            if (advertisement == null) {
                VungleLogger.error(DOWNLOAD_AD_CALLBACK_ON_DOWNLOAD_COMPLETED_CONTEXT, String.format("advertisement is null: request = %1$s; advertisementId = %2$s", new Object[]{operation2.request, str2}));
                downloadCallback2.onDownloadFailed(new VungleException(11), operation2.request, str2);
                return;
            }
            List<AdAsset> list2 = this.repository.loadAllAdAssets(str2).get();
            String str3 = "null";
            if (list2 == null || list2.size() == 0) {
                Object[] objArr = new Object[3];
                if (list2 != null) {
                    str3 = "empty";
                }
                objArr[0] = str3;
                objArr[1] = operation2.request;
                objArr[2] = str2;
                VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Assets are %1$s; request = %2$s; advertisement = %3$s", objArr));
                if (z) {
                    downloadCallback2.onDownloadFailed(new VungleException(24), operation2.request, str2);
                    return;
                }
                return;
            }
            for (AdAsset adAsset : list2) {
                int i = adAsset.status;
                if (i == 3) {
                    File file = new File(adAsset.localPath);
                    if (!fileIsValid(file, adAsset)) {
                        VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Assets file not valid %1$s; asset = %2$s,request = %3$s; advertisement = %4$s", new Object[]{file.getPath(), adAsset.toString(), operation2.request, advertisement}));
                        if (z) {
                            downloadCallback2.onDownloadFailed(new VungleException(24), operation2.request, advertisement.getId());
                            return;
                        }
                        return;
                    }
                } else if (adAsset.fileType == 0 && i != 4) {
                    VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Zip asset left unprocessed asset = %1$s,request = %2$s; advertisement = %3$s", new Object[]{adAsset.toString(), operation2.request, advertisement}));
                    downloadCallback2.onDownloadFailed(new VungleException(24), operation2.request, advertisement.getId());
                    return;
                }
            }
            if (advertisement.getAdType() == 1) {
                File destinationDir = getDestinationDir(advertisement);
                if (destinationDir == null || !destinationDir.isDirectory()) {
                    Object[] objArr2 = new Object[3];
                    if (destinationDir != null) {
                        str3 = NOT_A_DIR;
                    }
                    objArr2[0] = str3;
                    objArr2[1] = operation2.request;
                    objArr2[2] = advertisement;
                    VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Mraid ad; bad destinationDir - %1$srequest = %2$s; advertisement = %3$s", objArr2));
                    if (z) {
                        downloadCallback2.onDownloadFailed(new VungleException(26), operation2.request, advertisement.getId());
                        return;
                    }
                    return;
                }
                String str4 = TAG;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("saving MRAID for ");
                outline24.append(advertisement.getId());
                Log.d(str4, outline24.toString());
                advertisement.setMraidAssetDir(destinationDir);
                try {
                    this.repository.save(advertisement);
                } catch (DatabaseHelper.DBException e) {
                    VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Issue(s) with database: can't save advertisement;exception = %1$s; request = %2$s; advertisement = %3$s", new Object[]{e, operation2.request, advertisement}));
                    if (z) {
                        downloadCallback2.onDownloadFailed(new VungleException(26), operation2.request, advertisement.getId());
                        return;
                    }
                    return;
                }
            }
            if (z) {
                downloadCallback2.onDownloadCompleted(operation2.request, advertisement.getId());
                return;
            }
            return;
        }
        VungleException vungleException = null;
        Iterator<AssetDownloadListener.DownloadError> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AssetDownloadListener.DownloadError next = it.next();
            if (VungleException.getExceptionCode(next.cause) != 26) {
                if (recoverableServerCode(next.serverCode) && next.reason == 1) {
                    vungleException = new VungleException(23);
                } else if (next.reason == 0) {
                    vungleException = new VungleException(23);
                } else {
                    vungleException = new VungleException(24);
                }
                if (vungleException.getExceptionCode() == 24) {
                    break;
                }
            } else {
                vungleException = new VungleException(26);
                break;
            }
        }
        if (z) {
            downloadCallback2.onDownloadFailed(vungleException, operation2.request, str2);
        }
    }

    /* access modifiers changed from: private */
    public void onChangePriority(Operation operation) {
        for (DownloadRequest next : operation.requests) {
            next.setPriority(getAssetPriority(operation.priority, next.path));
            this.downloader.updatePriority(next);
        }
    }

    /* access modifiers changed from: private */
    public void onError(@Nullable Operation operation, @VungleException.ExceptionCode int i) {
        Object[] objArr = new Object[2];
        objArr[0] = new VungleException(i);
        objArr[1] = operation != null ? operation : "null";
        VungleLogger.error("AdLoader#onError; loadAd sequence", String.format("Error %1$s occured; operation is %2$s", objArr));
        if (operation != null) {
            for (LoadAdCallback onError : operation.loadAdCallbacks) {
                onError.onError(operation.request.getPlacementId(), new VungleException(i));
            }
        }
    }

    /* access modifiers changed from: private */
    public void processTemplate(@NonNull Operation operation, @NonNull DownloadCallback downloadCallback, @NonNull AdAsset adAsset, @NonNull Advertisement advertisement) {
        Operation operation2 = operation;
        DownloadCallback downloadCallback2 = downloadCallback;
        AdAsset adAsset2 = adAsset;
        Advertisement advertisement2 = advertisement;
        if (adAsset2.status != 3) {
            downloadCallback2.onDownloadFailed(new VungleException(24), operation2.request, advertisement.getId());
            return;
        }
        File file = new File(adAsset2.localPath);
        if (!fileIsValid(file, adAsset2)) {
            VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Assets file not valid %1$s; asset = %2$s,request = %3$s; advertisement = %4$s", new Object[]{file.getPath(), adAsset.toString(), operation2.request, advertisement2}));
            downloadCallback2.onDownloadFailed(new VungleException(24), operation2.request, advertisement.getId());
            return;
        }
        if (adAsset2.fileType == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            VungleLogger.verbose(true, TAG, TT_DOWNLOAD_CONTEXT, String.format("Start to unzip assets, request  = %1$s, at: %2$d", new Object[]{operation2.request, Long.valueOf(currentTimeMillis)}));
            try {
                unzipFile(advertisement2, adAsset2, file, this.repository.loadAllAdAssets(advertisement.getId()).get());
                VungleLogger.verbose(true, TAG, TT_DOWNLOAD_CONTEXT, String.format("Unzip assets completed, request  = %1$s, elapsed time = %2$dms", new Object[]{operation2.request, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
            } catch (IOException unused) {
                VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Unzip failed %1$s; asset = %2$s,request = %3$s; advertisement = %4$s", new Object[]{file.getPath(), adAsset.toString(), operation2.request, advertisement2}));
                this.downloader.dropCache(adAsset2.serverPath);
                downloadCallback2.onDownloadFailed(new VungleException(24), operation2.request, advertisement.getId());
                return;
            } catch (DatabaseHelper.DBException e) {
                VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Issue(s) with database: exception = %1$s; asset = %2$s,request = %3$s; advertisement = %4$s", new Object[]{e, adAsset.toString(), operation2.request, advertisement2}));
                downloadCallback2.onDownloadFailed(new VungleException(26), operation2.request, advertisement.getId());
                return;
            }
        }
        if (isAdLoadOptimizationEnabled(advertisement2)) {
            VungleLogger.verbose(true, TAG, TT_DOWNLOAD_CONTEXT, String.format("Ad ready to play, request  = %1$s, elapsed time = %2$dms", new Object[]{operation2.request, Long.valueOf(System.currentTimeMillis() - advertisement2.adRequestStartTime)}));
            downloadCallback2.onDownloadCompleted(operation2.request, advertisement.getId());
        }
    }

    private boolean recoverableServerCode(int i) {
        return i == 408 || (500 <= i && i < 600);
    }

    /* access modifiers changed from: private */
    public VungleException reposeCodeToVungleException(int i) {
        if (recoverableServerCode(i)) {
            return new VungleException(22);
        }
        return new VungleException(21);
    }

    /* access modifiers changed from: private */
    public VungleException retrofitToVungleException(Throwable th) {
        if (th instanceof UnknownHostException) {
            return new VungleException(11);
        }
        if (th instanceof IOException) {
            return new VungleException(20);
        }
        return new VungleException(11);
    }

    /* access modifiers changed from: private */
    public void setLoading(AdRequest adRequest, boolean z) {
        Operation operation = this.loadOperations.get(adRequest);
        if (operation != null) {
            operation.loading.set(z);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void startLoading(Operation operation) {
        this.loadOperations.put(operation.request, operation);
        loadAd(operation, new DownloadCallbackWrapper(this.sdkExecutors.getBackgroundExecutor(), new DownloadAdCallback()));
    }

    /* access modifiers changed from: private */
    public void tryLoadNextInQueue(@Nullable AdRequest adRequest) {
        AdRequest adRequest2 = this.sequenceLoadingRequest;
        if (adRequest2 == null || adRequest2.equals(adRequest)) {
            this.sequenceLoadingRequest = null;
            OperationSequence.Entry poll = this.sequence.poll();
            if (poll != null) {
                Operation operation = poll.operation;
                this.sequenceLoadingRequest = operation.request;
                startLoading(operation);
            }
        }
    }

    private void unzipFile(Advertisement advertisement, AdAsset adAsset, @NonNull final File file, List<AdAsset> list) throws IOException, DatabaseHelper.DBException {
        final ArrayList arrayList = new ArrayList();
        for (AdAsset next : list) {
            if (next.fileType == 2) {
                arrayList.add(next.localPath);
            }
        }
        File destinationDir = getDestinationDir(advertisement);
        if (destinationDir == null || !destinationDir.isDirectory()) {
            Object[] objArr = new Object[2];
            objArr[0] = destinationDir == null ? "null" : NOT_A_DIR;
            objArr[1] = advertisement;
            VungleLogger.error("AdLoader#unzipFile; loadAd sequence", String.format("Can't unzip file: destination dir is %1$s; advertisement = %2$s", objArr));
            throw new IOException("Unable to access Destination Directory");
        }
        List<File> unzip = UnzipUtility.unzip(file.getPath(), destinationDir.getPath(), new UnzipUtility.Filter() {
            public boolean matches(String str) {
                File file = new File(str);
                for (String file2 : arrayList) {
                    File file3 = new File(file2);
                    if (file3.equals(file)) {
                        return false;
                    }
                    String path = file.getPath();
                    if (path.startsWith(file3.getPath() + File.separator)) {
                        return false;
                    }
                }
                return true;
            }
        });
        if (file.getName().equals("template")) {
            StringBuilder sb = new StringBuilder();
            sb.append(destinationDir.getPath());
            File file2 = new File(GeneratedOutlineSupport.outline18(sb, File.separator, "mraid.js"));
            if (file2.exists()) {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2, true)));
                HackMraid.apply(printWriter);
                printWriter.close();
            }
        }
        for (File next2 : unzip) {
            AdAsset adAsset2 = new AdAsset(advertisement.getId(), (String) null, next2.getPath());
            adAsset2.fileSize = next2.length();
            adAsset2.fileType = 1;
            adAsset2.parentId = adAsset.identifier;
            adAsset2.status = 3;
            this.repository.save(adAsset2);
        }
        String str = TAG;
        Log.d(str, "Uzipped " + destinationDir);
        FileUtility.printDirectoryTree(destinationDir);
        adAsset.status = 4;
        this.repository.save(adAsset, new Repository.SaveCallback() {
            public void onError(Exception exc) {
            }

            public void onSaved() {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        try {
                            FileUtility.delete(file);
                        } catch (IOException e) {
                            Log.e(AdLoader.TAG, "Error on deleting zip assets archive", e);
                        }
                    }
                });
            }
        });
    }

    @WorkerThread
    public boolean canPlayAd(Advertisement advertisement) {
        if (advertisement == null || advertisement.getState() != 1) {
            return false;
        }
        return hasAssetsFor(advertisement);
    }

    @WorkerThread
    public boolean canRenderAd(Advertisement advertisement) {
        if (advertisement == null) {
            return false;
        }
        if (advertisement.getState() == 1 || advertisement.getState() == 2) {
            return hasAssetsFor(advertisement);
        }
        return false;
    }

    public void clear() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.loadOperations.keySet());
        hashSet.addAll(this.pendingOperations.keySet());
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            AdRequest adRequest = (AdRequest) it.next();
            Operation remove = this.loadOperations.remove(adRequest);
            this.startingOperations.remove(remove);
            onError(remove, 25);
            onError(this.pendingOperations.remove(adRequest), 25);
        }
        for (Operation next : this.startingOperations) {
            this.startingOperations.remove(next);
            onError(next, 25);
        }
        this.sdkExecutors.getBackgroundExecutor().submit(new Runnable() {
            public void run() {
                AdRequest unused = AdLoader.this.sequenceLoadingRequest = null;
                for (OperationSequence.Entry entry : AdLoader.this.sequence.removeAll()) {
                    AdLoader.this.onError(entry.operation, 25);
                }
            }
        });
    }

    public void dropCache(String str) {
        List<AdAsset> list = this.repository.loadAllAdAssets(str).get();
        if (list == null) {
            Log.w(TAG, "No assets found in ad cache to cleanup");
            return;
        }
        HashSet hashSet = new HashSet();
        for (AdAsset adAsset : list) {
            hashSet.add(adAsset.serverPath);
        }
        Advertisement advertisement = this.repository.load(str, Advertisement.class).get();
        if (advertisement != null) {
            hashSet.addAll(advertisement.getDownloadableUrls().values());
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.downloader.dropCache((String) it.next());
        }
    }

    @Nullable
    public File getDestinationDir(Advertisement advertisement) {
        return this.repository.getAdvertisementAssetDirectory(advertisement.getId()).get();
    }

    @VisibleForTesting
    public Collection<Operation> getPendingOperations() {
        return this.pendingOperations.values();
    }

    @VisibleForTesting
    public Collection<Operation> getRunningOperations() {
        return this.loadOperations.values();
    }

    public boolean hasAssetsFor(Advertisement advertisement) throws IllegalStateException {
        List<AdAsset> list;
        if (advertisement == null || (list = this.repository.loadAllAdAssets(advertisement.getId()).get()) == null || list.size() == 0) {
            return false;
        }
        for (AdAsset adAsset : list) {
            if (adAsset.fileType == 0) {
                if (adAsset.status != 4) {
                    return false;
                }
            } else if ((!isUrlValid(adAsset.serverPath) || !isAdLoadOptimizationEnabled(advertisement)) && (adAsset.status != 3 || !fileIsValid(new File(adAsset.localPath), adAsset))) {
                return false;
            }
        }
        return true;
    }

    public void init(@NonNull JobRunner jobRunner) {
        this.jobRunnerRef.set(jobRunner);
        this.downloader.init();
    }

    public boolean isLoading(AdRequest adRequest) {
        Operation operation = this.loadOperations.get(adRequest);
        return operation != null && operation.loading.get();
    }

    public void load(@NonNull final Operation operation) {
        JobRunner jobRunner = this.jobRunnerRef.get();
        if (jobRunner == null) {
            VungleLogger.error("AdLoader#load; loadAd sequence", String.format("Cannot load operation %s; job runner is null", new Object[]{operation}));
            onError(operation, 9);
            return;
        }
        checkAndUpdateHBPPlacementBannerSize(operation.request.getPlacementId(), operation.size);
        Operation remove = this.pendingOperations.remove(operation.request);
        if (remove != null) {
            operation.merge(remove);
        }
        if (operation.delay <= 0) {
            operation.request.timeStamp.set(System.currentTimeMillis());
            this.startingOperations.add(operation);
            this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                public void run() {
                    if (AdLoader.this.startingOperations.contains(operation)) {
                        Operation operation = operation;
                        Operation operation2 = (Operation) AdLoader.this.loadOperations.get(operation.request);
                        if (operation2 != null) {
                            int i = operation2.priority;
                            operation2.merge(operation);
                            if (operation2.priority < i) {
                                AdLoader.this.onChangePriority(operation2);
                            }
                        } else {
                            OperationSequence.Entry remove = AdLoader.this.sequence.remove(operation.request);
                            if (remove != null) {
                                remove.operation.merge(operation);
                                operation = remove.operation;
                            }
                            if (operation.priority <= 0) {
                                AdLoader.this.startLoading(operation);
                            } else {
                                OperationSequence access$100 = AdLoader.this.sequence;
                                if (remove == null) {
                                    remove = new OperationSequence.Entry(operation);
                                }
                                access$100.offer(remove);
                                AdLoader.this.tryLoadNextInQueue((AdRequest) null);
                            }
                        }
                        AdLoader.this.startingOperations.remove(operation);
                    }
                }
            });
            return;
        }
        this.pendingOperations.put(operation.request, operation);
        jobRunner.execute(DownloadJob.makeJobInfo(operation.request).setDelay(operation.delay).setUpdateCurrent(true));
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadEndlessIfNeeded(@androidx.annotation.NonNull com.vungle.warren.model.Placement r17, @androidx.annotation.NonNull com.vungle.warren.AdConfig.AdSize r18, long r19) {
        /*
            r16 = this;
            r0 = r16
            boolean r1 = r17.isMultipleHBPEnabled()
            r2 = 1
            if (r1 == 0) goto L_0x001d
            int r1 = r17.getPlacementAdType()
            if (r1 != r2) goto L_0x001d
            boolean r1 = com.vungle.warren.AdConfig.AdSize.isBannerAdSize(r18)
            if (r1 != 0) goto L_0x001d
            com.vungle.warren.AdConfig$AdSize r1 = r17.getRecommendedAdSize()
            r5 = r1
            r1 = r17
            goto L_0x0021
        L_0x001d:
            r1 = r17
            r5 = r18
        L_0x0021:
            boolean r3 = r0.isSizeInvalid(r1, r5)
            if (r3 == 0) goto L_0x0028
            return
        L_0x0028:
            r3 = 0
            boolean r4 = r17.isMultipleHBPEnabled()
            r6 = 0
            if (r4 == 0) goto L_0x0045
            boolean r4 = r17.isSingleHBPEnabled()
            if (r4 != 0) goto L_0x0045
            com.vungle.warren.AdRequest r3 = new com.vungle.warren.AdRequest
            java.lang.String r4 = r17.getId()
            int r7 = r17.getMaxHbCache()
            long r7 = (long) r7
            r3.<init>(r4, r2, r7)
            goto L_0x0069
        L_0x0045:
            boolean r2 = r17.isSingleHBPEnabled()
            r7 = 1
            if (r2 == 0) goto L_0x0059
            com.vungle.warren.AdRequest r2 = new com.vungle.warren.AdRequest
            java.lang.String r3 = r17.getId()
            r4 = 2
            r2.<init>(r3, r4, r7)
        L_0x0057:
            r4 = r2
            goto L_0x006a
        L_0x0059:
            boolean r2 = r17.isAutoCached()
            if (r2 == 0) goto L_0x0069
            com.vungle.warren.AdRequest r2 = new com.vungle.warren.AdRequest
            java.lang.String r3 = r17.getId()
            r2.<init>(r3, r6, r7)
            goto L_0x0057
        L_0x0069:
            r4 = r3
        L_0x006a:
            if (r4 == 0) goto L_0x0083
            com.vungle.warren.AdLoader$Operation r2 = new com.vungle.warren.AdLoader$Operation
            r8 = 2000(0x7d0, double:9.88E-321)
            r10 = 5
            r11 = 1
            r12 = 0
            r13 = 0
            int r14 = r17.getAutoCachePriority()
            com.vungle.warren.LoadAdCallback[] r15 = new com.vungle.warren.LoadAdCallback[r6]
            r3 = r2
            r6 = r19
            r3.<init>(r4, r5, r6, r8, r10, r11, r12, r13, r14, r15)
            r0.load(r2)
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.loadEndlessIfNeeded(com.vungle.warren.model.Placement, com.vungle.warren.AdConfig$AdSize, long):void");
    }

    public void loadPendingInternal(AdRequest adRequest) {
        Operation remove = this.pendingOperations.remove(adRequest);
        if (remove != null) {
            load(remove.delay(0));
        }
    }

    public void saveAsset(Advertisement advertisement, File file, String str, String str2) throws DatabaseHelper.DBException {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getPath());
        String outline18 = GeneratedOutlineSupport.outline18(sb, File.separator, str);
        int i = (outline18.endsWith(Advertisement.KEY_POSTROLL) || outline18.endsWith("template")) ? 0 : 2;
        AdAsset adAsset = new AdAsset(advertisement.getId(), str2, outline18);
        adAsset.status = 0;
        adAsset.fileType = i;
        try {
            this.repository.save(adAsset);
        } catch (DatabaseHelper.DBException e) {
            VungleLogger.error("AdLoader#saveAsset; loadAd sequence", String.format("Can't save adAsset %1$s; exception = %2$s", new Object[]{adAsset, e}));
            throw e;
        }
    }

    public void setAdLoadOptimizationEnabled(boolean z) {
        this.adLoadOptimizationEnabled = z;
    }

    @DownloadRequest.Priority
    public static int getAssetPriority(@NonNull String str, boolean z) {
        if (!z) {
            return 0;
        }
        return str.endsWith("template") ^ true ? 1 : 0;
    }

    public void load(AdRequest adRequest, AdConfig adConfig, LoadAdCallback loadAdCallback) {
        load(new Operation(adRequest, adConfig.getAdSize(), 0, 2000, 5, 0, 0, true, 0, loadAdCallback));
    }
}
