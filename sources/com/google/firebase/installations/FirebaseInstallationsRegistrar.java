package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.android.billingclient.api.zzam;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    public static /* synthetic */ FirebaseInstallationsApi lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseInstallations((FirebaseApp) componentContainer.get(FirebaseApp.class), (UserAgentPublisher) componentContainer.get(UserAgentPublisher.class), (HeartBeatInfo) componentContainer.get(HeartBeatInfo.class));
    }

    public List<Component<?>> getComponents() {
        Component.Builder<FirebaseInstallationsApi> builder = Component.builder(FirebaseInstallationsApi.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.required(HeartBeatInfo.class));
        builder.add(Dependency.required(UserAgentPublisher.class));
        builder.factory(FirebaseInstallationsRegistrar$$Lambda$1.instance);
        return Arrays.asList(new Component[]{builder.build(), zzam.create("fire-installations", "16.3.3")});
    }
}
