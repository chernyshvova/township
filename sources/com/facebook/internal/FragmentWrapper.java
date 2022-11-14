package com.facebook.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentWrapper.kt */
public final class FragmentWrapper {
    public Fragment nativeFragment;
    public androidx.fragment.app.Fragment supportFragment;

    public FragmentWrapper(androidx.fragment.app.Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.supportFragment = fragment;
    }

    public final Activity getActivity() {
        androidx.fragment.app.Fragment fragment = this.supportFragment;
        if (fragment == null) {
            Fragment fragment2 = this.nativeFragment;
            if (fragment2 == null) {
                return null;
            }
            return fragment2.getActivity();
        } else if (fragment == null) {
            return null;
        } else {
            return fragment.getActivity();
        }
    }

    public final Fragment getNativeFragment() {
        return this.nativeFragment;
    }

    public final androidx.fragment.app.Fragment getSupportFragment() {
        return this.supportFragment;
    }

    public final void startActivityForResult(Intent intent, int i) {
        androidx.fragment.app.Fragment fragment = this.supportFragment;
        if (fragment == null) {
            Fragment fragment2 = this.nativeFragment;
            if (fragment2 != null) {
                fragment2.startActivityForResult(intent, i);
            }
        } else if (fragment != null) {
            fragment.startActivityForResult(intent, i);
        }
    }

    public FragmentWrapper(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.nativeFragment = fragment;
    }
}
