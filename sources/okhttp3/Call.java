package okhttp3;

import java.io.IOException;

public interface Call extends Cloneable {

    public interface Factory {
    }

    void cancel();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();
}
