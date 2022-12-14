package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.google.android.gms.common.C1632R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class GoogleServices {
    public static final Object zza = new Object();
    @GuardedBy("sLock")
    @Nullable
    public static GoogleServices zzb;
    @Nullable
    public final String zzc;
    public final Status zzd;
    public final boolean zze;
    public final boolean zzf;

    @KeepForSdk
    @VisibleForTesting
    public GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C1632R.string.common_google_play_services_unknown_issue));
        boolean z = true;
        if (identifier != 0) {
            int integer = resources.getInteger(identifier);
            boolean z2 = integer == 0;
            z = integer == 0 ? false : z;
            this.zzf = z2;
        } else {
            this.zzf = false;
        }
        this.zze = z;
        String zza2 = zzaf.zza(context);
        zza2 = zza2 == null ? new StringResourceValueReader(context).getString("google_app_id") : zza2;
        if (TextUtils.isEmpty(zza2)) {
            this.zzd = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzc = null;
            return;
        }
        this.zzc = zza2;
        this.zzd = Status.RESULT_SUCCESS;
    }

    @KeepForSdk
    @VisibleForTesting
    public GoogleServices(String str, boolean z) {
        this.zzc = str;
        this.zzd = Status.RESULT_SUCCESS;
        this.zze = z;
        this.zzf = !z;
    }

    @KeepForSdk
    public static GoogleServices checkInitialized(String str) {
        GoogleServices googleServices;
        synchronized (zza) {
            if (zzb != null) {
                googleServices = zzb;
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(CodelessMatcher.CURRENT_CLASS_NAME);
                throw new IllegalStateException(sb.toString());
            }
        }
        return googleServices;
    }

    @KeepForSdk
    @VisibleForTesting
    public static void clearInstanceForTest() {
        synchronized (zza) {
            zzb = null;
        }
    }

    @KeepForSdk
    @RecentlyNullable
    public static String getGoogleAppId() {
        return checkInitialized("getGoogleAppId").zzc;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static Status initialize(@RecentlyNonNull Context context) {
        Status status;
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (zza) {
            if (zzb == null) {
                zzb = new GoogleServices(context);
            }
            status = zzb.zzd;
        }
        return status;
    }

    @KeepForSdk
    public static boolean isMeasurementEnabled() {
        GoogleServices checkInitialized = checkInitialized("isMeasurementEnabled");
        return checkInitialized.zzd.isSuccess() && checkInitialized.zze;
    }

    @KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        return checkInitialized("isMeasurementExplicitlyDisabled").zzf;
    }

    @KeepForSdk
    @VisibleForTesting
    public Status checkGoogleAppId(String str) {
        String str2 = this.zzc;
        if (str2 == null || str2.equals(str)) {
            return Status.RESULT_SUCCESS;
        }
        String str3 = this.zzc;
        return new Status(10, GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(str3).length() + 97), "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '", str3, "'."));
    }

    @RecentlyNonNull
    @KeepForSdk
    public static Status initialize(@RecentlyNonNull Context context, @RecentlyNonNull String str, boolean z) {
        Preconditions.checkNotNull(context, "Context must not be null.");
        Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (zza) {
            if (zzb != null) {
                Status checkGoogleAppId = zzb.checkGoogleAppId(str);
                return checkGoogleAppId;
            }
            GoogleServices googleServices = new GoogleServices(str, z);
            zzb = googleServices;
            Status status = googleServices.zzd;
            return status;
        }
    }
}
