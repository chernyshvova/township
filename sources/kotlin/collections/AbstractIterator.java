package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.p038io.FileTreeWalk;

/* compiled from: AbstractIterator.kt */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    public T nextValue;
    public State state = State.NotReady;

    public boolean hasNext() {
        T t;
        State state2 = State.Failed;
        if (this.state != state2) {
            int ordinal = this.state.ordinal();
            if (ordinal == 0) {
                return true;
            }
            if (ordinal != 2) {
                State state3 = State.Ready;
                this.state = state2;
                FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator = (FileTreeWalk.FileTreeWalkIterator) this;
                while (true) {
                    FileTreeWalk.WalkState peek = fileTreeWalkIterator.state.peek();
                    if (peek == null) {
                        t = null;
                        break;
                    }
                    t = peek.step();
                    if (t != null) {
                        if (Intrinsics.areEqual(t, peek.root) || !t.isDirectory() || fileTreeWalkIterator.state.size() >= FileTreeWalk.this.maxDepth) {
                            break;
                        }
                        fileTreeWalkIterator.state.push(fileTreeWalkIterator.directoryState(t));
                    } else {
                        fileTreeWalkIterator.state.pop();
                    }
                }
                if (t != null) {
                    fileTreeWalkIterator.nextValue = t;
                    fileTreeWalkIterator.state = state3;
                } else {
                    fileTreeWalkIterator.state = State.Done;
                }
                if (this.state == state3) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public T next() {
        if (hasNext()) {
            this.state = State.NotReady;
            return this.nextValue;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
