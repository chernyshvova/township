package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;
import com.android.billingclient.api.zzam;

public final class Base256Encoder implements Encoder {
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            sb.append(encoderContext.getCurrentChar());
            int i = encoderContext.pos + 1;
            encoderContext.pos = i;
            if (zzam.lookAheadTest(encoderContext.msg, i, 5) != 5) {
                encoderContext.newEncoding = 0;
                break;
            }
        }
        int length = sb.length() - 1;
        int codewordCount = encoderContext.getCodewordCount() + length + 1;
        encoderContext.updateSymbolInfo(codewordCount);
        boolean z = encoderContext.symbolInfo.dataCapacity - codewordCount > 0;
        if (encoderContext.hasMoreCharacters() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length2 = sb.length();
        for (int i2 = 0; i2 < length2; i2++) {
            int codewordCount2 = (((encoderContext.getCodewordCount() + 1) * 149) % 255) + 1 + sb.charAt(i2);
            if (codewordCount2 > 255) {
                codewordCount2 += InputDeviceCompat.SOURCE_ANY;
            }
            encoderContext.codewords.append((char) codewordCount2);
        }
    }
}
