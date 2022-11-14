package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwl<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzbvj {
    public final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zza;
    public final NETWORK_EXTRAS zzb;

    public zzbwl(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zza = mediationAdapter;
        this.zzb = network_extras;
    }

    private final SERVER_PARAMETERS zzb(String str) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                throw GeneratedOutlineSupport.outline6("", th);
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.zza.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.load(hashMap);
        return server_parameters;
    }

    public static final boolean zzc(zzbdk zzbdk) {
        if (zzbdk.zzf) {
            return true;
        }
        zzbev.zza();
        return zzcgl.zzm();
    }

    public final void zzA(boolean z) {
    }

    public final zzbhg zzB() {
        return null;
    }

    public final zzbvw zzC() {
        return null;
    }

    public final void zzD(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, zzbvn zzbvn) throws RemoteException {
    }

    public final void zzE(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzF(IObjectWrapper iObjectWrapper, zzbrq zzbrq, List<zzbrw> list) throws RemoteException {
    }

    public final void zzG(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, zzbvn zzbvn) throws RemoteException {
    }

    public final zzbyb zzH() {
        return null;
    }

    public final zzbyb zzI() {
        return null;
    }

    public final void zzJ(IObjectWrapper iObjectWrapper, zzbdp zzbdp, zzbdk zzbdk, String str, String str2, zzbvn zzbvn) {
    }

    public final zzbvq zzK() {
        return null;
    }

    public final void zzL(IObjectWrapper iObjectWrapper) {
    }

    public final zzbvs zzM() {
        return null;
    }

    public final zzbvt zzN() {
        return null;
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzbdp zzbdp, zzbdk zzbdk, String str, zzbvn zzbvn) throws RemoteException {
        zzj(iObjectWrapper, zzbdp, zzbdk, str, (String) null, zzbvn);
    }

    public final IObjectWrapper zzf() throws RemoteException {
        String str;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zza;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            if (valueOf.length() != 0) {
                str = "Not a MediationBannerAdapter: ".concat(valueOf);
            } else {
                str = new String("Not a MediationBannerAdapter: ");
            }
            zzcgs.zzi(str);
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th) {
            throw GeneratedOutlineSupport.outline6("", th);
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, zzbvn zzbvn) throws RemoteException {
        zzk(iObjectWrapper, zzbdk, str, (String) null, zzbvn);
    }

    public final void zzh() throws RemoteException {
        String str;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zza;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            if (valueOf.length() != 0) {
                str = "Not a MediationInterstitialAdapter: ".concat(valueOf);
            } else {
                str = new String("Not a MediationInterstitialAdapter: ");
            }
            zzcgs.zzi(str);
            throw new RemoteException();
        }
        zzcgs.zzd("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zza).showInterstitial();
        } catch (Throwable th) {
            throw GeneratedOutlineSupport.outline6("", th);
        }
    }

    public final void zzi() throws RemoteException {
        try {
            this.zza.destroy();
        } catch (Throwable th) {
            throw GeneratedOutlineSupport.outline6("", th);
        }
    }

    public final void zzj(IObjectWrapper iObjectWrapper, zzbdp zzbdp, zzbdk zzbdk, String str, String str2, zzbvn zzbvn) throws RemoteException {
        AdSize adSize;
        String str3;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zza;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            if (valueOf.length() != 0) {
                str3 = "Not a MediationBannerAdapter: ".concat(valueOf);
            } else {
                str3 = new String("Not a MediationBannerAdapter: ");
            }
            zzcgs.zzi(str3);
            throw new RemoteException();
        }
        zzcgs.zzd("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zza;
            zzbwx zzbwx = new zzbwx(zzbvn);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            MediationServerParameters zzb2 = zzb(str);
            int i = 0;
            AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
            while (true) {
                if (i < 6) {
                    if (adSizeArr[i].zza.getWidth() == zzbdp.zze && adSizeArr[i].zza.getHeight() == zzbdp.zzb) {
                        adSize = adSizeArr[i];
                        break;
                    }
                    i++;
                } else {
                    adSize = new AdSize(zza.zza(zzbdp.zze, zzbdp.zzb, zzbdp.zza));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzbwx, activity, zzb2, adSize, zzbwy.zzb(zzbdk, zzc(zzbdk)), this.zzb);
        } catch (Throwable th) {
            throw GeneratedOutlineSupport.outline6("", th);
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, String str2, zzbvn zzbvn) throws RemoteException {
        String str3;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zza;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            if (valueOf.length() != 0) {
                str3 = "Not a MediationInterstitialAdapter: ".concat(valueOf);
            } else {
                str3 = new String("Not a MediationInterstitialAdapter: ");
            }
            zzcgs.zzi(str3);
            throw new RemoteException();
        }
        zzcgs.zzd("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zza).requestInterstitialAd(new zzbwx(zzbvn), (Activity) ObjectWrapper.unwrap(iObjectWrapper), zzb(str), zzbwy.zzb(zzbdk, zzc(zzbdk)), this.zzb);
        } catch (Throwable th) {
            throw GeneratedOutlineSupport.outline6("", th);
        }
    }

    public final void zzl() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzm() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzn(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, zzccl zzccl, String str2) throws RemoteException {
    }

    public final void zzo(zzbdk zzbdk, String str) {
    }

    public final void zzp() {
    }

    public final boolean zzq() {
        return true;
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, String str2, zzbvn zzbvn, zzblw zzblw, List<String> list) {
    }

    public final Bundle zzs() {
        return new Bundle();
    }

    public final Bundle zzt() {
        return new Bundle();
    }

    public final Bundle zzu() {
        return new Bundle();
    }

    public final void zzv(zzbdk zzbdk, String str, String str2) {
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final boolean zzx() {
        return false;
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzccl zzccl, List<String> list) {
    }

    public final zzbnc zzz() {
        return null;
    }
}
