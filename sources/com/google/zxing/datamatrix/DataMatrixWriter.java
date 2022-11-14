package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.ASCIIEncoder;
import com.google.zxing.datamatrix.encoder.Base256Encoder;
import com.google.zxing.datamatrix.encoder.C40Encoder;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.EdifactEncoder;
import com.google.zxing.datamatrix.encoder.Encoder;
import com.google.zxing.datamatrix.encoder.EncoderContext;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.datamatrix.encoder.TextEncoder;
import com.google.zxing.datamatrix.encoder.X12Encoder;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

public final class DataMatrixWriter implements Writer {
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Dimension dimension;
        int i3;
        int i4;
        BitMatrix bitMatrix;
        String str2 = str;
        int i5 = i;
        int i6 = i2;
        Map<EncodeHintType, ?> map2 = map;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(barcodeFormat)));
        } else if (i5 < 0 || i6 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i5 + 'x' + i6);
        } else {
            SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
            Dimension dimension2 = null;
            if (map2 != null) {
                SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map2.get(EncodeHintType.DATA_MATRIX_SHAPE);
                if (symbolShapeHint2 != null) {
                    symbolShapeHint = symbolShapeHint2;
                }
                Dimension dimension3 = (Dimension) map2.get(EncodeHintType.MIN_SIZE);
                if (dimension3 == null) {
                    dimension3 = null;
                }
                Dimension dimension4 = (Dimension) map2.get(EncodeHintType.MAX_SIZE);
                if (dimension4 != null) {
                    dimension2 = dimension4;
                }
                dimension = dimension2;
                dimension2 = dimension3;
            } else {
                dimension = null;
            }
            int i7 = 4;
            Encoder[] encoderArr = {new ASCIIEncoder(), new C40Encoder(), new TextEncoder(), new X12Encoder(), new EdifactEncoder(), new Base256Encoder()};
            EncoderContext encoderContext = new EncoderContext(str2);
            encoderContext.shape = symbolShapeHint;
            encoderContext.minSize = dimension2;
            encoderContext.maxSize = dimension;
            if (str2.startsWith("[)>\u001e05\u001d") && str2.endsWith("\u001e\u0004")) {
                encoderContext.codewords.append(236);
                encoderContext.skipAtEnd = 2;
                encoderContext.pos += 7;
            } else if (str2.startsWith("[)>\u001e06\u001d") && str2.endsWith("\u001e\u0004")) {
                encoderContext.codewords.append(237);
                encoderContext.skipAtEnd = 2;
                encoderContext.pos += 7;
            }
            int i8 = 0;
            while (encoderContext.hasMoreCharacters()) {
                encoderArr[i8].encode(encoderContext);
                int i9 = encoderContext.newEncoding;
                if (i9 >= 0) {
                    encoderContext.newEncoding = -1;
                    i8 = i9;
                }
            }
            int codewordCount = encoderContext.getCodewordCount();
            encoderContext.updateSymbolInfo();
            int i10 = encoderContext.symbolInfo.dataCapacity;
            if (!(codewordCount >= i10 || i8 == 0 || i8 == 5 || i8 == 4)) {
                encoderContext.codewords.append(254);
            }
            StringBuilder sb = encoderContext.codewords;
            if (sb.length() < i10) {
                sb.append(129);
            }
            while (sb.length() < i10) {
                int length = (((sb.length() + 1) * 149) % 253) + 1 + 129;
                if (length > 254) {
                    length -= 254;
                }
                sb.append((char) length);
            }
            String sb2 = encoderContext.codewords.toString();
            SymbolInfo lookup = SymbolInfo.lookup(sb2.length(), symbolShapeHint, dimension2, dimension, true);
            DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.encodeECC200(sb2, lookup), lookup.getSymbolDataWidth(), lookup.getSymbolDataHeight());
            int i11 = 4;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                int i14 = defaultPlacement.numrows;
                if (i11 == i14 && i12 == 0) {
                    defaultPlacement.module(i14 - 1, 0, i13, 1);
                    defaultPlacement.module(defaultPlacement.numrows - 1, 1, i13, 2);
                    defaultPlacement.module(defaultPlacement.numrows - 1, 2, i13, 3);
                    defaultPlacement.module(0, defaultPlacement.numcols - 2, i13, i7);
                    defaultPlacement.module(0, defaultPlacement.numcols - 1, i13, 5);
                    defaultPlacement.module(1, defaultPlacement.numcols - 1, i13, 6);
                    defaultPlacement.module(2, defaultPlacement.numcols - 1, i13, 7);
                    defaultPlacement.module(3, defaultPlacement.numcols - 1, i13, 8);
                    i13++;
                }
                int i15 = defaultPlacement.numrows;
                if (i11 == i15 - 2 && i12 == 0 && defaultPlacement.numcols % i7 != 0) {
                    defaultPlacement.module(i15 - 3, 0, i13, 1);
                    defaultPlacement.module(defaultPlacement.numrows - 2, 0, i13, 2);
                    defaultPlacement.module(defaultPlacement.numrows - 1, 0, i13, 3);
                    defaultPlacement.module(0, defaultPlacement.numcols - i7, i13, i7);
                    defaultPlacement.module(0, defaultPlacement.numcols - 3, i13, 5);
                    defaultPlacement.module(0, defaultPlacement.numcols - 2, i13, 6);
                    defaultPlacement.module(0, defaultPlacement.numcols - 1, i13, 7);
                    defaultPlacement.module(1, defaultPlacement.numcols - 1, i13, 8);
                    i13++;
                }
                int i16 = defaultPlacement.numrows;
                if (i11 == i16 - 2 && i12 == 0 && defaultPlacement.numcols % 8 == i7) {
                    defaultPlacement.module(i16 - 3, 0, i13, 1);
                    defaultPlacement.module(defaultPlacement.numrows - 2, 0, i13, 2);
                    defaultPlacement.module(defaultPlacement.numrows - 1, 0, i13, 3);
                    defaultPlacement.module(0, defaultPlacement.numcols - 2, i13, i7);
                    defaultPlacement.module(0, defaultPlacement.numcols - 1, i13, 5);
                    defaultPlacement.module(1, defaultPlacement.numcols - 1, i13, 6);
                    defaultPlacement.module(2, defaultPlacement.numcols - 1, i13, 7);
                    defaultPlacement.module(3, defaultPlacement.numcols - 1, i13, 8);
                    i13++;
                }
                int i17 = defaultPlacement.numrows;
                if (i11 == i17 + 4 && i12 == 2 && defaultPlacement.numcols % 8 == 0) {
                    defaultPlacement.module(i17 - 1, 0, i13, 1);
                    defaultPlacement.module(defaultPlacement.numrows - 1, defaultPlacement.numcols - 1, i13, 2);
                    defaultPlacement.module(0, defaultPlacement.numcols - 3, i13, 3);
                    defaultPlacement.module(0, defaultPlacement.numcols - 2, i13, i7);
                    defaultPlacement.module(0, defaultPlacement.numcols - 1, i13, 5);
                    defaultPlacement.module(1, defaultPlacement.numcols - 3, i13, 6);
                    defaultPlacement.module(1, defaultPlacement.numcols - 2, i13, 7);
                    defaultPlacement.module(1, defaultPlacement.numcols - 1, i13, 8);
                    i13++;
                }
                do {
                    if (i11 < defaultPlacement.numrows && i12 >= 0 && !defaultPlacement.hasBit(i12, i11)) {
                        defaultPlacement.utah(i11, i12, i13);
                        i13++;
                    }
                    i11 -= 2;
                    i12 += 2;
                    if (i11 < 0 || i12 >= defaultPlacement.numcols) {
                        int i18 = i11 + 1;
                        int i19 = i12 + 3;
                    }
                    defaultPlacement.utah(i11, i12, i13);
                    i13++;
                    i11 -= 2;
                    i12 += 2;
                    break;
                } while (i12 >= defaultPlacement.numcols);
                int i182 = i11 + 1;
                int i192 = i12 + 3;
                do {
                    if (i182 >= 0 && i192 < defaultPlacement.numcols && !defaultPlacement.hasBit(i192, i182)) {
                        defaultPlacement.utah(i182, i192, i13);
                        i13++;
                    }
                    i182 += 2;
                    i192 -= 2;
                    if (i182 >= defaultPlacement.numrows) {
                        break;
                    }
                } while (i192 >= 0);
                i11 = i182 + 3;
                i12 = i192 + 1;
                i3 = defaultPlacement.numrows;
                if (i11 >= i3 && i12 >= (i4 = defaultPlacement.numcols)) {
                    break;
                }
                i7 = 4;
            }
            if (!defaultPlacement.hasBit(i4 - 1, i3 - 1)) {
                defaultPlacement.setBit(defaultPlacement.numcols - 1, defaultPlacement.numrows - 1, true);
                defaultPlacement.setBit(defaultPlacement.numcols - 2, defaultPlacement.numrows - 2, true);
            }
            int symbolDataWidth = lookup.getSymbolDataWidth();
            int symbolDataHeight = lookup.getSymbolDataHeight();
            ByteMatrix byteMatrix = new ByteMatrix(lookup.getSymbolWidth(), lookup.getSymbolHeight());
            int i20 = 0;
            for (int i21 = 0; i21 < symbolDataHeight; i21++) {
                if (i21 % lookup.matrixHeight == 0) {
                    int i22 = 0;
                    for (int i23 = 0; i23 < lookup.getSymbolWidth(); i23++) {
                        byteMatrix.set(i22, i20, i23 % 2 == 0);
                        i22++;
                    }
                    i20++;
                }
                int i24 = 0;
                for (int i25 = 0; i25 < symbolDataWidth; i25++) {
                    if (i25 % lookup.matrixWidth == 0) {
                        byteMatrix.set(i24, i20, true);
                        i24++;
                    }
                    byteMatrix.set(i24, i20, defaultPlacement.bits[(defaultPlacement.numcols * i21) + i25] == 1);
                    i24++;
                    int i26 = lookup.matrixWidth;
                    if (i25 % i26 == i26 - 1) {
                        byteMatrix.set(i24, i20, i21 % 2 == 0);
                        i24++;
                    }
                }
                i20++;
                int i27 = lookup.matrixHeight;
                if (i21 % i27 == i27 - 1) {
                    int i28 = 0;
                    for (int i29 = 0; i29 < lookup.getSymbolWidth(); i29++) {
                        byteMatrix.set(i28, i20, true);
                        i28++;
                    }
                    i20++;
                }
            }
            int i30 = byteMatrix.width;
            int i31 = byteMatrix.height;
            int max = Math.max(i5, i30);
            int max2 = Math.max(i6, i31);
            int min = Math.min(max / i30, max2 / i31);
            int i32 = (max - (i30 * min)) / 2;
            int i33 = (max2 - (i31 * min)) / 2;
            if (i6 < i31 || i5 < i30) {
                bitMatrix = new BitMatrix(i30, i31);
                i32 = 0;
                i33 = 0;
            } else {
                bitMatrix = new BitMatrix(i5, i6);
            }
            int length2 = bitMatrix.bits.length;
            for (int i34 = 0; i34 < length2; i34++) {
                bitMatrix.bits[i34] = 0;
            }
            int i35 = 0;
            while (i35 < i31) {
                int i36 = i32;
                int i37 = 0;
                while (i37 < i30) {
                    if (byteMatrix.get(i37, i35) == 1) {
                        bitMatrix.setRegion(i36, i33, min, min);
                    }
                    i37++;
                    i36 += min;
                }
                i35++;
                i33 += min;
            }
            return bitMatrix;
        }
    }
}
