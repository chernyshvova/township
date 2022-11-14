package com.google.firebase.messaging;

import android.content.SharedPreferences;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final class TopicsStore {
    @GuardedBy("TopicsStore.class")
    public static WeakReference<TopicsStore> topicsStoreWeakReference;
    public final SharedPreferences sharedPreferences;
    public final Executor syncExecutor;
    public SharedPreferencesQueue topicOperationsQueue;

    public TopicsStore(SharedPreferences sharedPreferences2, Executor executor) {
        this.syncExecutor = executor;
        this.sharedPreferences = sharedPreferences2;
    }

    @Nullable
    public final synchronized TopicOperation getNextTopicOperation() {
        String peek;
        SharedPreferencesQueue sharedPreferencesQueue = this.topicOperationsQueue;
        synchronized (sharedPreferencesQueue.internalQueue) {
            peek = sharedPreferencesQueue.internalQueue.peek();
        }
        return TopicOperation.from(peek);
    }
}
