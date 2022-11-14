package com.appsflyer.internal;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.aam.MetadataRule;
import com.helpshift.support.res.values.HSConsts;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.appsflyer.internal.g */
public final class C1476g {

    /* renamed from: com.appsflyer.internal.g$b */
    public enum C1477b {
        UNKNOWN("uk"),
        ACCELEROMETER("am"),
        MAGNETOMETER("mm"),
        RESERVED(HSConsts.READ_STATUS_KEY),
        GYROSCOPE("gs");
        
        public String AFInAppEventType;

        /* access modifiers changed from: public */
        C1477b(String str) {
            this.AFInAppEventType = str;
        }
    }

    /* renamed from: com.appsflyer.internal.g$c */
    public enum C1478c {
        UNKNOWN,
        ACCELEROMETER,
        MAGNETOMETER,
        RESERVED,
        GYROSCOPE
    }

    /* renamed from: com.appsflyer.internal.g$e */
    public enum C1479e {
        NONE,
        FIRST,
        ALL
    }

    public static List<BigDecimal> AFInAppEventParameterName(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(BigDecimal.valueOf(Double.parseDouble(((Float) arrayList.get(0)).toString())));
        arrayList2.add(BigDecimal.valueOf(Double.parseDouble(((Float) arrayList.get(1)).toString())));
        arrayList2.add(BigDecimal.valueOf(Double.parseDouble(((Float) arrayList.get(2)).toString())));
        return arrayList2;
    }

    public final Map AFInAppEventType(List<Map<String, Object>> list) {
        C1479e eVar;
        C1479e eVar2;
        Object obj;
        ArrayList arrayList;
        HashMap hashMap = new HashMap();
        for (Map next : list) {
            HashMap hashMap2 = new HashMap();
            boolean z = next.get("sVS") != null;
            boolean z2 = next.get("sVE") != null;
            if (z && z2) {
                eVar = C1479e.ALL;
            } else if (z) {
                eVar = C1479e.FIRST;
            } else {
                eVar = C1479e.NONE;
            }
            if (eVar == C1479e.NONE) {
                return GeneratedOutlineSupport.outline28("er", "na");
            }
            Integer num = (Integer) next.get("sT");
            String str = (String) next.get("sN");
            if (str != null) {
                hashMap2.put("n", str);
            } else {
                hashMap2.put("n", "uk");
            }
            C1478c cVar = C1478c.values()[num.intValue()];
            ArrayList arrayList2 = new ArrayList(AFInAppEventParameterName(next.get("sVS")));
            if (eVar == C1479e.ALL) {
                arrayList2.addAll(AFInAppEventParameterName(next.get("sVE")));
            }
            if (cVar == C1478c.MAGNETOMETER) {
                ArrayList arrayList3 = new ArrayList();
                C1479e eVar3 = eVar;
                BigDecimal valueOf = BigDecimal.valueOf(Math.atan2(((BigDecimal) arrayList2.get(1)).doubleValue(), ((BigDecimal) arrayList2.get(0)).doubleValue()) * 57.29577951308232d);
                DecimalFormat decimalFormat = new DecimalFormat("##.#");
                decimalFormat.setRoundingMode(RoundingMode.DOWN);
                arrayList3.add(Double.valueOf(Double.parseDouble(decimalFormat.format(valueOf))));
                DecimalFormat decimalFormat2 = new DecimalFormat("##.#");
                decimalFormat2.setRoundingMode(RoundingMode.DOWN);
                arrayList3.add(Double.valueOf(Double.parseDouble(decimalFormat2.format((BigDecimal) arrayList2.get(2)))));
                ArrayList arrayList4 = new ArrayList();
                if (arrayList2.size() > 5) {
                    obj = "er";
                    eVar2 = eVar3;
                    BigDecimal subtract = BigDecimal.valueOf(Math.atan2(((BigDecimal) arrayList2.get(4)).doubleValue(), ((BigDecimal) arrayList2.get(3)).doubleValue()) * 57.29577951308232d).subtract(valueOf);
                    DecimalFormat decimalFormat3 = new DecimalFormat("##.#");
                    decimalFormat3.setRoundingMode(RoundingMode.DOWN);
                    arrayList4.add(Double.valueOf(Double.parseDouble(decimalFormat3.format(subtract))));
                    BigDecimal subtract2 = ((BigDecimal) arrayList2.get(5)).subtract((BigDecimal) arrayList2.get(2));
                    DecimalFormat decimalFormat4 = new DecimalFormat("##.#");
                    decimalFormat4.setRoundingMode(RoundingMode.DOWN);
                    arrayList4.add(Double.valueOf(Double.parseDouble(decimalFormat4.format(subtract2))));
                } else {
                    obj = "er";
                    eVar2 = eVar3;
                }
                arrayList = new ArrayList();
                arrayList.add(arrayList3);
                arrayList.add(arrayList4);
            } else {
                eVar2 = eVar;
                obj = "er";
                ArrayList arrayList5 = new ArrayList();
                if (arrayList2.size() > 5) {
                    BigDecimal subtract3 = ((BigDecimal) arrayList2.get(3)).subtract((BigDecimal) arrayList2.get(0));
                    DecimalFormat decimalFormat5 = new DecimalFormat("##.#");
                    decimalFormat5.setRoundingMode(RoundingMode.DOWN);
                    arrayList5.add(Double.valueOf(Double.parseDouble(decimalFormat5.format(subtract3))));
                    BigDecimal subtract4 = ((BigDecimal) arrayList2.get(4)).subtract((BigDecimal) arrayList2.get(1));
                    DecimalFormat decimalFormat6 = new DecimalFormat("##.#");
                    decimalFormat6.setRoundingMode(RoundingMode.DOWN);
                    arrayList5.add(Double.valueOf(Double.parseDouble(decimalFormat6.format(subtract4))));
                    BigDecimal subtract5 = ((BigDecimal) arrayList2.get(5)).subtract((BigDecimal) arrayList2.get(2));
                    DecimalFormat decimalFormat7 = new DecimalFormat("##.#");
                    decimalFormat7.setRoundingMode(RoundingMode.DOWN);
                    arrayList5.add(Double.valueOf(Double.parseDouble(decimalFormat7.format(subtract5))));
                }
                ArrayList arrayList6 = new ArrayList();
                DecimalFormat decimalFormat8 = new DecimalFormat("##.#");
                decimalFormat8.setRoundingMode(RoundingMode.DOWN);
                arrayList6.add(Double.valueOf(Double.parseDouble(decimalFormat8.format((BigDecimal) arrayList2.get(0)))));
                DecimalFormat decimalFormat9 = new DecimalFormat("##.#");
                decimalFormat9.setRoundingMode(RoundingMode.DOWN);
                arrayList6.add(Double.valueOf(Double.parseDouble(decimalFormat9.format((BigDecimal) arrayList2.get(1)))));
                DecimalFormat decimalFormat10 = new DecimalFormat("##.#");
                decimalFormat10.setRoundingMode(RoundingMode.DOWN);
                arrayList6.add(Double.valueOf(Double.parseDouble(decimalFormat10.format((BigDecimal) arrayList2.get(2)))));
                ArrayList arrayList7 = new ArrayList();
                arrayList7.add(arrayList6);
                arrayList7.add(arrayList5);
                arrayList = arrayList7;
            }
            hashMap2.put(MetadataRule.FIELD_V, arrayList);
            hashMap.put(C1477b.values()[num.intValue()].AFInAppEventType, hashMap2);
            if (eVar2 == C1479e.FIRST) {
                hashMap.put(obj, "no_svs");
            }
        }
        return hashMap;
    }
}
