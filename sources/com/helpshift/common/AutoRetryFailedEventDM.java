package com.helpshift.common;

import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.NetworkErrorCodes;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.poller.HttpBackoff;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class AutoRetryFailedEventDM {
    public final Domain domain;
    public AtomicBoolean isBatcherScheduled = new AtomicBoolean(false);
    public AtomicBoolean isSendAllEventsScheduled = new AtomicBoolean(false);
    public Map<EventType, AutoRetriableDM> listeners = new HashMap();
    public Set<EventType> pendingRetryEventTypes = Collections.synchronizedSet(new LinkedHashSet());
    public final Platform platform;
    public final HttpBackoff retryBackoff;
    public boolean shouldScheduleAuthenticationEvent = true;

    /* renamed from: com.helpshift.common.AutoRetryFailedEventDM$5 */
    public static /* synthetic */ class C24925 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$common$AutoRetryFailedEventDM$EventType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0016 */
        static {
            /*
                com.helpshift.common.AutoRetryFailedEventDM$EventType[] r0 = com.helpshift.common.AutoRetryFailedEventDM.EventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$common$AutoRetryFailedEventDM$EventType = r0
                r1 = 1
                r2 = 2
                com.helpshift.common.AutoRetryFailedEventDM$EventType r3 = com.helpshift.common.AutoRetryFailedEventDM.EventType.PUSH_TOKEN     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$helpshift$common$AutoRetryFailedEventDM$EventType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.common.AutoRetryFailedEventDM$EventType r3 = com.helpshift.common.AutoRetryFailedEventDM.EventType.CONVERSATION     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3 = 4
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r0 = $SwitchMap$com$helpshift$common$AutoRetryFailedEventDM$EventType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.common.AutoRetryFailedEventDM$EventType r2 = com.helpshift.common.AutoRetryFailedEventDM.EventType.SYNC_USER     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.AutoRetryFailedEventDM.C24925.<clinit>():void");
        }
    }

    public enum EventType {
        MIGRATION,
        SYNC_USER,
        PUSH_TOKEN,
        CLEAR_USER,
        CONVERSATION,
        FAQ,
        ANALYTICS,
        CONFIG
    }

    public AutoRetryFailedEventDM(Domain domain2, Platform platform2, HttpBackoff httpBackoff) {
        this.domain = domain2;
        this.platform = platform2;
        this.retryBackoff = httpBackoff;
    }

    private boolean canRetryEventType(EventType eventType) {
        return !isAuthenticatedType(eventType) || this.shouldScheduleAuthenticationEvent;
    }

    private boolean isAuthenticatedType(EventType eventType) {
        int ordinal = eventType.ordinal();
        return ordinal == 1 || ordinal == 2 || ordinal == 4;
    }

    private void scheduleSync(int i, final Set<EventType> set) {
        if (this.isBatcherScheduled.compareAndSet(false, true)) {
            long nextIntervalMillis = this.retryBackoff.nextIntervalMillis(i);
            if (nextIntervalMillis != -100) {
                this.domain.runDelayedInParallel(new C2500F() {
                    /* renamed from: f */
                    public void mo33949f() {
                        AutoRetryFailedEventDM.this.isBatcherScheduled.compareAndSet(true, false);
                        AutoRetryFailedEventDM.this.retryFailedApis(set);
                    }
                }, nextIntervalMillis);
            } else {
                this.isBatcherScheduled.compareAndSet(true, false);
            }
        }
    }

    public void onUserAuthenticationUpdated() {
        if (!this.shouldScheduleAuthenticationEvent) {
            this.shouldScheduleAuthenticationEvent = true;
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    AutoRetryFailedEventDM autoRetryFailedEventDM = AutoRetryFailedEventDM.this;
                    autoRetryFailedEventDM.retryFailedApis(autoRetryFailedEventDM.pendingRetryEventTypes);
                }
            });
        }
    }

    public void register(EventType eventType, AutoRetriableDM autoRetriableDM) {
        this.listeners.put(eventType, autoRetriableDM);
    }

    public void resetBackoff() {
        this.retryBackoff.reset();
    }

    public void retryFailedApis(Set<EventType> set) {
        if (!this.platform.isOnline()) {
            scheduleSync(0, set);
            return;
        }
        try {
            Iterator it = new LinkedList(set).iterator();
            while (it.hasNext()) {
                EventType eventType = (EventType) it.next();
                if (canRetryEventType(eventType)) {
                    AutoRetriableDM autoRetriableDM = this.listeners.get(eventType);
                    if (autoRetriableDM == null) {
                        this.pendingRetryEventTypes.remove(eventType);
                        set.remove(eventType);
                    } else {
                        autoRetriableDM.sendFailedApiCalls(eventType);
                        this.pendingRetryEventTypes.remove(eventType);
                        set.remove(eventType);
                    }
                }
            }
            this.retryBackoff.reset();
        } catch (RootAPIException e) {
            if (e.exceptionType != NetworkException.INVALID_AUTH_TOKEN) {
                if (e.exceptionType != NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                    throw e;
                }
            }
            this.shouldScheduleAuthenticationEvent = false;
        } catch (RootAPIException e2) {
            scheduleSync(e2.getServerStatusCode(), set);
        }
    }

    public void scheduleRetryTaskForEventType(EventType eventType, int i) {
        this.pendingRetryEventTypes.add(eventType);
        if (!isAuthenticatedType(eventType)) {
            scheduleSync(i, this.pendingRetryEventTypes);
        } else if (i == NetworkErrorCodes.INVALID_AUTH_TOKEN.intValue() || i == NetworkErrorCodes.AUTH_TOKEN_NOT_PROVIDED.intValue()) {
            this.shouldScheduleAuthenticationEvent = false;
        } else {
            scheduleSync(i, this.pendingRetryEventTypes);
        }
    }

    public void sendAllEvents() {
        if (this.isSendAllEventsScheduled.compareAndSet(false, true)) {
            this.pendingRetryEventTypes.add(EventType.MIGRATION);
            this.pendingRetryEventTypes.add(EventType.SYNC_USER);
            this.pendingRetryEventTypes.add(EventType.PUSH_TOKEN);
            this.pendingRetryEventTypes.add(EventType.CLEAR_USER);
            this.pendingRetryEventTypes.add(EventType.CONVERSATION);
            this.pendingRetryEventTypes.add(EventType.FAQ);
            this.pendingRetryEventTypes.add(EventType.ANALYTICS);
            this.pendingRetryEventTypes.add(EventType.CONFIG);
            this.domain.runParallel(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    try {
                        AutoRetryFailedEventDM.this.retryFailedApis(AutoRetryFailedEventDM.this.pendingRetryEventTypes);
                    } finally {
                        AutoRetryFailedEventDM.this.isSendAllEventsScheduled.compareAndSet(true, false);
                    }
                }
            });
        }
    }

    public void sendEventForcefully(final EventType eventType) {
        this.domain.runParallel(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.add(eventType);
                AutoRetryFailedEventDM.this.retryFailedApis(linkedHashSet);
            }
        });
    }
}
