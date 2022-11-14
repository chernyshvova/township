package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.swrve.sdk.rest.RESTClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class Objects {

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static final class ToStringHelper {
        public final List<String> zza = new ArrayList();
        public final Object zzb;

        public /* synthetic */ ToStringHelper(Object obj, zzag zzag) {
            Preconditions.checkNotNull(obj);
            this.zzb = obj;
        }

        @RecentlyNonNull
        @KeepForSdk
        public ToStringHelper add(@RecentlyNonNull String str, @Nullable Object obj) {
            List<String> list = this.zza;
            Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(str.length() + 1 + valueOf.length());
            sb.append(str);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.zzb.getClass().getSimpleName());
            sb.append('{');
            int size = this.zza.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.zza.get(i));
                if (i < size - 1) {
                    sb.append(RESTClient.COMMA_SEPARATOR);
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public Objects() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static boolean checkBundlesEquality(@RecentlyNonNull Bundle bundle, @RecentlyNonNull Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return bundle == bundle2;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        Set<String> keySet = bundle.keySet();
        if (!keySet.containsAll(bundle2.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!equal(bundle.get(str), bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    @KeepForSdk
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @KeepForSdk
    public static int hashCode(@RecentlyNonNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static ToStringHelper toStringHelper(@RecentlyNonNull Object obj) {
        return new ToStringHelper(obj, (zzag) null);
    }
}
