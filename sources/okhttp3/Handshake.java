package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class Handshake {
    public final CipherSuite cipherSuite;
    public final List<Certificate> localCertificates;
    public final List<Certificate> peerCertificates;
    public final TlsVersion tlsVersion;

    public Handshake(TlsVersion tlsVersion2, CipherSuite cipherSuite2, List<Certificate> list, List<Certificate> list2) {
        this.tlsVersion = tlsVersion2;
        this.cipherSuite = cipherSuite2;
        this.peerCertificates = list;
        this.localCertificates = list2;
    }

    public static Handshake get(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite2 = sSLSession.getCipherSuite();
        if (cipherSuite2 == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite2)) {
            CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite2);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                TlsVersion forJavaName2 = TlsVersion.forJavaName(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = Util.immutableList((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates2 = sSLSession.getLocalCertificates();
                if (localCertificates2 != null) {
                    list2 = Util.immutableList((T[]) localCertificates2);
                } else {
                    list2 = Collections.emptyList();
                }
                return new Handshake(forJavaName2, forJavaName, list, list2);
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        if (!this.tlsVersion.equals(handshake.tlsVersion) || !this.cipherSuite.equals(handshake.cipherSuite) || !this.peerCertificates.equals(handshake.peerCertificates) || !this.localCertificates.equals(handshake.localCertificates)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.cipherSuite.hashCode();
        int hashCode2 = this.peerCertificates.hashCode();
        return this.localCertificates.hashCode() + ((hashCode2 + ((hashCode + ((this.tlsVersion.hashCode() + 527) * 31)) * 31)) * 31);
    }
}
