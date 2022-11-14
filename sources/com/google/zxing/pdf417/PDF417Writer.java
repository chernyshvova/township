package com.google.zxing.pdf417;

import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.lang.reflect.Array;

public final class PDF417Writer implements Writer {
    public static BitMatrix bitMatrixFromBitArray(byte[][] bArr, int i) {
        int i2 = i * 2;
        BitMatrix bitMatrix = new BitMatrix(bArr[0].length + i2, bArr.length + i2);
        int length = bitMatrix.bits.length;
        for (int i3 = 0; i3 < length; i3++) {
            bitMatrix.bits[i3] = 0;
        }
        int i4 = (bitMatrix.height - i) - 1;
        int i5 = 0;
        while (i5 < bArr.length) {
            byte[] bArr2 = bArr[i5];
            for (int i6 = 0; i6 < bArr[0].length; i6++) {
                if (bArr2[i6] == 1) {
                    bitMatrix.set(i6 + i, i4);
                }
            }
            i5++;
            i4--;
        }
        return bitMatrix;
    }

    public static byte[][] rotateArray(byte[][] bArr) {
        int length = bArr[0].length;
        int[] iArr = new int[2];
        iArr[1] = bArr.length;
        iArr[0] = length;
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, iArr);
        for (int i = 0; i < bArr.length; i++) {
            int length2 = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length2] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:88:0x0229 A[LOOP:6: B:87:0x0227->B:88:0x0229, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0253  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.common.BitMatrix encode(java.lang.String r19, com.google.zxing.BarcodeFormat r20, int r21, int r22, java.util.Map<com.google.zxing.EncodeHintType, ?> r23) throws com.google.zxing.WriterException {
        /*
            r18 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            com.google.zxing.EncodeHintType r3 = com.google.zxing.EncodeHintType.CHARACTER_SET
            com.google.zxing.EncodeHintType r4 = com.google.zxing.EncodeHintType.ERROR_CORRECTION
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.MARGIN
            com.google.zxing.EncodeHintType r6 = com.google.zxing.EncodeHintType.PDF417_DIMENSIONS
            com.google.zxing.EncodeHintType r7 = com.google.zxing.EncodeHintType.PDF417_COMPACTION
            com.google.zxing.EncodeHintType r8 = com.google.zxing.EncodeHintType.PDF417_COMPACT
            com.google.zxing.BarcodeFormat r9 = com.google.zxing.BarcodeFormat.PDF_417
            r10 = r20
            if (r10 != r9) goto L_0x02d5
            com.google.zxing.pdf417.encoder.Compaction r9 = com.google.zxing.pdf417.encoder.Compaction.AUTO
            r10 = 0
            if (r2 == 0) goto L_0x009d
            boolean r11 = r2.containsKey(r8)
            if (r11 == 0) goto L_0x0034
            java.lang.Object r8 = r2.get(r8)
            java.lang.String r8 = r8.toString()
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            boolean r8 = r8.booleanValue()
            goto L_0x0035
        L_0x0034:
            r8 = 0
        L_0x0035:
            boolean r11 = r2.containsKey(r7)
            if (r11 == 0) goto L_0x0047
            java.lang.Object r7 = r2.get(r7)
            java.lang.String r7 = r7.toString()
            com.google.zxing.pdf417.encoder.Compaction r9 = com.google.zxing.pdf417.encoder.Compaction.valueOf(r7)
        L_0x0047:
            boolean r7 = r2.containsKey(r6)
            if (r7 == 0) goto L_0x005b
            java.lang.Object r6 = r2.get(r6)
            com.google.zxing.pdf417.encoder.Dimensions r6 = (com.google.zxing.pdf417.encoder.Dimensions) r6
            if (r6 == 0) goto L_0x005a
            r6 = 0
            r7 = 0
            r11 = 0
            r12 = 0
            goto L_0x0061
        L_0x005a:
            throw r10
        L_0x005b:
            r6 = 2
            r7 = 30
            r11 = 2
            r12 = 30
        L_0x0061:
            boolean r13 = r2.containsKey(r5)
            if (r13 == 0) goto L_0x0074
            java.lang.Object r5 = r2.get(r5)
            java.lang.String r5 = r5.toString()
            int r5 = java.lang.Integer.parseInt(r5)
            goto L_0x0076
        L_0x0074:
            r5 = 30
        L_0x0076:
            boolean r13 = r2.containsKey(r4)
            if (r13 == 0) goto L_0x0089
            java.lang.Object r4 = r2.get(r4)
            java.lang.String r4 = r4.toString()
            int r4 = java.lang.Integer.parseInt(r4)
            goto L_0x008a
        L_0x0089:
            r4 = 2
        L_0x008a:
            boolean r13 = r2.containsKey(r3)
            if (r13 == 0) goto L_0x00a7
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = r2.toString()
            java.nio.charset.Charset r10 = java.nio.charset.Charset.forName(r2)
            goto L_0x00a7
        L_0x009d:
            r4 = 2
            r5 = 30
            r6 = 2
            r7 = 30
            r8 = 0
            r11 = 2
            r12 = 30
        L_0x00a7:
            int r2 = com.google.zxing.pdf417.encoder.PDF417ErrorCorrection.getErrorCorrectionCodewordCount(r4)
            r3 = r19
            java.lang.String r9 = com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeHighLevel(r3, r9, r10)
            int r10 = r9.length()
            r13 = 0
            r14 = 0
            r15 = r6
        L_0x00b8:
            if (r15 > r7) goto L_0x010f
            int r16 = r10 + 1
            int r16 = r16 + r2
            int r17 = r16 / r15
            int r17 = r17 + 1
            int r3 = r15 * r17
            r20 = r7
            int r7 = r16 + r15
            if (r3 < r7) goto L_0x00cc
            int r17 = r17 + -1
        L_0x00cc:
            r3 = r17
            if (r3 < r11) goto L_0x010f
            if (r3 > r12) goto L_0x0104
            int r7 = r15 * 17
            int r7 = r7 + 69
            float r7 = (float) r7
            r16 = 1052166324(0x3eb6c8b4, float:0.357)
            float r7 = r7 * r16
            r16 = r12
            float r12 = (float) r3
            r17 = 1073741824(0x40000000, float:2.0)
            float r12 = r12 * r17
            float r7 = r7 / r12
            if (r13 == 0) goto L_0x00f8
            r12 = 1077936128(0x40400000, float:3.0)
            float r17 = r7 - r12
            float r17 = java.lang.Math.abs(r17)
            float r12 = r14 - r12
            float r12 = java.lang.Math.abs(r12)
            int r12 = (r17 > r12 ? 1 : (r17 == r12 ? 0 : -1))
            if (r12 > 0) goto L_0x0106
        L_0x00f8:
            r12 = 2
            int[] r12 = new int[r12]
            r13 = 0
            r12[r13] = r15
            r13 = 1
            r12[r13] = r3
            r14 = r7
            r13 = r12
            goto L_0x0106
        L_0x0104:
            r16 = r12
        L_0x0106:
            int r15 = r15 + 1
            r3 = r19
            r7 = r20
            r12 = r16
            goto L_0x00b8
        L_0x010f:
            if (r13 != 0) goto L_0x012c
            int r3 = r10 + 1
            int r3 = r3 + r2
            int r7 = r3 / r6
            r12 = 1
            int r7 = r7 + r12
            int r14 = r6 * r7
            int r3 = r3 + r6
            if (r14 < r3) goto L_0x011f
            int r7 = r7 + -1
        L_0x011f:
            if (r7 >= r11) goto L_0x012a
            r3 = 2
            int[] r13 = new int[r3]
            r3 = 0
            r13[r3] = r6
            r13[r12] = r11
            goto L_0x012e
        L_0x012a:
            r3 = 0
            goto L_0x012e
        L_0x012c:
            r3 = 0
            r12 = 1
        L_0x012e:
            if (r13 == 0) goto L_0x02cd
            r3 = r13[r3]
            r6 = r13[r12]
            int r7 = r3 * r6
            int r7 = r7 - r2
            int r11 = r10 + 1
            if (r7 <= r11) goto L_0x013f
            int r7 = r7 - r10
            int r7 = r7 + -1
            goto L_0x0140
        L_0x013f:
            r7 = 0
        L_0x0140:
            int r2 = r2 + r10
            int r2 = r2 + 1
            r11 = 929(0x3a1, float:1.302E-42)
            if (r2 > r11) goto L_0x02b0
            int r10 = r10 + r7
            int r10 = r10 + 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r10)
            char r10 = (char) r10
            r2.append(r10)
            r2.append(r9)
            r9 = 0
        L_0x0157:
            if (r9 >= r7) goto L_0x0161
            r10 = 900(0x384, float:1.261E-42)
            r2.append(r10)
            int r9 = r9 + 1
            goto L_0x0157
        L_0x0161:
            java.lang.String r2 = r2.toString()
            int r7 = com.google.zxing.pdf417.encoder.PDF417ErrorCorrection.getErrorCorrectionCodewordCount(r4)
            char[] r9 = new char[r7]
            int r10 = r2.length()
            r12 = 0
        L_0x0170:
            if (r12 >= r10) goto L_0x01a9
            char r13 = r2.charAt(r12)
            int r14 = r7 + -1
            char r15 = r9[r14]
            int r13 = r13 + r15
            int r13 = r13 % r11
        L_0x017c:
            if (r14 <= 0) goto L_0x0196
            int[][] r15 = com.google.zxing.pdf417.encoder.PDF417ErrorCorrection.EC_COEFFICIENTS
            r15 = r15[r4]
            r15 = r15[r14]
            int r15 = r15 * r13
            int r15 = r15 % r11
            int r15 = 929 - r15
            int r16 = r14 + -1
            char r17 = r9[r16]
            int r15 = r17 + r15
            int r15 = r15 % r11
            char r15 = (char) r15
            r9[r14] = r15
            r14 = r16
            goto L_0x017c
        L_0x0196:
            int[][] r14 = com.google.zxing.pdf417.encoder.PDF417ErrorCorrection.EC_COEFFICIENTS
            r14 = r14[r4]
            r15 = 0
            r14 = r14[r15]
            int r13 = r13 * r14
            int r13 = r13 % r11
            int r13 = 929 - r13
            int r13 = r13 % r11
            char r13 = (char) r13
            r9[r15] = r13
            int r12 = r12 + 1
            goto L_0x0170
        L_0x01a9:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r7)
        L_0x01ae:
            int r7 = r7 + -1
            if (r7 < 0) goto L_0x01c3
            char r11 = r9[r7]
            if (r11 == 0) goto L_0x01bd
            char r11 = r9[r7]
            int r11 = 929 - r11
            char r11 = (char) r11
            r9[r7] = r11
        L_0x01bd:
            char r11 = r9[r7]
            r10.append(r11)
            goto L_0x01ae
        L_0x01c3:
            java.lang.String r7 = r10.toString()
            com.google.zxing.pdf417.encoder.BarcodeMatrix r9 = new com.google.zxing.pdf417.encoder.BarcodeMatrix
            r9.<init>(r6, r3)
            java.lang.String r2 = com.android.tools.p006r8.GeneratedOutlineSupport.outline16(r2, r7)
            r7 = 0
            r10 = 0
        L_0x01d2:
            if (r7 >= r6) goto L_0x026f
            int r11 = r7 % 3
            int r12 = r9.currentRow
            int r12 = r12 + 1
            r9.currentRow = r12
            r12 = 130728(0x1fea8, float:1.83189E-40)
            com.google.zxing.pdf417.encoder.BarcodeRow r13 = r9.getCurrentRow()
            r14 = 17
            com.google.zxing.pdf417.encoder.PDF417.encodeChar(r12, r14, r13)
            if (r11 != 0) goto L_0x01f6
            int r12 = r7 / 3
            int r12 = r12 * 30
            int r13 = r6 + -1
            int r13 = r13 / 3
            int r13 = r13 + r12
            int r15 = r3 + -1
            goto L_0x0208
        L_0x01f6:
            r12 = 1
            if (r11 != r12) goto L_0x020a
            int r12 = r7 / 3
            int r12 = r12 * 30
            int r13 = r4 * 3
            int r13 = r13 + r12
            int r15 = r6 + -1
            int r16 = r15 % 3
            int r13 = r16 + r13
            int r15 = r15 / 3
        L_0x0208:
            int r15 = r15 + r12
            goto L_0x0219
        L_0x020a:
            int r12 = r7 / 3
            int r12 = r12 * 30
            int r13 = r3 + -1
            int r13 = r13 + r12
            int r15 = r4 * 3
            int r15 = r15 + r12
            int r12 = r6 + -1
            int r12 = r12 % 3
            int r15 = r15 + r12
        L_0x0219:
            int[][] r12 = com.google.zxing.pdf417.encoder.PDF417.CODEWORD_TABLE
            r12 = r12[r11]
            r12 = r12[r13]
            com.google.zxing.pdf417.encoder.BarcodeRow r13 = r9.getCurrentRow()
            com.google.zxing.pdf417.encoder.PDF417.encodeChar(r12, r14, r13)
            r12 = 0
        L_0x0227:
            if (r12 >= r3) goto L_0x0243
            int[][] r13 = com.google.zxing.pdf417.encoder.PDF417.CODEWORD_TABLE
            r13 = r13[r11]
            char r16 = r2.charAt(r10)
            r13 = r13[r16]
            r19 = r2
            com.google.zxing.pdf417.encoder.BarcodeRow r2 = r9.getCurrentRow()
            com.google.zxing.pdf417.encoder.PDF417.encodeChar(r13, r14, r2)
            int r10 = r10 + 1
            int r12 = r12 + 1
            r2 = r19
            goto L_0x0227
        L_0x0243:
            r19 = r2
            r2 = 260649(0x3fa29, float:3.65247E-40)
            if (r8 == 0) goto L_0x0253
            com.google.zxing.pdf417.encoder.BarcodeRow r11 = r9.getCurrentRow()
            r12 = 1
            com.google.zxing.pdf417.encoder.PDF417.encodeChar(r2, r12, r11)
            goto L_0x0269
        L_0x0253:
            int[][] r12 = com.google.zxing.pdf417.encoder.PDF417.CODEWORD_TABLE
            r11 = r12[r11]
            r11 = r11[r15]
            com.google.zxing.pdf417.encoder.BarcodeRow r12 = r9.getCurrentRow()
            com.google.zxing.pdf417.encoder.PDF417.encodeChar(r11, r14, r12)
            r11 = 18
            com.google.zxing.pdf417.encoder.BarcodeRow r12 = r9.getCurrentRow()
            com.google.zxing.pdf417.encoder.PDF417.encodeChar(r2, r11, r12)
        L_0x0269:
            int r7 = r7 + 1
            r2 = r19
            goto L_0x01d2
        L_0x026f:
            r2 = 4
            r3 = 1
            byte[][] r2 = r9.getScaledMatrix(r3, r2)
            r3 = 0
            if (r1 <= r0) goto L_0x027a
            r4 = 1
            goto L_0x027b
        L_0x027a:
            r4 = 0
        L_0x027b:
            r6 = r2[r3]
            int r6 = r6.length
            int r7 = r2.length
            if (r6 >= r7) goto L_0x0283
            r6 = 1
            goto L_0x0284
        L_0x0283:
            r6 = 0
        L_0x0284:
            if (r4 == r6) goto L_0x028c
            byte[][] r2 = rotateArray(r2)
            r4 = 1
            goto L_0x028d
        L_0x028c:
            r4 = 0
        L_0x028d:
            r3 = r2[r3]
            int r3 = r3.length
            int r0 = r0 / r3
            int r3 = r2.length
            int r1 = r1 / r3
            if (r0 >= r1) goto L_0x0296
            goto L_0x0297
        L_0x0296:
            r0 = r1
        L_0x0297:
            r1 = 1
            if (r0 <= r1) goto L_0x02ab
            int r1 = r0 << 2
            byte[][] r0 = r9.getScaledMatrix(r0, r1)
            if (r4 == 0) goto L_0x02a6
            byte[][] r0 = rotateArray(r0)
        L_0x02a6:
            com.google.zxing.common.BitMatrix r0 = bitMatrixFromBitArray(r0, r5)
            goto L_0x02af
        L_0x02ab:
            com.google.zxing.common.BitMatrix r0 = bitMatrixFromBitArray(r2, r5)
        L_0x02af:
            return r0
        L_0x02b0:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Encoded message contains too many code words, message too big ("
            r1.<init>(r2)
            int r2 = r19.length()
            r1.append(r2)
            java.lang.String r2 = " bytes)"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x02cd:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Unable to fit message in columns"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x02d5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r20)
            java.lang.String r2 = "Can only encode PDF_417, but got "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            goto L_0x02e6
        L_0x02e5:
            throw r0
        L_0x02e6:
            goto L_0x02e5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.PDF417Writer.encode(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map):com.google.zxing.common.BitMatrix");
    }
}
