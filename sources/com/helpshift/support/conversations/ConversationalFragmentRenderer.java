package com.helpshift.support.conversations;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.helpshift.C2466R;
import com.helpshift.android.commons.downloader.HsUriUtils;
import com.helpshift.common.exception.ExceptionType;
import com.helpshift.common.exception.PlatformException;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.conversation.activeconversation.ConversationalRenderer;
import com.helpshift.conversation.activeconversation.SmartIntentRenderer;
import com.helpshift.conversation.activeconversation.message.ConversationFooterState;
import com.helpshift.conversation.activeconversation.message.HistoryLoadingState;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.input.Input;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.conversation.activeconversation.message.input.TextInput;
import com.helpshift.conversation.smartintent.BaseSmartIntentViewState;
import com.helpshift.conversation.smartintent.SmartIntentCollapsedRootViewState;
import com.helpshift.conversation.viewmodel.OptionUIModel;
import com.helpshift.delegate.RootDelegate;
import com.helpshift.support.Support;
import com.helpshift.support.conversations.picker.PickerAdapter;
import com.helpshift.support.fragments.HSMenuItemType;
import com.helpshift.support.fragments.IToolbarMenuItemRenderer;
import com.helpshift.support.util.SnackbarUtil;
import com.helpshift.support.util.Styles;
import com.helpshift.support.widget.AttachmentTypeOptionPicker;
import com.helpshift.util.FileUtil;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.IntentUtil;
import com.helpshift.util.KeyboardUtil;
import com.helpshift.util.StringUtils;
import com.helpshift.views.bottomsheet.HSBottomSheet;
import java.io.File;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ConversationalFragmentRenderer implements ConversationalRenderer {
    public static final int OPTIONS_PICKER_PEEK_HEIGHT = 142;
    public ImageButton addAttachmentButton;
    public AttachmentTypeOptionPicker attachmentPicker;
    public BottomSheetBehavior bottomSheetBehavior;
    public View confirmationBoxView;
    public Context context;
    public ConversationalFragmentRouter conversationalFragmentRouter;
    public boolean isAvatarEnabledInChatFeed;
    public boolean isHSBrandingDisabled;
    public RecyclerView.ItemDecoration lastMessageItemDecor;
    public Window listPickerHostWindow;
    public IToolbarMenuItemRenderer menuItemRenderer;
    public MessagesAdapter messagesAdapter;
    public RecyclerView messagesRecyclerView;
    public LinearLayout networkErrorFooter;
    public View parentView;
    public PickerAdapter pickerAdapter;
    public ImageView pickerBackView;
    public HSBottomSheet pickerBottomSheet;
    public ImageView pickerClearView;
    public ImageView pickerCollapseView;
    public View pickerCollapsedHeader;
    public TextView pickerCollapsedHeaderText;
    public View pickerCollapsedShadow;
    public View pickerEmptySearchResultsView;
    public ImageView pickerExpandView;
    public View pickerExpandedHeader;
    public TextView pickerExpandedHeaderText;
    public View pickerExpandedShadow;
    public EditText pickerHeaderSearchView;
    public RecyclerView pickerOptionsRecycler;
    public ImageView pickerSearchView;
    public View replyBoxView;
    public ImageButton replyButton;
    public EditText replyField;
    public TextView replyValidationFailedView;
    public View scrollIndicator;
    public View scrollJumpButton;
    public TextView skipBubbleTextView;
    public LinearLayout skipOutterBubble;
    public SmartIntentRenderer smartIntentRenderer;
    public View unreadMessagesIndicatorDot;

    public ConversationalFragmentRenderer(Context context2, Window window, RecyclerView recyclerView, View view, View view2, boolean z, boolean z2, View view3, View view4, IToolbarMenuItemRenderer iToolbarMenuItemRenderer, SmartIntentRenderer smartIntentRenderer2, ConversationalFragmentRouter conversationalFragmentRouter2) {
        this.context = context2;
        this.isHSBrandingDisabled = z;
        this.isAvatarEnabledInChatFeed = z2;
        this.listPickerHostWindow = window;
        this.messagesRecyclerView = recyclerView;
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        this.parentView = view;
        View findViewById = view.findViewById(C2466R.C2468id.replyBoxLayout);
        this.replyBoxView = findViewById;
        this.replyField = (EditText) findViewById.findViewById(C2466R.C2468id.hs__messageText);
        this.replyButton = (ImageButton) this.replyBoxView.findViewById(C2466R.C2468id.hs__sendMessageBtn);
        this.addAttachmentButton = (ImageButton) this.replyBoxView.findViewById(C2466R.C2468id.hs__addAttachmentBtn);
        this.replyButton.setImageDrawable(context2.getResources().getDrawable(Styles.getResourceIdForAttribute(context2, C2466R.attr.hs__messageSendIcon)).mutate());
        this.scrollJumpButton = view.findViewById(C2466R.C2468id.scroll_jump_button);
        this.confirmationBoxView = view2;
        this.conversationalFragmentRouter = conversationalFragmentRouter2;
        this.menuItemRenderer = iToolbarMenuItemRenderer;
        this.smartIntentRenderer = smartIntentRenderer2;
        this.scrollIndicator = view3;
        this.unreadMessagesIndicatorDot = view4;
        this.skipBubbleTextView = (TextView) view.findViewById(C2466R.C2468id.skipBubbleTextView);
        this.skipOutterBubble = (LinearLayout) view.findViewById(C2466R.C2468id.skipOuterBubble);
        this.replyValidationFailedView = (TextView) view.findViewById(C2466R.C2468id.errorReplyTextView);
        this.networkErrorFooter = (LinearLayout) view.findViewById(C2466R.C2468id.networkErrorFooter);
        this.conversationalFragmentRouter = conversationalFragmentRouter2;
    }

    private int calculatePickerBottomOffset(boolean z, int i) {
        int i2 = i - (this.isHSBrandingDisabled ? 0 : 14);
        return z ? i2 - 4 : i2;
    }

    private void changeMenuItemVisibility(HSMenuItemType hSMenuItemType, boolean z) {
        IToolbarMenuItemRenderer iToolbarMenuItemRenderer = this.menuItemRenderer;
        if (iToolbarMenuItemRenderer != null) {
            iToolbarMenuItemRenderer.updateMenuItemVisibility(hSMenuItemType, z);
        }
    }

    private void createRecyclerViewLastItemDecor() {
        if (this.lastMessageItemDecor == null) {
            this.lastMessageItemDecor = new RecyclerView.ItemDecoration() {
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    RecyclerView.Adapter adapter;
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                    if (childAdapterPosition != -1 && (adapter = recyclerView.getAdapter()) != null && ConversationalFragmentRenderer.this.skipOutterBubble.getVisibility() == 0 && childAdapterPosition == adapter.getItemCount() - 1) {
                        rect.set(rect.left, rect.top, rect.right, (int) TypedValue.applyDimension(1, 80.0f, recyclerView.getContext().getResources().getDisplayMetrics()));
                    }
                }
            };
        }
    }

    private void disableAccessibilityForMessageList() {
        View view = this.parentView;
        if (view != null) {
            view.setImportantForAccessibility(4);
            this.conversationalFragmentRouter.setToolbarImportanceForAccessibility(4);
        }
    }

    private void handleSkipButtonRenderingForPicker(boolean z, String str) {
        if (z || StringUtils.isEmpty(str)) {
            hideSkipButton();
            return;
        }
        setPickerOptionsInputSkipListener();
        this.skipBubbleTextView.setText(str);
        showSkipButton();
    }

    private void hideAttachmentPicker() {
        AttachmentTypeOptionPicker attachmentTypeOptionPicker = this.attachmentPicker;
        if (attachmentTypeOptionPicker != null) {
            attachmentTypeOptionPicker.dismissAttachmentPicker();
        }
    }

    private void hideScrollJumperView() {
        this.scrollIndicator.setVisibility(8);
        this.unreadMessagesIndicatorDot.setVisibility(8);
    }

    private void initBottomSheetCallback() {
        this.pickerBottomSheet.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            public void onSlide(@NonNull View view, float f) {
                if (((double) f) > 0.5d && ConversationalFragmentRenderer.this.bottomSheetBehavior.getState() == 2) {
                    ConversationalFragmentRenderer.this.onOptionPickerExpanded();
                } else if (ConversationalFragmentRenderer.this.bottomSheetBehavior.getState() == 2) {
                    ConversationalFragmentRenderer.this.onOptionPickerCollapsed();
                }
            }

            public void onStateChanged(@NonNull View view, int i) {
                if (4 == i) {
                    ConversationalFragmentRenderer.this.onOptionPickerCollapsed();
                } else if (3 == i) {
                    ConversationalFragmentRenderer.this.onOptionPickerExpanded();
                }
            }
        });
    }

    private void initPickerViews(String str) {
        this.bottomSheetBehavior = this.pickerBottomSheet.getBottomSheetBehaviour();
        View bottomSheetContentView = this.pickerBottomSheet.getBottomSheetContentView();
        this.pickerCollapsedShadow = bottomSheetContentView.findViewById(C2466R.C2468id.hs__picker_collapsed_shadow);
        this.pickerExpandedShadow = bottomSheetContentView.findViewById(C2466R.C2468id.hs__picker_expanded_shadow);
        RecyclerView recyclerView = (RecyclerView) bottomSheetContentView.findViewById(C2466R.C2468id.hs__optionsList);
        this.pickerOptionsRecycler = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(bottomSheetContentView.getContext(), 1, false));
        this.pickerSearchView = (ImageView) bottomSheetContentView.findViewById(C2466R.C2468id.hs__picker_action_search);
        this.pickerClearView = (ImageView) bottomSheetContentView.findViewById(C2466R.C2468id.hs__picker_action_clear);
        this.pickerCollapseView = (ImageView) bottomSheetContentView.findViewById(C2466R.C2468id.hs__picker_action_collapse);
        this.pickerBackView = (ImageView) bottomSheetContentView.findViewById(C2466R.C2468id.hs__picker_action_back);
        this.pickerHeaderSearchView = (EditText) bottomSheetContentView.findViewById(C2466R.C2468id.hs__picker_header_search);
        this.pickerExpandedHeaderText = (TextView) bottomSheetContentView.findViewById(C2466R.C2468id.hs__expanded_picker_header_text);
        this.pickerExpandedHeader = bottomSheetContentView.findViewById(C2466R.C2468id.hs__picker_expanded_header);
        this.pickerCollapsedHeader = bottomSheetContentView.findViewById(C2466R.C2468id.hs__picker_collapsed_header);
        this.pickerCollapsedHeaderText = (TextView) bottomSheetContentView.findViewById(C2466R.C2468id.hs__collapsed_picker_header_text);
        this.pickerEmptySearchResultsView = bottomSheetContentView.findViewById(C2466R.C2468id.hs__empty_picker_view);
        this.pickerExpandView = (ImageView) bottomSheetContentView.findViewById(C2466R.C2468id.hs__picker_action_expand);
        this.pickerExpandedHeaderText.setText(str);
        this.pickerCollapsedHeaderText.setText(str);
        String string = this.parentView.getResources().getString(C2466R.string.hs__picker_options_expand_header_voice_over, new Object[]{str});
        this.pickerCollapsedHeader.setContentDescription(string);
        this.pickerCollapsedHeaderText.setContentDescription(string);
        com.helpshift.util.Styles.setColorFilter(this.context, this.pickerSearchView.getDrawable(), C2466R.attr.hs__expandedPickerIconColor);
        com.helpshift.util.Styles.setColorFilter(this.context, this.pickerBackView.getDrawable(), C2466R.attr.hs__expandedPickerIconColor);
        com.helpshift.util.Styles.setColorFilter(this.context, this.pickerCollapseView.getDrawable(), C2466R.attr.hs__expandedPickerIconColor);
        com.helpshift.util.Styles.setColorFilter(this.context, this.pickerClearView.getDrawable(), C2466R.attr.hs__expandedPickerIconColor);
        com.helpshift.util.Styles.setColorFilter(this.context, this.pickerExpandView.getDrawable(), C2466R.attr.hs__collapsedPickerIconColor);
    }

    private void launchAttachmentIntentInternal(Intent intent, Uri uri) {
        try {
            this.context.startActivity(intent);
        } catch (Exception unused) {
            if (HelpshiftContext.getCoreApi().getDelegate().isDelegateRegistered()) {
                RootDelegate delegate = HelpshiftContext.getCoreApi().getDelegate().getDelegate();
                if (delegate instanceof Support.Delegate) {
                    ((Support.Delegate) delegate).displayAttachmentFile(uri);
                } else {
                    showErrorView(PlatformException.NO_APPS_FOR_OPENING_ATTACHMENT);
                }
            } else {
                showErrorView(PlatformException.NO_APPS_FOR_OPENING_ATTACHMENT);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onOptionPickerCollapsed() {
        this.pickerCollapsedShadow.setVisibility(0);
        com.helpshift.util.Styles.setGradientBackground(this.pickerCollapsedShadow, ContextCompat.getColor(this.context, C2466R.color.hs__color_40000000), 0, GradientDrawable.Orientation.BOTTOM_TOP);
        showPickerContent();
        resetPickerSearchViewToNormalHeader();
        this.pickerCollapsedHeader.setVisibility(0);
        this.pickerExpandedHeader.setVisibility(8);
        this.pickerOptionsRecycler.scrollToPosition(0);
        resetAccessibilityForMessageList();
    }

    /* access modifiers changed from: private */
    public void onOptionPickerExpanded() {
        this.pickerCollapsedShadow.setVisibility(8);
        com.helpshift.util.Styles.setGradientBackground(this.pickerExpandedShadow, ContextCompat.getColor(this.context, C2466R.color.hs__color_40000000), 0, GradientDrawable.Orientation.TOP_BOTTOM);
        this.pickerExpandedHeader.setVisibility(0);
        this.pickerCollapsedHeader.setVisibility(8);
        disableAccessibilityForMessageList();
    }

    private void registerListeners() {
        this.pickerHeaderSearchView.addTextChangedListener(new TextWatcherAdapter() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence != null) {
                    ConversationalFragmentRenderer.this.conversationalFragmentRouter.onListPickerSearchQueryChange(charSequence.toString());
                }
            }
        });
        this.pickerHeaderSearchView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3) {
                    return false;
                }
                ConversationalFragmentRenderer.this.hideKeyboard();
                return true;
            }
        });
        this.pickerSearchView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationalFragmentRenderer.this.pickerHeaderSearchView.setVisibility(0);
                ConversationalFragmentRenderer.this.pickerExpandedHeaderText.setVisibility(8);
                ConversationalFragmentRenderer.this.pickerSearchView.setVisibility(8);
                ConversationalFragmentRenderer.this.pickerHeaderSearchView.requestFocus();
                ConversationalFragmentRenderer.this.pickerBottomSheet.setDraggable(false);
                ConversationalFragmentRenderer.this.pickerCollapseView.setVisibility(8);
                ConversationalFragmentRenderer.this.pickerBackView.setVisibility(0);
                ConversationalFragmentRenderer conversationalFragmentRenderer = ConversationalFragmentRenderer.this;
                KeyboardUtil.showKeyboard(conversationalFragmentRenderer.context, conversationalFragmentRenderer.pickerHeaderSearchView);
                ConversationalFragmentRenderer.this.pickerBottomSheet.setDraggable(false);
            }
        });
        this.pickerBackView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationalFragmentRenderer.this.resetPickerSearchViewToNormalHeader();
            }
        });
        this.pickerClearView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationalFragmentRenderer.this.pickerHeaderSearchView.setText("");
                ConversationalFragmentRenderer.this.pickerClearView.setVisibility(8);
            }
        });
        this.pickerCollapseView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationalFragmentRenderer.this.bottomSheetBehavior.setState(4);
                ConversationalFragmentRenderer.this.hideKeyboard();
            }
        });
        this.pickerCollapsedHeader.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationalFragmentRenderer.this.bottomSheetBehavior.setState(3);
            }
        });
    }

    private void renderForTextInput(TextInput textInput) {
        this.replyField.setFocusableInTouchMode(true);
        this.replyField.setOnClickListener((View.OnClickListener) null);
        if (!TextUtils.isEmpty(textInput.inputLabel)) {
            ((LinearLayout) this.parentView.findViewById(C2466R.C2468id.replyBoxLabelLayout)).setVisibility(0);
            ((TextView) this.replyBoxView.findViewById(C2466R.C2468id.replyFieldLabel)).setText(textInput.inputLabel);
        }
        this.replyField.setHint(TextUtils.isEmpty(textInput.placeholder) ? "" : textInput.placeholder);
        int i = 131072;
        int i2 = textInput.keyboard;
        if (i2 == 1) {
            i = 147457;
        } else if (i2 == 2) {
            i = 131105;
        } else if (i2 == 3) {
            i = 139266;
        } else if (i2 != 4) {
            resetReplyFieldToNormalTextInput();
        } else {
            hideKeyboard();
            this.replyField.setFocusableInTouchMode(false);
            this.replyField.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ConversationalFragmentRenderer.this.createDatePickerForReplyField().show();
                }
            });
            i = 0;
        }
        this.replyField.setInputType(i);
        if (textInput.required || TextUtils.isEmpty(textInput.skipLabel)) {
            hideSkipButton();
        } else {
            setTextInputSkipListener();
            this.skipBubbleTextView.setText(textInput.skipLabel);
            showSkipButton();
        }
        this.replyBoxView.setVisibility(0);
    }

    private void resetAccessibilityForMessageList() {
        View view = this.parentView;
        if (view != null) {
            view.setImportantForAccessibility(0);
            this.conversationalFragmentRouter.resetToolbarImportanceForAccessibility();
        }
    }

    private void resetReplyFieldToNormalTextInput() {
        this.replyField.setInputType(147457);
        this.replyField.setHint(C2466R.string.hs__chat_hint);
    }

    private void setBottomOffset(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), (int) com.helpshift.util.Styles.dpToPx(this.context, (float) i));
    }

    private void setPaddingForReplyField(boolean z) {
        this.replyField.setPadding(!z ? (int) this.context.getResources().getDimension(C2466R.dimen.activity_horizontal_margin_medium) : 0, 0, 0, 0);
    }

    private void setPickerOptionsInputSkipListener() {
        this.skipBubbleTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationalFragmentRenderer.this.conversationalFragmentRouter.handleOptionSelectedForPicker((OptionUIModel) null, true);
            }
        });
    }

    private void setTextInputSkipListener() {
        this.skipBubbleTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationalFragmentRenderer.this.conversationalFragmentRouter.onSkipClick();
            }
        });
    }

    private void showEmptyPickerView() {
        if (!this.pickerEmptySearchResultsView.isShown()) {
            this.pickerEmptySearchResultsView.setVisibility(0);
        }
        if (this.pickerOptionsRecycler.isShown()) {
            this.pickerOptionsRecycler.setVisibility(8);
        }
    }

    private void showPickerContent() {
        if (this.pickerEmptySearchResultsView.isShown()) {
            this.pickerEmptySearchResultsView.setVisibility(8);
        }
        if (!this.pickerOptionsRecycler.isShown()) {
            this.pickerOptionsRecycler.setVisibility(0);
        }
    }

    private void showScrollJumperView(boolean z) {
        String str;
        this.scrollIndicator.setVisibility(0);
        if (z) {
            this.unreadMessagesIndicatorDot.setVisibility(0);
            str = this.context.getString(C2466R.string.hs__jump_button_with_new_message_voice_over);
        } else {
            this.unreadMessagesIndicatorDot.setVisibility(8);
            str = this.context.getString(C2466R.string.hs__jump_button_voice_over);
        }
        this.scrollJumpButton.setContentDescription(str);
    }

    private void showSendReplyUI(Input input) {
        if (input == null) {
            setMessagesViewBottomPadding();
            this.replyBoxView.setVisibility(0);
            ((LinearLayout) this.parentView.findViewById(C2466R.C2468id.replyBoxLabelLayout)).setVisibility(8);
            this.replyField.setFocusableInTouchMode(true);
            this.replyField.setOnClickListener((View.OnClickListener) null);
            resetReplyFieldToNormalTextInput();
            hideSkipButton();
            return;
        }
        if (input instanceof TextInput) {
            renderForTextInput((TextInput) input);
        }
        setMessagesViewBottomPadding();
    }

    public void appendMessages(int i, int i2) {
        MessagesAdapter messagesAdapter2 = this.messagesAdapter;
        if (messagesAdapter2 != null) {
            messagesAdapter2.onItemRangeInserted(i, i2);
        }
    }

    public DatePickerDialog createDatePickerForReplyField() {
        C271915 r2 = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Calendar instance = Calendar.getInstance();
                instance.set(i, i2, i3);
                ConversationalFragmentRenderer.this.replyField.setText(HSDateFormatSpec.getDateFormatter(HSDateFormatSpec.DISPLAY_DATE_PATTERN, HelpshiftContext.getCoreApi().getLocaleProviderDM().getCurrentLocale()).format(instance.getTime()));
            }
        };
        Calendar instance = Calendar.getInstance();
        try {
            String obj = this.replyField.getText().toString();
            if (!StringUtils.isEmpty(obj)) {
                instance.setTime(HSDateFormatSpec.getDateFormatter(HSDateFormatSpec.DISPLAY_DATE_PATTERN, HelpshiftContext.getCoreApi().getLocaleProviderDM().getCurrentLocale()).parse(obj));
            }
        } catch (ParseException unused) {
        }
        return new DatePickerDialog(this.parentView.getContext(), r2, instance.get(1), instance.get(2), instance.get(5));
    }

    public void destroy() {
        hideListPicker(true);
        this.smartIntentRenderer.dismissSmartIntentUI(false);
        hideAttachmentPicker();
        this.conversationalFragmentRouter = null;
    }

    public void disableSendReplyButton() {
        this.replyButton.setEnabled(false);
        Styles.setImageAlpha(this.replyButton, Styles.getInt(this.context, C2466R.attr.hs__reply_button_disabled_alpha));
        Styles.setSendMessageButtonIconColor(this.context, this.replyButton.getDrawable(), false);
    }

    public void enableSendReplyButton() {
        this.replyButton.setEnabled(true);
        Styles.setImageAlpha(this.replyButton, 255);
        Styles.setSendMessageButtonIconColor(this.context, this.replyButton.getDrawable(), true);
    }

    public String getReply() {
        return this.replyField.getText().toString();
    }

    public String getSmartIntentUserQuery() {
        return this.smartIntentRenderer.getReply();
    }

    public boolean handleBackPressedForListPicker() {
        if (this.pickerBottomSheet == null || this.bottomSheetBehavior.getState() != 3) {
            return false;
        }
        this.bottomSheetBehavior.setState(4);
        return true;
    }

    public void hideAgentTypingIndicator() {
        MessagesAdapter messagesAdapter2 = this.messagesAdapter;
        if (messagesAdapter2 != null) {
            messagesAdapter2.setAgentTypingIndicatorVisibility(false);
        }
    }

    public void hideKeyboard() {
        KeyboardUtil.hideKeyboard(this.context, this.replyField);
    }

    public void hideListPicker(boolean z) {
        BottomSheetBehavior bottomSheetBehavior2 = this.bottomSheetBehavior;
        if (bottomSheetBehavior2 != null && this.pickerBottomSheet != null) {
            if (z) {
                bottomSheetBehavior2.setHideable(true);
                this.pickerBottomSheet.removeAllBottomSheetCallbacks();
                this.pickerBottomSheet.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    public void onSlide(@NonNull View view, float f) {
                    }

                    public void onStateChanged(@NonNull View view, int i) {
                        if (i == 5) {
                            ConversationalFragmentRenderer.this.removePickerViewFromWindow();
                        }
                    }
                });
                this.bottomSheetBehavior.setState(5);
            } else {
                removePickerViewFromWindow();
            }
            resetAccessibilityForMessageList();
            hideKeyboard();
            setBottomOffset(this.parentView, 0);
            hideSkipButton();
        }
    }

    public void hideNetworkErrorFooter() {
        this.networkErrorFooter.setVisibility(8);
    }

    public void hidePickerClearButton() {
        if (this.pickerClearView.isShown()) {
            this.pickerClearView.setVisibility(8);
        }
    }

    public void hideReplyValidationFailedError() {
        this.replyValidationFailedView.setVisibility(8);
    }

    public void hideSendReplyUI() {
        this.messagesRecyclerView.setPadding(0, 0, 0, 0);
        this.replyBoxView.setVisibility(8);
        hideSkipButton();
        hideAttachmentPicker();
    }

    public void hideSkipButton() {
        this.skipOutterBubble.setVisibility(8);
        this.messagesRecyclerView.removeItemDecoration(this.lastMessageItemDecor);
    }

    public void hideSmartIntentReplyValidationFailedError() {
        this.smartIntentRenderer.hideReplyValidationFailedError();
    }

    public void hideSmartIntentView() {
        hideKeyboard();
        this.smartIntentRenderer.dismissSmartIntentUI(true);
        resetAccessibilityForMessageList();
    }

    public void initializeMessages(List<MessageDM> list) {
        this.messagesAdapter = new MessagesAdapter(this.context, list, this.isAvatarEnabledInChatFeed, this.conversationalFragmentRouter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setStackFromEnd(true);
        this.messagesRecyclerView.setLayoutManager(linearLayoutManager);
        this.messagesRecyclerView.setAdapter(this.messagesAdapter);
    }

    public boolean isReplyBoxVisible() {
        return this.replyBoxView.getVisibility() == 0;
    }

    public void launchAttachment(String str, String str2) {
        Intent intent;
        if (HsUriUtils.isValidUriPath(str)) {
            Uri parse = Uri.parse(str);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setFlags(1);
            intent2.setDataAndType(parse, str2);
            launchAttachmentIntentInternal(intent2, parse);
            return;
        }
        File validateAndCreateFile = FileUtil.validateAndCreateFile(str);
        if (validateAndCreateFile != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                intent = IntentUtil.createFileProviderIntent(this.context, validateAndCreateFile, str2);
            } else {
                Intent intent3 = new Intent("android.intent.action.VIEW");
                intent3.setDataAndType(Uri.fromFile(validateAndCreateFile), str2);
                intent = intent3;
            }
            launchAttachmentIntentInternal(intent, validateAndCreateFile);
            return;
        }
        showErrorView(PlatformException.FILE_NOT_FOUND);
    }

    public void launchScreenshotAttachment(String str, String str2) {
        File validateAndCreateFile = FileUtil.validateAndCreateFile(str);
        if (validateAndCreateFile != null) {
            launchAttachmentIntentInternal(IntentUtil.createFileProviderIntent(this.context, validateAndCreateFile, str2), validateAndCreateFile);
        } else {
            showErrorView(PlatformException.FILE_NOT_FOUND);
        }
    }

    public void notifyRefreshList() {
        MessagesAdapter messagesAdapter2 = this.messagesAdapter;
        if (messagesAdapter2 != null) {
            messagesAdapter2.notifyDataSetChanged();
        }
    }

    public void onAuthenticationFailure() {
        ConversationalFragmentRouter conversationalFragmentRouter2 = this.conversationalFragmentRouter;
        if (conversationalFragmentRouter2 != null) {
            conversationalFragmentRouter2.onAuthenticationFailure();
        }
    }

    public void onFocusChanged(boolean z) {
        if (!z) {
            hideListPicker(true);
            this.smartIntentRenderer.dismissSmartIntentUI(false);
        }
    }

    public void openActionLink(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.putExtra("origin", "helpshift");
        try {
            this.context.startActivity(intent);
        } catch (Exception unused) {
            showErrorView(PlatformException.NO_APPS_FOR_OPENING_ATTACHMENT);
        }
    }

    public void openAppReviewStore(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        try {
            this.context.startActivity(intent);
        } catch (Exception unused) {
            showErrorView(PlatformException.NO_APPS_FOR_OPENING_ATTACHMENT);
        }
    }

    public void openFreshConversationScreen(Map<String, Boolean> map) {
        this.conversationalFragmentRouter.openFreshConversationScreen(map);
    }

    public void removeMessages(int i, int i2) {
        MessagesAdapter messagesAdapter2 = this.messagesAdapter;
        if (messagesAdapter2 != null) {
            messagesAdapter2.onItemRangeRemoved(i, i2);
        }
    }

    public void removePickerViewFromWindow() {
        this.pickerBottomSheet.remove();
        this.pickerBottomSheet = null;
    }

    public void requestReplyFieldFocus() {
        this.replyField.requestFocus();
    }

    public void resetPickerSearchViewToNormalHeader() {
        this.pickerHeaderSearchView.setVisibility(8);
        this.pickerExpandedHeaderText.setVisibility(0);
        this.pickerHeaderSearchView.setText("");
        this.pickerBackView.setVisibility(8);
        this.pickerCollapseView.setVisibility(0);
        this.pickerClearView.setVisibility(8);
        this.pickerSearchView.setVisibility(0);
        hideKeyboard();
        this.pickerBottomSheet.setDraggable(true);
    }

    public void scrollToBottom() {
        int itemCount;
        MessagesAdapter messagesAdapter2 = this.messagesAdapter;
        if (messagesAdapter2 != null && (itemCount = messagesAdapter2.getItemCount()) > 0) {
            this.messagesRecyclerView.scrollToPosition(itemCount - 1);
        }
    }

    public void setMessagesViewBottomPadding() {
        this.messagesRecyclerView.setPadding(0, 0, 0, (int) com.helpshift.util.Styles.dpToPx(this.context, 12.0f));
    }

    public void setReply(String str) {
        this.replyField.setText(str);
        EditText editText = this.replyField;
        editText.setSelection(editText.getText().length());
    }

    public void setReplyboxListeners() {
        this.replyField.addTextChangedListener(new TextWatcherAdapter() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ConversationalFragmentRouter conversationalFragmentRouter = ConversationalFragmentRenderer.this.conversationalFragmentRouter;
                if (conversationalFragmentRouter != null) {
                    conversationalFragmentRouter.onTextChanged(charSequence, i, i2, i3);
                }
            }
        });
        this.replyField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                ConversationalFragmentRenderer.this.replyButton.performClick();
                return false;
            }
        });
        this.replyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationalFragmentRouter conversationalFragmentRouter = ConversationalFragmentRenderer.this.conversationalFragmentRouter;
                if (conversationalFragmentRouter != null) {
                    conversationalFragmentRouter.onSendButtonClick();
                }
            }
        });
        this.addAttachmentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationalFragmentRouter conversationalFragmentRouter = ConversationalFragmentRenderer.this.conversationalFragmentRouter;
                if (conversationalFragmentRouter != null) {
                    conversationalFragmentRouter.onAddAttachmentButtonClick();
                }
            }
        });
    }

    public void setSmartIntentReply(String str) {
        this.smartIntentRenderer.setReply(str);
    }

    public void showAgentTypingIndicator() {
        MessagesAdapter messagesAdapter2 = this.messagesAdapter;
        if (messagesAdapter2 != null) {
            messagesAdapter2.setAgentTypingIndicatorVisibility(true);
        }
    }

    public void showAttachmentPicker(List<Integer> list) {
        AttachmentTypeOptionPicker attachmentTypeOptionPicker = new AttachmentTypeOptionPicker(this.context);
        this.attachmentPicker = attachmentTypeOptionPicker;
        attachmentTypeOptionPicker.setListener(new AttachmentTypeOptionPicker.OnAttachmentTypeOptionClickListener() {
            public void launchAttachmentPicker(int i) {
                ConversationalFragmentRenderer.this.conversationalFragmentRouter.launchAttachmentPicker(i);
            }
        });
        this.attachmentPicker.showAttachmentPicker(this.addAttachmentButton, list);
    }

    public void showCSATSubmittedView() {
        SnackbarUtil.showSnackbar(this.parentView, (CharSequence) this.context.getResources().getString(C2466R.string.hs__csat_submit_toast), 0);
    }

    public void showEmptyListPickerView() {
        showEmptyPickerView();
    }

    public void showErrorView(ExceptionType exceptionType) {
        SnackbarUtil.showSnackbar(exceptionType, this.parentView);
    }

    public void showKeyboard() {
        KeyboardUtil.showKeyboard(this.context, this.replyField);
    }

    public void showListPicker(List<OptionUIModel> list, String str, boolean z, String str2) {
        if (this.pickerBottomSheet != null) {
            handleSkipButtonRenderingForPicker(z, str2);
            return;
        }
        boolean isTablet = Styles.isTablet(this.parentView.getContext());
        this.pickerBottomSheet = new HSBottomSheet.Builder(this.listPickerHostWindow).contentView(C2466R.layout.hs__picker_layout).referenceView(this.messagesRecyclerView).enableDimAnimation(true).dimOpacity(isTablet ? 0.8f : 1.0f).inflateAndBuild();
        initPickerViews(str);
        this.bottomSheetBehavior.setPeekHeight((int) com.helpshift.util.Styles.dpToPx(this.context, 142.0f));
        PickerAdapter pickerAdapter2 = new PickerAdapter(list, this.conversationalFragmentRouter);
        this.pickerAdapter = pickerAdapter2;
        this.pickerOptionsRecycler.setAdapter(pickerAdapter2);
        com.helpshift.util.Styles.setGradientBackground(this.pickerCollapsedShadow, ContextCompat.getColor(this.context, C2466R.color.hs__color_40000000), 0, GradientDrawable.Orientation.BOTTOM_TOP);
        hideSendReplyUI();
        handleSkipButtonRenderingForPicker(z, str2);
        hideKeyboard();
        setBottomOffset(this.parentView, calculatePickerBottomOffset(isTablet, OPTIONS_PICKER_PEEK_HEIGHT));
        registerListeners();
        initBottomSheetCallback();
        showPickerContent();
        this.pickerBottomSheet.show();
    }

    public void showNetworkErrorFooter(int i) {
        this.networkErrorFooter.setVisibility(0);
        TextView textView = (TextView) this.networkErrorFooter.findViewById(C2466R.C2468id.networkErrorFooterText);
        ProgressBar progressBar = (ProgressBar) this.networkErrorFooter.findViewById(C2466R.C2468id.networkErrorProgressBar);
        ImageView imageView = (ImageView) this.networkErrorFooter.findViewById(C2466R.C2468id.networkErrorIcon);
        imageView.setVisibility(0);
        com.helpshift.util.Styles.setDrawable(this.context, imageView, C2466R.C2467drawable.hs__network_error, C2466R.attr.hs__errorTextColor);
        progressBar.setVisibility(8);
        Resources resources = this.context.getResources();
        if (i == 1) {
            textView.setText(resources.getString(C2466R.string.hs__no_internet_error));
        } else if (i == 2) {
            textView.setText(resources.getString(C2466R.string.hs__network_reconnecting_error));
            imageView.setVisibility(8);
            progressBar.setVisibility(0);
        }
    }

    public void showOptionInput(OptionInput optionInput) {
        if (optionInput == null) {
            resetReplyFieldToNormalTextInput();
            return;
        }
        hideSendReplyUI();
        hideKeyboard();
        setMessagesViewBottomPadding();
    }

    public void showPickerClearButton() {
        if (!this.pickerClearView.isShown()) {
            this.pickerClearView.setVisibility(0);
        }
    }

    public void showReplyValidationFailedError(int i) {
        String str;
        boolean z = this.parentView.getResources().getConfiguration().orientation == 2;
        Resources resources = this.context.getResources();
        if (i == 1) {
            str = resources.getString(C2466R.string.hs__conversation_detail_error);
        } else if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    str = "";
                } else if (z) {
                    str = resources.getString(C2466R.string.hs__landscape_date_input_validation_error);
                } else {
                    str = resources.getString(C2466R.string.hs__date_input_validation_error);
                }
            } else if (z) {
                str = resources.getString(C2466R.string.hs__landscape_number_input_validation_error);
            } else {
                str = resources.getString(C2466R.string.hs__number_input_validation_error);
            }
        } else if (z) {
            str = resources.getString(C2466R.string.hs__landscape_email_input_validation_error);
        } else {
            str = resources.getString(C2466R.string.hs__email_input_validation_error);
        }
        if (z) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.parentView.getContext());
            builder.setTitle(resources.getString(C2466R.string.hs__landscape_input_validation_dialog_title));
            builder.setCancelable(true);
            builder.setMessage(str);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.create().show();
            return;
        }
        this.replyValidationFailedView.setText(str);
        this.replyValidationFailedView.setVisibility(0);
    }

    public void showSkipButton() {
        com.helpshift.util.Styles.setColorFilter(this.parentView.getContext(), this.skipBubbleTextView.getBackground(), C2466R.attr.hs__selectableOptionColor);
        com.helpshift.util.Styles.setColorFilter(this.parentView.getContext(), this.skipOutterBubble.getBackground(), 16842836);
        this.skipOutterBubble.setVisibility(0);
        this.messagesRecyclerView.removeItemDecoration(this.lastMessageItemDecor);
        createRecyclerViewLastItemDecor();
        this.messagesRecyclerView.addItemDecoration(this.lastMessageItemDecor);
    }

    public void showSmartIntentReplyValidationFailedError() {
        this.smartIntentRenderer.showReplyValidationFailedError();
    }

    public void showSmartIntentView(SmartIntentCollapsedRootViewState smartIntentCollapsedRootViewState) {
        hideKeyboard();
        this.smartIntentRenderer.showSmartIntentUI(smartIntentCollapsedRootViewState);
    }

    public void unregisterFragmentRenderer() {
        MessagesAdapter messagesAdapter2 = this.messagesAdapter;
        if (messagesAdapter2 != null) {
            messagesAdapter2.unregisterAdapterClickListener();
        }
    }

    public void updateConversationFooterState(ConversationFooterState conversationFooterState) {
        if (this.messagesAdapter != null) {
            if (conversationFooterState != ConversationFooterState.NONE) {
                hideKeyboard();
            }
            this.messagesAdapter.setConversationFooterState(conversationFooterState);
        }
    }

    public void updateConversationResolutionQuestionUI(boolean z) {
        if (z) {
            hideKeyboard();
            this.confirmationBoxView.setVisibility(0);
            return;
        }
        this.confirmationBoxView.setVisibility(8);
    }

    public void updateHistoryLoadingState(HistoryLoadingState historyLoadingState) {
        MessagesAdapter messagesAdapter2 = this.messagesAdapter;
        if (messagesAdapter2 != null) {
            messagesAdapter2.setHistoryLoadingState(historyLoadingState);
        }
    }

    public void updateImageAttachmentButtonView(boolean z) {
        if (z) {
            this.addAttachmentButton.setVisibility(0);
        } else {
            this.addAttachmentButton.setVisibility(8);
            hideAttachmentPicker();
            changeMenuItemVisibility(HSMenuItemType.SCREENSHOT_ATTACHMENT, false);
        }
        setPaddingForReplyField(z);
    }

    public void updateListPickerOptions(List<OptionUIModel> list) {
        if (this.pickerAdapter != null) {
            showPickerContent();
            this.pickerAdapter.dispatchUpdates(list);
        }
    }

    public void updateMessages(int i, int i2) {
        MessagesAdapter messagesAdapter2 = this.messagesAdapter;
        if (messagesAdapter2 != null) {
            if (i == 0 && i2 == messagesAdapter2.getMessageCount()) {
                this.messagesAdapter.notifyDataSetChanged();
            } else {
                this.messagesAdapter.onItemRangeChanged(i, i2);
            }
        }
    }

    public void updateScrollJumperView(boolean z, boolean z2) {
        if (z) {
            showScrollJumperView(z2);
        } else {
            hideScrollJumperView();
        }
    }

    public void updateSendReplyButton(boolean z) {
        if (z) {
            enableSendReplyButton();
        } else {
            disableSendReplyButton();
        }
    }

    public void updateSendReplyUI(boolean z, Input input) {
        if (z) {
            showSendReplyUI(input);
        } else {
            hideSendReplyUI();
        }
    }

    public void updateSmartIntentClearSearchButton(boolean z) {
        this.smartIntentRenderer.updateClearSearchButton(z);
    }

    public void updateSmartIntentReplyButton(boolean z, boolean z2) {
        this.smartIntentRenderer.updateReplyButtonViewState(z, z2);
    }

    public void updateSmartIntentView(BaseSmartIntentViewState baseSmartIntentViewState) {
        this.smartIntentRenderer.updateSmartIntentView(baseSmartIntentViewState);
        if (this.smartIntentRenderer.isUIInExpandedMode()) {
            disableAccessibilityForMessageList();
        } else {
            resetAccessibilityForMessageList();
        }
    }

    private void launchAttachmentIntentInternal(Intent intent, File file) {
        try {
            this.context.startActivity(intent);
        } catch (Exception unused) {
            if (HelpshiftContext.getCoreApi().getDelegate().isDelegateRegistered()) {
                HelpshiftContext.getCoreApi().getDelegate().displayAttachmentFile(file);
            } else {
                showErrorView(PlatformException.NO_APPS_FOR_OPENING_ATTACHMENT);
            }
        }
    }
}
