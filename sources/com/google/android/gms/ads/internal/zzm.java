package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzezr;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzm extends WebViewClient {
    public final /* synthetic */ zzr zza;

    public zzm(zzr zzr) {
        this.zza = zzr;
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.zza.zzg != null) {
            try {
                this.zza.zzg.zzd(zzezr.zzd(1, (String) null, (zzbdd) null));
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
        if (this.zza.zzg != null) {
            try {
                this.zza.zzg.zzc(0);
            } catch (RemoteException e2) {
                zzcgs.zzl("#007 Could not call remote method.", e2);
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.zza.zzN())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            if (this.zza.zzg != null) {
                try {
                    this.zza.zzg.zzd(zzezr.zzd(3, (String) null, (zzbdd) null));
                } catch (RemoteException e) {
                    zzcgs.zzl("#007 Could not call remote method.", e);
                }
            }
            if (this.zza.zzg != null) {
                try {
                    this.zza.zzg.zzc(3);
                } catch (RemoteException e2) {
                    zzcgs.zzl("#007 Could not call remote method.", e2);
                }
            }
            this.zza.zzL(0);
            return true;
        } else if (str.startsWith("gmsg://scriptLoadFailed")) {
            if (this.zza.zzg != null) {
                try {
                    this.zza.zzg.zzd(zzezr.zzd(1, (String) null, (zzbdd) null));
                } catch (RemoteException e3) {
                    zzcgs.zzl("#007 Could not call remote method.", e3);
                }
            }
            if (this.zza.zzg != null) {
                try {
                    this.zza.zzg.zzc(0);
                } catch (RemoteException e4) {
                    zzcgs.zzl("#007 Could not call remote method.", e4);
                }
            }
            this.zza.zzL(0);
            return true;
        } else if (str.startsWith("gmsg://adResized")) {
            if (this.zza.zzg != null) {
                try {
                    this.zza.zzg.zzf();
                } catch (RemoteException e5) {
                    zzcgs.zzl("#007 Could not call remote method.", e5);
                }
            }
            this.zza.zzL(this.zza.zzK(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            if (this.zza.zzg != null) {
                try {
                    this.zza.zzg.zze();
                } catch (RemoteException e6) {
                    zzcgs.zzl("#007 Could not call remote method.", e6);
                }
            }
            zzr.zzU(this.zza, zzr.zzT(this.zza, str));
            return true;
        }
    }
}
