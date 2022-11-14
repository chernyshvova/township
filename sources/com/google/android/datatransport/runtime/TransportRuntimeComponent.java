package com.google.android.datatransport.runtime;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class TransportRuntimeComponent implements Closeable {
    public void close() throws IOException {
        ((DaggerTransportRuntimeComponent) this).sQLiteEventStoreProvider.get().close();
    }
}
