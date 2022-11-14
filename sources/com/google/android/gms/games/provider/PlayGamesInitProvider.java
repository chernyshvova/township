package com.google.android.gms.games.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.internal.zzat;
import com.google.android.gms.internal.games_v2.zzal;
import com.google.android.gms.internal.games_v2.zzbq;

@zzal
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public class PlayGamesInitProvider extends ContentProvider {
    public final void attachInfo(@RecentlyNonNull Context context, @RecentlyNonNull ProviderInfo providerInfo) {
        Preconditions.checkNotNull(providerInfo, "PlayGamesSdkInitProvider ProviderInfo cannot be null.");
        if (!"com.google.android.gms.games.playgamesinitprovider".equals(providerInfo.authority)) {
            super.attachInfo(context, providerInfo);
            return;
        }
        throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
    }

    public final int delete(@RecentlyNonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @RecentlyNullable
    public final String getType(@RecentlyNonNull Uri uri) {
        return null;
    }

    @RecentlyNullable
    public final Uri insert(@RecentlyNonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    public final boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            zzat.zzg("GamesInitProvider", "No Context available. Please manually invoke PlayGamesSdk.initialize().");
            return false;
        }
        zzbq.zzc(context);
        return false;
    }

    @RecentlyNullable
    public final Cursor query(@RecentlyNonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    public final int update(@RecentlyNonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
