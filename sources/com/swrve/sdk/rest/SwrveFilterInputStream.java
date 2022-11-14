package com.swrve.sdk.rest;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class SwrveFilterInputStream extends FilterInputStream {
    public boolean hasMoreToRead = true;

    public SwrveFilterInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        if (this.hasMoreToRead && (read = super.read(bArr, i, i2)) != -1) {
            return read;
        }
        this.hasMoreToRead = false;
        return -1;
    }
}
