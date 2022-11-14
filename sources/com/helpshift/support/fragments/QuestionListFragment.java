package com.helpshift.support.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.C2466R;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.support.Faq;
import com.helpshift.support.FaqTagFilter;
import com.helpshift.support.HSApiData;
import com.helpshift.support.Section;
import com.helpshift.support.adapters.QuestionListAdapter;
import com.helpshift.support.contracts.FaqFlowViewParent;
import com.helpshift.support.contracts.FaqFragmentListener;
import com.helpshift.support.util.FragmentUtil;
import com.helpshift.support.util.SnackbarUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class QuestionListFragment extends MainFragment {
    public static final String TAG = "Helpshift_QstnListFrag";
    public HSApiData data;
    public boolean eventSent = false;
    public FaqTagFilter faqTagFilter;
    public boolean isConfigurationChanged = false;
    public View.OnClickListener onQuestionClickedListener;
    public RecyclerView questionList;
    public String sectionId;
    public String sectionTitle;

    public static class SectionFailureHandler extends Handler {
        public final WeakReference<QuestionListFragment> questionListFragmentWeakReference;

        public SectionFailureHandler(QuestionListFragment questionListFragment) {
            this.questionListFragmentWeakReference = new WeakReference<>(questionListFragment);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.helpshift.common.exception.ExceptionType} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r5) {
            /*
                r4 = this;
                java.lang.ref.WeakReference<com.helpshift.support.fragments.QuestionListFragment> r0 = r4.questionListFragmentWeakReference
                java.lang.Object r0 = r0.get()
                com.helpshift.support.fragments.QuestionListFragment r0 = (com.helpshift.support.fragments.QuestionListFragment) r0
                if (r0 == 0) goto L_0x004b
                boolean r1 = r0.isDetached()
                if (r1 == 0) goto L_0x0011
                goto L_0x004b
            L_0x0011:
                androidx.recyclerview.widget.RecyclerView r1 = r0.questionList
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$Adapter r2 = r1.getAdapter()
                if (r2 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
                int r1 = r1.getItemCount()
                if (r1 != 0) goto L_0x004b
            L_0x0027:
                r1 = 0
                java.lang.Object r2 = r5.obj
                boolean r3 = r2 instanceof com.helpshift.common.exception.ExceptionType
                if (r3 == 0) goto L_0x0031
                r1 = r2
                com.helpshift.common.exception.ExceptionType r1 = (com.helpshift.common.exception.ExceptionType) r1
            L_0x0031:
                if (r1 == 0) goto L_0x0042
                int r5 = r5.what
                int r2 = com.helpshift.support.constants.GetSectionsCallBackStatus.API_FAILURE_CONTENT_UNCHANGED
                if (r5 != r2) goto L_0x003a
                goto L_0x0042
            L_0x003a:
                android.view.View r5 = r0.getView()
                com.helpshift.support.util.SnackbarUtil.showSnackbar(r1, r5)
                goto L_0x004b
            L_0x0042:
                r5 = 103(0x67, float:1.44E-43)
                android.view.View r0 = r0.getView()
                com.helpshift.support.util.SnackbarUtil.showErrorSnackbar(r5, r0)
            L_0x004b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.fragments.QuestionListFragment.SectionFailureHandler.handleMessage(android.os.Message):void");
        }
    }

    public static class SectionSuccessHandler extends Handler {
        public final WeakReference<QuestionListFragment> questionListFragmentWeakReference;

        public SectionSuccessHandler(QuestionListFragment questionListFragment) {
            this.questionListFragmentWeakReference = new WeakReference<>(questionListFragment);
        }

        public void handleMessage(Message message) {
            QuestionListFragment questionListFragment = (QuestionListFragment) this.questionListFragmentWeakReference.get();
            if (questionListFragment != null && !questionListFragment.isDetached()) {
                Object obj = message.obj;
                if (obj != null) {
                    Section section = (Section) obj;
                    questionListFragment.updateSectionData(section);
                    HSLogger.m3237d(QuestionListFragment.TAG, "FAQ section loaded : SectionSuccessHandler : " + section.getTitle());
                    return;
                }
                RecyclerView access$000 = questionListFragment.questionList;
                if (access$000 == null || access$000.getAdapter() == null || access$000.getAdapter().getItemCount() == 0) {
                    SnackbarUtil.showErrorSnackbar(103, questionListFragment.getView());
                }
            }
        }
    }

    private void getSectionId(String str) {
        Section section = this.data.getSection(str);
        if (section != null) {
            this.sectionId = section.getSectionId();
        }
    }

    private String getSectionTitle(String str) {
        Section section = this.data.getSection(str);
        if (section != null) {
            return section.getTitle();
        }
        return null;
    }

    public static QuestionListFragment newInstance(Bundle bundle) {
        QuestionListFragment questionListFragment = new QuestionListFragment();
        questionListFragment.setArguments(bundle);
        return questionListFragment;
    }

    private void pushAnalyticEvent() {
        if (getUserVisibleHint() && !this.eventSent && !this.isConfigurationChanged && !TextUtils.isEmpty(this.sectionId)) {
            HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.BROWSED_FAQ_LIST, this.sectionId);
            this.eventSent = true;
        }
    }

    public FaqFragmentListener getFaqFlowListener() {
        return ((FaqFlowViewParent) getParentFragment()).getFaqFlowListener();
    }

    public void onAttach(Context context) {
        try {
            super.onAttach(context);
            this.data = new HSApiData(context);
            this.sectionTitle = getString(C2466R.string.hs__help_header);
        } catch (Exception e) {
            Log.e(TAG, "Caught exception in QuestionListFragment.onAttach()", e);
        }
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
        return layoutInflater.inflate(C2466R.layout.hs__question_list_fragment, viewGroup, false);
    }

    public void onDestroyView() {
        SnackbarUtil.hideSnackbar(getView());
        this.questionList.setAdapter((RecyclerView.Adapter) null);
        this.questionList = null;
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
        setToolbarTitle(getString(C2466R.string.hs__help_header));
        if (isScreenLarge()) {
            setToolbarTitle(this.sectionTitle);
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof FaqFlowFragment) {
                ((FaqFlowFragment) parentFragment).showVerticalDivider(true);
            }
        }
        pushAnalyticEvent();
    }

    public void onStart() {
        super.onStart();
        this.isConfigurationChanged = isChangingConfigurations();
        this.eventSent = false;
    }

    public void onStop() {
        if (isScreenLarge()) {
            setToolbarTitle(getString(C2466R.string.hs__help_header));
        }
        super.onStop();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C2466R.C2468id.question_list);
        this.questionList = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.onQuestionClickedListener = new View.OnClickListener() {
            public void onClick(View view) {
                QuestionListFragment.this.getFaqFlowListener().onQuestionSelected((String) view.getTag(), (ArrayList<String>) null);
            }
        };
        String string = getArguments().getString("sectionPublishId");
        if (isScreenLarge()) {
            String sectionTitle2 = getSectionTitle(string);
            if (!TextUtils.isEmpty(sectionTitle2)) {
                this.sectionTitle = sectionTitle2;
            }
        }
        SectionSuccessHandler sectionSuccessHandler = new SectionSuccessHandler(this);
        SectionFailureHandler sectionFailureHandler = new SectionFailureHandler(this);
        if (getArguments().getInt(SupportFragment.SUPPORT_MODE, 0) != 2) {
            this.data.getSectionSync(string, sectionSuccessHandler, sectionFailureHandler);
        } else {
            this.data.getSection(string, sectionSuccessHandler, sectionFailureHandler, this.faqTagFilter);
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("FAQ section loaded : Name : ");
        outline24.append(this.sectionTitle);
        HSLogger.m3237d(TAG, outline24.toString());
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        pushAnalyticEvent();
    }

    public boolean shouldRefreshMenu() {
        return getParentFragment() instanceof FaqFlowFragment;
    }

    public void updateSectionData(Section section) {
        if (this.questionList != null) {
            ArrayList<Faq> faqsForSection = this.data.getFaqsForSection(section.getPublishId(), this.faqTagFilter);
            if (faqsForSection != null && !faqsForSection.isEmpty()) {
                this.questionList.setAdapter(new QuestionListAdapter(faqsForSection, this.onQuestionClickedListener));
                SupportFragment supportFragment = FragmentUtil.getSupportFragment(this);
                if (supportFragment != null) {
                    supportFragment.onFaqsLoaded();
                }
                if (TextUtils.isEmpty(this.sectionId)) {
                    getSectionId(getArguments().getString("sectionPublishId"));
                }
                pushAnalyticEvent();
            } else if (!isDetached()) {
                SnackbarUtil.showErrorSnackbar(103, getView());
            }
        }
    }
}
