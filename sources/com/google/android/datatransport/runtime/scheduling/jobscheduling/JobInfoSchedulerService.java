package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

@RequiresApi(api = 21)
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class JobInfoSchedulerService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(getApplicationContext());
        TransportContext.Builder builder = TransportContext.builder();
        builder.setBackendName(string);
        builder.setPriority(PriorityMapping.valueOf(i));
        if (string2 != null) {
            ((AutoValue_TransportContext.Builder) builder).extras = Base64.decode(string2, 0);
        }
        Uploader uploader = TransportRuntime.getInstance().uploader;
        uploader.executor.execute(new Uploader$$Lambda$1(uploader, builder.build(), i2, new JobInfoSchedulerService$$Lambda$1(this, jobParameters)));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
