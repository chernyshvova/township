package com.google.firebase.messaging;

import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import com.android.billingclient.api.zzam;
import com.facebook.GraphRequest;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static class DevNullTransport<T> implements Transport<T> {
        public DevNullTransport(C23641 r1) {
        }

        public void send(Event<T> event) {
        }
    }

    @VisibleForTesting
    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static class DevNullTransportFactory implements TransportFactory {
        public <T> Transport<T> getTransport(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer) {
            return new DevNullTransport((C23641) null);
        }
    }

    @VisibleForTesting
    public static TransportFactory determineFactory(TransportFactory transportFactory) {
        if (transportFactory != null) {
            if (CCTDestination.LEGACY_INSTANCE == null) {
                throw null;
            } else if (CCTDestination.zzd.contains(new Encoding(GraphRequest.FORMAT_JSON))) {
                return transportFactory;
            }
        }
        return new DevNullTransportFactory();
    }

    public static final /* synthetic */ FirebaseMessaging lambda$getComponents$0$FirebaseMessagingRegistrar(ComponentContainer componentContainer) {
        return new FirebaseMessaging((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), determineFactory((TransportFactory) componentContainer.get(TransportFactory.class)), (Subscriber) componentContainer.get(Subscriber.class));
    }

    @Keep
    public List<Component<?>> getComponents() {
        Component.Builder<FirebaseMessaging> builder = Component.builder(FirebaseMessaging.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.required(FirebaseInstanceId.class));
        builder.add(Dependency.optionalProvider(UserAgentPublisher.class));
        builder.add(Dependency.optionalProvider(HeartBeatInfo.class));
        builder.add(new Dependency(TransportFactory.class, 0, 0));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.add(Dependency.required(Subscriber.class));
        builder.factory(FirebaseMessagingRegistrar$$Lambda$0.$instance);
        builder.setInstantiation(1);
        return Arrays.asList(new Component[]{builder.build(), zzam.create("fire-fcm", "20.1.7_1p")});
    }
}
