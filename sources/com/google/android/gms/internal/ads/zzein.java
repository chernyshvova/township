package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzdcn;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzein<AdT, AdapterT, ListenerT extends zzdcn> implements zzedn<AdT> {
    public final zzedp<AdapterT, ListenerT> zza;
    public final zzedv<AdT, AdapterT, ListenerT> zzb;
    public final zzfcx zzc;
    public final zzfqo zzd;

    public zzein(zzfcx zzfcx, zzfqo zzfqo, zzedp<AdapterT, ListenerT> zzedp, zzedv<AdT, AdapterT, ListenerT> zzedv) {
        this.zzc = zzfcx;
        this.zzd = zzfqo;
        this.zzb = zzedv;
        this.zza = zzedp;
    }

    @VisibleForTesting
    public static final String zze(String str, int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 31);
        sb.append("Error from: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(i);
        return sb.toString();
    }

    public final boolean zza(zzeyq zzeyq, zzeye zzeye) {
        return !zzeye.zzt.isEmpty();
    }

    public final zzfqn<AdT> zzb(zzeyq zzeyq, zzeye zzeye) {
        zzedq<AdapterT, ListenerT> zzedq;
        Class<AdMobAdapter> cls = AdMobAdapter.class;
        Iterator<String> it = zzeye.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzedq = null;
                break;
            }
            try {
                zzedq = this.zza.zza(it.next(), zzeye.zzv);
                break;
            } catch (zzezb unused) {
            }
        }
        if (zzedq == null) {
            return zzfqe.zzc(new zzegp("Unable to instantiate mediation adapter class."));
        }
        zzchj zzchj = new zzchj();
        zzedq.zzc.zza(new zzeim(this, zzedq, zzchj));
        if (zzeye.zzI) {
            Bundle bundle = zzeyq.zza.zza.zzd.zzm;
            Bundle bundle2 = bundle.getBundle(cls.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(cls.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfcx zzfcx = this.zzc;
        return zzfci.zzd(new zzeik(this, zzeyq, zzeye, zzedq), this.zzd, zzfcr.ADAPTER_LOAD_AD_SYN, zzfcx).zzj(zzfcr.ADAPTER_LOAD_AD_ACK).zze(zzchj).zzj(zzfcr.ADAPTER_WRAP_ADAPTER).zzb(new zzeil(this, zzeyq, zzeye, zzedq)).zzi();
    }

    public final /* synthetic */ Object zzc(zzeyq zzeyq, zzeye zzeye, zzedq zzedq, Void voidR) throws Exception {
        return this.zzb.zzb(zzeyq, zzeye, zzedq);
    }

    public final /* synthetic */ void zzd(zzeyq zzeyq, zzeye zzeye, zzedq zzedq) throws Exception {
        this.zzb.zza(zzeyq, zzeye, zzedq);
    }
}
