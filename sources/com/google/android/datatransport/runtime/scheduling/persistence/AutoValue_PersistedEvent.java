package com.google.android.datatransport.runtime.scheduling.persistence;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class AutoValue_PersistedEvent extends PersistedEvent {
    public final EventInternal event;

    /* renamed from: id */
    public final long f2765id;
    public final TransportContext transportContext;

    public AutoValue_PersistedEvent(long j, TransportContext transportContext2, EventInternal eventInternal) {
        this.f2765id = j;
        if (transportContext2 != null) {
            this.transportContext = transportContext2;
            if (eventInternal != null) {
                this.event = eventInternal;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        AutoValue_PersistedEvent autoValue_PersistedEvent = (AutoValue_PersistedEvent) ((PersistedEvent) obj);
        if (this.f2765id != autoValue_PersistedEvent.f2765id || !this.transportContext.equals(autoValue_PersistedEvent.transportContext) || !this.event.equals(autoValue_PersistedEvent.event)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.f2765id;
        return this.event.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.transportContext.hashCode()) * 1000003);
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("PersistedEvent{id=");
        outline24.append(this.f2765id);
        outline24.append(", transportContext=");
        outline24.append(this.transportContext);
        outline24.append(", event=");
        outline24.append(this.event);
        outline24.append("}");
        return outline24.toString();
    }
}
