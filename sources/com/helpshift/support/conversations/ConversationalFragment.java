package com.helpshift.support.conversations;

import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.util.AttachmentNetworkUtil;
import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.AuthDataProvider;
import com.helpshift.common.platform.Device;
import com.helpshift.common.platform.network.Method;
import com.helpshift.conversation.activeconversation.SmartIntentRenderer;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminCSATMessageWithOptions;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.OptionInputMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.smartintent.LeafIntentUIModel;
import com.helpshift.conversation.smartintent.RootIntentUIModel;
import com.helpshift.conversation.smartintent.SearchIntentUIModel;
import com.helpshift.conversation.smartintent.SmartIntentSavedState;
import com.helpshift.conversation.viewmodel.ConversationalVM;
import com.helpshift.conversation.viewmodel.OptionUIModel;
import com.helpshift.network.connectivity.HSConnectivityManager;
import com.helpshift.network.connectivity.HSNetworkConnectivityCallback;
import com.helpshift.support.conversations.HSRecyclerViewScrollListener;
import com.helpshift.support.conversations.messages.MessagesAdapterClickListener;
import com.helpshift.support.conversations.smartintent.SmartIntentRendererImpl;
import com.helpshift.support.conversations.smartintent.SmartIntentRouter;
import com.helpshift.support.fragments.AttachmentPreviewFragment;
import com.helpshift.support.fragments.SingleQuestionFragment;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.imageloader.ImageLoader;
import com.helpshift.support.util.AppSessionConstants;
import com.helpshift.support.util.SnackbarUtil;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.StringUtils;
import com.helpshift.util.Styles;
import com.helpshift.widget.BaseViewState;
import com.helpshift.widget.ConversationFooterViewState;
import com.helpshift.widget.HSObserver;
import com.helpshift.widget.HistoryLoadingViewState;
import com.helpshift.widget.ReplyBoxViewState;
import com.helpshift.widget.ReplyFieldViewState;
import com.helpshift.widget.ScrollJumperViewState;
import com.vungle.warren.p037ui.JavascriptBridge;
import java.security.GeneralSecurityException;
import java.util.Map;

public class ConversationalFragment extends BaseConversationFragment implements MessagesAdapterClickListener, ConversationalFragmentRouter, HSRecyclerViewScrollListener.RecyclerViewScrollCallback, HSNetworkConnectivityCallback, SmartIntentRouter {
    public static final String BUNDLE_ARG_CONVERSATION_LOCAL_ID = "issueId";
    public static final String BUNDLE_ARG_SHOW_CONVERSATION_HISTORY = "show_conv_history";
    public static final String FRAGMENT_TAG = "HSConversationFragment";
    public static final String TAG = "Helpshift_ConvalFrag";
    public final String SHOULD_SHOW_UNREAD_MESSAGE_INDICATOR = "should_show_unread_message_indicator";
    public final String SMART_INTENT_INSTANCE_SAVED_STATE = "si_instance_saved_state";
    public int attachmentPickerType;
    public Long conversationId;
    public ConversationalVM conversationalVM;
    public HSRecyclerViewScrollListener hsRecyclerViewScrollListener;
    public String imageRefersId;
    public boolean inNoOpMode;
    public boolean isConversationVMInitialized = false;
    public int lastSoftInputMode;
    public int lastWindowFlags;
    public RecyclerView messagesRecyclerView;
    public AttachmentMessageDM readableAttachmentMessage;
    public ConversationalFragmentRenderer renderer;
    public boolean retainMessageBoxOnUI;
    public AttachmentPickerFile selectedAttachmentFile;
    public String selectedImageRefersId;
    public boolean shouldShowConversationHistory;
    public boolean shouldUpdateAttachment;

    /* renamed from: com.helpshift.support.conversations.ConversationalFragment$18 */
    public static /* synthetic */ class C270418 {
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$common$platform$Device$PermissionState;

        /* renamed from: $SwitchMap$com$helpshift$support$fragments$AttachmentPreviewFragment$AttachmentAction */
        public static final /* synthetic */ int[] f3351x74ff8fc4;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|(2:1|2)|3|5|6|7|8|9|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.helpshift.common.platform.Device$PermissionState[] r0 = com.helpshift.common.platform.Device.PermissionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$common$platform$Device$PermissionState = r0
                r1 = 1
                com.helpshift.common.platform.Device$PermissionState r2 = com.helpshift.common.platform.Device.PermissionState.AVAILABLE     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$helpshift$common$platform$Device$PermissionState     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.common.platform.Device$PermissionState r3 = com.helpshift.common.platform.Device.PermissionState.UNAVAILABLE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r2 = $SwitchMap$com$helpshift$common$platform$Device$PermissionState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.common.platform.Device$PermissionState r3 = com.helpshift.common.platform.Device.PermissionState.REQUESTABLE     // Catch:{ NoSuchFieldError -> 0x001d }
                r3 = 3
                r2[r0] = r3     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.helpshift.support.fragments.AttachmentPreviewFragment$AttachmentAction[] r0 = com.helpshift.support.fragments.AttachmentPreviewFragment.AttachmentAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3351x74ff8fc4 = r0
                com.helpshift.support.fragments.AttachmentPreviewFragment$AttachmentAction r2 = com.helpshift.support.fragments.AttachmentPreviewFragment.AttachmentAction.SEND     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.ConversationalFragment.C270418.<clinit>():void");
        }
    }

    private void addViewStateObservers() {
        Domain domain = HelpshiftContext.getCoreApi().getDomain();
        this.conversationalVM.getReplyFieldViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                ConversationalFragment.this.renderer.setReply(((ReplyFieldViewState) obj).getReplyText());
            }
        });
        this.conversationalVM.getHistoryLoadingViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                ConversationalFragment.this.renderer.updateHistoryLoadingState(((HistoryLoadingViewState) obj).getState());
            }
        });
        this.conversationalVM.getScrollJumperViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                ScrollJumperViewState scrollJumperViewState = (ScrollJumperViewState) obj;
                ConversationalFragment.this.renderer.updateScrollJumperView(scrollJumperViewState.isVisible(), scrollJumperViewState.shouldShowUnreadMessagesIndicator());
            }
        });
        this.conversationalVM.getConversationFooterViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                ConversationalFragment.this.renderer.updateConversationFooterState(((ConversationFooterViewState) obj).getState());
            }
        });
        this.conversationalVM.getReplyBoxViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                ReplyBoxViewState replyBoxViewState = (ReplyBoxViewState) obj;
                ConversationalFragment.this.renderer.updateSendReplyUI(replyBoxViewState.isVisible(), replyBoxViewState.getInput());
            }
        });
        this.conversationalVM.getReplyButtonViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                ConversationalFragment.this.renderer.updateSendReplyButton(((BaseViewState) obj).isEnabled());
            }
        });
        this.conversationalVM.getAttachImageButtonViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                ConversationalFragment.this.renderer.updateImageAttachmentButtonView(((BaseViewState) obj).isVisible());
            }
        });
        this.conversationalVM.getConfirmationBoxViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                ConversationalFragment.this.renderer.updateConversationResolutionQuestionUI(((BaseViewState) obj).isVisible());
            }
        });
        this.conversationalVM.getSmartIntentReplyButtonViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                BaseViewState baseViewState = (BaseViewState) obj;
                ConversationalFragment.this.renderer.updateSmartIntentReplyButton(baseViewState.isVisible(), baseViewState.isEnabled());
            }
        });
        this.conversationalVM.getSmartIntentClearSearchButtonViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                ConversationalFragment.this.renderer.updateSmartIntentClearSearchButton(((BaseViewState) obj).isVisible());
            }
        });
        this.conversationalVM.getSmartIntentReplyFieldViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                ConversationalFragment.this.renderer.setSmartIntentReply(((ReplyFieldViewState) obj).getReplyText());
            }
        });
    }

    private SmartIntentRenderer buildSmartIntentRenderer() {
        return new SmartIntentRendererImpl(getContext(), this, getSupportFragment().isParentViewBottomSheetDialogFragment());
    }

    private void checkWriteStoragePermissionAndDelegateToVM(boolean z, AttachmentMessageDM attachmentMessageDM) {
        this.readableAttachmentMessage = null;
        if (z) {
            int ordinal = HelpshiftContext.getPlatform().getDevice().checkPermission(Device.PermissionType.WRITE_STORAGE).ordinal();
            if (ordinal == 0) {
                this.conversationalVM.handleAdminAttachmentMessageClick(attachmentMessageDM);
            } else if (ordinal == 1) {
                startDownloadWithSystemService(attachmentMessageDM.attachmentUrl, attachmentMessageDM.contentType, attachmentMessageDM.isSecureAttachment);
            } else if (ordinal == 2) {
                this.readableAttachmentMessage = attachmentMessageDM;
                requestWriteExternalStoragePermission(true);
            }
        } else {
            this.conversationalVM.handleAdminAttachmentMessageClick(attachmentMessageDM);
        }
    }

    private String generateSecureUrl(String str) {
        try {
            final AuthDataProvider authDataProvider = new AuthDataProvider(HelpshiftContext.getCoreApi().getDomain(), HelpshiftContext.getPlatform(), str);
            return AttachmentNetworkUtil.buildSecureURL(str, new NetworkAuthDataFetcher() {
                public Map<String, String> getAuthData(Map<String, String> map) throws GeneralSecurityException {
                    return authDataProvider.getAuthData(Method.GET, map);
                }
            }).toString();
        } catch (Exception unused) {
            HSLogger.m3241e(TAG, "Error while creating secure url: " + str);
            return str;
        }
    }

    private Window getParentWindow() {
        Dialog dialog;
        Fragment parentFragment = getParentFragment();
        int i = 5;
        while (true) {
            int i2 = i - 1;
            if (i > 0 && parentFragment != null) {
                if ((parentFragment instanceof DialogFragment) && (dialog = ((DialogFragment) parentFragment).getDialog()) != null) {
                    return dialog.getWindow();
                }
                parentFragment = parentFragment.getParentFragment();
                i = i2;
            }
        }
        return getActivity().getWindow();
    }

    public static ConversationalFragment newInstance(Bundle bundle) {
        ConversationalFragment conversationalFragment = new ConversationalFragment();
        conversationalFragment.setArguments(bundle);
        return conversationalFragment;
    }

    private void removeViewStateObservers() {
        this.conversationalVM.getReplyFieldViewState().unsubscribe();
        this.conversationalVM.getHistoryLoadingViewState().unsubscribe();
        this.conversationalVM.getScrollJumperViewState().unsubscribe();
        this.conversationalVM.getConversationFooterViewState().unsubscribe();
        this.conversationalVM.getAttachImageButtonViewState().unsubscribe();
        this.conversationalVM.getReplyBoxViewState().unsubscribe();
        this.conversationalVM.getReplyButtonViewState().unsubscribe();
        this.conversationalVM.getConfirmationBoxViewState().unsubscribe();
        this.conversationalVM.getSmartIntentReplyButtonViewState().unsubscribe();
        this.conversationalVM.getSmartIntentClearSearchButtonViewState().unsubscribe();
    }

    private void startDownloadWithSystemService(String str, String str2, boolean z) {
        DownloadManager downloadManager = (DownloadManager) getContext().getSystemService(JavascriptBridge.MraidHandler.DOWNLOAD_ACTION);
        if (downloadManager != null) {
            if (z) {
                str = generateSecureUrl(str);
            }
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setMimeType(str2);
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
            if (!isDetached()) {
                SnackbarUtil.showSnackbar(getView(), C2466R.string.hs__starting_download, -1);
            }
        }
    }

    public void downloadAvatarImage(MessageDM messageDM) {
        this.conversationalVM.downloadAvatarImage(messageDM);
    }

    public int getAttachmentMode() {
        return 3;
    }

    public String getToolbarTitle() {
        return getString(C2466R.string.hs__conversation_header);
    }

    public AppSessionConstants.Screen getViewName() {
        return AppSessionConstants.Screen.CONVERSATION;
    }

    public void handleAdminImageAttachmentMessageClick(AdminImageAttachmentMessageDM adminImageAttachmentMessageDM) {
        checkWriteStoragePermissionAndDelegateToVM(true, adminImageAttachmentMessageDM);
    }

    public boolean handleAttachmentAction(AttachmentPreviewFragment.AttachmentAction attachmentAction, AttachmentPickerFile attachmentPickerFile, @Nullable String str) {
        ConversationalVM conversationalVM2;
        if (attachmentAction.ordinal() != 1) {
            return false;
        }
        if (!this.isConversationVMInitialized || (conversationalVM2 = this.conversationalVM) == null) {
            this.selectedAttachmentFile = attachmentPickerFile;
            this.selectedImageRefersId = str;
            this.shouldUpdateAttachment = true;
        } else {
            conversationalVM2.sendAttachment(attachmentPickerFile, str);
        }
        return true;
    }

    public void handleGenericAttachmentMessageClick(AdminAttachmentMessageDM adminAttachmentMessageDM) {
        checkWriteStoragePermissionAndDelegateToVM(adminAttachmentMessageDM.isWriteStoragePermissionRequired(), adminAttachmentMessageDM);
    }

    public void handleOptionSelected(OptionInputMessageDM optionInputMessageDM, OptionInput.Option option, boolean z) {
        this.conversationalVM.handleOptionSelected(optionInputMessageDM, option, z);
    }

    public void handleOptionSelectedForPicker(OptionUIModel optionUIModel, boolean z) {
        this.conversationalVM.handleOptionSelectedForPicker(optionUIModel, z);
    }

    public void handleReplyReviewButtonClick(RequestAppReviewMessageDM requestAppReviewMessageDM) {
        this.conversationalVM.handleAppReviewRequestClick(requestAppReviewMessageDM);
    }

    public void initConversationVM() {
        this.conversationalVM = HelpshiftContext.getCoreApi().getConversationalViewModel(this.shouldShowConversationHistory, this.conversationId, this.renderer, this.retainMessageBoxOnUI);
    }

    public void initRenderer(RecyclerView recyclerView, View view, View view2, View view3) {
        this.renderer = new ConversationalFragmentRenderer(getContext(), getParentWindow(), recyclerView, getView(), view, HelpshiftContext.getCoreApi().getSDKConfigurationDM().isHelpshiftBrandingDisabled(), HelpshiftContext.getCoreApi().getSDKConfigurationDM().isAvatarEnabledInChatFeed(), view2, view3, getSupportFragment(), buildSmartIntentRenderer(), this);
    }

    public void initialize(View view) {
        this.messagesRecyclerView = (RecyclerView) view.findViewById(C2466R.C2468id.hs__messagesList);
        View findViewById = view.findViewById(C2466R.C2468id.hs__confirmation);
        View findViewById2 = view.findViewById(C2466R.C2468id.scroll_indicator);
        View findViewById3 = view.findViewById(C2466R.C2468id.unread_indicator_red_dot);
        View findViewById4 = view.findViewById(C2466R.C2468id.unread_indicator_red_dot_image_view);
        if (Build.VERSION.SDK_INT < 21) {
            Drawable drawable = ContextCompat.getDrawable(getContext(), C2466R.C2467drawable.hs__ring);
            findViewById2.setBackgroundDrawable(drawable);
            findViewById3.setBackgroundDrawable(drawable);
        }
        Styles.setDrawable(getContext(), findViewById4, C2466R.C2467drawable.hs__circle, C2466R.attr.colorAccent);
        initRenderer(this.messagesRecyclerView, findViewById, findViewById2, findViewById3);
        initConversationVM();
        this.renderer.setReplyboxListeners();
        this.retainMessageBoxOnUI = false;
        this.conversationalVM.startLiveUpdates();
        this.isConversationVMInitialized = true;
        if (this.shouldUpdateAttachment) {
            this.conversationalVM.sendAttachment(this.selectedAttachmentFile, this.selectedImageRefersId);
            this.shouldUpdateAttachment = false;
        }
        view.findViewById(C2466R.C2468id.resolution_accepted_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationalFragment.this.conversationalVM.markConversationResolutionStatus(true);
            }
        });
        view.findViewById(C2466R.C2468id.resolution_rejected_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationalFragment.this.renderer.requestReplyFieldFocus();
                ConversationalFragment.this.renderer.showKeyboard();
                ConversationalFragment.this.conversationalVM.markConversationResolutionStatus(false);
            }
        });
        ImageButton imageButton = (ImageButton) view.findViewById(C2466R.C2468id.scroll_jump_button);
        Styles.setDrawable(getContext(), imageButton, C2466R.C2467drawable.hs__circle_shape_scroll_jump, C2466R.attr.hs__composeBackgroundColor);
        Styles.setColorFilter(getContext(), imageButton.getDrawable(), C2466R.attr.hs__selectableOptionColor);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationalFragment.this.conversationalVM.onScrollJumperViewClicked();
            }
        });
        HSRecyclerViewScrollListener hSRecyclerViewScrollListener = new HSRecyclerViewScrollListener(new Handler(), this);
        this.hsRecyclerViewScrollListener = hSRecyclerViewScrollListener;
        this.messagesRecyclerView.addOnScrollListener(hSRecyclerViewScrollListener);
    }

    public void launchAttachmentPicker(int i) {
        this.attachmentPickerType = i;
        Bundle bundle = new Bundle();
        bundle.putInt(AttachmentPreviewFragment.KEY_ATTACHMENT_MODE, getAttachmentMode());
        bundle.putString(AttachmentPreviewFragment.KEY_MESSAGE_REFERS_ID, this.imageRefersId);
        bundle.putInt(AttachmentPreviewFragment.KEY_ATTACHMENT_TYPE, i);
        getSupportFragment().launchAttachmentPicker(bundle);
    }

    public void launchImagePicker(RequestScreenshotMessageDM requestScreenshotMessageDM) {
        this.imageRefersId = requestScreenshotMessageDM.serverId;
        this.attachmentPickerType = 1;
        this.conversationalVM.onAttachmentButtonClick();
        Bundle bundle = new Bundle();
        bundle.putInt(AttachmentPreviewFragment.KEY_ATTACHMENT_MODE, getAttachmentMode());
        bundle.putString(AttachmentPreviewFragment.KEY_MESSAGE_REFERS_ID, this.imageRefersId);
        bundle.putInt(AttachmentPreviewFragment.KEY_ATTACHMENT_TYPE, this.attachmentPickerType);
        getSupportFragment().launchAttachmentPicker(bundle);
    }

    public void onActionCardClicked(AdminActionCardMessageDM adminActionCardMessageDM) {
        this.conversationalVM.onActionCardMessageClicked(adminActionCardMessageDM);
    }

    public void onAddAttachmentButtonClick() {
        this.imageRefersId = null;
        this.conversationalVM.onAttachmentButtonClick();
        this.renderer.showAttachmentPicker(this.conversationalVM.getWhiteListedAttachmentTypes());
    }

    public void onAdminMessageLinkClickFailed() {
        this.conversationalVM.onAdminMessageLinkClickFailed();
    }

    public void onAdminMessageLinkClicked(String str, MessageDM messageDM) {
        this.conversationalVM.onAdminMessageLinkClicked(str, messageDM);
    }

    public void onAdminSuggestedQuestionSelected(final FAQListMessageDM fAQListMessageDM, final String str, String str2) {
        getSupportController().onAdminSuggestedQuestionSelected(str, str2, fAQListMessageDM.source, new SingleQuestionFragment.QuestionReadListener() {
            public void onQuestionRead(String str) {
                ConversationalFragment.this.conversationalVM.handleAdminSuggestedQuestionRead(fAQListMessageDM, str, str);
            }
        });
    }

    public void onAttach(Context context) {
        ConversationalFragmentRenderer conversationalFragmentRenderer;
        try {
            super.onAttach(context);
            if (isChangingConfigurations() && (conversationalFragmentRenderer = this.renderer) != null) {
                this.retainMessageBoxOnUI = conversationalFragmentRenderer.isReplyBoxVisible();
            }
        } catch (Exception e) {
            Log.e(TAG, "Caught exception in ConversationalFragment.onAttach()", e);
            this.inNoOpMode = true;
        }
    }

    public void onAuthenticationFailure() {
        getSupportController().onAuthenticationFailure();
    }

    public boolean onBackPressed() {
        if (!this.renderer.handleBackPressedForListPicker() && !this.conversationalVM.handleBackPressedForSmartIntent()) {
            return false;
        }
        return true;
    }

    public void onCSATSurveyCancelled() {
        this.conversationalVM.onCSATSurveyCancelled();
    }

    public void onCSATSurveyRequestedFromBot(String str) {
        this.conversationalVM.onCSATSurveyRequestedFromBot(str);
    }

    public void onCSATSurveyStarted() {
        this.conversationalVM.onCSATSurveyStarted();
    }

    public void onCSATSurveyStartedFromBot(String str) {
        this.conversationalVM.onCSATSurveyStartedFromBot(str);
    }

    public void onCSATSurveySubmitted(int i, String str) {
        this.conversationalVM.onCSATSurveySubmitted(i, str);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, final String str) {
        if (!StringUtils.isEmpty(str)) {
            contextMenu.add(0, 0, 0, C2466R.string.hs__copy).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem menuItem) {
                    ConversationalFragment.this.copyToClipboard(str);
                    return true;
                }
            });
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lastWindowFlags = getActivity().getWindow().getAttributes().flags;
        getActivity().getWindow().addFlags(2048);
        getActivity().getWindow().clearFlags(1024);
        return layoutInflater.inflate(C2466R.layout.hs__conversation_fragment, viewGroup, false);
    }

    public void onDestroy() {
        ConversationalVM conversationalVM2 = this.conversationalVM;
        if (conversationalVM2 != null) {
            conversationalVM2.onDestroy();
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        if (getActivity() != null) {
            getActivity().getWindow().clearFlags(2048);
            Window window = getActivity().getWindow();
            int i = this.lastWindowFlags;
            window.setFlags(i, i);
        }
        this.isConversationVMInitialized = false;
        this.conversationalVM.setConversationViewState(-1);
        this.renderer.unregisterFragmentRenderer();
        this.conversationalVM.unregisterRenderer();
        this.renderer.destroy();
        this.messagesRecyclerView.removeOnScrollListener(this.hsRecyclerViewScrollListener);
        this.messagesRecyclerView = null;
        ImageLoader.getInstance().destroy();
        super.onDestroyView();
    }

    public void onDetach() {
        if (this.inNoOpMode) {
            super.onDetach();
            return;
        }
        if (!isChangingConfigurations()) {
            HelpshiftContext.getCoreApi().getConversationInboxPoller().startAppPoller(true);
        }
        super.onDetach();
    }

    public void onFocusChanged(boolean z) {
        ConversationalFragmentRenderer conversationalFragmentRenderer = this.renderer;
        if (conversationalFragmentRenderer != null) {
            conversationalFragmentRenderer.onFocusChanged(z);
        }
    }

    public void onHistoryLoadingRetryClicked() {
        this.conversationalVM.retryHistoryLoadingMessages();
    }

    public void onLeafIntentSelected(LeafIntentUIModel leafIntentUIModel) {
        this.conversationalVM.handleLeafIntentSelected(leafIntentUIModel);
    }

    public void onListPickerSearchQueryChange(String str) {
        this.conversationalVM.onListPickerSearchQueryChange(str);
    }

    public void onNetworkAvailable() {
        this.conversationalVM.onNetworkAvailable();
    }

    public void onNetworkUnavailable() {
        this.conversationalVM.onNetworkUnAvailable();
    }

    public void onPause() {
        HSConnectivityManager.getInstance(HelpshiftContext.getApplicationContext()).unregisterNetworkConnectivityListener(this);
        getActivity().getWindow().setSoftInputMode(this.lastSoftInputMode);
        this.renderer.hideKeyboard();
        removeViewStateObservers();
        this.conversationalVM.onPause();
        super.onPause();
    }

    public void onPermissionGranted(int i) {
        AttachmentMessageDM attachmentMessageDM;
        if (i == 2) {
            Bundle bundle = new Bundle();
            bundle.putInt(AttachmentPreviewFragment.KEY_ATTACHMENT_MODE, getAttachmentMode());
            bundle.putString(AttachmentPreviewFragment.KEY_MESSAGE_REFERS_ID, this.imageRefersId);
            bundle.putInt(AttachmentPreviewFragment.KEY_ATTACHMENT_TYPE, this.attachmentPickerType);
            getSupportFragment().launchAttachmentPicker(bundle);
        } else if (i == 3 && (attachmentMessageDM = this.readableAttachmentMessage) != null) {
            this.conversationalVM.handleAdminAttachmentMessageClick(attachmentMessageDM);
            this.readableAttachmentMessage = null;
        }
    }

    public void onResume() {
        super.onResume();
        addViewStateObservers();
        if (!isChangingConfigurations()) {
            this.conversationalVM.pushChatScreenOpenAnalyticsEvent();
        }
        this.conversationalVM.onResume();
        this.lastSoftInputMode = getActivity().getWindow().getAttributes().softInputMode;
        getActivity().getWindow().setSoftInputMode(16);
        HSConnectivityManager.getInstance(HelpshiftContext.getApplicationContext()).registerNetworkConnectivityListener(this);
        HelpshiftContext.getCoreApi().getAutoRetryFailedEventDM().resetBackoff();
        HelpshiftContext.getCoreApi().getAutoRetryFailedEventDM().sendEventForcefully(AutoRetryFailedEventDM.EventType.CONVERSATION);
    }

    public void onRootIntentSelected(RootIntentUIModel rootIntentUIModel) {
        this.conversationalVM.handleRootIntentSelected(rootIntentUIModel);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("should_show_unread_message_indicator", this.conversationalVM.shouldShowUnreadMessagesIndicator());
        SmartIntentSavedState smartIntentInstanceSaveState = this.conversationalVM.getSmartIntentInstanceSaveState();
        if (smartIntentInstanceSaveState != null) {
            bundle.putSerializable("si_instance_saved_state", smartIntentInstanceSaveState);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onScreenshotMessageClicked(ScreenshotMessageDM screenshotMessageDM) {
        this.conversationalVM.handleScreenshotMessageClick(screenshotMessageDM);
    }

    public void onScrolledToBottom() {
        this.conversationalVM.onScrolledToBottom();
    }

    public void onScrolledToTop() {
        this.conversationalVM.onScrolledToTop();
    }

    public void onScrolling() {
        this.conversationalVM.onScrolling();
    }

    public void onSearchIntentSelected(SearchIntentUIModel searchIntentUIModel) {
        this.conversationalVM.handleSearchIntentSelected(searchIntentUIModel);
    }

    public void onSendButtonClick() {
        this.conversationalVM.sendTextMessage();
    }

    public void onSendFeedbackClick(int i, AdminCSATMessageWithOptions adminCSATMessageWithOptions) {
        this.conversationalVM.onSendFeedBackClick(i, adminCSATMessageWithOptions);
    }

    public void onSkipClick() {
        this.conversationalVM.onSkipClick();
    }

    public void onSmartIntentBackButtonPressed() {
        this.conversationalVM.handleBackPressedForSmartIntent();
    }

    public void onSmartIntentBottomSheetCollapsed() {
        this.conversationalVM.onSmartIntentBottomSheetCollapsed();
    }

    public void onSmartIntentBottomSheetExpanded() {
        this.conversationalVM.onSmartIntentBottomSheetExpanded();
    }

    public void onSmartIntentSendButtonClick() {
        this.conversationalVM.onSmartIntentSendButtonClick();
    }

    public void onSmartIntentTextChanged(CharSequence charSequence) {
        this.renderer.hideSmartIntentReplyValidationFailedError();
        this.conversationalVM.onSmartIntentTextChanged(charSequence);
    }

    public void onStartNewConversationButtonClick() {
        this.conversationalVM.onNewConversationButtonClicked();
    }

    public void onStartNewConversationButtonClickFromCSATBot(AdminCSATMessageWithOptions adminCSATMessageWithOptions) {
        this.conversationalVM.onStartNewConversationButtonClickFromCSATBot(adminCSATMessageWithOptions);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.renderer.hideReplyValidationFailedError();
        this.conversationalVM.toggleReplySendButton(charSequence != null && !StringUtils.isEmpty(charSequence.toString()));
    }

    public void onUserAttachmentMessageClicked(UserAttachmentMessageDM userAttachmentMessageDM) {
        this.conversationalVM.handleUserAttachmentMessageClick(userAttachmentMessageDM);
    }

    public void onViewCreated(View view, Bundle bundle) {
        boolean z;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.conversationId = Long.valueOf(arguments.getLong(BUNDLE_ARG_CONVERSATION_LOCAL_ID));
            this.shouldShowConversationHistory = arguments.getBoolean(BUNDLE_ARG_SHOW_CONVERSATION_HISTORY);
            z = arguments.getBoolean(ConversationalVM.CREATE_NEW_PRE_ISSUE);
        } else {
            z = false;
        }
        initialize(view);
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.conversationalVM.updateUnreadMessageCountIndicator(bundle.getBoolean("should_show_unread_message_indicator"));
            if (bundle.containsKey("si_instance_saved_state")) {
                this.conversationalVM.onRestoreSmartIntentInstanceState((SmartIntentSavedState) bundle.getSerializable("si_instance_saved_state"));
            }
        }
        if (z && bundle == null) {
            this.conversationalVM.forceClickOnNewConversationButton();
        }
        HSLogger.m3237d(TAG, "Now showing conversation screen");
    }

    public void openFreshConversationScreen(Map<String, Boolean> map) {
        getSupportFragment().getSupportController().startConversationFlow(map);
    }

    public void removeSmartIntentViewFromBottomSheet() {
        getSupportFragment().hideBottomSheetViewContainer();
    }

    public void resetToolbarImportanceForAccessibility() {
        SupportFragment supportFragment = getSupportFragment();
        if (supportFragment != null) {
            supportFragment.resetToolbarImportanceForAccessibility();
        }
    }

    public void retryMessage(MessageDM messageDM) {
        this.conversationalVM.retryMessage(messageDM);
    }

    public void setToolbarImportanceForAccessibility(int i) {
        SupportFragment supportFragment = getSupportFragment();
        if (supportFragment != null) {
            supportFragment.setToolbarImportanceForAccessibility(i);
        }
    }

    public void showSmartIntentViewInBottomSheet(View view, int i) {
        getSupportFragment().showBottomSheetViewContainer(view, i);
    }

    public void startLiveUpdates() {
        ConversationalVM conversationalVM2 = this.conversationalVM;
        if (conversationalVM2 != null) {
            conversationalVM2.startLiveUpdates();
        }
    }

    public void stopLiveUpdates() {
        ConversationalVM conversationalVM2 = this.conversationalVM;
        if (conversationalVM2 != null) {
            conversationalVM2.stopLiveUpdates();
        }
    }
}
