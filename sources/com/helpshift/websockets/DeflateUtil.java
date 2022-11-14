package com.helpshift.websockets;

public class DeflateUtil {
    public static int[] INDICES_FROM_CODE_LENGTH_ORDER = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};

    public static void readCodeLengths(ByteArray byteArray, int[] iArr, int[] iArr2, Huffman huffman) throws FormatException {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        while (i4 < iArr2.length) {
            int readSym = huffman.readSym(byteArray, iArr);
            if (readSym < 0 || readSym > 15) {
                switch (readSym) {
                    case 16:
                        i2 = iArr2[i4 - 1];
                        i = byteArray.readBits(iArr, 2) + 3;
                        break;
                    case 17:
                        i3 = byteArray.readBits(iArr, 3) + 3;
                        break;
                    case 18:
                        i3 = byteArray.readBits(iArr, 7) + 11;
                        break;
                    default:
                        throw new FormatException(String.format("[%s] Bad code length '%d' at the bit index '%d'.", new Object[]{DeflateUtil.class.getSimpleName(), Integer.valueOf(readSym), iArr}));
                }
                i = i3;
                i2 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    iArr2[i4 + i5] = i2;
                }
                i4 += i - 1;
            } else {
                iArr2[i4] = readSym;
            }
            i4++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005b, code lost:
        r0 = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
        r0 = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006b, code lost:
        r0 = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0073, code lost:
        r0 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r0 = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0082, code lost:
        r0 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0089, code lost:
        r0 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0090, code lost:
        r0 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        r0 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a9, code lost:
        return r13.readBits(r14, r0) + r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int readDistance(com.helpshift.websockets.ByteArray r13, int[] r14, com.helpshift.websockets.Huffman r15) throws com.helpshift.websockets.FormatException {
        /*
            int r15 = r15.readSym(r13, r14)
            r0 = 12
            r1 = 11
            r2 = 10
            r3 = 8
            r4 = 6
            r5 = 4
            r6 = 3
            r7 = 13
            r8 = 2
            r9 = 9
            r10 = 7
            r11 = 5
            r12 = 1
            switch(r15) {
                case 0: goto L_0x00aa;
                case 1: goto L_0x00aa;
                case 2: goto L_0x00aa;
                case 3: goto L_0x00aa;
                case 4: goto L_0x00a2;
                case 5: goto L_0x009f;
                case 6: goto L_0x009b;
                case 7: goto L_0x0099;
                case 8: goto L_0x0095;
                case 9: goto L_0x0092;
                case 10: goto L_0x008e;
                case 11: goto L_0x008b;
                case 12: goto L_0x0087;
                case 13: goto L_0x0084;
                case 14: goto L_0x0080;
                case 15: goto L_0x007d;
                case 16: goto L_0x0079;
                case 17: goto L_0x0076;
                case 18: goto L_0x0071;
                case 19: goto L_0x006e;
                case 20: goto L_0x0069;
                case 21: goto L_0x0066;
                case 22: goto L_0x0061;
                case 23: goto L_0x005e;
                case 24: goto L_0x0059;
                case 25: goto L_0x0056;
                case 26: goto L_0x0053;
                case 27: goto L_0x004f;
                case 28: goto L_0x0047;
                case 29: goto L_0x003f;
                default: goto L_0x001a;
            }
        L_0x001a:
            java.lang.Object[] r13 = new java.lang.Object[r6]
            java.lang.Class<com.helpshift.websockets.DeflateUtil> r0 = com.helpshift.websockets.DeflateUtil.class
            java.lang.String r0 = r0.getSimpleName()
            r1 = 0
            r13[r1] = r0
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r13[r12] = r15
            r14 = r14[r1]
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r13[r8] = r14
            java.lang.String r14 = "[%s] Bad distance code '%d' at the bit index '%d'."
            java.lang.String r13 = java.lang.String.format(r14, r13)
            com.helpshift.websockets.FormatException r14 = new com.helpshift.websockets.FormatException
            r14.<init>(r13)
            throw r14
        L_0x003f:
            r15 = 24577(0x6001, float:3.444E-41)
            r0 = 13
            r7 = 24577(0x6001, float:3.444E-41)
            goto L_0x00a4
        L_0x0047:
            r15 = 16385(0x4001, float:2.296E-41)
            r0 = 13
            r7 = 16385(0x4001, float:2.296E-41)
            goto L_0x00a4
        L_0x004f:
            r7 = 12289(0x3001, float:1.722E-41)
            goto L_0x00a4
        L_0x0053:
            r7 = 8193(0x2001, float:1.1481E-41)
            goto L_0x00a4
        L_0x0056:
            r7 = 6145(0x1801, float:8.611E-42)
            goto L_0x005b
        L_0x0059:
            r7 = 4097(0x1001, float:5.741E-42)
        L_0x005b:
            r0 = 11
            goto L_0x00a4
        L_0x005e:
            r7 = 3073(0xc01, float:4.306E-42)
            goto L_0x0063
        L_0x0061:
            r7 = 2049(0x801, float:2.871E-42)
        L_0x0063:
            r0 = 10
            goto L_0x00a4
        L_0x0066:
            r7 = 1537(0x601, float:2.154E-42)
            goto L_0x006b
        L_0x0069:
            r7 = 1025(0x401, float:1.436E-42)
        L_0x006b:
            r0 = 9
            goto L_0x00a4
        L_0x006e:
            r7 = 769(0x301, float:1.078E-42)
            goto L_0x0073
        L_0x0071:
            r7 = 513(0x201, float:7.19E-43)
        L_0x0073:
            r0 = 8
            goto L_0x00a4
        L_0x0076:
            r7 = 385(0x181, float:5.4E-43)
            goto L_0x007b
        L_0x0079:
            r7 = 257(0x101, float:3.6E-43)
        L_0x007b:
            r0 = 7
            goto L_0x00a4
        L_0x007d:
            r7 = 193(0xc1, float:2.7E-43)
            goto L_0x0082
        L_0x0080:
            r7 = 129(0x81, float:1.81E-43)
        L_0x0082:
            r0 = 6
            goto L_0x00a4
        L_0x0084:
            r7 = 97
            goto L_0x0089
        L_0x0087:
            r7 = 65
        L_0x0089:
            r0 = 5
            goto L_0x00a4
        L_0x008b:
            r7 = 49
            goto L_0x0090
        L_0x008e:
            r7 = 33
        L_0x0090:
            r0 = 4
            goto L_0x00a4
        L_0x0092:
            r7 = 25
            goto L_0x0097
        L_0x0095:
            r7 = 17
        L_0x0097:
            r0 = 3
            goto L_0x00a4
        L_0x0099:
            r0 = 2
            goto L_0x00a4
        L_0x009b:
            r0 = 2
            r7 = 9
            goto L_0x00a4
        L_0x009f:
            r0 = 1
            r7 = 7
            goto L_0x00a4
        L_0x00a2:
            r0 = 1
            r7 = 5
        L_0x00a4:
            int r13 = r13.readBits(r14, r0)
            int r13 = r13 + r7
            return r13
        L_0x00aa:
            int r15 = r15 + r12
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.DeflateUtil.readDistance(com.helpshift.websockets.ByteArray, int[], com.helpshift.websockets.Huffman):int");
    }

    public static void readDynamicTables(ByteArray byteArray, int[] iArr, Huffman[] huffmanArr) throws FormatException {
        int readBits = byteArray.readBits(iArr, 5) + 257;
        int readBits2 = byteArray.readBits(iArr, 5) + 1;
        int readBits3 = byteArray.readBits(iArr, 4) + 4;
        int[] iArr2 = new int[19];
        for (int i = 0; i < readBits3; i++) {
            iArr2[INDICES_FROM_CODE_LENGTH_ORDER[i]] = (byte) byteArray.readBits(iArr, 3);
        }
        Huffman huffman = new Huffman(iArr2);
        int[] iArr3 = new int[readBits];
        readCodeLengths(byteArray, iArr, iArr3, huffman);
        Huffman huffman2 = new Huffman(iArr3);
        int[] iArr4 = new int[readBits2];
        readCodeLengths(byteArray, iArr, iArr4, huffman);
        Huffman huffman3 = new Huffman(iArr4);
        huffmanArr[0] = huffman2;
        huffmanArr[1] = huffman3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        r0 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        r0 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        r0 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0074, code lost:
        return r5.readBits(r6, r0) + r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int readLength(com.helpshift.websockets.ByteArray r5, int[] r6, int r7) throws com.helpshift.websockets.FormatException {
        /*
            r0 = 5
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r7) {
                case 257: goto L_0x0075;
                case 258: goto L_0x0075;
                case 259: goto L_0x0075;
                case 260: goto L_0x0075;
                case 261: goto L_0x0075;
                case 262: goto L_0x0075;
                case 263: goto L_0x0075;
                case 264: goto L_0x0075;
                case 265: goto L_0x006c;
                case 266: goto L_0x0069;
                case 267: goto L_0x0066;
                case 268: goto L_0x0063;
                case 269: goto L_0x005f;
                case 270: goto L_0x005c;
                case 271: goto L_0x0059;
                case 272: goto L_0x0056;
                case 273: goto L_0x0052;
                case 274: goto L_0x004f;
                case 275: goto L_0x004c;
                case 276: goto L_0x0049;
                case 277: goto L_0x0045;
                case 278: goto L_0x0042;
                case 279: goto L_0x003f;
                case 280: goto L_0x003c;
                case 281: goto L_0x0039;
                case 282: goto L_0x0036;
                case 283: goto L_0x0033;
                case 284: goto L_0x0030;
                case 285: goto L_0x002d;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.Class<com.helpshift.websockets.DeflateUtil> r0 = com.helpshift.websockets.DeflateUtil.class
            java.lang.String r0 = r0.getSimpleName()
            r1 = 0
            r5[r1] = r0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5[r4] = r7
            r6 = r6[r1]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r3] = r6
            java.lang.String r6 = "[%s] Bad literal/length code '%d' at the bit index '%d'."
            java.lang.String r5 = java.lang.String.format(r6, r5)
            com.helpshift.websockets.FormatException r6 = new com.helpshift.websockets.FormatException
            r6.<init>(r5)
            throw r6
        L_0x002d:
            r5 = 258(0x102, float:3.62E-43)
            return r5
        L_0x0030:
            r7 = 227(0xe3, float:3.18E-43)
            goto L_0x006f
        L_0x0033:
            r7 = 195(0xc3, float:2.73E-43)
            goto L_0x006f
        L_0x0036:
            r7 = 163(0xa3, float:2.28E-43)
            goto L_0x006f
        L_0x0039:
            r7 = 131(0x83, float:1.84E-43)
            goto L_0x006f
        L_0x003c:
            r7 = 115(0x73, float:1.61E-43)
            goto L_0x0047
        L_0x003f:
            r7 = 99
            goto L_0x0047
        L_0x0042:
            r7 = 83
            goto L_0x0047
        L_0x0045:
            r7 = 67
        L_0x0047:
            r0 = 4
            goto L_0x006f
        L_0x0049:
            r7 = 59
            goto L_0x0054
        L_0x004c:
            r7 = 51
            goto L_0x0054
        L_0x004f:
            r7 = 43
            goto L_0x0054
        L_0x0052:
            r7 = 35
        L_0x0054:
            r0 = 3
            goto L_0x006f
        L_0x0056:
            r7 = 31
            goto L_0x0061
        L_0x0059:
            r7 = 27
            goto L_0x0061
        L_0x005c:
            r7 = 23
            goto L_0x0061
        L_0x005f:
            r7 = 19
        L_0x0061:
            r0 = 2
            goto L_0x006f
        L_0x0063:
            r7 = 17
            goto L_0x006e
        L_0x0066:
            r7 = 15
            goto L_0x006e
        L_0x0069:
            r7 = 13
            goto L_0x006e
        L_0x006c:
            r7 = 11
        L_0x006e:
            r0 = 1
        L_0x006f:
            int r5 = r5.readBits(r6, r0)
            int r5 = r5 + r7
            return r5
        L_0x0075:
            int r7 = r7 + -254
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.DeflateUtil.readLength(com.helpshift.websockets.ByteArray, int[], int):int");
    }
}
