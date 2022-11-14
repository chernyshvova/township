package com.facebook.internal;

import android.app.Activity;
import android.util.Log;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FacebookDialogBase.kt */
public abstract class FacebookDialogBase<CONTENT, RESULT> implements FacebookDialog<CONTENT, RESULT> {
    public static final Object BASE_AUTOMATIC_MODE = new Object();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "FacebookDialog";
    public final Activity activity;
    public CallbackManager callbackManager;
    public final FragmentWrapper fragmentWrapper;
    public List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> modeHandlers;
    public int requestCodeField;

    /* compiled from: FacebookDialogBase.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FacebookDialogBase.kt */
    public abstract class ModeHandler {
        public Object mode = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        public final /* synthetic */ FacebookDialogBase<CONTENT, RESULT> this$0;

        public ModeHandler(FacebookDialogBase facebookDialogBase) {
            Intrinsics.checkNotNullParameter(facebookDialogBase, "this$0");
            this.this$0 = facebookDialogBase;
        }

        public abstract boolean canShow(CONTENT content, boolean z);

        public abstract AppCall createAppCall(CONTENT content);

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }
    }

    public FacebookDialogBase(Activity activity2, int i) {
        Intrinsics.checkNotNullParameter(activity2, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.activity = activity2;
        this.fragmentWrapper = null;
        this.requestCodeField = i;
        this.callbackManager = null;
    }

    private final List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> cachedModeHandlers() {
        if (this.modeHandlers == null) {
            this.modeHandlers = getOrderedModeHandlers();
        }
        List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> list = this.modeHandlers;
        if (list != null) {
            return list;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.facebook.internal.FacebookDialogBase.ModeHandler<CONTENT of com.facebook.internal.FacebookDialogBase, RESULT of com.facebook.internal.FacebookDialogBase>>");
    }

    /* access modifiers changed from: private */
    public final AppCall createAppCallForMode(CONTENT content, Object obj) {
        boolean z = obj == BASE_AUTOMATIC_MODE;
        AppCall appCall = null;
        Iterator<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> it = cachedModeHandlers().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ModeHandler next = it.next();
            if (!z) {
                Utility utility = Utility.INSTANCE;
                if (!Utility.areObjectsEqual(next.getMode(), obj)) {
                    continue;
                }
            }
            if (next.canShow(content, true)) {
                try {
                    appCall = next.createAppCall(content);
                    break;
                } catch (FacebookException e) {
                    appCall = createBaseAppCall();
                    DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
                    DialogPresenter.setupAppCallForValidationError(appCall, e);
                }
            }
        }
        if (appCall != null) {
            return appCall;
        }
        AppCall createBaseAppCall = createBaseAppCall();
        DialogPresenter dialogPresenter2 = DialogPresenter.INSTANCE;
        DialogPresenter.setupAppCallForCannotShowError(createBaseAppCall);
        return createBaseAppCall;
    }

    private final void memorizeCallbackManager(CallbackManager callbackManager2) {
        CallbackManager callbackManager3 = this.callbackManager;
        if (callbackManager3 == null) {
            this.callbackManager = callbackManager2;
        } else if (callbackManager3 != callbackManager2) {
            Log.w(TAG, "You're registering a callback on a Facebook dialog with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    public boolean canShow(CONTENT content) {
        return canShowImpl(content, BASE_AUTOMATIC_MODE);
    }

    public boolean canShowImpl(CONTENT content, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "mode");
        boolean z = obj == BASE_AUTOMATIC_MODE;
        for (ModeHandler next : cachedModeHandlers()) {
            if (!z) {
                Utility utility = Utility.INSTANCE;
                if (!Utility.areObjectsEqual(next.getMode(), obj)) {
                    continue;
                }
            }
            if (next.canShow(content, false)) {
                return true;
            }
        }
        return false;
    }

    public final ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(CallbackManager callbackManager2, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "mode");
        return new C1558x81c24930(this, obj, callbackManager2);
    }

    public abstract AppCall createBaseAppCall();

    public final Activity getActivityContext() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            return activity2;
        }
        FragmentWrapper fragmentWrapper2 = this.fragmentWrapper;
        if (fragmentWrapper2 == null) {
            return null;
        }
        return fragmentWrapper2.getActivity();
    }

    @VisibleForTesting(otherwise = 2)
    public final CallbackManager getCallbackManager$facebook_common_release() {
        return this.callbackManager;
    }

    public abstract List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> getOrderedModeHandlers();

    public final int getRequestCode() {
        return this.requestCodeField;
    }

    public void registerCallback(CallbackManager callbackManager2, FacebookCallback<RESULT> facebookCallback) {
        Intrinsics.checkNotNullParameter(callbackManager2, "callbackManager");
        Intrinsics.checkNotNullParameter(facebookCallback, "callback");
        if (callbackManager2 instanceof CallbackManagerImpl) {
            memorizeCallbackManager(callbackManager2);
            registerCallbackImpl((CallbackManagerImpl) callbackManager2, facebookCallback);
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public abstract void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<RESULT> facebookCallback);

    public final void setCallbackManager(CallbackManager callbackManager2) {
        this.callbackManager = callbackManager2;
    }

    public final void setCallbackManager$facebook_common_release(CallbackManager callbackManager2) {
        this.callbackManager = callbackManager2;
    }

    public final void setRequestCode(int i) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.isFacebookRequestCode(i)) {
            this.requestCodeField = i;
            return;
        }
        throw new IllegalArgumentException(("Request code " + i + " cannot be within the range reserved by the Facebook SDK.").toString());
    }

    public void show(CONTENT content) {
        showImpl(content, BASE_AUTOMATIC_MODE);
    }

    public void showImpl(CONTENT content, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "mode");
        AppCall createAppCallForMode = createAppCallForMode(content, obj);
        if (createAppCallForMode == null) {
            Log.e(TAG, "No code path should ever result in a null appCall");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!(!FacebookSdk.isDebugEnabled())) {
                throw new IllegalStateException("No code path should ever result in a null appCall".toString());
            }
        } else if (getActivityContext() instanceof ActivityResultRegistryOwner) {
            Activity activityContext = getActivityContext();
            if (activityContext != null) {
                DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
                ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) activityContext).getActivityResultRegistry();
                Intrinsics.checkNotNullExpressionValue(activityResultRegistry, "registryOwner.activityResultRegistry");
                DialogPresenter.present(createAppCallForMode, activityResultRegistry, this.callbackManager);
                createAppCallForMode.setPending();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
        } else {
            FragmentWrapper fragmentWrapper2 = this.fragmentWrapper;
            if (fragmentWrapper2 != null) {
                DialogPresenter dialogPresenter2 = DialogPresenter.INSTANCE;
                DialogPresenter.present(createAppCallForMode, fragmentWrapper2);
                return;
            }
            Activity activity2 = this.activity;
            if (activity2 != null) {
                DialogPresenter dialogPresenter3 = DialogPresenter.INSTANCE;
                DialogPresenter.present(createAppCallForMode, activity2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startActivityForResult(android.content.Intent r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.app.Activity r0 = r4.getActivityContext()
            boolean r1 = r0 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r1 == 0) goto L_0x0020
            com.facebook.internal.DialogPresenter r1 = com.facebook.internal.DialogPresenter.INSTANCE
            androidx.activity.result.ActivityResultRegistryOwner r0 = (androidx.activity.result.ActivityResultRegistryOwner) r0
            androidx.activity.result.ActivityResultRegistry r0 = r0.getActivityResultRegistry()
            java.lang.String r1 = "activity as ActivityResultRegistryOwner).activityResultRegistry"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.facebook.CallbackManager r1 = r4.callbackManager
            com.facebook.internal.DialogPresenter.startActivityForResultWithAndroidX(r0, r1, r5, r6)
            goto L_0x002d
        L_0x0020:
            if (r0 == 0) goto L_0x0026
            r0.startActivityForResult(r5, r6)
            goto L_0x002d
        L_0x0026:
            com.facebook.internal.FragmentWrapper r0 = r4.fragmentWrapper
            if (r0 == 0) goto L_0x002f
            r0.startActivityForResult(r5, r6)
        L_0x002d:
            r5 = 0
            goto L_0x0031
        L_0x002f:
            java.lang.String r5 = "Failed to find Activity or Fragment to startActivityForResult "
        L_0x0031:
            if (r5 == 0) goto L_0x0048
            com.facebook.internal.Logger$Companion r6 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            r1 = 6
            java.lang.Class r2 = r4.getClass()
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "this.javaClass.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r6.log((com.facebook.LoggingBehavior) r0, (int) r1, (java.lang.String) r2, (java.lang.String) r5)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FacebookDialogBase.startActivityForResult(android.content.Intent, int):void");
    }

    public ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(CallbackManager callbackManager2) {
        return createActivityResultContractForShowingDialog(callbackManager2, BASE_AUTOMATIC_MODE);
    }

    public void registerCallback(CallbackManager callbackManager2, FacebookCallback<RESULT> facebookCallback, int i) {
        Intrinsics.checkNotNullParameter(callbackManager2, "callbackManager");
        Intrinsics.checkNotNullParameter(facebookCallback, "callback");
        memorizeCallbackManager(callbackManager2);
        setRequestCode(i);
        registerCallback(callbackManager2, facebookCallback);
    }

    public FacebookDialogBase(FragmentWrapper fragmentWrapper2, int i) {
        Intrinsics.checkNotNullParameter(fragmentWrapper2, "fragmentWrapper");
        this.fragmentWrapper = fragmentWrapper2;
        this.activity = null;
        this.requestCodeField = i;
        if (fragmentWrapper2.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity".toString());
        }
    }

    public FacebookDialogBase(int i) {
        this.requestCodeField = i;
        this.activity = null;
        this.fragmentWrapper = null;
    }
}
