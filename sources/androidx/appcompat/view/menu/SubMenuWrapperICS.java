package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportSubMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    public final SupportSubMenu mSubMenu;

    public SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
        this.mSubMenu = supportSubMenu;
    }

    public void clearHeader() {
        this.mSubMenu.clearHeader();
    }

    public MenuItem getItem() {
        return getMenuItemWrapper(this.mSubMenu.getItem());
    }

    public SubMenu setHeaderIcon(int i) {
        this.mSubMenu.setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        this.mSubMenu.setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.mSubMenu.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.mSubMenu.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.mSubMenu.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.mSubMenu.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.mSubMenu.setIcon(drawable);
        return this;
    }
}
