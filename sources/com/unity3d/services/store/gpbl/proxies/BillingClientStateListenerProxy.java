package com.unity3d.services.store.gpbl.proxies;

import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import com.unity3d.services.core.reflection.GenericListenerProxy;
import com.unity3d.services.store.gpbl.IBillingClientStateListener;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import java.lang.reflect.Method;

public class BillingClientStateListenerProxy extends GenericListenerProxy {
    public static String onBillingServiceDisconnectedMethodName = "onBillingServiceDisconnected";
    public static String onBillingSetupFinishedMethodName = "onBillingSetupFinished";
    public IBillingClientStateListener _billingClientStateListener;

    public BillingClientStateListenerProxy(IBillingClientStateListener iBillingClientStateListener) {
        this._billingClientStateListener = iBillingClientStateListener;
    }

    public static Class<?> getProxyListenerClass() throws ClassNotFoundException {
        return Class.forName(InAppPurchaseBillingClientWrapper.CLASSNAME_BILLING_CLIENT_STATE_LISTENER);
    }

    private void onBillingServiceDisconnected() {
        IBillingClientStateListener iBillingClientStateListener = this._billingClientStateListener;
        if (iBillingClientStateListener != null) {
            iBillingClientStateListener.onBillingServiceDisconnected();
        }
    }

    private void onBillingSetupFinished(Object obj) {
        IBillingClientStateListener iBillingClientStateListener = this._billingClientStateListener;
        if (iBillingClientStateListener != null) {
            iBillingClientStateListener.onBillingSetupFinished(new BillingResultBridge(obj));
        }
    }

    public Class<?> getProxyClass() throws ClassNotFoundException {
        return getProxyListenerClass();
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getName().equals(onBillingSetupFinishedMethodName)) {
            onBillingSetupFinished(objArr[0]);
        } else if (!method.getName().equals(onBillingServiceDisconnectedMethodName)) {
            return super.invoke(obj, method, objArr);
        } else {
            onBillingServiceDisconnected();
        }
        return null;
    }
}
