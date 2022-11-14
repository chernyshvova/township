package com.helpshift.common.platform;

import android.content.Context;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.helpshift.common.conversation.ConversationDB;
import com.helpshift.conversation.dao.ConversationInboxDAO;
import com.helpshift.conversation.dao.PushNotificationData;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.dto.ConversationDetailDTO;
import com.helpshift.conversation.dto.dao.ConversationInboxRecord;
import com.helpshift.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AndroidConversationInboxDAO implements ConversationInboxDAO {
    public static final String KEY_NOTIFICATION_COUNT = "notification_count";
    public static final String KEY_NOTIFICATION_TITLE = "notification_title";
    public static final String KEY_PUSH_NOTIFICATION_DATA = "push_notification_data";
    public ConversationDB conversationDB;
    public KVStore kvStore;

    public AndroidConversationInboxDAO(Context context, KVStore kVStore) {
        this.conversationDB = ConversationDB.getInstance(context);
        this.kvStore = kVStore;
    }

    private synchronized ConversationInboxRecord.Builder getConversationInboxRecordBuilder(long j) {
        ConversationInboxRecord.Builder builder;
        ConversationInboxRecord readConversationInboxRecord = this.conversationDB.readConversationInboxRecord(j);
        if (readConversationInboxRecord == null) {
            builder = new ConversationInboxRecord.Builder(j);
        } else {
            builder = new ConversationInboxRecord.Builder(readConversationInboxRecord);
        }
        return builder;
    }

    public void deleteUserData(long j) {
        if (j > 0) {
            this.conversationDB.deleteConversationInboxData(j);
        }
    }

    public synchronized String getConversationArchivalPrefillText(long j) {
        String str;
        ConversationInboxRecord readConversationInboxRecord = this.conversationDB.readConversationInboxRecord(j);
        str = null;
        if (readConversationInboxRecord != null) {
            str = readConversationInboxRecord.archivalText;
        }
        return str;
    }

    public synchronized String getConversationInboxTimestamp(long j) {
        String str;
        ConversationInboxRecord readConversationInboxRecord = this.conversationDB.readConversationInboxRecord(j);
        str = null;
        if (readConversationInboxRecord != null) {
            str = readConversationInboxRecord.lastSyncTimestamp;
        }
        return str;
    }

    public synchronized ConversationDetailDTO getDescriptionDetail(long j) {
        ConversationDetailDTO conversationDetailDTO;
        ConversationInboxRecord readConversationInboxRecord = this.conversationDB.readConversationInboxRecord(j);
        conversationDetailDTO = null;
        if (readConversationInboxRecord != null) {
            String str = readConversationInboxRecord.description;
            long j2 = readConversationInboxRecord.descriptionTimeStamp;
            int i = readConversationInboxRecord.descriptionType;
            if (!StringUtils.isEmpty(str)) {
                conversationDetailDTO = new ConversationDetailDTO(str, j2, i);
            }
        }
        return conversationDetailDTO;
    }

    public synchronized String getEmail(long j) {
        String str;
        ConversationInboxRecord readConversationInboxRecord = this.conversationDB.readConversationInboxRecord(j);
        str = null;
        if (readConversationInboxRecord != null) {
            str = readConversationInboxRecord.formEmail;
        }
        return str;
    }

    public boolean getHasOlderMessages(long j) {
        Boolean bool;
        ConversationInboxRecord readConversationInboxRecord = this.conversationDB.readConversationInboxRecord(j);
        if (readConversationInboxRecord == null || (bool = readConversationInboxRecord.hasOlderMessages) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public synchronized AttachmentPickerFile getImageAttachment(long j) {
        AttachmentPickerFile attachmentPickerFile;
        ConversationInboxRecord readConversationInboxRecord = this.conversationDB.readConversationInboxRecord(j);
        attachmentPickerFile = null;
        if (readConversationInboxRecord != null) {
            attachmentPickerFile = readConversationInboxRecord.imageAttachmentDraft;
        }
        return attachmentPickerFile;
    }

    public Long getLastConversationsRedactionTime(long j) {
        ConversationInboxRecord readConversationInboxRecord = this.conversationDB.readConversationInboxRecord(j);
        if (readConversationInboxRecord != null) {
            return readConversationInboxRecord.lastConversationsRedactionTime;
        }
        return null;
    }

    public synchronized String getName(long j) {
        String str;
        ConversationInboxRecord readConversationInboxRecord = this.conversationDB.readConversationInboxRecord(j);
        str = null;
        if (readConversationInboxRecord != null) {
            str = readConversationInboxRecord.formName;
        }
        return str;
    }

    public synchronized boolean getPersistMessageBox(long j) {
        boolean z;
        ConversationInboxRecord readConversationInboxRecord = this.conversationDB.readConversationInboxRecord(j);
        z = false;
        if (readConversationInboxRecord != null) {
            z = readConversationInboxRecord.persistMessageBox;
        }
        return z;
    }

    public PushNotificationData getPushNotificationData(String str) {
        String string = this.kvStore.getString(KEY_PUSH_NOTIFICATION_DATA);
        if (StringUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (!jSONObject.has(str)) {
                return null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return new PushNotificationData(jSONObject2.getInt(KEY_NOTIFICATION_COUNT), jSONObject2.getString(KEY_NOTIFICATION_TITLE));
        } catch (JSONException unused) {
            return null;
        }
    }

    public synchronized String getUserReplyDraft(long j) {
        String str;
        ConversationInboxRecord readConversationInboxRecord = this.conversationDB.readConversationInboxRecord(j);
        str = "";
        if (readConversationInboxRecord != null) {
            str = readConversationInboxRecord.replyText;
        }
        return str;
    }

    public void resetDataAfterConversationsDeletion(long j) {
        ConversationInboxRecord.Builder conversationInboxRecordBuilder = getConversationInboxRecordBuilder(j);
        conversationInboxRecordBuilder.setHasOlderMessages(true);
        conversationInboxRecordBuilder.setLastSyncTimestamp((String) null);
        this.conversationDB.storeConversationInboxRecord(conversationInboxRecordBuilder.build());
    }

    public synchronized void saveConversationArchivalPrefillText(long j, String str) {
        ConversationInboxRecord.Builder conversationInboxRecordBuilder = getConversationInboxRecordBuilder(j);
        conversationInboxRecordBuilder.setArchivalText(str);
        this.conversationDB.storeConversationInboxRecord(conversationInboxRecordBuilder.build());
    }

    public synchronized void saveConversationInboxTimestamp(long j, String str) {
        ConversationInboxRecord.Builder conversationInboxRecordBuilder = getConversationInboxRecordBuilder(j);
        conversationInboxRecordBuilder.setLastSyncTimestamp(str);
        this.conversationDB.storeConversationInboxRecord(conversationInboxRecordBuilder.build());
    }

    public synchronized void saveDescriptionDetail(long j, ConversationDetailDTO conversationDetailDTO) {
        ConversationInboxRecord.Builder conversationInboxRecordBuilder = getConversationInboxRecordBuilder(j);
        conversationInboxRecordBuilder.setDescription(conversationDetailDTO.title);
        conversationInboxRecordBuilder.setDescriptionTimeStamp(conversationDetailDTO.timestamp);
        conversationInboxRecordBuilder.setDescriptionType(conversationDetailDTO.type);
        this.conversationDB.storeConversationInboxRecord(conversationInboxRecordBuilder.build());
    }

    public synchronized void saveEmail(long j, String str) {
        ConversationInboxRecord.Builder conversationInboxRecordBuilder = getConversationInboxRecordBuilder(j);
        conversationInboxRecordBuilder.setFormEmail(str);
        this.conversationDB.storeConversationInboxRecord(conversationInboxRecordBuilder.build());
    }

    public void saveHasOlderMessages(long j, boolean z) {
        ConversationInboxRecord.Builder conversationInboxRecordBuilder = getConversationInboxRecordBuilder(j);
        conversationInboxRecordBuilder.setHasOlderMessages(z);
        this.conversationDB.storeConversationInboxRecord(conversationInboxRecordBuilder.build());
    }

    public synchronized void saveImageAttachment(long j, AttachmentPickerFile attachmentPickerFile) {
        ConversationInboxRecord.Builder conversationInboxRecordBuilder = getConversationInboxRecordBuilder(j);
        conversationInboxRecordBuilder.setImageAttachmentDraft(attachmentPickerFile);
        this.conversationDB.storeConversationInboxRecord(conversationInboxRecordBuilder.build());
    }

    public void saveLastConversationsRedactionTime(long j, long j2) {
        ConversationInboxRecord.Builder conversationInboxRecordBuilder = getConversationInboxRecordBuilder(j);
        conversationInboxRecordBuilder.setLastConversationsRedactionTime(Long.valueOf(j2));
        this.conversationDB.storeConversationInboxRecord(conversationInboxRecordBuilder.build());
    }

    public synchronized void saveName(long j, String str) {
        ConversationInboxRecord.Builder conversationInboxRecordBuilder = getConversationInboxRecordBuilder(j);
        conversationInboxRecordBuilder.setFormName(str);
        this.conversationDB.storeConversationInboxRecord(conversationInboxRecordBuilder.build());
    }

    public synchronized void savePersistMessageBox(long j, boolean z) {
        ConversationInboxRecord.Builder conversationInboxRecordBuilder = getConversationInboxRecordBuilder(j);
        conversationInboxRecordBuilder.setPersistMessageBox(z);
        this.conversationDB.storeConversationInboxRecord(conversationInboxRecordBuilder.build());
    }

    public synchronized void saveUserReplyDraft(long j, String str) {
        if (str == null) {
            str = "";
        }
        ConversationInboxRecord.Builder conversationInboxRecordBuilder = getConversationInboxRecordBuilder(j);
        conversationInboxRecordBuilder.setReplyText(str);
        this.conversationDB.storeConversationInboxRecord(conversationInboxRecordBuilder.build());
    }

    public void setPushNotificationData(String str, PushNotificationData pushNotificationData) {
        String string = this.kvStore.getString(KEY_PUSH_NOTIFICATION_DATA);
        if (StringUtils.isEmpty(string)) {
            string = JsonUtils.EMPTY_JSON;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (pushNotificationData == null) {
                jSONObject.remove(str);
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(KEY_NOTIFICATION_COUNT, pushNotificationData.count);
                jSONObject2.put(KEY_NOTIFICATION_TITLE, pushNotificationData.title);
                jSONObject.put(str, jSONObject2);
            }
            this.kvStore.setString(KEY_PUSH_NOTIFICATION_DATA, jSONObject.toString());
        } catch (JSONException unused) {
        }
    }
}
