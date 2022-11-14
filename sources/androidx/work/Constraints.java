package androidx.work;

import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class Constraints {
    public static final Constraints NONE = new Builder().build();
    @ColumnInfo(name = "content_uri_triggers")
    public ContentUriTriggers mContentUriTriggers = new ContentUriTriggers();
    @ColumnInfo(name = "required_network_type")
    public NetworkType mRequiredNetworkType = NetworkType.NOT_REQUIRED;
    @ColumnInfo(name = "requires_battery_not_low")
    public boolean mRequiresBatteryNotLow;
    @ColumnInfo(name = "requires_charging")
    public boolean mRequiresCharging;
    @ColumnInfo(name = "requires_device_idle")
    public boolean mRequiresDeviceIdle;
    @ColumnInfo(name = "requires_storage_not_low")
    public boolean mRequiresStorageNotLow;
    @ColumnInfo(name = "trigger_content_update_delay")
    public long mTriggerContentUpdateDelay = -1;
    @ColumnInfo(name = "trigger_max_content_delay")
    public long mTriggerMaxContentDelay = -1;

    public static final class Builder {
        public ContentUriTriggers mContentUriTriggers = new ContentUriTriggers();
        public NetworkType mRequiredNetworkType = NetworkType.NOT_REQUIRED;
        public boolean mRequiresBatteryNotLow = false;
        public boolean mRequiresCharging = false;
        public boolean mRequiresDeviceIdle = false;
        public boolean mRequiresStorageNotLow = false;
        public long mTriggerContentMaxDelay = -1;
        public long mTriggerContentUpdateDelay = -1;

        @RequiresApi(24)
        @NonNull
        public Builder addContentUriTrigger(@NonNull Uri uri, boolean z) {
            this.mContentUriTriggers.add(uri, z);
            return this;
        }

        @NonNull
        public Constraints build() {
            return new Constraints(this);
        }

        @NonNull
        public Builder setRequiredNetworkType(@NonNull NetworkType networkType) {
            this.mRequiredNetworkType = networkType;
            return this;
        }

        @NonNull
        public Builder setRequiresBatteryNotLow(boolean z) {
            this.mRequiresBatteryNotLow = z;
            return this;
        }

        @NonNull
        public Builder setRequiresCharging(boolean z) {
            this.mRequiresCharging = z;
            return this;
        }

        @RequiresApi(23)
        @NonNull
        public Builder setRequiresDeviceIdle(boolean z) {
            this.mRequiresDeviceIdle = z;
            return this;
        }

        @NonNull
        public Builder setRequiresStorageNotLow(boolean z) {
            this.mRequiresStorageNotLow = z;
            return this;
        }

        @RequiresApi(24)
        @NonNull
        public Builder setTriggerContentMaxDelay(long j, @NonNull TimeUnit timeUnit) {
            this.mTriggerContentMaxDelay = timeUnit.toMillis(j);
            return this;
        }

        @RequiresApi(24)
        @NonNull
        public Builder setTriggerContentUpdateDelay(long j, @NonNull TimeUnit timeUnit) {
            this.mTriggerContentUpdateDelay = timeUnit.toMillis(j);
            return this;
        }

        @RequiresApi(26)
        @NonNull
        public Builder setTriggerContentMaxDelay(Duration duration) {
            this.mTriggerContentMaxDelay = duration.toMillis();
            return this;
        }

        @RequiresApi(26)
        @NonNull
        public Builder setTriggerContentUpdateDelay(Duration duration) {
            this.mTriggerContentUpdateDelay = duration.toMillis();
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Constraints() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Constraints.class != obj.getClass()) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.mRequiresCharging == constraints.mRequiresCharging && this.mRequiresDeviceIdle == constraints.mRequiresDeviceIdle && this.mRequiresBatteryNotLow == constraints.mRequiresBatteryNotLow && this.mRequiresStorageNotLow == constraints.mRequiresStorageNotLow && this.mTriggerContentUpdateDelay == constraints.mTriggerContentUpdateDelay && this.mTriggerMaxContentDelay == constraints.mTriggerMaxContentDelay && this.mRequiredNetworkType == constraints.mRequiredNetworkType) {
            return this.mContentUriTriggers.equals(constraints.mContentUriTriggers);
        }
        return false;
    }

    @RequiresApi(24)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ContentUriTriggers getContentUriTriggers() {
        return this.mContentUriTriggers;
    }

    @NonNull
    public NetworkType getRequiredNetworkType() {
        return this.mRequiredNetworkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getTriggerContentUpdateDelay() {
        return this.mTriggerContentUpdateDelay;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getTriggerMaxContentDelay() {
        return this.mTriggerMaxContentDelay;
    }

    @RequiresApi(24)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean hasContentUriTriggers() {
        return this.mContentUriTriggers.size() > 0;
    }

    public int hashCode() {
        long j = this.mTriggerContentUpdateDelay;
        long j2 = this.mTriggerMaxContentDelay;
        return this.mContentUriTriggers.hashCode() + (((((((((((((this.mRequiredNetworkType.hashCode() * 31) + (this.mRequiresCharging ? 1 : 0)) * 31) + (this.mRequiresDeviceIdle ? 1 : 0)) * 31) + (this.mRequiresBatteryNotLow ? 1 : 0)) * 31) + (this.mRequiresStorageNotLow ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public boolean requiresBatteryNotLow() {
        return this.mRequiresBatteryNotLow;
    }

    public boolean requiresCharging() {
        return this.mRequiresCharging;
    }

    @RequiresApi(23)
    public boolean requiresDeviceIdle() {
        return this.mRequiresDeviceIdle;
    }

    public boolean requiresStorageNotLow() {
        return this.mRequiresStorageNotLow;
    }

    @RequiresApi(24)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setContentUriTriggers(@Nullable ContentUriTriggers contentUriTriggers) {
        this.mContentUriTriggers = contentUriTriggers;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiredNetworkType(@NonNull NetworkType networkType) {
        this.mRequiredNetworkType = networkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresBatteryNotLow(boolean z) {
        this.mRequiresBatteryNotLow = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresCharging(boolean z) {
        this.mRequiresCharging = z;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresDeviceIdle(boolean z) {
        this.mRequiresDeviceIdle = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRequiresStorageNotLow(boolean z) {
        this.mRequiresStorageNotLow = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setTriggerContentUpdateDelay(long j) {
        this.mTriggerContentUpdateDelay = j;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setTriggerMaxContentDelay(long j) {
        this.mTriggerMaxContentDelay = j;
    }

    public Constraints(Builder builder) {
        this.mRequiresCharging = builder.mRequiresCharging;
        this.mRequiresDeviceIdle = Build.VERSION.SDK_INT >= 23 && builder.mRequiresDeviceIdle;
        this.mRequiredNetworkType = builder.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = builder.mRequiresBatteryNotLow;
        this.mRequiresStorageNotLow = builder.mRequiresStorageNotLow;
        if (Build.VERSION.SDK_INT >= 24) {
            this.mContentUriTriggers = builder.mContentUriTriggers;
            this.mTriggerContentUpdateDelay = builder.mTriggerContentUpdateDelay;
            this.mTriggerMaxContentDelay = builder.mTriggerContentMaxDelay;
        }
    }

    public Constraints(@NonNull Constraints constraints) {
        this.mRequiresCharging = constraints.mRequiresCharging;
        this.mRequiresDeviceIdle = constraints.mRequiresDeviceIdle;
        this.mRequiredNetworkType = constraints.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = constraints.mRequiresBatteryNotLow;
        this.mRequiresStorageNotLow = constraints.mRequiresStorageNotLow;
        this.mContentUriTriggers = constraints.mContentUriTriggers;
    }
}
