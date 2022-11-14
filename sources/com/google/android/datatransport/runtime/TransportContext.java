package com.google.android.datatransport.runtime;

import android.util.Base64;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class TransportContext {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static abstract class Builder {
        public abstract TransportContext build();

        public abstract Builder setBackendName(String str);

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public abstract Builder setPriority(Priority priority);
    }

    public static Builder builder() {
        AutoValue_TransportContext.Builder builder = new AutoValue_TransportContext.Builder();
        builder.setPriority(Priority.DEFAULT);
        return builder;
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[3];
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this;
        objArr[0] = autoValue_TransportContext.backendName;
        objArr[1] = autoValue_TransportContext.priority;
        byte[] bArr = autoValue_TransportContext.extras;
        if (bArr == null) {
            str = "";
        } else {
            str = Base64.encodeToString(bArr, 2);
        }
        objArr[2] = str;
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
