package com.vungle.warren.p037ui.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.p037ui.CloseDelegate;
import com.vungle.warren.p037ui.OrientationDelegate;
import com.vungle.warren.p037ui.contract.AdContract;
import com.vungle.warren.p037ui.contract.AdContract.AdvertisementPresenter;
import com.vungle.warren.utility.ActivityManager;
import com.vungle.warren.utility.ExternalRouter;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.vungle.warren.ui.view.BaseAdView */
public abstract class BaseAdView<T extends AdContract.AdvertisementPresenter> implements AdContract.AdView<T> {
    public final String TAG = getClass().getSimpleName();
    public final CloseDelegate closeDelegate;
    public final Context context;
    public Dialog currentDialog;
    public Handler handler = new Handler(Looper.getMainLooper());
    public final OrientationDelegate orientationDelegate;
    public final FullAdWidget view;

    /* renamed from: com.vungle.warren.ui.view.BaseAdView$DialogClickListenerProxy */
    public static class DialogClickListenerProxy implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
        public AtomicReference<DialogInterface.OnClickListener> ckickRef = new AtomicReference<>();
        public AtomicReference<DialogInterface.OnDismissListener> dismissRef = new AtomicReference<>();

        public DialogClickListenerProxy(DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
            this.ckickRef.set(onClickListener);
            this.dismissRef.set(onDismissListener);
        }

        /* access modifiers changed from: private */
        public void autoRelease(Dialog dialog) {
            dialog.setOnDismissListener(this);
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            DialogInterface.OnClickListener onClickListener = this.ckickRef.get();
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i);
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = this.dismissRef.get();
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
            this.dismissRef.set((Object) null);
            this.ckickRef.set((Object) null);
        }
    }

    public BaseAdView(@NonNull Context context2, @NonNull FullAdWidget fullAdWidget, @NonNull OrientationDelegate orientationDelegate2, @NonNull CloseDelegate closeDelegate2) {
        this.view = fullAdWidget;
        this.context = context2;
        this.orientationDelegate = orientationDelegate2;
        this.closeDelegate = closeDelegate2;
    }

    public void close() {
        this.closeDelegate.close();
    }

    public void destroyAdView(long j) {
        this.view.release(j);
    }

    @NonNull
    public DialogInterface.OnDismissListener getDialogDismissListener() {
        return new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                BaseAdView.this.currentDialog = null;
            }
        };
    }

    public String getWebsiteUrl() {
        return this.view.getUrl();
    }

    public boolean hasWebView() {
        return this.view.hasWebView();
    }

    public boolean isDialogVisible() {
        return this.currentDialog != null;
    }

    public void open(@NonNull String str, ActivityManager.LeftApplicationCallback leftApplicationCallback) {
        String str2 = this.TAG;
        Log.d(str2, "Opening " + str);
        if (!ExternalRouter.launch(str, this.context, leftApplicationCallback)) {
            String str3 = this.TAG;
            Log.e(str3, "Cannot open url " + str);
        }
    }

    public void pauseWeb() {
        this.view.pauseWeb();
    }

    public void refreshDialogIfVisible() {
        if (isDialogVisible()) {
            this.currentDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    BaseAdView baseAdView = BaseAdView.this;
                    baseAdView.currentDialog.setOnDismissListener(baseAdView.getDialogDismissListener());
                }
            });
            this.currentDialog.dismiss();
            this.currentDialog.show();
        }
    }

    public void removeWebView() {
        this.view.destroyWebView(0);
    }

    public void resumeWeb() {
        this.view.resumeWeb();
    }

    public void setImmersiveMode() {
        this.view.setImmersiveMode();
    }

    public void setOrientation(int i) {
        this.orientationDelegate.setOrientation(i);
    }

    public void showCloseButton() {
        this.view.showCloseButton(true);
    }

    public void showDialog(@Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable final DialogInterface.OnClickListener onClickListener) {
        Context context2 = this.context;
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context2, context2.getApplicationInfo().theme));
        DialogClickListenerProxy dialogClickListenerProxy = new DialogClickListenerProxy(new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                BaseAdView.this.currentDialog = null;
                DialogInterface.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i);
                }
            }
        }, getDialogDismissListener());
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        builder.setPositiveButton(str3, dialogClickListenerProxy);
        builder.setNegativeButton(str4, dialogClickListenerProxy);
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        this.currentDialog = create;
        dialogClickListenerProxy.autoRelease(create);
        this.currentDialog.show();
    }
}
