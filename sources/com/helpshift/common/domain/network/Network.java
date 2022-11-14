package com.helpshift.common.domain.network;

import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;

public interface Network {
    Response makeRequest(RequestData requestData);
}
