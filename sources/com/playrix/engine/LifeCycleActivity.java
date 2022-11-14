package com.playrix.engine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;

public class LifeCycleActivity extends FragmentActivity {
    public ArrayList<ILifecycleCallbacks> mActivityLifecycleCallbacks = new ArrayList<>();

    public interface ILifecycleCallbacks {
        void onActivityCreated(Activity activity, Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        boolean onActivityResult(int i, int i2, Intent intent);

        void onActivityResumed(Activity activity);

        void onActivitySaveInstanceState(Activity activity, Bundle bundle);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);

        void onLowMemory();

        void onNewIntent(Intent intent);
    }

    private ILifecycleCallbacks[] collectActivityLifecycleCallbacks() {
        ILifecycleCallbacks[] iLifecycleCallbacksArr;
        synchronized (this.mActivityLifecycleCallbacks) {
            iLifecycleCallbacksArr = this.mActivityLifecycleCallbacks.size() > 0 ? (ILifecycleCallbacks[]) this.mActivityLifecycleCallbacks.toArray(new ILifecycleCallbacks[0]) : null;
        }
        return iLifecycleCallbacksArr;
    }

    public void callOnLowMemory() {
        ILifecycleCallbacks[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ILifecycleCallbacks onLowMemory : collectActivityLifecycleCallbacks) {
                onLowMemory.onLowMemory();
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ILifecycleCallbacks[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            int length = collectActivityLifecycleCallbacks.length;
            int i3 = 0;
            while (i3 < length && !collectActivityLifecycleCallbacks[i3].onActivityResult(i, i2, intent)) {
                i3++;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ILifecycleCallbacks[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ILifecycleCallbacks onActivityCreated : collectActivityLifecycleCallbacks) {
                onActivityCreated.onActivityCreated(this, bundle);
            }
        }
    }

    public void onDestroy() {
        ILifecycleCallbacks[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ILifecycleCallbacks onActivityDestroyed : collectActivityLifecycleCallbacks) {
                onActivityDestroyed.onActivityDestroyed(this);
            }
        }
        super.onDestroy();
    }

    public void onLowMemory() {
        callOnLowMemory();
        super.onLowMemory();
    }

    public void onNewIntent(Intent intent) {
        ILifecycleCallbacks[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ILifecycleCallbacks onNewIntent : collectActivityLifecycleCallbacks) {
                onNewIntent.onNewIntent(intent);
            }
        }
        super.onNewIntent(intent);
    }

    public void onPause() {
        ILifecycleCallbacks[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ILifecycleCallbacks onActivityPaused : collectActivityLifecycleCallbacks) {
                onActivityPaused.onActivityPaused(this);
            }
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        ILifecycleCallbacks[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ILifecycleCallbacks onActivityResumed : collectActivityLifecycleCallbacks) {
                onActivityResumed.onActivityResumed(this);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        ILifecycleCallbacks[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ILifecycleCallbacks onActivitySaveInstanceState : collectActivityLifecycleCallbacks) {
                onActivitySaveInstanceState.onActivitySaveInstanceState(this, bundle);
            }
        }
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        ILifecycleCallbacks[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ILifecycleCallbacks onActivityStarted : collectActivityLifecycleCallbacks) {
                onActivityStarted.onActivityStarted(this);
            }
        }
    }

    public void onStop() {
        ILifecycleCallbacks[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (ILifecycleCallbacks onActivityStopped : collectActivityLifecycleCallbacks) {
                onActivityStopped.onActivityStopped(this);
            }
        }
        super.onStop();
    }

    public void registerActivityLifecycleCallbacks(ILifecycleCallbacks iLifecycleCallbacks) {
        synchronized (this.mActivityLifecycleCallbacks) {
            this.mActivityLifecycleCallbacks.add(iLifecycleCallbacks);
        }
    }

    public void unregisterActivityLifecycleCallbacks(ILifecycleCallbacks iLifecycleCallbacks) {
        synchronized (this.mActivityLifecycleCallbacks) {
            this.mActivityLifecycleCallbacks.remove(iLifecycleCallbacks);
        }
    }
}
