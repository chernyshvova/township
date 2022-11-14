package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.android.billingclient.api.zzam;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.playrix.firebase.BuildConfig;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @SuppressLint({"MissingPermission"})
    @Keep
    @KeepForSdk
    public List<Component<?>> getComponents() {
        Component.Builder<AnalyticsConnector> builder = Component.builder(AnalyticsConnector.class);
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(Dependency.required(Context.class));
        builder.add(Dependency.required(Subscriber.class));
        builder.factory(zzb.zza);
        builder.setInstantiation(2);
        return Arrays.asList(new Component[]{builder.build(), zzam.create("fire-analytics", BuildConfig.FIREBASE_VERSION)});
    }
}
