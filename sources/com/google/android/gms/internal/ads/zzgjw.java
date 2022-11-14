package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgjw extends CustomTabsServiceConnection {
    public final WeakReference<zzbkl> zza;

    public zzgjw(zzbkl zzbkl, byte[] bArr) {
        this.zza = new WeakReference<>(zzbkl);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbkl zzbkl = (zzbkl) this.zza.get();
        if (zzbkl != null) {
            zzbkl.zzf(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzbkl zzbkl = (zzbkl) this.zza.get();
        if (zzbkl != null) {
            zzbkl.zzg();
        }
    }
}
