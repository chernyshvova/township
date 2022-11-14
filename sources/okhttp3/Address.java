package okhttp3;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.Utility;
import com.facebook.internal.security.CertificateUtil;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

public final class Address {
    @Nullable
    public final CertificatePinner certificatePinner;
    public final List<ConnectionSpec> connectionSpecs;
    public final Dns dns;
    @Nullable
    public final HostnameVerifier hostnameVerifier;
    public final List<Protocol> protocols;
    @Nullable
    public final Proxy proxy;
    public final Authenticator proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final SocketFactory socketFactory;
    @Nullable
    public final SSLSocketFactory sslSocketFactory;
    public final HttpUrl url;

    public Address(String str, int i, Dns dns2, SocketFactory socketFactory2, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier2, @Nullable CertificatePinner certificatePinner2, Authenticator authenticator, @Nullable Proxy proxy2, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector2) {
        String str2 = str;
        int i2 = i;
        Dns dns3 = dns2;
        SocketFactory socketFactory3 = socketFactory2;
        SSLSocketFactory sSLSocketFactory2 = sSLSocketFactory;
        Authenticator authenticator2 = authenticator;
        ProxySelector proxySelector3 = proxySelector2;
        HttpUrl.Builder builder = new HttpUrl.Builder();
        String str3 = sSLSocketFactory2 != null ? Utility.URL_SCHEME : "http";
        if (str3.equalsIgnoreCase("http")) {
            builder.scheme = "http";
        } else if (str3.equalsIgnoreCase(Utility.URL_SCHEME)) {
            builder.scheme = Utility.URL_SCHEME;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline16("unexpected scheme: ", str3));
        }
        if (str2 != null) {
            String canonicalizeHost = HttpUrl.Builder.canonicalizeHost(str, 0, str.length());
            if (canonicalizeHost != null) {
                builder.host = canonicalizeHost;
                if (i2 <= 0 || i2 > 65535) {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline14("unexpected port: ", i));
                }
                builder.port = i2;
                this.url = builder.build();
                if (dns3 != null) {
                    this.dns = dns3;
                    if (socketFactory3 != null) {
                        this.socketFactory = socketFactory3;
                        if (authenticator2 != null) {
                            this.proxyAuthenticator = authenticator2;
                            if (list != null) {
                                this.protocols = Util.immutableList(list);
                                if (list2 != null) {
                                    this.connectionSpecs = Util.immutableList(list2);
                                    if (proxySelector3 != null) {
                                        this.proxySelector = proxySelector3;
                                        this.proxy = proxy2;
                                        this.sslSocketFactory = sSLSocketFactory2;
                                        this.hostnameVerifier = hostnameVerifier2;
                                        this.certificatePinner = certificatePinner2;
                                        return;
                                    }
                                    throw new NullPointerException("proxySelector == null");
                                }
                                throw new NullPointerException("connectionSpecs == null");
                            }
                            throw new NullPointerException("protocols == null");
                        }
                        throw new NullPointerException("proxyAuthenticator == null");
                    }
                    throw new NullPointerException("socketFactory == null");
                }
                throw new NullPointerException("dns == null");
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline16("unexpected host: ", str));
        }
        throw new NullPointerException("host == null");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return this.url.equals(address.url) && equalsNonHost(address);
        }
    }

    public boolean equalsNonHost(Address address) {
        return this.dns.equals(address.dns) && this.proxyAuthenticator.equals(address.proxyAuthenticator) && this.protocols.equals(address.protocols) && this.connectionSpecs.equals(address.connectionSpecs) && this.proxySelector.equals(address.proxySelector) && Util.equal(this.proxy, address.proxy) && Util.equal(this.sslSocketFactory, address.sslSocketFactory) && Util.equal(this.hostnameVerifier, address.hostnameVerifier) && Util.equal(this.certificatePinner, address.certificatePinner) && this.url.port == address.url.port;
    }

    public int hashCode() {
        int hashCode = this.dns.hashCode();
        int hashCode2 = (this.proxySelector.hashCode() + ((this.connectionSpecs.hashCode() + ((this.protocols.hashCode() + ((this.proxyAuthenticator.hashCode() + ((hashCode + ((this.url.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        Proxy proxy2 = this.proxy;
        int i = 0;
        int hashCode3 = (hashCode2 + (proxy2 != null ? proxy2.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        int hashCode4 = (hashCode3 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier2 = this.hostnameVerifier;
        int hashCode5 = (hashCode4 + (hostnameVerifier2 != null ? hostnameVerifier2.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner2 = this.certificatePinner;
        if (certificatePinner2 != null) {
            i = certificatePinner2.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Address{");
        outline24.append(this.url.host);
        outline24.append(CertificateUtil.DELIMITER);
        outline24.append(this.url.port);
        if (this.proxy != null) {
            outline24.append(", proxy=");
            outline24.append(this.proxy);
        } else {
            outline24.append(", proxySelector=");
            outline24.append(this.proxySelector);
        }
        outline24.append("}");
        return outline24.toString();
    }
}
