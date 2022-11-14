package com.google.android.datatransport.runtime.scheduling.persistence;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.UserSettingsManager;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class EventStoreConfig {
    public static final EventStoreConfig DEFAULT;

    static {
        Long l = 10485760L;
        Integer num = 200;
        Integer num2 = 10000;
        Long valueOf = Long.valueOf(UserSettingsManager.TIMEOUT_7D);
        String str = l == null ? " maxStorageSizeInBytes" : "";
        if (num == null) {
            str = GeneratedOutlineSupport.outline16(str, " loadBatchSize");
        }
        if (num2 == null) {
            str = GeneratedOutlineSupport.outline16(str, " criticalSectionEnterTimeoutMs");
        }
        if (valueOf == null) {
            str = GeneratedOutlineSupport.outline16(str, " eventCleanUpAge");
        }
        if (str.isEmpty()) {
            DEFAULT = new AutoValue_EventStoreConfig(l.longValue(), num.intValue(), num2.intValue(), valueOf.longValue(), (AutoValue_EventStoreConfig.C16171) null);
            return;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline16("Missing required properties:", str));
    }
}
