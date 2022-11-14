package com.helpshift.support.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.helpshift.C2466R;
import com.helpshift.support.compositions.FaqFragment;
import com.helpshift.support.contracts.FaqFlowView;
import com.helpshift.support.contracts.FaqFragmentListener;
import com.helpshift.support.controllers.FaqFlowController;
import com.helpshift.support.flows.CustomContactUsFlowListHolder;
import com.helpshift.support.flows.Flow;
import com.helpshift.support.util.FragmentUtil;
import java.util.List;

public class FaqFlowFragment extends MainFragment implements FaqFlowView {
    public static final String FRAGMENT_TAG = "Helpshift_FaqFlowFrag";
    public List<Flow> customContactUsFlows;
    public FaqFlowController faqFlowController;
    public View selectQuestionView;
    public View verticalDivider;

    public static FaqFlowFragment newInstance(Bundle bundle, List<Flow> list) {
        FaqFlowFragment faqFlowFragment = new FaqFlowFragment();
        faqFlowFragment.setArguments(bundle);
        faqFlowFragment.customContactUsFlows = list;
        return faqFlowFragment;
    }

    public List<Flow> getCustomContactUsFlows() {
        return this.customContactUsFlows;
    }

    public FaqFlowController getFaqFlowController() {
        return this.faqFlowController;
    }

    public FaqFragmentListener getFaqFlowListener() {
        return getFaqFlowController();
    }

    public SupportFragment getSupportFragment() {
        return (SupportFragment) getParentFragment();
    }

    public void onAttach(Context context) {
        try {
            super.onAttach(context);
            FaqFlowController faqFlowController2 = this.faqFlowController;
            if (faqFlowController2 == null) {
                this.faqFlowController = new FaqFlowController(this, context, getRetainedChildFragmentManager(), getArguments());
            } else {
                faqFlowController2.onFragmentManagerUpdate(getRetainedChildFragmentManager());
            }
        } catch (Exception e) {
            Log.e(FRAGMENT_TAG, "Caught exception in FaqFlowFragment.onAttach()", e);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2466R.layout.hs__faq_flow_fragment, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        this.faqFlowController = null;
        this.verticalDivider = null;
        this.selectQuestionView = null;
        getSupportFragment().unRegisterSearchListener();
    }

    public void onResume() {
        super.onResume();
        CustomContactUsFlowListHolder.setFlowList(this.customContactUsFlows);
        getSupportFragment().setSearchListeners(this.faqFlowController);
        this.faqFlowController.start();
        updateSelectQuestionUI();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        FaqFlowController faqFlowController2 = this.faqFlowController;
        if (faqFlowController2 != null) {
            faqFlowController2.onSaveInstanceState(bundle);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.verticalDivider = view.findViewById(C2466R.C2468id.vertical_divider);
        this.selectQuestionView = view.findViewById(C2466R.C2468id.select_question_view);
    }

    public void onViewStateRestored(@Nullable Bundle bundle) {
        FaqFlowController faqFlowController2;
        super.onViewStateRestored(bundle);
        if (bundle != null && (faqFlowController2 = this.faqFlowController) != null) {
            faqFlowController2.onViewStateRestored(bundle);
        }
    }

    public void retryGetSections() {
        FaqFragment faqFragment = FragmentUtil.getFaqFragment(getRetainedChildFragmentManager());
        if (faqFragment != null) {
            faqFragment.retryGetSections();
        }
    }

    public boolean shouldRefreshMenu() {
        return false;
    }

    public void showVerticalDivider(boolean z) {
        View view = this.verticalDivider;
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void updateSelectQuestionUI() {
        if (isScreenLarge() && this.selectQuestionView != null) {
            if (getRetainedChildFragmentManager().findFragmentById(C2466R.C2468id.details_fragment_container) == null) {
                updateSelectQuestionUI(true);
            } else {
                updateSelectQuestionUI(false);
            }
        }
    }

    public void updateSelectQuestionUI(boolean z) {
        View view = this.selectQuestionView;
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }
}
