package com.facebook.appevents.iap;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.PaintCompat;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.vungle.warren.log.LogEntry;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: InAppPurchaseBillingClientWrapper.kt */
public final class InAppPurchaseBillingClientWrapper {
    public static final String CLASSNAME_BILLING_CLIENT = "com.android.billingclient.api.BillingClient";
    public static final String CLASSNAME_BILLING_CLIENT_BUILDER = "com.android.billingclient.api.BillingClient$Builder";
    public static final String CLASSNAME_BILLING_CLIENT_STATE_LISTENER = "com.android.billingclient.api.BillingClientStateListener";
    public static final String CLASSNAME_PURCHASE = "com.android.billingclient.api.Purchase";
    public static final String CLASSNAME_PURCHASES_RESULT = "com.android.billingclient.api.Purchase$PurchasesResult";
    public static final String CLASSNAME_PURCHASE_HISTORY_RECORD = "com.android.billingclient.api.PurchaseHistoryRecord";
    public static final String CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER = "com.android.billingclient.api.PurchaseHistoryResponseListener";
    public static final String CLASSNAME_PURCHASE_UPDATED_LISTENER = "com.android.billingclient.api.PurchasesUpdatedListener";
    public static final String CLASSNAME_SKU_DETAILS = "com.android.billingclient.api.SkuDetails";
    public static final String CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER = "com.android.billingclient.api.SkuDetailsResponseListener";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String IN_APP = "inapp";
    public static final String METHOD_BUILD = "build";
    public static final String METHOD_ENABLE_PENDING_PURCHASES = "enablePendingPurchases";
    public static final String METHOD_GET_ORIGINAL_JSON = "getOriginalJson";
    public static final String METHOD_GET_PURCHASE_LIST = "getPurchasesList";
    public static final String METHOD_NEW_BUILDER = "newBuilder";
    public static final String METHOD_ON_BILLING_SERVICE_DISCONNECTED = "onBillingServiceDisconnected";
    public static final String METHOD_ON_BILLING_SETUP_FINISHED = "onBillingSetupFinished";
    public static final String METHOD_ON_PURCHASE_HISTORY_RESPONSE = "onPurchaseHistoryResponse";
    public static final String METHOD_ON_SKU_DETAILS_RESPONSE = "onSkuDetailsResponse";
    public static final String METHOD_QUERY_PURCHASES = "queryPurchases";
    public static final String METHOD_QUERY_PURCHASE_HISTORY_ASYNC = "queryPurchaseHistoryAsync";
    public static final String METHOD_QUERY_SKU_DETAILS_ASYNC = "querySkuDetailsAsync";
    public static final String METHOD_SET_LISTENER = "setListener";
    public static final String METHOD_START_CONNECTION = "startConnection";
    public static final String PACKAGE_NAME = "packageName";
    public static final String PRODUCT_ID = "productId";
    public static final AtomicBoolean initialized = new AtomicBoolean(false);
    public static InAppPurchaseBillingClientWrapper instance;
    public static final AtomicBoolean isServiceConnected = new AtomicBoolean(false);
    public static final Map<String, JSONObject> purchaseDetailsMap = new ConcurrentHashMap();
    public static final Map<String, JSONObject> skuDetailsMap = new ConcurrentHashMap();
    public final Object billingClient;
    public final Class<?> billingClientClazz;
    public final Context context;
    public final Method getOriginalJsonMethod;
    public final Method getOriginalJsonPurchaseHistoryMethod;
    public final Method getOriginalJsonSkuMethod;
    public final Method getPurchaseListMethod;
    public final Set<String> historyPurchaseSet;
    public final InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper;
    public final Class<?> purchaseClazz;
    public final Class<?> purchaseHistoryRecordClazz;
    public final Class<?> purchaseHistoryResponseListenerClazz;
    public final Class<?> purchaseResultClazz;
    public final Method queryPurchaseHistoryAsyncMethod;
    public final Method queryPurchasesMethod;
    public final Method querySkuDetailsAsyncMethod;
    public final Class<?> skuDetailsClazz;
    public final Class<?> skuDetailsResponseListenerClazz;

    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    public static final class BillingClientStateListenerWrapper implements InvocationHandler {
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(obj, "proxy");
                Intrinsics.checkNotNullParameter(method, PaintCompat.EM_STRING);
                if (Intrinsics.areEqual(method.getName(), InAppPurchaseBillingClientWrapper.METHOD_ON_BILLING_SETUP_FINISHED)) {
                    InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().set(true);
                } else {
                    String name = method.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "m.name");
                    if (CharsKt__CharKt.endsWith$default(name, InAppPurchaseBillingClientWrapper.METHOD_ON_BILLING_SERVICE_DISCONNECTED, false, 2)) {
                        InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().set(false);
                    }
                }
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }
    }

    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object createBillingClient(Context context, Class<?> cls) {
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_BILLING_CLIENT_BUILDER);
            InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
            Class<?> cls3 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_UPDATED_LISTENER);
            if (cls2 == null || cls3 == null) {
                return null;
            }
            InAppPurchaseUtils inAppPurchaseUtils3 = InAppPurchaseUtils.INSTANCE;
            Method method = InAppPurchaseUtils.getMethod(cls, "newBuilder", Context.class);
            InAppPurchaseUtils inAppPurchaseUtils4 = InAppPurchaseUtils.INSTANCE;
            Method method2 = InAppPurchaseUtils.getMethod(cls2, "enablePendingPurchases", new Class[0]);
            InAppPurchaseUtils inAppPurchaseUtils5 = InAppPurchaseUtils.INSTANCE;
            Method method3 = InAppPurchaseUtils.getMethod(cls2, "setListener", cls3);
            InAppPurchaseUtils inAppPurchaseUtils6 = InAppPurchaseUtils.INSTANCE;
            Method method4 = InAppPurchaseUtils.getMethod(cls2, "build", new Class[0]);
            if (method == null || method2 == null || method3 == null || method4 == null) {
                return null;
            }
            InAppPurchaseUtils inAppPurchaseUtils7 = InAppPurchaseUtils.INSTANCE;
            Object invokeMethod = InAppPurchaseUtils.invokeMethod(cls, method, (Object) null, context);
            if (invokeMethod == null) {
                return null;
            }
            Object newProxyInstance = Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new PurchasesUpdatedListenerWrapper());
            Intrinsics.checkNotNullExpressionValue(newProxyInstance, "newProxyInstance(\n              listenerClazz.classLoader, arrayOf(listenerClazz), PurchasesUpdatedListenerWrapper())");
            InAppPurchaseUtils inAppPurchaseUtils8 = InAppPurchaseUtils.INSTANCE;
            Object invokeMethod2 = InAppPurchaseUtils.invokeMethod(cls2, method3, invokeMethod, newProxyInstance);
            if (invokeMethod2 == null) {
                return null;
            }
            InAppPurchaseUtils inAppPurchaseUtils9 = InAppPurchaseUtils.INSTANCE;
            Object invokeMethod3 = InAppPurchaseUtils.invokeMethod(cls2, method2, invokeMethod2, new Object[0]);
            if (invokeMethod3 == null) {
                return null;
            }
            InAppPurchaseUtils inAppPurchaseUtils10 = InAppPurchaseUtils.INSTANCE;
            return InAppPurchaseUtils.invokeMethod(cls2, method4, invokeMethod3, new Object[0]);
        }

        private final void createInstance(Context context) {
            Class<String> cls = String.class;
            InAppPurchaseSkuDetailsWrapper orCreateInstance = InAppPurchaseSkuDetailsWrapper.Companion.getOrCreateInstance();
            if (orCreateInstance != null) {
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_BILLING_CLIENT);
                InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
                Class<?> cls3 = InAppPurchaseUtils.getClass("com.android.billingclient.api.Purchase");
                InAppPurchaseUtils inAppPurchaseUtils3 = InAppPurchaseUtils.INSTANCE;
                Class<?> cls4 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASES_RESULT);
                InAppPurchaseUtils inAppPurchaseUtils4 = InAppPurchaseUtils.INSTANCE;
                Class<?> cls5 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_SKU_DETAILS);
                InAppPurchaseUtils inAppPurchaseUtils5 = InAppPurchaseUtils.INSTANCE;
                Class<?> cls6 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_HISTORY_RECORD);
                InAppPurchaseUtils inAppPurchaseUtils6 = InAppPurchaseUtils.INSTANCE;
                Class<?> cls7 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER);
                InAppPurchaseUtils inAppPurchaseUtils7 = InAppPurchaseUtils.INSTANCE;
                Class<?> cls8 = InAppPurchaseUtils.getClass(InAppPurchaseBillingClientWrapper.CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER);
                if (cls2 == null || cls4 == null || cls3 == null || cls5 == null || cls7 == null || cls6 == null || cls8 == null) {
                    return;
                }
                InAppPurchaseUtils inAppPurchaseUtils8 = InAppPurchaseUtils.INSTANCE;
                Method method = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseBillingClientWrapper.METHOD_QUERY_PURCHASES, cls);
                InAppPurchaseUtils inAppPurchaseUtils9 = InAppPurchaseUtils.INSTANCE;
                Method method2 = InAppPurchaseUtils.getMethod(cls4, InAppPurchaseBillingClientWrapper.METHOD_GET_PURCHASE_LIST, new Class[0]);
                InAppPurchaseUtils inAppPurchaseUtils10 = InAppPurchaseUtils.INSTANCE;
                Method method3 = InAppPurchaseUtils.getMethod(cls3, "getOriginalJson", new Class[0]);
                InAppPurchaseUtils inAppPurchaseUtils11 = InAppPurchaseUtils.INSTANCE;
                Method method4 = InAppPurchaseUtils.getMethod(cls5, "getOriginalJson", new Class[0]);
                InAppPurchaseUtils inAppPurchaseUtils12 = InAppPurchaseUtils.INSTANCE;
                Method method5 = InAppPurchaseUtils.getMethod(cls6, "getOriginalJson", new Class[0]);
                InAppPurchaseUtils inAppPurchaseUtils13 = InAppPurchaseUtils.INSTANCE;
                Method method6 = InAppPurchaseUtils.getMethod(cls2, "querySkuDetailsAsync", orCreateInstance.getSkuDetailsParamsClazz(), cls7);
                InAppPurchaseUtils inAppPurchaseUtils14 = InAppPurchaseUtils.INSTANCE;
                Method method7 = InAppPurchaseUtils.getMethod(cls2, "queryPurchaseHistoryAsync", cls, cls8);
                if (method == null || method2 == null || method3 == null || method4 == null || method5 == null || method6 == null || method7 == null) {
                    return;
                }
                Object createBillingClient = createBillingClient(context, cls2);
                if (createBillingClient != null) {
                    InAppPurchaseBillingClientWrapper.access$setInstance$cp(new InAppPurchaseBillingClientWrapper(context, createBillingClient, cls2, cls4, cls3, cls5, cls6, cls7, cls8, method, method2, method3, method4, method5, method6, method7, orCreateInstance, (DefaultConstructorMarker) null));
                    InAppPurchaseBillingClientWrapper access$getInstance$cp = InAppPurchaseBillingClientWrapper.access$getInstance$cp();
                    if (access$getInstance$cp != null) {
                        InAppPurchaseBillingClientWrapper.access$startConnection(access$getInstance$cp);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper");
                }
            }
        }

        public final synchronized InAppPurchaseBillingClientWrapper getOrCreateInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            if (InAppPurchaseBillingClientWrapper.access$getInitialized$cp().get()) {
                return InAppPurchaseBillingClientWrapper.access$getInstance$cp();
            }
            createInstance(context);
            InAppPurchaseBillingClientWrapper.access$getInitialized$cp().set(true);
            return InAppPurchaseBillingClientWrapper.access$getInstance$cp();
        }

        public final Map<String, JSONObject> getPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapper.access$getPurchaseDetailsMap$cp();
        }

        public final Map<String, JSONObject> getSkuDetailsMap() {
            return InAppPurchaseBillingClientWrapper.access$getSkuDetailsMap$cp();
        }

        public final AtomicBoolean isServiceConnected() {
            return InAppPurchaseBillingClientWrapper.access$isServiceConnected$cp();
        }
    }

    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    public final class PurchaseHistoryResponseListenerWrapper implements InvocationHandler {
        public Runnable runnable;
        public final /* synthetic */ InAppPurchaseBillingClientWrapper this$0;

        public PurchaseHistoryResponseListenerWrapper(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable2) {
            Intrinsics.checkNotNullParameter(inAppPurchaseBillingClientWrapper, "this$0");
            Intrinsics.checkNotNullParameter(runnable2, "runnable");
            this.this$0 = inAppPurchaseBillingClientWrapper;
            this.runnable = runnable2;
        }

        private final void getPurchaseHistoryRecord(List<?> list) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    for (Object next : list) {
                        try {
                            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                            Object invokeMethod = InAppPurchaseUtils.invokeMethod(InAppPurchaseBillingClientWrapper.access$getPurchaseHistoryRecordClazz$p(this.this$0), InAppPurchaseBillingClientWrapper.access$getGetOriginalJsonPurchaseHistoryMethod$p(this.this$0), next, new Object[0]);
                            String str = invokeMethod instanceof String ? (String) invokeMethod : null;
                            if (str != null) {
                                JSONObject jSONObject = new JSONObject(str);
                                jSONObject.put(InAppPurchaseBillingClientWrapper.PACKAGE_NAME, InAppPurchaseBillingClientWrapper.access$getContext$p(this.this$0).getPackageName());
                                if (jSONObject.has("productId")) {
                                    String string = jSONObject.getString("productId");
                                    InAppPurchaseBillingClientWrapper.access$getHistoryPurchaseSet$p(this.this$0).add(string);
                                    Map<String, JSONObject> purchaseDetailsMap = InAppPurchaseBillingClientWrapper.Companion.getPurchaseDetailsMap();
                                    Intrinsics.checkNotNullExpressionValue(string, "skuID");
                                    purchaseDetailsMap.put(string, jSONObject);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    this.runnable.run();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        public final Runnable getRunnable() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return this.runnable;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            List list;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(obj, "proxy");
                Intrinsics.checkNotNullParameter(method, "method");
                if (Intrinsics.areEqual(method.getName(), "onPurchaseHistoryResponse")) {
                    if (objArr == null) {
                        list = null;
                    } else {
                        list = objArr[1];
                    }
                    if (list != null && (list instanceof List)) {
                        getPurchaseHistoryRecord(list);
                    }
                }
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        public final void setRunnable(Runnable runnable2) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    Intrinsics.checkNotNullParameter(runnable2, "<set-?>");
                    this.runnable = runnable2;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    public static final class PurchasesUpdatedListenerWrapper implements InvocationHandler {
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(obj, "proxy");
                Intrinsics.checkNotNullParameter(method, PaintCompat.EM_STRING);
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }
    }

    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    public final class SkuDetailsResponseListenerWrapper implements InvocationHandler {
        public Runnable runnable;
        public final /* synthetic */ InAppPurchaseBillingClientWrapper this$0;

        public SkuDetailsResponseListenerWrapper(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable2) {
            Intrinsics.checkNotNullParameter(inAppPurchaseBillingClientWrapper, "this$0");
            Intrinsics.checkNotNullParameter(runnable2, "runnable");
            this.this$0 = inAppPurchaseBillingClientWrapper;
            this.runnable = runnable2;
        }

        public final Runnable getRunnable() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return this.runnable;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            List list;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(obj, "proxy");
                Intrinsics.checkNotNullParameter(method, PaintCompat.EM_STRING);
                if (Intrinsics.areEqual(method.getName(), "onSkuDetailsResponse")) {
                    if (objArr == null) {
                        list = null;
                    } else {
                        list = objArr[1];
                    }
                    if (list != null && (list instanceof List)) {
                        parseSkuDetails(list);
                    }
                }
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        public final void parseSkuDetails(List<?> list) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    Intrinsics.checkNotNullParameter(list, "skuDetailsObjectList");
                    for (Object next : list) {
                        try {
                            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                            Object invokeMethod = InAppPurchaseUtils.invokeMethod(InAppPurchaseBillingClientWrapper.access$getSkuDetailsClazz$p(this.this$0), InAppPurchaseBillingClientWrapper.access$getGetOriginalJsonSkuMethod$p(this.this$0), next, new Object[0]);
                            String str = invokeMethod instanceof String ? (String) invokeMethod : null;
                            if (str != null) {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has("productId")) {
                                    String string = jSONObject.getString("productId");
                                    Map<String, JSONObject> skuDetailsMap = InAppPurchaseBillingClientWrapper.Companion.getSkuDetailsMap();
                                    Intrinsics.checkNotNullExpressionValue(string, "skuID");
                                    skuDetailsMap.put(string, jSONObject);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    this.runnable.run();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        public final void setRunnable(Runnable runnable2) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    Intrinsics.checkNotNullParameter(runnable2, "<set-?>");
                    this.runnable = runnable2;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    public InAppPurchaseBillingClientWrapper(Context context2, Object obj, Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4, Class<?> cls5, Class<?> cls6, Class<?> cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper2) {
        this.context = context2;
        this.billingClient = obj;
        this.billingClientClazz = cls;
        this.purchaseResultClazz = cls2;
        this.purchaseClazz = cls3;
        this.skuDetailsClazz = cls4;
        this.purchaseHistoryRecordClazz = cls5;
        this.skuDetailsResponseListenerClazz = cls6;
        this.purchaseHistoryResponseListenerClazz = cls7;
        this.queryPurchasesMethod = method;
        this.getPurchaseListMethod = method2;
        this.getOriginalJsonMethod = method3;
        this.getOriginalJsonSkuMethod = method4;
        this.getOriginalJsonPurchaseHistoryMethod = method5;
        this.querySkuDetailsAsyncMethod = method6;
        this.queryPurchaseHistoryAsyncMethod = method7;
        this.inAppPurchaseSkuDetailsWrapper = inAppPurchaseSkuDetailsWrapper2;
        this.historyPurchaseSet = new CopyOnWriteArraySet();
    }

    public /* synthetic */ InAppPurchaseBillingClientWrapper(Context context2, Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, obj, cls, cls2, cls3, cls4, cls5, cls6, cls7, method, method2, method3, method4, method5, method6, method7, inAppPurchaseSkuDetailsWrapper2);
    }

    public static final /* synthetic */ Context access$getContext$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.context;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Method access$getGetOriginalJsonPurchaseHistoryMethod$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.getOriginalJsonPurchaseHistoryMethod;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Method access$getGetOriginalJsonSkuMethod$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.getOriginalJsonSkuMethod;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Set access$getHistoryPurchaseSet$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.historyPurchaseSet;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean access$getInitialized$cp() {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return initialized;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ InAppPurchaseBillingClientWrapper access$getInstance$cp() {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getPurchaseDetailsMap$cp() {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return purchaseDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Class access$getPurchaseHistoryRecordClazz$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.purchaseHistoryRecordClazz;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Class access$getSkuDetailsClazz$p(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapper.skuDetailsClazz;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getSkuDetailsMap$cp() {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return skuDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean access$isServiceConnected$cp() {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return isServiceConnected;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ void access$setInstance$cp(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                instance = inAppPurchaseBillingClientWrapper;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final /* synthetic */ void access$startConnection(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                inAppPurchaseBillingClientWrapper.startConnection();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final synchronized InAppPurchaseBillingClientWrapper getOrCreateInstance(Context context2) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        synchronized (cls) {
            if (CrashShieldHandler.isObjectCrashing(cls)) {
                return null;
            }
            try {
                InAppPurchaseBillingClientWrapper orCreateInstance = Companion.getOrCreateInstance(context2);
                return orCreateInstance;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
                return null;
            }
        }
    }

    /* renamed from: queryPurchaseHistory$lambda-0  reason: not valid java name */
    public static final void m3580queryPurchaseHistory$lambda0(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(inAppPurchaseBillingClientWrapper, "this$0");
                Intrinsics.checkNotNullParameter(runnable, "$queryPurchaseHistoryRunnable");
                inAppPurchaseBillingClientWrapper.querySkuDetailsAsync("inapp", new ArrayList(inAppPurchaseBillingClientWrapper.historyPurchaseSet), runnable);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void queryPurchaseHistoryAsync(String str, Runnable runnable) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Object newProxyInstance = Proxy.newProxyInstance(this.purchaseHistoryResponseListenerClazz.getClassLoader(), new Class[]{this.purchaseHistoryResponseListenerClazz}, new PurchaseHistoryResponseListenerWrapper(this, runnable));
                Intrinsics.checkNotNullExpressionValue(newProxyInstance, "newProxyInstance(\n            purchaseHistoryResponseListenerClazz.classLoader,\n            arrayOf(purchaseHistoryResponseListenerClazz),\n            PurchaseHistoryResponseListenerWrapper(runnable))");
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.queryPurchaseHistoryAsyncMethod, this.billingClient, str, newProxyInstance);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void querySkuDetailsAsync(String str, List<String> list, Runnable runnable) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Object newProxyInstance = Proxy.newProxyInstance(this.skuDetailsResponseListenerClazz.getClassLoader(), new Class[]{this.skuDetailsResponseListenerClazz}, new SkuDetailsResponseListenerWrapper(this, runnable));
                Intrinsics.checkNotNullExpressionValue(newProxyInstance, "newProxyInstance(\n            skuDetailsResponseListenerClazz.classLoader,\n            arrayOf(skuDetailsResponseListenerClazz),\n            SkuDetailsResponseListenerWrapper(runnable))");
                Object skuDetailsParams = this.inAppPurchaseSkuDetailsWrapper.getSkuDetailsParams(str, list);
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.querySkuDetailsAsyncMethod, this.billingClient, skuDetailsParams, newProxyInstance);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final void startConnection() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                Class<?> cls = InAppPurchaseUtils.getClass(CLASSNAME_BILLING_CLIENT_STATE_LISTENER);
                if (cls != null) {
                    InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
                    Method method = InAppPurchaseUtils.getMethod(this.billingClientClazz, "startConnection", cls);
                    if (method != null) {
                        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new BillingClientStateListenerWrapper());
                        Intrinsics.checkNotNullExpressionValue(newProxyInstance, "newProxyInstance(\n            listenerClazz.classLoader, arrayOf(listenerClazz), BillingClientStateListenerWrapper())");
                        InAppPurchaseUtils inAppPurchaseUtils3 = InAppPurchaseUtils.INSTANCE;
                        InAppPurchaseUtils.invokeMethod(this.billingClientClazz, method, this.billingClient, newProxyInstance);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void queryPurchase(String str, Runnable runnable) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(str, "skuType");
                Intrinsics.checkNotNullParameter(runnable, "querySkuRunnable");
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.queryPurchasesMethod, this.billingClient, "inapp");
                InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
                Object invokeMethod2 = InAppPurchaseUtils.invokeMethod(this.purchaseResultClazz, this.getPurchaseListMethod, invokeMethod, new Object[0]);
                List list = invokeMethod2 instanceof List ? (List) invokeMethod2 : null;
                if (list != null) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        for (Object next : list) {
                            InAppPurchaseUtils inAppPurchaseUtils3 = InAppPurchaseUtils.INSTANCE;
                            Object invokeMethod3 = InAppPurchaseUtils.invokeMethod(this.purchaseClazz, this.getOriginalJsonMethod, next, new Object[0]);
                            String str2 = invokeMethod3 instanceof String ? (String) invokeMethod3 : null;
                            if (str2 != null) {
                                JSONObject jSONObject = new JSONObject(str2);
                                if (jSONObject.has("productId")) {
                                    String string = jSONObject.getString("productId");
                                    arrayList.add(string);
                                    Map<String, JSONObject> map = purchaseDetailsMap;
                                    Intrinsics.checkNotNullExpressionValue(string, "skuID");
                                    map.put(string, jSONObject);
                                }
                            }
                        }
                        querySkuDetailsAsync(str, arrayList, runnable);
                    } catch (JSONException unused) {
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void queryPurchaseHistory(String str, Runnable runnable) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(str, "skuType");
                Intrinsics.checkNotNullParameter(runnable, "queryPurchaseHistoryRunnable");
                queryPurchaseHistoryAsync(str, new Runnable(runnable) {
                    public final /* synthetic */ Runnable f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        InAppPurchaseBillingClientWrapper.m3580queryPurchaseHistory$lambda0(InAppPurchaseBillingClientWrapper.this, this.f$1);
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
