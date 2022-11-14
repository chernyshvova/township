package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.C1620R;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbyn extends zzbyq {
    public final Map<String, String> zza;
    public final Context zzb;

    public zzbyn(zzcmr zzcmr, Map<String, String> map) {
        super(zzcmr, "storePicture");
        this.zza = map;
        this.zzb = zzcmr.zzj();
    }

    public final void zza() {
        if (this.zzb == null) {
            zzf("Activity context is not available");
            return;
        }
        zzs.zzc();
        if (!new zzbiy(this.zzb).zza()) {
            zzf("Feature is not supported by the device.");
            return;
        }
        String str = this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzf("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzf(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzs.zzc();
            if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
                Resources zzf = zzs.zzg().zzf();
                zzs.zzc();
                AlertDialog.Builder builder = new AlertDialog.Builder(this.zzb);
                builder.setTitle(zzf != null ? zzf.getString(C1620R.string.f2766s1) : "Save image");
                builder.setMessage(zzf != null ? zzf.getString(C1620R.string.f2767s2) : "Allow Ad to store image in Picture gallery?");
                builder.setPositiveButton(zzf != null ? zzf.getString(C1620R.string.f2768s3) : "Accept", new zzbyl(this, str, lastPathSegment));
                builder.setNegativeButton(zzf != null ? zzf.getString(C1620R.string.f2769s4) : "Decline", new zzbym(this));
                builder.create().show();
                return;
            }
            String valueOf2 = String.valueOf(lastPathSegment);
            zzf(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
        }
    }
}
