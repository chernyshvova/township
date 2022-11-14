package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;

/* compiled from: CameraEffectFeature.kt */
public enum CameraEffectFeature implements DialogFeature {
    SHARE_CAMERA_EFFECT(NativeProtocol.PROTOCOL_VERSION_20170417);
    
    public final int minVersion;

    /* access modifiers changed from: public */
    CameraEffectFeature(int i) {
        this.minVersion = i;
    }

    public String getAction() {
        return NativeProtocol.ACTION_CAMERA_EFFECT;
    }

    public int getMinVersion() {
        return this.minVersion;
    }
}
