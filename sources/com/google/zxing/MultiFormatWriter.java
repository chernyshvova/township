package com.google.zxing;

import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.Code93Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.UPCEWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Map;

public final class MultiFormatWriter implements Writer {
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        Writer writer;
        switch (barcodeFormat.ordinal()) {
            case 0:
                writer = new AztecWriter();
                break;
            case 1:
                writer = new CodaBarWriter();
                break;
            case 2:
                writer = new Code39Writer();
                break;
            case 3:
                writer = new Code93Writer();
                break;
            case 4:
                writer = new Code128Writer();
                break;
            case 5:
                writer = new DataMatrixWriter();
                break;
            case 6:
                writer = new EAN8Writer();
                break;
            case 7:
                writer = new EAN13Writer();
                break;
            case 8:
                writer = new ITFWriter();
                break;
            case 10:
                writer = new PDF417Writer();
                break;
            case 11:
                writer = new QRCodeWriter();
                break;
            case 14:
                writer = new UPCAWriter();
                break;
            case 15:
                writer = new UPCEWriter();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(barcodeFormat)));
        }
        return writer.encode(str, barcodeFormat, i, i2, map);
    }
}
