package com.google.android.datatransport.runtime;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Map;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class AutoValue_EventInternal extends EventInternal {
    public final Map<String, String> autoMetadata;
    public final Integer code;
    public final EncodedPayload encodedPayload;
    public final long eventMillis;
    public final String transportName;
    public final long uptimeMillis;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static final class Builder extends EventInternal.Builder {
        public Map<String, String> autoMetadata;
        public Integer code;
        public EncodedPayload encodedPayload;
        public Long eventMillis;
        public String transportName;
        public Long uptimeMillis;

        public EventInternal build() {
            String str = this.transportName == null ? " transportName" : "";
            if (this.encodedPayload == null) {
                str = GeneratedOutlineSupport.outline16(str, " encodedPayload");
            }
            if (this.eventMillis == null) {
                str = GeneratedOutlineSupport.outline16(str, " eventMillis");
            }
            if (this.uptimeMillis == null) {
                str = GeneratedOutlineSupport.outline16(str, " uptimeMillis");
            }
            if (this.autoMetadata == null) {
                str = GeneratedOutlineSupport.outline16(str, " autoMetadata");
            }
            if (str.isEmpty()) {
                return new AutoValue_EventInternal(this.transportName, this.code, this.encodedPayload, this.eventMillis.longValue(), this.uptimeMillis.longValue(), this.autoMetadata, (C16121) null);
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline16("Missing required properties:", str));
        }

        public Map<String, String> getAutoMetadata() {
            Map<String, String> map = this.autoMetadata;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        public EventInternal.Builder setEncodedPayload(EncodedPayload encodedPayload2) {
            if (encodedPayload2 != null) {
                this.encodedPayload = encodedPayload2;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public EventInternal.Builder setEventMillis(long j) {
            this.eventMillis = Long.valueOf(j);
            return this;
        }

        public EventInternal.Builder setTransportName(String str) {
            if (str != null) {
                this.transportName = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        public EventInternal.Builder setUptimeMillis(long j) {
            this.uptimeMillis = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload2, long j, long j2, Map map, C16121 r9) {
        this.transportName = str;
        this.code = num;
        this.encodedPayload = encodedPayload2;
        this.eventMillis = j;
        this.uptimeMillis = j2;
        this.autoMetadata = map;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        if (this.transportName.equals(((AutoValue_EventInternal) eventInternal).transportName) && ((num = this.code) != null ? num.equals(((AutoValue_EventInternal) eventInternal).code) : ((AutoValue_EventInternal) eventInternal).code == null)) {
            AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) eventInternal;
            if (!this.encodedPayload.equals(autoValue_EventInternal.encodedPayload) || this.eventMillis != autoValue_EventInternal.eventMillis || this.uptimeMillis != autoValue_EventInternal.uptimeMillis || !this.autoMetadata.equals(autoValue_EventInternal.autoMetadata)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.transportName.hashCode() ^ 1000003) * 1000003;
        Integer num = this.code;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j = this.eventMillis;
        long j2 = this.uptimeMillis;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.encodedPayload.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.autoMetadata.hashCode();
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("EventInternal{transportName=");
        outline24.append(this.transportName);
        outline24.append(", code=");
        outline24.append(this.code);
        outline24.append(", encodedPayload=");
        outline24.append(this.encodedPayload);
        outline24.append(", eventMillis=");
        outline24.append(this.eventMillis);
        outline24.append(", uptimeMillis=");
        outline24.append(this.uptimeMillis);
        outline24.append(", autoMetadata=");
        outline24.append(this.autoMetadata);
        outline24.append("}");
        return outline24.toString();
    }
}
