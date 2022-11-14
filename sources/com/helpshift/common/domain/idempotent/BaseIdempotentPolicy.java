package com.helpshift.common.domain.idempotent;

import com.helpshift.common.domain.network.NetworkErrorCodes;

public abstract class BaseIdempotentPolicy implements IdempotentPolicy {
    public final boolean isRequestCompleted(int i) {
        if (i == NetworkErrorCodes.PROCESSING_REQUEST.intValue()) {
            return false;
        }
        return shouldMarkRequestCompleted(i);
    }

    public abstract boolean shouldMarkRequestCompleted(int i);
}
