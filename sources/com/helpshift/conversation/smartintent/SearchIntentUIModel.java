package com.helpshift.conversation.smartintent;

public class SearchIntentUIModel extends BaseIntentUIModel {
    public Double confidence;
    public final String parentLabel;
    public int rank;

    public SearchIntentUIModel(long j, String str, String str2) {
        super(j, str);
        this.parentLabel = str2;
    }

    public SearchIntentUIModel deepClone() {
        SearchIntentUIModel searchIntentUIModel = new SearchIntentUIModel(this.localId, this.label, this.parentLabel);
        searchIntentUIModel.rank = this.rank;
        searchIntentUIModel.confidence = this.confidence;
        return searchIntentUIModel;
    }

    public SmartIntentType getType() {
        return SmartIntentType.SEARCH_INTENT;
    }
}
