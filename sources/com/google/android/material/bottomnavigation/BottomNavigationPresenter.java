package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.transition.TransitionManager;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationPresenter implements MenuPresenter {

    /* renamed from: id */
    public int f2859id;
    public MenuBuilder menu;
    public BottomNavigationMenuView menuView;
    public boolean updateSuspended = false;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int selectedItemId;

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(this.selectedItemId);
        }

        public SavedState(Parcel parcel) {
            this.selectedItemId = parcel.readInt();
        }
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.f2859id;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        return this.menuView;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
        this.menuView.initialize(menuBuilder);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            BottomNavigationMenuView bottomNavigationMenuView = this.menuView;
            int i = ((SavedState) parcelable).selectedItemId;
            int size = bottomNavigationMenuView.menu.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = bottomNavigationMenuView.menu.getItem(i2);
                if (i == item.getItemId()) {
                    bottomNavigationMenuView.selectedItemId = i;
                    bottomNavigationMenuView.selectedItemPosition = i2;
                    item.setChecked(true);
                    return;
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.selectedItemId = this.menuView.getSelectedItemId();
        return savedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void setCallback(MenuPresenter.Callback callback) {
    }

    public void updateMenuView(boolean z) {
        if (!this.updateSuspended) {
            if (z) {
                this.menuView.buildMenuView();
                return;
            }
            BottomNavigationMenuView bottomNavigationMenuView = this.menuView;
            MenuBuilder menuBuilder = bottomNavigationMenuView.menu;
            if (menuBuilder != null && bottomNavigationMenuView.buttons != null) {
                int size = menuBuilder.size();
                if (size != bottomNavigationMenuView.buttons.length) {
                    bottomNavigationMenuView.buildMenuView();
                    return;
                }
                int i = bottomNavigationMenuView.selectedItemId;
                for (int i2 = 0; i2 < size; i2++) {
                    MenuItem item = bottomNavigationMenuView.menu.getItem(i2);
                    if (item.isChecked()) {
                        bottomNavigationMenuView.selectedItemId = item.getItemId();
                        bottomNavigationMenuView.selectedItemPosition = i2;
                    }
                }
                if (i != bottomNavigationMenuView.selectedItemId) {
                    TransitionManager.beginDelayedTransition(bottomNavigationMenuView, bottomNavigationMenuView.set);
                }
                boolean isShifting = bottomNavigationMenuView.isShifting(bottomNavigationMenuView.labelVisibilityMode, bottomNavigationMenuView.menu.getVisibleItems().size());
                for (int i3 = 0; i3 < size; i3++) {
                    bottomNavigationMenuView.presenter.updateSuspended = true;
                    bottomNavigationMenuView.buttons[i3].setLabelVisibilityMode(bottomNavigationMenuView.labelVisibilityMode);
                    bottomNavigationMenuView.buttons[i3].setShifting(isShifting);
                    bottomNavigationMenuView.buttons[i3].initialize((MenuItemImpl) bottomNavigationMenuView.menu.getItem(i3), 0);
                    bottomNavigationMenuView.presenter.updateSuspended = false;
                }
            }
        }
    }
}
