package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzevk {
    public static <T> void zza(AtomicReference<T> atomicReference, zzevj<T> zzevj) {
        T t = atomicReference.get();
        if (t != null) {
            try {
                zzevj.zza(t);
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            } catch (NullPointerException e2) {
                zzcgs.zzj("NullPointerException occurs when invoking a method from a delegating listener.", e2);
            }
        }
    }
}
