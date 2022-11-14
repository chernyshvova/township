package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzag;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.analytics.connector.zza;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.firebase.events.Subscriber;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final /* synthetic */ class zzb implements ComponentFactory {
    public static final ComponentFactory zza = new zzb();

    public final Object create(ComponentContainer componentContainer) {
        RestrictedComponentContainer restrictedComponentContainer = (RestrictedComponentContainer) componentContainer;
        FirebaseApp firebaseApp = (FirebaseApp) restrictedComponentContainer.get(FirebaseApp.class);
        Context context = (Context) restrictedComponentContainer.get(Context.class);
        Subscriber subscriber = (Subscriber) restrictedComponentContainer.get(Subscriber.class);
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (AnalyticsConnectorImpl.zzb == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (AnalyticsConnectorImpl.zzb == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, com.google.firebase.analytics.connector.zzb.zza, zza.zza);
                        firebaseApp.checkNotDeleted();
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.dataCollectionConfigStorage.get().dataCollectionDefaultEnabled.get());
                    }
                    AnalyticsConnectorImpl.zzb = new AnalyticsConnectorImpl(zzag.zza(context, (String) null, (String) null, (String) null, bundle).zza());
                }
            }
        }
        return AnalyticsConnectorImpl.zzb;
    }
}
