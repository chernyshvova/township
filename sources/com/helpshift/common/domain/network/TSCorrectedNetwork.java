package com.helpshift.common.domain.network;

import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.KeyValuePair;
import com.helpshift.common.platform.network.NetworkRequestDAO;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.common.util.HSDateFormatSpec;
import java.util.List;

public class TSCorrectedNetwork implements Network {
    public final Network network;
    public final NetworkRequestDAO networkRequestDAO;

    public TSCorrectedNetwork(Network network2, Platform platform) {
        this.network = network2;
        this.networkRequestDAO = platform.getNetworkRequestDAO();
    }

    private String getHeaderValue(List<KeyValuePair> list, String str) {
        for (KeyValuePair next : list) {
            String str2 = next.key;
            if (str2 != null && str2.equals(str)) {
                return next.value;
            }
        }
        return null;
    }

    public Response makeRequest(RequestData requestData) {
        return makeRequest(requestData, 3);
    }

    private Response makeRequest(RequestData requestData, int i) {
        Response makeRequest = this.network.makeRequest(requestData);
        if (makeRequest.status != 422) {
            return makeRequest;
        }
        if (i != 0) {
            int i2 = i - 1;
            String headerValue = getHeaderValue(makeRequest.headers, "HS-UEpoch");
            if (headerValue != null) {
                this.networkRequestDAO.storeServerTimeDelta(HSDateFormatSpec.calculateTimeDelta(headerValue));
            }
            return makeRequest(new RequestData(requestData), i2);
        }
        throw RootAPIException.wrap((Exception) null, NetworkException.TIMESTAMP_CORRECTION_RETRIES_EXHAUSTED);
    }
}
