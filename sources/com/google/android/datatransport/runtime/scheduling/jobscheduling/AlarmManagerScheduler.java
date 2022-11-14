package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.android.billingclient.api.zzam;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.drive.DriveFile;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class AlarmManagerScheduler implements WorkScheduler {
    public AlarmManager alarmManager;
    public final Clock clock;
    public final SchedulerConfig config;
    public final Context context;
    public final EventStore eventStore;

    public AlarmManagerScheduler(Context context2, EventStore eventStore2, Clock clock2, SchedulerConfig schedulerConfig) {
        this.context = context2;
        this.eventStore = eventStore2;
        this.alarmManager = (AlarmManager) context2.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.clock = clock2;
        this.config = schedulerConfig;
    }

    public void schedule(TransportContext transportContext, int i) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", ((AutoValue_TransportContext) transportContext).backendName);
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) transportContext;
        builder.appendQueryParameter("priority", String.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority)));
        byte[] bArr = autoValue_TransportContext.extras;
        if (bArr != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(bArr, 0));
        }
        Intent intent = new Intent(this.context, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i);
        if (PendingIntent.getBroadcast(this.context, 0, intent, DriveFile.MODE_WRITE_ONLY) != null) {
            zzam.m35d("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", (Object) transportContext);
            return;
        }
        long nextCallTime = this.eventStore.getNextCallTime(transportContext);
        long scheduleDelay = this.config.getScheduleDelay(autoValue_TransportContext.priority, nextCallTime, i);
        zzam.m36d("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Long.valueOf(scheduleDelay), Long.valueOf(nextCallTime), Integer.valueOf(i));
        this.alarmManager.set(3, this.clock.getTime() + scheduleDelay, PendingIntent.getBroadcast(this.context, 0, intent, 0));
    }
}
