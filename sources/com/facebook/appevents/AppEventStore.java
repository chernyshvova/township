package com.facebook.appevents;

import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppEventStore.kt */
public final class AppEventStore {
    public static final AppEventStore INSTANCE = new AppEventStore();
    public static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    public static final String TAG;

    /* compiled from: AppEventStore.kt */
    public static final class MovedClassObjectInputStream extends ObjectInputStream {
        public static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        public static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        /* compiled from: AppEventStore.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public MovedClassObjectInputStream(InputStream inputStream) {
            super(inputStream);
        }

        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (Intrinsics.areEqual(readClassDescriptor.getName(), ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (Intrinsics.areEqual(readClassDescriptor.getName(), APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            Intrinsics.checkNotNullExpressionValue(readClassDescriptor, "resultClassDescriptor");
            return readClassDescriptor;
        }
    }

    static {
        String name = AppEventStore.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "AppEventStore::class.java.name");
        TAG = name;
    }

    public static final synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        Class<AppEventStore> cls = AppEventStore.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
                    Intrinsics.checkNotNullParameter(sessionEventsState, "appEvents");
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    AppEventUtility.assertIsNotMainThread();
                    PersistedEvents readAndClearStore = readAndClearStore();
                    readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                    saveEventsToDisk$facebook_core_release(readAndClearStore);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ad A[Catch:{ Exception -> 0x0044, all -> 0x00b4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventStore> r0 = com.facebook.appevents.AppEventStore.class
            monitor-enter(r0)
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)     // Catch:{ all -> 0x00ba }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)
            return r2
        L_0x000c:
            com.facebook.appevents.internal.AppEventUtility r1 = com.facebook.appevents.internal.AppEventUtility.INSTANCE     // Catch:{ all -> 0x00b4 }
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch:{ all -> 0x00b4 }
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x00b4 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch:{ FileNotFoundException -> 0x0094, Exception -> 0x005a, all -> 0x0057 }
            java.lang.String r4 = "context.openFileInput(PERSISTED_EVENTS_FILENAME)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ FileNotFoundException -> 0x0094, Exception -> 0x005a, all -> 0x0057 }
            com.facebook.appevents.AppEventStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventStore$MovedClassObjectInputStream     // Catch:{ FileNotFoundException -> 0x0094, Exception -> 0x005a, all -> 0x0057 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0094, Exception -> 0x005a, all -> 0x0057 }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0094, Exception -> 0x005a, all -> 0x0057 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0094, Exception -> 0x005a, all -> 0x0057 }
            java.lang.Object r3 = r4.readObject()     // Catch:{ FileNotFoundException -> 0x0095, Exception -> 0x0055 }
            if (r3 == 0) goto L_0x004d
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch:{ FileNotFoundException -> 0x0095, Exception -> 0x0055 }
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x00b4 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch:{ Exception -> 0x0044 }
            r1.delete()     // Catch:{ Exception -> 0x0044 }
            goto L_0x00ab
        L_0x0044:
            r1 = move-exception
            java.lang.String r4 = TAG     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch:{ all -> 0x00b4 }
            goto L_0x00ab
        L_0x004d:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ FileNotFoundException -> 0x0095, Exception -> 0x0055 }
            java.lang.String r5 = "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents"
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0095, Exception -> 0x0055 }
            throw r3     // Catch:{ FileNotFoundException -> 0x0095, Exception -> 0x0055 }
        L_0x0055:
            r3 = move-exception
            goto L_0x005c
        L_0x0057:
            r3 = move-exception
            r4 = r2
            goto L_0x007c
        L_0x005a:
            r3 = move-exception
            r4 = r2
        L_0x005c:
            java.lang.String r5 = TAG     // Catch:{ all -> 0x007b }
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r3)     // Catch:{ all -> 0x007b }
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x00b4 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x0072 }
            r1.delete()     // Catch:{ Exception -> 0x0072 }
            goto L_0x00aa
        L_0x0072:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
        L_0x0077:
            android.util.Log.w(r3, r4, r1)     // Catch:{ all -> 0x00b4 }
            goto L_0x00aa
        L_0x007b:
            r3 = move-exception
        L_0x007c:
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x00b4 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch:{ Exception -> 0x008b }
            r1.delete()     // Catch:{ Exception -> 0x008b }
            goto L_0x0093
        L_0x008b:
            r1 = move-exception
            java.lang.String r4 = TAG     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch:{ all -> 0x00b4 }
        L_0x0093:
            throw r3     // Catch:{ all -> 0x00b4 }
        L_0x0094:
            r4 = r2
        L_0x0095:
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x00b4 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x00a4 }
            r1.delete()     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00aa
        L_0x00a4:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L_0x0077
        L_0x00aa:
            r3 = r2
        L_0x00ab:
            if (r3 != 0) goto L_0x00b2
            com.facebook.appevents.PersistedEvents r3 = new com.facebook.appevents.PersistedEvents     // Catch:{ all -> 0x00b4 }
            r3.<init>()     // Catch:{ all -> 0x00b4 }
        L_0x00b2:
            monitor-exit(r0)
            return r3
        L_0x00b4:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)     // Catch:{ all -> 0x00ba }
            monitor-exit(r0)
            return r2
        L_0x00ba:
            r1 = move-exception
            monitor-exit(r0)
            goto L_0x00be
        L_0x00bd:
            throw r1
        L_0x00be:
            goto L_0x00bd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003c */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void saveEventsToDisk$facebook_core_release(com.facebook.appevents.PersistedEvents r7) {
        /*
            java.lang.String r0 = "AppEventsLogger.persistedevents"
            java.lang.Class<com.facebook.appevents.AppEventStore> r1 = com.facebook.appevents.AppEventStore.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            r2 = 0
            com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0049 }
            android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0049 }
            java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x002d }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x002d }
            r6 = 0
            java.io.FileOutputStream r6 = r3.openFileOutput(r0, r6)     // Catch:{ all -> 0x002d }
            r5.<init>(r6)     // Catch:{ all -> 0x002d }
            r4.<init>(r5)     // Catch:{ all -> 0x002d }
            r4.writeObject(r7)     // Catch:{ all -> 0x002a }
            com.facebook.internal.Utility r7 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x0049 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0049 }
            goto L_0x0041
        L_0x002a:
            r7 = move-exception
            r2 = r4
            goto L_0x002e
        L_0x002d:
            r7 = move-exception
        L_0x002e:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0042 }
            java.lang.String r5 = "Got unexpected exception while persisting events: "
            android.util.Log.w(r4, r5, r7)     // Catch:{ all -> 0x0042 }
            java.io.File r7 = r3.getFileStreamPath(r0)     // Catch:{ Exception -> 0x003c }
            r7.delete()     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            com.facebook.internal.Utility r7 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x0049 }
            com.facebook.internal.Utility.closeQuietly(r2)     // Catch:{ all -> 0x0049 }
        L_0x0041:
            return
        L_0x0042:
            r7 = move-exception
            com.facebook.internal.Utility r0 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x0049 }
            com.facebook.internal.Utility.closeQuietly(r2)     // Catch:{ all -> 0x0049 }
            throw r7     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r7 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.saveEventsToDisk$facebook_core_release(com.facebook.appevents.PersistedEvents):void");
    }

    public static final synchronized void persistEvents(AppEventCollection appEventCollection) {
        Class<AppEventStore> cls = AppEventStore.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    Intrinsics.checkNotNullParameter(appEventCollection, "eventsToPersist");
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    AppEventUtility.assertIsNotMainThread();
                    PersistedEvents readAndClearStore = readAndClearStore();
                    for (AccessTokenAppIdPair next : appEventCollection.keySet()) {
                        SessionEventsState sessionEventsState = appEventCollection.get(next);
                        if (sessionEventsState != null) {
                            readAndClearStore.addEvents(next, sessionEventsState.getEventsToPersist());
                        } else {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                    }
                    saveEventsToDisk$facebook_core_release(readAndClearStore);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }
}
