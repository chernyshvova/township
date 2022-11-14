package com.helpshift.support.conversations.smartintent;

import android.view.View;
import com.helpshift.conversation.smartintent.LeafIntentUIModel;
import com.helpshift.conversation.smartintent.RootIntentUIModel;
import com.helpshift.conversation.smartintent.SearchIntentUIModel;

public interface SmartIntentRouter {
    void onLeafIntentSelected(LeafIntentUIModel leafIntentUIModel);

    void onRootIntentSelected(RootIntentUIModel rootIntentUIModel);

    void onSearchIntentSelected(SearchIntentUIModel searchIntentUIModel);

    void onSmartIntentBackButtonPressed();

    void onSmartIntentBottomSheetCollapsed();

    void onSmartIntentBottomSheetExpanded();

    void onSmartIntentSendButtonClick();

    void onSmartIntentTextChanged(CharSequence charSequence);

    void removeSmartIntentViewFromBottomSheet();

    void showSmartIntentViewInBottomSheet(View view, int i);
}
