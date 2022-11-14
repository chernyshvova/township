package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Region.kt */
public final class RegionKt$iterator$1 implements Iterator<Rect>, KMappedMarker {
    public final /* synthetic */ Region $this_iterator;
    public boolean hasMore;
    public final RegionIterator iterator = new RegionIterator(this.$this_iterator);
    public final Rect rect;

    public RegionKt$iterator$1(Region region) {
        this.$this_iterator = region;
        Rect rect2 = new Rect();
        this.rect = rect2;
        this.hasMore = this.iterator.next(rect2);
    }

    public boolean hasNext() {
        return this.hasMore;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Rect next() {
        if (this.hasMore) {
            Rect rect2 = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return rect2;
        }
        throw new IndexOutOfBoundsException();
    }
}
