package com.helpshift.android.commons.downloader;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.facebook.internal.NativeProtocol;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.IOException;

public class HsUriUtils {
    public static boolean canReadFileAtUri(Context context, String str) {
        boolean z = false;
        if (!isValidUriPath(str)) {
            return false;
        }
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(Uri.parse(str), AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
            if (parcelFileDescriptor != null) {
                z = true;
            }
        } catch (Exception unused) {
        } finally {
            closeParcelFileDescriptor(parcelFileDescriptor);
        }
        return z;
    }

    public static void closeParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean isValidUriPath(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return str.startsWith(NativeProtocol.CONTENT_SCHEME);
    }
}
