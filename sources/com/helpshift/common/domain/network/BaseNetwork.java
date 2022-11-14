package com.helpshift.common.domain.network;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.GraphRequest;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Device;
import com.helpshift.common.platform.Jsonifier;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.HTTPTransport;
import com.helpshift.common.platform.network.KeyValuePair;
import com.helpshift.common.platform.network.Method;
import com.helpshift.common.platform.network.NetworkRequestDAO;
import com.helpshift.common.platform.network.Request;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.crypto.CryptoDM;
import com.helpshift.localeprovider.domainmodel.LocaleProviderDM;
import com.helpshift.util.StringUtils;
import com.vungle.warren.downloader.AssetDownloader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class BaseNetwork implements Network {
    public final String apiKey;
    public final String appId;
    public final CryptoDM cryptoDM;
    public final Device device;
    public final Domain domain;
    public final String domainKey;
    public final Jsonifier jsonifier;
    public final LocaleProviderDM localeProviderDM;
    public final NetworkRequestDAO networkRequestDAO;
    public final Platform platform;
    public final String route;
    public final HTTPTransport transport;

    public BaseNetwork(String str, Domain domain2, Platform platform2) {
        this.route = str;
        this.platform = platform2;
        this.domain = domain2;
        this.localeProviderDM = domain2.getLocaleProviderDM();
        this.cryptoDM = domain2.getCryptoDM();
        this.networkRequestDAO = platform2.getNetworkRequestDAO();
        this.transport = platform2.getHTTPTransport();
        this.apiKey = platform2.getAPIKey();
        this.domainKey = platform2.getDomain();
        this.appId = platform2.getAppId();
        this.device = platform2.getDevice();
        this.jsonifier = platform2.getJsonifier();
    }

    private List<KeyValuePair> getCustomHeaders(RequestData requestData) {
        ArrayList arrayList = new ArrayList();
        Map<String, String> customHeaders = requestData.getCustomHeaders();
        if (customHeaders != null) {
            for (Map.Entry next : customHeaders.entrySet()) {
                arrayList.add(new KeyValuePair((String) next.getKey(), (String) next.getValue()));
            }
        }
        return arrayList;
    }

    private String getURI() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("/api/lib/3");
        outline24.append(this.route);
        return outline24.toString();
    }

    public Map<String, String> getAuthData(Method method, Map<String, String> map) {
        AuthDataProvider authDataProvider = new AuthDataProvider(this.domain, this.platform, this.route);
        map.put("uri", getURI());
        try {
            return authDataProvider.getAuthData(method, map);
        } catch (GeneralSecurityException e) {
            NetworkException networkException = NetworkException.UNABLE_TO_GENERATE_SIGNATURE;
            networkException.route = this.route;
            throw RootAPIException.wrap(e, networkException, "Network error");
        }
    }

    public List<KeyValuePair> getCommonHeaders(String str) {
        String str2;
        String format = String.format(Locale.ENGLISH, "Helpshift-%s/%s/%s", new Object[]{this.device.getPlatformName(), this.device.getSDKVersion(), this.device.getOSVersion()});
        String sDKLanguage = this.localeProviderDM.getSDKLanguage();
        String defaultLanguage = this.localeProviderDM.getDefaultLanguage();
        if (!StringUtils.isEmpty(sDKLanguage)) {
            str2 = String.format(Locale.ENGLISH, "%s;q=1.0, %s;q=0.5", new Object[]{sDKLanguage, defaultLanguage});
        } else {
            str2 = String.format(Locale.ENGLISH, "%s;q=1.0", new Object[]{defaultLanguage});
        }
        String format2 = String.format(Locale.ENGLISH, "Helpshift-%s/%s", new Object[]{this.device.getPlatformName(), this.device.getSDKVersion()});
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair(GraphRequest.USER_AGENT_HEADER, format));
        arrayList.add(new KeyValuePair(GraphRequest.ACCEPT_LANGUAGE_HEADER, str2));
        arrayList.add(new KeyValuePair(AssetDownloader.ACCEPT_ENCODING, "gzip"));
        arrayList.add(new KeyValuePair("X-HS-V", format2));
        arrayList.add(new KeyValuePair("X-HS-Request-ID", str));
        return arrayList;
    }

    public List<KeyValuePair> getHeaders(String str, RequestData requestData) {
        List<KeyValuePair> commonHeaders = getCommonHeaders(str);
        commonHeaders.addAll(getCustomHeaders(requestData));
        return commonHeaders;
    }

    public abstract Request getRequest(RequestData requestData);

    public String getURL() {
        return NetworkConstants.scheme + this.domainKey + getURI();
    }

    public Response makeRequest(RequestData requestData) {
        return this.transport.makeRequest(getRequest(requestData));
    }
}
