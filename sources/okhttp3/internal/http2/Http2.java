package okhttp3.internal.http2;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Http2 {
    public static final String[] BINARY = new String[256];
    public static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    public static final String[] FLAGS = new String[64];
    public static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = BINARY;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = Util.format("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            FLAGS[i4 | 8] = GeneratedOutlineSupport.outline18(new StringBuilder(), FLAGS[i4], "|PADDED");
        }
        String[] strArr3 = FLAGS;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                String[] strArr4 = FLAGS;
                int i9 = i8 | i6;
                strArr4[i9] = FLAGS[i8] + '|' + FLAGS[i6];
                StringBuilder sb = new StringBuilder();
                sb.append(FLAGS[i8]);
                sb.append('|');
                FLAGS[i9 | 8] = GeneratedOutlineSupport.outline18(sb, FLAGS[i6], "|PADDED");
            }
        }
        while (true) {
            String[] strArr5 = FLAGS;
            if (i < strArr5.length) {
                if (strArr5[i] == null) {
                    strArr5[i] = BINARY[i];
                }
                i++;
            } else {
                return;
            }
        }
    }

    public static String frameLog(boolean z, int i, int i2, byte b, byte b2) {
        String str;
        String[] strArr = FRAME_NAMES;
        String format = b < strArr.length ? strArr[b] : Util.format("0x%02x", Byte.valueOf(b));
        if (b2 == 0) {
            str = "";
        } else {
            if (!(b == 2 || b == 3)) {
                if (b == 4 || b == 6) {
                    str = b2 == 1 ? "ACK" : BINARY[b2];
                } else if (!(b == 7 || b == 8)) {
                    String[] strArr2 = FLAGS;
                    String str2 = b2 < strArr2.length ? strArr2[b2] : BINARY[b2];
                    str = (b != 5 || (b2 & 4) == 0) ? (b != 0 || (b2 & 32) == 0) ? str2 : str2.replace("PRIORITY", "COMPRESSED") : str2.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            str = BINARY[b2];
        }
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = format;
        objArr[4] = str;
        return Util.format("%s 0x%08x %5d %-13s %s", objArr);
    }

    public static IllegalArgumentException illegalArgument(String str, Object... objArr) {
        throw new IllegalArgumentException(Util.format(str, objArr));
    }

    public static IOException ioException(String str, Object... objArr) throws IOException {
        throw new IOException(Util.format(str, objArr));
    }
}
