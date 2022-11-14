package com.helpshift.common.domain.idempotent;

public interface IdempotentPolicy {
    boolean isRequestCompleted(int i);
}
