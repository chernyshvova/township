package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.sequences.Sequence;

/* compiled from: ViewGroup.kt */
public final class ViewGroupKt$children$1 implements Sequence<View> {
    public final /* synthetic */ ViewGroup $this_children;

    public ViewGroupKt$children$1(ViewGroup viewGroup) {
        this.$this_children = viewGroup;
    }

    public Iterator<View> iterator() {
        return ViewGroupKt.iterator(this.$this_children);
    }
}
