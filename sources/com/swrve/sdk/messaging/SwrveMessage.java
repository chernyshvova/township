package com.swrve.sdk.messaging;

import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.SwrveTextTemplating;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveMessage implements SwrveBaseMessage {
    public File cacheDir;
    public SwrveInAppCampaign campaign;
    public List<SwrveMessageFormat> formats;

    /* renamed from: id */
    public int f2798id;
    public String name;
    public int priority;

    public SwrveMessage(SwrveInAppCampaign swrveInAppCampaign, File file) {
        this.priority = 9999;
        this.campaign = swrveInAppCampaign;
        this.formats = new ArrayList();
        setCacheDir(file);
    }

    @Deprecated
    public boolean areAssetsReady(Set<String> set) {
        return areAssetsReady(set, (Map<String, String>) null);
    }

    public boolean assetInCache(Set<String> set, String str) {
        return SwrveHelper.isNotNullOrEmpty(str) && set.contains(str);
    }

    public File getCacheDir() {
        return this.cacheDir;
    }

    public SwrveMessageFormat getFormat(SwrveOrientation swrveOrientation) {
        List<SwrveMessageFormat> list = this.formats;
        if (list == null) {
            return null;
        }
        for (SwrveMessageFormat next : list) {
            if (next.getOrientation() == swrveOrientation) {
                return next;
            }
        }
        return null;
    }

    public List<SwrveMessageFormat> getFormats() {
        return this.formats;
    }

    public int getId() {
        return this.f2798id;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setCacheDir(File file) {
        this.cacheDir = file;
    }

    public void setCampaign(SwrveInAppCampaign swrveInAppCampaign) {
        this.campaign = swrveInAppCampaign;
    }

    public void setFormats(List<SwrveMessageFormat> list) {
        this.formats = list;
    }

    public void setId(int i) {
        this.f2798id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public boolean supportsOrientation(SwrveOrientation swrveOrientation) {
        if (swrveOrientation != SwrveOrientation.Both && getFormat(swrveOrientation) == null) {
            return false;
        }
        return true;
    }

    public boolean areAssetsReady(Set<String> set, Map<String, String> map) {
        List<SwrveMessageFormat> list = this.formats;
        if (list != null) {
            for (SwrveMessageFormat next : list) {
                for (SwrveButton next2 : next.buttons) {
                    String image = next2.getImage();
                    boolean assetInCache = assetInCache(set, image);
                    if (!assetInCache && SwrveHelper.isNotNullOrEmpty(next2.getDynamicImageUrl())) {
                        try {
                            String apply = SwrveTextTemplating.apply(next2.getDynamicImageUrl(), map);
                            if (assetInCache(set, SwrveHelper.sha1(apply.getBytes()))) {
                                assetInCache = true;
                                continue;
                            } else {
                                SwrveLogger.m2755i("Button dynamic asset not yet downloaded: %s", apply);
                                return false;
                            }
                        } catch (Exception e) {
                            SwrveLogger.m2755i("Could not resolve personalization", e);
                            continue;
                        }
                    }
                    if (!assetInCache) {
                        SwrveLogger.m2755i("Button asset not yet downloaded: %s", image);
                        return false;
                    }
                }
                Iterator<SwrveImage> it = next.images.iterator();
                while (true) {
                    if (it.hasNext()) {
                        SwrveImage next3 = it.next();
                        String file = next3.getFile();
                        boolean assetInCache2 = assetInCache(set, file);
                        if (!assetInCache2 && SwrveHelper.isNotNullOrEmpty(next3.getDynamicImageUrl())) {
                            try {
                                String apply2 = SwrveTextTemplating.apply(next3.getDynamicImageUrl(), map);
                                if (assetInCache(set, SwrveHelper.sha1(apply2.getBytes()))) {
                                    assetInCache2 = true;
                                    continue;
                                } else {
                                    SwrveLogger.m2755i("Image dynamic asset not yet downloaded: %s", apply2);
                                    return false;
                                }
                            } catch (Exception e2) {
                                SwrveLogger.m2755i("Could not resolve personalization", e2);
                                continue;
                            }
                        }
                        if (!assetInCache2) {
                            SwrveLogger.m2755i("Image asset not yet downloaded: %s", file);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public SwrveInAppCampaign getCampaign() {
        return this.campaign;
    }

    public SwrveMessage(SwrveInAppCampaign swrveInAppCampaign, JSONObject jSONObject, File file) throws JSONException {
        this(swrveInAppCampaign, file);
        setId(jSONObject.getInt("id"));
        setName(jSONObject.getString("name"));
        if (jSONObject.has("priority")) {
            setPriority(jSONObject.getInt("priority"));
        }
        JSONArray jSONArray = jSONObject.getJSONObject("template").getJSONArray("formats");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            getFormats().add(new SwrveMessageFormat(this, jSONArray.getJSONObject(i)));
        }
    }
}
