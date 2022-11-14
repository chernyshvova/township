package com.helpshift.support.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.support.Faq;
import com.helpshift.support.adapters.SearchResultAdapter;
import com.helpshift.support.contracts.SearchResultListener;
import java.util.List;

public class SearchResultFragment extends MainFragment {
    public static final String BUNDLE_ARG_SEARCH_RESULTS = "search_fragment_results";
    public static final String FRAGMENT_TAG = "HSSearchResultFragment";
    public View.OnClickListener onQuestionClickedListener;
    public RecyclerView searchResultList;
    public SearchResultListener searchResultListener;
    public View.OnClickListener sendAnywayClickedListener;

    public static SearchResultFragment newInstance(Bundle bundle, SearchResultListener searchResultListener2) {
        SearchResultFragment searchResultFragment = new SearchResultFragment();
        searchResultFragment.setArguments(bundle);
        searchResultFragment.searchResultListener = searchResultListener2;
        return searchResultFragment;
    }

    private void showResults() {
        List parcelableArrayList = getArguments().getParcelableArrayList(BUNDLE_ARG_SEARCH_RESULTS);
        if (parcelableArrayList != null && parcelableArrayList.size() > 3) {
            parcelableArrayList = parcelableArrayList.subList(0, 3);
        }
        this.searchResultList.setAdapter(new SearchResultAdapter(parcelableArrayList, this.onQuestionClickedListener, this.sendAnywayClickedListener));
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2466R.layout.hs__search_result_fragment, viewGroup, false);
    }

    public void onResume() {
        super.onResume();
        setToolbarTitle(getString(C2466R.string.hs__search_result_title));
        showResults();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C2466R.C2468id.search_result);
        this.searchResultList = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.onQuestionClickedListener = new View.OnClickListener() {
            public void onClick(View view) {
                String str = (String) view.getTag();
                Faq faq = ((SearchResultAdapter) SearchResultFragment.this.searchResultList.getAdapter()).getFaq(str);
                SearchResultFragment.this.searchResultListener.onQuestionSelected(str, faq != null ? faq.searchTerms : null);
            }
        };
        this.sendAnywayClickedListener = new View.OnClickListener() {
            public void onClick(View view) {
                SearchResultFragment.this.searchResultListener.sendAnyway();
            }
        };
    }

    public void setSearchResultListener(SearchResultListener searchResultListener2) {
        this.searchResultListener = searchResultListener2;
    }

    public boolean shouldRefreshMenu() {
        return true;
    }
}
