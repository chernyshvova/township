package com.helpshift.common.domain.network;

import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.KeyValuePair;
import com.helpshift.common.platform.network.Method;
import com.helpshift.common.platform.network.Request;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.common.platform.network.UploadRequest;
import java.io.File;
import java.util.List;

public class UploadNetwork extends BaseNetwork {
    public Platform platform;

    public UploadNetwork(String str, Domain domain, Platform platform2) {
        super(str, domain, platform2);
        this.platform = platform2;
    }

    public List<KeyValuePair> getHeaders(String str, RequestData requestData) {
        List<KeyValuePair> headers = super.getHeaders(str, requestData);
        headers.add(new KeyValuePair("Connection", "Keep-Alive"));
        headers.add(new KeyValuePair("Content-Type", "multipart/form-data;boundary=*****"));
        return headers;
    }

    public Request getRequest(RequestData requestData) {
        return new UploadRequest(Method.POST, getURL(), getAuthData(Method.POST, NetworkDataRequestUtil.cleanData(requestData.body)), this.platform.getMimeTypeForFile(new File(requestData.body.get("filePath")).getPath()), getHeaders(requestData.getRequestId(), requestData), 30000);
    }

    public /* bridge */ /* synthetic */ Response makeRequest(RequestData requestData) {
        return super.makeRequest(requestData);
    }
}
