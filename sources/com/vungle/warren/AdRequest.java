package com.vungle.warren;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public final class AdRequest implements Serializable {
    public final long adCount;
    @Nullable
    public final AdMarkup adMarkup;
    @NonNull
    public final String placementId;
    public AtomicLong timeStamp;
    @Type
    public final int type;

    public @interface Type {
        public static final int NORMAL = 0;
        public static final int NO_ASSETS = 1;
        public static final int SINGLE_HBP = 2;
    }

    public AdRequest(@NonNull String str, @Type int i, long j) {
        this.timeStamp = new AtomicLong(0);
        this.placementId = str;
        this.adMarkup = null;
        this.type = i;
        this.adCount = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdRequest.class != obj.getClass()) {
            return false;
        }
        AdRequest adRequest = (AdRequest) obj;
        if (this.type != adRequest.type || !this.placementId.equals(adRequest.placementId)) {
            return false;
        }
        AdMarkup adMarkup2 = this.adMarkup;
        AdMarkup adMarkup3 = adRequest.adMarkup;
        if (adMarkup2 != null) {
            return adMarkup2.equals(adMarkup3);
        }
        if (adMarkup3 == null) {
            return true;
        }
        return false;
    }

    public long getAdCount() {
        return this.adCount;
    }

    @Nullable
    public String getEventId() {
        AdMarkup adMarkup2 = this.adMarkup;
        if (adMarkup2 != null) {
            return adMarkup2.getEventId();
        }
        return null;
    }

    @Nullable
    public String[] getImpression() {
        AdMarkup adMarkup2 = this.adMarkup;
        if (adMarkup2 != null) {
            return adMarkup2.getImpression();
        }
        return null;
    }

    @NonNull
    public String getPlacementId() {
        return this.placementId;
    }

    @Type
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.placementId.hashCode() * 31;
        AdMarkup adMarkup2 = this.adMarkup;
        return ((hashCode + (adMarkup2 != null ? adMarkup2.hashCode() : 0)) * 31) + this.type;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AdRequest{placementId='");
        GeneratedOutlineSupport.outline33(outline24, this.placementId, '\'', ", adMarkup=");
        outline24.append(this.adMarkup);
        outline24.append(", type=");
        outline24.append(this.type);
        outline24.append(", adCount=");
        outline24.append(this.adCount);
        outline24.append('}');
        return outline24.toString();
    }

    public AdRequest(@NonNull String str, @Nullable AdMarkup adMarkup2) {
        this.timeStamp = new AtomicLong(0);
        this.placementId = str;
        this.adMarkup = adMarkup2;
        this.type = 0;
        this.adCount = 1;
    }

    public AdRequest(@NonNull String str) {
        this(str, (AdMarkup) null);
    }
}
