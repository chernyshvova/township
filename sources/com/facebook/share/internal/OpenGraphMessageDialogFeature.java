package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;

public enum OpenGraphMessageDialogFeature implements DialogFeature {
    OG_MESSAGE_DIALOG(NativeProtocol.PROTOCOL_VERSION_20140204);
    
    public int minVersion;

    /* access modifiers changed from: public */
    OpenGraphMessageDialogFeature(int i) {
        this.minVersion = i;
    }

    public String getAction() {
        return NativeProtocol.ACTION_OGMESSAGEPUBLISH_DIALOG;
    }

    public int getMinVersion() {
        return this.minVersion;
    }
}
