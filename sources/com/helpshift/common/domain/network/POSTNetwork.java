package com.helpshift.common.domain.network;

import com.helpshift.common.domain.Domain;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.KeyValuePair;
import com.helpshift.common.platform.network.Method;
import com.helpshift.common.platform.network.POSTRequest;
import com.helpshift.common.platform.network.Request;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.util.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class POSTNetwork extends BaseNetwork implements Network {
    public POSTNetwork(String str, Domain domain, Platform platform) {
        super(str, domain, platform);
    }

    public List<KeyValuePair> getHeaders(String str, RequestData requestData) {
        List<KeyValuePair> headers = super.getHeaders(str, requestData);
        headers.add(new KeyValuePair("Content-type", NetworkConstants.contentType));
        return headers;
    }

    public String getQuery(Map<String, String> map) {
        Map<String, String> authData = getAuthData(Method.POST, map);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : authData.entrySet()) {
            try {
                arrayList.add(URLEncoder.encode((String) next.getKey(), "UTF-8") + "=" + URLEncoder.encode((String) next.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw RootAPIException.wrap(e, NetworkException.UNSUPPORTED_ENCODING_EXCEPTION);
            }
        }
        return StringUtils.join("&", arrayList);
    }

    public Request getRequest(RequestData requestData) {
        return new POSTRequest(getURL(), getQuery(NetworkDataRequestUtil.cleanData(requestData.body)), getHeaders(requestData.getRequestId(), requestData), 5000);
    }

    public /* bridge */ /* synthetic */ Response makeRequest(RequestData requestData) {
        return super.makeRequest(requestData);
    }
}
