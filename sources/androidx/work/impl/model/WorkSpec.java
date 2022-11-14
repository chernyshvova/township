package androidx.work.impl.model;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity(indices = {@Index({"schedule_requested_at"}), @Index({"period_start_time"})})
public final class WorkSpec {
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    public static final String TAG = Logger.tagWithPrefix("WorkSpec");
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER = new Function<List<WorkInfoPojo>, List<WorkInfo>>() {
        public List<WorkInfo> apply(List<WorkInfoPojo> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (WorkInfoPojo workInfo : list) {
                arrayList.add(workInfo.toWorkInfo());
            }
            return arrayList;
        }
    };
    @ColumnInfo(name = "backoff_delay_duration")
    public long backoffDelayDuration;
    @ColumnInfo(name = "backoff_policy")
    @NonNull
    public BackoffPolicy backoffPolicy;
    @NonNull
    @Embedded
    public Constraints constraints;
    @ColumnInfo(name = "flex_duration")
    public long flexDuration;
    @ColumnInfo(name = "id")
    @NonNull
    @PrimaryKey

    /* renamed from: id */
    public String f34id;
    @ColumnInfo(name = "initial_delay")
    public long initialDelay;
    @ColumnInfo(name = "input")
    @NonNull
    public Data input;
    @ColumnInfo(name = "input_merger_class_name")
    public String inputMergerClassName;
    @ColumnInfo(name = "interval_duration")
    public long intervalDuration;
    @ColumnInfo(name = "minimum_retention_duration")
    public long minimumRetentionDuration;
    @ColumnInfo(name = "output")
    @NonNull
    public Data output;
    @ColumnInfo(name = "period_start_time")
    public long periodStartTime;
    @ColumnInfo(name = "run_attempt_count")
    @IntRange(from = 0)
    public int runAttemptCount;
    @ColumnInfo(name = "run_in_foreground")
    public boolean runInForeground;
    @ColumnInfo(name = "schedule_requested_at")
    public long scheduleRequestedAt;
    @ColumnInfo(name = "state")
    @NonNull
    public WorkInfo.State state = WorkInfo.State.ENQUEUED;
    @ColumnInfo(name = "worker_class_name")
    @NonNull
    public String workerClassName;

    public static class IdAndState {
        @ColumnInfo(name = "id")

        /* renamed from: id */
        public String f35id;
        @ColumnInfo(name = "state")
        public WorkInfo.State state;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            if (this.state != idAndState.state) {
                return false;
            }
            return this.f35id.equals(idAndState.f35id);
        }

        public int hashCode() {
            return this.state.hashCode() + (this.f35id.hashCode() * 31);
        }
    }

    public static class WorkInfoPojo {
        @ColumnInfo(name = "id")

        /* renamed from: id */
        public String f36id;
        @ColumnInfo(name = "output")
        public Data output;
        @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"progress"})
        public List<Data> progress;
        @ColumnInfo(name = "run_attempt_count")
        public int runAttemptCount;
        @ColumnInfo(name = "state")
        public WorkInfo.State state;
        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"tag"})
        public List<String> tags;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            if (this.runAttemptCount != workInfoPojo.runAttemptCount) {
                return false;
            }
            String str = this.f36id;
            if (str == null ? workInfoPojo.f36id != null : !str.equals(workInfoPojo.f36id)) {
                return false;
            }
            if (this.state != workInfoPojo.state) {
                return false;
            }
            Data data = this.output;
            if (data == null ? workInfoPojo.output != null : !data.equals(workInfoPojo.output)) {
                return false;
            }
            List<String> list = this.tags;
            if (list == null ? workInfoPojo.tags != null : !list.equals(workInfoPojo.tags)) {
                return false;
            }
            List<Data> list2 = this.progress;
            List<Data> list3 = workInfoPojo.progress;
            if (list2 != null) {
                return list2.equals(list3);
            }
            if (list3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.f36id;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            WorkInfo.State state2 = this.state;
            int hashCode2 = (hashCode + (state2 != null ? state2.hashCode() : 0)) * 31;
            Data data = this.output;
            int hashCode3 = (((hashCode2 + (data != null ? data.hashCode() : 0)) * 31) + this.runAttemptCount) * 31;
            List<String> list = this.tags;
            int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            List<Data> list2 = this.progress;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return hashCode4 + i;
        }

        @NonNull
        public WorkInfo toWorkInfo() {
            Data data;
            List<Data> list = this.progress;
            if (list == null || list.isEmpty()) {
                data = Data.EMPTY;
            } else {
                data = this.progress.get(0);
            }
            return new WorkInfo(UUID.fromString(this.f36id), this.state, this.output, this.tags, data, this.runAttemptCount);
        }
    }

    public WorkSpec(@NonNull String str, @NonNull String str2) {
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = 30000;
        this.scheduleRequestedAt = -1;
        this.f34id = str;
        this.workerClassName = str2;
    }

    public long calculateNextRunTime() {
        long j;
        long j2;
        long j3;
        boolean z = false;
        if (isBackedOff()) {
            if (this.backoffPolicy == BackoffPolicy.LINEAR) {
                z = true;
            }
            if (z) {
                j3 = this.backoffDelayDuration * ((long) this.runAttemptCount);
            } else {
                j3 = (long) Math.scalb((float) this.backoffDelayDuration, this.runAttemptCount - 1);
            }
            j2 = this.periodStartTime;
            j = Math.min(WorkRequest.MAX_BACKOFF_MILLIS, j3);
        } else {
            long j4 = 0;
            if (isPeriodic()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j5 = this.periodStartTime;
                if (j5 == 0) {
                    j5 = this.initialDelay + currentTimeMillis;
                }
                if (this.flexDuration != this.intervalDuration) {
                    z = true;
                }
                if (z) {
                    if (this.periodStartTime == 0) {
                        j4 = this.flexDuration * -1;
                    }
                    return j5 + this.intervalDuration + j4;
                }
                if (this.periodStartTime != 0) {
                    j4 = this.intervalDuration;
                }
                return j5 + j4;
            }
            j = this.periodStartTime;
            if (j == 0) {
                j = System.currentTimeMillis();
            }
            j2 = this.initialDelay;
        }
        return j + j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        if (this.initialDelay != workSpec.initialDelay || this.intervalDuration != workSpec.intervalDuration || this.flexDuration != workSpec.flexDuration || this.runAttemptCount != workSpec.runAttemptCount || this.backoffDelayDuration != workSpec.backoffDelayDuration || this.periodStartTime != workSpec.periodStartTime || this.minimumRetentionDuration != workSpec.minimumRetentionDuration || this.scheduleRequestedAt != workSpec.scheduleRequestedAt || this.runInForeground != workSpec.runInForeground || !this.f34id.equals(workSpec.f34id) || this.state != workSpec.state || !this.workerClassName.equals(workSpec.workerClassName)) {
            return false;
        }
        String str = this.inputMergerClassName;
        if (str == null ? workSpec.inputMergerClassName != null : !str.equals(workSpec.inputMergerClassName)) {
            return false;
        }
        if (this.input.equals(workSpec.input) && this.output.equals(workSpec.output) && this.constraints.equals(workSpec.constraints) && this.backoffPolicy == workSpec.backoffPolicy) {
            return true;
        }
        return false;
    }

    public boolean hasConstraints() {
        return !Constraints.NONE.equals(this.constraints);
    }

    public int hashCode() {
        int outline4 = GeneratedOutlineSupport.outline4(this.workerClassName, (this.state.hashCode() + (this.f34id.hashCode() * 31)) * 31, 31);
        String str = this.inputMergerClassName;
        int hashCode = str != null ? str.hashCode() : 0;
        int hashCode2 = this.input.hashCode();
        int hashCode3 = this.output.hashCode();
        long j = this.initialDelay;
        long j2 = this.intervalDuration;
        long j3 = this.flexDuration;
        int hashCode4 = this.constraints.hashCode();
        int hashCode5 = this.backoffPolicy.hashCode();
        long j4 = this.backoffDelayDuration;
        long j5 = this.periodStartTime;
        long j6 = this.minimumRetentionDuration;
        long j7 = this.scheduleRequestedAt;
        return ((((((((((hashCode5 + ((((hashCode4 + ((((((((hashCode3 + ((hashCode2 + ((outline4 + hashCode) * 31)) * 31)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31) + this.runAttemptCount) * 31)) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.runInForeground ? 1 : 0);
    }

    public boolean isBackedOff() {
        return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
    }

    public boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public void setBackoffDelayDuration(long j) {
        if (j > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value", new Throwable[0]);
            j = 18000000;
        }
        if (j < 10000) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value", new Throwable[0]);
            j = 10000;
        }
        this.backoffDelayDuration = j;
    }

    public void setPeriodic(long j) {
        if (j < 900000) {
            Logger.get().warning(TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{900000L}), new Throwable[0]);
            j = 900000;
        }
        setPeriodic(j, j);
    }

    @NonNull
    public String toString() {
        return GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline24("{WorkSpec: "), this.f34id, "}");
    }

    public void setPeriodic(long j, long j2) {
        if (j < 900000) {
            Logger.get().warning(TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{900000L}), new Throwable[0]);
            j = 900000;
        }
        if (j2 < 300000) {
            Logger.get().warning(TAG, String.format("Flex duration lesser than minimum allowed value; Changed to %s", new Object[]{300000L}), new Throwable[0]);
            j2 = 300000;
        }
        if (j2 > j) {
            Logger.get().warning(TAG, String.format("Flex duration greater than interval duration; Changed to %s", new Object[]{Long.valueOf(j)}), new Throwable[0]);
            j2 = j;
        }
        this.intervalDuration = j;
        this.flexDuration = j2;
    }

    public WorkSpec(@NonNull WorkSpec workSpec) {
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = 30000;
        this.scheduleRequestedAt = -1;
        this.f34id = workSpec.f34id;
        this.workerClassName = workSpec.workerClassName;
        this.state = workSpec.state;
        this.inputMergerClassName = workSpec.inputMergerClassName;
        this.input = new Data(workSpec.input);
        this.output = new Data(workSpec.output);
        this.initialDelay = workSpec.initialDelay;
        this.intervalDuration = workSpec.intervalDuration;
        this.flexDuration = workSpec.flexDuration;
        this.constraints = new Constraints(workSpec.constraints);
        this.runAttemptCount = workSpec.runAttemptCount;
        this.backoffPolicy = workSpec.backoffPolicy;
        this.backoffDelayDuration = workSpec.backoffDelayDuration;
        this.periodStartTime = workSpec.periodStartTime;
        this.minimumRetentionDuration = workSpec.minimumRetentionDuration;
        this.scheduleRequestedAt = workSpec.scheduleRequestedAt;
        this.runInForeground = workSpec.runInForeground;
    }
}
