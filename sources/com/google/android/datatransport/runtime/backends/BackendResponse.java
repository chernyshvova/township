package com.google.android.datatransport.runtime.backends;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class BackendResponse {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public static BackendResponse fatalError() {
        return new AutoValue_BackendResponse(Status.FATAL_ERROR, -1);
    }
}
