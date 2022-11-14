package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_messaging.zzi;
import com.google.android.gms.tasks.Task;
import java.io.Closeable;
import java.io.InputStream;
import java.net.URL;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public class ImageDownload implements Closeable {
    @Nullable
    public volatile InputStream connectionInputStream;
    @Nullable
    public Task<Bitmap> task;
    public final URL url;

    public ImageDownload(URL url2) {
        this.url = url2;
    }

    public void close() {
        try {
            zzi.zza(this.connectionInputStream);
        } catch (NullPointerException e) {
            Log.e("FirebaseMessaging", "Failed to close the image download stream.", e);
        }
    }
}
