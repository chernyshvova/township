package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.C0032R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.android.billingclient.api.zzam;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    public static final int ANIMATION_DURATION = 300;
    @Dimension(unit = 0)
    public static final int DEFAULT_GAP_TEXT_ICON = 8;
    @Dimension(unit = 0)
    public static final int DEFAULT_HEIGHT = 48;
    @Dimension(unit = 0)
    public static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    @Dimension(unit = 0)
    public static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    public static final int INVALID_WIDTH = -1;
    @Dimension(unit = 0)
    public static final int MIN_INDICATOR_WIDTH = 24;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    @Dimension(unit = 0)
    public static final int TAB_MIN_WIDTH_MARGIN = 56;
    public static final Pools.Pool<Tab> tabPool = new Pools.SynchronizedPool(16);
    public AdapterChangeListener adapterChangeListener;
    public int contentInsetStart;
    public BaseOnTabSelectedListener currentVpSelectedListener;
    public boolean inlineLabel;
    public int mode;
    public TabLayoutOnPageChangeListener pageChangeListener;
    public PagerAdapter pagerAdapter;
    public DataSetObserver pagerAdapterObserver;
    public final int requestedTabMaxWidth;
    public final int requestedTabMinWidth;
    public ValueAnimator scrollAnimator;
    public final int scrollableTabMinWidth;
    public BaseOnTabSelectedListener selectedListener;
    public final ArrayList<BaseOnTabSelectedListener> selectedListeners;
    public Tab selectedTab;
    public boolean setupViewPagerImplicitly;
    public final SlidingTabIndicator slidingTabIndicator;
    public final int tabBackgroundResId;
    public int tabGravity;
    public ColorStateList tabIconTint;
    public PorterDuff.Mode tabIconTintMode;
    public int tabIndicatorAnimationDuration;
    public boolean tabIndicatorFullWidth;
    public int tabIndicatorGravity;
    public int tabMaxWidth;
    public int tabPaddingBottom;
    public int tabPaddingEnd;
    public int tabPaddingStart;
    public int tabPaddingTop;
    public ColorStateList tabRippleColorStateList;
    @Nullable
    public Drawable tabSelectedIndicator;
    public int tabTextAppearance;
    public ColorStateList tabTextColors;
    public float tabTextMultiLineSize;
    public float tabTextSize;
    public final RectF tabViewContentBounds;
    public final Pools.Pool<TabView> tabViewPool;
    public final ArrayList<Tab> tabs;
    public boolean unboundedRipple;
    public ViewPager viewPager;

    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        public boolean autoRefresh;

        public AdapterChangeListener() {
        }

        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.viewPager == viewPager) {
                tabLayout.setPagerAdapter(pagerAdapter2, this.autoRefresh);
            }
        }
    }

    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T t);

        void onTabSelected(T t);

        void onTabUnselected(T t);
    }

    public class PagerAdapterObserver extends DataSetObserver {
        public PagerAdapterObserver() {
        }

        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    public class SlidingTabIndicator extends LinearLayout {
        public final GradientDrawable defaultSelectionIndicator;
        public ValueAnimator indicatorAnimator;
        public int indicatorLeft = -1;
        public int indicatorRight = -1;
        public int layoutDirection = -1;
        public int selectedIndicatorHeight;
        public final Paint selectedIndicatorPaint;
        public int selectedPosition = -1;
        public float selectionOffset;

        public SlidingTabIndicator(Context context) {
            super(context);
            setWillNotDraw(false);
            this.selectedIndicatorPaint = new Paint();
            this.defaultSelectionIndicator = new GradientDrawable();
        }

        public void animateIndicatorToPosition(final int i, int i2) {
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.indicatorAnimator.cancel();
            }
            View childAt = getChildAt(i);
            if (childAt == null) {
                updateIndicatorPosition();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.tabIndicatorFullWidth && (childAt instanceof TabView)) {
                calculateTabViewContentBounds((TabView) childAt, tabLayout.tabViewContentBounds);
                left = (int) TabLayout.this.tabViewContentBounds.left;
                right = (int) TabLayout.this.tabViewContentBounds.right;
            }
            final int i3 = left;
            final int i4 = right;
            final int i5 = this.indicatorLeft;
            final int i6 = this.indicatorRight;
            if (i5 != i3 || i6 != i4) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.indicatorAnimator = valueAnimator2;
                valueAnimator2.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                valueAnimator2.setDuration((long) i2);
                valueAnimator2.setFloatValues(new float[]{0.0f, 1.0f});
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        SlidingTabIndicator slidingTabIndicator = SlidingTabIndicator.this;
                        int lerp = AnimationUtils.lerp(i5, i3, animatedFraction);
                        int i = i6;
                        int round = Math.round(animatedFraction * ((float) (i4 - i))) + i;
                        if (lerp != slidingTabIndicator.indicatorLeft || round != slidingTabIndicator.indicatorRight) {
                            slidingTabIndicator.indicatorLeft = lerp;
                            slidingTabIndicator.indicatorRight = round;
                            ViewCompat.postInvalidateOnAnimation(slidingTabIndicator);
                        }
                    }
                });
                valueAnimator2.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        SlidingTabIndicator slidingTabIndicator = SlidingTabIndicator.this;
                        slidingTabIndicator.selectedPosition = i;
                        slidingTabIndicator.selectionOffset = 0.0f;
                    }
                });
                valueAnimator2.start();
            }
        }

        public final void calculateTabViewContentBounds(TabView tabView, RectF rectF) {
            View[] viewArr = {tabView.textView, tabView.iconView, tabView.customView};
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? Math.min(i2, view.getLeft()) : view.getLeft();
                    i = z ? Math.max(i, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            int i4 = i - i2;
            if (i4 < TabLayout.this.dpToPx(24)) {
                i4 = TabLayout.this.dpToPx(24);
            }
            int right = (tabView.getRight() + tabView.getLeft()) / 2;
            int i5 = i4 / 2;
            rectF.set((float) (right - i5), 0.0f, (float) (right + i5), 0.0f);
        }

        public void draw(Canvas canvas) {
            Drawable drawable = TabLayout.this.tabSelectedIndicator;
            int i = 0;
            int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
            int i2 = this.selectedIndicatorHeight;
            if (i2 >= 0) {
                intrinsicHeight = i2;
            }
            int i3 = TabLayout.this.tabIndicatorGravity;
            if (i3 == 0) {
                i = getHeight() - intrinsicHeight;
                intrinsicHeight = getHeight();
            } else if (i3 == 1) {
                i = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i3 != 2) {
                if (i3 != 3) {
                    intrinsicHeight = 0;
                } else {
                    intrinsicHeight = getHeight();
                }
            }
            int i4 = this.indicatorLeft;
            if (i4 >= 0 && this.indicatorRight > i4) {
                Drawable drawable2 = TabLayout.this.tabSelectedIndicator;
                if (drawable2 == null) {
                    drawable2 = this.defaultSelectionIndicator;
                }
                Drawable wrap = DrawableCompat.wrap(drawable2);
                wrap.setBounds(this.indicatorLeft, i, this.indicatorRight, intrinsicHeight);
                Paint paint = this.selectedIndicatorPaint;
                if (paint != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        wrap.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        DrawableCompat.setTint(wrap, paint.getColor());
                    }
                }
                wrap.draw(canvas);
            }
            super.draw(canvas);
        }

        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                updateIndicatorPosition();
                return;
            }
            this.indicatorAnimator.cancel();
            animateIndicatorToPosition(this.selectedPosition, Math.round((1.0f - this.indicatorAnimator.getAnimatedFraction()) * ((float) this.indicatorAnimator.getDuration())));
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z = true;
                if (tabLayout.mode == 1 && tabLayout.tabGravity == 1) {
                    int childCount = getChildCount();
                    int i3 = 0;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = getChildAt(i4);
                        if (childAt.getVisibility() == 0) {
                            i3 = Math.max(i3, childAt.getMeasuredWidth());
                        }
                    }
                    if (i3 > 0) {
                        if (i3 * childCount <= getMeasuredWidth() - (TabLayout.this.dpToPx(16) * 2)) {
                            boolean z2 = false;
                            for (int i5 = 0; i5 < childCount; i5++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                                if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i3;
                                    layoutParams.weight = 0.0f;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.tabGravity = 0;
                            tabLayout2.updateTabViews(false);
                        }
                        if (z) {
                            super.onMeasure(i, i2);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT < 23 && this.layoutDirection != i) {
                requestLayout();
                this.layoutDirection = i;
            }
        }

        public final void updateIndicatorPosition() {
            int i;
            View childAt = getChildAt(this.selectedPosition);
            int i2 = -1;
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
            } else {
                int left = childAt.getLeft();
                int right = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.tabIndicatorFullWidth && (childAt instanceof TabView)) {
                    calculateTabViewContentBounds((TabView) childAt, tabLayout.tabViewContentBounds);
                    left = (int) TabLayout.this.tabViewContentBounds.left;
                    right = (int) TabLayout.this.tabViewContentBounds.right;
                }
                if (this.selectionOffset <= 0.0f || this.selectedPosition >= getChildCount() - 1) {
                    i2 = left;
                    i = right;
                } else {
                    View childAt2 = getChildAt(this.selectedPosition + 1);
                    int left2 = childAt2.getLeft();
                    int right2 = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.tabIndicatorFullWidth && (childAt2 instanceof TabView)) {
                        calculateTabViewContentBounds((TabView) childAt2, tabLayout2.tabViewContentBounds);
                        left2 = (int) TabLayout.this.tabViewContentBounds.left;
                        right2 = (int) TabLayout.this.tabViewContentBounds.right;
                    }
                    float f = this.selectionOffset;
                    float f2 = 1.0f - f;
                    i2 = (int) ((((float) left) * f2) + (((float) left2) * f));
                    i = (int) ((f2 * ((float) right)) + (((float) right2) * f));
                }
            }
            if (i2 != this.indicatorLeft || i != this.indicatorRight) {
                this.indicatorLeft = i2;
                this.indicatorRight = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    public static class Tab {
        public CharSequence contentDesc;
        public View customView;
        public Drawable icon;
        public TabLayout parent;
        public int position = -1;
        public CharSequence text;
        public TabView view;

        @NonNull
        public Tab setText(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.contentDesc) && !TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.text = charSequence;
            updateView();
            return this;
        }

        public void updateView() {
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.update();
            }
        }
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public int previousScrollState;
        public int scrollState;
        public final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.tabLayoutRef = new WeakReference<>(tabLayout);
        }

        public void onPageScrollStateChanged(int i) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i;
        }

        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout = (TabLayout) this.tabLayoutRef.get();
            if (tabLayout != null) {
                boolean z = false;
                boolean z2 = this.scrollState != 2 || this.previousScrollState == 1;
                if (!(this.scrollState == 2 && this.previousScrollState == 0)) {
                    z = true;
                }
                tabLayout.setScrollPosition(i, f, z2, z);
            }
        }

        public void onPageSelected(int i) {
            TabLayout tabLayout = (TabLayout) this.tabLayoutRef.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.scrollState;
                tabLayout.selectTab(tabLayout.getTabAt(i), i2 == 0 || (i2 == 2 && this.previousScrollState == 0));
            }
        }
    }

    public class TabView extends LinearLayout {
        @Nullable
        public Drawable baseBackgroundDrawable;
        public ImageView customIconView;
        public TextView customTextView;
        public View customView;
        public int defaultMaxLines = 2;
        public ImageView iconView;
        public Tab tab;
        public TextView textView;

        public TabView(Context context) {
            super(context);
            updateBackgroundDrawable(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(TabLayout.this.inlineLabel ^ true ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.baseBackgroundDrawable;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.baseBackgroundDrawable.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0096, code lost:
            if (((r0 / r2.getPaint().getTextSize()) * r2.getLineWidth(0)) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) goto L_0x0098;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMeasure(int r8, int r9) {
            /*
                r7 = this;
                int r0 = android.view.View.MeasureSpec.getSize(r8)
                int r1 = android.view.View.MeasureSpec.getMode(r8)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                int r2 = r2.getTabMaxWidth()
                if (r2 <= 0) goto L_0x001e
                if (r1 == 0) goto L_0x0014
                if (r0 <= r2) goto L_0x001e
            L_0x0014:
                com.google.android.material.tabs.TabLayout r8 = com.google.android.material.tabs.TabLayout.this
                int r8 = r8.tabMaxWidth
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r0)
            L_0x001e:
                super.onMeasure(r8, r9)
                android.widget.TextView r0 = r7.textView
                if (r0 == 0) goto L_0x00a8
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                float r0 = r0.tabTextSize
                int r1 = r7.defaultMaxLines
                android.widget.ImageView r2 = r7.iconView
                r3 = 1
                if (r2 == 0) goto L_0x0038
                int r2 = r2.getVisibility()
                if (r2 != 0) goto L_0x0038
                r1 = 1
                goto L_0x0046
            L_0x0038:
                android.widget.TextView r2 = r7.textView
                if (r2 == 0) goto L_0x0046
                int r2 = r2.getLineCount()
                if (r2 <= r3) goto L_0x0046
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                float r0 = r0.tabTextMultiLineSize
            L_0x0046:
                android.widget.TextView r2 = r7.textView
                float r2 = r2.getTextSize()
                android.widget.TextView r4 = r7.textView
                int r4 = r4.getLineCount()
                android.widget.TextView r5 = r7.textView
                int r5 = androidx.core.widget.TextViewCompat.getMaxLines(r5)
                int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r6 != 0) goto L_0x0060
                if (r5 < 0) goto L_0x00a8
                if (r1 == r5) goto L_0x00a8
            L_0x0060:
                com.google.android.material.tabs.TabLayout r5 = com.google.android.material.tabs.TabLayout.this
                int r5 = r5.mode
                r6 = 0
                if (r5 != r3) goto L_0x0099
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 <= 0) goto L_0x0099
                if (r4 != r3) goto L_0x0099
                android.widget.TextView r2 = r7.textView
                android.text.Layout r2 = r2.getLayout()
                if (r2 == 0) goto L_0x0098
                float r4 = r2.getLineWidth(r6)
                android.text.TextPaint r2 = r2.getPaint()
                float r2 = r2.getTextSize()
                float r2 = r0 / r2
                float r2 = r2 * r4
                int r4 = r7.getMeasuredWidth()
                int r5 = r7.getPaddingLeft()
                int r4 = r4 - r5
                int r5 = r7.getPaddingRight()
                int r4 = r4 - r5
                float r4 = (float) r4
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 <= 0) goto L_0x0099
            L_0x0098:
                r3 = 0
            L_0x0099:
                if (r3 == 0) goto L_0x00a8
                android.widget.TextView r2 = r7.textView
                r2.setTextSize(r6, r0)
                android.widget.TextView r0 = r7.textView
                r0.setMaxLines(r1)
                super.onMeasure(r8, r9)
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.onMeasure(int, int):void");
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.tab == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            Tab tab2 = this.tab;
            TabLayout tabLayout = tab2.parent;
            if (tabLayout != null) {
                tabLayout.selectTab(tab2);
                return true;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void setSelected(boolean z) {
            if (isSelected() != z) {
            }
            super.setSelected(z);
            TextView textView2 = this.textView;
            if (textView2 != null) {
                textView2.setSelected(z);
            }
            ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.customView;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public final void update() {
            Drawable drawable;
            Tab tab2 = this.tab;
            Drawable drawable2 = null;
            View view = tab2 != null ? tab2.customView : null;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.customView = view;
                TextView textView2 = this.textView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.iconView.setImageDrawable((Drawable) null);
                }
                TextView textView3 = (TextView) view.findViewById(16908308);
                this.customTextView = textView3;
                if (textView3 != null) {
                    this.defaultMaxLines = TextViewCompat.getMaxLines(textView3);
                }
                this.customIconView = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.customView;
                if (view2 != null) {
                    removeView(view2);
                    this.customView = null;
                }
                this.customTextView = null;
                this.customIconView = null;
            }
            boolean z = false;
            if (this.customView == null) {
                if (this.iconView == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, this, false);
                    addView(imageView2, 0);
                    this.iconView = imageView2;
                }
                if (!(tab2 == null || (drawable = tab2.icon) == null)) {
                    drawable2 = DrawableCompat.wrap(drawable).mutate();
                }
                if (drawable2 != null) {
                    DrawableCompat.setTintList(drawable2, TabLayout.this.tabIconTint);
                    PorterDuff.Mode mode = TabLayout.this.tabIconTintMode;
                    if (mode != null) {
                        DrawableCompat.setTintMode(drawable2, mode);
                    }
                }
                if (this.textView == null) {
                    TextView textView4 = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, this, false);
                    addView(textView4);
                    this.textView = textView4;
                    this.defaultMaxLines = TextViewCompat.getMaxLines(textView4);
                }
                TextViewCompat.setTextAppearance(this.textView, TabLayout.this.tabTextAppearance);
                ColorStateList colorStateList = TabLayout.this.tabTextColors;
                if (colorStateList != null) {
                    this.textView.setTextColor(colorStateList);
                }
                updateTextAndIcon(this.textView, this.iconView);
            } else if (!(this.customTextView == null && this.customIconView == null)) {
                updateTextAndIcon(this.customTextView, this.customIconView);
            }
            if (tab2 != null && !TextUtils.isEmpty(tab2.contentDesc)) {
                setContentDescription(tab2.contentDesc);
            }
            if (tab2 != null) {
                TabLayout tabLayout = tab2.parent;
                if (tabLayout != null) {
                    if (tabLayout.getSelectedTabPosition() == tab2.position) {
                        z = true;
                    }
                } else {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
            }
            setSelected(z);
        }

        /* JADX WARNING: type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        /* JADX WARNING: type inference failed for: r0v3, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void updateBackgroundDrawable(android.content.Context r7) {
            /*
                r6 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.tabBackgroundResId
                r1 = 0
                if (r0 == 0) goto L_0x001f
                android.graphics.drawable.Drawable r7 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r7, r0)
                r6.baseBackgroundDrawable = r7
                if (r7 == 0) goto L_0x0021
                boolean r7 = r7.isStateful()
                if (r7 == 0) goto L_0x0021
                android.graphics.drawable.Drawable r7 = r6.baseBackgroundDrawable
                int[] r0 = r6.getDrawableState()
                r7.setState(r0)
                goto L_0x0021
            L_0x001f:
                r6.baseBackgroundDrawable = r1
            L_0x0021:
                android.graphics.drawable.GradientDrawable r7 = new android.graphics.drawable.GradientDrawable
                r7.<init>()
                r0 = 0
                r7.setColor(r0)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.tabRippleColorStateList
                if (r2 == 0) goto L_0x0078
                android.graphics.drawable.GradientDrawable r2 = new android.graphics.drawable.GradientDrawable
                r2.<init>()
                r3 = 925353388(0x3727c5ac, float:1.0E-5)
                r2.setCornerRadius(r3)
                r3 = -1
                r2.setColor(r3)
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r3 = r3.tabRippleColorStateList
                android.content.res.ColorStateList r3 = com.google.android.material.ripple.RippleUtils.convertToRippleDrawableColor(r3)
                int r4 = android.os.Build.VERSION.SDK_INT
                r5 = 21
                if (r4 < r5) goto L_0x0063
                android.graphics.drawable.RippleDrawable r0 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.unboundedRipple
                if (r4 == 0) goto L_0x0056
                r7 = r1
            L_0x0056:
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.unboundedRipple
                if (r4 == 0) goto L_0x005d
                goto L_0x005e
            L_0x005d:
                r1 = r2
            L_0x005e:
                r0.<init>(r3, r7, r1)
                r7 = r0
                goto L_0x0078
            L_0x0063:
                android.graphics.drawable.Drawable r1 = androidx.core.graphics.drawable.DrawableCompat.wrap(r2)
                androidx.core.graphics.drawable.DrawableCompat.setTintList(r1, r3)
                android.graphics.drawable.LayerDrawable r2 = new android.graphics.drawable.LayerDrawable
                r3 = 2
                android.graphics.drawable.Drawable[] r3 = new android.graphics.drawable.Drawable[r3]
                r3[r0] = r7
                r7 = 1
                r3[r7] = r1
                r2.<init>(r3)
                r7 = r2
            L_0x0078:
                androidx.core.view.ViewCompat.setBackground(r6, r7)
                com.google.android.material.tabs.TabLayout r7 = com.google.android.material.tabs.TabLayout.this
                r7.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.updateBackgroundDrawable(android.content.Context):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
            r0 = r0.icon;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void updateTextAndIcon(@androidx.annotation.Nullable android.widget.TextView r6, @androidx.annotation.Nullable android.widget.ImageView r7) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout$Tab r0 = r5.tab
                r1 = 0
                if (r0 == 0) goto L_0x0012
                android.graphics.drawable.Drawable r0 = r0.icon
                if (r0 == 0) goto L_0x0012
                android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.DrawableCompat.wrap(r0)
                android.graphics.drawable.Drawable r0 = r0.mutate()
                goto L_0x0013
            L_0x0012:
                r0 = r1
            L_0x0013:
                com.google.android.material.tabs.TabLayout$Tab r2 = r5.tab
                if (r2 == 0) goto L_0x001a
                java.lang.CharSequence r2 = r2.text
                goto L_0x001b
            L_0x001a:
                r2 = r1
            L_0x001b:
                r3 = 8
                r4 = 0
                if (r7 == 0) goto L_0x0032
                if (r0 == 0) goto L_0x002c
                r7.setImageDrawable(r0)
                r7.setVisibility(r4)
                r5.setVisibility(r4)
                goto L_0x0032
            L_0x002c:
                r7.setVisibility(r3)
                r7.setImageDrawable(r1)
            L_0x0032:
                boolean r0 = android.text.TextUtils.isEmpty(r2)
                r0 = r0 ^ 1
                if (r6 == 0) goto L_0x004c
                if (r0 == 0) goto L_0x0046
                r6.setText(r2)
                r6.setVisibility(r4)
                r5.setVisibility(r4)
                goto L_0x004c
            L_0x0046:
                r6.setVisibility(r3)
                r6.setText(r1)
            L_0x004c:
                if (r7 == 0) goto L_0x008b
                android.view.ViewGroup$LayoutParams r6 = r7.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
                if (r0 == 0) goto L_0x0063
                int r2 = r7.getVisibility()
                if (r2 != 0) goto L_0x0063
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                int r2 = r2.dpToPx(r3)
                goto L_0x0064
            L_0x0063:
                r2 = 0
            L_0x0064:
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                boolean r3 = r3.inlineLabel
                if (r3 == 0) goto L_0x007c
                int r3 = androidx.core.view.MarginLayoutParamsCompat.getMarginEnd(r6)
                if (r2 == r3) goto L_0x008b
                androidx.core.view.MarginLayoutParamsCompat.setMarginEnd(r6, r2)
                r6.bottomMargin = r4
                r7.setLayoutParams(r6)
                r7.requestLayout()
                goto L_0x008b
            L_0x007c:
                int r3 = r6.bottomMargin
                if (r2 == r3) goto L_0x008b
                r6.bottomMargin = r2
                androidx.core.view.MarginLayoutParamsCompat.setMarginEnd(r6, r4)
                r7.setLayoutParams(r6)
                r7.requestLayout()
            L_0x008b:
                com.google.android.material.tabs.TabLayout$Tab r6 = r5.tab
                if (r6 == 0) goto L_0x0092
                java.lang.CharSequence r6 = r6.contentDesc
                goto L_0x0093
            L_0x0092:
                r6 = r1
            L_0x0093:
                if (r0 == 0) goto L_0x0096
                goto L_0x0097
            L_0x0096:
                r1 = r6
            L_0x0097:
                androidx.appcompat.widget.TooltipCompat.setTooltipText(r5, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.updateTextAndIcon(android.widget.TextView, android.widget.ImageView):void");
        }
    }

    public static class ViewPagerOnTabSelectedListener implements BaseOnTabSelectedListener {
        public final ViewPager viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager2) {
            this.viewPager = viewPager2;
        }

        public void onTabReselected(Tab tab) {
        }

        public void onTabSelected(Tab tab) {
            this.viewPager.setCurrentItem(tab.position);
        }

        public void onTabUnselected(Tab tab) {
        }
    }

    public TabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void addTabFromItemView(@NonNull TabItem tabItem) {
        Tab newTab = newTab();
        CharSequence charSequence = tabItem.text;
        if (charSequence != null) {
            newTab.setText(charSequence);
        }
        Drawable drawable = tabItem.icon;
        if (drawable != null) {
            newTab.icon = drawable;
            newTab.updateView();
        }
        int i = tabItem.customLayout;
        if (i != 0) {
            newTab.customView = LayoutInflater.from(newTab.view.getContext()).inflate(i, newTab.view, false);
            newTab.updateView();
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            newTab.contentDesc = tabItem.getContentDescription();
            newTab.updateView();
        }
        addTab(newTab);
    }

    private void addTabView(Tab tab) {
        this.slidingTabIndicator.addView(tab.view, tab.position, createLayoutParamsForTabs());
    }

    private void addViewInternal(View view) {
        if (view instanceof TabItem) {
            addTabFromItemView((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void animateToTab(int i) {
        boolean z;
        if (i != -1) {
            if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
                SlidingTabIndicator slidingTabIndicator2 = this.slidingTabIndicator;
                int childCount = slidingTabIndicator2.getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        z = false;
                        break;
                    } else if (slidingTabIndicator2.getChildAt(i2).getWidth() <= 0) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    int scrollX = getScrollX();
                    int calculateScrollXForTab = calculateScrollXForTab(i, 0.0f);
                    if (scrollX != calculateScrollXForTab) {
                        ensureScrollAnimator();
                        this.scrollAnimator.setIntValues(new int[]{scrollX, calculateScrollXForTab});
                        this.scrollAnimator.start();
                    }
                    this.slidingTabIndicator.animateIndicatorToPosition(i, this.tabIndicatorAnimationDuration);
                    return;
                }
            }
            setScrollPosition(i, 0.0f, true);
        }
    }

    private void applyModeAndGravity() {
        ViewCompat.setPaddingRelative(this.slidingTabIndicator, this.mode == 0 ? Math.max(0, this.contentInsetStart - this.tabPaddingStart) : 0, 0, 0, 0);
        int i = this.mode;
        if (i == 0) {
            this.slidingTabIndicator.setGravity(GravityCompat.START);
        } else if (i == 1) {
            this.slidingTabIndicator.setGravity(1);
        }
        updateTabViews(true);
    }

    private int calculateScrollXForTab(int i, float f) {
        int i2 = 0;
        if (this.mode != 0) {
            return 0;
        }
        View childAt = this.slidingTabIndicator.getChildAt(i);
        int i3 = i + 1;
        View childAt2 = i3 < this.slidingTabIndicator.getChildCount() ? this.slidingTabIndicator.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i4 = (int) (((float) (width + i2)) * 0.5f * f);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i4 : left - i4;
    }

    private void configureTab(Tab tab, int i) {
        tab.position = i;
        this.tabs.add(i, tab);
        int size = this.tabs.size();
        while (true) {
            i++;
            if (i < size) {
                this.tabs.get(i).position = i;
            } else {
                return;
            }
        }
    }

    public static ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i2, i});
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private TabView createTabView(@NonNull Tab tab) {
        Pools.Pool<TabView> pool = this.tabViewPool;
        TabView acquire = pool != null ? pool.acquire() : null;
        if (acquire == null) {
            acquire = new TabView(getContext());
        }
        if (tab != acquire.tab) {
            acquire.tab = tab;
            acquire.update();
        }
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.contentDesc)) {
            acquire.setContentDescription(tab.text);
        } else {
            acquire.setContentDescription(tab.contentDesc);
        }
        return acquire;
    }

    private void dispatchTabReselected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabReselected(tab);
        }
    }

    private void dispatchTabSelected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabSelected(tab);
        }
    }

    private void dispatchTabUnselected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabUnselected(tab);
        }
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.scrollAnimator.setDuration((long) this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.tabs.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < size) {
                Tab tab = this.tabs.get(i);
                if (tab != null && tab.icon != null && !TextUtils.isEmpty(tab.text)) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return (!z || this.inlineLabel) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i = this.requestedTabMinWidth;
        if (i != -1) {
            return i;
        }
        if (this.mode == 0) {
            return this.scrollableTabMinWidth;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void removeTabViewAt(int i) {
        TabView tabView = (TabView) this.slidingTabIndicator.getChildAt(i);
        this.slidingTabIndicator.removeViewAt(i);
        if (tabView != null) {
            if (tabView.tab != null) {
                tabView.tab = null;
                tabView.update();
            }
            tabView.setSelected(false);
            this.tabViewPool.release(tabView);
        }
        requestLayout();
    }

    private void setSelectedTabView(int i) {
        int childCount = this.slidingTabIndicator.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = this.slidingTabIndicator.getChildAt(i2);
                boolean z = true;
                childAt.setSelected(i2 == i);
                if (i2 != i) {
                    z = false;
                }
                childAt.setActivated(z);
                i2++;
            }
        }
    }

    private void updateAllTabs() {
        int size = this.tabs.size();
        for (int i = 0; i < size; i++) {
            this.tabs.get(i).updateView();
        }
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
        if (this.mode == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public void addOnTabSelectedListener(@NonNull BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (!this.selectedListeners.contains(baseOnTabSelectedListener)) {
            this.selectedListeners.add(baseOnTabSelectedListener);
        }
    }

    public void addTab(@NonNull Tab tab) {
        addTab(tab, this.tabs.isEmpty());
    }

    public void addView(View view) {
        addViewInternal(view);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public Tab createTabFromPool() {
        Tab acquire = tabPool.acquire();
        return acquire == null ? new Tab() : acquire;
    }

    @Dimension(unit = 1)
    public int dpToPx(@Dimension(unit = 0) int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    public int getSelectedTabPosition() {
        Tab tab = this.selectedTab;
        if (tab != null) {
            return tab.position;
        }
        return -1;
    }

    @Nullable
    public Tab getTabAt(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.tabs.get(i);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    @Nullable
    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    @NonNull
    public Tab newTab() {
        Tab createTabFromPool = createTabFromPool();
        createTabFromPool.parent = this;
        createTabFromPool.view = createTabView(createTabFromPool);
        return createTabFromPool;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.viewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager((ViewPager) null);
            this.setupViewPagerImplicitly = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        r1 = (com.google.android.material.tabs.TabLayout.TabView) r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r8) {
        /*
            r7 = this;
            r0 = 0
        L_0x0001:
            com.google.android.material.tabs.TabLayout$SlidingTabIndicator r1 = r7.slidingTabIndicator
            int r1 = r1.getChildCount()
            if (r0 >= r1) goto L_0x0034
            com.google.android.material.tabs.TabLayout$SlidingTabIndicator r1 = r7.slidingTabIndicator
            android.view.View r1 = r1.getChildAt(r0)
            boolean r2 = r1 instanceof com.google.android.material.tabs.TabLayout.TabView
            if (r2 == 0) goto L_0x0031
            com.google.android.material.tabs.TabLayout$TabView r1 = (com.google.android.material.tabs.TabLayout.TabView) r1
            android.graphics.drawable.Drawable r2 = r1.baseBackgroundDrawable
            if (r2 == 0) goto L_0x0031
            int r3 = r1.getLeft()
            int r4 = r1.getTop()
            int r5 = r1.getRight()
            int r6 = r1.getBottom()
            r2.setBounds(r3, r4, r5, r6)
            android.graphics.drawable.Drawable r1 = r1.baseBackgroundDrawable
            r1.draw(r8)
        L_0x0031:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0034:
            super.onDraw(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
        if (r1.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        if (r1.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.getDefaultHeight()
            int r0 = r5.dpToPx(r0)
            int r1 = r5.getPaddingTop()
            int r1 = r1 + r0
            int r0 = r5.getPaddingBottom()
            int r0 = r0 + r1
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r1 == r2) goto L_0x0024
            if (r1 == 0) goto L_0x001f
            goto L_0x0030
        L_0x001f:
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L_0x0030
        L_0x0024:
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r7 = java.lang.Math.min(r0, r7)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
        L_0x0030:
            int r0 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r6)
            if (r1 == 0) goto L_0x0049
            int r1 = r5.requestedTabMaxWidth
            if (r1 <= 0) goto L_0x003f
            goto L_0x0047
        L_0x003f:
            r1 = 56
            int r1 = r5.dpToPx(r1)
            int r1 = r0 - r1
        L_0x0047:
            r5.tabMaxWidth = r1
        L_0x0049:
            super.onMeasure(r6, r7)
            int r6 = r5.getChildCount()
            r0 = 1
            if (r6 != r0) goto L_0x0097
            r6 = 0
            android.view.View r1 = r5.getChildAt(r6)
            int r2 = r5.mode
            if (r2 == 0) goto L_0x006a
            if (r2 == r0) goto L_0x005f
            goto L_0x0077
        L_0x005f:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 == r4) goto L_0x0075
            goto L_0x0076
        L_0x006a:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 >= r4) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r0 = 0
        L_0x0076:
            r6 = r0
        L_0x0077:
            if (r6 == 0) goto L_0x0097
            int r6 = r5.getPaddingTop()
            int r0 = r5.getPaddingBottom()
            int r0 = r0 + r6
            android.view.ViewGroup$LayoutParams r6 = r1.getLayoutParams()
            int r6 = r6.height
            int r6 = android.widget.HorizontalScrollView.getChildMeasureSpec(r7, r0, r6)
            int r7 = r5.getMeasuredWidth()
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
            r1.measure(r7, r6)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 != null) {
            int count = pagerAdapter2.getCount();
            for (int i = 0; i < count; i++) {
                Tab newTab = newTab();
                newTab.setText(this.pagerAdapter.getPageTitle(i));
                addTab(newTab, false);
            }
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 != null && count > 0 && (currentItem = viewPager2.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                selectTab(getTabAt(currentItem));
            }
        }
    }

    public boolean releaseFromTabPool(Tab tab) {
        return tabPool.release(tab);
    }

    public void removeAllTabs() {
        for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<Tab> it = this.tabs.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.parent = null;
            next.view = null;
            next.icon = null;
            next.text = null;
            next.contentDesc = null;
            next.position = -1;
            next.customView = null;
            releaseFromTabPool(next);
        }
        this.selectedTab = null;
    }

    public void removeOnTabSelectedListener(@NonNull BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.selectedListeners.remove(baseOnTabSelectedListener);
    }

    public void removeTab(Tab tab) {
        if (tab.parent == this) {
            removeTabAt(tab.position);
            return;
        }
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int i) {
        Tab tab = this.selectedTab;
        int i2 = tab != null ? tab.position : 0;
        removeTabViewAt(i);
        Tab remove = this.tabs.remove(i);
        Tab tab2 = null;
        if (remove != null) {
            remove.parent = null;
            remove.view = null;
            remove.icon = null;
            remove.text = null;
            remove.contentDesc = null;
            remove.position = -1;
            remove.customView = null;
            releaseFromTabPool(remove);
        }
        int size = this.tabs.size();
        for (int i3 = i; i3 < size; i3++) {
            this.tabs.get(i3).position = i3;
        }
        if (i2 == i) {
            if (!this.tabs.isEmpty()) {
                tab2 = this.tabs.get(Math.max(0, i - 1));
            }
            selectTab(tab2);
        }
    }

    public void selectTab(Tab tab) {
        selectTab(tab, true);
    }

    public void setInlineLabel(boolean z) {
        if (this.inlineLabel != z) {
            this.inlineLabel = z;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    TabView tabView = (TabView) childAt;
                    tabView.setOrientation(TabLayout.this.inlineLabel ^ true ? 1 : 0);
                    if (tabView.customTextView == null && tabView.customIconView == null) {
                        tabView.updateTextAndIcon(tabView.textView, tabView.iconView);
                    } else {
                        tabView.updateTextAndIcon(tabView.customTextView, tabView.customIconView);
                    }
                }
            }
            applyModeAndGravity();
        }
    }

    public void setInlineLabelResource(@BoolRes int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.selectedListener;
        if (baseOnTabSelectedListener2 != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener2);
        }
        this.selectedListener = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            addOnTabSelectedListener(baseOnTabSelectedListener);
        }
    }

    public void setPagerAdapter(@Nullable PagerAdapter pagerAdapter2, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter3 = this.pagerAdapter;
        if (!(pagerAdapter3 == null || (dataSetObserver = this.pagerAdapterObserver) == null)) {
            pagerAdapter3.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = pagerAdapter2;
        if (z && pagerAdapter2 != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new PagerAdapterObserver();
            }
            pagerAdapter2.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int i, float f, boolean z) {
        setScrollPosition(i, f, z, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.tabSelectedIndicator != drawable) {
            this.tabSelectedIndicator = drawable;
            ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
        SlidingTabIndicator slidingTabIndicator2 = this.slidingTabIndicator;
        if (slidingTabIndicator2.selectedIndicatorPaint.getColor() != i) {
            slidingTabIndicator2.selectedIndicatorPaint.setColor(i);
            ViewCompat.postInvalidateOnAnimation(slidingTabIndicator2);
        }
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.tabIndicatorGravity != i) {
            this.tabIndicatorGravity = i;
            ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        SlidingTabIndicator slidingTabIndicator2 = this.slidingTabIndicator;
        if (slidingTabIndicator2.selectedIndicatorHeight != i) {
            slidingTabIndicator2.selectedIndicatorHeight = i;
            ViewCompat.postInvalidateOnAnimation(slidingTabIndicator2);
        }
    }

    public void setTabGravity(int i) {
        if (this.tabGravity != i) {
            this.tabGravity = i;
            applyModeAndGravity();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            updateAllTabs();
        }
    }

    public void setTabIconTintResource(@ColorRes int i) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.tabIndicatorFullWidth = z;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setTabMode(int i) {
        if (i != this.mode) {
            this.mode = i;
            applyModeAndGravity();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter2) {
        setPagerAdapter(pagerAdapter2, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.unboundedRipple != z) {
            this.unboundedRipple = z;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager2) {
        setupWithViewPager(viewPager2, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public void updateTabViews(boolean z) {
        for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
            View childAt = this.slidingTabIndicator.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    public void addTab(@NonNull Tab tab, int i) {
        addTab(tab, i, this.tabs.isEmpty());
    }

    public void addView(View view, int i) {
        addViewInternal(view);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public void selectTab(Tab tab, boolean z) {
        Tab tab2 = this.selectedTab;
        if (tab2 != tab) {
            int i = tab != null ? tab.position : -1;
            if (z) {
                if ((tab2 == null || tab2.position == -1) && i != -1) {
                    setScrollPosition(i, 0.0f, true);
                } else {
                    animateToTab(i);
                }
                if (i != -1) {
                    setSelectedTabView(i);
                }
            }
            this.selectedTab = tab;
            if (tab2 != null) {
                dispatchTabUnselected(tab2);
            }
            if (tab != null) {
                dispatchTabSelected(tab);
            }
        } else if (tab2 != null) {
            dispatchTabReselected(tab);
            animateToTab(tab.position);
        }
    }

    public void setScrollPosition(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.slidingTabIndicator.getChildCount()) {
            if (z2) {
                SlidingTabIndicator slidingTabIndicator2 = this.slidingTabIndicator;
                ValueAnimator valueAnimator = slidingTabIndicator2.indicatorAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    slidingTabIndicator2.indicatorAnimator.cancel();
                }
                slidingTabIndicator2.selectedPosition = i;
                slidingTabIndicator2.selectionOffset = f;
                slidingTabIndicator2.updateIndicatorPosition();
            }
            ValueAnimator valueAnimator2 = this.scrollAnimator;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.scrollAnimator.cancel();
            }
            scrollTo(calculateScrollXForTab(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager2, boolean z) {
        setupWithViewPager(viewPager2, z, false);
    }

    /* JADX INFO: finally extract failed */
    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tabs = new ArrayList<>();
        this.tabViewContentBounds = new RectF();
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.selectedListeners = new ArrayList<>();
        this.tabViewPool = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator slidingTabIndicator2 = new SlidingTabIndicator(context);
        this.slidingTabIndicator = slidingTabIndicator2;
        super.addView(slidingTabIndicator2, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R$styleable.TabLayout, i, R$style.Widget_Design_TabLayout, R$styleable.TabLayout_tabTextAppearance);
        SlidingTabIndicator slidingTabIndicator3 = this.slidingTabIndicator;
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, -1);
        if (slidingTabIndicator3.selectedIndicatorHeight != dimensionPixelSize) {
            slidingTabIndicator3.selectedIndicatorHeight = dimensionPixelSize;
            ViewCompat.postInvalidateOnAnimation(slidingTabIndicator3);
        }
        SlidingTabIndicator slidingTabIndicator4 = this.slidingTabIndicator;
        int color = obtainStyledAttributes.getColor(R$styleable.TabLayout_tabIndicatorColor, 0);
        if (slidingTabIndicator4.selectedIndicatorPaint.getColor() != color) {
            slidingTabIndicator4.selectedIndicatorPaint.setColor(color);
            ViewCompat.postInvalidateOnAnimation(slidingTabIndicator4);
        }
        setSelectedTabIndicator(zzam.getDrawable(context, obtainStyledAttributes, R$styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(obtainStyledAttributes.getInt(R$styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(obtainStyledAttributes.getBoolean(R$styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = dimensionPixelSize2;
        this.tabPaddingEnd = dimensionPixelSize2;
        this.tabPaddingTop = dimensionPixelSize2;
        this.tabPaddingStart = dimensionPixelSize2;
        this.tabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, dimensionPixelSize2);
        this.tabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.TabLayout_tabTextAppearance, R$style.TextAppearance_Design_Tab);
        this.tabTextAppearance = resourceId;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, C0032R.styleable.TextAppearance);
        try {
            this.tabTextSize = (float) obtainStyledAttributes2.getDimensionPixelSize(C0032R.styleable.TextAppearance_android_textSize, 0);
            this.tabTextColors = zzam.getColorStateList(context, obtainStyledAttributes2, C0032R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes2.recycle();
            if (obtainStyledAttributes.hasValue(R$styleable.TabLayout_tabTextColor)) {
                this.tabTextColors = zzam.getColorStateList(context, obtainStyledAttributes, R$styleable.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(R$styleable.TabLayout_tabSelectedTextColor)) {
                this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), obtainStyledAttributes.getColor(R$styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.tabIconTint = zzam.getColorStateList(context, obtainStyledAttributes, R$styleable.TabLayout_tabIconTint);
            this.tabIconTintMode = zzam.parseTintMode(obtainStyledAttributes.getInt(R$styleable.TabLayout_tabIconTintMode, -1), (PorterDuff.Mode) null);
            this.tabRippleColorStateList = zzam.getColorStateList(context, obtainStyledAttributes, R$styleable.TabLayout_tabRippleColor);
            this.tabIndicatorAnimationDuration = obtainStyledAttributes.getInt(R$styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.requestedTabMinWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
            this.requestedTabMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
            this.tabBackgroundResId = obtainStyledAttributes.getResourceId(R$styleable.TabLayout_tabBackground, 0);
            this.contentInsetStart = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
            this.mode = obtainStyledAttributes.getInt(R$styleable.TabLayout_tabMode, 1);
            this.tabGravity = obtainStyledAttributes.getInt(R$styleable.TabLayout_tabGravity, 0);
            this.inlineLabel = obtainStyledAttributes.getBoolean(R$styleable.TabLayout_tabInlineLabel, false);
            this.unboundedRipple = obtainStyledAttributes.getBoolean(R$styleable.TabLayout_tabUnboundedRipple, false);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.tabTextMultiLineSize = (float) resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
            this.scrollableTabMinWidth = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
            applyModeAndGravity();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private void setupWithViewPager(@Nullable ViewPager viewPager2, boolean z, boolean z2) {
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.pageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager3.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener2 = this.adapterChangeListener;
            if (adapterChangeListener2 != null) {
                this.viewPager.removeOnAdapterChangeListener(adapterChangeListener2);
            }
        }
        BaseOnTabSelectedListener baseOnTabSelectedListener = this.currentVpSelectedListener;
        if (baseOnTabSelectedListener != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener);
            this.currentVpSelectedListener = null;
        }
        if (viewPager2 != null) {
            this.viewPager = viewPager2;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener2 = this.pageChangeListener;
            tabLayoutOnPageChangeListener2.scrollState = 0;
            tabLayoutOnPageChangeListener2.previousScrollState = 0;
            viewPager2.addOnPageChangeListener(tabLayoutOnPageChangeListener2);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager2);
            this.currentVpSelectedListener = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener(viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager2.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new AdapterChangeListener();
            }
            AdapterChangeListener adapterChangeListener3 = this.adapterChangeListener;
            adapterChangeListener3.autoRefresh = z;
            viewPager2.addOnAdapterChangeListener(adapterChangeListener3);
            setScrollPosition(viewPager2.getCurrentItem(), 0.0f, true);
        } else {
            this.viewPager = null;
            setPagerAdapter((PagerAdapter) null, false);
        }
        this.setupViewPagerImplicitly = z2;
    }

    public void addTab(@NonNull Tab tab, boolean z) {
        addTab(tab, this.tabs.size(), z);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void addTab(@NonNull Tab tab, int i, boolean z) {
        if (tab.parent == this) {
            configureTab(tab, i);
            addTabView(tab);
            if (z) {
                TabLayout tabLayout = tab.parent;
                if (tabLayout != null) {
                    tabLayout.selectTab(tab);
                    return;
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void setSelectedTabIndicator(@DrawableRes int i) {
        if (i != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }
}
