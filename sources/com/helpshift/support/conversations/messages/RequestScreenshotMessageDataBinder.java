package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UIViewState;
import com.helpshift.support.conversations.messages.MessageViewDataBinder;
import com.helpshift.support.util.Styles;
import com.helpshift.util.HSLinkify;
import com.helpshift.views.CircleImageView;

public class RequestScreenshotMessageDataBinder extends MessageViewDataBinder<ViewHolder, RequestScreenshotMessageDM> {

    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout adminMessage;
        public final TextView adminRequestText;
        public final Button attachButton;
        public final CircleImageView avatarImageView;
        public final View messageLayout;
        public final TextView subText;

        public ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(C2466R.C2468id.agent_screenshot_request_message_layout);
            this.adminRequestText = (TextView) view.findViewById(C2466R.C2468id.admin_attachment_request_text);
            this.attachButton = (Button) view.findViewById(C2466R.C2468id.admin_attach_screenshot_button);
            this.adminMessage = (LinearLayout) view.findViewById(C2466R.C2468id.admin_message);
            this.subText = (TextView) view.findViewById(C2466R.C2468id.admin_date_text);
            this.avatarImageView = (CircleImageView) view.findViewById(C2466R.C2468id.avatar_image_view);
            Styles.setAdminChatBubbleColor(RequestScreenshotMessageDataBinder.this.context, this.adminMessage.getBackground());
        }
    }

    public RequestScreenshotMessageDataBinder(Context context) {
        super(context);
    }

    public void bind(ViewHolder viewHolder, final RequestScreenshotMessageDM requestScreenshotMessageDM) {
        viewHolder.adminRequestText.setText(escapeHtml(requestScreenshotMessageDM.body));
        setViewVisibility(viewHolder.attachButton, requestScreenshotMessageDM.isAttachmentAllowed());
        UIViewState uiViewState = requestScreenshotMessageDM.getUiViewState();
        setDrawable(viewHolder.adminMessage, uiViewState.isRoundedBackground() ? C2466R.C2467drawable.hs__chat_bubble_rounded : C2466R.C2467drawable.hs__chat_bubble_admin, C2466R.attr.hs__chatBubbleAdminBackgroundColor);
        if (uiViewState.isFooterVisible()) {
            viewHolder.subText.setText(requestScreenshotMessageDM.getSubText());
        }
        setViewVisibility(viewHolder.subText, uiViewState.isFooterVisible());
        viewHolder.attachButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MessageViewDataBinder.MessageItemClickListener messageItemClickListener;
                if (requestScreenshotMessageDM.isAttachmentButtonClickable() && (messageItemClickListener = RequestScreenshotMessageDataBinder.this.messageClickListener) != null) {
                    messageItemClickListener.launchImagePicker(requestScreenshotMessageDM);
                }
            }
        });
        viewHolder.messageLayout.setContentDescription(getAdminMessageContentDesciption(requestScreenshotMessageDM));
        linkify(viewHolder.adminRequestText, new HSLinkify.LinkClickListener() {
            public void onLinkClickFailed() {
                MessageViewDataBinder.MessageItemClickListener messageItemClickListener = RequestScreenshotMessageDataBinder.this.messageClickListener;
                if (messageItemClickListener != null) {
                    messageItemClickListener.onAdminMessageLinkClickFailed();
                }
            }

            public void onLinkClicked(String str) {
                MessageViewDataBinder.MessageItemClickListener messageItemClickListener = RequestScreenshotMessageDataBinder.this.messageClickListener;
                if (messageItemClickListener != null) {
                    messageItemClickListener.onAdminMessageLinkClicked(str, requestScreenshotMessageDM);
                }
            }
        });
        setAuthorAvatar(requestScreenshotMessageDM, viewHolder.avatarImageView);
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__msg_request_screenshot, viewGroup, false));
    }
}
