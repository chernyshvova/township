package com.helpshift.support.imageloader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public class DisplayImageTask implements Runnable {
    public Bitmap bitmap;
    public WeakReference<ImageLoaderCallback> callback;
    public WeakReference<ImageView> target;

    public DisplayImageTask(Bitmap bitmap2, WeakReference<ImageView> weakReference, WeakReference<ImageLoaderCallback> weakReference2) {
        this.bitmap = bitmap2;
        this.target = weakReference;
        this.callback = weakReference2;
    }

    public void run() {
        if (!(this.target.get() == null || this.bitmap == null)) {
            ((ImageView) this.target.get()).setImageBitmap(this.bitmap);
        }
        if (this.callback.get() != null) {
            ((ImageLoaderCallback) this.callback.get()).onSuccess();
        }
    }
}
