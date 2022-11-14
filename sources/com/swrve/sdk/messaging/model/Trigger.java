package com.swrve.sdk.messaging.model;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.swrve.sdk.SwrveLogger;
import java.util.List;

public class Trigger {
    public Conditions conditions;
    public String eventName;

    public static List<Trigger> fromJson(String str, int i) {
        List<Trigger> list;
        JsonParseException e;
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
            list = (List) gsonBuilder.create().fromJson(str, new TypeToken<List<Trigger>>() {
            }.getType());
            try {
                return validateTriggers(list, i);
            } catch (JsonParseException e2) {
                e = e2;
                SwrveLogger.m2753e(GeneratedOutlineSupport.outline16("Could not parse campaign[%s] trigger json:%s", str), e, Integer.valueOf(i), str);
                return list;
            }
        } catch (JsonParseException e3) {
            JsonParseException jsonParseException = e3;
            list = null;
            e = jsonParseException;
            SwrveLogger.m2753e(GeneratedOutlineSupport.outline16("Could not parse campaign[%s] trigger json:%s", str), e, Integer.valueOf(i), str);
            return list;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.swrve.sdk.messaging.model.Trigger> validateTriggers(java.util.List<com.swrve.sdk.messaging.model.Trigger> r11, int r12) {
        /*
            java.util.Iterator r0 = r11.iterator()
        L_0x0004:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00e2
            java.lang.Object r1 = r0.next()
            com.swrve.sdk.messaging.model.Trigger r1 = (com.swrve.sdk.messaging.model.Trigger) r1
            com.swrve.sdk.messaging.model.Conditions r2 = r1.getConditions()
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 2
            java.lang.String r7 = "Invalid trigger in campaign[%s] trigger:%s"
            if (r2 != 0) goto L_0x002a
            java.lang.Object[] r11 = new java.lang.Object[r6]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11[r5] = r12
            r11[r4] = r1
            com.swrve.sdk.SwrveLogger.m2754e(r7, r11)
            return r3
        L_0x002a:
            com.swrve.sdk.messaging.model.Conditions$Op r8 = r2.getOp()
            if (r8 != 0) goto L_0x0043
            java.lang.String r8 = r2.getValue()
            if (r8 != 0) goto L_0x0043
            java.lang.String r8 = r2.getKey()
            if (r8 != 0) goto L_0x0043
            java.util.List r8 = r2.getArgs()
            if (r8 != 0) goto L_0x0043
            goto L_0x0004
        L_0x0043:
            com.swrve.sdk.messaging.model.Conditions$Op r8 = com.swrve.sdk.messaging.model.Conditions.C1708Op.AND
            com.swrve.sdk.messaging.model.Conditions$Op r9 = r2.getOp()
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00ae
            java.util.List r8 = r2.getArgs()
            if (r8 == 0) goto L_0x00a0
            java.util.List r8 = r2.getArgs()
            int r8 = r8.size()
            if (r8 != 0) goto L_0x0060
            goto L_0x00a0
        L_0x0060:
            java.util.List r2 = r2.getArgs()
            java.util.Iterator r2 = r2.iterator()
        L_0x0068:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0004
            java.lang.Object r8 = r2.next()
            com.swrve.sdk.messaging.model.Arg r8 = (com.swrve.sdk.messaging.model.Arg) r8
            java.lang.String r9 = r8.getKey()
            if (r9 == 0) goto L_0x0092
            com.swrve.sdk.messaging.model.Arg$Op r9 = r8.getOp()
            if (r9 == 0) goto L_0x0092
            com.swrve.sdk.messaging.model.Arg$Op r9 = com.swrve.sdk.messaging.model.Arg.C1707Op.EQ
            com.swrve.sdk.messaging.model.Arg$Op r10 = r8.getOp()
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0092
            java.lang.String r8 = r8.getValue()
            if (r8 != 0) goto L_0x0068
        L_0x0092:
            java.lang.Object[] r11 = new java.lang.Object[r6]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11[r5] = r12
            r11[r4] = r1
            com.swrve.sdk.SwrveLogger.m2754e(r7, r11)
            return r3
        L_0x00a0:
            java.lang.Object[] r11 = new java.lang.Object[r6]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11[r5] = r12
            r11[r4] = r1
            com.swrve.sdk.SwrveLogger.m2754e(r7, r11)
            return r3
        L_0x00ae:
            com.swrve.sdk.messaging.model.Conditions$Op r8 = com.swrve.sdk.messaging.model.Conditions.C1708Op.EQ
            com.swrve.sdk.messaging.model.Conditions$Op r9 = r2.getOp()
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00d4
            java.lang.String r8 = r2.getKey()
            if (r8 == 0) goto L_0x00c6
            java.lang.String r2 = r2.getValue()
            if (r2 != 0) goto L_0x0004
        L_0x00c6:
            java.lang.Object[] r11 = new java.lang.Object[r6]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11[r5] = r12
            r11[r4] = r1
            com.swrve.sdk.SwrveLogger.m2754e(r7, r11)
            return r3
        L_0x00d4:
            java.lang.Object[] r11 = new java.lang.Object[r6]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11[r5] = r12
            r11[r4] = r1
            com.swrve.sdk.SwrveLogger.m2754e(r7, r11)
            return r3
        L_0x00e2:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.messaging.model.Trigger.validateTriggers(java.util.List, int):java.util.List");
    }

    public Conditions getConditions() {
        return this.conditions;
    }

    public String getEventName() {
        return this.eventName;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Trigger{eventName='");
        GeneratedOutlineSupport.outline33(outline24, this.eventName, '\'', ", conditions=");
        outline24.append(this.conditions);
        outline24.append('}');
        return outline24.toString();
    }
}
