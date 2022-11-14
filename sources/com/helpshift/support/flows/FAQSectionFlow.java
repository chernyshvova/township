package com.helpshift.support.flows;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.helpshift.support.ApiConfig;
import com.helpshift.support.SupportInternal;
import com.helpshift.support.controllers.SupportController;
import com.helpshift.support.fragments.SupportFragment;
import com.helpshift.support.util.ConfigUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FAQSectionFlow implements Flow {
    public final HashMap config;
    public final String label;
    public final int labelResId;
    public final String sectionPublishId;
    public SupportController supportController;

    public FAQSectionFlow(int i, String str) {
        this(i, str, (Map) new HashMap());
    }

    public String getLabel() {
        return this.label;
    }

    public int getLabelResId() {
        return this.labelResId;
    }

    public void performAction() {
        Bundle cleanConfig = SupportInternal.cleanConfig(SupportInternal.removeFAQFlowUnsupportedConfigs(this.config));
        cleanConfig.putString("sectionPublishId", this.sectionPublishId);
        cleanConfig.putInt(SupportFragment.SUPPORT_MODE, 2);
        this.supportController.startFaqFlow(cleanConfig, true, (List) this.config.get("customContactUsFlows"));
    }

    public void setSupportController(SupportController supportController2) {
        this.supportController = supportController2;
    }

    public FAQSectionFlow(int i, String str, Map map) {
        this.labelResId = i;
        this.sectionPublishId = str;
        this.config = new HashMap(map);
        this.label = null;
    }

    public FAQSectionFlow(int i, @NonNull String str, @NonNull ApiConfig apiConfig) {
        this(i, str, (Map) ConfigUtil.validateAndConvertToMap(apiConfig));
    }

    public FAQSectionFlow(String str, String str2) {
        this(str, str2, (Map) new HashMap());
    }

    public FAQSectionFlow(String str, String str2, Map map) {
        this.label = str;
        this.sectionPublishId = str2;
        this.config = new HashMap(map);
        this.labelResId = 0;
    }

    public FAQSectionFlow(String str, @NonNull String str2, @NonNull ApiConfig apiConfig) {
        this(str, str2, (Map) ConfigUtil.validateAndConvertToMap(apiConfig));
    }
}
