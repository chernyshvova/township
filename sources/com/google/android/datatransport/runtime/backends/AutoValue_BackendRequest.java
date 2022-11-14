package com.google.android.datatransport.runtime.backends;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Arrays;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class AutoValue_BackendRequest extends BackendRequest {
    public final Iterable<EventInternal> events;
    public final byte[] extras;

    public AutoValue_BackendRequest(Iterable iterable, byte[] bArr, C16151 r3) {
        this.events = iterable;
        this.extras = bArr;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        AutoValue_BackendRequest autoValue_BackendRequest = (AutoValue_BackendRequest) backendRequest;
        if (this.events.equals(autoValue_BackendRequest.events)) {
            byte[] bArr2 = this.extras;
            if (backendRequest instanceof AutoValue_BackendRequest) {
                bArr = autoValue_BackendRequest.extras;
            } else {
                bArr = autoValue_BackendRequest.extras;
            }
            if (Arrays.equals(bArr2, bArr)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.events.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.extras);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("BackendRequest{events=");
        outline24.append(this.events);
        outline24.append(", extras=");
        outline24.append(Arrays.toString(this.extras));
        outline24.append("}");
        return outline24.toString();
    }
}
