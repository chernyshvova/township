package com.google.android.gms.ads.search;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.ads.zzbhn;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    @RecentlyNonNull
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    @NotOnlyInitialized
    public final zzbhn zza;
    public final String zzb;

    public /* synthetic */ SearchAdRequest(zzc zzc, zzb zzb2) {
        this.zzb = zzc.zzb;
        this.zza = new zzbhn(zzc.zza, this);
    }

    @Deprecated
    public int getAnchorTextColor() {
        return 0;
    }

    @Deprecated
    public int getBackgroundColor() {
        return 0;
    }

    @Deprecated
    public int getBackgroundGradientBottom() {
        return 0;
    }

    @Deprecated
    public int getBackgroundGradientTop() {
        return 0;
    }

    @Deprecated
    public int getBorderColor() {
        return 0;
    }

    @Deprecated
    public int getBorderThickness() {
        return 0;
    }

    @Deprecated
    public int getBorderType() {
        return 0;
    }

    @Deprecated
    public int getCallButtonColor() {
        return 0;
    }

    @Deprecated
    @RecentlyNullable
    public String getCustomChannels() {
        return null;
    }

    @RecentlyNullable
    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(@RecentlyNonNull Class<T> cls) {
        return this.zza.zzi(cls);
    }

    @Deprecated
    public int getDescriptionTextColor() {
        return 0;
    }

    @Deprecated
    @RecentlyNullable
    public String getFontFace() {
        return null;
    }

    @Deprecated
    public int getHeaderTextColor() {
        return 0;
    }

    @Deprecated
    public int getHeaderTextSize() {
        return 0;
    }

    @RecentlyNonNull
    public Location getLocation() {
        return this.zza.zzf();
    }

    @Deprecated
    @RecentlyNullable
    public <T extends NetworkExtras> T getNetworkExtras(@RecentlyNonNull Class<T> cls) {
        return this.zza.zzg(cls);
    }

    @RecentlyNullable
    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(@RecentlyNonNull Class<T> cls) {
        return this.zza.zzh(cls);
    }

    @RecentlyNonNull
    public String getQuery() {
        return this.zzb;
    }

    public boolean isTestDevice(@RecentlyNonNull Context context) {
        return this.zza.zzm(context);
    }

    public final zzbhn zza() {
        return this.zza;
    }
}
