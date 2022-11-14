package com.microsoft.appcenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.DefaultChannel;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;

public abstract class AbstractAppCenterService implements AppCenterService {
    public Channel mChannel;
    public AppCenterHandler mHandler;

    @WorkerThread
    public synchronized void applyEnabledState(boolean z) {
        throw null;
    }

    public abstract Channel.GroupListener getChannelListener();

    @NonNull
    public String getEnabledPreferenceKey() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("enabled_");
        outline24.append(getServiceName());
        return outline24.toString();
    }

    public abstract String getGroupName();

    public abstract String getLoggerTag();

    public int getTriggerCount() {
        return 50;
    }

    public long getTriggerInterval() {
        return 3000;
    }

    public boolean isAppSecretRequired() {
        return true;
    }

    public synchronized boolean isInstanceEnabled() {
        return SharedPreferencesManager.getBoolean(getEnabledPreferenceKey(), true);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onApplicationEnterBackground() {
    }

    public void onApplicationEnterForeground() {
    }

    public void onConfigurationUpdated(String str, String str2) {
    }

    @WorkerThread
    public synchronized void onStarted(@NonNull Context context, @NonNull Channel channel, String str, String str2, boolean z) {
        String groupName = getGroupName();
        boolean isInstanceEnabled = isInstanceEnabled();
        if (groupName != null) {
            DefaultChannel defaultChannel = (DefaultChannel) channel;
            defaultChannel.removeGroup(groupName);
            if (isInstanceEnabled) {
                defaultChannel.addGroup(groupName, getTriggerCount(), getTriggerInterval(), 3, (Ingestion) null, getChannelListener());
            } else {
                defaultChannel.clear(groupName);
            }
        }
        this.mChannel = channel;
        applyEnabledState(isInstanceEnabled);
    }

    public final synchronized void onStarting(@NonNull AppCenterHandler appCenterHandler) {
        this.mHandler = appCenterHandler;
    }

    public synchronized void post(Runnable runnable) {
        post(runnable, (Runnable) null, (Runnable) null);
    }

    public synchronized <T> void postAsyncGetter(final Runnable runnable, final DefaultAppCenterFuture<T> defaultAppCenterFuture, final T t) {
        C29285 r0 = new Runnable(this) {
            public void run() {
                defaultAppCenterFuture.complete(t);
            }
        };
        if (!post(new Runnable(this) {
            public void run() {
                runnable.run();
            }
        }, r0, r0)) {
            r0.run();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0088, code lost:
        return;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setInstanceEnabled(boolean r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.isInstanceEnabled()     // Catch:{ all -> 0x0089 }
            r1 = 1
            r2 = 0
            r3 = 2
            if (r13 != r0) goto L_0x002a
            java.lang.String r0 = r12.getLoggerTag()     // Catch:{ all -> 0x0089 }
            java.lang.String r4 = "%s service has already been %s."
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0089 }
            java.lang.String r5 = r12.getServiceName()     // Catch:{ all -> 0x0089 }
            r3[r2] = r5     // Catch:{ all -> 0x0089 }
            if (r13 == 0) goto L_0x001d
            java.lang.String r13 = "enabled"
            goto L_0x001f
        L_0x001d:
            java.lang.String r13 = "disabled"
        L_0x001f:
            r3[r1] = r13     // Catch:{ all -> 0x0089 }
            java.lang.String r13 = java.lang.String.format(r4, r3)     // Catch:{ all -> 0x0089 }
            com.microsoft.appcenter.utils.AppCenterLog.info(r0, r13)     // Catch:{ all -> 0x0089 }
            monitor-exit(r12)
            return
        L_0x002a:
            java.lang.String r5 = r12.getGroupName()     // Catch:{ all -> 0x0089 }
            com.microsoft.appcenter.channel.Channel r0 = r12.mChannel     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x005b
            if (r5 == 0) goto L_0x005b
            if (r13 == 0) goto L_0x004d
            com.microsoft.appcenter.channel.Channel r0 = r12.mChannel     // Catch:{ all -> 0x0089 }
            int r6 = r12.getTriggerCount()     // Catch:{ all -> 0x0089 }
            long r7 = r12.getTriggerInterval()     // Catch:{ all -> 0x0089 }
            r9 = 3
            r10 = 0
            com.microsoft.appcenter.channel.Channel$GroupListener r11 = r12.getChannelListener()     // Catch:{ all -> 0x0089 }
            r4 = r0
            com.microsoft.appcenter.channel.DefaultChannel r4 = (com.microsoft.appcenter.channel.DefaultChannel) r4
            r4.addGroup(r5, r6, r7, r9, r10, r11)     // Catch:{ all -> 0x0089 }
            goto L_0x005b
        L_0x004d:
            com.microsoft.appcenter.channel.Channel r0 = r12.mChannel     // Catch:{ all -> 0x0089 }
            com.microsoft.appcenter.channel.DefaultChannel r0 = (com.microsoft.appcenter.channel.DefaultChannel) r0
            r0.clear(r5)     // Catch:{ all -> 0x0089 }
            com.microsoft.appcenter.channel.Channel r0 = r12.mChannel     // Catch:{ all -> 0x0089 }
            com.microsoft.appcenter.channel.DefaultChannel r0 = (com.microsoft.appcenter.channel.DefaultChannel) r0
            r0.removeGroup(r5)     // Catch:{ all -> 0x0089 }
        L_0x005b:
            java.lang.String r0 = r12.getEnabledPreferenceKey()     // Catch:{ all -> 0x0089 }
            com.microsoft.appcenter.utils.storage.SharedPreferencesManager.putBoolean(r0, r13)     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = r12.getLoggerTag()     // Catch:{ all -> 0x0089 }
            java.lang.String r4 = "%s service has been %s."
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0089 }
            java.lang.String r5 = r12.getServiceName()     // Catch:{ all -> 0x0089 }
            r3[r2] = r5     // Catch:{ all -> 0x0089 }
            if (r13 == 0) goto L_0x0075
            java.lang.String r2 = "enabled"
            goto L_0x0077
        L_0x0075:
            java.lang.String r2 = "disabled"
        L_0x0077:
            r3[r1] = r2     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = java.lang.String.format(r4, r3)     // Catch:{ all -> 0x0089 }
            com.microsoft.appcenter.utils.AppCenterLog.info(r0, r1)     // Catch:{ all -> 0x0089 }
            com.microsoft.appcenter.channel.Channel r0 = r12.mChannel     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x0087
            r12.applyEnabledState(r13)     // Catch:{ all -> 0x0089 }
        L_0x0087:
            monitor-exit(r12)
            return
        L_0x0089:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.AbstractAppCenterService.setInstanceEnabled(boolean):void");
    }

    public synchronized boolean post(final Runnable runnable, Runnable runnable2, final Runnable runnable3) {
        if (this.mHandler == null) {
            AppCenterLog.error("AppCenter", getServiceName() + " needs to be started before it can be used.");
            return false;
        }
        ((AppCenter.C29315) this.mHandler).post(new Runnable() {
            public void run() {
                if (AbstractAppCenterService.this.isInstanceEnabled()) {
                    runnable.run();
                    return;
                }
                Runnable runnable = runnable3;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                AppCenterLog.info("AppCenter", AbstractAppCenterService.this.getServiceName() + " service disabled, discarding calls.");
            }
        }, runnable2);
        return true;
    }
}
