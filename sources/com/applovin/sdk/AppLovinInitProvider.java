package com.applovin.sdk;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.AppLovinContentProviderUtils;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1234o;
import com.applovin.impl.sdk.C1243p;
import com.applovin.impl.sdk.utils.Utils;

public class AppLovinInitProvider extends ContentProvider {
    public int delete(Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Nullable
    public String getType(Uri uri) {
        return AppLovinContentProviderUtils.getType(uri);
    }

    @Nullable
    public Uri insert(Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        if (Utils.isTestApp(getContext())) {
            C1243p.m2427a();
        }
        C1234o.m2386a(getContext());
        C1234o.m2393c(getContext());
        C1188m.m2054a(getContext());
        return true;
    }

    @Nullable
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return AppLovinContentProviderUtils.openFile(uri);
    }

    @Nullable
    public Cursor query(Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return AppLovinContentProviderUtils.query(uri);
    }

    public int update(Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
