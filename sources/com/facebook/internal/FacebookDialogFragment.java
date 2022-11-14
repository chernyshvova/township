package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FacebookDialogFragment.kt */
public final class FacebookDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "FacebookDialogFragment";
    public Dialog innerDialog;

    /* compiled from: FacebookDialogFragment.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: initDialog$lambda-0  reason: not valid java name */
    public static final void m3612initDialog$lambda0(FacebookDialogFragment facebookDialogFragment, Bundle bundle, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(facebookDialogFragment, "this$0");
        facebookDialogFragment.onCompleteWebDialog(bundle, facebookException);
    }

    /* renamed from: initDialog$lambda-1  reason: not valid java name */
    public static final void m3613initDialog$lambda1(FacebookDialogFragment facebookDialogFragment, Bundle bundle, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(facebookDialogFragment, "this$0");
        facebookDialogFragment.onCompleteWebFallbackDialog(bundle);
    }

    private final void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "fragmentActivity.intent");
            activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(intent, bundle, facebookException));
            activity.finish();
        }
    }

    private final void onCompleteWebFallbackDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtras(bundle);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    public final Dialog getInnerDialog() {
        return this.innerDialog;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: android.os.Bundle} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initDialog$facebook_common_release() {
        /*
            r7 = this;
            android.app.Dialog r0 = r7.innerDialog
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            android.content.Intent r1 = r0.getIntent()
            com.facebook.internal.NativeProtocol r2 = com.facebook.internal.NativeProtocol.INSTANCE
            java.lang.String r2 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.os.Bundle r1 = com.facebook.internal.NativeProtocol.getMethodArgumentsFromIntent(r1)
            r2 = 0
            if (r1 != 0) goto L_0x0020
            r3 = 0
            goto L_0x0026
        L_0x0020:
            java.lang.String r3 = "is_fallback"
            boolean r3 = r1.getBoolean(r3, r2)
        L_0x0026:
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.String"
            java.lang.String r5 = "FacebookDialogFragment"
            r6 = 0
            if (r3 != 0) goto L_0x006e
            if (r1 != 0) goto L_0x0031
            r2 = r6
            goto L_0x0037
        L_0x0031:
            java.lang.String r2 = "action"
            java.lang.String r2 = r1.getString(r2)
        L_0x0037:
            if (r1 != 0) goto L_0x003a
            goto L_0x0040
        L_0x003a:
            java.lang.String r3 = "params"
            android.os.Bundle r6 = r1.getBundle(r3)
        L_0x0040:
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
            boolean r1 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r2)
            if (r1 == 0) goto L_0x0053
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
            java.lang.String r1 = "Cannot start a WebDialog with an empty/missing 'actionName'"
            com.facebook.internal.Utility.logd((java.lang.String) r5, (java.lang.String) r1)
            r0.finish()
            return
        L_0x0053:
            com.facebook.internal.WebDialog$Builder r1 = new com.facebook.internal.WebDialog$Builder
            if (r2 == 0) goto L_0x0068
            r1.<init>(r0, r2, r6)
            com.facebook.internal.-$$Lambda$3BbV3rJ4-THTu8bLGxrqhyLdAgU r0 = new com.facebook.internal.-$$Lambda$3BbV3rJ4-THTu8bLGxrqhyLdAgU
            r0.<init>()
            com.facebook.internal.WebDialog$Builder r0 = r1.setOnCompleteListener(r0)
            com.facebook.internal.WebDialog r0 = r0.build()
            goto L_0x00ad
        L_0x0068:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r4)
            throw r0
        L_0x006e:
            if (r1 != 0) goto L_0x0071
            goto L_0x0077
        L_0x0071:
            java.lang.String r3 = "url"
            java.lang.String r6 = r1.getString(r3)
        L_0x0077:
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
            boolean r1 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r6)
            if (r1 == 0) goto L_0x008a
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
            java.lang.String r1 = "Cannot start a fallback WebDialog with an empty/missing 'url'"
            com.facebook.internal.Utility.logd((java.lang.String) r5, (java.lang.String) r1)
            r0.finish()
            return
        L_0x008a:
            r1 = 1
            java.lang.Object[] r3 = new java.lang.Object[r1]
            com.facebook.FacebookSdk r5 = com.facebook.FacebookSdk.INSTANCE
            java.lang.String r5 = com.facebook.FacebookSdk.getApplicationId()
            r3[r2] = r5
            java.lang.String r2 = "fb%s://bridge/"
            java.lang.String r5 = "java.lang.String.format(format, *args)"
            java.lang.String r1 = com.android.tools.p006r8.GeneratedOutlineSupport.outline21(r3, r1, r2, r5)
            com.facebook.internal.FacebookWebFallbackDialog$Companion r2 = com.facebook.internal.FacebookWebFallbackDialog.Companion
            if (r6 == 0) goto L_0x00b0
            com.facebook.internal.FacebookWebFallbackDialog r0 = r2.newInstance(r0, r6, r1)
            com.facebook.internal.-$$Lambda$WBlQjPDIShjArX4e5coy79ZG5ss r1 = new com.facebook.internal.-$$Lambda$WBlQjPDIShjArX4e5coy79ZG5ss
            r1.<init>()
            r0.setOnCompleteListener(r1)
        L_0x00ad:
            r7.innerDialog = r0
            return
        L_0x00b0:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FacebookDialogFragment.initDialog$facebook_common_release():void");
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if ((this.innerDialog instanceof WebDialog) && isResumed()) {
            Dialog dialog = this.innerDialog;
            if (dialog != null) {
                ((WebDialog) dialog).resize();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initDialog$facebook_common_release();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.innerDialog;
        if (dialog == null) {
            onCompleteWebDialog((Bundle) null, (FacebookException) null);
            setShowsDialog(false);
            Dialog onCreateDialog = super.onCreateDialog(bundle);
            Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
            return onCreateDialog;
        } else if (dialog != null) {
            return dialog;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
        }
    }

    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage((Message) null);
        }
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = this.innerDialog;
        if (!(dialog instanceof WebDialog)) {
            return;
        }
        if (dialog != null) {
            ((WebDialog) dialog).resize();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
    }

    public final void setInnerDialog(Dialog dialog) {
        this.innerDialog = dialog;
    }
}
