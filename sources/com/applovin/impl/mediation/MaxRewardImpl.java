package com.applovin.impl.mediation;

import androidx.annotation.NonNull;
import com.applovin.mediation.MaxReward;

public class MaxRewardImpl implements MaxReward {

    /* renamed from: a */
    public final String f560a;

    /* renamed from: b */
    public final int f561b;

    public MaxRewardImpl(int i, String str) {
        if (i >= 0) {
            this.f560a = str;
            this.f561b = i;
            return;
        }
        throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
    }

    public static MaxReward create(int i, String str) {
        return new MaxRewardImpl(i, str);
    }

    public static MaxReward createDefault() {
        return create(0, "");
    }

    public final int getAmount() {
        return this.f561b;
    }

    public final String getLabel() {
        return this.f560a;
    }

    @NonNull
    public String toString() {
        return "MaxReward{}";
    }
}
