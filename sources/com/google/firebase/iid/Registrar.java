package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.android.billingclient.api.zzam;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final class Registrar implements ComponentRegistrar {

    /* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public static class FIIDInternalAdapter implements FirebaseInstanceIdInternal {
        public FIIDInternalAdapter(FirebaseInstanceId firebaseInstanceId) {
        }
    }

    public static final /* synthetic */ FirebaseInstanceId lambda$getComponents$0$Registrar(ComponentContainer componentContainer) {
        return new FirebaseInstanceId((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.getProvider(UserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class));
    }

    public static final /* synthetic */ FirebaseInstanceIdInternal lambda$getComponents$1$Registrar(ComponentContainer componentContainer) {
        return new FIIDInternalAdapter((FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class));
    }

    @Keep
    public final List<Component<?>> getComponents() {
        Class<FirebaseInstanceId> cls = FirebaseInstanceId.class;
        Component.Builder<FirebaseInstanceId> builder = Component.builder(cls);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.optionalProvider(UserAgentPublisher.class));
        builder.add(Dependency.optionalProvider(HeartBeatInfo.class));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.factory(Registrar$$Lambda$0.$instance);
        builder.setInstantiation(1);
        Component<FirebaseInstanceId> build = builder.build();
        Component.Builder<FirebaseInstanceIdInternal> builder2 = Component.builder(FirebaseInstanceIdInternal.class);
        builder2.add(Dependency.required(cls));
        builder2.factory(Registrar$$Lambda$1.$instance);
        return Arrays.asList(new Component[]{build, builder2.build(), zzam.create("fire-iid", "21.0.0")});
    }
}
