package com.applovin.communicator;

import android.os.Bundle;
import com.applovin.impl.communicator.CommunicatorMessageImpl;

public class AppLovinCommunicatorMessage extends CommunicatorMessageImpl {
    public AppLovinCommunicatorMessage(Bundle bundle, String str, AppLovinCommunicatorPublisher appLovinCommunicatorPublisher) {
        this(bundle, str, appLovinCommunicatorPublisher, true);
    }

    public AppLovinCommunicatorMessage(Bundle bundle, String str, AppLovinCommunicatorPublisher appLovinCommunicatorPublisher, boolean z) {
        super(bundle, str, appLovinCommunicatorPublisher, z);
    }

    public Bundle getMessageData() {
        return this.data;
    }

    public String getPublisherId() {
        AppLovinCommunicatorPublisher appLovinCommunicatorPublisher = (AppLovinCommunicatorPublisher) this.publisherRef.get();
        return appLovinCommunicatorPublisher != null ? appLovinCommunicatorPublisher.getCommunicatorId() : "";
    }

    public String getTopic() {
        return getAction();
    }
}
