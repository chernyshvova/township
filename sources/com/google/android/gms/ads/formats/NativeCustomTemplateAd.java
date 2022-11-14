package com.google.android.gms.ads.formats;

import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface NativeCustomTemplateAd {
    @RecentlyNonNull
    public static final String ASSET_NAME_VIDEO = "_videoMediaView";

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public interface DisplayOpenMeasurement {
        void setView(@RecentlyNonNull View view);

        boolean start();
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public interface OnCustomClickListener {
        void onCustomClick(@RecentlyNonNull NativeCustomTemplateAd nativeCustomTemplateAd, @RecentlyNonNull String str);
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public interface OnCustomTemplateAdLoadedListener {
        void onCustomTemplateAdLoaded(@RecentlyNonNull NativeCustomTemplateAd nativeCustomTemplateAd);
    }

    void destroy();

    @RecentlyNonNull
    List<String> getAvailableAssetNames();

    @RecentlyNonNull
    String getCustomTemplateId();

    @RecentlyNonNull
    DisplayOpenMeasurement getDisplayOpenMeasurement();

    @RecentlyNonNull
    NativeAd.Image getImage(@RecentlyNonNull String str);

    @RecentlyNonNull
    CharSequence getText(@RecentlyNonNull String str);

    @RecentlyNonNull
    VideoController getVideoController();

    @RecentlyNonNull
    MediaView getVideoMediaView();

    void performClick(@RecentlyNonNull String str);

    void recordImpression();
}
