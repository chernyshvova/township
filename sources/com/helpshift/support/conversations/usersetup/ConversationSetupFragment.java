package com.helpshift.support.conversations.usersetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.helpshift.C2466R;
import com.helpshift.common.domain.Domain;
import com.helpshift.conversation.activeconversation.usersetup.ConversationSetupRenderer;
import com.helpshift.conversation.viewmodel.ConversationSetupVM;
import com.helpshift.network.connectivity.HSConnectivityManager;
import com.helpshift.network.connectivity.HSNetworkConnectivityCallback;
import com.helpshift.support.controllers.SupportController;
import com.helpshift.support.fragments.MainFragment;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.util.Styles;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.widget.BaseViewState;
import com.helpshift.widget.HSObserver;

public class ConversationSetupFragment extends MainFragment implements ConversationSetupRenderer, HSNetworkConnectivityCallback {
    public static final String FRAGMENT_TAG = "Helpshift_CnvStpFrgmnt";
    public ConversationSetupVM conversationSetupVM;
    public View offlineErrorView;
    public ProgressBar progressBar;
    public View progressDescriptionView;

    private void addViewStateObservers() {
        Domain domain = HelpshiftContext.getCoreApi().getDomain();
        this.conversationSetupVM.getProgressBarViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                if (((BaseViewState) obj).isVisible()) {
                    ConversationSetupFragment.this.showProgressBar();
                } else {
                    ConversationSetupFragment.this.hideProgressBar();
                }
            }
        });
        this.conversationSetupVM.getDescriptionProgressViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                if (((BaseViewState) obj).isVisible()) {
                    ConversationSetupFragment.this.showProgressDescription();
                } else {
                    ConversationSetupFragment.this.hideProgressDescription();
                }
            }
        });
        this.conversationSetupVM.getUserOfflineErrorViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                if (((BaseViewState) obj).isVisible()) {
                    ConversationSetupFragment.this.showNoInternetView();
                } else {
                    ConversationSetupFragment.this.hideNoInternetView();
                }
            }
        });
    }

    private SupportController getSupportController() {
        return ((SupportFragment) getParentFragment()).getSupportController();
    }

    private void initialize(View view) {
        this.progressBar = (ProgressBar) view.findViewById(C2466R.C2468id.progressbar);
        Styles.setAccentColor(getContext(), this.progressBar.getIndeterminateDrawable());
        this.progressDescriptionView = view.findViewById(C2466R.C2468id.progress_description_text_view);
        this.offlineErrorView = view.findViewById(C2466R.C2468id.offline_error_view);
        com.helpshift.util.Styles.setColorFilter(getContext(), ((ImageView) view.findViewById(C2466R.C2468id.info_icon)).getDrawable(), 16842806);
        this.conversationSetupVM = HelpshiftContext.getCoreApi().getConversationSetupVM(this);
    }

    public static ConversationSetupFragment newInstance() {
        return new ConversationSetupFragment();
    }

    private void removeViewStateObservers() {
        this.conversationSetupVM.getProgressBarViewState().unsubscribe();
        this.conversationSetupVM.getDescriptionProgressViewState().unsubscribe();
        this.conversationSetupVM.getUserOfflineErrorViewState().unsubscribe();
    }

    public void hideNoInternetView() {
        this.offlineErrorView.setVisibility(8);
    }

    public void hideProgressBar() {
        this.progressBar.setVisibility(8);
    }

    public void hideProgressDescription() {
        this.progressDescriptionView.setVisibility(8);
    }

    public void onAuthenticationFailure() {
        getSupportController().onAuthenticationFailure();
    }

    public void onConversationSetupComplete() {
        getSupportController().onConversationSetupCompleted();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2466R.layout.hs__user_setup_fragment, viewGroup, false);
    }

    public void onDestroyView() {
        this.conversationSetupVM.onDestroyView();
        super.onDestroyView();
    }

    public void onNetworkAvailable() {
        this.conversationSetupVM.onNetworkAvailable();
    }

    public void onNetworkUnavailable() {
        this.conversationSetupVM.onNetworkUnavailable();
    }

    public void onPause() {
        removeViewStateObservers();
        HSConnectivityManager.getInstance(HelpshiftContext.getApplicationContext()).unregisterNetworkConnectivityListener(this);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        addViewStateObservers();
        setToolbarTitle(getString(C2466R.string.hs__conversation_header));
        HSConnectivityManager.getInstance(HelpshiftContext.getApplicationContext()).registerNetworkConnectivityListener(this);
        this.conversationSetupVM.onResume();
    }

    public void onViewCreated(View view, Bundle bundle) {
        initialize(view);
        super.onViewCreated(view, bundle);
    }

    public boolean shouldRefreshMenu() {
        return true;
    }

    public void showNoInternetView() {
        this.offlineErrorView.setVisibility(0);
    }

    public void showProgressBar() {
        this.progressBar.setVisibility(0);
    }

    public void showProgressDescription() {
        this.progressDescriptionView.setVisibility(0);
    }
}
