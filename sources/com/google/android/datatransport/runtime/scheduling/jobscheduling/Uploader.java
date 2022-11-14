package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class Uploader {
    public final BackendRegistry backendRegistry;
    public final Clock clock;
    public final Context context;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final WorkScheduler workScheduler;

    public Uploader(Context context2, BackendRegistry backendRegistry2, EventStore eventStore2, WorkScheduler workScheduler2, Executor executor2, SynchronizationGuard synchronizationGuard, Clock clock2) {
        this.context = context2;
        this.backendRegistry = backendRegistry2;
        this.eventStore = eventStore2;
        this.workScheduler = workScheduler2;
        this.executor = executor2;
        this.guard = synchronizationGuard;
        this.clock = clock2;
    }

    public void logAndUpdateState(TransportContext transportContext, int i) {
        BackendResponse send;
        TransportBackend transportBackend = this.backendRegistry.get(((AutoValue_TransportContext) transportContext).backendName);
        Iterable<PersistedEvent> iterable = (Iterable) this.guard.runCriticalSection(new Uploader$$Lambda$2(this, transportContext));
        if (iterable.iterator().hasNext()) {
            if (transportBackend == null) {
                zzam.m35d("Uploader", "Unknown backend for %s, deleting event batch for it...", (Object) transportContext);
                send = BackendResponse.fatalError();
            } else {
                ArrayList arrayList = new ArrayList();
                for (PersistedEvent persistedEvent : iterable) {
                    arrayList.add(((AutoValue_PersistedEvent) persistedEvent).event);
                }
                byte[] bArr = ((AutoValue_TransportContext) transportContext).extras;
                if (1 != 0) {
                    send = transportBackend.send(new AutoValue_BackendRequest(arrayList, bArr, (AutoValue_BackendRequest.C16151) null));
                } else {
                    throw new IllegalStateException(GeneratedOutlineSupport.outline16("Missing required properties:", ""));
                }
            }
            this.guard.runCriticalSection(new Uploader$$Lambda$3(this, send, iterable, transportContext, i));
        }
    }
}
