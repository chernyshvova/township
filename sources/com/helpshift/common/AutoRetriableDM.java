package com.helpshift.common;

import com.helpshift.common.AutoRetryFailedEventDM;

public interface AutoRetriableDM {
    void sendFailedApiCalls(AutoRetryFailedEventDM.EventType eventType);
}
