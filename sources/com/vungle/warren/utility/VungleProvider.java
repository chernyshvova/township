package com.vungle.warren.utility;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;

public final class VungleProvider extends ContentProvider {
    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(@NonNull Uri uri) {
        return null;
    }

    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            return true;
        }
        ActivityManager.getInstance().init(context);
        return true;
    }

    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
