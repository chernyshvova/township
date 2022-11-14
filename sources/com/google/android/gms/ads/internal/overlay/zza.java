package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzcgs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zza {
    public static final boolean zza(Context context, Intent intent, zzv zzv, @Nullable zzt zzt, boolean z) {
        String str;
        if (z) {
            return zzc(context, intent.getData(), zzv, zzt);
        }
        try {
            String valueOf = String.valueOf(intent.toURI());
            if (valueOf.length() != 0) {
                str = "Launching an intent: ".concat(valueOf);
            } else {
                str = new String("Launching an intent: ");
            }
            zze.zza(str);
            zzs.zzc();
            zzr.zzP(context, intent);
            if (zzv != null) {
                zzv.zzg();
            }
            if (zzt != null) {
                zzt.zza(true);
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzcgs.zzi(e.getMessage());
            if (zzt != null) {
                zzt.zza(false);
            }
            return false;
        }
    }

    public static final boolean zzb(Context context, @Nullable zzc zzc, zzv zzv, @Nullable zzt zzt) {
        int i = 0;
        if (zzc == null) {
            zzcgs.zzi("No intent data for launcher overlay.");
            return false;
        }
        zzbjn.zza(context);
        Intent intent = zzc.zzh;
        if (intent != null) {
            return zza(context, intent, zzv, zzt, zzc.zzj);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzc.zzb)) {
            zzcgs.zzi("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzc.zzc)) {
            intent2.setDataAndType(Uri.parse(zzc.zzb), zzc.zzc);
        } else {
            intent2.setData(Uri.parse(zzc.zzb));
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzc.zzd)) {
            intent2.setPackage(zzc.zzd);
        }
        if (!TextUtils.isEmpty(zzc.zze)) {
            String[] split = zzc.zze.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzc.zze);
                zzcgs.zzi(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str = zzc.zzf;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzcgs.zzi("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzcO)).booleanValue()) {
            intent2.addFlags(DriveFile.MODE_READ_ONLY);
            intent2.putExtra(CustomTabsIntent.EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS, true);
        } else {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzcN)).booleanValue()) {
                zzs.zzc();
                zzr.zzu(context, intent2);
            }
        }
        return zza(context, intent2, zzv, zzt, zzc.zzj);
    }

    public static final boolean zzc(Context context, Uri uri, zzv zzv, zzt zzt) {
        int i;
        try {
            i = zzs.zzc().zzs(context, uri);
            if (zzv != null) {
                zzv.zzg();
            }
        } catch (ActivityNotFoundException e) {
            zzcgs.zzi(e.getMessage());
            i = 6;
        }
        if (zzt != null) {
            zzt.zzb(i);
        }
        return i == 5;
    }
}
