package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.URLUtil;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.facebook.appevents.AppEventsConstants;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.appsflyer.internal.d */
public final class C1471d {
    public static int[] AFInAppEventParameterName = {-1561070057, 514484915, 930939875, 301799129, -1732453763, 2117582934, 45892617, 527080290, -475401890, 1909085415, 1501949576, 1209623277, 100102418, 1725391356, 261332508, -2136743842, 1926168337, 853198554};
    public static long AFInAppEventType = 1208377450132544418L;
    public static int AFKeystoreWrapper = 1;
    public static int values;

    public static boolean AFInAppEventParameterName(String str) {
        int i = values + 105;
        AFKeystoreWrapper = i % 128;
        if (!(i % 2 == 0)) {
            try {
                Class.forName(str);
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        } else {
            Class.forName(str);
            return false;
        }
    }

    @Nullable
    public static String AFInAppEventType(Context context, long j) {
        String str;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        if (AFInAppEventParameterName(valueOf(new int[]{-366126248, 1594216626, 121198719, -1454430311, 1771630183, -1422284795, -342282604, -289599189, 57194665, 1596223313, -1633407671, -645694150, 1419814614, 796963686, 529596675, 501760726, -492285621, 1248821428}, (SystemClock.elapsedRealtime() > 0 ? 1 : (SystemClock.elapsedRealtime() == 0 ? 0 : -1)) + 33).intern())) {
            int i = AFKeystoreWrapper + 47;
            values = i % 128;
            if (i % 2 != 0) {
                str = AFKeystoreWrapper("멓ꇀ").intern();
                try {
                    int i2 = 75 / 0;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                str = AFKeystoreWrapper("멓ꇀ").intern();
            }
        } else {
            str = valueOf(new int[]{800975718, 1188862115}, -TextUtils.indexOf("", '0', 0)).intern();
            int i3 = values + 103;
            AFKeystoreWrapper = i3 % 128;
            int i4 = i3 % 2;
        }
        sb2.append(str);
        StringBuilder sb4 = new StringBuilder();
        String packageName = context.getPackageName();
        String valueOf = valueOf(packageName);
        sb2.append(AFKeystoreWrapper("멓ꇀ").intern());
        sb4.append(valueOf);
        if ((AFInAppEventType(context) == null ? (char) 21 : 26) != 21) {
            sb2.append(AFKeystoreWrapper("멓ꇀ").intern());
            sb4.append(packageName);
        } else {
            int i5 = values + 31;
            AFKeystoreWrapper = i5 % 128;
            int i6 = i5 % 2;
            sb2.append(valueOf(new int[]{800975718, 1188862115}, -(ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1))).intern());
            sb4.append(packageName);
        }
        String AFKeystoreWrapper2 = AFKeystoreWrapper(context);
        if (AFKeystoreWrapper2 == null) {
            sb2.append(valueOf(new int[]{800975718, 1188862115}, (ViewConfiguration.getFadingEdgeLength() >> 16) + 1).intern());
            sb4.append(packageName);
        } else {
            sb2.append(AFKeystoreWrapper("멓ꇀ").intern());
            sb4.append(AFKeystoreWrapper2);
        }
        sb4.append(values(context, packageName));
        sb.append(sb4.toString());
        try {
            sb.append(new SimpleDateFormat(valueOf(new int[]{-1188180132, -825381851, -211153543, 786248974, 862026842, 859323838, 1660704394, 1379645416, 1396011, 1600074988}, ExpandableListView.getPackedPositionChild(0) + 19).intern(), Locale.US).format(new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime)));
            sb.append(j);
            sb3.append((AFInAppEventParameterName(AFKeystoreWrapper("礥拦炩ｄ䙴촕䯅튤妀ꂣ⼛뙜㴢믐˽覗Ⴅ齁洧狭練䂿콍").intern()) ? AFKeystoreWrapper("멓ꇀ") : valueOf(new int[]{800975718, 1188862115}, TextUtils.getCapsMode("", 0, 0) + 1)).intern());
            sb3.append((AFInAppEventParameterName(AFKeystoreWrapper("?쌔ꩢ酃碌⟾ແ?葅接䫭㇒᤾쀁꽉隷緋⓯ల퉲릷悁").intern()) ? AFKeystoreWrapper("멓ꇀ") : valueOf(new int[]{800975718, 1188862115}, AndroidCharacter.getEastAsianWidth('0') - 3)).intern());
            sb3.append((AFInAppEventParameterName(valueOf(new int[]{-366126248, 1594216626, 121198719, -1454430311, 1018736745, -1677194107, 1104448559, -186780067, 2069685916, -687685980}, 20 - (ViewConfiguration.getScrollBarSize() >> 8)).intern()) ? AFKeystoreWrapper("멓ꇀ") : valueOf(new int[]{800975718, 1188862115}, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1)).intern());
            sb3.append(((AFInAppEventParameterName(valueOf(new int[]{-366126248, 1594216626, 121198719, -1454430311, -437696193, -2082656785, 988557039, -1634642004}, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 15).intern()) ? '^' : 'N') != '^' ? valueOf(new int[]{800975718, 1188862115}, TextUtils.getTrimmedLength("") + 1) : AFKeystoreWrapper("멓ꇀ")).intern());
            String AFInAppEventType2 = C1407ai.AFInAppEventType(C1407ai.valueOf(sb.toString()));
            String obj = sb2.toString();
            StringBuilder sb5 = new StringBuilder(AFInAppEventType2);
            sb5.setCharAt(17, Integer.toString(Integer.parseInt(obj, 2), 16).charAt(0));
            String obj2 = sb5.toString();
            String obj3 = sb3.toString();
            StringBuilder sb6 = new StringBuilder(obj2);
            sb6.setCharAt(27, Integer.toString(Integer.parseInt(obj3, 2), 16).charAt(0));
            return valueOf(sb6.toString(), Long.valueOf(j));
        } catch (PackageManager.NameNotFoundException unused) {
            return valueOf(new int[]{1802321378, -951457527, -1819654011, -20136054, 1414463443, 2024286047, -280389489, -614427551, 1395119073, 355582374, -181284088, 1734397673, -1098400086, -1844892891, -1303208920, -1462041732}, 32 - (ViewConfiguration.getTouchSlop() >> 8)).intern();
        }
    }

    public static String AFKeystoreWrapper(Context context) {
        int i = AFKeystoreWrapper + 17;
        values = i % 128;
        int i2 = i % 2;
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            int i3 = AFKeystoreWrapper + 69;
            values = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String valueOf(String str, Long l) {
        int i = AFKeystoreWrapper + 35;
        values = i % 128;
        if (i % 2 == 0) {
            if ((str != null ? 'A' : 13) != 13) {
                if ((l != null ? '?' : '3') == '?' && str.length() == 32) {
                    StringBuilder sb = new StringBuilder(str);
                    String obj = l.toString();
                    long j = 0;
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        if ((i2 < obj.length() ? 24 : 'D') != 24) {
                            break;
                        }
                        i3 += Character.getNumericValue(obj.charAt(i2));
                        i2++;
                    }
                    String hexString = Integer.toHexString(i3);
                    sb.replace(7, hexString.length() + 7, hexString);
                    for (int i4 = 0; i4 < sb.length(); i4++) {
                        int i5 = values + 29;
                        AFKeystoreWrapper = i5 % 128;
                        int i6 = i5 % 2;
                        j += (long) Character.getNumericValue(sb.charAt(i4));
                    }
                    while (j > 100) {
                        j %= 100;
                        int i7 = AFKeystoreWrapper + 71;
                        values = i7 % 128;
                        int i8 = i7 % 2;
                    }
                    sb.insert(23, (int) j);
                    if (j < 10) {
                        int i9 = values + 95;
                        AFKeystoreWrapper = i9 % 128;
                        if (i9 % 2 == 0) {
                            sb.insert(102, valueOf(new int[]{800975718, 1188862115}, (ViewConfiguration.getFadingEdgeLength() >> 89) * 0).intern());
                        } else {
                            sb.insert(23, valueOf(new int[]{800975718, 1188862115}, 1 - (ViewConfiguration.getFadingEdgeLength() >> 16)).intern());
                        }
                    }
                    return sb.toString();
                }
            }
            return valueOf(new int[]{1802321378, -951457527, -1819654011, -20136054, 1414463443, 2024286047, -280389489, -614427551, 1395119073, 355582374, -181284088, 1734397673, -1098400086, -1844892891, -1303208920, -1462041732}, View.MeasureSpec.makeMeasureSpec(0, 0) + 32).intern();
        }
        throw null;
    }

    public static String values(Context context, String str) {
        try {
            for (ApplicationInfo applicationInfo : (List) PackageManager.class.getDeclaredMethod(AFKeystoreWrapper("﫷슯쩻툧?ꆱ꤈냊뢒聸蠰韻龾杼漿皆繚䘘䷗喭嵹").intern(), new Class[]{Integer.TYPE}).invoke(context.getPackageManager(), new Object[]{0})) {
                if (applicationInfo.packageName.equals(str)) {
                    String obj = Boolean.TRUE.toString();
                    int i = AFKeystoreWrapper + 123;
                    values = i % 128;
                    if ((i % 2 != 0 ? '^' : '\'') != '^') {
                        return obj;
                    }
                    throw null;
                }
                int i2 = values + 121;
                AFKeystoreWrapper = i2 % 128;
                int i3 = i2 % 2;
            }
            int i4 = values + 69;
            AFKeystoreWrapper = i4 % 128;
            int i5 = i4 % 2;
        } catch (IllegalAccessException e) {
            C1414am AFKeystoreWrapper2 = C1414am.AFKeystoreWrapper();
            String intern = valueOf(new int[]{1152416525, -164918015, -2080163619, 1801793819, 202274972, -1779018482, 588742499, -570880358, -772689434, -1383085093, -842074354, 276130351}, Color.blue(0) + 24).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(AFKeystoreWrapper("靉貭㕑?䛪遰㥽ꆃ䩝鯮ಥ땲幼욗潗ဝ룬↬쩵猫ᮁ豉㕚?䚭逶㢈ꅈ䩕鮢౤딱巆왊漌៞뢯Ⅳ쨬犈ᭁ谙㒆?").intern());
            sb.append(e);
            AFKeystoreWrapper2.valueOf((String) null, intern, sb.toString());
        } catch (NoSuchMethodException e2) {
            C1414am AFKeystoreWrapper3 = C1414am.AFKeystoreWrapper();
            String intern2 = valueOf(new int[]{1152416525, -164918015, -2080163619, 1801793819, 202274972, -1779018482, 588742499, -570880358, -772689434, -1383085093, -842074354, 276130351}, View.getDefaultSize(0, 0) + 24).intern();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(AFKeystoreWrapper("靉貭㕑?䛪遰㥽ꆃ䩝鯮ಥ땲幼욗潗ဝ룬↬쩵猫ᮁ豉㕚?䚭逶㢈ꅈ䩕鮢౤딱巆왊漌៞뢯Ⅳ쨬犈ᭁ谙㒆?").intern());
            sb2.append(e2);
            AFKeystoreWrapper3.valueOf((String) null, intern2, sb2.toString());
        } catch (InvocationTargetException e3) {
            C1414am AFKeystoreWrapper4 = C1414am.AFKeystoreWrapper();
            String intern3 = valueOf(new int[]{1152416525, -164918015, -2080163619, 1801793819, 202274972, -1779018482, 588742499, -570880358, -772689434, -1383085093, -842074354, 276130351}, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 24).intern();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(AFKeystoreWrapper("靉貭㕑?䛪遰㥽ꆃ䩝鯮ಥ땲幼욗潗ဝ룬↬쩵猫ᮁ豉㕚?䚭逶㢈ꅈ䩕鮢౤딱巆왊漌៞뢯Ⅳ쨬犈ᭁ谙㒆?").intern());
            sb3.append(e3);
            AFKeystoreWrapper4.valueOf((String) null, intern3, sb3.toString());
        }
        return Boolean.FALSE.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFKeystoreWrapper(java.lang.String r8) {
        /*
            r0 = 0
            r1 = 1
            if (r8 == 0) goto L_0x0006
            r2 = 0
            goto L_0x0007
        L_0x0006:
            r2 = 1
        L_0x0007:
            if (r2 == 0) goto L_0x000a
            goto L_0x0022
        L_0x000a:
            int r2 = AFKeystoreWrapper
            int r2 = r2 + 93
            int r3 = r2 % 128
            values = r3
            int r2 = r2 % 2
            char[] r8 = r8.toCharArray()
            int r2 = values
            int r2 = r2 + 125
            int r3 = r2 % 128
            AFKeystoreWrapper = r3
            int r2 = r2 % 2
        L_0x0022:
            char[] r8 = (char[]) r8
            char r0 = r8[r0]
            int r2 = r8.length
            int r2 = r2 - r1
            char[] r2 = new char[r2]
        L_0x002a:
            int r3 = r8.length
            r4 = 96
            if (r1 >= r3) goto L_0x0032
            r3 = 96
            goto L_0x0034
        L_0x0032:
            r3 = 92
        L_0x0034:
            if (r3 == r4) goto L_0x003c
            java.lang.String r8 = new java.lang.String
            r8.<init>(r2)
            return r8
        L_0x003c:
            int r3 = r1 + -1
            char r4 = r8[r1]
            int r5 = r1 * r0
            r4 = r4 ^ r5
            long r4 = (long) r4
            long r6 = AFInAppEventType
            long r4 = r4 ^ r6
            int r5 = (int) r4
            char r4 = (char) r5
            r2[r3] = r4
            int r1 = r1 + 1
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1471d.AFKeystoreWrapper(java.lang.String):java.lang.String");
    }

    public static String valueOf(String str) {
        int i = AFKeystoreWrapper + 75;
        values = i % 128;
        int i2 = i % 2;
        if ((!str.contains(AFKeystoreWrapper("蘏鶃").intern()) ? 'H' : 'A') == 'H') {
            return str;
        }
        String[] split = str.split(AFKeystoreWrapper("훙촧똾").intern());
        int length = split.length;
        StringBuilder sb = new StringBuilder();
        int i3 = length - 1;
        sb.append(split[i3]);
        sb.append(AFKeystoreWrapper("蘏鶃").intern());
        int i4 = 1;
        while (true) {
            boolean z = false;
            if (i4 < i3) {
                int i5 = values + 71;
                AFKeystoreWrapper = i5 % 128;
                if (i5 % 2 != 0) {
                    z = true;
                }
                if (z) {
                    sb.append(split[i4]);
                    sb.append(AFKeystoreWrapper("蘏鶃").intern());
                    i4++;
                } else {
                    sb.append(split[i4]);
                    sb.append(AFKeystoreWrapper("蘏鶃").intern());
                    i4 += 49;
                }
            } else {
                sb.append(split[0]);
                return sb.toString();
            }
        }
    }

    /* renamed from: com.appsflyer.internal.d$a */
    public static class C1472a extends HashMap<String, Object> {
        public static int AFInAppEventType = 86;
        public static char AFKeystoreWrapper = '蜠';
        public static int AFLogger$LogLevel = 0;
        public static char AFVersionDeclaration = '४';
        public static int AppsFlyer2dXConversionCallback = 1;
        public static char getLevel = '?';
        public static char values = '喒';
        public final Map<String, Object> AFInAppEventParameterName;
        public final Context valueOf;

        /* renamed from: com.appsflyer.internal.d$a$d */
        public static class C1473d {
            public final Boolean AFInAppEventType;
            public final String valueOf;
            public Boolean values;

            public C1473d() {
            }

            @NonNull
            public static byte[] AFInAppEventType(@NonNull String str) throws Exception {
                return str.getBytes();
            }

            @NonNull
            public static String valueOf(@NonNull byte[] bArr) throws Exception {
                StringBuilder sb = new StringBuilder();
                for (byte hexString : bArr) {
                    String hexString2 = Integer.toHexString(hexString);
                    if (hexString2.length() == 1) {
                        hexString2 = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(hexString2);
                    }
                    sb.append(hexString2);
                }
                return sb.toString();
            }

            public C1473d(String str, Boolean bool) {
                this.valueOf = str;
                this.AFInAppEventType = bool;
            }

            public static byte[] AFInAppEventType(@NonNull byte[] bArr) throws Exception {
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (bArr[i] ^ ((i % 2) + 42));
                }
                return bArr;
            }
        }

        public C1472a(Map<String, Object> map, Context context) {
            this.AFInAppEventParameterName = map;
            this.valueOf = context;
            put(AFKeystoreWrapper(), AFInAppEventParameterName());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x01cd, code lost:
            if ((!r0.contains(AFInAppEventParameterName((android.view.ViewConfiguration.getFadingEdgeLength() >> 16) + 3, ",￬￪", android.webkit.URLUtil.isDataUrl("data:") ^ true, 162 - (android.view.ViewConfiguration.getDoubleTapTimeout() >> 16), android.view.View.MeasureSpec.getMode(0) + 3).intern())) != false) goto L_0x01e3;
         */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x02df  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x02e2 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x02e3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String AFInAppEventParameterName() {
            /*
                r20 = this;
                r1 = r20
                java.lang.String r2 = "ਂ⷏?ஔ螋犱듃ꓚ茝ꉷ랺⓸铹⭨␎㓇֬屧苊蔐蹳犑ꋊ㗝䖶쵞쮂늙잶뙟⡵歐늤\u0012뷧ᬳ篩螧搞ᰆ甥긏ԥ"
                java.lang.String r3 = "data:"
                java.lang.String r4 = ""
                r5 = 5
                r6 = 0
                r8 = 16
                r9 = 1
                r10 = 0
                java.util.Map<java.lang.String, java.lang.Object> r0 = r1.AFInAppEventParameterName     // Catch:{ Exception -> 0x00e7 }
                int r11 = android.view.KeyEvent.getMaxKeyCode()     // Catch:{ Exception -> 0x00e7 }
                int r11 = r11 >> r8
                int r11 = r11 + 6
                java.lang.String r12 = "\u0003￿\n￵￼￷\u0006\u0003￷\n\t￻"
                java.lang.String r13 = "content:"
                boolean r13 = android.webkit.URLUtil.isContentUrl(r13)     // Catch:{ Exception -> 0x00e7 }
                int r14 = android.view.ViewConfiguration.getDoubleTapTimeout()     // Catch:{ Exception -> 0x00e7 }
                int r14 = r14 >> r8
                int r14 = r14 + 192
                int r15 = android.widget.ExpandableListView.getPackedPositionType(r6)     // Catch:{ Exception -> 0x00e7 }
                int r15 = 12 - r15
                java.lang.String r11 = AFInAppEventParameterName(r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x00e7 }
                java.lang.String r11 = r11.intern()     // Catch:{ Exception -> 0x00e7 }
                java.lang.Object r0 = r0.get(r11)     // Catch:{ Exception -> 0x00e7 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00e7 }
                java.util.Map<java.lang.String, java.lang.Object> r11 = r1.AFInAppEventParameterName     // Catch:{ Exception -> 0x00e7 }
                long r12 = android.widget.ExpandableListView.getPackedPositionForGroup(r10)     // Catch:{ Exception -> 0x00e7 }
                int r14 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
                int r14 = r14 + 9
                java.lang.String r12 = "￻\u000f\b�\u0002￞￻\u000e￿\u0000\u0003\f\r\u000e￦"
                boolean r13 = android.webkit.URLUtil.isDataUrl(r3)     // Catch:{ Exception -> 0x00e7 }
                r13 = r13 ^ r9
                r15 = 48
                int r15 = android.text.TextUtils.indexOf(r4, r15, r10)     // Catch:{ Exception -> 0x00e7 }
                int r15 = 187 - r15
                int r16 = android.view.View.resolveSize(r10, r10)     // Catch:{ Exception -> 0x00e7 }
                int r6 = r16 + 15
                java.lang.String r6 = AFInAppEventParameterName(r14, r12, r13, r15, r6)     // Catch:{ Exception -> 0x00e7 }
                java.lang.String r6 = r6.intern()     // Catch:{ Exception -> 0x00e7 }
                java.lang.Object r6 = r11.get(r6)     // Catch:{ Exception -> 0x00e7 }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00e7 }
                int r7 = android.view.ViewConfiguration.getFadingEdgeLength()     // Catch:{ Exception -> 0x00e7 }
                int r7 = r7 >> r8
                int r7 = 3 - r7
                java.lang.String r11 = "\u0002�￿\u0005�"
                boolean r12 = android.view.WindowManager.LayoutParams.mayUseInputMethod(r10)     // Catch:{ Exception -> 0x00e7 }
                r12 = r12 ^ r9
                int r13 = android.graphics.drawable.Drawable.resolveOpacity(r10, r10)     // Catch:{ Exception -> 0x00e7 }
                int r13 = 135 - r13
                int r14 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ Exception -> 0x00e7 }
                int r14 = 5 - r14
                java.lang.String r7 = AFInAppEventParameterName(r7, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00e7 }
                java.lang.String r7 = r7.intern()     // Catch:{ Exception -> 0x00e7 }
                int r11 = android.view.ViewConfiguration.getScrollDefaultDelay()     // Catch:{ Exception -> 0x00e7 }
                int r11 = r11 >> r8
                int r11 = 1 - r11
                java.lang.String r12 = "￨￥￩\u001e-"
                java.lang.String r13 = "about:"
                boolean r13 = android.webkit.URLUtil.isAboutUrl(r13)     // Catch:{ Exception -> 0x00e7 }
                int r14 = android.view.ViewConfiguration.getDoubleTapTimeout()     // Catch:{ Exception -> 0x00e7 }
                int r14 = r14 >> r8
                int r14 = r14 + 155
                long r15 = android.view.ViewConfiguration.getGlobalActionKeyTimeout()     // Catch:{ Exception -> 0x00e7 }
                r17 = 0
                int r19 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
                int r15 = 6 - r19
                java.lang.String r11 = AFInAppEventParameterName(r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x00e7 }
                java.lang.String r11 = r11.intern()     // Catch:{ Exception -> 0x00e7 }
                java.lang.String r7 = r7.replaceAll(r11, r4)     // Catch:{ Exception -> 0x00e7 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e7 }
                r11.<init>()     // Catch:{ Exception -> 0x00e7 }
                r11.append(r0)     // Catch:{ Exception -> 0x00e7 }
                r11.append(r6)     // Catch:{ Exception -> 0x00e7 }
                r11.append(r7)     // Catch:{ Exception -> 0x00e7 }
                java.lang.String r0 = r11.toString()     // Catch:{ Exception -> 0x00e7 }
                java.lang.String r0 = com.appsflyer.internal.C1407ai.valueOf((java.lang.String) r0)     // Catch:{ Exception -> 0x00e7 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e7 }
                r6.<init>()     // Catch:{ Exception -> 0x00e7 }
                r6.append(r4)     // Catch:{ Exception -> 0x00e7 }
                java.lang.String r0 = r0.substring(r10, r8)     // Catch:{ Exception -> 0x00e7 }
                r6.append(r0)     // Catch:{ Exception -> 0x00e7 }
                java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x00e7 }
                goto L_0x011c
            L_0x00e7:
                r0 = move-exception
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = valueOf(r2)
                java.lang.String r7 = r7.intern()
                r6.append(r7)
                r6.append(r0)
                java.lang.String r0 = r6.toString()
                com.appsflyer.AFLogger.AFKeystoreWrapper(r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r4)
                java.lang.String r6 = "部ړՠ叿咂뀵斃꯳?⠹₦䰵ﶁ儓湺枻찳ይ宼"
                java.lang.String r6 = valueOf(r6)
                java.lang.String r6 = r6.intern()
                r0.append(r6)
                java.lang.String r0 = r0.toString()
            L_0x011c:
                r6 = r0
                r7 = 0
                r11 = 2
                android.content.Context r0 = r1.valueOf     // Catch:{ Exception -> 0x0284 }
                android.content.IntentFilter r12 = new android.content.IntentFilter     // Catch:{ Exception -> 0x0284 }
                java.lang.String r13 = "鿭䦸?婮絏冶뭹뺼Ⴏꩳ鏍椹篔㞶푂貗⁦㒱␎㓇媟?ﴵ㛲흦樟샼棶ꗒ䂅ࡽ㹔ᤄ脔糦鰿"
                java.lang.String r13 = valueOf(r13)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r13 = r13.intern()     // Catch:{ Exception -> 0x0284 }
                r12.<init>(r13)     // Catch:{ Exception -> 0x0284 }
                android.content.Intent r0 = r0.registerReceiver(r7, r12)     // Catch:{ Exception -> 0x0284 }
                r12 = -2700(0xfffffffffffff574, float:NaN)
                if (r0 == 0) goto L_0x0162
                int r13 = AFLogger$LogLevel
                int r13 = r13 + 31
                int r14 = r13 % 128
                AppsFlyer2dXConversionCallback = r14
                int r13 = r13 % r11
                java.lang.String r14 = "숼ಣ牰퍼἟曭铹⭨Ὴ솋ꤞ离"
                if (r13 != 0) goto L_0x0156
                java.lang.String r12 = valueOf(r14)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r12 = r12.intern()     // Catch:{ Exception -> 0x0284 }
                r13 = 7280(0x1c70, float:1.0201E-41)
                int r12 = r0.getIntExtra(r12, r13)     // Catch:{ Exception -> 0x0284 }
                goto L_0x0162
            L_0x0156:
                java.lang.String r13 = valueOf(r14)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r13 = r13.intern()     // Catch:{ Exception -> 0x0284 }
                int r12 = r0.getIntExtra(r13, r12)     // Catch:{ Exception -> 0x0284 }
            L_0x0162:
                android.content.Context r0 = r1.valueOf     // Catch:{ Exception -> 0x0284 }
                android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch:{ Exception -> 0x0284 }
                java.lang.String r0 = r0.nativeLibraryDir     // Catch:{ Exception -> 0x0284 }
                if (r0 == 0) goto L_0x01e3
                int r13 = AppsFlyer2dXConversionCallback
                int r13 = r13 + 19
                int r14 = r13 % 128
                AFLogger$LogLevel = r14
                int r13 = r13 % r11
                java.lang.String r14 = ",￬￪"
                if (r13 == 0) goto L_0x01a3
                int r13 = android.view.ViewConfiguration.getFadingEdgeLength()     // Catch:{ Exception -> 0x0284 }
                int r13 = r13 >>> 82
                int r13 = r11 << r13
                boolean r3 = android.webkit.URLUtil.isDataUrl(r3)     // Catch:{ Exception -> 0x0284 }
                r3 = r3 | r9
                int r15 = android.view.ViewConfiguration.getDoubleTapTimeout()     // Catch:{ Exception -> 0x0284 }
                int r15 = r15 >> 91
                int r15 = r15 + 830
                int r16 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ Exception -> 0x0284 }
                int r5 = r16 + 2
                java.lang.String r3 = AFInAppEventParameterName(r13, r14, r3, r15, r5)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x0284 }
                boolean r0 = r0.contains(r3)     // Catch:{ Exception -> 0x0284 }
                if (r0 == 0) goto L_0x01e3
                goto L_0x01d0
            L_0x01a3:
                int r5 = android.view.ViewConfiguration.getFadingEdgeLength()     // Catch:{ Exception -> 0x0284 }
                int r5 = r5 >> r8
                int r5 = r5 + 3
                boolean r3 = android.webkit.URLUtil.isDataUrl(r3)     // Catch:{ Exception -> 0x0284 }
                r3 = r3 ^ r9
                int r13 = android.view.ViewConfiguration.getDoubleTapTimeout()     // Catch:{ Exception -> 0x0284 }
                int r13 = r13 >> r8
                int r13 = 162 - r13
                int r15 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ Exception -> 0x0284 }
                int r15 = r15 + 3
                java.lang.String r3 = AFInAppEventParameterName(r5, r14, r3, r13, r15)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x0284 }
                boolean r0 = r0.contains(r3)     // Catch:{ Exception -> 0x0284 }
                if (r0 == 0) goto L_0x01cc
                r0 = 0
                goto L_0x01cd
            L_0x01cc:
                r0 = 1
            L_0x01cd:
                if (r0 == 0) goto L_0x01d0
                goto L_0x01e3
            L_0x01d0:
                int r0 = AFLogger$LogLevel
                int r0 = r0 + 79
                int r3 = r0 % 128
                AppsFlyer2dXConversionCallback = r3
                int r0 = r0 % r11
                r3 = 99
                if (r0 != 0) goto L_0x01df
                r5 = 5
                goto L_0x01e1
            L_0x01df:
                r5 = 99
            L_0x01e1:
                r0 = 1
                goto L_0x01e4
            L_0x01e3:
                r0 = 0
            L_0x01e4:
                android.content.Context r3 = r1.valueOf     // Catch:{ Exception -> 0x0284 }
                java.lang.String r5 = "l쭉篔㞶汅?௎蕤"
                java.lang.String r5 = valueOf(r5)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r5 = r5.intern()     // Catch:{ Exception -> 0x0284 }
                java.lang.Object r3 = r3.getSystemService(r5)     // Catch:{ Exception -> 0x0284 }
                android.hardware.SensorManager r3 = (android.hardware.SensorManager) r3     // Catch:{ Exception -> 0x0284 }
                r5 = -1
                java.util.List r3 = r3.getSensorList(r5)     // Catch:{ Exception -> 0x0284 }
                int r3 = r3.size()     // Catch:{ Exception -> 0x0284 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0284 }
                r5.<init>()     // Catch:{ Exception -> 0x0284 }
                int r13 = android.os.Process.getGidForName(r4)     // Catch:{ Exception -> 0x0284 }
                int r13 = -r13
                java.lang.String r14 = "\u0000"
                boolean r15 = android.text.TextUtils.isDigitsOnly(r4)     // Catch:{ Exception -> 0x0284 }
                int r7 = android.text.TextUtils.getCapsMode(r4, r10, r10)     // Catch:{ Exception -> 0x0284 }
                int r7 = 184 - r7
                int r19 = android.view.ViewConfiguration.getPressedStateDuration()     // Catch:{ Exception -> 0x0284 }
                int r19 = r19 >> 16
                int r11 = r19 + 1
                java.lang.String r7 = AFInAppEventParameterName(r13, r14, r15, r7, r11)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r7 = r7.intern()     // Catch:{ Exception -> 0x0284 }
                r5.append(r7)     // Catch:{ Exception -> 0x0284 }
                r5.append(r12)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r7 = "―濎힗៧"
                java.lang.String r7 = valueOf(r7)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r7 = r7.intern()     // Catch:{ Exception -> 0x0284 }
                r5.append(r7)     // Catch:{ Exception -> 0x0284 }
                r5.append(r0)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r0 = "―濎䯫↣"
                java.lang.String r0 = valueOf(r0)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r0 = r0.intern()     // Catch:{ Exception -> 0x0284 }
                r5.append(r0)     // Catch:{ Exception -> 0x0284 }
                r5.append(r3)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r0 = "―濎﹚鴬"
                java.lang.String r0 = valueOf(r0)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r0 = r0.intern()     // Catch:{ Exception -> 0x0284 }
                r5.append(r0)     // Catch:{ Exception -> 0x0284 }
                java.util.Map<java.lang.String, java.lang.Object> r0 = r1.AFInAppEventParameterName     // Catch:{ Exception -> 0x0284 }
                int r0 = r0.size()     // Catch:{ Exception -> 0x0284 }
                r5.append(r0)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0284 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0284 }
                r3.<init>()     // Catch:{ Exception -> 0x0284 }
                r3.append(r6)     // Catch:{ Exception -> 0x0284 }
                byte[] r0 = com.appsflyer.internal.C1471d.C1472a.C1473d.AFInAppEventType((java.lang.String) r0)     // Catch:{ Exception -> 0x0284 }
                byte[] r0 = com.appsflyer.internal.C1471d.C1472a.C1473d.AFInAppEventType((byte[]) r0)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r0 = com.appsflyer.internal.C1471d.C1472a.C1473d.valueOf(r0)     // Catch:{ Exception -> 0x0284 }
                r3.append(r0)     // Catch:{ Exception -> 0x0284 }
                java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0284 }
                goto L_0x02d3
            L_0x0284:
                r0 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r2 = valueOf(r2)
                java.lang.String r2 = r2.intern()
                r3.append(r2)
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                com.appsflyer.AFLogger.AFKeystoreWrapper(r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r6)
                int r2 = android.text.TextUtils.indexOf(r4, r4, r10)
                int r2 = r2 + 12
                boolean r3 = android.content.res.Configuration.needNewResources(r10, r10)
                int r4 = android.view.ViewConfiguration.getScrollDefaultDelay()
                int r4 = r4 >> r8
                int r4 = r4 + 171
                long r5 = android.widget.ExpandableListView.getPackedPositionForChild(r10, r10)
                java.lang.String r7 = "\u001cￜ\u001bￜ\u001b￝￝\u000e\u0013\u001f\f\u0018\u0011ￛ\u001cￛ"
                r11 = 0
                int r8 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                int r5 = 15 - r8
                java.lang.String r2 = AFInAppEventParameterName(r2, r7, r3, r4, r5)
                java.lang.String r2 = r2.intern()
                r0.append(r2)
                java.lang.String r0 = r0.toString()
            L_0x02d3:
                int r2 = AFLogger$LogLevel
                int r2 = r2 + 41
                int r3 = r2 % 128
                AppsFlyer2dXConversionCallback = r3
                r3 = 2
                int r2 = r2 % r3
                if (r2 != 0) goto L_0x02e0
                r9 = 0
            L_0x02e0:
                if (r9 == 0) goto L_0x02e3
                return r0
            L_0x02e3:
                r2 = 0
                throw r2     // Catch:{ all -> 0x02e5 }
            L_0x02e5:
                r0 = move-exception
                r2 = r0
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1471d.C1472a.AFInAppEventParameterName():java.lang.String");
        }

        public static StringBuilder AFInAppEventType(@NonNull String... strArr) throws Exception {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                if ((i < 3 ? 'H' : 19) != 'H') {
                    break;
                }
                arrayList.add(Integer.valueOf(strArr[i].length()));
                i++;
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb = new StringBuilder();
            int i2 = AFLogger$LogLevel + 77;
            AppsFlyer2dXConversionCallback = i2 % 128;
            int i3 = i2 % 2;
            int i4 = 0;
            while (true) {
                if (i4 < intValue) {
                    int i5 = AppsFlyer2dXConversionCallback + 49;
                    AFLogger$LogLevel = i5 % 128;
                    int i6 = i5 % 2;
                    Integer num = null;
                    for (int i7 = 0; i7 < 3; i7++) {
                        int i8 = AppsFlyer2dXConversionCallback + 97;
                        AFLogger$LogLevel = i8 % 128;
                        int i9 = i8 % 2;
                        char charAt = strArr[i7].charAt(i4);
                        if (num != null) {
                            charAt ^= num.intValue();
                        }
                        num = Integer.valueOf(charAt);
                    }
                    sb.append(Integer.toHexString(num.intValue()));
                    i4++;
                } else {
                    int i10 = AFLogger$LogLevel + 123;
                    AppsFlyer2dXConversionCallback = i10 % 128;
                    int i11 = i10 % 2;
                    return sb;
                }
            }
        }

        @NonNull
        private String AFKeystoreWrapper() {
            try {
                String num = Integer.toString(Build.VERSION.SDK_INT);
                String obj = this.AFInAppEventParameterName.get(AFInAppEventParameterName(View.MeasureSpec.getMode(0) + 6, "\u0003￿\n￵￼￷\u0006\u0003￷\n\t￻", !Gravity.isHorizontal(0), (Process.myTid() >> 22) + 192, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 12).intern()).toString();
                String obj2 = this.AFInAppEventParameterName.get(valueOf("韒卷铹⭨?婮").intern()).toString();
                if (obj2 == null) {
                    int i = AppsFlyer2dXConversionCallback + 41;
                    AFLogger$LogLevel = i % 128;
                    int i2 = i % 2;
                    obj2 = AFInAppEventParameterName((ViewConfiguration.getTapTimeout() >> 16) + 4, "￶\u0013\u0003\u0002￸\u0002￵\u0006", URLUtil.isHttpUrl("http://"), (ViewConfiguration.getTouchSlop() >> 8) + 162, Color.red(0) + 8).intern();
                    int i3 = AppsFlyer2dXConversionCallback + 19;
                    AFLogger$LogLevel = i3 % 128;
                    int i4 = i3 % 2;
                }
                StringBuilder sb = new StringBuilder(obj);
                sb.reverse();
                StringBuilder AFInAppEventType2 = AFInAppEventType(num, obj2, sb.toString());
                int length = AFInAppEventType2.length();
                if (!(length > 4)) {
                    while (true) {
                        if (length >= 4) {
                            break;
                        }
                        length++;
                        AFInAppEventType2.append('1');
                    }
                } else {
                    AFInAppEventType2.delete(4, length);
                }
                AFInAppEventType2.insert(0, valueOf("ﱾ蹳").intern());
                return AFInAppEventType2.toString();
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(valueOf("埀ᮘ?ஔ螋犱듃ꓚ茝ꉷ랺⓸铹⭨␎㓇֬屧苊蔐蹳苊蔐墸╄늙잶뙟⡵歐늤\u0012뷧ᬳ篩螧搞ᰆ甥긏ԥ").intern());
                sb2.append(e);
                AFLogger.AFKeystoreWrapper(sb2.toString());
                return valueOf("낣⒨蹳칗㗇칗㗇").intern();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String valueOf(java.lang.String r10) {
            /*
                int r0 = AppsFlyer2dXConversionCallback
                int r0 = r0 + 51
                int r1 = r0 % 128
                AFLogger$LogLevel = r1
                r1 = 2
                int r0 = r0 % r1
                r0 = 0
                if (r10 == 0) goto L_0x000f
                r2 = 0
                goto L_0x0011
            L_0x000f:
                r2 = 49
            L_0x0011:
                if (r2 == 0) goto L_0x0014
                goto L_0x0021
            L_0x0014:
                int r2 = AppsFlyer2dXConversionCallback
                int r2 = r2 + 13
                int r3 = r2 % 128
                AFLogger$LogLevel = r3
                int r2 = r2 % r1
                char[] r10 = r10.toCharArray()
            L_0x0021:
                char[] r10 = (char[]) r10
                int r2 = r10.length
                char[] r2 = new char[r2]
                char[] r1 = new char[r1]
                r3 = 0
            L_0x0029:
                int r4 = r10.length
                r5 = 40
                if (r3 >= r4) goto L_0x0031
                r4 = 40
                goto L_0x0033
            L_0x0031:
                r4 = 32
            L_0x0033:
                r6 = 1
                if (r4 == r5) goto L_0x003e
                char r10 = r2[r0]
                java.lang.String r0 = new java.lang.String
                r0.<init>(r2, r6, r10)
                return r0
            L_0x003e:
                char r4 = r10[r3]
                r1[r0] = r4
                int r4 = r3 + 1
                char r5 = r10[r4]
                r1[r6] = r5
                char r5 = AFKeystoreWrapper
                char r7 = values
                char r8 = AFVersionDeclaration
                char r9 = getLevel
                com.appsflyer.internal.C1469ce.AFKeystoreWrapper(r1, r5, r7, r8, r9)
                char r5 = r1[r0]
                r2[r3] = r5
                char r5 = r1[r6]
                r2[r4] = r5
                int r3 = r3 + 2
                goto L_0x0029
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1471d.C1472a.valueOf(java.lang.String):java.lang.String");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: char[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: java.lang.String} */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String AFInAppEventParameterName(int r6, java.lang.String r7, boolean r8, int r9, int r10) {
            /*
                r0 = 1
                r1 = 0
                if (r7 == 0) goto L_0x0006
                r2 = 0
                goto L_0x0007
            L_0x0006:
                r2 = 1
            L_0x0007:
                if (r2 == r0) goto L_0x0023
                int r2 = AppsFlyer2dXConversionCallback
                int r2 = r2 + 27
                int r3 = r2 % 128
                AFLogger$LogLevel = r3
                int r2 = r2 % 2
                if (r2 == 0) goto L_0x001f
                char[] r7 = r7.toCharArray()
                r2 = 95
                int r2 = r2 / r1
                goto L_0x0023
            L_0x001d:
                r6 = move-exception
                throw r6
            L_0x001f:
                char[] r7 = r7.toCharArray()
            L_0x0023:
                char[] r7 = (char[]) r7
                char[] r2 = new char[r10]
                r3 = 0
            L_0x0028:
                r4 = 44
                if (r3 >= r10) goto L_0x002f
                r5 = 36
                goto L_0x0031
            L_0x002f:
                r5 = 44
            L_0x0031:
                if (r5 == r4) goto L_0x004e
                char r4 = r7[r3]
                int r4 = r4 + r9
                char r4 = (char) r4
                r2[r3] = r4
                char r4 = r2[r3]
                int r5 = AFInAppEventType
                int r4 = r4 - r5
                char r4 = (char) r4
                r2[r3] = r4
                int r3 = r3 + 1
                int r4 = AFLogger$LogLevel
                int r4 = r4 + 25
                int r5 = r4 % 128
                AppsFlyer2dXConversionCallback = r5
                int r4 = r4 % 2
                goto L_0x0028
            L_0x004e:
                if (r6 <= 0) goto L_0x0052
                r7 = 1
                goto L_0x0053
            L_0x0052:
                r7 = 0
            L_0x0053:
                if (r7 == 0) goto L_0x0062
                char[] r7 = new char[r10]
                java.lang.System.arraycopy(r2, r1, r7, r1, r10)
                int r9 = r10 - r6
                java.lang.System.arraycopy(r7, r1, r2, r9, r6)
                java.lang.System.arraycopy(r7, r6, r2, r1, r9)
            L_0x0062:
                if (r8 == 0) goto L_0x0087
                int r6 = AFLogger$LogLevel
                int r6 = r6 + 89
                int r7 = r6 % 128
                AppsFlyer2dXConversionCallback = r7
                int r6 = r6 % 2
                char[] r6 = new char[r10]
            L_0x0070:
                if (r1 >= r10) goto L_0x0086
                int r7 = AFLogger$LogLevel
                int r7 = r7 + 97
                int r8 = r7 % 128
                AppsFlyer2dXConversionCallback = r8
                int r7 = r7 % 2
                int r7 = r10 - r1
                int r7 = r7 - r0
                char r7 = r2[r7]
                r6[r1] = r7
                int r1 = r1 + 1
                goto L_0x0070
            L_0x0086:
                r2 = r6
            L_0x0087:
                java.lang.String r6 = new java.lang.String
                r6.<init>(r2)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1471d.C1472a.AFInAppEventParameterName(int, java.lang.String, boolean, int, int):java.lang.String");
        }
    }

    public static String valueOf(int[] iArr, int i) {
        char[] cArr = new char[4];
        char[] cArr2 = new char[(iArr.length << 1)];
        int[] iArr2 = (int[]) AFInAppEventParameterName.clone();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if ((i2 < iArr.length ? 'Q' : '$') == '$') {
                break;
            }
            cArr[0] = (char) (iArr[i2] >> 16);
            cArr[1] = (char) iArr[i2];
            int i3 = i2 + 1;
            cArr[2] = (char) (iArr[i3] >> 16);
            cArr[3] = (char) iArr[i3];
            C1470cf.AFInAppEventParameterName(cArr, iArr2, false);
            int i4 = i2 << 1;
            cArr2[i4] = cArr[0];
            cArr2[i4 + 1] = cArr[1];
            cArr2[i4 + 2] = cArr[2];
            cArr2[i4 + 3] = cArr[3];
            i2 += 2;
            int i5 = AFKeystoreWrapper + 101;
            values = i5 % 128;
            int i6 = i5 % 2;
        }
        String str = new String(cArr2, 0, i);
        int i7 = values + 117;
        AFKeystoreWrapper = i7 % 128;
        if (i7 % 2 != 0) {
            z = true;
        }
        if (z) {
            return str;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        if ((!java.lang.System.getProperties().containsKey(valueOf(new int[]{1141018980, -98311195, 450320629, -863775449, -1220162186, -1527388840, 1565031198, -886603873}, 14 - android.text.TextUtils.getCapsMode("", 0, 0)).intern())) != false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0057, code lost:
        if (java.lang.System.getProperties().containsKey(valueOf(new int[]{1141018980, -98311195, 450320629, -863775449, -1220162186, -1527388840, 1565031198, -886603873}, 85 >>> android.text.TextUtils.getCapsMode("", 1, 1)).intern()) != false) goto L_0x0059;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String AFInAppEventType(android.content.Context r8) {
        /*
            int r0 = AFKeystoreWrapper
            int r0 = r0 + 113
            int r1 = r0 % 128
            values = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0010
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            r3 = 8
            java.lang.String r4 = ""
            r5 = 0
            if (r0 == 0) goto L_0x003b
            java.util.Properties r0 = java.lang.System.getProperties()
            int[] r3 = new int[r3]
            r3 = {1141018980, -98311195, 450320629, -863775449, -1220162186, -1527388840, 1565031198, -886603873} // fill-array
            int r6 = android.text.TextUtils.getCapsMode(r4, r1, r1)
            int r6 = 14 - r6
            java.lang.String r3 = valueOf((int[]) r3, (int) r6)
            java.lang.String r3 = r3.intern()
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x0037
            r0 = 0
            goto L_0x0038
        L_0x0037:
            r0 = 1
        L_0x0038:
            if (r0 == 0) goto L_0x0059
            goto L_0x0098
        L_0x003b:
            java.util.Properties r0 = java.lang.System.getProperties()
            int[] r3 = new int[r3]
            r3 = {1141018980, -98311195, 450320629, -863775449, -1220162186, -1527388840, 1565031198, -886603873} // fill-array
            r6 = 85
            int r7 = android.text.TextUtils.getCapsMode(r4, r2, r2)
            int r6 = r6 >>> r7
            java.lang.String r3 = valueOf((int[]) r3, (int) r6)
            java.lang.String r3 = r3.intern()
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x0098
        L_0x0059:
            java.io.File r8 = r8.getCacheDir()     // Catch:{ Exception -> 0x009a }
            java.lang.String r8 = r8.getPath()     // Catch:{ Exception -> 0x009a }
            java.lang.String r0 = "귧뙪䀏ቶ걝繉ࢭ"
            java.lang.String r0 = AFKeystoreWrapper((java.lang.String) r0)     // Catch:{ Exception -> 0x009a }
            java.lang.String r0 = r0.intern()     // Catch:{ Exception -> 0x009a }
            java.lang.String r8 = r8.replace(r0, r4)     // Catch:{ Exception -> 0x009a }
            java.lang.String r0 = "㹣◯李ꂤⰾ淚꼿⫳瑕"
            java.lang.String r0 = AFKeystoreWrapper((java.lang.String) r0)     // Catch:{ Exception -> 0x009a }
            java.lang.String r0 = r0.intern()     // Catch:{ Exception -> 0x009a }
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x009a }
            java.util.regex.Matcher r8 = r0.matcher(r8)     // Catch:{ Exception -> 0x009a }
            boolean r0 = r8.find()     // Catch:{ Exception -> 0x009a }
            if (r0 == 0) goto L_0x0098
            java.lang.String r8 = r8.group(r2)     // Catch:{ Exception -> 0x009a }
            int r0 = values
            int r0 = r0 + 11
            int r1 = r0 % 128
            AFKeystoreWrapper = r1
            int r0 = r0 % 2
            goto L_0x00d6
        L_0x0098:
            r8 = r5
            goto L_0x00d6
        L_0x009a:
            r8 = move-exception
            com.appsflyer.internal.am r0 = com.appsflyer.internal.C1414am.AFKeystoreWrapper()
            r3 = 10
            int[] r3 = new int[r3]
            r3 = {1152416525, -164918015, -2080163619, 1801793819, -948359309, -2043990532, 59265054, 669102890, 1548748609, 1430423480} // fill-array
            int r4 = android.text.TextUtils.indexOf(r4, r4, r1, r1)
            int r4 = 17 - r4
            java.lang.String r3 = valueOf((int[]) r3, (int) r4)
            java.lang.String r3 = r3.intern()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "寫䀏강ࠊ瑢큐㱄飯쒎₎責哃넹ᵘ礄ꕳŚ浌즶㗞醕ﷱ始藂下ꨂᙢ牕?㪲暺슊⻱諳匼뼯ᬁ䜠ꌡ"
            java.lang.String r6 = AFKeystoreWrapper((java.lang.String) r6)
            java.lang.String r6 = r6.intern()
            r4.append(r6)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            java.lang.String[] r2 = new java.lang.String[r2]
            r2[r1] = r8
            r0.valueOf(r5, r3, r2)
            return r5
        L_0x00d6:
            int r0 = AFKeystoreWrapper
            int r0 = r0 + 113
            int r1 = r0 % 128
            values = r1
            int r0 = r0 % 2
            r1 = 86
            if (r0 == 0) goto L_0x00e6
            r2 = 86
        L_0x00e6:
            if (r2 == r1) goto L_0x00e9
            return r8
        L_0x00e9:
            throw r5     // Catch:{ all -> 0x00ea }
        L_0x00ea:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1471d.AFInAppEventType(android.content.Context):java.lang.String");
    }
}
