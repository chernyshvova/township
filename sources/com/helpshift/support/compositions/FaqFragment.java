package com.helpshift.support.compositions;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.C2466R;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.support.Faq;
import com.helpshift.support.FaqTagFilter;
import com.helpshift.support.HSApiData;
import com.helpshift.support.Section;
import com.helpshift.support.constants.GetSectionsCallBackStatus;
import com.helpshift.support.contracts.FaqFlowViewParent;
import com.helpshift.support.contracts.FaqFragmentListener;
import com.helpshift.support.fragments.FaqFlowFragment;
import com.helpshift.support.fragments.MainFragment;
import com.helpshift.support.fragments.QuestionListFragment;
import com.helpshift.support.fragments.SectionListFragment;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.util.FragmentUtil;
import com.helpshift.support.util.SnackbarUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class FaqFragment extends MainFragment implements FaqFlowViewParent {
    public static final String TAG = "Helpshift_FaqFragment";
    public HSApiData data;
    public FaqTagFilter faqTagFilter;
    public boolean isDataUpdatePending;
    public int sectionsSize = 0;

    public static class Failure extends Handler {
        public final WeakReference<FaqFragment> faqFragmentWeakReference;

        public Failure(FaqFragment faqFragment) {
            this.faqFragmentWeakReference = new WeakReference<>(faqFragment);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.helpshift.common.exception.ExceptionType} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r5) {
            /*
                r4 = this;
                java.lang.ref.WeakReference<com.helpshift.support.compositions.FaqFragment> r0 = r4.faqFragmentWeakReference
                java.lang.Object r0 = r0.get()
                com.helpshift.support.compositions.FaqFragment r0 = (com.helpshift.support.compositions.FaqFragment) r0
                if (r0 == 0) goto L_0x0040
                java.lang.Object r1 = r0.getHost()
                if (r1 == 0) goto L_0x0040
                boolean r1 = r0.isDetached()
                if (r1 == 0) goto L_0x0017
                goto L_0x0040
            L_0x0017:
                r1 = 0
                int r2 = r5.what
                java.lang.Object r5 = r5.obj
                boolean r3 = r5 instanceof com.helpshift.common.exception.ExceptionType
                if (r3 == 0) goto L_0x0023
                r1 = r5
                com.helpshift.common.exception.ExceptionType r1 = (com.helpshift.common.exception.ExceptionType) r1
            L_0x0023:
                int r5 = r0.sectionsSize
                if (r5 != 0) goto L_0x003c
                int r5 = com.helpshift.support.constants.GetSectionsCallBackStatus.API_FAILURE_CONTENT_UNCHANGED
                if (r2 != r5) goto L_0x0030
                r5 = 2
                r0.updateFaqLoadingUI(r5)
                goto L_0x0040
            L_0x0030:
                r5 = 3
                r0.updateFaqLoadingUI(r5)
                android.view.View r5 = r0.getView()
                com.helpshift.support.util.SnackbarUtil.showSnackbar(r1, r5)
                goto L_0x0040
            L_0x003c:
                r5 = 1
                r0.updateFaqLoadingUI(r5)
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.compositions.FaqFragment.Failure.handleMessage(android.os.Message):void");
        }
    }

    public static class FaqLoadingStatus {
        public static final int ERROR = 3;
        public static final int HIDE = 1;
        public static final int IN_PROGRESS = 0;
        public static final int NO_FAQS = 2;
    }

    public static class Success extends Handler {
        public final WeakReference<FaqFragment> faqFragmentWeakReference;

        public Success(FaqFragment faqFragment) {
            this.faqFragmentWeakReference = new WeakReference<>(faqFragment);
        }

        public void handleMessage(Message message) {
            FaqFragment faqFragment = (FaqFragment) this.faqFragmentWeakReference.get();
            if (faqFragment != null && faqFragment.getHost() != null && !faqFragment.isDetached()) {
                ArrayList<Section> arrayList = (ArrayList) message.obj;
                int i = message.what;
                if (arrayList != null) {
                    arrayList = faqFragment.removeEmptySections(arrayList);
                    faqFragment.sectionsSize = arrayList.size();
                }
                if (i == GetSectionsCallBackStatus.DATABASE_SUCCESS) {
                    if (faqFragment.sectionsSize != 0) {
                        faqFragment.updateFaqLoadingUI(1);
                        faqFragment.updateFragment(faqFragment, arrayList);
                    }
                } else if (i == GetSectionsCallBackStatus.API_SUCCESS_NEW_DATA) {
                    if (faqFragment.sectionsSize == 0) {
                        faqFragment.updateFaqLoadingUI(2);
                    } else {
                        faqFragment.isDataUpdatePending = true;
                        faqFragment.updateFaqLoadingUI(1);
                        faqFragment.updateFragment(faqFragment, arrayList);
                    }
                } else if (i == GetSectionsCallBackStatus.API_SUCCESS_NO_NEW_DATA && faqFragment.sectionsSize == 0) {
                    faqFragment.updateFaqLoadingUI(2);
                }
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Faq loaded with ");
                outline24.append(faqFragment.sectionsSize);
                outline24.append(" sections");
                HSLogger.m3237d(FaqFragment.TAG, outline24.toString());
            }
        }
    }

    public static FaqFragment newInstance(Bundle bundle) {
        FaqFragment faqFragment = new FaqFragment();
        faqFragment.setArguments(bundle);
        return faqFragment;
    }

    private void sendFaqLoadedEvent() {
        SupportFragment supportFragment = FragmentUtil.getSupportFragment(this);
        if (supportFragment != null) {
            supportFragment.onFaqsLoaded();
        }
    }

    public FaqFragmentListener getFaqFlowListener() {
        return ((FaqFlowViewParent) getParentFragment()).getFaqFlowListener();
    }

    public void onAttach(Context context) {
        try {
            super.onAttach(context);
            this.data = new HSApiData(context);
        } catch (Exception e) {
            Log.e(TAG, "Caught exception in FaqFragment.onAttach()", e);
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
        return layoutInflater.inflate(C2466R.layout.hs__faq_fragment, viewGroup, false);
    }

    public void onDestroyView() {
        SnackbarUtil.hideSnackbar(getView());
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
        setToolbarTitle(getString(C2466R.string.hs__help_header));
        if (this.sectionsSize == 0) {
            updateFaqLoadingUI(0);
        }
        this.data.getSections(new Success(this), new Failure(this), this.faqTagFilter);
        if (!isChangingConfigurations()) {
            HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.SUPPORT_LAUNCH);
        }
    }

    public void onStop() {
        super.onStop();
        updateFaqLoadingUI(1);
    }

    public ArrayList<Section> removeEmptySections(ArrayList<Section> arrayList) {
        ArrayList<Section> arrayList2 = new ArrayList<>();
        Iterator<Section> it = arrayList.iterator();
        while (it.hasNext()) {
            Section next = it.next();
            ArrayList<Faq> faqsForSection = this.data.getFaqsForSection(next.getPublishId(), this.faqTagFilter);
            if (faqsForSection != null && !faqsForSection.isEmpty()) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public void retryGetSections() {
        if (this.sectionsSize == 0) {
            updateFaqLoadingUI(0);
        }
        this.data.getSections(new Success(this), new Failure(this), this.faqTagFilter);
    }

    public boolean shouldRefreshMenu() {
        return true;
    }

    public void updateFaqLoadingUI(int i) {
        FaqFlowFragment faqFlowFragment = (FaqFlowFragment) getParentFragment();
        SupportFragment supportFragment = faqFlowFragment != null ? (SupportFragment) faqFlowFragment.getParentFragment() : null;
        if (supportFragment != null) {
            if (i == 1) {
                faqFlowFragment.showVerticalDivider(true);
                faqFlowFragment.updateSelectQuestionUI();
            } else {
                faqFlowFragment.showVerticalDivider(false);
                faqFlowFragment.updateSelectQuestionUI(false);
            }
            supportFragment.updateFaqLoadingUI(i);
        }
    }

    public void updateFragment(FaqFragment faqFragment, ArrayList<Section> arrayList) {
        sendFaqLoadedEvent();
        if (faqFragment.getRetainedChildFragmentManager().findFragmentById(C2466R.C2468id.faq_fragment_container) == null || this.isDataUpdatePending) {
            ArrayList<Section> populatedSections = faqFragment.data.getPopulatedSections(arrayList, faqFragment.faqTagFilter);
            if (populatedSections.size() == 1) {
                Bundle bundle = new Bundle();
                bundle.putString("sectionPublishId", populatedSections.get(0).getPublishId());
                bundle.putSerializable("withTagsMatching", getArguments().getSerializable("withTagsMatching"));
                try {
                    FragmentUtil.startFragment(faqFragment.getRetainedChildFragmentManager(), C2466R.C2468id.faq_fragment_container, QuestionListFragment.newInstance(bundle), (String) null, (String) null, false, this.isDataUpdatePending);
                    this.isDataUpdatePending = false;
                } catch (IllegalStateException unused) {
                }
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelableArrayList("sections", populatedSections);
                bundle2.putSerializable("withTagsMatching", getArguments().getSerializable("withTagsMatching"));
                FragmentUtil.startFragment(faqFragment.getRetainedChildFragmentManager(), C2466R.C2468id.faq_fragment_container, SectionListFragment.newInstance(bundle2), (String) null, (String) null, false, this.isDataUpdatePending);
                this.isDataUpdatePending = false;
            }
        }
    }
}
