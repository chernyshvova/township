package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ads.zzbhp;
import com.google.android.gms.internal.ads.zzcgs;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class SearchAdView extends ViewGroup {
    @NotOnlyInitialized
    public final zzbhp zza;

    public SearchAdView(@RecentlyNonNull Context context) {
        super(context);
        this.zza = new zzbhp(this);
    }

    public void destroy() {
        this.zza.zza();
    }

    @RecentlyNonNull
    public AdListener getAdListener() {
        return this.zza.zzb();
    }

    @RecentlyNullable
    public AdSize getAdSize() {
        return this.zza.zzc();
    }

    @RecentlyNonNull
    public String getAdUnitId() {
        return this.zza.zze();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@RecentlyNonNull DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (AdSize.SEARCH.equals(getAdSize())) {
            this.zza.zzg(dynamicHeightSearchAdRequest.zza());
            return;
        }
        throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        AdSize adSize;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzcgs.zzg("Unable to retrieve ad size.", e);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.zza.zzh();
    }

    public void resume() {
        this.zza.zzj();
    }

    public void setAdListener(@RecentlyNonNull AdListener adListener) {
        this.zza.zzk(adListener);
    }

    public void setAdSize(@RecentlyNonNull AdSize adSize) {
        this.zza.zzm(adSize);
    }

    public void setAdUnitId(@RecentlyNonNull String str) {
        this.zza.zzo(str);
    }

    public SearchAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zza = new zzbhp(this, attributeSet, false);
    }

    public SearchAdView(@RecentlyNonNull Context context, @RecentlyNonNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zza = new zzbhp(this, attributeSet, false);
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@RecentlyNonNull SearchAdRequest searchAdRequest) {
        this.zza.zzg(searchAdRequest.zza());
    }
}
