package com.helpshift.support.conversations.smartintent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.C2466R;
import com.helpshift.conversation.smartintent.BaseIntentUIModel;
import com.helpshift.conversation.smartintent.SearchIntentUIModel;
import com.helpshift.conversation.smartintent.SmartIntentType;
import com.helpshift.util.HSViewUtil;
import com.helpshift.util.Styles;
import java.util.List;

public class SmartIntentsListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public SmartIntentListAdapterCallback callback;
    public List<BaseIntentUIModel> intentUIModels;

    public class RootIntentViewHolder extends ViewHolder {
        public ImageView nextIconView;

        public RootIntentViewHolder(@NonNull View view) {
            super(view);
            this.nextIconView = (ImageView) view.findViewById(C2466R.C2468id.hs__smart_intent_next_icon_view);
        }

        public void bind(BaseIntentUIModel baseIntentUIModel, SmartIntentListAdapterCallback smartIntentListAdapterCallback) {
            super.bind(baseIntentUIModel, smartIntentListAdapterCallback);
            Styles.setColorFilter(this.nextIconView.getContext(), this.nextIconView.getDrawable(), 16842806);
            if (HSViewUtil.isViewDirectionRtl(this.itemView)) {
                this.nextIconView.setRotationY(180.0f);
            }
            this.itemView.setContentDescription(this.itemView.getContext().getString(C2466R.string.hs__si_root_intent_list_item_voice_over, new Object[]{baseIntentUIModel.label}));
        }
    }

    public class SearchResultViewHolder extends ViewHolder {
        public TextView parentLabelTextView;

        public SearchResultViewHolder(@NonNull View view) {
            super(view);
            this.parentLabelTextView = (TextView) view.findViewById(C2466R.C2468id.hs__smart_intent_title_text_View);
        }

        public void bind(BaseIntentUIModel baseIntentUIModel, SmartIntentListAdapterCallback smartIntentListAdapterCallback) {
            super.bind(baseIntentUIModel, smartIntentListAdapterCallback);
            SearchIntentUIModel searchIntentUIModel = (SearchIntentUIModel) baseIntentUIModel;
            this.parentLabelTextView.setText(searchIntentUIModel.parentLabel);
            this.itemView.setContentDescription(searchIntentUIModel.parentLabel + " " + searchIntentUIModel.label);
        }
    }

    public interface SmartIntentListAdapterCallback {
        void onIntentSelected(BaseIntentUIModel baseIntentUIModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView labelTextView;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.labelTextView = (TextView) view.findViewById(C2466R.C2468id.hs__smart_intent_text_View);
        }

        public void bind(final BaseIntentUIModel baseIntentUIModel, final SmartIntentListAdapterCallback smartIntentListAdapterCallback) {
            this.labelTextView.setText(baseIntentUIModel.label);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    smartIntentListAdapterCallback.onIntentSelected(baseIntentUIModel);
                }
            });
            this.itemView.setContentDescription(baseIntentUIModel.label);
        }
    }

    public SmartIntentsListAdapter(List<BaseIntentUIModel> list, SmartIntentListAdapterCallback smartIntentListAdapterCallback) {
        this.intentUIModels = list;
        this.callback = smartIntentListAdapterCallback;
    }

    public BaseIntentUIModel getItem(int i) {
        return this.intentUIModels.get(i);
    }

    public int getItemCount() {
        return this.intentUIModels.size();
    }

    public int getItemViewType(int i) {
        return getItem(i).getType().ordinal();
    }

    public void updateIntentUIModels(List<BaseIntentUIModel> list) {
        this.intentUIModels.clear();
        this.intentUIModels.addAll(list);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(getItem(i), this.callback);
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        SmartIntentType smartIntentType = SmartIntentType.ROOT_INTENT;
        if (i == 0) {
            return new RootIntentViewHolder(from.inflate(C2466R.layout.hs__list_item_smart_intent, viewGroup, false));
        }
        SmartIntentType smartIntentType2 = SmartIntentType.LEAF_INTENT;
        if (i == 1) {
            return new ViewHolder(from.inflate(C2466R.layout.hs__list_item_leaf_intent, viewGroup, false));
        }
        SmartIntentType smartIntentType3 = SmartIntentType.SEARCH_INTENT;
        if (i == 2) {
            return new SearchResultViewHolder(from.inflate(C2466R.layout.hs__list_item_search_intent, viewGroup, false));
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline14("Unknown smart intent type : ", i));
    }
}
