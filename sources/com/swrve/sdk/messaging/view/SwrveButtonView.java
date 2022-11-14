package com.swrve.sdk.messaging.view;

import android.content.Context;
import com.swrve.sdk.messaging.SwrveActionType;

public class SwrveButtonView extends SwrveBaseInteractableView {
    public String action;

    public SwrveButtonView(Context context, SwrveActionType swrveActionType, int i, int i2, String str) {
        super(context, swrveActionType, i, i2);
        setFocusable(true);
        this.action = str;
    }

    public String getAction() {
        return this.action;
    }
}
