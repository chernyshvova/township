package com.vungle.warren.downloader;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

@Keep
public class DownloadRequestMediator {
    public Map<String, Pair<DownloadRequest, AssetDownloadListener>> children = new ConcurrentHashMap(1);
    public AtomicBoolean connectedAtomic = new AtomicBoolean(true);
    public final String filePath;
    public final boolean isCacheable;
    public final String key;
    public final ReentrantLock lock = new ReentrantLock();
    public final String metaPath;
    public final AssetPriority priority;
    public AtomicReference<Runnable> runnable = new AtomicReference<>();
    public AtomicInteger statusAtomic = new AtomicInteger(0);
    public final String url;

    public DownloadRequestMediator(@NonNull DownloadRequest downloadRequest, @Nullable AssetDownloadListener assetDownloadListener, @NonNull String str, @NonNull String str2, boolean z, String str3) {
        this.url = downloadRequest.url;
        this.filePath = str;
        this.metaPath = str2;
        this.isCacheable = z;
        this.key = str3;
        this.priority = downloadRequest.getPriority();
        this.children.put(downloadRequest.f2848id, new Pair(downloadRequest, assetDownloadListener));
    }

    public synchronized void add(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) {
        this.children.put(downloadRequest.f2848id, new Pair(downloadRequest, assetDownloadListener));
    }

    public AssetPriority getPriority() {
        AssetPriority priority2;
        AssetPriority assetPriority = new AssetPriority(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Pair<DownloadRequest, AssetDownloadListener> pair : values()) {
            F f = pair.first;
            if (!(f == null || (priority2 = ((DownloadRequest) f).getPriority()) == null || assetPriority.compareTo(priority2) < 0)) {
                assetPriority = priority2;
            }
        }
        return assetPriority;
    }

    public Runnable getRunnable() {
        return this.runnable.get();
    }

    @Status
    public int getStatus() {
        return this.statusAtomic.get();
    }

    /* renamed from: is */
    public boolean mo21913is(@Status int i) {
        return this.statusAtomic.get() == i;
    }

    public boolean isConnected() {
        return this.connectedAtomic.get();
    }

    public boolean isPausable() {
        for (Pair<DownloadRequest, AssetDownloadListener> pair : values()) {
            F f = pair.first;
            if (f != null && ((DownloadRequest) f).pauseOnConnectionLost) {
                return true;
            }
        }
        return false;
    }

    public void lock() {
        this.lock.lock();
    }

    public synchronized Pair<DownloadRequest, AssetDownloadListener> remove(DownloadRequest downloadRequest) {
        return this.children.remove(downloadRequest.f2848id);
    }

    public synchronized List<DownloadRequest> requests() {
        ArrayList arrayList;
        List<Pair<DownloadRequest, AssetDownloadListener>> values = values();
        arrayList = new ArrayList();
        for (Pair<DownloadRequest, AssetDownloadListener> pair : values) {
            arrayList.add(pair.first);
        }
        return arrayList;
    }

    public void set(@Status int i) {
        if (this.statusAtomic.get() != 3) {
            this.statusAtomic.set(i);
        }
    }

    public void setConnected(boolean z) {
        this.connectedAtomic.set(z);
    }

    public void setRunnable(Runnable runnable2) {
        this.runnable.set(runnable2);
    }

    public void unlock() {
        this.lock.unlock();
    }

    public synchronized List<Pair<DownloadRequest, AssetDownloadListener>> values() {
        return new ArrayList(this.children.values());
    }
}
