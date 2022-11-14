package com.unity3d.services.store.gpbl.bridges;

import com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper;
import com.unity3d.services.core.reflection.GenericBridge;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkuDetailsParamsBridge extends GenericBridge {
    public static final String newBuilderMethodName = "newBuilder";
    public static final Map<String, Class<?>[]> staticMethods = new HashMap<String, Class<?>[]>() {
        {
            put("newBuilder", new Class[0]);
        }
    };
    public final Object _skuDetailsParamsInternalInstance;

    public static class BuilderBridge extends GenericBridge {
        public static final String buildMethodName = "build";
        public static final String setSkusListMethodName = "setSkusList";
        public static final String setTypeMethodName = "setType";
        public Object _skuDetailsParamsBuilderInternalInstance;

        public BuilderBridge(Object obj) {
            super(new HashMap<String, Class[]>() {
                {
                    put("build", new Class[0]);
                    put("setSkusList", new Class[]{List.class});
                    put("setType", new Class[]{String.class});
                }
            });
            this._skuDetailsParamsBuilderInternalInstance = obj;
        }

        public SkuDetailsParamsBridge build() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
            return new SkuDetailsParamsBridge(callNonVoidMethod("build", this._skuDetailsParamsBuilderInternalInstance, new Object[0]));
        }

        public String getClassName() {
            return InAppPurchaseSkuDetailsWrapper.CLASSNAME_SKU_DETAILS_PARAMS_BUILDER;
        }

        public BuilderBridge setSkuList(List<String> list) {
            this._skuDetailsParamsBuilderInternalInstance = callNonVoidMethod("setSkusList", this._skuDetailsParamsBuilderInternalInstance, list);
            return this;
        }

        public BuilderBridge setType(String str) {
            this._skuDetailsParamsBuilderInternalInstance = callNonVoidMethod("setType", this._skuDetailsParamsBuilderInternalInstance, str);
            return this;
        }
    }

    public SkuDetailsParamsBridge(Object obj) {
        super(new HashMap<String, Class[]>() {
            {
                put("newBuilder", new Class[0]);
            }
        });
        this._skuDetailsParamsInternalInstance = obj;
    }

    public static Object callNonVoidStaticMethod(String str, Object... objArr) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        return getClassForBridge().getMethod(str, (Class[]) staticMethods.get(str)).invoke((Object) null, objArr);
    }

    public static Class<?> getClassForBridge() throws ClassNotFoundException {
        return Class.forName(InAppPurchaseSkuDetailsWrapper.CLASSNAME_SKU_DETAILS_PARAMS);
    }

    public static BuilderBridge newBuilder() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        return new BuilderBridge(callNonVoidStaticMethod("newBuilder", new Object[0]));
    }

    public String getClassName() {
        return InAppPurchaseSkuDetailsWrapper.CLASSNAME_SKU_DETAILS_PARAMS;
    }

    public Object getInternalInstance() {
        return this._skuDetailsParamsInternalInstance;
    }
}
