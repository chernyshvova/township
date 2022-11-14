package com.helpshift.support.controllers;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.helpshift.C2466R;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.support.compositions.FaqFragment;
import com.helpshift.support.compositions.SectionPagerFragment;
import com.helpshift.support.contracts.FaqFlowView;
import com.helpshift.support.contracts.FaqFragmentListener;
import com.helpshift.support.conversations.NewConversationFragment;
import com.helpshift.support.fragments.QuestionListFragment;
import com.helpshift.support.fragments.SearchFragment;
import com.helpshift.support.fragments.SingleQuestionFragment;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.util.FragmentUtil;
import com.helpshift.support.util.Styles;
import com.helpshift.util.HelpshiftConnectionUtil;
import com.helpshift.util.HelpshiftContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FaqFlowController implements FaqFragmentListener, MenuItemCompat.OnActionExpandListener, MenuItem.OnActionExpandListener, SearchView.OnQueryTextListener {
    public final String KEY_FAQ_CONTROLLER_STARTED_STATE = "key_faq_controller_state";
    public final Bundle bundle;
    public String currentQuery = "";
    public final FaqFlowView faqFlowView;
    public FragmentManager fragmentManager;
    public boolean isControllerStarted;
    public final boolean isScreenLarge;
    public String lastQuery = "";
    public boolean retainSearchFragmentState;

    public FaqFlowController(FaqFlowView faqFlowView2, Context context, FragmentManager fragmentManager2, Bundle bundle2) {
        this.faqFlowView = faqFlowView2;
        this.isScreenLarge = Styles.isTablet(context);
        this.fragmentManager = fragmentManager2;
        this.bundle = bundle2;
    }

    private boolean onQuery(String str) {
        SearchFragment searchFragment;
        if (this.retainSearchFragmentState || (searchFragment = (SearchFragment) this.fragmentManager.findFragmentByTag(SearchFragment.TAG)) == null) {
            return false;
        }
        searchFragment.onQuery(str, this.bundle.getString("sectionPublishId"));
        return true;
    }

    private void startFaqFragment() {
        FragmentUtil.startFragmentWithoutBackStack(this.fragmentManager, C2466R.C2468id.list_fragment_container, FaqFragment.newInstance(this.bundle), (String) null, true);
    }

    private void startQuestionListFragment() {
        FragmentUtil.startFragmentWithoutBackStack(this.fragmentManager, C2466R.C2468id.list_fragment_container, QuestionListFragment.newInstance(this.bundle), (String) null, false);
    }

    private void startSingleQuestionFragment() {
        int i = C2466R.C2468id.list_fragment_container;
        if (this.isScreenLarge) {
            i = C2466R.C2468id.single_question_container;
        }
        this.faqFlowView.getSupportFragment().getSupportController().setSearchPerformed(true);
        FragmentUtil.startFragmentWithoutBackStack(this.fragmentManager, i, SingleQuestionFragment.newInstance(this.bundle, 1, this.isScreenLarge, (SingleQuestionFragment.QuestionReadListener) null), (String) null, false);
    }

    public Fragment getTopMostFaqFragment() {
        return FragmentUtil.getTopMostFragment(this.fragmentManager);
    }

    public void onContactUsClicked(String str) {
        setRetainSearchFragmentState(true);
        performedSearch();
        this.faqFlowView.getSupportFragment().getSupportController().onContactUsClicked(str);
    }

    public void onFragmentManagerUpdate(FragmentManager fragmentManager2) {
        this.fragmentManager = fragmentManager2;
    }

    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        performedSearch();
        if (this.retainSearchFragmentState) {
            return true;
        }
        this.lastQuery = "";
        this.currentQuery = "";
        FragmentUtil.popBackStack(this.fragmentManager, SearchFragment.class.getName());
        return true;
    }

    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        if (((SearchFragment) this.fragmentManager.findFragmentByTag(SearchFragment.TAG)) != null) {
            return true;
        }
        FragmentUtil.startFragmentWithBackStack(this.fragmentManager, C2466R.C2468id.list_fragment_container, SearchFragment.newInstance(this.bundle), SearchFragment.TAG, false);
        return true;
    }

    public boolean onQueryTextChange(String str) {
        if (TextUtils.isEmpty(str) && this.currentQuery.length() > 2) {
            performedSearch();
        }
        this.currentQuery = str;
        return onQuery(str);
    }

    public boolean onQueryTextSubmit(String str) {
        return false;
    }

    public void onQuestionSelected(String str, ArrayList<String> arrayList) {
        performedSearch();
        this.faqFlowView.getSupportFragment().getSupportController().setSearchPerformed(true);
        Bundle bundle2 = new Bundle();
        bundle2.putString(SingleQuestionFragment.BUNDLE_ARG_QUESTION_PUBLISH_ID, str);
        bundle2.putStringArrayList("searchTerms", arrayList);
        if (this.isScreenLarge) {
            FragmentUtil.startFragmentWithoutBackStack(this.fragmentManager, C2466R.C2468id.details_fragment_container, SingleQuestionFragment.newInstance(bundle2, 1, false, (SingleQuestionFragment.QuestionReadListener) null), (String) null, false);
            return;
        }
        FragmentUtil.startFragmentWithBackStack(this.fragmentManager, C2466R.C2468id.list_fragment_container, SingleQuestionFragment.newInstance(bundle2, 1, false, (SingleQuestionFragment.QuestionReadListener) null), (String) null, false);
    }

    public void onSaveInstanceState(Bundle bundle2) {
        bundle2.putBoolean("key_faq_controller_state", this.isControllerStarted);
    }

    public void onSectionSelected(Bundle bundle2) {
        if (this.isScreenLarge) {
            FragmentUtil.startFragmentWithBackStack(this.fragmentManager, C2466R.C2468id.list_fragment_container, QuestionListFragment.newInstance(bundle2), (String) null, false);
            return;
        }
        FragmentUtil.startFragmentWithBackStack(this.fragmentManager, C2466R.C2468id.list_fragment_container, SectionPagerFragment.newInstance(bundle2), (String) null, false);
    }

    public void onViewStateRestored(Bundle bundle2) {
        if (!this.isControllerStarted && bundle2.containsKey("key_faq_controller_state")) {
            this.isControllerStarted = bundle2.getBoolean("key_faq_controller_state");
        }
    }

    public void performedSearch() {
        int numberOfSearchResults;
        if (!TextUtils.isEmpty(this.currentQuery.trim()) && !this.lastQuery.equals(this.currentQuery)) {
            this.faqFlowView.getSupportFragment().getSupportController().setSearchPerformed(true);
            this.bundle.putBoolean(NewConversationFragment.SEARCH_PERFORMED, true);
            SearchFragment searchFragment = (SearchFragment) this.fragmentManager.findFragmentByTag(SearchFragment.TAG);
            if (searchFragment != null && (numberOfSearchResults = searchFragment.getNumberOfSearchResults()) >= 0) {
                HashMap hashMap = new HashMap();
                hashMap.put(AnalyticsEventKey.SEARCH_QUERY, this.currentQuery);
                hashMap.put("n", Integer.valueOf(numberOfSearchResults));
                hashMap.put("nt", Boolean.valueOf(HelpshiftConnectionUtil.isOnline(HelpshiftContext.getApplicationContext())));
                HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.PERFORMED_SEARCH, (Map<String, Object>) hashMap);
                this.lastQuery = this.currentQuery;
            }
        }
    }

    public void setRetainSearchFragmentState(boolean z) {
        this.retainSearchFragmentState = z;
    }

    public void start() {
        if (!this.isControllerStarted) {
            int i = this.bundle.getInt(SupportFragment.SUPPORT_MODE, 0);
            if (i == 2) {
                startQuestionListFragment();
            } else if (i != 3) {
                startFaqFragment();
            } else {
                startSingleQuestionFragment();
            }
        }
        this.isControllerStarted = true;
    }
}
