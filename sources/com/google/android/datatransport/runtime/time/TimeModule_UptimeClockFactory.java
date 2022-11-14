package com.google.android.datatransport.runtime.time;

import com.android.billingclient.api.zzam;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class TimeModule_UptimeClockFactory implements Object<Clock> {
    public static final TimeModule_UptimeClockFactory INSTANCE = new TimeModule_UptimeClockFactory();

    public Object get() {
        UptimeClock uptimeClock = new UptimeClock();
        zzam.checkNotNull1(uptimeClock, "Cannot return null from a non-@Nullable @Provides method");
        return uptimeClock;
    }
}
