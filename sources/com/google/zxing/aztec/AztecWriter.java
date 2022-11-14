package com.google.zxing.aztec;

import com.google.zxing.Writer;

public final class AztecWriter implements Writer {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x045f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.common.BitMatrix encode(java.lang.String r19, com.google.zxing.BarcodeFormat r20, int r21, int r22, java.util.Map<com.google.zxing.EncodeHintType, ?> r23) {
        /*
            r18 = this;
            r0 = r23
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.AZTEC_LAYERS
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.ERROR_CORRECTION
            com.google.zxing.EncodeHintType r3 = com.google.zxing.EncodeHintType.CHARACTER_SET
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.ISO_8859_1
            r5 = 0
            r6 = 33
            if (r0 == 0) goto L_0x0046
            boolean r7 = r0.containsKey(r3)
            if (r7 == 0) goto L_0x0021
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = r3.toString()
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r3)
        L_0x0021:
            boolean r3 = r0.containsKey(r2)
            if (r3 == 0) goto L_0x0033
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = r2.toString()
            int r6 = java.lang.Integer.parseInt(r2)
        L_0x0033:
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L_0x0046
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = r0.toString()
            int r0 = java.lang.Integer.parseInt(r0)
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.AZTEC
            r2 = r20
            if (r2 != r1) goto L_0x045f
            r1 = r19
            byte[] r1 = r1.getBytes(r4)
            com.google.zxing.aztec.encoder.HighLevelEncoder r2 = new com.google.zxing.aztec.encoder.HighLevelEncoder
            r2.<init>(r1)
            com.google.zxing.aztec.encoder.State r1 = com.google.zxing.aztec.encoder.State.INITIAL_STATE
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r3 = 0
        L_0x005f:
            byte[] r4 = r2.text
            int r7 = r4.length
            r8 = 32
            r9 = 3
            r10 = 10
            r11 = 4
            r12 = 2
            r13 = 1
            if (r3 >= r7) goto L_0x0171
            int r7 = r3 + 1
            int r14 = r4.length
            if (r7 >= r14) goto L_0x0074
            byte r4 = r4[r7]
            goto L_0x0075
        L_0x0074:
            r4 = 0
        L_0x0075:
            byte[] r14 = r2.text
            byte r14 = r14[r3]
            r15 = 13
            if (r14 == r15) goto L_0x0096
            r10 = 44
            if (r14 == r10) goto L_0x0092
            r10 = 46
            if (r14 == r10) goto L_0x008e
            r10 = 58
            if (r14 == r10) goto L_0x008a
            goto L_0x009a
        L_0x008a:
            if (r4 != r8) goto L_0x009a
            r4 = 5
            goto L_0x009b
        L_0x008e:
            if (r4 != r8) goto L_0x009a
            r4 = 3
            goto L_0x009b
        L_0x0092:
            if (r4 != r8) goto L_0x009a
            r4 = 4
            goto L_0x009b
        L_0x0096:
            if (r4 != r10) goto L_0x009a
            r4 = 2
            goto L_0x009b
        L_0x009a:
            r4 = 0
        L_0x009b:
            if (r4 <= 0) goto L_0x00f0
            java.util.LinkedList r8 = new java.util.LinkedList
            r8.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x00a6:
            boolean r10 = r1.hasNext()
            if (r10 == 0) goto L_0x00e9
            java.lang.Object r10 = r1.next()
            com.google.zxing.aztec.encoder.State r10 = (com.google.zxing.aztec.encoder.State) r10
            com.google.zxing.aztec.encoder.State r14 = r10.endBinaryShift(r3)
            com.google.zxing.aztec.encoder.State r15 = r14.latchAndAppend(r11, r4)
            r8.add(r15)
            int r15 = r10.mode
            if (r15 == r11) goto L_0x00c8
            com.google.zxing.aztec.encoder.State r15 = r14.shiftAndAppend(r11, r4)
            r8.add(r15)
        L_0x00c8:
            if (r4 == r9) goto L_0x00cc
            if (r4 != r11) goto L_0x00d9
        L_0x00cc:
            int r15 = 16 - r4
            com.google.zxing.aztec.encoder.State r14 = r14.latchAndAppend(r12, r15)
            com.google.zxing.aztec.encoder.State r14 = r14.latchAndAppend(r12, r13)
            r8.add(r14)
        L_0x00d9:
            int r14 = r10.binaryShiftByteCount
            if (r14 <= 0) goto L_0x00a6
            com.google.zxing.aztec.encoder.State r10 = r10.addBinaryShiftChar(r3)
            com.google.zxing.aztec.encoder.State r10 = r10.addBinaryShiftChar(r7)
            r8.add(r10)
            goto L_0x00a6
        L_0x00e9:
            java.util.Collection r1 = com.google.zxing.aztec.encoder.HighLevelEncoder.simplifyStates(r8)
            r3 = r7
            goto L_0x016e
        L_0x00f0:
            java.util.LinkedList r4 = new java.util.LinkedList
            r4.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x00f9:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x016a
            java.lang.Object r7 = r1.next()
            com.google.zxing.aztec.encoder.State r7 = (com.google.zxing.aztec.encoder.State) r7
            byte[] r8 = r2.text
            byte r8 = r8[r3]
            r8 = r8 & 255(0xff, float:3.57E-43)
            char r8 = (char) r8
            int[][] r9 = com.google.zxing.aztec.encoder.HighLevelEncoder.CHAR_MAP
            int r10 = r7.mode
            r9 = r9[r10]
            r9 = r9[r8]
            if (r9 <= 0) goto L_0x0118
            r9 = 1
            goto L_0x0119
        L_0x0118:
            r9 = 0
        L_0x0119:
            r10 = 0
            r14 = 0
        L_0x011b:
            if (r10 > r11) goto L_0x0152
            int[][] r11 = com.google.zxing.aztec.encoder.HighLevelEncoder.CHAR_MAP
            r11 = r11[r10]
            r11 = r11[r8]
            if (r11 <= 0) goto L_0x014d
            if (r14 != 0) goto L_0x012b
            com.google.zxing.aztec.encoder.State r14 = r7.endBinaryShift(r3)
        L_0x012b:
            if (r9 == 0) goto L_0x0133
            int r15 = r7.mode
            if (r10 == r15) goto L_0x0133
            if (r10 != r12) goto L_0x013a
        L_0x0133:
            com.google.zxing.aztec.encoder.State r12 = r14.latchAndAppend(r10, r11)
            r4.add(r12)
        L_0x013a:
            if (r9 != 0) goto L_0x014d
            int[][] r12 = com.google.zxing.aztec.encoder.HighLevelEncoder.SHIFT_TABLE
            int r15 = r7.mode
            r12 = r12[r15]
            r12 = r12[r10]
            if (r12 < 0) goto L_0x014d
            com.google.zxing.aztec.encoder.State r11 = r14.shiftAndAppend(r10, r11)
            r4.add(r11)
        L_0x014d:
            int r10 = r10 + 1
            r11 = 4
            r12 = 2
            goto L_0x011b
        L_0x0152:
            int r9 = r7.binaryShiftByteCount
            if (r9 > 0) goto L_0x0160
            int[][] r9 = com.google.zxing.aztec.encoder.HighLevelEncoder.CHAR_MAP
            int r10 = r7.mode
            r9 = r9[r10]
            r8 = r9[r8]
            if (r8 != 0) goto L_0x0167
        L_0x0160:
            com.google.zxing.aztec.encoder.State r7 = r7.addBinaryShiftChar(r3)
            r4.add(r7)
        L_0x0167:
            r11 = 4
            r12 = 2
            goto L_0x00f9
        L_0x016a:
            java.util.Collection r1 = com.google.zxing.aztec.encoder.HighLevelEncoder.simplifyStates(r4)
        L_0x016e:
            int r3 = r3 + r13
            goto L_0x005f
        L_0x0171:
            com.google.zxing.aztec.encoder.HighLevelEncoder$1 r3 = new com.google.zxing.aztec.encoder.HighLevelEncoder$1
            r3.<init>(r2)
            java.lang.Object r1 = java.util.Collections.min(r1, r3)
            com.google.zxing.aztec.encoder.State r1 = (com.google.zxing.aztec.encoder.State) r1
            byte[] r2 = r2.text
            if (r1 == 0) goto L_0x045d
            java.util.LinkedList r3 = new java.util.LinkedList
            r3.<init>()
            int r4 = r2.length
            com.google.zxing.aztec.encoder.State r1 = r1.endBinaryShift(r4)
            com.google.zxing.aztec.encoder.Token r1 = r1.token
        L_0x018c:
            if (r1 == 0) goto L_0x0194
            r3.addFirst(r1)
            com.google.zxing.aztec.encoder.Token r1 = r1.previous
            goto L_0x018c
        L_0x0194:
            com.google.zxing.common.BitArray r1 = new com.google.zxing.common.BitArray
            r1.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x019d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01ad
            java.lang.Object r4 = r3.next()
            com.google.zxing.aztec.encoder.Token r4 = (com.google.zxing.aztec.encoder.Token) r4
            r4.appendTo(r1, r2)
            goto L_0x019d
        L_0x01ad:
            int r2 = r1.size
            r3 = 100
            r4 = 11
            int r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline2(r6, r2, r3, r4)
            int r2 = r2 + r3
            if (r0 == 0) goto L_0x020f
            if (r0 >= 0) goto L_0x01be
            r2 = 1
            goto L_0x01bf
        L_0x01be:
            r2 = 0
        L_0x01bf:
            int r6 = java.lang.Math.abs(r0)
            if (r2 == 0) goto L_0x01c6
            r8 = 4
        L_0x01c6:
            if (r6 > r8) goto L_0x01fb
            if (r2 == 0) goto L_0x01cd
            r0 = 88
            goto L_0x01cf
        L_0x01cd:
            r0 = 112(0x70, float:1.57E-43)
        L_0x01cf:
            int r5 = r6 << 4
            int r0 = r0 + r5
            int r0 = r0 * r6
            int[] r5 = com.google.zxing.aztec.encoder.Encoder.WORD_SIZE
            r5 = r5[r6]
            int r7 = r0 % r5
            int r7 = r0 - r7
            com.google.zxing.common.BitArray r1 = com.google.zxing.aztec.encoder.Encoder.stuffBits(r1, r5)
            int r8 = r1.size
            int r3 = r3 + r8
            java.lang.String r9 = "Data to large for user specified layer"
            if (r3 > r7) goto L_0x01f5
            if (r2 == 0) goto L_0x025a
            int r3 = r5 << 6
            if (r8 > r3) goto L_0x01ef
            goto L_0x025a
        L_0x01ef:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r9)
            throw r0
        L_0x01f5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r9)
            throw r0
        L_0x01fb:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.Object[] r2 = new java.lang.Object[r13]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2[r5] = r0
            java.lang.String r0 = "Illegal value %s for layers"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x020f:
            r0 = 0
            r5 = 0
            r6 = 0
        L_0x0212:
            if (r0 > r8) goto L_0x0455
            if (r0 > r9) goto L_0x0218
            r7 = 1
            goto L_0x0219
        L_0x0218:
            r7 = 0
        L_0x0219:
            if (r7 == 0) goto L_0x021e
            int r8 = r0 + 1
            goto L_0x021f
        L_0x021e:
            r8 = r0
        L_0x021f:
            if (r7 == 0) goto L_0x0224
            r10 = 88
            goto L_0x0226
        L_0x0224:
            r10 = 112(0x70, float:1.57E-43)
        L_0x0226:
            int r11 = r8 << 4
            int r10 = r10 + r11
            int r10 = r10 * r8
            if (r2 > r10) goto L_0x0448
            if (r5 == 0) goto L_0x0235
            int[] r11 = com.google.zxing.aztec.encoder.Encoder.WORD_SIZE
            r11 = r11[r8]
            if (r6 == r11) goto L_0x0242
        L_0x0235:
            int[] r5 = com.google.zxing.aztec.encoder.Encoder.WORD_SIZE
            r5 = r5[r8]
            com.google.zxing.common.BitArray r6 = com.google.zxing.aztec.encoder.Encoder.stuffBits(r1, r5)
            r17 = r6
            r6 = r5
            r5 = r17
        L_0x0242:
            int r11 = r10 % r6
            int r11 = r10 - r11
            if (r7 == 0) goto L_0x024e
            int r12 = r5.size
            int r14 = r6 << 6
            if (r12 > r14) goto L_0x0448
        L_0x024e:
            int r12 = r5.size
            int r12 = r12 + r3
            if (r12 <= r11) goto L_0x0255
            goto L_0x0448
        L_0x0255:
            r1 = r5
            r5 = r6
            r2 = r7
            r6 = r8
            r0 = r10
        L_0x025a:
            com.google.zxing.common.BitArray r0 = com.google.zxing.aztec.encoder.Encoder.generateCheckWords(r1, r0, r5)
            int r1 = r1.size
            int r1 = r1 / r5
            com.google.zxing.common.BitArray r3 = new com.google.zxing.common.BitArray
            r3.<init>()
            if (r2 == 0) goto L_0x027c
            int r5 = r6 + -1
            r7 = 2
            r3.appendBits(r5, r7)
            int r1 = r1 + -1
            r5 = 6
            r3.appendBits(r1, r5)
            r1 = 28
            r5 = 4
            com.google.zxing.common.BitArray r1 = com.google.zxing.aztec.encoder.Encoder.generateCheckWords(r3, r1, r5)
            goto L_0x028e
        L_0x027c:
            r5 = 4
            int r7 = r6 + -1
            r8 = 5
            r3.appendBits(r7, r8)
            int r1 = r1 + -1
            r3.appendBits(r1, r4)
            r1 = 40
            com.google.zxing.common.BitArray r1 = com.google.zxing.aztec.encoder.Encoder.generateCheckWords(r3, r1, r5)
        L_0x028e:
            if (r2 == 0) goto L_0x0291
            goto L_0x0293
        L_0x0291:
            r4 = 14
        L_0x0293:
            int r3 = r6 << 2
            int r4 = r4 + r3
            int[] r3 = new int[r4]
            if (r2 == 0) goto L_0x02a4
            r5 = 0
        L_0x029b:
            if (r5 >= r4) goto L_0x02a2
            r3[r5] = r5
            int r5 = r5 + 1
            goto L_0x029b
        L_0x02a2:
            r8 = r4
            goto L_0x02c9
        L_0x02a4:
            int r5 = r4 + 1
            int r7 = r4 / 2
            int r8 = r7 + -1
            int r8 = r8 / 15
            int r8 = r8 * 2
            int r8 = r8 + r5
            int r5 = r8 / 2
            r9 = 0
        L_0x02b2:
            if (r9 >= r7) goto L_0x02c9
            int r10 = r9 / 15
            int r10 = r10 + r9
            int r11 = r7 - r9
            int r11 = r11 - r13
            int r12 = r5 - r10
            int r12 = r12 + -1
            r3[r11] = r12
            int r11 = r7 + r9
            int r10 = r10 + r5
            int r10 = r10 + r13
            r3[r11] = r10
            int r9 = r9 + 1
            goto L_0x02b2
        L_0x02c9:
            com.google.zxing.common.BitMatrix r5 = new com.google.zxing.common.BitMatrix
            r5.<init>(r8, r8)
            r7 = 0
            r9 = 0
        L_0x02d0:
            if (r7 >= r6) goto L_0x0358
            int r10 = r6 - r7
            int r10 = r10 << 2
            if (r2 == 0) goto L_0x02db
            r11 = 9
            goto L_0x02dd
        L_0x02db:
            r11 = 12
        L_0x02dd:
            int r10 = r10 + r11
            r11 = 0
        L_0x02df:
            if (r11 >= r10) goto L_0x0351
            int r12 = r11 << 1
            r13 = 0
        L_0x02e4:
            r14 = 2
            if (r13 >= r14) goto L_0x034e
            int r14 = r9 + r12
            int r14 = r14 + r13
            boolean r14 = r0.get(r14)
            if (r14 == 0) goto L_0x02fc
            int r14 = r7 << 1
            int r15 = r14 + r13
            r15 = r3[r15]
            int r14 = r14 + r11
            r14 = r3[r14]
            r5.set(r15, r14)
        L_0x02fc:
            int r14 = r10 << 1
            int r14 = r14 + r9
            int r14 = r14 + r12
            int r14 = r14 + r13
            boolean r14 = r0.get(r14)
            if (r14 == 0) goto L_0x0318
            int r14 = r7 << 1
            int r15 = r14 + r11
            r15 = r3[r15]
            int r16 = r4 + -1
            int r16 = r16 - r14
            int r16 = r16 - r13
            r14 = r3[r16]
            r5.set(r15, r14)
        L_0x0318:
            int r14 = r10 << 2
            int r14 = r14 + r9
            int r14 = r14 + r12
            int r14 = r14 + r13
            boolean r14 = r0.get(r14)
            if (r14 == 0) goto L_0x0332
            int r14 = r4 + -1
            int r15 = r7 << 1
            int r14 = r14 - r15
            int r15 = r14 - r13
            r15 = r3[r15]
            int r14 = r14 - r11
            r14 = r3[r14]
            r5.set(r15, r14)
        L_0x0332:
            int r14 = r10 * 6
            int r14 = r14 + r9
            int r14 = r14 + r12
            int r14 = r14 + r13
            boolean r14 = r0.get(r14)
            if (r14 == 0) goto L_0x034b
            int r14 = r4 + -1
            int r15 = r7 << 1
            int r14 = r14 - r15
            int r14 = r14 - r11
            r14 = r3[r14]
            int r15 = r15 + r13
            r15 = r3[r15]
            r5.set(r14, r15)
        L_0x034b:
            int r13 = r13 + 1
            goto L_0x02e4
        L_0x034e:
            int r11 = r11 + 1
            goto L_0x02df
        L_0x0351:
            int r10 = r10 << 3
            int r9 = r9 + r10
            int r7 = r7 + 1
            goto L_0x02d0
        L_0x0358:
            int r0 = r8 / 2
            r3 = 7
            if (r2 == 0) goto L_0x0398
            r6 = 0
        L_0x035e:
            if (r6 >= r3) goto L_0x03d8
            int r7 = r0 + -3
            int r7 = r7 + r6
            boolean r9 = r1.get(r6)
            if (r9 == 0) goto L_0x036e
            int r9 = r0 + -5
            r5.set(r7, r9)
        L_0x036e:
            int r9 = r6 + 7
            boolean r9 = r1.get(r9)
            if (r9 == 0) goto L_0x037b
            int r9 = r0 + 5
            r5.set(r9, r7)
        L_0x037b:
            int r9 = 20 - r6
            boolean r9 = r1.get(r9)
            if (r9 == 0) goto L_0x0388
            int r9 = r0 + 5
            r5.set(r7, r9)
        L_0x0388:
            int r9 = 27 - r6
            boolean r9 = r1.get(r9)
            if (r9 == 0) goto L_0x0395
            int r9 = r0 + -5
            r5.set(r9, r7)
        L_0x0395:
            int r6 = r6 + 1
            goto L_0x035e
        L_0x0398:
            r6 = 0
            r7 = 10
        L_0x039b:
            if (r6 >= r7) goto L_0x03d8
            int r9 = r0 + -5
            int r9 = r9 + r6
            int r10 = r6 / 5
            int r10 = r10 + r9
            boolean r9 = r1.get(r6)
            if (r9 == 0) goto L_0x03ae
            int r9 = r0 + -7
            r5.set(r10, r9)
        L_0x03ae:
            int r9 = r6 + 10
            boolean r9 = r1.get(r9)
            if (r9 == 0) goto L_0x03bb
            int r9 = r0 + 7
            r5.set(r9, r10)
        L_0x03bb:
            int r9 = 29 - r6
            boolean r9 = r1.get(r9)
            if (r9 == 0) goto L_0x03c8
            int r9 = r0 + 7
            r5.set(r10, r9)
        L_0x03c8:
            int r9 = 39 - r6
            boolean r9 = r1.get(r9)
            if (r9 == 0) goto L_0x03d5
            int r9 = r0 + -7
            r5.set(r9, r10)
        L_0x03d5:
            int r6 = r6 + 1
            goto L_0x039b
        L_0x03d8:
            if (r2 == 0) goto L_0x03df
            r1 = 5
            com.google.zxing.aztec.encoder.Encoder.drawBullsEye(r5, r0, r1)
            goto L_0x0406
        L_0x03df:
            com.google.zxing.aztec.encoder.Encoder.drawBullsEye(r5, r0, r3)
            r1 = 0
            r2 = 0
        L_0x03e4:
            int r3 = r4 / 2
            int r3 = r3 + -1
            if (r1 >= r3) goto L_0x0406
            r3 = r0 & 1
        L_0x03ec:
            if (r3 >= r8) goto L_0x0401
            int r6 = r0 - r2
            r5.set(r6, r3)
            int r7 = r0 + r2
            r5.set(r7, r3)
            r5.set(r3, r6)
            r5.set(r3, r7)
            int r3 = r3 + 2
            goto L_0x03ec
        L_0x0401:
            int r1 = r1 + 15
            int r2 = r2 + 16
            goto L_0x03e4
        L_0x0406:
            int r0 = r5.width
            int r1 = r5.height
            r7 = r21
            int r2 = java.lang.Math.max(r7, r0)
            r8 = r22
            int r3 = java.lang.Math.max(r8, r1)
            int r4 = r2 / r0
            int r6 = r3 / r1
            int r4 = java.lang.Math.min(r4, r6)
            int r6 = r0 * r4
            int r6 = r2 - r6
            int r6 = r6 / 2
            int r7 = r1 * r4
            int r7 = r3 - r7
            int r7 = r7 / 2
            com.google.zxing.common.BitMatrix r8 = new com.google.zxing.common.BitMatrix
            r8.<init>(r2, r3)
            r2 = 0
        L_0x0430:
            if (r2 >= r1) goto L_0x0447
            r3 = 0
            r9 = r6
        L_0x0434:
            if (r3 >= r0) goto L_0x0443
            boolean r10 = r5.get(r3, r2)
            if (r10 == 0) goto L_0x043f
            r8.setRegion(r9, r7, r4, r4)
        L_0x043f:
            int r3 = r3 + 1
            int r9 = r9 + r4
            goto L_0x0434
        L_0x0443:
            int r2 = r2 + 1
            int r7 = r7 + r4
            goto L_0x0430
        L_0x0447:
            return r8
        L_0x0448:
            r7 = r21
            r8 = r22
            int r0 = r0 + 1
            r10 = 32
            r13 = 1
            r8 = 32
            goto L_0x0212
        L_0x0455:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Data too large for an Aztec code"
            r0.<init>(r1)
            throw r0
        L_0x045d:
            r0 = 0
            throw r0
        L_0x045f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r20)
            java.lang.String r2 = "Can only encode AZTEC, but got "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            goto L_0x0470
        L_0x046f:
            throw r0
        L_0x0470:
            goto L_0x046f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.AztecWriter.encode(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map):com.google.zxing.common.BitMatrix");
    }
}
