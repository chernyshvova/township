package okhttp3;

import java.io.IOException;

public interface Interceptor {

    public interface Chain {
    }

    Response intercept(Chain chain) throws IOException;
}
