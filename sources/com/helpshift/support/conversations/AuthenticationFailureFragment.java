package com.helpshift.support.conversations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.helpshift.C2466R;
import com.helpshift.support.fragments.MainFragment;
import com.helpshift.util.Styles;

public class AuthenticationFailureFragment extends MainFragment {
    public static final String FRAGMENT_TAG = "HSAuthenticationFailureFragment";

    public static AuthenticationFailureFragment newInstance() {
        return new AuthenticationFailureFragment();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2466R.layout.hs__authentication_failure_fragment, viewGroup, false);
    }

    public void onResume() {
        super.onResume();
        setToolbarTitle(getString(C2466R.string.hs__conversation_header));
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        Styles.setColorFilter(getContext(), ((ImageView) view.findViewById(C2466R.C2468id.info_icon)).getDrawable(), 16842806);
        super.onViewCreated(view, bundle);
    }

    public boolean shouldRefreshMenu() {
        return true;
    }
}
