package com.google.zxing.qrcode.decoder;

public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    public final int bits;

    /* access modifiers changed from: public */
    ErrorCorrectionLevel(int i) {
        this.bits = i;
    }
}
