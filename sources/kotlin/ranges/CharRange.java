package kotlin.ranges;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Ranges.kt */
public final class CharRange extends CharProgression implements ClosedRange<Character> {
    static {
        new CharRange((char) 1, (char) 0);
    }

    public CharRange(char c, char c2) {
        super(c, c2, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CharRange) {
            if (!isEmpty() || !((CharRange) obj).isEmpty()) {
                CharRange charRange = (CharRange) obj;
                if (!(this.first == charRange.first && this.last == charRange.last)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Comparable getEndInclusive() {
        return Character.valueOf(this.last);
    }

    public Comparable getStart() {
        return Character.valueOf(this.first);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.first * 31) + this.last;
    }

    public boolean isEmpty() {
        return Intrinsics.compare(this.first, this.last) > 0;
    }

    public String toString() {
        return this.first + ".." + this.last;
    }
}
