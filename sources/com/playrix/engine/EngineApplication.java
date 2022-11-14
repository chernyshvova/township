package com.playrix.engine;

import androidx.multidex.MultiDexApplication;

public class EngineApplication extends MultiDexApplication {
    public void onCreate() {
        super.onCreate();
        Engine.setApplicationContext(this);
        if (NativeThread.getInstance().loadNativeLibraries()) {
            Engine.registerThermalStatusListener();
            Engine.requestAdvertisingId();
            Engine.enableTls12();
        }
    }
}
