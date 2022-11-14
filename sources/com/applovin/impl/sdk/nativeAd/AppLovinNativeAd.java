package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import android.view.View;
import java.util.List;

public interface AppLovinNativeAd {
    long getAdIdNumber();

    String getAdvertiser();

    String getBody();

    String getCallToAction();

    Uri getIconUri();

    AppLovinMediaView getMediaView();

    AppLovinOptionsView getOptionsView();

    String getTitle();

    void registerViewsForInteraction(List<View> list);

    void unregisterViewsForInteraction();
}
