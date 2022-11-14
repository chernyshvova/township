package com.helpshift.support.storage;

import android.content.Context;
import androidx.annotation.NonNull;
import com.helpshift.common.platform.AndroidNetworkRequestDAO;
import com.helpshift.common.platform.KVStore;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.storage.CachedKeyValueStorage;
import com.helpshift.storage.KeyValueStorage;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SupportKeyValueDBStorage implements KVStore {
    public KeyValueStorage storage;

    public SupportKeyValueDBStorage(Context context) {
        this.storage = new CachedKeyValueStorage(new SupportRetryKeyValueDBStorage(context), getCacheWhitelistKeys());
    }

    @NonNull
    private Set<String> getCacheWhitelistKeys() {
        return new HashSet(Arrays.asList(new String[]{SDKConfigurationDM.SDK_LANGUAGE, SDKConfigurationDM.DISABLE_IN_APP_CONVERSATION, SDKConfigurationDM.DEBUG_LOG_LIMIT, SDKConfigurationDM.ENABLE_TYPING_INDICATOR_AGENT, SDKConfigurationDM.ENABLE_TYPING_INDICATOR, SDKConfigurationDM.ENABLE_FULL_PRIVACY, SDKConfigurationDM.SHOW_CONVERSATION_INFO_SCREEN, SDKConfigurationDM.RUNTIME_VERSION, SDKConfigurationDM.SDK_TYPE, SDKConfigurationDM.DISABLE_APP_LAUNCH_EVENT, SDKConfigurationDM.PLUGIN_VERSION, SDKConfigurationDM.PROFILE_FORM_ENABLE, SDKConfigurationDM.REQUIRE_NAME_AND_EMAIL, SDKConfigurationDM.REQUIRE_EMAIL, SDKConfigurationDM.HIDE_NAME_AND_EMAIL, SDKConfigurationDM.GOTO_CONVERSATION_AFTER_CONTACT_US, SDKConfigurationDM.SHOW_SEARCH_ON_NEW_CONVERSATION, SDKConfigurationDM.SUPPORT_NOTIFICATION_CHANNEL_ID, SDKConfigurationDM.NOTIFICATION_ICON_ID, SDKConfigurationDM.NOTIFICATION_LARGE_ICON_ID, SDKConfigurationDM.APP_REVIEWED, SDKConfigurationDM.DEFAULT_FALLBACK_LANGUAGE_ENABLE, SDKConfigurationDM.CONVERSATION_GREETING_MESSAGE, SDKConfigurationDM.CONVERSATIONAL_ISSUE_FILING, SDKConfigurationDM.SHOW_CONVERSATION_RESOLUTION_QUESTION_API, SDKConfigurationDM.SHOW_CONVERSATION_RESOLUTION_QUESTION_AGENT, SDKConfigurationDM.ALLOW_USER_ATTACHMENTS, AndroidNetworkRequestDAO.KEY_SERVER_TIME_DELTA, SDKConfigurationDM.HELPSHIFT_BRANDING_DISABLE_AGENT, "disableHelpshiftBranding", SDKConfigurationDM.PERIODIC_REVIEW_ENABLED, SDKConfigurationDM.PERIODIC_REVIEW_INTERVAL, SDKConfigurationDM.PERIODIC_REVIEW_TYPE, SDKConfigurationDM.CUSTOMER_SATISFACTION_SURVEY, SDKConfigurationDM.SHOULD_SHOW_CONVERSATION_HISTORY_AGENT, SDKConfigurationDM.ENABLE_DEFAULT_CONVERSATIONAL_FILING, SDKConfigurationDM.AVATAR_IMAGE_TEMPLATE_URL, SDKConfigurationDM.HEADER_IMAGE_LOCAL_PATH, SDKConfigurationDM.AGENT_FALLBACK_IMAGE_LOCAL_PATH, SDKConfigurationDM.BOT_FALLBACK_IMAGE_LOCAL_PATH, SDKConfigurationDM.HEADER_TITLE_TEXT}));
    }

    private void setOrRemoveKeyInternal(String str, Serializable serializable) {
        if (serializable == null) {
            this.storage.removeKey(str);
        } else {
            this.storage.set(str, serializable);
        }
    }

    public Boolean getBoolean(String str) {
        Object obj = this.storage.get(str);
        if (obj == null) {
            return null;
        }
        return (Boolean) obj;
    }

    public Float getFloat(String str) {
        Object obj = this.storage.get(str);
        if (obj == null) {
            return null;
        }
        return (Float) obj;
    }

    public Integer getInt(String str) {
        Object obj = this.storage.get(str);
        if (obj == null) {
            return null;
        }
        return (Integer) obj;
    }

    public Long getLong(String str) {
        Object obj = this.storage.get(str);
        if (obj == null) {
            return null;
        }
        return (Long) obj;
    }

    public Object getSerializable(String str) {
        return this.storage.get(str);
    }

    public String getString(String str) {
        Object obj = this.storage.get(str);
        if (obj == null) {
            return null;
        }
        return (String) obj;
    }

    public void removeAllKeys() {
        this.storage.removeAllKeys();
    }

    public void setBoolean(String str, Boolean bool) {
        setOrRemoveKeyInternal(str, bool);
    }

    public void setFloat(String str, Float f) {
        setOrRemoveKeyInternal(str, f);
    }

    public void setInt(String str, Integer num) {
        setOrRemoveKeyInternal(str, num);
    }

    public void setKeyValues(Map<String, Serializable> map) {
        this.storage.setKeyValues(map);
    }

    public void setLong(String str, Long l) {
        setOrRemoveKeyInternal(str, l);
    }

    public void setSerializable(String str, Serializable serializable) {
        setOrRemoveKeyInternal(str, serializable);
    }

    public void setString(String str, String str2) {
        setOrRemoveKeyInternal(str, str2);
    }

    public Boolean getBoolean(String str, Boolean bool) {
        Object obj = this.storage.get(str);
        if (obj == null) {
            return bool;
        }
        return (Boolean) obj;
    }

    public Float getFloat(String str, Float f) {
        Object obj = this.storage.get(str);
        if (obj == null) {
            return f;
        }
        return (Float) obj;
    }

    public Integer getInt(String str, Integer num) {
        Object obj = this.storage.get(str);
        if (obj == null) {
            return num;
        }
        return (Integer) obj;
    }

    public Long getLong(String str, Long l) {
        Object obj = this.storage.get(str);
        if (obj == null) {
            return l;
        }
        return (Long) obj;
    }

    public String getString(String str, String str2) {
        Object obj = this.storage.get(str);
        if (obj == null) {
            return str2;
        }
        return (String) obj;
    }
}
