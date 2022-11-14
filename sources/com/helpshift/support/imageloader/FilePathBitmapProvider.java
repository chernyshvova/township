package com.helpshift.support.imageloader;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.util.AndroidFileUtil;
import com.helpshift.util.Callback;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ImageUtil;

public class FilePathBitmapProvider implements BitmapProvider {
    public static final String TAG = "Helpshift_FilePthPrvdr";
    public String path;

    public FilePathBitmapProvider(String str) {
        this.path = str;
    }

    public static int getExifRotation(String str) {
        try {
            String mimeType = AndroidFileUtil.getMimeType(str);
            if (mimeType != null && mimeType.contains("jpeg")) {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 3) {
                    return 180;
                }
                if (attributeInt == 8) {
                    return 270;
                }
                return 0;
            }
        } catch (Exception e) {
            HSLogger.m3242e("", "Exception in getting exif rotation", e);
        }
        return 0;
    }

    public Bitmap decodeFile(String str, int i) {
        return ImageUtil.decodeFile(str, i);
    }

    public void getBitmap(int i, boolean z, Callback<Bitmap, String> callback) {
        Bitmap decodeFile = decodeFile(this.path, i);
        if (decodeFile != null) {
            int exifRotation = getExifRotation(this.path);
            if (exifRotation != 0) {
                Matrix matrix = new Matrix();
                matrix.preRotate((float) exifRotation);
                decodeFile = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, false);
            }
            callback.onSuccess(decodeFile);
            HSLogger.m3237d(TAG, "Image loaded from filepath: " + this.path);
            return;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error in creating bitmap for given file path: ");
        outline24.append(this.path);
        callback.onFailure(outline24.toString());
    }

    @NonNull
    public String getSource() {
        return this.path;
    }
}
