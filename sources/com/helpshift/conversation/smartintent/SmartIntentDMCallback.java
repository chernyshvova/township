package com.helpshift.conversation.smartintent;

import androidx.annotation.NonNull;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.conversation.smartintent.dto.SITreeDTO;

public interface SmartIntentDMCallback {
    void onTreeAvailable(@NonNull UserDM userDM, @NonNull SITreeDTO sITreeDTO);

    void onTreeUnAvailable(@NonNull UserDM userDM);
}
