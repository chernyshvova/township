package com.google.zxing.datamatrix.encoder;

public final class EdifactEncoder implements Encoder {
    public static String encodeToCodewords(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length != 0) {
            char charAt = charSequence.charAt(i);
            char c = 0;
            char charAt2 = length >= 2 ? charSequence.charAt(i + 1) : 0;
            char charAt3 = length >= 3 ? charSequence.charAt(i + 2) : 0;
            if (length >= 4) {
                c = charSequence.charAt(i + 3);
            }
            int i2 = (charAt << 18) + (charAt2 << 12) + (charAt3 << 6) + c;
            char c2 = (char) ((i2 >> 8) & 255);
            char c3 = (char) (i2 & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i2 >> 16) & 255));
            if (length >= 2) {
                sb.append(c2);
            }
            if (length >= 3) {
                sb.append(c3);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        throw null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(com.google.zxing.datamatrix.encoder.EncoderContext r11) {
        /*
            r10 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0005:
            boolean r1 = r11.hasMoreCharacters()
            r2 = 1
            r3 = 4
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L_0x0055
            char r1 = r11.getCurrentChar()
            r6 = 32
            if (r1 < r6) goto L_0x001f
            r6 = 63
            if (r1 > r6) goto L_0x001f
            r0.append(r1)
            goto L_0x002d
        L_0x001f:
            r6 = 64
            if (r1 < r6) goto L_0x0051
            r6 = 94
            if (r1 > r6) goto L_0x0051
            int r1 = r1 + -64
            char r1 = (char) r1
            r0.append(r1)
        L_0x002d:
            int r1 = r11.pos
            int r1 = r1 + r2
            r11.pos = r1
            int r1 = r0.length()
            if (r1 < r3) goto L_0x0005
            java.lang.String r1 = encodeToCodewords(r0, r5)
            java.lang.StringBuilder r6 = r11.codewords
            r6.append(r1)
            r0.delete(r5, r3)
            java.lang.String r1 = r11.msg
            int r6 = r11.pos
            int r1 = com.android.billingclient.api.zzam.lookAheadTest(r1, r6, r3)
            if (r1 == r3) goto L_0x0005
            r11.newEncoding = r5
            goto L_0x0055
        L_0x0051:
            com.android.billingclient.api.zzam.illegalCharacter(r1)
            throw r4
        L_0x0055:
            r1 = 31
            r0.append(r1)
            int r1 = r0.length()     // Catch:{ all -> 0x00dc }
            if (r1 != 0) goto L_0x0062
            goto L_0x00d1
        L_0x0062:
            r6 = 2
            if (r1 != r2) goto L_0x008d
            r11.updateSymbolInfo()     // Catch:{ all -> 0x00dc }
            com.google.zxing.datamatrix.encoder.SymbolInfo r7 = r11.symbolInfo     // Catch:{ all -> 0x00dc }
            int r7 = r7.dataCapacity     // Catch:{ all -> 0x00dc }
            int r8 = r11.getCodewordCount()     // Catch:{ all -> 0x00dc }
            int r7 = r7 - r8
            int r8 = r11.getRemainingCharacters()     // Catch:{ all -> 0x00dc }
            if (r8 <= r7) goto L_0x0088
            int r7 = r11.getCodewordCount()     // Catch:{ all -> 0x00dc }
            int r7 = r7 + r2
            r11.updateSymbolInfo(r7)     // Catch:{ all -> 0x00dc }
            com.google.zxing.datamatrix.encoder.SymbolInfo r7 = r11.symbolInfo     // Catch:{ all -> 0x00dc }
            int r7 = r7.dataCapacity     // Catch:{ all -> 0x00dc }
            int r9 = r11.getCodewordCount()     // Catch:{ all -> 0x00dc }
            int r7 = r7 - r9
        L_0x0088:
            if (r8 > r7) goto L_0x008d
            if (r7 > r6) goto L_0x008d
            goto L_0x00d1
        L_0x008d:
            if (r1 > r3) goto L_0x00d4
            int r1 = r1 - r2
            java.lang.String r0 = encodeToCodewords(r0, r5)     // Catch:{ all -> 0x00dc }
            boolean r3 = r11.hasMoreCharacters()     // Catch:{ all -> 0x00dc }
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x009e
            if (r1 > r6) goto L_0x009e
            goto L_0x009f
        L_0x009e:
            r2 = 0
        L_0x009f:
            if (r1 > r6) goto L_0x00c2
            int r3 = r11.getCodewordCount()     // Catch:{ all -> 0x00dc }
            int r3 = r3 + r1
            r11.updateSymbolInfo(r3)     // Catch:{ all -> 0x00dc }
            com.google.zxing.datamatrix.encoder.SymbolInfo r3 = r11.symbolInfo     // Catch:{ all -> 0x00dc }
            int r3 = r3.dataCapacity     // Catch:{ all -> 0x00dc }
            int r6 = r11.getCodewordCount()     // Catch:{ all -> 0x00dc }
            int r3 = r3 - r6
            r6 = 3
            if (r3 < r6) goto L_0x00c2
            int r2 = r11.getCodewordCount()     // Catch:{ all -> 0x00dc }
            int r3 = r0.length()     // Catch:{ all -> 0x00dc }
            int r2 = r2 + r3
            r11.updateSymbolInfo(r2)     // Catch:{ all -> 0x00dc }
            r2 = 0
        L_0x00c2:
            if (r2 == 0) goto L_0x00cc
            r11.symbolInfo = r4     // Catch:{ all -> 0x00dc }
            int r0 = r11.pos     // Catch:{ all -> 0x00dc }
            int r0 = r0 - r1
            r11.pos = r0     // Catch:{ all -> 0x00dc }
            goto L_0x00d1
        L_0x00cc:
            java.lang.StringBuilder r1 = r11.codewords     // Catch:{ all -> 0x00dc }
            r1.append(r0)     // Catch:{ all -> 0x00dc }
        L_0x00d1:
            r11.newEncoding = r5
            return
        L_0x00d4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00dc }
            java.lang.String r1 = "Count must not exceed 4"
            r0.<init>(r1)     // Catch:{ all -> 0x00dc }
            throw r0     // Catch:{ all -> 0x00dc }
        L_0x00dc:
            r0 = move-exception
            r11.newEncoding = r5
            goto L_0x00e1
        L_0x00e0:
            throw r0
        L_0x00e1:
            goto L_0x00e0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.EdifactEncoder.encode(com.google.zxing.datamatrix.encoder.EncoderContext):void");
    }
}
