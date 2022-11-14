package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.Metadata;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public class FirebaseMessaging {
    @VisibleForTesting
    @SuppressLint({"FirebaseUnknownNullness"})
    @Nullable
    public static TransportFactory transportFactory;
    public final AutoInit autoInit;
    public final Context context;
    public final Executor fileIoExecutor;
    public final FirebaseApp firebaseApp;
    public final FirebaseInstanceId iid;
    public final Task<TopicsSubscriber> topicsSubscriberTask;

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public class AutoInit {
        @GuardedBy("this")
        @Nullable
        public Boolean autoInitEnabled;
        @GuardedBy("this")
        @Nullable
        public EventHandler<DataCollectionDefaultChange> dataCollectionDefaultChangeEventHandler;
        @GuardedBy("this")
        public boolean initialized;
        public final Subscriber subscriber;

        public AutoInit(Subscriber subscriber2) {
            this.subscriber = subscriber2;
        }

        public synchronized void initialize() {
            if (!this.initialized) {
                Boolean readEnabled = readEnabled();
                this.autoInitEnabled = readEnabled;
                if (readEnabled == null) {
                    FirebaseMessaging$AutoInit$$Lambda$0 firebaseMessaging$AutoInit$$Lambda$0 = new FirebaseMessaging$AutoInit$$Lambda$0(this);
                    this.dataCollectionDefaultChangeEventHandler = firebaseMessaging$AutoInit$$Lambda$0;
                    this.subscriber.subscribe(DataCollectionDefaultChange.class, firebaseMessaging$AutoInit$$Lambda$0);
                }
                this.initialized = true;
            }
        }

        public synchronized boolean isEnabled() {
            initialize();
            if (this.autoInitEnabled != null) {
                return this.autoInitEnabled.booleanValue();
            }
            FirebaseApp firebaseApp = FirebaseMessaging.this.firebaseApp;
            firebaseApp.checkNotDeleted();
            return firebaseApp.dataCollectionConfigStorage.get().dataCollectionDefaultEnabled.get();
        }

        @Nullable
        public final Boolean readEnabled() {
            ApplicationInfo applicationInfo;
            FirebaseApp firebaseApp = FirebaseMessaging.this.firebaseApp;
            firebaseApp.checkNotDeleted();
            Context context = firebaseApp.applicationContext;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
    }

    public FirebaseMessaging(FirebaseApp firebaseApp2, FirebaseInstanceId firebaseInstanceId, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable TransportFactory transportFactory2, Subscriber subscriber) {
        FirebaseApp firebaseApp3 = firebaseApp2;
        FirebaseInstanceId firebaseInstanceId2 = firebaseInstanceId;
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceIdReceiver");
            transportFactory = transportFactory2;
            this.firebaseApp = firebaseApp3;
            this.iid = firebaseInstanceId2;
            this.autoInit = new AutoInit(subscriber);
            firebaseApp2.checkNotDeleted();
            this.context = firebaseApp3.applicationContext;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Init"));
            this.fileIoExecutor = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.execute(new FirebaseMessaging$$Lambda$0(this, firebaseInstanceId));
            Task<TopicsSubscriber> createInstance = TopicsSubscriber.createInstance(firebaseApp2, firebaseInstanceId, new Metadata(this.context), provider, provider2, firebaseInstallationsApi, this.context, new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io")));
            this.topicsSubscriberTask = createInstance;
            createInstance.addOnSuccessListener((Executor) new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("Firebase-Messaging-Trigger-Topics-Io")), (OnSuccessListener<? super TopicsSubscriber>) new FirebaseMessaging$$Lambda$1(this));
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("FirebaseMessaging and FirebaseInstanceId versions not compatible. Update to latest version of firebase-messaging.");
        }
    }

    @NonNull
    @Keep
    public static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp firebaseApp2) {
        FirebaseMessaging firebaseMessaging;
        Class cls = FirebaseMessaging.class;
        synchronized (cls) {
            firebaseApp2.checkNotDeleted();
            firebaseMessaging = (FirebaseMessaging) firebaseApp2.componentRuntime.get(cls);
            Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }
}
