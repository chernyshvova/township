package com.google.android.gms.ads.nativead;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbms;
import com.google.android.gms.internal.ads.zzcgs;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class NativeAdViewHolder {
    @RecentlyNonNull
    public static WeakHashMap<View, NativeAdViewHolder> zza = new WeakHashMap<>();
    @NotOnlyInitialized
    public zzbms zzb;
    public WeakReference<View> zzc;

    public NativeAdViewHolder(@RecentlyNonNull View view, @RecentlyNonNull Map<String, View> map, @RecentlyNonNull Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if (view instanceof NativeAdView) {
            zzcgs.zzf("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zza.get(view) != null) {
            zzcgs.zzf("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zza.put(view, this);
            this.zzc = new WeakReference<>(view);
            this.zzb = zzbev.zzb().zze(view, zza(map), zza(map2));
        }
    }

    public static final HashMap<String, View> zza(Map<String, View> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public final void setClickConfirmingView(@RecentlyNonNull View view) {
        try {
            this.zzb.zzd(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzcgs.zzg("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [com.google.android.gms.dynamic.IObjectWrapper, java.lang.Object] */
    public void setNativeAd(@RecentlyNonNull NativeAd nativeAd) {
        ? zza2 = nativeAd.zza();
        WeakReference<View> weakReference = this.zzc;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null) {
            zzcgs.zzi("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zza.containsKey(view)) {
            zza.put(view, this);
        }
        zzbms zzbms = this.zzb;
        if (zzbms != null) {
            try {
                zzbms.zzb(zza2);
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public void unregisterNativeAd() {
        zzbms zzbms = this.zzb;
        if (zzbms != null) {
            try {
                zzbms.zzc();
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference<View> weakReference = this.zzc;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            zza.remove(view);
        }
    }
}
