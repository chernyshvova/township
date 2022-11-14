package androidx.core.graphics;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.android.tools.p006r8.GeneratedOutlineSupport;

public final class PathSegment {
    public final PointF mEnd;
    public final float mEndFraction;
    public final PointF mStart;
    public final float mStartFraction;

    public PathSegment(@NonNull PointF pointF, float f, @NonNull PointF pointF2, float f2) {
        this.mStart = (PointF) Preconditions.checkNotNull(pointF, "start == null");
        this.mStartFraction = f;
        this.mEnd = (PointF) Preconditions.checkNotNull(pointF2, "end == null");
        this.mEndFraction = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        if (Float.compare(this.mStartFraction, pathSegment.mStartFraction) != 0 || Float.compare(this.mEndFraction, pathSegment.mEndFraction) != 0 || !this.mStart.equals(pathSegment.mStart) || !this.mEnd.equals(pathSegment.mEnd)) {
            return false;
        }
        return true;
    }

    @NonNull
    public PointF getEnd() {
        return this.mEnd;
    }

    public float getEndFraction() {
        return this.mEndFraction;
    }

    @NonNull
    public PointF getStart() {
        return this.mStart;
    }

    public float getStartFraction() {
        return this.mStartFraction;
    }

    public int hashCode() {
        int hashCode = this.mStart.hashCode() * 31;
        float f = this.mStartFraction;
        int i = 0;
        int hashCode2 = (this.mEnd.hashCode() + ((hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31)) * 31;
        float f2 = this.mEndFraction;
        if (f2 != 0.0f) {
            i = Float.floatToIntBits(f2);
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("PathSegment{start=");
        outline24.append(this.mStart);
        outline24.append(", startFraction=");
        outline24.append(this.mStartFraction);
        outline24.append(", end=");
        outline24.append(this.mEnd);
        outline24.append(", endFraction=");
        outline24.append(this.mEndFraction);
        outline24.append('}');
        return outline24.toString();
    }
}
