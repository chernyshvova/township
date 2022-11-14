package com.helpshift.websockets;

public class FixedLiteralLengthHuffman extends Huffman {
    public static final FixedLiteralLengthHuffman INSTANCE = new FixedLiteralLengthHuffman();

    public FixedLiteralLengthHuffman() {
        super(buildCodeLensFromSym());
    }

    public static int[] buildCodeLensFromSym() {
        int[] iArr = new int[288];
        int i = 0;
        while (i < 144) {
            iArr[i] = 8;
            i++;
        }
        while (i < 256) {
            iArr[i] = 9;
            i++;
        }
        while (i < 280) {
            iArr[i] = 7;
            i++;
        }
        while (i < 288) {
            iArr[i] = 8;
            i++;
        }
        return iArr;
    }

    public static FixedLiteralLengthHuffman getInstance() {
        return INSTANCE;
    }
}
