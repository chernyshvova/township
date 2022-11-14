package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
@SafeParcelable.Class(creator = "StatusCreator")
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Status> CREATOR = new zzb();
    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_CANCELED = new Status(16);
    @RecentlyNonNull
    @KeepForSdk
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_INTERRUPTED = new Status(14);
    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    @VisibleForTesting
    public static final Status RESULT_SUCCESS = new Status(0);
    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_TIMEOUT = new Status(15);
    @RecentlyNonNull
    @ShowFirstParty
    public static final Status zza = new Status(17);
    @SafeParcelable.VersionField(mo17153id = 1000)
    public final int zzb;
    @SafeParcelable.Field(getter = "getStatusCode", mo17147id = 1)
    public final int zzc;
    @SafeParcelable.Field(getter = "getStatusMessage", mo17147id = 2)
    @Nullable
    public final String zzd;
    @SafeParcelable.Field(getter = "getPendingIntent", mo17147id = 3)
    @Nullable
    public final PendingIntent zze;
    @SafeParcelable.Field(getter = "getConnectionResult", mo17147id = 4)
    @Nullable
    public final ConnectionResult zzf;

    @KeepForSdk
    public Status(int i) {
        this(i, (String) null);
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    public Status(@SafeParcelable.Param(mo17150id = 1000) int i, @SafeParcelable.Param(mo17150id = 1) int i2, @SafeParcelable.Param(mo17150id = 2) @Nullable String str, @SafeParcelable.Param(mo17150id = 3) @Nullable PendingIntent pendingIntent, @SafeParcelable.Param(mo17150id = 4) @Nullable ConnectionResult connectionResult) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = str;
        this.zze = pendingIntent;
        this.zzf = connectionResult;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.zzb != status.zzb || this.zzc != status.zzc || !Objects.equal(this.zzd, status.zzd) || !Objects.equal(this.zze, status.zze) || !Objects.equal(this.zzf, status.zzf)) {
            return false;
        }
        return true;
    }

    @RecentlyNullable
    public ConnectionResult getConnectionResult() {
        return this.zzf;
    }

    @RecentlyNullable
    public PendingIntent getResolution() {
        return this.zze;
    }

    @RecentlyNonNull
    @KeepForSdk
    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zzc;
    }

    @RecentlyNullable
    public String getStatusMessage() {
        return this.zzd;
    }

    @VisibleForTesting
    public boolean hasResolution() {
        return this.zze != null;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze, this.zzf);
    }

    public boolean isCanceled() {
        return this.zzc == 16;
    }

    public boolean isInterrupted() {
        return this.zzc == 14;
    }

    public boolean isSuccess() {
        return this.zzc <= 0;
    }

    public void startResolutionForResult(@RecentlyNonNull Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.zze;
            Preconditions.checkNotNull(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, (Intent) null, 0, 0, 0);
        }
    }

    @RecentlyNonNull
    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("statusCode", zza());
        stringHelper.add("resolution", this.zze);
        return stringHelper.toString();
    }

    @KeepForSdk
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getConnectionResult(), i, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final String zza() {
        String str = this.zzd;
        return str != null ? str : CommonStatusCodes.getStatusCodeString(this.zzc);
    }

    @KeepForSdk
    public Status(int i, int i2, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(i, i2, str, pendingIntent, (ConnectionResult) null);
    }

    @KeepForSdk
    public Status(int i, @Nullable String str) {
        this(1, i, str, (PendingIntent) null);
    }

    @KeepForSdk
    public Status(int i, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public Status(@RecentlyNonNull ConnectionResult connectionResult, @RecentlyNonNull String str) {
        this(connectionResult, str, 17);
    }

    @KeepForSdk
    @Deprecated
    public Status(@RecentlyNonNull ConnectionResult connectionResult, @RecentlyNonNull String str, int i) {
        this(1, i, str, connectionResult.getResolution(), connectionResult);
    }
}
