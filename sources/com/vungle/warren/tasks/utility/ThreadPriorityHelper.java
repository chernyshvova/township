package com.vungle.warren.tasks.utility;

import androidx.annotation.NonNull;
import com.vungle.warren.tasks.JobInfo;

public interface ThreadPriorityHelper {
    int makeAndroidThreadPriority(@NonNull JobInfo jobInfo);
}
