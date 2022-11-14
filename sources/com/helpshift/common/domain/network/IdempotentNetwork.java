package com.helpshift.common.domain.network;

import com.helpshift.common.domain.idempotent.IdempotentPolicy;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.NetworkRequestDAO;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.util.StringUtils;

public class IdempotentNetwork implements Network {
    public IdempotentPolicy idempotentPolicy;
    public Network network;
    public NetworkRequestDAO networkRequestDAO;
    public String route;
    public String uniqueMappingKey;

    public IdempotentNetwork(Network network2, Platform platform, IdempotentPolicy idempotentPolicy2, String str, String str2) {
        this.network = network2;
        this.idempotentPolicy = idempotentPolicy2;
        this.networkRequestDAO = platform.getNetworkRequestDAO();
        this.route = str;
        this.uniqueMappingKey = str2;
    }

    public Response makeRequest(RequestData requestData) {
        String pendingRequestId = this.networkRequestDAO.getPendingRequestId(this.route, this.uniqueMappingKey);
        if (StringUtils.isEmpty(pendingRequestId)) {
            this.networkRequestDAO.storePendingRequestId(this.route, this.uniqueMappingKey, requestData.getRequestId());
        } else {
            requestData.overrideRequestId(pendingRequestId);
        }
        Response makeRequest = this.network.makeRequest(requestData);
        if (makeRequest == null || this.idempotentPolicy.isRequestCompleted(makeRequest.status)) {
            this.networkRequestDAO.deletePendingRequestId(this.route, this.uniqueMappingKey);
            this.networkRequestDAO.storeSuccessfulRequestId(requestData.getRequestId());
        }
        return makeRequest;
    }
}
