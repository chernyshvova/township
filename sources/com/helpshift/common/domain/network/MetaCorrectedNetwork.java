package com.helpshift.common.domain.network;

import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Jsonifier;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import java.util.HashMap;
import java.util.Map;

public class MetaCorrectedNetwork implements Network {
    public final Jsonifier jsonifier;
    public final Network network;

    public MetaCorrectedNetwork(Network network2, Platform platform) {
        this.network = network2;
        this.jsonifier = platform.getJsonifier();
    }

    private void removeCIFAndCustomMetadata(Map<String, String> map) {
        map.put("meta", this.jsonifier.removeKeyFromJsonObjString(map.get("meta"), "custom_meta"));
        map.remove("custom_fields");
    }

    public Response makeRequest(RequestData requestData) {
        return makeRequest(requestData, 1);
    }

    private Response makeRequest(RequestData requestData, int i) {
        Response makeRequest = this.network.makeRequest(requestData);
        if (makeRequest.status != 413) {
            return makeRequest;
        }
        if (i > 0) {
            HashMap hashMap = new HashMap(requestData.body);
            removeCIFAndCustomMetadata(hashMap);
            return makeRequest(new RequestData((Map<String, String>) hashMap), i - 1);
        }
        throw RootAPIException.wrap((Exception) null, NetworkException.ENTITY_TOO_LARGE_RETRIES_EXHAUSTED);
    }
}
