package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final /* synthetic */ class zaa implements Comparator {
    public static final Comparator zaa = new zaa();

    public final int compare(Object obj, Object obj2) {
        return ((Scope) obj).getScopeUri().compareTo(((Scope) obj2).getScopeUri());
    }
}
