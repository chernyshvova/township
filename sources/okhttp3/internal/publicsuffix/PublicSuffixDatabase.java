package okhttp3.internal.publicsuffix;

import com.playrix.gplay.billing.Base64;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;
import okio.GzipSource;
import okio.Okio;
import okio.RealBufferedSource;
import okio.Timeout;

public final class PublicSuffixDatabase {
    public static final String[] EMPTY_RULE = new String[0];
    public static final String[] PREVAILING_RULE = {"*"};
    public static final byte[] WILDCARD_LABEL = {42};
    public static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    public final AtomicBoolean listRead = new AtomicBoolean(false);
    public byte[] publicSuffixExceptionListBytes;
    public byte[] publicSuffixListBytes;
    public final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static String binarySearchBytes(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        byte b;
        int i3;
        byte[] bArr3 = bArr;
        byte[][] bArr4 = bArr2;
        int length = bArr3.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = (i4 + length) / 2;
            while (i5 > -1 && bArr3[i5] != 10) {
                i5--;
            }
            int i6 = i5 + 1;
            int i7 = 1;
            while (true) {
                i2 = i6 + i7;
                if (bArr3[i2] == 10) {
                    break;
                }
                i7++;
            }
            int i8 = i2 - i6;
            int i9 = i;
            boolean z2 = false;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (z2) {
                    b = 46;
                    z = false;
                } else {
                    z = z2;
                    b = bArr4[i9][i10] & Base64.EQUALS_SIGN_ENC;
                }
                i3 = b - (bArr3[i6 + i11] & Base64.EQUALS_SIGN_ENC);
                if (i3 == 0) {
                    i11++;
                    i10++;
                    if (i11 == i8) {
                        break;
                    } else if (bArr4[i9].length != i10) {
                        z2 = z;
                    } else if (i9 == bArr4.length - 1) {
                        break;
                    } else {
                        i9++;
                        z2 = true;
                        i10 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i3 >= 0) {
                if (i3 <= 0) {
                    int i12 = i8 - i11;
                    int length2 = bArr4[i9].length - i10;
                    while (true) {
                        i9++;
                        if (i9 >= bArr4.length) {
                            break;
                        }
                        length2 += bArr4[i9].length;
                    }
                    if (length2 >= i12) {
                        if (length2 <= i12) {
                            return new String(bArr3, i6, i8, Util.UTF_8);
                        }
                    }
                }
                i4 = i2 + 1;
            }
            length = i6 - 1;
        }
        return null;
    }

    public final void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            RealBufferedSource realBufferedSource = new RealBufferedSource(new GzipSource(Okio.source(resourceAsStream, new Timeout())));
            try {
                byte[] bArr = new byte[realBufferedSource.readInt()];
                realBufferedSource.readFully(bArr);
                byte[] bArr2 = new byte[realBufferedSource.readInt()];
                realBufferedSource.readFully(bArr2);
                synchronized (this) {
                    this.publicSuffixListBytes = bArr;
                    this.publicSuffixExceptionListBytes = bArr2;
                }
                this.readCompleteLatch.countDown();
            } finally {
                Util.closeQuietly((Closeable) realBufferedSource);
            }
        }
    }
}
