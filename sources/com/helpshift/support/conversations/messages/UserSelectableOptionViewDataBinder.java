package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.animation.CollapseViewAnimation;
import com.helpshift.conversation.activeconversation.message.OptionInputMessageDM;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.support.conversations.messages.MessageViewDataBinder;
import com.helpshift.support.util.Styles;
import com.helpshift.support.views.HSAdjustableSelectOptionsViewInflater;
import com.helpshift.util.StringUtils;

public class UserSelectableOptionViewDataBinder extends MessageViewDataBinder<ViewHolder, OptionInputMessageDM> {

    public final class OnOptionSelectedListener implements View.OnClickListener {
        public final boolean isSkip;
        public final OptionInputMessageDM message;
        public final MessageViewDataBinder.MessageItemClickListener messageClickListener;
        public final ViewHolder viewHolder;

        public OnOptionSelectedListener(ViewHolder viewHolder2, MessageViewDataBinder.MessageItemClickListener messageItemClickListener, OptionInputMessageDM optionInputMessageDM, boolean z) {
            this.viewHolder = viewHolder2;
            this.messageClickListener = messageItemClickListener;
            this.message = optionInputMessageDM;
            this.isSkip = z;
        }

        public void onClick(View view) {
            final TextView textView = (TextView) view;
            CollapseViewAnimation collapseViewAnimation = new CollapseViewAnimation(this.viewHolder.optionsMessageView);
            long j = (long) 250;
            collapseViewAnimation.setDuration(j);
            collapseViewAnimation.setFillAfter(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(j);
            alphaAnimation.setFillAfter(true);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(collapseViewAnimation);
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    OnOptionSelectedListener.this.viewHolder.optionsMessageView.setVisibility(8);
                    OnOptionSelectedListener onOptionSelectedListener = OnOptionSelectedListener.this;
                    MessageViewDataBinder.MessageItemClickListener messageItemClickListener = onOptionSelectedListener.messageClickListener;
                    if (messageItemClickListener != null) {
                        messageItemClickListener.handleOptionSelected(onOptionSelectedListener.message, (OptionInput.Option) textView.getTag(), OnOptionSelectedListener.this.isSkip);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            this.viewHolder.optionsMessageView.startAnimation(animationSet);
        }
    }

    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout optionsContainer;
        public final TextView optionsHeaderTextView;
        public final LinearLayout optionsMessageView;
        public final TextView optionsSkipTextView;

        public ViewHolder(View view) {
            super(view);
            this.optionsMessageView = (LinearLayout) view.findViewById(C2466R.C2468id.options_message_view);
            this.optionsContainer = (LinearLayout) view.findViewById(C2466R.C2468id.selectable_options_container);
            this.optionsHeaderTextView = (TextView) view.findViewById(C2466R.C2468id.options_header);
            this.optionsSkipTextView = (TextView) view.findViewById(C2466R.C2468id.selectable_option_skip);
        }
    }

    public UserSelectableOptionViewDataBinder(Context context) {
        super(context);
    }

    public void bind(ViewHolder viewHolder, OptionInputMessageDM optionInputMessageDM) {
        ViewHolder viewHolder2 = viewHolder;
        OptionInputMessageDM optionInputMessageDM2 = optionInputMessageDM;
        viewHolder2.optionsContainer.removeAllViews();
        if (!StringUtils.isEmpty(optionInputMessageDM2.input.inputLabel)) {
            viewHolder2.optionsHeaderTextView.setVisibility(0);
            viewHolder2.optionsHeaderTextView.setText(optionInputMessageDM2.input.inputLabel);
        } else {
            viewHolder2.optionsHeaderTextView.setVisibility(8);
        }
        OnOptionSelectedListener onOptionSelectedListener = new OnOptionSelectedListener(viewHolder, this.messageClickListener, optionInputMessageDM, false);
        new HSAdjustableSelectOptionsViewInflater(this.context, Styles.isTablet(this.context) ? 0.6000000000000001d : 0.8d, (int) this.context.getResources().getDimension(C2466R.dimen.activity_horizontal_margin_medium), viewHolder2.optionsContainer, C2466R.layout.hs__msg_user_selectable_option, C2466R.C2468id.selectable_option_text, C2466R.C2467drawable.hs__pill, C2466R.attr.hs__selectableOptionColor, optionInputMessageDM2.input.options, onOptionSelectedListener).inflate();
        OptionInput optionInput = optionInputMessageDM2.input;
        if (optionInput.required || StringUtils.isEmpty(optionInput.skipLabel)) {
            viewHolder2.optionsSkipTextView.setVisibility(8);
            return;
        }
        int paddingLeft = viewHolder2.optionsSkipTextView.getPaddingLeft();
        int paddingTop = viewHolder2.optionsSkipTextView.getPaddingTop();
        int paddingRight = viewHolder2.optionsSkipTextView.getPaddingRight();
        int paddingBottom = viewHolder2.optionsSkipTextView.getPaddingBottom();
        setDrawable(viewHolder2.optionsSkipTextView, C2466R.C2467drawable.hs__pill_small, C2466R.attr.hs__selectableOptionColor);
        viewHolder2.optionsSkipTextView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        viewHolder2.optionsSkipTextView.setText(optionInputMessageDM2.input.skipLabel);
        viewHolder2.optionsSkipTextView.setVisibility(0);
        viewHolder2.optionsSkipTextView.setOnClickListener(new OnOptionSelectedListener(viewHolder, this.messageClickListener, optionInputMessageDM, true));
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__msg_user_selectable_options_container, viewGroup, false));
        viewHolder.setIsRecyclable(false);
        return viewHolder;
    }
}
