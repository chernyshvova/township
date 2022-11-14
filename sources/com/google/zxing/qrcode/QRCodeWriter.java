package com.google.zxing.qrcode;

import com.google.zxing.Writer;

public final class QRCodeWriter implements Writer {
    /* JADX WARNING: Removed duplicated region for block: B:103:0x016d A[LOOP:2: B:88:0x013b->B:103:0x016d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e A[SYNTHETIC, Splitter:B:26:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x065e  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x00c3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x017c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x012e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.common.BitMatrix encode(java.lang.String r27, com.google.zxing.BarcodeFormat r28, int r29, int r30, java.util.Map<com.google.zxing.EncodeHintType, ?> r31) throws com.google.zxing.WriterException {
        /*
            r26 = this;
            r0 = r27
            r1 = r29
            r2 = r30
            r3 = r31
            com.google.zxing.EncodeHintType r4 = com.google.zxing.EncodeHintType.MARGIN
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.ERROR_CORRECTION
            boolean r6 = r27.isEmpty()
            if (r6 != 0) goto L_0x06a8
            com.google.zxing.BarcodeFormat r6 = com.google.zxing.BarcodeFormat.QR_CODE
            r7 = r28
            if (r7 != r6) goto L_0x0698
            if (r1 < 0) goto L_0x067a
            if (r2 < 0) goto L_0x067a
            com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r6 = com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.L
            if (r3 == 0) goto L_0x0045
            boolean r8 = r3.containsKey(r5)
            if (r8 == 0) goto L_0x0032
            java.lang.Object r5 = r3.get(r5)
            java.lang.String r5 = r5.toString()
            com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r6 = com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.valueOf(r5)
        L_0x0032:
            boolean r5 = r3.containsKey(r4)
            if (r5 == 0) goto L_0x0045
            java.lang.Object r4 = r3.get(r4)
            java.lang.String r4 = r4.toString()
            int r4 = java.lang.Integer.parseInt(r4)
            goto L_0x0046
        L_0x0045:
            r4 = 4
        L_0x0046:
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.QR_VERSION
            com.google.zxing.EncodeHintType r8 = com.google.zxing.EncodeHintType.GS1_FORMAT
            com.google.zxing.EncodeHintType r9 = com.google.zxing.EncodeHintType.CHARACTER_SET
            com.google.zxing.qrcode.decoder.Mode r10 = com.google.zxing.qrcode.decoder.Mode.BYTE
            if (r3 == 0) goto L_0x0058
            boolean r13 = r3.containsKey(r9)
            if (r13 == 0) goto L_0x0058
            r13 = 1
            goto L_0x0059
        L_0x0058:
            r13 = 0
        L_0x0059:
            if (r13 == 0) goto L_0x0064
            java.lang.Object r9 = r3.get(r9)
            java.lang.String r9 = r9.toString()
            goto L_0x0066
        L_0x0064:
            java.lang.String r9 = "ISO-8859-1"
        L_0x0066:
            java.lang.String r14 = "Shift_JIS"
            boolean r15 = r14.equals(r9)
            if (r15 == 0) goto L_0x009f
            byte[] r15 = r0.getBytes(r14)     // Catch:{ UnsupportedEncodingException -> 0x0099 }
            int r11 = r15.length
            int r17 = r11 % 2
            if (r17 == 0) goto L_0x0078
            goto L_0x0099
        L_0x0078:
            r7 = 0
        L_0x0079:
            if (r7 >= r11) goto L_0x0097
            byte r12 = r15[r7]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r19 = r11
            r11 = 129(0x81, float:1.81E-43)
            if (r12 < r11) goto L_0x0089
            r11 = 159(0x9f, float:2.23E-43)
            if (r12 <= r11) goto L_0x0092
        L_0x0089:
            r11 = 224(0xe0, float:3.14E-43)
            if (r12 < r11) goto L_0x0099
            r11 = 235(0xeb, float:3.3E-43)
            if (r12 <= r11) goto L_0x0092
            goto L_0x0099
        L_0x0092:
            int r7 = r7 + 2
            r11 = r19
            goto L_0x0079
        L_0x0097:
            r7 = 1
            goto L_0x009a
        L_0x0099:
            r7 = 0
        L_0x009a:
            if (r7 == 0) goto L_0x009f
            com.google.zxing.qrcode.decoder.Mode r7 = com.google.zxing.qrcode.decoder.Mode.KANJI
            goto L_0x00ce
        L_0x009f:
            r7 = 0
            r11 = 0
            r12 = 0
        L_0x00a2:
            int r15 = r27.length()
            if (r12 >= r15) goto L_0x00c3
            char r15 = r0.charAt(r12)
            r2 = 48
            if (r15 < r2) goto L_0x00b6
            r2 = 57
            if (r15 > r2) goto L_0x00b6
            r11 = 1
            goto L_0x00be
        L_0x00b6:
            int r2 = com.google.zxing.qrcode.encoder.Encoder.getAlphanumericCode(r15)
            r7 = -1
            if (r2 == r7) goto L_0x00cd
            r7 = 1
        L_0x00be:
            int r12 = r12 + 1
            r2 = r30
            goto L_0x00a2
        L_0x00c3:
            if (r7 == 0) goto L_0x00c8
            com.google.zxing.qrcode.decoder.Mode r7 = com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC
            goto L_0x00ce
        L_0x00c8:
            if (r11 == 0) goto L_0x00cd
            com.google.zxing.qrcode.decoder.Mode r7 = com.google.zxing.qrcode.decoder.Mode.NUMERIC
            goto L_0x00ce
        L_0x00cd:
            r7 = r10
        L_0x00ce:
            com.google.zxing.common.BitArray r2 = new com.google.zxing.common.BitArray
            r2.<init>()
            r11 = 8
            if (r7 != r10) goto L_0x00f3
            if (r13 == 0) goto L_0x00f3
            java.util.Map<java.lang.String, com.google.zxing.common.CharacterSetECI> r12 = com.google.zxing.common.CharacterSetECI.NAME_TO_ECI
            java.lang.Object r12 = r12.get(r9)
            com.google.zxing.common.CharacterSetECI r12 = (com.google.zxing.common.CharacterSetECI) r12
            if (r12 == 0) goto L_0x00f3
            com.google.zxing.qrcode.decoder.Mode r13 = com.google.zxing.qrcode.decoder.Mode.ECI
            int r13 = r13.bits
            r15 = 4
            r2.appendBits(r13, r15)
            int[] r12 = r12.values
            r13 = 0
            r12 = r12[r13]
            r2.appendBits(r12, r11)
        L_0x00f3:
            if (r3 == 0) goto L_0x00fd
            boolean r12 = r3.containsKey(r8)
            if (r12 == 0) goto L_0x00fd
            r12 = 1
            goto L_0x00fe
        L_0x00fd:
            r12 = 0
        L_0x00fe:
            if (r12 == 0) goto L_0x011b
            java.lang.Object r8 = r3.get(r8)
            java.lang.String r8 = r8.toString()
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x011b
            com.google.zxing.qrcode.decoder.Mode r8 = com.google.zxing.qrcode.decoder.Mode.FNC1_FIRST_POSITION
            int r8 = r8.bits
            r12 = 4
            r2.appendBits(r8, r12)
            goto L_0x011c
        L_0x011b:
            r12 = 4
        L_0x011c:
            int r8 = r7.bits
            r2.appendBits(r8, r12)
            com.google.zxing.common.BitArray r8 = new com.google.zxing.common.BitArray
            r8.<init>()
            int r13 = r7.ordinal()
            r15 = 2
            r11 = 1
            if (r13 == r11) goto L_0x01f3
            r11 = 6
            if (r13 == r15) goto L_0x01b6
            if (r13 == r12) goto L_0x019c
            if (r13 != r11) goto L_0x018c
            byte[] r9 = r0.getBytes(r14)     // Catch:{ UnsupportedEncodingException -> 0x0184 }
            int r11 = r9.length
            r12 = 0
        L_0x013b:
            if (r12 >= r11) goto L_0x0238
            byte r13 = r9[r12]
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r14 = r12 + 1
            byte r14 = r9[r14]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r20 = 8
            int r13 = r13 << 8
            r13 = r13 | r14
            r14 = 33088(0x8140, float:4.6366E-41)
            if (r13 < r14) goto L_0x015a
            r14 = 40956(0x9ffc, float:5.7392E-41)
            if (r13 > r14) goto L_0x015a
            r14 = 33088(0x8140, float:4.6366E-41)
            goto L_0x0167
        L_0x015a:
            r14 = 57408(0xe040, float:8.0446E-41)
            if (r13 < r14) goto L_0x0169
            r14 = 60351(0xebbf, float:8.457E-41)
            if (r13 > r14) goto L_0x0169
            r14 = 49472(0xc140, float:6.9325E-41)
        L_0x0167:
            int r13 = r13 - r14
            goto L_0x016a
        L_0x0169:
            r13 = -1
        L_0x016a:
            r14 = -1
            if (r13 == r14) goto L_0x017c
            int r14 = r13 >> 8
            int r14 = r14 * 192
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r14 = r14 + r13
            r13 = 13
            r8.appendBits(r14, r13)
            int r12 = r12 + 2
            goto L_0x013b
        L_0x017c:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Invalid byte sequence"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0184:
            r0 = move-exception
            r1 = r0
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>((java.lang.Throwable) r1)
            throw r0
        L_0x018c:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = java.lang.String.valueOf(r7)
            java.lang.String r2 = "Invalid mode: "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x019c:
            byte[] r9 = r0.getBytes(r9)     // Catch:{ UnsupportedEncodingException -> 0x01ae }
            int r11 = r9.length
            r12 = 0
        L_0x01a2:
            if (r12 >= r11) goto L_0x0238
            byte r13 = r9[r12]
            r14 = 8
            r8.appendBits(r13, r14)
            int r12 = r12 + 1
            goto L_0x01a2
        L_0x01ae:
            r0 = move-exception
            r1 = r0
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>((java.lang.Throwable) r1)
            throw r0
        L_0x01b6:
            int r9 = r27.length()
            r12 = 0
        L_0x01bb:
            if (r12 >= r9) goto L_0x0238
            char r13 = r0.charAt(r12)
            int r13 = com.google.zxing.qrcode.encoder.Encoder.getAlphanumericCode(r13)
            r14 = -1
            if (r13 == r14) goto L_0x01ed
            int r15 = r12 + 1
            if (r15 >= r9) goto L_0x01e7
            char r15 = r0.charAt(r15)
            int r15 = com.google.zxing.qrcode.encoder.Encoder.getAlphanumericCode(r15)
            if (r15 == r14) goto L_0x01e1
            int r13 = r13 * 45
            int r13 = r13 + r15
            r14 = 11
            r8.appendBits(r13, r14)
            int r12 = r12 + 2
            goto L_0x01eb
        L_0x01e1:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>()
            throw r0
        L_0x01e7:
            r8.appendBits(r13, r11)
            r12 = r15
        L_0x01eb:
            r15 = 2
            goto L_0x01bb
        L_0x01ed:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>()
            throw r0
        L_0x01f3:
            int r9 = r27.length()
            r11 = 0
        L_0x01f8:
            if (r11 >= r9) goto L_0x0238
            char r12 = r0.charAt(r11)
            int r12 = r12 + -48
            int r13 = r11 + 2
            if (r13 >= r9) goto L_0x0220
            int r14 = r11 + 1
            char r14 = r0.charAt(r14)
            int r14 = r14 + -48
            char r13 = r0.charAt(r13)
            int r13 = r13 + -48
            int r12 = r12 * 100
            r15 = 10
            int r14 = r14 * 10
            int r14 = r14 + r12
            int r14 = r14 + r13
            r8.appendBits(r14, r15)
            int r11 = r11 + 3
            goto L_0x01f8
        L_0x0220:
            int r11 = r11 + 1
            if (r11 >= r9) goto L_0x0233
            char r11 = r0.charAt(r11)
            int r11 = r11 + -48
            int r12 = r12 * 10
            int r12 = r12 + r11
            r11 = 7
            r8.appendBits(r12, r11)
            r11 = r13
            goto L_0x01f8
        L_0x0233:
            r13 = 4
            r8.appendBits(r12, r13)
            goto L_0x01f8
        L_0x0238:
            if (r3 == 0) goto L_0x0269
            boolean r9 = r3.containsKey(r5)
            if (r9 == 0) goto L_0x0269
            java.lang.Object r3 = r3.get(r5)
            java.lang.String r3 = r3.toString()
            int r3 = java.lang.Integer.parseInt(r3)
            com.google.zxing.qrcode.decoder.Version r3 = com.google.zxing.qrcode.decoder.Version.getVersionForNumber(r3)
            int r5 = r2.size
            int r9 = r7.getCharacterCountBits(r3)
            int r9 = r9 + r5
            int r5 = r8.size
            int r9 = r9 + r5
            boolean r5 = com.google.zxing.qrcode.encoder.Encoder.willFit(r9, r3, r6)
            if (r5 == 0) goto L_0x0261
            goto L_0x028a
        L_0x0261:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Data too big for requested version"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0269:
            r3 = 1
            com.google.zxing.qrcode.decoder.Version r5 = com.google.zxing.qrcode.decoder.Version.getVersionForNumber(r3)
            int r3 = r2.size
            int r5 = r7.getCharacterCountBits(r5)
            int r5 = r5 + r3
            int r3 = r8.size
            int r5 = r5 + r3
            com.google.zxing.qrcode.decoder.Version r3 = com.google.zxing.qrcode.encoder.Encoder.chooseVersion(r5, r6)
            int r5 = r2.size
            int r3 = r7.getCharacterCountBits(r3)
            int r3 = r3 + r5
            int r5 = r8.size
            int r3 = r3 + r5
            com.google.zxing.qrcode.decoder.Version r3 = com.google.zxing.qrcode.encoder.Encoder.chooseVersion(r3, r6)
        L_0x028a:
            com.google.zxing.common.BitArray r5 = new com.google.zxing.common.BitArray
            r5.<init>()
            r5.appendBitArray(r2)
            if (r7 != r10) goto L_0x0299
            int r0 = r8.getSizeInBytes()
            goto L_0x029d
        L_0x0299:
            int r0 = r27.length()
        L_0x029d:
            int r2 = r7.getCharacterCountBits(r3)
            r7 = 1
            int r9 = r7 << r2
            if (r0 >= r9) goto L_0x065e
            r5.appendBits(r0, r2)
            r5.appendBitArray(r8)
            com.google.zxing.qrcode.decoder.Version$ECBlocks[] r0 = r3.ecBlocks
            int r2 = r6.ordinal()
            r0 = r0[r2]
            int r2 = r3.totalCodewords
            int r7 = r0.ecCodewordsPerBlock
            int r8 = r0.getNumBlocks()
            int r8 = r8 * r7
            int r2 = r2 - r8
            int r7 = r2 << 3
            int r8 = r5.size
            if (r8 > r7) goto L_0x0640
            r8 = 0
        L_0x02c6:
            r9 = 4
            if (r8 >= r9) goto L_0x02d4
            int r9 = r5.size
            if (r9 >= r7) goto L_0x02d4
            r9 = 0
            r5.appendBit(r9)
            int r8 = r8 + 1
            goto L_0x02c6
        L_0x02d4:
            r9 = 0
            int r8 = r5.size
            r10 = 7
            r8 = r8 & r10
            if (r8 <= 0) goto L_0x02e6
        L_0x02db:
            r10 = 8
            if (r8 >= r10) goto L_0x02e6
            r5.appendBit(r9)
            int r8 = r8 + 1
            r9 = 0
            goto L_0x02db
        L_0x02e6:
            int r8 = r5.getSizeInBytes()
            int r8 = r2 - r8
            r9 = 0
        L_0x02ed:
            if (r9 >= r8) goto L_0x0300
            r11 = r9 & 1
            if (r11 != 0) goto L_0x02f6
            r10 = 236(0xec, float:3.31E-43)
            goto L_0x02f8
        L_0x02f6:
            r10 = 17
        L_0x02f8:
            r11 = 8
            r5.appendBits(r10, r11)
            int r9 = r9 + 1
            goto L_0x02ed
        L_0x0300:
            int r8 = r5.size
            if (r8 != r7) goto L_0x0638
            int r7 = r3.totalCodewords
            int r0 = r0.getNumBlocks()
            int r8 = r5.getSizeInBytes()
            if (r8 != r2) goto L_0x0630
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>(r0)
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0319:
            if (r13 >= r0) goto L_0x03fe
            r14 = 1
            int[] r15 = new int[r14]
            int[] r10 = new int[r14]
            if (r13 >= r0) goto L_0x03f6
            int r14 = r7 % r0
            int r1 = r0 - r14
            int r19 = r7 / r0
            int r21 = r19 + 1
            int r22 = r2 / r0
            int r23 = r22 + 1
            r24 = r4
            int r4 = r19 - r22
            r19 = r6
            int r6 = r21 - r23
            if (r4 != r6) goto L_0x03ee
            r21 = r3
            int r3 = r1 + r14
            if (r0 != r3) goto L_0x03e6
            int r3 = r22 + r4
            int r3 = r3 * r1
            int r25 = r23 + r6
            int r25 = r25 * r14
            int r3 = r25 + r3
            if (r7 != r3) goto L_0x03de
            if (r13 >= r1) goto L_0x0352
            r1 = 0
            r15[r1] = r22
            r10[r1] = r4
            goto L_0x0357
        L_0x0352:
            r1 = 0
            r15[r1] = r23
            r10[r1] = r6
        L_0x0357:
            r3 = r15[r1]
            byte[] r1 = new byte[r3]
            int r4 = r9 << 3
            r6 = 0
        L_0x035e:
            if (r6 >= r3) goto L_0x038a
            r31 = r0
            r22 = r7
            r0 = 0
            r7 = 8
            r14 = 0
        L_0x0368:
            if (r14 >= r7) goto L_0x037e
            boolean r7 = r5.get(r4)
            if (r7 == 0) goto L_0x0377
            int r7 = 7 - r14
            r23 = 1
            int r7 = r23 << r7
            r0 = r0 | r7
        L_0x0377:
            int r4 = r4 + 1
            int r14 = r14 + 1
            r7 = 8
            goto L_0x0368
        L_0x037e:
            int r7 = r6 + 0
            byte r0 = (byte) r0
            r1[r7] = r0
            int r6 = r6 + 1
            r0 = r31
            r7 = r22
            goto L_0x035e
        L_0x038a:
            r31 = r0
            r22 = r7
            r0 = 0
            r4 = r10[r0]
            int r0 = r3 + r4
            int[] r0 = new int[r0]
            r6 = 0
        L_0x0396:
            if (r6 >= r3) goto L_0x03a1
            byte r7 = r1[r6]
            r7 = r7 & 255(0xff, float:3.57E-43)
            r0[r6] = r7
            int r6 = r6 + 1
            goto L_0x0396
        L_0x03a1:
            com.google.zxing.common.reedsolomon.ReedSolomonEncoder r6 = new com.google.zxing.common.reedsolomon.ReedSolomonEncoder
            com.google.zxing.common.reedsolomon.GenericGF r7 = com.google.zxing.common.reedsolomon.GenericGF.QR_CODE_FIELD_256
            r6.<init>(r7)
            r6.encode(r0, r4)
            byte[] r6 = new byte[r4]
            r7 = 0
        L_0x03ae:
            if (r7 >= r4) goto L_0x03ba
            int r10 = r3 + r7
            r10 = r0[r10]
            byte r10 = (byte) r10
            r6[r7] = r10
            int r7 = r7 + 1
            goto L_0x03ae
        L_0x03ba:
            com.google.zxing.qrcode.encoder.BlockPair r0 = new com.google.zxing.qrcode.encoder.BlockPair
            r0.<init>(r1, r6)
            r8.add(r0)
            int r11 = java.lang.Math.max(r11, r3)
            int r12 = java.lang.Math.max(r12, r4)
            r0 = 0
            r1 = r15[r0]
            int r9 = r9 + r1
            int r13 = r13 + 1
            r1 = r29
            r0 = r31
            r6 = r19
            r3 = r21
            r7 = r22
            r4 = r24
            goto L_0x0319
        L_0x03de:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Total bytes mismatch"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x03e6:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "RS blocks mismatch"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x03ee:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "EC bytes mismatch"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x03f6:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Block ID too large"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x03fe:
            r21 = r3
            r24 = r4
            r19 = r6
            r22 = r7
            if (r2 != r9) goto L_0x0628
            com.google.zxing.common.BitArray r0 = new com.google.zxing.common.BitArray
            r0.<init>()
            r13 = 0
        L_0x040e:
            if (r13 >= r11) goto L_0x0430
            java.util.Iterator r1 = r8.iterator()
        L_0x0414:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x042d
            java.lang.Object r2 = r1.next()
            com.google.zxing.qrcode.encoder.BlockPair r2 = (com.google.zxing.qrcode.encoder.BlockPair) r2
            byte[] r2 = r2.dataBytes
            int r3 = r2.length
            if (r13 >= r3) goto L_0x0414
            byte r2 = r2[r13]
            r3 = 8
            r0.appendBits(r2, r3)
            goto L_0x0414
        L_0x042d:
            int r13 = r13 + 1
            goto L_0x040e
        L_0x0430:
            r13 = 0
        L_0x0431:
            if (r13 >= r12) goto L_0x0453
            java.util.Iterator r1 = r8.iterator()
        L_0x0437:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0450
            java.lang.Object r2 = r1.next()
            com.google.zxing.qrcode.encoder.BlockPair r2 = (com.google.zxing.qrcode.encoder.BlockPair) r2
            byte[] r2 = r2.errorCorrectionBytes
            int r3 = r2.length
            if (r13 >= r3) goto L_0x0437
            byte r2 = r2[r13]
            r3 = 8
            r0.appendBits(r2, r3)
            goto L_0x0437
        L_0x0450:
            int r13 = r13 + 1
            goto L_0x0431
        L_0x0453:
            int r1 = r0.getSizeInBytes()
            r2 = r22
            if (r2 != r1) goto L_0x0603
            r3 = r21
            int r1 = r3.versionNumber
            r2 = 4
            int r1 = r1 * 4
            r2 = 17
            int r1 = r1 + r2
            com.google.zxing.qrcode.encoder.ByteMatrix r2 = new com.google.zxing.qrcode.encoder.ByteMatrix
            r2.<init>(r1, r1)
            r1 = 2147483647(0x7fffffff, float:NaN)
            r4 = 8
            r7 = -1
            r13 = 0
        L_0x0471:
            if (r13 >= r4) goto L_0x05b6
            r6 = r19
            com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(r0, r6, r3, r13, r2)
            r5 = 1
            int r8 = com.android.billingclient.api.zzam.applyMaskPenaltyRule1Internal(r2, r5)
            r5 = 0
            int r9 = com.android.billingclient.api.zzam.applyMaskPenaltyRule1Internal(r2, r5)
            int r9 = r9 + r8
            byte[][] r8 = r2.bytes
            int r10 = r2.width
            int r11 = r2.height
            r12 = 0
            r14 = 0
        L_0x048b:
            r15 = -1
            int r4 = r11 + -1
            if (r12 >= r4) goto L_0x04bb
            r4 = r8[r12]
            r16 = r14
            r14 = 0
        L_0x0495:
            int r5 = r10 + -1
            if (r14 >= r5) goto L_0x04b5
            byte r5 = r4[r14]
            int r18 = r14 + 1
            byte r15 = r4[r18]
            if (r5 != r15) goto L_0x04b1
            int r15 = r12 + 1
            r19 = r8[r15]
            byte r14 = r19[r14]
            if (r5 != r14) goto L_0x04b1
            r14 = r8[r15]
            byte r14 = r14[r18]
            if (r5 != r14) goto L_0x04b1
            int r16 = r16 + 1
        L_0x04b1:
            r14 = r18
            r15 = -1
            goto L_0x0495
        L_0x04b5:
            int r12 = r12 + 1
            r14 = r16
            r5 = 0
            goto L_0x048b
        L_0x04bb:
            int r14 = r14 * 3
            int r14 = r14 + r9
            byte[][] r4 = r2.bytes
            int r5 = r2.width
            int r8 = r2.height
            r9 = 0
            r10 = 0
        L_0x04c6:
            if (r9 >= r8) goto L_0x0572
            r11 = 0
        L_0x04c9:
            if (r11 >= r5) goto L_0x056a
            r12 = r4[r9]
            int r15 = r11 + 6
            if (r15 >= r5) goto L_0x0511
            r16 = r5
            byte r5 = r12[r11]
            r31 = r0
            r0 = 1
            if (r5 != r0) goto L_0x0515
            int r5 = r11 + 1
            byte r5 = r12[r5]
            if (r5 != 0) goto L_0x0515
            int r5 = r11 + 2
            byte r5 = r12[r5]
            if (r5 != r0) goto L_0x0515
            int r5 = r11 + 3
            byte r5 = r12[r5]
            if (r5 != r0) goto L_0x0515
            int r5 = r11 + 4
            byte r5 = r12[r5]
            if (r5 != r0) goto L_0x0515
            int r5 = r11 + 5
            byte r5 = r12[r5]
            if (r5 != 0) goto L_0x0515
            byte r5 = r12[r15]
            if (r5 != r0) goto L_0x0515
            int r0 = r11 + -4
            boolean r0 = com.android.billingclient.api.zzam.isWhiteHorizontal(r12, r0, r11)
            if (r0 != 0) goto L_0x050e
            int r0 = r11 + 7
            int r5 = r11 + 11
            boolean r0 = com.android.billingclient.api.zzam.isWhiteHorizontal(r12, r0, r5)
            if (r0 == 0) goto L_0x0515
        L_0x050e:
            int r10 = r10 + 1
            goto L_0x0515
        L_0x0511:
            r31 = r0
            r16 = r5
        L_0x0515:
            int r0 = r9 + 6
            if (r0 >= r8) goto L_0x0562
            r5 = r4[r9]
            byte r5 = r5[r11]
            r12 = 1
            if (r5 != r12) goto L_0x0562
            int r5 = r9 + 1
            r5 = r4[r5]
            byte r5 = r5[r11]
            if (r5 != 0) goto L_0x0562
            int r5 = r9 + 2
            r5 = r4[r5]
            byte r5 = r5[r11]
            if (r5 != r12) goto L_0x0562
            int r5 = r9 + 3
            r5 = r4[r5]
            byte r5 = r5[r11]
            if (r5 != r12) goto L_0x0562
            int r5 = r9 + 4
            r5 = r4[r5]
            byte r5 = r5[r11]
            if (r5 != r12) goto L_0x0562
            int r5 = r9 + 5
            r5 = r4[r5]
            byte r5 = r5[r11]
            if (r5 != 0) goto L_0x0562
            r0 = r4[r0]
            byte r0 = r0[r11]
            if (r0 != r12) goto L_0x0562
            int r0 = r9 + -4
            boolean r0 = com.android.billingclient.api.zzam.isWhiteVertical(r4, r11, r0, r9)
            if (r0 != 0) goto L_0x0560
            int r0 = r9 + 7
            int r5 = r9 + 11
            boolean r0 = com.android.billingclient.api.zzam.isWhiteVertical(r4, r11, r0, r5)
            if (r0 == 0) goto L_0x0562
        L_0x0560:
            int r10 = r10 + 1
        L_0x0562:
            int r11 = r11 + 1
            r0 = r31
            r5 = r16
            goto L_0x04c9
        L_0x056a:
            r31 = r0
            r16 = r5
            int r9 = r9 + 1
            goto L_0x04c6
        L_0x0572:
            r31 = r0
            int r10 = r10 * 40
            int r10 = r10 + r14
            byte[][] r0 = r2.bytes
            int r4 = r2.width
            int r5 = r2.height
            r8 = 0
            r9 = 0
        L_0x057f:
            if (r8 >= r5) goto L_0x0593
            r11 = r0[r8]
            r12 = 0
        L_0x0584:
            if (r12 >= r4) goto L_0x0590
            byte r14 = r11[r12]
            r15 = 1
            if (r14 != r15) goto L_0x058d
            int r9 = r9 + 1
        L_0x058d:
            int r12 = r12 + 1
            goto L_0x0584
        L_0x0590:
            int r8 = r8 + 1
            goto L_0x057f
        L_0x0593:
            int r0 = r2.height
            int r4 = r2.width
            int r0 = r0 * r4
            int r4 = r9 << 1
            int r4 = r4 - r0
            int r4 = java.lang.Math.abs(r4)
            r5 = 10
            int r4 = r4 * 10
            int r4 = r4 / r0
            int r4 = r4 * 10
            int r4 = r4 + r10
            if (r4 >= r1) goto L_0x05ac
            r1 = r4
            r7 = r13
        L_0x05ac:
            int r13 = r13 + 1
            r0 = r31
            r19 = r6
            r4 = 8
            goto L_0x0471
        L_0x05b6:
            r6 = r19
            com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(r0, r6, r3, r7, r2)
            int r0 = r2.width
            int r1 = r2.height
            r3 = 1
            int r4 = r24 << 1
            int r3 = r0 + r4
            int r4 = r4 + r1
            r5 = r29
            int r5 = java.lang.Math.max(r5, r3)
            r6 = r30
            int r6 = java.lang.Math.max(r6, r4)
            int r3 = r5 / r3
            int r4 = r6 / r4
            int r3 = java.lang.Math.min(r3, r4)
            int r4 = r0 * r3
            int r4 = r5 - r4
            r7 = 2
            int r4 = r4 / r7
            int r8 = r1 * r3
            int r8 = r6 - r8
            int r8 = r8 / r7
            com.google.zxing.common.BitMatrix r7 = new com.google.zxing.common.BitMatrix
            r7.<init>(r5, r6)
            r13 = 0
        L_0x05ea:
            if (r13 >= r1) goto L_0x0602
            r6 = r4
            r5 = 0
        L_0x05ee:
            if (r5 >= r0) goto L_0x05fe
            byte r9 = r2.get(r5, r13)
            r10 = 1
            if (r9 != r10) goto L_0x05fa
            r7.setRegion(r6, r8, r3, r3)
        L_0x05fa:
            int r5 = r5 + 1
            int r6 = r6 + r3
            goto L_0x05ee
        L_0x05fe:
            int r13 = r13 + 1
            int r8 = r8 + r3
            goto L_0x05ea
        L_0x0602:
            return r7
        L_0x0603:
            com.google.zxing.WriterException r1 = new com.google.zxing.WriterException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Interleaving error: "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = " and "
            r3.append(r2)
            int r0 = r0.getSizeInBytes()
            r3.append(r0)
            java.lang.String r0 = " differ."
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x0628:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Data bytes does not match offset"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0630:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Number of bits and data bytes does not match"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0638:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Bits size does not equal capacity"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0640:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "data bits cannot fit in the QR Code"
            r1.<init>(r2)
            int r2 = r5.size
            r1.append(r2)
            java.lang.String r2 = " > "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x065e:
            com.google.zxing.WriterException r1 = new com.google.zxing.WriterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = " is bigger than "
            r2.append(r0)
            r0 = 1
            int r9 = r9 - r0
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x067a:
            r5 = r1
            r6 = r2
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Requested dimensions are too small: "
            r1.<init>(r2)
            r1.append(r5)
            r2 = 120(0x78, float:1.68E-43)
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0698:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r28)
            java.lang.String r2 = "Can only encode QR_CODE, but got "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L_0x06a8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Found empty contents"
            r0.<init>(r1)
            goto L_0x06b1
        L_0x06b0:
            throw r0
        L_0x06b1:
            goto L_0x06b0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.QRCodeWriter.encode(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map):com.google.zxing.common.BitMatrix");
    }
}
