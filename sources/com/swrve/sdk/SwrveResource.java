package com.swrve.sdk;

import com.facebook.internal.ServerProtocol;
import java.util.Map;
import java.util.Set;

public class SwrveResource {
    public Map<String, String> attributes;

    public SwrveResource(Map<String, String> map) {
        this.attributes = map;
    }

    public boolean _getAttributeAsBoolean(String str, boolean z) {
        if (!this.attributes.containsKey(str)) {
            return z;
        }
        String str2 = this.attributes.get(str);
        return str2.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) || str2.equalsIgnoreCase("yes");
    }

    public float _getAttributeAsFloat(String str, float f) {
        if (this.attributes.containsKey(str)) {
            try {
                return Float.parseFloat(this.attributes.get(str));
            } catch (NumberFormatException unused) {
                SwrveLogger.m2754e("Could not retrieve attribute %s as float value, returning default value instead", str);
            }
        }
        return f;
    }

    public int _getAttributeAsInt(String str, int i) {
        if (this.attributes.containsKey(str)) {
            try {
                return Integer.parseInt(this.attributes.get(str));
            } catch (NumberFormatException unused) {
                SwrveLogger.m2754e("Could not retrieve attribute %s as integer value, returning default value instead", str);
            }
        }
        return i;
    }

    public String _getAttributeAsString(String str, String str2) {
        return this.attributes.containsKey(str) ? this.attributes.get(str) : str2;
    }

    public boolean getAttributeAsBoolean(String str, boolean z) {
        try {
            return _getAttributeAsBoolean(str, z);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return z;
        }
    }

    public float getAttributeAsFloat(String str, float f) {
        try {
            return _getAttributeAsFloat(str, f);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return f;
        }
    }

    public int getAttributeAsInt(String str, int i) {
        try {
            return _getAttributeAsInt(str, i);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return i;
        }
    }

    public String getAttributeAsString(String str, String str2) {
        try {
            return _getAttributeAsString(str, str2);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return str2;
        }
    }

    public Set<String> getAttributeKeys() {
        return this.attributes.keySet();
    }
}
