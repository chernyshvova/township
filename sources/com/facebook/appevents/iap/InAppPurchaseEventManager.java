package com.facebook.appevents.iap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.RestrictTo;
import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.vungle.warren.log.LogEntry;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: InAppPurchaseEventManager.kt */
public final class InAppPurchaseEventManager {
    public static final String AS_INTERFACE = "asInterface";
    public static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    public static final String DETAILS_LIST = "DETAILS_LIST";
    public static final String GET_PURCHASES = "getPurchases";
    public static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    public static final String GET_SKU_DETAILS = "getSkuDetails";
    public static final String INAPP = "inapp";
    public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    public static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    public static final InAppPurchaseEventManager INSTANCE = new InAppPurchaseEventManager();
    public static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    public static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    public static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    public static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    public static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    public static final int MAX_QUERY_PURCHASE_NUM = 30;
    public static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    public static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    public static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    public static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    public static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    public static final String SUBSCRIPTION = "subs";
    public static final HashMap<String, Class<?>> classMap = new HashMap<>();
    public static final HashMap<String, Method> methodMap = new HashMap<>();
    public static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);
    public static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);

    static {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
    }

    public static final Object asInterface(Context context, IBinder iBinder) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            return INSTANCE.invokeMethod(context, "com.android.vending.billing.IInAppBillingService$Stub", AS_INTERFACE, (Object) null, new Object[]{iBinder});
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final void clearSkuDetailsCache() {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long j = skuDetailSharedPrefs.getLong("LAST_CLEARED_TIME", 0);
                if (j == 0) {
                    skuDetailSharedPrefs.edit().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
                } else if (currentTimeMillis - j > ((long) 604800)) {
                    skuDetailSharedPrefs.edit().clear().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final ArrayList<String> filterPurchases(ArrayList<String> arrayList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList<String> arrayList2 = new ArrayList<>();
            SharedPreferences.Editor edit = purchaseInappSharedPrefs.edit();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    JSONObject jSONObject = new JSONObject(next);
                    String string = jSONObject.getString("productId");
                    long j = jSONObject.getLong(InAppPurchaseLoggerManager.PURCHASE_TIME);
                    String string2 = jSONObject.getString("purchaseToken");
                    if (currentTimeMillis - (j / 1000) <= 86400) {
                        if (!Intrinsics.areEqual(purchaseInappSharedPrefs.getString(string, ""), string2)) {
                            edit.putString(string, string2);
                            arrayList2.add(next);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            edit.apply();
            return arrayList2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Class<?> getClass(Context context, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Class<?> cls = classMap.get(str);
            if (cls != null) {
                return cls;
            }
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            Class<?> classFromContext$facebook_core_release = InAppPurchaseUtils.getClassFromContext$facebook_core_release(context, str);
            if (classFromContext$facebook_core_release != null) {
                classMap.put(str, classFromContext$facebook_core_release);
            }
            return classFromContext$facebook_core_release;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.reflect.Method getMethod(java.lang.Class<?> r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r10)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r1 = methodMap     // Catch:{ all -> 0x00c2 }
            java.lang.Object r1 = r1.get(r12)     // Catch:{ all -> 0x00c2 }
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1     // Catch:{ all -> 0x00c2 }
            if (r1 == 0) goto L_0x0015
            return r1
        L_0x0015:
            int r1 = r12.hashCode()     // Catch:{ all -> 0x00c2 }
            r3 = 4
            r4 = 2
            java.lang.String r5 = "TYPE"
            r6 = 3
            r7 = 0
            r8 = 1
            switch(r1) {
                case -1801122596: goto L_0x0086;
                case -1450694211: goto L_0x006f;
                case -1123215065: goto L_0x005f;
                case -594356707: goto L_0x0041;
                case -573310373: goto L_0x0025;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x009f
        L_0x0025:
            java.lang.String r1 = "getSkuDetails"
            boolean r1 = r12.equals(r1)     // Catch:{ all -> 0x00c2 }
            if (r1 != 0) goto L_0x002f
            goto L_0x009f
        L_0x002f:
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ all -> 0x00c2 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00c2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ all -> 0x00c2 }
            r1[r7] = r3     // Catch:{ all -> 0x00c2 }
            r1[r8] = r0     // Catch:{ all -> 0x00c2 }
            r1[r4] = r0     // Catch:{ all -> 0x00c2 }
            java.lang.Class<android.os.Bundle> r0 = android.os.Bundle.class
            r1[r6] = r0     // Catch:{ all -> 0x00c2 }
            goto L_0x00a0
        L_0x0041:
            java.lang.String r1 = "getPurchaseHistory"
            boolean r1 = r12.equals(r1)     // Catch:{ all -> 0x00c2 }
            if (r1 != 0) goto L_0x004a
            goto L_0x009f
        L_0x004a:
            r1 = 5
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ all -> 0x00c2 }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00c2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)     // Catch:{ all -> 0x00c2 }
            r1[r7] = r9     // Catch:{ all -> 0x00c2 }
            r1[r8] = r0     // Catch:{ all -> 0x00c2 }
            r1[r4] = r0     // Catch:{ all -> 0x00c2 }
            r1[r6] = r0     // Catch:{ all -> 0x00c2 }
            java.lang.Class<android.os.Bundle> r0 = android.os.Bundle.class
            r1[r3] = r0     // Catch:{ all -> 0x00c2 }
            goto L_0x00a0
        L_0x005f:
            java.lang.String r0 = "asInterface"
            boolean r0 = r12.equals(r0)     // Catch:{ all -> 0x00c2 }
            if (r0 != 0) goto L_0x0068
            goto L_0x009f
        L_0x0068:
            java.lang.Class[] r1 = new java.lang.Class[r8]     // Catch:{ all -> 0x00c2 }
            java.lang.Class<android.os.IBinder> r0 = android.os.IBinder.class
            r1[r7] = r0     // Catch:{ all -> 0x00c2 }
            goto L_0x00a0
        L_0x006f:
            java.lang.String r1 = "isBillingSupported"
            boolean r1 = r12.equals(r1)     // Catch:{ all -> 0x00c2 }
            if (r1 != 0) goto L_0x0078
            goto L_0x009f
        L_0x0078:
            java.lang.Class[] r1 = new java.lang.Class[r6]     // Catch:{ all -> 0x00c2 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00c2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ all -> 0x00c2 }
            r1[r7] = r3     // Catch:{ all -> 0x00c2 }
            r1[r8] = r0     // Catch:{ all -> 0x00c2 }
            r1[r4] = r0     // Catch:{ all -> 0x00c2 }
            goto L_0x00a0
        L_0x0086:
            java.lang.String r1 = "getPurchases"
            boolean r1 = r12.equals(r1)     // Catch:{ all -> 0x00c2 }
            if (r1 != 0) goto L_0x008f
            goto L_0x009f
        L_0x008f:
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ all -> 0x00c2 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00c2 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ all -> 0x00c2 }
            r1[r7] = r3     // Catch:{ all -> 0x00c2 }
            r1[r8] = r0     // Catch:{ all -> 0x00c2 }
            r1[r4] = r0     // Catch:{ all -> 0x00c2 }
            r1[r6] = r0     // Catch:{ all -> 0x00c2 }
            goto L_0x00a0
        L_0x009f:
            r1 = r2
        L_0x00a0:
            if (r1 != 0) goto L_0x00ad
            com.facebook.appevents.iap.InAppPurchaseUtils r0 = com.facebook.appevents.iap.InAppPurchaseUtils.INSTANCE     // Catch:{ all -> 0x00c2 }
            java.lang.Class[] r0 = new java.lang.Class[r8]     // Catch:{ all -> 0x00c2 }
            r0[r7] = r2     // Catch:{ all -> 0x00c2 }
            java.lang.reflect.Method r11 = com.facebook.appevents.iap.InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(r11, r12, r0)     // Catch:{ all -> 0x00c2 }
            goto L_0x00ba
        L_0x00ad:
            com.facebook.appevents.iap.InAppPurchaseUtils r0 = com.facebook.appevents.iap.InAppPurchaseUtils.INSTANCE     // Catch:{ all -> 0x00c2 }
            int r0 = r1.length     // Catch:{ all -> 0x00c2 }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r0)     // Catch:{ all -> 0x00c2 }
            java.lang.Class[] r0 = (java.lang.Class[]) r0     // Catch:{ all -> 0x00c2 }
            java.lang.reflect.Method r11 = com.facebook.appevents.iap.InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(r11, r12, r0)     // Catch:{ all -> 0x00c2 }
        L_0x00ba:
            if (r11 == 0) goto L_0x00c1
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r0 = methodMap     // Catch:{ all -> 0x00c2 }
            r0.put(r12, r11)     // Catch:{ all -> 0x00c2 }
        L_0x00c1:
            return r11
        L_0x00c2:
            r11 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r11, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getMethod(java.lang.Class, java.lang.String):java.lang.reflect.Method");
    }

    private final ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            if (isBillingSupported(context, obj, str)) {
                String str2 = null;
                int i = 0;
                boolean z = false;
                do {
                    Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, obj, new Object[]{6, PACKAGE_NAME, str, str2, new Bundle()});
                    if (invokeMethod != null) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        Bundle bundle = (Bundle) invokeMethod;
                        if (bundle.getInt(RESPONSE_CODE) == 0) {
                            ArrayList<String> stringArrayList = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST);
                            if (stringArrayList != null) {
                                Iterator<String> it = stringArrayList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    String next = it.next();
                                    try {
                                        if (currentTimeMillis - (new JSONObject(next).getLong(InAppPurchaseLoggerManager.PURCHASE_TIME) / 1000) > 1200) {
                                            z = true;
                                            break;
                                        }
                                        arrayList.add(next);
                                        i++;
                                    } catch (JSONException unused) {
                                    }
                                }
                                str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                                if (i >= 30 || str2 == null) {
                                    break;
                                }
                            }
                        }
                    }
                    str2 = null;
                } while (!z);
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        Class<?> cls;
        Class<InAppPurchaseEventManager> cls2 = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls2)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            ArrayList<String> arrayList = new ArrayList<>();
            if (obj == null || (cls = INSTANCE.getClass(context, IN_APP_BILLING_SERVICE)) == null || INSTANCE.getMethod(cls, GET_PURCHASE_HISTORY) == null) {
                return arrayList;
            }
            return INSTANCE.filterPurchases(INSTANCE.getPurchaseHistory(context, obj, "inapp"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062 A[EDGE_INSN: B:27:0x0062->B:21:0x0062 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r13, java.lang.Object r14, java.lang.String r15) {
        /*
            r12 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0063 }
            r0.<init>()     // Catch:{ all -> 0x0063 }
            if (r14 != 0) goto L_0x0010
            return r0
        L_0x0010:
            boolean r2 = r12.isBillingSupported(r13, r14, r15)     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x0062
            r2 = 0
            r3 = r1
            r4 = 0
        L_0x0019:
            r5 = 4
            java.lang.Object[] r11 = new java.lang.Object[r5]     // Catch:{ all -> 0x0063 }
            r5 = 3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0063 }
            r11[r2] = r6     // Catch:{ all -> 0x0063 }
            r6 = 1
            java.lang.String r7 = PACKAGE_NAME     // Catch:{ all -> 0x0063 }
            r11[r6] = r7     // Catch:{ all -> 0x0063 }
            r6 = 2
            r11[r6] = r15     // Catch:{ all -> 0x0063 }
            r11[r5] = r3     // Catch:{ all -> 0x0063 }
            java.lang.String r8 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r9 = "getPurchases"
            r6 = r12
            r7 = r13
            r10 = r14
            java.lang.Object r3 = r6.invokeMethod(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0063 }
            if (r3 == 0) goto L_0x005b
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch:{ all -> 0x0063 }
            java.lang.String r5 = "RESPONSE_CODE"
            int r5 = r3.getInt(r5)     // Catch:{ all -> 0x0063 }
            if (r5 != 0) goto L_0x005b
            java.lang.String r5 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r5 = r3.getStringArrayList(r5)     // Catch:{ all -> 0x0063 }
            if (r5 == 0) goto L_0x0062
            int r6 = r5.size()     // Catch:{ all -> 0x0063 }
            int r4 = r4 + r6
            r0.addAll(r5)     // Catch:{ all -> 0x0063 }
            java.lang.String r5 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r3 = r3.getString(r5)     // Catch:{ all -> 0x0063 }
            goto L_0x005c
        L_0x005b:
            r3 = r1
        L_0x005c:
            r5 = 30
            if (r4 >= r5) goto L_0x0062
            if (r3 != 0) goto L_0x0019
        L_0x0062:
            return r0
        L_0x0063:
            r13 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    public static final ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            return INSTANCE.filterPurchases(INSTANCE.getPurchases(context, obj, "inapp"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final ArrayList<String> getPurchasesSubs(Context context, Object obj) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            return INSTANCE.filterPurchases(INSTANCE.getPurchases(context, obj, SUBSCRIPTION));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            Intrinsics.checkNotNullParameter(arrayList, "skuList");
            Map<String, String> readSkuDetailsFromCache = INSTANCE.readSkuDetailsFromCache(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!readSkuDetailsFromCache.containsKey(next)) {
                    arrayList2.add(next);
                }
            }
            readSkuDetailsFromCache.putAll(INSTANCE.getSkuDetailsFromGoogle(context, arrayList2, obj, z));
            return readSkuDetailsFromCache;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private final Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        int size;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (obj != null) {
                if (!arrayList.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
                    Object[] objArr = new Object[4];
                    int i = 0;
                    objArr[0] = 3;
                    objArr[1] = PACKAGE_NAME;
                    objArr[2] = z ? SUBSCRIPTION : "inapp";
                    objArr[3] = bundle;
                    Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, objArr);
                    if (invokeMethod != null) {
                        Bundle bundle2 = (Bundle) invokeMethod;
                        if (bundle2.getInt(RESPONSE_CODE) == 0) {
                            ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                            if (stringArrayList != null && arrayList.size() == stringArrayList.size() && arrayList.size() - 1 >= 0) {
                                while (true) {
                                    int i2 = i + 1;
                                    String str = arrayList.get(i);
                                    Intrinsics.checkNotNullExpressionValue(str, "skuList[i]");
                                    String str2 = stringArrayList.get(i);
                                    Intrinsics.checkNotNullExpressionValue(str2, "skuDetailsList[i]");
                                    linkedHashMap.put(str, str2);
                                    if (i2 > size) {
                                        break;
                                    }
                                    i = i2;
                                }
                            }
                            writeSkuDetailsToCache(linkedHashMap);
                        }
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Class<?> cls = getClass(context, str);
            if (cls == null || (method = getMethod(cls, str2)) == null) {
                return null;
            }
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            return InAppPurchaseUtils.invokeMethod(cls, method, obj, Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final boolean isBillingSupported(Context context, Object obj, String str) {
        if (CrashShieldHandler.isObjectCrashing(this) || obj == null) {
            return false;
        }
        try {
            Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{3, PACKAGE_NAME, str});
            if (invokeMethod == null || ((Integer) invokeMethod).intValue() != 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                String string = skuDetailSharedPrefs.getString(next, (String) null);
                if (string != null) {
                    List split$default = CharsKt__CharKt.split$default(string, new String[]{";"}, false, 2, 2);
                    if (currentTimeMillis - Long.parseLong((String) split$default.get(0)) < 43200) {
                        Intrinsics.checkNotNullExpressionValue(next, AppLovinEventParameters.PRODUCT_IDENTIFIER);
                        linkedHashMap.put(next, split$default.get(1));
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void writeSkuDetailsToCache(Map<String, String> map) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                SharedPreferences.Editor edit = skuDetailSharedPrefs.edit();
                for (Map.Entry next : map.entrySet()) {
                    edit.putString((String) next.getKey(), currentTimeMillis + ';' + ((String) next.getValue()));
                }
                edit.apply();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final boolean hasFreeTrialPeirod(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "skuDetail");
            try {
                String optString = new JSONObject(str).optString("freeTrialPeriod");
                if (optString == null) {
                    return false;
                }
                if (optString.length() > 0) {
                    return true;
                }
                return false;
            } catch (JSONException unused) {
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
