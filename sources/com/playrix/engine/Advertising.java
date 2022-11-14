package com.playrix.engine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.playrix.engine.LifeCycleActivity;

public class Advertising {
    public static Interface _instance = new NullInterface();

    public interface Interface extends LifeCycleActivity.ILifecycleCallbacks {
        void onActivityCreated(Activity activity, Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);

        boolean onBackPressed(Activity activity);

        void setImmersiveMode(boolean z);
    }

    public static class NullInterface implements Interface {
        public NullInterface() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public boolean onActivityResult(int i, int i2, Intent intent) {
            return false;
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public boolean onBackPressed(Activity activity) {
            return false;
        }

        public void onLowMemory() {
        }

        public void onNewIntent(Intent intent) {
        }

        public void setImmersiveMode(boolean z) {
        }
    }

    public static Interface getInstance() {
        return _instance;
    }

    public static void initialize(Interface interfaceR) {
        _instance = interfaceR;
    }
}
