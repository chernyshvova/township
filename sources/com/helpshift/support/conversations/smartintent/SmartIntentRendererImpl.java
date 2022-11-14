package com.helpshift.support.conversations.smartintent;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.SmartIntentRenderer;
import com.helpshift.conversation.smartintent.BaseIntentUIModel;
import com.helpshift.conversation.smartintent.BaseSmartIntentViewState;
import com.helpshift.conversation.smartintent.LeafIntentUIModel;
import com.helpshift.conversation.smartintent.RootIntentUIModel;
import com.helpshift.conversation.smartintent.SearchIntentUIModel;
import com.helpshift.conversation.smartintent.SmartIntentCollapsedRootViewState;
import com.helpshift.conversation.smartintent.SmartIntentExpandedRootViewState;
import com.helpshift.conversation.smartintent.SmartIntentLeafViewState;
import com.helpshift.conversation.smartintent.SmartIntentSearchResultViewState;
import com.helpshift.support.conversations.TextWatcherAdapter;
import com.helpshift.support.conversations.smartintent.SmartIntentsListAdapter;
import com.helpshift.util.ApplicationUtil;
import com.helpshift.util.HSAnimationUtil;
import com.helpshift.util.HSViewUtil;
import com.helpshift.util.KeyboardUtil;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.Styles;
import java.util.ArrayList;

public class SmartIntentRendererImpl implements SmartIntentRenderer, SmartIntentsListAdapter.SmartIntentListAdapterCallback {
    public SmartIntentsListAdapter adapter;
    public View.OnClickListener backButtonListener = new View.OnClickListener() {
        public void onClick(View view) {
            SmartIntentRendererImpl.this.recyclerView.setLayoutAnimation(SmartIntentRendererImpl.this.slideFromLeftAnimControl);
            SmartIntentRendererImpl.this.router.onSmartIntentBackButtonPressed();
        }
    };
    public View.OnClickListener bottomSheetCollapseListener = new View.OnClickListener() {
        public void onClick(View view) {
            SmartIntentRendererImpl.this.onBottomSheetToCollapseButtonClicked();
        }
    };
    public ImageView bottomSheetToolbarButtonView;
    public ImageButton clearSearch;
    public TextView collapseHeaderTitleView;
    public View collapseModeHeaderContainer;
    public View collapsedShadowView;
    public Context context;
    public ImageView crossButtonView;
    public EditText editFieldView;
    public TextView emptySearchResultHintView;
    public ImageView expandButtonView;
    public TextView expandHeaderTitleView;
    public View expandModeHeaderContainer;
    public View expandedShadowView;
    public boolean isParentBottomSheetDialogFragment;
    public BaseSmartIntentViewState lastViewState;
    public RecyclerView recyclerView;
    public ImageButton replyButton;
    public TextView replyValidationFailedView;
    public SmartIntentRouter router;
    public View scrollableViewContainer;
    public ImageView searchIcon;
    public Animation slideDownAnimation;
    public LayoutAnimationController slideFromLeftAnimControl;
    public LayoutAnimationController slideFromRightAnimControl;
    public View viewToDim;

    public SmartIntentRendererImpl(Context context2, SmartIntentRouter smartIntentRouter, boolean z) {
        this.context = context2;
        this.router = smartIntentRouter;
        this.isParentBottomSheetDialogFragment = z;
    }

    private void bindCollapsedRootViewState(SmartIntentCollapsedRootViewState smartIntentCollapsedRootViewState) {
        hideKeyboard();
        this.expandModeHeaderContainer.setVisibility(8);
        this.collapseModeHeaderContainer.setVisibility(0);
        this.collapseHeaderTitleView.setText(smartIntentCollapsedRootViewState.promptTitle);
        HSAnimationUtil.fadeVisibilityIn(this.collapsedShadowView, 0);
        this.expandHeaderTitleView.setText(smartIntentCollapsedRootViewState.promptTitle);
        this.recyclerView.setVisibility(0);
        this.adapter.updateIntentUIModels(new ArrayList(smartIntentCollapsedRootViewState.rootIntentUIModels));
        this.editFieldView.setHint(smartIntentCollapsedRootViewState.typingBoxHint);
        SmartIntentBottomSheetBehavior bottomSheetBehaviour = getBottomSheetBehaviour();
        if (bottomSheetBehaviour.getState() != 4) {
            bottomSheetBehaviour.setState(4);
        }
        Styles.setColorFilter(this.context, this.expandButtonView.getDrawable(), 16842806);
        if (this.isParentBottomSheetDialogFragment) {
            bottomSheetBehaviour.setDraggable(false);
        } else {
            bottomSheetBehaviour.setDraggable(true);
        }
        this.collapseModeHeaderContainer.setContentDescription(this.context.getResources().getString(C2466R.string.hs__picker_options_expand_header_voice_over, new Object[]{smartIntentCollapsedRootViewState.promptTitle}));
    }

    private void bindExpandedRootViewState(SmartIntentExpandedRootViewState smartIntentExpandedRootViewState) {
        this.collapseModeHeaderContainer.setVisibility(8);
        this.expandModeHeaderContainer.setVisibility(0);
        this.bottomSheetToolbarButtonView.setVisibility(0);
        this.bottomSheetToolbarButtonView.setOnClickListener(this.bottomSheetCollapseListener);
        HSAnimationUtil.rotate(this.bottomSheetToolbarButtonView, 100, 0.0f);
        this.crossButtonView.setVisibility(8);
        this.emptySearchResultHintView.setVisibility(8);
        this.expandHeaderTitleView.setText(smartIntentExpandedRootViewState.promptTitle);
        Styles.setColorFilter(this.context, this.bottomSheetToolbarButtonView.getDrawable(), 16842806);
        this.recyclerView.setVisibility(0);
        this.adapter.updateIntentUIModels(new ArrayList(smartIntentExpandedRootViewState.rootIntentUIModels));
        this.editFieldView.setHint(smartIntentExpandedRootViewState.typingBoxHint);
        SmartIntentBottomSheetBehavior bottomSheetBehaviour = getBottomSheetBehaviour();
        if (bottomSheetBehaviour.getState() != 3) {
            bottomSheetBehaviour.setState(3);
        }
        if (this.isParentBottomSheetDialogFragment) {
            bottomSheetBehaviour.setDraggable(false);
        } else {
            bottomSheetBehaviour.setDraggable(true);
        }
        this.bottomSheetToolbarButtonView.setContentDescription(this.context.getString(C2466R.string.hs__picker_options_list_collapse_btn_voice_over));
    }

    private void bindLeafViewState(SmartIntentLeafViewState smartIntentLeafViewState) {
        this.collapseModeHeaderContainer.setVisibility(8);
        this.expandModeHeaderContainer.setVisibility(0);
        this.bottomSheetToolbarButtonView.setVisibility(0);
        this.crossButtonView.setVisibility(8);
        this.emptySearchResultHintView.setVisibility(8);
        this.expandHeaderTitleView.setText(smartIntentLeafViewState.promptTitle);
        this.bottomSheetToolbarButtonView.setOnClickListener(this.backButtonListener);
        HSAnimationUtil.rotate(this.bottomSheetToolbarButtonView, 100, HSViewUtil.isViewDirectionRtl(this.expandModeHeaderContainer) ? -90.0f : 90.0f);
        Styles.setColorFilter(this.context, this.bottomSheetToolbarButtonView.getDrawable(), 16842806);
        this.recyclerView.setVisibility(0);
        this.adapter.updateIntentUIModels(new ArrayList(smartIntentLeafViewState.leafIntentUIModels));
        this.editFieldView.setHint(smartIntentLeafViewState.typingBoxHint);
        SmartIntentBottomSheetBehavior bottomSheetBehaviour = getBottomSheetBehaviour();
        if (bottomSheetBehaviour.getState() != 3) {
            bottomSheetBehaviour.setState(3);
        }
        bottomSheetBehaviour.setDraggable(false);
        this.bottomSheetToolbarButtonView.setContentDescription(this.context.getString(C2466R.string.hs__picker_search_edit_back_btn_voice_over));
    }

    private void bindSearchResultViewState(SmartIntentSearchResultViewState smartIntentSearchResultViewState) {
        this.collapseModeHeaderContainer.setVisibility(8);
        this.expandModeHeaderContainer.setVisibility(0);
        this.bottomSheetToolbarButtonView.setVisibility(8);
        this.crossButtonView.setVisibility(0);
        this.expandHeaderTitleView.setText(smartIntentSearchResultViewState.promptTitle);
        Styles.setColorFilter(this.context, this.crossButtonView.getDrawable(), 16842806);
        if (ListUtils.isEmpty(smartIntentSearchResultViewState.searchIntentUIModels)) {
            this.emptySearchResultHintView.setVisibility(0);
            this.emptySearchResultHintView.setText(smartIntentSearchResultViewState.emptySearchDescription);
            this.recyclerView.setVisibility(4);
        } else {
            this.emptySearchResultHintView.setVisibility(8);
            this.recyclerView.setVisibility(0);
            this.adapter.updateIntentUIModels(new ArrayList(smartIntentSearchResultViewState.searchIntentUIModels));
        }
        SmartIntentBottomSheetBehavior bottomSheetBehaviour = getBottomSheetBehaviour();
        if (bottomSheetBehaviour.getState() != 3) {
            bottomSheetBehaviour.setState(3);
        }
        bottomSheetBehaviour.setDraggable(false);
    }

    private int calculateBottomSheetPeakHeight(int i) {
        return Math.min((int) Styles.dpToPx(this.context, (float) ((i * 64) + 112)), ApplicationUtil.getScreenHeight(this.context) / 2);
    }

    private void collapsedViewAnimations() {
        if (!HSViewUtil.isVisible(this.collapseModeHeaderContainer) || !HSViewUtil.isGone(this.expandModeHeaderContainer)) {
            HSAnimationUtil.fadeVisibilityIn(this.collapseModeHeaderContainer, 0);
            HSAnimationUtil.fadeVisibilityGone(this.expandModeHeaderContainer, 0);
        }
    }

    private void disableSendReplyButton() {
        this.replyButton.setEnabled(false);
        com.helpshift.support.util.Styles.setImageAlpha(this.replyButton, com.helpshift.support.util.Styles.getInt(this.context, C2466R.attr.hs__reply_button_disabled_alpha));
        com.helpshift.support.util.Styles.setSendMessageButtonIconColor(this.context, this.replyButton.getDrawable(), false);
    }

    private void enableSendReplyButton() {
        this.replyButton.setEnabled(true);
        com.helpshift.support.util.Styles.setImageAlpha(this.replyButton, 255);
        com.helpshift.support.util.Styles.setSendMessageButtonIconColor(this.context, this.replyButton.getDrawable(), true);
    }

    private void expandViewAnimations() {
        if (!HSViewUtil.isGone(this.collapseModeHeaderContainer) || !HSViewUtil.isVisible(this.expandModeHeaderContainer)) {
            HSAnimationUtil.fadeVisibilityGone(this.collapseModeHeaderContainer, 0);
            HSAnimationUtil.fadeVisibilityIn(this.expandModeHeaderContainer, 0);
            HSAnimationUtil.rotate(this.bottomSheetToolbarButtonView, 100, 0.0f);
        }
    }

    private BottomSheetBehavior.BottomSheetCallback getBottomSheetBehaviorCallback() {
        return new BottomSheetBehavior.BottomSheetCallback() {
            public void onSlide(@NonNull View view, float f) {
                SmartIntentRendererImpl.this.handleBottomSheetSlideChange(f);
            }

            public void onStateChanged(@NonNull View view, int i) {
                SmartIntentRendererImpl.this.handleBottomSheetStateChange(i);
            }
        };
    }

    /* access modifiers changed from: private */
    public void handleBottomSheetSlideChange(float f) {
        double d = (double) f;
        if (d > 0.1d) {
            this.collapsedShadowView.setVisibility(4);
        }
        if (d <= 0.3d) {
            collapsedViewAnimations();
        } else if (isLeafViewState()) {
            leafViewAnimations();
        } else {
            expandViewAnimations();
        }
        this.viewToDim.setBackgroundColor(ColorUtils.blendARGB(0, ViewCompat.MEASURED_STATE_MASK, f));
    }

    /* access modifiers changed from: private */
    public void handleBottomSheetStateChange(int i) {
        if (i == 3) {
            this.router.onSmartIntentBottomSheetExpanded();
        } else if (i == 4) {
            this.router.onSmartIntentBottomSheetCollapsed();
        }
    }

    /* access modifiers changed from: private */
    public void hideKeyboard() {
        EditText editText = this.editFieldView;
        if (editText != null) {
            KeyboardUtil.hideKeyboard(this.context, editText);
        }
    }

    private boolean isLeafViewState() {
        return this.lastViewState instanceof SmartIntentLeafViewState;
    }

    private boolean isViewInitialized() {
        return this.lastViewState != null;
    }

    private void leafViewAnimations() {
        if (!HSViewUtil.isGone(this.collapseModeHeaderContainer) || !HSViewUtil.isVisible(this.expandModeHeaderContainer)) {
            HSAnimationUtil.fadeVisibilityGone(this.collapseModeHeaderContainer, 0);
            HSAnimationUtil.fadeVisibilityIn(this.expandModeHeaderContainer, 0);
            HSAnimationUtil.rotate(this.bottomSheetToolbarButtonView, 100, HSViewUtil.isViewDirectionRtl(this.expandModeHeaderContainer) ? -90.0f : 90.0f);
        }
    }

    /* access modifiers changed from: private */
    public void onBottomSheetToCollapseButtonClicked() {
        collapsedViewAnimations();
        getBottomSheetBehaviour().setState(4);
    }

    /* access modifiers changed from: private */
    public void onBottomSheetToExpandButtonClicked() {
        expandViewAnimations();
        getBottomSheetBehaviour().setState(3);
    }

    /* access modifiers changed from: private */
    public void onReplyFieldViewFocusedChanged(boolean z) {
        if (z) {
            getBottomSheetBehaviour().setState(3);
        } else {
            hideKeyboard();
        }
    }

    private void registerViewListeners() {
        this.editFieldView.addTextChangedListener(new TextWatcherAdapter() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence != null) {
                    SmartIntentRendererImpl.this.router.onSmartIntentTextChanged(charSequence);
                }
            }
        });
        this.editFieldView.setClickable(true);
        this.editFieldView.setFocusable(true);
        this.editFieldView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                SmartIntentRendererImpl.this.onReplyFieldViewFocusedChanged(z);
            }
        });
        this.editFieldView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SmartIntentRendererImpl.this.onReplyFieldViewFocusedChanged(true);
            }
        });
        this.editFieldView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    SmartIntentRendererImpl.this.router.onSmartIntentSendButtonClick();
                    return false;
                } else if (i != 3) {
                    return false;
                } else {
                    SmartIntentRendererImpl.this.router.onSmartIntentTextChanged(SmartIntentRendererImpl.this.editFieldView.getText());
                    SmartIntentRendererImpl.this.hideKeyboard();
                    return false;
                }
            }
        });
        this.expandButtonView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SmartIntentRendererImpl.this.onBottomSheetToExpandButtonClicked();
            }
        });
        this.bottomSheetToolbarButtonView.setOnClickListener(this.bottomSheetCollapseListener);
        this.replyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SmartIntentRendererImpl.this.router.onSmartIntentSendButtonClick();
            }
        });
        this.crossButtonView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SmartIntentRendererImpl.this.router.onSmartIntentBackButtonPressed();
                if (SmartIntentRendererImpl.this.lastViewState.enforceIntentSelection) {
                    SmartIntentRendererImpl.this.editFieldView.setText("");
                }
            }
        });
        this.collapseModeHeaderContainer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SmartIntentRendererImpl.this.onBottomSheetToExpandButtonClicked();
            }
        });
        this.clearSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SmartIntentRendererImpl.this.lastViewState instanceof SmartIntentSearchResultViewState) {
                    SmartIntentRendererImpl.this.router.onSmartIntentBackButtonPressed();
                }
                SmartIntentRendererImpl.this.editFieldView.setText("");
            }
        });
    }

    public void dismissSmartIntentUI(boolean z) {
        View view;
        Animation animation;
        this.lastViewState = null;
        if (!(!z || (view = this.scrollableViewContainer) == null || (animation = this.slideDownAnimation) == null)) {
            view.startAnimation(animation);
        }
        this.router.removeSmartIntentViewFromBottomSheet();
    }

    public SmartIntentBottomSheetBehavior getBottomSheetBehaviour() {
        return (SmartIntentBottomSheetBehavior) BottomSheetBehavior.from(this.scrollableViewContainer);
    }

    public String getReply() {
        if (!isViewInitialized()) {
            return null;
        }
        return this.editFieldView.getText().toString();
    }

    public void hideReplyValidationFailedError() {
        if (isViewInitialized()) {
            this.replyValidationFailedView.setVisibility(8);
        }
    }

    public boolean isUIInExpandedMode() {
        return !(this.lastViewState instanceof SmartIntentCollapsedRootViewState);
    }

    public void onIntentSelected(BaseIntentUIModel baseIntentUIModel) {
        if (baseIntentUIModel instanceof RootIntentUIModel) {
            this.router.onRootIntentSelected((RootIntentUIModel) baseIntentUIModel);
        } else if (baseIntentUIModel instanceof LeafIntentUIModel) {
            this.router.onLeafIntentSelected((LeafIntentUIModel) baseIntentUIModel);
        } else if (baseIntentUIModel instanceof SearchIntentUIModel) {
            this.router.onSearchIntentSelected((SearchIntentUIModel) baseIntentUIModel);
        }
        this.recyclerView.setLayoutAnimation(this.slideFromRightAnimControl);
    }

    public void setReply(String str) {
        if (isViewInitialized() && !StringUtils.isEqual(str, this.editFieldView.getText().toString())) {
            this.editFieldView.setText(str);
            EditText editText = this.editFieldView;
            editText.setSelection(editText.getText().length());
        }
    }

    public void showReplyValidationFailedError() {
        if (isViewInitialized()) {
            boolean z = this.scrollableViewContainer.getResources().getConfiguration().orientation == 2;
            Resources resources = this.context.getResources();
            String string = resources.getString(C2466R.string.hs__conversation_detail_error);
            if (z) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                builder.setTitle(resources.getString(C2466R.string.hs__landscape_input_validation_dialog_title));
                builder.setCancelable(true);
                builder.setMessage(string);
                builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
                return;
            }
            this.replyValidationFailedView.setText(string);
            this.replyValidationFailedView.setVisibility(0);
        }
    }

    public void showSmartIntentUI(SmartIntentCollapsedRootViewState smartIntentCollapsedRootViewState) {
        View inflate = LayoutInflater.from(this.context).inflate(C2466R.layout.hs__smart_intents_container, (ViewGroup) null, false);
        this.scrollableViewContainer = inflate.findViewById(C2466R.C2468id.hs__si_scrollable_view_container);
        this.viewToDim = inflate.findViewById(C2466R.C2468id.hs__si_background_dim_view);
        this.scrollableViewContainer.startAnimation(AnimationUtils.loadAnimation(this.context, C2466R.anim.hs__slide_up));
        this.collapseModeHeaderContainer = inflate.findViewById(C2466R.C2468id.hs__si_header_collapsed_view_container);
        this.collapsedShadowView = inflate.findViewById(C2466R.C2468id.hs__si_collapsed_shadow);
        this.collapseHeaderTitleView = (TextView) inflate.findViewById(C2466R.C2468id.hs__si_header_collapsed_text);
        this.expandButtonView = (ImageView) inflate.findViewById(C2466R.C2468id.hs__si_header_expand_button);
        this.expandModeHeaderContainer = inflate.findViewById(C2466R.C2468id.hs__si_header_expanded_view_container);
        this.expandedShadowView = inflate.findViewById(C2466R.C2468id.hs__si_header_expanded_shadow);
        this.expandHeaderTitleView = (TextView) inflate.findViewById(C2466R.C2468id.hs__si_header_expanded_text);
        this.bottomSheetToolbarButtonView = (ImageView) inflate.findViewById(C2466R.C2468id.hs__si_header_collapse_button);
        this.crossButtonView = (ImageView) inflate.findViewById(C2466R.C2468id.hs__si_header_cross_button);
        this.emptySearchResultHintView = (TextView) inflate.findViewById(C2466R.C2468id.hs__si_empty_search_result_view);
        this.slideDownAnimation = AnimationUtils.loadAnimation(this.context, C2466R.anim.hs__slide_down);
        this.slideFromRightAnimControl = AnimationUtils.loadLayoutAnimation(this.context, C2466R.anim.hs__smart_intent_layout_from_right);
        this.slideFromLeftAnimControl = AnimationUtils.loadLayoutAnimation(this.context, C2466R.anim.hs__smart_intent_layout_from_left);
        this.collapseModeHeaderContainer.setVisibility(0);
        this.expandModeHeaderContainer.setVisibility(8);
        this.editFieldView = (EditText) inflate.findViewById(C2466R.C2468id.hs__si_edit_text_view);
        this.replyValidationFailedView = (TextView) inflate.findViewById(C2466R.C2468id.hs__si_error_reply_text_view);
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(C2466R.C2468id.hs__si_intents_recycler_view);
        this.recyclerView = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.context));
        this.adapter = new SmartIntentsListAdapter(new ArrayList(smartIntentCollapsedRootViewState.rootIntentUIModels), this);
        this.recyclerView.setLayoutAnimation(this.slideFromRightAnimControl);
        this.recyclerView.setAdapter(this.adapter);
        this.replyButton = (ImageButton) inflate.findViewById(C2466R.C2468id.hs__si_send_button_view);
        if (HSViewUtil.isViewDirectionRtl(this.expandModeHeaderContainer)) {
            this.replyButton.setRotationY(180.0f);
        }
        this.replyButton.setImageDrawable(this.context.getResources().getDrawable(com.helpshift.support.util.Styles.getResourceIdForAttribute(this.context, C2466R.attr.hs__messageSendIcon)).mutate());
        disableSendReplyButton();
        Styles.setGradientBackground(this.collapsedShadowView, ContextCompat.getColor(this.context, C2466R.color.hs__color_40000000), 0, GradientDrawable.Orientation.BOTTOM_TOP);
        Styles.setGradientBackground(this.expandedShadowView, ContextCompat.getColor(this.context, C2466R.color.hs__color_40000000), 0, GradientDrawable.Orientation.TOP_BOTTOM);
        int calculateBottomSheetPeakHeight = calculateBottomSheetPeakHeight(smartIntentCollapsedRootViewState.rootIntentUIModels.size());
        SmartIntentBottomSheetBehavior bottomSheetBehaviour = getBottomSheetBehaviour();
        bottomSheetBehaviour.setPeekHeight(calculateBottomSheetPeakHeight);
        bottomSheetBehaviour.setBottomSheetCallback(getBottomSheetBehaviorCallback());
        this.router.showSmartIntentViewInBottomSheet(inflate, calculateBottomSheetPeakHeight);
        this.clearSearch = (ImageButton) inflate.findViewById(C2466R.C2468id.hs__si_clear_search_btn);
        bindCollapsedRootViewState(smartIntentCollapsedRootViewState);
        registerViewListeners();
        this.lastViewState = smartIntentCollapsedRootViewState;
        if (smartIntentCollapsedRootViewState.enforceIntentSelection) {
            ImageView imageView = (ImageView) inflate.findViewById(C2466R.C2468id.hs__smart_intent_replyfooter_search_image);
            this.searchIcon = imageView;
            imageView.setImageDrawable(this.context.getResources().getDrawable(C2466R.C2467drawable.hs__action_search).mutate());
            this.searchIcon.setVisibility(0);
            Styles.setColorFilter(this.searchIcon.getContext(), this.searchIcon.getDrawable(), 16842806);
        }
    }

    public void updateClearSearchButton(boolean z) {
        if (isViewInitialized()) {
            int i = z ? 0 : 8;
            if (i == 0) {
                Styles.setColorFilter(this.clearSearch.getContext(), this.clearSearch.getDrawable(), 16842806);
            }
            this.clearSearch.setVisibility(i);
        }
    }

    public void updateReplyButtonViewState(boolean z, boolean z2) {
        if (isViewInitialized()) {
            if (z) {
                this.replyButton.setVisibility(0);
                this.editFieldView.setImeOptions(4);
            } else {
                this.replyButton.setVisibility(8);
                this.editFieldView.setImeOptions(3);
            }
            if (z2) {
                enableSendReplyButton();
            } else {
                disableSendReplyButton();
            }
        }
    }

    public void updateSmartIntentView(BaseSmartIntentViewState baseSmartIntentViewState) {
        this.lastViewState = baseSmartIntentViewState;
        if (baseSmartIntentViewState instanceof SmartIntentExpandedRootViewState) {
            bindExpandedRootViewState((SmartIntentExpandedRootViewState) baseSmartIntentViewState);
        } else if (baseSmartIntentViewState instanceof SmartIntentCollapsedRootViewState) {
            bindCollapsedRootViewState((SmartIntentCollapsedRootViewState) baseSmartIntentViewState);
        } else if (baseSmartIntentViewState instanceof SmartIntentLeafViewState) {
            bindLeafViewState((SmartIntentLeafViewState) baseSmartIntentViewState);
        } else if (baseSmartIntentViewState instanceof SmartIntentSearchResultViewState) {
            bindSearchResultViewState((SmartIntentSearchResultViewState) baseSmartIntentViewState);
        }
    }
}
