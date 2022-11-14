package okhttp3;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class CipherSuite {
    public static final Map<String, CipherSuite> INSTANCES = new LinkedHashMap();
    public static final Comparator<String> ORDER_BY_NAME = new Comparator<String>() {
        public int compare(Object obj, Object obj2) {
            String str = (String) obj;
            String str2 = (String) obj2;
            int min = Math.min(str.length(), str2.length());
            int i = 4;
            while (true) {
                if (i < min) {
                    char charAt = str.charAt(i);
                    char charAt2 = str2.charAt(i);
                    if (charAt == charAt2) {
                        i++;
                    } else if (charAt < charAt2) {
                        return -1;
                    }
                } else {
                    int length = str.length();
                    int length2 = str2.length();
                    if (length == length2) {
                        return 0;
                    }
                    if (length < length2) {
                        return -1;
                    }
                }
            }
            return 1;
        }
    };
    public static final CipherSuite TLS_AES_128_CCM_SHA256 = init("TLS_AES_128_CCM_SHA256");
    public static final CipherSuite TLS_AES_128_GCM_SHA256 = init("TLS_AES_128_GCM_SHA256");
    public static final CipherSuite TLS_AES_256_CCM_8_SHA256 = init("TLS_AES_256_CCM_8_SHA256");
    public static final CipherSuite TLS_AES_256_GCM_SHA384 = init("TLS_AES_256_GCM_SHA384");
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256 = init("TLS_CHACHA20_POLY1305_SHA256");
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = init("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = init("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = init("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = init("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = init("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = init("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA = init("SSL_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA = init("TLS_RSA_WITH_AES_128_CBC_SHA");
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256 = init("TLS_RSA_WITH_AES_128_GCM_SHA256");
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA = init("TLS_RSA_WITH_AES_256_CBC_SHA");
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384 = init("TLS_RSA_WITH_AES_256_GCM_SHA384");
    public final String javaName;

    static {
        init("SSL_RSA_WITH_NULL_MD5");
        init("SSL_RSA_WITH_NULL_SHA");
        init("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        init("SSL_RSA_WITH_RC4_128_MD5");
        init("SSL_RSA_WITH_RC4_128_SHA");
        init("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        init("SSL_RSA_WITH_DES_CBC_SHA");
        init("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        init("SSL_DHE_DSS_WITH_DES_CBC_SHA");
        init("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        init("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        init("SSL_DHE_RSA_WITH_DES_CBC_SHA");
        init("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        init("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        init("SSL_DH_anon_WITH_RC4_128_MD5");
        init("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        init("SSL_DH_anon_WITH_DES_CBC_SHA");
        init("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        init("TLS_KRB5_WITH_DES_CBC_SHA");
        init("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        init("TLS_KRB5_WITH_RC4_128_SHA");
        init("TLS_KRB5_WITH_DES_CBC_MD5");
        init("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        init("TLS_KRB5_WITH_RC4_128_MD5");
        init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        init("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        init("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        init("TLS_DH_anon_WITH_AES_128_CBC_SHA");
        init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        init("TLS_DH_anon_WITH_AES_256_CBC_SHA");
        init("TLS_RSA_WITH_NULL_SHA256");
        init("TLS_RSA_WITH_AES_128_CBC_SHA256");
        init("TLS_RSA_WITH_AES_256_CBC_SHA256");
        init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        init("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        init("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        init("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        init("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        init("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        init("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        init("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        init("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        init("TLS_PSK_WITH_RC4_128_SHA");
        init("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        init("TLS_PSK_WITH_AES_128_CBC_SHA");
        init("TLS_PSK_WITH_AES_256_CBC_SHA");
        init("TLS_RSA_WITH_SEED_CBC_SHA");
        init("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        init("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        init("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        init("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        init("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        init("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        init("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        init("TLS_FALLBACK_SCSV");
        init("TLS_ECDH_ECDSA_WITH_NULL_SHA");
        init("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        init("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        init("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        init("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        init("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        init("TLS_ECDH_RSA_WITH_NULL_SHA");
        init("TLS_ECDH_RSA_WITH_RC4_128_SHA");
        init("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        init("TLS_ECDHE_RSA_WITH_NULL_SHA");
        init("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        init("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        init("TLS_ECDH_anon_WITH_NULL_SHA");
        init("TLS_ECDH_anon_WITH_RC4_128_SHA");
        init("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        init("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        init("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        init("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        init("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        init("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        init("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        init("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        init("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
        init("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        init("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
    }

    public CipherSuite(String str) {
        if (str != null) {
            this.javaName = str;
            return;
        }
        throw null;
    }

    public static synchronized CipherSuite forJavaName(String str) {
        CipherSuite cipherSuite;
        synchronized (CipherSuite.class) {
            cipherSuite = INSTANCES.get(str);
            if (cipherSuite == null) {
                cipherSuite = INSTANCES.get(secondaryName(str));
                if (cipherSuite == null) {
                    cipherSuite = new CipherSuite(str);
                }
                INSTANCES.put(str, cipherSuite);
            }
        }
        return cipherSuite;
    }

    public static CipherSuite init(String str) {
        CipherSuite cipherSuite = new CipherSuite(str);
        INSTANCES.put(str, cipherSuite);
        return cipherSuite;
    }

    public static String secondaryName(String str) {
        if (str.startsWith("TLS_")) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("SSL_");
            outline24.append(str.substring(4));
            return outline24.toString();
        } else if (!str.startsWith("SSL_")) {
            return str;
        } else {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("TLS_");
            outline242.append(str.substring(4));
            return outline242.toString();
        }
    }

    public String toString() {
        return this.javaName;
    }
}
