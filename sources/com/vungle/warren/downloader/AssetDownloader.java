package com.vungle.warren.downloader;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.downloader.AssetDownloadListener;
import com.vungle.warren.utility.FileUtility;
import com.vungle.warren.utility.NetworkProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLException;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okio.GzipSource;
import okio.RealBufferedSource;

@SuppressLint({"LogNotTimber"})
public class AssetDownloader implements Downloader {
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    public static final String BYTES = "bytes";
    public static final int CONNECTION_RETRY_TIMEOUT = 300;
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final int DOWNLOAD_CHUNK_SIZE = 2048;
    public static final String DOWNLOAD_COMPLETE = "DOWNLOAD_COMPLETE";
    public static final String DOWNLOAD_URL = "Download_URL";
    public static final String ETAG = "ETag";
    public static final String GZIP = "gzip";
    public static final String IDENTITY = "identity";
    public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String IF_NONE_MATCH = "If-None-Match";
    public static final String IF_RANGE = "If-Range";
    public static final String KEY_TEMPLATE = "template";
    public static final String LAST_CACHE_VERIFICATION = "Last-Cache-Verification";
    public static final String LAST_DOWNLOAD = "Last-Download";
    public static final String LAST_MODIFIED = "Last-Modified";
    public static final String LOAD_CONTEXT = "AssetDownloader#load; loadAd sequence";
    public static final long MAX_PERCENT = 100;
    public static final int MAX_RECONNECT_ATTEMPTS = 10;
    public static final String META_POSTFIX_EXT = ".vng_meta";
    public static final int PROGRESS_STEP = 5;
    public static final String RANGE = "Range";
    public static final int RANGE_NOT_SATISFIABLE = 416;
    public static final int RETRY_COUNT_ON_CONNECTION_LOST = 5;
    public static final String TAG = AssetDownloader.class.getSimpleName();
    public static final int TIMEOUT = 30;
    public static final long VERIFICATION_WINDOW = TimeUnit.HOURS.toMillis(24);
    public final Object addLock;
    @Nullable
    public final DownloaderCache cache;
    public final ThreadPoolExecutor downloadExecutor;
    public boolean isCacheEnabled;
    public int maxReconnectAttempts;
    public Map<String, DownloadRequestMediator> mediators;
    public final NetworkProvider.NetworkListener networkListener;
    public final NetworkProvider networkProvider;
    public final OkHttpClient okHttpClient;
    public volatile int progressStep;
    public int reconnectTimeout;
    public int retryCountOnConnectionLost;
    public final long timeWindow;
    public List<DownloadRequest> transitioning;
    public final ExecutorService uiExecutor;

    public @interface NetworkType {
        public static final int ANY = 3;
        public static final int CELLULAR = 1;
        public static final int WIFI = 2;
    }

    public AssetDownloader(int i, @NonNull NetworkProvider networkProvider2, @NonNull ExecutorService executorService) {
        this((DownloaderCache) null, 0, i, networkProvider2, executorService);
    }

    private void addNetworkListener() {
        Log.d(TAG, "Adding network listner");
        this.networkProvider.addListener(this.networkListener);
    }

    /* access modifiers changed from: private */
    public void appendHeaders(long j, @NonNull File file, @NonNull HashMap<String, String> hashMap, @NonNull Request.Builder builder) {
        builder.addHeader(ACCEPT_ENCODING, IDENTITY);
        if (file.exists() && !hashMap.isEmpty()) {
            String str = hashMap.get(ETAG);
            String str2 = hashMap.get(LAST_MODIFIED);
            if (Boolean.parseBoolean(hashMap.get(DOWNLOAD_COMPLETE))) {
                if (!TextUtils.isEmpty(str)) {
                    builder.addHeader(IF_NONE_MATCH, str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    builder.addHeader(IF_MODIFIED_SINCE, str2);
                }
            } else if (BYTES.equalsIgnoreCase(hashMap.get(ACCEPT_RANGES))) {
                if (hashMap.get("Content-Encoding") == null || IDENTITY.equalsIgnoreCase(hashMap.get("Content-Encoding"))) {
                    builder.addHeader(RANGE, "bytes=" + j + "-");
                    if (!TextUtils.isEmpty(str)) {
                        builder.addHeader(IF_RANGE, str);
                    } else if (!TextUtils.isEmpty(str2)) {
                        builder.addHeader(IF_RANGE, str2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void checkEncoding(File file, File file2, Headers headers) throws IOException {
        String str = headers.get("Content-Encoding");
        if (str != null && !"gzip".equalsIgnoreCase(str) && !IDENTITY.equalsIgnoreCase(str)) {
            deleteFileAndMeta(file, file2, false);
            VungleLogger.error("AssetDownloader#checkEncoding; loadAd sequence", String.format("unknown %1$s %2$s ", new Object[]{"Content-Encoding", str}));
            throw new IOException("Unknown Content-Encoding");
        }
    }

    private void copyToDestination(File file, File file2, Pair<DownloadRequest, AssetDownloadListener> pair) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        IOException e;
        if (file2.exists()) {
            FileUtility.deleteAndLogIfFailed(file2);
        }
        if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    channel.transferTo(0, channel.size(), fileOutputStream.getChannel());
                    Log.d(TAG, "Copying: finished " + ((DownloadRequest) pair.first).url + " copying to " + file2.getPath());
                } catch (IOException e2) {
                    e = e2;
                    try {
                        VungleLogger.error("AssetDownloader#copyToDestination; loadAd sequence", String.format("cannot copy from %1$s(%2$s) to %3$s due to %4$s", new Object[]{file.getPath(), ((DownloadRequest) pair.first).url, file2.getPath(), e}));
                        deliverError((DownloadRequest) pair.first, (AssetDownloadListener) pair.second, new AssetDownloadListener.DownloadError(-1, e, 2));
                        Log.d(TAG, "Copying: error" + ((DownloadRequest) pair.first).url + " copying to " + file2.getPath());
                        FileUtility.closeQuietly(fileInputStream);
                        FileUtility.closeQuietly(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            } catch (IOException e3) {
                IOException iOException = e3;
                fileOutputStream = null;
                e = iOException;
                VungleLogger.error("AssetDownloader#copyToDestination; loadAd sequence", String.format("cannot copy from %1$s(%2$s) to %3$s due to %4$s", new Object[]{file.getPath(), ((DownloadRequest) pair.first).url, file2.getPath(), e}));
                deliverError((DownloadRequest) pair.first, (AssetDownloadListener) pair.second, new AssetDownloadListener.DownloadError(-1, e, 2));
                Log.d(TAG, "Copying: error" + ((DownloadRequest) pair.first).url + " copying to " + file2.getPath());
                FileUtility.closeQuietly(fileInputStream);
                FileUtility.closeQuietly(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                FileUtility.closeQuietly(fileInputStream2);
                FileUtility.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e4) {
            fileOutputStream = null;
            e = e4;
            fileInputStream = null;
            VungleLogger.error("AssetDownloader#copyToDestination; loadAd sequence", String.format("cannot copy from %1$s(%2$s) to %3$s due to %4$s", new Object[]{file.getPath(), ((DownloadRequest) pair.first).url, file2.getPath(), e}));
            deliverError((DownloadRequest) pair.first, (AssetDownloadListener) pair.second, new AssetDownloadListener.DownloadError(-1, e, 2));
            Log.d(TAG, "Copying: error" + ((DownloadRequest) pair.first).url + " copying to " + file2.getPath());
            FileUtility.closeQuietly(fileInputStream);
            FileUtility.closeQuietly(fileOutputStream);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            FileUtility.closeQuietly(fileInputStream2);
            FileUtility.closeQuietly(fileOutputStream);
            throw th;
        }
        FileUtility.closeQuietly(fileInputStream);
        FileUtility.closeQuietly(fileOutputStream);
    }

    /* access modifiers changed from: private */
    public String debugString(DownloadRequestMediator downloadRequestMediator) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(", mediator url - ");
        outline24.append(downloadRequestMediator.url);
        outline24.append(", path - ");
        outline24.append(downloadRequestMediator.filePath);
        outline24.append(", th - ");
        outline24.append(Thread.currentThread().getName());
        outline24.append("id ");
        outline24.append(downloadRequestMediator);
        return outline24.toString();
    }

    /* access modifiers changed from: private */
    public ResponseBody decodeGzipIfNeeded(Response response) {
        ResponseBody responseBody;
        String str = response.headers.get("Content-Encoding");
        String str2 = null;
        if (str == null) {
            str = null;
        }
        if (!"gzip".equalsIgnoreCase(str) || !HttpHeaders.hasBody(response) || (responseBody = response.body) == null) {
            return response.body;
        }
        GzipSource gzipSource = new GzipSource(responseBody.source());
        String str3 = response.headers.get("Content-Type");
        if (str3 != null) {
            str2 = str3;
        }
        return new RealResponseBody(str2, -1, new RealBufferedSource(gzipSource));
    }

    /* access modifiers changed from: private */
    public void deleteFileAndMeta(File file, File file2, boolean z) {
        if (file != null) {
            FileUtility.deleteAndLogIfFailed(file);
            if (file2 != null) {
                FileUtility.deleteAndLogIfFailed(file2);
            }
            if (this.cache != null && isCacheEnabled()) {
                if (z) {
                    this.cache.deleteAndRemove(file);
                } else {
                    this.cache.deleteContents(file);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void deliverError(@Nullable final DownloadRequest downloadRequest, @Nullable final AssetDownloadListener assetDownloadListener, @NonNull final AssetDownloadListener.DownloadError downloadError) {
        Object[] objArr = new Object[2];
        objArr[0] = downloadError;
        objArr[1] = downloadRequest != null ? debugString(downloadRequest) : "null";
        VungleLogger.error("AssetDownloader#deliverError; loadAd sequence", String.format("Delivering error %1$s; request %2$s", objArr));
        if (assetDownloadListener != null) {
            this.uiExecutor.execute(new Runnable() {
                public void run() {
                    assetDownloadListener.onError(downloadError, downloadRequest);
                }
            });
        }
    }

    private void deliverProgress(final AssetDownloadListener.Progress progress, final DownloadRequest downloadRequest, final AssetDownloadListener assetDownloadListener) {
        if (assetDownloadListener != null) {
            this.uiExecutor.execute(new Runnable() {
                public void run() {
                    String access$000 = AssetDownloader.TAG;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("On progress ");
                    outline24.append(downloadRequest);
                    Log.d(access$000, outline24.toString());
                    assetDownloadListener.onProgress(progress, downloadRequest);
                }
            });
        }
    }

    private void deliverSuccess(Pair<DownloadRequest, AssetDownloadListener> pair, File file) {
        S s = pair.second;
        if (s != null) {
            ((AssetDownloadListener) s).onSuccess(file, (DownloadRequest) pair.first);
        }
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> extractMeta(File file) {
        return FileUtility.readMap(file.getPath());
    }

    private synchronized DownloadRequestMediator findMediatorForCancellation(DownloadRequest downloadRequest) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.mediators.get(getCacheableKey(downloadRequest)));
        arrayList.add(this.mediators.get(getNonCacheableKey(downloadRequest)));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            DownloadRequestMediator downloadRequestMediator = (DownloadRequestMediator) it.next();
            if (downloadRequestMediator != null) {
                for (DownloadRequest equals : downloadRequestMediator.requests()) {
                    if (equals.equals(downloadRequest)) {
                        return downloadRequestMediator;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private String getCacheableKey(DownloadRequest downloadRequest) {
        return downloadRequest.url;
    }

    /* access modifiers changed from: private */
    public long getContentLength(Response response) {
        if (response == null) {
            return -1;
        }
        String str = response.headers.get("Content-Length");
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private String getNonCacheableKey(DownloadRequest downloadRequest) {
        return downloadRequest.url + " " + downloadRequest.path;
    }

    /* access modifiers changed from: private */
    public boolean isAnyConnected(DownloadRequestMediator downloadRequestMediator) {
        for (DownloadRequest next : downloadRequestMediator.requests()) {
            if (next == null) {
                Log.d(TAG, "Request is null");
            } else if (isConnected(next)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(21)
    private boolean isConnected(@NonNull DownloadRequest downloadRequest) {
        int i;
        int currentNetworkType = this.networkProvider.getCurrentNetworkType();
        boolean z = true;
        if (currentNetworkType >= 0 && downloadRequest.networkType == 3) {
            return true;
        }
        if (currentNetworkType != 0) {
            if (currentNetworkType != 1) {
                if (currentNetworkType != 4) {
                    if (currentNetworkType != 9) {
                        if (currentNetworkType != 17) {
                            if (currentNetworkType != 6) {
                                if (currentNetworkType != 7) {
                                    i = -1;
                                    if (i <= 0 || (downloadRequest.networkType & i) != i) {
                                        z = false;
                                    }
                                    String str = TAG;
                                    Log.d(str, "checking pause for type: " + currentNetworkType + " connected " + z + debugString(downloadRequest));
                                    return z;
                                }
                            }
                        }
                    }
                }
            }
            i = 2;
            z = false;
            String str2 = TAG;
            Log.d(str2, "checking pause for type: " + currentNetworkType + " connected " + z + debugString(downloadRequest));
            return z;
        }
        i = 1;
        z = false;
        String str22 = TAG;
        Log.d(str22, "checking pause for type: " + currentNetworkType + " connected " + z + debugString(downloadRequest));
        return z;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.lock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0070, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r7.transitioning.remove(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007b, code lost:
        if (r1.mo21913is(6) != false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0081, code lost:
        if (r1.mo21913is(3) == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0087, code lost:
        if (r8.isCancelled() != false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008c, code lost:
        if (r1.isCacheable == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008e, code lost:
        r1.add(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        if (r1.mo21913is(2) == false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0098, code lost:
        load(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009c, code lost:
        com.vungle.warren.VungleLogger.warn("AssetDownloader#launchRequest; loadAd sequence", "request " + r8 + " is already running");
        deliverError(r8, r9, new com.vungle.warren.downloader.AssetDownloadListener.DownloadError(-1, new java.lang.IllegalArgumentException("DownloadRequest is already running"), 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c7, code lost:
        r8 = makeNewMediator(r8, r9);
        r7.mediators.put(r1.key, r8);
        load(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d5, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r1.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00da, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00de, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e2, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void launchRequest(com.vungle.warren.downloader.DownloadRequest r8, com.vungle.warren.downloader.AssetDownloadListener r9) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.Object r0 = r7.addLock
            monitor-enter(r0)
            monitor-enter(r7)     // Catch:{ all -> 0x00e6 }
            boolean r1 = r8.isCancelled()     // Catch:{ all -> 0x00e3 }
            r2 = 1
            r3 = -1
            r4 = 3
            if (r1 == 0) goto L_0x0048
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r1 = r7.transitioning     // Catch:{ all -> 0x00e3 }
            r1.remove(r8)     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = TAG     // Catch:{ all -> 0x00e3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e3 }
            r5.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "Request "
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = r8.url     // Catch:{ all -> 0x00e3 }
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = " is cancelled before starting"
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e3 }
            android.util.Log.d(r1, r5)     // Catch:{ all -> 0x00e3 }
            com.vungle.warren.downloader.AssetDownloadListener$Progress r1 = new com.vungle.warren.downloader.AssetDownloadListener$Progress     // Catch:{ all -> 0x00e3 }
            r1.<init>()     // Catch:{ all -> 0x00e3 }
            r1.status = r4     // Catch:{ all -> 0x00e3 }
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r1 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x00e3 }
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = "Cancelled"
            r4.<init>(r5)     // Catch:{ all -> 0x00e3 }
            r1.<init>(r3, r4, r2)     // Catch:{ all -> 0x00e3 }
            r7.deliverError(r8, r9, r1)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r7)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e6 }
            return
        L_0x0048:
            java.util.Map<java.lang.String, com.vungle.warren.downloader.DownloadRequestMediator> r1 = r7.mediators     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r7.mediatorKeyFromRequest(r8)     // Catch:{ all -> 0x00e3 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x00e3 }
            com.vungle.warren.downloader.DownloadRequestMediator r1 = (com.vungle.warren.downloader.DownloadRequestMediator) r1     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x006c
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r1 = r7.transitioning     // Catch:{ all -> 0x00e3 }
            r1.remove(r8)     // Catch:{ all -> 0x00e3 }
            com.vungle.warren.downloader.DownloadRequestMediator r8 = r7.makeNewMediator(r8, r9)     // Catch:{ all -> 0x00e3 }
            java.util.Map<java.lang.String, com.vungle.warren.downloader.DownloadRequestMediator> r9 = r7.mediators     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = r8.key     // Catch:{ all -> 0x00e3 }
            r9.put(r1, r8)     // Catch:{ all -> 0x00e3 }
            r7.load(r8)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r7)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e6 }
            return
        L_0x006c:
            monitor-exit(r7)     // Catch:{ all -> 0x00e3 }
            r1.lock()     // Catch:{ all -> 0x00de }
            monitor-enter(r7)     // Catch:{ all -> 0x00de }
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r5 = r7.transitioning     // Catch:{ all -> 0x00db }
            r5.remove(r8)     // Catch:{ all -> 0x00db }
            r5 = 6
            boolean r5 = r1.mo21913is(r5)     // Catch:{ all -> 0x00db }
            if (r5 != 0) goto L_0x00c7
            boolean r4 = r1.mo21913is(r4)     // Catch:{ all -> 0x00db }
            if (r4 == 0) goto L_0x008a
            boolean r4 = r8.isCancelled()     // Catch:{ all -> 0x00db }
            if (r4 != 0) goto L_0x008a
            goto L_0x00c7
        L_0x008a:
            boolean r4 = r1.isCacheable     // Catch:{ all -> 0x00db }
            if (r4 == 0) goto L_0x009c
            r1.add(r8, r9)     // Catch:{ all -> 0x00db }
            r8 = 2
            boolean r8 = r1.mo21913is(r8)     // Catch:{ all -> 0x00db }
            if (r8 == 0) goto L_0x00d5
            r7.load(r1)     // Catch:{ all -> 0x00db }
            goto L_0x00d5
        L_0x009c:
            java.lang.String r4 = "AssetDownloader#launchRequest; loadAd sequence"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r5.<init>()     // Catch:{ all -> 0x00db }
            java.lang.String r6 = "request "
            r5.append(r6)     // Catch:{ all -> 0x00db }
            r5.append(r8)     // Catch:{ all -> 0x00db }
            java.lang.String r6 = " is already running"
            r5.append(r6)     // Catch:{ all -> 0x00db }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00db }
            com.vungle.warren.VungleLogger.warn(r4, r5)     // Catch:{ all -> 0x00db }
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r4 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x00db }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00db }
            java.lang.String r6 = "DownloadRequest is already running"
            r5.<init>(r6)     // Catch:{ all -> 0x00db }
            r4.<init>(r3, r5, r2)     // Catch:{ all -> 0x00db }
            r7.deliverError(r8, r9, r4)     // Catch:{ all -> 0x00db }
            goto L_0x00d5
        L_0x00c7:
            com.vungle.warren.downloader.DownloadRequestMediator r8 = r7.makeNewMediator(r8, r9)     // Catch:{ all -> 0x00db }
            java.util.Map<java.lang.String, com.vungle.warren.downloader.DownloadRequestMediator> r9 = r7.mediators     // Catch:{ all -> 0x00db }
            java.lang.String r2 = r1.key     // Catch:{ all -> 0x00db }
            r9.put(r2, r8)     // Catch:{ all -> 0x00db }
            r7.load(r8)     // Catch:{ all -> 0x00db }
        L_0x00d5:
            monitor-exit(r7)     // Catch:{ all -> 0x00db }
            r1.unlock()     // Catch:{ all -> 0x00e6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e6 }
            return
        L_0x00db:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00db }
            throw r8     // Catch:{ all -> 0x00de }
        L_0x00de:
            r8 = move-exception
            r1.unlock()     // Catch:{ all -> 0x00e6 }
            throw r8     // Catch:{ all -> 0x00e6 }
        L_0x00e3:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00e3 }
            throw r8     // Catch:{ all -> 0x00e6 }
        L_0x00e6:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e6 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.launchRequest(com.vungle.warren.downloader.DownloadRequest, com.vungle.warren.downloader.AssetDownloadListener):void");
    }

    private synchronized void load(final DownloadRequestMediator downloadRequestMediator) {
        addNetworkListener();
        downloadRequestMediator.set(1);
        this.downloadExecutor.execute(new DownloadPriorityRunnable(downloadRequestMediator) {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.io.Closeable} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.io.Closeable} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.io.Closeable} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: long} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v83, resolved type: okhttp3.RealCall} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v86, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v88, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v67, resolved type: com.vungle.warren.downloader.AssetDownloadListener$DownloadError} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v103, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v31, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v68, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v104, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v105, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v71, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v107, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v72, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v73, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v74, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v75, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v76, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v77, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v79, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v200, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v126, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v40, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v41, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v42, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v43, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v44, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v59, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v45, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v46, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v21, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v213, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v66, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v131, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v58, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v27, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v29, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v132, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v133, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v134, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v75, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v77, resolved type: java.io.File} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v55, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v135, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v68, resolved type: boolean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v137, resolved type: java.lang.String} */
            /* JADX WARNING: type inference failed for: r14v30, types: [okio.BufferedSource, okio.Source, java.io.Closeable] */
            /* JADX WARNING: type inference failed for: r5v57 */
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
                	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
                */
            /* JADX WARNING: Multi-variable type inference failed */
            public void run() {
                /*
                    r31 = this;
                    r1 = r31
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    r2 = 0
                    r0.setRunnable(r2)
                    com.vungle.warren.downloader.AssetDownloadListener$Progress r3 = new com.vungle.warren.downloader.AssetDownloadListener$Progress
                    r3.<init>()
                    long r4 = java.lang.System.currentTimeMillis()
                    r3.timestampDownloadStart = r4
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    java.lang.String r4 = r0.url
                    java.lang.String r5 = r0.filePath
                    java.lang.String r0 = r0.metaPath
                    java.io.File r12 = new java.io.File
                    r12.<init>(r5)
                    java.io.File r5 = new java.io.File
                    r5.<init>(r0)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x003c
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x003c
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.startTracking(r12)
                L_0x003c:
                    r0 = 0
                    r6 = 0
                    r7 = 0
                    r13 = r2
                    r14 = 0
                    r15 = 0
                L_0x0042:
                    if (r0 != 0) goto L_0x0da1
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r7 = "Start load: url: "
                    r6.append(r7)
                    r6.append(r4)
                    java.lang.String r6 = r6.toString()
                    android.util.Log.d(r0, r6)
                    r0 = 5
                    r6 = 2
                    r7 = 3
                    r8 = 4
                    r9 = 1
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r3     // Catch:{ all -> 0x0949 }
                    boolean r2 = r10.mo21913is(r9)     // Catch:{ all -> 0x0949 }
                    if (r2 != 0) goto L_0x0147
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0144 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0144 }
                    r9.<init>()     // Catch:{ all -> 0x0144 }
                    java.lang.String r10 = "Abort download, wrong state "
                    r9.append(r10)     // Catch:{ all -> 0x0144 }
                    com.vungle.warren.downloader.AssetDownloader r10 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0144 }
                    com.vungle.warren.downloader.DownloadRequestMediator r11 = r3     // Catch:{ all -> 0x0144 }
                    java.lang.String r10 = r10.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r11)     // Catch:{ all -> 0x0144 }
                    r9.append(r10)     // Catch:{ all -> 0x0144 }
                    java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0144 }
                    android.util.Log.w(r2, r9)     // Catch:{ all -> 0x0144 }
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r3 = "request is done "
                    java.lang.StringBuilder r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r3)
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r3
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r5)
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    android.util.Log.d(r2, r3)
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    int r2 = r2.getStatus()
                    if (r2 == r6) goto L_0x00d4
                    if (r2 == r7) goto L_0x00cd
                    if (r2 == r8) goto L_0x00c5
                    if (r2 == r0) goto L_0x00bd
                    if (r15 != 0) goto L_0x00d4
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x00d4
                L_0x00bd:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onErrorMediator(r13, r2)
                    goto L_0x00d4
                L_0x00c5:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x00d4
                L_0x00cd:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                L_0x00d4:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r2 = "Done with request in state "
                    java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0141 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0141 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0141 }
                    r0 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r0)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r0)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0140
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0140
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x0137
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0140
                L_0x0137:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0140:
                    return
                L_0x0141:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0141 }
                    throw r0
                L_0x0144:
                    r0 = move-exception
                    goto L_0x0288
                L_0x0147:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x093b }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3     // Catch:{ all -> 0x093b }
                    boolean r0 = r0.isAnyConnected(r2)     // Catch:{ all -> 0x093b }
                    if (r0 == 0) goto L_0x08fd
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x093b }
                    r2 = 1
                    r0.setConnected(r2)     // Catch:{ all -> 0x093b }
                    java.io.File r0 = r12.getParentFile()     // Catch:{ all -> 0x093b }
                    if (r0 == 0) goto L_0x016e
                    java.io.File r0 = r12.getParentFile()     // Catch:{ all -> 0x0144 }
                    boolean r0 = r0.exists()     // Catch:{ all -> 0x0144 }
                    if (r0 != 0) goto L_0x016e
                    java.io.File r0 = r12.getParentFile()     // Catch:{ all -> 0x0144 }
                    r0.mkdirs()     // Catch:{ all -> 0x0144 }
                L_0x016e:
                    boolean r0 = r12.exists()     // Catch:{ all -> 0x093b }
                    r16 = 0
                    if (r0 == 0) goto L_0x017c
                    long r9 = r12.length()     // Catch:{ all -> 0x0144 }
                    r10 = r9
                    goto L_0x017e
                L_0x017c:
                    r10 = r16
                L_0x017e:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x093b }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x093b }
                    r2.<init>()     // Catch:{ all -> 0x093b }
                    java.lang.String r7 = "already downloaded : "
                    r2.append(r7)     // Catch:{ all -> 0x093b }
                    r2.append(r10)     // Catch:{ all -> 0x093b }
                    java.lang.String r7 = ", file exists = "
                    r2.append(r7)     // Catch:{ all -> 0x093b }
                    boolean r7 = r12.exists()     // Catch:{ all -> 0x093b }
                    r2.append(r7)     // Catch:{ all -> 0x093b }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x093b }
                    com.vungle.warren.downloader.DownloadRequestMediator r9 = r3     // Catch:{ all -> 0x093b }
                    java.lang.String r7 = r7.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r9)     // Catch:{ all -> 0x093b }
                    r2.append(r7)     // Catch:{ all -> 0x093b }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x093b }
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x093b }
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x093b }
                    java.util.HashMap r0 = r0.extractMeta(r5)     // Catch:{ all -> 0x093b }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x093b }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3     // Catch:{ all -> 0x093b }
                    boolean r2 = r2.useCacheWithoutVerification(r7, r12, r0)     // Catch:{ all -> 0x093b }
                    if (r2 == 0) goto L_0x029b
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0144 }
                    r0.set(r8)     // Catch:{ all -> 0x0144 }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0144 }
                    java.lang.String r2 = "Using cache without verification, dispatch existing file"
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x0144 }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r2 = "request is done "
                    java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    if (r0 == r6) goto L_0x0218
                    r2 = 3
                    if (r0 == r2) goto L_0x0211
                    if (r0 == r8) goto L_0x0209
                    r2 = 5
                    if (r0 == r2) goto L_0x0201
                    if (r15 != 0) goto L_0x0218
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x0218
                L_0x0201:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onErrorMediator(r13, r2)
                    goto L_0x0218
                L_0x0209:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x0218
                L_0x0211:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                L_0x0218:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r2 = "Done with request in state "
                    java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0285 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0285 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0285 }
                    r0 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r0)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r0)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0284
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0284
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x027b
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0284
                L_0x027b:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0284:
                    return
                L_0x0285:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0285 }
                    throw r0
                L_0x0288:
                    r2 = 0
                    r6 = 2
                    r7 = 3
                    r8 = -1
                    r9 = 0
                    r10 = 0
                    r11 = 0
                    r21 = r4
                    r4 = r13
                    r19 = r15
                    r30 = r9
                    r9 = r5
                    r5 = r30
                    goto L_0x095c
                L_0x029b:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x093b }
                    java.lang.String r7 = "ttDownloadContext"
                    java.lang.String r8 = "Send network request: %1$s, at: %2$d"
                    java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x093b }
                    r9 = 0
                    r6[r9] = r4     // Catch:{ all -> 0x093b }
                    long r18 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x093b }
                    java.lang.Long r9 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x093b }
                    r24 = r13
                    r13 = 1
                    r6[r13] = r9     // Catch:{ all -> 0x08f2 }
                    java.lang.String r6 = java.lang.String.format(r8, r6)     // Catch:{ all -> 0x08f2 }
                    com.vungle.warren.VungleLogger.verbose(r13, r2, r7, r6)     // Catch:{ all -> 0x08f2 }
                    okhttp3.Request$Builder r2 = new okhttp3.Request$Builder     // Catch:{ all -> 0x08f2 }
                    r2.<init>()     // Catch:{ all -> 0x08f2 }
                    r2.url((java.lang.String) r4)     // Catch:{ all -> 0x08f2 }
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x08f2 }
                    r7 = r10
                    r9 = r12
                    r25 = r10
                    r10 = r0
                    r11 = r2
                    r6.appendHeaders(r7, r9, r10, r11)     // Catch:{ all -> 0x08e4 }
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x08e4 }
                    okhttp3.OkHttpClient r6 = r6.okHttpClient     // Catch:{ all -> 0x08e4 }
                    okhttp3.Request r2 = r2.build()     // Catch:{ all -> 0x08e4 }
                    okhttp3.Call r11 = r6.newCall(r2)     // Catch:{ all -> 0x08e4 }
                    r2 = r11
                    okhttp3.RealCall r2 = (okhttp3.RealCall) r2
                    okhttp3.Response r6 = r2.execute()     // Catch:{ all -> 0x08d2 }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x08ba }
                    long r7 = r7.getContentLength(r6)     // Catch:{ all -> 0x08ba }
                    java.lang.String r9 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x08ba }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x08ba }
                    r10.<init>()     // Catch:{ all -> 0x08ba }
                    java.lang.String r13 = "Response code: "
                    r10.append(r13)     // Catch:{ all -> 0x08ba }
                    int r13 = r6.code()     // Catch:{ all -> 0x08ba }
                    r10.append(r13)     // Catch:{ all -> 0x08ba }
                    java.lang.String r13 = " "
                    r10.append(r13)     // Catch:{ all -> 0x08ba }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x08ba }
                    r10.append(r13)     // Catch:{ all -> 0x08ba }
                    java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x08ba }
                    android.util.Log.d(r9, r10)     // Catch:{ all -> 0x08ba }
                    int r9 = r6.code()     // Catch:{ all -> 0x08ba }
                    com.vungle.warren.downloader.AssetDownloader r10 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x089d }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x089d }
                    boolean r10 = r10.notModified(r12, r6, r13, r0)     // Catch:{ all -> 0x089d }
                    if (r10 != 0) goto L_0x0772
                    com.vungle.warren.downloader.AssetDownloader r10 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0762 }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x0762 }
                    boolean r10 = r10.useCacheOnFail(r13, r12, r0, r9)     // Catch:{ all -> 0x0762 }
                    if (r10 == 0) goto L_0x032a
                    goto L_0x0772
                L_0x032a:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0762 }
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r3     // Catch:{ all -> 0x0762 }
                    r18 = r0
                    r19 = r25
                    r21 = r9
                    r22 = r6
                    r23 = r10
                    boolean r0 = r18.partialMalformed(r19, r21, r22, r23)     // Catch:{ all -> 0x0762 }
                    if (r0 == 0) goto L_0x03ca
                    int r7 = r14 + 1
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x03c7 }
                    int r0 = r0.maxReconnectAttempts     // Catch:{ all -> 0x03c7 }
                    if (r14 >= r0) goto L_0x03b0
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x03c7 }
                    r8 = 0
                    r0.deleteFileAndMeta(r12, r5, r8)     // Catch:{ all -> 0x03c7 }
                    okhttp3.ResponseBody r0 = r6.body()
                    if (r0 == 0) goto L_0x0359
                    okhttp3.ResponseBody r0 = r6.body()
                    r0.close()
                L_0x0359:
                    r2.cancel()
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r2 = "request is done "
                    java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3
                    java.lang.String r6 = r6.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r8)
                    r2.append(r6)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r2 = "Not removing connections and listener "
                    java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3
                    java.lang.String r6 = r6.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r8)
                    r2.append(r6)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x03ad }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x03ad }
                    monitor-exit(r2)     // Catch:{ all -> 0x03ad }
                    r0 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r0)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r0)
                    r0 = 0
                    r21 = r4
                    r9 = r5
                    r14 = r7
                    r13 = r24
                    goto L_0x0c9e
                L_0x03ad:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x03ad }
                    throw r0
                L_0x03b0:
                    com.vungle.warren.downloader.Downloader$RequestException r0 = new com.vungle.warren.downloader.Downloader$RequestException     // Catch:{ all -> 0x03c7 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c7 }
                    r2.<init>()     // Catch:{ all -> 0x03c7 }
                    java.lang.String r8 = "Code: "
                    r2.append(r8)     // Catch:{ all -> 0x03c7 }
                    r2.append(r9)     // Catch:{ all -> 0x03c7 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03c7 }
                    r0.<init>(r2)     // Catch:{ all -> 0x03c7 }
                    throw r0     // Catch:{ all -> 0x03c7 }
                L_0x03c7:
                    r0 = move-exception
                    r14 = r7
                    goto L_0x03df
                L_0x03ca:
                    boolean r0 = r6.isSuccessful()     // Catch:{ all -> 0x0762 }
                    if (r0 == 0) goto L_0x0736
                    r0 = 206(0xce, float:2.89E-43)
                    if (r9 == r0) goto L_0x03e4
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x03de }
                    r10 = 0
                    r0.deleteFileAndMeta(r12, r5, r10)     // Catch:{ all -> 0x03de }
                    r13 = r11
                    r10 = r16
                    goto L_0x03e7
                L_0x03de:
                    r0 = move-exception
                L_0x03df:
                    r18 = r11
                    r19 = r15
                    goto L_0x0424
                L_0x03e4:
                    r13 = r11
                    r10 = r25
                L_0x03e7:
                    com.vungle.warren.utility.FileUtility.deleteAndLogIfFailed(r5)     // Catch:{ all -> 0x0727 }
                    okhttp3.Headers r0 = r6.headers()     // Catch:{ all -> 0x0727 }
                    r18 = r13
                    com.vungle.warren.downloader.AssetDownloader r13 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x071d }
                    r13.checkEncoding(r12, r5, r0)     // Catch:{ all -> 0x071d }
                    com.vungle.warren.downloader.AssetDownloader r13 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x071d }
                    java.util.HashMap r0 = r13.makeMeta(r5, r0, r4)     // Catch:{ all -> 0x071d }
                    boolean r13 = okhttp3.internal.http.HttpHeaders.hasBody(r6)     // Catch:{ all -> 0x071d }
                    if (r13 == 0) goto L_0x06f5
                    com.vungle.warren.downloader.AssetDownloader r13 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x071d }
                    com.vungle.warren.downloader.DownloaderCache r13 = r13.cache     // Catch:{ all -> 0x071d }
                    if (r13 == 0) goto L_0x042e
                    com.vungle.warren.downloader.AssetDownloader r13 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x041d }
                    com.vungle.warren.downloader.DownloaderCache r13 = r13.cache     // Catch:{ all -> 0x041d }
                    r20 = r14
                    r19 = r15
                    long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x041b }
                    r13.setCacheLastUpdateTimestamp(r12, r14)     // Catch:{ all -> 0x041b }
                    goto L_0x0432
                L_0x041b:
                    r0 = move-exception
                    goto L_0x0422
                L_0x041d:
                    r0 = move-exception
                    r20 = r14
                    r19 = r15
                L_0x0422:
                    r14 = r20
                L_0x0424:
                    r2 = 2
                    r7 = 3
                    r21 = r4
                    r8 = r9
                    r4 = r24
                    r9 = r5
                    goto L_0x07a7
                L_0x042e:
                    r20 = r14
                    r19 = r15
                L_0x0432:
                    com.vungle.warren.downloader.AssetDownloader r13 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06ec }
                    okhttp3.ResponseBody r13 = r13.decodeGzipIfNeeded(r6)     // Catch:{ all -> 0x06ec }
                    okio.BufferedSource r14 = r13.source()     // Catch:{ all -> 0x06ec }
                    java.lang.String r15 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x06de }
                    r21 = r4
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x06d7 }
                    r4.<init>()     // Catch:{ all -> 0x06d7 }
                    r22 = r9
                    java.lang.String r9 = "Start download from bytes: "
                    r4.append(r9)     // Catch:{ all -> 0x06d2 }
                    r4.append(r10)     // Catch:{ all -> 0x06d2 }
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06d2 }
                    r23 = r2
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3     // Catch:{ all -> 0x06d2 }
                    java.lang.String r2 = r9.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r2)     // Catch:{ all -> 0x06d2 }
                    r4.append(r2)     // Catch:{ all -> 0x06d2 }
                    java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x06d2 }
                    android.util.Log.d(r15, r2)     // Catch:{ all -> 0x06d2 }
                    long r7 = r7 + r10
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x06d2 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x06d2 }
                    r4.<init>()     // Catch:{ all -> 0x06d2 }
                    java.lang.String r9 = "final offset = "
                    r4.append(r9)     // Catch:{ all -> 0x06d2 }
                    r4.append(r10)     // Catch:{ all -> 0x06d2 }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x06d2 }
                    android.util.Log.d(r2, r4)     // Catch:{ all -> 0x06d2 }
                    int r2 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
                    if (r2 != 0) goto L_0x048f
                    okio.Sink r2 = okio.Okio.sink((java.io.File) r12)     // Catch:{ all -> 0x0487 }
                    goto L_0x0493
                L_0x0487:
                    r0 = move-exception
                    r2 = 2
                    r4 = 3
                    r9 = r5
                    r4 = r24
                    goto L_0x06e3
                L_0x048f:
                    okio.Sink r2 = okio.Okio.appendingSink(r12)     // Catch:{ all -> 0x06d2 }
                L_0x0493:
                    okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ all -> 0x06d2 }
                    r4 = 0
                    r3.status = r4     // Catch:{ all -> 0x06bf }
                    r9 = r5
                    long r4 = r13.contentLength()     // Catch:{ all -> 0x06bb }
                    r3.sizeBytes = r4     // Catch:{ all -> 0x06bb }
                    r3.startBytes = r10     // Catch:{ all -> 0x06bb }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06bb }
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r3     // Catch:{ all -> 0x06bb }
                    r4.onProgressMediator(r5, r3)     // Catch:{ all -> 0x06bb }
                    r4 = 0
                    r25 = r16
                L_0x04ad:
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r3     // Catch:{ all -> 0x06bb }
                    r13 = 1
                    boolean r5 = r5.mo21913is(r13)     // Catch:{ all -> 0x06bb }
                    if (r5 == 0) goto L_0x056a
                    r5 = r2
                    okio.RealBufferedSink r5 = (okio.RealBufferedSink) r5
                    okio.Buffer r13 = r5.buffer()     // Catch:{ all -> 0x0566 }
                    r27 = r2
                    r15 = r3
                    r2 = 2048(0x800, double:1.0118E-320)
                    long r2 = r14.read(r13, r2)     // Catch:{ all -> 0x0563 }
                    r28 = -1
                    int r13 = (r2 > r28 ? 1 : (r2 == r28 ? 0 : -1))
                    if (r13 == 0) goto L_0x0561
                    boolean r13 = r12.exists()     // Catch:{ all -> 0x0563 }
                    if (r13 == 0) goto L_0x0545
                    r5.emit()     // Catch:{ all -> 0x0563 }
                    long r25 = r25 + r2
                    long r2 = r10 + r25
                    r28 = 100
                    int r5 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
                    if (r5 <= 0) goto L_0x04e4
                    long r2 = r2 * r28
                    long r2 = r2 / r7
                    int r3 = (int) r2     // Catch:{ all -> 0x0563 }
                    r4 = r3
                L_0x04e4:
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3     // Catch:{ all -> 0x0563 }
                    boolean r2 = r2.isConnected()     // Catch:{ all -> 0x0563 }
                    if (r2 == 0) goto L_0x0523
                    r3 = r15
                L_0x04ed:
                    int r2 = r3.progressPercent     // Catch:{ all -> 0x055f }
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x055f }
                    int r5 = r5.progressStep     // Catch:{ all -> 0x055f }
                    int r2 = r2 + r5
                    if (r2 > r4) goto L_0x051e
                    int r2 = r3.progressPercent     // Catch:{ all -> 0x055f }
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x055f }
                    int r5 = r5.progressStep     // Catch:{ all -> 0x055f }
                    int r2 = r2 + r5
                    r13 = r4
                    long r4 = (long) r2     // Catch:{ all -> 0x055f }
                    int r2 = (r4 > r28 ? 1 : (r4 == r28 ? 0 : -1))
                    if (r2 > 0) goto L_0x051f
                    r2 = 1
                    r3.status = r2     // Catch:{ all -> 0x055f }
                    int r2 = r3.progressPercent     // Catch:{ all -> 0x055f }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x055f }
                    int r4 = r4.progressStep     // Catch:{ all -> 0x055f }
                    int r2 = r2 + r4
                    r3.progressPercent = r2     // Catch:{ all -> 0x055f }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x055f }
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3     // Catch:{ all -> 0x055f }
                    r2.onProgressMediator(r4, r3)     // Catch:{ all -> 0x055f }
                    r4 = r13
                    goto L_0x04ed
                L_0x051e:
                    r13 = r4
                L_0x051f:
                    r4 = r13
                    r2 = r27
                    goto L_0x04ad
                L_0x0523:
                    r3 = r15
                    java.lang.String r0 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r2 = "mediator %s is not connected"
                    r4 = 1
                    java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x055f }
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x055f }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3     // Catch:{ all -> 0x055f }
                    java.lang.String r5 = r5.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)     // Catch:{ all -> 0x055f }
                    r7 = 0
                    r4[r7] = r5     // Catch:{ all -> 0x055f }
                    java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ all -> 0x055f }
                    com.vungle.warren.VungleLogger.error(r0, r2)     // Catch:{ all -> 0x055f }
                    java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x055f }
                    java.lang.String r2 = "Request is not connected"
                    r0.<init>(r2)     // Catch:{ all -> 0x055f }
                    throw r0     // Catch:{ all -> 0x055f }
                L_0x0545:
                    r3 = r15
                    java.lang.String r0 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r2 = "file %s does not exist"
                    r4 = 1
                    java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x055f }
                    r5 = 0
                    r4[r5] = r12     // Catch:{ all -> 0x055f }
                    java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ all -> 0x055f }
                    com.vungle.warren.VungleLogger.error(r0, r2)     // Catch:{ all -> 0x055f }
                    com.vungle.warren.downloader.Downloader$RequestException r0 = new com.vungle.warren.downloader.Downloader$RequestException     // Catch:{ all -> 0x055f }
                    java.lang.String r2 = "File is not existing"
                    r0.<init>(r2)     // Catch:{ all -> 0x055f }
                    throw r0     // Catch:{ all -> 0x055f }
                L_0x055f:
                    r0 = move-exception
                    goto L_0x05a9
                L_0x0561:
                    r3 = r15
                    goto L_0x056c
                L_0x0563:
                    r0 = move-exception
                    r3 = r15
                    goto L_0x05a9
                L_0x0566:
                    r0 = move-exception
                    r27 = r2
                    goto L_0x05a9
                L_0x056a:
                    r27 = r2
                L_0x056c:
                    r2 = r27
                    okio.RealBufferedSink r2 = (okio.RealBufferedSink) r2
                    r2.flush()     // Catch:{ all -> 0x06b7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3     // Catch:{ all -> 0x06b7 }
                    r4 = 1
                    boolean r2 = r2.mo21913is(r4)     // Catch:{ all -> 0x06b7 }
                    if (r2 == 0) goto L_0x05af
                    long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x055f }
                    java.lang.String r2 = "DOWNLOAD_COMPLETE"
                    java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x055f }
                    java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x055f }
                    r0.put(r2, r7)     // Catch:{ all -> 0x055f }
                    java.lang.String r2 = "Last-Cache-Verification"
                    java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x055f }
                    r0.put(r2, r7)     // Catch:{ all -> 0x055f }
                    java.lang.String r2 = "Last-Download"
                    java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x055f }
                    r0.put(r2, r4)     // Catch:{ all -> 0x055f }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x055f }
                    r2.saveMeta(r9, r0)     // Catch:{ all -> 0x055f }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x055f }
                    r2 = 4
                    r0.set(r2)     // Catch:{ all -> 0x055f }
                    goto L_0x05d9
                L_0x05a9:
                    r2 = 2
                    r4 = 3
                    r4 = r24
                    goto L_0x06c6
                L_0x05af:
                    r0 = 6
                    r3.status = r0     // Catch:{ all -> 0x06b7 }
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06b7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3     // Catch:{ all -> 0x06b7 }
                    r0.onProgressMediator(r2, r3)     // Catch:{ all -> 0x06b7 }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x06b7 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x06b7 }
                    r2.<init>()     // Catch:{ all -> 0x06b7 }
                    java.lang.String r4 = "State has changed, cancelling download "
                    r2.append(r4)     // Catch:{ all -> 0x06b7 }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06b7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r3     // Catch:{ all -> 0x06b7 }
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r5)     // Catch:{ all -> 0x06b7 }
                    r2.append(r4)     // Catch:{ all -> 0x06b7 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x06b7 }
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x06b7 }
                L_0x05d9:
                    okhttp3.ResponseBody r0 = r6.body()
                    if (r0 == 0) goto L_0x05e6
                    okhttp3.ResponseBody r0 = r6.body()
                    r0.close()
                L_0x05e6:
                    r23.cancel()
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r2 = "request is done "
                    java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r3
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r5)
                    r2.append(r4)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    r2 = 2
                    if (r0 == r2) goto L_0x063f
                    r2 = 3
                    if (r0 == r2) goto L_0x0635
                    r2 = 4
                    if (r0 == r2) goto L_0x062b
                    r2 = 5
                    if (r0 == r2) goto L_0x0621
                    if (r19 != 0) goto L_0x063f
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x063f
                L_0x0621:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r4 = r24
                    r0.onErrorMediator(r4, r2)
                    goto L_0x0641
                L_0x062b:
                    r4 = r24
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x0641
                L_0x0635:
                    r4 = r24
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                    goto L_0x0641
                L_0x063f:
                    r4 = r24
                L_0x0641:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r2 = "Done with request in state "
                    java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r3
                    int r5 = r5.getStatus()
                    r2.append(r5)
                    java.lang.String r5 = " "
                    r2.append(r5)
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3
                    java.lang.String r5 = r5.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r2.append(r5)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x06b4 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x06b4 }
                    monitor-exit(r2)     // Catch:{ all -> 0x06b4 }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r27)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r14)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x06ac
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x06ac
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x06a3
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x06ac
                L_0x06a3:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x06ac:
                    r0 = 1
                    r13 = r4
                    r15 = r19
                    r14 = r20
                    goto L_0x0c9e
                L_0x06b4:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x06b4 }
                    throw r0
                L_0x06b7:
                    r0 = move-exception
                L_0x06b8:
                    r4 = r24
                    goto L_0x06c4
                L_0x06bb:
                    r0 = move-exception
                    r27 = r2
                    goto L_0x06b8
                L_0x06bf:
                    r0 = move-exception
                    r27 = r2
                    r9 = r5
                    goto L_0x06b8
                L_0x06c4:
                    r2 = 2
                    r5 = 3
                L_0x06c6:
                    r7 = 3
                    r5 = r14
                    r11 = r18
                    r14 = r20
                    r8 = r22
                    r10 = r27
                    goto L_0x08b3
                L_0x06d2:
                    r0 = move-exception
                    r9 = r5
                    r4 = r24
                    goto L_0x06e2
                L_0x06d7:
                    r0 = move-exception
                L_0x06d8:
                    r22 = r9
                    r4 = r24
                    r9 = r5
                    goto L_0x06e2
                L_0x06de:
                    r0 = move-exception
                    r21 = r4
                    goto L_0x06d8
                L_0x06e2:
                    r2 = 2
                L_0x06e3:
                    r5 = 3
                    r7 = r5
                    r5 = r14
                    r14 = r20
                    r8 = r22
                    goto L_0x07a8
                L_0x06ec:
                    r0 = move-exception
                    r21 = r4
                    r22 = r9
                L_0x06f1:
                    r4 = r24
                    r9 = r5
                    goto L_0x072f
                L_0x06f5:
                    r21 = r4
                    r22 = r9
                    r20 = r14
                    r19 = r15
                    r4 = r24
                    r9 = r5
                    r2 = 2
                    r5 = 3
                    java.lang.String r0 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r7 = "response has no body %s"
                    r8 = 1
                    java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x071b }
                    r10 = 0
                    r8[r10] = r6     // Catch:{ all -> 0x071b }
                    java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch:{ all -> 0x071b }
                    com.vungle.warren.VungleLogger.error(r0, r7)     // Catch:{ all -> 0x071b }
                    java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x071b }
                    java.lang.String r7 = "Response body is null"
                    r0.<init>(r7)     // Catch:{ all -> 0x071b }
                    throw r0     // Catch:{ all -> 0x071b }
                L_0x071b:
                    r0 = move-exception
                    goto L_0x0731
                L_0x071d:
                    r0 = move-exception
                    r21 = r4
                    r22 = r9
                L_0x0722:
                    r20 = r14
                    r19 = r15
                    goto L_0x06f1
                L_0x0727:
                    r0 = move-exception
                    r21 = r4
                    r22 = r9
                    r18 = r13
                    goto L_0x0722
                L_0x072f:
                    r2 = 2
                    r5 = 3
                L_0x0731:
                    r7 = r5
                    r8 = r22
                    goto L_0x07a5
                L_0x0736:
                    r21 = r4
                    r22 = r9
                    r18 = r11
                    r20 = r14
                    r19 = r15
                    r4 = r24
                    r9 = r5
                    r2 = 2
                    r5 = 3
                    com.vungle.warren.downloader.Downloader$RequestException r0 = new com.vungle.warren.downloader.Downloader$RequestException     // Catch:{ all -> 0x075e }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x075e }
                    r7.<init>()     // Catch:{ all -> 0x075e }
                    java.lang.String r8 = "Code: "
                    r7.append(r8)     // Catch:{ all -> 0x075e }
                    r8 = r22
                    r7.append(r8)     // Catch:{ all -> 0x07a3 }
                    java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x07a3 }
                    r0.<init>(r7)     // Catch:{ all -> 0x07a3 }
                    throw r0     // Catch:{ all -> 0x07a3 }
                L_0x075e:
                    r0 = move-exception
                    r8 = r22
                    goto L_0x07a4
                L_0x0762:
                    r0 = move-exception
                    r21 = r4
                    r8 = r9
                    r18 = r11
                    r20 = r14
                    r19 = r15
                    r4 = r24
                    r9 = r5
                    r2 = 2
                    r5 = 3
                    goto L_0x07a4
                L_0x0772:
                    r23 = r2
                    r21 = r4
                    r8 = r9
                    r18 = r11
                    r20 = r14
                    r19 = r15
                    r4 = r24
                    r9 = r5
                    r2 = 2
                    r5 = 3
                    r7 = 5
                    r10 = 304(0x130, float:4.26E-43)
                    if (r8 != r10) goto L_0x07ad
                    java.lang.String r10 = "Last-Cache-Verification"
                    long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x07a3 }
                    java.lang.String r11 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x07a3 }
                    r0.put(r10, r11)     // Catch:{ all -> 0x07a3 }
                    com.vungle.warren.downloader.AssetDownloader r10 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x07a3 }
                    r10.saveMeta(r9, r0)     // Catch:{ all -> 0x07a3 }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x07a3 }
                    java.lang.String r10 = "Verification success, dispatch existing file"
                    android.util.Log.d(r0, r10)     // Catch:{ all -> 0x07a3 }
                    goto L_0x07c9
                L_0x07a3:
                    r0 = move-exception
                L_0x07a4:
                    r7 = r5
                L_0x07a5:
                    r14 = r20
                L_0x07a7:
                    r5 = 0
                L_0x07a8:
                    r10 = 0
                    r11 = r18
                    goto L_0x08b3
                L_0x07ad:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x089b }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x089b }
                    r10.<init>()     // Catch:{ all -> 0x089b }
                    java.lang.String r11 = "Using local cache file despite response code = "
                    r10.append(r11)     // Catch:{ all -> 0x089b }
                    int r11 = r6.code()     // Catch:{ all -> 0x089b }
                    r10.append(r11)     // Catch:{ all -> 0x089b }
                    java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x089b }
                    android.util.Log.d(r0, r10)     // Catch:{ all -> 0x089b }
                L_0x07c9:
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x089b }
                    r10 = 4
                    r0.set(r10)     // Catch:{ all -> 0x089b }
                    okhttp3.ResponseBody r0 = r6.body()
                    if (r0 == 0) goto L_0x07dc
                    okhttp3.ResponseBody r0 = r6.body()
                    r0.close()
                L_0x07dc:
                    r23.cancel()
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r3 = "request is done "
                    java.lang.StringBuilder r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r3)
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3
                    java.lang.String r6 = r6.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r8)
                    r3.append(r6)
                    java.lang.String r3 = r3.toString()
                    android.util.Log.d(r0, r3)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    if (r0 == r2) goto L_0x082b
                    if (r0 == r5) goto L_0x0824
                    r2 = 4
                    if (r0 == r2) goto L_0x081c
                    if (r0 == r7) goto L_0x0814
                    if (r19 != 0) goto L_0x082b
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x082b
                L_0x0814:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onErrorMediator(r4, r2)
                    goto L_0x082b
                L_0x081c:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x082b
                L_0x0824:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                L_0x082b:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r2 = "Done with request in state "
                    java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r7)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0898 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0898 }
                    monitor-exit(r7)     // Catch:{ all -> 0x0898 }
                    r0 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r0)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r0)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0897
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0897
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x088e
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0897
                L_0x088e:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0897:
                    return
                L_0x0898:
                    r0 = move-exception
                    monitor-exit(r7)     // Catch:{ all -> 0x0898 }
                    throw r0
                L_0x089b:
                    r0 = move-exception
                    goto L_0x08ac
                L_0x089d:
                    r0 = move-exception
                    r21 = r4
                    r8 = r9
                    r18 = r11
                    r20 = r14
                    r19 = r15
                    r4 = r24
                    r9 = r5
                    r2 = 2
                    r5 = 3
                L_0x08ac:
                    r7 = 3
                    r5 = 0
                    r10 = r5
                    r11 = r18
                    r14 = r20
                L_0x08b3:
                    r30 = r6
                    r6 = r2
                    r2 = r30
                    goto L_0x095c
                L_0x08ba:
                    r0 = move-exception
                    r21 = r4
                    r9 = r5
                    r18 = r11
                    r20 = r14
                    r19 = r15
                    r4 = r24
                    r2 = 2
                    r5 = 3
                    r7 = 0
                    r2 = r6
                    r5 = r7
                    r10 = r5
                    r11 = r18
                    r6 = 2
                    r7 = 3
                    goto L_0x0959
                L_0x08d2:
                    r0 = move-exception
                    r21 = r4
                    r9 = r5
                    r18 = r11
                    r20 = r14
                    r19 = r15
                    r4 = r24
                    r2 = 2
                    r5 = 3
                    r6 = 0
                    r11 = r18
                    goto L_0x0935
                L_0x08e4:
                    r0 = move-exception
                    r21 = r4
                    r9 = r5
                    r20 = r14
                    r19 = r15
                    r4 = r24
                    r2 = 2
                    r5 = 3
                    r6 = 0
                    goto L_0x0933
                L_0x08f2:
                    r0 = move-exception
                    r21 = r4
                    r9 = r5
                    r20 = r14
                    r19 = r15
                    r4 = r24
                    goto L_0x0944
                L_0x08fd:
                    r21 = r4
                    r9 = r5
                    r4 = r13
                    r20 = r14
                    r19 = r15
                    r2 = 2
                    r5 = 3
                    r6 = 0
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0932 }
                    java.lang.String r7 = "Request is not connected to required network"
                    android.util.Log.d(r0, r7)     // Catch:{ all -> 0x0932 }
                    java.lang.String r0 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r7 = "No connected to required network requests in %s"
                    r8 = 1
                    java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x0932 }
                    com.vungle.warren.downloader.AssetDownloader r10 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0932 }
                    com.vungle.warren.downloader.DownloadRequestMediator r11 = r3     // Catch:{ all -> 0x0932 }
                    java.lang.String r10 = r10.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r11)     // Catch:{ all -> 0x0932 }
                    r11 = 0
                    r8[r11] = r10     // Catch:{ all -> 0x0932 }
                    java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch:{ all -> 0x0932 }
                    com.vungle.warren.VungleLogger.warn(r0, r7)     // Catch:{ all -> 0x0932 }
                    java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0932 }
                    java.lang.String r7 = "Not connected to correct network"
                    r0.<init>(r7)     // Catch:{ all -> 0x0932 }
                    throw r0     // Catch:{ all -> 0x0932 }
                L_0x0932:
                    r0 = move-exception
                L_0x0933:
                    r11 = r6
                    r6 = r11
                L_0x0935:
                    r7 = r5
                    r5 = r6
                    r10 = r5
                    r6 = r2
                    r2 = r10
                    goto L_0x0959
                L_0x093b:
                    r0 = move-exception
                    r21 = r4
                    r9 = r5
                    r4 = r13
                    r20 = r14
                    r19 = r15
                L_0x0944:
                    r2 = 2
                    r5 = 3
                    r6 = 0
                    r2 = r6
                    goto L_0x0952
                L_0x0949:
                    r0 = move-exception
                    r21 = r4
                    r9 = r5
                    r4 = r13
                    r20 = r14
                    r19 = r15
                L_0x0952:
                    r5 = 2
                    r6 = 3
                    r10 = r2
                    r11 = r10
                    r7 = r6
                    r6 = r5
                    r5 = r11
                L_0x0959:
                    r8 = -1
                    r14 = r20
                L_0x095c:
                    java.lang.String r13 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r15 = "exception, cannot load due to %1$s, state is %2$s"
                    java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0ca7 }
                    r16 = 0
                    r6[r16] = r0     // Catch:{ all -> 0x0ca7 }
                    r16 = r14
                    com.vungle.warren.downloader.AssetDownloader r14 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0ca7 }
                    r17 = r3
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3     // Catch:{ all -> 0x0ca7 }
                    java.lang.String r3 = r14.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r3)     // Catch:{ all -> 0x0ca7 }
                    r14 = 1
                    r6[r14] = r3     // Catch:{ all -> 0x0ca7 }
                    java.lang.String r3 = java.lang.String.format(r15, r6)     // Catch:{ all -> 0x0ca7 }
                    com.vungle.warren.VungleLogger.error(r13, r3)     // Catch:{ all -> 0x0ca7 }
                    java.lang.String r3 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0ca7 }
                    java.lang.String r6 = "Exception on download"
                    android.util.Log.e(r3, r6, r0)     // Catch:{ all -> 0x0ca7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3     // Catch:{ all -> 0x0ca7 }
                    boolean r3 = r3.mo21913is(r7)     // Catch:{ all -> 0x0ca7 }
                    if (r3 != 0) goto L_0x0993
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3     // Catch:{ all -> 0x0ca7 }
                    r6 = 5
                    r3.set(r6)     // Catch:{ all -> 0x0ca7 }
                L_0x0993:
                    boolean r3 = r0 instanceof java.io.IOException     // Catch:{ all -> 0x0ca7 }
                    if (r3 == 0) goto L_0x0b8b
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0ca7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3     // Catch:{ all -> 0x0ca7 }
                    boolean r3 = r3.isAnyConnected(r6)     // Catch:{ all -> 0x0ca7 }
                    if (r3 != 0) goto L_0x0a93
                    if (r2 != 0) goto L_0x0a93
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0ca7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x0ca7 }
                    com.vungle.warren.downloader.AssetDownloader r14 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0ca7 }
                    java.util.HashMap r14 = r14.extractMeta(r9)     // Catch:{ all -> 0x0ca7 }
                    r15 = -1
                    boolean r6 = r6.useCacheOnFail(r13, r12, r14, r15)     // Catch:{ all -> 0x0ca7 }
                    if (r6 == 0) goto L_0x0a93
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0ca7 }
                    boolean r0 = r0.mo21913is(r7)     // Catch:{ all -> 0x0ca7 }
                    if (r0 != 0) goto L_0x09c2
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0ca7 }
                    r3 = 4
                    r0.set(r3)     // Catch:{ all -> 0x0ca7 }
                L_0x09c2:
                    if (r2 == 0) goto L_0x09d1
                    okhttp3.ResponseBody r0 = r2.body()
                    if (r0 == 0) goto L_0x09d1
                    okhttp3.ResponseBody r0 = r2.body()
                    r0.close()
                L_0x09d1:
                    if (r11 == 0) goto L_0x09d6
                    r11.cancel()
                L_0x09d6:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r2 = "request is done "
                    java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    int r0 = r0.getStatus()
                    r2 = 2
                    if (r0 == r2) goto L_0x0a24
                    if (r0 == r7) goto L_0x0a1d
                    r2 = 4
                    if (r0 == r2) goto L_0x0a15
                    r2 = 5
                    if (r0 == r2) goto L_0x0a0d
                    if (r19 != 0) goto L_0x0a24
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.removeMediator(r2)
                    goto L_0x0a24
                L_0x0a0d:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onErrorMediator(r4, r2)
                    goto L_0x0a24
                L_0x0a15:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x0a24
                L_0x0a1d:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    r0.onCancelledMediator(r2)
                L_0x0a24:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r2 = "Done with request in state "
                    java.lang.StringBuilder r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r3
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r3)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a90 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0a90 }
                    monitor-exit(r3)     // Catch:{ all -> 0x0a90 }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r10)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r5)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0a8f
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0a8f
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x0a86
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0a8f
                L_0x0a86:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0a8f:
                    return
                L_0x0a90:
                    r0 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x0a90 }
                    throw r0
                L_0x0a93:
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3     // Catch:{ all -> 0x0ca7 }
                    r6.setConnected(r3)     // Catch:{ all -> 0x0ca7 }
                    com.vungle.warren.downloader.AssetDownloadListener$DownloadError r6 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x0ca7 }
                    com.vungle.warren.downloader.AssetDownloader r13 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0ca7 }
                    int r13 = r13.mapExceptionToReason(r0, r3)     // Catch:{ all -> 0x0ca7 }
                    r6.<init>(r8, r0, r13)     // Catch:{ all -> 0x0ca7 }
                    if (r3 != 0) goto L_0x0b25
                    r0 = 5
                    r3 = r17
                    r3.status = r0     // Catch:{ all -> 0x0b21 }
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b21 }
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3     // Catch:{ all -> 0x0b21 }
                    r0.onProgressMediator(r4, r3)     // Catch:{ all -> 0x0b21 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0b21 }
                    boolean r0 = r0.mo21913is(r7)     // Catch:{ all -> 0x0b21 }
                    if (r0 != 0) goto L_0x0b1e
                    int r14 = r16 + 1
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b21 }
                    int r0 = r0.maxReconnectAttempts     // Catch:{ all -> 0x0b21 }
                    r13 = r16
                    if (r13 >= r0) goto L_0x0b1b
                    r0 = 0
                L_0x0ac4:
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b21 }
                    int r4 = r4.retryCountOnConnectionLost     // Catch:{ all -> 0x0b21 }
                    if (r0 >= r4) goto L_0x0b1b
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b21 }
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b21 }
                    int r8 = r8.reconnectTimeout     // Catch:{ all -> 0x0b21 }
                    r15 = r14
                    long r13 = (long) r8     // Catch:{ all -> 0x0b21 }
                    r4.sleep(r13)     // Catch:{ all -> 0x0b21 }
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3     // Catch:{ all -> 0x0b21 }
                    boolean r4 = r4.mo21913is(r7)     // Catch:{ all -> 0x0b21 }
                    if (r4 == 0) goto L_0x0ade
                    goto L_0x0b1c
                L_0x0ade:
                    java.lang.String r4 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0b21 }
                    java.lang.String r8 = "Trying to reconnect"
                    android.util.Log.d(r4, r8)     // Catch:{ all -> 0x0b21 }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b21 }
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3     // Catch:{ all -> 0x0b21 }
                    boolean r4 = r4.isAnyConnected(r8)     // Catch:{ all -> 0x0b21 }
                    if (r4 == 0) goto L_0x0b11
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0b21 }
                    java.lang.String r4 = "Reconnected, starting download again"
                    android.util.Log.d(r0, r4)     // Catch:{ all -> 0x0b21 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0b09 }
                    r4 = 1
                    r0.setConnected(r4)     // Catch:{ all -> 0x0b09 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0b09 }
                    r0.set(r4)     // Catch:{ all -> 0x0b09 }
                    r0 = 0
                    r14 = r15
                    r4 = 0
                    goto L_0x0b2c
                L_0x0b09:
                    r0 = move-exception
                    r3 = 0
                    r3 = r1
                    r15 = r19
                    r4 = 0
                    goto L_0x0caf
                L_0x0b11:
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3     // Catch:{ all -> 0x0b21 }
                    r8 = 0
                    r4.setConnected(r8)     // Catch:{ all -> 0x0b21 }
                    int r0 = r0 + 1
                    r14 = r15
                    goto L_0x0ac4
                L_0x0b1b:
                    r15 = r14
                L_0x0b1c:
                    r14 = r15
                    goto L_0x0b2a
                L_0x0b1e:
                    r13 = r16
                    goto L_0x0b29
                L_0x0b21:
                    r0 = move-exception
                    r13 = r6
                    goto L_0x0ca9
                L_0x0b25:
                    r13 = r16
                    r3 = r17
                L_0x0b29:
                    r14 = r13
                L_0x0b2a:
                    r0 = 1
                    r4 = 1
                L_0x0b2c:
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b85 }
                    monitor-enter(r8)     // Catch:{ all -> 0x0b85 }
                    if (r4 == 0) goto L_0x0b77
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0b72 }
                    boolean r0 = r0.isConnected()     // Catch:{ all -> 0x0b72 }
                    if (r0 != 0) goto L_0x0b77
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0b72 }
                    boolean r0 = r0.isPausable()     // Catch:{ all -> 0x0b72 }
                    if (r0 == 0) goto L_0x0b77
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b72 }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x0b72 }
                    boolean r0 = r0.isAnyConnected(r13)     // Catch:{ all -> 0x0b72 }
                    if (r0 == 0) goto L_0x0b68
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0b72 }
                    java.lang.String r13 = "Reconnected, starting download again"
                    android.util.Log.d(r0, r13)     // Catch:{ all -> 0x0b72 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0b61 }
                    r4 = 1
                    r0.setConnected(r4)     // Catch:{ all -> 0x0b61 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r3     // Catch:{ all -> 0x0b61 }
                    r0.set(r4)     // Catch:{ all -> 0x0b61 }
                    r4 = 0
                    goto L_0x0b77
                L_0x0b61:
                    r0 = move-exception
                    r3 = 0
                    r3 = r1
                    r15 = r19
                    r4 = 0
                    goto L_0x0b7e
                L_0x0b68:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b72 }
                    com.vungle.warren.downloader.DownloadRequestMediator r13 = r3     // Catch:{ all -> 0x0b72 }
                    boolean r0 = r0.pause(r13, r3, r6)     // Catch:{ all -> 0x0b72 }
                    r15 = r0
                    goto L_0x0b79
                L_0x0b72:
                    r0 = move-exception
                    r3 = r1
                    r15 = r19
                    goto L_0x0b7e
                L_0x0b77:
                    r15 = r19
                L_0x0b79:
                    monitor-exit(r8)     // Catch:{ all -> 0x0b7c }
                    r0 = r4
                    goto L_0x0baf
                L_0x0b7c:
                    r0 = move-exception
                    r3 = r1
                L_0x0b7e:
                    monitor-exit(r8)     // Catch:{ all -> 0x0b83 }
                    throw r0     // Catch:{ all -> 0x0b80 }
                L_0x0b80:
                    r0 = move-exception
                    goto L_0x0caf
                L_0x0b83:
                    r0 = move-exception
                    goto L_0x0b7e
                L_0x0b85:
                    r0 = move-exception
                    r3 = r1
                    r15 = r19
                    goto L_0x0caf
                L_0x0b8b:
                    r13 = r16
                    r3 = r17
                    boolean r6 = r0 instanceof com.vungle.warren.downloader.Downloader.RequestException     // Catch:{ all -> 0x0ca7 }
                    if (r6 == 0) goto L_0x0b9f
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0ca7 }
                    r14 = 1
                    r6.deleteFileAndMeta(r12, r9, r14)     // Catch:{ all -> 0x0ca7 }
                    com.vungle.warren.downloader.AssetDownloadListener$DownloadError r6 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x0ca7 }
                    r6.<init>(r8, r0, r14)     // Catch:{ all -> 0x0ca7 }
                    goto L_0x0bab
                L_0x0b9f:
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0ca7 }
                    r14 = 1
                    r6.deleteFileAndMeta(r12, r9, r14)     // Catch:{ all -> 0x0ca7 }
                    com.vungle.warren.downloader.AssetDownloadListener$DownloadError r6 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x0ca7 }
                    r14 = 4
                    r6.<init>(r8, r0, r14)     // Catch:{ all -> 0x0ca7 }
                L_0x0bab:
                    r0 = 1
                    r14 = r13
                    r15 = r19
                L_0x0baf:
                    r13 = r6
                    if (r2 == 0) goto L_0x0bbf
                    okhttp3.ResponseBody r4 = r2.body()
                    if (r4 == 0) goto L_0x0bbf
                    okhttp3.ResponseBody r2 = r2.body()
                    r2.close()
                L_0x0bbf:
                    if (r11 == 0) goto L_0x0bc4
                    r11.cancel()
                L_0x0bc4:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r4 = "request is done "
                    java.lang.StringBuilder r4 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r4)
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3
                    java.lang.String r6 = r6.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r8)
                    r4.append(r6)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.d(r2, r4)
                    if (r0 == 0) goto L_0x0c3f
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    int r2 = r2.getStatus()
                    r4 = 2
                    if (r2 == r4) goto L_0x0c14
                    if (r2 == r7) goto L_0x0c0d
                    r4 = 4
                    if (r2 == r4) goto L_0x0c05
                    r4 = 5
                    if (r2 == r4) goto L_0x0bfd
                    if (r15 != 0) goto L_0x0c14
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r2.removeMediator(r4)
                    goto L_0x0c14
                L_0x0bfd:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r2.onErrorMediator(r13, r4)
                    goto L_0x0c14
                L_0x0c05:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r2.onSuccessMediator(r12, r4)
                    goto L_0x0c14
                L_0x0c0d:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r3
                    r2.onCancelledMediator(r4)
                L_0x0c14:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r4 = "Done with request in state "
                    java.lang.StringBuilder r4 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r4)
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3
                    int r6 = r6.getStatus()
                    r4.append(r6)
                    java.lang.String r6 = " "
                    r4.append(r6)
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3
                    java.lang.String r6 = r6.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)
                    r4.append(r6)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.d(r2, r4)
                    goto L_0x0c5b
                L_0x0c3f:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r4 = "Not removing connections and listener "
                    java.lang.StringBuilder r4 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r4)
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3
                    java.lang.String r6 = r6.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)
                    r4.append(r6)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.d(r2, r4)
                L_0x0c5b:
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r6)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0ca4 }
                    r2.removeNetworkListener()     // Catch:{ all -> 0x0ca4 }
                    monitor-exit(r6)     // Catch:{ all -> 0x0ca4 }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r10)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r5)
                    if (r0 == 0) goto L_0x0c9e
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    if (r2 == 0) goto L_0x0c9e
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    boolean r2 = r2.isCacheable
                    if (r2 == 0) goto L_0x0c9e
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r2 = r2.isCacheEnabled()
                    if (r2 != 0) goto L_0x0c95
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.clear()
                    goto L_0x0c9e
                L_0x0c95:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.purge()
                L_0x0c9e:
                    r2 = 0
                    r5 = r9
                    r4 = r21
                    goto L_0x0042
                L_0x0ca4:
                    r0 = move-exception
                    monitor-exit(r6)     // Catch:{ all -> 0x0ca4 }
                    throw r0
                L_0x0ca7:
                    r0 = move-exception
                    r13 = r4
                L_0x0ca9:
                    r3 = 1
                    r3 = r1
                    r6 = r13
                    r15 = r19
                    r4 = 1
                L_0x0caf:
                    if (r2 == 0) goto L_0x0cbe
                    okhttp3.ResponseBody r8 = r2.body()
                    if (r8 == 0) goto L_0x0cbe
                    okhttp3.ResponseBody r2 = r2.body()
                    r2.close()
                L_0x0cbe:
                    if (r11 == 0) goto L_0x0cc3
                    r11.cancel()
                L_0x0cc3:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r8 = "request is done "
                    java.lang.StringBuilder r8 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r8)
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r11 = r3
                    java.lang.String r9 = r9.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r11)
                    r8.append(r9)
                    java.lang.String r8 = r8.toString()
                    android.util.Log.d(r2, r8)
                    if (r4 == 0) goto L_0x0d3e
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    int r2 = r2.getStatus()
                    r8 = 2
                    if (r2 == r8) goto L_0x0d13
                    if (r2 == r7) goto L_0x0d0c
                    r7 = 4
                    if (r2 == r7) goto L_0x0d04
                    r7 = 5
                    if (r2 == r7) goto L_0x0cfc
                    if (r15 != 0) goto L_0x0d13
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3
                    r2.removeMediator(r6)
                    goto L_0x0d13
                L_0x0cfc:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3
                    r2.onErrorMediator(r6, r7)
                    goto L_0x0d13
                L_0x0d04:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3
                    r2.onSuccessMediator(r12, r6)
                    goto L_0x0d13
                L_0x0d0c:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r3
                    r2.onCancelledMediator(r6)
                L_0x0d13:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r6 = "Done with request in state "
                    java.lang.StringBuilder r6 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r6)
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r3
                    int r7 = r7.getStatus()
                    r6.append(r7)
                    java.lang.String r7 = " "
                    r6.append(r7)
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3
                    java.lang.String r7 = r7.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r8)
                    r6.append(r7)
                    java.lang.String r6 = r6.toString()
                    android.util.Log.d(r2, r6)
                    goto L_0x0d5a
                L_0x0d3e:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.String r6 = "Not removing connections and listener "
                    java.lang.StringBuilder r6 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r6)
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r3
                    java.lang.String r7 = r7.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r8)
                    r6.append(r7)
                    java.lang.String r6 = r6.toString()
                    android.util.Log.d(r2, r6)
                L_0x0d5a:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0d9e }
                    r6.removeNetworkListener()     // Catch:{ all -> 0x0d9e }
                    monitor-exit(r2)     // Catch:{ all -> 0x0d9e }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r10)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r5)
                    if (r4 == 0) goto L_0x0d9d
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    if (r2 == 0) goto L_0x0d9d
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r3
                    boolean r2 = r2.isCacheable
                    if (r2 == 0) goto L_0x0d9d
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r2 = r2.isCacheEnabled()
                    if (r2 != 0) goto L_0x0d94
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.clear()
                    goto L_0x0d9d
                L_0x0d94:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.purge()
                L_0x0d9d:
                    throw r0
                L_0x0d9e:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0d9e }
                    throw r0
                L_0x0da1:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.C19592.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> makeMeta(File file, Headers headers, String str) {
        HashMap<String, String> outline28 = GeneratedOutlineSupport.outline28(DOWNLOAD_URL, str);
        outline28.put(ETAG, headers.get(ETAG));
        outline28.put(LAST_MODIFIED, headers.get(LAST_MODIFIED));
        outline28.put(ACCEPT_RANGES, headers.get(ACCEPT_RANGES));
        outline28.put("Content-Encoding", headers.get("Content-Encoding"));
        saveMeta(file, outline28);
        return outline28;
    }

    private DownloadRequestMediator makeNewMediator(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) throws IOException {
        String str;
        boolean z;
        File file;
        File file2;
        if (!isCacheEnabled()) {
            file2 = new File(downloadRequest.path);
            file = new File(file2.getPath() + ".vng_meta");
            str = downloadRequest.url + " " + downloadRequest.path;
            z = false;
        } else {
            file2 = this.cache.getFile(downloadRequest.url);
            file = this.cache.getMetaFile(file2);
            str = downloadRequest.url;
            z = true;
        }
        String str2 = TAG;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Destination file ");
        outline24.append(file2.getPath());
        Log.d(str2, outline24.toString());
        return new DownloadRequestMediator(downloadRequest, assetDownloadListener, file2.getPath(), file.getPath(), z, str);
    }

    /* access modifiers changed from: private */
    public int mapExceptionToReason(Throwable th, boolean z) {
        if (th instanceof RuntimeException) {
            return 4;
        }
        if (!z || (th instanceof SocketException) || (th instanceof SocketTimeoutException)) {
            return 0;
        }
        return ((th instanceof UnknownHostException) || (th instanceof SSLException)) ? 1 : 2;
    }

    private String mediatorKeyFromRequest(@NonNull DownloadRequest downloadRequest) {
        if (isCacheEnabled()) {
            return getCacheableKey(downloadRequest);
        }
        return getNonCacheableKey(downloadRequest);
    }

    /* access modifiers changed from: private */
    public boolean notModified(@NonNull File file, @Nullable Response response, @NonNull DownloadRequestMediator downloadRequestMediator, @NonNull HashMap<String, String> hashMap) {
        if (response != null && file.exists() && file.length() > 0 && downloadRequestMediator.isCacheable) {
            int i = response.code;
            if (Boolean.parseBoolean(hashMap.get(DOWNLOAD_COMPLETE)) && i == 304) {
                String str = TAG;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("304 code, data size matches file size ");
                outline24.append(debugString(downloadRequestMediator));
                Log.d(str, outline24.toString());
                return true;
            }
        }
        return false;
    }

    private void onCancelled(@NonNull DownloadRequest downloadRequest) {
        DownloadRequest downloadRequest2;
        if (!downloadRequest.isCancelled()) {
            downloadRequest.cancel();
            DownloadRequestMediator findMediatorForCancellation = findMediatorForCancellation(downloadRequest);
            if (!(findMediatorForCancellation == null || findMediatorForCancellation.getStatus() == 3)) {
                Pair<DownloadRequest, AssetDownloadListener> remove = findMediatorForCancellation.remove(downloadRequest);
                AssetDownloadListener assetDownloadListener = null;
                if (remove == null) {
                    downloadRequest2 = null;
                } else {
                    downloadRequest2 = (DownloadRequest) remove.first;
                }
                if (remove != null) {
                    assetDownloadListener = (AssetDownloadListener) remove.second;
                }
                if (findMediatorForCancellation.values().isEmpty()) {
                    findMediatorForCancellation.set(3);
                }
                if (downloadRequest2 != null) {
                    AssetDownloadListener.Progress progress = new AssetDownloadListener.Progress();
                    progress.status = 3;
                    deliverProgress(progress, downloadRequest2, assetDownloadListener);
                } else {
                    return;
                }
            }
            removeNetworkListener();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onCancelledMediator(@NonNull DownloadRequestMediator downloadRequestMediator) {
        for (DownloadRequest onCancelled : downloadRequestMediator.requests()) {
            onCancelled(onCancelled);
        }
    }

    /* access modifiers changed from: private */
    public void onErrorMediator(@Nullable AssetDownloadListener.DownloadError downloadError, @NonNull DownloadRequestMediator downloadRequestMediator) {
        VungleLogger.error("AssetDownloader#onErrorMediator; loadAd sequence", String.format("Error %1$s occured; mediator %2$s", new Object[]{downloadError, debugString(downloadRequestMediator)}));
        if (downloadError == null) {
            downloadError = new AssetDownloadListener.DownloadError(-1, new RuntimeException(), 4);
        }
        try {
            downloadRequestMediator.lock();
            for (Pair next : downloadRequestMediator.values()) {
                deliverError((DownloadRequest) next.first, (AssetDownloadListener) next.second, downloadError);
            }
            removeMediator(downloadRequestMediator);
            downloadRequestMediator.set(6);
        } finally {
            downloadRequestMediator.unlock();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onNetworkChanged(int i) {
        String str = TAG;
        Log.d(str, "Num of connections: " + this.mediators.values().size());
        for (DownloadRequestMediator next : this.mediators.values()) {
            if (next.mo21913is(3)) {
                Log.d(TAG, "Result cancelled");
            } else {
                boolean isAnyConnected = isAnyConnected(next);
                String str2 = TAG;
                Log.d(str2, "Connected = " + isAnyConnected + " for " + i);
                next.setConnected(isAnyConnected);
                if (next.isPausable() && isAnyConnected && next.mo21913is(2)) {
                    load(next);
                    String str3 = TAG;
                    Log.d(str3, "resumed " + next.key + " " + next);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onProgressMediator(DownloadRequestMediator downloadRequestMediator, AssetDownloadListener.Progress progress) {
        if (downloadRequestMediator != null) {
            AssetDownloadListener.Progress copy = AssetDownloadListener.Progress.copy(progress);
            String str = TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Progress ");
            outline24.append(progress.progressPercent);
            outline24.append(" status ");
            outline24.append(progress.status);
            outline24.append(" ");
            outline24.append(downloadRequestMediator);
            outline24.append(" ");
            outline24.append(downloadRequestMediator.filePath);
            Log.d(str, outline24.toString());
            for (Pair next : downloadRequestMediator.values()) {
                deliverProgress(copy, (DownloadRequest) next.first, (AssetDownloadListener) next.second);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onSuccessMediator(@NonNull File file, @NonNull DownloadRequestMediator downloadRequestMediator) {
        String str = TAG;
        Log.d(str, "OnComplete - Removing connections and listener " + downloadRequestMediator);
        try {
            downloadRequestMediator.lock();
            List<Pair<DownloadRequest, AssetDownloadListener>> values = downloadRequestMediator.values();
            if (!file.exists()) {
                VungleLogger.error("AssetDownloader#onSuccessMediator; loadAd sequence", String.format("File %1$s does not exist; mediator %2$s ", new Object[]{file.getPath(), debugString(downloadRequestMediator)}));
                onErrorMediator(new AssetDownloadListener.DownloadError(-1, new IOException("File is deleted"), 2), downloadRequestMediator);
                return;
            }
            if (this.cache != null && downloadRequestMediator.isCacheable) {
                this.cache.onCacheHit(file, (long) values.size());
                this.cache.setCacheLastUpdateTimestamp(file, System.currentTimeMillis());
            }
            for (Pair next : values) {
                File file2 = new File(((DownloadRequest) next.first).path);
                if (!file2.equals(file)) {
                    copyToDestination(file, file2, next);
                } else {
                    file2 = file;
                }
                String str2 = TAG;
                Log.d(str2, "Deliver success:" + ((DownloadRequest) next.first).url + " dest file: " + file2.getPath());
                deliverSuccess(next, file2);
            }
            removeMediator(downloadRequestMediator);
            downloadRequestMediator.set(6);
            String str3 = TAG;
            Log.d(str3, "Finished " + debugString(downloadRequestMediator));
            downloadRequestMediator.unlock();
        } finally {
            downloadRequestMediator.unlock();
        }
    }

    /* access modifiers changed from: private */
    public boolean partialMalformed(long j, int i, Response response, DownloadRequestMediator downloadRequestMediator) {
        return (i == 206 && !satisfiesPartialDownload(response, j, downloadRequestMediator)) || i == 416;
    }

    /* access modifiers changed from: private */
    public boolean pause(DownloadRequestMediator downloadRequestMediator, AssetDownloadListener.Progress progress, AssetDownloadListener.DownloadError downloadError) {
        boolean z = false;
        if (downloadRequestMediator.mo21913is(3) || isAnyConnected(downloadRequestMediator)) {
            return false;
        }
        progress.status = 2;
        AssetDownloadListener.Progress copy = AssetDownloadListener.Progress.copy(progress);
        boolean z2 = false;
        for (Pair next : downloadRequestMediator.values()) {
            DownloadRequest downloadRequest = (DownloadRequest) next.first;
            if (downloadRequest != null) {
                if (!downloadRequest.pauseOnConnectionLost) {
                    downloadRequestMediator.remove(downloadRequest);
                    deliverError(downloadRequest, (AssetDownloadListener) next.second, downloadError);
                } else {
                    downloadRequestMediator.set(2);
                    String str = TAG;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Pausing download ");
                    outline24.append(debugString(downloadRequest));
                    Log.d(str, outline24.toString());
                    deliverProgress(copy, (DownloadRequest) next.first, (AssetDownloadListener) next.second);
                    z2 = true;
                }
            }
        }
        if (!z2) {
            downloadRequestMediator.set(5);
        }
        String str2 = TAG;
        StringBuilder outline242 = GeneratedOutlineSupport.outline24("Attempted to pause - ");
        if (downloadRequestMediator.getStatus() == 2) {
            z = true;
        }
        outline242.append(z);
        Log.d(str2, outline242.toString());
        return z2;
    }

    /* access modifiers changed from: private */
    public synchronized void removeMediator(DownloadRequestMediator downloadRequestMediator) {
        this.mediators.remove(downloadRequestMediator.key);
    }

    /* access modifiers changed from: private */
    public void removeNetworkListener() {
        if (this.mediators.isEmpty()) {
            Log.d(TAG, "Removing listener");
            this.networkProvider.removeListener(this.networkListener);
        }
    }

    private boolean responseVersionMatches(Response response, HashMap<String, String> hashMap) {
        Headers headers = response.headers;
        String str = headers.get(ETAG);
        String str2 = headers.get(LAST_MODIFIED);
        String str3 = TAG;
        Log.d(str3, "server etag: " + str);
        String str4 = TAG;
        Log.d(str4, "server lastModified: " + str2);
        if (str != null && !str.equals(hashMap.get(ETAG))) {
            String str5 = TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("etags miss match current: ");
            outline24.append(hashMap.get(ETAG));
            Log.d(str5, outline24.toString());
            return false;
        } else if (str2 == null || str2.equals(hashMap.get(LAST_MODIFIED))) {
            return true;
        } else {
            String str6 = TAG;
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("lastModified miss match current: ");
            outline242.append(hashMap.get(LAST_MODIFIED));
            Log.d(str6, outline242.toString());
            return false;
        }
    }

    private boolean satisfiesPartialDownload(Response response, long j, DownloadRequestMediator downloadRequestMediator) {
        boolean z;
        RangeResponse rangeResponse = new RangeResponse(response.headers.get(CONTENT_RANGE));
        if (response.code == 206 && BYTES.equalsIgnoreCase(rangeResponse.dimension)) {
            long j2 = rangeResponse.rangeStart;
            if (j2 >= 0 && j == j2) {
                z = true;
                String str = TAG;
                Log.d(str, "satisfies partial download: " + z + " " + debugString(downloadRequestMediator));
                return z;
            }
        }
        z = false;
        String str2 = TAG;
        Log.d(str2, "satisfies partial download: " + z + " " + debugString(downloadRequestMediator));
        return z;
    }

    /* access modifiers changed from: private */
    public void saveMeta(@NonNull File file, @NonNull HashMap<String, String> hashMap) {
        FileUtility.writeMap(file.getPath(), hashMap);
    }

    /* access modifiers changed from: private */
    public void sleep(long j) {
        try {
            Thread.sleep(Math.max(0, j));
        } catch (InterruptedException e) {
            Log.e(TAG, "InterruptedException ", e);
            Thread.currentThread().interrupt();
        }
    }

    /* access modifiers changed from: private */
    public boolean useCacheOnFail(DownloadRequestMediator downloadRequestMediator, File file, Map<String, String> map, int i) {
        return this.cache != null && downloadRequestMediator.isCacheable && i != 200 && i != 416 && i != 206 && Boolean.parseBoolean(map.get(DOWNLOAD_COMPLETE)) && file.exists() && file.length() > 0;
    }

    /* access modifiers changed from: private */
    public boolean useCacheWithoutVerification(DownloadRequestMediator downloadRequestMediator, File file, Map<String, String> map) {
        String str;
        if (map == null || this.cache == null || !downloadRequestMediator.isCacheable || (str = map.get(LAST_CACHE_VERIFICATION)) == null || !file.exists() || !Boolean.parseBoolean(map.get(DOWNLOAD_COMPLETE))) {
            return false;
        }
        try {
            long parseLong = Long.parseLong(str);
            long j = this.timeWindow;
            if (j >= RecyclerView.FOREVER_NS - parseLong || parseLong + j >= System.currentTimeMillis()) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public synchronized void cancel(@Nullable DownloadRequest downloadRequest) {
        if (downloadRequest != null) {
            onCancelled(downloadRequest);
        }
    }

    public synchronized void cancelAll() {
        Log.d(TAG, "Cancelling all");
        for (DownloadRequest next : this.transitioning) {
            String str = TAG;
            Log.d(str, "Cancel in transtiotion " + next.url);
            cancel(next);
        }
        String str2 = TAG;
        Log.d(str2, "Cancel in mediator " + this.mediators.values().size());
        for (DownloadRequestMediator next2 : this.mediators.values()) {
            String str3 = TAG;
            Log.d(str3, "Cancel in mediator " + next2.key);
            onCancelledMediator(next2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        sleep(10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancelAndAwait(@androidx.annotation.Nullable com.vungle.warren.downloader.DownloadRequest r6, long r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r5.cancel(r6)
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 0
            long r7 = java.lang.Math.max(r3, r7)
            long r7 = r7 + r1
        L_0x0012:
            long r1 = java.lang.System.currentTimeMillis()
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 >= 0) goto L_0x0040
            com.vungle.warren.downloader.DownloadRequestMediator r1 = r5.findMediatorForCancellation(r6)
            monitor-enter(r5)
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r2 = r5.transitioning     // Catch:{ all -> 0x003d }
            boolean r2 = r2.contains(r6)     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x0036
            if (r1 == 0) goto L_0x0033
            java.util.List r1 = r1.requests()     // Catch:{ all -> 0x003d }
            boolean r1 = r1.contains(r6)     // Catch:{ all -> 0x003d }
            if (r1 != 0) goto L_0x0036
        L_0x0033:
            r6 = 1
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            return r6
        L_0x0036:
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            r1 = 10
            r5.sleep(r1)
            goto L_0x0012
        L_0x003d:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            throw r6
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.cancelAndAwait(com.vungle.warren.downloader.DownloadRequest, long):boolean");
    }

    public synchronized void clearCache() {
        if (this.cache != null) {
            this.cache.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void download(final com.vungle.warren.downloader.DownloadRequest r9, final com.vungle.warren.downloader.AssetDownloadListener r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 1
            if (r9 != 0) goto L_0x0020
            java.lang.String r9 = "AssetDownloader#download; loadAd sequence"
            java.lang.String r1 = "downloadRequest is null"
            com.vungle.warren.VungleLogger.error(r9, r1)     // Catch:{ all -> 0x0056 }
            if (r10 == 0) goto L_0x001e
            r9 = 0
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r1 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x0056 }
            r2 = -1
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0056 }
            java.lang.String r4 = "DownloadRequest is null"
            r3.<init>(r4)     // Catch:{ all -> 0x0056 }
            r1.<init>(r2, r3, r0)     // Catch:{ all -> 0x0056 }
            r8.deliverError(r9, r10, r1)     // Catch:{ all -> 0x0056 }
        L_0x001e:
            monitor-exit(r8)
            return
        L_0x0020:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x0056 }
            java.lang.String r2 = "ttDownloadContext"
            java.lang.String r3 = "Waiting for download asset %1$s, at: %2$d"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0056 }
            r5 = 0
            r4[r5] = r9     // Catch:{ all -> 0x0056 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0056 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0056 }
            r4[r0] = r6     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x0056 }
            com.vungle.warren.VungleLogger.verbose(r0, r1, r2, r3)     // Catch:{ all -> 0x0056 }
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r0 = r8.transitioning     // Catch:{ all -> 0x0056 }
            r0.add(r9)     // Catch:{ all -> 0x0056 }
            java.util.concurrent.ThreadPoolExecutor r0 = r8.downloadExecutor     // Catch:{ all -> 0x0056 }
            com.vungle.warren.downloader.AssetDownloader$1 r1 = new com.vungle.warren.downloader.AssetDownloader$1     // Catch:{ all -> 0x0056 }
            com.vungle.warren.downloader.AssetPriority r2 = new com.vungle.warren.downloader.AssetPriority     // Catch:{ all -> 0x0056 }
            r3 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            r2.<init>(r3, r5)     // Catch:{ all -> 0x0056 }
            r1.<init>(r2, r9, r10)     // Catch:{ all -> 0x0056 }
            r0.execute(r1)     // Catch:{ all -> 0x0056 }
            monitor-exit(r8)
            return
        L_0x0056:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.download(com.vungle.warren.downloader.DownloadRequest, com.vungle.warren.downloader.AssetDownloadListener):void");
    }

    public boolean dropCache(@Nullable String str) {
        DownloaderCache downloaderCache = this.cache;
        if (!(downloaderCache == null || str == null)) {
            try {
                File file = downloaderCache.getFile(str);
                String str2 = TAG;
                Log.d(str2, "Broken asset, deleting " + file.getPath());
                return this.cache.deleteAndRemove(file);
            } catch (IOException e) {
                VungleLogger.error("AssetDownloader#dropCache; loadAd sequence", String.format("Error %1$s occured", new Object[]{e}));
                Log.e(TAG, "There was an error to get file", e);
            }
        }
        return false;
    }

    public synchronized List<DownloadRequest> getAllRequests() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = new ArrayList(this.mediators.values()).iterator();
        while (it.hasNext()) {
            arrayList.addAll(((DownloadRequestMediator) it.next()).requests());
        }
        arrayList.addAll(this.transitioning);
        return arrayList;
    }

    public synchronized void init() {
        if (this.cache != null) {
            this.cache.init();
        }
    }

    public synchronized boolean isCacheEnabled() {
        return this.cache != null && this.isCacheEnabled;
    }

    public synchronized void setCacheEnabled(boolean z) {
        this.isCacheEnabled = z;
    }

    @VisibleForTesting
    public synchronized void setDownloadedForTests(boolean z, String str, String str2) {
        ArrayList arrayList = new ArrayList(2);
        if (this.cache != null) {
            try {
                arrayList.add(this.cache.getMetaFile(this.cache.getFile(str)));
            } catch (IOException e) {
                Log.e(TAG, "Cannot add or get meta file", e);
                throw new RuntimeException("Failed to get file for request");
            }
        }
        arrayList.add(new File(str2 + ".vng_meta"));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            HashMap<String, String> extractMeta = extractMeta(file);
            extractMeta.put(DOWNLOAD_COMPLETE, Boolean.valueOf(z).toString());
            FileUtility.writeSerializable(file, extractMeta);
        }
    }

    public void setProgressStep(int i) {
        if (i != 0) {
            this.progressStep = i;
        }
    }

    public synchronized void shutdown() {
        cancel((DownloadRequest) null);
        this.transitioning.clear();
        this.mediators.clear();
        this.uiExecutor.shutdownNow();
        this.downloadExecutor.shutdownNow();
        try {
            this.downloadExecutor.awaitTermination(2, TimeUnit.SECONDS);
            this.uiExecutor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Log.e(TAG, "InterruptedException ", e);
            Thread.currentThread().interrupt();
        }
        return;
    }

    public void updatePriority(DownloadRequest downloadRequest) {
        Runnable runnable;
        DownloadRequestMediator findMediatorForCancellation = findMediatorForCancellation(downloadRequest);
        if (findMediatorForCancellation != null && (runnable = findMediatorForCancellation.getRunnable()) != null && this.downloadExecutor.remove(runnable)) {
            String str = TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("prio: updated to ");
            outline24.append(findMediatorForCancellation.getPriority());
            Log.d(str, outline24.toString());
            this.downloadExecutor.execute(runnable);
        }
    }

    public AssetDownloader(@Nullable DownloaderCache downloaderCache, long j, int i, @NonNull NetworkProvider networkProvider2, @NonNull ExecutorService executorService) {
        this.retryCountOnConnectionLost = 5;
        this.maxReconnectAttempts = 10;
        this.reconnectTimeout = 300;
        this.mediators = new ConcurrentHashMap();
        this.transitioning = new ArrayList();
        this.addLock = new Object();
        this.progressStep = 5;
        this.isCacheEnabled = true;
        this.networkListener = new NetworkProvider.NetworkListener() {
            public void onChanged(int i) {
                String access$000 = AssetDownloader.TAG;
                Log.d(access$000, "Network changed: " + i);
                AssetDownloader.this.onNetworkChanged(i);
            }
        };
        this.cache = downloaderCache;
        int max = Math.max(i, 1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, max, 1, TimeUnit.SECONDS, new PriorityBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.timeWindow = j;
        this.downloadExecutor = threadPoolExecutor;
        this.networkProvider = networkProvider2;
        this.uiExecutor = executorService;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout = Util.checkDuration("timeout", 30, TimeUnit.SECONDS);
        builder.cache = null;
        builder.internalCache = null;
        builder.followRedirects = true;
        builder.followSslRedirects = true;
        this.okHttpClient = new OkHttpClient(builder);
    }

    private String debugString(DownloadRequest downloadRequest) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(", single request url - ");
        outline24.append(downloadRequest.url);
        outline24.append(", path - ");
        outline24.append(downloadRequest.path);
        outline24.append(", th - ");
        outline24.append(Thread.currentThread().getName());
        outline24.append("id ");
        outline24.append(downloadRequest.f2848id);
        return outline24.toString();
    }

    public static abstract class DownloadPriorityRunnable implements Comparable, Runnable {
        public static final AtomicInteger seq = new AtomicInteger();
        public final DownloadRequestMediator mediator;
        public final int order = seq.incrementAndGet();
        public final AssetPriority priority;

        public DownloadPriorityRunnable(DownloadRequestMediator downloadRequestMediator) {
            this.mediator = downloadRequestMediator;
            this.priority = downloadRequestMediator.priority;
            downloadRequestMediator.setRunnable(this);
        }

        public int compareTo(@NonNull Object obj) {
            if (!(obj instanceof DownloadPriorityRunnable)) {
                return -1;
            }
            DownloadPriorityRunnable downloadPriorityRunnable = (DownloadPriorityRunnable) obj;
            int compareTo = getPriority().compareTo(downloadPriorityRunnable.getPriority());
            return compareTo == 0 ? Integer.valueOf(this.order).compareTo(Integer.valueOf(downloadPriorityRunnable.order)) : compareTo;
        }

        public AssetPriority getPriority() {
            DownloadRequestMediator downloadRequestMediator = this.mediator;
            return downloadRequestMediator != null ? downloadRequestMediator.getPriority() : this.priority;
        }

        public DownloadPriorityRunnable(AssetPriority assetPriority) {
            this.priority = assetPriority;
            this.mediator = null;
        }
    }
}
