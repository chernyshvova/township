package com.vungle.warren.tasks;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;

public class ReconfigJob implements Job {
    public static final String TAG = "com.vungle.warren.tasks.ReconfigJob";
    public ReconfigCall reconfigCall;

    public interface ReconfigCall {
        void reConfigVungle();
    }

    public ReconfigJob(@NonNull ReconfigCall reconfigCall2) {
        this.reconfigCall = reconfigCall2;
    }

    public static JobInfo makeJobInfo(String str) {
        return new JobInfo(TAG).setExtras(GeneratedOutlineSupport.outline5("appId", str)).setUpdateCurrent(true).setPriority(4);
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        if (bundle.getString("appId", (String) null) == null) {
            return 1;
        }
        this.reconfigCall.reConfigVungle();
        return 0;
    }
}
