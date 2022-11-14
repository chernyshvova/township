package com.google.android.datatransport.runtime.time;

import com.android.billingclient.api.zzam;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class TimeModule_EventClockFactory implements Object<Clock> {
    public static final TimeModule_EventClockFactory INSTANCE = new TimeModule_EventClockFactory();

    public Object get() {
        WallTimeClock wallTimeClock = new WallTimeClock();
        zzam.checkNotNull1(wallTimeClock, "Cannot return null from a non-@Nullable @Provides method");
        return wallTimeClock;
    }
}
