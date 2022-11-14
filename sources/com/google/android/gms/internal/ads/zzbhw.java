package com.google.android.gms.internal.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbhw extends ContentProvider {
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        String str;
        Bundle bundle = null;
        try {
            bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (NullPointerException e) {
            zzcgs.zzg("Failed to load metadata: Null pointer exception.", e);
        } catch (PackageManager.NameNotFoundException e2) {
            zzcgs.zzg("Failed to load metadata: Package name not found.", e2);
        }
        zzbva zza = zzbva.zza();
        if (bundle == null) {
            zzcgs.zzf("Metadata was null.");
        } else {
            try {
                String str2 = (String) bundle.get("com.google.android.gms.ads.APPLICATION_ID");
                try {
                    Boolean bool = (Boolean) bundle.get("com.google.android.gms.ads.AD_MANAGER_APP");
                    try {
                        Boolean bool2 = (Boolean) bundle.get("com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT");
                        try {
                            String str3 = (String) bundle.get("com.google.android.gms.ads.INTEGRATION_MANAGER");
                            if (str2 == null || str2.matches("^/\\d+~.+$")) {
                                if (bool == null || !bool.booleanValue()) {
                                    if (!TextUtils.isEmpty(str3)) {
                                        String valueOf = String.valueOf(str3);
                                        zzcgs.zzd(valueOf.length() != 0 ? "The Google Mobile Ads SDK is integrated by ".concat(valueOf) : new String("The Google Mobile Ads SDK is integrated by "));
                                    } else {
                                        throw new IllegalStateException("\n\n******************************************************************************\n* The Google Mobile Ads SDK was initialized incorrectly. AdMob publishers    *\n* should follow the instructions here:                                       *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to add a valid App ID inside the AndroidManifest.                          *\n* Google Ad Manager publishers should follow instructions here:              *\n* https://googlemobileadssdk.page.link/ad-manager-android-update-manifest.   *\n******************************************************************************\n\n");
                                    }
                                }
                            } else if (str2.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$")) {
                                if (str2.length() != 0) {
                                    str = "Publisher provided Google AdMob App ID in manifest: ".concat(str2);
                                } else {
                                    str = new String("Publisher provided Google AdMob App ID in manifest: ");
                                }
                                zzcgs.zzd(str);
                                if (bool2 == null || !bool2.booleanValue()) {
                                    zza.zzb(context, str2);
                                }
                            } else {
                                throw new IllegalStateException("\n\n******************************************************************************\n* Invalid application ID. Follow instructions here:                          *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to find your app ID.                                                       *\n******************************************************************************\n\n");
                            }
                        } catch (ClassCastException e3) {
                            throw new IllegalStateException("The com.google.android.gms.ads.INTEGRATION_MANAGER metadata must have a String value.", e3);
                        }
                    } catch (ClassCastException e4) {
                        throw new IllegalStateException("The com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT metadata must have a boolean value.", e4);
                    }
                } catch (ClassCastException e5) {
                    throw new IllegalStateException("The com.google.android.gms.ads.AD_MANAGER_APP metadata must have a boolean value.", e5);
                }
            } catch (ClassCastException e6) {
                throw new IllegalStateException("The com.google.android.gms.ads.APPLICATION_ID metadata must have a String value.", e6);
            }
        }
        super.attachInfo(context, providerInfo);
    }

    public final int delete(@NonNull Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Nullable
    public final String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public final Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return null;
    }

    public final boolean onCreate() {
        return false;
    }

    @Nullable
    public final Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public final int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
