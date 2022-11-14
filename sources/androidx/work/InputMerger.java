package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.List;

public abstract class InputMerger {
    public static final String TAG = Logger.tagWithPrefix("InputMerger");

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static InputMerger fromClassName(String str) {
        try {
            return (InputMerger) Class.forName(str).newInstance();
        } catch (Exception e) {
            Logger.get().error(TAG, GeneratedOutlineSupport.outline16("Trouble instantiating + ", str), e);
            return null;
        }
    }

    @NonNull
    public abstract Data merge(@NonNull List<Data> list);
}
