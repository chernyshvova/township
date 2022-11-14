package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public abstract class WorkRequest {
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_BACKOFF_MILLIS = 10000;
    @NonNull
    public UUID mId;
    @NonNull
    public Set<String> mTags;
    @NonNull
    public WorkSpec mWorkSpec;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkRequest(@NonNull UUID uuid, @NonNull WorkSpec workSpec, @NonNull Set<String> set) {
        this.mId = uuid;
        this.mWorkSpec = workSpec;
        this.mTags = set;
    }

    @NonNull
    public UUID getId() {
        return this.mId;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getStringId() {
        return this.mId.toString();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<String> getTags() {
        return this.mTags;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkSpec getWorkSpec() {
        return this.mWorkSpec;
    }

    public static abstract class Builder<B extends Builder<?, ?>, W extends WorkRequest> {
        public boolean mBackoffCriteriaSet = false;
        public UUID mId = UUID.randomUUID();
        public Set<String> mTags = new HashSet();
        public WorkSpec mWorkSpec;
        public Class<? extends ListenableWorker> mWorkerClass;

        public Builder(@NonNull Class<? extends ListenableWorker> cls) {
            this.mWorkerClass = cls;
            this.mWorkSpec = new WorkSpec(this.mId.toString(), cls.getName());
            addTag(cls.getName());
        }

        @NonNull
        public final B addTag(@NonNull String str) {
            this.mTags.add(str);
            return getThis();
        }

        @NonNull
        public final W build() {
            W buildInternal = buildInternal();
            this.mId = UUID.randomUUID();
            WorkSpec workSpec = new WorkSpec(this.mWorkSpec);
            this.mWorkSpec = workSpec;
            workSpec.f34id = this.mId.toString();
            return buildInternal;
        }

        @NonNull
        public abstract W buildInternal();

        @NonNull
        public abstract B getThis();

        @NonNull
        public final B keepResultsForAtLeast(long j, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.minimumRetentionDuration = timeUnit.toMillis(j);
            return getThis();
        }

        @NonNull
        public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, long j, @NonNull TimeUnit timeUnit) {
            this.mBackoffCriteriaSet = true;
            WorkSpec workSpec = this.mWorkSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(timeUnit.toMillis(j));
            return getThis();
        }

        @NonNull
        public final B setConstraints(@NonNull Constraints constraints) {
            this.mWorkSpec.constraints = constraints;
            return getThis();
        }

        @NonNull
        public B setInitialDelay(long j, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.initialDelay = timeUnit.toMillis(j);
            if (RecyclerView.FOREVER_NS - System.currentTimeMillis() > this.mWorkSpec.initialDelay) {
                return getThis();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setInitialRunAttemptCount(int i) {
            this.mWorkSpec.runAttemptCount = i;
            return getThis();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setInitialState(@NonNull WorkInfo.State state) {
            this.mWorkSpec.state = state;
            return getThis();
        }

        @NonNull
        public final B setInputData(@NonNull Data data) {
            this.mWorkSpec.input = data;
            return getThis();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setPeriodStartTime(long j, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.periodStartTime = timeUnit.toMillis(j);
            return getThis();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        @NonNull
        public final B setScheduleRequestedAt(long j, @NonNull TimeUnit timeUnit) {
            this.mWorkSpec.scheduleRequestedAt = timeUnit.toMillis(j);
            return getThis();
        }

        @RequiresApi(26)
        @NonNull
        public final B keepResultsForAtLeast(@NonNull Duration duration) {
            this.mWorkSpec.minimumRetentionDuration = duration.toMillis();
            return getThis();
        }

        @RequiresApi(26)
        @NonNull
        public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, @NonNull Duration duration) {
            this.mBackoffCriteriaSet = true;
            WorkSpec workSpec = this.mWorkSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(duration.toMillis());
            return getThis();
        }

        @RequiresApi(26)
        @NonNull
        public B setInitialDelay(@NonNull Duration duration) {
            this.mWorkSpec.initialDelay = duration.toMillis();
            if (RecyclerView.FOREVER_NS - System.currentTimeMillis() > this.mWorkSpec.initialDelay) {
                return getThis();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }
    }
}
