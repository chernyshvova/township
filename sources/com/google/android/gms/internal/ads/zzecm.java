package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzecm {
    public static final SparseArray<zzbbo> zzh;
    public final Context zza;
    public final zzdaj zzb;
    public final TelephonyManager zzc;
    public final zzecf zzd;
    public final zzecb zze;
    public final zzg zzf;
    public zzbap zzg;

    static {
        SparseArray<zzbbo> sparseArray = new SparseArray<>();
        zzh = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbbo.CONNECTED);
        zzh.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzbbo.CONNECTING);
        zzh.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzbbo.CONNECTING);
        zzh.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzbbo.CONNECTING);
        zzh.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbbo.DISCONNECTING);
        zzh.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzbbo.DISCONNECTED);
        zzh.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzbbo.DISCONNECTED);
        zzh.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzbbo.DISCONNECTED);
        zzh.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzbbo.DISCONNECTED);
        zzh.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzbbo.DISCONNECTED);
        zzh.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbbo.SUSPENDED);
        zzh.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzbbo.CONNECTING);
        zzh.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzbbo.CONNECTING);
    }

    public zzecm(Context context, zzdaj zzdaj, zzecf zzecf, zzecb zzecb, zzg zzg2) {
        this.zza = context;
        this.zzb = zzdaj;
        this.zzd = zzecf;
        this.zze = zzecb;
        this.zzc = (TelephonyManager) context.getSystemService("phone");
        this.zzf = zzg2;
    }

    public static /* synthetic */ zzbbf zzd(zzecm zzecm, Bundle bundle) {
        zzbbb zzbbb;
        zzbay zzf2 = zzbbf.zzf();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            zzecm.zzg = zzbap.ENUM_TRUE;
        } else {
            zzecm.zzg = zzbap.ENUM_FALSE;
            if (i == 0) {
                zzf2.zza(zzbbe.CELL);
            } else if (i != 1) {
                zzf2.zza(zzbbe.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzf2.zza(zzbbe.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbbb = zzbbb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbbb = zzbbb.THREE_G;
                    break;
                case 13:
                    zzbbb = zzbbb.zzd;
                    break;
                default:
                    zzbbb = zzbbb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzf2.zzb(zzbbb);
        }
        return (zzbbf) zzf2.zzah();
    }

    public static /* synthetic */ byte[] zzf(zzecm zzecm, boolean z, ArrayList arrayList, zzbbf zzbbf, zzbbo zzbbo) {
        zzbbj zzo = zzbbk.zzo();
        zzo.zze(arrayList);
        boolean z2 = true;
        zzo.zzh(zzg(zzs.zze().zzf(zzecm.zza.getContentResolver()) != 0));
        zzo.zzi(zzs.zze().zzq(zzecm.zza, zzecm.zzc));
        zzo.zzc(zzecm.zzd.zzd());
        zzo.zzd(zzecm.zzd.zzh());
        zzo.zzj(zzecm.zzd.zzb());
        zzo.zzl(zzbbo);
        zzo.zzf(zzbbf);
        zzo.zzk(zzecm.zzg);
        zzo.zzb(zzg(z));
        zzo.zza(zzs.zzj().currentTimeMillis());
        if (zzs.zze().zze(zzecm.zza.getContentResolver()) == 0) {
            z2 = false;
        }
        zzo.zzg(zzg(z2));
        return ((zzbbk) zzo.zzah()).zzao();
    }

    public static final zzbap zzg(boolean z) {
        return z ? zzbap.ENUM_TRUE : zzbap.ENUM_FALSE;
    }

    public final void zza(boolean z) {
        zzfqe.zzp(this.zzb.zza(), new zzecl(this, z), zzche.zzf);
    }
}
