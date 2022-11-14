package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbys extends NativeAd.AdChoicesInfo {
    public final List<NativeAd.Image> zza = new ArrayList();
    public String zzb;

    public zzbys(zzbma zzbma) {
        try {
            this.zzb = zzbma.zzb();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            this.zzb = "";
        }
        try {
            for (zzbmi next : zzbma.zzc()) {
                zzbmi zzg = next instanceof IBinder ? zzbmh.zzg((IBinder) next) : null;
                if (zzg != null) {
                    this.zza.add(new zzbyu(zzg));
                }
            }
        } catch (RemoteException e2) {
            zzcgs.zzg("", e2);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    public final CharSequence getText() {
        return this.zzb;
    }
}
