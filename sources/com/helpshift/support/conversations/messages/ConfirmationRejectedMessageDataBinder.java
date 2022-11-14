package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.ConfirmationRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.UIViewState;
import com.helpshift.views.CircleImageView;
import com.swrve.sdk.rest.RESTClient;

public class ConfirmationRejectedMessageDataBinder extends MessageViewDataBinder<ViewHolder, ConfirmationRejectedMessageDM> {

    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final CircleImageView avatarImageView;
        public final TextView message;
        public final View messageContainer;
        public final View messageLayout;
        public final TextView subText;

        public ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(C2466R.C2468id.admin_text_message_layout);
            this.message = (TextView) view.findViewById(C2466R.C2468id.admin_message_text);
            this.subText = (TextView) view.findViewById(C2466R.C2468id.admin_date_text);
            this.messageContainer = view.findViewById(C2466R.C2468id.admin_message_container);
            this.avatarImageView = (CircleImageView) view.findViewById(C2466R.C2468id.avatar_image_view);
        }
    }

    public ConfirmationRejectedMessageDataBinder(Context context) {
        super(context);
    }

    public void bind(ViewHolder viewHolder, ConfirmationRejectedMessageDM confirmationRejectedMessageDM) {
        viewHolder.message.setText(C2466R.string.hs__cr_msg);
        UIViewState uiViewState = confirmationRejectedMessageDM.getUiViewState();
        setDrawable(viewHolder.messageContainer, uiViewState.isRoundedBackground() ? C2466R.C2467drawable.hs__chat_bubble_rounded : C2466R.C2467drawable.hs__chat_bubble_admin, C2466R.attr.hs__chatBubbleAdminBackgroundColor);
        if (uiViewState.isFooterVisible()) {
            viewHolder.subText.setText(confirmationRejectedMessageDM.getSystemMessageNickname() + RESTClient.COMMA_SEPARATOR + confirmationRejectedMessageDM.getSubText());
        }
        viewHolder.messageLayout.setContentDescription(getAdminMessageContentDesciption(confirmationRejectedMessageDM));
        setViewVisibility(viewHolder.subText, uiViewState.isFooterVisible());
        setAuthorAvatar(confirmationRejectedMessageDM, viewHolder.avatarImageView);
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__msg_txt_admin, viewGroup, false));
    }
}
