package com.microsoft.appcenter.analytics.channel;

import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.utils.AppCenterLog;

public class AnalyticsValidator extends AbstractChannelListener {
    public static String validateName(String str, String str2) {
        if (str == null || str.isEmpty()) {
            AppCenterLog.error("AppCenterAnalytics", str2 + " name cannot be null or empty.");
            return null;
        } else if (str.length() <= 256) {
            return str;
        } else {
            AppCenterLog.warn("AppCenterAnalytics", String.format("%s '%s' : name length cannot be longer than %s characters. Name will be truncated.", new Object[]{str2, str, 256}));
            return str.substring(0, 256);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldFilter(@androidx.annotation.NonNull com.microsoft.appcenter.ingestion.models.Log r18) {
        /*
            r17 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.microsoft.appcenter.analytics.ingestion.models.PageLog
            r2 = 125(0x7d, float:1.75E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r4 = 20
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6 = 0
            r7 = 2
            r8 = 1
            java.lang.String r9 = "AppCenterAnalytics"
            if (r1 == 0) goto L_0x00f8
            com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties r0 = (com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties) r0
            java.lang.String r1 = r0.name
            java.lang.String r10 = r0.getType()
            java.lang.String r1 = validateName(r1, r10)
            if (r1 != 0) goto L_0x0027
            goto L_0x00f5
        L_0x0027:
            java.util.Map<java.lang.String, java.lang.String> r10 = r0.properties
            java.lang.String r11 = r0.getType()
            if (r10 != 0) goto L_0x0032
            r2 = 0
            goto L_0x00f0
        L_0x0032:
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x003f:
            boolean r13 = r10.hasNext()
            if (r13 == 0) goto L_0x00ef
            java.lang.Object r13 = r10.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r14 = r13.getKey()
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r13 = r13.getValue()
            java.lang.String r13 = (java.lang.String) r13
            int r15 = r12.size()
            r2 = 3
            if (r15 < r4) goto L_0x0071
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r6] = r11
            r2[r8] = r1
            r2[r7] = r5
            java.lang.String r3 = "%s '%s' : properties cannot contain more than %s items. Skipping other properties."
            java.lang.String r2 = java.lang.String.format(r3, r2)
            com.microsoft.appcenter.utils.AppCenterLog.warn(r9, r2)
            goto L_0x00ef
        L_0x0071:
            if (r14 == 0) goto L_0x00d9
            boolean r15 = r14.isEmpty()
            if (r15 == 0) goto L_0x007a
            goto L_0x00d9
        L_0x007a:
            r15 = 4
            if (r13 != 0) goto L_0x0093
            java.lang.Object[] r13 = new java.lang.Object[r15]
            r13[r6] = r11
            r13[r8] = r1
            r13[r7] = r14
            r13[r2] = r14
            java.lang.String r2 = "%s '%s' : property '%s' : property value cannot be null. Property '%s' will be skipped."
            java.lang.String r2 = java.lang.String.format(r2, r13)
            com.microsoft.appcenter.utils.AppCenterLog.warn(r9, r2)
            r2 = 125(0x7d, float:1.75E-43)
            goto L_0x003f
        L_0x0093:
            int r4 = r14.length()
            r2 = 125(0x7d, float:1.75E-43)
            if (r4 <= r2) goto L_0x00b4
            java.lang.Object[] r4 = new java.lang.Object[r15]
            r4[r6] = r11
            r4[r8] = r1
            r4[r7] = r14
            r16 = 3
            r4[r16] = r3
            java.lang.String r7 = "%s '%s' : property '%s' : property key length cannot be longer than %s characters. Property key will be truncated."
            java.lang.String r4 = java.lang.String.format(r7, r4)
            com.microsoft.appcenter.utils.AppCenterLog.warn(r9, r4)
            java.lang.String r14 = r14.substring(r6, r2)
        L_0x00b4:
            int r4 = r13.length()
            if (r4 <= r2) goto L_0x00d4
            java.lang.Object[] r4 = new java.lang.Object[r15]
            r4[r6] = r11
            r4[r8] = r1
            r7 = 2
            r4[r7] = r14
            r15 = 3
            r4[r15] = r3
            java.lang.String r15 = "%s '%s' : property '%s' : property value cannot be longer than %s characters. Property value will be truncated."
            java.lang.String r4 = java.lang.String.format(r15, r4)
            com.microsoft.appcenter.utils.AppCenterLog.warn(r9, r4)
            java.lang.String r13 = r13.substring(r6, r2)
            goto L_0x00d5
        L_0x00d4:
            r7 = 2
        L_0x00d5:
            r12.put(r14, r13)
            goto L_0x00e8
        L_0x00d9:
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r2[r6] = r11
            r2[r8] = r1
            java.lang.String r4 = "%s '%s' : a property key cannot be null or empty. Property will be skipped."
            java.lang.String r2 = java.lang.String.format(r4, r2)
            com.microsoft.appcenter.utils.AppCenterLog.warn(r9, r2)
        L_0x00e8:
            r2 = 125(0x7d, float:1.75E-43)
            r4 = 20
            r7 = 2
            goto L_0x003f
        L_0x00ef:
            r2 = r12
        L_0x00f0:
            r0.name = r1
            r0.properties = r2
            r6 = 1
        L_0x00f5:
            r0 = r6 ^ 1
            return r0
        L_0x00f8:
            boolean r1 = r0 instanceof com.microsoft.appcenter.analytics.ingestion.models.EventLog
            if (r1 == 0) goto L_0x0234
            com.microsoft.appcenter.analytics.ingestion.models.EventLog r0 = (com.microsoft.appcenter.analytics.ingestion.models.EventLog) r0
            java.lang.String r1 = r0.name
            java.lang.String r2 = "event"
            java.lang.String r1 = validateName(r1, r2)
            if (r1 != 0) goto L_0x010b
            r0 = 1
            goto L_0x0232
        L_0x010b:
            java.util.List<com.microsoft.appcenter.ingestion.models.properties.TypedProperty> r2 = r0.typedProperties
            if (r2 != 0) goto L_0x0111
            goto L_0x022e
        L_0x0111:
            java.util.ListIterator r2 = r2.listIterator()
            r4 = 0
            r7 = 0
        L_0x0117:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x022e
            java.lang.Object r10 = r2.next()
            com.microsoft.appcenter.ingestion.models.properties.TypedProperty r10 = (com.microsoft.appcenter.ingestion.models.properties.TypedProperty) r10
            java.lang.String r11 = r10.name
            r12 = 20
            if (r4 < r12) goto L_0x013d
            if (r7 != 0) goto L_0x0139
            java.lang.Object[] r7 = new java.lang.Object[r8]
            r7[r6] = r5
            java.lang.String r10 = "Typed properties cannot contain more than %s items. Skipping other properties."
            java.lang.String r7 = java.lang.String.format(r10, r7)
            com.microsoft.appcenter.utils.AppCenterLog.warn(r9, r7)
            r7 = 1
        L_0x0139:
            r2.remove()
            goto L_0x0117
        L_0x013d:
            if (r11 == 0) goto L_0x0221
            boolean r13 = r11.isEmpty()
            if (r13 == 0) goto L_0x0147
            goto L_0x0221
        L_0x0147:
            int r13 = r11.length()
            r14 = 125(0x7d, float:1.75E-43)
            if (r13 <= r14) goto L_0x01cb
            r13 = 2
            java.lang.Object[] r15 = new java.lang.Object[r13]
            r15[r6] = r11
            r15[r8] = r3
            java.lang.String r13 = "Typed property '%s' : property key length cannot be longer than %s characters. Property key will be truncated."
            java.lang.String r13 = java.lang.String.format(r13, r15)
            com.microsoft.appcenter.utils.AppCenterLog.warn(r9, r13)
            java.lang.String r11 = r11.substring(r6, r14)
            java.lang.String r13 = r10.getType()
            java.lang.String r14 = "boolean"
            boolean r14 = r14.equals(r13)
            if (r14 == 0) goto L_0x017c
            com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty r13 = new com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty
            r13.<init>()
            com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty r10 = (com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty) r10
            boolean r10 = r10.value
            r13.value = r10
        L_0x017a:
            r10 = r13
            goto L_0x01c4
        L_0x017c:
            java.lang.String r14 = "dateTime"
            boolean r14 = r14.equals(r13)
            if (r14 == 0) goto L_0x0190
            com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty r13 = new com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty
            r13.<init>()
            com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty r10 = (com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty) r10
            java.util.Date r10 = r10.value
            r13.value = r10
            goto L_0x017a
        L_0x0190:
            java.lang.String r14 = "double"
            boolean r14 = r14.equals(r13)
            if (r14 == 0) goto L_0x01a4
            com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty r13 = new com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty
            r13.<init>()
            com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty r10 = (com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty) r10
            double r14 = r10.value
            r13.value = r14
            goto L_0x017a
        L_0x01a4:
            java.lang.String r14 = "long"
            boolean r13 = r14.equals(r13)
            if (r13 == 0) goto L_0x01b8
            com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty r13 = new com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty
            r13.<init>()
            com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty r10 = (com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty) r10
            long r14 = r10.value
            r13.value = r14
            goto L_0x017a
        L_0x01b8:
            com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty r13 = new com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty
            r13.<init>()
            com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty r10 = (com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty) r10
            java.lang.String r10 = r10.value
            r13.value = r10
            goto L_0x017a
        L_0x01c4:
            r10.name = r11
            r2.set(r10)
            r13 = 0
            goto L_0x01cc
        L_0x01cb:
            r13 = 1
        L_0x01cc:
            boolean r14 = r10 instanceof com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty
            if (r14 == 0) goto L_0x021c
            com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty r10 = (com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty) r10
            java.lang.String r14 = r10.value
            if (r14 != 0) goto L_0x01ec
            r15 = 2
            java.lang.Object[] r10 = new java.lang.Object[r15]
            r10[r6] = r11
            r10[r8] = r11
            java.lang.String r11 = "Typed property '%s' : property value cannot be null. Property '%s' will be skipped."
            java.lang.String r10 = java.lang.String.format(r11, r10)
            com.microsoft.appcenter.utils.AppCenterLog.warn(r9, r10)
            r2.remove()
            r8 = 125(0x7d, float:1.75E-43)
            goto L_0x022b
        L_0x01ec:
            r15 = 2
            int r12 = r14.length()
            r8 = 125(0x7d, float:1.75E-43)
            if (r12 <= r8) goto L_0x021e
            java.lang.Object[] r12 = new java.lang.Object[r15]
            r12[r6] = r11
            r16 = 1
            r12[r16] = r3
            java.lang.String r15 = "A String property '%s' : property value cannot be longer than %s characters. Property value will be truncated."
            java.lang.String r12 = java.lang.String.format(r15, r12)
            com.microsoft.appcenter.utils.AppCenterLog.warn(r9, r12)
            java.lang.String r12 = r14.substring(r6, r8)
            if (r13 == 0) goto L_0x0219
            com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty r10 = new com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty
            r10.<init>()
            r10.name = r11
            r10.value = r12
            r2.set(r10)
            goto L_0x021e
        L_0x0219:
            r10.value = r12
            goto L_0x021e
        L_0x021c:
            r8 = 125(0x7d, float:1.75E-43)
        L_0x021e:
            int r4 = r4 + 1
            goto L_0x022b
        L_0x0221:
            r8 = 125(0x7d, float:1.75E-43)
            java.lang.String r10 = "A typed property key cannot be null or empty. Property will be skipped."
            com.microsoft.appcenter.utils.AppCenterLog.warn(r9, r10)
            r2.remove()
        L_0x022b:
            r8 = 1
            goto L_0x0117
        L_0x022e:
            r0.name = r1
            r0 = 1
            r6 = 1
        L_0x0232:
            r0 = r0 ^ r6
            return r0
        L_0x0234:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.analytics.channel.AnalyticsValidator.shouldFilter(com.microsoft.appcenter.ingestion.models.Log):boolean");
    }
}
