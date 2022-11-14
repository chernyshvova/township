package com.swrve.sdk.conversations.p035ui;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;

/* renamed from: com.swrve.sdk.conversations.ui.ConversationImageView */
public class ConversationImageView extends AppCompatImageView {
    public ConversationImageView(Context context) {
        super(context);
        setFocusable(false);
    }

    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        setMeasuredDimension(size, intrinsicWidth > 0 ? (getDrawable().getIntrinsicHeight() * size) / intrinsicWidth : size);
    }
}
