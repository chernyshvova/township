package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer$$Lambda$1;
import com.google.android.datatransport.runtime.time.Clock;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class TransportRuntime implements TransportInternal {
    public static volatile TransportRuntimeComponent instance;
    public final Clock eventClock;
    public final Scheduler scheduler;
    public final Uploader uploader;
    public final Clock uptimeClock;

    public TransportRuntime(Clock clock, Clock clock2, Scheduler scheduler2, Uploader uploader2, WorkInitializer workInitializer) {
        this.eventClock = clock;
        this.uptimeClock = clock2;
        this.scheduler = scheduler2;
        this.uploader = uploader2;
        workInitializer.executor.execute(new WorkInitializer$$Lambda$1(workInitializer));
    }

    public static TransportRuntime getInstance() {
        TransportRuntimeComponent transportRuntimeComponent = instance;
        if (transportRuntimeComponent != null) {
            return ((DaggerTransportRuntimeComponent) transportRuntimeComponent).transportRuntimeProvider.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void initialize(Context context) {
        if (instance == null) {
            synchronized (TransportRuntime.class) {
                if (instance == null) {
                    if (context != null) {
                        Class<Context> cls = Context.class;
                        if (context != null) {
                            instance = new DaggerTransportRuntimeComponent(context, (DaggerTransportRuntimeComponent.C16141) null);
                        } else {
                            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
                        }
                    } else {
                        throw null;
                    }
                }
            }
        }
    }
}
