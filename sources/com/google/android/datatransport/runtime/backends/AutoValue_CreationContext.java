package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.time.Clock;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class AutoValue_CreationContext extends CreationContext {
    public final Context applicationContext;
    public final String backendName;
    public final Clock monotonicClock;
    public final Clock wallClock;

    public AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context != null) {
            this.applicationContext = context;
            if (clock != null) {
                this.wallClock = clock;
                if (clock2 != null) {
                    this.monotonicClock = clock2;
                    if (str != null) {
                        this.backendName = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        AutoValue_CreationContext autoValue_CreationContext = (AutoValue_CreationContext) ((CreationContext) obj);
        if (!this.applicationContext.equals(autoValue_CreationContext.applicationContext) || !this.wallClock.equals(autoValue_CreationContext.wallClock) || !this.monotonicClock.equals(autoValue_CreationContext.monotonicClock) || !this.backendName.equals(autoValue_CreationContext.backendName)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.applicationContext.hashCode() ^ 1000003) * 1000003) ^ this.wallClock.hashCode()) * 1000003) ^ this.monotonicClock.hashCode()) * 1000003) ^ this.backendName.hashCode();
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("CreationContext{applicationContext=");
        outline24.append(this.applicationContext);
        outline24.append(", wallClock=");
        outline24.append(this.wallClock);
        outline24.append(", monotonicClock=");
        outline24.append(this.monotonicClock);
        outline24.append(", backendName=");
        return GeneratedOutlineSupport.outline18(outline24, this.backendName, "}");
    }
}
