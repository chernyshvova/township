package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LegacyNativeDialogParameters.kt */
public final class LegacyNativeDialogParameters {
    public static final LegacyNativeDialogParameters INSTANCE = new LegacyNativeDialogParameters();

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
        } else if ((shareContent instanceof ShareVideoContent) || !(shareContent instanceof ShareOpenGraphContent)) {
            return null;
        } else {
            try {
                ShareInternalUtility shareInternalUtility2 = ShareInternalUtility.INSTANCE;
                return INSTANCE.create((ShareOpenGraphContent) shareContent, ShareInternalUtility.toJSONObjectForCall(uuid, (ShareOpenGraphContent) shareContent), z);
            } catch (JSONException e) {
                throw new FacebookException(Intrinsics.stringPlus("Unable to create a JSON Object from the provided ShareOpenGraphContent: ", e.getMessage()));
            }
        }
    }

    private final Bundle createBaseParameters(ShareContent<?, ?> shareContent, boolean z) {
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putUri(bundle, ShareConstants.LEGACY_LINK, shareContent.getContentUrl());
        Utility utility2 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_PLACE_TAG, shareContent.getPlaceId());
        Utility utility3 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.LEGACY_DATA_FAILURES_FATAL, z);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (!(peopleIds == null || peopleIds.isEmpty())) {
            bundle.putStringArrayList(ShareConstants.LEGACY_FRIEND_TAGS, new ArrayList(peopleIds));
        }
        return bundle;
    }

    private final Bundle create(ShareLinkContent shareLinkContent, boolean z) {
        return createBaseParameters(shareLinkContent, z);
    }

    private final Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent, z);
        createBaseParameters.putStringArrayList(ShareConstants.LEGACY_PHOTOS, new ArrayList(list));
        return createBaseParameters;
    }

    private final Bundle create(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        Bundle createBaseParameters = createBaseParameters(shareOpenGraphContent, z);
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_PREVIEW_PROPERTY_NAME, shareOpenGraphContent.getPreviewPropertyName());
        Utility utility2 = Utility.INSTANCE;
        ShareOpenGraphAction action = shareOpenGraphContent.getAction();
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_ACTION_TYPE, action == null ? null : action.getActionType());
        Utility utility3 = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_ACTION, String.valueOf(jSONObject));
        return createBaseParameters;
    }
}
