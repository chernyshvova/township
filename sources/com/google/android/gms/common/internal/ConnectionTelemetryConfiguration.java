package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "ConnectionTelemetryConfigurationCreator")
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    @RecentlyNonNull
    @KeepForSdk
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new zzk();
    @SafeParcelable.Field(getter = "getRootTelemetryConfiguration", mo17147id = 1)
    public final RootTelemetryConfiguration zza;
    @SafeParcelable.Field(getter = "getMethodInvocationTelemetryEnabled", mo17147id = 2)
    public final boolean zzb;
    @SafeParcelable.Field(getter = "getMethodTimingTelemetryEnabled", mo17147id = 3)
    public final boolean zzc;
    @SafeParcelable.Field(getter = "getMethodInvocationMethodKeyAllowlist", mo17147id = 4)
    @Nullable
    public final int[] zzd;
    @SafeParcelable.Field(getter = "getMaxMethodInvocationsLogged", mo17147id = 5)
    public final int zze;
    @SafeParcelable.Field(getter = "getMethodInvocationMethodKeyDisallowlist", mo17147id = 6)
    @Nullable
    public final int[] zzf;

    @SafeParcelable.Constructor
    public ConnectionTelemetryConfiguration(@RecentlyNonNull @SafeParcelable.Param(mo17150id = 1) RootTelemetryConfiguration rootTelemetryConfiguration, @SafeParcelable.Param(mo17150id = 2) boolean z, @SafeParcelable.Param(mo17150id = 3) boolean z2, @SafeParcelable.Param(mo17150id = 4) @Nullable int[] iArr, @SafeParcelable.Param(mo17150id = 5) int i, @SafeParcelable.Param(mo17150id = 6) @Nullable int[] iArr2) {
        this.zza = rootTelemetryConfiguration;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = iArr;
        this.zze = i;
        this.zzf = iArr2;
    }

    @KeepForSdk
    public int getMaxMethodInvocationsLogged() {
        return this.zze;
    }

    @KeepForSdk
    @RecentlyNullable
    public int[] getMethodInvocationMethodKeyAllowlist() {
        return this.zzd;
    }

    @KeepForSdk
    @RecentlyNullable
    public int[] getMethodInvocationMethodKeyDisallowlist() {
        return this.zzf;
    }

    @KeepForSdk
    public boolean getMethodInvocationTelemetryEnabled() {
        return this.zzb;
    }

    @KeepForSdk
    public boolean getMethodTimingTelemetryEnabled() {
        return this.zzc;
    }

    @RecentlyNonNull
    @KeepForSdk
    public RootTelemetryConfiguration getRootTelemetryConfiguration() {
        return this.zza;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getRootTelemetryConfiguration(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, getMethodInvocationTelemetryEnabled());
        SafeParcelWriter.writeBoolean(parcel, 3, getMethodTimingTelemetryEnabled());
        SafeParcelWriter.writeIntArray(parcel, 4, getMethodInvocationMethodKeyAllowlist(), false);
        SafeParcelWriter.writeInt(parcel, 5, getMaxMethodInvocationsLogged());
        SafeParcelWriter.writeIntArray(parcel, 6, getMethodInvocationMethodKeyDisallowlist(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
