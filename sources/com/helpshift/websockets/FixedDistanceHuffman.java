package com.helpshift.websockets;

public class FixedDistanceHuffman extends Huffman {
    public static final FixedDistanceHuffman INSTANCE = new FixedDistanceHuffman();

    public FixedDistanceHuffman() {
        super(buildCodeLensFromSym());
    }

    public static int[] buildCodeLensFromSym() {
        int[] iArr = new int[32];
        for (int i = 0; i < 32; i++) {
            iArr[i] = 5;
        }
        return iArr;
    }

    public static FixedDistanceHuffman getInstance() {
        return INSTANCE;
    }
}
