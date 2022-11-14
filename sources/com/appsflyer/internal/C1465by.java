package com.appsflyer.internal;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.playrix.gplay.billing.Base64;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.appsflyer.internal.by */
public final class C1465by extends FilterInputStream {
    public static final short values = ((short) ((int) (Math.pow(2.0d, 15.0d) * (Math.sqrt(5.0d) - 1.0d))));
    public byte[] AFInAppEventParameterName = new byte[8];
    public int AFInAppEventType = 8;
    public byte[] AFKeystoreWrapper = new byte[8];
    public int AFLogger$LogLevel = Integer.MAX_VALUE;
    public int AFVersionDeclaration;
    public int AppsFlyer2dXConversionCallback = 8;
    public int getLevel;
    public int init;
    public int onAppOpenAttributionNative;
    public int onAttributionFailureNative;
    public int onInstallConversionFailureNative;
    public byte[] valueOf = new byte[8];

    public C1465by(InputStream inputStream, int[] iArr, int i, byte[] bArr, int i2, int i3) throws IOException {
        super(inputStream);
        this.init = Math.min(Math.max(i2, 5), 16);
        this.AFVersionDeclaration = i3;
        if (i3 == 3) {
            System.arraycopy(bArr, 0, this.AFKeystoreWrapper, 0, 8);
        }
        long j = ((((long) iArr[0]) & 4294967295L) << 32) | (4294967295L & ((long) iArr[1]));
        if (i == 0) {
            this.getLevel = (int) j;
            long j2 = j >> 3;
            short s = values;
            this.onAttributionFailureNative = (int) ((((long) s) * j2) >> 32);
            this.onAppOpenAttributionNative = (int) (j >> 32);
            this.onInstallConversionFailureNative = (int) (j2 + ((long) s));
            return;
        }
        int i4 = (int) j;
        this.getLevel = i4;
        this.onAttributionFailureNative = i4 * i;
        this.onAppOpenAttributionNative = i4 ^ i;
        this.onInstallConversionFailureNative = (int) (j >> 32);
    }

    private void AFKeystoreWrapper() {
        if (this.AFVersionDeclaration == 3) {
            byte[] bArr = this.valueOf;
            System.arraycopy(bArr, 0, this.AFInAppEventParameterName, 0, bArr.length);
        }
        byte[] bArr2 = this.valueOf;
        int i = ((bArr2[0] << 24) & ViewCompat.MEASURED_STATE_MASK) + ((bArr2[1] << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) + ((bArr2[2] << 8) & 65280) + (bArr2[3] & Base64.EQUALS_SIGN_ENC);
        int i2 = (-16777216 & (bArr2[4] << 24)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & Base64.EQUALS_SIGN_ENC);
        int i3 = 0;
        while (true) {
            int i4 = this.init;
            if (i3 >= i4) {
                break;
            }
            short s = values;
            i2 -= ((((i4 - i3) * s) + i) ^ ((i << 4) + this.onAppOpenAttributionNative)) ^ ((i >>> 5) + this.onInstallConversionFailureNative);
            i -= (((i2 << 4) + this.getLevel) ^ (((i4 - i3) * s) + i2)) ^ ((i2 >>> 5) + this.onAttributionFailureNative);
            i3++;
        }
        byte[] bArr3 = this.valueOf;
        bArr3[0] = (byte) (i >> 24);
        bArr3[1] = (byte) (i >> 16);
        bArr3[2] = (byte) (i >> 8);
        bArr3[3] = (byte) i;
        bArr3[4] = (byte) (i2 >> 24);
        bArr3[5] = (byte) (i2 >> 16);
        bArr3[6] = (byte) (i2 >> 8);
        bArr3[7] = (byte) i2;
        if (this.AFVersionDeclaration == 3) {
            for (int i5 = 0; i5 < 8; i5++) {
                byte[] bArr4 = this.valueOf;
                bArr4[i5] = (byte) (bArr4[i5] ^ this.AFKeystoreWrapper[i5]);
            }
            byte[] bArr5 = this.AFInAppEventParameterName;
            System.arraycopy(bArr5, 0, this.AFKeystoreWrapper, 0, bArr5.length);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int values() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.AFLogger$LogLevel
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.AFLogger$LogLevel = r0
        L_0x000f:
            int r0 = r7.AFInAppEventType
            r1 = 8
            if (r0 != r1) goto L_0x0059
            byte[] r0 = r7.valueOf
            int r2 = r7.AFLogger$LogLevel
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0053
            r2 = 1
        L_0x0022:
            java.io.InputStream r3 = r7.in
            byte[] r5 = r7.valueOf
            int r6 = 8 - r2
            int r3 = r3.read(r5, r2, r6)
            if (r3 <= 0) goto L_0x0031
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0022
        L_0x0031:
            if (r2 < r1) goto L_0x004d
            r7.AFKeystoreWrapper()
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.AFLogger$LogLevel = r0
            r7.AFInAppEventType = r4
            if (r0 >= 0) goto L_0x004a
            byte[] r0 = r7.valueOf
            r2 = 7
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x004a:
            r7.AppsFlyer2dXConversionCallback = r1
            goto L_0x0059
        L_0x004d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0053:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0059:
            int r0 = r7.AppsFlyer2dXConversionCallback
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1465by.values():int");
    }

    public final int available() throws IOException {
        values();
        return this.AppsFlyer2dXConversionCallback - this.AFInAppEventType;
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        values();
        int i = this.AFInAppEventType;
        if (i >= this.AppsFlyer2dXConversionCallback) {
            return -1;
        }
        byte[] bArr = this.valueOf;
        this.AFInAppEventType = i + 1;
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
            int i5 = this.AFInAppEventType;
            if (i5 < this.AppsFlyer2dXConversionCallback) {
                byte[] bArr2 = this.valueOf;
                this.AFInAppEventType = i5 + 1;
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
