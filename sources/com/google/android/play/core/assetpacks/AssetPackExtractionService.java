package com.google.android.play.core.assetpacks;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.android.billingclient.api.zzam;
import com.google.android.play.core.internal.C2292ag;
import com.helpshift.common.platform.AndroidConversationInboxDAO;
import com.swrve.sdk.SwrveNotificationConstants;

public class AssetPackExtractionService extends Service {

    /* renamed from: a */
    public Context f2864a;

    /* renamed from: b */
    public C2267j f2865b;

    /* renamed from: c */
    public C2198bb f2866c;

    /* renamed from: d */
    public final C2292ag f2867d = new C2292ag("AssetPackExtractionService");

    /* renamed from: e */
    public C2196b f2868e;

    /* renamed from: f */
    public NotificationManager f2869f;

    /* renamed from: a */
    public final synchronized void mo33150a() {
        this.f2867d.mo33278a(4, "Stopping service.", new Object[0]);
        this.f2865b.mo33267a(false);
        stopForeground(true);
        stopSelf();
    }

    /* renamed from: b */
    public final synchronized void mo33151b(Bundle bundle) {
        String string = bundle.getString(AndroidConversationInboxDAO.KEY_NOTIFICATION_TITLE);
        String string2 = bundle.getString("notification_subtext");
        long j = bundle.getLong("notification_timeout");
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("notification_on_click_intent");
        Notification.Builder timeoutAfter = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(this.f2864a, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(j) : new Notification.Builder(this.f2864a).setPriority(-2);
        if (pendingIntent != null) {
            timeoutAfter.setContentIntent(pendingIntent);
        }
        timeoutAfter.setSmallIcon(17301633).setOngoing(false).setContentTitle(string).setSubText(string2);
        if (Build.VERSION.SDK_INT >= 21) {
            timeoutAfter.setColor(bundle.getInt("notification_color")).setVisibility(-1);
        }
        Notification build = timeoutAfter.build();
        this.f2867d.mo33278a(4, "Starting foreground service.", new Object[0]);
        this.f2865b.mo33267a(true);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2869f.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", bundle.getString("notification_channel_name"), 2));
        }
        startForeground(-1883842196, build);
    }

    public final IBinder onBind(Intent intent) {
        return this.f2868e;
    }

    public final void onCreate() {
        C2210br brVar;
        super.onCreate();
        this.f2867d.mo33278a(3, "onCreate", new Object[0]);
        Context applicationContext = getApplicationContext();
        synchronized (zzam.class) {
            if (zzam.f38a == null) {
                Context applicationContext2 = applicationContext.getApplicationContext();
                if (applicationContext2 != null) {
                    applicationContext = applicationContext2;
                }
                zzam.f38a = new C2210br(new C2272n(applicationContext));
            }
            brVar = zzam.f38a;
        }
        Context context = brVar.f2977a.f3213a;
        zzam.m31b(context);
        this.f2864a = context;
        this.f2865b = brVar.f3001y.mo33167a();
        this.f2866c = brVar.f2980d.mo33167a();
        this.f2868e = new C2196b(this.f2864a, this, this.f2866c);
        this.f2869f = (NotificationManager) this.f2864a.getSystemService(SwrveNotificationConstants.PUSH_BUNDLE);
    }
}
