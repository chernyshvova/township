package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static /* synthetic */ void lambda$onReceive$0() {
    }

    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(context);
        TransportContext.Builder builder = TransportContext.builder();
        builder.setBackendName(queryParameter);
        builder.setPriority(PriorityMapping.valueOf(intValue));
        if (queryParameter2 != null) {
            ((AutoValue_TransportContext.Builder) builder).extras = Base64.decode(queryParameter2, 0);
        }
        Uploader uploader = TransportRuntime.getInstance().uploader;
        uploader.executor.execute(new Uploader$$Lambda$1(uploader, builder.build(), i, AlarmManagerSchedulerBroadcastReceiver$$Lambda$1.instance));
    }
}
