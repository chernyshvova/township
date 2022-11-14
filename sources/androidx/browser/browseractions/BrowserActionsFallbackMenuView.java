package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.browser.C0133R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BrowserActionsFallbackMenuView extends LinearLayout {
    public final int mBrowserActionsMenuMaxWidthPx = getResources().getDimensionPixelOffset(C0133R.dimen.browser_actions_context_menu_max_width);
    public final int mBrowserActionsMenuMinPaddingPx = getResources().getDimensionPixelOffset(C0133R.dimen.browser_actions_context_menu_min_padding);

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.mBrowserActionsMenuMinPaddingPx * 2), this.mBrowserActionsMenuMaxWidthPx), 1073741824), i2);
    }
}
