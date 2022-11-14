package com.helpshift.views.bottomsheet;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.helpshift.C2466R;
import java.util.ArrayList;
import java.util.List;

public class HSBottomSheet {
    public final ViewGroup bottomSheet;
    public final View bottomSheetParentView;
    public final Window bottomSheetWindow;
    public List<BottomSheetBehavior.BottomSheetCallback> callbacks = new ArrayList();
    public final View contentView;
    public final float dimOpacity;
    public final boolean enableDimAnimation;
    public final View referenceWindowView;
    public final View viewToDim;

    public static class Builder {
        public View content;
        public float dimOpacity = 1.0f;
        public boolean enableDimAnimation;
        public int layoutId;
        public Window layoutWindow;
        public View referenceView;

        public Builder(@NonNull Window window) {
            this.layoutWindow = window;
        }

        public Builder contentView(@LayoutRes int i) {
            this.layoutId = i;
            return this;
        }

        public Builder dimOpacity(float f) {
            this.dimOpacity = f;
            return this;
        }

        public Builder enableDimAnimation(boolean z) {
            this.enableDimAnimation = z;
            return this;
        }

        @SuppressLint({"InflateParams"})
        public HSBottomSheet inflateAndBuild() {
            View view;
            if (this.layoutWindow != null) {
                if (this.enableDimAnimation) {
                    View view2 = new View(this.referenceView.getContext());
                    Window window = this.layoutWindow;
                    window.addContentView(view2, window.getAttributes());
                    view = view2;
                } else {
                    view = null;
                }
                LayoutInflater from = LayoutInflater.from(this.layoutWindow.getContext());
                this.content = from.inflate(this.layoutId, (ViewGroup) null);
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) from.inflate(C2466R.layout.hs__bottomsheet_wrapper, (ViewGroup) null);
                return new HSBottomSheet(this.content, this.layoutWindow, this.referenceView, view, this.enableDimAnimation, this.dimOpacity, coordinatorLayout, (FrameLayout) coordinatorLayout.findViewById(C2466R.C2468id.hs__bottom_sheet));
            }
            throw new IllegalArgumentException("Bottomsheet layout window can not be null");
        }

        public Builder referenceView(@Nullable View view) {
            this.referenceView = view;
            return this;
        }
    }

    public HSBottomSheet(View view, Window window, View view2, @Nullable View view3, boolean z, float f, View view4, ViewGroup viewGroup) {
        this.contentView = view;
        this.bottomSheetWindow = window;
        this.referenceWindowView = view2;
        this.viewToDim = view3;
        this.enableDimAnimation = z;
        this.dimOpacity = f;
        this.bottomSheetParentView = view4;
        this.bottomSheet = viewGroup;
    }

    private void attachBehaviourCallback() {
        getBottomSheetBehaviour().setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            public void onSlide(@NonNull View view, float f) {
                HSBottomSheet hSBottomSheet = HSBottomSheet.this;
                if (hSBottomSheet.enableDimAnimation && hSBottomSheet.viewToDim != null) {
                    float f2 = 0.0f;
                    if (f > 0.0f) {
                        f2 = f;
                    }
                    HSBottomSheet hSBottomSheet2 = HSBottomSheet.this;
                    hSBottomSheet2.viewToDim.setBackgroundColor(ColorUtils.blendARGB(0, ViewCompat.MEASURED_STATE_MASK, f2 * hSBottomSheet2.dimOpacity));
                }
                if (HSBottomSheet.this.callbacks.size() > 0) {
                    for (BottomSheetBehavior.BottomSheetCallback onSlide : HSBottomSheet.this.callbacks) {
                        onSlide.onSlide(view, f);
                    }
                }
            }

            public void onStateChanged(@NonNull View view, int i) {
                View view2 = HSBottomSheet.this.viewToDim;
                if (view2 != null) {
                    if (i == 3) {
                        view2.setClickable(true);
                    } else if (i == 4) {
                        view2.setClickable(false);
                    }
                }
                if (HSBottomSheet.this.callbacks.size() > 0) {
                    for (BottomSheetBehavior.BottomSheetCallback onStateChanged : HSBottomSheet.this.callbacks) {
                        onStateChanged.onStateChanged(view, i);
                    }
                }
            }
        });
    }

    private void attachBottomSheetToWindow(ViewGroup.LayoutParams layoutParams) {
        this.bottomSheetWindow.addContentView(this.bottomSheetParentView, layoutParams);
    }

    private void initiateReferenceViewAttachment() {
        if (ViewCompat.isLaidOut(this.referenceWindowView)) {
            showOnReferenceView();
        } else {
            this.referenceWindowView.post(new Runnable() {
                public void run() {
                    HSBottomSheet.this.showOnReferenceView();
                }
            });
        }
    }

    public void addBottomSheetCallback(@Nullable BottomSheetBehavior.BottomSheetCallback bottomSheetCallback) {
        this.callbacks.add(bottomSheetCallback);
    }

    public BottomSheetBehavior getBottomSheetBehaviour() {
        return BottomSheetBehavior.from(this.bottomSheet);
    }

    public View getBottomSheetContentView() {
        return this.contentView;
    }

    public ViewGroup.LayoutParams getParamsForReferenceView() {
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = this.referenceWindowView.getWidth();
        return layoutParams;
    }

    public ViewGroup.LayoutParams getParamsForWindow() {
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        return layoutParams;
    }

    public void remove() {
        if (ViewCompat.isAttachedToWindow(this.bottomSheetParentView)) {
            ((ViewGroup) this.bottomSheetParentView.getParent()).removeView(this.bottomSheetParentView);
        }
        View view = this.viewToDim;
        if (view != null && ViewCompat.isAttachedToWindow(view)) {
            ((ViewGroup) this.viewToDim.getParent()).removeView(this.viewToDim);
        }
    }

    public void removeAllBottomSheetCallbacks() {
        this.callbacks.clear();
    }

    public void setDraggable(boolean z) {
        ((HSBottomSheetBehaviour) getBottomSheetBehaviour()).setDraggable(z);
    }

    public void setupBottomSheetView() {
        int i;
        View findViewById;
        int[] iArr = new int[2];
        this.referenceWindowView.getLocationInWindow(iArr);
        View decorView = this.bottomSheetWindow.getDecorView();
        if (decorView == null || (findViewById = decorView.findViewById(16908290)) == null) {
            i = 0;
        } else {
            int[] iArr2 = new int[2];
            findViewById.getLocationInWindow(iArr2);
            i = iArr2[0];
        }
        this.bottomSheetParentView.setX((float) Math.max(0, iArr[0] - i));
    }

    public void show() {
        this.bottomSheet.addView(this.contentView);
        attachBehaviourCallback();
        if (this.referenceWindowView != null) {
            initiateReferenceViewAttachment();
        } else {
            this.bottomSheetWindow.addContentView(this.bottomSheetParentView, getParamsForWindow());
        }
    }

    public void showOnReferenceView() {
        setupBottomSheetView();
        attachBottomSheetToWindow(getParamsForReferenceView());
    }
}
