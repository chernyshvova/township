package com.vungle.warren.tasks;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.vungle.warren.analytics.AdAnalytics;
import com.vungle.warren.tasks.JobInfo;

public class AnalyticsJob implements Job {
    public static final long DEFAULT_DELAY = 2000;
    public static final String EXTRA_ACTION = "action_extra";
    public static final String EXTRA_BODY = "extra_body";
    public static final String EXTRA_URLS = "extra_urls";
    public static final String TAG = "AnalyticsJob";
    public final AdAnalytics adAnalytics;

    public @interface Action {
        public static final int PING = 1;
        public static final int RETRY_UNSENT = 2;

        /* renamed from: RI */
        public static final int f2850RI = 0;
        public static final int STORE_URL = 3;
    }

    public AnalyticsJob(AdAnalytics adAnalytics2) {
        this.adAnalytics = adAnalytics2;
    }

    public static JobInfo makeJob(@Action int i, String str, String[] strArr, @JobInfo.NetworkType int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_ACTION, i);
        bundle.putString(EXTRA_BODY, str);
        bundle.putStringArray(EXTRA_URLS, strArr);
        return new JobInfo(TAG).setUpdateCurrent(false).setExtras(bundle).setReschedulePolicy(2000, 1).setRequiredNetworkType(i2).setPriority(5);
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        String[] stringArray;
        int i = bundle.getInt(EXTRA_ACTION, -1);
        if (i == 0) {
            this.adAnalytics.mo21860ri(((JsonElement) new Gson().fromJson(bundle.getString(EXTRA_BODY), JsonElement.class)).getAsJsonObject());
            return 0;
        } else if (i == 1) {
            String[] stringArray2 = bundle.getStringArray(EXTRA_URLS);
            if (stringArray2 == null) {
                return 0;
            }
            String[] ping = this.adAnalytics.ping(stringArray2);
            if (ping.length == 0) {
                return 0;
            }
            bundle.putStringArray(EXTRA_URLS, ping);
            return 2;
        } else if (i == 2) {
            String[] retryUnsent = this.adAnalytics.retryUnsent();
            if (retryUnsent.length == 0) {
                return 0;
            }
            bundle.putStringArray(EXTRA_URLS, retryUnsent);
            return 2;
        } else if (i != 3 || (stringArray = bundle.getStringArray(EXTRA_URLS)) == null) {
            return 0;
        } else {
            this.adAnalytics.saveVungleUrls(stringArray);
            return 0;
        }
    }
}
