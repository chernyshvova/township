package com.helpshift.support.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.helpshift.C2466R;
import com.helpshift.activities.MainActivity;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.fragments.SupportFragmentConstants;
import com.helpshift.util.ActivityUtil;
import com.helpshift.util.HelpshiftContext;
import java.util.List;

public class ParentActivity extends MainActivity {
    public static final String TAG = "Helpshift_PrntAct";
    public FragmentManager fragmentManager;

    public void onBackPressed() {
        List<Fragment> fragments = this.fragmentManager.getFragments();
        if (fragments != null) {
            for (Fragment next : fragments) {
                if (next != null && next.isVisible() && (next instanceof SupportFragment)) {
                    if (!((SupportFragment) next).onBackPressed()) {
                        FragmentManager childFragmentManager = next.getChildFragmentManager();
                        if (childFragmentManager.getBackStackEntryCount() > 0) {
                            childFragmentManager.popBackStack();
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (!HelpshiftContext.installCallSuccessful.get()) {
                Log.d(TAG, "Install call not successful, falling back to launcher activity");
                ActivityUtil.startLauncherActivityAndFinish(this);
                return;
            }
            setContentView(C2466R.layout.hs__parent_activity);
            this.fragmentManager = getSupportFragmentManager();
            if (bundle == null) {
                Bundle extras = getIntent().getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                extras.putBoolean(SupportFragmentConstants.IS_EMBEDDED, false);
                FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
                beginTransaction.add(C2466R.C2468id.support_fragment_container, (Fragment) SupportFragment.newInstance(extras));
                beginTransaction.commit();
            }
        } catch (Exception e) {
            Log.e(TAG, "Caught exception in ParentActivity.onCreate()", e);
            if (!HelpshiftContext.installCallSuccessful.get()) {
                ActivityUtil.startLauncherActivityAndFinish(this);
            }
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        List<Fragment> fragments = this.fragmentManager.getFragments();
        if (fragments != null) {
            for (Fragment next : fragments) {
                if (next instanceof SupportFragment) {
                    ((SupportFragment) next).onNewIntent(intent.getExtras());
                }
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
