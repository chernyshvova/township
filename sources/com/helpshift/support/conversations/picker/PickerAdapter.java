package com.helpshift.support.conversations.picker;

import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.C2466R;
import com.helpshift.conversation.viewmodel.HSRange;
import com.helpshift.conversation.viewmodel.OptionUIModel;
import com.helpshift.support.conversations.ConversationalFragmentRouter;
import com.helpshift.util.ListUtils;
import com.helpshift.util.Styles;
import java.util.List;

public class PickerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public ConversationalFragmentRouter conversationalFragmentRouter;
    public List<OptionUIModel> options;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View layoutView;
        public final TextView optionView = ((TextView) this.itemView.findViewById(C2466R.C2468id.hs__option));

        public ViewHolder(View view) {
            super(view);
            View findViewById = this.itemView.findViewById(C2466R.C2468id.option_list_item_layout);
            this.layoutView = findViewById;
            findViewById.setOnClickListener(this);
        }

        public void onClick(View view) {
            PickerAdapter pickerAdapter = PickerAdapter.this;
            ConversationalFragmentRouter conversationalFragmentRouter = pickerAdapter.conversationalFragmentRouter;
            if (conversationalFragmentRouter != null) {
                conversationalFragmentRouter.handleOptionSelectedForPicker((OptionUIModel) pickerAdapter.options.get(getAdapterPosition()), false);
            }
        }
    }

    public PickerAdapter(List<OptionUIModel> list, ConversationalFragmentRouter conversationalFragmentRouter2) {
        this.options = list;
        this.conversationalFragmentRouter = conversationalFragmentRouter2;
    }

    public void dispatchUpdates(List<OptionUIModel> list) {
        this.options.clear();
        this.options.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.options.size();
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        OptionUIModel optionUIModel = this.options.get(i);
        String str = optionUIModel.option.title;
        if (ListUtils.isEmpty(optionUIModel.titleHighlightInfo)) {
            viewHolder.optionView.setText(str);
        } else {
            int color = Styles.getColor(viewHolder.optionView.getContext(), C2466R.attr.hs__searchHighlightColor);
            SpannableString spannableString = new SpannableString(str);
            for (HSRange next : optionUIModel.titleHighlightInfo) {
                BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(color);
                int i2 = next.index;
                spannableString.setSpan(backgroundColorSpan, i2, next.length + i2, 33);
            }
            viewHolder.optionView.setText(spannableString);
        }
        viewHolder.layoutView.setContentDescription(viewHolder.optionView.getContext().getString(C2466R.string.hs__picker_option_list_item_voice_over, new Object[]{str}));
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2466R.layout.hs__picker_option, viewGroup, false));
    }
}
