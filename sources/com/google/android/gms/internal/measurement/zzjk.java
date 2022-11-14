package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzjk {
    public static String zza(zzjj zzjj, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zza(zzjj, sb, 0);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01e5, code lost:
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01f8, code lost:
        if (((java.lang.Integer) r6).intValue() == 0) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0209, code lost:
        if (((java.lang.Float) r6).floatValue() == 0.0f) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x021b, code lost:
        if (((java.lang.Double) r6).doubleValue() == androidx.cardview.widget.RoundRectDrawableWithShadow.COS_45) goto L_0x01e7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0253  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zza(com.google.android.gms.internal.measurement.zzjj r13, java.lang.StringBuilder r14, int r15) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.TreeSet r2 = new java.util.TreeSet
            r2.<init>()
            java.lang.Class r3 = r13.getClass()
            java.lang.reflect.Method[] r3 = r3.getDeclaredMethods()
            int r4 = r3.length
            r5 = 0
            r6 = 0
        L_0x001a:
            java.lang.String r7 = "get"
            if (r6 >= r4) goto L_0x0049
            r8 = r3[r6]
            java.lang.String r9 = r8.getName()
            r1.put(r9, r8)
            java.lang.Class[] r9 = r8.getParameterTypes()
            int r9 = r9.length
            if (r9 != 0) goto L_0x0046
            java.lang.String r9 = r8.getName()
            r0.put(r9, r8)
            java.lang.String r9 = r8.getName()
            boolean r7 = r9.startsWith(r7)
            if (r7 == 0) goto L_0x0046
            java.lang.String r7 = r8.getName()
            r2.add(r7)
        L_0x0046:
            int r6 = r6 + 1
            goto L_0x001a
        L_0x0049:
            java.util.Iterator r2 = r2.iterator()
        L_0x004d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x026c
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = r3.startsWith(r7)
            r6 = 3
            if (r4 == 0) goto L_0x0065
            java.lang.String r4 = r3.substring(r6)
            goto L_0x0066
        L_0x0065:
            r4 = r3
        L_0x0066:
            java.lang.String r8 = "List"
            boolean r9 = r4.endsWith(r8)
            r10 = 1
            if (r9 == 0) goto L_0x00ca
            java.lang.String r9 = "OrBuilderList"
            boolean r9 = r4.endsWith(r9)
            if (r9 != 0) goto L_0x00ca
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L_0x00ca
            java.lang.String r8 = r4.substring(r5, r10)
            java.lang.String r8 = r8.toLowerCase()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r9 = r4.length()
            int r9 = r9 + -4
            java.lang.String r9 = r4.substring(r10, r9)
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r11 = r9.length()
            if (r11 == 0) goto L_0x00a2
            java.lang.String r8 = r8.concat(r9)
            goto L_0x00a8
        L_0x00a2:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r8)
            r8 = r9
        L_0x00a8:
            java.lang.Object r9 = r0.get(r3)
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9
            if (r9 == 0) goto L_0x00ca
            java.lang.Class r11 = r9.getReturnType()
            java.lang.Class<java.util.List> r12 = java.util.List.class
            boolean r11 = r11.equals(r12)
            if (r11 == 0) goto L_0x00ca
            java.lang.String r3 = zza(r8)
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhy.zza((java.lang.reflect.Method) r9, (java.lang.Object) r13, (java.lang.Object[]) r4)
            zza(r14, r15, r3, r4)
            goto L_0x004d
        L_0x00ca:
            java.lang.String r8 = "Map"
            boolean r9 = r4.endsWith(r8)
            if (r9 == 0) goto L_0x0136
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L_0x0136
            java.lang.String r8 = r4.substring(r5, r10)
            java.lang.String r8 = r8.toLowerCase()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r9 = r4.length()
            int r9 = r9 - r6
            java.lang.String r6 = r4.substring(r10, r9)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r9 = r6.length()
            if (r9 == 0) goto L_0x00fc
            java.lang.String r6 = r8.concat(r6)
            goto L_0x0101
        L_0x00fc:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r8)
        L_0x0101:
            java.lang.Object r3 = r0.get(r3)
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            if (r3 == 0) goto L_0x0136
            java.lang.Class r8 = r3.getReturnType()
            java.lang.Class<java.util.Map> r9 = java.util.Map.class
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0136
            java.lang.Class<java.lang.Deprecated> r8 = java.lang.Deprecated.class
            boolean r8 = r3.isAnnotationPresent(r8)
            if (r8 != 0) goto L_0x0136
            int r8 = r3.getModifiers()
            boolean r8 = java.lang.reflect.Modifier.isPublic(r8)
            if (r8 == 0) goto L_0x0136
            java.lang.String r4 = zza(r6)
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhy.zza((java.lang.reflect.Method) r3, (java.lang.Object) r13, (java.lang.Object[]) r6)
            zza(r14, r15, r4, r3)
            goto L_0x004d
        L_0x0136:
            java.lang.String r3 = "set"
            int r6 = r4.length()
            if (r6 == 0) goto L_0x0143
            java.lang.String r3 = r3.concat(r4)
            goto L_0x0149
        L_0x0143:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r3)
            r3 = r6
        L_0x0149:
            java.lang.Object r3 = r1.get(r3)
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            if (r3 == 0) goto L_0x004d
            java.lang.String r3 = "Bytes"
            boolean r3 = r4.endsWith(r3)
            if (r3 == 0) goto L_0x017d
            int r3 = r4.length()
            int r3 = r3 + -5
            java.lang.String r3 = r4.substring(r5, r3)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r6 = r3.length()
            if (r6 == 0) goto L_0x0172
            java.lang.String r3 = r7.concat(r3)
            goto L_0x0177
        L_0x0172:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r7)
        L_0x0177:
            boolean r3 = r0.containsKey(r3)
            if (r3 != 0) goto L_0x004d
        L_0x017d:
            java.lang.String r3 = r4.substring(r5, r10)
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r6 = r4.substring(r10)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r8 = r6.length()
            if (r8 == 0) goto L_0x019c
            java.lang.String r3 = r3.concat(r6)
            goto L_0x01a2
        L_0x019c:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r3)
            r3 = r6
        L_0x01a2:
            int r6 = r4.length()
            if (r6 == 0) goto L_0x01ad
            java.lang.String r6 = r7.concat(r4)
            goto L_0x01b2
        L_0x01ad:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r7)
        L_0x01b2:
            java.lang.Object r6 = r0.get(r6)
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            java.lang.String r8 = "has"
            int r9 = r4.length()
            if (r9 == 0) goto L_0x01c5
            java.lang.String r4 = r8.concat(r4)
            goto L_0x01ca
        L_0x01c5:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r8)
        L_0x01ca:
            java.lang.Object r4 = r0.get(r4)
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4
            if (r6 == 0) goto L_0x004d
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzhy.zza((java.lang.reflect.Method) r6, (java.lang.Object) r13, (java.lang.Object[]) r8)
            if (r4 != 0) goto L_0x0255
            boolean r4 = r6 instanceof java.lang.Boolean
            if (r4 == 0) goto L_0x01ed
            r4 = r6
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x01ea
        L_0x01e7:
            r4 = 1
            goto L_0x0250
        L_0x01ea:
            r4 = 0
            goto L_0x0250
        L_0x01ed:
            boolean r4 = r6 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x01fb
            r4 = r6
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 != 0) goto L_0x01ea
            goto L_0x01e7
        L_0x01fb:
            boolean r4 = r6 instanceof java.lang.Float
            if (r4 == 0) goto L_0x020c
            r4 = r6
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            r8 = 0
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x01ea
            goto L_0x01e7
        L_0x020c:
            boolean r4 = r6 instanceof java.lang.Double
            if (r4 == 0) goto L_0x021e
            r4 = r6
            java.lang.Double r4 = (java.lang.Double) r4
            double r8 = r4.doubleValue()
            r11 = 0
            int r4 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r4 != 0) goto L_0x01ea
            goto L_0x01e7
        L_0x021e:
            boolean r4 = r6 instanceof java.lang.String
            if (r4 == 0) goto L_0x0229
            java.lang.String r4 = ""
            boolean r4 = r6.equals(r4)
            goto L_0x0250
        L_0x0229:
            boolean r4 = r6 instanceof com.google.android.gms.internal.measurement.zzgp
            if (r4 == 0) goto L_0x0234
            com.google.android.gms.internal.measurement.zzgp r4 = com.google.android.gms.internal.measurement.zzgp.zza
            boolean r4 = r6.equals(r4)
            goto L_0x0250
        L_0x0234:
            boolean r4 = r6 instanceof com.google.android.gms.internal.measurement.zzjj
            if (r4 == 0) goto L_0x0242
            r4 = r6
            com.google.android.gms.internal.measurement.zzjj r4 = (com.google.android.gms.internal.measurement.zzjj) r4
            com.google.android.gms.internal.measurement.zzjj r4 = r4.zzbv()
            if (r6 != r4) goto L_0x01ea
            goto L_0x01e7
        L_0x0242:
            boolean r4 = r6 instanceof java.lang.Enum
            if (r4 == 0) goto L_0x01ea
            r4 = r6
            java.lang.Enum r4 = (java.lang.Enum) r4
            int r4 = r4.ordinal()
            if (r4 != 0) goto L_0x01ea
            goto L_0x01e7
        L_0x0250:
            if (r4 != 0) goto L_0x0253
            goto L_0x0261
        L_0x0253:
            r10 = 0
            goto L_0x0261
        L_0x0255:
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhy.zza((java.lang.reflect.Method) r4, (java.lang.Object) r13, (java.lang.Object[]) r8)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r10 = r4.booleanValue()
        L_0x0261:
            if (r10 == 0) goto L_0x004d
            java.lang.String r3 = zza(r3)
            zza(r14, r15, r3, r6)
            goto L_0x004d
        L_0x026c:
            boolean r0 = r13 instanceof com.google.android.gms.internal.measurement.zzhy.zzd
            if (r0 == 0) goto L_0x0292
            r0 = r13
            com.google.android.gms.internal.measurement.zzhy$zzd r0 = (com.google.android.gms.internal.measurement.zzhy.zzd) r0
            com.google.android.gms.internal.measurement.zzhr<com.google.android.gms.internal.measurement.zzhy$zzc> r0 = r0.zzc
            java.util.Iterator r0 = r0.zzd()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x0280
            goto L_0x0292
        L_0x0280:
            java.lang.Object r13 = r0.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r13 = r13.getKey()
            com.google.android.gms.internal.measurement.zzhy$zzc r13 = (com.google.android.gms.internal.measurement.zzhy.zzc) r13
            java.lang.NoSuchMethodError r13 = new java.lang.NoSuchMethodError
            r13.<init>()
            throw r13
        L_0x0292:
            com.google.android.gms.internal.measurement.zzhy r13 = (com.google.android.gms.internal.measurement.zzhy) r13
            com.google.android.gms.internal.measurement.zzks r13 = r13.zzb
            if (r13 == 0) goto L_0x029b
            r13.zza((java.lang.StringBuilder) r14, (int) r15)
        L_0x029b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(com.google.android.gms.internal.measurement.zzjj, java.lang.StringBuilder, int):void");
    }

    public static final void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zza : (List) obj) {
                zza(sb, i, str, zza);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zza2 : ((Map) obj).entrySet()) {
                zza(sb, i, str, zza2);
            }
        } else {
            sb.append(10);
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzkp.zza(zzgp.zza((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzgp) {
                sb.append(": \"");
                sb.append(zzkp.zza((zzgp) obj));
                sb.append('\"');
            } else if (obj instanceof zzhy) {
                sb.append(" {");
                zza((zzhy) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i4 = i + 2;
                zza(sb, i4, "key", entry.getKey());
                zza(sb, i4, "value", entry.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    public static final String zza(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
