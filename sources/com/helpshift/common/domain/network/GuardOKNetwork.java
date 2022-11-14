package com.helpshift.common.domain.network;

import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;

public class GuardOKNetwork implements Network {
    public final Network network;

    public GuardOKNetwork(Network network2) {
        this.network = network2;
    }

    public Response makeRequest(RequestData requestData) {
        Response makeRequest = this.network.makeRequest(requestData);
        int i = makeRequest.status;
        if (i >= 200 && i < 300) {
            return makeRequest;
        }
        NetworkException networkException = NetworkException.UNHANDLED_STATUS_CODE;
        networkException.serverStatusCode = makeRequest.status;
        throw RootAPIException.wrap((Exception) null, networkException);
    }
}
