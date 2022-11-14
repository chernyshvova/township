package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StorageNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    public static final String TAG = Logger.tagWithPrefix("StorageNotLowTracker");

    public StorageNotLowTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
        if (r6.equals("android.intent.action.DEVICE_STORAGE_OK") == false) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBroadcastReceive(android.content.Context r6, @androidx.annotation.NonNull android.content.Intent r7) {
        /*
            r5 = this;
            java.lang.String r6 = r7.getAction()
            if (r6 != 0) goto L_0x0007
            return
        L_0x0007:
            androidx.work.Logger r6 = androidx.work.Logger.get()
            java.lang.String r0 = TAG
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = r7.getAction()
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "Received %s"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            java.lang.Throwable[] r3 = new java.lang.Throwable[r4]
            r6.debug(r0, r2, r3)
            java.lang.String r6 = r7.getAction()
            r7 = -1
            int r0 = r6.hashCode()
            r2 = -1181163412(0xffffffffb998e06c, float:-2.9158907E-4)
            if (r0 == r2) goto L_0x003f
            r2 = -730838620(0xffffffffd47049a4, float:-4.12811054E12)
            if (r0 == r2) goto L_0x0036
            goto L_0x0049
        L_0x0036:
            java.lang.String r0 = "android.intent.action.DEVICE_STORAGE_OK"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            goto L_0x004a
        L_0x003f:
            java.lang.String r0 = "android.intent.action.DEVICE_STORAGE_LOW"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r4 = 1
            goto L_0x004a
        L_0x0049:
            r4 = -1
        L_0x004a:
            if (r4 == 0) goto L_0x0055
            if (r4 == r1) goto L_0x004f
            goto L_0x005a
        L_0x004f:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5.setState(r6)
            goto L_0x005a
        L_0x0055:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.setState(r6)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.StorageNotLowTracker.onBroadcastReceive(android.content.Context, android.content.Intent):void");
    }

    public Boolean getInitialState() {
        Intent registerReceiver = this.mAppContext.registerReceiver((BroadcastReceiver) null, getIntentFilter());
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return Boolean.TRUE;
        }
        String action = registerReceiver.getAction();
        char c = 65535;
        int hashCode = action.hashCode();
        if (hashCode != -1181163412) {
            if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                c = 0;
            }
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            c = 1;
        }
        if (c == 0) {
            return Boolean.TRUE;
        }
        if (c != 1) {
            return null;
        }
        return Boolean.FALSE;
    }
}
