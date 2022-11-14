package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Object zza = new Object();
    public boolean zzb = false;

    @KeepForSdk
    public static boolean canUnparcelSafely(@RecentlyNonNull String str) {
        synchronized (zza) {
        }
        return true;
    }

    @KeepForSdk
    @RecentlyNullable
    public static Integer getUnparcelClientVersion() {
        synchronized (zza) {
        }
        return null;
    }

    @KeepForSdk
    public abstract boolean prepareForClientVersion(int i);

    @KeepForSdk
    public void setShouldDowngrade(boolean z) {
        this.zzb = z;
    }

    @KeepForSdk
    public boolean shouldDowngrade() {
        return this.zzb;
    }
}
