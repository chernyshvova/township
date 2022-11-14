package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NativeDialogParameters.kt */
public final class NativeDialogParameters {
    public static final NativeDialogParameters INSTANCE = new NativeDialogParameters();

    public static final Bundle create(UUID uuid, ShareContent<?, ?> shareContent, boolean z) {
        Intrinsics.checkNotNullParameter(uuid, "callId");
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        if (shareContent instanceof ShareLinkContent) {
            return INSTANCE.create((ShareLinkContent) shareContent, z);
        }
        if (shareContent instanceof SharePhotoContent) {
            ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            List photoUrls = ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid);
            if (photoUrls == null) {
                photoUrls = EmptyList.INSTANCE;
            }
            return INSTANCE.create(sharePhotoContent, (List<String>) photoUrls, z);
        } else if (shareContent instanceof ShareVideoContent) {
            ShareInternalUtility shareInternalUtility2 = ShareInternalUtility.INSTANCE;
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            return INSTANCE.create(shareVideoContent, ShareInternalUtility.getVideoUrl(shareVideoContent, uuid), z);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            try {
                ShareInternalUtility shareInternalUtility3 = ShareInternalUtility.INSTANCE;
                JSONObject jSONObjectForCall = ShareInternalUtility.toJSONObjectForCall(uuid, (ShareOpenGraphContent) shareContent);
                ShareInternalUtility shareInternalUtility4 = ShareInternalUtility.INSTANCE;
                return INSTANCE.create((ShareOpenGraphContent) shareContent, ShareInternalUtility.removeNamespacesFromOGJsonObject(jSONObjectForCall, false), z);
            } catch (JSONException e) {
                throw new FacebookException(Intrinsics.stringPlus("Unable to create a JSON Object from the provided ShareOpenGraphContent: ", e.getMessage()));
            }
        } else if (shareContent instanceof ShareMediaContent) {
            ShareInternalUtility shareInternalUtility5 = ShareInternalUtility.INSTANCE;
            ShareMediaContent shareMediaContent = (ShareMediaContent) shareContent;
            List mediaInfos = ShareInternalUtility.getMediaInfos(shareMediaContent, uuid);
            if (mediaInfos == null) {
                mediaInfos = EmptyList.INSTANCE;
            }
            return INSTANCE.create(shareMediaContent, (List<Bundle>) mediaInfos, z);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            ShareInternalUtility shareInternalUtility6 = ShareInternalUtility.INSTANCE;
            ShareCameraEffectContent shareCameraEffectContent = (ShareCameraEffectContent) shareContent;
            return INSTANCE.create(shareCameraEffectContent, ShareInternalUtility.getTextureUrlBundle(shareCameraEffectContent, uuid), z);
        } else if (!(shareContent instanceof ShareStoryContent)) {
            return null;
        } else {
            ShareInternalUtility shareInternalUtility7 = ShareInternalUtility.INSTANCE;
            ShareStoryContent shareStoryContent = (ShareStoryContent) shareContent;
            Bundle backgroundAssetMediaInfo = ShareInternalUtility.getBackgroundAssetMediaInfo(shareStoryContent, uuid);
            ShareInternalUtility shareInternalUtility8 = ShareInternalUtility.INSTANCE;
            return INSTANCE.create(shareStoryContent, backgroundAssetMediaInfo, ShareInternalUtility.getStickerUrl(shareStoryContent, uuid), z);
        }
    }

    private final Bundle createBaseParameters(ShareContent<?, ?> shareContent, boolean z) {
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putUri(bundle, ShareConstants.CONTENT_URL, shareContent.getContentUrl());
        Utility utility2 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, ShareConstants.PLACE_ID, shareContent.getPlaceId());
        Utility utility3 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, ShareConstants.PAGE_ID, shareContent.getPageId());
        Utility utility4 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, ShareConstants.REF, shareContent.getRef());
        Utility utility5 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, ShareConstants.REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.DATA_FAILURES_FATAL, z);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (!(peopleIds == null || peopleIds.isEmpty())) {
            bundle.putStringArrayList(ShareConstants.PEOPLE_IDS, new ArrayList(peopleIds));
        }
        Utility utility6 = Utility.INSTANCE;
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        Utility.putNonEmptyString(bundle, ShareConstants.HASHTAG, shareHashtag == null ? null : shareHashtag.getHashtag());
        return bundle;
    }

    private final Bundle create(ShareCameraEffectContent shareCameraEffectContent, Bundle bundle, boolean z) {
        Bundle createBaseParameters = createBaseParameters(shareCameraEffectContent, z);
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.EFFECT_ID, shareCameraEffectContent.getEffectId());
        if (bundle != null) {
            createBaseParameters.putBundle(ShareConstants.EFFECT_TEXTURES, bundle);
        }
        try {
            CameraEffectJSONUtility cameraEffectJSONUtility = CameraEffectJSONUtility.INSTANCE;
            JSONObject convertToJSON = CameraEffectJSONUtility.convertToJSON(shareCameraEffectContent.getArguments());
            if (convertToJSON != null) {
                Utility utility2 = Utility.INSTANCE;
                Utility.putNonEmptyString(createBaseParameters, ShareConstants.EFFECT_ARGS, convertToJSON.toString());
            }
            return createBaseParameters;
        } catch (JSONException e) {
            throw new FacebookException(Intrinsics.stringPlus("Unable to create a JSON Object from the provided CameraEffectArguments: ", e.getMessage()));
        }
    }

    private final Bundle create(ShareLinkContent shareLinkContent, boolean z) {
        Bundle createBaseParameters = createBaseParameters(shareLinkContent, z);
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.QUOTE, shareLinkContent.getQuote());
        Utility utility2 = Utility.INSTANCE;
        Utility.putUri(createBaseParameters, ShareConstants.MESSENGER_URL, shareLinkContent.getContentUrl());
        Utility utility3 = Utility.INSTANCE;
        Utility.putUri(createBaseParameters, ShareConstants.TARGET_DISPLAY, shareLinkContent.getContentUrl());
        return createBaseParameters;
    }

    private final Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent, z);
        createBaseParameters.putStringArrayList(ShareConstants.PHOTOS, new ArrayList(list));
        return createBaseParameters;
    }

    private final Bundle create(ShareVideoContent shareVideoContent, String str, boolean z) {
        Bundle createBaseParameters = createBaseParameters(shareVideoContent, z);
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.TITLE, shareVideoContent.getContentTitle());
        Utility utility2 = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.DESCRIPTION, shareVideoContent.getContentDescription());
        Utility utility3 = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.VIDEO_URL, str);
        return createBaseParameters;
    }

    private final Bundle create(ShareMediaContent shareMediaContent, List<Bundle> list, boolean z) {
        Bundle createBaseParameters = createBaseParameters(shareMediaContent, z);
        createBaseParameters.putParcelableArrayList(ShareConstants.MEDIA, new ArrayList(list));
        return createBaseParameters;
    }

    private final Bundle create(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        String str;
        Bundle createBaseParameters = createBaseParameters(shareOpenGraphContent, z);
        String previewPropertyName = shareOpenGraphContent.getPreviewPropertyName();
        String str2 = null;
        if (previewPropertyName == null) {
            str = null;
        } else {
            ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
            str = (String) ShareInternalUtility.getFieldNameAndNamespaceFromFullName(previewPropertyName).second;
        }
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.PREVIEW_PROPERTY_NAME, str);
        Utility utility2 = Utility.INSTANCE;
        ShareOpenGraphAction action = shareOpenGraphContent.getAction();
        if (action != null) {
            str2 = action.getActionType();
        }
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.ACTION_TYPE, str2);
        Utility utility3 = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.ACTION, String.valueOf(jSONObject));
        return createBaseParameters;
    }

    private final Bundle create(ShareStoryContent shareStoryContent, Bundle bundle, Bundle bundle2, boolean z) {
        Bundle createBaseParameters = createBaseParameters(shareStoryContent, z);
        if (bundle != null) {
            createBaseParameters.putParcelable(ShareConstants.STORY_BG_ASSET, bundle);
        }
        if (bundle2 != null) {
            createBaseParameters.putParcelable(ShareConstants.STORY_INTERACTIVE_ASSET_URI, bundle2);
        }
        List<String> backgroundColorList = shareStoryContent.getBackgroundColorList();
        if (!(backgroundColorList == null || backgroundColorList.isEmpty())) {
            createBaseParameters.putStringArrayList(ShareConstants.STORY_INTERACTIVE_COLOR_LIST, new ArrayList(backgroundColorList));
        }
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.STORY_DEEP_LINK_URL, shareStoryContent.getAttributionLink());
        return createBaseParameters;
    }
}
