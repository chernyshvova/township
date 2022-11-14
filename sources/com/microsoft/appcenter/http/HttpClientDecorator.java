package com.microsoft.appcenter.http;

import java.io.IOException;

public abstract class HttpClientDecorator implements HttpClient {
    public final HttpClient mDecoratedApi;

    public HttpClientDecorator(HttpClient httpClient) {
        this.mDecoratedApi = httpClient;
    }

    public void close() throws IOException {
        this.mDecoratedApi.close();
    }

    public void reopen() {
        this.mDecoratedApi.reopen();
    }
}
