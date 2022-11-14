package com.applovin.mediation.adapter.parameters;

import android.os.Bundle;
import java.util.Map;

public interface MaxAdapterParameters {
    String getAdUnitId();

    Map<String, Object> getLocalExtraParameters();

    Bundle getServerParameters();

    Boolean hasUserConsent();

    Boolean isAgeRestrictedUser();

    Boolean isDoNotSell();

    boolean isTesting();
}
