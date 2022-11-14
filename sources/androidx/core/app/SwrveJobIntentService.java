package androidx.core.app;

import androidx.core.app.JobIntentService;
import com.swrve.sdk.SwrveLogger;

public abstract class SwrveJobIntentService extends JobIntentService {
    public JobIntentService.GenericWorkItem dequeueWork() {
        try {
            return super.dequeueWork();
        } catch (SecurityException e) {
            SwrveLogger.m2753e("SwrveJobIntentService exception in dequeueWork. This is a known android O+ bug.", e, new Object[0]);
            return null;
        }
    }
}
