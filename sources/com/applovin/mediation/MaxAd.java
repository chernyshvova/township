package com.applovin.mediation;

public interface MaxAd {
    String getAdUnitId();

    String getAdValue(String str);

    String getAdValue(String str, String str2);

    String getCreativeId();

    MaxAdFormat getFormat();

    String getNetworkName();

    String getNetworkPlacement();

    String getPlacement();

    double getRevenue();

    String getRevenuePrecision();

    MaxAdWaterfallInfo getWaterfall();
}
