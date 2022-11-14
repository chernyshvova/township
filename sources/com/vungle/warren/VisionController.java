package com.vungle.warren;

import android.annotation.TargetApi;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.VisionData;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.NetworkProvider;
import com.vungle.warren.vision.VisionAggregationData;
import com.vungle.warren.vision.VisionAggregationInfo;
import com.vungle.warren.vision.VisionConfig;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VisionController {
    public static final String ADVERTISER_DETAILS = "advertiser_details";
    public static final String AGGREGATE = "aggregate";
    public static final String CAMPAIGN_DETAILS = "campaign_details";
    public static final String CREATIVE_DETAILS = "creative_details";
    public static final String DATA_SCIENCE_CACHE = "data_science_cache";
    public static final String FILTER_ID = "_id";
    public static final String LAST_TIME_VIEWED = "last_time_viewed";
    public static final String LAST_VIEWED_ADVERTISER_ID = "last_viewed_advertiser_id";
    public static final String LAST_VIEWED_CAMPAIGN_ID = "last_viewed_campaign_id";
    public static final String LAST_VIEWED_CREATIVE_ID = "last_viewed_creative_id";
    public static final String TOTAL_VIEW_COUNT = "total_view_count";
    public static final String VIEW_COUNT = "view_count";
    public static final String VISION = "vision";
    public static final String VISION_COOKIE = "visionCookie";
    public static final String WINDOW = "window";
    @NonNull
    public VisionConfig config = new VisionConfig();
    @NonNull
    public final NetworkProvider networkProvider;
    @NonNull
    public final Repository repository;

    public VisionController(@NonNull Repository repository2, @NonNull NetworkProvider networkProvider2) {
        this.repository = repository2;
        this.networkProvider = networkProvider2;
    }

    @Nullable
    private String getDataScienceCache() {
        Cookie cookie = this.repository.load(VISION_COOKIE, Cookie.class).get();
        if (cookie == null) {
            return null;
        }
        return cookie.getString(DATA_SCIENCE_CACHE);
    }

    public void clearData() throws DatabaseHelper.DBException {
        this.repository.trimVisionData(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043 A[RETURN] */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getFilterName(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1329100269(0xffffffffb0c78a13, float:-1.4518399E-9)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 1272113586(0x4bd2e9b2, float:2.7644772E7)
            if (r0 == r1) goto L_0x0020
            r1 = 1845893934(0x6e061b2e, float:1.0375962E28)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "advertiser_details"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "creative_details"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "campaign_details"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == 0) goto L_0x0043
            if (r5 == r3) goto L_0x0040
            if (r5 == r2) goto L_0x003d
            r5 = 0
            return r5
        L_0x003d:
            java.lang.String r5 = "advertiser"
            return r5
        L_0x0040:
            java.lang.String r5 = "campaign"
            return r5
        L_0x0043:
            java.lang.String r5 = "creative"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.VisionController.getFilterName(java.lang.String):java.lang.String");
    }

    @TargetApi(21)
    @NonNull
    public JsonObject getPayload() {
        int i;
        int i2;
        VisionController visionController = this;
        JsonObject jsonObject = new JsonObject();
        String dataScienceCache = getDataScienceCache();
        if (dataScienceCache != null) {
            jsonObject.addProperty(DATA_SCIENCE_CACHE, dataScienceCache);
        }
        if (visionController.config.viewLimit != null) {
            int currentNetworkType = visionController.networkProvider.getCurrentNetworkType();
            if (currentNetworkType != 0) {
                if (currentNetworkType != 1) {
                    if (currentNetworkType != 4) {
                        if (currentNetworkType != 9) {
                            if (currentNetworkType != 17) {
                                if (currentNetworkType != 6) {
                                    if (currentNetworkType != 7) {
                                        i = visionController.config.viewLimit.device;
                                    }
                                }
                            }
                        }
                    }
                }
                VisionConfig.Limits limits = visionController.config.viewLimit;
                i2 = limits.wifi;
                if (i2 <= 0) {
                    i = limits.device;
                }
                i = i2;
            }
            VisionConfig.Limits limits2 = visionController.config.viewLimit;
            i2 = limits2.mobile;
            if (i2 <= 0) {
                i = limits2.device;
            }
            i = i2;
        } else {
            i = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JsonArray jsonArray = new JsonArray();
        jsonObject.members.put(AGGREGATE, jsonArray);
        int[] iArr = visionController.config.aggregationTimeWindows;
        if (iArr != null) {
            int length = iArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = iArr[i3];
                long millis = currentTimeMillis - TimeUnit.DAYS.toMillis((long) i4);
                VisionAggregationInfo visionAggregationInfo = visionController.repository.getVisionAggregationInfo(millis).get();
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty(WINDOW, (Number) Integer.valueOf(i4));
                jsonObject2.addProperty(LAST_VIEWED_CREATIVE_ID, visionAggregationInfo != null ? visionAggregationInfo.lastCreative : null);
                jsonObject2.addProperty(TOTAL_VIEW_COUNT, (Number) Integer.valueOf(visionAggregationInfo != null ? visionAggregationInfo.totalCount : 0));
                String[] strArr = visionController.config.aggregationFilters;
                if (strArr != null) {
                    int length2 = strArr.length;
                    int i5 = 0;
                    while (i5 < length2) {
                        String str = strArr[i5];
                        long j = currentTimeMillis;
                        JsonArray jsonArray2 = new JsonArray();
                        jsonObject2.add(str, jsonArray2);
                        String filterName = visionController.getFilterName(str);
                        List<VisionAggregationData> list = visionController.repository.getVisionAggregationData(millis, i, filterName).get();
                        if (list != null) {
                            for (VisionAggregationData visionAggregationData : list) {
                                int i6 = i;
                                JsonObject jsonObject3 = new JsonObject();
                                jsonObject3.addProperty(GeneratedOutlineSupport.outline16(filterName, "_id"), visionAggregationData.f2853id);
                                jsonObject3.addProperty(VIEW_COUNT, (Number) Integer.valueOf(visionAggregationData.viewCount));
                                jsonObject3.addProperty(LAST_TIME_VIEWED, (Number) Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(visionAggregationData.lastTimeStamp)));
                                jsonArray2.elements.add(jsonObject3);
                                i = i6;
                                iArr = iArr;
                                filterName = filterName;
                                length = length;
                            }
                        }
                        i5++;
                        visionController = this;
                        currentTimeMillis = j;
                        i = i;
                        iArr = iArr;
                        length = length;
                    }
                }
                jsonArray.elements.add(jsonObject2);
                i3++;
                visionController = this;
                currentTimeMillis = currentTimeMillis;
                i = i;
                iArr = iArr;
                length = length;
            }
        }
        return jsonObject;
    }

    @VisibleForTesting
    public VisionConfig getVisionConfig() {
        return this.config;
    }

    public boolean isEnabled() {
        return this.config.enabled;
    }

    public void reportData(@NonNull String str, @NonNull String str2, @NonNull String str3) throws DatabaseHelper.DBException {
        this.repository.save(new VisionData(System.currentTimeMillis(), str, str2, str3));
        Repository repository2 = this.repository;
        VisionConfig.Limits limits = this.config.viewLimit;
        repository2.trimVisionData(limits != null ? limits.device : 0);
    }

    public void setConfig(@NonNull VisionConfig visionConfig) throws DatabaseHelper.DBException {
        this.config = visionConfig;
        if (visionConfig.enabled) {
            Repository repository2 = this.repository;
            VisionConfig.Limits limits = visionConfig.viewLimit;
            repository2.trimVisionData(limits != null ? limits.device : 0);
        }
    }

    public void setDataScienceCache(@Nullable String str) throws DatabaseHelper.DBException {
        Cookie cookie = new Cookie(VISION_COOKIE);
        if (str != null) {
            cookie.putValue(DATA_SCIENCE_CACHE, str);
        }
        this.repository.save(cookie);
    }
}
