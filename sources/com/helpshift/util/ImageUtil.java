package com.helpshift.util;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ImageUtil {
    public static final String TAG = "Helpshift_ImageUtil";
    public static final Set<String> resizableImageMimeTypes = new HashSet(Arrays.asList(new String[]{"image/jpeg", "image/png", "image/x-png", "image/x-citrix-pjpeg", "image/pjpeg"}));
    public static Set<String> supportedImageMimeTypes = new HashSet(Arrays.asList(new String[]{"image/jpeg", "image/png", "image/bmp"}));

    public static int calculateInSampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (i6 / i5 > i4 && i7 / i5 > i3) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static int calculateReqHeight(int i, int i2, int i3) {
        return (int) ((((float) i2) / ((float) i)) * ((float) i3));
    }

    public static Bitmap decodeAvatarImageFile(String str) {
        if (!FileUtil.doesFilePathExistAndCanRead(str)) {
            return null;
        }
        return BitmapFactory.decodeFile(str, new BitmapFactory.Options());
    }

    public static Bitmap decodeFile(String str, int i) {
        if (!FileUtil.doesFilePathExistAndCanRead(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i > 0) {
            int calculateReqHeight = calculateReqHeight(options.outWidth, options.outHeight, i);
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int calculateInSampleSize = calculateInSampleSize(options, i, calculateReqHeight);
            options.inSampleSize = calculateInSampleSize;
            if (calculateInSampleSize < 4) {
                options.inSampleSize = calculateInSampleSize + 1;
            }
        } else {
            options.inSampleSize = 4;
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap getBitmap(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.canRead()) {
            return null;
        }
        int i2 = 1;
        int i3 = 0;
        do {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = i2;
                options.inJustDecodeBounds = false;
                return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            } catch (OutOfMemoryError unused) {
                i2 = i > 0 ? i : i2 * 2;
                i3++;
                if (i3 == 3) {
                    return null;
                }
            }
        } while (i3 == 3);
        return null;
    }

    public static Bitmap getBitmapWithMaxDimension(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float max = ((float) i) / ((float) Math.max(height, width));
        if (max >= 1.0f) {
            return bitmap;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (((float) width) * max), (int) (((float) height) * max), true);
    }

    public static int getExifOrientation(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"orientation"}, (String) null, (String[]) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i = query.getInt(0);
                    query.close();
                    return i;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (Exception unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static boolean isImageFileFormatSupported(String str) {
        return isSupportedImageMimeType(AndroidFileUtil.getMimeType(str));
    }

    public static boolean isResizableImage(String str) {
        return resizableImageMimeTypes.contains(AndroidFileUtil.getMimeType(str));
    }

    public static boolean isSupportedImageMimeType(String str) {
        return supportedImageMimeTypes.contains(str);
    }

    public static Bitmap rotateImage(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.preRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public static void saveBitmapToFile(Bitmap bitmap, String str, String str2) {
        Bitmap.CompressFormat compressFormat;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (str2.contains("png")) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        if (bitmap.compress(compressFormat, 70, byteArrayOutputStream)) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str, false);
                try {
                    fileOutputStream2.write(byteArray);
                    fileOutputStream2.flush();
                    IOUtils.closeQuitely(byteArrayOutputStream);
                    IOUtils.closeQuitely(fileOutputStream2);
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    try {
                        HSLogger.m3238d(TAG, "saveBitmapToFile : ", (Throwable) e);
                        IOUtils.closeQuitely(byteArrayOutputStream);
                        IOUtils.closeQuitely(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeQuitely(byteArrayOutputStream);
                        IOUtils.closeQuitely(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    IOUtils.closeQuitely(byteArrayOutputStream);
                    IOUtils.closeQuitely(fileOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                HSLogger.m3238d(TAG, "saveBitmapToFile : ", (Throwable) e);
                IOUtils.closeQuitely(byteArrayOutputStream);
                IOUtils.closeQuitely(fileOutputStream);
            }
        } else {
            HSLogger.m3241e(TAG, "saveBitmapToFile : Compression Failed");
        }
    }

    public static void scaleDownAndSave(String str, int i) {
        if (!TextUtils.isEmpty(str) && i > 0) {
            File file = new File(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            int i2 = options.outHeight;
            float f = (float) options.outWidth;
            float f2 = (float) i2;
            int sqrt = ((int) Math.sqrt((double) ((f / f2) * ((float) (i * 25))))) * 100;
            int calculateInSampleSize = calculateInSampleSize(options, sqrt, (int) ((f2 / f) * ((float) sqrt)));
            options.inSampleSize = calculateInSampleSize;
            if (calculateInSampleSize > 1) {
                options.inJustDecodeBounds = false;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (decodeFile != null) {
                    saveBitmapToFile(decodeFile, str, AndroidFileUtil.getMimeType(str));
                }
            }
        }
    }

    public static void scaleDownAndSaveWithMaxDimension(String str, int i) {
        scaleDownAndSaveWithMaxDimension(str, i, 0);
    }

    public static boolean isResizableImage(Uri uri, Context context) {
        return resizableImageMimeTypes.contains(context.getContentResolver().getType(uri));
    }

    public static void scaleDownAndSaveWithMaxDimension(String str, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            float max = ((float) i) / ((float) Math.max(i3, i4));
            if (max < 1.0f) {
                options.inSampleSize = calculateInSampleSize(options, (int) (((float) i4) * max), (int) (((float) i3) * max));
                options.inJustDecodeBounds = false;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (decodeFile != null) {
                    Bitmap bitmapWithMaxDimension = getBitmapWithMaxDimension(decodeFile, i);
                    if (i2 != 0) {
                        bitmapWithMaxDimension = rotateImage(bitmapWithMaxDimension, i2);
                    }
                    saveBitmapToFile(bitmapWithMaxDimension, str, AndroidFileUtil.getMimeType(str));
                }
            }
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        return calculateInSampleSize(options.outWidth, options.outHeight, i, i2);
    }

    public static Bitmap getBitmap(Resources resources, int i, int i2) {
        int i3 = 1;
        int i4 = 0;
        do {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = i3;
                options.inJustDecodeBounds = false;
                return BitmapFactory.decodeResource(resources, i, options);
            } catch (OutOfMemoryError unused) {
                i3 = i2 > 0 ? i2 : i3 * 2;
                i4++;
                if (i4 == 3) {
                    return null;
                }
            }
        } while (i4 == 3);
        return null;
    }
}
