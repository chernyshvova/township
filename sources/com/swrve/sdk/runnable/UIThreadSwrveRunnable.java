package com.swrve.sdk.runnable;

public abstract class UIThreadSwrveRunnable implements Runnable {
    public Exception exception;

    public void setException(Exception exc) {
        this.exception = exc;
    }
}
