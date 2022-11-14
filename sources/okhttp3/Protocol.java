package okhttp3;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;

public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    
    public final String protocol;

    /* access modifiers changed from: public */
    Protocol(String str) {
        this.protocol = str;
    }

    public static Protocol get(String str) throws IOException {
        Protocol protocol2 = QUIC;
        Protocol protocol3 = SPDY_3;
        Protocol protocol4 = HTTP_2;
        Protocol protocol5 = H2_PRIOR_KNOWLEDGE;
        Protocol protocol6 = HTTP_1_1;
        Protocol protocol7 = HTTP_1_0;
        if (str.equals(protocol7.protocol)) {
            return protocol7;
        }
        if (str.equals(protocol6.protocol)) {
            return protocol6;
        }
        if (str.equals(protocol5.protocol)) {
            return protocol5;
        }
        if (str.equals(protocol4.protocol)) {
            return protocol4;
        }
        if (str.equals(protocol3.protocol)) {
            return protocol3;
        }
        if (str.equals(protocol2.protocol)) {
            return protocol2;
        }
        throw new IOException(GeneratedOutlineSupport.outline16("Unexpected protocol: ", str));
    }

    public String toString() {
        return this.protocol;
    }
}
