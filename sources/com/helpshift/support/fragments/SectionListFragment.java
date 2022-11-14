package com.helpshift.support.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.support.FaqTagFilter;
import com.helpshift.support.adapters.SectionListAdapter;
import com.helpshift.support.contracts.FaqFlowViewParent;
import com.helpshift.support.contracts.FaqFragmentListener;
import java.util.ArrayList;

public class SectionListFragment extends MainFragment {
    public static final String TAG = "Helpshift_SecLstFrag";
    public RecyclerView sectionList;

    public static SectionListFragment newInstance(@Nullable Bundle bundle) {
        SectionListFragment sectionListFragment = new SectionListFragment();
        sectionListFragment.setArguments(bundle);
        return sectionListFragment;
    }

    public FaqFragmentListener getFaqFlowListener() {
        return ((FaqFlowViewParent) getParentFragment()).getFaqFlowListener();
    }

    public void onAttach(Context context) {
        try {
            super.onAttach(context);
        } catch (Exception e) {
            Log.e(TAG, "Caught exception in SectionListFragment.onAttach()", e);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2466R.layout.hs__section_list_fragment, viewGroup, false);
    }

    public void onDestroyView() {
        this.sectionList.setAdapter((RecyclerView.Adapter) null);
        this.sectionList = null;
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        final ArrayList parcelableArrayList = getArguments().getParcelableArrayList("sections");
        final FaqTagFilter faqTagFilter = (FaqTagFilter) getArguments().getSerializable("withTagsMatching");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C2466R.C2468id.section_list);
        this.sectionList = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.sectionList.setAdapter(new SectionListAdapter(parcelableArrayList, new View.OnClickListener() {
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("sections", parcelableArrayList);
                bundle.putString("sectionPublishId", (String) view.getTag());
                bundle.putSerializable("withTagsMatching", faqTagFilter);
                SectionListFragment.this.getFaqFlowListener().onSectionSelected(bundle);
            }
        }));
    }

    public boolean shouldRefreshMenu() {
        return false;
    }
}
