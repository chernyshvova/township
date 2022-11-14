package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.support.util.Styles;

public class AgentTypingMessageDataBinder {
    public Context context;

    public final class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout typingContainer;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.typingContainer = (LinearLayout) view.findViewById(C2466R.C2468id.agent_typing_container);
        }
    }

    public AgentTypingMessageDataBinder(Context context2) {
        this.context = context2;
    }

    public void bind(ViewHolder viewHolder, boolean z) {
        if (z) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.typingContainer.getLayoutParams();
            marginLayoutParams.setMargins((int) this.context.getResources().getDimension(C2466R.dimen.hs__author_avatar_size), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    public RecyclerView.ViewHolder createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.context).inflate(C2466R.layout.hs__msg_agent_typing, viewGroup, false);
        Styles.setAdminChatBubbleColor(this.context, inflate.findViewById(C2466R.C2468id.agent_typing_container).getBackground());
        return new ViewHolder(inflate);
    }
}
