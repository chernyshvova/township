package com.vungle.warren.tasks.runnable;

import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.vungle.warren.tasks.JobCreator;
import com.vungle.warren.tasks.JobInfo;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.tasks.UnknownTagException;
import com.vungle.warren.tasks.utility.ThreadPriorityHelper;
import com.vungle.warren.utility.PriorityRunnable;

public class JobRunnable extends PriorityRunnable {
    public static final String TAG = JobRunnable.class.getSimpleName();
    public final JobCreator creator;
    public final JobRunner jobRunner;
    public final JobInfo jobinfo;
    public final ThreadPriorityHelper threadPriorityHelper;

    public JobRunnable(@NonNull JobInfo jobInfo, @NonNull JobCreator jobCreator, @NonNull JobRunner jobRunner2, @Nullable ThreadPriorityHelper threadPriorityHelper2) {
        this.jobinfo = jobInfo;
        this.creator = jobCreator;
        this.jobRunner = jobRunner2;
        this.threadPriorityHelper = threadPriorityHelper2;
    }

    public Integer getPriority() {
        return Integer.valueOf(this.jobinfo.getPriority());
    }

    public void run() {
        ThreadPriorityHelper threadPriorityHelper2 = this.threadPriorityHelper;
        if (threadPriorityHelper2 != null) {
            try {
                int makeAndroidThreadPriority = threadPriorityHelper2.makeAndroidThreadPriority(this.jobinfo);
                Process.setThreadPriority(makeAndroidThreadPriority);
                String str = TAG;
                Log.d(str, "Setting process thread prio = " + makeAndroidThreadPriority + " for " + this.jobinfo.getJobTag());
            } catch (Throwable unused) {
                Log.e(TAG, "Error on setting process thread priority");
            }
        }
        try {
            String jobTag = this.jobinfo.getJobTag();
            Bundle extras = this.jobinfo.getExtras();
            String str2 = TAG;
            Log.d(str2, "Start job " + jobTag + "Thread " + Thread.currentThread().getName());
            int onRunJob = this.creator.create(jobTag).onRunJob(extras, this.jobRunner);
            String str3 = TAG;
            Log.d(str3, "On job finished " + jobTag + " with result " + onRunJob);
            if (onRunJob == 2) {
                long makeNextRescedule = this.jobinfo.makeNextRescedule();
                if (makeNextRescedule > 0) {
                    this.jobinfo.setDelay(makeNextRescedule);
                    this.jobRunner.execute(this.jobinfo);
                    String str4 = TAG;
                    Log.d(str4, "Rescheduling " + jobTag + " in " + makeNextRescedule);
                }
            }
        } catch (UnknownTagException e) {
            String str5 = TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Cannot create job");
            outline24.append(e.getLocalizedMessage());
            Log.e(str5, outline24.toString());
        } catch (Throwable th) {
            Log.e(TAG, "Can't start job", th);
        }
    }
}
