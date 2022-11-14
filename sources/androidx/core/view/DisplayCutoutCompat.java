package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.List;

public final class DisplayCutoutCompat {
    public final Object mDisplayCutout;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DisplayCutoutCompat(Rect rect, List<Rect> list) {
        this(Build.VERSION.SDK_INT >= 28 ? new DisplayCutout(rect, list) : null);
    }

    public static DisplayCutoutCompat wrap(Object obj) {
        if (obj == null) {
            return null;
        }
        return new DisplayCutoutCompat(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DisplayCutoutCompat.class != obj.getClass()) {
            return false;
        }
        DisplayCutoutCompat displayCutoutCompat = (DisplayCutoutCompat) obj;
        Object obj2 = this.mDisplayCutout;
        if (obj2 != null) {
            return obj2.equals(displayCutoutCompat.mDisplayCutout);
        }
        if (displayCutoutCompat.mDisplayCutout == null) {
            return true;
        }
        return false;
    }

    public List<Rect> getBoundingRects() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.mDisplayCutout).getBoundingRects();
        }
        return null;
    }

    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.mDisplayCutout).getSafeInsetBottom();
        }
        return 0;
    }

    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.mDisplayCutout).getSafeInsetLeft();
        }
        return 0;
    }

    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.mDisplayCutout).getSafeInsetRight();
        }
        return 0;
    }

    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.mDisplayCutout).getSafeInsetTop();
        }
        return 0;
    }

    public int hashCode() {
        Object obj = this.mDisplayCutout;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("DisplayCutoutCompat{");
        outline24.append(this.mDisplayCutout);
        outline24.append("}");
        return outline24.toString();
    }

    @RequiresApi(api = 28)
    public DisplayCutout unwrap() {
        return (DisplayCutout) this.mDisplayCutout;
    }

    public DisplayCutoutCompat(Object obj) {
        this.mDisplayCutout = obj;
    }
}
