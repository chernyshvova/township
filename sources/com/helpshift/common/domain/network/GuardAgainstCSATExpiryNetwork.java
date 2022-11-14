package com.helpshift.common.domain.network;

import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.common.platform.network.ResponseParser;

public class GuardAgainstCSATExpiryNetwork implements Network {
    public final Network network;
    public final ResponseParser responseParser;

    public GuardAgainstCSATExpiryNetwork(Network network2, Platform platform) {
        this.network = network2;
        this.responseParser = platform.getResponseParser();
    }

    public Response makeRequest(RequestData requestData) {
        Response makeRequest = this.network.makeRequest(requestData);
        if (makeRequest.status != 410 || !"csat timer expired".equals(this.responseParser.parseErrorMessage(makeRequest.responseString))) {
            return makeRequest;
        }
        throw RootAPIException.wrap((Exception) null, NetworkException.CSAT_EXPIRED);
    }
}
