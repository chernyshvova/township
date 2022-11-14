package com.helpshift.websockets;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.playrix.gplay.billing.Base64;
import java.util.Map;

public class PerMessageDeflateExtension extends PerMessageCompressionExtension {
    public static final String CLIENT_MAX_WINDOW_BITS = "client_max_window_bits";
    public static final String CLIENT_NO_CONTEXT_TAKEOVER = "client_no_context_takeover";
    public static final byte[] COMPRESSION_TERMINATOR = {0, 0, -1, -1};
    public static final int INCOMING_SLIDING_WINDOW_MARGIN = 1024;
    public static final int MAX_BITS = 15;
    public static final int MAX_WINDOW_SIZE = 32768;
    public static final int MIN_BITS = 8;
    public static final int MIN_WINDOW_SIZE = 256;
    public static final String SERVER_MAX_WINDOW_BITS = "server_max_window_bits";
    public static final String SERVER_NO_CONTEXT_TAKEOVER = "server_no_context_takeover";
    public boolean mClientNoContextTakeover;
    public int mClientWindowSize = 32768;
    public ByteArray mIncomingSlidingWindow;
    public int mIncomingSlidingWindowBufferSize;
    public boolean mServerNoContextTakeover;
    public int mServerWindowSize = 32768;

    public PerMessageDeflateExtension() {
        super(WebSocketExtension.PERMESSAGE_DEFLATE);
    }

    public static byte[] adjustCompressedData(byte[] bArr) throws FormatException {
        ByteArray byteArray = new ByteArray(bArr.length + 1);
        byteArray.put(bArr);
        int[] iArr = new int[1];
        boolean[] zArr = new boolean[1];
        do {
        } while (skipBlock(byteArray, iArr, zArr));
        if (zArr[0]) {
            return byteArray.toBytes(0, (((iArr[0] - 1) / 8) + 1) - 4);
        }
        appendEmptyBlock(byteArray, iArr);
        return byteArray.toBytes(0, ((iArr[0] - 1) / 8) + 1);
    }

    public static void appendEmptyBlock(ByteArray byteArray, int[] iArr) {
        int i = iArr[0] % 8;
        if (i == 0 || i == 6 || i == 7) {
            byteArray.put(0);
        }
        iArr[0] = iArr[0] + 3;
    }

    private boolean canCompress(byte[] bArr) {
        int i = this.mClientWindowSize;
        if (i != 32768 && bArr.length >= i) {
            return false;
        }
        return true;
    }

    private int computeWindowSize(String str, String str2) throws WebSocketException {
        int extractMaxWindowBits = extractMaxWindowBits(str, str2);
        int i = 256;
        for (int i2 = 8; i2 < extractMaxWindowBits; i2++) {
            i *= 2;
        }
        return i;
    }

    private int extractMaxWindowBits(String str, String str2) throws WebSocketException {
        int parseMaxWindowBits = parseMaxWindowBits(str2);
        if (parseMaxWindowBits >= 0) {
            return parseMaxWindowBits;
        }
        throw new WebSocketException(WebSocketError.PERMESSAGE_DEFLATE_INVALID_MAX_WINDOW_BITS, String.format("The value of %s parameter of permessage-deflate extension is invalid: %s", new Object[]{str, str2}));
    }

    private int parseMaxWindowBits(String str) {
        if (str == null) {
            return -1;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 8 || 15 < parseInt) {
                return -1;
            }
            return parseInt;
        } catch (NumberFormatException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean skipBlock(com.helpshift.websockets.ByteArray r5, int[] r6, boolean[] r7) throws com.helpshift.websockets.FormatException {
        /*
            boolean r0 = r5.readBit(r6)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000e
            r3 = r6[r2]
            int r3 = r3 - r1
            r5.clearBit(r3)
        L_0x000e:
            r3 = 2
            int r4 = r5.readBits(r6, r3)
            if (r4 == 0) goto L_0x0040
            if (r4 == r1) goto L_0x003b
            if (r4 != r3) goto L_0x001d
            skipDynamicBlock(r5, r6)
            goto L_0x003e
        L_0x001d:
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.Class<com.helpshift.websockets.PerMessageDeflateExtension> r7 = com.helpshift.websockets.PerMessageDeflateExtension.class
            java.lang.String r7 = r7.getSimpleName()
            r5[r2] = r7
            r6 = r6[r2]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r1] = r6
            java.lang.String r6 = "[%s] Bad compression type '11' at the bit index '%d'."
            java.lang.String r5 = java.lang.String.format(r6, r5)
            com.helpshift.websockets.FormatException r6 = new com.helpshift.websockets.FormatException
            r6.<init>(r5)
            throw r6
        L_0x003b:
            skipFixedBlock(r5, r6)
        L_0x003e:
            r3 = 0
            goto L_0x0047
        L_0x0040:
            int r3 = skipPlainBlock(r5, r6)
            if (r3 != 0) goto L_0x003e
            r3 = 1
        L_0x0047:
            int r5 = r5.length()
            r6 = r6[r2]
            int r6 = r6 / 8
            if (r5 > r6) goto L_0x0052
            r0 = 1
        L_0x0052:
            if (r0 == 0) goto L_0x0058
            if (r3 == 0) goto L_0x0058
            r7[r2] = r1
        L_0x0058:
            r5 = r0 ^ 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.websockets.PerMessageDeflateExtension.skipBlock(com.helpshift.websockets.ByteArray, int[], boolean[]):boolean");
    }

    public static void skipData(ByteArray byteArray, int[] iArr, Huffman huffman, Huffman huffman2) throws FormatException {
        while (true) {
            int readSym = huffman.readSym(byteArray, iArr);
            if (readSym != 256) {
                if (readSym < 0 || readSym > 255) {
                    DeflateUtil.readLength(byteArray, iArr, readSym);
                    DeflateUtil.readDistance(byteArray, iArr, huffman2);
                }
            } else {
                return;
            }
        }
    }

    public static void skipDynamicBlock(ByteArray byteArray, int[] iArr) throws FormatException {
        Huffman[] huffmanArr = new Huffman[2];
        DeflateUtil.readDynamicTables(byteArray, iArr, huffmanArr);
        skipData(byteArray, iArr, huffmanArr[0], huffmanArr[1]);
    }

    public static void skipFixedBlock(ByteArray byteArray, int[] iArr) throws FormatException {
        skipData(byteArray, iArr, FixedLiteralLengthHuffman.getInstance(), FixedDistanceHuffman.getInstance());
    }

    public static int skipPlainBlock(ByteArray byteArray, int[] iArr) {
        int i = ((iArr[0] + 7) & -8) / 8;
        int i2 = ((byteArray.get(i + 1) & Base64.EQUALS_SIGN_ENC) * 256) + (byteArray.get(i) & Base64.EQUALS_SIGN_ENC);
        iArr[0] = (i + 4 + i2) * 8;
        return i2;
    }

    private void validateParameter(String str, String str2) throws WebSocketException {
        if (SERVER_NO_CONTEXT_TAKEOVER.equals(str)) {
            this.mServerNoContextTakeover = true;
        } else if (CLIENT_NO_CONTEXT_TAKEOVER.equals(str)) {
            this.mClientNoContextTakeover = true;
        } else if (SERVER_MAX_WINDOW_BITS.equals(str)) {
            this.mServerWindowSize = computeWindowSize(str, str2);
        } else if (CLIENT_MAX_WINDOW_BITS.equals(str)) {
            this.mClientWindowSize = computeWindowSize(str, str2);
        } else {
            throw new WebSocketException(WebSocketError.PERMESSAGE_DEFLATE_UNSUPPORTED_PARAMETER, GeneratedOutlineSupport.outline16("permessage-deflate extension contains an unsupported parameter: ", str));
        }
    }

    public byte[] compress(byte[] bArr) throws WebSocketException {
        if (!canCompress(bArr)) {
            return bArr;
        }
        try {
            return adjustCompressedData(DeflateCompressor.compress(bArr));
        } catch (Exception e) {
            throw new WebSocketException(WebSocketError.COMPRESSION_ERROR, String.format("Failed to compress the message: %s", new Object[]{e.getMessage()}), e);
        }
    }

    public byte[] decompress(byte[] bArr) throws WebSocketException {
        ByteArray byteArray = new ByteArray(bArr.length + COMPRESSION_TERMINATOR.length);
        byteArray.put(bArr);
        byteArray.put(COMPRESSION_TERMINATOR);
        if (this.mIncomingSlidingWindow == null) {
            this.mIncomingSlidingWindow = new ByteArray(this.mIncomingSlidingWindowBufferSize);
        }
        int length = this.mIncomingSlidingWindow.length();
        try {
            DeflateDecompressor.decompress(byteArray, this.mIncomingSlidingWindow);
            byte[] bytes = this.mIncomingSlidingWindow.toBytes(length);
            this.mIncomingSlidingWindow.shrink(this.mIncomingSlidingWindowBufferSize);
            if (this.mServerNoContextTakeover) {
                this.mIncomingSlidingWindow.clear();
            }
            return bytes;
        } catch (Exception e) {
            throw new WebSocketException(WebSocketError.DECOMPRESSION_ERROR, String.format("Failed to decompress the message: %s", new Object[]{e.getMessage()}), e);
        }
    }

    public int getClientWindowSize() {
        return this.mClientWindowSize;
    }

    public int getServerWindowSize() {
        return this.mServerWindowSize;
    }

    public boolean isClientNoContextTakeover() {
        return this.mClientNoContextTakeover;
    }

    public boolean isServerNoContextTakeover() {
        return this.mServerNoContextTakeover;
    }

    public void validate() throws WebSocketException {
        for (Map.Entry next : getParameters().entrySet()) {
            validateParameter((String) next.getKey(), (String) next.getValue());
        }
        this.mIncomingSlidingWindowBufferSize = this.mServerWindowSize + 1024;
    }

    public PerMessageDeflateExtension(String str) {
        super(str);
    }
}
