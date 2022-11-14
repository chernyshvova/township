package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.facebook.appevents.codeless.CodelessMatcher;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final /* synthetic */ class FcmBroadcastProcessor$$Lambda$1 implements Callable {
    public final Context arg$1;
    public final Intent arg$2;

    public FcmBroadcastProcessor$$Lambda$1(Context context, Intent intent) {
        this.arg$1 = context;
        this.arg$2 = intent;
    }

    public final Object call() {
        int i;
        ComponentName componentName;
        Context context = this.arg$1;
        Intent intent = this.arg$2;
        ServiceStarter instance = ServiceStarter.getInstance();
        String str = null;
        if (instance != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Starting service");
            }
            instance.messagingEvents.offer(intent);
            Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
            intent2.setPackage(context.getPackageName());
            synchronized (instance) {
                if (instance.firebaseMessagingServiceClassName != null) {
                    str = instance.firebaseMessagingServiceClassName;
                } else {
                    ResolveInfo resolveService = context.getPackageManager().resolveService(intent2, 0);
                    if (resolveService != null) {
                        if (resolveService.serviceInfo != null) {
                            ServiceInfo serviceInfo = resolveService.serviceInfo;
                            if (context.getPackageName().equals(serviceInfo.packageName)) {
                                if (serviceInfo.name != null) {
                                    if (serviceInfo.name.startsWith(CodelessMatcher.CURRENT_CLASS_NAME)) {
                                        String valueOf = String.valueOf(context.getPackageName());
                                        String valueOf2 = String.valueOf(serviceInfo.name);
                                        instance.firebaseMessagingServiceClassName = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                                    } else {
                                        instance.firebaseMessagingServiceClassName = serviceInfo.name;
                                    }
                                    str = instance.firebaseMessagingServiceClassName;
                                }
                            }
                            String str2 = serviceInfo.packageName;
                            String str3 = serviceInfo.name;
                            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 94 + String.valueOf(str3).length());
                            sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                            sb.append(str2);
                            sb.append("/");
                            sb.append(str3);
                            Log.e("FirebaseInstanceId", sb.toString());
                        }
                    }
                    Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
                }
            }
            if (str != null) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", str.length() != 0 ? "Restricting intent to a specific service: ".concat(str) : new String("Restricting intent to a specific service: "));
                }
                intent2.setClassName(context.getPackageName(), str);
            }
            try {
                if (instance.hasWakeLockPermission(context)) {
                    componentName = WakeLockHolder.startWakefulService(context, intent2);
                } else {
                    componentName = context.startService(intent2);
                    Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
                }
                if (componentName == null) {
                    Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                    i = 404;
                } else {
                    i = -1;
                }
            } catch (SecurityException e) {
                Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e);
                i = 401;
            } catch (IllegalStateException e2) {
                String valueOf3 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(valueOf3.length() + 45);
                sb2.append("Failed to start service while in background: ");
                sb2.append(valueOf3);
                Log.e("FirebaseInstanceId", sb2.toString());
                i = 402;
            }
            return Integer.valueOf(i);
        }
        throw null;
    }
}
