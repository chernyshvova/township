package com.swrve.sdk.messaging;

import androidx.annotation.Nullable;
import java.util.Map;

public interface SwrveMessagePersonalizationProvider {
    Map<String, String> personalize(@Nullable Map<String, String> map);
}
