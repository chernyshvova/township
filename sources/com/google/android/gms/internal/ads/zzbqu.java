package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.p033h5.OnH5AdsEventListener;
import com.google.android.gms.common.internal.Preconditions;

@RequiresApi(api = 21)
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbqu {
    public final Context zza;
    public final OnH5AdsEventListener zzb;
    @Nullable
    public zzbqq zzc;

    public zzbqu(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        Preconditions.checkState(Build.VERSION.SDK_INT >= 21, "Android version must be Lollipop or higher");
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onH5AdsEventListener);
        this.zza = context;
        this.zzb = onH5AdsEventListener;
    }

    public static final boolean zzc(String str) {
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzgu)).booleanValue()) {
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.length() > ((Integer) zzbex.zzc().zzb(zzbjn.zzgw)).intValue()) {
            zzcgs.zzd("H5 GMSG exceeds max length");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!"gmsg".equals(parse.getScheme()) || !"mobileads.google.com".equals(parse.getHost()) || !"/h5ads".equals(parse.getPath())) {
            return false;
        }
        return true;
    }

    private final void zzd() {
        if (this.zzc == null) {
            this.zzc = zzbev.zzb().zzj(this.zza, new zzbve(), this.zzb);
        }
    }

    public final boolean zza(String str) {
        if (!zzc(str)) {
            return false;
        }
        zzd();
        zzbqq zzbqq = this.zzc;
        if (zzbqq == null) {
            return false;
        }
        try {
            zzbqq.zze(str);
            return true;
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            return true;
        }
    }

    public final void zzb() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgu)).booleanValue()) {
            zzd();
            zzbqq zzbqq = this.zzc;
            if (zzbqq != null) {
                try {
                    zzbqq.zzf();
                } catch (RemoteException e) {
                    zzcgs.zzl("#007 Could not call remote method.", e);
                }
            }
        }
    }
}
