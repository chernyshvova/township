package com.helpshift.util;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import com.helpshift.analytics.AnalyticsEventKey;
import com.vungle.warren.model.Advertisement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AndroidFileUtil {
    public static final String TAG = "AndroidFileUtil";
    public static final Set<String> imageMimeTypes = new HashSet(Arrays.asList(new String[]{"image/jpeg", "image/png", "image/gif", "image/x-png", "image/x-citrix-pjpeg", "image/x-citrix-gif", "image/pjpeg"}));

    public static boolean doesFileFromUriExistAndCanRead(Uri uri, Context context) {
        boolean z = false;
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
            if (openFileDescriptor != null) {
                z = true;
            }
            if (openFileDescriptor != null) {
                try {
                    openFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
            return z;
        } catch (Exception e) {
            String str = TAG;
            HSLogger.m3238d(str, "Unable to open input file descriptor for doesFileFromUriExistAndCanRead: " + uri, (Throwable) e);
            return false;
        }
    }

    public static String getFileExtension(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(47);
        int lastIndexOf2 = str.lastIndexOf(46);
        if (lastIndexOf2 <= 0 || lastIndexOf2 >= str.length() - 1 || lastIndexOf >= lastIndexOf2) {
            return null;
        }
        return str.substring(lastIndexOf2 + 1);
    }

    public static String getFileExtensionFromFileName(String str) {
        int lastIndexOf;
        if (StringUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        String substring = str.substring(lastIndexOf + 1);
        if (substring.indexOf(47) >= 0) {
            return null;
        }
        return substring;
    }

    public static String getFileExtensionFromMimeType(Context context, @NonNull Uri uri) {
        if ("content".equals(uri.getScheme())) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        }
        return MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
    }

    public static String getMimeType(URL url) {
        try {
            return url.openConnection().getContentType();
        } catch (Exception e) {
            HSLogger.m3238d(TAG, "openConnection() Exception :", (Throwable) e);
            return null;
        }
    }

    public static boolean isSupportedMimeType(String str) {
        return imageMimeTypes.contains(str);
    }

    public static void saveFile(URL url, File file) {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        try {
            InputStream openStream = url.openStream();
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                e = e;
                fileOutputStream = null;
                inputStream = openStream;
                try {
                    HSLogger.m3238d(TAG, "saveFile Exception :", (Throwable) e);
                    IOUtils.closeQuitely(inputStream);
                    IOUtils.closeQuitely(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuitely(inputStream);
                    IOUtils.closeQuitely(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                inputStream = openStream;
                IOUtils.closeQuitely(inputStream);
                IOUtils.closeQuitely(fileOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[500];
                while (true) {
                    int read = openStream.read(bArr, 0, 500);
                    if (read < 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                IOUtils.closeQuitely(openStream);
            } catch (Exception e2) {
                e = e2;
                inputStream = openStream;
                HSLogger.m3238d(TAG, "saveFile Exception :", (Throwable) e);
                IOUtils.closeQuitely(inputStream);
                IOUtils.closeQuitely(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                inputStream = openStream;
                IOUtils.closeQuitely(inputStream);
                IOUtils.closeQuitely(fileOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            HSLogger.m3238d(TAG, "saveFile Exception :", (Throwable) e);
            IOUtils.closeQuitely(inputStream);
            IOUtils.closeQuitely(fileOutputStream);
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            IOUtils.closeQuitely(inputStream);
            IOUtils.closeQuitely(fileOutputStream);
            throw th;
        }
        IOUtils.closeQuitely(fileOutputStream);
    }

    public static String getMimeType(String str) {
        try {
            return getMimeType(new URL(Advertisement.FILE_SCHEME + str));
        } catch (MalformedURLException e) {
            HSLogger.m3238d(TAG, "error in getting mimeType :", (Throwable) e);
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r7 != null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.helpshift.util.HSLogger.m3241e(TAG, "Unable to detect file extension via Uri");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        if (r7 == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileExtension(android.content.Context r7, android.net.Uri r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0049
            if (r7 != 0) goto L_0x0006
            goto L_0x0049
        L_0x0006:
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch:{ Exception -> 0x0035, all -> 0x0033 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r8
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0035, all -> 0x0033 }
            if (r7 == 0) goto L_0x002d
            boolean r8 = r7.moveToFirst()     // Catch:{ Exception -> 0x0036 }
            if (r8 == 0) goto L_0x002d
            java.lang.String r8 = "_display_name"
            int r8 = r7.getColumnIndex(r8)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r8 = r7.getString(r8)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r8 = getFileExtensionFromFileName(r8)     // Catch:{ Exception -> 0x0036 }
            r7.close()
            return r8
        L_0x002d:
            if (r7 == 0) goto L_0x0040
        L_0x002f:
            r7.close()
            goto L_0x0040
        L_0x0033:
            r8 = move-exception
            goto L_0x0043
        L_0x0035:
            r7 = r0
        L_0x0036:
            java.lang.String r8 = TAG     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = "Unable to detect file extension via Uri"
            com.helpshift.util.HSLogger.m3241e(r8, r1)     // Catch:{ all -> 0x0041 }
            if (r7 == 0) goto L_0x0040
            goto L_0x002f
        L_0x0040:
            return r0
        L_0x0041:
            r8 = move-exception
            r0 = r7
        L_0x0043:
            if (r0 == 0) goto L_0x0048
            r0.close()
        L_0x0048:
            throw r8
        L_0x0049:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.util.AndroidFileUtil.getFileExtension(android.content.Context, android.net.Uri):java.lang.String");
    }
}
