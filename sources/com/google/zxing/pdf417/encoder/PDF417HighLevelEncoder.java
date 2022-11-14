package com.google.zxing.pdf417.encoder;

import com.facebook.appevents.AppEventsConstants;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.playrix.gplay.billing.Base64;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public final class PDF417HighLevelEncoder {
    public static final Charset DEFAULT_ENCODING = StandardCharsets.ISO_8859_1;
    public static final byte[] MIXED = new byte[128];
    public static final byte[] PUNCTUATION = new byte[128];
    public static final byte[] TEXT_MIXED_RAW = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, Base64.EQUALS_SIGN, 94, 0, 32, 0, 0, 0};
    public static final byte[] TEXT_PUNCTUATION_RAW = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    static {
        Arrays.fill(MIXED, (byte) -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = TEXT_MIXED_RAW;
            if (i2 >= bArr.length) {
                break;
            }
            byte b = bArr[i2];
            if (b > 0) {
                MIXED[b] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        while (true) {
            byte[] bArr2 = TEXT_PUNCTUATION_RAW;
            if (i < bArr2.length) {
                byte b2 = bArr2[i];
                if (b2 > 0) {
                    PUNCTUATION[b2] = (byte) i;
                }
                i++;
            } else {
                return;
            }
        }
    }

    public static void encodeBinary(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            sb.append(913);
        } else if (i2 % 6 == 0) {
            sb.append(924);
        } else {
            sb.append(901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & Base64.EQUALS_SIGN_ENC));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            sb.append((char) (bArr[i4] & Base64.EQUALS_SIGN_ENC));
            i4++;
        }
    }

    public static String encodeHighLevel(String str, Compaction compaction, Charset charset) throws WriterException {
        int i;
        int i2;
        CharacterSetECI characterSetECI;
        String str2 = str;
        Charset charset2 = charset;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset2 == null) {
            charset2 = DEFAULT_ENCODING;
        } else if (!DEFAULT_ENCODING.equals(charset2) && (characterSetECI = CharacterSetECI.NAME_TO_ECI.get(charset.name())) != null) {
            int i3 = characterSetECI.values[0];
            if (i3 >= 0 && i3 < 900) {
                sb.append(927);
                sb.append((char) i3);
            } else if (i3 < 810900) {
                sb.append(926);
                sb.append((char) ((i3 / 900) - 1));
                sb.append((char) (i3 % 900));
            } else if (i3 < 811800) {
                sb.append(925);
                sb.append((char) (810900 - i3));
            } else {
                throw new WriterException("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i3)));
            }
        }
        int length = str.length();
        int ordinal = compaction.ordinal();
        if (ordinal == 1) {
            encodeText(str2, 0, length, sb, 0);
        } else if (ordinal != 2) {
            char c = 902;
            if (ordinal != 3) {
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (i4 < length) {
                    int length2 = str.length();
                    if (i4 < length2) {
                        char charAt = str2.charAt(i4);
                        int i7 = i4;
                        i = 0;
                        while (isDigit(charAt) && i7 < length2) {
                            i++;
                            i7++;
                            if (i7 < length2) {
                                charAt = str2.charAt(i7);
                            }
                        }
                    } else {
                        i = 0;
                    }
                    if (i >= 13) {
                        sb.append(c);
                        encodeNumeric(str2, i4, i, sb);
                        i4 += i;
                        i5 = 0;
                        i6 = 2;
                    } else {
                        int length3 = str.length();
                        int i8 = i4;
                        while (true) {
                            if (i8 >= length3) {
                                break;
                            }
                            char charAt2 = str2.charAt(i8);
                            int i9 = 0;
                            while (i9 < 13 && isDigit(charAt2) && i8 < length3) {
                                i9++;
                                i8++;
                                if (i8 < length3) {
                                    charAt2 = str2.charAt(i8);
                                }
                            }
                            if (i9 >= 13) {
                                i2 = (i8 - i4) - i9;
                                break;
                            } else if (i9 <= 0) {
                                char charAt3 = str2.charAt(i8);
                                if (!(charAt3 == 9 || charAt3 == 10 || charAt3 == 13 || (charAt3 >= ' ' && charAt3 <= '~'))) {
                                    break;
                                }
                                i8++;
                            }
                        }
                        i2 = i8 - i4;
                        if (i2 >= 5 || i == length) {
                            if (i6 != 0) {
                                sb.append(900);
                                i5 = 0;
                                i6 = 0;
                            }
                            int encodeText = encodeText(str2, i4, i2, sb, i5);
                            i4 += i2;
                            i5 = encodeText;
                        } else {
                            CharsetEncoder newEncoder = charset2.newEncoder();
                            int length4 = str.length();
                            int i10 = i4;
                            while (i10 < length4) {
                                char charAt4 = str2.charAt(i10);
                                int i11 = 0;
                                while (i11 < 13 && isDigit(charAt4)) {
                                    i11++;
                                    int i12 = i10 + i11;
                                    if (i12 >= length4) {
                                        break;
                                    }
                                    charAt4 = str2.charAt(i12);
                                }
                                if (i11 >= 13) {
                                    break;
                                }
                                char charAt5 = str2.charAt(i10);
                                if (newEncoder.canEncode(charAt5)) {
                                    i10++;
                                } else {
                                    throw new WriterException("Non-encodable character detected: " + charAt5 + " (Unicode: " + charAt5 + ')');
                                }
                            }
                            int i13 = i10 - i4;
                            if (i13 == 0) {
                                i13 = 1;
                            }
                            int i14 = i13 + i4;
                            byte[] bytes = str2.substring(i4, i14).getBytes(charset2);
                            if (bytes.length == 1 && i6 == 0) {
                                encodeBinary(bytes, 0, 1, 0, sb);
                            } else {
                                encodeBinary(bytes, 0, bytes.length, i6, sb);
                                i5 = 0;
                                i6 = 1;
                            }
                            i4 = i14;
                        }
                        c = 902;
                    }
                }
            } else {
                sb.append(902);
                encodeNumeric(str2, 0, length, sb);
            }
        } else {
            byte[] bytes2 = str2.getBytes(charset2);
            encodeBinary(bytes2, 0, bytes2.length, 1, sb);
        }
        return sb.toString();
    }

    public static void encodeNumeric(String str, int i, int i2, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int min = Math.min(44, i2 - i3);
            StringBuilder sb3 = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            int i4 = i + i3;
            sb3.append(str.substring(i4, i4 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            int length = sb2.length();
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                sb.append(sb2.charAt(length));
            }
            i3 += min;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0101 A[EDGE_INSN: B:75:0x0101->B:60:0x0101 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0011 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int encodeText(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = r20
            r8 = 0
        L_0x0011:
            int r9 = r17 + r8
            char r10 = r0.charAt(r9)
            r11 = 26
            r12 = 32
            r13 = 28
            r14 = 27
            r15 = 29
            if (r7 == 0) goto L_0x00c7
            if (r7 == r6) goto L_0x008e
            r11 = -1
            if (r7 == r4) goto L_0x0041
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            if (r9 == r11) goto L_0x0030
            r9 = 1
            goto L_0x0031
        L_0x0030:
            r9 = 0
        L_0x0031:
            if (r9 == 0) goto L_0x003d
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00fd
        L_0x003d:
            r3.append(r15)
            goto L_0x005a
        L_0x0041:
            boolean r12 = isMixed(r10)
            if (r12 == 0) goto L_0x0051
            byte[] r9 = MIXED
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00fd
        L_0x0051:
            boolean r12 = isAlphaUpper(r10)
            if (r12 == 0) goto L_0x005c
            r3.append(r13)
        L_0x005a:
            r7 = 0
            goto L_0x0011
        L_0x005c:
            boolean r12 = isAlphaLower(r10)
            if (r12 == 0) goto L_0x0067
            r3.append(r14)
            goto L_0x00e3
        L_0x0067:
            int r9 = r9 + 1
            if (r9 >= r1) goto L_0x0081
            char r9 = r0.charAt(r9)
            byte[] r12 = PUNCTUATION
            byte r9 = r12[r9]
            if (r9 == r11) goto L_0x0077
            r9 = 1
            goto L_0x0078
        L_0x0077:
            r9 = 0
        L_0x0078:
            if (r9 == 0) goto L_0x0081
            r7 = 3
            r9 = 25
            r3.append(r9)
            goto L_0x0011
        L_0x0081:
            r3.append(r15)
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00fd
        L_0x008e:
            boolean r9 = isAlphaLower(r10)
            if (r9 == 0) goto L_0x00a1
            if (r10 != r12) goto L_0x009a
            r3.append(r11)
            goto L_0x00fd
        L_0x009a:
            int r10 = r10 + -97
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00fd
        L_0x00a1:
            boolean r9 = isAlphaUpper(r10)
            if (r9 == 0) goto L_0x00b1
            r3.append(r14)
            int r10 = r10 + -65
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00fd
        L_0x00b1:
            boolean r9 = isMixed(r10)
            if (r9 == 0) goto L_0x00bb
            r3.append(r13)
            goto L_0x00ef
        L_0x00bb:
            r3.append(r15)
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00fd
        L_0x00c7:
            boolean r9 = isAlphaUpper(r10)
            if (r9 == 0) goto L_0x00da
            if (r10 != r12) goto L_0x00d3
            r3.append(r11)
            goto L_0x00fd
        L_0x00d3:
            int r10 = r10 + -65
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00fd
        L_0x00da:
            boolean r9 = isAlphaLower(r10)
            if (r9 == 0) goto L_0x00e6
            r3.append(r14)
        L_0x00e3:
            r7 = 1
            goto L_0x0011
        L_0x00e6:
            boolean r9 = isMixed(r10)
            if (r9 == 0) goto L_0x00f2
            r3.append(r13)
        L_0x00ef:
            r7 = 2
            goto L_0x0011
        L_0x00f2:
            r3.append(r15)
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
        L_0x00fd:
            int r8 = r8 + 1
            if (r8 < r1) goto L_0x0011
            int r0 = r3.length()
            r1 = 0
            r8 = 0
        L_0x0107:
            if (r1 >= r0) goto L_0x0125
            int r9 = r1 % 2
            if (r9 == 0) goto L_0x010f
            r9 = 1
            goto L_0x0110
        L_0x010f:
            r9 = 0
        L_0x0110:
            if (r9 == 0) goto L_0x011e
            int r8 = r8 * 30
            char r9 = r3.charAt(r1)
            int r9 = r9 + r8
            char r8 = (char) r9
            r2.append(r8)
            goto L_0x0122
        L_0x011e:
            char r8 = r3.charAt(r1)
        L_0x0122:
            int r1 = r1 + 1
            goto L_0x0107
        L_0x0125:
            int r0 = r0 % r4
            if (r0 == 0) goto L_0x012f
            int r8 = r8 * 30
            int r8 = r8 + r15
            char r0 = (char) r8
            r2.append(r0)
        L_0x012f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeText(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    public static boolean isAlphaLower(char c) {
        if (c != ' ') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    public static boolean isAlphaUpper(char c) {
        if (c != ' ') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isMixed(char c) {
        return MIXED[c] != -1;
    }
}
