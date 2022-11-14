package com.facebook.share.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import com.facebook.common.C1541R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.C1579R;

public final class ShareButton extends ShareButtonBase {
    public ShareButton(Context context) {
        super(context, (AttributeSet) null, 0, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), C1541R.C1542drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    }

    public int getDefaultStyleResource() {
        return C1579R.style.com_facebook_button_share;
    }

    public ShareDialog getDialog() {
        ShareDialog shareDialog;
        if (getFragment() != null) {
            shareDialog = new ShareDialog(getFragment(), getRequestCode());
        } else if (getNativeFragment() != null) {
            shareDialog = new ShareDialog(getNativeFragment(), getRequestCode());
        } else {
            shareDialog = new ShareDialog(getActivity(), getRequestCode());
        }
        shareDialog.setCallbackManager(getCallbackManager());
        return shareDialog;
    }

    public ShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    public ShareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }
}
