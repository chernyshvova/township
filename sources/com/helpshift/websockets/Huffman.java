package com.helpshift.websockets;

public class Huffman {
    public final int mMaxCodeLen;
    public final int[] mMaxCodeValsFromCodeLen;
    public final int mMinCodeLen;
    public final int[] mSymsFromCodeVal;

    public Huffman(int[] iArr) {
        this.mMinCodeLen = Math.max(Misc.min(iArr), 1);
        int max = Misc.max(iArr);
        this.mMaxCodeLen = max;
        Object[] objArr = new Object[2];
        this.mMaxCodeValsFromCodeLen = createMaxCodeValsFromCodeLen(createCountsFromCodeLen(iArr, max), this.mMaxCodeLen, objArr);
        this.mSymsFromCodeVal = createSymsFromCodeVal(iArr, (int[]) objArr[0], ((Integer) objArr[1]).intValue());
    }

    public static int[] createCountsFromCodeLen(int[] iArr, int i) {
        int[] iArr2 = new int[(i + 1)];
        for (int i2 : iArr) {
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }

    public static int[] createIntArray(int i, int i2) {
        int[] iArr = new int[i];
        for (int i3 = 0; i3 < i; i3++) {
            iArr[i3] = i2;
        }
        return iArr;
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [java.lang.Object[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] createMaxCodeValsFromCodeLen(int[] r7, int r8, java.lang.Object[] r9) {
        /*
            r0 = 1
            int r8 = r8 + r0
            r1 = -1
            int[] r1 = createIntArray(r8, r1)
            r2 = 0
            r7[r2] = r2
            int[] r8 = new int[r8]
            r3 = 1
            r4 = 0
            r5 = 0
        L_0x000f:
            int r6 = r7.length
            if (r3 >= r6) goto L_0x0023
            int r4 = r3 + -1
            r4 = r7[r4]
            int r5 = r5 + r4
            int r5 = r5 << r0
            r8[r3] = r5
            r4 = r7[r3]
            int r4 = r4 + r5
            int r4 = r4 - r0
            r1[r3] = r4
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0023:
            r9[r2] = r8
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            r9[r0] = r7
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.Huffman.createMaxCodeValsFromCodeLen(int[], int, java.lang.Object[]):int[]");
    }

    public static int[] createSymsFromCodeVal(int[] iArr, int[] iArr2, int i) {
        int[] iArr3 = new int[(i + 1)];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                int i4 = iArr2[i3];
                iArr2[i3] = i4 + 1;
                iArr3[i4] = i2;
            }
        }
        return iArr3;
    }

    public int readSym(ByteArray byteArray, int[] iArr) throws FormatException {
        int huffmanBits;
        for (int i = this.mMinCodeLen; i <= this.mMaxCodeLen; i++) {
            int i2 = this.mMaxCodeValsFromCodeLen[i];
            if (i2 >= 0 && i2 >= (huffmanBits = byteArray.getHuffmanBits(iArr[0], i))) {
                int i3 = this.mSymsFromCodeVal[huffmanBits];
                iArr[0] = iArr[0] + i;
                return i3;
            }
        }
        throw new FormatException(String.format("[%s] Bad code at the bit index '%d'.", new Object[]{getClass().getSimpleName(), Integer.valueOf(iArr[0])}));
    }
}
