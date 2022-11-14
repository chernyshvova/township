package com.applovin.impl.sdk;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.drive.DriveFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AppLovinContentProviderUtils {

    /* renamed from: a */
    public static final String[] f1275a = {"_display_name", "_size"};

    /* renamed from: a */
    public static Uri m1354a(String str) {
        return Uri.parse(NativeProtocol.CONTENT_SCHEME + (C1188m.m2053M().getPackageName() + ".applovincontentprovider/" + str));
    }

    @Nullable
    /* renamed from: a */
    public static File m1355a(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return null;
        }
        return m1356b(lastPathSegment);
    }

    @Nullable
    /* renamed from: b */
    public static File m1356b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(C1188m.m2053M().getCacheDir());
        File file = new File(GeneratedOutlineSupport.outline18(sb, File.separator, "ALContentProviderCache"));
        if (!file.exists()) {
            try {
                if (!file.mkdir()) {
                    return null;
                }
            } catch (Throwable unused) {
            }
        }
        return new File(file, str);
    }

    @Nullable
    public static Uri cacheJPEGImageWithFileName(Bitmap bitmap, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(m1356b(str));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return m1354a(str);
        } catch (Throwable th) {
            C1314v.m2663i("AppLovinContentProvider", "Failed to create jpeg file '" + str + "' for content provider with exception: " + th);
            return null;
        }
    }

    @Nullable
    public static Uri cacheTextWithFileName(String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(m1356b(str2));
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
            return m1354a(str2);
        } catch (Throwable th) {
            C1314v.m2663i("AppLovinContentProvider", "Failed to create text file '" + str2 + "' for content provider with exception: " + th);
            return null;
        }
    }

    @Nullable
    public static String getType(Uri uri) {
        File a = m1355a(uri);
        try {
            String substring = a.getName().substring(a.getName().indexOf(46) + 1);
            if (MimeTypeMap.getSingleton().hasExtension(substring)) {
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring);
            }
            return null;
        } catch (Throwable th) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to get file type for '");
            outline24.append(uri.toString());
            outline24.append("'");
            C1314v.m2659c("AppLovinContentProvider", outline24.toString(), th);
            return null;
        }
    }

    @Nullable
    public static ParcelFileDescriptor openFile(Uri uri) {
        try {
            return ParcelFileDescriptor.open(m1355a(uri), DriveFile.MODE_READ_ONLY);
        } catch (FileNotFoundException e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to open file '");
            outline24.append(uri.toString());
            outline24.append("'");
            C1314v.m2659c("AppLovinContentProvider", outline24.toString(), e);
            return null;
        }
    }

    @Nullable
    public static Cursor query(Uri uri) {
        File a = m1355a(uri);
        try {
            MatrixCursor matrixCursor = new MatrixCursor(f1275a, 1);
            matrixCursor.addRow(new Object[]{a.getName(), Long.valueOf(a.length())});
            return matrixCursor;
        } catch (Throwable th) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to query file '");
            outline24.append(uri.toString());
            outline24.append("'");
            C1314v.m2659c("AppLovinContentProvider", outline24.toString(), th);
            return null;
        }
    }
}
