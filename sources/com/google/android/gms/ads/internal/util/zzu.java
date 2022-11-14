package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.SharedPreferencesUtils;

@TargetApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzu extends zzac {
    public zzu() {
        super((zzt) null);
    }

    public final boolean zza(Context context, WebSettings webSettings) {
        super.zza(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    public final String zzb(Context context) {
        String str;
        zzcf zza = zzcf.zza();
        if (TextUtils.isEmpty(zza.zza)) {
            if (ClientLibraryUtils.isPackageSide()) {
                str = (String) zzcc.zza(context, new zzcd(zza, context));
            } else {
                str = (String) zzcc.zza(context, new zzce(zza, GooglePlayServicesUtilLight.getRemoteContext(context), context));
            }
            zza.zza = str;
        }
        return zza.zza;
    }

    public final void zzc(Context context) {
        zzcf zza = zzcf.zza();
        zze.zza("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(zza.zza)) {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (!ClientLibraryUtils.isPackageSide()) {
                if (remoteContext == null) {
                    remoteContext = null;
                }
                zza.zza = defaultUserAgent;
            }
            SharedPreferences.Editor putString = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
            if (remoteContext == null) {
                putString.apply();
            } else {
                SharedPreferencesUtils.publishWorldReadableSharedPreferences(context, putString, "admob_user_agent");
            }
            zza.zza = defaultUserAgent;
        }
        zze.zza("User agent is updated.");
    }

    public final Drawable zzd(Context context, Bitmap bitmap, boolean z, float f) {
        if (!z || f <= 0.0f || f > 25.0f) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(context);
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            return new BitmapDrawable(context.getResources(), createBitmap);
        } catch (RuntimeException unused) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
    }

    public final int zze(ContentResolver contentResolver) {
        return Settings.Global.getInt(contentResolver, "wifi_on", 0);
    }

    public final int zzf(ContentResolver contentResolver) {
        return Settings.Global.getInt(contentResolver, "airplane_mode_on", 0);
    }
}
