package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdqd extends zzbnb {
    public final Context zza;
    public final zzdma zzb;
    public zzdmz zzc;
    public zzdlv zzd;

    public zzdqd(Context context, zzdma zzdma, zzdmz zzdmz, zzdlv zzdlv) {
        this.zza = context;
        this.zzb = zzdma;
        this.zzc = zzdmz;
        this.zzd = zzdlv;
    }

    public final String zze(String str) {
        return this.zzb.zzY().get(str);
    }

    public final zzbmi zzf(String str) {
        return this.zzb.zzV().get(str);
    }

    public final List<String> zzg() {
        SimpleArrayMap<String, zzbls> zzV = this.zzb.zzV();
        SimpleArrayMap<String, String> zzY = this.zzb.zzY();
        String[] strArr = new String[(zzY.size() + zzV.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzV.size()) {
            strArr[i3] = zzV.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < zzY.size()) {
            strArr[i3] = zzY.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public final String zzh() {
        return this.zzb.zzQ();
    }

    public final void zzi(String str) {
        zzdlv zzdlv = this.zzd;
        if (zzdlv != null) {
            zzdlv.zza(str);
        }
    }

    public final void zzj() {
        zzdlv zzdlv = this.zzd;
        if (zzdlv != null) {
            zzdlv.zzb();
        }
    }

    public final zzbhg zzk() {
        return this.zzb.zzw();
    }

    public final void zzl() {
        zzdlv zzdlv = this.zzd;
        if (zzdlv != null) {
            zzdlv.zzT();
        }
        this.zzd = null;
        this.zzc = null;
    }

    public final IObjectWrapper zzm() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final boolean zzn(IObjectWrapper iObjectWrapper) {
        zzdmz zzdmz;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdmz = this.zzc) == null || !zzdmz.zzd((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzR().zzap(new zzdqc(this));
        return true;
    }

    public final boolean zzo() {
        zzdlv zzdlv = this.zzd;
        if ((zzdlv == null || zzdlv.zzE()) && this.zzb.zzT() != null && this.zzb.zzR() == null) {
            return true;
        }
        return false;
    }

    public final boolean zzp() {
        IObjectWrapper zzU = this.zzb.zzU();
        if (zzU != null) {
            zzs.zzr().zzh(zzU);
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzdu)).booleanValue() || this.zzb.zzT() == null) {
                return true;
            }
            this.zzb.zzT().zze("onSdkLoaded", new ArrayMap());
            return true;
        }
        zzcgs.zzi("Trying to start OMID session before creation.");
        return false;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) {
        zzdlv zzdlv;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzb.zzU() != null && (zzdlv = this.zzd) != null) {
            zzdlv.zzF((View) unwrap);
        }
    }

    public final void zzr() {
        String zzX = this.zzb.zzX();
        if ("Google".equals(zzX)) {
            zzcgs.zzi("Illegal argument specified for omid partner name.");
        } else if (TextUtils.isEmpty(zzX)) {
            zzcgs.zzi("Not starting OMID session. OM partner name has not been configured.");
        } else {
            zzdlv zzdlv = this.zzd;
            if (zzdlv != null) {
                zzdlv.zzD(zzX, false);
            }
        }
    }
}
