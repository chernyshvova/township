package com.vungle.warren.utility;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ActivityManager implements Application.ActivityLifecycleCallbacks {
    @VisibleForTesting
    public static final long CONFIG_CHANGE_DELAY = 700;
    public static final String TAG = ActivityManager.class.getSimpleName();
    @VisibleForTesting
    public static final long TIMEOUT = 3000;
    public static final ActivityManager instance = new ActivityManager();
    public ConcurrentHashMap<LeftApplicationCallback, LifeCycleCallback> adLeftCallbacks = new ConcurrentHashMap<>();
    public CopyOnWriteArraySet<LifeCycleCallback> callbacks = new CopyOnWriteArraySet<>();
    public Runnable configChangeRunnable = new Runnable() {
        public void run() {
            if (ActivityManager.this.resumed == 0 && !ActivityManager.this.paused) {
                boolean unused = ActivityManager.this.paused = true;
                Iterator it = ActivityManager.this.callbacks.iterator();
                while (it.hasNext()) {
                    ((LifeCycleCallback) it.next()).onPause();
                }
            }
            if (ActivityManager.this.started == 0 && ActivityManager.this.paused && !ActivityManager.this.stopped) {
                boolean unused2 = ActivityManager.this.stopped = true;
                Iterator it2 = ActivityManager.this.callbacks.iterator();
                while (it2.hasNext()) {
                    ((LifeCycleCallback) it2.next()).onStop();
                }
            }
        }
    };
    public Handler handler;
    public boolean initialized;
    public boolean paused = true;
    public int resumed;
    public int started;
    public boolean stopped = true;

    public interface LeftApplicationCallback {
        void onLeftApplication();
    }

    public static class LifeCycleCallback {
        public void onPause() {
        }

        public void onResume() {
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    public static ActivityManager getInstance() {
        return instance;
    }

    /* access modifiers changed from: private */
    public void removeListener(LifeCycleCallback lifeCycleCallback) {
        this.callbacks.remove(lifeCycleCallback);
    }

    /* access modifiers changed from: private */
    public void removeOnNextAppLeftCallback(@Nullable LeftApplicationCallback leftApplicationCallback) {
        LifeCycleCallback remove;
        if (leftApplicationCallback != null && (remove = this.adLeftCallbacks.remove(leftApplicationCallback)) != null) {
            removeListener(remove);
        }
    }

    public static boolean startActivityHandleException(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            String str = TAG;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Cannot find activity to handle the Implicit intent: ");
            outline24.append(e.getLocalizedMessage());
            Log.e(str, outline24.toString());
            return false;
        }
    }

    public static void startWhenForeground(Context context, final Intent intent, @Nullable final LeftApplicationCallback leftApplicationCallback) {
        final WeakReference weakReference = new WeakReference(context);
        if (!instance.inForeground()) {
            instance.addListener(new LifeCycleCallback() {
                public void onStart() {
                    super.onStart();
                    ActivityManager.instance.removeListener(this);
                    Context context = (Context) weakReference.get();
                    if (context != null && ActivityManager.startActivityHandleException(context, intent)) {
                        ActivityManager.instance.addOnNextAppLeftCallback(leftApplicationCallback);
                    }
                }
            });
        } else if (startActivityHandleException(context, intent)) {
            instance.addOnNextAppLeftCallback(leftApplicationCallback);
        }
    }

    public void addListener(LifeCycleCallback lifeCycleCallback) {
        this.callbacks.add(lifeCycleCallback);
    }

    public void addOnNextAppLeftCallback(@Nullable LeftApplicationCallback leftApplicationCallback) {
        if (leftApplicationCallback != null) {
            if (!this.initialized) {
                leftApplicationCallback.onLeftApplication();
                return;
            }
            final WeakReference weakReference = new WeakReference(leftApplicationCallback);
            final C20453 r1 = new Runnable() {
                public void run() {
                    ActivityManager.this.handler.removeCallbacks(this);
                    ActivityManager.this.removeOnNextAppLeftCallback((LeftApplicationCallback) weakReference.get());
                }
            };
            C20464 r2 = new LifeCycleCallback() {
                public boolean wasPaused = false;

                public void onPause() {
                    super.onPause();
                    this.wasPaused = true;
                    ActivityManager.this.handler.removeCallbacks(r1);
                }

                public void onResume() {
                    super.onResume();
                    ActivityManager.this.handler.postDelayed(r1, 1400);
                }

                public void onStop() {
                    super.onStop();
                    LeftApplicationCallback leftApplicationCallback = (LeftApplicationCallback) weakReference.get();
                    if (this.wasPaused && leftApplicationCallback != null && ActivityManager.this.adLeftCallbacks.containsKey(leftApplicationCallback)) {
                        leftApplicationCallback.onLeftApplication();
                    }
                    ActivityManager.this.removeOnNextAppLeftCallback(leftApplicationCallback);
                    ActivityManager.this.handler.removeCallbacks(r1);
                }
            };
            this.adLeftCallbacks.put(leftApplicationCallback, r2);
            if (inForeground()) {
                this.handler.postDelayed(r1, 3000);
                addListener(r2);
                return;
            }
            getInstance().addListener(new LifeCycleCallback() {
                public void onStart() {
                    ActivityManager.instance.removeListener(this);
                    LifeCycleCallback lifeCycleCallback = (LifeCycleCallback) ActivityManager.this.adLeftCallbacks.get(weakReference.get());
                    if (lifeCycleCallback != null) {
                        ActivityManager.this.handler.postDelayed(r1, 3000);
                        ActivityManager.this.addListener(lifeCycleCallback);
                    }
                }
            });
        }
    }

    @VisibleForTesting
    public void deInit(Context context) {
        ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
        this.started = 0;
        this.resumed = 0;
        this.paused = true;
        this.stopped = true;
        this.initialized = false;
        this.callbacks.clear();
        this.adLeftCallbacks.clear();
    }

    @VisibleForTesting
    public boolean inForeground() {
        return !this.initialized || this.started > 0;
    }

    public void init(Context context) {
        if (!this.initialized) {
            this.handler = new Handler(Looper.getMainLooper());
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
            this.initialized = true;
        }
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    public void onActivityPaused(@NonNull Activity activity) {
        this.resumed = Math.max(0, this.resumed - 1);
        this.handler.postDelayed(this.configChangeRunnable, 700);
    }

    public void onActivityResumed(@NonNull Activity activity) {
        int i = this.resumed + 1;
        this.resumed = i;
        if (i != 1) {
            return;
        }
        if (this.paused) {
            this.paused = false;
            Iterator<LifeCycleCallback> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onResume();
            }
            return;
        }
        this.handler.removeCallbacks(this.configChangeRunnable);
    }

    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    public void onActivityStarted(@NonNull Activity activity) {
        int i = this.started + 1;
        this.started = i;
        if (i == 1 && this.stopped) {
            this.stopped = false;
            Iterator<LifeCycleCallback> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onStart();
            }
        }
    }

    public void onActivityStopped(@NonNull Activity activity) {
        this.started = Math.max(0, this.started - 1);
        this.handler.postDelayed(this.configChangeRunnable, 700);
    }
}
