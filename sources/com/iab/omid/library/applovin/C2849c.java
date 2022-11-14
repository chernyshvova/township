package com.iab.omid.library.applovin;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.iab.omid.library.applovin.p047d.C2860e;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.iab.omid.library.applovin.c */
public class C2849c {

    /* renamed from: a */
    public static final Pattern f3416a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* renamed from: b */
    public static final Pattern f3417b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* renamed from: c */
    public static final Pattern f3418c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* renamed from: d */
    public static final Pattern f3419d = Pattern.compile("<(body)( [^>]*?)?/>", 2);

    /* renamed from: e */
    public static final Pattern f3420e = Pattern.compile("<(html)( [^>]*?)?>", 2);

    /* renamed from: f */
    public static final Pattern f3421f = Pattern.compile("<(html)( [^>]*?)?/>", 2);

    /* renamed from: g */
    public static final Pattern f3422g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    /* renamed from: a */
    public static String m3333a(String str, String str2) {
        return m3337b(str2, "<script type=\"text/javascript\">" + str + "</script>");
    }

    /* renamed from: a */
    public static boolean m3334a(int i, int[][] iArr) {
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                if (i >= iArr2[0] && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3335a(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!m3334a(start, iArr)) {
                sb.append(str.substring(0, matcher.end()));
                sb.append(str2);
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i = end;
        }
        return false;
    }

    /* renamed from: a */
    public static int[][] m3336a(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int indexOf = str.indexOf("<!--", i);
            if (indexOf >= 0) {
                int indexOf2 = str.indexOf("-->", indexOf);
                int[] iArr = new int[2];
                if (indexOf2 >= 0) {
                    iArr[0] = indexOf;
                    iArr[1] = indexOf2;
                    arrayList.add(iArr);
                    i = indexOf2 + 3;
                } else {
                    iArr[0] = indexOf;
                    iArr[1] = length;
                    arrayList.add(iArr);
                }
            }
            i = length;
        }
        return (int[][]) arrayList.toArray((int[][]) Array.newInstance(int.class, new int[]{0, 2}));
    }

    /* renamed from: b */
    public static String m3337b(String str, String str2) {
        C2860e.m3381a(str, "HTML is null or empty");
        int[][] a = m3336a(str);
        StringBuilder sb = new StringBuilder(str2.length() + str.length() + 16);
        return m3338b(str, sb, f3417b, str2, a) ? sb.toString() : m3335a(str, sb, f3416a, str2, a) ? sb.toString() : m3338b(str, sb, f3419d, str2, a) ? sb.toString() : m3335a(str, sb, f3418c, str2, a) ? sb.toString() : m3338b(str, sb, f3421f, str2, a) ? sb.toString() : m3335a(str, sb, f3420e, str2, a) ? sb.toString() : m3335a(str, sb, f3422g, str2, a) ? sb.toString() : GeneratedOutlineSupport.outline16(str2, str);
    }

    /* renamed from: b */
    public static boolean m3338b(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find(i)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!m3334a(start, iArr)) {
                sb.append(str.substring(0, matcher.end() - 2));
                sb.append(">");
                sb.append(str2);
                sb.append("</");
                sb.append(matcher.group(1));
                sb.append(">");
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i = end;
        }
        return false;
    }
}
