package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.channel.AbstractChannelListener;
import java.util.concurrent.ConcurrentHashMap;

public class PropertyConfigurator extends AbstractChannelListener {
    public final AnalyticsTransmissionTarget mTransmissionTarget;

    public PropertyConfigurator(AnalyticsTransmissionTarget analyticsTransmissionTarget) {
        new ConcurrentHashMap();
        this.mTransmissionTarget = analyticsTransmissionTarget;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        if ((r6 && r2.isEnabledInStorage()) != false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPreparingLog(@androidx.annotation.NonNull com.microsoft.appcenter.ingestion.models.Log r5, @androidx.annotation.NonNull java.lang.String r6) {
        /*
            r4 = this;
            boolean r6 = r5 instanceof com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L_0x002c
            java.lang.Object r6 = r5.getTag()
            com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget r2 = r4.mTransmissionTarget
            if (r6 != r2) goto L_0x002c
            com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget r6 = r2.mParentTarget
        L_0x0010:
            if (r6 == 0) goto L_0x001d
            boolean r3 = r6.isEnabledInStorage()
            if (r3 != 0) goto L_0x001a
            r6 = 0
            goto L_0x001e
        L_0x001a:
            com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget r6 = r6.mParentTarget
            goto L_0x0010
        L_0x001d:
            r6 = 1
        L_0x001e:
            if (r6 == 0) goto L_0x0028
            boolean r6 = r2.isEnabledInStorage()
            if (r6 == 0) goto L_0x0028
            r6 = 1
            goto L_0x0029
        L_0x0028:
            r6 = 0
        L_0x0029:
            if (r6 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            if (r0 == 0) goto L_0x0066
            com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog r5 = (com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog) r5
            com.microsoft.appcenter.ingestion.models.one.Extensions r5 = r5.ext
            com.microsoft.appcenter.ingestion.models.one.AppExtension r5 = r5.app
            com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget r5 = r4.mTransmissionTarget
        L_0x0037:
            com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget r5 = r5.mParentTarget
            r6 = 0
            if (r5 == 0) goto L_0x0042
            com.microsoft.appcenter.analytics.PropertyConfigurator r0 = r5.mPropertyConfigurator
            if (r0 == 0) goto L_0x0041
            goto L_0x0037
        L_0x0041:
            throw r6
        L_0x0042:
            com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget r5 = r4.mTransmissionTarget
        L_0x0044:
            com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget r5 = r5.mParentTarget
            if (r5 == 0) goto L_0x004e
            com.microsoft.appcenter.analytics.PropertyConfigurator r0 = r5.mPropertyConfigurator
            if (r0 == 0) goto L_0x004d
            goto L_0x0044
        L_0x004d:
            throw r6
        L_0x004e:
            com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget r5 = r4.mTransmissionTarget
        L_0x0050:
            com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget r5 = r5.mParentTarget
            if (r5 == 0) goto L_0x005a
            com.microsoft.appcenter.analytics.PropertyConfigurator r0 = r5.mPropertyConfigurator
            if (r0 == 0) goto L_0x0059
            goto L_0x0050
        L_0x0059:
            throw r6
        L_0x005a:
            com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget r5 = r4.mTransmissionTarget
        L_0x005c:
            com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget r5 = r5.mParentTarget
            if (r5 == 0) goto L_0x0066
            com.microsoft.appcenter.analytics.PropertyConfigurator r0 = r5.mPropertyConfigurator
            if (r0 == 0) goto L_0x0065
            goto L_0x005c
        L_0x0065:
            throw r6
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.analytics.PropertyConfigurator.onPreparingLog(com.microsoft.appcenter.ingestion.models.Log, java.lang.String):void");
    }
}
