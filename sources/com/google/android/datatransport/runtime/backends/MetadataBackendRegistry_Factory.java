package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class MetadataBackendRegistry_Factory implements Object<MetadataBackendRegistry> {
    public final Provider<Context> applicationContextProvider;
    public final Provider<CreationContextFactory> creationContextFactoryProvider;

    public MetadataBackendRegistry_Factory(Provider<Context> provider, Provider<CreationContextFactory> provider2) {
        this.applicationContextProvider = provider;
        this.creationContextFactoryProvider = provider2;
    }

    public Object get() {
        return new MetadataBackendRegistry(this.applicationContextProvider.get(), this.creationContextFactoryProvider.get());
    }
}
