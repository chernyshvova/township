package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
public final class AutoValue_Event<T> extends Event<T> {
    public final Integer code = null;
    public final T payload;
    public final Priority priority;

    public AutoValue_Event(@Nullable Integer num, T t, Priority priority2) {
        if (t != null) {
            this.payload = t;
            if (priority2 != null) {
                this.priority = priority2;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.code;
        if (num != null ? num.equals(((AutoValue_Event) event).code) : ((AutoValue_Event) event).code == null) {
            AutoValue_Event autoValue_Event = (AutoValue_Event) event;
            if (!this.payload.equals(autoValue_Event.payload) || !this.priority.equals(autoValue_Event.priority)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.code;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.payload.hashCode()) * 1000003) ^ this.priority.hashCode();
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Event{code=");
        outline24.append(this.code);
        outline24.append(", payload=");
        outline24.append(this.payload);
        outline24.append(", priority=");
        outline24.append(this.priority);
        outline24.append("}");
        return outline24.toString();
    }
}
