package com.helpshift.websockets;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WebSocketInputStream extends FilterInputStream {
    public WebSocketInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private byte[] readPayload(long j, boolean z, byte[] bArr) throws IOException, WebSocketException {
        if (j == 0) {
            return null;
        }
        int i = (int) j;
        try {
            byte[] bArr2 = new byte[i];
            readBytes(bArr2, i);
            if (z) {
                WebSocketFrame.mask(bArr, bArr2);
            }
            return bArr2;
        } catch (OutOfMemoryError e) {
            skipQuietly(j);
            WebSocketError webSocketError = WebSocketError.INSUFFICIENT_MEMORY_FOR_PAYLOAD;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("OutOfMemoryError occurred during a trial to allocate a memory area for a frame's payload: ");
            outline24.append(e.getMessage());
            throw new WebSocketException(webSocketError, outline24.toString(), e);
        }
    }

    private void skipQuietly(long j) {
        try {
            skip(j);
        } catch (IOException unused) {
        }
    }

    public void readBytes(byte[] bArr, int i) throws IOException, WebSocketException {
        int i2 = 0;
        while (i2 < i) {
            int read = read(bArr, i2, i - i2);
            if (read > 0) {
                i2 += read;
            } else {
                throw new InsufficientDataException(i, i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.helpshift.websockets.WebSocketFrame readFrame() throws java.io.IOException, com.helpshift.websockets.WebSocketException {
        /*
            r17 = this;
            r1 = r17
            r0 = 8
            byte[] r2 = new byte[r0]
            r3 = 2
            r1.readBytes(r2, r3)     // Catch:{ InsufficientDataException -> 0x00ed }
            r4 = 0
            byte r5 = r2[r4]
            r5 = r5 & 128(0x80, float:1.794E-43)
            r6 = 1
            if (r5 == 0) goto L_0x0014
            r5 = 1
            goto L_0x0015
        L_0x0014:
            r5 = 0
        L_0x0015:
            byte r7 = r2[r4]
            r7 = r7 & 64
            if (r7 == 0) goto L_0x001d
            r7 = 1
            goto L_0x001e
        L_0x001d:
            r7 = 0
        L_0x001e:
            byte r8 = r2[r4]
            r8 = r8 & 32
            if (r8 == 0) goto L_0x0026
            r8 = 1
            goto L_0x0027
        L_0x0026:
            r8 = 0
        L_0x0027:
            byte r9 = r2[r4]
            r9 = r9 & 16
            if (r9 == 0) goto L_0x002f
            r9 = 1
            goto L_0x0030
        L_0x002f:
            r9 = 0
        L_0x0030:
            byte r10 = r2[r4]
            r10 = r10 & 15
            byte r11 = r2[r6]
            r11 = r11 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x003c
            r11 = 1
            goto L_0x003d
        L_0x003c:
            r11 = 0
        L_0x003d:
            byte r12 = r2[r6]
            r12 = r12 & 127(0x7f, float:1.78E-43)
            long r12 = (long) r12
            r14 = 126(0x7e, double:6.23E-322)
            r6 = 4
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 != 0) goto L_0x005a
            r1.readBytes(r2, r3)
            byte r3 = r2[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r0 = r3 << 8
            r3 = 1
            byte r2 = r2[r3]
        L_0x0055:
            r2 = r2 & 255(0xff, float:3.57E-43)
            r0 = r0 | r2
            long r12 = (long) r0
            goto L_0x00ab
        L_0x005a:
            r14 = 127(0x7f, double:6.27E-322)
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 != 0) goto L_0x00ab
            r1.readBytes(r2, r0)
            byte r12 = r2[r4]
            r12 = r12 & 128(0x80, float:1.794E-43)
            if (r12 != 0) goto L_0x00a1
            byte r4 = r2[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << 56
            r12 = 1
            byte r12 = r2[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << 48
            r4 = r4 | r12
            byte r3 = r2[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 40
            r3 = r3 | r4
            r4 = 3
            byte r4 = r2[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << 32
            r3 = r3 | r4
            byte r4 = r2[r6]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << 24
            r3 = r3 | r4
            r4 = 5
            byte r4 = r2[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << 16
            r3 = r3 | r4
            r4 = 6
            byte r4 = r2[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r0 = r4 << 8
            r0 = r0 | r3
            r3 = 7
            byte r2 = r2[r3]
            goto L_0x0055
        L_0x00a1:
            com.helpshift.websockets.WebSocketException r0 = new com.helpshift.websockets.WebSocketException
            com.helpshift.websockets.WebSocketError r2 = com.helpshift.websockets.WebSocketError.INVALID_PAYLOAD_LENGTH
            java.lang.String r3 = "The payload length of a frame is invalid."
            r0.<init>((com.helpshift.websockets.WebSocketError) r2, (java.lang.String) r3)
            throw r0
        L_0x00ab:
            r0 = 0
            if (r11 == 0) goto L_0x00b3
            byte[] r0 = new byte[r6]
            r1.readBytes(r0, r6)
        L_0x00b3:
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r4 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r4 < 0) goto L_0x00e0
            byte[] r0 = r1.readPayload(r12, r11, r0)
            com.helpshift.websockets.WebSocketFrame r2 = new com.helpshift.websockets.WebSocketFrame
            r2.<init>()
            com.helpshift.websockets.WebSocketFrame r2 = r2.setFin(r5)
            com.helpshift.websockets.WebSocketFrame r2 = r2.setRsv1(r7)
            com.helpshift.websockets.WebSocketFrame r2 = r2.setRsv2(r8)
            com.helpshift.websockets.WebSocketFrame r2 = r2.setRsv3(r9)
            com.helpshift.websockets.WebSocketFrame r2 = r2.setOpcode(r10)
            com.helpshift.websockets.WebSocketFrame r2 = r2.setMask(r11)
            com.helpshift.websockets.WebSocketFrame r0 = r2.setPayload((byte[]) r0)
            return r0
        L_0x00e0:
            r1.skipQuietly(r12)
            com.helpshift.websockets.WebSocketException r0 = new com.helpshift.websockets.WebSocketException
            com.helpshift.websockets.WebSocketError r2 = com.helpshift.websockets.WebSocketError.TOO_LONG_PAYLOAD
            java.lang.String r3 = "The payload length of a frame exceeds the maximum array size in Java."
            r0.<init>((com.helpshift.websockets.WebSocketError) r2, (java.lang.String) r3)
            throw r0
        L_0x00ed:
            r0 = move-exception
            r2 = r0
            int r0 = r2.getReadByteCount()
            if (r0 != 0) goto L_0x00fb
            com.helpshift.websockets.NoMoreFrameException r0 = new com.helpshift.websockets.NoMoreFrameException
            r0.<init>()
            throw r0
        L_0x00fb:
            goto L_0x00fd
        L_0x00fc:
            throw r2
        L_0x00fd:
            goto L_0x00fc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.WebSocketInputStream.readFrame():com.helpshift.websockets.WebSocketFrame");
    }

    public String readLine() throws IOException {
        return Misc.readLine(this, "UTF-8");
    }
}
