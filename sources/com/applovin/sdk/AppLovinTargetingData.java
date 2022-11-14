package com.applovin.sdk;

import androidx.annotation.Nullable;
import java.util.List;

public interface AppLovinTargetingData {
    void clearAll();

    @Nullable
    String getEmail();

    @Nullable
    AppLovinGender getGender();

    @Nullable
    List<String> getInterests();

    @Nullable
    List<String> getKeywords();

    @Nullable
    AppLovinAdContentRating getMaximumAdContentRating();

    @Nullable
    String getPhoneNumber();

    @Nullable
    Integer getYearOfBirth();

    void setEmail(@Nullable String str);

    void setGender(@Nullable AppLovinGender appLovinGender);

    void setInterests(@Nullable List<String> list);

    void setKeywords(@Nullable List<String> list);

    void setMaximumAdContentRating(@Nullable AppLovinAdContentRating appLovinAdContentRating);

    void setPhoneNumber(@Nullable String str);

    void setYearOfBirth(@Nullable Integer num);
}
