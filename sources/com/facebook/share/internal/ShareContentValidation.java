package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: ShareContentValidation.kt */
public final class ShareContentValidation {
    public static final ShareContentValidation INSTANCE = new ShareContentValidation();
    public static final Validator apiValidator = new ApiValidator();
    public static final Validator defaultValidator = new Validator();
    public static final Validator storyValidator = new StoryShareValidator();
    public static final Validator webShareValidator = new WebShareValidator();

    /* compiled from: ShareContentValidation.kt */
    public static final class ApiValidator extends Validator {
        public void validate(SharePhoto sharePhoto) {
            Intrinsics.checkNotNullParameter(sharePhoto, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
            ShareContentValidation.INSTANCE.validatePhotoForApi(sharePhoto, this);
        }

        public void validate(ShareVideoContent shareVideoContent) {
            Intrinsics.checkNotNullParameter(shareVideoContent, "videoContent");
            Utility utility = Utility.INSTANCE;
            if (Utility.isNullOrEmpty(shareVideoContent.getPlaceId())) {
                Utility utility2 = Utility.INSTANCE;
                if (Utility.isNullOrEmpty((Collection<?>) shareVideoContent.getPeopleIds())) {
                    Utility utility3 = Utility.INSTANCE;
                    if (!Utility.isNullOrEmpty(shareVideoContent.getRef())) {
                        throw new FacebookException("Cannot share video content with referrer URL using the share api");
                    }
                    return;
                }
                throw new FacebookException("Cannot share video content with people IDs using the share api");
            }
            throw new FacebookException("Cannot share video content with place IDs using the share api");
        }

        public void validate(ShareMediaContent shareMediaContent) {
            Intrinsics.checkNotNullParameter(shareMediaContent, "mediaContent");
            throw new FacebookException("Cannot share ShareMediaContent using the share api");
        }

        public void validate(ShareLinkContent shareLinkContent) {
            Intrinsics.checkNotNullParameter(shareLinkContent, "linkContent");
            Utility utility = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(shareLinkContent.getQuote())) {
                throw new FacebookException("Cannot share link content with quote using the share api");
            }
        }
    }

    /* compiled from: ShareContentValidation.kt */
    public static final class StoryShareValidator extends Validator {
        public void validate(ShareStoryContent shareStoryContent) {
            ShareContentValidation.INSTANCE.validateStoryContent(shareStoryContent, this);
        }
    }

    /* compiled from: ShareContentValidation.kt */
    public static class Validator {
        public boolean isOpenGraphContent;

        public final boolean isOpenGraphContent() {
            return this.isOpenGraphContent;
        }

        public void validate(ShareLinkContent shareLinkContent) {
            Intrinsics.checkNotNullParameter(shareLinkContent, "linkContent");
            ShareContentValidation.INSTANCE.validateLinkContent(shareLinkContent, this);
        }

        public void validate(SharePhotoContent sharePhotoContent) {
            Intrinsics.checkNotNullParameter(sharePhotoContent, "photoContent");
            ShareContentValidation.INSTANCE.validatePhotoContent(sharePhotoContent, this);
        }

        public void validate(ShareVideoContent shareVideoContent) {
            Intrinsics.checkNotNullParameter(shareVideoContent, "videoContent");
            ShareContentValidation.INSTANCE.validateVideoContent(shareVideoContent, this);
        }

        public void validate(ShareMediaContent shareMediaContent) {
            Intrinsics.checkNotNullParameter(shareMediaContent, "mediaContent");
            ShareContentValidation.INSTANCE.validateMediaContent(shareMediaContent, this);
        }

        public void validate(ShareCameraEffectContent shareCameraEffectContent) {
            Intrinsics.checkNotNullParameter(shareCameraEffectContent, "cameraEffectContent");
            ShareContentValidation.INSTANCE.validateCameraEffectContent(shareCameraEffectContent);
        }

        public void validate(ShareOpenGraphContent shareOpenGraphContent) {
            Intrinsics.checkNotNullParameter(shareOpenGraphContent, "openGraphContent");
            this.isOpenGraphContent = true;
            ShareContentValidation.INSTANCE.validateOpenGraphContent(shareOpenGraphContent, this);
        }

        public void validate(ShareOpenGraphAction shareOpenGraphAction) {
            ShareContentValidation.INSTANCE.validateOpenGraphAction(shareOpenGraphAction, this);
        }

        public void validate(ShareOpenGraphObject shareOpenGraphObject) {
            ShareContentValidation.INSTANCE.validateOpenGraphObject(shareOpenGraphObject, this);
        }

        public void validate(ShareOpenGraphValueContainer<?, ?> shareOpenGraphValueContainer, boolean z) {
            Intrinsics.checkNotNullParameter(shareOpenGraphValueContainer, "openGraphValueContainer");
            ShareContentValidation.INSTANCE.validateOpenGraphValueContainer(shareOpenGraphValueContainer, this, z);
        }

        public void validate(SharePhoto sharePhoto) {
            Intrinsics.checkNotNullParameter(sharePhoto, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
            ShareContentValidation.INSTANCE.validatePhotoForNativeDialog(sharePhoto, this);
        }

        public void validate(ShareVideo shareVideo) {
            ShareContentValidation.INSTANCE.validateVideo(shareVideo, this);
        }

        public void validate(ShareMedia<?, ?> shareMedia) {
            Intrinsics.checkNotNullParameter(shareMedia, FirebaseAnalytics.Param.MEDIUM);
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateMedium(shareMedia, this);
        }

        public void validate(ShareStoryContent shareStoryContent) {
            ShareContentValidation.INSTANCE.validateStoryContent(shareStoryContent, this);
        }
    }

    /* compiled from: ShareContentValidation.kt */
    public static final class WebShareValidator extends Validator {
        public void validate(ShareVideoContent shareVideoContent) {
            Intrinsics.checkNotNullParameter(shareVideoContent, "videoContent");
            throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
        }

        public void validate(ShareMediaContent shareMediaContent) {
            Intrinsics.checkNotNullParameter(shareMediaContent, "mediaContent");
            throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
        }

        public void validate(SharePhoto sharePhoto) {
            Intrinsics.checkNotNullParameter(sharePhoto, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
            ShareContentValidation.INSTANCE.validatePhotoForWebDialog(sharePhoto, this);
        }
    }

    private final void validate(ShareContent<?, ?> shareContent, Validator validator) throws FacebookException {
        if (shareContent == null) {
            throw new FacebookException("Must provide non-null content to share");
        } else if (shareContent instanceof ShareLinkContent) {
            validator.validate((ShareLinkContent) shareContent);
        } else if (shareContent instanceof SharePhotoContent) {
            validator.validate((SharePhotoContent) shareContent);
        } else if (shareContent instanceof ShareVideoContent) {
            validator.validate((ShareVideoContent) shareContent);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            validator.validate((ShareOpenGraphContent) shareContent);
        } else if (shareContent instanceof ShareMediaContent) {
            validator.validate((ShareMediaContent) shareContent);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            validator.validate((ShareCameraEffectContent) shareContent);
        } else if (shareContent instanceof ShareStoryContent) {
            validator.validate((ShareStoryContent) shareContent);
        }
    }

    /* access modifiers changed from: private */
    public final void validateCameraEffectContent(ShareCameraEffectContent shareCameraEffectContent) {
        String effectId = shareCameraEffectContent.getEffectId();
        Utility utility = Utility.INSTANCE;
        if (Utility.isNullOrEmpty(effectId)) {
            throw new FacebookException("Must specify a non-empty effectId");
        }
    }

    public static final void validateForApiShare(ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, apiValidator);
    }

    public static final void validateForMessage(ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, defaultValidator);
    }

    public static final void validateForNativeShare(ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, defaultValidator);
    }

    public static final void validateForStoryShare(ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, storyValidator);
    }

    public static final void validateForWebShare(ShareContent<?, ?> shareContent) {
        INSTANCE.validate(shareContent, webShareValidator);
    }

    /* access modifiers changed from: private */
    public final void validateLinkContent(ShareLinkContent shareLinkContent, Validator validator) {
        Uri contentUrl = shareLinkContent.getContentUrl();
        if (contentUrl != null) {
            Utility utility = Utility.INSTANCE;
            if (!Utility.isWebUri(contentUrl)) {
                throw new FacebookException("Content Url must be an http:// or https:// url");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void validateMediaContent(ShareMediaContent shareMediaContent, Validator validator) {
        List<ShareMedia<?, ?>> media = shareMediaContent.getMedia();
        if (media == null || media.isEmpty()) {
            throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
        } else if (media.size() <= 6) {
            for (ShareMedia<?, ?> validate : media) {
                validator.validate(validate);
            }
        } else {
            String format = String.format(Locale.ROOT, "Cannot add more than %d media.", Arrays.copyOf(new Object[]{6}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format);
        }
    }

    public static final void validateMedium(ShareMedia<?, ?> shareMedia, Validator validator) {
        Intrinsics.checkNotNullParameter(shareMedia, FirebaseAnalytics.Param.MEDIUM);
        Intrinsics.checkNotNullParameter(validator, "validator");
        if (shareMedia instanceof SharePhoto) {
            validator.validate((SharePhoto) shareMedia);
        } else if (shareMedia instanceof ShareVideo) {
            validator.validate((ShareVideo) shareMedia);
        } else {
            String format = String.format(Locale.ROOT, "Invalid media type: %s", Arrays.copyOf(new Object[]{shareMedia.getClass().getSimpleName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format);
        }
    }

    /* access modifiers changed from: private */
    public final void validateOpenGraphAction(ShareOpenGraphAction shareOpenGraphAction, Validator validator) {
        if (shareOpenGraphAction != null) {
            Utility utility = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(shareOpenGraphAction.getActionType())) {
                validator.validate(shareOpenGraphAction, false);
                return;
            }
            throw new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
        }
        throw new FacebookException("Must specify a non-null ShareOpenGraphAction");
    }

    /* access modifiers changed from: private */
    public final void validateOpenGraphContent(ShareOpenGraphContent shareOpenGraphContent, Validator validator) {
        validator.validate(shareOpenGraphContent.getAction());
        String previewPropertyName = shareOpenGraphContent.getPreviewPropertyName();
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(previewPropertyName)) {
            ShareOpenGraphAction action = shareOpenGraphContent.getAction();
            if (action == null || action.get(previewPropertyName) == null) {
                throw new FacebookException("Property \"" + previewPropertyName + "\" was not found on the action. The name of the preview property must match the name of an action property.");
            }
            return;
        }
        throw new FacebookException("Must specify a previewPropertyName.");
    }

    private final void validateOpenGraphKey(String str, boolean z) {
        boolean z2;
        if (z) {
            Object[] array = CharsKt__CharKt.split$default(str, new String[]{CertificateUtil.DELIMITER}, false, 0, 6).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length >= 2) {
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        String str2 = strArr[i];
                        i++;
                        if (str2.length() == 0) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            throw new FacebookException("Invalid key found in Open Graph dictionary: %s", str);
                        }
                    }
                    return;
                }
                throw new FacebookException("Open Graph keys must be namespaced: %s", str);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    /* access modifiers changed from: private */
    public final void validateOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject, Validator validator) {
        if (shareOpenGraphObject != null) {
            validator.validate(shareOpenGraphObject, true);
            return;
        }
        throw new FacebookException("Cannot share a null ShareOpenGraphObject");
    }

    /* access modifiers changed from: private */
    public final void validateOpenGraphValueContainer(ShareOpenGraphValueContainer<?, ?> shareOpenGraphValueContainer, Validator validator, boolean z) {
        for (String next : shareOpenGraphValueContainer.keySet()) {
            Intrinsics.checkNotNullExpressionValue(next, "key");
            validateOpenGraphKey(next, z);
            Object obj = shareOpenGraphValueContainer.get(next);
            if (obj instanceof List) {
                for (Object next2 : (List) obj) {
                    if (next2 != null) {
                        validateOpenGraphValueContainerObject(next2, validator);
                    } else {
                        throw new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                    }
                }
                continue;
            } else {
                validateOpenGraphValueContainerObject(obj, validator);
            }
        }
    }

    private final void validateOpenGraphValueContainerObject(Object obj, Validator validator) {
        if (obj instanceof ShareOpenGraphObject) {
            validator.validate((ShareOpenGraphObject) obj);
        } else if (obj instanceof SharePhoto) {
            validator.validate((SharePhoto) obj);
        }
    }

    private final void validatePhoto(SharePhoto sharePhoto) {
        if (sharePhoto != null) {
            Bitmap bitmap = sharePhoto.getBitmap();
            Uri imageUrl = sharePhoto.getImageUrl();
            if (bitmap == null && imageUrl == null) {
                throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
            }
            return;
        }
        throw new FacebookException("Cannot share a null SharePhoto");
    }

    /* access modifiers changed from: private */
    public final void validatePhotoContent(SharePhotoContent sharePhotoContent, Validator validator) {
        List<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos == null || photos.isEmpty()) {
            throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
        } else if (photos.size() <= 6) {
            for (SharePhoto validate : photos) {
                validator.validate(validate);
            }
        } else {
            String format = String.format(Locale.ROOT, "Cannot add more than %d photos.", Arrays.copyOf(new Object[]{6}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format);
        }
    }

    /* access modifiers changed from: private */
    public final void validatePhotoForApi(SharePhoto sharePhoto, Validator validator) {
        validatePhoto(sharePhoto);
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null) {
            Utility utility = Utility.INSTANCE;
            if (Utility.isWebUri(imageUrl) && !validator.isOpenGraphContent()) {
                throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void validatePhotoForNativeDialog(SharePhoto sharePhoto, Validator validator) {
        validatePhotoForApi(sharePhoto, validator);
        if (sharePhoto.getBitmap() == null) {
            Utility utility = Utility.INSTANCE;
            if (Utility.isWebUri(sharePhoto.getImageUrl())) {
                return;
            }
        }
        Validate validate = Validate.INSTANCE;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Validate.hasContentProvider(FacebookSdk.getApplicationContext());
    }

    /* access modifiers changed from: private */
    public final void validatePhotoForWebDialog(SharePhoto sharePhoto, Validator validator) {
        validatePhoto(sharePhoto);
    }

    private final void validateShareMessengerActionButton(ShareMessengerActionButton shareMessengerActionButton) {
        if (shareMessengerActionButton != null) {
            Utility utility = Utility.INSTANCE;
            if (Utility.isNullOrEmpty(shareMessengerActionButton.getTitle())) {
                throw new FacebookException("Must specify title for ShareMessengerActionButton");
            } else if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                validateShareMessengerURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton);
            }
        }
    }

    private final void validateShareMessengerURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (shareMessengerURLActionButton.getUrl() == null) {
            throw new FacebookException("Must specify url for ShareMessengerURLActionButton");
        }
    }

    /* access modifiers changed from: private */
    public final void validateStoryContent(ShareStoryContent shareStoryContent, Validator validator) {
        if (shareStoryContent == null || (shareStoryContent.getBackgroundAsset() == null && shareStoryContent.getStickerAsset() == null)) {
            throw new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
        }
        if (shareStoryContent.getBackgroundAsset() != null) {
            validator.validate(shareStoryContent.getBackgroundAsset());
        }
        if (shareStoryContent.getStickerAsset() != null) {
            validator.validate(shareStoryContent.getStickerAsset());
        }
    }

    /* access modifiers changed from: private */
    public final void validateVideo(ShareVideo shareVideo, Validator validator) {
        if (shareVideo != null) {
            Uri localUrl = shareVideo.getLocalUrl();
            if (localUrl != null) {
                Utility utility = Utility.INSTANCE;
                if (!Utility.isContentUri(localUrl)) {
                    Utility utility2 = Utility.INSTANCE;
                    if (!Utility.isFileUri(localUrl)) {
                        throw new FacebookException("ShareVideo must reference a video that is on the device");
                    }
                    return;
                }
                return;
            }
            throw new FacebookException("ShareVideo does not have a LocalUrl specified");
        }
        throw new FacebookException("Cannot share a null ShareVideo");
    }

    /* access modifiers changed from: private */
    public final void validateVideoContent(ShareVideoContent shareVideoContent, Validator validator) {
        validator.validate(shareVideoContent.getVideo());
        SharePhoto previewPhoto = shareVideoContent.getPreviewPhoto();
        if (previewPhoto != null) {
            validator.validate(previewPhoto);
        }
    }
}
