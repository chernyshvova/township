package com.helpshift.support.external;

import com.google.android.gms.ads.RequestConfiguration;

public class DoubleMetaphone {
    public static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};
    public static final String[] L_R_N_M_B_H_F_V_W_SPACE = {"L", "R", "N", "M", "B", "H", "F", "V", "W", " "};
    public static final String[] L_T_K_S_N_M_B_Z = {"L", RequestConfiguration.MAX_AD_CONTENT_RATING_T, "K", "S", "N", "M", "B", "Z"};
    public static final String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS"};
    public static final String VOWELS = "AEIOUY";
    public int maxCodeLen = 4;

    public class DoubleMetaphoneResult {
        public final StringBuilder alternate = new StringBuilder(DoubleMetaphone.this.maxCodeLen);
        public final int maxLength;
        public final StringBuilder primary = new StringBuilder(DoubleMetaphone.this.maxCodeLen);

        public DoubleMetaphoneResult(int i) {
            this.maxLength = i;
        }
    }

    public static boolean contains(String str, int i, int i2, String[] strArr) {
        int i3;
        if (i < 0 || (i3 = i2 + i) > str.length()) {
            return false;
        }
        String substring = str.substring(i, i3);
        for (String equals : strArr) {
            if (substring.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public char charAt(String str, int i) {
        if (i < 0 || i >= str.length()) {
            return 0;
        }
        return str.charAt(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.helpshift.support.external.DoubleMetaphone$DoubleMetaphoneResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v179, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v355, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v61, resolved type: int} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x033c, code lost:
        if (charAt(r1, r3) == 'V') goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x057a, code lost:
        if (contains(r1, r3, 1, new java.lang.String[]{"Z"}) != false) goto L_0x057c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x057c, code lost:
        r3 = r7 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x0748, code lost:
        if (contains(r1, r3, 1, new java.lang.String[]{"S", "Z"}) != false) goto L_0x057c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x078d, code lost:
        r7 = r7 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x07f6, code lost:
        if (charAt(r1, r3) == r4) goto L_0x0508;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x0825, code lost:
        if (charAt(r1, r3) == 'Q') goto L_0x0508;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0093, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x08b3, code lost:
        if (charAt(r1, r3) == r4) goto L_0x0508;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x090b, code lost:
        if (r4 != false) goto L_0x0508;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:452:0x09e9, code lost:
        if (charAt(r1, r3) == r4) goto L_0x0508;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bf, code lost:
        r7 = r7 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:498:0x0adf, code lost:
        if (charAt(r1, r4) == 'J') goto L_0x0508;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:499:0x0ae3, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:521:0x0b54, code lost:
        if (VOWELS.indexOf(charAt(r1, r7 - 1)) != -1) goto L_0x0b58;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:719:0x0fc8, code lost:
        if (charAt(r1, r3) == r4) goto L_0x0508;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:970:0x1552, code lost:
        if (charAt(r1, r3) == 'B') goto L_0x0508;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x10ea  */
    /* JADX WARNING: Removed duplicated region for block: B:781:0x1114  */
    /* JADX WARNING: Removed duplicated region for block: B:804:0x1196  */
    /* JADX WARNING: Removed duplicated region for block: B:810:0x11ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String doubleMetaphone(java.lang.String r23, boolean r24) {
        /*
            r22 = this;
            r0 = r22
            if (r23 != 0) goto L_0x0006
            r1 = 0
            return r1
        L_0x0006:
            java.lang.String r1 = r23.trim()
            int r2 = r1.length()
            if (r2 != 0) goto L_0x0012
            r1 = 0
            return r1
        L_0x0012:
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toUpperCase(r2)
            r2 = 87
            int r2 = r1.indexOf(r2)
            r3 = -1
            r4 = 75
            r5 = 0
            r6 = 1
            if (r2 > r3) goto L_0x003e
            int r2 = r1.indexOf(r4)
            if (r2 > r3) goto L_0x003e
            java.lang.String r2 = "CZ"
            int r2 = r1.indexOf(r2)
            if (r2 > r3) goto L_0x003e
            java.lang.String r2 = "WITZ"
            int r2 = r1.indexOf(r2)
            if (r2 <= r3) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r2 = 0
            goto L_0x003f
        L_0x003e:
            r2 = 1
        L_0x003f:
            java.lang.String[] r7 = SILENT_START
            int r8 = r7.length
            r9 = 0
        L_0x0043:
            if (r9 >= r8) goto L_0x0052
            r10 = r7[r9]
            boolean r10 = r1.startsWith(r10)
            if (r10 == 0) goto L_0x004f
            r7 = 1
            goto L_0x0053
        L_0x004f:
            int r9 = r9 + 1
            goto L_0x0043
        L_0x0052:
            r7 = 0
        L_0x0053:
            com.helpshift.support.external.DoubleMetaphone$DoubleMetaphoneResult r8 = new com.helpshift.support.external.DoubleMetaphone$DoubleMetaphoneResult
            int r9 = r0.maxCodeLen
            r8.<init>(r9)
        L_0x005a:
            java.lang.StringBuilder r9 = r8.primary
            int r9 = r9.length()
            int r10 = r8.maxLength
            if (r9 < r10) goto L_0x006e
            java.lang.StringBuilder r9 = r8.alternate
            int r9 = r9.length()
            int r10 = r8.maxLength
            if (r9 >= r10) goto L_0x15d2
        L_0x006e:
            int r9 = r1.length()
            int r9 = r9 - r6
            if (r7 > r9) goto L_0x15d2
            char r9 = r1.charAt(r7)
            r10 = 199(0xc7, float:2.79E-43)
            r11 = 83
            if (r9 == r10) goto L_0x15af
            r10 = 209(0xd1, float:2.93E-43)
            if (r9 == r10) goto L_0x1587
            java.lang.String r13 = "E"
            java.lang.String r14 = "KS"
            r12 = 84
            java.lang.String r4 = "AEIOUY"
            r15 = 72
            r3 = 74
            r10 = 2
            switch(r9) {
                case 65: goto L_0x1556;
                case 66: goto L_0x1524;
                case 67: goto L_0x1097;
                case 68: goto L_0x0fcc;
                case 69: goto L_0x1556;
                case 70: goto L_0x0f9f;
                case 71: goto L_0x0b84;
                case 72: goto L_0x0b47;
                case 73: goto L_0x1556;
                case 74: goto L_0x09ed;
                case 75: goto L_0x09c0;
                case 76: goto L_0x090f;
                case 77: goto L_0x08b7;
                case 78: goto L_0x088a;
                case 79: goto L_0x1556;
                case 80: goto L_0x0829;
                case 81: goto L_0x07fa;
                case 82: goto L_0x0791;
                case 83: goto L_0x0462;
                case 84: goto L_0x0340;
                case 85: goto L_0x1556;
                case 86: goto L_0x0311;
                case 87: goto L_0x01da;
                case 88: goto L_0x0147;
                case 89: goto L_0x1556;
                case 90: goto L_0x0099;
                default: goto L_0x0093;
            }
        L_0x0093:
            int r7 = r7 + 1
        L_0x0095:
            r3 = -1
            r4 = 75
            goto L_0x005a
        L_0x0099:
            int r4 = r7 + 1
            char r9 = r0.charAt(r1, r4)
            if (r9 != r15) goto L_0x00c2
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r9 = r8.maxLength
            if (r4 >= r9) goto L_0x00b0
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r3)
        L_0x00b0:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r9 = r8.maxLength
            if (r4 >= r9) goto L_0x00bf
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r3)
        L_0x00bf:
            int r7 = r7 + 2
            goto L_0x0095
        L_0x00c2:
            java.lang.String r3 = "ZO"
            java.lang.String r9 = "ZI"
            java.lang.String r13 = "ZA"
            java.lang.String[] r3 = new java.lang.String[]{r3, r9, r13}
            boolean r3 = contains(r1, r4, r10, r3)
            if (r3 != 0) goto L_0x00fe
            if (r2 == 0) goto L_0x00df
            if (r7 <= 0) goto L_0x00df
            int r3 = r7 + -1
            char r3 = r0.charAt(r1, r3)
            if (r3 == r12) goto L_0x00df
            goto L_0x00fe
        L_0x00df:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r9 = r8.maxLength
            if (r3 >= r9) goto L_0x00ee
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r11)
        L_0x00ee:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r9 = r8.maxLength
            if (r3 >= r9) goto L_0x013a
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r11)
            goto L_0x013a
        L_0x00fe:
            int r3 = r8.maxLength
            java.lang.StringBuilder r9 = r8.primary
            int r9 = r9.length()
            int r3 = r3 - r9
            if (r6 > r3) goto L_0x0111
            java.lang.StringBuilder r3 = r8.primary
            java.lang.String r9 = "S"
            r3.append(r9)
            goto L_0x011c
        L_0x0111:
            java.lang.StringBuilder r9 = r8.primary
            java.lang.String r11 = "S"
            java.lang.String r3 = r11.substring(r5, r3)
            r9.append(r3)
        L_0x011c:
            int r3 = r8.maxLength
            java.lang.StringBuilder r9 = r8.alternate
            int r9 = r9.length()
            int r3 = r3 - r9
            if (r10 > r3) goto L_0x012f
            java.lang.StringBuilder r3 = r8.alternate
            java.lang.String r9 = "TS"
            r3.append(r9)
            goto L_0x013a
        L_0x012f:
            java.lang.StringBuilder r9 = r8.alternate
            java.lang.String r10 = "TS"
            java.lang.String r3 = r10.substring(r5, r3)
            r9.append(r3)
        L_0x013a:
            char r3 = r0.charAt(r1, r4)
            r9 = 90
            if (r3 != r9) goto L_0x0144
            int r4 = r7 + 2
        L_0x0144:
            r7 = r4
            goto L_0x0095
        L_0x0147:
            if (r7 != 0) goto L_0x0169
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0158
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r11)
        L_0x0158:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0093
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r11)
            goto L_0x0093
        L_0x0169:
            int r3 = r1.length()
            int r3 = r3 - r6
            if (r7 != r3) goto L_0x0191
            int r3 = r7 + -3
            java.lang.String r4 = "IAU"
            java.lang.String r9 = "EAU"
            java.lang.String[] r4 = new java.lang.String[]{r4, r9}
            r9 = 3
            boolean r3 = contains(r1, r3, r9, r4)
            if (r3 != 0) goto L_0x01c5
            int r3 = r7 + -2
            java.lang.String r4 = "AU"
            java.lang.String r9 = "OU"
            java.lang.String[] r4 = new java.lang.String[]{r4, r9}
            boolean r3 = contains(r1, r3, r10, r4)
            if (r3 != 0) goto L_0x01c5
        L_0x0191:
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r10 > r3) goto L_0x01a2
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r14)
            goto L_0x01ab
        L_0x01a2:
            java.lang.StringBuilder r4 = r8.primary
            java.lang.String r3 = r14.substring(r5, r3)
            r4.append(r3)
        L_0x01ab:
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r10 > r3) goto L_0x01bc
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r14)
            goto L_0x01c5
        L_0x01bc:
            java.lang.StringBuilder r4 = r8.alternate
            java.lang.String r3 = r14.substring(r5, r3)
            r4.append(r3)
        L_0x01c5:
            int r3 = r7 + 1
            java.lang.String r4 = "C"
            java.lang.String r9 = "X"
            java.lang.String[] r4 = new java.lang.String[]{r4, r9}
            boolean r4 = contains(r1, r3, r6, r4)
            if (r4 == 0) goto L_0x01d7
            int r3 = r7 + 2
        L_0x01d7:
            r7 = r3
            goto L_0x0095
        L_0x01da:
            java.lang.String r3 = "WR"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            boolean r3 = contains(r1, r7, r10, r3)
            if (r3 == 0) goto L_0x020b
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x01f8
            java.lang.StringBuilder r3 = r8.primary
            r4 = 82
            r3.append(r4)
            goto L_0x01fa
        L_0x01f8:
            r4 = 82
        L_0x01fa:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r9 = r8.maxLength
            if (r3 >= r9) goto L_0x00bf
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x00bf
        L_0x020b:
            if (r7 != 0) goto L_0x0278
            int r3 = r7 + 1
            char r9 = r0.charAt(r1, r3)
            int r9 = r4.indexOf(r9)
            r11 = -1
            if (r9 != r11) goto L_0x0226
            java.lang.String r9 = "WH"
            java.lang.String[] r9 = new java.lang.String[]{r9}
            boolean r9 = contains(r1, r7, r10, r9)
            if (r9 == 0) goto L_0x0278
        L_0x0226:
            char r7 = r0.charAt(r1, r3)
            int r4 = r4.indexOf(r7)
            if (r4 == r11) goto L_0x0253
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r7 = r8.maxLength
            if (r4 >= r7) goto L_0x0241
            java.lang.StringBuilder r4 = r8.primary
            r7 = 65
            r4.append(r7)
        L_0x0241:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r7 = r8.maxLength
            if (r4 >= r7) goto L_0x01d7
            java.lang.StringBuilder r4 = r8.alternate
            r7 = 70
            r4.append(r7)
            goto L_0x01d7
        L_0x0253:
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r7 = r8.maxLength
            if (r4 >= r7) goto L_0x0265
            java.lang.StringBuilder r4 = r8.primary
            r7 = 65
            r4.append(r7)
            goto L_0x0267
        L_0x0265:
            r7 = 65
        L_0x0267:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r9 = r8.maxLength
            if (r4 >= r9) goto L_0x01d7
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r7)
            goto L_0x01d7
        L_0x0278:
            int r3 = r1.length()
            int r3 = r3 - r6
            if (r7 != r3) goto L_0x028c
            int r3 = r7 + -1
            char r3 = r0.charAt(r1, r3)
            int r3 = r4.indexOf(r3)
            r4 = -1
            if (r3 != r4) goto L_0x02fe
        L_0x028c:
            int r3 = r7 + -1
            r4 = 5
            java.lang.String r9 = "EWSKI"
            java.lang.String r11 = "EWSKY"
            java.lang.String r12 = "OWSKI"
            java.lang.String r13 = "OWSKY"
            java.lang.String[] r9 = new java.lang.String[]{r9, r11, r12, r13}
            boolean r3 = contains(r1, r3, r4, r9)
            if (r3 != 0) goto L_0x02fe
            java.lang.String r3 = "SCH"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r4 = 3
            boolean r3 = contains(r1, r5, r4, r3)
            if (r3 == 0) goto L_0x02af
            goto L_0x02fe
        L_0x02af:
            java.lang.String r3 = "WICZ"
            java.lang.String r4 = "WITZ"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}
            r4 = 4
            boolean r3 = contains(r1, r7, r4, r3)
            if (r3 == 0) goto L_0x0093
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r10 > r3) goto L_0x02d1
            java.lang.StringBuilder r3 = r8.primary
            java.lang.String r4 = "TS"
            r3.append(r4)
            goto L_0x02dc
        L_0x02d1:
            java.lang.StringBuilder r4 = r8.primary
            java.lang.String r9 = "TS"
            java.lang.String r3 = r9.substring(r5, r3)
            r4.append(r3)
        L_0x02dc:
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r10 > r3) goto L_0x02ef
            java.lang.StringBuilder r3 = r8.alternate
            java.lang.String r4 = "FX"
            r3.append(r4)
            goto L_0x02fa
        L_0x02ef:
            java.lang.StringBuilder r4 = r8.alternate
            java.lang.String r9 = "FX"
            java.lang.String r3 = r9.substring(r5, r3)
            r4.append(r3)
        L_0x02fa:
            int r7 = r7 + 4
            goto L_0x0095
        L_0x02fe:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0093
            java.lang.StringBuilder r3 = r8.alternate
            r4 = 70
            r3.append(r4)
            goto L_0x0093
        L_0x0311:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0323
            java.lang.StringBuilder r3 = r8.primary
            r4 = 70
            r3.append(r4)
            goto L_0x0325
        L_0x0323:
            r4 = 70
        L_0x0325:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r9 = r8.maxLength
            if (r3 >= r9) goto L_0x0334
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x0334:
            int r3 = r7 + 1
            char r4 = r0.charAt(r1, r3)
            r9 = 86
            if (r4 != r9) goto L_0x01d7
            goto L_0x00bf
        L_0x0340:
            java.lang.String r3 = "TION"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r4 = 4
            boolean r3 = contains(r1, r7, r4, r3)
            if (r3 == 0) goto L_0x0374
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x035f
            java.lang.StringBuilder r3 = r8.primary
            r4 = 88
            r3.append(r4)
            goto L_0x0361
        L_0x035f:
            r4 = 88
        L_0x0361:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r9 = r8.maxLength
            if (r3 >= r9) goto L_0x0370
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x0370:
            int r7 = r7 + 3
            goto L_0x0095
        L_0x0374:
            java.lang.String r3 = "TIA"
            java.lang.String r4 = "TCH"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}
            r4 = 3
            boolean r3 = contains(r1, r7, r4, r3)
            if (r3 == 0) goto L_0x03a7
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0395
            java.lang.StringBuilder r3 = r8.primary
            r4 = 88
            r3.append(r4)
            goto L_0x0397
        L_0x0395:
            r4 = 88
        L_0x0397:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r9 = r8.maxLength
            if (r3 >= r9) goto L_0x0370
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x0370
        L_0x03a7:
            java.lang.String r3 = "TH"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            boolean r3 = contains(r1, r7, r10, r3)
            if (r3 != 0) goto L_0x03f3
            java.lang.String r3 = "TTH"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r4 = 3
            boolean r3 = contains(r1, r7, r4, r3)
            if (r3 == 0) goto L_0x03c1
            goto L_0x03f3
        L_0x03c1:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x03d0
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r12)
        L_0x03d0:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x03df
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r12)
        L_0x03df:
            int r3 = r7 + 1
            java.lang.String r4 = "T"
            java.lang.String r9 = "D"
            java.lang.String[] r4 = new java.lang.String[]{r4, r9}
            boolean r4 = contains(r1, r3, r6, r4)
            if (r4 == 0) goto L_0x01d7
            int r3 = r7 + 2
            goto L_0x01d7
        L_0x03f3:
            int r7 = r7 + 2
            java.lang.String r3 = "OM"
            java.lang.String r4 = "AM"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}
            boolean r3 = contains(r1, r7, r10, r3)
            if (r3 != 0) goto L_0x0442
            java.lang.String r3 = "VAN "
            java.lang.String r4 = "VON "
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}
            r4 = 4
            boolean r3 = contains(r1, r5, r4, r3)
            if (r3 != 0) goto L_0x0442
            java.lang.String r3 = "SCH"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r4 = 3
            boolean r3 = contains(r1, r5, r4, r3)
            if (r3 == 0) goto L_0x0420
            goto L_0x0442
        L_0x0420:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0431
            java.lang.StringBuilder r3 = r8.primary
            r4 = 48
            r3.append(r4)
        L_0x0431:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0095
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r12)
            goto L_0x0095
        L_0x0442:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0451
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r12)
        L_0x0451:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0095
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r12)
            goto L_0x0095
        L_0x0462:
            int r3 = r7 + -1
            java.lang.String r9 = "ISL"
            java.lang.String r12 = "YSL"
            java.lang.String[] r9 = new java.lang.String[]{r9, r12}
            r12 = 3
            boolean r3 = contains(r1, r3, r12, r9)
            if (r3 == 0) goto L_0x0475
        L_0x0473:
            goto L_0x157f
        L_0x0475:
            if (r7 != 0) goto L_0x04a5
            r3 = 5
            java.lang.String r9 = "SUGAR"
            java.lang.String[] r9 = new java.lang.String[]{r9}
            boolean r3 = contains(r1, r7, r3, r9)
            if (r3 == 0) goto L_0x04a5
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0495
            java.lang.StringBuilder r3 = r8.primary
            r4 = 88
            r3.append(r4)
        L_0x0495:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x157f
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r11)
            goto L_0x0473
        L_0x04a5:
            java.lang.String r3 = "SH"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            boolean r3 = contains(r1, r7, r10, r3)
            if (r3 == 0) goto L_0x050c
            int r3 = r7 + 1
            java.lang.String r4 = "HEIM"
            java.lang.String r9 = "HOEK"
            java.lang.String r10 = "HOLM"
            java.lang.String r12 = "HOLZ"
            java.lang.String[] r4 = new java.lang.String[]{r4, r9, r10, r12}
            r9 = 4
            boolean r3 = contains(r1, r3, r9, r4)
            if (r3 == 0) goto L_0x04e5
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x04d5
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r11)
        L_0x04d5:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0508
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r11)
            goto L_0x0508
        L_0x04e5:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x04f7
            java.lang.StringBuilder r3 = r8.primary
            r4 = 88
            r3.append(r4)
            goto L_0x04f9
        L_0x04f7:
            r4 = 88
        L_0x04f9:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r9 = r8.maxLength
            if (r3 >= r9) goto L_0x0508
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x0508:
            int r7 = r7 + 2
            goto L_0x1581
        L_0x050c:
            java.lang.String r3 = "SIO"
            java.lang.String r9 = "SIA"
            java.lang.String[] r3 = new java.lang.String[]{r3, r9}
            r9 = 3
            boolean r3 = contains(r1, r7, r9, r3)
            if (r3 != 0) goto L_0x074c
            java.lang.String r3 = "SIAN"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r9 = 4
            boolean r3 = contains(r1, r7, r9, r3)
            if (r3 == 0) goto L_0x052a
            goto L_0x074c
        L_0x052a:
            if (r7 != 0) goto L_0x0540
            int r3 = r7 + 1
            java.lang.String r9 = "M"
            java.lang.String r12 = "N"
            java.lang.String r14 = "L"
            java.lang.String r5 = "W"
            java.lang.String[] r5 = new java.lang.String[]{r9, r12, r14, r5}
            boolean r3 = contains(r1, r3, r6, r5)
            if (r3 != 0) goto L_0x054e
        L_0x0540:
            int r3 = r7 + 1
            java.lang.String r5 = "Z"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            boolean r5 = contains(r1, r3, r6, r5)
            if (r5 == 0) goto L_0x0581
        L_0x054e:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x055d
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r11)
        L_0x055d:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x056e
            java.lang.StringBuilder r3 = r8.alternate
            r4 = 88
            r3.append(r4)
        L_0x056e:
            int r3 = r7 + 1
            java.lang.String r4 = "Z"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            boolean r4 = contains(r1, r3, r6, r4)
            if (r4 == 0) goto L_0x057e
        L_0x057c:
            int r3 = r7 + 2
        L_0x057e:
            r7 = r3
            goto L_0x1581
        L_0x0581:
            java.lang.String r5 = "SC"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            boolean r5 = contains(r1, r7, r10, r5)
            if (r5 == 0) goto L_0x06f7
            int r3 = r7 + 2
            char r5 = r0.charAt(r1, r3)
            java.lang.String r9 = "SK"
            if (r5 != r15) goto L_0x0690
            int r3 = r7 + 3
            java.lang.String r16 = "OO"
            java.lang.String r17 = "ER"
            java.lang.String r18 = "EN"
            java.lang.String r19 = "UY"
            java.lang.String r20 = "ED"
            java.lang.String r21 = "EM"
            java.lang.String[] r5 = new java.lang.String[]{r16, r17, r18, r19, r20, r21}
            boolean r5 = contains(r1, r3, r10, r5)
            if (r5 == 0) goto L_0x0633
            java.lang.String r4 = "ER"
            java.lang.String r5 = "EN"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}
            boolean r3 = contains(r1, r3, r10, r4)
            if (r3 == 0) goto L_0x05fa
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r6 > r3) goto L_0x05d0
            java.lang.StringBuilder r3 = r8.primary
            java.lang.String r4 = "X"
            r3.append(r4)
            goto L_0x05dc
        L_0x05d0:
            java.lang.StringBuilder r4 = r8.primary
            java.lang.String r5 = "X"
            r11 = 0
            java.lang.String r3 = r5.substring(r11, r3)
            r4.append(r3)
        L_0x05dc:
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r10 > r3) goto L_0x05ee
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r9)
            goto L_0x078d
        L_0x05ee:
            java.lang.StringBuilder r4 = r8.alternate
            r5 = 0
            java.lang.String r3 = r9.substring(r5, r3)
            r4.append(r3)
            goto L_0x078d
        L_0x05fa:
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r10 > r3) goto L_0x060b
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r9)
            goto L_0x0615
        L_0x060b:
            java.lang.StringBuilder r4 = r8.primary
            r5 = 0
            java.lang.String r3 = r9.substring(r5, r3)
            r4.append(r3)
        L_0x0615:
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r10 > r3) goto L_0x0627
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r9)
            goto L_0x078d
        L_0x0627:
            java.lang.StringBuilder r4 = r8.alternate
            r5 = 0
            java.lang.String r3 = r9.substring(r5, r3)
            r4.append(r3)
            goto L_0x078d
        L_0x0633:
            if (r7 != 0) goto L_0x066b
            r3 = 3
            char r5 = r0.charAt(r1, r3)
            int r4 = r4.indexOf(r5)
            r5 = -1
            if (r4 != r5) goto L_0x066b
            char r3 = r0.charAt(r1, r3)
            r4 = 87
            if (r3 == r4) goto L_0x066b
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x065a
            java.lang.StringBuilder r3 = r8.primary
            r4 = 88
            r3.append(r4)
        L_0x065a:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x078d
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r11)
            goto L_0x078d
        L_0x066b:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x067d
            java.lang.StringBuilder r3 = r8.primary
            r4 = 88
            r3.append(r4)
            goto L_0x067f
        L_0x067d:
            r4 = 88
        L_0x067f:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x078d
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x078d
        L_0x0690:
            java.lang.String r4 = "I"
            java.lang.String r5 = "Y"
            java.lang.String[] r4 = new java.lang.String[]{r4, r13, r5}
            boolean r3 = contains(r1, r3, r6, r4)
            if (r3 == 0) goto L_0x06be
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x06ad
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r11)
        L_0x06ad:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x078d
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r11)
            goto L_0x078d
        L_0x06be:
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r10 > r3) goto L_0x06cf
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r9)
            goto L_0x06d9
        L_0x06cf:
            java.lang.StringBuilder r4 = r8.primary
            r5 = 0
            java.lang.String r3 = r9.substring(r5, r3)
            r4.append(r3)
        L_0x06d9:
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r10 > r3) goto L_0x06eb
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r9)
            goto L_0x078d
        L_0x06eb:
            java.lang.StringBuilder r4 = r8.alternate
            r5 = 0
            java.lang.String r3 = r9.substring(r5, r3)
            r4.append(r3)
            goto L_0x078d
        L_0x06f7:
            int r4 = r1.length()
            int r4 = r4 - r6
            if (r7 != r4) goto L_0x071e
            int r4 = r7 + -2
            java.lang.String r5 = "AI"
            java.lang.String r9 = "OI"
            java.lang.String[] r5 = new java.lang.String[]{r5, r9}
            boolean r4 = contains(r1, r4, r10, r5)
            if (r4 == 0) goto L_0x071e
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x073c
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r11)
            goto L_0x073c
        L_0x071e:
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x072d
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r11)
        L_0x072d:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x073c
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r11)
        L_0x073c:
            java.lang.String r4 = "S"
            java.lang.String r5 = "Z"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}
            boolean r4 = contains(r1, r3, r6, r4)
            if (r4 == 0) goto L_0x057e
            goto L_0x057c
        L_0x074c:
            if (r2 == 0) goto L_0x076d
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x075d
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r11)
        L_0x075d:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x078d
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r11)
            goto L_0x078d
        L_0x076d:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x077c
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r11)
        L_0x077c:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x078d
            java.lang.StringBuilder r3 = r8.alternate
            r4 = 88
            r3.append(r4)
        L_0x078d:
            int r7 = r7 + 3
            goto L_0x1581
        L_0x0791:
            int r3 = r1.length()
            int r3 = r3 - r6
            if (r7 != r3) goto L_0x07cd
            if (r2 != 0) goto L_0x07cd
            int r3 = r7 + -2
            java.lang.String r4 = "IE"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            boolean r3 = contains(r1, r3, r10, r4)
            if (r3 == 0) goto L_0x07cd
            int r3 = r7 + -4
            java.lang.String r4 = "ME"
            java.lang.String r5 = "MA"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}
            boolean r3 = contains(r1, r3, r10, r4)
            if (r3 != 0) goto L_0x07cd
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x07ca
            java.lang.StringBuilder r3 = r8.alternate
            r4 = 82
            r3.append(r4)
            goto L_0x07f0
        L_0x07ca:
            r4 = 82
            goto L_0x07f0
        L_0x07cd:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x07df
            java.lang.StringBuilder r3 = r8.primary
            r4 = 82
            r3.append(r4)
            goto L_0x07e1
        L_0x07df:
            r4 = 82
        L_0x07e1:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x07f0
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x07f0:
            int r3 = r7 + 1
            char r5 = r0.charAt(r1, r3)
            if (r5 != r4) goto L_0x057e
            goto L_0x0508
        L_0x07fa:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x080c
            java.lang.StringBuilder r3 = r8.primary
            r4 = 75
            r3.append(r4)
            goto L_0x080e
        L_0x080c:
            r4 = 75
        L_0x080e:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x081d
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x081d:
            int r3 = r7 + 1
            char r4 = r0.charAt(r1, r3)
            r5 = 81
            if (r4 != r5) goto L_0x057e
            goto L_0x0508
        L_0x0829:
            int r3 = r7 + 1
            char r4 = r0.charAt(r1, r3)
            if (r4 != r15) goto L_0x0856
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0843
            java.lang.StringBuilder r3 = r8.primary
            r4 = 70
            r3.append(r4)
            goto L_0x0845
        L_0x0843:
            r4 = 70
        L_0x0845:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x0508
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x0508
        L_0x0856:
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0867
            java.lang.StringBuilder r4 = r8.primary
            r5 = 80
            r4.append(r5)
        L_0x0867:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0878
            java.lang.StringBuilder r4 = r8.alternate
            r5 = 80
            r4.append(r5)
        L_0x0878:
            java.lang.String r4 = "P"
            java.lang.String r5 = "B"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}
            boolean r4 = contains(r1, r3, r6, r4)
            if (r4 == 0) goto L_0x057e
            int r3 = r7 + 2
            goto L_0x057e
        L_0x088a:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x089c
            java.lang.StringBuilder r3 = r8.primary
            r4 = 78
            r3.append(r4)
            goto L_0x089e
        L_0x089c:
            r4 = 78
        L_0x089e:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x08ad
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x08ad:
            int r3 = r7 + 1
            char r5 = r0.charAt(r1, r3)
            if (r5 != r4) goto L_0x057e
            goto L_0x0508
        L_0x08b7:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x08c8
            java.lang.StringBuilder r3 = r8.primary
            r4 = 77
            r3.append(r4)
        L_0x08c8:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x08d9
            java.lang.StringBuilder r3 = r8.alternate
            r4 = 77
            r3.append(r4)
        L_0x08d9:
            int r3 = r7 + 1
            char r4 = r0.charAt(r1, r3)
            r5 = 77
            if (r4 != r5) goto L_0x08e5
        L_0x08e3:
            r4 = 1
            goto L_0x090b
        L_0x08e5:
            int r4 = r7 + -1
            java.lang.String r5 = "UMB"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r9 = 3
            boolean r4 = contains(r1, r4, r9, r5)
            if (r4 == 0) goto L_0x090a
            int r4 = r1.length()
            int r4 = r4 - r6
            if (r3 == r4) goto L_0x08e3
            int r4 = r7 + 2
            java.lang.String r5 = "ER"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            boolean r4 = contains(r1, r4, r10, r5)
            if (r4 == 0) goto L_0x090a
            goto L_0x08e3
        L_0x090a:
            r4 = 0
        L_0x090b:
            if (r4 == 0) goto L_0x057e
            goto L_0x0508
        L_0x090f:
            int r3 = r7 + 1
            char r4 = r0.charAt(r1, r3)
            r5 = 76
            if (r4 != r5) goto L_0x09a0
            int r3 = r1.length()
            r4 = 3
            int r3 = r3 - r4
            if (r7 != r3) goto L_0x0936
            int r3 = r7 + -1
            java.lang.String r4 = "ILLO"
            java.lang.String r9 = "ILLA"
            java.lang.String r11 = "ALLE"
            java.lang.String[] r4 = new java.lang.String[]{r4, r9, r11}
            r9 = 4
            boolean r3 = contains(r1, r3, r9, r4)
            if (r3 == 0) goto L_0x0936
        L_0x0934:
            r3 = 1
            goto L_0x096d
        L_0x0936:
            int r3 = r1.length()
            int r3 = r3 - r10
            java.lang.String r4 = "AS"
            java.lang.String r9 = "OS"
            java.lang.String[] r4 = new java.lang.String[]{r4, r9}
            boolean r3 = contains(r1, r3, r10, r4)
            if (r3 != 0) goto L_0x095c
            int r3 = r1.length()
            int r3 = r3 - r6
            java.lang.String r4 = "A"
            java.lang.String r9 = "O"
            java.lang.String[] r4 = new java.lang.String[]{r4, r9}
            boolean r3 = contains(r1, r3, r6, r4)
            if (r3 == 0) goto L_0x096c
        L_0x095c:
            int r3 = r7 + -1
            java.lang.String r4 = "ALLE"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r9 = 4
            boolean r3 = contains(r1, r3, r9, r4)
            if (r3 == 0) goto L_0x096c
            goto L_0x0934
        L_0x096c:
            r3 = 0
        L_0x096d:
            if (r3 == 0) goto L_0x0980
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0508
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r5)
            goto L_0x0508
        L_0x0980:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x098f
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r5)
        L_0x098f:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0508
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r5)
            goto L_0x0508
        L_0x09a0:
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r7 = r8.maxLength
            if (r4 >= r7) goto L_0x09af
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r5)
        L_0x09af:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r7 = r8.maxLength
            if (r4 >= r7) goto L_0x057e
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r5)
            goto L_0x057e
        L_0x09c0:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x09d2
            java.lang.StringBuilder r3 = r8.primary
            r4 = 75
            r3.append(r4)
            goto L_0x09d4
        L_0x09d2:
            r4 = 75
        L_0x09d4:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x09e3
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x09e3:
            int r3 = r7 + 1
            char r5 = r0.charAt(r1, r3)
            if (r5 != r4) goto L_0x057e
            goto L_0x0508
        L_0x09ed:
            java.lang.String r5 = "JOSE"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r9 = 4
            boolean r5 = contains(r1, r7, r9, r5)
            if (r5 != 0) goto L_0x0ae6
            java.lang.String r5 = "SAN "
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r10 = 0
            boolean r5 = contains(r1, r10, r9, r5)
            if (r5 == 0) goto L_0x0a09
            goto L_0x0ae6
        L_0x0a09:
            if (r7 != 0) goto L_0x0a39
            java.lang.String r5 = "JOSE"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            boolean r5 = contains(r1, r7, r9, r5)
            if (r5 != 0) goto L_0x0a39
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0a26
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r3)
        L_0x0a26:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0ad9
            java.lang.StringBuilder r4 = r8.alternate
            r5 = 65
            r4.append(r5)
            goto L_0x0ad9
        L_0x0a39:
            int r5 = r7 + -1
            char r9 = r0.charAt(r1, r5)
            int r4 = r4.indexOf(r9)
            r9 = -1
            if (r4 == r9) goto L_0x0a79
            if (r2 != 0) goto L_0x0a79
            int r4 = r7 + 1
            char r9 = r0.charAt(r1, r4)
            r10 = 65
            if (r9 == r10) goto L_0x0a5a
            char r4 = r0.charAt(r1, r4)
            r9 = 79
            if (r4 != r9) goto L_0x0a79
        L_0x0a5a:
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0a69
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r3)
        L_0x0a69:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0ad9
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r15)
            goto L_0x0ad9
        L_0x0a79:
            int r4 = r1.length()
            int r4 = r4 - r6
            if (r7 != r4) goto L_0x0aa1
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0a8f
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r3)
        L_0x0a8f:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0ad9
            java.lang.StringBuilder r4 = r8.alternate
            r5 = 32
            r4.append(r5)
            goto L_0x0ad9
        L_0x0aa1:
            int r4 = r7 + 1
            java.lang.String[] r9 = L_T_K_S_N_M_B_Z
            boolean r4 = contains(r1, r4, r6, r9)
            if (r4 != 0) goto L_0x0ad9
            java.lang.String r4 = "S"
            java.lang.String r9 = "K"
            java.lang.String r10 = "L"
            java.lang.String[] r4 = new java.lang.String[]{r4, r9, r10}
            boolean r4 = contains(r1, r5, r6, r4)
            if (r4 != 0) goto L_0x0ad9
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0aca
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r3)
        L_0x0aca:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0ad9
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r3)
        L_0x0ad9:
            int r4 = r7 + 1
            char r5 = r0.charAt(r1, r4)
            if (r5 != r3) goto L_0x0ae3
            goto L_0x0508
        L_0x0ae3:
            r7 = r4
            goto L_0x1581
        L_0x0ae6:
            if (r7 != 0) goto L_0x0af2
            int r4 = r7 + 4
            char r4 = r0.charAt(r1, r4)
            r5 = 32
            if (r4 == r5) goto L_0x0b27
        L_0x0af2:
            int r4 = r1.length()
            r5 = 4
            if (r4 == r5) goto L_0x0b27
            java.lang.String r4 = "SAN "
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r9 = 0
            boolean r4 = contains(r1, r9, r5, r4)
            if (r4 == 0) goto L_0x0b07
            goto L_0x0b27
        L_0x0b07:
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0b16
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r3)
        L_0x0b16:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x157f
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r15)
            goto L_0x157f
        L_0x0b27:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0b36
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r15)
        L_0x0b36:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x157f
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r15)
            goto L_0x157f
        L_0x0b47:
            if (r7 == 0) goto L_0x0b57
            int r3 = r7 + -1
            char r3 = r0.charAt(r1, r3)
            int r3 = r4.indexOf(r3)
            r5 = -1
            if (r3 == r5) goto L_0x157f
            goto L_0x0b58
        L_0x0b57:
            r5 = -1
        L_0x0b58:
            int r3 = r7 + 1
            char r3 = r0.charAt(r1, r3)
            int r3 = r4.indexOf(r3)
            if (r3 == r5) goto L_0x157f
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0b73
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r15)
        L_0x0b73:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0508
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r15)
            goto L_0x0508
        L_0x0b84:
            int r5 = r7 + 1
            char r9 = r0.charAt(r1, r5)
            if (r9 != r15) goto L_0x0cc6
            if (r7 <= 0) goto L_0x0bc0
            int r5 = r7 + -1
            char r5 = r0.charAt(r1, r5)
            int r4 = r4.indexOf(r5)
            r5 = -1
            if (r4 != r5) goto L_0x0bc0
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0bad
            java.lang.StringBuilder r3 = r8.primary
            r4 = 75
            r3.append(r4)
            goto L_0x0baf
        L_0x0bad:
            r4 = 75
        L_0x0baf:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x0508
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x0508
        L_0x0bc0:
            if (r7 != 0) goto L_0x0c11
            int r7 = r7 + 2
            char r4 = r0.charAt(r1, r7)
            r5 = 73
            if (r4 != r5) goto L_0x0bec
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0bdb
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r3)
        L_0x0bdb:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x1581
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r3)
            goto L_0x1581
        L_0x0bec:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0bfe
            java.lang.StringBuilder r3 = r8.primary
            r4 = 75
            r3.append(r4)
            goto L_0x0c00
        L_0x0bfe:
            r4 = 75
        L_0x0c00:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x1581
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x1581
        L_0x0c11:
            if (r7 <= r6) goto L_0x0c25
            int r3 = r7 + -2
            java.lang.String r4 = "B"
            java.lang.String r5 = "H"
            java.lang.String r9 = "D"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r9}
            boolean r3 = contains(r1, r3, r6, r4)
            if (r3 != 0) goto L_0x0508
        L_0x0c25:
            if (r7 <= r10) goto L_0x0c39
            int r3 = r7 + -3
            java.lang.String r4 = "B"
            java.lang.String r5 = "H"
            java.lang.String r9 = "D"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r9}
            boolean r3 = contains(r1, r3, r6, r4)
            if (r3 != 0) goto L_0x0508
        L_0x0c39:
            r3 = 3
            if (r7 <= r3) goto L_0x0c4e
            int r3 = r7 + -4
            java.lang.String r4 = "B"
            java.lang.String r5 = "H"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}
            boolean r3 = contains(r1, r3, r6, r4)
            if (r3 == 0) goto L_0x0c4e
            goto L_0x0508
        L_0x0c4e:
            if (r7 <= r10) goto L_0x0c95
            int r3 = r7 + -1
            char r3 = r0.charAt(r1, r3)
            r4 = 85
            if (r3 != r4) goto L_0x0c95
            int r3 = r7 + -3
            java.lang.String r4 = "C"
            java.lang.String r5 = "G"
            java.lang.String r9 = "L"
            java.lang.String r10 = "R"
            java.lang.String r11 = "T"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r9, r10, r11}
            boolean r3 = contains(r1, r3, r6, r4)
            if (r3 == 0) goto L_0x0c95
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0c82
            java.lang.StringBuilder r3 = r8.primary
            r4 = 70
            r3.append(r4)
            goto L_0x0c84
        L_0x0c82:
            r4 = 70
        L_0x0c84:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x0508
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x0508
        L_0x0c95:
            if (r7 <= 0) goto L_0x0508
            int r3 = r7 + -1
            char r3 = r0.charAt(r1, r3)
            r4 = 73
            if (r3 == r4) goto L_0x0508
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0cb3
            java.lang.StringBuilder r3 = r8.primary
            r4 = 75
            r3.append(r4)
            goto L_0x0cb5
        L_0x0cb3:
            r4 = 75
        L_0x0cb5:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x0508
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x0508
        L_0x0cc6:
            char r9 = r0.charAt(r1, r5)
            r11 = 78
            if (r9 != r11) goto L_0x0dab
            java.lang.String r3 = "KN"
            if (r7 != r6) goto L_0x0d1d
            r9 = 0
            char r11 = r0.charAt(r1, r9)
            int r4 = r4.indexOf(r11)
            r9 = -1
            if (r4 == r9) goto L_0x0d1d
            if (r2 != 0) goto L_0x0d1d
            int r4 = r8.maxLength
            java.lang.StringBuilder r5 = r8.primary
            int r5 = r5.length()
            int r4 = r4 - r5
            if (r10 > r4) goto L_0x0cf1
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r3)
            goto L_0x0cfb
        L_0x0cf1:
            java.lang.StringBuilder r5 = r8.primary
            r9 = 0
            java.lang.String r3 = r3.substring(r9, r4)
            r5.append(r3)
        L_0x0cfb:
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r6 > r3) goto L_0x0d0f
            java.lang.StringBuilder r3 = r8.alternate
            java.lang.String r4 = "N"
            r3.append(r4)
            goto L_0x0508
        L_0x0d0f:
            java.lang.StringBuilder r4 = r8.alternate
            java.lang.String r5 = "N"
            r9 = 0
            java.lang.String r3 = r5.substring(r9, r3)
            r4.append(r3)
            goto L_0x0508
        L_0x0d1d:
            int r4 = r7 + 2
            java.lang.String r9 = "EY"
            java.lang.String[] r9 = new java.lang.String[]{r9}
            boolean r4 = contains(r1, r4, r10, r9)
            if (r4 != 0) goto L_0x0d72
            char r4 = r0.charAt(r1, r5)
            r5 = 89
            if (r4 == r5) goto L_0x0d72
            if (r2 != 0) goto L_0x0d72
            int r4 = r8.maxLength
            java.lang.StringBuilder r5 = r8.primary
            int r5 = r5.length()
            int r4 = r4 - r5
            if (r6 > r4) goto L_0x0d48
            java.lang.StringBuilder r4 = r8.primary
            java.lang.String r5 = "N"
            r4.append(r5)
            goto L_0x0d54
        L_0x0d48:
            java.lang.StringBuilder r5 = r8.primary
            java.lang.String r9 = "N"
            r11 = 0
            java.lang.String r4 = r9.substring(r11, r4)
            r5.append(r4)
        L_0x0d54:
            int r4 = r8.maxLength
            java.lang.StringBuilder r5 = r8.alternate
            int r5 = r5.length()
            int r4 = r4 - r5
            if (r10 > r4) goto L_0x0d66
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r3)
            goto L_0x0508
        L_0x0d66:
            java.lang.StringBuilder r5 = r8.alternate
            r9 = 0
            java.lang.String r3 = r3.substring(r9, r4)
            r5.append(r3)
            goto L_0x0508
        L_0x0d72:
            int r4 = r8.maxLength
            java.lang.StringBuilder r5 = r8.primary
            int r5 = r5.length()
            int r4 = r4 - r5
            if (r10 > r4) goto L_0x0d83
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r3)
            goto L_0x0d8d
        L_0x0d83:
            java.lang.StringBuilder r5 = r8.primary
            r9 = 0
            java.lang.String r4 = r3.substring(r9, r4)
            r5.append(r4)
        L_0x0d8d:
            int r4 = r8.maxLength
            java.lang.StringBuilder r5 = r8.alternate
            int r5 = r5.length()
            int r4 = r4 - r5
            if (r10 > r4) goto L_0x0d9f
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r3)
            goto L_0x0508
        L_0x0d9f:
            java.lang.StringBuilder r5 = r8.alternate
            r9 = 0
            java.lang.String r3 = r3.substring(r9, r4)
            r5.append(r3)
            goto L_0x0508
        L_0x0dab:
            java.lang.String r4 = "LI"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            boolean r4 = contains(r1, r5, r10, r4)
            if (r4 == 0) goto L_0x0dfa
            if (r2 != 0) goto L_0x0dfa
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r10 > r3) goto L_0x0dcc
            java.lang.StringBuilder r3 = r8.primary
            java.lang.String r4 = "KL"
            r3.append(r4)
            goto L_0x0dd8
        L_0x0dcc:
            java.lang.StringBuilder r4 = r8.primary
            java.lang.String r5 = "KL"
            r9 = 0
            java.lang.String r3 = r5.substring(r9, r3)
            r4.append(r3)
        L_0x0dd8:
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r6 > r3) goto L_0x0dec
            java.lang.StringBuilder r3 = r8.alternate
            java.lang.String r4 = "L"
            r3.append(r4)
            goto L_0x0508
        L_0x0dec:
            java.lang.StringBuilder r4 = r8.alternate
            java.lang.String r5 = "L"
            r9 = 0
            java.lang.String r3 = r5.substring(r9, r3)
            r4.append(r3)
            goto L_0x0508
        L_0x0dfa:
            if (r7 != 0) goto L_0x0e2e
            char r4 = r0.charAt(r1, r5)
            r9 = 89
            if (r4 == r9) goto L_0x0e0c
            java.lang.String[] r4 = ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER
            boolean r4 = contains(r1, r5, r10, r4)
            if (r4 == 0) goto L_0x0e2e
        L_0x0e0c:
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0e1d
            java.lang.StringBuilder r4 = r8.primary
            r5 = 75
            r4.append(r5)
        L_0x0e1d:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0508
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r3)
            goto L_0x0508
        L_0x0e2e:
            java.lang.String r4 = "ER"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            boolean r4 = contains(r1, r5, r10, r4)
            if (r4 != 0) goto L_0x0e42
            char r4 = r0.charAt(r1, r5)
            r9 = 89
            if (r4 != r9) goto L_0x0e93
        L_0x0e42:
            r4 = 6
            java.lang.String r9 = "DANGER"
            java.lang.String r11 = "RANGER"
            java.lang.String r12 = "MANGER"
            java.lang.String[] r9 = new java.lang.String[]{r9, r11, r12}
            r11 = 0
            boolean r4 = contains(r1, r11, r4, r9)
            if (r4 != 0) goto L_0x0e93
            int r4 = r7 + -1
            java.lang.String r9 = "I"
            java.lang.String[] r9 = new java.lang.String[]{r13, r9}
            boolean r9 = contains(r1, r4, r6, r9)
            if (r9 != 0) goto L_0x0e93
            java.lang.String r9 = "RGY"
            java.lang.String r11 = "OGY"
            java.lang.String[] r9 = new java.lang.String[]{r9, r11}
            r11 = 3
            boolean r4 = contains(r1, r4, r11, r9)
            if (r4 != 0) goto L_0x0e93
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0e82
            java.lang.StringBuilder r4 = r8.primary
            r5 = 75
            r4.append(r5)
        L_0x0e82:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0508
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r3)
            goto L_0x0508
        L_0x0e93:
            java.lang.String r4 = "I"
            java.lang.String r9 = "Y"
            java.lang.String[] r4 = new java.lang.String[]{r13, r4, r9}
            boolean r4 = contains(r1, r5, r6, r4)
            if (r4 != 0) goto L_0x0f05
            int r4 = r7 + -1
            java.lang.String r9 = "AGGI"
            java.lang.String r11 = "OGGI"
            java.lang.String[] r9 = new java.lang.String[]{r9, r11}
            r11 = 4
            boolean r4 = contains(r1, r4, r11, r9)
            if (r4 == 0) goto L_0x0eb3
            goto L_0x0f05
        L_0x0eb3:
            char r3 = r0.charAt(r1, r5)
            r4 = 71
            if (r3 != r4) goto L_0x0ee2
            int r7 = r7 + 2
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0ecf
            java.lang.StringBuilder r3 = r8.primary
            r4 = 75
            r3.append(r4)
            goto L_0x0ed1
        L_0x0ecf:
            r4 = 75
        L_0x0ed1:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x1581
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x1581
        L_0x0ee2:
            r4 = 75
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r7 = r8.maxLength
            if (r3 >= r7) goto L_0x0ef3
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r4)
        L_0x0ef3:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r7 = r8.maxLength
            if (r3 >= r7) goto L_0x0f02
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x0f02:
            r7 = r5
            goto L_0x1581
        L_0x0f05:
            java.lang.String r4 = "VAN "
            java.lang.String r9 = "VON "
            java.lang.String[] r4 = new java.lang.String[]{r4, r9}
            r9 = 4
            r11 = 0
            boolean r4 = contains(r1, r11, r9, r4)
            if (r4 != 0) goto L_0x0f7d
            java.lang.String r4 = "SCH"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r9 = 3
            boolean r4 = contains(r1, r11, r9, r4)
            if (r4 != 0) goto L_0x0f7d
            java.lang.String r4 = "ET"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            boolean r4 = contains(r1, r5, r10, r4)
            if (r4 == 0) goto L_0x0f2f
            goto L_0x0f7d
        L_0x0f2f:
            java.lang.String r4 = "IER"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            boolean r4 = contains(r1, r5, r9, r4)
            if (r4 == 0) goto L_0x0f5b
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0f4a
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r3)
        L_0x0f4a:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0508
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r3)
            goto L_0x0508
        L_0x0f5b:
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0f6a
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r3)
        L_0x0f6a:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0508
            java.lang.StringBuilder r3 = r8.alternate
            r4 = 75
            r3.append(r4)
            goto L_0x0508
        L_0x0f7d:
            r4 = 75
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x0f8e
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r4)
        L_0x0f8e:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x0508
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x0508
        L_0x0f9f:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0fb1
            java.lang.StringBuilder r3 = r8.primary
            r4 = 70
            r3.append(r4)
            goto L_0x0fb3
        L_0x0fb1:
            r4 = 70
        L_0x0fb3:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r5 = r8.maxLength
            if (r3 >= r5) goto L_0x0fc2
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x0fc2:
            int r3 = r7 + 1
            char r5 = r0.charAt(r1, r3)
            if (r5 != r4) goto L_0x057e
            goto L_0x0508
        L_0x0fcc:
            java.lang.String r4 = "DG"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            boolean r4 = contains(r1, r7, r10, r4)
            if (r4 == 0) goto L_0x1049
            int r4 = r7 + 2
            java.lang.String r5 = "I"
            java.lang.String r9 = "Y"
            java.lang.String[] r5 = new java.lang.String[]{r5, r13, r9}
            boolean r5 = contains(r1, r4, r6, r5)
            if (r5 == 0) goto L_0x1008
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x0ff7
            java.lang.StringBuilder r4 = r8.primary
            r4.append(r3)
        L_0x0ff7:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r5 = r8.maxLength
            if (r4 >= r5) goto L_0x078d
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r3)
            goto L_0x078d
        L_0x1008:
            int r3 = r8.maxLength
            java.lang.StringBuilder r5 = r8.primary
            int r5 = r5.length()
            int r3 = r3 - r5
            if (r10 > r3) goto L_0x101b
            java.lang.StringBuilder r3 = r8.primary
            java.lang.String r5 = "TK"
            r3.append(r5)
            goto L_0x1027
        L_0x101b:
            java.lang.StringBuilder r5 = r8.primary
            java.lang.String r7 = "TK"
            r9 = 0
            java.lang.String r3 = r7.substring(r9, r3)
            r5.append(r3)
        L_0x1027:
            int r3 = r8.maxLength
            java.lang.StringBuilder r5 = r8.alternate
            int r5 = r5.length()
            int r3 = r3 - r5
            if (r10 > r3) goto L_0x103b
            java.lang.StringBuilder r3 = r8.alternate
            java.lang.String r5 = "TK"
            r3.append(r5)
            goto L_0x0ae3
        L_0x103b:
            java.lang.StringBuilder r5 = r8.alternate
            java.lang.String r7 = "TK"
            r9 = 0
            java.lang.String r3 = r7.substring(r9, r3)
            r5.append(r3)
            goto L_0x0ae3
        L_0x1049:
            java.lang.String r3 = "DT"
            java.lang.String r4 = "DD"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}
            boolean r3 = contains(r1, r7, r10, r3)
            if (r3 == 0) goto L_0x1077
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x1066
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r12)
        L_0x1066:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x0508
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r12)
            goto L_0x0508
        L_0x1077:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x1086
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r12)
        L_0x1086:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x157f
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r12)
            goto L_0x157f
        L_0x1097:
            java.lang.String r3 = "CHIA"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r5 = 4
            boolean r3 = contains(r1, r7, r5, r3)
            if (r3 == 0) goto L_0x10a7
            r3 = 1
        L_0x10a5:
            r5 = -1
            goto L_0x10e8
        L_0x10a7:
            if (r7 > r6) goto L_0x10ab
            r3 = 0
            goto L_0x10a5
        L_0x10ab:
            int r3 = r7 + -2
            char r5 = r0.charAt(r1, r3)
            int r4 = r4.indexOf(r5)
            r5 = -1
            if (r4 == r5) goto L_0x10ba
        L_0x10b8:
            r3 = 0
            goto L_0x10e8
        L_0x10ba:
            int r4 = r7 + -1
            java.lang.String r9 = "ACH"
            java.lang.String[] r9 = new java.lang.String[]{r9}
            r12 = 3
            boolean r4 = contains(r1, r4, r12, r9)
            if (r4 != 0) goto L_0x10ca
            goto L_0x10b8
        L_0x10ca:
            int r4 = r7 + 2
            char r4 = r0.charAt(r1, r4)
            r9 = 73
            if (r4 == r9) goto L_0x10d8
            r9 = 69
            if (r4 != r9) goto L_0x10e7
        L_0x10d8:
            r4 = 6
            java.lang.String r9 = "BACHER"
            java.lang.String r12 = "MACHER"
            java.lang.String[] r9 = new java.lang.String[]{r9, r12}
            boolean r3 = contains(r1, r3, r4, r9)
            if (r3 == 0) goto L_0x10b8
        L_0x10e7:
            r3 = 1
        L_0x10e8:
            if (r3 == 0) goto L_0x1114
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x10fc
            java.lang.StringBuilder r3 = r8.primary
            r4 = 75
            r3.append(r4)
            goto L_0x10fe
        L_0x10fc:
            r4 = 75
        L_0x10fe:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r9 = r8.maxLength
            if (r3 >= r9) goto L_0x110d
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x110d:
            int r7 = r7 + 2
        L_0x110f:
            r9 = 0
        L_0x1110:
            r12 = 75
            goto L_0x1581
        L_0x1114:
            if (r7 != 0) goto L_0x1142
            r3 = 6
            java.lang.String r4 = "CAESAR"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            boolean r3 = contains(r1, r7, r3, r4)
            if (r3 == 0) goto L_0x1142
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x1132
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r11)
        L_0x1132:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x110d
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r11)
            goto L_0x110d
        L_0x1142:
            java.lang.String r3 = "CH"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            boolean r3 = contains(r1, r7, r10, r3)
            if (r3 == 0) goto L_0x12e9
            if (r7 == 0) goto L_0x1152
        L_0x1150:
            r3 = 0
            goto L_0x1187
        L_0x1152:
            int r3 = r7 + 1
            r4 = 5
            java.lang.String r9 = "HARAC"
            java.lang.String r11 = "HARIS"
            java.lang.String[] r9 = new java.lang.String[]{r9, r11}
            boolean r4 = contains(r1, r3, r4, r9)
            if (r4 != 0) goto L_0x1177
            java.lang.String r4 = "HOR"
            java.lang.String r9 = "HYM"
            java.lang.String r11 = "HIA"
            java.lang.String r12 = "HEM"
            java.lang.String[] r4 = new java.lang.String[]{r4, r9, r11, r12}
            r9 = 3
            boolean r3 = contains(r1, r3, r9, r4)
            if (r3 != 0) goto L_0x1177
            goto L_0x1150
        L_0x1177:
            r3 = 5
            java.lang.String r4 = "CHORE"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r9 = 0
            boolean r3 = contains(r1, r9, r3, r4)
            if (r3 == 0) goto L_0x1186
            goto L_0x1150
        L_0x1186:
            r3 = 1
        L_0x1187:
            if (r7 <= 0) goto L_0x11ba
            java.lang.String r4 = "CHAE"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r9 = 4
            boolean r4 = contains(r1, r7, r9, r4)
            if (r4 == 0) goto L_0x11ba
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x11a7
            java.lang.StringBuilder r3 = r8.primary
            r4 = 75
            r3.append(r4)
        L_0x11a7:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x110d
            java.lang.StringBuilder r3 = r8.alternate
            r4 = 88
            r3.append(r4)
            goto L_0x110d
        L_0x11ba:
            if (r3 == 0) goto L_0x11e1
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x11ce
            java.lang.StringBuilder r3 = r8.primary
            r4 = 75
            r3.append(r4)
            goto L_0x11d0
        L_0x11ce:
            r4 = 75
        L_0x11d0:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r9 = r8.maxLength
            if (r3 >= r9) goto L_0x110d
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x110d
        L_0x11e1:
            java.lang.String r3 = "VAN "
            java.lang.String r4 = "VON "
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}
            r4 = 4
            r9 = 0
            boolean r3 = contains(r1, r9, r4, r3)
            if (r3 != 0) goto L_0x12c4
            java.lang.String r3 = "SCH"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r4 = 3
            boolean r3 = contains(r1, r9, r4, r3)
            if (r3 != 0) goto L_0x12c4
            int r3 = r7 + -2
            r4 = 6
            java.lang.String r9 = "ORCHES"
            java.lang.String r11 = "ARCHIT"
            java.lang.String r12 = "ORCHID"
            java.lang.String[] r9 = new java.lang.String[]{r9, r11, r12}
            boolean r3 = contains(r1, r3, r4, r9)
            if (r3 != 0) goto L_0x12c4
            int r3 = r7 + 2
            java.lang.String r4 = "T"
            java.lang.String r9 = "S"
            java.lang.String[] r4 = new java.lang.String[]{r4, r9}
            boolean r4 = contains(r1, r3, r6, r4)
            if (r4 != 0) goto L_0x12c4
            int r4 = r7 + -1
            java.lang.String r9 = "A"
            java.lang.String r11 = "O"
            java.lang.String r12 = "U"
            java.lang.String[] r9 = new java.lang.String[]{r9, r11, r12, r13}
            boolean r4 = contains(r1, r4, r6, r9)
            if (r4 != 0) goto L_0x1235
            if (r7 != 0) goto L_0x1248
        L_0x1235:
            java.lang.String[] r4 = L_R_N_M_B_H_F_V_W_SPACE
            boolean r4 = contains(r1, r3, r6, r4)
            if (r4 != 0) goto L_0x12c4
            int r4 = r7 + 1
            int r9 = r1.length()
            int r9 = r9 - r6
            if (r4 != r9) goto L_0x1248
            goto L_0x12c4
        L_0x1248:
            if (r7 <= 0) goto L_0x129e
            java.lang.String r4 = "MC"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r7 = 0
            boolean r4 = contains(r1, r7, r10, r4)
            if (r4 == 0) goto L_0x127b
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r7 = r8.maxLength
            if (r4 >= r7) goto L_0x1269
            java.lang.StringBuilder r4 = r8.primary
            r7 = 75
            r4.append(r7)
            goto L_0x126b
        L_0x1269:
            r7 = 75
        L_0x126b:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r9 = r8.maxLength
            if (r4 >= r9) goto L_0x12c1
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r7)
            goto L_0x12c1
        L_0x127b:
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r7 = r8.maxLength
            if (r4 >= r7) goto L_0x128c
            java.lang.StringBuilder r4 = r8.primary
            r7 = 88
            r4.append(r7)
        L_0x128c:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r7 = r8.maxLength
            if (r4 >= r7) goto L_0x12c1
            java.lang.StringBuilder r4 = r8.alternate
            r7 = 75
            r4.append(r7)
            goto L_0x12c1
        L_0x129e:
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r7 = r8.maxLength
            if (r4 >= r7) goto L_0x12b0
            java.lang.StringBuilder r4 = r8.primary
            r7 = 88
            r4.append(r7)
            goto L_0x12b2
        L_0x12b0:
            r7 = 88
        L_0x12b2:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r9 = r8.maxLength
            if (r4 >= r9) goto L_0x12c1
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r7)
        L_0x12c1:
            r7 = r3
            goto L_0x110f
        L_0x12c4:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x12d6
            java.lang.StringBuilder r3 = r8.primary
            r4 = 75
            r3.append(r4)
            goto L_0x12d8
        L_0x12d6:
            r4 = 75
        L_0x12d8:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r9 = r8.maxLength
            if (r3 >= r9) goto L_0x110d
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x110d
        L_0x12e9:
            java.lang.String r3 = "CZ"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            boolean r3 = contains(r1, r7, r10, r3)
            if (r3 == 0) goto L_0x1326
            int r3 = r7 + -2
            java.lang.String r4 = "WICZ"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r9 = 4
            boolean r3 = contains(r1, r3, r9, r4)
            if (r3 != 0) goto L_0x1326
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x1313
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r11)
        L_0x1313:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x110d
            java.lang.StringBuilder r3 = r8.alternate
            r4 = 88
            r3.append(r4)
            goto L_0x110d
        L_0x1326:
            int r3 = r7 + 1
            java.lang.String r4 = "CIA"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r9 = 3
            boolean r4 = contains(r1, r3, r9, r4)
            if (r4 == 0) goto L_0x135c
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x1347
            java.lang.StringBuilder r3 = r8.primary
            r4 = 88
            r3.append(r4)
            goto L_0x1349
        L_0x1347:
            r4 = 88
        L_0x1349:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r9 = r8.maxLength
            if (r3 >= r9) goto L_0x1358
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x1358:
            int r7 = r7 + 3
            goto L_0x110f
        L_0x135c:
            java.lang.String r4 = "CC"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            boolean r4 = contains(r1, r7, r10, r4)
            if (r4 == 0) goto L_0x1432
            if (r7 != r6) goto L_0x1373
            r4 = 0
            char r9 = r0.charAt(r1, r4)
            r4 = 77
            if (r9 == r4) goto L_0x1432
        L_0x1373:
            int r3 = r7 + 2
            java.lang.String r4 = "I"
            java.lang.String r9 = "H"
            java.lang.String[] r4 = new java.lang.String[]{r4, r13, r9}
            boolean r4 = contains(r1, r3, r6, r4)
            if (r4 == 0) goto L_0x140b
            java.lang.String r4 = "HU"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            boolean r4 = contains(r1, r3, r10, r4)
            if (r4 != 0) goto L_0x140b
            if (r7 != r6) goto L_0x139b
            int r3 = r7 + -1
            char r3 = r0.charAt(r1, r3)
            r4 = 65
            if (r3 == r4) goto L_0x13ac
        L_0x139b:
            int r3 = r7 + -1
            r4 = 5
            java.lang.String r9 = "UCCEE"
            java.lang.String r11 = "UCCES"
            java.lang.String[] r9 = new java.lang.String[]{r9, r11}
            boolean r3 = contains(r1, r3, r4, r9)
            if (r3 == 0) goto L_0x13e4
        L_0x13ac:
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r10 > r3) goto L_0x13bd
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r14)
            goto L_0x13c7
        L_0x13bd:
            java.lang.StringBuilder r4 = r8.primary
            r9 = 0
            java.lang.String r3 = r14.substring(r9, r3)
            r4.append(r3)
        L_0x13c7:
            int r3 = r8.maxLength
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r3 = r3 - r4
            if (r10 > r3) goto L_0x13d9
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r14)
            r9 = 0
            goto L_0x1408
        L_0x13d9:
            java.lang.StringBuilder r4 = r8.alternate
            r9 = 0
            java.lang.String r3 = r14.substring(r9, r3)
            r4.append(r3)
            goto L_0x1408
        L_0x13e4:
            r9 = 0
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x13f7
            java.lang.StringBuilder r3 = r8.primary
            r4 = 88
            r3.append(r4)
            goto L_0x13f9
        L_0x13f7:
            r4 = 88
        L_0x13f9:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r10 = r8.maxLength
            if (r3 >= r10) goto L_0x1408
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x1408:
            int r3 = r7 + 3
            goto L_0x142f
        L_0x140b:
            r9 = 0
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r7 = r8.maxLength
            if (r4 >= r7) goto L_0x141e
            java.lang.StringBuilder r4 = r8.primary
            r7 = 75
            r4.append(r7)
            goto L_0x1420
        L_0x141e:
            r7 = 75
        L_0x1420:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r10 = r8.maxLength
            if (r4 >= r10) goto L_0x142f
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r7)
        L_0x142f:
            r7 = r3
            goto L_0x1110
        L_0x1432:
            r9 = 0
            java.lang.String r4 = "CK"
            java.lang.String r12 = "CG"
            java.lang.String r13 = "CQ"
            java.lang.String[] r4 = new java.lang.String[]{r4, r12, r13}
            boolean r4 = contains(r1, r7, r10, r4)
            if (r4 == 0) goto L_0x146a
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x1455
            java.lang.StringBuilder r3 = r8.primary
            r4 = 75
            r3.append(r4)
            goto L_0x1457
        L_0x1455:
            r4 = 75
        L_0x1457:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r10 = r8.maxLength
            if (r3 >= r10) goto L_0x1466
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x1466:
            int r7 = r7 + 2
            goto L_0x1110
        L_0x146a:
            java.lang.String r4 = "CI"
            java.lang.String r12 = "CE"
            java.lang.String r13 = "CY"
            java.lang.String[] r4 = new java.lang.String[]{r4, r12, r13}
            boolean r4 = contains(r1, r7, r10, r4)
            if (r4 == 0) goto L_0x14cb
            java.lang.String r3 = "CIO"
            java.lang.String r4 = "CIE"
            java.lang.String r10 = "CIA"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r10}
            r4 = 3
            boolean r3 = contains(r1, r7, r4, r3)
            if (r3 == 0) goto L_0x14ac
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x149a
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r11)
        L_0x149a:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x1466
            java.lang.StringBuilder r3 = r8.alternate
            r4 = 88
            r3.append(r4)
            goto L_0x1466
        L_0x14ac:
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x14bb
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r11)
        L_0x14bb:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x1466
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r11)
            goto L_0x1466
        L_0x14cb:
            java.lang.StringBuilder r4 = r8.primary
            int r4 = r4.length()
            int r11 = r8.maxLength
            if (r4 >= r11) goto L_0x14dd
            java.lang.StringBuilder r4 = r8.primary
            r12 = 75
            r4.append(r12)
            goto L_0x14df
        L_0x14dd:
            r12 = 75
        L_0x14df:
            java.lang.StringBuilder r4 = r8.alternate
            int r4 = r4.length()
            int r11 = r8.maxLength
            if (r4 >= r11) goto L_0x14ee
            java.lang.StringBuilder r4 = r8.alternate
            r4.append(r12)
        L_0x14ee:
            java.lang.String r4 = " C"
            java.lang.String r11 = " Q"
            java.lang.String r13 = " G"
            java.lang.String[] r4 = new java.lang.String[]{r4, r11, r13}
            boolean r4 = contains(r1, r3, r10, r4)
            if (r4 == 0) goto L_0x1502
            int r3 = r7 + 3
            goto L_0x057e
        L_0x1502:
            java.lang.String r4 = "C"
            java.lang.String r11 = "K"
            java.lang.String r13 = "Q"
            java.lang.String[] r4 = new java.lang.String[]{r4, r11, r13}
            boolean r4 = contains(r1, r3, r6, r4)
            if (r4 == 0) goto L_0x057e
            java.lang.String r4 = "CE"
            java.lang.String r11 = "CI"
            java.lang.String[] r4 = new java.lang.String[]{r4, r11}
            boolean r4 = contains(r1, r3, r10, r4)
            if (r4 != 0) goto L_0x057e
            int r3 = r7 + 2
            goto L_0x057e
        L_0x1524:
            r5 = -1
            r9 = 0
            r12 = 75
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x1539
            java.lang.StringBuilder r3 = r8.primary
            r4 = 80
            r3.append(r4)
        L_0x1539:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x154a
            java.lang.StringBuilder r3 = r8.alternate
            r4 = 80
            r3.append(r4)
        L_0x154a:
            int r3 = r7 + 1
            char r4 = r0.charAt(r1, r3)
            r10 = 66
            if (r4 != r10) goto L_0x057e
            goto L_0x0508
        L_0x1556:
            r5 = -1
            r9 = 0
            r12 = 75
            if (r7 != 0) goto L_0x157f
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x156e
            java.lang.StringBuilder r3 = r8.primary
            r4 = 65
            r3.append(r4)
            goto L_0x1570
        L_0x156e:
            r4 = 65
        L_0x1570:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r10 = r8.maxLength
            if (r3 >= r10) goto L_0x157f
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
        L_0x157f:
            int r7 = r7 + 1
        L_0x1581:
            r3 = -1
            r4 = 75
            r5 = 0
            goto L_0x005a
        L_0x1587:
            r5 = -1
            r9 = 0
            r12 = 75
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x159d
            java.lang.StringBuilder r3 = r8.primary
            r4 = 78
            r3.append(r4)
            goto L_0x159f
        L_0x159d:
            r4 = 78
        L_0x159f:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r10 = r8.maxLength
            if (r3 >= r10) goto L_0x157f
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r4)
            goto L_0x157f
        L_0x15af:
            r5 = -1
            r9 = 0
            r12 = 75
            java.lang.StringBuilder r3 = r8.primary
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x15c2
            java.lang.StringBuilder r3 = r8.primary
            r3.append(r11)
        L_0x15c2:
            java.lang.StringBuilder r3 = r8.alternate
            int r3 = r3.length()
            int r4 = r8.maxLength
            if (r3 >= r4) goto L_0x157f
            java.lang.StringBuilder r3 = r8.alternate
            r3.append(r11)
            goto L_0x157f
        L_0x15d2:
            if (r24 == 0) goto L_0x15d7
            java.lang.StringBuilder r1 = r8.alternate
            goto L_0x15d9
        L_0x15d7:
            java.lang.StringBuilder r1 = r8.primary
        L_0x15d9:
            java.lang.String r1 = r1.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.external.DoubleMetaphone.doubleMetaphone(java.lang.String, boolean):java.lang.String");
    }
}
