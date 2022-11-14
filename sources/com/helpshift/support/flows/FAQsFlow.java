package com.helpshift.support.flows;

import androidx.annotation.NonNull;
import com.helpshift.support.ApiConfig;
import com.helpshift.support.SupportInternal;
import com.helpshift.support.controllers.SupportController;
import com.helpshift.support.util.ConfigUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FAQsFlow implements Flow {
    public final HashMap config;
    public final String label;
    public final int labelResId;
    public SupportController supportController;

    public FAQsFlow(int i) {
        this(i, (Map) new HashMap());
    }

    public String getLabel() {
        return this.label;
    }

    public int getLabelResId() {
        return this.labelResId;
    }

    public void performAction() {
        this.supportController.startFaqFlow(SupportInternal.cleanConfig(this.config), true, (List) this.config.get("customContactUsFlows"));
    }

    public void setSupportController(SupportController supportController2) {
        this.supportController = supportController2;
    }

    public FAQsFlow(int i, Map map) {
        this.labelResId = i;
        this.config = new HashMap(map);
        this.label = null;
    }

    public FAQsFlow(int i, @NonNull ApiConfig apiConfig) {
        this(i, (Map) ConfigUtil.validateAndConvertToMap(apiConfig));
    }

    public FAQsFlow(String str) {
        this(str, (Map) new HashMap());
    }

    public FAQsFlow(String str, Map map) {
        this.label = str;
        this.config = new HashMap(map);
        this.labelResId = 0;
    }

    public FAQsFlow(@NonNull String str, @NonNull ApiConfig apiConfig) {
        this(str, (Map) ConfigUtil.validateAndConvertToMap(apiConfig));
    }
}
