package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class Code128Writer extends OneDimensionalCodeWriter {

    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        r6 = r6.charAt(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.oned.Code128Writer.CType findCType(java.lang.CharSequence r6, int r7) {
        /*
            com.google.zxing.oned.Code128Writer$CType r0 = com.google.zxing.oned.Code128Writer.CType.ONE_DIGIT
            com.google.zxing.oned.Code128Writer$CType r1 = com.google.zxing.oned.Code128Writer.CType.UNCODABLE
            int r2 = r6.length()
            if (r7 < r2) goto L_0x000b
            return r1
        L_0x000b:
            char r3 = r6.charAt(r7)
            r4 = 241(0xf1, float:3.38E-43)
            if (r3 != r4) goto L_0x0016
            com.google.zxing.oned.Code128Writer$CType r6 = com.google.zxing.oned.Code128Writer.CType.FNC_1
            return r6
        L_0x0016:
            r4 = 48
            if (r3 < r4) goto L_0x0031
            r5 = 57
            if (r3 <= r5) goto L_0x001f
            goto L_0x0031
        L_0x001f:
            int r7 = r7 + 1
            if (r7 < r2) goto L_0x0024
            return r0
        L_0x0024:
            char r6 = r6.charAt(r7)
            if (r6 < r4) goto L_0x0030
            if (r6 <= r5) goto L_0x002d
            goto L_0x0030
        L_0x002d:
            com.google.zxing.oned.Code128Writer$CType r6 = com.google.zxing.oned.Code128Writer.CType.TWO_DIGITS
            return r6
        L_0x0030:
            return r0
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.findCType(java.lang.CharSequence, int):com.google.zxing.oned.Code128Writer$CType");
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(barcodeFormat)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0081, code lost:
        if (findCType(r0, r5 + 3) == r11) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008f, code lost:
        if (r12 == r13) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009a, code lost:
        if (r14 == r11) goto L_0x009f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0036 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean[] encode(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r17
            int r1 = r17.length()
            if (r1 <= 0) goto L_0x0149
            r2 = 80
            if (r1 > r2) goto L_0x0149
            r3 = 0
        L_0x000d:
            if (r3 >= r1) goto L_0x002d
            char r4 = r0.charAt(r3)
            switch(r4) {
                case 241: goto L_0x001a;
                case 242: goto L_0x001a;
                case 243: goto L_0x001a;
                case 244: goto L_0x001a;
                default: goto L_0x0016;
            }
        L_0x0016:
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 > r5) goto L_0x001d
        L_0x001a:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x001d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r4)
            java.lang.String r2 = "Bad character in input: "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L_0x002d:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 1
        L_0x0036:
            if (r5 >= r1) goto L_0x0100
            com.google.zxing.oned.Code128Writer$CType r10 = com.google.zxing.oned.Code128Writer.CType.UNCODABLE
            com.google.zxing.oned.Code128Writer$CType r11 = com.google.zxing.oned.Code128Writer.CType.TWO_DIGITS
            com.google.zxing.oned.Code128Writer$CType r12 = com.google.zxing.oned.Code128Writer.CType.FNC_1
            com.google.zxing.oned.Code128Writer$CType r13 = com.google.zxing.oned.Code128Writer.CType.ONE_DIGIT
            com.google.zxing.oned.Code128Writer$CType r14 = findCType(r0, r5)
            r15 = 32
            r2 = 101(0x65, float:1.42E-43)
            r9 = 100
            r4 = 96
            if (r14 != r13) goto L_0x004f
            goto L_0x009d
        L_0x004f:
            if (r14 != r10) goto L_0x0064
            int r10 = r17.length()
            if (r5 >= r10) goto L_0x009d
            char r10 = r0.charAt(r5)
            if (r10 < r15) goto L_0x0061
            if (r7 != r2) goto L_0x009d
            if (r10 >= r4) goto L_0x009d
        L_0x0061:
            r15 = 101(0x65, float:1.42E-43)
            goto L_0x009f
        L_0x0064:
            r15 = 99
            if (r7 != r15) goto L_0x0069
            goto L_0x009f
        L_0x0069:
            if (r7 != r9) goto L_0x0092
            if (r14 != r12) goto L_0x006e
            goto L_0x009d
        L_0x006e:
            int r14 = r5 + 2
            com.google.zxing.oned.Code128Writer$CType r14 = findCType(r0, r14)
            if (r14 == r10) goto L_0x009d
            if (r14 != r13) goto L_0x0079
            goto L_0x009d
        L_0x0079:
            if (r14 != r12) goto L_0x0084
            int r10 = r5 + 3
            com.google.zxing.oned.Code128Writer$CType r10 = findCType(r0, r10)
            if (r10 != r11) goto L_0x009d
            goto L_0x009f
        L_0x0084:
            int r10 = r5 + 4
        L_0x0086:
            com.google.zxing.oned.Code128Writer$CType r12 = findCType(r0, r10)
            if (r12 != r11) goto L_0x008f
            int r10 = r10 + 2
            goto L_0x0086
        L_0x008f:
            if (r12 != r13) goto L_0x009f
            goto L_0x009d
        L_0x0092:
            if (r14 != r12) goto L_0x009a
            int r10 = r5 + 1
            com.google.zxing.oned.Code128Writer$CType r14 = findCType(r0, r10)
        L_0x009a:
            if (r14 != r11) goto L_0x009d
            goto L_0x009f
        L_0x009d:
            r15 = 100
        L_0x009f:
            if (r15 != r7) goto L_0x00de
            char r10 = r0.charAt(r5)
            switch(r10) {
                case 241: goto L_0x00b6;
                case 242: goto L_0x00b3;
                case 243: goto L_0x00af;
                case 244: goto L_0x00a9;
                default: goto L_0x00a8;
            }
        L_0x00a8:
            goto L_0x00b9
        L_0x00a9:
            if (r7 != r2) goto L_0x00ac
            goto L_0x00b1
        L_0x00ac:
            r2 = 100
            goto L_0x00b1
        L_0x00af:
            r2 = 96
        L_0x00b1:
            r4 = 1
            goto L_0x00dc
        L_0x00b3:
            r2 = 97
            goto L_0x00b1
        L_0x00b6:
            r2 = 102(0x66, float:1.43E-43)
            goto L_0x00b1
        L_0x00b9:
            if (r7 == r9) goto L_0x00d5
            if (r7 == r2) goto L_0x00ca
            int r2 = r5 + 2
            java.lang.String r2 = r0.substring(r5, r2)
            int r2 = java.lang.Integer.parseInt(r2)
            int r5 = r5 + 1
            goto L_0x00b1
        L_0x00ca:
            char r2 = r0.charAt(r5)
            int r2 = r2 + -32
            if (r2 >= 0) goto L_0x00b1
            int r2 = r2 + 96
            goto L_0x00b1
        L_0x00d5:
            char r2 = r0.charAt(r5)
            int r2 = r2 + -32
            goto L_0x00b1
        L_0x00dc:
            int r5 = r5 + r4
            goto L_0x00f0
        L_0x00de:
            if (r7 != 0) goto L_0x00ed
            if (r15 == r9) goto L_0x00ea
            if (r15 == r2) goto L_0x00e7
            r9 = 105(0x69, float:1.47E-43)
            goto L_0x00ee
        L_0x00e7:
            r9 = 103(0x67, float:1.44E-43)
            goto L_0x00ee
        L_0x00ea:
            r9 = 104(0x68, float:1.46E-43)
            goto L_0x00ee
        L_0x00ed:
            r9 = r15
        L_0x00ee:
            r2 = r9
            r7 = r15
        L_0x00f0:
            int[][] r4 = com.google.zxing.oned.Code128Reader.CODE_PATTERNS
            r4 = r4[r2]
            r3.add(r4)
            int r2 = r2 * r8
            int r6 = r6 + r2
            if (r5 == 0) goto L_0x0036
            int r8 = r8 + 1
            goto L_0x0036
        L_0x0100:
            r2 = 103(0x67, float:1.44E-43)
            int r6 = r6 % r2
            int[][] r0 = com.google.zxing.oned.Code128Reader.CODE_PATTERNS
            r0 = r0[r6]
            r3.add(r0)
            int[][] r0 = com.google.zxing.oned.Code128Reader.CODE_PATTERNS
            r1 = 106(0x6a, float:1.49E-43)
            r0 = r0[r1]
            r3.add(r0)
            java.util.Iterator r0 = r3.iterator()
            r1 = 0
        L_0x0118:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x012e
            java.lang.Object r2 = r0.next()
            int[] r2 = (int[]) r2
            int r4 = r2.length
            r5 = 0
        L_0x0126:
            if (r5 >= r4) goto L_0x0118
            r6 = r2[r5]
            int r1 = r1 + r6
            int r5 = r5 + 1
            goto L_0x0126
        L_0x012e:
            boolean[] r0 = new boolean[r1]
            java.util.Iterator r1 = r3.iterator()
            r2 = 0
        L_0x0135:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0148
            java.lang.Object r3 = r1.next()
            int[] r3 = (int[]) r3
            r4 = 1
            int r3 = com.google.zxing.oned.OneDimensionalCodeWriter.appendPattern(r0, r2, r3, r4)
            int r2 = r2 + r3
            goto L_0x0135
        L_0x0148:
            return r0
        L_0x0149:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Contents length should be between 1 and 80 characters, but got "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            goto L_0x015a
        L_0x0159:
            throw r0
        L_0x015a:
            goto L_0x0159
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.encode(java.lang.String):boolean[]");
    }
}
