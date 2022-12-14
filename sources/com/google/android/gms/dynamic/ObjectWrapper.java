package com.google.android.gms.dynamic;

import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

@RetainForClient
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ObjectWrapper<T> extends IObjectWrapper.Stub {
    public final T zza;

    public ObjectWrapper(T t) {
        this.zza = t;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <T> T unwrap(@RecentlyNonNull IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return ((ObjectWrapper) iObjectWrapper).zza;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i == 1) {
            Preconditions.checkNotNull(field);
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return field.get(asBinder);
                } catch (NullPointerException e) {
                    throw new IllegalArgumentException("Binder object is null.", e);
                } catch (IllegalAccessException e2) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
                }
            } else {
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline9(64, "Unexpected number of IObjectWrapper declared fields: ", declaredFields.length));
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <T> IObjectWrapper wrap(@RecentlyNonNull T t) {
        return new ObjectWrapper(t);
    }
}
