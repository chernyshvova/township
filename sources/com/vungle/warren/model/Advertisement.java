package com.vungle.warren.model;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.ServerProtocol;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.vungle.warren.AdConfig;
import com.vungle.warren.VungleLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

public class Advertisement implements Comparable<Advertisement> {
    public static final int DONE = 3;
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int ERROR = 4;
    public static final String FILE_SCHEME = "file://";
    public static final String INCENTIVIZED_BODY_TEXT = "INCENTIVIZED_BODY_TEXT";
    public static final String INCENTIVIZED_CLOSE_TEXT = "INCENTIVIZED_CLOSE_TEXT";
    public static final String INCENTIVIZED_CONTINUE_TEXT = "INCENTIVIZED_CONTINUE_TEXT";
    public static final String INCENTIVIZED_TITLE_TEXT = "INCENTIVIZED_TITLE_TEXT";
    public static final int INVALID = 5;
    public static final String KEY_POSTROLL = "postroll";
    public static final String KEY_TEMPLATE = "template";
    public static final String KEY_VIDEO = "video";
    public static final int LANDSCAPE = 1;
    public static final String MRAID_ARGS = "mraid_args";
    public static final int NEW = 0;
    public static final int PORTRAIT = 0;
    public static final int READY = 1;
    public static final String START_MUTED = "START_MUTED";
    public static final Collection<String> STATIC_TPAT_EVENTS = Arrays.asList(new String[]{"play_percentage", "checkpoint.0", "checkpoint.25", "checkpoint.50", "checkpoint.75", "checkpoint.100"});
    public static final String TAG = "Advertisement";
    public static final int TYPE_VUNGLE_LOCAL = 0;
    public static final int TYPE_VUNGLE_MRAID = 1;
    public static final String UNKNOWN = "unknown";
    public static final int VIEWING = 2;
    public AdConfig adConfig;
    public String adMarketId;
    @VisibleForTesting
    public long adRequestStartTime;
    public String adToken;
    @AdType
    public int adType;
    public String appID;
    @VisibleForTesting
    public long assetDownloadDuration;
    @VisibleForTesting
    public long assetDownloadStartTime;
    public boolean assetsFullyDownloaded = false;
    public String bidToken;
    public Map<String, Pair<String, String>> cacheableAssets = new HashMap();
    public String campaign;
    public List<Checkpoint> checkpoints;
    public int countdown;
    public boolean ctaClickArea = true;
    public String ctaDestinationUrl;
    public boolean ctaOverlayEnabled;
    public String ctaUrl;
    public int delay;
    public Map<String, ArrayList<String>> dynamicEventsAndUrls = new LinkedTreeMap();
    public boolean enableOm;
    public long expireTime;
    public Gson gson = new Gson();
    public String identifier;
    public Map<String, String> incentivizedTextSettings = new HashMap();
    public String md5;
    public Map<String, String> mraidFiles = new HashMap();
    @Nullable
    public String omExtraVast;
    public String placementId;
    public String postrollBundleUrl;
    public boolean requiresNonMarketInstall;
    public int retryCount;
    public long serverRequestTimestamp;
    public int showCloseDelay;
    public int showCloseIncentivized;
    public int state = 0;
    public String templateId;
    public Map<String, String> templateSettings;
    public String templateType;
    public String templateUrl;
    public long ttDownload;
    public int videoHeight;
    public String videoIdentifier;
    public String videoUrl;
    public int videoWidth;

    public @interface AdType {
    }

    public @interface CacheKey {
    }

    public static class Checkpoint implements Comparable<Checkpoint> {
        @SerializedName("percentage")
        public byte percentage;
        @SerializedName("urls")
        public String[] urls;

        public Checkpoint(JsonObject jsonObject) throws IllegalArgumentException {
            if (JsonUtil.hasNonNull(jsonObject, "checkpoint")) {
                this.percentage = (byte) ((int) (jsonObject.get("checkpoint").getAsFloat() * 100.0f));
                if (JsonUtil.hasNonNull(jsonObject, "urls")) {
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("urls");
                    this.urls = new String[asJsonArray.size()];
                    for (int i = 0; i < asJsonArray.size(); i++) {
                        if (asJsonArray.get(i) == null || "null".equalsIgnoreCase(asJsonArray.get(i).toString())) {
                            this.urls[i] = "";
                        } else {
                            this.urls[i] = asJsonArray.get(i).getAsString();
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("Checkpoint missing reporting URL!");
            }
            throw new IllegalArgumentException("Checkpoint missing percentage!");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Checkpoint)) {
                return false;
            }
            Checkpoint checkpoint = (Checkpoint) obj;
            if (checkpoint.percentage != this.percentage || checkpoint.urls.length != this.urls.length) {
                return false;
            }
            int i = 0;
            while (true) {
                String[] strArr = this.urls;
                if (i >= strArr.length) {
                    return true;
                }
                if (!checkpoint.urls[i].equals(strArr[i])) {
                    return false;
                }
                i++;
            }
        }

        public byte getPercentage() {
            return this.percentage;
        }

        public String[] getUrls() {
            return (String[]) this.urls.clone();
        }

        public int hashCode() {
            String[] strArr = this.urls;
            return (((this.percentage * 31) + strArr.length) * 31) + Arrays.hashCode(strArr);
        }

        public int compareTo(@NonNull Checkpoint checkpoint) {
            return Float.compare((float) this.percentage, (float) checkpoint.percentage);
        }

        public Checkpoint(JsonArray jsonArray, byte b) {
            if (jsonArray.size() != 0) {
                this.urls = new String[jsonArray.size()];
                for (int i = 0; i < jsonArray.size(); i++) {
                    this.urls[i] = jsonArray.get(i).getAsString();
                }
                this.percentage = b;
                return;
            }
            throw new IllegalArgumentException("Empty URLS!");
        }
    }

    public @interface Orientation {
    }

    public @interface State {
    }

    public Advertisement() {
    }

    private boolean isValidUrl(String str) {
        return !TextUtils.isEmpty(str) && HttpUrl.parse(str) != null;
    }

    public void configure(AdConfig adConfig2) {
        if (adConfig2 == null) {
            this.adConfig = new AdConfig();
        } else {
            this.adConfig = adConfig2;
        }
    }

    public JsonObject createMRAIDArgs() {
        if (this.templateSettings != null) {
            HashMap hashMap = new HashMap(this.templateSettings);
            for (Map.Entry next : this.cacheableAssets.entrySet()) {
                hashMap.put(next.getKey(), ((Pair) next.getValue()).first);
            }
            if (!this.mraidFiles.isEmpty()) {
                hashMap.putAll(this.mraidFiles);
            }
            if (!this.incentivizedTextSettings.isEmpty()) {
                hashMap.putAll(this.incentivizedTextSettings);
            }
            String str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            if (!str.equalsIgnoreCase((String) hashMap.get(START_MUTED))) {
                if ((getAdConfig().getSettings() & 1) == 0) {
                    str = "false";
                }
                hashMap.put(START_MUTED, str);
            }
            JsonObject jsonObject = new JsonObject();
            for (Map.Entry entry : hashMap.entrySet()) {
                jsonObject.addProperty((String) entry.getKey(), (String) entry.getValue());
            }
            VungleLogger.verbose(true, TAG, MRAID_ARGS, jsonObject.toString());
            return jsonObject;
        }
        throw new IllegalArgumentException("Advertisement does not have MRAID Arguments!");
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Advertisement)) {
            return false;
        }
        Advertisement advertisement = (Advertisement) obj;
        if (advertisement.adType != this.adType || advertisement.delay != this.delay || advertisement.showCloseDelay != this.showCloseDelay || advertisement.showCloseIncentivized != this.showCloseIncentivized || advertisement.countdown != this.countdown || advertisement.videoWidth != this.videoWidth || advertisement.videoHeight != this.videoHeight || advertisement.ctaOverlayEnabled != this.ctaOverlayEnabled || advertisement.ctaClickArea != this.ctaClickArea || advertisement.retryCount != this.retryCount || advertisement.enableOm != this.enableOm || advertisement.requiresNonMarketInstall != this.requiresNonMarketInstall || advertisement.state != this.state || (str = advertisement.identifier) == null || (str2 = this.identifier) == null || !str.equals(str2) || !advertisement.campaign.equals(this.campaign) || !advertisement.videoUrl.equals(this.videoUrl) || !advertisement.md5.equals(this.md5) || !advertisement.postrollBundleUrl.equals(this.postrollBundleUrl) || !advertisement.ctaDestinationUrl.equals(this.ctaDestinationUrl) || !advertisement.ctaUrl.equals(this.ctaUrl) || !advertisement.adToken.equals(this.adToken) || !advertisement.videoIdentifier.equals(this.videoIdentifier)) {
            return false;
        }
        String str3 = advertisement.omExtraVast;
        if (str3 == null ? this.omExtraVast != null : !str3.equals(this.omExtraVast)) {
            return false;
        }
        if (!advertisement.adMarketId.equals(this.adMarketId) || !advertisement.bidToken.equals(this.bidToken) || advertisement.checkpoints.size() != this.checkpoints.size()) {
            return false;
        }
        for (int i = 0; i < this.checkpoints.size(); i++) {
            if (!advertisement.checkpoints.get(i).equals(this.checkpoints.get(i))) {
                return false;
            }
        }
        return this.dynamicEventsAndUrls.equals(advertisement.dynamicEventsAndUrls) && advertisement.serverRequestTimestamp == this.serverRequestTimestamp;
    }

    public AdConfig getAdConfig() {
        return this.adConfig;
    }

    public String getAdMarketId() {
        return this.adMarketId;
    }

    public String getAdToken() {
        return this.adToken;
    }

    @AdType
    public int getAdType() {
        return this.adType;
    }

    public String getAdvertiserAppId() {
        String appID2 = getAppID();
        String appID3 = getAppID();
        if (appID3 != null && appID3.length() > 3) {
            try {
                JSONObject jSONObject = new JSONObject(appID3.substring(3));
                appID2 = jSONObject.isNull("app_id") ? null : jSONObject.optString("app_id", (String) null);
            } catch (JSONException e) {
                Log.e(TAG, "JsonException : ", e);
            }
        }
        return TextUtils.isEmpty(appID2) ? "unknown" : appID2;
    }

    public String getAppID() {
        return this.appID;
    }

    public long getAssetDownloadDuration() {
        return this.assetDownloadDuration;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    @Nullable
    public String getCTAURL(boolean z) {
        int i = this.adType;
        if (i == 0) {
            return z ? this.ctaUrl : this.ctaDestinationUrl;
        }
        if (i == 1) {
            return this.ctaUrl;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unknown AdType ");
        outline24.append(this.adType);
        throw new IllegalArgumentException(outline24.toString());
    }

    public String getCampaign() {
        return this.campaign;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCampaignId() {
        /*
            r3 = this;
            java.lang.String r0 = r3.getCampaign()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "\\|"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r2 = 1
            if (r1 < r2) goto L_0x0018
            r1 = 0
            r0 = r0[r1]
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0021
            java.lang.String r0 = "unknown"
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Advertisement.getCampaignId():java.lang.String");
    }

    public List<Checkpoint> getCheckpoints() {
        return this.checkpoints;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCreativeId() {
        /*
            r3 = this;
            java.lang.String r0 = r3.getCampaign()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "\\|"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r2 = 2
            if (r1 < r2) goto L_0x0018
            r1 = 1
            r0 = r0[r1]
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0021
            java.lang.String r0 = "unknown"
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Advertisement.getCreativeId():java.lang.String");
    }

    public boolean getCtaClickArea() {
        return this.ctaClickArea;
    }

    public Map<String, String> getDownloadableUrls() {
        HashMap hashMap = new HashMap();
        int i = this.adType;
        if (i == 0) {
            hashMap.put("video", this.videoUrl);
            if (!TextUtils.isEmpty(this.postrollBundleUrl)) {
                hashMap.put(KEY_POSTROLL, this.postrollBundleUrl);
            }
        } else if (i == 1) {
            hashMap.put("template", this.templateUrl);
            for (Map.Entry<String, Pair<String, String>> value : this.cacheableAssets.entrySet()) {
                String str = (String) ((Pair) value.getValue()).first;
                if (isValidUrl(str)) {
                    hashMap.put(URLUtil.guessFileName(str, (String) null, (String) null), str);
                }
            }
        } else {
            throw new IllegalStateException("Advertisement created without adType!");
        }
        return hashMap;
    }

    public long getExpireTime() {
        return this.expireTime * 1000;
    }

    @NonNull
    public String getId() {
        String str = this.identifier;
        return str == null ? "" : str;
    }

    public boolean getOmEnabled() {
        return this.enableOm;
    }

    @Nullable
    public String getOmExtraVast() {
        return this.omExtraVast;
    }

    @Orientation
    public int getOrientation() {
        return this.videoWidth > this.videoHeight ? 1 : 0;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public long getServerRequestTimestamp() {
        return this.serverRequestTimestamp;
    }

    public int getShowCloseDelay(boolean z) {
        int i;
        if (z) {
            i = this.showCloseIncentivized;
        } else {
            i = this.showCloseDelay;
        }
        return i * 1000;
    }

    @State
    public int getState() {
        return this.state;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateType() {
        return this.templateType;
    }

    public String[] getTpatUrls(@NonNull String str) {
        String outline16 = GeneratedOutlineSupport.outline16("Unknown TPAT Event ", str);
        ArrayList arrayList = this.dynamicEventsAndUrls.get(str);
        int i = this.adType;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("Unknown Advertisement Type!");
            } else if (str.startsWith("checkpoint")) {
                String[] strArr = EMPTY_STRING_ARRAY;
                Checkpoint checkpoint = this.checkpoints.get(Integer.parseInt(str.split("\\.")[1]) / 25);
                return checkpoint != null ? checkpoint.getUrls() : strArr;
            } else if (arrayList != null) {
                return (String[]) arrayList.toArray(EMPTY_STRING_ARRAY);
            } else {
                VungleLogger.warn(Advertisement.class.getSimpleName() + "#getTpatUrls", outline16);
                return EMPTY_STRING_ARRAY;
            }
        } else if (arrayList != null) {
            return (String[]) arrayList.toArray(EMPTY_STRING_ARRAY);
        } else {
            VungleLogger.warn(Advertisement.class.getSimpleName() + "#getTpatUrls", outline16);
            return EMPTY_STRING_ARRAY;
        }
    }

    public long getTtDownload() {
        return this.ttDownload;
    }

    public String getUrl() {
        return this.videoUrl;
    }

    public boolean hasPostroll() {
        return !TextUtils.isEmpty(this.postrollBundleUrl);
    }

    public int hashCode() {
        int outline4 = GeneratedOutlineSupport.outline4(this.identifier, this.adType * 31, 31);
        int hashCode = this.dynamicEventsAndUrls.hashCode();
        String str = this.campaign;
        int outline42 = (GeneratedOutlineSupport.outline4(this.videoIdentifier, GeneratedOutlineSupport.outline4(this.adToken, (GeneratedOutlineSupport.outline4(this.ctaUrl, GeneratedOutlineSupport.outline4(this.ctaDestinationUrl, (((GeneratedOutlineSupport.outline4(this.postrollBundleUrl, GeneratedOutlineSupport.outline4(this.md5, (((GeneratedOutlineSupport.outline4(this.videoUrl, (((((GeneratedOutlineSupport.outline4(str, (((hashCode + ((this.checkpoints.hashCode() + outline4) * 31)) * 31) + this.delay) * 31, 31) + this.showCloseDelay) * 31) + this.showCloseIncentivized) * 31) + this.countdown) * 31, 31) + this.videoWidth) * 31) + this.videoHeight) * 31, 31), 31) + (this.ctaOverlayEnabled ? 1 : 0)) * 31) + (this.ctaClickArea ? 1 : 0)) * 31, 31), 31) + this.retryCount) * 31, 31), 31) + (this.enableOm ? 1 : 0)) * 31;
        String str2 = this.omExtraVast;
        return (int) (((long) ((GeneratedOutlineSupport.outline4(this.bidToken, GeneratedOutlineSupport.outline4(this.adMarketId, (((outline42 + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.requiresNonMarketInstall ? 1 : 0)) * 31, 31), 31) + this.state) * 31)) + this.serverRequestTimestamp);
    }

    public boolean isCtaOverlayEnabled() {
        return this.ctaOverlayEnabled;
    }

    public boolean isRequiresNonMarketInstall() {
        return this.requiresNonMarketInstall;
    }

    public void setAdRequestStartTime(long j) {
        this.adRequestStartTime = j;
    }

    public void setAssetDownloadStartTime(long j) {
        this.assetDownloadStartTime = j;
    }

    public void setFinishedDownloadingTime(long j) {
        this.assetDownloadDuration = j - this.assetDownloadStartTime;
        this.ttDownload = j - this.adRequestStartTime;
    }

    public void setIncentivizedText(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        if (!TextUtils.isEmpty(str)) {
            this.incentivizedTextSettings.put(INCENTIVIZED_TITLE_TEXT, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.incentivizedTextSettings.put(INCENTIVIZED_BODY_TEXT, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.incentivizedTextSettings.put(INCENTIVIZED_CONTINUE_TEXT, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            this.incentivizedTextSettings.put(INCENTIVIZED_CLOSE_TEXT, str4);
        }
    }

    public void setMraidAssetDir(File file) {
        for (Map.Entry next : this.cacheableAssets.entrySet()) {
            String str = (String) ((Pair) next.getValue()).first;
            if (isValidUrl(str)) {
                File file2 = new File(file, URLUtil.guessFileName(str, (String) null, (String) null));
                if (file2.exists()) {
                    Map<String, String> map = this.mraidFiles;
                    Object key = next.getKey();
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24(FILE_SCHEME);
                    outline24.append(file2.getPath());
                    map.put(key, outline24.toString());
                }
            }
        }
        this.assetsFullyDownloaded = true;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setState(@State int i) {
        this.state = i;
    }

    @NonNull
    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Advertisement{adType=");
        outline24.append(this.adType);
        outline24.append(", identifier='");
        GeneratedOutlineSupport.outline33(outline24, this.identifier, '\'', ", appID='");
        GeneratedOutlineSupport.outline33(outline24, this.appID, '\'', ", expireTime=");
        outline24.append(this.expireTime);
        outline24.append(", checkpoints=");
        outline24.append(this.gson.toJson((Object) this.checkpoints, AdvertisementDBAdapter.CHECKPOINT_LIST_TYPE));
        outline24.append(", dynamicEventsAndUrls=");
        outline24.append(this.gson.toJson((Object) this.dynamicEventsAndUrls, AdvertisementDBAdapter.DYNAMIC_EVENTS_AND_URLS_TYPE));
        outline24.append(", delay=");
        outline24.append(this.delay);
        outline24.append(", campaign='");
        GeneratedOutlineSupport.outline33(outline24, this.campaign, '\'', ", showCloseDelay=");
        outline24.append(this.showCloseDelay);
        outline24.append(", showCloseIncentivized=");
        outline24.append(this.showCloseIncentivized);
        outline24.append(", countdown=");
        outline24.append(this.countdown);
        outline24.append(", videoUrl='");
        GeneratedOutlineSupport.outline33(outline24, this.videoUrl, '\'', ", videoWidth=");
        outline24.append(this.videoWidth);
        outline24.append(", videoHeight=");
        outline24.append(this.videoHeight);
        outline24.append(", md5='");
        GeneratedOutlineSupport.outline33(outline24, this.md5, '\'', ", postrollBundleUrl='");
        GeneratedOutlineSupport.outline33(outline24, this.postrollBundleUrl, '\'', ", ctaOverlayEnabled=");
        outline24.append(this.ctaOverlayEnabled);
        outline24.append(", ctaClickArea=");
        outline24.append(this.ctaClickArea);
        outline24.append(", ctaDestinationUrl='");
        GeneratedOutlineSupport.outline33(outline24, this.ctaDestinationUrl, '\'', ", ctaUrl='");
        GeneratedOutlineSupport.outline33(outline24, this.ctaUrl, '\'', ", adConfig=");
        outline24.append(this.adConfig);
        outline24.append(", retryCount=");
        outline24.append(this.retryCount);
        outline24.append(", adToken='");
        GeneratedOutlineSupport.outline33(outline24, this.adToken, '\'', ", videoIdentifier='");
        GeneratedOutlineSupport.outline33(outline24, this.videoIdentifier, '\'', ", templateUrl='");
        GeneratedOutlineSupport.outline33(outline24, this.templateUrl, '\'', ", templateSettings=");
        outline24.append(this.templateSettings);
        outline24.append(", mraidFiles=");
        outline24.append(this.mraidFiles);
        outline24.append(", cacheableAssets=");
        outline24.append(this.cacheableAssets);
        outline24.append(", templateId='");
        GeneratedOutlineSupport.outline33(outline24, this.templateId, '\'', ", templateType='");
        GeneratedOutlineSupport.outline33(outline24, this.templateType, '\'', ", enableOm=");
        outline24.append(this.enableOm);
        outline24.append(", oMSDKExtraVast='");
        GeneratedOutlineSupport.outline33(outline24, this.omExtraVast, '\'', ", requiresNonMarketInstall=");
        outline24.append(this.requiresNonMarketInstall);
        outline24.append(", adMarketId='");
        GeneratedOutlineSupport.outline33(outline24, this.adMarketId, '\'', ", bidToken='");
        GeneratedOutlineSupport.outline33(outline24, this.bidToken, '\'', ", state=");
        outline24.append(this.state);
        outline24.append('\'');
        outline24.append(", assetDownloadStartTime='");
        outline24.append(this.assetDownloadStartTime);
        outline24.append('\'');
        outline24.append(", assetDownloadDuration='");
        outline24.append(this.assetDownloadDuration);
        outline24.append('\'');
        outline24.append(", adRequestStartTime='");
        outline24.append(this.adRequestStartTime);
        outline24.append('\'');
        outline24.append(", requestTimestamp='");
        outline24.append(this.serverRequestTimestamp);
        outline24.append('}');
        return outline24.toString();
    }

    public int compareTo(Advertisement advertisement) {
        if (advertisement == null) {
            return 1;
        }
        String str = advertisement.identifier;
        if (str != null) {
            String str2 = this.identifier;
            if (str2 == null) {
                return -1;
            }
            return str2.compareTo(str);
        } else if (this.identifier == null) {
            return 0;
        } else {
            return 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x038c  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03c7  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03de  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03e8  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x056e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Advertisement(@androidx.annotation.NonNull com.google.gson.JsonObject r14) throws java.lang.IllegalArgumentException {
        /*
            r13 = this;
            r13.<init>()
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            r13.gson = r0
            com.google.gson.internal.LinkedTreeMap r0 = new com.google.gson.internal.LinkedTreeMap
            r0.<init>()
            r13.dynamicEventsAndUrls = r0
            r0 = 1
            r13.ctaClickArea = r0
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r13.mraidFiles = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r13.cacheableAssets = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r13.incentivizedTextSettings = r1
            r1 = 0
            r13.state = r1
            r13.assetsFullyDownloaded = r1
            java.lang.String r2 = "ad_markup"
            boolean r3 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r3 == 0) goto L_0x0596
            com.google.gson.JsonObject r14 = r14.getAsJsonObject(r2)
            java.lang.String r2 = "adType"
            boolean r3 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r3 == 0) goto L_0x058e
            com.google.gson.JsonElement r2 = r14.get(r2)
            java.lang.String r2 = r2.getAsString()
            r3 = -1
            int r4 = r2.hashCode()
            r5 = -1852456483(0xffffffff9195c1dd, float:-2.3627532E-28)
            if (r4 == r5) goto L_0x0065
            r5 = -1851445271(0xffffffff91a52fe9, float:-2.6061937E-28)
            if (r4 == r5) goto L_0x005a
            goto L_0x006f
        L_0x005a:
            java.lang.String r4 = "vungle_mraid"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x006f
            r3 = 1
            goto L_0x006f
        L_0x0065:
            java.lang.String r4 = "vungle_local"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x006f
            r3 = 0
        L_0x006f:
            java.lang.String r4 = "url"
            r5 = 0
            java.lang.String r6 = ""
            if (r3 == 0) goto L_0x01dd
            if (r3 != r0) goto L_0x01cf
            r13.adType = r0
            r13.postrollBundleUrl = r6
            java.lang.String r2 = "templateSettings"
            boolean r3 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r3 == 0) goto L_0x01c7
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r13.templateSettings = r3
            com.google.gson.JsonObject r2 = r14.getAsJsonObject(r2)
            java.lang.String r3 = "normal_replacements"
            boolean r7 = com.vungle.warren.model.JsonUtil.hasNonNull(r2, r3)
            if (r7 == 0) goto L_0x00e6
            com.google.gson.JsonObject r3 = r2.getAsJsonObject(r3)
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x00a3:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x00e6
            java.lang.Object r7 = r3.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getKey()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x00bc
            goto L_0x00a3
        L_0x00bc:
            java.lang.Object r8 = r7.getValue()
            if (r8 == 0) goto L_0x00db
            java.lang.Object r8 = r7.getValue()
            com.google.gson.JsonElement r8 = (com.google.gson.JsonElement) r8
            if (r8 == 0) goto L_0x00da
            boolean r8 = r8 instanceof com.google.gson.JsonNull
            if (r8 == 0) goto L_0x00cf
            goto L_0x00db
        L_0x00cf:
            java.lang.Object r8 = r7.getValue()
            com.google.gson.JsonElement r8 = (com.google.gson.JsonElement) r8
            java.lang.String r8 = r8.getAsString()
            goto L_0x00dc
        L_0x00da:
            throw r5
        L_0x00db:
            r8 = r5
        L_0x00dc:
            java.util.Map<java.lang.String, java.lang.String> r9 = r13.templateSettings
            java.lang.Object r7 = r7.getKey()
            r9.put(r7, r8)
            goto L_0x00a3
        L_0x00e6:
            java.lang.String r3 = "cacheable_replacements"
            boolean r7 = com.vungle.warren.model.JsonUtil.hasNonNull(r2, r3)
            if (r7 == 0) goto L_0x0177
            com.google.gson.JsonObject r2 = r2.getAsJsonObject(r3)
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
            r3 = r6
        L_0x00fb:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0178
            java.lang.Object r7 = r2.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getKey()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x0114
            goto L_0x00fb
        L_0x0114:
            java.lang.Object r8 = r7.getValue()
            if (r8 != 0) goto L_0x011b
            goto L_0x00fb
        L_0x011b:
            java.lang.Object r8 = r7.getValue()
            com.google.gson.JsonElement r8 = (com.google.gson.JsonElement) r8
            boolean r8 = com.vungle.warren.model.JsonUtil.hasNonNull(r8, r4)
            if (r8 == 0) goto L_0x00fb
            java.lang.Object r8 = r7.getValue()
            com.google.gson.JsonElement r8 = (com.google.gson.JsonElement) r8
            java.lang.String r9 = "extension"
            boolean r8 = com.vungle.warren.model.JsonUtil.hasNonNull(r8, r9)
            if (r8 == 0) goto L_0x00fb
            java.lang.Object r8 = r7.getValue()
            com.google.gson.JsonElement r8 = (com.google.gson.JsonElement) r8
            com.google.gson.JsonObject r8 = r8.getAsJsonObject()
            com.google.gson.JsonElement r8 = r8.get(r4)
            java.lang.String r8 = r8.getAsString()
            java.lang.Object r10 = r7.getValue()
            com.google.gson.JsonElement r10 = (com.google.gson.JsonElement) r10
            com.google.gson.JsonObject r10 = r10.getAsJsonObject()
            com.google.gson.JsonElement r9 = r10.get(r9)
            java.lang.String r9 = r9.getAsString()
            java.util.Map<java.lang.String, android.util.Pair<java.lang.String, java.lang.String>> r10 = r13.cacheableAssets
            java.lang.Object r11 = r7.getKey()
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r8, r9)
            r10.put(r11, r12)
            java.lang.Object r7 = r7.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r9 = "MAIN_VIDEO"
            boolean r7 = r7.equalsIgnoreCase(r9)
            if (r7 == 0) goto L_0x00fb
            r3 = r8
            goto L_0x00fb
        L_0x0177:
            r3 = r6
        L_0x0178:
            java.lang.String r2 = "templateId"
            boolean r4 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r4 == 0) goto L_0x01bf
            com.google.gson.JsonElement r2 = r14.get(r2)
            java.lang.String r2 = r2.getAsString()
            r13.templateId = r2
            java.lang.String r2 = "template_type"
            boolean r4 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r4 == 0) goto L_0x01b7
            com.google.gson.JsonElement r2 = r14.get(r2)
            java.lang.String r2 = r2.getAsString()
            r13.templateType = r2
            java.lang.String r2 = "templateURL"
            boolean r4 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r4 == 0) goto L_0x01af
            com.google.gson.JsonElement r2 = r14.get(r2)
            java.lang.String r2 = r2.getAsString()
            r13.templateUrl = r2
            goto L_0x0211
        L_0x01af:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Template URL missing!"
            r14.<init>(r0)
            throw r14
        L_0x01b7:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Template Type missing!"
            r14.<init>(r0)
            throw r14
        L_0x01bf:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Missing templateID!"
            r14.<init>(r0)
            throw r14
        L_0x01c7:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Missing template adConfig!"
            r14.<init>(r0)
            throw r14
        L_0x01cf:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Unknown Ad Type "
            java.lang.String r1 = "! Please add this ad type"
            java.lang.String r0 = com.android.tools.p006r8.GeneratedOutlineSupport.outline17(r0, r2, r1)
            r14.<init>(r0)
            throw r14
        L_0x01dd:
            r13.adType = r1
            java.lang.String r2 = "postBundle"
            boolean r3 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r3 == 0) goto L_0x01f0
            com.google.gson.JsonElement r2 = r14.get(r2)
            java.lang.String r2 = r2.getAsString()
            goto L_0x01f1
        L_0x01f0:
            r2 = r6
        L_0x01f1:
            r13.postrollBundleUrl = r2
            boolean r2 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r4)
            if (r2 == 0) goto L_0x0203
            com.google.gson.JsonElement r2 = r14.get(r4)
            java.lang.String r2 = r2.getAsString()
            r3 = r2
            goto L_0x0204
        L_0x0203:
            r3 = r6
        L_0x0204:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r13.templateSettings = r2
            r13.templateUrl = r6
            r13.templateId = r6
            r13.templateType = r6
        L_0x0211:
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L_0x021a
            r13.videoUrl = r3
            goto L_0x021c
        L_0x021a:
            r13.videoUrl = r6
        L_0x021c:
            java.lang.String r2 = "id"
            boolean r3 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r3 == 0) goto L_0x0586
            com.google.gson.JsonElement r2 = r14.get(r2)
            java.lang.String r2 = r2.getAsString()
            r13.identifier = r2
            java.lang.String r2 = "campaign"
            boolean r3 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r3 == 0) goto L_0x057e
            com.google.gson.JsonElement r2 = r14.get(r2)
            java.lang.String r2 = r2.getAsString()
            r13.campaign = r2
            java.lang.String r2 = "app_id"
            boolean r3 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r3 == 0) goto L_0x0576
            com.google.gson.JsonElement r2 = r14.get(r2)
            java.lang.String r2 = r2.getAsString()
            r13.appID = r2
            java.lang.String r2 = "expiry"
            boolean r3 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            r7 = 1000(0x3e8, double:4.94E-321)
            if (r3 == 0) goto L_0x0280
            com.google.gson.JsonElement r3 = r14.get(r2)
            if (r3 == 0) goto L_0x027f
            boolean r3 = r3 instanceof com.google.gson.JsonNull
            if (r3 != 0) goto L_0x0280
            com.google.gson.JsonElement r2 = r14.get(r2)
            long r2 = r2.getAsLong()
            r9 = 0
            int r4 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x0277
            r13.expireTime = r2
            goto L_0x0287
        L_0x0277:
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 / r7
            r13.expireTime = r2
            goto L_0x0287
        L_0x027f:
            throw r5
        L_0x0280:
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 / r7
            r13.expireTime = r2
        L_0x0287:
            java.lang.String r2 = "tpat"
            boolean r3 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r3 == 0) goto L_0x037d
            com.google.gson.JsonObject r2 = r14.getAsJsonObject(r2)
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 5
            r3.<init>(r4)
            r13.checkpoints = r3
            int r3 = r13.adType
            if (r3 == 0) goto L_0x02d9
            if (r3 != r0) goto L_0x02d1
            r3 = 0
        L_0x02a2:
            r4 = 5
            if (r3 >= r4) goto L_0x030f
            int r4 = r3 * 25
            java.util.Locale r7 = java.util.Locale.ENGLISH
            java.lang.Object[] r8 = new java.lang.Object[r0]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            r8[r1] = r9
            java.lang.String r9 = "checkpoint.%d"
            java.lang.String r7 = java.lang.String.format(r7, r9, r8)
            boolean r8 = com.vungle.warren.model.JsonUtil.hasNonNull(r2, r7)
            if (r8 == 0) goto L_0x02c8
            com.vungle.warren.model.Advertisement$Checkpoint r8 = new com.vungle.warren.model.Advertisement$Checkpoint
            com.google.gson.JsonArray r7 = r2.getAsJsonArray(r7)
            byte r4 = (byte) r4
            r8.<init>(r7, r4)
            goto L_0x02c9
        L_0x02c8:
            r8 = r5
        L_0x02c9:
            java.util.List<com.vungle.warren.model.Advertisement$Checkpoint> r4 = r13.checkpoints
            r4.add(r3, r8)
            int r3 = r3 + 1
            goto L_0x02a2
        L_0x02d1:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Unknown Ad Type!"
            r14.<init>(r0)
            throw r14
        L_0x02d9:
            java.lang.String r3 = "play_percentage"
            boolean r3 = com.vungle.warren.model.JsonUtil.hasNonNull(r2, r3)
            if (r3 == 0) goto L_0x030f
            java.lang.String r3 = "play_percentage"
            com.google.gson.JsonArray r3 = r2.getAsJsonArray(r3)
            r4 = 0
        L_0x02e8:
            int r7 = r3.size()
            if (r4 >= r7) goto L_0x030a
            com.google.gson.JsonElement r7 = r3.get(r4)
            if (r7 != 0) goto L_0x02f5
            goto L_0x0307
        L_0x02f5:
            java.util.List<com.vungle.warren.model.Advertisement$Checkpoint> r7 = r13.checkpoints
            com.vungle.warren.model.Advertisement$Checkpoint r8 = new com.vungle.warren.model.Advertisement$Checkpoint
            com.google.gson.JsonElement r9 = r3.get(r4)
            com.google.gson.JsonObject r9 = r9.getAsJsonObject()
            r8.<init>(r9)
            r7.add(r8)
        L_0x0307:
            int r4 = r4 + 1
            goto L_0x02e8
        L_0x030a:
            java.util.List<com.vungle.warren.model.Advertisement$Checkpoint> r3 = r13.checkpoints
            java.util.Collections.sort(r3)
        L_0x030f:
            java.util.TreeSet r3 = new java.util.TreeSet
            com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> r4 = r2.members
            java.util.Set r4 = r4.keySet()
            r3.<init>(r4)
            java.lang.String r4 = "moat"
            r3.remove(r4)
            java.util.Collection<java.lang.String> r4 = STATIC_TPAT_EVENTS
            r3.removeAll(r4)
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0384
            java.util.Iterator r3 = r3.iterator()
        L_0x032e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0384
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            com.google.gson.JsonElement r7 = r2.get(r4)
            com.google.gson.JsonArray r7 = r7.getAsJsonArray()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r9 = 0
        L_0x0348:
            int r10 = r7.size()
            if (r9 >= r10) goto L_0x0377
            com.google.gson.JsonElement r10 = r7.get(r9)
            if (r10 == 0) goto L_0x0371
            com.google.gson.JsonElement r10 = r7.get(r9)
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "null"
            boolean r10 = r11.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x0365
            goto L_0x0371
        L_0x0365:
            com.google.gson.JsonElement r10 = r7.get(r9)
            java.lang.String r10 = r10.getAsString()
            r8.add(r9, r10)
            goto L_0x0374
        L_0x0371:
            r8.add(r9, r6)
        L_0x0374:
            int r9 = r9 + 1
            goto L_0x0348
        L_0x0377:
            java.util.Map<java.lang.String, java.util.ArrayList<java.lang.String>> r7 = r13.dynamicEventsAndUrls
            r7.put(r4, r8)
            goto L_0x032e
        L_0x037d:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r13.checkpoints = r2
        L_0x0384:
            java.lang.String r2 = "delay"
            boolean r2 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r2 == 0) goto L_0x0399
            java.lang.String r2 = "delay"
            com.google.gson.JsonElement r2 = r14.get(r2)
            int r2 = r2.getAsInt()
            r13.delay = r2
            goto L_0x039b
        L_0x0399:
            r13.delay = r1
        L_0x039b:
            java.lang.String r2 = "showClose"
            boolean r2 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r2 == 0) goto L_0x03b0
            java.lang.String r2 = "showClose"
            com.google.gson.JsonElement r2 = r14.get(r2)
            int r2 = r2.getAsInt()
            r13.showCloseDelay = r2
            goto L_0x03b2
        L_0x03b0:
            r13.showCloseDelay = r1
        L_0x03b2:
            java.lang.String r2 = "showCloseIncentivized"
            boolean r2 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r2 == 0) goto L_0x03c7
            java.lang.String r2 = "showCloseIncentivized"
            com.google.gson.JsonElement r2 = r14.get(r2)
            int r2 = r2.getAsInt()
            r13.showCloseIncentivized = r2
            goto L_0x03c9
        L_0x03c7:
            r13.showCloseIncentivized = r1
        L_0x03c9:
            java.lang.String r2 = "countdown"
            boolean r2 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r2 == 0) goto L_0x03de
            java.lang.String r2 = "countdown"
            com.google.gson.JsonElement r2 = r14.get(r2)
            int r2 = r2.getAsInt()
            r13.countdown = r2
            goto L_0x03e0
        L_0x03de:
            r13.countdown = r1
        L_0x03e0:
            java.lang.String r2 = "videoWidth"
            boolean r2 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r2 == 0) goto L_0x056e
            java.lang.String r2 = "videoWidth"
            com.google.gson.JsonElement r2 = r14.get(r2)
            int r2 = r2.getAsInt()
            r13.videoWidth = r2
            java.lang.String r2 = "videoHeight"
            boolean r2 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r2 == 0) goto L_0x0566
            java.lang.String r2 = "videoHeight"
            com.google.gson.JsonElement r2 = r14.get(r2)
            int r2 = r2.getAsInt()
            r13.videoHeight = r2
            java.lang.String r2 = "md5"
            boolean r2 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r2 == 0) goto L_0x041d
            java.lang.String r2 = "md5"
            com.google.gson.JsonElement r2 = r14.get(r2)
            java.lang.String r2 = r2.getAsString()
            r13.md5 = r2
            goto L_0x041f
        L_0x041d:
            r13.md5 = r6
        L_0x041f:
            java.lang.String r2 = "cta_overlay"
            boolean r2 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r2 == 0) goto L_0x046b
            java.lang.String r2 = "cta_overlay"
            com.google.gson.JsonObject r2 = r14.getAsJsonObject(r2)
            java.lang.String r3 = "enabled"
            boolean r3 = com.vungle.warren.model.JsonUtil.hasNonNull(r2, r3)
            if (r3 == 0) goto L_0x0442
            java.lang.String r3 = "enabled"
            com.google.gson.JsonElement r3 = r2.get(r3)
            boolean r3 = r3.getAsBoolean()
            r13.ctaOverlayEnabled = r3
            goto L_0x0444
        L_0x0442:
            r13.ctaOverlayEnabled = r1
        L_0x0444:
            java.lang.String r3 = "click_area"
            boolean r4 = com.vungle.warren.model.JsonUtil.hasNonNull(r2, r3)
            if (r4 == 0) goto L_0x046d
            com.google.gson.JsonElement r4 = r2.get(r3)
            java.lang.String r4 = r4.getAsString()
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x046d
            com.google.gson.JsonElement r2 = r2.get(r3)
            double r2 = r2.getAsDouble()
            r7 = 0
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x046d
            r13.ctaClickArea = r1
            goto L_0x046d
        L_0x046b:
            r13.ctaOverlayEnabled = r1
        L_0x046d:
            java.lang.String r2 = "callToActionDest"
            boolean r2 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r2 == 0) goto L_0x0480
            java.lang.String r2 = "callToActionDest"
            com.google.gson.JsonElement r2 = r14.get(r2)
            java.lang.String r2 = r2.getAsString()
            goto L_0x0481
        L_0x0480:
            r2 = r6
        L_0x0481:
            r13.ctaDestinationUrl = r2
            java.lang.String r2 = "callToActionUrl"
            boolean r2 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r2 == 0) goto L_0x0496
            java.lang.String r2 = "callToActionUrl"
            com.google.gson.JsonElement r2 = r14.get(r2)
            java.lang.String r2 = r2.getAsString()
            goto L_0x0497
        L_0x0496:
            r2 = r6
        L_0x0497:
            r13.ctaUrl = r2
            java.lang.String r2 = "retryCount"
            boolean r2 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r2)
            if (r2 == 0) goto L_0x04ae
            java.lang.String r0 = "retryCount"
            com.google.gson.JsonElement r0 = r14.get(r0)
            int r0 = r0.getAsInt()
            r13.retryCount = r0
            goto L_0x04b0
        L_0x04ae:
            r13.retryCount = r0
        L_0x04b0:
            java.lang.String r0 = "ad_token"
            boolean r0 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r0)
            if (r0 == 0) goto L_0x055e
            java.lang.String r0 = "ad_token"
            com.google.gson.JsonElement r0 = r14.get(r0)
            java.lang.String r0 = r0.getAsString()
            r13.adToken = r0
            java.lang.String r0 = "video_object_id"
            boolean r0 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r0)
            if (r0 == 0) goto L_0x04d9
            java.lang.String r0 = "video_object_id"
            com.google.gson.JsonElement r0 = r14.get(r0)
            java.lang.String r0 = r0.getAsString()
            r13.videoIdentifier = r0
            goto L_0x04db
        L_0x04d9:
            r13.videoIdentifier = r6
        L_0x04db:
            java.lang.String r0 = "requires_sideloading"
            boolean r0 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r0)
            if (r0 == 0) goto L_0x04f0
            java.lang.String r0 = "requires_sideloading"
            com.google.gson.JsonElement r0 = r14.get(r0)
            boolean r0 = r0.getAsBoolean()
            r13.requiresNonMarketInstall = r0
            goto L_0x04f2
        L_0x04f0:
            r13.requiresNonMarketInstall = r1
        L_0x04f2:
            java.lang.String r0 = "ad_market_id"
            boolean r0 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r0)
            if (r0 == 0) goto L_0x0507
            java.lang.String r0 = "ad_market_id"
            com.google.gson.JsonElement r0 = r14.get(r0)
            java.lang.String r0 = r0.getAsString()
            r13.adMarketId = r0
            goto L_0x0509
        L_0x0507:
            r13.adMarketId = r6
        L_0x0509:
            java.lang.String r0 = "bid_token"
            boolean r0 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r0)
            if (r0 == 0) goto L_0x051e
            java.lang.String r0 = "bid_token"
            com.google.gson.JsonElement r0 = r14.get(r0)
            java.lang.String r0 = r0.getAsString()
            r13.bidToken = r0
            goto L_0x0520
        L_0x051e:
            r13.bidToken = r6
        L_0x0520:
            java.lang.String r0 = "timestamp"
            boolean r0 = com.vungle.warren.model.JsonUtil.hasNonNull(r14, r0)
            if (r0 == 0) goto L_0x0535
            java.lang.String r0 = "timestamp"
            com.google.gson.JsonElement r0 = r14.get(r0)
            long r2 = r0.getAsLong()
            r13.serverRequestTimestamp = r2
            goto L_0x0539
        L_0x0535:
            r2 = 1
            r13.serverRequestTimestamp = r2
        L_0x0539:
            java.lang.String r0 = "viewability"
            com.google.gson.JsonObject r14 = com.vungle.warren.model.JsonUtil.getAsObject(r14, r0)
            java.lang.String r0 = "om"
            com.google.gson.JsonObject r14 = com.vungle.warren.model.JsonUtil.getAsObject(r14, r0)
            java.lang.String r0 = "is_enabled"
            boolean r0 = com.vungle.warren.model.JsonUtil.getAsBoolean(r14, r0, r1)
            r13.enableOm = r0
            java.lang.String r0 = "extra_vast"
            java.lang.String r14 = com.vungle.warren.model.JsonUtil.getAsString(r14, r0, r5)
            r13.omExtraVast = r14
            com.vungle.warren.AdConfig r14 = new com.vungle.warren.AdConfig
            r14.<init>()
            r13.adConfig = r14
            return
        L_0x055e:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "AdToken missing!"
            r14.<init>(r0)
            throw r14
        L_0x0566:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Missing video height!"
            r14.<init>(r0)
            throw r14
        L_0x056e:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Missing video width!"
            r14.<init>(r0)
            throw r14
        L_0x0576:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Missing app Id, cannot process advertisement!"
            r14.<init>(r0)
            throw r14
        L_0x057e:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Missing campaign information, cannot process advertisement!"
            r14.<init>(r0)
            throw r14
        L_0x0586:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Missing identifier, cannot process advertisement!"
            r14.<init>(r0)
            throw r14
        L_0x058e:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Advertisement did not contain an adType!"
            r14.<init>(r0)
            throw r14
        L_0x0596:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "JSON does not contain ad markup!"
            r14.<init>(r0)
            goto L_0x059f
        L_0x059e:
            throw r14
        L_0x059f:
            goto L_0x059e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Advertisement.<init>(com.google.gson.JsonObject):void");
    }
}
