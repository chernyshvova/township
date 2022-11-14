package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.text.Html;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminCSATMessageWithOptions;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.OptionInputMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UIViewState;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.util.HSLinkify;
import com.helpshift.util.HSPattern;
import com.helpshift.util.StringUtils;
import com.helpshift.util.Styles;
import com.helpshift.views.CircleImageView;

public abstract class MessageViewDataBinder<VH extends RecyclerView.ViewHolder, M extends MessageDM> {
    public static final float BUBBLE_OPAGUE = 1.0f;
    public static final float BUBBLE_TRANSLUCENT = 0.5f;
    public Context context;
    public MessageItemClickListener messageClickListener;

    public interface MessageItemClickListener {
        void downloadAvatarImage(MessageDM messageDM);

        void handleAdminImageAttachmentMessageClick(AdminImageAttachmentMessageDM adminImageAttachmentMessageDM);

        void handleGenericAttachmentMessageClick(AdminAttachmentMessageDM adminAttachmentMessageDM);

        void handleOptionSelected(OptionInputMessageDM optionInputMessageDM, OptionInput.Option option, boolean z);

        void handleReplyReviewButtonClick(RequestAppReviewMessageDM requestAppReviewMessageDM);

        void launchImagePicker(RequestScreenshotMessageDM requestScreenshotMessageDM);

        void onActionCardClicked(AdminActionCardMessageDM adminActionCardMessageDM);

        void onAdminMessageLinkClickFailed();

        void onAdminMessageLinkClicked(String str, MessageDM messageDM);

        void onAdminSuggestedQuestionSelected(FAQListMessageDM fAQListMessageDM, String str, String str2);

        void onCSATSurveyRequestedFromBot(String str);

        void onCSATSurveyStartedFromBot(String str);

        void onCreateContextMenu(ContextMenu contextMenu, String str);

        void onScreenshotMessageClicked(ScreenshotMessageDM screenshotMessageDM);

        void onSendFeedbackClick(int i, AdminCSATMessageWithOptions adminCSATMessageWithOptions);

        void onStartNewConversationButtonClickFromCSATBot(AdminCSATMessageWithOptions adminCSATMessageWithOptions);

        void onUserAttachmentMessageClicked(UserAttachmentMessageDM userAttachmentMessageDM);

        void retryMessage(int i);
    }

    public MessageViewDataBinder(Context context2) {
        this.context = context2;
    }

    public void applyRedactionStyle(TextView textView) {
        textView.setTypeface(textView.getTypeface(), 2);
        textView.setAlpha(0.55f);
    }

    public abstract void bind(VH vh, M m);

    public abstract VH createViewHolder(ViewGroup viewGroup);

    public String escapeHtml(String str) {
        return Html.fromHtml(str.replace("\n", "<br/>")).toString();
    }

    public String getAdminMessageContentDesciption(MessageDM messageDM) {
        String displayedAuthorName = messageDM.getDisplayedAuthorName();
        String accessbilityMessageTime = messageDM.getAccessbilityMessageTime();
        if (StringUtils.isEmpty(displayedAuthorName)) {
            return this.context.getString(C2466R.string.hs__agent_message_voice_over, new Object[]{accessbilityMessageTime});
        }
        return this.context.getString(C2466R.string.hs__agent_message_with_name_voice_over, new Object[]{displayedAuthorName, accessbilityMessageTime});
    }

    public String getRedactedBodyText(String str) {
        return GeneratedOutlineSupport.outline16(str, " ");
    }

    public void linkify(TextView textView, HSLinkify.LinkClickListener linkClickListener) {
        HSLinkify.addLinks(textView, 14, linkClickListener);
        HSLinkify.addLinks(textView, HSPattern.getUrlPattern(), (String) null, (HSLinkify.MatchFilter) null, (HSLinkify.TransformFilter) null, linkClickListener);
    }

    public void setAdminMessageContainerBackground(View view, UIViewState uIViewState) {
        setDrawable(view, uIViewState.isRoundedBackground() ? C2466R.C2467drawable.hs__chat_bubble_rounded : C2466R.C2467drawable.hs__chat_bubble_admin, C2466R.attr.hs__chatBubbleAdminBackgroundColor);
    }

    public void setAdminMessageLayoutMarginForAvatar(ViewGroup.LayoutParams layoutParams) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins((int) this.context.getResources().getDimension(C2466R.dimen.hs__author_avatar_size), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
    }

    public void setAdminMessageSubText(TextView textView, UIViewState uIViewState, String str) {
        textView.setText(str);
        setViewVisibility(textView, uIViewState.isFooterVisible());
    }

    public void setAuthorAvatar(MessageDM messageDM, CircleImageView circleImageView) {
        UIViewState uiViewState = messageDM.getUiViewState();
        if (!messageDM.shouldShowAvatar()) {
            setViewVisibility(circleImageView, false);
        } else if (!uiViewState.isFooterVisible() || uiViewState.isRoundedBackground()) {
            circleImageView.setVisibility(4);
        } else {
            setViewVisibility(circleImageView, true);
            AvatarImageLoader.loadAvatarImageAccordingToState(this.context, messageDM, circleImageView);
            MessageItemClickListener messageItemClickListener = this.messageClickListener;
            if (messageItemClickListener != null) {
                messageItemClickListener.downloadAvatarImage(messageDM);
            }
        }
    }

    public void setDrawable(View view, int i, int i2) {
        Styles.setDrawable(this.context, view, i, i2);
    }

    public void setMessageItemClickListener(MessageItemClickListener messageItemClickListener) {
        this.messageClickListener = messageItemClickListener;
    }

    public void setUserMessageContainerBackground(View view, UIViewState uIViewState) {
        setDrawable(view, uIViewState.isRoundedBackground() ? C2466R.C2467drawable.hs__chat_bubble_rounded : C2466R.C2467drawable.hs__chat_bubble_user, C2466R.attr.hs__chatBubbleUserBackgroundColor);
    }

    public void setUserMessageLayoutMargin(ViewGroup.LayoutParams layoutParams) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        TypedValue typedValue = new TypedValue();
        this.context.getResources().getValue(C2466R.dimen.hs__screen_to_conversation_view_ratio, typedValue, true);
        marginLayoutParams.setMargins((int) (typedValue.getFloat() * ((float) this.context.getResources().getDisplayMetrics().widthPixels) * 0.2f), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
    }

    public void setUserMessageSubText(TextView textView, UIViewState uIViewState, String str) {
        textView.setText(str);
        setViewVisibility(textView, uIViewState.isFooterVisible());
    }

    public void setViewVisibility(View view, boolean z) {
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }
}
