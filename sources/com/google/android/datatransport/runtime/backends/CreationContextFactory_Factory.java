package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class CreationContextFactory_Factory implements Object<CreationContextFactory> {
    public final Provider<Context> applicationContextProvider;
    public final Provider<Clock> monotonicClockProvider;
    public final Provider<Clock> wallClockProvider;

    public CreationContextFactory_Factory(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        this.applicationContextProvider = provider;
        this.wallClockProvider = provider2;
        this.monotonicClockProvider = provider3;
    }

    public Object get() {
        return new CreationContextFactory(this.applicationContextProvider.get(), this.wallClockProvider.get(), this.monotonicClockProvider.get());
    }
}
