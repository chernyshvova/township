package com.swrve.sdk.messaging.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.swrve.sdk.messaging.SwrveActionType;

public abstract class SwrveBaseInteractableView extends AppCompatImageView {
    public int clickColor;
    public int focusColor;
    public SwrveActionType type;

    public SwrveBaseInteractableView(Context context, SwrveActionType swrveActionType, int i, int i2) {
        super(context);
        this.type = swrveActionType;
        this.focusColor = i;
        this.clickColor = i2;
    }

    public abstract String getAction();

    public SwrveActionType getType() {
        return this.type;
    }

    public void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            clearColorFilter();
        } else {
            setColorFilter(this.focusColor);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setColorFilter(this.clickColor);
            invalidate();
        } else if (action == 1) {
            clearColorFilter();
        }
        return super.onTouchEvent(motionEvent);
    }
}
