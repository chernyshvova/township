package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzs;
import com.vungle.warren.VungleSettings;

@TargetApi(11)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcmq extends WebChromeClient {
    public final zzcmr zza;

    public zzcmq(zzcmr zzcmr) {
        this.zza = zzcmr;
    }

    public static final Context zzb(WebView webView) {
        if (!(webView instanceof zzcmr)) {
            return webView.getContext();
        }
        zzcmr zzcmr = (zzcmr) webView;
        Activity zzj = zzcmr.zzj();
        if (zzj != null) {
            return zzj;
        }
        return zzcmr.getContext();
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcmr)) {
            zzcgs.zzi("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        zzl zzN = ((zzcmr) webView).zzN();
        if (zzN == null) {
            zzcgs.zzi("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzN.zzb();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 19 + String.valueOf(sourceId).length());
        GeneratedOutlineSupport.outline34(sb, "JS: ", message, " (", sourceId);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(lineNumber);
        sb.append(")");
        String sb2 = sb.toString();
        if (sb2.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i = zzcmp.zza[consoleMessage.messageLevel().ordinal()];
        if (i == 1) {
            zzcgs.zzf(sb2);
        } else if (i == 2) {
            zzcgs.zzi(sb2);
        } else if (i == 3 || i == 4) {
            zzcgs.zzh(sb2);
        } else if (i != 5) {
            zzcgs.zzh(sb2);
        } else {
            zzcgs.zzd(sb2);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zza.zzS() != null) {
            webView2.setWebViewClient(this.zza.zzS());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > VungleSettings.MEGABYTE) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(Math.min(131072, j4) + j, VungleSettings.MEGABYTE);
        } else {
            if (j2 <= Math.min(VungleSettings.MEGABYTE - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzs.zzc();
            if (!zzr.zzE(this.zza.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzs.zzc();
                if (!zzr.zzE(this.zza.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    public final void onHideCustomView() {
        zzl zzN = this.zza.zzN();
        if (zzN == null) {
            zzcgs.zzi("Could not get ad overlay when hiding custom view.");
        } else {
            zzN.zzc();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "alert", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "onBeforeUnload", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "confirm", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzb(webView), "prompt", str, str2, str3, (JsResult) null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        long j3 = j + 131072;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    @Deprecated
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zzl zzN = this.zza.zzN();
        if (zzN == null) {
            zzcgs.zzi("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzN.zzx(view, customViewCallback);
        zzN.zzw(i);
    }

    public final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        zzb zzb;
        try {
            zzcmr zzcmr = this.zza;
            if (zzcmr == null || zzcmr.zzR() == null || this.zza.zzR().zzb() == null || (zzb = this.zza.zzR().zzb()) == null || zzb.zzb()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(str2);
                if (z) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    EditText editText = new EditText(context);
                    editText.setText(str4);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    builder.setView(linearLayout).setPositiveButton(17039370, new zzcmo(jsPromptResult, editText)).setNegativeButton(17039360, new zzcmn(jsPromptResult)).setOnCancelListener(new zzcmm(jsPromptResult)).create().show();
                } else {
                    builder.setMessage(str3).setPositiveButton(17039370, new zzcml(jsResult)).setNegativeButton(17039360, new zzcmk(jsResult)).setOnCancelListener(new zzcmj(jsResult)).create().show();
                }
                return true;
            }
            StringBuilder sb = new StringBuilder(str.length() + 11 + String.valueOf(str3).length());
            sb.append("window.");
            sb.append(str);
            sb.append("('");
            sb.append(str3);
            sb.append("')");
            zzb.zzc(sb.toString());
            return false;
        } catch (WindowManager.BadTokenException e) {
            zzcgs.zzj("Fail to display Dialog.", e);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
