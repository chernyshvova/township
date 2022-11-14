package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.C1513Ad;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@Keep
public class DynamicLoaderFallback {
    public static final WeakHashMap<Object, AdListener> sApiProxyToAdListenersMap = new WeakHashMap<>();

    public static class SimpleMethodCaptor {
        public final InvocationHandler mInvocationHandler;
        @Nullable
        public Method mLastInvokedMethod;

        public SimpleMethodCaptor() {
            this.mInvocationHandler = new InvocationHandler() {
                @Nullable
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if ("toString".equals(method.getName())) {
                        return null;
                    }
                    Method unused = SimpleMethodCaptor.this.mLastInvokedMethod = method;
                    return null;
                }
            };
        }

        @Nullable
        public Method getLastMethod() {
            return this.mLastInvokedMethod;
        }

        public <T> T mock(Class<T> cls) {
            return cls.cast(Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{cls}, this.mInvocationHandler));
        }
    }

    public static boolean equalsMethodParams(Method method, Method method2) {
        return Arrays.equals(method.getParameterTypes(), method2.getParameterTypes());
    }

    public static boolean equalsMethods(Method method, Method method2) {
        return method != null && method2 != null && method.getDeclaringClass().equals(method2.getDeclaringClass()) && method.getName().equals(method2.getName()) && equalsMethodParams(method, method2);
    }

    @SuppressLint({"Parameter Not Nullable", "CatchGeneralException"})
    public static DynamicLoader makeFallbackLoader() {
        Class cls = DynamicLoader.class;
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        final ArrayList arrayList5 = new ArrayList();
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        SimpleMethodCaptor simpleMethodCaptor = new SimpleMethodCaptor();
        DynamicLoader dynamicLoader = (DynamicLoader) simpleMethodCaptor.mock(cls);
        dynamicLoader.createInterstitialAd((Context) null, (String) null, (InterstitialAd) null);
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createRewardedVideoAd((Context) null, (String) null, (RewardedVideoAd) null);
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createAdViewApi((Context) null, (String) null, (AdSize) null, (AdViewParentApi) null, (AdView) null);
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        try {
            dynamicLoader.createAdViewApi((Context) null, (String) null, (String) null, (AdViewParentApi) null, (AdView) null);
        } catch (Exception unused) {
        }
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createNativeAdApi((NativeAd) null, (NativeAdBaseApi) null);
        Method lastMethod = simpleMethodCaptor.getLastMethod();
        dynamicLoader.createNativeBannerAdApi((NativeBannerAd) null, (NativeAdBaseApi) null);
        final Method lastMethod2 = simpleMethodCaptor.getLastMethod();
        NativeAdBaseApi nativeAdBaseApi = (NativeAdBaseApi) simpleMethodCaptor.mock(NativeAdBaseApi.class);
        nativeAdBaseApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.loadAd((NativeAdBase.NativeLoadAdConfig) null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.buildLoadAdConfig((NativeAdBase) null);
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        InterstitialAdApi interstitialAdApi = (InterstitialAdApi) simpleMethodCaptor.mock(InterstitialAdApi.class);
        interstitialAdApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.loadAd((InterstitialAd.InterstitialLoadAdConfig) null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.buildLoadAdConfig();
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        RewardedVideoAdApi rewardedVideoAdApi = (RewardedVideoAdApi) simpleMethodCaptor.mock(RewardedVideoAdApi.class);
        rewardedVideoAdApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.loadAd((RewardedVideoAd.RewardedVideoLoadAdConfig) null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.buildLoadAdConfig();
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        AdViewApi adViewApi = (AdViewApi) simpleMethodCaptor.mock(AdViewApi.class);
        adViewApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        adViewApi.loadAd((AdView.AdViewLoadConfig) null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        adViewApi.buildLoadAdConfig();
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        ((AdView.AdViewLoadConfigBuilder) simpleMethodCaptor.mock(AdView.AdViewLoadConfigBuilder.class)).withAdListener((AdListener) null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        ((NativeAdBase.NativeAdLoadConfigBuilder) simpleMethodCaptor.mock(NativeAdBase.NativeAdLoadConfigBuilder.class)).withAdListener((NativeAdListener) null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        ((InterstitialAd.InterstitialAdLoadConfigBuilder) simpleMethodCaptor.mock(InterstitialAd.InterstitialAdLoadConfigBuilder.class)).withAdListener((InterstitialAdListener) null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        ((RewardedVideoAd.RewardedVideoAdLoadConfigBuilder) simpleMethodCaptor.mock(RewardedVideoAd.RewardedVideoAdLoadConfigBuilder.class)).withAdListener((RewardedVideoAdListener) null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        final Method method = lastMethod;
        C15251 r1 = new InvocationHandler() {
            @Nullable
            public Object invoke(Object obj, Method method, Object[] objArr) {
                Object obj2;
                if (method.getReturnType().isPrimitive()) {
                    if (!method.getReturnType().equals(Void.TYPE)) {
                        return Array.get(Array.newInstance(method.getReturnType(), 1), 0);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext() && (!DynamicLoaderFallback.equalsMethods(method, (Method) it.next()) || !DynamicLoaderFallback.reportError(obj, hashMap))) {
                    }
                    for (Method access$100 : arrayList2) {
                        if (DynamicLoaderFallback.equalsMethods(method, access$100) && DynamicLoaderFallback.reportError(obj, hashMap)) {
                            return null;
                        }
                    }
                    return null;
                } else if (method.getReturnType().equals(String.class)) {
                    return "";
                } else {
                    if (method.getReturnType().equals(obj.getClass().getInterfaces()[0])) {
                        obj2 = obj;
                    } else {
                        obj2 = Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{method.getReturnType()}, this);
                    }
                    Iterator it2 = arrayList3.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (DynamicLoaderFallback.equalsMethods(method, (Method) it2.next())) {
                                DynamicLoaderFallback.sApiProxyToAdListenersMap.put(hashMap2.get(obj), objArr[0]);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    for (Method access$1002 : arrayList4) {
                        if (DynamicLoaderFallback.equalsMethods(method, access$1002)) {
                            hashMap2.put(obj2, obj);
                        }
                    }
                    for (Method access$1003 : arrayList5) {
                        if (DynamicLoaderFallback.equalsMethods(method, access$1003)) {
                            for (C1513Ad ad : objArr) {
                                if (ad instanceof C1513Ad) {
                                    hashMap.put(obj2, ad);
                                }
                            }
                        }
                    }
                    if (DynamicLoaderFallback.equalsMethods(method, method)) {
                        hashMap.put(objArr[1], objArr[0]);
                    }
                    if (DynamicLoaderFallback.equalsMethods(method, lastMethod2)) {
                        hashMap.put(objArr[1], objArr[0]);
                    }
                    return obj2;
                }
            }
        };
        return (DynamicLoader) Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{cls}, r1);
    }

    public static boolean reportError(@Nullable Object obj, Map<Object, C1513Ad> map) {
        if (obj == null) {
            return false;
        }
        final AdListener adListener = sApiProxyToAdListenersMap.get(obj);
        final C1513Ad ad = map.get(obj);
        if (adListener == null) {
            return false;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                AdListener.this.onError(ad, new AdError(-1, DynamicLoaderFactory.DEX_LOADING_ERROR_MESSAGE));
            }
        }, 500);
        return true;
    }
}
