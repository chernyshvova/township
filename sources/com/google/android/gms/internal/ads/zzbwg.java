package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbwg extends zzbvj {
    public final Object zza;
    public zzbwi zzb;
    public zzccl zzc;
    public IObjectWrapper zzd;
    public View zze;
    public MediationInterstitialAd zzf;
    public UnifiedNativeAdMapper zzg;
    public MediationRewardedAd zzh;
    public MediationInterscrollerAd zzi;
    public final String zzj = "";

    public zzbwg(@NonNull Adapter adapter) {
        this.zza = adapter;
    }

    private final Bundle zzR(String str, zzbdk zzbdk, String str2) throws RemoteException {
        String str3;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str3 = "Server parameters: ".concat(valueOf);
        } else {
            str3 = new String("Server parameters: ");
        }
        zzcgs.zzd(str3);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zza instanceof AdMobAdapter) {
                bundle.putString(AdMobAdapter.AD_JSON_PARAMETER, str2);
                if (zzbdk != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzbdk.zzg);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            throw GeneratedOutlineSupport.outline6("", th);
        }
    }

    private final Bundle zzS(zzbdk zzbdk) {
        Bundle bundle;
        Bundle bundle2 = zzbdk.zzm;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    public static final boolean zzT(zzbdk zzbdk) {
        if (zzbdk.zzf) {
            return true;
        }
        zzbev.zza();
        return zzcgl.zzm();
    }

    @Nullable
    public static final String zzU(String str, zzbdk zzbdk) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzbdk.zzu;
        }
    }

    public final void zzA(boolean z) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
            } catch (Throwable th) {
                zzcgs.zzg("", th);
            }
        } else {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzcgs.zzd(sb.toString());
        }
    }

    public final zzbhg zzB() {
        Object obj = this.zza;
        if (obj instanceof zzb) {
            try {
                return ((zzb) obj).getVideoController();
            } catch (Throwable th) {
                zzcgs.zzg("", th);
            }
        }
        return null;
    }

    public final zzbvw zzC() {
        UnifiedNativeAdMapper unifiedNativeAdMapper;
        UnifiedNativeAdMapper zzd2;
        Object obj = this.zza;
        if (obj instanceof MediationNativeAdapter) {
            zzbwi zzbwi = this.zzb;
            if (zzbwi == null || (zzd2 = zzbwi.zzd()) == null) {
                return null;
            }
            return new zzbwz(zzd2);
        } else if (!(obj instanceof Adapter) || (unifiedNativeAdMapper = this.zzg) == null) {
            return null;
        } else {
            return new zzbwz(unifiedNativeAdMapper);
        }
    }

    public final void zzD(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, zzbvn zzbvn) throws RemoteException {
        zzbdk zzbdk2 = zzbdk;
        String str2 = str;
        if (this.zza instanceof Adapter) {
            zzcgs.zzd("Requesting rewarded ad from adapter.");
            try {
                zzbwf zzbwf = new zzbwf(this, zzbvn);
                Bundle zzR = zzR(str2, zzbdk2, (String) null);
                Bundle zzS = zzS(zzbdk2);
                boolean zzT = zzT(zzbdk);
                Location location = zzbdk2.zzk;
                int i = zzbdk2.zzg;
                int i2 = zzbdk2.zzt;
                String zzU = zzU(str2, zzbdk2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzR, zzS, zzT, location, i, i2, zzU, "");
                ((Adapter) this.zza).loadRewardedAd(mediationRewardedAdConfiguration, zzbwf);
            } catch (Exception e) {
                zzcgs.zzg("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzcgs.zzi(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzE(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zza instanceof Adapter) {
            zzcgs.zzd("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzh;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzcgs.zzf("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzcgs.zzi(sb.toString());
            throw new RemoteException();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzF(com.google.android.gms.dynamic.IObjectWrapper r9, com.google.android.gms.internal.ads.zzbrq r10, java.util.List<com.google.android.gms.internal.ads.zzbrw> r11) throws android.os.RemoteException {
        /*
            r8 = this;
            java.lang.Object r0 = r8.zza
            boolean r0 = r0 instanceof com.google.android.gms.ads.mediation.Adapter
            if (r0 == 0) goto L_0x0096
            com.google.android.gms.internal.ads.zzbwb r0 = new com.google.android.gms.internal.ads.zzbwb
            r0.<init>(r8, r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Iterator r11 = r11.iterator()
        L_0x0014:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x0088
            java.lang.Object r1 = r11.next()
            com.google.android.gms.internal.ads.zzbrw r1 = (com.google.android.gms.internal.ads.zzbrw) r1
            java.lang.String r2 = r1.zza
            int r3 = r2.hashCode()
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r3) {
                case -1396342996: goto L_0x0056;
                case -1052618729: goto L_0x004c;
                case -239580146: goto L_0x0042;
                case 604727084: goto L_0x0038;
                case 1911491517: goto L_0x002e;
                default: goto L_0x002d;
            }
        L_0x002d:
            goto L_0x0060
        L_0x002e:
            java.lang.String r3 = "rewarded_interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = 3
            goto L_0x0061
        L_0x0038:
            java.lang.String r3 = "interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = 1
            goto L_0x0061
        L_0x0042:
            java.lang.String r3 = "rewarded"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = 2
            goto L_0x0061
        L_0x004c:
            java.lang.String r3 = "native"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = 4
            goto L_0x0061
        L_0x0056:
            java.lang.String r3 = "banner"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0060
            r2 = 0
            goto L_0x0061
        L_0x0060:
            r2 = -1
        L_0x0061:
            if (r2 == 0) goto L_0x0079
            if (r2 == r7) goto L_0x0076
            if (r2 == r6) goto L_0x0073
            if (r2 == r5) goto L_0x0070
            if (r2 == r4) goto L_0x006d
            r2 = 0
            goto L_0x007b
        L_0x006d:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.NATIVE
            goto L_0x007b
        L_0x0070:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.REWARDED_INTERSTITIAL
            goto L_0x007b
        L_0x0073:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.REWARDED
            goto L_0x007b
        L_0x0076:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.INTERSTITIAL
            goto L_0x007b
        L_0x0079:
            com.google.android.gms.ads.AdFormat r2 = com.google.android.gms.ads.AdFormat.BANNER
        L_0x007b:
            if (r2 == 0) goto L_0x0014
            com.google.android.gms.ads.mediation.MediationConfiguration r3 = new com.google.android.gms.ads.mediation.MediationConfiguration
            android.os.Bundle r1 = r1.zzb
            r3.<init>(r2, r1)
            r10.add(r3)
            goto L_0x0014
        L_0x0088:
            java.lang.Object r11 = r8.zza
            com.google.android.gms.ads.mediation.Adapter r11 = (com.google.android.gms.ads.mediation.Adapter) r11
            java.lang.Object r9 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r9)
            android.content.Context r9 = (android.content.Context) r9
            r11.initialize(r9, r0, r10)
            return
        L_0x0096:
            android.os.RemoteException r9 = new android.os.RemoteException
            r9.<init>()
            goto L_0x009d
        L_0x009c:
            throw r9
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbwg.zzF(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzbrq, java.util.List):void");
    }

    public final void zzG(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, zzbvn zzbvn) throws RemoteException {
        zzbdk zzbdk2 = zzbdk;
        String str2 = str;
        if (this.zza instanceof Adapter) {
            zzcgs.zzd("Requesting rewarded interstitial ad from adapter.");
            try {
                zzbwf zzbwf = new zzbwf(this, zzbvn);
                Bundle zzR = zzR(str2, zzbdk2, (String) null);
                Bundle zzS = zzS(zzbdk2);
                boolean zzT = zzT(zzbdk);
                Location location = zzbdk2.zzk;
                int i = zzbdk2.zzg;
                int i2 = zzbdk2.zzt;
                String zzU = zzU(str2, zzbdk2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzR, zzS, zzT, location, i, i2, zzU, "");
                ((Adapter) this.zza).loadRewardedInterstitialAd(mediationRewardedAdConfiguration, zzbwf);
            } catch (Exception e) {
                zzcgs.zzg("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzcgs.zzi(sb.toString());
            throw new RemoteException();
        }
    }

    public final zzbyb zzH() {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzbyb.zza(((Adapter) obj).getVersionInfo());
    }

    public final zzbyb zzI() {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzbyb.zza(((Adapter) obj).getSDKVersionInfo());
    }

    public final void zzJ(IObjectWrapper iObjectWrapper, zzbdp zzbdp, zzbdk zzbdk, String str, String str2, zzbvn zzbvn) throws RemoteException {
        zzbdp zzbdp2 = zzbdp;
        zzbdk zzbdk2 = zzbdk;
        String str3 = str;
        if (this.zza instanceof Adapter) {
            zzcgs.zzd("Requesting interscroller ad from adapter.");
            try {
                Adapter adapter = (Adapter) this.zza;
                zzbwa zzbwa = new zzbwa(this, zzbvn, adapter);
                Bundle zzR = zzR(str3, zzbdk2, str2);
                Bundle zzS = zzS(zzbdk2);
                boolean zzT = zzT(zzbdk);
                Location location = zzbdk2.zzk;
                int i = zzbdk2.zzg;
                int i2 = zzbdk2.zzt;
                String zzU = zzU(str3, zzbdk2);
                AdSize zzc2 = zza.zzc(zzbdp2.zze, zzbdp2.zzb);
                MediationBannerAdConfiguration mediationBannerAdConfiguration = r6;
                MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzR, zzS, zzT, location, i, i2, zzU, zzc2, "");
                adapter.loadInterscrollerAd(mediationBannerAdConfiguration, zzbwa);
            } catch (Exception e) {
                zzcgs.zzg("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzcgs.zzi(sb.toString());
            throw new RemoteException();
        }
    }

    public final zzbvq zzK() {
        MediationInterscrollerAd mediationInterscrollerAd = this.zzi;
        if (mediationInterscrollerAd != null) {
            return new zzbwh(mediationInterscrollerAd);
        }
        return null;
    }

    public final void zzL(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter) && !(obj instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(canonicalName).length(), 26, String.valueOf(canonicalName2).length(), String.valueOf(canonicalName3).length()));
            GeneratedOutlineSupport.outline34(sb, canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzcgs.zzi(sb.toString());
            throw new RemoteException();
        } else if (obj instanceof MediationInterstitialAdapter) {
            zzh();
        } else {
            zzcgs.zzd("Show interstitial ad from adapter.");
            MediationInterstitialAd mediationInterstitialAd = this.zzf;
            if (mediationInterstitialAd != null) {
                mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzcgs.zzf("Can not show null mediation interstitial ad.");
                throw new RemoteException();
            }
        }
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
        Object obj = this.zza;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                throw GeneratedOutlineSupport.outline6("", th);
            }
        } else if (obj instanceof Adapter) {
            return ObjectWrapper.wrap(this.zze);
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(canonicalName).length(), 26, String.valueOf(canonicalName2).length(), String.valueOf(canonicalName3).length()));
            GeneratedOutlineSupport.outline34(sb, canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzcgs.zzi(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, zzbvn zzbvn) throws RemoteException {
        zzk(iObjectWrapper, zzbdk, str, (String) null, zzbvn);
    }

    public final void zzh() throws RemoteException {
        if (this.zza instanceof MediationInterstitialAdapter) {
            zzcgs.zzd("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zza).showInterstitial();
            } catch (Throwable th) {
                throw GeneratedOutlineSupport.outline6("", th);
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzcgs.zzi(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzi() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                throw GeneratedOutlineSupport.outline6("", th);
            }
        }
    }

    public final void zzj(IObjectWrapper iObjectWrapper, zzbdp zzbdp, zzbdk zzbdk, String str, String str2, zzbvn zzbvn) throws RemoteException {
        AdSize adSize;
        Date date;
        zzbdp zzbdp2 = zzbdp;
        zzbdk zzbdk2 = zzbdk;
        String str3 = str;
        String str4 = str2;
        zzbvn zzbvn2 = zzbvn;
        Object obj = this.zza;
        if ((obj instanceof MediationBannerAdapter) || (obj instanceof Adapter)) {
            zzcgs.zzd("Requesting banner ad from adapter.");
            if (zzbdp2.zzn) {
                adSize = zza.zzb(zzbdp2.zze, zzbdp2.zzb);
            } else {
                adSize = zza.zza(zzbdp2.zze, zzbdp2.zzb, zzbdp2.zza);
            }
            AdSize adSize2 = adSize;
            Object obj2 = this.zza;
            if (obj2 instanceof MediationBannerAdapter) {
                try {
                    MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) obj2;
                    List<String> list = zzbdk2.zze;
                    HashSet hashSet = list != null ? new HashSet(list) : null;
                    long j = zzbdk2.zzb;
                    if (j == -1) {
                        date = null;
                    } else {
                        date = new Date(j);
                    }
                    zzbvz zzbvz = new zzbvz(date, zzbdk2.zzd, hashSet, zzbdk2.zzk, zzT(zzbdk), zzbdk2.zzg, zzbdk2.zzr, zzbdk2.zzt, zzU(str3, zzbdk2));
                    Bundle bundle = zzbdk2.zzm;
                    mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzbwi(zzbvn2), zzR(str3, zzbdk2, str4), adSize2, zzbvz, bundle != null ? bundle.getBundle(mediationBannerAdapter.getClass().getName()) : null);
                } catch (Throwable th) {
                    throw GeneratedOutlineSupport.outline6("", th);
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    zzbwc zzbwc = new zzbwc(this, zzbvn2);
                    Bundle zzR = zzR(str3, zzbdk2, str4);
                    Bundle zzS = zzS(zzbdk2);
                    boolean zzT = zzT(zzbdk);
                    Location location = zzbdk2.zzk;
                    int i = zzbdk2.zzg;
                    int i2 = zzbdk2.zzt;
                    String zzU = zzU(str3, zzbdk2);
                    String str5 = this.zzj;
                    MediationBannerAdConfiguration mediationBannerAdConfiguration = r2;
                    MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzR, zzS, zzT, location, i, i2, zzU, adSize2, str5);
                    ((Adapter) obj2).loadBannerAd(mediationBannerAdConfiguration, zzbwc);
                } catch (Throwable th2) {
                    throw GeneratedOutlineSupport.outline6("", th2);
                }
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(canonicalName).length(), 26, String.valueOf(canonicalName2).length(), String.valueOf(canonicalName3).length()));
            GeneratedOutlineSupport.outline34(sb, canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzcgs.zzi(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, String str2, zzbvn zzbvn) throws RemoteException {
        Date date;
        zzbdk zzbdk2 = zzbdk;
        String str3 = str;
        String str4 = str2;
        zzbvn zzbvn2 = zzbvn;
        Object obj = this.zza;
        if ((obj instanceof MediationInterstitialAdapter) || (obj instanceof Adapter)) {
            zzcgs.zzd("Requesting interstitial ad from adapter.");
            Object obj2 = this.zza;
            if (obj2 instanceof MediationInterstitialAdapter) {
                try {
                    MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) obj2;
                    List<String> list = zzbdk2.zze;
                    HashSet hashSet = list != null ? new HashSet(list) : null;
                    long j = zzbdk2.zzb;
                    if (j == -1) {
                        date = null;
                    } else {
                        date = new Date(j);
                    }
                    zzbvz zzbvz = new zzbvz(date, zzbdk2.zzd, hashSet, zzbdk2.zzk, zzT(zzbdk), zzbdk2.zzg, zzbdk2.zzr, zzbdk2.zzt, zzU(str3, zzbdk2));
                    Bundle bundle = zzbdk2.zzm;
                    mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzbwi(zzbvn2), zzR(str3, zzbdk2, str4), zzbvz, bundle != null ? bundle.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
                } catch (Throwable th) {
                    throw GeneratedOutlineSupport.outline6("", th);
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzR(str3, zzbdk2, str4), zzS(zzbdk2), zzT(zzbdk), zzbdk2.zzk, zzbdk2.zzg, zzbdk2.zzt, zzU(str3, zzbdk2), this.zzj), new zzbwd(this, zzbvn2));
                } catch (Throwable th2) {
                    throw GeneratedOutlineSupport.outline6("", th2);
                }
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(canonicalName).length(), 26, String.valueOf(canonicalName2).length(), String.valueOf(canonicalName3).length()));
            GeneratedOutlineSupport.outline34(sb, canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzcgs.zzi(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzl() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                throw GeneratedOutlineSupport.outline6("", th);
            }
        }
    }

    public final void zzm() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                throw GeneratedOutlineSupport.outline6("", th);
            }
        }
    }

    public final void zzn(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, zzccl zzccl, String str2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            this.zzd = iObjectWrapper;
            this.zzc = zzccl;
            zzccl.zze(ObjectWrapper.wrap(obj));
            return;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzcgs.zzi(sb.toString());
        throw new RemoteException();
    }

    public final void zzo(zzbdk zzbdk, String str) throws RemoteException {
        zzv(zzbdk, str, (String) null);
    }

    public final void zzp() throws RemoteException {
        if (this.zza instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzh;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzd));
            } else {
                zzcgs.zzf("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzcgs.zzi(sb.toString());
            throw new RemoteException();
        }
    }

    public final boolean zzq() throws RemoteException {
        if (this.zza instanceof Adapter) {
            return this.zzc != null;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzcgs.zzi(sb.toString());
        throw new RemoteException();
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzbdk zzbdk, String str, String str2, zzbvn zzbvn, zzblw zzblw, List<String> list) throws RemoteException {
        Date date;
        zzbdk zzbdk2 = zzbdk;
        String str3 = str;
        String str4 = str2;
        zzbvn zzbvn2 = zzbvn;
        Object obj = this.zza;
        if ((obj instanceof MediationNativeAdapter) || (obj instanceof Adapter)) {
            zzcgs.zzd("Requesting native ad from adapter.");
            Object obj2 = this.zza;
            if (obj2 instanceof MediationNativeAdapter) {
                try {
                    MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj2;
                    List<String> list2 = zzbdk2.zze;
                    HashSet hashSet = list2 != null ? new HashSet(list2) : null;
                    long j = zzbdk2.zzb;
                    if (j == -1) {
                        date = null;
                    } else {
                        date = new Date(j);
                    }
                    zzbwk zzbwk = new zzbwk(date, zzbdk2.zzd, hashSet, zzbdk2.zzk, zzT(zzbdk), zzbdk2.zzg, zzblw, list, zzbdk2.zzr, zzbdk2.zzt, zzU(str3, zzbdk2));
                    Bundle bundle = zzbdk2.zzm;
                    Bundle bundle2 = bundle != null ? bundle.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                    this.zzb = new zzbwi(zzbvn2);
                    mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzb, zzR(str3, zzbdk2, str4), zzbwk, bundle2);
                } catch (Throwable th) {
                    throw GeneratedOutlineSupport.outline6("", th);
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzR(str3, zzbdk2, str4), zzS(zzbdk2), zzT(zzbdk), zzbdk2.zzk, zzbdk2.zzg, zzbdk2.zzt, zzU(str3, zzbdk2), this.zzj, zzblw), new zzbwe(this, zzbvn2));
                } catch (Throwable th2) {
                    throw GeneratedOutlineSupport.outline6("", th2);
                }
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zza.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(canonicalName).length(), 26, String.valueOf(canonicalName2).length(), String.valueOf(canonicalName3).length()));
            GeneratedOutlineSupport.outline34(sb, canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzcgs.zzi(sb.toString());
            throw new RemoteException();
        }
    }

    public final Bundle zzs() {
        Object obj = this.zza;
        if (obj instanceof zzcon) {
            return ((zzcon) obj).zza();
        }
        String canonicalName = zzcon.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzcgs.zzi(sb.toString());
        return new Bundle();
    }

    public final Bundle zzt() {
        Object obj = this.zza;
        if (obj instanceof zzcoo) {
            return ((zzcoo) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzcoo.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzcgs.zzi(sb.toString());
        return new Bundle();
    }

    public final Bundle zzu() {
        return new Bundle();
    }

    public final void zzv(zzbdk zzbdk, String str, String str2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzD(this.zzd, zzbdk, str, new zzbwj((Adapter) obj, this.zzc));
            return;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zza.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzcgs.zzi(sb.toString());
        throw new RemoteException();
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zza;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    public final boolean zzx() {
        return false;
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzccl zzccl, List<String> list) throws RemoteException {
        zzcgs.zzi("Could not initialize rewarded video adapter.");
        throw new RemoteException();
    }

    public final zzbnc zzz() {
        zzbwi zzbwi = this.zzb;
        if (zzbwi == null) {
            return null;
        }
        NativeCustomTemplateAd zze2 = zzbwi.zze();
        if (zze2 instanceof zzbnd) {
            return ((zzbnd) zze2).zza();
        }
        return null;
    }

    public zzbwg(@NonNull MediationAdapter mediationAdapter) {
        this.zza = mediationAdapter;
    }
}
