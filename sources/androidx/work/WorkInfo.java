package androidx.work;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class WorkInfo {
    @NonNull
    public UUID mId;
    @NonNull
    public Data mOutputData;
    @NonNull
    public Data mProgress;
    public int mRunAttemptCount;
    @NonNull
    public State mState;
    @NonNull
    public Set<String> mTags;

    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean isFinished() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkInfo(@NonNull UUID uuid, @NonNull State state, @NonNull Data data, @NonNull List<String> list, @NonNull Data data2, int i) {
        this.mId = uuid;
        this.mState = state;
        this.mOutputData = data;
        this.mTags = new HashSet(list);
        this.mProgress = data2;
        this.mRunAttemptCount = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkInfo.class != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.mRunAttemptCount == workInfo.mRunAttemptCount && this.mId.equals(workInfo.mId) && this.mState == workInfo.mState && this.mOutputData.equals(workInfo.mOutputData) && this.mTags.equals(workInfo.mTags)) {
            return this.mProgress.equals(workInfo.mProgress);
        }
        return false;
    }

    @NonNull
    public UUID getId() {
        return this.mId;
    }

    @NonNull
    public Data getOutputData() {
        return this.mOutputData;
    }

    @NonNull
    public Data getProgress() {
        return this.mProgress;
    }

    @IntRange(from = 0)
    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    @NonNull
    public State getState() {
        return this.mState;
    }

    @NonNull
    public Set<String> getTags() {
        return this.mTags;
    }

    public int hashCode() {
        int hashCode = this.mState.hashCode();
        int hashCode2 = this.mOutputData.hashCode();
        int hashCode3 = this.mTags.hashCode();
        return ((this.mProgress.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.mId.hashCode() * 31)) * 31)) * 31)) * 31)) * 31) + this.mRunAttemptCount;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("WorkInfo{mId='");
        outline24.append(this.mId);
        outline24.append('\'');
        outline24.append(", mState=");
        outline24.append(this.mState);
        outline24.append(", mOutputData=");
        outline24.append(this.mOutputData);
        outline24.append(", mTags=");
        outline24.append(this.mTags);
        outline24.append(", mProgress=");
        outline24.append(this.mProgress);
        outline24.append('}');
        return outline24.toString();
    }
}
