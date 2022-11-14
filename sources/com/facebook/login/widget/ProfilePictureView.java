package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.C1563R;

public class ProfilePictureView extends FrameLayout {
    public static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
    public static final String BITMAP_KEY = "ProfilePictureView_bitmap";
    public static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
    public static final int CUSTOM = -1;
    public static final boolean IS_CROPPED_DEFAULT_VALUE = true;
    public static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
    public static final int LARGE = -4;
    public static final int MIN_SIZE = 1;
    public static final int NORMAL = -3;
    public static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
    public static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
    public static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
    public static final int SMALL = -2;
    public static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
    public static final String TAG = ProfilePictureView.class.getSimpleName();
    public Bitmap customizedDefaultProfilePicture = null;
    public ImageView image;
    public Bitmap imageContents;
    public boolean isCropped = true;
    public ImageRequest lastRequest;
    public OnErrorListener onErrorListener;
    public int presetSizeType = -1;
    public String profileId;
    public ProfileTracker profileTracker;
    public int queryHeight = 0;
    public int queryWidth = 0;

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public ProfilePictureView(Context context) {
        super(context);
        initialize(context);
    }

    private int getPresetSizeInPixels(boolean z) {
        int i;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            int i2 = this.presetSizeType;
            if (i2 == -4) {
                i = C1563R.dimen.com_facebook_profilepictureview_preset_size_large;
            } else if (i2 == -3) {
                i = C1563R.dimen.com_facebook_profilepictureview_preset_size_normal;
            } else if (i2 == -2) {
                i = C1563R.dimen.com_facebook_profilepictureview_preset_size_small;
            } else if (i2 != -1 || !z) {
                return 0;
            } else {
                i = C1563R.dimen.com_facebook_profilepictureview_preset_size_normal;
            }
            return getResources().getDimensionPixelSize(i);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    private void initialize(Context context) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                removeAllViews();
                this.image = new ImageView(context);
                this.image.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                addView(this.image);
                this.profileTracker = new ProfileTracker() {
                    public void onCurrentProfileChanged(Profile profile, Profile profile2) {
                        ProfilePictureView.this.setProfileId(profile2 != null ? profile2.getId() : null);
                        ProfilePictureView.this.refreshImage(true);
                    }
                };
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void parseAttributes(AttributeSet attributeSet) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1563R.styleable.com_facebook_profile_picture_view);
                setPresetSize(obtainStyledAttributes.getInt(C1563R.styleable.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
                this.isCropped = obtainStyledAttributes.getBoolean(C1563R.styleable.com_facebook_profile_picture_view_com_facebook_is_cropped, true);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void processResponse(ImageResponse imageResponse) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (imageResponse.getRequest() == this.lastRequest) {
                    this.lastRequest = null;
                    Bitmap bitmap = imageResponse.getBitmap();
                    Exception error = imageResponse.getError();
                    if (error != null) {
                        OnErrorListener onErrorListener2 = this.onErrorListener;
                        if (onErrorListener2 != null) {
                            onErrorListener2.onError(new FacebookException("Error in downloading profile picture for profileId: " + getProfileId(), (Throwable) error));
                            return;
                        }
                        Logger.log(LoggingBehavior.REQUESTS, 6, TAG, error.toString());
                    } else if (bitmap != null) {
                        setImageBitmap(bitmap);
                        if (imageResponse.isCachedRedirect()) {
                            sendImageRequest(false);
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void refreshImage(boolean z) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                boolean updateImageQueryParameters = updateImageQueryParameters();
                if (!(this.profileId == null || this.profileId.length() == 0)) {
                    if (this.queryWidth != 0 || this.queryHeight != 0) {
                        if (updateImageQueryParameters || z) {
                            sendImageRequest(true);
                            return;
                        }
                        return;
                    }
                }
                setBlankProfilePicture();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void sendImageRequest(boolean z) {
        Uri profilePictureUri;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Uri profilePictureUri2 = ImageRequest.getProfilePictureUri(this.profileId, this.queryWidth, this.queryHeight, AccessToken.isCurrentAccessTokenActive() ? AccessToken.getCurrentAccessToken().getToken() : "");
                Profile currentProfile = Profile.getCurrentProfile();
                if (!(!AccessToken.isLoggedInWithInstagram() || currentProfile == null || (profilePictureUri = currentProfile.getProfilePictureUri(this.queryWidth, this.queryHeight)) == null)) {
                    profilePictureUri2 = profilePictureUri;
                }
                ImageRequest build = new ImageRequest.Builder(getContext(), profilePictureUri2).setAllowCachedRedirects(z).setCallerTag(this).setCallback(new ImageRequest.Callback() {
                    public void onCompleted(ImageResponse imageResponse) {
                        ProfilePictureView.this.processResponse(imageResponse);
                    }
                }).build();
                if (this.lastRequest != null) {
                    ImageDownloader.cancelRequest(this.lastRequest);
                }
                this.lastRequest = build;
                ImageDownloader.downloadAsync(build);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void setBlankProfilePicture() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.lastRequest != null) {
                    ImageDownloader.cancelRequest(this.lastRequest);
                }
                if (this.customizedDefaultProfilePicture == null) {
                    setImageBitmap(BitmapFactory.decodeResource(getResources(), isCropped() ? C1563R.C1564drawable.com_facebook_profile_picture_blank_square : C1563R.C1564drawable.com_facebook_profile_picture_blank_portrait));
                    return;
                }
                updateImageQueryParameters();
                setImageBitmap(Bitmap.createScaledBitmap(this.customizedDefaultProfilePicture, this.queryWidth, this.queryHeight, false));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void setImageBitmap(Bitmap bitmap) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.image != null && bitmap != null) {
                    this.imageContents = bitmap;
                    this.image.setImageBitmap(bitmap);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private boolean updateImageQueryParameters() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            int height = getHeight();
            int width = getWidth();
            boolean z = true;
            if (width >= 1) {
                if (height >= 1) {
                    int presetSizeInPixels = getPresetSizeInPixels(false);
                    if (presetSizeInPixels != 0) {
                        height = presetSizeInPixels;
                        width = height;
                    }
                    if (width <= height) {
                        height = isCropped() ? width : 0;
                    } else {
                        width = isCropped() ? height : 0;
                    }
                    if (width == this.queryWidth) {
                        if (height == this.queryHeight) {
                            z = false;
                        }
                    }
                    this.queryWidth = width;
                    this.queryHeight = height;
                    return z;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public final OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final int getPresetSize() {
        return this.presetSizeType;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final boolean getShouldUpdateOnProfileChange() {
        return this.profileTracker.isTracking();
    }

    public final boolean isCropped() {
        return this.isCropped;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lastRequest = null;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        refreshImage(false);
    }

    public void onMeasure(int i, int i2) {
        boolean z;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        boolean z2 = true;
        if (View.MeasureSpec.getMode(i2) == 1073741824 || layoutParams.height != -2) {
            z = false;
        } else {
            size = getPresetSizeInPixels(true);
            i2 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            z = true;
        }
        if (View.MeasureSpec.getMode(i) == 1073741824 || layoutParams.width != -2) {
            z2 = z;
        } else {
            size2 = getPresetSizeInPixels(true);
            i = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        }
        if (z2) {
            setMeasuredDimension(size2, size);
            measureChildren(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(SUPER_STATE_KEY));
        this.profileId = bundle.getString(PROFILE_ID_KEY);
        this.presetSizeType = bundle.getInt(PRESET_SIZE_KEY);
        this.isCropped = bundle.getBoolean(IS_CROPPED_KEY);
        this.queryWidth = bundle.getInt(BITMAP_WIDTH_KEY);
        this.queryHeight = bundle.getInt(BITMAP_HEIGHT_KEY);
        refreshImage(true);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE_KEY, onSaveInstanceState);
        bundle.putString(PROFILE_ID_KEY, this.profileId);
        bundle.putInt(PRESET_SIZE_KEY, this.presetSizeType);
        bundle.putBoolean(IS_CROPPED_KEY, this.isCropped);
        bundle.putInt(BITMAP_WIDTH_KEY, this.queryWidth);
        bundle.putInt(BITMAP_HEIGHT_KEY, this.queryHeight);
        bundle.putBoolean(PENDING_REFRESH_KEY, this.lastRequest != null);
        return bundle;
    }

    public final void setCropped(boolean z) {
        this.isCropped = z;
        refreshImage(false);
    }

    public final void setDefaultProfilePicture(Bitmap bitmap) {
        this.customizedDefaultProfilePicture = bitmap;
    }

    public final void setOnErrorListener(OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    public final void setPresetSize(int i) {
        if (i == -4 || i == -3 || i == -2 || i == -1) {
            this.presetSizeType = i;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Must use a predefined preset size");
    }

    public final void setProfileId(@Nullable String str) {
        boolean z;
        if (Utility.isNullOrEmpty(this.profileId) || !this.profileId.equalsIgnoreCase(str)) {
            setBlankProfilePicture();
            z = true;
        } else {
            z = false;
        }
        this.profileId = str;
        refreshImage(z);
    }

    public final void setShouldUpdateOnProfileChange(boolean z) {
        if (z) {
            this.profileTracker.startTracking();
        } else {
            this.profileTracker.stopTracking();
        }
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
        parseAttributes(attributeSet);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context);
        parseAttributes(attributeSet);
    }
}
