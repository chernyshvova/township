package com.vungle.warren.tasks;

import androidx.annotation.NonNull;

public interface JobRunner {
    void cancelPendingJob(@NonNull String str);

    void execute(@NonNull JobInfo jobInfo);
}
