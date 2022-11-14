package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class JobInfoSchedulerService$$Lambda$1 implements Runnable {
    public final JobInfoSchedulerService arg$1;
    public final JobParameters arg$2;

    public JobInfoSchedulerService$$Lambda$1(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.arg$1 = jobInfoSchedulerService;
        this.arg$2 = jobParameters;
    }

    public void run() {
        this.arg$1.jobFinished(this.arg$2, false);
    }
}
