package com.applovin.impl.sdk.utils;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.security.CertificateUtil;
import com.playrix.gplay.billing.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.applovin.impl.sdk.utils.l */
public class C1302l {
    /* renamed from: a */
    public static String m2599a(String str, String str2) {
        return m2602a(str, str2, new byte[]{-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77});
    }

    /* renamed from: a */
    public static String m2600a(String str, String str2, long j) {
        return m2601a(str, str2, j, new byte[]{-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77});
    }

    /* renamed from: a */
    public static String m2601a(String str, String str2, long j, byte[] bArr) {
        String str3 = str;
        String str4 = str2;
        byte[] bArr2 = bArr;
        if (str4 == null) {
            throw new IllegalArgumentException("No SDK key specified");
        } else if (str2.length() < 80) {
            throw new IllegalArgumentException("SDK key is too short");
        } else if (bArr2 != null) {
            char c = ' ';
            if (bArr2.length < 32) {
                throw new IllegalArgumentException("Salt is too short");
            } else if (str3 == null || str.isEmpty()) {
                return str3;
            } else {
                try {
                    String substring = str4.substring(32);
                    String substring2 = str4.substring(0, 32);
                    byte[] bytes = str3.getBytes("UTF-8");
                    byte[] a = m2605a(substring2, bArr2);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(((byte) ((int) ((j >> 0) & 255))) ^ a[0]);
                    byteArrayOutputStream.write(((byte) ((int) ((j >> 8) & 255))) ^ a[1]);
                    byteArrayOutputStream.write(((byte) ((int) ((j >> 16) & 255))) ^ a[2]);
                    byteArrayOutputStream.write(((byte) ((int) ((j >> 24) & 255))) ^ a[3]);
                    byteArrayOutputStream.write(((byte) ((int) ((j >> 32) & 255))) ^ a[4]);
                    byteArrayOutputStream.write(((byte) ((int) ((j >> 40) & 255))) ^ a[5]);
                    byteArrayOutputStream.write(((byte) ((int) ((j >> 48) & 255))) ^ a[6]);
                    byteArrayOutputStream.write(((byte) ((int) ((j >> 56) & 255))) ^ a[7]);
                    int i = 0;
                    while (i < bytes.length) {
                        long j2 = j + ((long) i);
                        long j3 = (j2 ^ (j2 >> 33)) * -4417276706812531889L;
                        long j4 = (j3 ^ (j3 >> 29)) * -8796714831421723037L;
                        long j5 = j4 ^ (j4 >> c);
                        int i2 = i + 0;
                        byteArrayOutputStream.write((byte) ((int) (((long) ((i2 >= bytes.length ? 0 : bytes[i2]) ^ a[i2 % a.length])) ^ ((j5 >> 0) & 255))));
                        int i3 = i + 1;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a[i3 % a.length] ^ (i3 >= bytes.length ? 0 : bytes[i3]))) ^ ((j5 >> 8) & 255))));
                        int i4 = i + 2;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a[i4 % a.length] ^ (i4 >= bytes.length ? 0 : bytes[i4]))) ^ ((j5 >> 16) & 255))));
                        int i5 = i + 3;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a[i5 % a.length] ^ (i5 >= bytes.length ? 0 : bytes[i5]))) ^ ((j5 >> 24) & 255))));
                        int i6 = i + 4;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a[i6 % a.length] ^ (i6 >= bytes.length ? 0 : bytes[i6]))) ^ ((j5 >> 32) & 255))));
                        int i7 = i + 5;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a[i7 % a.length] ^ (i7 >= bytes.length ? 0 : bytes[i7]))) ^ ((j5 >> 40) & 255))));
                        int i8 = i + 6;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a[i8 % a.length] ^ (i8 >= bytes.length ? 0 : bytes[i8]))) ^ ((j5 >> 48) & 255))));
                        int i9 = i + 7;
                        byteArrayOutputStream.write((byte) ((int) (((long) (a[i9 % a.length] ^ (i9 >= bytes.length ? 0 : bytes[i9]))) ^ ((j5 >> 56) & 255))));
                        i += 8;
                        c = ' ';
                    }
                    String b = m2607b(byteArrayOutputStream.toByteArray());
                    String a2 = m2603a(bArr);
                    return "1:" + a2 + CertificateUtil.DELIMITER + substring + CertificateUtil.DELIMITER + b;
                } catch (IOException unused) {
                    return null;
                }
            }
        } else {
            throw new IllegalArgumentException("No salt specified");
        }
    }

    /* renamed from: a */
    public static String m2602a(String str, String str2, byte[] bArr) {
        String str3 = str;
        String str4 = str2;
        byte[] bArr2 = bArr;
        if (str4 == null) {
            throw new IllegalArgumentException("No SDK key specified");
        } else if (str2.length() < 80) {
            throw new IllegalArgumentException("SDK key is too short");
        } else if (bArr2 != null) {
            char c = ' ';
            if (bArr2.length < 32) {
                throw new IllegalArgumentException("Salt is too short");
            } else if (TextUtils.isEmpty(str) || str.trim().startsWith("{")) {
                return str3;
            } else {
                String[] split = str3.split(CertificateUtil.DELIMITER);
                char c2 = 0;
                try {
                    if (!AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(split[0])) {
                        return null;
                    }
                    if (split.length != 4) {
                        return null;
                    }
                    char c3 = 1;
                    String str5 = split[1];
                    String str6 = split[2];
                    byte[] a = m2604a(split[3]);
                    if (!str4.endsWith(str6)) {
                        return null;
                    }
                    if (!m2603a(bArr).equals(str5)) {
                        return null;
                    }
                    byte[] a2 = m2605a(str4.substring(0, 32), bArr2);
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a);
                    char c4 = 8;
                    try {
                        long read = (((long) ((byteArrayInputStream.read() ^ a2[5]) & Base64.EQUALS_SIGN_ENC)) << 40) | (((long) ((byteArrayInputStream.read() ^ a2[0]) & Base64.EQUALS_SIGN_ENC)) << 0) | (((long) ((byteArrayInputStream.read() ^ a2[1]) & Base64.EQUALS_SIGN_ENC)) << 8) | (((long) ((byteArrayInputStream.read() ^ a2[2]) & Base64.EQUALS_SIGN_ENC)) << 16) | (((long) ((byteArrayInputStream.read() ^ a2[3]) & Base64.EQUALS_SIGN_ENC)) << 24) | (((long) ((byteArrayInputStream.read() ^ a2[4]) & Base64.EQUALS_SIGN_ENC)) << 32) | (((long) ((byteArrayInputStream.read() ^ a2[6]) & Base64.EQUALS_SIGN_ENC)) << 48) | (((long) ((byteArrayInputStream.read() ^ a2[7]) & Base64.EQUALS_SIGN_ENC)) << 56);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr3 = new byte[8];
                        int read2 = byteArrayInputStream.read(bArr3);
                        int i = 0;
                        while (read2 >= 0) {
                            long j = ((long) i) + read;
                            long j2 = (j ^ (j >> 33)) * -4417276706812531889L;
                            long j3 = (j2 ^ (j2 >> 29)) * -8796714831421723037L;
                            long j4 = j3 ^ (j3 >> c);
                            byteArrayOutputStream.write((byte) ((int) (((long) (bArr3[c2] ^ a2[(i + 0) % a2.length])) ^ ((j4 >> c2) & 255))));
                            byteArrayOutputStream.write((byte) ((int) (((long) (bArr3[c3] ^ a2[(i + 1) % a2.length])) ^ ((j4 >> c4) & 255))));
                            long j5 = read;
                            byteArrayOutputStream.write((byte) ((int) (((long) (a2[(i + 2) % a2.length] ^ bArr3[2])) ^ ((j4 >> 16) & 255))));
                            byteArrayOutputStream.write((byte) ((int) (((long) (bArr3[3] ^ a2[(i + 3) % a2.length])) ^ ((j4 >> 24) & 255))));
                            byteArrayOutputStream.write((byte) ((int) (((long) (a2[(i + 4) % a2.length] ^ bArr3[4])) ^ ((j4 >> c) & 255))));
                            byteArrayOutputStream.write((byte) ((int) (((long) (bArr3[5] ^ a2[(i + 5) % a2.length])) ^ ((j4 >> 40) & 255))));
                            byteArrayOutputStream.write((byte) ((int) (((long) (a2[(i + 6) % a2.length] ^ bArr3[6])) ^ ((j4 >> 48) & 255))));
                            byteArrayOutputStream.write((byte) ((int) (((long) (a2[(i + 7) % a2.length] ^ bArr3[7])) ^ ((j4 >> 56) & 255))));
                            i += 8;
                            read2 = byteArrayInputStream.read(bArr3);
                            read = j5;
                            c4 = 8;
                            c2 = 0;
                            c = ' ';
                            c3 = 1;
                        }
                        return new String(byteArrayOutputStream.toByteArray(), "UTF-8").trim();
                    } catch (IOException unused) {
                        return null;
                    }
                } catch (IOException unused2) {
                    return null;
                }
            }
        } else {
            throw new IllegalArgumentException("No salt specified");
        }
    }

    /* renamed from: a */
    public static String m2603a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Utility.HASH_ALGORITHM_SHA1);
            instance.update(bArr);
            return StringUtils.toHexString(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 algorithm not found", e);
        }
    }

    /* renamed from: a */
    public static byte[] m2604a(String str) {
        return android.util.Base64.decode(m2606b(str), 0);
    }

    /* renamed from: a */
    public static byte[] m2605a(String str, byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Utility.HASH_ALGORITHM_SHA256);
            instance.update(bArr);
            instance.update(str.getBytes("UTF-8"));
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 algorithm not found", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 encoding not found", e2);
        }
    }

    /* renamed from: b */
    public static String m2606b(String str) {
        return str.replace('-', '+').replace('_', '/').replace('*', '=');
    }

    /* renamed from: b */
    public static String m2607b(byte[] bArr) throws UnsupportedEncodingException {
        return m2608c(android.util.Base64.encode(bArr, 2));
    }

    /* renamed from: c */
    public static String m2608c(byte[] bArr) throws UnsupportedEncodingException {
        return new String(bArr, "UTF-8").replace('+', '-').replace('/', '_').replace('=', '*');
    }
}
