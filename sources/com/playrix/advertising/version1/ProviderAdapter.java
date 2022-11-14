package com.playrix.advertising.version1;

import java.util.HashMap;
import java.util.Map;

public class ProviderAdapter {
    public static final Map<Class, Provider> _providers = new HashMap();

    public static class Provider {
        public boolean isInitializedAsAdapter;
        public boolean isInitializedAsProvider;

        public Provider() {
            this.isInitializedAsProvider = false;
            this.isInitializedAsAdapter = false;
        }
    }

    public static Provider getProvider(Class cls) {
        Provider provider = _providers.get(cls);
        if (provider != null) {
            return provider;
        }
        Provider provider2 = new Provider();
        _providers.put(cls, provider2);
        return provider2;
    }

    public static boolean isInitializedAsAdapter(Class cls) {
        return getProvider(cls).isInitializedAsAdapter;
    }

    public static boolean isInitializedAsProvider(Class cls) {
        return getProvider(cls).isInitializedAsProvider;
    }

    public static void onInitializeAsAdapter(Class cls) {
        getProvider(cls).isInitializedAsAdapter = true;
    }

    public static boolean onInitializeAsProvider(Class cls) {
        Provider provider = getProvider(cls);
        if (provider.isInitializedAsAdapter) {
            return false;
        }
        provider.isInitializedAsProvider = true;
        return true;
    }
}
