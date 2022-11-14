package com.unity3d.services.store.gpbl.proxies;

import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import com.unity3d.services.core.reflection.GenericListenerProxy;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseHistoryRecordBridge;
import com.unity3d.services.store.listeners.IPurchaseHistoryResponseListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class PurchaseHistoryResponseListenerProxy extends GenericListenerProxy {
    public static final String onPurchaseHistoryResponseMethodName = "onPurchaseHistoryResponse";
    public int _maxPurchases;
    public IPurchaseHistoryResponseListener _purchaseUpdatedResponseListener;

    public PurchaseHistoryResponseListenerProxy(IPurchaseHistoryResponseListener iPurchaseHistoryResponseListener, int i) {
        this._purchaseUpdatedResponseListener = iPurchaseHistoryResponseListener;
        this._maxPurchases = i;
    }

    public static Class<?> getProxyListenerClass() throws ClassNotFoundException {
        return Class.forName(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER);
    }

    public Class<?> getProxyClass() throws ClassNotFoundException {
        return getProxyListenerClass();
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!method.getName().equals("onPurchaseHistoryResponse")) {
            return super.invoke(obj, method, objArr);
        }
        onPurchaseHistoryResponse(objArr[0], objArr[1]);
        return null;
    }

    public void onPurchaseHistoryResponse(Object obj, List<Object> list) {
        ArrayList arrayList;
        if (list != null) {
            arrayList = new ArrayList();
            int i = 0;
            while (i < this._maxPurchases && i < list.size()) {
                arrayList.add(new PurchaseHistoryRecordBridge(list.get(i)));
                i++;
            }
        } else {
            arrayList = null;
        }
        IPurchaseHistoryResponseListener iPurchaseHistoryResponseListener = this._purchaseUpdatedResponseListener;
        if (iPurchaseHistoryResponseListener != null) {
            iPurchaseHistoryResponseListener.onBillingResponse(new BillingResultBridge(obj), arrayList);
        }
    }
}
