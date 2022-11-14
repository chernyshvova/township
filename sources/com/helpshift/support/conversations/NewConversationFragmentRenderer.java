package com.helpshift.support.conversations;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.helpshift.C2466R;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.viewmodel.NewConversationRenderer;
import com.helpshift.support.fragments.HSMenuItemType;
import com.helpshift.support.fragments.IToolbarMenuItemRenderer;
import com.helpshift.support.imageloader.ImageLoader;
import com.helpshift.support.imageloader.ImageLoaderCallback;
import com.helpshift.support.util.SnackbarUtil;
import com.helpshift.util.AttachmentFileSize;
import com.helpshift.util.StringUtils;
import com.helpshift.views.HSToast;
import com.helpshift.widget.TextViewState;
import java.util.ArrayList;

public class NewConversationFragmentRenderer implements NewConversationRenderer {
    public final ImageButton attachmentClearButton;
    public final CardView attachmentContainer;
    public final TextView attachmentFileName;
    public final TextView attachmentFileSize;
    public final ImageView attachmentImage;
    public final Context context;
    public final TextInputEditText descriptionField;
    public final TextInputLayout descriptionFieldWrapper;
    public final TextInputEditText emailField;
    public final TextInputLayout emailFieldWrapper;
    public final IToolbarMenuItemRenderer menuItemRenderer;
    public final TextInputEditText nameField;
    public final TextInputLayout nameFieldWrapper;
    public final NewConversationRouter newConversationRouter;
    public final View parentView;
    public final ProgressBar progressBar;

    public NewConversationFragmentRenderer(Context context2, TextInputLayout textInputLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout2, TextInputEditText textInputEditText2, TextInputLayout textInputLayout3, TextInputEditText textInputEditText3, ProgressBar progressBar2, ImageView imageView, TextView textView, TextView textView2, CardView cardView, ImageButton imageButton, View view, NewConversationRouter newConversationRouter2, IToolbarMenuItemRenderer iToolbarMenuItemRenderer) {
        this.context = context2;
        this.descriptionFieldWrapper = textInputLayout;
        this.descriptionField = textInputEditText;
        this.nameFieldWrapper = textInputLayout2;
        this.nameField = textInputEditText2;
        this.emailFieldWrapper = textInputLayout3;
        this.emailField = textInputEditText3;
        this.progressBar = progressBar2;
        this.attachmentImage = imageView;
        this.attachmentFileName = textView;
        this.attachmentFileSize = textView2;
        this.attachmentContainer = cardView;
        this.attachmentClearButton = imageButton;
        this.parentView = view;
        this.newConversationRouter = newConversationRouter2;
        this.menuItemRenderer = iToolbarMenuItemRenderer;
    }

    private void changeMenuItemVisibility(HSMenuItemType hSMenuItemType, boolean z) {
        IToolbarMenuItemRenderer iToolbarMenuItemRenderer = this.menuItemRenderer;
        if (iToolbarMenuItemRenderer != null) {
            iToolbarMenuItemRenderer.updateMenuItemVisibility(hSMenuItemType, z);
        }
    }

    private String getText(int i) {
        return this.context.getText(i).toString();
    }

    private void setError(TextInputLayout textInputLayout, CharSequence charSequence) {
        textInputLayout.setErrorEnabled(!TextUtils.isEmpty(charSequence));
        textInputLayout.setError(charSequence);
    }

    public void clearDescriptionError() {
        setError(this.descriptionFieldWrapper, (CharSequence) null);
    }

    public void clearEmailError() {
        setError(this.emailFieldWrapper, (CharSequence) null);
    }

    public void clearNameError() {
        setError(this.nameFieldWrapper, (CharSequence) null);
    }

    public void disableImageAttachmentClickable() {
    }

    public void enableImageAttachmentClickable() {
    }

    public void exit() {
        this.newConversationRouter.exitNewConversationView();
    }

    public void gotoConversation(long j) {
        this.newConversationRouter.showConversationScreen();
    }

    public void hideImageAttachmentButton() {
        changeMenuItemVisibility(HSMenuItemType.SCREENSHOT_ATTACHMENT, false);
    }

    public void hideImageAttachmentContainer() {
        this.attachmentContainer.setVisibility(8);
        this.attachmentImage.setVisibility(8);
        this.attachmentClearButton.setVisibility(8);
    }

    public void hideProfileForm() {
        this.nameField.setVisibility(8);
        this.emailField.setVisibility(8);
    }

    public void hideProgressBar() {
        this.progressBar.setVisibility(8);
    }

    public void hideStartConversationButton() {
        changeMenuItemVisibility(HSMenuItemType.START_NEW_CONVERSATION, false);
    }

    public void onAuthenticationFailure() {
        this.newConversationRouter.onAuthenticationFailure();
    }

    public void setDescription(String str) {
        this.descriptionField.setText(str);
        TextInputEditText textInputEditText = this.descriptionField;
        textInputEditText.setSelection(textInputEditText.getText().length());
    }

    public void setEmail(String str) {
        this.emailField.setText(str);
        TextInputEditText textInputEditText = this.emailField;
        textInputEditText.setSelection(textInputEditText.getText().length());
    }

    public void setEmailRequired() {
        this.emailField.setHint(getText(C2466R.string.hs__email_required_hint));
    }

    public void setName(String str) {
        this.nameField.setText(str);
        TextInputEditText textInputEditText = this.nameField;
        textInputEditText.setSelection(textInputEditText.getText().length());
    }

    public void showAttachmentPreviewScreenFromDraft(AttachmentPickerFile attachmentPickerFile) {
        this.newConversationRouter.showAttachmentPreviewScreenFromDraft(attachmentPickerFile);
    }

    public void showConversationStartedMessage() {
        HSToast.makeText(this.context, C2466R.string.hs__conversation_started_message, 0).show();
    }

    public void showDescriptionEmptyError() {
        setError(this.descriptionFieldWrapper, getText(C2466R.string.hs__conversation_detail_error));
    }

    public void showDescriptionLessThanMinimumError() {
        setError(this.descriptionFieldWrapper, getText(C2466R.string.hs__description_invalid_length_error));
    }

    public void showDescriptionOnlySpecialCharactersError() {
        setError(this.descriptionFieldWrapper, getText(C2466R.string.hs__invalid_description_error));
    }

    public void showEmailEmptyError() {
        setError(this.emailFieldWrapper, getText(C2466R.string.hs__invalid_email_error));
    }

    public void showEmailInvalidError() {
        setError(this.emailFieldWrapper, getText(C2466R.string.hs__invalid_email_error));
    }

    public void showErrorView(ExceptionType exceptionType) {
        SnackbarUtil.showSnackbar(exceptionType, this.parentView);
    }

    public void showImageAttachmentButton() {
        changeMenuItemVisibility(HSMenuItemType.SCREENSHOT_ATTACHMENT, true);
    }

    public void showImageAttachmentContainer(@NonNull String str, final String str2, final Long l) {
        ImageLoader.getInstance().load(str, this.attachmentImage, this.context.getResources().getDrawable(C2466R.C2467drawable.hs__placeholder_image), new ImageLoaderCallback() {
            public void onSuccess() {
                TextView access$000 = NewConversationFragmentRenderer.this.attachmentFileName;
                String str = str2;
                String str2 = "";
                if (str == null) {
                    str = str2;
                }
                access$000.setText(str);
                Long l = l;
                if (l != null) {
                    str2 = AttachmentFileSize.getFormattedFileSize((double) l.longValue());
                }
                NewConversationFragmentRenderer.this.attachmentFileSize.setText(str2);
                NewConversationFragmentRenderer.this.attachmentImage.setVisibility(0);
                NewConversationFragmentRenderer.this.attachmentClearButton.setVisibility(0);
                NewConversationFragmentRenderer.this.attachmentContainer.setVisibility(0);
            }
        });
    }

    public void showNameEmptyError() {
        setError(this.nameFieldWrapper, getText(C2466R.string.hs__username_blank_error));
    }

    public void showNameOnlySpecialCharactersError() {
        setError(this.nameFieldWrapper, getText(C2466R.string.hs__username_blank_error));
    }

    public void showProfileForm() {
        this.nameField.setVisibility(0);
        this.emailField.setVisibility(0);
    }

    public void showProgressBar() {
        this.progressBar.setVisibility(0);
    }

    public void showSearchResultFragment(ArrayList arrayList) {
        this.newConversationRouter.showSearchResultFragment(arrayList);
    }

    public void showStartConversationButton() {
        changeMenuItemVisibility(HSMenuItemType.START_NEW_CONVERSATION, true);
    }

    public void updateDescriptionErrorState(TextViewState.TextViewStatesError textViewStatesError) {
        if (TextViewState.TextViewStatesError.EMPTY.equals(textViewStatesError)) {
            showDescriptionEmptyError();
        } else if (TextViewState.TextViewStatesError.ONLY_SPECIAL_CHARACTERS.equals(textViewStatesError)) {
            showDescriptionOnlySpecialCharactersError();
        } else if (TextViewState.TextViewStatesError.LESS_THAN_MINIMUM_LENGTH.equals(textViewStatesError)) {
            showDescriptionLessThanMinimumError();
        } else {
            clearDescriptionError();
        }
    }

    public void updateEmailErrorState(TextViewState.TextViewStatesError textViewStatesError, boolean z) {
        if (TextViewState.TextViewStatesError.INVALID_EMAIL.equals(textViewStatesError)) {
            showEmailInvalidError();
        } else if (TextViewState.TextViewStatesError.EMPTY.equals(textViewStatesError)) {
            showEmailEmptyError();
        } else {
            clearEmailError();
        }
        if (z) {
            setEmailRequired();
        }
    }

    public void updateImageAttachmentButton(boolean z) {
        changeMenuItemVisibility(HSMenuItemType.SCREENSHOT_ATTACHMENT, z);
    }

    public void updateImageAttachmentClick(boolean z) {
        if (z) {
            enableImageAttachmentClickable();
        } else {
            disableImageAttachmentClickable();
        }
    }

    public void updateImageAttachmentPickerFile(AttachmentPickerFile attachmentPickerFile) {
        if (attachmentPickerFile == null || StringUtils.isEmpty(attachmentPickerFile.filePath)) {
            hideImageAttachmentContainer();
        } else {
            showImageAttachmentContainer(attachmentPickerFile.filePath, attachmentPickerFile.originalFileName, attachmentPickerFile.originalFileSize);
        }
    }

    public void updateNameErrorState(TextViewState.TextViewStatesError textViewStatesError) {
        if (TextViewState.TextViewStatesError.EMPTY.equals(textViewStatesError)) {
            showNameEmptyError();
        } else if (TextViewState.TextViewStatesError.ONLY_SPECIAL_CHARACTERS.equals(textViewStatesError)) {
            showNameOnlySpecialCharactersError();
        } else {
            clearNameError();
        }
    }

    public void updateProfileForm(boolean z) {
        if (z) {
            showProfileForm();
        } else {
            hideProfileForm();
        }
    }

    public void updateProgressBarVisibility(boolean z) {
        if (z) {
            showProgressBar();
        } else {
            hideProgressBar();
        }
    }

    public void updateStartConversationButton(boolean z) {
        changeMenuItemVisibility(HSMenuItemType.START_NEW_CONVERSATION, z);
    }
}
