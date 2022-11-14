package com.google.android.datatransport.runtime.scheduling;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportImpl$$Lambda$1;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class DefaultScheduler implements Scheduler {
    public static final Logger LOGGER = Logger.getLogger(TransportRuntime.class.getName());
    public final BackendRegistry backendRegistry;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final WorkScheduler workScheduler;

    public DefaultScheduler(Executor executor2, BackendRegistry backendRegistry2, WorkScheduler workScheduler2, EventStore eventStore2, SynchronizationGuard synchronizationGuard) {
        this.executor = executor2;
        this.backendRegistry = backendRegistry2;
        this.workScheduler = workScheduler2;
        this.eventStore = eventStore2;
        this.guard = synchronizationGuard;
    }

    public static void lambda$schedule$1(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        try {
            TransportBackend transportBackend = defaultScheduler.backendRegistry.get(((AutoValue_TransportContext) transportContext).backendName);
            if (transportBackend == null) {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{((AutoValue_TransportContext) transportContext).backendName});
                LOGGER.warning(format);
                new IllegalArgumentException(format);
                if (((TransportImpl$$Lambda$1) transportScheduleCallback) == null) {
                    throw null;
                }
                return;
            }
            defaultScheduler.guard.runCriticalSection(new DefaultScheduler$$Lambda$2(defaultScheduler, transportContext, transportBackend.decorate(eventInternal)));
            if (((TransportImpl$$Lambda$1) transportScheduleCallback) == null) {
                throw null;
            }
        } catch (Exception e) {
            Logger logger = LOGGER;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error scheduling event ");
            outline24.append(e.getMessage());
            logger.warning(outline24.toString());
            if (((TransportImpl$$Lambda$1) transportScheduleCallback) == null) {
                throw null;
            }
        }
    }

    public void schedule(TransportContext transportContext, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        this.executor.execute(new DefaultScheduler$$Lambda$1(this, transportContext, transportScheduleCallback, eventInternal));
    }
}
