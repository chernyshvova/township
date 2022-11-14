package com.swrve.sdk.messaging;

public interface SwrveBaseMessage {
    SwrveBaseCampaign getCampaign();

    int getId();

    int getPriority();

    boolean supportsOrientation(SwrveOrientation swrveOrientation);
}
