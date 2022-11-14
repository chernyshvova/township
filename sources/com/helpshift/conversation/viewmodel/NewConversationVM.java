package com.helpshift.conversation.viewmodel;

import com.helpshift.account.AuthenticationFailureDM;
import com.helpshift.common.domain.C2500F;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.domainmodel.ConversationController;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HSPattern;
import com.helpshift.util.StringUtils;
import com.helpshift.widget.BaseViewState;
import com.helpshift.widget.ImageAttachmentViewState;
import com.helpshift.widget.MutableBaseViewState;
import com.helpshift.widget.MutableImageAttachmentViewState;
import com.helpshift.widget.MutableTextViewState;
import com.helpshift.widget.TextViewState;
import com.helpshift.widget.WidgetGateway;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class NewConversationVM implements ConversationController.StartNewConversationListener, AuthenticationFailureDM.AuthenticationFailureObserver {
    public static final String TAG = "Helpshift_NewConvVM";
    public final MutableBaseViewState attachImageButtonViewState;
    public final ConversationController conversationController;
    public final MutableTextViewState descriptionViewState;
    public final Domain domain;
    public final MutableTextViewState emailViewState;
    public final MutableImageAttachmentViewState imageAttachmentViewState;
    public final MutableTextViewState nameViewState;
    public final Platform platform;
    public final MutableBaseViewState profileFormViewState;
    public final MutableBaseViewState progressBarViewState;
    public WeakReference<NewConversationRenderer> rendererWeakRef;
    public final SDKConfigurationDM sdkConfigurationDM;
    public final MutableBaseViewState startConversationButtonViewState;
    public boolean wasSearchPerformed = false;
    public final WidgetGateway widgetGateway;

    public NewConversationVM(Platform platform2, Domain domain2, ConversationController conversationController2, NewConversationRenderer newConversationRenderer) {
        this.platform = platform2;
        this.domain = domain2;
        SDKConfigurationDM sDKConfigurationDM = domain2.getSDKConfigurationDM();
        this.sdkConfigurationDM = sDKConfigurationDM;
        this.conversationController = conversationController2;
        WidgetGateway widgetGateway2 = new WidgetGateway(sDKConfigurationDM, conversationController2);
        this.widgetGateway = widgetGateway2;
        this.descriptionViewState = widgetGateway2.makeDescriptionViewState();
        this.nameViewState = this.widgetGateway.makeNameViewState();
        this.emailViewState = this.widgetGateway.makeEmailViewState();
        this.imageAttachmentViewState = this.widgetGateway.makeImageAttachmentWidget();
        this.progressBarViewState = this.widgetGateway.makeProgressBarViewState();
        this.profileFormViewState = this.widgetGateway.makeProfileFormViewState(this.nameViewState, this.emailViewState);
        this.attachImageButtonViewState = this.widgetGateway.makeNewConversationAttachImageButtonViewState(this.imageAttachmentViewState);
        this.startConversationButtonViewState = this.widgetGateway.makeStartConversationButtonViewState();
        conversationController2.registerStartNewConversationListener(this);
        domain2.getAuthenticationFailureDM().registerListener(this);
        this.rendererWeakRef = new WeakReference<>(newConversationRenderer);
    }

    private void handleException(final Exception exc) {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                Exception exc = exc;
                if (exc instanceof RootAPIException) {
                    RootAPIException rootAPIException = (RootAPIException) exc;
                    if (NewConversationVM.this.rendererWeakRef.get() != null) {
                        ((NewConversationRenderer) NewConversationVM.this.rendererWeakRef.get()).showErrorView(rootAPIException.exceptionType);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean isFormValid() {
        this.descriptionViewState.setError(validateDescription());
        this.nameViewState.setError(validateName());
        this.emailViewState.setError(validateEmail());
        return this.descriptionViewState.getError() == null && this.nameViewState.getError() == null && this.emailViewState.getError() == null;
    }

    private void showSearchOrStartNewConversationInternal(final boolean z) {
        this.domain.runSerial(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (NewConversationVM.this.isFormValid()) {
                    if (z && NewConversationVM.this.shouldShowSearchOnNewConversation()) {
                        NewConversationVM newConversationVM = NewConversationVM.this;
                        ArrayList fAQSearchResults = newConversationVM.conversationController.getFAQSearchResults(newConversationVM.descriptionViewState.getText());
                        if (fAQSearchResults.size() > 0) {
                            if (NewConversationVM.this.rendererWeakRef.get() != null) {
                                ((NewConversationRenderer) NewConversationVM.this.rendererWeakRef.get()).showSearchResultFragment(fAQSearchResults);
                                return;
                            }
                            return;
                        }
                    }
                    final Conversation activeConversationFromStorage = NewConversationVM.this.conversationController.getActiveConversationFromStorage();
                    if (activeConversationFromStorage != null) {
                        NewConversationVM.this.domain.runOnUI(new C2500F() {
                            /* renamed from: f */
                            public void mo33949f() {
                                NewConversationVM.this.progressBarViewState.setVisible(false);
                                NewConversationVM.this.startConversationButtonViewState.setVisible(true);
                                NewConversationVM.this.imageAttachmentViewState.setClickable(true);
                                NewConversationVM newConversationVM = NewConversationVM.this;
                                newConversationVM.attachImageButtonViewState.setVisible(StringUtils.isEmpty(newConversationVM.imageAttachmentViewState.getImagePath()));
                                if (NewConversationVM.this.rendererWeakRef.get() != null) {
                                    ((NewConversationRenderer) NewConversationVM.this.rendererWeakRef.get()).gotoConversation(activeConversationFromStorage.localId.longValue());
                                }
                            }
                        });
                        return;
                    }
                    HSLogger.m3237d(NewConversationVM.TAG, "Creating new conversation");
                    NewConversationVM.this.progressBarViewState.setVisible(true);
                    NewConversationVM.this.startConversationButtonViewState.setVisible(false);
                    NewConversationVM.this.attachImageButtonViewState.setVisible(false);
                    NewConversationVM.this.imageAttachmentViewState.setClickable(false);
                    NewConversationVM newConversationVM2 = NewConversationVM.this;
                    newConversationVM2.conversationController.startNewConversation(newConversationVM2.descriptionViewState.getText(), NewConversationVM.this.nameViewState.getText(), NewConversationVM.this.emailViewState.getText(), NewConversationVM.this.imageAttachmentViewState.getAttachmentPickerFile());
                }
            }
        });
    }

    public BaseViewState getAttachImageButtonViewState() {
        return this.attachImageButtonViewState;
    }

    public TextViewState getDescriptionViewState() {
        return this.descriptionViewState;
    }

    public TextViewState getEmailViewState() {
        return this.emailViewState;
    }

    public ImageAttachmentViewState getImageAttachmentViewState() {
        return this.imageAttachmentViewState;
    }

    public TextViewState getNameViewState() {
        return this.nameViewState;
    }

    public BaseViewState getProfileFormViewState() {
        return this.profileFormViewState;
    }

    public BaseViewState getProgressBarViewState() {
        return this.progressBarViewState;
    }

    public BaseViewState getStartConversationButtonState() {
        return this.startConversationButtonViewState;
    }

    public void handleImageAttachmentClearButtonClick() {
        if (!this.progressBarViewState.isVisible()) {
            this.domain.runSerial(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    AttachmentPickerFile attachmentPickerFile = NewConversationVM.this.imageAttachmentViewState.getAttachmentPickerFile();
                    if (attachmentPickerFile != null && attachmentPickerFile.filePath != null) {
                        NewConversationVM.this.domain.getAttachmentFileManagerDM().deleteAttachmentLocalCopy(attachmentPickerFile);
                    }
                }
            });
            setImageAttachment((AttachmentPickerFile) null);
        }
    }

    public void handleImageAttachmentClick() {
        if (!this.progressBarViewState.isVisible()) {
            this.domain.runSerial(new C2500F() {
                /* renamed from: f */
                public void mo33949f() {
                    final AttachmentPickerFile attachmentPickerFile = NewConversationVM.this.imageAttachmentViewState.getAttachmentPickerFile();
                    if (attachmentPickerFile != null && !StringUtils.isEmpty(attachmentPickerFile.filePath)) {
                        NewConversationVM.this.domain.runOnUI(new C2500F() {
                            /* renamed from: f */
                            public void mo33949f() {
                                if (NewConversationVM.this.rendererWeakRef.get() != null) {
                                    ((NewConversationRenderer) NewConversationVM.this.rendererWeakRef.get()).showAttachmentPreviewScreenFromDraft(attachmentPickerFile);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void onAuthenticationFailure() {
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (NewConversationVM.this.rendererWeakRef.get() != null) {
                    ((NewConversationRenderer) NewConversationVM.this.rendererWeakRef.get()).onAuthenticationFailure();
                }
            }
        });
    }

    public void onCreateConversationFailure(Exception exc) {
        this.progressBarViewState.setVisible(false);
        this.startConversationButtonViewState.setVisible(true);
        this.imageAttachmentViewState.setClickable(true);
        this.attachImageButtonViewState.setVisible(StringUtils.isEmpty(this.imageAttachmentViewState.getImagePath()));
        handleException(exc);
    }

    public void onCreateConversationSuccess(final long j) {
        this.progressBarViewState.setVisible(false);
        this.startConversationButtonViewState.setVisible(true);
        this.descriptionViewState.setText((String) null);
        this.imageAttachmentViewState.setAttachmentPickerFile((AttachmentPickerFile) null);
        this.attachImageButtonViewState.setVisible(StringUtils.isEmpty(this.imageAttachmentViewState.getImagePath()));
        this.domain.runOnUI(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (NewConversationVM.this.rendererWeakRef.get() != null) {
                    NewConversationRenderer newConversationRenderer = (NewConversationRenderer) NewConversationVM.this.rendererWeakRef.get();
                    if (!NewConversationVM.this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.GOTO_CONVERSATION_AFTER_CONTACT_US) || NewConversationVM.this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.DISABLE_IN_APP_CONVERSATION)) {
                        newConversationRenderer.showConversationStartedMessage();
                        newConversationRenderer.exit();
                        return;
                    }
                    newConversationRenderer.gotoConversation(j);
                }
            }
        });
    }

    public void setConversationViewState(final int i) {
        this.domain.runSerial(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                NewConversationVM.this.conversationController.setConversationViewState(i);
            }
        });
    }

    public void setDescription(final String str) {
        this.domain.runSerial(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (!NewConversationVM.this.descriptionViewState.getText().equals(str)) {
                    NewConversationVM.this.descriptionViewState.setText(str);
                    NewConversationVM newConversationVM = NewConversationVM.this;
                    newConversationVM.widgetGateway.save(newConversationVM.descriptionViewState);
                }
            }
        });
    }

    public void setEmail(final String str) {
        this.domain.runSerial(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (!NewConversationVM.this.emailViewState.getText().equals(str)) {
                    NewConversationVM.this.emailViewState.setText(str);
                }
            }
        });
    }

    public void setImageAttachment(final AttachmentPickerFile attachmentPickerFile) {
        this.domain.runSerial(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                NewConversationVM.this.imageAttachmentViewState.setAttachmentPickerFile(attachmentPickerFile);
                NewConversationVM newConversationVM = NewConversationVM.this;
                newConversationVM.widgetGateway.save(newConversationVM.imageAttachmentViewState);
                if (NewConversationVM.this.progressBarViewState.isVisible()) {
                    NewConversationVM.this.attachImageButtonViewState.setVisible(false);
                    return;
                }
                NewConversationVM newConversationVM2 = NewConversationVM.this;
                newConversationVM2.attachImageButtonViewState.setVisible(StringUtils.isEmpty(newConversationVM2.imageAttachmentViewState.getImagePath()));
            }
        });
    }

    public void setName(final String str) {
        this.domain.runSerial(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (!NewConversationVM.this.nameViewState.getText().equals(str)) {
                    NewConversationVM.this.nameViewState.setText(str);
                }
            }
        });
    }

    public void setSearchQuery(final String str) {
        this.domain.runSerial(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                if (StringUtils.isEmpty(NewConversationVM.this.descriptionViewState.getText()) && !StringUtils.isEmpty(str)) {
                    NewConversationVM.this.descriptionViewState.setText(str.substring(0, 1).toUpperCase() + str.substring(1));
                }
            }
        });
    }

    public void setShouldDropCustomMetadata(final boolean z) {
        this.domain.runSerial(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                NewConversationVM.this.conversationController.setShouldDropCustomMetadata(z);
            }
        });
    }

    public void setWasSearchPerformed(final boolean z) {
        this.domain.runSerial(new C2500F() {
            /* renamed from: f */
            public void mo33949f() {
                NewConversationVM newConversationVM = NewConversationVM.this;
                newConversationVM.wasSearchPerformed = z;
                if (newConversationVM.shouldShowSearchOnNewConversation()) {
                    NewConversationVM.this.conversationController.triggerFAQSearchIndexing();
                }
            }
        });
    }

    public boolean shouldShowSearchOnNewConversation() {
        return !this.wasSearchPerformed && this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.SHOW_SEARCH_ON_NEW_CONVERSATION);
    }

    public void showSearchOrStartNewConversation() {
        showSearchOrStartNewConversationInternal(true);
    }

    public void startNewConversation() {
        showSearchOrStartNewConversationInternal(false);
    }

    public void unregisterRenderer(NewConversationRenderer newConversationRenderer) {
        WeakReference<NewConversationRenderer> weakReference = this.rendererWeakRef;
        if (weakReference != null && weakReference.get() == newConversationRenderer) {
            this.rendererWeakRef = new WeakReference<>((Object) null);
        }
        this.domain.getAuthenticationFailureDM().unregisterListener(this);
        this.conversationController.unregisterStartNewConversationListener(this);
    }

    public TextViewState.TextViewStatesError validateDescription() {
        String text = this.descriptionViewState.getText();
        if (text.length() == 0) {
            return TextViewState.TextViewStatesError.EMPTY;
        }
        if (TextViewState.specialCharactersPattern.matcher(text).matches()) {
            return TextViewState.TextViewStatesError.ONLY_SPECIAL_CHARACTERS;
        }
        if (text.length() < this.sdkConfigurationDM.getMinimumConversationDescriptionLength()) {
            return TextViewState.TextViewStatesError.LESS_THAN_MINIMUM_LENGTH;
        }
        return null;
    }

    public TextViewState.TextViewStatesError validateEmail() {
        String text = this.emailViewState.getText();
        if (text.length() == 0) {
            if (this.emailViewState.isRequired()) {
                return TextViewState.TextViewStatesError.EMPTY;
            }
            return null;
        } else if (!HSPattern.isValidEmail(text)) {
            return TextViewState.TextViewStatesError.INVALID_EMAIL;
        } else {
            return null;
        }
    }

    public TextViewState.TextViewStatesError validateName() {
        String text = this.nameViewState.getText();
        if (text.length() == 0) {
            return TextViewState.TextViewStatesError.EMPTY;
        }
        if (TextViewState.specialCharactersPattern.matcher(text).matches()) {
            return TextViewState.TextViewStatesError.ONLY_SPECIAL_CHARACTERS;
        }
        return null;
    }
}
