package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.C0030Px;
import androidx.annotation.RequiresApi;
import com.vungle.warren.network.VungleApiImpl;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: View.kt */
public final class ViewKt {
    public static final void doOnAttach(View view, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$doOnAttach");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        if (ViewCompat.isAttachedToWindow(view)) {
            function1.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnAttach$1(view, function1));
        }
    }

    public static final void doOnDetach(View view, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$doOnDetach");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        if (!ViewCompat.isAttachedToWindow(view)) {
            function1.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnDetach$1(view, function1));
        }
    }

    public static final void doOnLayout(View view, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$doOnLayout");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(function1));
        } else {
            function1.invoke(view);
        }
    }

    public static final void doOnNextLayout(View view, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$doOnNextLayout");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        view.addOnLayoutChangeListener(new ViewKt$doOnNextLayout$1(function1));
    }

    public static final OneShotPreDrawListener doOnPreDraw(View view, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$doOnPreDraw");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        OneShotPreDrawListener add = OneShotPreDrawListener.add(view, new ViewKt$doOnPreDraw$1(view, function1));
        Intrinsics.checkExpressionValueIsNotNull(add, "OneShotPreDrawListener.add(this) { action(this) }");
        return add;
    }

    public static final Bitmap drawToBitmap(View view, Bitmap.Config config) {
        Intrinsics.checkParameterIsNotNull(view, "$this$drawToBitmap");
        Intrinsics.checkParameterIsNotNull(config, VungleApiImpl.CONFIG);
        if (ViewCompat.isLaidOut(view)) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
            Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-((float) view.getScrollX()), -((float) view.getScrollY()));
            view.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final int getMarginBottom(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$marginBottom");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$marginEnd");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$marginLeft");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$marginRight");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$marginStart");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$marginTop");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$isGone");
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$isInvisible");
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$isVisible");
        return view.getVisibility() == 0;
    }

    public static final Runnable postDelayed(View view, long j, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(view, "$this$postDelayed");
        Intrinsics.checkParameterIsNotNull(function0, "action");
        ViewKt$postDelayed$runnable$1 viewKt$postDelayed$runnable$1 = new ViewKt$postDelayed$runnable$1(function0);
        view.postDelayed(viewKt$postDelayed$runnable$1, j);
        return viewKt$postDelayed$runnable$1;
    }

    @RequiresApi(16)
    public static final Runnable postOnAnimationDelayed(View view, long j, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(view, "$this$postOnAnimationDelayed");
        Intrinsics.checkParameterIsNotNull(function0, "action");
        ViewKt$postOnAnimationDelayed$runnable$1 viewKt$postOnAnimationDelayed$runnable$1 = new ViewKt$postOnAnimationDelayed$runnable$1(function0);
        view.postOnAnimationDelayed(viewKt$postOnAnimationDelayed$runnable$1, j);
        return viewKt$postOnAnimationDelayed$runnable$1;
    }

    public static final void setGone(View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "$this$isGone");
        view.setVisibility(z ? 8 : 0);
    }

    public static final void setInvisible(View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "$this$isInvisible");
        view.setVisibility(z ? 4 : 0);
    }

    public static final void setPadding(View view, @C0030Px int i) {
        Intrinsics.checkParameterIsNotNull(view, "$this$setPadding");
        view.setPadding(i, i, i, i);
    }

    public static final void setVisible(View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "$this$isVisible");
        view.setVisibility(z ? 0 : 8);
    }

    public static final void updateLayoutParams(View view, Function1<? super ViewGroup.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$updateLayoutParams");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            function1.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$updateLayoutParams");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        view.getLayoutParams();
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    public static final void updatePadding(View view, @C0030Px int i, @C0030Px int i2, @C0030Px int i3, @C0030Px int i4) {
        Intrinsics.checkParameterIsNotNull(view, "$this$updatePadding");
        view.setPadding(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingLeft();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingRight();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        Intrinsics.checkParameterIsNotNull(view, "$this$updatePadding");
        view.setPadding(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(View view, @C0030Px int i, @C0030Px int i2, @C0030Px int i3, @C0030Px int i4) {
        Intrinsics.checkParameterIsNotNull(view, "$this$updatePaddingRelative");
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingStart();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        Intrinsics.checkParameterIsNotNull(view, "$this$updatePaddingRelative");
        view.setPaddingRelative(i, i2, i3, i4);
    }
}
