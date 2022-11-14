package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareDialog.kt */
public class ShareDialog extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result> implements Sharer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    public static final String FEED_DIALOG = "feed";
    public static final String TAG;
    public static final String WEB_OG_SHARE_DIALOG = "share_open_graph";
    public static final String WEB_SHARE_DIALOG = "share";
    public boolean isAutomaticMode;
    public final List<FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler> orderedModeHandlers;
    public boolean shouldFailOnDataError;

    /* compiled from: ShareDialog.kt */
    public final class CameraEffectHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        public Object mode = Mode.NATIVE;
        public final /* synthetic */ ShareDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CameraEffectHandler(ShareDialog shareDialog) {
            super(shareDialog);
            Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            this.this$0 = shareDialog;
        }

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        public boolean canShow(ShareContent<?, ?> shareContent, boolean z) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return (shareContent instanceof ShareCameraEffectContent) && ShareDialog.Companion.canShowNative(shareContent.getClass());
        }

        public AppCall createAppCall(ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateForNativeShare(shareContent);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            boolean shouldFailOnDataError = this.this$0.getShouldFailOnDataError();
            DialogFeature access$getFeature = ShareDialog.Companion.getFeature(shareContent.getClass());
            if (access$getFeature == null) {
                return null;
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ShareDialog$CameraEffectHandler$createAppCall$1(createBaseAppCall, shareContent, shouldFailOnDataError), access$getFeature);
            return createBaseAppCall;
        }
    }

    /* compiled from: ShareDialog.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean canShowNative(Class<? extends ShareContent<?, ?>> cls) {
            DialogFeature feature = getFeature(cls);
            if (feature != null) {
                DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
                if (DialogPresenter.canPresentNativeDialogWithFeature(feature)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final boolean canShowWebCheck(ShareContent<?, ?> shareContent) {
            if (!canShowWebTypeCheck(shareContent.getClass())) {
                return false;
            }
            if (!(shareContent instanceof ShareOpenGraphContent)) {
                return true;
            }
            try {
                ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
                ShareInternalUtility.toJSONObjectForWeb((ShareOpenGraphContent) shareContent);
                return true;
            } catch (Exception e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(ShareDialog.TAG, "canShow returned false because the content of the Open Graph object can't be shared via the web dialog", e);
                return false;
            }
        }

        private final boolean canShowWebTypeCheck(Class<? extends ShareContent<?, ?>> cls) {
            return ShareLinkContent.class.isAssignableFrom(cls) || ShareOpenGraphContent.class.isAssignableFrom(cls) || (SharePhotoContent.class.isAssignableFrom(cls) && AccessToken.Companion.isCurrentAccessTokenActive());
        }

        /* access modifiers changed from: private */
        public final DialogFeature getFeature(Class<? extends ShareContent<?, ?>> cls) {
            if (ShareLinkContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.SHARE_DIALOG;
            }
            if (SharePhotoContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.PHOTOS;
            }
            if (ShareVideoContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.VIDEO;
            }
            if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
                return OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
            }
            if (ShareMediaContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.MULTIMEDIA;
            }
            if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
                return CameraEffectFeature.SHARE_CAMERA_EFFECT;
            }
            if (ShareStoryContent.class.isAssignableFrom(cls)) {
                return ShareStoryFeature.SHARE_STORY_ASSET;
            }
            return null;
        }

        public boolean canShow(Class<? extends ShareContent<?, ?>> cls) {
            Intrinsics.checkNotNullParameter(cls, "contentType");
            return canShowWebTypeCheck(cls) || canShowNative(cls);
        }

        public void show(Activity activity, ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics.checkNotNullParameter(shareContent, "shareContent");
            new ShareDialog(activity).show(shareContent);
        }

        public void show(Fragment fragment, ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(shareContent, "shareContent");
            show(new FragmentWrapper(fragment), shareContent);
        }

        public void show(android.app.Fragment fragment, ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(shareContent, "shareContent");
            show(new FragmentWrapper(fragment), shareContent);
        }

        private final void show(FragmentWrapper fragmentWrapper, ShareContent<?, ?> shareContent) {
            new ShareDialog(fragmentWrapper, 0, 2, (DefaultConstructorMarker) null).show(shareContent);
        }
    }

    /* compiled from: ShareDialog.kt */
    public final class FeedHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        public Object mode = Mode.FEED;
        public final /* synthetic */ ShareDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeedHandler(ShareDialog shareDialog) {
            super(shareDialog);
            Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            this.this$0 = shareDialog;
        }

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        public boolean canShow(ShareContent<?, ?> shareContent, boolean z) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent);
        }

        public AppCall createAppCall(ShareContent<?, ?> shareContent) {
            Bundle bundle;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareDialog shareDialog = this.this$0;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), shareContent, Mode.FEED);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            if (shareContent instanceof ShareLinkContent) {
                ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
                ShareContentValidation.validateForWebShare(shareContent);
                WebDialogParameters webDialogParameters = WebDialogParameters.INSTANCE;
                bundle = WebDialogParameters.createForFeed((ShareLinkContent) shareContent);
            } else if (!(shareContent instanceof ShareFeedContent)) {
                return null;
            } else {
                WebDialogParameters webDialogParameters2 = WebDialogParameters.INSTANCE;
                bundle = WebDialogParameters.createForFeed((ShareFeedContent) shareContent);
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, ShareDialog.FEED_DIALOG, bundle);
            return createBaseAppCall;
        }
    }

    /* compiled from: ShareDialog.kt */
    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    /* compiled from: ShareDialog.kt */
    public final class NativeHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        public Object mode = Mode.NATIVE;
        public final /* synthetic */ ShareDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NativeHandler(ShareDialog shareDialog) {
            super(shareDialog);
            Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            this.this$0 = shareDialog;
        }

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
            if (com.facebook.internal.DialogPresenter.canPresentNativeDialogWithFeature(com.facebook.share.internal.ShareDialogFeature.LINK_SHARE_QUOTES) != false) goto L_0x004a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0059 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean canShow(com.facebook.share.model.ShareContent<?, ?> r4, boolean r5) {
            /*
                r3 = this;
                java.lang.String r0 = "content"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                boolean r0 = r4 instanceof com.facebook.share.model.ShareCameraEffectContent
                r1 = 0
                if (r0 != 0) goto L_0x005a
                boolean r0 = r4 instanceof com.facebook.share.model.ShareStoryContent
                if (r0 == 0) goto L_0x000f
                goto L_0x005a
            L_0x000f:
                r0 = 1
                if (r5 != 0) goto L_0x004a
                com.facebook.share.model.ShareHashtag r5 = r4.getShareHashtag()
                if (r5 == 0) goto L_0x0021
                com.facebook.internal.DialogPresenter r5 = com.facebook.internal.DialogPresenter.INSTANCE
                com.facebook.share.internal.ShareDialogFeature r5 = com.facebook.share.internal.ShareDialogFeature.HASHTAG
                boolean r5 = com.facebook.internal.DialogPresenter.canPresentNativeDialogWithFeature(r5)
                goto L_0x0022
            L_0x0021:
                r5 = 1
            L_0x0022:
                boolean r2 = r4 instanceof com.facebook.share.model.ShareLinkContent
                if (r2 == 0) goto L_0x004b
                r2 = r4
                com.facebook.share.model.ShareLinkContent r2 = (com.facebook.share.model.ShareLinkContent) r2
                java.lang.String r2 = r2.getQuote()
                if (r2 == 0) goto L_0x0038
                int r2 = r2.length()
                if (r2 != 0) goto L_0x0036
                goto L_0x0038
            L_0x0036:
                r2 = 0
                goto L_0x0039
            L_0x0038:
                r2 = 1
            L_0x0039:
                if (r2 != 0) goto L_0x004b
                if (r5 == 0) goto L_0x0048
                com.facebook.internal.DialogPresenter r5 = com.facebook.internal.DialogPresenter.INSTANCE
                com.facebook.share.internal.ShareDialogFeature r5 = com.facebook.share.internal.ShareDialogFeature.LINK_SHARE_QUOTES
                boolean r5 = com.facebook.internal.DialogPresenter.canPresentNativeDialogWithFeature(r5)
                if (r5 == 0) goto L_0x0048
                goto L_0x004a
            L_0x0048:
                r5 = 0
                goto L_0x004b
            L_0x004a:
                r5 = 1
            L_0x004b:
                if (r5 == 0) goto L_0x005a
                com.facebook.share.widget.ShareDialog$Companion r5 = com.facebook.share.widget.ShareDialog.Companion
                java.lang.Class r4 = r4.getClass()
                boolean r4 = r5.canShowNative(r4)
                if (r4 == 0) goto L_0x005a
                r1 = 1
            L_0x005a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.NativeHandler.canShow(com.facebook.share.model.ShareContent, boolean):boolean");
        }

        public AppCall createAppCall(ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareDialog shareDialog = this.this$0;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), shareContent, Mode.NATIVE);
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateForNativeShare(shareContent);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            boolean shouldFailOnDataError = this.this$0.getShouldFailOnDataError();
            DialogFeature access$getFeature = ShareDialog.Companion.getFeature(shareContent.getClass());
            if (access$getFeature == null) {
                return null;
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ShareDialog$NativeHandler$createAppCall$1(createBaseAppCall, shareContent, shouldFailOnDataError), access$getFeature);
            return createBaseAppCall;
        }
    }

    /* compiled from: ShareDialog.kt */
    public final class ShareStoryHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        public Object mode = Mode.NATIVE;
        public final /* synthetic */ ShareDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShareStoryHandler(ShareDialog shareDialog) {
            super(shareDialog);
            Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            this.this$0 = shareDialog;
        }

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        public boolean canShow(ShareContent<?, ?> shareContent, boolean z) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return (shareContent instanceof ShareStoryContent) && ShareDialog.Companion.canShowNative(shareContent.getClass());
        }

        public AppCall createAppCall(ShareContent<?, ?> shareContent) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateForStoryShare(shareContent);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            boolean shouldFailOnDataError = this.this$0.getShouldFailOnDataError();
            DialogFeature access$getFeature = ShareDialog.Companion.getFeature(shareContent.getClass());
            if (access$getFeature == null) {
                return null;
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ShareDialog$ShareStoryHandler$createAppCall$1(createBaseAppCall, shareContent, shouldFailOnDataError), access$getFeature);
            return createBaseAppCall;
        }
    }

    /* compiled from: ShareDialog.kt */
    public final class WebShareHandler extends FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler {
        public Object mode = Mode.WEB;
        public final /* synthetic */ ShareDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WebShareHandler(ShareDialog shareDialog) {
            super(shareDialog);
            Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            this.this$0 = shareDialog;
        }

        private final SharePhotoContent createAndMapAttachments(SharePhotoContent sharePhotoContent, UUID uuid) {
            SharePhotoContent.Builder readFrom = new SharePhotoContent.Builder().readFrom(sharePhotoContent);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = sharePhotoContent.getPhotos().size() - 1;
            if (size >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    SharePhoto sharePhoto = sharePhotoContent.getPhotos().get(i);
                    Bitmap bitmap = sharePhoto.getBitmap();
                    if (bitmap != null) {
                        NativeAppCallAttachmentStore nativeAppCallAttachmentStore = NativeAppCallAttachmentStore.INSTANCE;
                        NativeAppCallAttachmentStore.Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
                        sharePhoto = new SharePhoto.Builder().readFrom(sharePhoto).setImageUrl(Uri.parse(createAttachment.getAttachmentUrl())).setBitmap((Bitmap) null).build();
                        arrayList2.add(createAttachment);
                    }
                    arrayList.add(sharePhoto);
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            readFrom.setPhotos(arrayList);
            NativeAppCallAttachmentStore nativeAppCallAttachmentStore2 = NativeAppCallAttachmentStore.INSTANCE;
            NativeAppCallAttachmentStore.addAttachments(arrayList2);
            return readFrom.build();
        }

        private final String getActionName(ShareContent<?, ?> shareContent) {
            if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof SharePhotoContent)) {
                return "share";
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                return ShareDialog.WEB_OG_SHARE_DIALOG;
            }
            return null;
        }

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }

        public boolean canShow(ShareContent<?, ?> shareContent, boolean z) {
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return ShareDialog.Companion.canShowWebCheck(shareContent);
        }

        public AppCall createAppCall(ShareContent<?, ?> shareContent) {
            Bundle bundle;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareDialog shareDialog = this.this$0;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), shareContent, Mode.WEB);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            ShareContentValidation shareContentValidation = ShareContentValidation.INSTANCE;
            ShareContentValidation.validateForWebShare(shareContent);
            if (shareContent instanceof ShareLinkContent) {
                WebDialogParameters webDialogParameters = WebDialogParameters.INSTANCE;
                bundle = WebDialogParameters.create((ShareLinkContent) shareContent);
            } else if (shareContent instanceof SharePhotoContent) {
                SharePhotoContent createAndMapAttachments = createAndMapAttachments((SharePhotoContent) shareContent, createBaseAppCall.getCallId());
                WebDialogParameters webDialogParameters2 = WebDialogParameters.INSTANCE;
                bundle = WebDialogParameters.create(createAndMapAttachments);
            } else if (!(shareContent instanceof ShareOpenGraphContent)) {
                return null;
            } else {
                WebDialogParameters webDialogParameters3 = WebDialogParameters.INSTANCE;
                bundle = WebDialogParameters.create((ShareOpenGraphContent) shareContent);
            }
            DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, getActionName(shareContent), bundle);
            return createBaseAppCall;
        }
    }

    /* compiled from: ShareDialog.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            Mode mode = Mode.AUTOMATIC;
            iArr[0] = 1;
            Mode mode2 = Mode.WEB;
            iArr[2] = 2;
            Mode mode3 = Mode.NATIVE;
            iArr[1] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        String simpleName = ShareDialog.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "ShareDialog::class.java.simpleName");
        TAG = simpleName;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShareDialog(Activity activity) {
        this(activity, DEFAULT_REQUEST_CODE);
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    public static boolean canShow(Class<? extends ShareContent<?, ?>> cls) {
        return Companion.canShow(cls);
    }

    /* access modifiers changed from: private */
    public final void logDialogShare(Context context, ShareContent<?, ?> shareContent, Mode mode) {
        if (this.isAutomaticMode) {
            mode = Mode.AUTOMATIC;
        }
        int ordinal = mode.ordinal();
        String str = "unknown";
        String str2 = ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? str : "web" : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC;
        DialogFeature access$getFeature = Companion.getFeature(shareContent.getClass());
        if (access$getFeature == ShareDialogFeature.SHARE_DIALOG) {
            str = "status";
        } else if (access$getFeature == ShareDialogFeature.PHOTOS) {
            str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;
        } else if (access$getFeature == ShareDialogFeature.VIDEO) {
            str = "video";
        } else if (access$getFeature == OpenGraphActionDialogFeature.OG_ACTION_DIALOG) {
            str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_OPENGRAPH;
        }
        InternalAppEventsLogger.Companion companion = InternalAppEventsLogger.Companion;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        InternalAppEventsLogger createInstance = companion.createInstance(context, FacebookSdk.getApplicationId());
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str2);
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_TYPE, str);
        createInstance.logEventImplicitly("fb_share_dialog_show", bundle);
    }

    public static void show(Activity activity, ShareContent<?, ?> shareContent) {
        Companion.show(activity, shareContent);
    }

    public static void show(android.app.Fragment fragment, ShareContent<?, ?> shareContent) {
        Companion.show(fragment, shareContent);
    }

    public static void show(Fragment fragment, ShareContent<?, ?> shareContent) {
        Companion.show(fragment, shareContent);
    }

    public boolean canShow(ShareContent<?, ?> shareContent, Mode mode) {
        Intrinsics.checkNotNullParameter(shareContent, "content");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Object obj = mode;
        if (mode == Mode.AUTOMATIC) {
            obj = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
        return canShowImpl(shareContent, obj);
    }

    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode(), (UUID) null, 2, (DefaultConstructorMarker) null);
    }

    public List<FacebookDialogBase<ShareContent<?, ?>, Sharer.Result>.ModeHandler> getOrderedModeHandlers() {
        return this.orderedModeHandlers;
    }

    public boolean getShouldFailOnDataError() {
        return this.shouldFailOnDataError;
    }

    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Sharer.Result> facebookCallback) {
        Intrinsics.checkNotNullParameter(callbackManagerImpl, "callbackManager");
        Intrinsics.checkNotNullParameter(facebookCallback, "callback");
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManagerImpl, facebookCallback);
    }

    public void setShouldFailOnDataError(boolean z) {
        this.shouldFailOnDataError = z;
    }

    public void show(ShareContent<?, ?> shareContent, Mode mode) {
        Intrinsics.checkNotNullParameter(shareContent, "content");
        Intrinsics.checkNotNullParameter(mode, "mode");
        boolean z = mode == Mode.AUTOMATIC;
        this.isAutomaticMode = z;
        Object obj = mode;
        if (z) {
            obj = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
        showImpl(shareContent, obj);
    }

    public ShareDialog(int i) {
        super(i);
        this.isAutomaticMode = true;
        this.orderedModeHandlers = CollectionsKt__CollectionsKt.arrayListOf(new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this));
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShareDialog(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? DEFAULT_REQUEST_CODE : i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShareDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment), 0, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShareDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment), 0, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareDialog(Activity activity, int i) {
        super(activity, i);
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.isAutomaticMode = true;
        this.orderedModeHandlers = CollectionsKt__CollectionsKt.arrayListOf(new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this));
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShareDialog(Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShareDialog(android.app.Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShareDialog(FragmentWrapper fragmentWrapper, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentWrapper, (i2 & 2) != 0 ? DEFAULT_REQUEST_CODE : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareDialog(FragmentWrapper fragmentWrapper, int i) {
        super(fragmentWrapper, i);
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        this.isAutomaticMode = true;
        this.orderedModeHandlers = CollectionsKt__CollectionsKt.arrayListOf(new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this));
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        ShareInternalUtility.registerStaticShareCallback(i);
    }
}
