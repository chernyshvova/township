package androidx.transition;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

public class ViewGroupUtils {
    public static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        return new ViewGroupOverlayApi18(viewGroup);
    }

    public static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        ViewGroupUtilsApi18.suppressLayout(viewGroup, z);
    }
}
