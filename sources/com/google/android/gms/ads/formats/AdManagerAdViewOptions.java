package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzbit;
import com.google.android.gms.internal.ads.zzbny;
import com.google.android.gms.internal.ads.zzbnz;

@SafeParcelable.Class(creator = "AdManagerAdViewOptionsCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class AdManagerAdViewOptions extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<AdManagerAdViewOptions> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", mo17147id = 1)
    public final boolean zza;
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", mo17147id = 2)
    @Nullable
    public final IBinder zzb;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public static final class Builder {
        public boolean zza = false;
        @Nullable
        public ShouldDelayBannerRenderingListener zzb;

        @RecentlyNonNull
        public AdManagerAdViewOptions build() {
            return new AdManagerAdViewOptions(this, (zzb) null);
        }

        @RecentlyNonNull
        public Builder setManualImpressionsEnabled(boolean z) {
            this.zza = z;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setShouldDelayBannerRenderingListener(@RecentlyNonNull ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zzb = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    public /* synthetic */ AdManagerAdViewOptions(Builder builder, zzb zzb2) {
        this.zza = builder.zza;
        this.zzb = builder.zzb != null ? new zzbit(builder.zzb) : null;
    }

    public boolean getManualImpressionsEnabled() {
        return this.zza;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final zzbnz zza() {
        IBinder iBinder = this.zzb;
        if (iBinder == null) {
            return null;
        }
        return zzbny.zzc(iBinder);
    }

    @SafeParcelable.Constructor
    public AdManagerAdViewOptions(@SafeParcelable.Param(mo17150id = 1) boolean z, @SafeParcelable.Param(mo17150id = 2) @Nullable IBinder iBinder) {
        this.zza = z;
        this.zzb = iBinder;
    }
}
