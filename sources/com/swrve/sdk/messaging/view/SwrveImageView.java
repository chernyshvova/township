package com.swrve.sdk.messaging.view;

import android.content.Context;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;

public class SwrveImageView extends AppCompatImageView {
    public SwrveImageView(Context context) {
        super(context);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
