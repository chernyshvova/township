package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdwy {
    public final Context zza;
    public final ApplicationInfo zzb;
    public final int zzc;
    public final int zzd;
    public String zze = "";

    public zzdwy(Context context) {
        this.zza = context;
        this.zzb = context.getApplicationInfo();
        this.zzc = ((Integer) zzbex.zzc().zzb(zzbjn.zzgo)).intValue();
        this.zzd = ((Integer) zzbex.zzc().zzb(zzbjn.zzgp)).intValue();
    }

    public final JSONObject zza() throws JSONException {
        Drawable drawable;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", Wrappers.packageManager(this.zza).getApplicationLabel(this.zzb.packageName));
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONObject.put(InAppPurchaseBillingClientWrapper.PACKAGE_NAME, this.zzb.packageName);
        zzs.zzc();
        jSONObject.put("adMobAppId", zzr.zzv(this.zza));
        if (this.zze.isEmpty()) {
            try {
                drawable = (Drawable) Wrappers.packageManager(this.zza).getApplicationLabelAndIcon(this.zzb.packageName).second;
            } catch (PackageManager.NameNotFoundException unused2) {
                drawable = null;
            }
            if (drawable == null) {
                str = "";
            } else {
                drawable.setBounds(0, 0, this.zzc, this.zzd);
                Bitmap createBitmap = Bitmap.createBitmap(this.zzc, this.zzd, Bitmap.Config.ARGB_8888);
                drawable.draw(new Canvas(createBitmap));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            }
            this.zze = str;
        }
        if (!this.zze.isEmpty()) {
            jSONObject.put("icon", this.zze);
            jSONObject.put("iconWidthPx", this.zzc);
            jSONObject.put("iconHeightPx", this.zzd);
        }
        return jSONObject;
    }
}
