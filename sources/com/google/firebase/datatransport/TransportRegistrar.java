package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedDestination;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportFactoryImpl;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Keep
/* compiled from: com.google.firebase:firebase-datatransport@@17.0.3 */
public class TransportRegistrar implements ComponentRegistrar {
    public static TransportFactory lambda$getComponents$0(ComponentContainer componentContainer) {
        Set<T> set;
        TransportRuntime.initialize((Context) componentContainer.get(Context.class));
        TransportRuntime instance = TransportRuntime.getInstance();
        CCTDestination cCTDestination = CCTDestination.LEGACY_INSTANCE;
        if (instance != null) {
            if (cCTDestination instanceof EncodedDestination) {
                set = Collections.unmodifiableSet(cCTDestination.getSupportedEncodings());
            } else {
                set = Collections.singleton(new Encoding("proto"));
            }
            TransportContext.Builder builder = TransportContext.builder();
            builder.setBackendName(cCTDestination.getName());
            AutoValue_TransportContext.Builder builder2 = (AutoValue_TransportContext.Builder) builder;
            builder2.extras = cCTDestination.getExtras();
            return new TransportFactoryImpl(set, builder2.build(), instance);
        }
        throw null;
    }

    public List<Component<?>> getComponents() {
        Component.Builder<TransportFactory> builder = Component.builder(TransportFactory.class);
        builder.add(Dependency.required(Context.class));
        builder.factory(TransportRegistrar$$Lambda$1.instance);
        return Collections.singletonList(builder.build());
    }
}
