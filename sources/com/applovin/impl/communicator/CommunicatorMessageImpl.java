package com.applovin.impl.communicator;

import android.content.Intent;
import android.os.Bundle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import java.lang.ref.WeakReference;
import java.util.UUID;

public abstract class CommunicatorMessageImpl extends Intent {

    /* renamed from: a */
    public final String f520a = UUID.randomUUID().toString();
    public final Bundle data;
    public final WeakReference<AppLovinCommunicatorPublisher> publisherRef;
    public boolean sticky;

    public CommunicatorMessageImpl(Bundle bundle, String str, AppLovinCommunicatorPublisher appLovinCommunicatorPublisher, boolean z) {
        super(str);
        this.publisherRef = new WeakReference<>(appLovinCommunicatorPublisher);
        this.sticky = z;
        this.data = bundle;
    }

    public static AppLovinCommunicatorMessage create(Bundle bundle, String str, AppLovinCommunicatorPublisher appLovinCommunicatorPublisher, boolean z) {
        AppLovinCommunicatorMessage appLovinCommunicatorMessage = new AppLovinCommunicatorMessage(bundle, str, appLovinCommunicatorPublisher);
        appLovinCommunicatorMessage.sticky = z;
        return appLovinCommunicatorMessage;
    }

    public abstract Bundle getMessageData();

    public abstract String getPublisherId();

    public abstract String getTopic();

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinCommunicatorMessage{publisherId=");
        outline24.append(getPublisherId());
        outline24.append(", topic=");
        outline24.append(getTopic());
        outline24.append('\'');
        outline24.append(", uniqueId='");
        GeneratedOutlineSupport.outline33(outline24, this.f520a, '\'', ", data=");
        outline24.append(this.data);
        outline24.append(", sticky=");
        outline24.append(this.sticky);
        outline24.append('}');
        return outline24.toString();
    }
}
