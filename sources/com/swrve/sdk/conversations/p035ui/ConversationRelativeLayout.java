package com.swrve.sdk.conversations.p035ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.swrve.sdk.conversations.C1694R;

/* renamed from: com.swrve.sdk.conversations.ui.ConversationRelativeLayout */
public class ConversationRelativeLayout extends RelativeLayout {
    public final int maxModalWidthPx;
    public final int topBottomPaddingPx;

    public ConversationRelativeLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = com.swrve.sdk.conversations.C1694R.C1696id.swrve__conversation_modal
            android.view.View r0 = r7.findViewById(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0014
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.String r9 = "ConversationRelativeLayout missing swrve__conversation_modal layout in xml."
            com.swrve.sdk.SwrveLogger.m2754e(r9, r8)
            goto L_0x0057
        L_0x0014:
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r2 = (android.widget.RelativeLayout.LayoutParams) r2
            int r3 = r7.getMeasuredWidth()
            int r4 = r7.maxModalWidthPx
            r5 = 1
            if (r3 <= r4) goto L_0x003b
            int r3 = r2.bottomMargin
            int r4 = r7.topBottomPaddingPx
            r6 = -2
            if (r3 != r4) goto L_0x0032
            int r3 = r2.topMargin
            if (r3 != r4) goto L_0x0032
            int r3 = r2.height
            if (r3 == r6) goto L_0x004f
        L_0x0032:
            int r1 = r7.topBottomPaddingPx
            r2.topMargin = r1
            r2.bottomMargin = r1
            r2.height = r6
            goto L_0x004e
        L_0x003b:
            int r3 = r2.bottomMargin
            r4 = -1
            if (r3 != 0) goto L_0x0048
            int r3 = r2.topMargin
            if (r3 != 0) goto L_0x0048
            int r3 = r2.height
            if (r3 == r4) goto L_0x004f
        L_0x0048:
            r2.topMargin = r1
            r2.bottomMargin = r1
            r2.height = r4
        L_0x004e:
            r1 = 1
        L_0x004f:
            if (r1 == 0) goto L_0x0057
            r0.setLayoutParams(r2)
            super.onMeasure(r8, r9)
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.conversations.p035ui.ConversationRelativeLayout.onMeasure(int, int):void");
    }

    public ConversationRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConversationRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setFocusable(false);
        this.topBottomPaddingPx = getResources().getDimensionPixelSize(C1694R.dimen.swrve__conversation_min_modal_top_bottom_padding);
        this.maxModalWidthPx = getResources().getDimensionPixelSize(C1694R.dimen.swrve__conversation_max_modal_width);
    }
}
