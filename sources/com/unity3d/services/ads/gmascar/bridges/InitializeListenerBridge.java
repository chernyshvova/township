package com.unity3d.services.ads.gmascar.bridges;

import com.unity3d.services.ads.gmascar.listeners.IInitializationStatusListener;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.reflection.GenericBridge;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class InitializeListenerBridge extends GenericBridge {
    public static final String initializationCompleteMethodName = "onInitializationComplete";
    public IInitializationStatusListener _initializationStatusListener;

    public InitializeListenerBridge() {
        super(new HashMap<String, Class[]>() {
            {
                try {
                    put(InitializeListenerBridge.initializationCompleteMethodName, new Class[]{Class.forName("com.google.android.gms.ads.initialization.InitializationStatus")});
                } catch (ClassNotFoundException e) {
                    DeviceLog.debug("Could not find class \"com.google.android.gms.ads.initialization.InitializationStatus\" %s", e.getLocalizedMessage());
                }
            }
        });
    }

    public Object createInitializeListenerProxy() {
        try {
            return Proxy.newProxyInstance(classForName().getClassLoader(), new Class[]{classForName()}, new InvocationHandler() {
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if (!method.getName().equals(InitializeListenerBridge.initializationCompleteMethodName) || InitializeListenerBridge.this._initializationStatusListener == null) {
                        return null;
                    }
                    InitializeListenerBridge.this._initializationStatusListener.onInitializationComplete(objArr[0]);
                    return null;
                }
            });
        } catch (Exception unused) {
            DeviceLog.debug("ERROR: Could not create InitializeCompletionListener");
            return null;
        }
    }

    public String getClassName() {
        return "com.google.android.gms.ads.initialization.OnInitializationCompleteListener";
    }

    public void setStatusListener(IInitializationStatusListener iInitializationStatusListener) {
        this._initializationStatusListener = iInitializationStatusListener;
    }
}
