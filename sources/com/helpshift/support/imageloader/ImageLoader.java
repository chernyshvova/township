package com.helpshift.support.imageloader;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.helpshift.android.commons.downloader.HsUriUtils;
import com.helpshift.common.domain.HSThreadFactory;
import com.helpshift.util.HelpshiftContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ImageLoader {
    public static ImageLoader mInstance;
    public final ExecutorService imageLoaderExecutor;
    public BitmapLruCache lruCache;
    public final Handler mainThreadHandler;
    public final Map<ImageView, LoadAndDisplayImageTask> viewToActionMap = new LinkedHashMap();

    public ImageLoader(ExecutorService executorService) {
        this.imageLoaderExecutor = executorService;
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
        this.lruCache = new BitmapLruCache();
    }

    private void cancelExistingRequest(ImageView imageView) {
        LoadAndDisplayImageTask remove = this.viewToActionMap.remove(imageView);
        if (remove != null) {
            remove.cancel();
        }
    }

    private BitmapProvider getBitmapProvider(String str) {
        if (str == null) {
            return null;
        }
        if (HsUriUtils.isValidUriPath(str)) {
            return new UriBitmapProvider(Uri.parse(str));
        }
        if (isValidUrl(str)) {
            return new URLBitmapProvider(str, HelpshiftContext.getPlatform().getDownloader(), HelpshiftContext.getCoreApi().getDomain(), HelpshiftContext.getPlatform());
        }
        return new FilePathBitmapProvider(str);
    }

    public static synchronized ImageLoader getInstance() {
        ImageLoader imageLoader;
        synchronized (ImageLoader.class) {
            if (mInstance == null) {
                mInstance = new ImageLoader(new ThreadPoolExecutor(1, 3, 10, TimeUnit.SECONDS, new LIFOLinkedBlockingDeque(), new HSThreadFactory("image-loader")));
            }
            imageLoader = mInstance;
        }
        return imageLoader;
    }

    private boolean isValidUrl(String str) {
        return !str.isEmpty() && (str.startsWith("https://") || str.startsWith("http://"));
    }

    private void loadBitmap(String str, ImageView imageView, Drawable drawable, ImageLoaderCallback imageLoaderCallback, int i) {
        cancelExistingRequest(imageView);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        if (str != null) {
            Bitmap bitmap = this.lruCache.get(str);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                if (imageLoaderCallback != null) {
                    imageLoaderCallback.onSuccess();
                    return;
                }
                return;
            }
            BitmapProvider bitmapProvider = getBitmapProvider(str);
            if (bitmapProvider != null) {
                LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(bitmapProvider, i, imageView.isHardwareAccelerated(), imageView, imageLoaderCallback, this.lruCache, this.mainThreadHandler);
                this.viewToActionMap.put(imageView, loadAndDisplayImageTask);
                loadAndDisplayImageTask.submit(this.imageLoaderExecutor);
            }
        }
    }

    public void cancelAll() {
        Iterator it = new ArrayList(this.viewToActionMap.values()).iterator();
        while (it.hasNext()) {
            cancelExistingRequest(((LoadAndDisplayImageTask) it.next()).getTarget());
        }
        this.viewToActionMap.clear();
    }

    public void destroy() {
        cancelAll();
        this.lruCache.clear();
        this.imageLoaderExecutor.shutdown();
        mInstance = null;
    }

    public void load(@NonNull String str, @NonNull ImageView imageView) {
        load(str, imageView, (Drawable) null);
    }

    public void loadImageWithoutSampling(@NonNull String str, @NonNull ImageView imageView, Drawable drawable, int i) {
        cancelExistingRequest(imageView);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        if (str != null) {
            Bitmap bitmap = this.lruCache.get(str);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(new AvatarFilePathBitmapProvider(str), i, imageView.isHardwareAccelerated(), imageView, (ImageLoaderCallback) null, this.lruCache, this.mainThreadHandler);
            this.viewToActionMap.put(imageView, loadAndDisplayImageTask);
            loadAndDisplayImageTask.submit(this.imageLoaderExecutor);
        }
    }

    public void load(@NonNull String str, @NonNull ImageView imageView, Drawable drawable) {
        load(str, imageView, drawable, (ImageLoaderCallback) null);
    }

    public void load(@NonNull String str, @NonNull ImageView imageView, Drawable drawable, ImageLoaderCallback imageLoaderCallback) {
        load(str, imageView, drawable, imageView.getWidth(), imageLoaderCallback);
    }

    public void load(@NonNull String str, @NonNull ImageView imageView, Drawable drawable, int i, ImageLoaderCallback imageLoaderCallback) {
        loadBitmap(str, imageView, drawable, imageLoaderCallback, i);
    }
}
