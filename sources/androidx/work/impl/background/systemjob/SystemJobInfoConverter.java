package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;

@RequiresApi(api = 23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemJobInfoConverter {
    public static final String EXTRA_IS_PERIODIC = "EXTRA_IS_PERIODIC";
    public static final String EXTRA_WORK_SPEC_ID = "EXTRA_WORK_SPEC_ID";
    public static final String TAG = Logger.tagWithPrefix("SystemJobInfoConverter");
    public final ComponentName mWorkServiceComponent;

    /* renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1 */
    public static /* synthetic */ class C05741 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
        static {
            /*
                androidx.work.NetworkType[] r0 = androidx.work.NetworkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$work$NetworkType = r0
                r1 = 1
                androidx.work.NetworkType r2 = androidx.work.NetworkType.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x0016 }
                androidx.work.NetworkType r3 = androidx.work.NetworkType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.work.NetworkType r3 = androidx.work.NetworkType.UNMETERED     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x0024 }
                androidx.work.NetworkType r3 = androidx.work.NetworkType.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                int[] r1 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x002b }
                androidx.work.NetworkType r2 = androidx.work.NetworkType.METERED     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 5
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobInfoConverter.C05741.<clinit>():void");
        }
    }

    @VisibleForTesting(otherwise = 3)
    public SystemJobInfoConverter(@NonNull Context context) {
        this.mWorkServiceComponent = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    @RequiresApi(24)
    public static JobInfo.TriggerContentUri convertContentUriTrigger(ContentUriTriggers.Trigger trigger) {
        return new JobInfo.TriggerContentUri(trigger.getUri(), trigger.shouldTriggerForDescendants() ? 1 : 0);
    }

    public static int convertNetworkType(NetworkType networkType) {
        int ordinal = networkType.ordinal();
        if (ordinal == 0) {
            return 0;
        }
        if (ordinal == 1) {
            return 1;
        }
        if (ordinal == 2) {
            return 2;
        }
        if (ordinal != 3) {
            if (ordinal == 4 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        Logger.get().debug(TAG, String.format("API version too low. Cannot convert network type value %s", new Object[]{networkType}), new Throwable[0]);
        return 1;
    }

    public JobInfo convert(WorkSpec workSpec, int i) {
        Constraints constraints = workSpec.constraints;
        int convertNetworkType = convertNetworkType(constraints.getRequiredNetworkType());
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(EXTRA_WORK_SPEC_ID, workSpec.f34id);
        persistableBundle.putBoolean(EXTRA_IS_PERIODIC, workSpec.isPeriodic());
        JobInfo.Builder extras = new JobInfo.Builder(i, this.mWorkServiceComponent).setRequiredNetworkType(convertNetworkType).setRequiresCharging(constraints.requiresCharging()).setRequiresDeviceIdle(constraints.requiresDeviceIdle()).setExtras(persistableBundle);
        if (!constraints.requiresDeviceIdle()) {
            extras.setBackoffCriteria(workSpec.backoffDelayDuration, workSpec.backoffPolicy == BackoffPolicy.LINEAR ? 0 : 1);
        }
        long max = Math.max(workSpec.calculateNextRunTime() - System.currentTimeMillis(), 0);
        if (Build.VERSION.SDK_INT <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else {
            extras.setImportantWhileForeground(true);
        }
        if (Build.VERSION.SDK_INT >= 24 && constraints.hasContentUriTriggers()) {
            for (ContentUriTriggers.Trigger convertContentUriTrigger : constraints.getContentUriTriggers().getTriggers()) {
                extras.addTriggerContentUri(convertContentUriTrigger(convertContentUriTrigger));
            }
            extras.setTriggerContentUpdateDelay(constraints.getTriggerContentUpdateDelay());
            extras.setTriggerContentMaxDelay(constraints.getTriggerMaxContentDelay());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(constraints.requiresBatteryNotLow());
            extras.setRequiresStorageNotLow(constraints.requiresStorageNotLow());
        }
        return extras.build();
    }
}
