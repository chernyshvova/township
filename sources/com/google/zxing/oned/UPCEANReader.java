package com.google.zxing.oned;

import com.google.zxing.FormatException;
import com.google.zxing.ReaderException;

public abstract class UPCEANReader extends OneDReader {
    public static final int[] END_PATTERN = {1, 1, 1, 1, 1, 1};
    public static final int[][] L_AND_G_PATTERNS;
    public static final int[][] L_PATTERNS;
    public static final int[] MIDDLE_PATTERN = {1, 1, 1, 1, 1};
    public static final int[] START_END_PATTERN = {1, 1, 1};

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        L_PATTERNS = iArr;
        int[][] iArr2 = new int[20][];
        L_AND_G_PATTERNS = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = L_PATTERNS[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            L_AND_G_PATTERNS[i] = iArr4;
        }
    }

    public static boolean checkStandardUPCEANChecksum(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return getStandardUPCEANChecksum(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    public static int getStandardUPCEANChecksum(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int charAt = charSequence.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw (ReaderException.isStackTrace ? new FormatException() : FormatException.INSTANCE);
            }
            i += charAt;
        }
        int i3 = i * 3;
        while (true) {
            length -= 2;
            if (length < 0) {
                return (1000 - i3) % 10;
            }
            int charAt2 = charSequence.charAt(length) - '0';
            if (charAt2 >= 0 && charAt2 <= 9) {
                i3 += charAt2;
            }
        }
        throw (ReaderException.isStackTrace ? new FormatException() : FormatException.INSTANCE);
    }
}
