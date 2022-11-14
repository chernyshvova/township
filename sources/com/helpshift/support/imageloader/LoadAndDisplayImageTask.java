package com.helpshift.support.imageloader;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.helpshift.util.Callback;
import com.helpshift.util.HSLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

public class LoadAndDisplayImageTask implements Callable<Void>, Callback<Bitmap, String> {
    public static final String TAG = "Helpshift_DisplyImgTsk";
    public WeakReference<ImageLoaderCallback> callback;
    @Nullable
    public Future<?> future;
    public final boolean isHardwareAccelerated;
    public BitmapLruCache lruCache;
    public Handler mainThreadHandler;
    public final BitmapProvider provider;
    public WeakReference<ImageView> target;
    public final int width;

    public LoadAndDisplayImageTask(BitmapProvider bitmapProvider, int i, boolean z, ImageView imageView, ImageLoaderCallback imageLoaderCallback, BitmapLruCache bitmapLruCache, Handler handler) {
        this.provider = bitmapProvider;
        this.width = i;
        this.isHardwareAccelerated = z;
        this.target = new WeakReference<>(imageView);
        this.callback = new WeakReference<>(imageLoaderCallback);
        this.lruCache = bitmapLruCache;
        this.mainThreadHandler = handler;
    }

    public boolean cancel() {
        Future<?> future2 = this.future;
        if (future2 == null || !future2.cancel(true)) {
            return false;
        }
        return true;
    }

    public ImageView getTarget() {
        return (ImageView) this.target.get();
    }

    public boolean isCancelled() {
        Future<?> future2 = this.future;
        return future2 != null && future2.isCancelled();
    }

    public void submit(@NonNull ExecutorService executorService) {
        try {
            this.future = executorService.submit(this);
        } catch (RejectedExecutionException e) {
            HSLogger.m3242e(TAG, "Rejected execution of image loader task", e);
        }
    }

    public final Void call() {
        this.provider.getBitmap(this.width, this.isHardwareAccelerated, this);
        return null;
    }

    public void onFailure(String str) {
        HSLogger.m3241e(TAG, str);
        cancel();
    }

    public void onSuccess(Bitmap bitmap) {
        this.lruCache.set(this.provider.getSource(), bitmap);
        this.mainThreadHandler.post(new DisplayImageTask(bitmap, this.target, this.callback));
    }
}
