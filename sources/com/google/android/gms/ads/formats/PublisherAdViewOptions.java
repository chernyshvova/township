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
import com.google.android.gms.internal.ads.zzbfx;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbny;
import com.google.android.gms.internal.ads.zzbnz;

@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", mo17147id = 1)
    public final boolean zza;
    @SafeParcelable.Field(getter = "getAppEventListenerBinder", mo17147id = 2, type = "android.os.IBinder")
    @Nullable
    public final zzbfy zzb;
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", mo17147id = 3)
    @Nullable
    public final IBinder zzc;

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public static final class Builder {
        @Nullable
        public ShouldDelayBannerRenderingListener zza;

        @RecentlyNonNull
        @KeepForSdk
        public Builder setShouldDelayBannerRenderingListener(@RecentlyNonNull ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zza = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public PublisherAdViewOptions(@SafeParcelable.Param(mo17150id = 1) boolean z, @SafeParcelable.Param(mo17150id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(mo17150id = 3) @Nullable IBinder iBinder2) {
        this.zza = z;
        this.zzb = iBinder != null ? zzbfx.zzd(iBinder) : null;
        this.zzc = iBinder2;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        zzbfy zzbfy = this.zzb;
        if (zzbfy == null) {
            iBinder = null;
        } else {
            iBinder = zzbfy.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, iBinder, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zza() {
        return this.zza;
    }

    @Nullable
    public final zzbfy zzb() {
        return this.zzb;
    }

    @Nullable
    public final zzbnz zzc() {
        IBinder iBinder = this.zzc;
        if (iBinder == null) {
            return null;
        }
        return zzbny.zzc(iBinder);
    }
}
