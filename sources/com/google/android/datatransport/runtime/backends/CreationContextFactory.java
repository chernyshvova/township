package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class CreationContextFactory {
    public final Context applicationContext;
    public final Clock monotonicClock;
    public final Clock wallClock;

    public CreationContextFactory(Context context, Clock clock, Clock clock2) {
        this.applicationContext = context;
        this.wallClock = clock;
        this.monotonicClock = clock2;
    }
}
