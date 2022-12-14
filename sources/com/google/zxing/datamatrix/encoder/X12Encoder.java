package com.google.zxing.datamatrix.encoder;

import com.android.billingclient.api.zzam;

public final class X12Encoder extends C40Encoder {
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            encodeChar(currentChar, sb);
            if (sb.length() % 3 == 0) {
                C40Encoder.writeNextTriplet(encoderContext, sb);
                if (zzam.lookAheadTest(encoderContext.msg, encoderContext.pos, 3) != 3) {
                    encoderContext.newEncoding = 0;
                    break;
                }
            }
        }
        handleEOD(encoderContext, sb);
    }

    public int encodeChar(char c, StringBuilder sb) {
        if (c == 13) {
            sb.append(0);
        } else if (c == ' ') {
            sb.append(3);
        } else if (c == '*') {
            sb.append(1);
        } else if (c == '>') {
            sb.append(2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c < 'A' || c > 'Z') {
            zzam.illegalCharacter(c);
            throw null;
        } else {
            sb.append((char) ((c - 'A') + 14));
        }
        return 1;
    }

    public int getEncodingMode() {
        return 3;
    }

    public void handleEOD(EncoderContext encoderContext, StringBuilder sb) {
        encoderContext.updateSymbolInfo();
        int codewordCount = encoderContext.symbolInfo.dataCapacity - encoderContext.getCodewordCount();
        encoderContext.pos -= sb.length();
        if (encoderContext.getRemainingCharacters() > 1 || codewordCount > 1 || encoderContext.getRemainingCharacters() != codewordCount) {
            encoderContext.codewords.append(254);
        }
        if (encoderContext.newEncoding < 0) {
            encoderContext.newEncoding = 0;
        }
    }
}
