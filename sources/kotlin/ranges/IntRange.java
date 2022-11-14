package kotlin.ranges;

/* compiled from: Ranges.kt */
public final class IntRange extends IntProgression implements ClosedRange<Integer> {
    public static final IntRange Companion = null;
    public static final IntRange EMPTY = new IntRange(1, 0);

    public IntRange(int i, int i2) {
        super(i, i2, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntRange) {
            if (!isEmpty() || !((IntRange) obj).isEmpty()) {
                IntRange intRange = (IntRange) obj;
                if (!(this.first == intRange.first && this.last == intRange.last)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.first * 31) + this.last;
    }

    public boolean isEmpty() {
        return this.first > this.last;
    }

    public String toString() {
        return this.first + ".." + this.last;
    }

    public Integer getEndInclusive() {
        return Integer.valueOf(this.last);
    }

    public Integer getStart() {
        return Integer.valueOf(this.first);
    }
}
