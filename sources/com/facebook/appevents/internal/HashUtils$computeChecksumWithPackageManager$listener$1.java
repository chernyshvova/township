package com.facebook.appevents.internal;

import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: HashUtils.kt */
public final class HashUtils$computeChecksumWithPackageManager$listener$1 implements InvocationHandler {
    public final /* synthetic */ Object $TYPE_WHOLE_MD5;
    public final /* synthetic */ Condition $checksumReady;
    public final /* synthetic */ ReentrantLock $lock;
    public final /* synthetic */ Ref$ObjectRef<String> $resultChecksum;

    public HashUtils$computeChecksumWithPackageManager$listener$1(Object obj, Ref$ObjectRef<String> ref$ObjectRef, ReentrantLock reentrantLock, Condition condition) {
        this.$TYPE_WHOLE_MD5 = obj;
        this.$resultChecksum = ref$ObjectRef;
        this.$lock = reentrantLock;
        this.$checksumReady = condition;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(objArr, "objects");
        try {
            if (Intrinsics.areEqual(method.getName(), "onChecksumsReady") && objArr.length == 1 && (objArr[0] instanceof List)) {
                for (Object next : objArr[0]) {
                    if (next != null) {
                        Method method2 = next.getClass().getMethod("getSplitName", new Class[0]);
                        Intrinsics.checkNotNullExpressionValue(method2, "c.javaClass.getMethod(\"getSplitName\")");
                        Method method3 = next.getClass().getMethod("getType", new Class[0]);
                        Intrinsics.checkNotNullExpressionValue(method3, "c.javaClass.getMethod(\"getType\")");
                        if (method2.invoke(next, new Object[0]) == null && Intrinsics.areEqual(method3.invoke(next, new Object[0]), this.$TYPE_WHOLE_MD5)) {
                            Method method4 = next.getClass().getMethod("getValue", new Class[0]);
                            Intrinsics.checkNotNullExpressionValue(method4, "c.javaClass.getMethod(\"getValue\")");
                            Object invoke = method4.invoke(next, new Object[0]);
                            if (invoke != null) {
                                this.$resultChecksum.element = new BigInteger(1, (byte[]) invoke).toString(16);
                                this.$lock.lock();
                                this.$checksumReady.signalAll();
                                this.$lock.unlock();
                                return null;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Log.d(HashUtils.TAG, "Can't fetch checksum.", th);
        }
        return null;
    }
}
