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
public abstract class BroadcastReceiverConstraintTracker<T> extends ConstraintTracker<T> {
    public static final String TAG = Logger.tagWithPrefix("BrdcstRcvrCnstrntTrckr");
    public final BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                BroadcastReceiverConstraintTracker.this.onBroadcastReceive(context, intent);
            }
        }
    };

    public BroadcastReceiverConstraintTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public abstract IntentFilter getIntentFilter();

    public abstract void onBroadcastReceive(Context context, @NonNull Intent intent);

    public void startTracking() {
        Logger.get().debug(TAG, String.format("%s: registering receiver", new Object[]{getClass().getSimpleName()}), new Throwable[0]);
        this.mAppContext.registerReceiver(this.mBroadcastReceiver, getIntentFilter());
    }

    public void stopTracking() {
        Logger.get().debug(TAG, String.format("%s: unregistering receiver", new Object[]{getClass().getSimpleName()}), new Throwable[0]);
        this.mAppContext.unregisterReceiver(this.mBroadcastReceiver);
    }
}
