package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.C1620R;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.swrve.sdk.SwrveNotificationConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzedj extends zzbze {
    public final Context zza;
    public final zzduu zzb;
    public final zzcgx zzc;
    public final zzedb zzd;
    public final zzfdh zze;

    public zzedj(Context context, zzedb zzedb, zzcgx zzcgx, zzduu zzduu, zzfdh zzfdh) {
        this.zza = context;
        this.zzb = zzduu;
        this.zzc = zzcgx;
        this.zzd = zzedb;
        this.zze = zzfdh;
    }

    public static void zzc(Activity activity, @Nullable zzl zzl, zzbs zzbs, zzedb zzedb, zzduu zzduu, zzfdh zzfdh, String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        zzs.zzc();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, zzs.zze().zzm());
        Resources zzf = zzs.zzg().zzf();
        if (zzf == null) {
            str3 = "Open ad when you're back online.";
        } else {
            str3 = zzf.getString(C1620R.string.offline_opt_in_title);
        }
        AlertDialog.Builder title = builder.setTitle(str3);
        if (zzf == null) {
            str4 = "We'll send you a notification with a link to the advertiser site.";
        } else {
            str4 = zzf.getString(C1620R.string.offline_opt_in_message);
        }
        AlertDialog.Builder message = title.setMessage(str4);
        if (zzf == null) {
            str5 = "OK";
        } else {
            str5 = zzf.getString(C1620R.string.offline_opt_in_confirm);
        }
        AlertDialog.Builder positiveButton = message.setPositiveButton(str5, new zzede(zzduu, activity, zzfdh, zzedb, str, zzbs, str2, zzf, zzl));
        if (zzf == null) {
            str6 = "No thanks";
        } else {
            str6 = zzf.getString(C1620R.string.offline_opt_in_decline);
        }
        zzedb zzedb2 = zzedb;
        String str7 = str;
        zzduu zzduu2 = zzduu;
        Activity activity2 = activity;
        zzfdh zzfdh2 = zzfdh;
        zzl zzl2 = zzl;
        positiveButton.setNegativeButton(str6, new zzedf(zzedb2, str7, zzduu2, activity2, zzfdh2, zzl2)).setOnCancelListener(new zzedg(zzedb2, str7, zzduu2, activity2, zzfdh2, zzl2));
        builder.create().show();
    }

    public static void zzd(Context context, zzduu zzduu, zzfdh zzfdh, zzedb zzedb, String str, String str2) {
        zzh(context, zzduu, zzfdh, zzedb, str, str2, new HashMap());
    }

    public static void zzh(Context context, zzduu zzduu, zzfdh zzfdh, zzedb zzedb, String str, String str2, Map<String, String> map) {
        String str3;
        String str4 = "offline";
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfU)).booleanValue()) {
            zzfdg zza2 = zzfdg.zza(str2);
            zza2.zzc("gqi", str);
            zzs.zzc();
            if (true == zzr.zzI(context)) {
                str4 = "online";
            }
            zza2.zzc("device_connectivity", str4);
            zza2.zzc("event_timestamp", String.valueOf(zzs.zzj().currentTimeMillis()));
            for (Map.Entry next : map.entrySet()) {
                zza2.zzc((String) next.getKey(), (String) next.getValue());
            }
            str3 = zzfdh.zzb(zza2);
        } else {
            zzdut zza3 = zzduu.zza();
            zza3.zzc("gqi", str);
            zza3.zzc("action", str2);
            zzs.zzc();
            if (true == zzr.zzI(context)) {
                str4 = "online";
            }
            zza3.zzc("device_connectivity", str4);
            zza3.zzc("event_timestamp", String.valueOf(zzs.zzj().currentTimeMillis()));
            for (Map.Entry next2 : map.entrySet()) {
                zza3.zzc((String) next2.getKey(), (String) next2.getValue());
            }
            str3 = zza3.zze();
        }
        zzedb.zze(new zzedd(zzs.zzj().currentTimeMillis(), str, str3, 2));
    }

    private final void zzi(String str, String str2, Map<String, String> map) {
        zzh(this.zza, this.zzb, this.zze, this.zzd, str, str2, map);
    }

    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            zzs.zzc();
            boolean zzI = zzr.zzI(this.zza);
            HashMap hashMap = new HashMap();
            char c = 2;
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (true == zzI) {
                    c = 1;
                }
                hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
                try {
                    Context context = this.zza;
                    Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(DriveFile.MODE_READ_ONLY);
                    context.startActivity(launchIntentForPackage);
                    hashMap.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    hashMap.put("olaa", "olaf");
                }
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            zzi(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.zzd.getWritableDatabase();
                if (c == 1) {
                    this.zzd.zzb(writableDatabase, this.zzc, stringExtra2);
                } else {
                    zzedb.zzi(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(valueOf.length() + 51);
                sb.append("Failed to get writable offline buffering database: ");
                sb.append(valueOf);
                zzcgs.zzf(sb.toString());
            }
        }
    }

    public final void zzf(IObjectWrapper iObjectWrapper, String str, String str2) {
        String str3;
        String str4;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzs.zzc();
        if (PlatformVersion.isAtLeastO()) {
            NotificationChannel notificationChannel = new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", 2);
            notificationChannel.setShowBadge(false);
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
        Intent intent = new Intent();
        intent.setClass(context, AdService.class);
        intent.setAction("offline_notification_clicked");
        intent.putExtra("offline_notification_action", "offline_notification_clicked");
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str);
        PendingIntent zza2 = zzfjk.zza(context, 0, intent, zzfjk.zza | 1073741824, 0);
        Intent intent2 = new Intent();
        intent2.setClass(context, AdService.class);
        intent2.setAction("offline_notification_dismissed");
        intent2.putExtra("offline_notification_action", "offline_notification_dismissed");
        intent2.putExtra("gws_query_id", str2);
        PendingIntent zza3 = zzfjk.zza(context, 0, intent2, zzfjk.zza | 1073741824, 0);
        Resources zzf = zzs.zzg().zzf();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "offline_notification_channel");
        if (zzf == null) {
            str3 = "View the ad you saved when you were offline";
        } else {
            str3 = zzf.getString(C1620R.string.offline_notification_title);
        }
        NotificationCompat.Builder contentTitle = builder.setContentTitle(str3);
        if (zzf == null) {
            str4 = "Tap to open ad";
        } else {
            str4 = zzf.getString(C1620R.string.offline_notification_text);
        }
        ((NotificationManager) context.getSystemService(SwrveNotificationConstants.PUSH_BUNDLE)).notify(str2, 54321, contentTitle.setContentText(str4).setAutoCancel(true).setDeleteIntent(zza3).setContentIntent(zza2).setSmallIcon(context.getApplicationInfo().icon).build());
        zzi(str2, "offline_notification_impression", new HashMap());
    }

    public final void zzg() {
        this.zzd.zza(new zzecv(this.zzc));
    }
}
