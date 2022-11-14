package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.UIViewState;
import com.helpshift.support.conversations.messages.MessageViewDataBinder;
import com.helpshift.views.CircleImageView;

public class RequestAppReviewMessageDataBinder extends MessageViewDataBinder<ViewHolder, RequestAppReviewMessageDM> {

    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final CircleImageView avatarImageView;
        public final TextView message;
        public final View messageContainer;
        public final View messageLayout;
        public final Button reviewButton;
        public final TextView subText;

        public ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(C2466R.C2468id.admin_review_message_layout);
            this.message = (TextView) view.findViewById(C2466R.C2468id.review_request_message);
            this.reviewButton = (Button) view.findViewById(C2466R.C2468id.review_request_button);
            this.subText = (TextView) view.findViewById(C2466R.C2468id.review_request_date);
            this.messageContainer = view.findViewById(C2466R.C2468id.review_request_message_container);
            this.avatarImageView = (CircleImageView) view.findViewById(C2466R.C2468id.avatar_image_view);
        }
    }

    public RequestAppReviewMessageDataBinder(Context context) {
        super(context);
    }

    public void bind(ViewHolder viewHolder, final RequestAppReviewMessageDM requestAppReviewMessageDM) {
        viewHolder.message.setText(C2466R.string.hs__review_request_message);
        if (requestAppReviewMessageDM.isAnswered) {
            viewHolder.reviewButton.setVisibility(8);
        } else {
            viewHolder.reviewButton.setVisibility(0);
        }
        UIViewState uiViewState = requestAppReviewMessageDM.getUiViewState();
        setDrawable(viewHolder.messageContainer, uiViewState.isRoundedBackground() ? C2466R.C2467drawable.hs__chat_bubble_rounded : C2466R.C2467drawable.hs__chat_bubble_admin, C2466R.attr.hs__chatBubbleAdminBackgroundColor);
        if (uiViewState.isFooterVisible()) {
            viewHolder.subText.setText(requestAppReviewMessageDM.getSubText());
        }
        setViewVisibility(viewHolder.subText, uiViewState.isFooterVisible());
        if (requestAppReviewMessageDM.isReviewButtonClickable) {
            viewHolder.reviewButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MessageViewDataBinder.MessageItemClickListener messageItemClickListener = RequestAppReviewMessageDataBinder.this.messageClickListener;
                    if (messageItemClickListener != null) {
                        messageItemClickListener.handleReplyReviewButtonClick(requestAppReviewMessageDM);
                    }
                }
            });
        } else {
            viewHolder.reviewButton.setOnClickListener((View.OnClickListener) null);
        }
        viewHolder.messageLayout.setContentDescription(getAdminMessageContentDesciption(requestAppReviewMessageDM));
        setAuthorAvatar(requestAppReviewMessageDM, viewHolder.avatarImageView);
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__msg_review_request, viewGroup, false));
    }
}
