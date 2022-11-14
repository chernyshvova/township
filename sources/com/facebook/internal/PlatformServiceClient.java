package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformServiceClient.kt */
public abstract class PlatformServiceClient implements ServiceConnection {
    public final String applicationId;
    public final Context context;
    public final Handler handler;
    public CompletedListener listener;
    public final String nonce;
    public final int protocolVersion;
    public final int replyMessage;
    public final int requestMessage;
    public boolean running;
    public Messenger sender;

    /* compiled from: PlatformServiceClient.kt */
    public interface CompletedListener {
        void completed(Bundle bundle);
    }

    public PlatformServiceClient(Context context2, int i, int i2, int i3, String str, String str2) {
        Intrinsics.checkNotNullParameter(context2, LogEntry.LOG_ITEM_CONTEXT);
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext != null ? applicationContext : context2;
        this.requestMessage = i;
        this.replyMessage = i2;
        this.applicationId = str;
        this.protocolVersion = i3;
        this.nonce = str2;
        this.handler = new Handler(this) {
            public final /* synthetic */ PlatformServiceClient this$0;

            {
                this.this$0 = r1;
            }

            public void handleMessage(Message message) {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        Intrinsics.checkNotNullParameter(message, "message");
                        this.this$0.handleMessage(message);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            }
        };
    }

    private final void callback(Bundle bundle) {
        if (this.running) {
            this.running = false;
            CompletedListener completedListener = this.listener;
            if (completedListener != null) {
                completedListener.completed(bundle);
            }
        }
    }

    private final void sendMessage() {
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.EXTRA_APPLICATION_ID, this.applicationId);
        String str = this.nonce;
        if (str != null) {
            bundle.putString(NativeProtocol.EXTRA_NONCE, str);
        }
        populateRequestBundle(bundle);
        Message obtain = Message.obtain((Handler) null, this.requestMessage);
        obtain.arg1 = this.protocolVersion;
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.handler);
        try {
            Messenger messenger = this.sender;
            if (messenger != null) {
                messenger.send(obtain);
            }
        } catch (RemoteException unused) {
            callback((Bundle) null);
        }
    }

    public final void cancel() {
        this.running = false;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.what == this.replyMessage) {
            Bundle data = message.getData();
            if (data.getString(NativeProtocol.STATUS_ERROR_TYPE) != null) {
                callback((Bundle) null);
            } else {
                callback(data);
            }
            try {
                this.context.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        Intrinsics.checkNotNullParameter(iBinder, NotificationCompat.CATEGORY_SERVICE);
        this.sender = new Messenger(iBinder);
        sendMessage();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        this.sender = null;
        try {
            this.context.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        callback((Bundle) null);
    }

    public abstract void populateRequestBundle(Bundle bundle);

    public final void setCompletedListener(CompletedListener completedListener) {
        this.listener = completedListener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean start() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.running     // Catch:{ all -> 0x002f }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            com.facebook.internal.NativeProtocol r0 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch:{ all -> 0x002f }
            int r0 = r3.protocolVersion     // Catch:{ all -> 0x002f }
            int r0 = com.facebook.internal.NativeProtocol.getLatestAvailableProtocolVersionForService(r0)     // Catch:{ all -> 0x002f }
            r2 = -1
            if (r0 != r2) goto L_0x0015
            monitor-exit(r3)
            return r1
        L_0x0015:
            com.facebook.internal.NativeProtocol r0 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch:{ all -> 0x002f }
            android.content.Context r0 = r3.getContext()     // Catch:{ all -> 0x002f }
            android.content.Intent r0 = com.facebook.internal.NativeProtocol.createPlatformServiceIntent(r0)     // Catch:{ all -> 0x002f }
            r2 = 1
            if (r0 != 0) goto L_0x0023
            goto L_0x002d
        L_0x0023:
            r3.running = r2     // Catch:{ all -> 0x002f }
            android.content.Context r1 = r3.getContext()     // Catch:{ all -> 0x002f }
            r1.bindService(r0, r3, r2)     // Catch:{ all -> 0x002f }
            r1 = 1
        L_0x002d:
            monitor-exit(r3)
            return r1
        L_0x002f:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.PlatformServiceClient.start():boolean");
    }
}
