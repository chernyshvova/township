package com.helpshift.support.conversations.smartintent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.helpshift.C2466R;
import com.helpshift.views.bottomsheet.HSBottomSheetBehaviour;

public class SmartIntentBottomSheetBehavior<V extends View> extends HSBottomSheetBehaviour<V> {
    public SmartIntentBottomSheetBehavior() {
    }

    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view) {
        if (v.getId() == C2466R.C2468id.hs__si_scrollable_view_container && view.getId() == C2466R.C2468id.reply_footer_container) {
            return true;
        }
        return super.layoutDependsOn(coordinatorLayout, v, view);
    }

    public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view) {
        if (v.getId() != C2466R.C2468id.hs__si_scrollable_view_container || view.getId() != C2466R.C2468id.reply_footer_container) {
            return super.onDependentViewChanged(coordinatorLayout, v, view);
        }
        v.setPadding(v.getPaddingLeft(), v.getPaddingTop(), v.getPaddingRight(), view.getHeight());
        return true;
    }

    public SmartIntentBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
