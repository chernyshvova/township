package com.facebook.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdk;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FacebookInitProvider.kt */
public final class FacebookInitProvider extends ContentProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG;

    /* compiled from: FacebookInitProvider.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = FacebookInitProvider.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "FacebookInitProvider::class.java.simpleName");
        TAG = simpleName;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    public boolean onCreate() {
        try {
            Context context = getContext();
            if (context != null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.sdkInitialize(context);
                return false;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } catch (Exception e) {
            Log.i(TAG, "Failed to auto initialize the Facebook SDK", e);
            return false;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }
}
