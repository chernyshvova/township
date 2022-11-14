package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class Wrappers {
    public static Wrappers zzb = new Wrappers();
    @Nullable
    public PackageManagerWrapper zza = null;

    @RecentlyNonNull
    @KeepForSdk
    public static PackageManagerWrapper packageManager(@RecentlyNonNull Context context) {
        return zzb.zza(context);
    }

    @RecentlyNonNull
    @VisibleForTesting
    public final synchronized PackageManagerWrapper zza(@RecentlyNonNull Context context) {
        if (this.zza == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zza = new PackageManagerWrapper(context);
        }
        return this.zza;
    }
}
