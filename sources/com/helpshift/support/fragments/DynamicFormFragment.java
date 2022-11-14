package com.helpshift.support.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.support.adapters.FlowListAdapter;
import com.helpshift.support.controllers.SupportController;
import com.helpshift.support.flows.ConversationFlow;
import com.helpshift.support.flows.DynamicFormFlow;
import com.helpshift.support.flows.FAQSectionFlow;
import com.helpshift.support.flows.FAQsFlow;
import com.helpshift.support.flows.Flow;
import com.helpshift.support.flows.SingleFAQFlow;
import com.helpshift.util.HelpshiftContext;
import java.util.List;

public class DynamicFormFragment extends MainFragment implements View.OnClickListener {
    public static final String FRAGMENT_TAG = "HSDynamicFormFragment";
    public List<Flow> flowList;
    public RecyclerView flowListView;
    public boolean sendAnalyticsEvent = true;
    public SupportController supportController;
    public String title;

    public static DynamicFormFragment newInstance(Bundle bundle, List<Flow> list, SupportController supportController2) {
        DynamicFormFragment dynamicFormFragment = new DynamicFormFragment();
        dynamicFormFragment.setArguments(bundle);
        dynamicFormFragment.flowList = list;
        dynamicFormFragment.supportController = supportController2;
        return dynamicFormFragment;
    }

    private void performAction(Flow flow) {
        if (flow instanceof ConversationFlow) {
            ((ConversationFlow) flow).setSupportController(this.supportController);
        } else if (flow instanceof FAQSectionFlow) {
            ((FAQSectionFlow) flow).setSupportController(this.supportController);
        } else if (flow instanceof SingleFAQFlow) {
            ((SingleFAQFlow) flow).setSupportController(this.supportController);
        } else if (flow instanceof DynamicFormFlow) {
            ((DynamicFormFlow) flow).setSupportController(this.supportController);
        } else if (flow instanceof FAQsFlow) {
            ((FAQsFlow) flow).setSupportController(this.supportController);
        }
        flow.performAction();
    }

    private void showFlows() {
        List<Flow> list = this.flowList;
        if (list != null) {
            this.flowListView.setAdapter(new FlowListAdapter(list, this));
        }
    }

    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        this.sendAnalyticsEvent = false;
        performAction(this.flowList.get(intValue));
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(SupportFragmentConstants.FLOW_TITLE);
            this.title = string;
            if (TextUtils.isEmpty(string)) {
                this.title = getString(C2466R.string.hs__help_header);
            }
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2466R.layout.hs__dynamic_form_fragment, viewGroup, false);
    }

    public void onDestroyView() {
        this.flowListView = null;
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
        setToolbarTitle(this.title);
        showFlows();
    }

    public void onStart() {
        super.onStart();
        if (!isChangingConfigurations() && this.sendAnalyticsEvent) {
            HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.DYNAMIC_FORM_OPEN);
        }
        this.sendAnalyticsEvent = true;
    }

    public void onStop() {
        super.onStop();
        if (!isChangingConfigurations() && this.sendAnalyticsEvent) {
            HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.DYNAMIC_FORM_CLOSE);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C2466R.C2468id.flow_list);
        this.flowListView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    public void setSupportController(SupportController supportController2) {
        this.supportController = supportController2;
    }

    public boolean shouldRefreshMenu() {
        return true;
    }
}
