package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import com.swrve.sdk.SwrveNotificationConstants;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {
    public static final String TAG = Logger.tagWithPrefix("SystemFgService");
    @Nullable
    public static SystemForegroundService sForegroundService = null;
    public SystemForegroundDispatcher mDispatcher;
    public Handler mHandler;
    public boolean mIsShutdown;
    public NotificationManager mNotificationManager;

    @Nullable
    public static SystemForegroundService getInstance() {
        return sForegroundService;
    }

    @MainThread
    private void initializeDispatcher() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService(SwrveNotificationConstants.PUSH_BUNDLE);
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher;
        systemForegroundDispatcher.setCallback(this);
    }

    public void cancelNotification(final int i) {
        this.mHandler.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.mNotificationManager.cancel(i);
            }
        });
    }

    public void notify(final int i, @NonNull final Notification notification) {
        this.mHandler.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.mNotificationManager.notify(i, notification);
            }
        });
    }

    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        initializeDispatcher();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.mDispatcher.onDestroy();
            initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        this.mDispatcher.onStartCommand(intent);
        return 3;
    }

    public void startForeground(final int i, final int i2, @NonNull final Notification notification) {
        this.mHandler.post(new Runnable() {
            public void run() {
                if (Build.VERSION.SDK_INT >= 29) {
                    SystemForegroundService.this.startForeground(i, notification, i2);
                } else {
                    SystemForegroundService.this.startForeground(i, notification);
                }
            }
        });
    }

    @MainThread
    public void stop() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        sForegroundService = null;
        stopSelf();
    }

    public void stopForegroundService() {
        this.mHandler.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.mDispatcher.handleStop();
            }
        });
    }
}
