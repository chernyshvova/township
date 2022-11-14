package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.sequences.Sequence;

/* compiled from: Menu.kt */
public final class MenuKt$children$1 implements Sequence<MenuItem> {
    public final /* synthetic */ Menu $this_children;

    public MenuKt$children$1(Menu menu) {
        this.$this_children = menu;
    }

    public Iterator<MenuItem> iterator() {
        return MenuKt.iterator(this.$this_children);
    }
}
