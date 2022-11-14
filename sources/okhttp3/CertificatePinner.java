package okhttp3;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.Utility;
import com.facebook.internal.security.CertificateUtil;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new CertificatePinner(new LinkedHashSet(new ArrayList()), (CertificateChainCleaner) null);
    @Nullable
    public final CertificateChainCleaner certificateChainCleaner;
    public final Set<Pin> pins;

    public static final class Pin {
        public final ByteString hash;
        public final String hashAlgorithm;
        public final String pattern;

        public boolean equals(Object obj) {
            if (!(obj instanceof Pin)) {
                return false;
            }
            String str = ((Pin) obj).pattern;
            throw null;
        }

        public int hashCode() {
            throw null;
        }

        public String toString() {
            new StringBuilder().append((String) null);
            throw null;
        }
    }

    public CertificatePinner(Set<Pin> set, @Nullable CertificateChainCleaner certificateChainCleaner2) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner2;
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("sha256/");
            outline24.append(ByteString.m2766of(((X509Certificate) certificate).getPublicKey().getEncoded()).digest(Utility.HASH_ALGORITHM_SHA256).base64());
            return outline24.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List emptyList = Collections.emptyList();
        Iterator<Pin> it = this.pins.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw null;
            }
            throw null;
        } else if (!emptyList.isEmpty()) {
            CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
            if (certificateChainCleaner2 != null) {
                list = certificateChainCleaner2.clean(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = emptyList.size();
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    Pin pin = (Pin) emptyList.get(i2);
                    if (pin.hashAlgorithm.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = ByteString.m2766of(x509Certificate.getPublicKey().getEncoded()).digest(Utility.HASH_ALGORITHM_SHA256);
                        }
                        if (pin.hash.equals(byteString)) {
                            return;
                        }
                    } else if (pin.hashAlgorithm.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = ByteString.m2766of(x509Certificate.getPublicKey().getEncoded()).digest(Utility.HASH_ALGORITHM_SHA1);
                        }
                        if (pin.hash.equals(byteString2)) {
                            return;
                        }
                    } else {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("unsupported hashAlgorithm: ");
                        outline24.append(pin.hashAlgorithm);
                        throw new AssertionError(outline24.toString());
                    }
                }
            }
            StringBuilder outline26 = GeneratedOutlineSupport.outline26("Certificate pinning failure!", "\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                outline26.append("\n    ");
                outline26.append(pin(x509Certificate2));
                outline26.append(": ");
                outline26.append(x509Certificate2.getSubjectDN().getName());
            }
            outline26.append("\n  Pinned certificates for ");
            outline26.append(str);
            outline26.append(CertificateUtil.DELIMITER);
            int size4 = emptyList.size();
            for (int i4 = 0; i4 < size4; i4++) {
                outline26.append("\n    ");
                outline26.append((Pin) emptyList.get(i4));
            }
            throw new SSLPeerUnverifiedException(outline26.toString());
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (!Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner) || !this.pins.equals(certificatePinner.pins)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
        return this.pins.hashCode() + ((certificateChainCleaner2 != null ? certificateChainCleaner2.hashCode() : 0) * 31);
    }
}
