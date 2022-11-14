package com.vungle.warren.tasks.utility;

import androidx.annotation.NonNull;
import com.vungle.warren.tasks.JobInfo;

public class JobRunnerThreadPriorityHelper implements ThreadPriorityHelper {
    public static final String TAG = "JobRunnerThreadPriorityHelper";

    public int makeAndroidThreadPriority(@NonNull JobInfo jobInfo) {
        return Math.min(19, Math.abs(Math.min(0, jobInfo.getPriority() - 2)) + 10);
    }
}
