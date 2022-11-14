package com.vungle.warren.model;

import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Objects;

public class CacheBust {
    public static final int EVENT_TYPE_CAMPAIGN = 1;
    public static final int EVENT_TYPE_CREATIVE = 2;
    public static final String TAG = "CacheBust";
    public String[] eventIds;
    @SerializedName("id")

    /* renamed from: id */
    public String f2849id;
    @EventType
    public int idType;
    @SerializedName("timestamp_bust_end")
    public long timeWindowEnd;
    @SerializedName("timestamp_processed")
    public long timestampProcessed;

    public @interface EventType {
    }

    public static CacheBust fromJson(JsonObject jsonObject) {
        return (CacheBust) new GsonBuilder().create().fromJson((JsonElement) jsonObject, CacheBust.class);
    }

    @VisibleForTesting
    public String calculateId() {
        return this.f2849id + CertificateUtil.DELIMITER + this.timeWindowEnd;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CacheBust.class != obj.getClass()) {
            return false;
        }
        CacheBust cacheBust = (CacheBust) obj;
        if (this.idType == cacheBust.idType && this.timestampProcessed == cacheBust.timestampProcessed && this.f2849id.equals(cacheBust.f2849id) && this.timeWindowEnd == cacheBust.timeWindowEnd && Arrays.equals(this.eventIds, cacheBust.eventIds)) {
            return true;
        }
        return false;
    }

    public String[] getEventIds() {
        return this.eventIds;
    }

    public String getId() {
        return this.f2849id;
    }

    public int getIdType() {
        return this.idType;
    }

    public long getTimeWindowEnd() {
        return this.timeWindowEnd;
    }

    public long getTimestampProcessed() {
        return this.timestampProcessed;
    }

    @RequiresApi(api = 19)
    public int hashCode() {
        return (Objects.hash(new Object[]{this.f2849id, Long.valueOf(this.timeWindowEnd), Integer.valueOf(this.idType), Long.valueOf(this.timestampProcessed)}) * 31) + Arrays.hashCode(this.eventIds);
    }

    public void setEventIds(String[] strArr) {
        this.eventIds = strArr;
    }

    public void setId(String str) {
        this.f2849id = str;
    }

    public void setIdType(int i) {
        this.idType = i;
    }

    public void setTimeWindowEnd(long j) {
        this.timeWindowEnd = j;
    }

    public void setTimestampProcessed(long j) {
        this.timestampProcessed = j;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("CacheBust{id='");
        GeneratedOutlineSupport.outline33(outline24, this.f2849id, '\'', ", timeWindowEnd=");
        outline24.append(this.timeWindowEnd);
        outline24.append(", idType=");
        outline24.append(this.idType);
        outline24.append(", eventIds=");
        outline24.append(Arrays.toString(this.eventIds));
        outline24.append(", timestampProcessed=");
        outline24.append(this.timestampProcessed);
        outline24.append('}');
        return outline24.toString();
    }
}
