package com.unity3d.services.store.gpbl.bridges;

import android.content.Context;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import com.unity3d.services.core.reflection.GenericBridge;
import com.unity3d.services.store.gpbl.BillingResultResponseCode;
import com.unity3d.services.store.gpbl.proxies.BillingClientStateListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchaseHistoryResponseListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchaseUpdatedListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchasesResponseListenerProxy;
import com.unity3d.services.store.gpbl.proxies.SkuDetailsResponseListenerProxy;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BillingClientBridge extends GenericBridge {
    public static final String endConnectionMethodName = "endConnection";
    public static final String isFeatureSupportedMethodName = "isFeatureSupported";
    public static final String isReadyMethodName = "isReady";
    public static final String newBuilderMethodName = "newBuilder";
    public static final String queryPurchaseHistoryAsyncMethodName = "queryPurchaseHistoryAsync";
    public static final String queryPurchasesAsyncMethodName = "queryPurchasesAsync";
    public static final String querySkuDetailsAsyncMethodName = "querySkuDetailsAsync";
    public static final String startConnectionMethodName = "startConnection";
    public static final Map<String, Class<?>[]> staticMethods = new HashMap<String, Class<?>[]>() {
        {
            put("newBuilder", new Class[]{Context.class});
        }
    };
    public final Object _billingClientInternalInstance;

    public static class BuilderBridge extends GenericBridge {
        public static final String buildMethodName = "build";
        public static final String enablePendingPurchasesMethodName = "enablePendingPurchases";
        public static final String setListenerMethodName = "setListener";
        public Object _billingClientBuilderInternalInstance;

        public BuilderBridge(Object obj) throws ClassNotFoundException {
            super(new HashMap<String, Class[]>() {
                {
                    put("setListener", new Class[]{PurchaseUpdatedListenerProxy.getProxyListenerClass()});
                    put("enablePendingPurchases", new Class[0]);
                    put("build", new Class[0]);
                }
            });
            this._billingClientBuilderInternalInstance = obj;
        }

        public BillingClientBridge build() throws ClassNotFoundException {
            return new BillingClientBridge(callNonVoidMethod("build", this._billingClientBuilderInternalInstance, new Object[0]));
        }

        public BuilderBridge enablePendingPurchases() {
            this._billingClientBuilderInternalInstance = callNonVoidMethod("enablePendingPurchases", this._billingClientBuilderInternalInstance, new Object[0]);
            return this;
        }

        public String getClassName() {
            return InAppPurchaseBillingClientWrapper.CLASSNAME_BILLING_CLIENT_BUILDER;
        }

        public BuilderBridge setListener(PurchaseUpdatedListenerProxy purchaseUpdatedListenerProxy) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            this._billingClientBuilderInternalInstance = callNonVoidMethod("setListener", this._billingClientBuilderInternalInstance, purchaseUpdatedListenerProxy.getProxyInstance());
            return this;
        }
    }

    public BillingClientBridge(Object obj) throws ClassNotFoundException {
        super(new HashMap<String, Class[]>() {
            {
                Class<String> cls = String.class;
                put("newBuilder", new Class[]{Context.class});
                put("startConnection", new Class[]{BillingClientStateListenerProxy.getProxyListenerClass()});
                put(BillingClientBridge.endConnectionMethodName, new Class[0]);
                put("querySkuDetailsAsync", new Class[]{SkuDetailsParamsBridge.getClassForBridge(), SkuDetailsResponseListenerProxy.getProxyListenerClass()});
                put("queryPurchaseHistoryAsync", new Class[]{cls, PurchaseHistoryResponseListenerProxy.getProxyListenerClass()});
                put(BillingClientBridge.queryPurchasesAsyncMethodName, new Class[]{cls, PurchasesResponseListenerProxy.getProxyListenerClass()});
                put(BillingClientBridge.isFeatureSupportedMethodName, new Class[]{cls});
                put(BillingClientBridge.isReadyMethodName, new Class[0]);
            }
        });
        this._billingClientInternalInstance = obj;
    }

    public static Object callNonVoidStaticMethod(String str, Object... objArr) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        return getClassForBridge().getMethod(str, (Class[]) staticMethods.get(str)).invoke((Object) null, objArr);
    }

    public static Class<?> getClassForBridge() throws ClassNotFoundException {
        return Class.forName(InAppPurchaseBillingClientWrapper.CLASSNAME_BILLING_CLIENT);
    }

    public static BuilderBridge newBuilder(Context context) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        return new BuilderBridge(callNonVoidStaticMethod("newBuilder", context));
    }

    public void endConnection() {
        callVoidMethod(endConnectionMethodName, this._billingClientInternalInstance, new Object[0]);
    }

    public String getClassName() {
        return InAppPurchaseBillingClientWrapper.CLASSNAME_BILLING_CLIENT;
    }

    public BillingResultResponseCode isFeatureSupported(String str) {
        return new BillingResultBridge(callNonVoidMethod(isFeatureSupportedMethodName, this._billingClientInternalInstance, str)).getResponseCode();
    }

    public boolean isReady() {
        return ((Boolean) callNonVoidMethod(isReadyMethodName, this._billingClientInternalInstance, new Object[0])).booleanValue();
    }

    public void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListenerProxy purchaseHistoryResponseListenerProxy) throws ClassNotFoundException {
        callVoidMethod("queryPurchaseHistoryAsync", this._billingClientInternalInstance, str, purchaseHistoryResponseListenerProxy.getProxyInstance());
    }

    public void queryPurchasesAsync(String str, PurchasesResponseListenerProxy purchasesResponseListenerProxy) throws ClassNotFoundException {
        callVoidMethod(queryPurchasesAsyncMethodName, this._billingClientInternalInstance, str, purchasesResponseListenerProxy.getProxyInstance());
    }

    public void querySkuDetailsAsync(SkuDetailsParamsBridge skuDetailsParamsBridge, SkuDetailsResponseListenerProxy skuDetailsResponseListenerProxy) throws ClassNotFoundException {
        callVoidMethod("querySkuDetailsAsync", this._billingClientInternalInstance, skuDetailsParamsBridge.getInternalInstance(), skuDetailsResponseListenerProxy.getProxyInstance());
    }

    public void startConnection(BillingClientStateListenerProxy billingClientStateListenerProxy) throws ClassNotFoundException {
        callVoidMethod("startConnection", this._billingClientInternalInstance, billingClientStateListenerProxy.getProxyInstance());
    }
}
