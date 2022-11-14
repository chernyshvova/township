package com.helpshift.support.conversations;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.Snackbar;
import com.helpshift.C2466R;
import com.helpshift.support.controllers.SupportController;
import com.helpshift.support.fragments.MainFragment;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.storage.IMAppSessionStorage;
import com.helpshift.support.util.AppSessionConstants;
import com.helpshift.support.util.SnackbarUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.KeyboardUtil;
import com.helpshift.util.PermissionUtil;
import com.helpshift.views.HSSnackbar;

public abstract class BaseConversationFragment extends MainFragment {
    public static final int REQUEST_READ_STORAGE_PERMISSION_REQUEST_ID = 2;
    public static final int REQUEST_WRITE_STORAGE_PERMISSION_REQUEST_ID = 3;
    public static final String TAG = "Helpshift_BaseConvFrag";
    public Snackbar permissionDeniedSnackbar;
    public Snackbar showRationaleSnackbar;

    public abstract int getAttachmentMode();

    public SupportController getSupportController() {
        return getSupportFragment().getSupportController();
    }

    public SupportFragment getSupportFragment() {
        return (SupportFragment) getParentFragment();
    }

    public abstract String getToolbarTitle();

    public abstract AppSessionConstants.Screen getViewName();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportFragment().resetNewMessageCount();
    }

    public void onDestroyView() {
        SnackbarUtil.hideSnackbar(getView());
        super.onDestroyView();
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    public void onPause() {
        Snackbar snackbar = this.showRationaleSnackbar;
        if (snackbar != null && snackbar.isShown()) {
            this.showRationaleSnackbar.dispatchDismiss(3);
        }
        Snackbar snackbar2 = this.permissionDeniedSnackbar;
        if (snackbar2 != null && snackbar2.isShown()) {
            this.permissionDeniedSnackbar.dispatchDismiss(3);
        }
        super.onPause();
    }

    public abstract void onPermissionGranted(int i);

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        boolean z = true;
        if (!(iArr.length == 1 && iArr[0] == 0)) {
            z = false;
        }
        HSLogger.m3237d(TAG, "onRequestPermissionsResult : request: " + i + ", result: " + z);
        if (z) {
            onPermissionGranted(i);
            return;
        }
        this.permissionDeniedSnackbar = HSSnackbar.make(getView(), C2466R.string.hs__permission_denied_message, -1);
        if (strArr.length > 0 && !shouldShowRequestPermissionRationale(strArr[0])) {
            this.permissionDeniedSnackbar.setAction(C2466R.string.hs__permission_denied_snackbar_action, new View.OnClickListener() {
                public void onClick(View view) {
                    PermissionUtil.showSettingsPage(BaseConversationFragment.this.getContext());
                }
            });
        }
        this.permissionDeniedSnackbar.show();
    }

    public void onResume() {
        super.onResume();
        setToolbarTitle(getToolbarTitle());
    }

    public void onStart() {
        super.onStart();
        IMAppSessionStorage.getInstance().set(AppSessionConstants.CURRENT_OPEN_SCREEN, getViewName());
    }

    public void onStop() {
        AppSessionConstants.Screen screen = (AppSessionConstants.Screen) IMAppSessionStorage.getInstance().get(AppSessionConstants.CURRENT_OPEN_SCREEN);
        if (screen != null && screen.equals(getViewName())) {
            IMAppSessionStorage.getInstance().removeKey(AppSessionConstants.CURRENT_OPEN_SCREEN);
        }
        super.onStop();
    }

    public void requestPermission(boolean z, int i) {
        String str = i != 2 ? i != 3 ? null : "android.permission.WRITE_EXTERNAL_STORAGE" : "android.permission.READ_EXTERNAL_STORAGE";
        if (z && str != null) {
            KeyboardUtil.hideKeyboard(getContext(), getView());
            this.showRationaleSnackbar = PermissionUtil.requestPermissions(getParentFragment(), new String[]{str}, C2466R.string.hs__permission_denied_message, C2466R.string.hs__permission_rationale_snackbar_action_label, i, getView());
        } else if (!isDetached()) {
            SnackbarUtil.showSnackbar(getView(), C2466R.string.hs__permission_not_granted, -1);
        }
    }

    public void requestWriteExternalStoragePermission(boolean z) {
        requestPermission(z, 3);
    }

    public boolean shouldRefreshMenu() {
        return true;
    }
}
