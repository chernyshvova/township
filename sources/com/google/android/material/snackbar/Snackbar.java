package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;

public final class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] SNACKBAR_BUTTON_STYLE_ATTR = {R$attr.snackbarButtonStyle};
    public final AccessibilityManager accessibilityManager;
    public boolean hasAction;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }

    public Snackbar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        super(viewGroup, view, contentViewCallback);
        this.accessibilityManager = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @NonNull
    public static Snackbar make(@NonNull View view, @NonNull CharSequence charSequence, int i) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        while (true) {
            if (!(view instanceof CoordinatorLayout)) {
                if (view instanceof FrameLayout) {
                    if (view.getId() == 16908290) {
                        viewGroup = (ViewGroup) view;
                        break;
                    }
                    viewGroup2 = (ViewGroup) view;
                }
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof View) {
                        view = (View) parent;
                        continue;
                    } else {
                        view = null;
                        continue;
                    }
                }
                if (view == null) {
                    viewGroup = viewGroup2;
                    break;
                }
            } else {
                viewGroup = (ViewGroup) view;
                break;
            }
        }
        if (viewGroup != null) {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(resourceId != -1 ? R$layout.mtrl_layout_snackbar_include : R$layout.design_layout_snackbar_include, viewGroup, false);
            Snackbar snackbar = new Snackbar(viewGroup, snackbarContentLayout, snackbarContentLayout);
            ((SnackbarContentLayout) snackbar.view.getChildAt(0)).getMessageView().setText(charSequence);
            snackbar.duration = i;
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    public boolean isShown() {
        boolean isCurrentSnackbarLocked;
        SnackbarManager instance = SnackbarManager.getInstance();
        SnackbarManager.Callback callback = this.managerCallback;
        synchronized (instance.lock) {
            isCurrentSnackbarLocked = instance.isCurrentSnackbarLocked(callback);
        }
        return isCurrentSnackbarLocked;
    }

    @NonNull
    public Snackbar setAction(@StringRes int i, final View.OnClickListener onClickListener) {
        CharSequence text = this.context.getText(i);
        Button actionView = ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView();
        if (!TextUtils.isEmpty(text)) {
            this.hasAction = true;
            actionView.setVisibility(0);
            actionView.setText(text);
            actionView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    Snackbar.this.dispatchDismiss(1);
                }
            });
        } else {
            actionView.setVisibility(8);
            actionView.setOnClickListener((View.OnClickListener) null);
            this.hasAction = false;
        }
        return this;
    }

    public void show() {
        int i;
        SnackbarManager instance = SnackbarManager.getInstance();
        if (!this.hasAction || !this.accessibilityManager.isTouchExplorationEnabled()) {
            i = this.duration;
        } else {
            i = -2;
        }
        SnackbarManager.Callback callback = this.managerCallback;
        synchronized (instance.lock) {
            if (instance.isCurrentSnackbarLocked(callback)) {
                instance.currentSnackbar.duration = i;
                instance.handler.removeCallbacksAndMessages(instance.currentSnackbar);
                instance.scheduleTimeoutLocked(instance.currentSnackbar);
                return;
            }
            if (instance.isNextSnackbarLocked(callback)) {
                instance.nextSnackbar.duration = i;
            } else {
                instance.nextSnackbar = new SnackbarManager.SnackbarRecord(i, callback);
            }
            if (instance.currentSnackbar == null || !instance.cancelSnackbarLocked(instance.currentSnackbar, 4)) {
                instance.currentSnackbar = null;
                instance.showNextSnackbarLocked();
            }
        }
    }
}
