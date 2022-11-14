package com.helpshift.support.imageloader;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.util.Callback;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.ImageUtil;
import java.io.IOException;

public class UriBitmapProvider implements BitmapProvider {
    public static final String TAG = "Helpshift_UriBtmpPrvdr";
    public Uri fileUri;

    public UriBitmapProvider(Uri uri) {
        this.fileUri = uri;
    }

    @RequiresApi(api = 28)
    public void getBitmap(final int i, final boolean z, Callback<Bitmap, String> callback) {
        try {
            ImageDecoder.Source createSource = ImageDecoder.createSource(HelpshiftContext.getApplicationContext().getContentResolver(), this.fileUri);
            C28121 r1 = new ImageDecoder.OnHeaderDecodedListener() {
                public void onHeaderDecoded(@NonNull ImageDecoder imageDecoder, @NonNull ImageDecoder.ImageInfo imageInfo, @NonNull ImageDecoder.Source source) {
                    Size size = imageInfo.getSize();
                    int width = size.getWidth();
                    int height = size.getHeight();
                    int i = i;
                    int i2 = 4;
                    if (i > 0 && width > 0 && height > 0) {
                        int calculateInSampleSize = ImageUtil.calculateInSampleSize(width, height, i, ImageUtil.calculateReqHeight(width, height, i));
                        if (calculateInSampleSize < 4) {
                            calculateInSampleSize++;
                        }
                        i2 = calculateInSampleSize;
                    }
                    if (!z) {
                        imageDecoder.setAllocator(1);
                    }
                    imageDecoder.setTargetSampleSize(i2);
                }
            };
            HSLogger.m3237d(TAG, "Image downloaded from file URI: " + this.fileUri);
            callback.onSuccess(ImageDecoder.decodeBitmap(createSource, r1));
        } catch (IOException unused) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error while building bitmap from uri: ");
            outline24.append(this.fileUri.toString());
            callback.onFailure(outline24.toString());
        }
    }

    @NonNull
    public String getSource() {
        return this.fileUri.toString();
    }
}
