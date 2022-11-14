package com.helpshift.support.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.helpshift.C2466R;
import com.helpshift.model.InfoModelFactory;
import com.helpshift.support.compositions.FaqFragment;
import com.helpshift.support.fragments.AttachmentPreviewFragment;
import com.helpshift.support.fragments.FaqFlowFragment;
import com.helpshift.support.fragments.SearchFragment;
import com.helpshift.support.fragments.SingleQuestionFragment;
import com.helpshift.support.fragments.SupportFragment;
import java.util.Iterator;
import java.util.List;

public class FragmentUtil {
    public static FaqFlowFragment getFaqFlowFragment(FragmentManager fragmentManager) {
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments == null) {
            return null;
        }
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment != null && (fragment instanceof FaqFlowFragment)) {
                return (FaqFlowFragment) fragment;
            }
        }
        return null;
    }

    public static FaqFragment getFaqFragment(FragmentManager fragmentManager) {
        return (FaqFragment) getFragment(fragmentManager, FaqFragment.class);
    }

    public static <T extends Fragment> T getFragment(FragmentManager fragmentManager, Class<T> cls) {
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments == null) {
            return null;
        }
        Iterator<Fragment> it = fragments.iterator();
        while (it.hasNext()) {
            T t = (Fragment) it.next();
            if (cls.isInstance(t)) {
                return t;
            }
        }
        return null;
    }

    public static AttachmentPreviewFragment getScreenshotPreviewFragment(FragmentManager fragmentManager) {
        return (AttachmentPreviewFragment) getFragment(fragmentManager, AttachmentPreviewFragment.class);
    }

    public static SearchFragment getSearchFragment(FragmentManager fragmentManager) {
        return (SearchFragment) getFragment(fragmentManager, SearchFragment.class);
    }

    public static SingleQuestionFragment getSingleQuestionFragment(FragmentManager fragmentManager) {
        return (SingleQuestionFragment) getFragment(fragmentManager, SingleQuestionFragment.class);
    }

    public static SupportFragment getSupportFragment(Fragment fragment) {
        if (fragment instanceof SupportFragment) {
            return (SupportFragment) fragment;
        }
        Fragment parentFragment = fragment.getParentFragment();
        if (parentFragment == null) {
            return null;
        }
        if (parentFragment instanceof SupportFragment) {
            return (SupportFragment) parentFragment;
        }
        return getSupportFragment(parentFragment);
    }

    @Nullable
    public static Fragment getTopMostFragment(FragmentManager fragmentManager) {
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments == null || fragments.size() <= 0) {
            return null;
        }
        return fragments.get(fragments.size() - 1);
    }

    public static void loadFragment(FragmentManager fragmentManager, int i, Fragment fragment, String str, String str2, boolean z, boolean z2) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Fragment findFragmentById = fragmentManager.findFragmentById(i);
        if (!InfoModelFactory.getInstance().appInfoModel.disableAnimations.booleanValue()) {
            if (findFragmentById == null || z2) {
                beginTransaction.setCustomAnimations(0, 0, 0, 0);
            } else {
                beginTransaction.setCustomAnimations(C2466R.anim.hs__slide_in_from_right, C2466R.anim.hs__slide_out_to_left, C2466R.anim.hs__slide_in_from_left, C2466R.anim.hs__slide_out_to_right);
            }
        }
        beginTransaction.replace(i, fragment, str);
        if (!TextUtils.isEmpty(str2)) {
            beginTransaction.addToBackStack(str2);
        }
        beginTransaction.commitAllowingStateLoss();
        if (z) {
            fragmentManager.executePendingTransactions();
        }
    }

    public static void popBackStack(FragmentManager fragmentManager, String str) {
        fragmentManager.popBackStack(str, 1);
    }

    public static void popBackStackImmediate(FragmentManager fragmentManager, String str) {
        fragmentManager.popBackStackImmediate(str, 1);
    }

    public static void removeFragment(FragmentManager fragmentManager, Fragment fragment) {
        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
    }

    public static void startFragment(FragmentManager fragmentManager, int i, Fragment fragment, String str, String str2, boolean z, boolean z2) {
        loadFragment(fragmentManager, i, fragment, str, str2, z, z2);
    }

    public static void startFragmentWithBackStack(FragmentManager fragmentManager, int i, Fragment fragment, String str, boolean z) {
        loadFragment(fragmentManager, i, fragment, str, fragment.getClass().getName(), z, false);
    }

    public static void startFragmentWithoutBackStack(FragmentManager fragmentManager, int i, Fragment fragment, String str, boolean z) {
        loadFragment(fragmentManager, i, fragment, str, (String) null, z, false);
    }
}
