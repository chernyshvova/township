package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zai extends Drawable.ConstantState {
    public int zaa;
    public int zab;

    public zai(@Nullable zai zai) {
        if (zai != null) {
            this.zaa = zai.zaa;
            this.zab = zai.zab;
        }
    }

    public final int getChangingConfigurations() {
        return this.zaa;
    }

    public final Drawable newDrawable() {
        return new zaf(this);
    }
}
