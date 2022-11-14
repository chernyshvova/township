package com.google.android.datatransport.runtime;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class AutoValue_TransportContext extends TransportContext {
    public final String backendName;
    public final byte[] extras;
    public final Priority priority;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static final class Builder extends TransportContext.Builder {
        public String backendName;
        public byte[] extras;
        public Priority priority;

        public TransportContext build() {
            String str = this.backendName == null ? " backendName" : "";
            if (this.priority == null) {
                str = GeneratedOutlineSupport.outline16(str, " priority");
            }
            if (str.isEmpty()) {
                return new AutoValue_TransportContext(this.backendName, this.extras, this.priority, (C16131) null);
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline16("Missing required properties:", str));
        }

        public TransportContext.Builder setBackendName(String str) {
            if (str != null) {
                this.backendName = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public TransportContext.Builder setPriority(Priority priority2) {
            if (priority2 != null) {
                this.priority = priority2;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    public AutoValue_TransportContext(String str, byte[] bArr, Priority priority2, C16131 r4) {
        this.backendName = str;
        this.extras = bArr;
        this.priority = priority2;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.backendName.equals(((AutoValue_TransportContext) transportContext).backendName)) {
            byte[] bArr2 = this.extras;
            if (transportContext instanceof AutoValue_TransportContext) {
                bArr = ((AutoValue_TransportContext) transportContext).extras;
            } else {
                bArr = ((AutoValue_TransportContext) transportContext).extras;
            }
            if (!Arrays.equals(bArr2, bArr) || !this.priority.equals(((AutoValue_TransportContext) transportContext).priority)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.backendName.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.extras)) * 1000003) ^ this.priority.hashCode();
    }
}
