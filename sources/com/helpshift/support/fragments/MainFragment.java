package com.helpshift.support.fragments;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.helpshift.C2466R;
import com.helpshift.model.InfoModelFactory;
import com.helpshift.support.util.FragmentUtil;
import com.helpshift.support.util.Styles;
import com.helpshift.util.ActivityUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.LocaleContextUtil;
import com.helpshift.views.HSToast;
import java.lang.reflect.Field;

public abstract class MainFragment extends Fragment {
    public static final String TAG = SupportFragment.class.getSimpleName();
    public static final String TOOLBAR_ID = "toolbarId";
    public static boolean shouldRetainChildFragmentManager;
    public String fragmentName = getClass().getName();
    public boolean isChangingConfigurations;
    public boolean isScreenLarge;
    public FragmentManager retainedChildFragmentManager;

    public void copyToClipboard(String str) {
        ((ClipboardManager) getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copy Text", str));
        HSToast.makeText(getContext(), (CharSequence) getString(C2466R.string.hs__copied_to_clipboard), 0).show();
    }

    public Activity getActivity(Fragment fragment) {
        if (fragment == null) {
            return null;
        }
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getActivity();
    }

    public Context getContext() {
        Context context = super.getContext();
        if (context != null) {
            return context;
        }
        return HelpshiftContext.getApplicationContext();
    }

    public FragmentManager getRetainedChildFragmentManager() {
        if (!shouldRetainChildFragmentManager) {
            return getChildFragmentManager();
        }
        if (this.retainedChildFragmentManager == null) {
            this.retainedChildFragmentManager = getChildFragmentManager();
        }
        return this.retainedChildFragmentManager;
    }

    public boolean isChangingConfigurations() {
        return this.isChangingConfigurations;
    }

    public boolean isScreenLarge() {
        return this.isScreenLarge;
    }

    public void onAttach(Context context) {
        try {
            super.onAttach(LocaleContextUtil.getContextWithUpdatedLocaleLegacy(context));
            try {
                setRetainInstance(true);
            } catch (Exception unused) {
                shouldRetainChildFragmentManager = true;
            }
            if (HelpshiftContext.getApplicationContext() == null) {
                HelpshiftContext.setApplicationContext(context.getApplicationContext());
            }
            this.isScreenLarge = Styles.isTablet(getContext());
            if (shouldRetainChildFragmentManager && this.retainedChildFragmentManager != null) {
                try {
                    Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
                    declaredField.setAccessible(true);
                    declaredField.set(this, this.retainedChildFragmentManager);
                } catch (NoSuchFieldException e) {
                    HSLogger.m3238d(TAG, "NoSuchFieldException", (Throwable) e);
                } catch (IllegalAccessException e2) {
                    HSLogger.m3238d(TAG, "IllegalAccessException", (Throwable) e2);
                }
            }
        } catch (Exception e3) {
            Log.e(TAG, "Caught exception in MainFragment.onAttach()", e3);
            super.onAttach(context);
            if (!HelpshiftContext.installCallSuccessful.get()) {
                ActivityUtil.startLauncherActivityAndFinish(getActivity());
            }
            throw e3;
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        if (InfoModelFactory.getInstance().appInfoModel.disableAnimations.booleanValue() || z || isRemoving()) {
            return super.onCreateAnimation(i, z, i2);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
        alphaAnimation.setDuration((long) getResources().getInteger(C2466R.integer.hs_animation_duration));
        return alphaAnimation;
    }

    public void onPause() {
        this.isChangingConfigurations = getActivity(this).isChangingConfigurations();
        super.onPause();
    }

    public void onStart() {
        SupportFragment supportFragment;
        super.onStart();
        if (shouldRefreshMenu() && (supportFragment = FragmentUtil.getSupportFragment(this)) != null) {
            supportFragment.addVisibleFragment(this.fragmentName);
        }
    }

    public void onStop() {
        SupportFragment supportFragment;
        if (shouldRefreshMenu() && (supportFragment = FragmentUtil.getSupportFragment(this)) != null) {
            supportFragment.removeVisibleFragment(this.fragmentName);
        }
        super.onStop();
    }

    public void setToolbarTitle(String str) {
        SupportFragment supportFragment = FragmentUtil.getSupportFragment(this);
        if (supportFragment != null) {
            supportFragment.setToolbarTitleAndHeader(str);
        }
    }

    public abstract boolean shouldRefreshMenu();
}
