package com.swrve.sdk.messaging;

public enum SwrveOrientation {
    Portrait,
    Landscape,
    Both;

    public static SwrveOrientation parse(int i) {
        if (i == 1) {
            return Portrait;
        }
        return Landscape;
    }

    public static SwrveOrientation parse(String str) {
        if (str.equalsIgnoreCase("portrait")) {
            return Portrait;
        }
        if (str.equalsIgnoreCase("landscape")) {
            return Landscape;
        }
        if (str.equalsIgnoreCase("both")) {
            return Both;
        }
        return Landscape;
    }
}
