package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class TransportFactoryImpl implements TransportFactory {
    public final Set<Encoding> supportedPayloadEncodings;
    public final TransportContext transportContext;
    public final TransportInternal transportInternal;

    public TransportFactoryImpl(Set<Encoding> set, TransportContext transportContext2, TransportInternal transportInternal2) {
        this.supportedPayloadEncodings = set;
        this.transportContext = transportContext2;
        this.transportInternal = transportInternal2;
    }

    public <T> Transport<T> getTransport(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer) {
        if (this.supportedPayloadEncodings.contains(encoding)) {
            return new TransportImpl(this.transportContext, str, encoding, transformer, this.transportInternal);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{encoding, this.supportedPayloadEncodings}));
    }
}
