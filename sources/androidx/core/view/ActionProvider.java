package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import com.android.tools.p006r8.GeneratedOutlineSupport;

public abstract class ActionProvider {
    public static final String TAG = "ActionProvider(support)";
    public final Context mContext;
    public SubUiVisibilityListener mSubUiVisibilityListener;
    public VisibilityListener mVisibilityListener;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean z);
    }

    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public ActionProvider(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener != null && overridesItemVisibility()) {
            this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSubUiVisibilityListener(SubUiVisibilityListener subUiVisibilityListener) {
        this.mSubUiVisibilityListener = subUiVisibilityListener;
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        if (!(this.mVisibilityListener == null || visibilityListener == null)) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            outline24.append(getClass().getSimpleName());
            outline24.append(" instance while it is still in use somewhere else?");
            Log.w(TAG, outline24.toString());
        }
        this.mVisibilityListener = visibilityListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void subUiVisibilityChanged(boolean z) {
        SubUiVisibilityListener subUiVisibilityListener = this.mSubUiVisibilityListener;
        if (subUiVisibilityListener != null) {
            subUiVisibilityListener.onSubUiVisibilityChanged(z);
        }
    }
}
