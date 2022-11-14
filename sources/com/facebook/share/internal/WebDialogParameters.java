package com.facebook.share.internal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.android.billingclient.api.zzam;
import com.facebook.FacebookException;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WebDialogParameters.kt */
public final class WebDialogParameters {
    public static final WebDialogParameters INSTANCE = new WebDialogParameters();

    public static final Bundle create(AppGroupCreationContent appGroupCreationContent) {
        String str;
        Intrinsics.checkNotNullParameter(appGroupCreationContent, "appGroupCreationContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "name", appGroupCreationContent.getName());
        Utility utility2 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "description", appGroupCreationContent.getDescription());
        Utility utility3 = Utility.INSTANCE;
        AppGroupCreationContent.AppGroupPrivacy appGroupPrivacy = appGroupCreationContent.getAppGroupPrivacy();
        String str2 = null;
        if (!(appGroupPrivacy == null || (str = appGroupPrivacy.toString()) == null)) {
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
            str2 = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, "privacy", str2);
        return bundle;
    }

    public static final Bundle createBaseParameters(ShareContent<?, ?> shareContent) {
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, shareHashtag == null ? null : shareHashtag.getHashtag());
        return bundle;
    }

    @SuppressLint({"DeprecatedMethod"})
    public static final Bundle createForFeed(ShareLinkContent shareLinkContent) {
        Intrinsics.checkNotNullParameter(shareLinkContent, "shareLinkContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "link", Utility.getUriString(shareLinkContent.getContentUrl()));
        Utility utility2 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        Utility utility3 = Utility.INSTANCE;
        ShareHashtag shareHashtag = shareLinkContent.getShareHashtag();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, shareHashtag == null ? null : shareHashtag.getHashtag());
        return bundle;
    }

    public static final Bundle create(GameRequestContent gameRequestContent) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(gameRequestContent, "gameRequestContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "message", gameRequestContent.getMessage());
        Utility utility2 = Utility.INSTANCE;
        Utility.putCommaSeparatedStringList(bundle, "to", gameRequestContent.getRecipients());
        Utility utility3 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "title", gameRequestContent.getTitle());
        Utility utility4 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "data", gameRequestContent.getData());
        Utility utility5 = Utility.INSTANCE;
        GameRequestContent.ActionType actionType = gameRequestContent.getActionType();
        String str4 = null;
        if (actionType == null || (str3 = actionType.toString()) == null) {
            str = null;
        } else {
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
            str = str3.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, "action_type", str);
        Utility utility6 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "object_id", gameRequestContent.getObjectId());
        Utility utility7 = Utility.INSTANCE;
        GameRequestContent.Filters filters = gameRequestContent.getFilters();
        if (!(filters == null || (str2 = filters.toString()) == null)) {
            Locale locale2 = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(locale2, ViewHierarchyConstants.ENGLISH);
            str4 = str2.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(str4, "(this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_FILTERS, str4);
        Utility utility8 = Utility.INSTANCE;
        Utility.putCommaSeparatedStringList(bundle, ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS, gameRequestContent.getSuggestions());
        return bundle;
    }

    public static final Bundle createForFeed(ShareFeedContent shareFeedContent) {
        Intrinsics.checkNotNullParameter(shareFeedContent, "shareFeedContent");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "to", shareFeedContent.getToId());
        Utility utility2 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "link", shareFeedContent.getLink());
        Utility utility3 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "picture", shareFeedContent.getPicture());
        Utility utility4 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "source", shareFeedContent.getMediaSource());
        Utility utility5 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "name", shareFeedContent.getLinkName());
        Utility utility6 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "caption", shareFeedContent.getLinkCaption());
        Utility utility7 = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "description", shareFeedContent.getLinkDescription());
        return bundle;
    }

    public static final Bundle create(ShareLinkContent shareLinkContent) {
        Intrinsics.checkNotNullParameter(shareLinkContent, "shareLinkContent");
        Bundle createBaseParameters = createBaseParameters(shareLinkContent);
        Utility utility = Utility.INSTANCE;
        Utility.putUri(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_HREF, shareLinkContent.getContentUrl());
        Utility utility2 = Utility.INSTANCE;
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        return createBaseParameters;
    }

    public static final Bundle create(ShareOpenGraphContent shareOpenGraphContent) {
        Intrinsics.checkNotNullParameter(shareOpenGraphContent, "shareOpenGraphContent");
        Bundle createBaseParameters = createBaseParameters(shareOpenGraphContent);
        Utility utility = Utility.INSTANCE;
        ShareOpenGraphAction action = shareOpenGraphContent.getAction();
        String str = null;
        Utility.putNonEmptyString(createBaseParameters, "action_type", action == null ? null : action.getActionType());
        try {
            ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
            JSONObject jSONObjectForWeb = ShareInternalUtility.toJSONObjectForWeb(shareOpenGraphContent);
            ShareInternalUtility shareInternalUtility2 = ShareInternalUtility.INSTANCE;
            JSONObject removeNamespacesFromOGJsonObject = ShareInternalUtility.removeNamespacesFromOGJsonObject(jSONObjectForWeb, false);
            Utility utility2 = Utility.INSTANCE;
            if (removeNamespacesFromOGJsonObject != null) {
                str = removeNamespacesFromOGJsonObject.toString();
            }
            Utility.putNonEmptyString(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_ACTION_PROPERTIES, str);
            return createBaseParameters;
        } catch (JSONException e) {
            throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", (Throwable) e);
        }
    }

    public static final Bundle create(SharePhotoContent sharePhotoContent) {
        Intrinsics.checkNotNullParameter(sharePhotoContent, "sharePhotoContent");
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent);
        Iterable<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos == null) {
            photos = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(zzam.collectionSizeOrDefault(photos, 10));
        for (SharePhoto imageUrl : photos) {
            arrayList.add(String.valueOf(imageUrl.getImageUrl()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            createBaseParameters.putStringArray(ShareConstants.WEB_DIALOG_PARAM_MEDIA, (String[]) array);
            return createBaseParameters;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
