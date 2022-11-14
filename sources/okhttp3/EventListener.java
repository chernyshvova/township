package okhttp3;

public abstract class EventListener {
    public static final EventListener NONE = new EventListener() {
    };

    public interface Factory {
    }
}
