package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;

/* compiled from: Menu.kt */
public final class MenuKt$iterator$1 implements Iterator<MenuItem>, Object {
    public final /* synthetic */ Menu $this_iterator;
    public int index;

    public MenuKt$iterator$1(Menu menu) {
        this.$this_iterator = menu;
    }

    public boolean hasNext() {
        return this.index < this.$this_iterator.size();
    }

    public void remove() {
        Menu menu = this.$this_iterator;
        int i = this.index - 1;
        this.index = i;
        menu.removeItem(i);
    }

    public MenuItem next() {
        Menu menu = this.$this_iterator;
        int i = this.index;
        this.index = i + 1;
        MenuItem item = menu.getItem(i);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }
}
