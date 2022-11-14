package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0032R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;

public class NavigationView extends ScrimInsetsFrameLayout {
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final int[] DISABLED_STATE_SET = {-16842910};
    public OnNavigationItemSelectedListener listener;
    public final int maxWidth;
    public final NavigationMenu menu;
    public MenuInflater menuInflater;
    public final NavigationMenuPresenter presenter = new NavigationMenuPresenter();

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ColorStateList colorStateList;
        boolean z;
        int i2;
        this.menu = new NavigationMenu(context);
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context, attributeSet, R$styleable.NavigationView, i, R$style.Widget_Design_NavigationView, new int[0]);
        ViewCompat.setBackground(this, obtainTintedStyledAttributes.getDrawable(R$styleable.NavigationView_android_background));
        if (obtainTintedStyledAttributes.hasValue(R$styleable.NavigationView_elevation)) {
            ViewCompat.setElevation(this, (float) obtainTintedStyledAttributes.getDimensionPixelSize(R$styleable.NavigationView_elevation, 0));
        }
        ViewCompat.setFitsSystemWindows(this, obtainTintedStyledAttributes.getBoolean(R$styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = obtainTintedStyledAttributes.getDimensionPixelSize(R$styleable.NavigationView_android_maxWidth, 0);
        if (obtainTintedStyledAttributes.hasValue(R$styleable.NavigationView_itemIconTint)) {
            colorStateList = obtainTintedStyledAttributes.getColorStateList(R$styleable.NavigationView_itemIconTint);
        } else {
            colorStateList = createDefaultColorStateList(16842808);
        }
        if (obtainTintedStyledAttributes.hasValue(R$styleable.NavigationView_itemTextAppearance)) {
            i2 = obtainTintedStyledAttributes.getResourceId(R$styleable.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            i2 = 0;
            z = false;
        }
        ColorStateList colorStateList2 = obtainTintedStyledAttributes.hasValue(R$styleable.NavigationView_itemTextColor) ? obtainTintedStyledAttributes.getColorStateList(R$styleable.NavigationView_itemTextColor) : null;
        if (!z && colorStateList2 == null) {
            colorStateList2 = createDefaultColorStateList(16842806);
        }
        Drawable drawable = obtainTintedStyledAttributes.getDrawable(R$styleable.NavigationView_itemBackground);
        if (obtainTintedStyledAttributes.hasValue(R$styleable.NavigationView_itemHorizontalPadding)) {
            this.presenter.setItemHorizontalPadding(obtainTintedStyledAttributes.getDimensionPixelSize(R$styleable.NavigationView_itemHorizontalPadding, 0));
        }
        int dimensionPixelSize = obtainTintedStyledAttributes.getDimensionPixelSize(R$styleable.NavigationView_itemIconPadding, 0);
        this.menu.setCallback(new MenuBuilder.Callback() {
            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                OnNavigationItemSelectedListener onNavigationItemSelectedListener = NavigationView.this.listener;
                return onNavigationItemSelectedListener != null && onNavigationItemSelectedListener.onNavigationItemSelected(menuItem);
            }

            public void onMenuModeChange(MenuBuilder menuBuilder) {
            }
        });
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.f2860id = 1;
        navigationMenuPresenter.initForMenu(context, this.menu);
        NavigationMenuPresenter navigationMenuPresenter2 = this.presenter;
        navigationMenuPresenter2.iconTintList = colorStateList;
        navigationMenuPresenter2.updateMenuView(false);
        if (z) {
            NavigationMenuPresenter navigationMenuPresenter3 = this.presenter;
            navigationMenuPresenter3.textAppearance = i2;
            navigationMenuPresenter3.textAppearanceSet = true;
            navigationMenuPresenter3.updateMenuView(false);
        }
        NavigationMenuPresenter navigationMenuPresenter4 = this.presenter;
        navigationMenuPresenter4.textColor = colorStateList2;
        navigationMenuPresenter4.updateMenuView(false);
        NavigationMenuPresenter navigationMenuPresenter5 = this.presenter;
        navigationMenuPresenter5.itemBackground = drawable;
        navigationMenuPresenter5.updateMenuView(false);
        this.presenter.setItemIconPadding(dimensionPixelSize);
        this.menu.addMenuPresenter(this.presenter);
        NavigationMenuPresenter navigationMenuPresenter6 = this.presenter;
        if (navigationMenuPresenter6.menuView == null) {
            navigationMenuPresenter6.menuView = (NavigationMenuView) navigationMenuPresenter6.layoutInflater.inflate(R$layout.design_navigation_menu, this, false);
            if (navigationMenuPresenter6.adapter == null) {
                navigationMenuPresenter6.adapter = new NavigationMenuPresenter.NavigationMenuAdapter();
            }
            navigationMenuPresenter6.headerLayout = (LinearLayout) navigationMenuPresenter6.layoutInflater.inflate(R$layout.design_navigation_item_header, navigationMenuPresenter6.menuView, false);
            navigationMenuPresenter6.menuView.setAdapter(navigationMenuPresenter6.adapter);
        }
        addView(navigationMenuPresenter6.menuView);
        if (obtainTintedStyledAttributes.hasValue(R$styleable.NavigationView_menu)) {
            int resourceId = obtainTintedStyledAttributes.getResourceId(R$styleable.NavigationView_menu, 0);
            this.presenter.setUpdateSuspended(true);
            getMenuInflater().inflate(resourceId, this.menu);
            this.presenter.setUpdateSuspended(false);
            this.presenter.updateMenuView(false);
        }
        if (obtainTintedStyledAttributes.hasValue(R$styleable.NavigationView_headerLayout)) {
            int resourceId2 = obtainTintedStyledAttributes.getResourceId(R$styleable.NavigationView_headerLayout, 0);
            NavigationMenuPresenter navigationMenuPresenter7 = this.presenter;
            navigationMenuPresenter7.headerLayout.addView(navigationMenuPresenter7.layoutInflater.inflate(resourceId2, navigationMenuPresenter7.headerLayout, false));
            NavigationMenuView navigationMenuView = navigationMenuPresenter7.menuView;
            navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
        }
        obtainTintedStyledAttributes.recycle();
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    public final ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(C0032R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(DISABLED_STATE_SET, defaultColor), i2, defaultColor});
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.presenter.adapter.checkedItem;
    }

    public int getHeaderCount() {
        return this.presenter.headerLayout.getChildCount();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.presenter.itemBackground;
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.presenter.itemHorizontalPadding;
    }

    @Dimension
    public int getItemIconPadding() {
        return this.presenter.itemIconPadding;
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.presenter.iconTintList;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.presenter.textColor;
    }

    public Menu getMenu() {
        return this.menu;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onInsetsChanged(WindowInsetsCompat windowInsetsCompat) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            if (navigationMenuPresenter.paddingTopDefault != systemWindowInsetTop) {
                navigationMenuPresenter.paddingTopDefault = systemWindowInsetTop;
                if (navigationMenuPresenter.headerLayout.getChildCount() == 0) {
                    NavigationMenuView navigationMenuView = navigationMenuPresenter.menuView;
                    navigationMenuView.setPadding(0, navigationMenuPresenter.paddingTopDefault, 0, navigationMenuView.getPaddingBottom());
                }
            }
            ViewCompat.dispatchApplyWindowInsets(navigationMenuPresenter.headerLayout, windowInsetsCompat);
            return;
        }
        throw null;
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.maxWidth), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuState);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    public void setCheckedItem(@IdRes int i) {
        MenuItem findItem = this.menu.findItem(i);
        if (findItem != null) {
            this.presenter.adapter.setCheckedItem((MenuItemImpl) findItem);
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemBackground = drawable;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemBackgroundResource(@DrawableRes int i) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemHorizontalPadding(@Dimension int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemHorizontalPadding = i;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconPadding(@Dimension int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemIconPadding = i;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemIconPaddingResource(int i) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.iconTintList = colorStateList;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemTextAppearance(@StyleRes int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.textAppearance = i;
        navigationMenuPresenter.textAppearanceSet = true;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.textColor = colorStateList;
        navigationMenuPresenter.updateMenuView(false);
    }

    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        public Bundle menuState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem findItem = this.menu.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.presenter.adapter.setCheckedItem((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
