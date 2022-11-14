package com.vungle.warren.tasks;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class JobInfo implements Cloneable {
    public static final String TAG = "JobInfo";
    public long delay;
    public Bundle extras = new Bundle();
    public long nextRescheduleTimeout;
    public int priority = 2;
    @NetworkType
    public int requiredNetworkType = 0;
    public int reschedulePolicy = 1;
    public long rescheduleTimeout;
    public final String tag;
    public boolean updateCurrent;

    public @interface NetworkType {
        public static final int ANY = 0;
        public static final int CONNECTED = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Priority {
        public static final int CRITICAL = 5;
        public static final int HIGH = 3;
        public static final int HIGHEST = 4;
        public static final int LOW = 1;
        public static final int LOWEST = 0;
        public static final int NORMAL = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReschedulePolicy {
        public static final int EXPONENTIAL = 1;
        public static final int LINEAR = 0;
    }

    public JobInfo(@NonNull String str) {
        this.tag = str;
    }

    public JobInfo copy() {
        try {
            return (JobInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            Log.e(TAG, Log.getStackTraceString(e));
            return null;
        }
    }

    public long getDelay() {
        return this.delay;
    }

    public Bundle getExtras() {
        return this.extras;
    }

    public String getJobTag() {
        return this.tag;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    public boolean getUpdateCurrent() {
        return this.updateCurrent;
    }

    public long makeNextRescedule() {
        long j = this.rescheduleTimeout;
        if (j == 0) {
            return 0;
        }
        long j2 = this.nextRescheduleTimeout;
        if (j2 == 0) {
            this.nextRescheduleTimeout = j;
        } else if (this.reschedulePolicy == 1) {
            this.nextRescheduleTimeout = j2 * 2;
        }
        return this.nextRescheduleTimeout;
    }

    public JobInfo setDelay(long j) {
        this.delay = j;
        return this;
    }

    public JobInfo setExtras(@NonNull Bundle bundle) {
        if (bundle != null) {
            this.extras = bundle;
        }
        return this;
    }

    public JobInfo setPriority(int i) {
        this.priority = i;
        return this;
    }

    public JobInfo setRequiredNetworkType(@NetworkType int i) {
        this.requiredNetworkType = i;
        return this;
    }

    public JobInfo setReschedulePolicy(long j, int i) {
        this.rescheduleTimeout = j;
        this.reschedulePolicy = i;
        return this;
    }

    public JobInfo setUpdateCurrent(boolean z) {
        this.updateCurrent = z;
        return this;
    }
}
