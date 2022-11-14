package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaa extends ActivityLifecycleObserver {
    public final WeakReference<C3365zaa> zaa;

    @VisibleForTesting(otherwise = 2)
    /* renamed from: com.google.android.gms.common.api.internal.zaa$zaa  reason: collision with other inner class name */
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static class C3365zaa extends LifecycleCallback {
        public List<Runnable> zaa = new ArrayList();

        public C3365zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* access modifiers changed from: private */
        public final synchronized void zaa(Runnable runnable) {
            this.zaa.add(runnable);
        }

        public static C3365zaa zab(Activity activity) {
            C3365zaa zaa2;
            synchronized (activity) {
                LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                zaa2 = (C3365zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C3365zaa.class);
                if (zaa2 == null) {
                    zaa2 = new C3365zaa(fragment);
                }
            }
            return zaa2;
        }

        @MainThread
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zaa;
                this.zaa = new ArrayList();
            }
            for (Runnable run : list) {
                run.run();
            }
        }
    }

    public zaa(Activity activity) {
        this(C3365zaa.zab(activity));
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C3365zaa zaa2 = (C3365zaa) this.zaa.get();
        if (zaa2 != null) {
            zaa2.zaa(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }

    @VisibleForTesting(otherwise = 2)
    public zaa(C3365zaa zaa2) {
        this.zaa = new WeakReference<>(zaa2);
    }
}
