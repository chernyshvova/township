package com.helpshift.delegate;

public enum AuthenticationFailureReason {
    AUTH_TOKEN_NOT_PROVIDED(0),
    INVALID_AUTH_TOKEN(1);
    
    public int value;

    /* access modifiers changed from: public */
    AuthenticationFailureReason(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
