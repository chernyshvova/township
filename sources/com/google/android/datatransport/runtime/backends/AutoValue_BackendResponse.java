package com.google.android.datatransport.runtime.backends;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.backends.BackendResponse;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class AutoValue_BackendResponse extends BackendResponse {
    public final long nextRequestWaitMillis;
    public final BackendResponse.Status status;

    public AutoValue_BackendResponse(BackendResponse.Status status2, long j) {
        if (status2 != null) {
            this.status = status2;
            this.nextRequestWaitMillis = j;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        AutoValue_BackendResponse autoValue_BackendResponse = (AutoValue_BackendResponse) ((BackendResponse) obj);
        if (!this.status.equals(autoValue_BackendResponse.status) || this.nextRequestWaitMillis != autoValue_BackendResponse.nextRequestWaitMillis) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.nextRequestWaitMillis;
        return ((this.status.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("BackendResponse{status=");
        outline24.append(this.status);
        outline24.append(", nextRequestWaitMillis=");
        outline24.append(this.nextRequestWaitMillis);
        outline24.append("}");
        return outline24.toString();
    }
}
