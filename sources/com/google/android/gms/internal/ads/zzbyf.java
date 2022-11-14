package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbyf implements MediationInterstitialAdapter {
    public Activity zza;
    public MediationInterstitialListener zzb;
    public Uri zzc;

    public final void onDestroy() {
        zzcgs.zzd("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        zzcgs.zzd("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        zzcgs.zzd("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzb = mediationInterstitialListener;
        if (mediationInterstitialListener == null) {
            zzcgs.zzi("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzcgs.zzi("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzb.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
        } else if (!PlatformVersion.isAtLeastIceCreamSandwichMR1() || !zzbkl.zza(context)) {
            zzcgs.zzi("Default browser does not support custom tabs. Bailing out.");
            this.zzb.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
        } else {
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzcgs.zzi("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzb.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
                return;
            }
            this.zza = (Activity) context;
            this.zzc = Uri.parse(string);
            this.zzb.onAdLoaded(this);
        }
    }

    public final void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setData(this.zzc);
        zzr.zza.post(new zzbye(this, new AdOverlayInfoParcel(new zzc(build.intent, (zzt) null), (zzbcz) null, new zzbyd(this), (zzv) null, new zzcgy(0, 0, false, false, false), (zzcmr) null)));
        zzs.zzg().zzd();
    }
}
