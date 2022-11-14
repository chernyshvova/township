package com.helpshift.common.domain.network;

import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;

public class FailedAPICallNetworkDecorator implements Network {
    public final Network network;

    public FailedAPICallNetworkDecorator(Network network2) {
        this.network = network2;
    }

    private boolean isStatusCodeNonRetriable(int i) {
        return NetworkErrorCodes.NOT_RETRIABLE_STATUS_CODES.contains(Integer.valueOf(i));
    }

    public Response makeRequest(RequestData requestData) {
        Response makeRequest = this.network.makeRequest(requestData);
        int i = makeRequest.status;
        if (!isStatusCodeNonRetriable(i)) {
            return makeRequest;
        }
        NetworkException networkException = NetworkException.NON_RETRIABLE;
        networkException.serverStatusCode = i;
        throw RootAPIException.wrap((Exception) null, networkException);
    }
}
