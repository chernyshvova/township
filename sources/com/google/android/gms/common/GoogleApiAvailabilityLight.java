package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class GoogleApiAvailabilityLight {
    @RecentlyNonNull
    @KeepForSdk
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @KeepForSdk
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    @RecentlyNonNull
    @KeepForSdk
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    @KeepForSdk
    public static final String TRACKING_SOURCE_DIALOG = "d";
    @KeepForSdk
    public static final String TRACKING_SOURCE_NOTIFICATION = "n";
    public static final GoogleApiAvailabilityLight zza = new GoogleApiAvailabilityLight();

    @RecentlyNonNull
    @KeepForSdk
    public static GoogleApiAvailabilityLight getInstance() {
        return zza;
    }

    @KeepForSdk
    public void cancelAvailabilityErrorNotifications(@RecentlyNonNull Context context) {
        GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
    }

    @ShowFirstParty
    @KeepForSdk
    public int getApkVersion(@RecentlyNonNull Context context) {
        return GooglePlayServicesUtilLight.getApkVersion(context);
    }

    @ShowFirstParty
    @KeepForSdk
    public int getClientVersion(@RecentlyNonNull Context context) {
        return GooglePlayServicesUtilLight.getClientVersion(context);
    }

    @ShowFirstParty
    @RecentlyNullable
    @KeepForSdk
    @Deprecated
    public Intent getErrorResolutionIntent(int i) {
        return getErrorResolutionIntent((Context) null, i, (String) null);
    }

    @KeepForSdk
    @RecentlyNullable
    public PendingIntent getErrorResolutionPendingIntent(@RecentlyNonNull Context context, int i, int i2) {
        return getErrorResolutionPendingIntent(context, i, i2, (String) null);
    }

    @NonNull
    @KeepForSdk
    public String getErrorString(int i) {
        return GooglePlayServicesUtilLight.getErrorString(i);
    }

    @KeepForSdk
    @HideFirstParty
    public int isGooglePlayServicesAvailable(@RecentlyNonNull Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPlayServicesPossiblyUpdating(@RecentlyNonNull Context context, int i) {
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i);
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPlayStorePossiblyUpdating(@RecentlyNonNull Context context, int i) {
        return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i);
    }

    @KeepForSdk
    public boolean isUninstalledAppPossiblyUpdating(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        return GooglePlayServicesUtilLight.zza(context, str);
    }

    @KeepForSdk
    public boolean isUserResolvableError(int i) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i);
    }

    @KeepForSdk
    public void verifyGooglePlayServicesIsAvailable(@RecentlyNonNull Context context, int i) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context, i);
    }

    @ShowFirstParty
    @KeepForSdk
    @RecentlyNullable
    public Intent getErrorResolutionIntent(@Nullable Context context, int i, @Nullable String str) {
        if (i == 1 || i == 2) {
            if (context != null && DeviceProperties.isWearableWithoutPlayStore(context)) {
                return zzs.zzc();
            }
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("gcore_");
            outline24.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
            outline24.append("-");
            if (!TextUtils.isEmpty(str)) {
                outline24.append(str);
            }
            outline24.append("-");
            if (context != null) {
                outline24.append(context.getPackageName());
            }
            outline24.append("-");
            if (context != null) {
                try {
                    outline24.append(Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return zzs.zzb("com.google.android.gms", outline24.toString());
        } else if (i != 3) {
            return null;
        } else {
            return zzs.zza("com.google.android.gms");
        }
    }

    @ShowFirstParty
    @KeepForSdk
    @RecentlyNullable
    public PendingIntent getErrorResolutionPendingIntent(@RecentlyNonNull Context context, int i, int i2, @Nullable String str) {
        Intent errorResolutionIntent = getErrorResolutionIntent(context, i, str);
        if (errorResolutionIntent == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, errorResolutionIntent, 134217728);
    }

    @KeepForSdk
    public int isGooglePlayServicesAvailable(@RecentlyNonNull Context context, int i) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }
}
