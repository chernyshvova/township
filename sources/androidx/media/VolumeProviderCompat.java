package androidx.media;

import android.media.VolumeProvider;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    public Callback mCallback;
    public final String mControlId;
    public final int mControlType;
    public int mCurrentVolume;
    public final int mMaxVolume;
    public VolumeProvider mVolumeProviderFwk;

    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        this(i, i2, i3, (String) null);
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final String getVolumeControlId() {
        return this.mControlId;
    }

    public Object getVolumeProvider() {
        if (this.mVolumeProviderFwk == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.mVolumeProviderFwk = new VolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, this.mControlId) {
                    public void onAdjustVolume(int i) {
                        VolumeProviderCompat.this.onAdjustVolume(i);
                    }

                    public void onSetVolumeTo(int i) {
                        VolumeProviderCompat.this.onSetVolumeTo(i);
                    }
                };
            } else if (i >= 21) {
                this.mVolumeProviderFwk = new VolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume) {
                    public void onAdjustVolume(int i) {
                        VolumeProviderCompat.this.onAdjustVolume(i);
                    }

                    public void onSetVolumeTo(int i) {
                        VolumeProviderCompat.this.onSetVolumeTo(i);
                    }
                };
            }
        }
        return this.mVolumeProviderFwk;
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public final void setCurrentVolume(int i) {
        this.mCurrentVolume = i;
        if (Build.VERSION.SDK_INT >= 21) {
            ((VolumeProvider) getVolumeProvider()).setCurrentVolume(i);
        }
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public VolumeProviderCompat(int i, int i2, int i3, @Nullable String str) {
        this.mControlType = i;
        this.mMaxVolume = i2;
        this.mCurrentVolume = i3;
        this.mControlId = str;
    }
}
