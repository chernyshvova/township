package com.vungle.warren.vision;

import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

public class VisionConfig {
    @SerializedName("aggregation_filters")
    @Nullable
    public String[] aggregationFilters;
    @SerializedName("aggregation_time_windows")
    @Nullable
    public int[] aggregationTimeWindows;
    @SerializedName("enabled")
    public boolean enabled;
    @SerializedName("view_limit")
    @Nullable
    public Limits viewLimit;

    public static class Limits {
        @SerializedName("device")
        public int device;
        @SerializedName("mobile")
        public int mobile;
        @SerializedName("wifi")
        public int wifi;
    }
}
