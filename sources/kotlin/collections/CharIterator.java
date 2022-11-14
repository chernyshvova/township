package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.CharProgressionIterator;

/* compiled from: Iterators.kt */
public abstract class CharIterator implements Iterator<Character>, KMappedMarker {
    public Object next() {
        CharProgressionIterator charProgressionIterator = (CharProgressionIterator) this;
        int i = charProgressionIterator.next;
        if (i != charProgressionIterator.finalElement) {
            charProgressionIterator.next = charProgressionIterator.step + i;
        } else if (charProgressionIterator.hasNext) {
            charProgressionIterator.hasNext = false;
        } else {
            throw new NoSuchElementException();
        }
        return Character.valueOf((char) i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
