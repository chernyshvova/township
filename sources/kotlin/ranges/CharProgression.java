package kotlin.ranges;

import com.android.billingclient.api.zzam;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Progressions.kt */
public class CharProgression implements Iterable<Character>, KMappedMarker {
    public final char first;
    public final char last;
    public final int step;

    public CharProgression(char c, char c2, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i != Integer.MIN_VALUE) {
            this.first = c;
            this.last = (char) zzam.getProgressionLastElement(c, c2, i);
            this.step = i;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public Iterator iterator() {
        return new CharProgressionIterator(this.first, this.last, this.step);
    }
}
