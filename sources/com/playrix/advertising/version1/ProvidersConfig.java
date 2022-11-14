package com.playrix.advertising.version1;

public class ProvidersConfig {
    public static boolean blockAdapterProviders() {
        return true;
    }

    public static String[] getNatives() {
        return new String[0];
    }

    public static ProviderInterface[] getProviders() {
        return new ProviderInterface[]{new AppLovinProvider(), new UnityAdsProvider()};
    }
}
