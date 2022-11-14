package com.helpshift.support.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.support.Faq;
import com.helpshift.support.FaqTagFilter;
import com.helpshift.support.HSApiData;
import com.helpshift.support.HSSearch;
import com.helpshift.support.adapters.SearchListAdapter;
import com.helpshift.support.contracts.FaqFlowViewParent;
import com.helpshift.support.contracts.FaqFragmentListener;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchFragment extends MainFragment {
    public static final String KEY_SEARCH_QUERY = "key_search_query";
    public static final String TAG = "Helpshift_SearchFrag";
    public String currentQuery;
    public HSApiData data;
    public FaqTagFilter faqTagFilter;
    public View.OnClickListener onContactUsClickedListener;
    public View.OnClickListener onQuestionClickedListener;
    public RecyclerView searchList;
    public final Handler searchResultSuccessHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message != null && message.getData() != null && message.obj != null) {
                String string = message.getData().getString(SearchFragment.KEY_SEARCH_QUERY);
                String str = SearchFragment.this.currentQuery;
                if (str != null && str.equals(string)) {
                    List list = (List) message.obj;
                    if (list == null) {
                        list = new ArrayList();
                    }
                    SearchFragment.this.updateSearchResult(list);
                }
            }
        }
    };
    public String sectionId;

    public class SearchResultFetcherTask implements Runnable {
        public Handler callback;
        public String query;
        public boolean searchWithAny;
        public String sectionId;

        public SearchResultFetcherTask(String str, boolean z, String str2, Handler handler) {
            this.query = str;
            this.searchWithAny = z;
            this.sectionId = str2;
            this.callback = handler;
        }

        public void run() {
            List<Faq> list;
            if (TextUtils.isEmpty(this.query) || (this.query.length() < 3 && !this.searchWithAny)) {
                SearchFragment searchFragment = SearchFragment.this;
                list = searchFragment.data.getAllFaqs(searchFragment.faqTagFilter);
            } else {
                SearchFragment searchFragment2 = SearchFragment.this;
                list = searchFragment2.data.localFaqSearch(this.query, HSSearch.HS_SEARCH_OPTIONS.FULL_SEARCH, searchFragment2.faqTagFilter);
            }
            if (!TextUtils.isEmpty(this.sectionId)) {
                ArrayList arrayList = new ArrayList();
                for (Faq faq : list) {
                    if (faq.section_publish_id.equals(this.sectionId)) {
                        arrayList.add(faq);
                    }
                }
                list = arrayList;
            }
            Message message = new Message();
            message.obj = list;
            Bundle bundle = new Bundle();
            bundle.putString(SearchFragment.KEY_SEARCH_QUERY, this.query);
            message.setData(bundle);
            this.callback.sendMessage(message);
        }
    }

    public static SearchFragment newInstance(Bundle bundle) {
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.setArguments(bundle);
        return searchFragment;
    }

    public String getCurrentQuery() {
        return this.currentQuery;
    }

    public FaqFragmentListener getFaqFlowListener() {
        return ((FaqFlowViewParent) getParentFragment()).getFaqFlowListener();
    }

    public int getNumberOfSearchResults() {
        SearchListAdapter searchListAdapter;
        RecyclerView recyclerView = this.searchList;
        if (recyclerView == null || (searchListAdapter = (SearchListAdapter) recyclerView.getAdapter()) == null) {
            return -1;
        }
        return searchListAdapter.getItemCount() - searchListAdapter.getFooterCount();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        HSApiData hSApiData = new HSApiData(context);
        this.data = hSApiData;
        hSApiData.loadIndex();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.faqTagFilter = (FaqTagFilter) arguments.getSerializable("withTagsMatching");
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2466R.layout.hs__search_fragment, viewGroup, false);
    }

    public void onDestroyView() {
        this.searchList.setAdapter((RecyclerView.Adapter) null);
        this.searchList = null;
        super.onDestroyView();
    }

    public void onQuery(String str, String str2) {
        String str3;
        this.sectionId = str2;
        if (this.searchList != null) {
            String string = HelpshiftContext.getCoreApi().getSDKConfigurationDM().getString(SDKConfigurationDM.SDK_LANGUAGE);
            if (TextUtils.isEmpty(string)) {
                string = Locale.getDefault().getLanguage();
            }
            boolean z = string.startsWith("zh") || string.equals("ja") || string.equals("ko");
            if (str == null) {
                str3 = "";
            } else {
                str3 = str.trim();
            }
            String str4 = str3;
            this.currentQuery = str4;
            new Thread(new SearchResultFetcherTask(str4, z, str2, this.searchResultSuccessHandler), "HS-search-query").start();
            HSLogger.m3237d(TAG, "Performing search : Query : " + this.currentQuery);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C2466R.C2468id.search_list);
        this.searchList = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.onQuestionClickedListener = new View.OnClickListener() {
            public void onClick(View view) {
                String str = (String) view.getTag();
                Faq faq = ((SearchListAdapter) SearchFragment.this.searchList.getAdapter()).getFaq(str);
                SearchFragment.this.getFaqFlowListener().onQuestionSelected(str, faq != null ? faq.searchTerms : null);
            }
        };
        this.onContactUsClickedListener = new View.OnClickListener() {
            public void onClick(View view) {
                SearchFragment.this.getFaqFlowListener().onContactUsClicked(SearchFragment.this.currentQuery);
            }
        };
        if (getArguments() != null) {
            this.sectionId = getArguments().getString("sectionPublishId");
        }
        onQuery(this.currentQuery, this.sectionId);
    }

    public boolean shouldRefreshMenu() {
        return true;
    }

    public void updateSearchResult(@NonNull List<Faq> list) {
        if (this.searchList != null) {
            SearchListAdapter searchListAdapter = new SearchListAdapter(this.currentQuery, list, this.onQuestionClickedListener, this.onContactUsClickedListener);
            searchListAdapter.setHasStableIds(true);
            if (this.searchList.getAdapter() == null) {
                this.searchList.setAdapter(searchListAdapter);
            } else {
                this.searchList.swapAdapter(new SearchListAdapter(this.currentQuery, list, this.onQuestionClickedListener, this.onContactUsClickedListener), true);
            }
        }
    }
}
