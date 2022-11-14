package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

public final class ByteMatrix {
    public final byte[][] bytes;
    public final int height;
    public final int width;

    public ByteMatrix(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = i;
        iArr[0] = i2;
        this.bytes = (byte[][]) Array.newInstance(byte.class, iArr);
        this.width = i;
        this.height = i2;
    }

    public byte get(int i, int i2) {
        return this.bytes[i2][i];
    }

    public void set(int i, int i2, int i3) {
        this.bytes[i2][i] = (byte) i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
        for (int i = 0; i < this.height; i++) {
            byte[] bArr = this.bytes[i];
            for (int i2 = 0; i2 < this.width; i2++) {
                byte b = bArr[i2];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append(10);
        }
        return sb.toString();
    }

    public void set(int i, int i2, boolean z) {
        this.bytes[i2][i] = z ? (byte) 1 : 0;
    }
}
