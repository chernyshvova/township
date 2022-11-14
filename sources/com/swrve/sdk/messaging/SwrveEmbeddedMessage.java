package com.swrve.sdk.messaging;

import com.facebook.GraphRequest;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveEmbeddedMessage implements SwrveBaseMessage {
    public List<String> buttons;
    public SwrveEmbeddedCampaign campaign;
    public String data;

    /* renamed from: id */
    public int f2797id;
    public int priority = 9999;
    public EMBEDDED_CAMPAIGN_TYPE type;

    public enum EMBEDDED_CAMPAIGN_TYPE {
        OTHER {
            public String toString() {
                return "other";
            }
        },
        JSON {
            public String toString() {
                return GraphRequest.FORMAT_JSON;
            }
        }
    }

    public SwrveEmbeddedMessage(SwrveEmbeddedCampaign swrveEmbeddedCampaign, JSONObject jSONObject) throws JSONException {
        setCampaign(swrveEmbeddedCampaign);
        setId(jSONObject.getInt("id"));
        if (jSONObject.has("priority")) {
            setPriority(jSONObject.getInt("priority"));
        }
        if (jSONObject.has("buttons")) {
            JSONArray jSONArray = jSONObject.getJSONArray("buttons");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
            setButtons(arrayList);
        }
        if (jSONObject.has("data")) {
            setData(jSONObject.getString("data"));
        }
        if (jSONObject.has("type")) {
            setType(jSONObject.getString("type"));
        }
    }

    public List<String> getButtons() {
        return this.buttons;
    }

    public String getData() {
        return this.data;
    }

    public int getId() {
        return this.f2797id;
    }

    public int getPriority() {
        return this.priority;
    }

    public EMBEDDED_CAMPAIGN_TYPE getType() {
        return this.type;
    }

    public void setButtons(List<String> list) {
        this.buttons = list;
    }

    public void setCampaign(SwrveEmbeddedCampaign swrveEmbeddedCampaign) {
        this.campaign = swrveEmbeddedCampaign;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setId(int i) {
        this.f2797id = i;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setType(String str) {
        if (str.equalsIgnoreCase(EMBEDDED_CAMPAIGN_TYPE.JSON.toString())) {
            this.type = EMBEDDED_CAMPAIGN_TYPE.JSON;
        }
        if (str.equalsIgnoreCase(EMBEDDED_CAMPAIGN_TYPE.OTHER.toString())) {
            this.type = EMBEDDED_CAMPAIGN_TYPE.OTHER;
        }
    }

    public boolean supportsOrientation(SwrveOrientation swrveOrientation) {
        return true;
    }

    public SwrveEmbeddedCampaign getCampaign() {
        return this.campaign;
    }
}
