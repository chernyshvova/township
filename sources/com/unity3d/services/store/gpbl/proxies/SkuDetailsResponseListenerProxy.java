package com.unity3d.services.store.gpbl.proxies;

import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import com.unity3d.services.core.reflection.GenericListenerProxy;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsBridge;
import com.unity3d.services.store.listeners.ISkuDetailsResponseListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SkuDetailsResponseListenerProxy extends GenericListenerProxy {
    public static final String onSkuDetailsResponseMethodName = "onSkuDetailsResponse";
    public ISkuDetailsResponseListener _skuDetailsResponseListener;

    public SkuDetailsResponseListenerProxy(ISkuDetailsResponseListener iSkuDetailsResponseListener) {
        this._skuDetailsResponseListener = iSkuDetailsResponseListener;
    }

    public static Class<?> getProxyListenerClass() throws ClassNotFoundException {
        return Class.forName(InAppPurchaseBillingClientWrapper.CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER);
    }

    public Class<?> getProxyClass() throws ClassNotFoundException {
        return getProxyListenerClass();
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!method.getName().equals("onSkuDetailsResponse")) {
            return super.invoke(obj, method, objArr);
        }
        onSkuDetailsResponse(objArr[0], objArr[1]);
        return null;
    }

    public void onSkuDetailsResponse(Object obj, List<Object> list) {
        ArrayList arrayList;
        if (list != null) {
            arrayList = new ArrayList();
            for (Object skuDetailsBridge : list) {
                arrayList.add(new SkuDetailsBridge(skuDetailsBridge));
            }
        } else {
            arrayList = null;
        }
        ISkuDetailsResponseListener iSkuDetailsResponseListener = this._skuDetailsResponseListener;
        if (iSkuDetailsResponseListener != null) {
            iSkuDetailsResponseListener.onBillingResponse(new BillingResultBridge(obj), arrayList);
        }
    }
}
