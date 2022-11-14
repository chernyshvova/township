package okhttp3.internal.connection;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;

public final class ConnectionSpecSelector {
    public final List<ConnectionSpec> connectionSpecs;
    public boolean isFallback;
    public boolean isFallbackPossible;
    public int nextModeIndex = 0;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.connectionSpecs = list;
    }

    public ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        boolean z;
        String[] strArr;
        String[] strArr2;
        int i = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.connectionSpecs.get(i);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.nextModeIndex = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec != null) {
            int i2 = this.nextModeIndex;
            while (true) {
                if (i2 >= this.connectionSpecs.size()) {
                    z = false;
                    break;
                } else if (this.connectionSpecs.get(i2).isCompatible(sSLSocket)) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            this.isFallbackPossible = z;
            Internal internal = Internal.instance;
            boolean z2 = this.isFallback;
            if (((OkHttpClient.C20611) internal) != null) {
                if (connectionSpec.cipherSuites != null) {
                    strArr = Util.intersect(CipherSuite.ORDER_BY_NAME, sSLSocket.getEnabledCipherSuites(), connectionSpec.cipherSuites);
                } else {
                    strArr = sSLSocket.getEnabledCipherSuites();
                }
                if (connectionSpec.tlsVersions != null) {
                    strArr2 = Util.intersect(Util.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), connectionSpec.tlsVersions);
                } else {
                    strArr2 = sSLSocket.getEnabledProtocols();
                }
                String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
                int indexOf = Util.indexOf(CipherSuite.ORDER_BY_NAME, supportedCipherSuites, "TLS_FALLBACK_SCSV");
                if (z2 && indexOf != -1) {
                    String str = supportedCipherSuites[indexOf];
                    int length = strArr.length + 1;
                    String[] strArr3 = new String[length];
                    System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
                    strArr3[length - 1] = str;
                    strArr = strArr3;
                }
                boolean z3 = connectionSpec.tls;
                if (!z3) {
                    throw new IllegalStateException("no cipher suites for cleartext connections");
                } else if (strArr.length != 0) {
                    String[] strArr4 = (String[]) strArr.clone();
                    if (!z3) {
                        throw new IllegalStateException("no TLS versions for cleartext connections");
                    } else if (strArr2.length != 0) {
                        String[] strArr5 = (String[]) strArr2.clone();
                        if (strArr5 != null) {
                            sSLSocket.setEnabledProtocols(strArr5);
                        }
                        if (strArr4 != null) {
                            sSLSocket.setEnabledCipherSuites(strArr4);
                        }
                        return connectionSpec;
                    } else {
                        throw new IllegalArgumentException("At least one TLS version is required");
                    }
                } else {
                    throw new IllegalArgumentException("At least one cipher suite is required");
                }
            } else {
                throw null;
            }
        } else {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unable to find acceptable protocols. isFallback=");
            outline24.append(this.isFallback);
            outline24.append(", modes=");
            outline24.append(this.connectionSpecs);
            outline24.append(", supported protocols=");
            outline24.append(Arrays.toString(sSLSocket.getEnabledProtocols()));
            throw new UnknownServiceException(outline24.toString());
        }
    }
}
