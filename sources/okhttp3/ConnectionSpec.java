package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec {
    public static final CipherSuite[] APPROVED_CIPHER_SUITES = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_AES_128_CCM_SHA256, CipherSuite.TLS_AES_256_CCM_8_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    public static final ConnectionSpec CLEARTEXT = new ConnectionSpec(new Builder(false));
    public static final ConnectionSpec MODERN_TLS;
    public static final CipherSuite[] RESTRICTED_CIPHER_SUITES = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_AES_128_CCM_SHA256, CipherSuite.TLS_AES_256_CCM_8_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256};
    @Nullable
    public final String[] cipherSuites;
    public final boolean supportsTlsExtensions;
    public final boolean tls;
    @Nullable
    public final String[] tlsVersions;

    static {
        TlsVersion tlsVersion = TlsVersion.TLS_1_0;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        TlsVersion tlsVersion3 = TlsVersion.TLS_1_3;
        Builder builder = new Builder(true);
        builder.cipherSuites(RESTRICTED_CIPHER_SUITES);
        builder.tlsVersions(tlsVersion3, tlsVersion2);
        builder.supportsTlsExtensions(true);
        Builder builder2 = new Builder(true);
        builder2.cipherSuites(APPROVED_CIPHER_SUITES);
        builder2.tlsVersions(tlsVersion3, tlsVersion2, TlsVersion.TLS_1_1, tlsVersion);
        builder2.supportsTlsExtensions(true);
        MODERN_TLS = new ConnectionSpec(builder2);
        Builder builder3 = new Builder(true);
        builder3.cipherSuites(APPROVED_CIPHER_SUITES);
        builder3.tlsVersions(tlsVersion);
        builder3.supportsTlsExtensions(true);
    }

    public ConnectionSpec(Builder builder) {
        this.tls = builder.tls;
        this.cipherSuites = builder.cipherSuites;
        this.tlsVersions = builder.tlsVersions;
        this.supportsTlsExtensions = builder.supportsTlsExtensions;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = this.tls;
        if (z != connectionSpec.tls) {
            return false;
        }
        return !z || (Arrays.equals(this.cipherSuites, connectionSpec.cipherSuites) && Arrays.equals(this.tlsVersions, connectionSpec.tlsVersions) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions);
    }

    public int hashCode() {
        if (this.tls) {
            return ((((527 + Arrays.hashCode(this.cipherSuites)) * 31) + Arrays.hashCode(this.tlsVersions)) * 31) + (this.supportsTlsExtensions ^ true ? 1 : 0);
        }
        return 17;
    }

    public boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.tls) {
            return false;
        }
        String[] strArr = this.tlsVersions;
        if (strArr != null && !Util.nonEmptyIntersection(Util.NATURAL_ORDER, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.cipherSuites;
        if (strArr2 == null || Util.nonEmptyIntersection(CipherSuite.ORDER_BY_NAME, strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str;
        List list;
        if (!this.tls) {
            return "ConnectionSpec()";
        }
        String[] strArr = this.cipherSuites;
        List list2 = null;
        String str2 = "[all enabled]";
        if (strArr != null) {
            if (strArr != null) {
                ArrayList arrayList = new ArrayList(strArr.length);
                for (String forJavaName : strArr) {
                    arrayList.add(CipherSuite.forJavaName(forJavaName));
                }
                list = Collections.unmodifiableList(arrayList);
            } else {
                list = null;
            }
            str = list.toString();
        } else {
            str = str2;
        }
        String[] strArr2 = this.tlsVersions;
        if (strArr2 != null) {
            if (strArr2 != null) {
                ArrayList arrayList2 = new ArrayList(strArr2.length);
                for (String forJavaName2 : strArr2) {
                    arrayList2.add(TlsVersion.forJavaName(forJavaName2));
                }
                list2 = Collections.unmodifiableList(arrayList2);
            }
            str2 = list2.toString();
        }
        return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
    }

    public static final class Builder {
        @Nullable
        public String[] cipherSuites;
        public boolean supportsTlsExtensions;
        public boolean tls;
        @Nullable
        public String[] tlsVersions;

        public Builder(boolean z) {
            this.tls = z;
        }

        public Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            if (this.tls) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].javaName;
                }
                cipherSuites(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder supportsTlsExtensions(boolean z) {
            if (this.tls) {
                this.supportsTlsExtensions = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public Builder tlsVersions(TlsVersion... tlsVersionArr) {
            if (this.tls) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                tlsVersions(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public Builder cipherSuites(String... strArr) {
            if (!this.tls) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.cipherSuites = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public Builder tlsVersions(String... strArr) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.tlsVersions = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }
    }
}
