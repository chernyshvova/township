package com.helpshift.common.platform;

import android.content.Context;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.conversation.smartintent.dao.SmartIntentDAO;
import com.helpshift.conversation.smartintent.dto.SISearchModelDTO;
import com.helpshift.conversation.smartintent.dto.SITreeDTO;
import com.helpshift.p042db.conversation.smartintent.SmartIntentDB;
import java.util.List;

public class AndroidSmartIntentDAO implements SmartIntentDAO {
    public static final String TAG = "Helpshift_SIDBDao";
    public final SmartIntentDB smartIntentDB;

    public AndroidSmartIntentDAO(Context context) {
        this.smartIntentDB = SmartIntentDB.getInstance(context);
    }

    public boolean deleteModel(long j) {
        return this.smartIntentDB.deleteModel(j);
    }

    public boolean deleteTreeAndModel(UserDM userDM) {
        return this.smartIntentDB.deleteTreeAndModel(userDM);
    }

    public SISearchModelDTO getModelWithoutWordProbabilities(long j) {
        return this.smartIntentDB.getModelWithoutWordProbabilities(j);
    }

    public SITreeDTO getTree(UserDM userDM) {
        return this.smartIntentDB.getSmartIntentTree(userDM.getLocalId().longValue());
    }

    public List<Double> getWordToIntentProbabilities(long j, String str) {
        return this.smartIntentDB.getWordToIntentProbabilities(j, str);
    }

    public boolean insertModel(long j, SISearchModelDTO sISearchModelDTO) {
        return this.smartIntentDB.insertModel(j, sISearchModelDTO);
    }

    public boolean insertTree(UserDM userDM, SITreeDTO sITreeDTO) {
        return this.smartIntentDB.insertTree(userDM, sITreeDTO);
    }

    public boolean updateModelLastRefreshedAtTime(long j, long j2) {
        return this.smartIntentDB.updateModelRefreshedAt(j, j2);
    }

    public boolean updateTreeLastRefreshedAtTime(UserDM userDM, long j) {
        return this.smartIntentDB.updateTreeRefreshedAt(userDM, j);
    }
}
