package com.appsflyer.internal;

import com.playrix.gplay.billing.Base64;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.appsflyer.internal.bx */
public final class C1464bx extends FilterInputStream {
    public final int AFInAppEventParameterName;
    public byte[] AFInAppEventType;
    public short AFKeystoreWrapper;
    public int AFVersionDeclaration;
    public int getLevel;
    public int init = Integer.MAX_VALUE;
    public long[] valueOf;
    public long[] values;

    public C1464bx(InputStream inputStream, int i, int i2, short s, int i3, int i4) throws IOException {
        super(inputStream);
        int min = Math.min(Math.max(s, 4), 8);
        this.AFInAppEventParameterName = min;
        this.AFInAppEventType = new byte[min];
        this.values = new long[4];
        this.valueOf = new long[4];
        this.getLevel = min;
        this.AFVersionDeclaration = min;
        this.values = C1467ca.values(i ^ i4, min ^ i4);
        this.valueOf = C1467ca.values(i2 ^ i4, i3 ^ i4);
    }

    private void valueOf() {
        long[] jArr = this.values;
        long[] jArr2 = this.valueOf;
        short s = this.AFKeystoreWrapper;
        int i = (s + 2) % 4;
        int i2 = (s + 3) % 4;
        jArr2[i2] = ((jArr[i2] * 2147483085) + jArr2[i]) / 2147483647L;
        jArr[i2] = ((jArr[s % 4] * 2147483085) + jArr2[i]) % 2147483647L;
        for (int i3 = 0; i3 < this.AFInAppEventParameterName; i3++) {
            byte[] bArr = this.AFInAppEventType;
            bArr[i3] = (byte) ((int) (((long) bArr[i3]) ^ ((this.values[this.AFKeystoreWrapper] >> (i3 << 3)) & 255)));
        }
        this.AFKeystoreWrapper = (short) ((this.AFKeystoreWrapper + 1) % 4);
    }

    private int values() throws IOException {
        int read;
        int i;
        if (this.init == Integer.MAX_VALUE) {
            this.init = this.in.read();
        }
        if (this.getLevel == this.AFInAppEventParameterName) {
            byte[] bArr = this.AFInAppEventType;
            int i2 = this.init;
            bArr[0] = (byte) i2;
            if (i2 >= 0) {
                int i3 = 1;
                do {
                    read = this.in.read(this.AFInAppEventType, i3, this.AFInAppEventParameterName - i3);
                    if (read <= 0 || (i3 = i3 + read) >= this.AFInAppEventParameterName) {
                    }
                    read = this.in.read(this.AFInAppEventType, i3, this.AFInAppEventParameterName - i3);
                    break;
                } while ((i3 = i3 + read) >= this.AFInAppEventParameterName);
                if (i3 >= this.AFInAppEventParameterName) {
                    valueOf();
                    int read2 = this.in.read();
                    this.init = read2;
                    this.getLevel = 0;
                    if (read2 < 0) {
                        int i4 = this.AFInAppEventParameterName;
                        i = i4 - (this.AFInAppEventType[i4 - 1] & Base64.EQUALS_SIGN_ENC);
                    } else {
                        i = this.AFInAppEventParameterName;
                    }
                    this.AFVersionDeclaration = i;
                } else {
                    throw new IllegalStateException("unexpected block size");
                }
            } else {
                throw new IllegalStateException("unexpected block size");
            }
        }
        return this.AFVersionDeclaration;
    }

    public final int available() throws IOException {
        values();
        return this.AFVersionDeclaration - this.getLevel;
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        values();
        int i = this.getLevel;
        if (i >= this.AFVersionDeclaration) {
            return -1;
        }
        byte[] bArr = this.AFInAppEventType;
        this.getLevel = i + 1;
        return bArr[i] & Base64.EQUALS_SIGN_ENC;
    }

    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3) {
            values();
            int i5 = this.getLevel;
            if (i5 < this.AFVersionDeclaration) {
                byte[] bArr2 = this.AFInAppEventType;
                this.getLevel = i5 + 1;
                bArr[i4] = bArr2[i5];
                i4++;
            } else if (i4 == i) {
                return -1;
            } else {
                return i2 - (i3 - i4);
            }
        }
        return i2;
    }
}
