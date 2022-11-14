package androidx.activity.contextaware;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ContextAwareHelper {
    public volatile Context mContext;
    public final Set<OnContextAvailableListener> mListeners = new CopyOnWriteArraySet();

    public void addOnContextAvailableListener(@NonNull OnContextAvailableListener onContextAvailableListener) {
        if (this.mContext != null) {
            onContextAvailableListener.onContextAvailable(this.mContext);
        }
        this.mListeners.add(onContextAvailableListener);
    }

    public void clearAvailableContext() {
        this.mContext = null;
    }

    public void dispatchOnContextAvailable(@NonNull Context context) {
        this.mContext = context;
        for (OnContextAvailableListener onContextAvailable : this.mListeners) {
            onContextAvailable.onContextAvailable(context);
        }
    }

    @Nullable
    public Context peekAvailableContext() {
        return this.mContext;
    }

    public void removeOnContextAvailableListener(@NonNull OnContextAvailableListener onContextAvailableListener) {
        this.mListeners.remove(onContextAvailableListener);
    }
}