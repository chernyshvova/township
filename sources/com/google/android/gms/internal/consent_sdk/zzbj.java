package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.WorkerThread;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzbj implements zzi {
    public final Application zza;
    public final zzbh zzb;
    public final Handler zzc;
    public final Executor zzd;
    public final zze zze;
    public final zzaj zzf;
    public final zzat zzg;

    public zzbj(Application application, zzbh zzbh, Handler handler, Executor executor, zze zze2, zzaj zzaj, zzat zzat) {
        this.zza = application;
        this.zzb = zzbh;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zze2;
        this.zzf = zzaj;
        this.zzg = zzat;
    }

    public final void zza(int i, String str, String str2) {
        this.zzg.zza(new zzk(2, String.format(Locale.US, "WebResourceError(%d, %s): %s", new Object[]{Integer.valueOf(i), str2, str})));
    }

    public final /* synthetic */ void zzb() {
        this.zzg.zza().zza("UMP_configureFormWithAppAssets", zza((Context) this.zza));
    }

    public final void zza(String str) {
        String valueOf = String.valueOf(str);
        Log.d("UserMessagingPlatform", valueOf.length() != 0 ? "Receive consent action: ".concat(valueOf) : new String("Receive consent action: "));
        Uri parse = Uri.parse(str);
        this.zze.zza(parse.getQueryParameter("action"), parse.getQueryParameter("args"), this, this.zzf);
    }

    public final Executor zza() {
        Handler handler = this.zzc;
        handler.getClass();
        return zzbm.zza(handler);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @androidx.annotation.UiThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.String r7, org.json.JSONObject r8) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = -1
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1370505102: goto L_0x002b;
                case -278739366: goto L_0x0021;
                case 150940456: goto L_0x0017;
                case 1671672458: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0035
        L_0x000d:
            java.lang.String r0 = "dismiss"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 1
            goto L_0x0036
        L_0x0017:
            java.lang.String r0 = "browser"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 2
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "configure_app_assets"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 3
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "load_complete"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 0
            goto L_0x0036
        L_0x0035:
            r7 = -1
        L_0x0036:
            if (r7 == 0) goto L_0x0109
            if (r7 == r5) goto L_0x00a9
            if (r7 == r4) goto L_0x004a
            if (r7 == r3) goto L_0x003f
            return r2
        L_0x003f:
            java.util.concurrent.Executor r7 = r6.zzd
            com.google.android.gms.internal.consent_sdk.zzbl r8 = new com.google.android.gms.internal.consent_sdk.zzbl
            r8.<init>(r6)
            r7.execute(r8)
            return r5
        L_0x004a:
            java.lang.String r7 = "url"
            java.lang.String r7 = r8.optString(r7)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r0 = "UserMessagingPlatform"
            if (r8 == 0) goto L_0x005d
            java.lang.String r8 = "Action[browser]: empty url."
            android.util.Log.d(r0, r8)
        L_0x005d:
            android.net.Uri r8 = android.net.Uri.parse(r7)
            java.lang.String r1 = r8.getScheme()
            if (r1 != 0) goto L_0x0081
            java.lang.String r1 = "Action[browser]: empty scheme: "
            java.lang.String r2 = java.lang.String.valueOf(r7)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x0078
            java.lang.String r1 = r1.concat(r2)
            goto L_0x007e
        L_0x0078:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r1 = r2
        L_0x007e:
            android.util.Log.d(r0, r1)
        L_0x0081:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x008e }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1, r8)     // Catch:{ ActivityNotFoundException -> 0x008e }
            com.google.android.gms.internal.consent_sdk.zzbh r8 = r6.zzb     // Catch:{ ActivityNotFoundException -> 0x008e }
            r8.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x008e }
            goto L_0x00a8
        L_0x008e:
            r8 = move-exception
            java.lang.String r0 = "Action[browser]: can not open url: "
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r1 = r7.length()
            if (r1 == 0) goto L_0x00a0
            java.lang.String r7 = r0.concat(r7)
            goto L_0x00a5
        L_0x00a0:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r0)
        L_0x00a5:
            com.google.android.gms.internal.consent_sdk.zzca.zza(r7, r8)
        L_0x00a8:
            return r5
        L_0x00a9:
            java.lang.String r7 = "status"
            java.lang.String r7 = r8.optString(r7)
            int r8 = r7.hashCode()
            r0 = 4
            switch(r8) {
                case -954325659: goto L_0x00e0;
                case -258041904: goto L_0x00d6;
                case 429411856: goto L_0x00cc;
                case 467888915: goto L_0x00c2;
                case 1666911234: goto L_0x00b8;
                default: goto L_0x00b7;
            }
        L_0x00b7:
            goto L_0x00e9
        L_0x00b8:
            java.lang.String r8 = "non_personalized"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x00e9
            r1 = 2
            goto L_0x00e9
        L_0x00c2:
            java.lang.String r8 = "CONSENT_SIGNAL_PERSONALIZED_ADS"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x00e9
            r1 = 1
            goto L_0x00e9
        L_0x00cc:
            java.lang.String r8 = "CONSENT_SIGNAL_SUFFICIENT"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x00e9
            r1 = 4
            goto L_0x00e9
        L_0x00d6:
            java.lang.String r8 = "personalized"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x00e9
            r1 = 0
            goto L_0x00e9
        L_0x00e0:
            java.lang.String r8 = "CONSENT_SIGNAL_NON_PERSONALIZED_ADS"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x00e9
            r1 = 3
        L_0x00e9:
            if (r1 == 0) goto L_0x0102
            if (r1 == r5) goto L_0x0102
            if (r1 == r4) goto L_0x0100
            if (r1 == r3) goto L_0x0100
            if (r1 == r0) goto L_0x0103
            com.google.android.gms.internal.consent_sdk.zzat r7 = r6.zzg
            com.google.android.gms.internal.consent_sdk.zzk r8 = new com.google.android.gms.internal.consent_sdk.zzk
            java.lang.String r0 = "We are getting something wrong with the webview."
            r8.<init>(r5, r0)
            r7.zzb(r8)
            goto L_0x0108
        L_0x0100:
            r2 = 1
            goto L_0x0103
        L_0x0102:
            r2 = 2
        L_0x0103:
            com.google.android.gms.internal.consent_sdk.zzat r7 = r6.zzg
            r7.zza((int) r3, (int) r2)
        L_0x0108:
            return r5
        L_0x0109:
            com.google.android.gms.internal.consent_sdk.zzat r7 = r6.zzg
            r7.zzb()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzbj.zza(java.lang.String, org.json.JSONObject):boolean");
    }

    @WorkerThread
    public static JSONObject zza(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString());
            Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getApplicationInfo());
            if (applicationIcon == null) {
                str = null;
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                applicationIcon.draw(canvas);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                String valueOf = String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                str = valueOf.length() != 0 ? "data:image/png;base64,".concat(valueOf) : new String("data:image/png;base64,");
            }
            jSONObject.put("app_icon", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
