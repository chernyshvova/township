package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.activeconversation.message.SystemPublishIdMessageDM;
import com.helpshift.util.Styles;

public class SystemPublishIdMessageDataBinder extends MessageViewDataBinder<ViewHolder, SystemPublishIdMessageDM> {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        public final TextView label;

        public ViewHolder(View view) {
            super(view);
            this.label = (TextView) view.findViewById(C2466R.C2468id.issue_publish_id_label);
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            if (SystemPublishIdMessageDataBinder.this.messageClickListener != null) {
                String[] split = ((TextView) view).getText().toString().split("#");
                if (split.length > 1) {
                    SystemPublishIdMessageDataBinder.this.messageClickListener.onCreateContextMenu(contextMenu, split[1]);
                }
            }
        }

        public void setListeners() {
            this.label.setOnCreateContextMenuListener(this);
        }
    }

    public SystemPublishIdMessageDataBinder(Context context) {
        super(context);
    }

    public void bind(ViewHolder viewHolder, SystemPublishIdMessageDM systemPublishIdMessageDM) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
        if (systemPublishIdMessageDM.isFirstMessageInList) {
            layoutParams.topMargin = (int) Styles.dpToPx(this.context, 18.0f);
        } else {
            layoutParams.topMargin = 0;
        }
        viewHolder.itemView.setLayoutParams(layoutParams);
        viewHolder.label.setText(this.context.getString(C2466R.string.hs__conversation_issue_id_header, new Object[]{systemPublishIdMessageDM.body}));
        viewHolder.label.setContentDescription(this.context.getString(C2466R.string.hs__conversation_publish_id_voice_over, new Object[]{systemPublishIdMessageDM.body}));
    }

    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__msg_publish_id_layout, viewGroup, false));
        viewHolder.setListeners();
        return viewHolder;
    }
}
