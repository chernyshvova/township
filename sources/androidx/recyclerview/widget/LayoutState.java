package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.p006r8.GeneratedOutlineSupport;

public class LayoutState {
    public static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    public static final int ITEM_DIRECTION_HEAD = -1;
    public static final int ITEM_DIRECTION_TAIL = 1;
    public static final int LAYOUT_END = 1;
    public static final int LAYOUT_START = -1;
    public static final String TAG = "LayoutState";
    public int mAvailable;
    public int mCurrentPosition;
    public int mEndLine = 0;
    public boolean mInfinite;
    public int mItemDirection;
    public int mLayoutDirection;
    public boolean mRecycle = true;
    public int mStartLine = 0;
    public boolean mStopInFocusable;

    public boolean hasMore(RecyclerView.State state) {
        int i = this.mCurrentPosition;
        return i >= 0 && i < state.getItemCount();
    }

    public View next(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return viewForPosition;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("LayoutState{mAvailable=");
        outline24.append(this.mAvailable);
        outline24.append(", mCurrentPosition=");
        outline24.append(this.mCurrentPosition);
        outline24.append(", mItemDirection=");
        outline24.append(this.mItemDirection);
        outline24.append(", mLayoutDirection=");
        outline24.append(this.mLayoutDirection);
        outline24.append(", mStartLine=");
        outline24.append(this.mStartLine);
        outline24.append(", mEndLine=");
        outline24.append(this.mEndLine);
        outline24.append('}');
        return outline24.toString();
    }
}
