package com.helpshift.support.conversations;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.helpshift.C2466R;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.common.domain.Domain;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.viewmodel.NewConversationVM;
import com.helpshift.support.Faq;
import com.helpshift.support.fragments.AttachmentPreviewFragment;
import com.helpshift.support.fragments.HSMenuItemType;
import com.helpshift.support.fragments.IMenuItemEventListener;
import com.helpshift.support.fragments.SearchResultFragment;
import com.helpshift.support.util.AppSessionConstants;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.KeyboardUtil;
import com.helpshift.widget.BaseViewState;
import com.helpshift.widget.HSObserver;
import com.helpshift.widget.ImageAttachmentViewState;
import com.helpshift.widget.TextViewState;
import java.util.ArrayList;

public class NewConversationFragment extends BaseConversationFragment implements NewConversationRouter, MenuItem.OnMenuItemClickListener, IMenuItemEventListener {
    public static final String FRAGMENT_TAG = "HSNewConversationFragment";
    public static final String SEARCH_PERFORMED = "search_performed";
    public static final String SHOULD_DROP_META = "dropMeta";
    public static final String SOURCE_SEARCH_QUERY = "source_search_query";
    public TextInputEditText descriptionField;
    public NewConversationVM newConversationVM;
    public NewConversationFragmentRenderer renderer;
    public AttachmentPickerFile selectedImageFile;
    public boolean shouldUpdateAttachment;

    /* renamed from: com.helpshift.support.conversations.NewConversationFragment$15 */
    public static /* synthetic */ class C274215 {

        /* renamed from: $SwitchMap$com$helpshift$support$fragments$AttachmentPreviewFragment$AttachmentAction */
        public static final /* synthetic */ int[] f3352x74ff8fc4;
        public static final /* synthetic */ int[] $SwitchMap$com$helpshift$support$fragments$HSMenuItemType;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0023 */
        static {
            /*
                com.helpshift.support.fragments.HSMenuItemType[] r0 = com.helpshift.support.fragments.HSMenuItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$helpshift$support$fragments$HSMenuItemType = r0
                r1 = 0
                r2 = 1
                com.helpshift.support.fragments.HSMenuItemType r3 = com.helpshift.support.fragments.HSMenuItemType.START_NEW_CONVERSATION     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r3 = $SwitchMap$com$helpshift$support$fragments$HSMenuItemType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.support.fragments.HSMenuItemType r4 = com.helpshift.support.fragments.HSMenuItemType.SCREENSHOT_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                com.helpshift.support.fragments.AttachmentPreviewFragment$AttachmentAction[] r3 = com.helpshift.support.fragments.AttachmentPreviewFragment.AttachmentAction.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f3352x74ff8fc4 = r3
                com.helpshift.support.fragments.AttachmentPreviewFragment$AttachmentAction r4 = com.helpshift.support.fragments.AttachmentPreviewFragment.AttachmentAction.ADD     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r1 = f3352x74ff8fc4     // Catch:{ NoSuchFieldError -> 0x0029 }
                com.helpshift.support.fragments.AttachmentPreviewFragment$AttachmentAction r2 = com.helpshift.support.fragments.AttachmentPreviewFragment.AttachmentAction.REMOVE     // Catch:{ NoSuchFieldError -> 0x0029 }
                r1[r0] = r0     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.conversations.NewConversationFragment.C274215.<clinit>():void");
        }
    }

    private void addTopMarginToView(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (int) getResources().getDimension(C2466R.dimen.hs__formBasedFieldsMarginTop), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    private void addViewStateObservers() {
        Domain domain = HelpshiftContext.getCoreApi().getDomain();
        this.newConversationVM.getDescriptionViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                TextViewState textViewState = (TextViewState) obj;
                NewConversationFragment.this.renderer.setDescription(textViewState.getText());
                NewConversationFragment.this.renderer.updateDescriptionErrorState(textViewState.getError());
            }
        });
        this.newConversationVM.getProgressBarViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                NewConversationFragment.this.renderer.updateProgressBarVisibility(((BaseViewState) obj).isVisible());
            }
        });
        this.newConversationVM.getStartConversationButtonState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                NewConversationFragment.this.renderer.updateStartConversationButton(((BaseViewState) obj).isVisible());
            }
        });
        this.newConversationVM.getAttachImageButtonViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                NewConversationFragment.this.renderer.updateImageAttachmentButton(((BaseViewState) obj).isVisible());
            }
        });
        this.newConversationVM.getImageAttachmentViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                ImageAttachmentViewState imageAttachmentViewState = (ImageAttachmentViewState) obj;
                NewConversationFragment.this.renderer.updateImageAttachmentPickerFile(imageAttachmentViewState.getAttachmentPickerFile());
                NewConversationFragment.this.renderer.updateImageAttachmentClick(imageAttachmentViewState.isClickable());
            }
        });
        this.newConversationVM.getNameViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                TextViewState textViewState = (TextViewState) obj;
                NewConversationFragment.this.renderer.setName(textViewState.getText());
                NewConversationFragment.this.renderer.updateNameErrorState(textViewState.getError());
            }
        });
        this.newConversationVM.getEmailViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                TextViewState textViewState = (TextViewState) obj;
                NewConversationFragment.this.renderer.setEmail(textViewState.getText());
                NewConversationFragment.this.renderer.updateEmailErrorState(textViewState.getError(), textViewState.isRequired());
            }
        });
        this.newConversationVM.getProfileFormViewState().subscribe(domain, new HSObserver() {
            public void onChanged(Object obj) {
                NewConversationFragment.this.renderer.updateProfileForm(((BaseViewState) obj).isVisible());
            }
        });
    }

    private void initialize(View view) {
        boolean z;
        View view2 = view;
        TextInputLayout textInputLayout = (TextInputLayout) view2.findViewById(C2466R.C2468id.hs__conversationDetailWrapper);
        TextInputLayout textInputLayout2 = textInputLayout;
        textInputLayout.setHintEnabled(false);
        textInputLayout.setHintAnimationEnabled(false);
        this.descriptionField = (TextInputEditText) view2.findViewById(C2466R.C2468id.hs__conversationDetail);
        TextInputLayout textInputLayout3 = (TextInputLayout) view2.findViewById(C2466R.C2468id.hs__usernameWrapper);
        TextInputLayout textInputLayout4 = textInputLayout3;
        textInputLayout3.setHintEnabled(false);
        textInputLayout3.setHintAnimationEnabled(false);
        TextInputEditText textInputEditText = (TextInputEditText) view2.findViewById(C2466R.C2468id.hs__username);
        TextInputEditText textInputEditText2 = textInputEditText;
        TextInputLayout textInputLayout5 = (TextInputLayout) view2.findViewById(C2466R.C2468id.hs__emailWrapper);
        TextInputLayout textInputLayout6 = textInputLayout5;
        textInputLayout5.setHintEnabled(false);
        textInputLayout5.setHintAnimationEnabled(false);
        TextInputEditText textInputEditText3 = (TextInputEditText) view2.findViewById(C2466R.C2468id.hs__email);
        TextInputEditText textInputEditText4 = textInputEditText3;
        addTopMarginToView(textInputEditText);
        addTopMarginToView(textInputEditText3);
        ProgressBar progressBar = (ProgressBar) view2.findViewById(C2466R.C2468id.progress_bar);
        ImageView imageView = (ImageView) view2.findViewById(C2466R.C2468id.hs__screenshot);
        TextView textView = (TextView) view2.findViewById(C2466R.C2468id.attachment_file_name);
        TextView textView2 = (TextView) view2.findViewById(C2466R.C2468id.attachment_file_size);
        CardView cardView = (CardView) view2.findViewById(C2466R.C2468id.screenshot_view_container);
        TextInputEditText textInputEditText5 = textInputEditText3;
        ImageButton imageButton = (ImageButton) view2.findViewById(16908314);
        NewConversationFragmentRenderer newConversationFragmentRenderer = r0;
        TextInputEditText textInputEditText6 = textInputEditText;
        TextInputEditText textInputEditText7 = textInputEditText5;
        TextInputEditText textInputEditText8 = textInputEditText7;
        NewConversationFragmentRenderer newConversationFragmentRenderer2 = new NewConversationFragmentRenderer(getContext(), textInputLayout2, this.descriptionField, textInputLayout4, textInputEditText2, textInputLayout6, textInputEditText4, progressBar, imageView, textView, textView2, cardView, imageButton, getView(), this, getSupportFragment());
        this.renderer = newConversationFragmentRenderer;
        NewConversationVM newConversationViewModel = HelpshiftContext.getCoreApi().getNewConversationViewModel(this.renderer);
        this.newConversationVM = newConversationViewModel;
        if (this.shouldUpdateAttachment) {
            newConversationViewModel.setImageAttachment(this.selectedImageFile);
            z = false;
            this.shouldUpdateAttachment = false;
        } else {
            z = false;
        }
        this.descriptionField.addTextChangedListener(new TextWatcherAdapter() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                NewConversationFragment.this.newConversationVM.setDescription(charSequence.toString());
            }
        });
        textInputEditText6.addTextChangedListener(new TextWatcherAdapter() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                NewConversationFragment.this.newConversationVM.setName(charSequence.toString());
            }
        });
        textInputEditText8.addTextChangedListener(new TextWatcherAdapter() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                NewConversationFragment.this.newConversationVM.setEmail(charSequence.toString());
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.newConversationVM.setSearchQuery(arguments.getString(SOURCE_SEARCH_QUERY));
            this.newConversationVM.setShouldDropCustomMetadata(arguments.getBoolean(SHOULD_DROP_META));
            this.newConversationVM.setWasSearchPerformed(getArguments().getBoolean(SEARCH_PERFORMED, z));
        }
    }

    public static NewConversationFragment newInstance(Bundle bundle) {
        NewConversationFragment newConversationFragment = new NewConversationFragment();
        newConversationFragment.setArguments(bundle);
        return newConversationFragment;
    }

    private void removeViewStateObservers() {
        this.newConversationVM.getDescriptionViewState().unsubscribe();
        this.newConversationVM.getProgressBarViewState().unsubscribe();
        this.newConversationVM.getStartConversationButtonState().unsubscribe();
        this.newConversationVM.getAttachImageButtonViewState().unsubscribe();
        this.newConversationVM.getImageAttachmentViewState().unsubscribe();
        this.newConversationVM.getNameViewState().unsubscribe();
        this.newConversationVM.getEmailViewState().unsubscribe();
        this.newConversationVM.getProfileFormViewState().unsubscribe();
    }

    private void setViewListeners(View view) {
        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C2466R.C2468id.hs__conversationDetail);
        this.descriptionField = textInputEditText;
        textInputEditText.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == C2466R.C2468id.hs__conversationDetail) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if ((motionEvent.getAction() & 255) == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        ImageButton imageButton = (ImageButton) view.findViewById(16908314);
        imageButton.setVisibility(8);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NewConversationFragment.this.newConversationVM.handleImageAttachmentClearButtonClick();
            }
        });
        ((ImageView) view.findViewById(C2466R.C2468id.hs__screenshot)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NewConversationFragment.this.newConversationVM.handleImageAttachmentClick();
            }
        });
    }

    public void exitNewConversationView() {
        getSupportFragment().exitSdkSession();
    }

    public int getAttachmentMode() {
        return 1;
    }

    public String getToolbarTitle() {
        return getString(C2466R.string.hs__new_conversation_header);
    }

    public AppSessionConstants.Screen getViewName() {
        return AppSessionConstants.Screen.NEW_CONVERSATION;
    }

    public boolean handleScreenshotAction(AttachmentPreviewFragment.AttachmentAction attachmentAction, AttachmentPickerFile attachmentPickerFile) {
        int ordinal = attachmentAction.ordinal();
        if (ordinal == 0) {
            NewConversationVM newConversationVM2 = this.newConversationVM;
            if (newConversationVM2 == null) {
                this.selectedImageFile = attachmentPickerFile;
                this.shouldUpdateAttachment = true;
            } else {
                newConversationVM2.setImageAttachment(attachmentPickerFile);
            }
            return true;
        } else if (ordinal != 2) {
            return false;
        } else {
            NewConversationVM newConversationVM3 = this.newConversationVM;
            if (newConversationVM3 == null) {
                this.selectedImageFile = null;
                this.shouldUpdateAttachment = true;
            } else {
                newConversationVM3.setImageAttachment((AttachmentPickerFile) null);
            }
            return true;
        }
    }

    public void onAuthenticationFailure() {
        getSupportController().onAuthenticationFailure();
    }

    public void onCreateOptionMenuCalled() {
        this.renderer.updateStartConversationButton(this.newConversationVM.getStartConversationButtonState().isVisible());
        this.renderer.updateImageAttachmentButton(this.newConversationVM.getAttachImageButtonViewState().isVisible());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2466R.layout.hs__new_conversation_fragment, viewGroup, false);
    }

    public void onDestroyView() {
        getSupportFragment().unRegisterToolbarMenuEventsListener(this);
        this.newConversationVM.unregisterRenderer(this.renderer);
        this.newConversationVM.setConversationViewState(-1);
        super.onDestroyView();
    }

    public void onMenuItemClicked(HSMenuItemType hSMenuItemType) {
        int ordinal = hSMenuItemType.ordinal();
        if (ordinal == 0) {
            this.newConversationVM.showSearchOrStartNewConversation();
        } else if (ordinal == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt(AttachmentPreviewFragment.KEY_ATTACHMENT_MODE, getAttachmentMode());
            bundle.putString(AttachmentPreviewFragment.KEY_MESSAGE_REFERS_ID, (String) null);
            bundle.putInt(AttachmentPreviewFragment.KEY_ATTACHMENT_TYPE, 1);
            getSupportFragment().launchAttachmentPicker(bundle);
        }
    }

    public void onPause() {
        removeViewStateObservers();
        super.onPause();
        KeyboardUtil.hideKeyboard(getContext(), this.descriptionField);
    }

    public void onPermissionGranted(int i) {
        if (i == 2) {
            Bundle bundle = new Bundle();
            bundle.putInt(AttachmentPreviewFragment.KEY_ATTACHMENT_MODE, getAttachmentMode());
            bundle.putInt(AttachmentPreviewFragment.KEY_ATTACHMENT_TYPE, 1);
            getSupportFragment().launchAttachmentPicker(bundle);
        }
    }

    public void onResume() {
        super.onResume();
        addViewStateObservers();
        if (!isChangingConfigurations()) {
            HelpshiftContext.getCoreApi().getAnalyticsEventDM().pushEvent(AnalyticsEventType.REPORTED_ISSUE);
        }
        this.descriptionField.requestFocus();
        KeyboardUtil.showKeyboard(getContext(), this.descriptionField);
        this.newConversationVM.setConversationViewState(1);
    }

    public void onStart() {
        super.onStart();
        if (!isChangingConfigurations()) {
            HelpshiftContext.getCoreApi().getConversationController().deleteCachedFilesForResolvedConversations();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        initialize(view);
        super.onViewCreated(view, bundle);
        getSupportFragment().registerToolbarMenuEventsListener(this);
        setViewListeners(view);
    }

    public void showAttachmentPreviewScreenFromDraft(AttachmentPickerFile attachmentPickerFile) {
        Bundle bundle = new Bundle();
        bundle.putInt(AttachmentPreviewFragment.KEY_ATTACHMENT_MODE, 2);
        bundle.putString(AttachmentPreviewFragment.KEY_MESSAGE_REFERS_ID, (String) null);
        bundle.putInt(AttachmentPreviewFragment.KEY_ATTACHMENT_TYPE, 1);
        attachmentPickerFile.attachmentType = 1;
        getSupportController().startScreenshotPreviewFragment(attachmentPickerFile, bundle, AttachmentPreviewFragment.LaunchSource.ATTACHMENT_DRAFT);
    }

    public void showConversationScreen() {
        if (isResumed()) {
            getSupportController().startConversationFlow();
        }
    }

    public void showSearchResultFragment(ArrayList<Faq> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(SearchResultFragment.BUNDLE_ARG_SEARCH_RESULTS, arrayList);
        getSupportController().showConversationSearchResultFragment(bundle);
    }

    public void startNewConversation() {
        this.newConversationVM.startNewConversation();
    }
}
