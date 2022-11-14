package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.google.android.gms.internal.firebase_messaging.zzh;
import com.google.android.gms.internal.firebase_messaging.zzk;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class ImageDownload$$Lambda$0 implements Callable {
    public final ImageDownload arg$1;

    public ImageDownload$$Lambda$0(ImageDownload imageDownload) {
        this.arg$1 = imageDownload;
    }

    public final Object call() {
        ImageDownload imageDownload = this.arg$1;
        String valueOf = String.valueOf(imageDownload.url);
        StringBuilder sb = new StringBuilder(valueOf.length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        Log.i("FirebaseMessaging", sb.toString());
        URLConnection openConnection = imageDownload.url.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                imageDownload.connectionInputStream = inputStream;
                byte[] zza = zzh.zza(zzh.zza(inputStream, 1048577));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable("FirebaseMessaging", 2)) {
                    int length = zza.length;
                    String valueOf2 = String.valueOf(imageDownload.url);
                    StringBuilder sb2 = new StringBuilder(valueOf2.length() + 34);
                    sb2.append("Downloaded ");
                    sb2.append(length);
                    sb2.append(" bytes from ");
                    sb2.append(valueOf2);
                    Log.v("FirebaseMessaging", sb2.toString());
                }
                if (zza.length <= 1048576) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(zza, 0, zza.length);
                    if (decodeByteArray != null) {
                        if (Log.isLoggable("FirebaseMessaging", 3)) {
                            String valueOf3 = String.valueOf(imageDownload.url);
                            StringBuilder sb3 = new StringBuilder(valueOf3.length() + 31);
                            sb3.append("Successfully downloaded image: ");
                            sb3.append(valueOf3);
                            Log.d("FirebaseMessaging", sb3.toString());
                        }
                        return decodeByteArray;
                    }
                    String valueOf4 = String.valueOf(imageDownload.url);
                    StringBuilder sb4 = new StringBuilder(valueOf4.length() + 24);
                    sb4.append("Failed to decode image: ");
                    sb4.append(valueOf4);
                    throw new IOException(sb4.toString());
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                zzk.zza(th, th);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }
}
