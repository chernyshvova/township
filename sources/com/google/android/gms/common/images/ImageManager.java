package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.collection.LruCache;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.internal.base.zas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class ImageManager {
    public static final Object zaa = new Object();
    public static HashSet<Uri> zab = new HashSet<>();
    public static ImageManager zac;
    public final Context zad;
    public final Handler zae = new zas(Looper.getMainLooper());
    public final ExecutorService zaf = zao.zaa().zaa(4, zap.zab);
    @Nullable
    public final zaa zag = null;
    public final zak zah = new zak();
    public final Map<zab, ImageReceiver> zai = new HashMap();
    public final Map<Uri, ImageReceiver> zaj = new HashMap();
    public final Map<Uri, Long> zak = new HashMap();

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public interface OnImageLoadedListener {
        void onImageLoaded(@RecentlyNonNull Uri uri, @Nullable Drawable drawable, boolean z);
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class zaa extends LruCache<zaa, Bitmap> {
        public final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, @Nullable Object obj3) {
            throw new NoSuchMethodError();
        }

        public final /* synthetic */ int sizeOf(Object obj, Object obj2) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public final class zab implements Runnable {
        public final zab zaa;

        public zab(zab zab2) {
            this.zaa = zab2;
        }

        public final void run() {
            Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zai.get(this.zaa);
            if (imageReceiver != null) {
                ImageManager.this.zai.remove(this.zaa);
                imageReceiver.zab(this.zaa);
            }
            zab zab2 = this.zaa;
            zaa zaa2 = zab2.zaa;
            if (zaa2.zaa == null) {
                zab2.zaa(ImageManager.this.zad, ImageManager.this.zah, true);
                return;
            }
            Bitmap zaa3 = ImageManager.this.zaa(zaa2);
            if (zaa3 != null) {
                this.zaa.zaa(ImageManager.this.zad, zaa3, true);
                return;
            }
            Long l = (Long) ImageManager.this.zak.get(zaa2.zaa);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zaa.zaa(ImageManager.this.zad, ImageManager.this.zah, true);
                    return;
                }
                ImageManager.this.zak.remove(zaa2.zaa);
            }
            this.zaa.zaa(ImageManager.this.zad, ImageManager.this.zah);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.zaj.get(zaa2.zaa);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(zaa2.zaa);
                ImageManager.this.zaj.put(zaa2.zaa, imageReceiver2);
            }
            imageReceiver2.zaa(this.zaa);
            if (!(this.zaa instanceof zac)) {
                ImageManager.this.zai.put(this.zaa, imageReceiver2);
            }
            synchronized (ImageManager.zaa) {
                if (!ImageManager.zab.contains(zaa2.zaa)) {
                    ImageManager.zab.add(zaa2.zaa);
                    imageReceiver2.zaa();
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public final class zac implements Runnable {
        public final Uri zaa;
        @Nullable
        public final ParcelFileDescriptor zab;

        public zac(Uri uri, @Nullable ParcelFileDescriptor parcelFileDescriptor) {
            this.zaa = uri;
            this.zab = parcelFileDescriptor;
        }

        public final void run() {
            boolean z;
            Bitmap bitmap;
            Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.zab;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(this.zaa);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(valueOf);
                    Log.e("ImageManager", sb.toString(), e);
                    z2 = true;
                }
                try {
                    this.zab.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.zae.post(new zad(this.zaa, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.zaa);
                GeneratedOutlineSupport.outline30(valueOf2.length() + 32, "Latch interrupted while posting ", valueOf2, "ImageManager");
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public final class zad implements Runnable {
        public final Uri zaa;
        @Nullable
        public final Bitmap zab;
        public final CountDownLatch zac;
        public boolean zad;

        public zad(Uri uri, @Nullable Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zaa = uri;
            this.zab = bitmap;
            this.zad = z;
            this.zac = countDownLatch;
        }

        public final void run() {
            Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.zab != null;
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zaj.remove(this.zaa);
            if (imageReceiver != null) {
                ArrayList zaa2 = imageReceiver.zab;
                int size = zaa2.size();
                for (int i = 0; i < size; i++) {
                    zab zab2 = (zab) zaa2.get(i);
                    if (this.zab == null || !z) {
                        ImageManager.this.zak.put(this.zaa, Long.valueOf(SystemClock.elapsedRealtime()));
                        zab2.zaa(ImageManager.this.zad, ImageManager.this.zah, false);
                    } else {
                        zab2.zaa(ImageManager.this.zad, this.zab, false);
                    }
                    if (!(zab2 instanceof zac)) {
                        ImageManager.this.zai.remove(zab2);
                    }
                }
            }
            this.zac.countDown();
            synchronized (ImageManager.zaa) {
                ImageManager.zab.remove(this.zaa);
            }
        }
    }

    public ImageManager(Context context, boolean z) {
        this.zad = context.getApplicationContext();
    }

    @RecentlyNonNull
    public static ImageManager create(@RecentlyNonNull Context context) {
        if (zac == null) {
            zac = new ImageManager(context, false);
        }
        return zac;
    }

    /* access modifiers changed from: private */
    @Nullable
    public final Bitmap zaa(zaa zaa2) {
        return null;
    }

    private final void zaa(zab zab2) {
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new zab(zab2).run();
    }

    public final void loadImage(@RecentlyNonNull ImageView imageView, @RecentlyNonNull Uri uri) {
        zaa((zab) new zad(imageView, uri));
    }

    @KeepName
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public final class ImageReceiver extends ResultReceiver {
        public final Uri zaa;
        public final ArrayList<zab> zab = new ArrayList<>();

        public ImageReceiver(Uri uri) {
            super(new zas(Looper.getMainLooper()));
            this.zaa = uri;
        }

        public final void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.zaf.execute(new zac(this.zaa, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public final void zaa(zab zab2) {
            Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zab.add(zab2);
        }

        public final void zab(zab zab2) {
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zab.remove(zab2);
        }

        public final void zaa() {
            Intent intent = new Intent(Constants.ACTION_LOAD_IMAGE);
            intent.setPackage("com.google.android.gms");
            intent.putExtra(Constants.EXTRA_URI, this.zaa);
            intent.putExtra(Constants.EXTRA_RESULT_RECEIVER, this);
            intent.putExtra(Constants.EXTRA_PRIORITY, 3);
            ImageManager.this.zad.sendBroadcast(intent);
        }
    }

    public final void loadImage(@RecentlyNonNull ImageView imageView, int i) {
        zaa((zab) new zad(imageView, i));
    }

    public final void loadImage(@RecentlyNonNull ImageView imageView, @RecentlyNonNull Uri uri, int i) {
        zad zad2 = new zad(imageView, uri);
        zad2.zab = i;
        zaa((zab) zad2);
    }

    public final void loadImage(@RecentlyNonNull OnImageLoadedListener onImageLoadedListener, @RecentlyNonNull Uri uri) {
        zaa((zab) new zac(onImageLoadedListener, uri));
    }

    public final void loadImage(@RecentlyNonNull OnImageLoadedListener onImageLoadedListener, @RecentlyNonNull Uri uri, int i) {
        zac zac2 = new zac(onImageLoadedListener, uri);
        zac2.zab = i;
        zaa((zab) zac2);
    }
}
