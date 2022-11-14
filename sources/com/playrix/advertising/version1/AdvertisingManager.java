package com.playrix.advertising.version1;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.playrix.advertising.version1.ProviderCallbacks;
import com.playrix.engine.Advertising;
import com.playrix.engine.Engine;
import com.playrix.engine.EngineActivity;
import com.playrix.engine.NativeThread;

public class AdvertisingManager implements Advertising.Interface {
    public final ProviderInterface[] _providers;

    public static void createActivityLifecycleCallbacks() {
        Engine.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof EngineActivity) {
                    Engine.getActivity().registerActivityLifecycleCallbacks(Advertising.getInstance());
                }
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
            }
        });
    }

    public static boolean initialize() {
        return NativeThread.getInstance().queueInitalizeEvent(new Runnable() {
            public void run() {
                Advertising.initialize(new AdvertisingManager());
                AdvertisingManager.createActivityLifecycleCallbacks();
            }
        });
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        ProviderInterface[] providerInterfaceArr = this._providers;
        if (providerInterfaceArr != null) {
            for (ProviderInterface onCreate : providerInterfaceArr) {
                onCreate.onCreate(activity);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        ProviderInterface[] providerInterfaceArr = this._providers;
        if (providerInterfaceArr != null) {
            for (ProviderInterface onDestroy : providerInterfaceArr) {
                onDestroy.onDestroy(activity);
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        ProviderInterface[] providerInterfaceArr = this._providers;
        if (providerInterfaceArr != null) {
            for (ProviderInterface onPause : providerInterfaceArr) {
                onPause.onPause(activity);
            }
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        ProviderInterface[] providerInterfaceArr = this._providers;
        if (providerInterfaceArr != null) {
            for (ProviderInterface onActivityResult : providerInterfaceArr) {
                if (onActivityResult.onActivityResult(i, i2, intent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onActivityResumed(Activity activity) {
        ProviderInterface[] providerInterfaceArr = this._providers;
        if (providerInterfaceArr != null) {
            for (ProviderInterface onResume : providerInterfaceArr) {
                onResume.onResume(activity);
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        ProviderInterface[] providerInterfaceArr = this._providers;
        if (providerInterfaceArr != null) {
            for (ProviderInterface onStart : providerInterfaceArr) {
                onStart.onStart(activity);
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        ProviderInterface[] providerInterfaceArr = this._providers;
        if (providerInterfaceArr != null) {
            for (ProviderInterface onStop : providerInterfaceArr) {
                onStop.onStop(activity);
            }
        }
    }

    public boolean onBackPressed(Activity activity) {
        ProviderInterface[] providerInterfaceArr = this._providers;
        if (providerInterfaceArr != null) {
            for (ProviderInterface onBackPressed : providerInterfaceArr) {
                if (onBackPressed.onBackPressed(activity)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onLowMemory() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void setImmersiveMode(boolean z) {
        ProviderInterface[] providerInterfaceArr = this._providers;
        if (providerInterfaceArr != null) {
            for (ProviderInterface immersiveMode : providerInterfaceArr) {
                immersiveMode.setImmersiveMode(z);
            }
        }
    }

    public AdvertisingManager() {
        this._providers = ProviderCallbacks.getProviders();
        ProviderCallbacks.setCall(new ProviderCallbacks.Call() {
            public void run(Runnable runnable) {
                Engine.runOnGLThread(runnable);
            }
        });
    }
}
