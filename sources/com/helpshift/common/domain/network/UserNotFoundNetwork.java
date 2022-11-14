package com.helpshift.common.domain.network;

import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;

public class UserNotFoundNetwork implements Network {
    public final Network network;

    public UserNotFoundNetwork(Network network2) {
        this.network = network2;
    }

    public Response makeRequest(RequestData requestData) {
        Response makeRequest = this.network.makeRequest(requestData);
        if (makeRequest.status != NetworkErrorCodes.CONTENT_NOT_FOUND.intValue()) {
            return makeRequest;
        }
        throw RootAPIException.wrap((Exception) null, NetworkException.USER_NOT_FOUND);
    }
}
