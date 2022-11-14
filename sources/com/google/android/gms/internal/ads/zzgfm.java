package com.google.android.gms.internal.ads;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgfm {
    public static String zza(zzgfk zzgfk, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zzgfk, sb, 0);
        return sb.toString();
    }

    public static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i, str, zzb2);
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
                sb.append(zzggm.zza(zzgcz.zzv((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzgcz) {
                sb.append(": \"");
                sb.append(zzggm.zza((zzgcz) obj));
                sb.append('\"');
            } else if (obj instanceof zzgec) {
                sb.append(" {");
                zzc((zzgec) obj, sb, i + 2);
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
                zzb(sb, i4, "key", entry.getKey());
                zzb(sb, i4, "value", entry.getValue());
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

    public static void zzc(zzgfk zzgfk, StringBuilder sb, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        String str5;
        String str6;
        String str7;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        for (Method method : zzgfk.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str8 = (String) it.next();
            String substring = str8.startsWith("get") ? str8.substring(3) : str8;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String valueOf = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(substring.substring(1, substring.length() - 4));
                if (valueOf2.length() != 0) {
                    str7 = valueOf.concat(valueOf2);
                } else {
                    str7 = new String(valueOf);
                }
                Method method2 = (Method) hashMap.get(str8);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzd(str7), zzgec.zzaA(method2, zzgfk, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String valueOf3 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(substring.substring(1, substring.length() - 3));
                if (valueOf4.length() != 0) {
                    str6 = valueOf3.concat(valueOf4);
                } else {
                    str6 = new String(valueOf3);
                }
                Method method3 = (Method) hashMap.get(str8);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzd(str6), zzgec.zzaA(method3, zzgfk, new Object[0]));
                }
            }
            if (substring.length() != 0) {
                str = "set".concat(substring);
            } else {
                str = new String("set");
            }
            if (((Method) hashMap2.get(str)) != null) {
                if (substring.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(substring.substring(0, substring.length() - 5));
                    if (valueOf5.length() != 0) {
                        str5 = "get".concat(valueOf5);
                    } else {
                        str5 = new String("get");
                    }
                    if (hashMap.containsKey(str5)) {
                    }
                }
                String valueOf6 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(substring.substring(1));
                if (valueOf7.length() != 0) {
                    str2 = valueOf6.concat(valueOf7);
                } else {
                    str2 = new String(valueOf6);
                }
                if (substring.length() != 0) {
                    str3 = "get".concat(substring);
                } else {
                    str3 = new String("get");
                }
                Method method4 = (Method) hashMap.get(str3);
                if (substring.length() != 0) {
                    str4 = "has".concat(substring);
                } else {
                    str4 = new String("has");
                }
                Method method5 = (Method) hashMap.get(str4);
                if (method4 != null) {
                    Object zzaA = zzgec.zzaA(method4, zzgfk, new Object[0]);
                    if (method5 == null) {
                        if (zzaA instanceof Boolean) {
                            if (!((Boolean) zzaA).booleanValue()) {
                            }
                        } else if (zzaA instanceof Integer) {
                            if (((Integer) zzaA).intValue() == 0) {
                            }
                        } else if (zzaA instanceof Float) {
                            if (((Float) zzaA).floatValue() == 0.0f) {
                            }
                        } else if (!(zzaA instanceof Double)) {
                            if (zzaA instanceof String) {
                                z = zzaA.equals("");
                            } else if (zzaA instanceof zzgcz) {
                                z = zzaA.equals(zzgcz.zzb);
                            } else if (zzaA instanceof zzgfk) {
                                if (zzaA == ((zzgfk) zzaA).zzbe()) {
                                }
                            } else if ((zzaA instanceof Enum) && ((Enum) zzaA).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (((Double) zzaA).doubleValue() == RoundRectDrawableWithShadow.COS_45) {
                        }
                    } else if (!((Boolean) zzgec.zzaA(method5, zzgfk, new Object[0])).booleanValue()) {
                    }
                    zzb(sb, i, zzd(str2), zzaA);
                }
            }
        }
        if (!(zzgfk instanceof zzgdz)) {
            zzggp zzggp = ((zzgec) zzgfk).zzc;
            if (zzggp != null) {
                zzggp.zzg(sb, i);
                return;
            }
            return;
        }
        zzgdz zzgdz = (zzgdz) zzgfk;
        throw null;
    }

    public static final String zzd(String str) {
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
