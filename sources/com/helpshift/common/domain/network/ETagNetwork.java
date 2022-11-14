package com.helpshift.common.domain.network;

import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.KeyValuePair;
import com.helpshift.common.platform.network.NetworkRequestDAO;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.vungle.warren.downloader.AssetDownloader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ETagNetwork implements Network {
    public final String key;
    public final Network network;
    public final NetworkRequestDAO networkRequestDAO;

    public ETagNetwork(Network network2, Platform platform, String str) {
        this.network = network2;
        this.networkRequestDAO = platform.getNetworkRequestDAO();
        this.key = str;
    }

    private String getHeaderValue(List<KeyValuePair> list, String str) {
        for (KeyValuePair next : list) {
            String str2 = next.key;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return next.value;
            }
        }
        return null;
    }

    public Response makeRequest(RequestData requestData) {
        String headerValue;
        String eTag = this.networkRequestDAO.getETag(this.key);
        if (eTag != null) {
            Map customHeaders = requestData.getCustomHeaders();
            if (customHeaders == null) {
                customHeaders = new HashMap();
            }
            customHeaders.put(AssetDownloader.IF_NONE_MATCH, eTag);
            requestData.setCustomHeaders(customHeaders);
        }
        Response makeRequest = this.network.makeRequest(requestData);
        int i = makeRequest.status;
        if (i >= 200 && i < 300 && (headerValue = getHeaderValue(makeRequest.headers, AssetDownloader.ETAG)) != null) {
            this.networkRequestDAO.storeETag(this.key, headerValue);
        }
        return makeRequest;
    }
}
