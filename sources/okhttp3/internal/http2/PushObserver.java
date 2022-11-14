package okhttp3.internal.http2;

public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() {
    };
}
