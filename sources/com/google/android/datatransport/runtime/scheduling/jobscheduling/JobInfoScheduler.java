package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;

@RequiresApi(api = 21)
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class JobInfoScheduler implements WorkScheduler {
    public final SchedulerConfig config;
    public final Context context;
    public final EventStore eventStore;

    public JobInfoScheduler(Context context2, EventStore eventStore2, SchedulerConfig schedulerConfig) {
        this.context = context2;
        this.eventStore = eventStore2;
        this.config = schedulerConfig;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x008d, code lost:
        r5 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void schedule(com.google.android.datatransport.runtime.TransportContext r18, int r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            android.content.ComponentName r3 = new android.content.ComponentName
            android.content.Context r4 = r0.context
            java.lang.Class<com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService> r5 = com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService.class
            r3.<init>(r4, r5)
            android.content.Context r4 = r0.context
            java.lang.String r5 = "jobscheduler"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.app.job.JobScheduler r4 = (android.app.job.JobScheduler) r4
            java.util.zip.Adler32 r5 = new java.util.zip.Adler32
            r5.<init>()
            android.content.Context r6 = r0.context
            java.lang.String r6 = r6.getPackageName()
            java.lang.String r7 = "UTF-8"
            java.nio.charset.Charset r8 = java.nio.charset.Charset.forName(r7)
            byte[] r6 = r6.getBytes(r8)
            r5.update(r6)
            r6 = r1
            com.google.android.datatransport.runtime.AutoValue_TransportContext r6 = (com.google.android.datatransport.runtime.AutoValue_TransportContext) r6
            java.lang.String r8 = r6.backendName
            java.nio.charset.Charset r7 = java.nio.charset.Charset.forName(r7)
            byte[] r7 = r8.getBytes(r7)
            r5.update(r7)
            r7 = 4
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r7)
            com.google.android.datatransport.Priority r9 = r6.priority
            int r9 = com.google.android.datatransport.runtime.util.PriorityMapping.toInt(r9)
            java.nio.ByteBuffer r8 = r8.putInt(r9)
            byte[] r8 = r8.array()
            r5.update(r8)
            byte[] r6 = r6.extras
            if (r6 == 0) goto L_0x005e
            r5.update(r6)
        L_0x005e:
            long r5 = r5.getValue()
            int r6 = (int) r5
            java.util.List r5 = r4.getAllPendingJobs()
            java.util.Iterator r5 = r5.iterator()
        L_0x006b:
            boolean r8 = r5.hasNext()
            java.lang.String r9 = "attemptNumber"
            r10 = 1
            r11 = 0
            if (r8 == 0) goto L_0x008d
            java.lang.Object r8 = r5.next()
            android.app.job.JobInfo r8 = (android.app.job.JobInfo) r8
            android.os.PersistableBundle r12 = r8.getExtras()
            int r12 = r12.getInt(r9)
            int r8 = r8.getId()
            if (r8 != r6) goto L_0x006b
            if (r12 < r2) goto L_0x008d
            r5 = 1
            goto L_0x008e
        L_0x008d:
            r5 = 0
        L_0x008e:
            java.lang.String r8 = "JobInfoScheduler"
            if (r5 == 0) goto L_0x0098
            java.lang.String r2 = "Upload for context %s is already scheduled. Returning..."
            com.android.billingclient.api.zzam.m35d((java.lang.String) r8, (java.lang.String) r2, (java.lang.Object) r1)
            return
        L_0x0098:
            com.google.android.datatransport.runtime.scheduling.persistence.EventStore r5 = r0.eventStore
            long r12 = r5.getNextCallTime(r1)
            com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig r5 = r0.config
            android.app.job.JobInfo$Builder r14 = new android.app.job.JobInfo$Builder
            r14.<init>(r6, r3)
            r3 = r1
            com.google.android.datatransport.runtime.AutoValue_TransportContext r3 = (com.google.android.datatransport.runtime.AutoValue_TransportContext) r3
            com.google.android.datatransport.Priority r15 = r3.priority
            r16 = r8
            long r7 = r5.getScheduleDelay(r15, r12, r2)
            r14.setMinimumLatency(r7)
            com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig r5 = (com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig) r5
            java.util.Map<com.google.android.datatransport.Priority, com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$ConfigValue> r5 = r5.values
            java.lang.Object r5 = r5.get(r15)
            com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$ConfigValue r5 = (com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue) r5
            com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue r5 = (com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue) r5
            java.util.Set<com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag> r5 = r5.flags
            com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag r7 = com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.Flag.NETWORK_UNMETERED
            boolean r7 = r5.contains(r7)
            r8 = 2
            if (r7 == 0) goto L_0x00ce
            r14.setRequiredNetworkType(r8)
            goto L_0x00d1
        L_0x00ce:
            r14.setRequiredNetworkType(r10)
        L_0x00d1:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag r7 = com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.Flag.DEVICE_CHARGING
            boolean r7 = r5.contains(r7)
            if (r7 == 0) goto L_0x00dc
            r14.setRequiresCharging(r10)
        L_0x00dc:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag r7 = com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.Flag.DEVICE_IDLE
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x00e7
            r14.setRequiresDeviceIdle(r10)
        L_0x00e7:
            android.os.PersistableBundle r5 = new android.os.PersistableBundle
            r5.<init>()
            r5.putInt(r9, r2)
            java.lang.String r7 = r3.backendName
            java.lang.String r9 = "backendName"
            r5.putString(r9, r7)
            com.google.android.datatransport.Priority r7 = r3.priority
            int r7 = com.google.android.datatransport.runtime.util.PriorityMapping.toInt(r7)
            java.lang.String r9 = "priority"
            r5.putInt(r9, r7)
            byte[] r7 = r3.extras
            if (r7 == 0) goto L_0x010e
            java.lang.String r7 = android.util.Base64.encodeToString(r7, r11)
            java.lang.String r9 = "extras"
            r5.putString(r9, r7)
        L_0x010e:
            r14.setExtras(r5)
            r5 = 5
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r11] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r5[r10] = r1
            com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig r1 = r0.config
            com.google.android.datatransport.Priority r3 = r3.priority
            long r6 = r1.getScheduleDelay(r3, r12, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r6)
            r5[r8] = r1
            r1 = 3
            java.lang.Long r3 = java.lang.Long.valueOf(r12)
            r5[r1] = r3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r19)
            r2 = 4
            r5[r2] = r1
            java.lang.String r1 = "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d"
            r2 = r16
            com.android.billingclient.api.zzam.m36d((java.lang.String) r2, (java.lang.String) r1, (java.lang.Object[]) r5)
            android.app.job.JobInfo r1 = r14.build()
            r4.schedule(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler.schedule(com.google.android.datatransport.runtime.TransportContext, int):void");
    }
}
