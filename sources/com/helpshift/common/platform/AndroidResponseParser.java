package com.helpshift.common.platform;

import androidx.core.app.NotificationCompat;
import androidx.core.graphics.PaintCompat;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.internal.ServerProtocol;
import com.facebook.login.LoginLogger;
import com.facebook.share.internal.VideoUploader;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.auth.dto.WebSocketAuthData;
import com.helpshift.bots.BotControlActions;
import com.helpshift.common.exception.ParseException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.ResponseParser;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.configuration.response.AvatarConfig;
import com.helpshift.configuration.response.PeriodicReview;
import com.helpshift.configuration.response.RootServerConfig;
import com.helpshift.conversation.IssueType;
import com.helpshift.conversation.activeconversation.message.AcceptedAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminBotControlMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminCSATMessageWithOptions;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageWithOptionInputDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageWithTextInputDM;
import com.helpshift.conversation.activeconversation.message.AdminResolutionMessageWithOptions;
import com.helpshift.conversation.activeconversation.message.Author;
import com.helpshift.conversation.activeconversation.message.ConfirmationAcceptedMessageDM;
import com.helpshift.conversation.activeconversation.message.ConfirmationRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageWithOptionInputDM;
import com.helpshift.conversation.activeconversation.message.FollowupAcceptedMessageDM;
import com.helpshift.conversation.activeconversation.message.FollowupRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.MessageType;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UnsupportedAdminMessageWithInputDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.UserBotControlMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageDM;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForCSATInput;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForOptionInput;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForTextInputDM;
import com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM;
import com.helpshift.conversation.activeconversation.message.input.CSATRatingsInput;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.conversation.activeconversation.model.Action;
import com.helpshift.conversation.activeconversation.model.ActionCard;
import com.helpshift.conversation.activeconversation.model.ActionType;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dto.ConversationHistory;
import com.helpshift.conversation.dto.ConversationInbox;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.dto.WSPingMessage;
import com.helpshift.conversation.dto.WSTypingActionMessage;
import com.helpshift.conversation.dto.WebSocketMessage;
import com.helpshift.conversation.smartintent.dto.SISearchModelDTO;
import com.helpshift.conversation.smartintent.dto.SITreeDTO;
import com.helpshift.conversation.smartintent.dto.SmartIntentDTO;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.faq.FaqCore;
import com.helpshift.logger.constants.LogLevel;
import com.helpshift.p042db.conversation.tables.ActionCardTable;
import com.helpshift.p042db.conversation.tables.ConversationTable;
import com.helpshift.p042db.conversation.tables.MessagesTable;
import com.helpshift.p042db.smartintents.tables.SmartIntentModelsTable;
import com.helpshift.p042db.smartintents.tables.SmartIntentTreeTable;
import com.helpshift.p042db.user.tables.UserTable;
import com.helpshift.util.HSJSONUtils;
import com.helpshift.util.HSLogger;
import com.swrve.sdk.ISwrveCommon;
import com.vungle.warren.CleverCacheSettings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AndroidResponseParser implements ResponseParser {
    public static final int AVATAR_IMAGE_CACHE_DEFAULT_INTERVAL = 14400000;
    public static final int OPTIONS_MAX_LIMIT = 500;
    public static final long SMART_INTENT_CLIENT_CACHE_DEFAULT_INTERVAL = 259200000;
    public static final long SMART_INTENT_REFRESH_DEFAULT_INTERVAL = 600000;
    public static final String TAG = "Helpshift_AResponseParser";

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int convertDeliveryStateToInt(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -840272977(0xffffffffcdea73af, float:-4.91681248E8)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L_0x002b
            r1 = 3496342(0x355996, float:4.899419E-39)
            if (r0 == r1) goto L_0x0021
            r1 = 3526552(0x35cf98, float:4.941752E-39)
            if (r0 == r1) goto L_0x0017
            goto L_0x0035
        L_0x0017:
            java.lang.String r0 = "sent"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            r6 = 2
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "read"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            r6 = 1
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "unread"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            r6 = 0
            goto L_0x0036
        L_0x0035:
            r6 = -1
        L_0x0036:
            if (r6 == r4) goto L_0x003c
            if (r6 == r3) goto L_0x003b
            return r2
        L_0x003b:
            return r3
        L_0x003c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.platform.AndroidResponseParser.convertDeliveryStateToInt(java.lang.String):int");
    }

    private AdminActionCardMessageDM parseAdminActionCardMessageDM(JSONObject jSONObject) throws JSONException {
        String addMilliSeconds = HSDateFormatSpec.addMilliSeconds(HSDateFormatSpec.STORAGE_TIME_FORMAT, jSONObject.getString("created_at"), 1);
        long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(addMilliSeconds);
        JSONObject jSONObject2 = jSONObject.getJSONArray(ActionCardTable.TABLE_NAME).getJSONObject(0);
        JSONObject jSONObject3 = jSONObject2.getJSONArray("actions").getJSONObject(0);
        AdminActionCardMessageDM adminActionCardMessageDM = new AdminActionCardMessageDM(jSONObject.getString("id") + "_0", jSONObject.getString("body"), addMilliSeconds, convertToEpochTime, parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), jSONObject.getString("id"), new ActionCard(jSONObject2.optString("title"), jSONObject2.optString(ActionCardTable.Columns.IMAGE_URL), jSONObject2.optBoolean(ActionCardTable.Columns.IS_IMAGE_SECURE), new Action(jSONObject3.getString("display_text"), jSONObject3.getString("id"), ActionType.fromValue(jSONObject3.getString("type")), HSJSONUtils.toStringMap(jSONObject3.getJSONObject("data")))));
        adminActionCardMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
        adminActionCardMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
        return adminActionCardMessageDM;
    }

    /* JADX WARNING: type inference failed for: r10v4, types: [com.helpshift.conversation.activeconversation.message.MessageDM, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r11v17, types: [com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM] */
    /* JADX WARNING: type inference failed for: r11v18, types: [com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bb A[Catch:{ JSONException -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00db A[Catch:{ JSONException -> 0x0104 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.helpshift.conversation.activeconversation.message.MessageDM> parseAdminAttachmentEntities(org.json.JSONObject r29) {
        /*
            r28 = this;
            r1 = r28
            r0 = r29
            java.lang.String r2 = "redacted"
            java.lang.String r3 = "body"
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0104 }
            r4.<init>()     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r5 = "meta"
            org.json.JSONObject r5 = r0.optJSONObject(r5)     // Catch:{ JSONException -> 0x0104 }
            r6 = 0
            if (r5 == 0) goto L_0x001c
            java.lang.String r6 = "attachments"
            org.json.JSONArray r6 = r5.optJSONArray(r6)     // Catch:{ JSONException -> 0x0104 }
        L_0x001c:
            if (r6 == 0) goto L_0x0103
            int r5 = r6.length()     // Catch:{ JSONException -> 0x0104 }
            if (r5 != 0) goto L_0x0026
            goto L_0x0103
        L_0x0026:
            java.lang.String r5 = "id"
            java.lang.String r5 = r0.getString(r5)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r7 = "created_at"
            java.lang.String r7 = r0.getString(r7)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r8 = r0.getString(r3)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r9 = "author"
            org.json.JSONObject r9 = r0.getJSONObject(r9)     // Catch:{ JSONException -> 0x0104 }
            r10 = 0
            com.helpshift.conversation.activeconversation.message.Author r9 = r1.parseMessageAuthor(r9, r10)     // Catch:{ JSONException -> 0x0104 }
            boolean r24 = r0.optBoolean(r2, r10)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r11 = "md_state"
            java.lang.String r12 = ""
            java.lang.String r0 = r0.optString(r11, r12)     // Catch:{ JSONException -> 0x0104 }
            int r0 = r1.convertDeliveryStateToInt(r0)     // Catch:{ JSONException -> 0x0104 }
            r11 = 0
        L_0x0052:
            int r12 = r6.length()     // Catch:{ JSONException -> 0x0104 }
            if (r11 >= r12) goto L_0x0103
            org.json.JSONObject r12 = r6.getJSONObject(r11)     // Catch:{ JSONException -> 0x0104 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0104 }
            r13.<init>()     // Catch:{ JSONException -> 0x0104 }
            r13.append(r5)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r5 = "_"
            r13.append(r5)     // Catch:{ JSONException -> 0x0104 }
            r13.append(r11)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r5 = r13.toString()     // Catch:{ JSONException -> 0x0104 }
            com.helpshift.util.HSSimpleDateFormat r13 = com.helpshift.common.util.HSDateFormatSpec.STORAGE_TIME_FORMAT     // Catch:{ JSONException -> 0x0104 }
            int r15 = r11 + 1
            java.lang.String r14 = com.helpshift.common.util.HSDateFormatSpec.addMilliSeconds(r13, r7, r15)     // Catch:{ JSONException -> 0x0104 }
            long r16 = com.helpshift.common.util.HSDateFormatSpec.convertToEpochTime(r14)     // Catch:{ JSONException -> 0x0104 }
            boolean r11 = r12.has(r3)     // Catch:{ JSONException -> 0x0104 }
            if (r11 == 0) goto L_0x0088
            java.lang.String r11 = r12.getString(r3)     // Catch:{ JSONException -> 0x0104 }
            r13 = r11
            goto L_0x0089
        L_0x0088:
            r13 = r8
        L_0x0089:
            java.lang.String r11 = "url"
            java.lang.String r20 = r12.getString(r11)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r11 = "content-type"
            java.lang.String r21 = r12.getString(r11)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r11 = "size"
            int r23 = r12.getInt(r11)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r11 = "file-name"
            java.lang.String r22 = r12.getString(r11)     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r11 = "secure?"
            boolean r25 = r12.optBoolean(r11, r10)     // Catch:{ JSONException -> 0x0104 }
            if (r24 != 0) goto L_0x00b2
            boolean r11 = r12.optBoolean(r2, r10)     // Catch:{ JSONException -> 0x0104 }
            if (r11 == 0) goto L_0x00b0
            goto L_0x00b2
        L_0x00b0:
            r11 = 0
            goto L_0x00b3
        L_0x00b2:
            r11 = 1
        L_0x00b3:
            java.lang.String r10 = "image"
            boolean r10 = r12.optBoolean(r10)     // Catch:{ JSONException -> 0x0104 }
            if (r10 == 0) goto L_0x00db
            com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM r10 = new com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM     // Catch:{ JSONException -> 0x0104 }
            java.lang.String r1 = "thumbnail"
            java.lang.String r1 = r12.getString(r1)     // Catch:{ JSONException -> 0x0104 }
            r12 = r11
            r11 = r10
            r26 = r2
            r2 = r12
            r12 = r5
            r27 = r15
            r15 = r16
            r17 = r9
            r18 = r20
            r19 = r22
            r20 = r1
            r22 = r25
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ JSONException -> 0x0104 }
            goto L_0x00f3
        L_0x00db:
            r26 = r2
            r2 = r11
            r27 = r15
            com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM r10 = new com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM     // Catch:{ JSONException -> 0x0104 }
            r11 = r10
            r12 = r5
            r15 = r16
            r17 = r9
            r18 = r23
            r19 = r21
            r21 = r22
            r22 = r25
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r21, r22)     // Catch:{ JSONException -> 0x0104 }
        L_0x00f3:
            r10.deliveryState = r0     // Catch:{ JSONException -> 0x0104 }
            r10.isRedacted = r2     // Catch:{ JSONException -> 0x0104 }
            r4.add(r10)     // Catch:{ JSONException -> 0x0104 }
            r1 = r28
            r2 = r26
            r11 = r27
            r10 = 0
            goto L_0x0052
        L_0x0103:
            return r4
        L_0x0104:
            r0 = move-exception
            com.helpshift.common.exception.ParseException r1 = com.helpshift.common.exception.ParseException.GENERIC
            java.lang.String r2 = "Parsing exception while reading admin attachment message"
            com.helpshift.common.exception.RootAPIException r0 = com.helpshift.common.exception.RootAPIException.wrap(r0, r1, r2)
            goto L_0x010f
        L_0x010e:
            throw r0
        L_0x010f:
            goto L_0x010e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.platform.AndroidResponseParser.parseAdminAttachmentEntities(org.json.JSONObject):java.util.List");
    }

    private MessageDM parseAdminCSATMessageWithRatingInputDM(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("input");
            String string = jSONObject2.getString("created_at");
            long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(string);
            boolean optBoolean = jSONObject3.optBoolean("show_new_conversation_button", true);
            String string2 = jSONObject2.getString("id");
            String string3 = jSONObject2.getString("body");
            Author parseMessageAuthor = parseMessageAuthor(jSONObject2.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false);
            String jSONObject4 = jSONObject2.getJSONObject("chatbot_info").toString();
            boolean z = jSONObject3.getBoolean("required");
            String string4 = jSONObject3.getString("label");
            String optString = jSONObject3.optString("skip_label");
            String optString2 = jSONObject3.optString("submit_feedback_button_text");
            String optString3 = jSONObject3.optString("show_new_conversation_button_text");
            AdminCSATMessageWithOptions adminCSATMessageWithOptions = new AdminCSATMessageWithOptions(string2, string3, string, convertToEpochTime, parseMessageAuthor, jSONObject4, z, string4, optString, optString2, optBoolean, optString3, parseRatingsInput(jSONObject3), CSATRatingsInput.Type.STAR_5);
            adminCSATMessageWithOptions.deliveryState = convertDeliveryStateToInt(jSONObject2.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            adminCSATMessageWithOptions.isRedacted = jSONObject2.optBoolean("redacted", false);
            return adminCSATMessageWithOptions;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading admin resolution message with option input");
        }
    }

    private AdminMessageWithTextInputDM parseAdminEmptyMessageWithTextInputDM(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("input");
            String string = jSONObject2.getString("created_at");
            AdminMessageWithTextInputDM adminMessageWithTextInputDM = new AdminMessageWithTextInputDM(jSONObject2.getString("id"), "", string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject2.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), jSONObject2.getJSONObject("chatbot_info").toString(), jSONObject3.getString("placeholder"), jSONObject3.getBoolean("required"), jSONObject3.getString("label"), jSONObject3.optString("skip_label"), 1, true);
            adminMessageWithTextInputDM.deliveryState = convertDeliveryStateToInt(jSONObject2.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            adminMessageWithTextInputDM.isRedacted = jSONObject2.optBoolean("redacted", false);
            return adminMessageWithTextInputDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading admin empty message with text input");
        }
    }

    private void parseAdminMessage(String str, JSONObject jSONObject, List<MessageDM> list) {
        ArrayList arrayList = new ArrayList();
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1267395154:
                    if (str.equals("txt_csat_msg_with_option_input")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1052767485:
                    if (str.equals("faq_list_msg_with_option_input")) {
                        c = 11;
                        break;
                    }
                    break;
                case -739846729:
                    if (str.equals("txt_resolution_msg_with_option_input")) {
                        c = 13;
                        break;
                    }
                    break;
                case -185416997:
                    if (str.equals("txt_msg_with_email_input")) {
                        c = 2;
                        break;
                    }
                    break;
                case 112675:
                    if (str.equals("rar")) {
                        c = 7;
                        break;
                    }
                    break;
                case 112830:
                    if (str.equals("rfr")) {
                        c = 9;
                        break;
                    }
                    break;
                case 113218:
                    if (str.equals("rsc")) {
                        c = 8;
                        break;
                    }
                    break;
                case 115312:
                    if (str.equals("txt")) {
                        c = 0;
                        break;
                    }
                    break;
                case 61080689:
                    if (str.equals("txt_msg_with_actions")) {
                        c = 12;
                        break;
                    }
                    break;
                case 133418599:
                    if (str.equals("txt_msg_with_dt_input")) {
                        c = 4;
                        break;
                    }
                    break;
                case 373335180:
                    if (str.equals("txt_msg_with_option_input")) {
                        c = 6;
                        break;
                    }
                    break;
                case 534550447:
                    if (str.equals("txt_msg_with_txt_input")) {
                        c = 1;
                        break;
                    }
                    break;
                case 892689447:
                    if (str.equals("faq_list")) {
                        c = 10;
                        break;
                    }
                    break;
                case 903982601:
                    if (str.equals(BotControlActions.BOT_STARTED)) {
                        c = 15;
                        break;
                    }
                    break;
                case 1564911026:
                    if (str.equals("empty_msg_with_txt_input")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1829173826:
                    if (str.equals(BotControlActions.BOT_ENDED)) {
                        c = 16;
                        break;
                    }
                    break;
                case 2114645132:
                    if (str.equals("txt_msg_with_numeric_input")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    arrayList.addAll(parseAdminMessageDM(jSONObject));
                    break;
                case 1:
                    arrayList.addAll(parseAdminMessageWithTextInputDM(jSONObject, 1));
                    break;
                case 2:
                    arrayList.addAll(parseAdminMessageWithTextInputDM(jSONObject, 2));
                    break;
                case 3:
                    arrayList.addAll(parseAdminMessageWithTextInputDM(jSONObject, 3));
                    break;
                case 4:
                    arrayList.addAll(parseAdminMessageWithTextInputDM(jSONObject, 4));
                    break;
                case 5:
                    arrayList.add(parseAdminEmptyMessageWithTextInputDM(jSONObject));
                    break;
                case 6:
                    arrayList.addAll(parseAdminMessageWithOptionInputDM(jSONObject));
                    break;
                case 7:
                    arrayList.add(parseRequestAppReviewMessageDM(jSONObject));
                    break;
                case 8:
                    arrayList.addAll(parseRequestScreenshotMessageDM(jSONObject));
                    break;
                case 9:
                    arrayList.add(parseRequestForReopenMessageDM(jSONObject));
                    break;
                case 10:
                    arrayList.add(parseFAQListMessageDM(jSONObject));
                    break;
                case 11:
                    arrayList.add(parseFAQListMessageWitOptionInputDM(jSONObject));
                    break;
                case 12:
                    arrayList.addAll(parseAdminMessageWithActionCardMessageDM(jSONObject));
                    break;
                case 13:
                    arrayList.addAll(parseAdminResolutionMessageWithOptionInputDM(jSONObject));
                    break;
                case 14:
                    arrayList.add(parseAdminCSATMessageWithRatingInputDM(jSONObject));
                    break;
                case 15:
                case 16:
                    arrayList.add(parseBotControlMessage(jSONObject.toString(), true));
                    break;
                default:
                    if (jSONObject.has("input")) {
                        arrayList.add(parseUnsupportedAdminMessageWithInput(jSONObject.toString()));
                        break;
                    }
                    break;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((MessageDM) it.next()).isFeedbackMessage = jSONObject.optBoolean("feedback_message", false);
            }
            list.addAll(arrayList);
        } catch (RootAPIException e) {
            HSLogger.m3242e(TAG, "Exception while parsing messages: ", e);
        }
    }

    private List<MessageDM> parseAdminMessageDM(JSONObject jSONObject) {
        try {
            ArrayList arrayList = new ArrayList();
            String string = jSONObject.getString("created_at");
            AdminMessageDM adminMessageDM = new AdminMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false));
            adminMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            adminMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            arrayList.add(adminMessageDM);
            arrayList.addAll(parseAdminAttachmentEntities(jSONObject));
            return arrayList;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading admin text message");
        }
    }

    private List<MessageDM> parseAdminMessageWithActionCardMessageDM(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            String string = jSONObject.getString("created_at");
            AdminMessageDM adminMessageDM = new AdminMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false));
            adminMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            adminMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            arrayList.add(adminMessageDM);
            arrayList.add(parseAdminActionCardMessageDM(jSONObject));
            return arrayList;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading admin action card message");
        }
    }

    private List<MessageDM> parseAdminMessageWithOptionInputDM(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject3 = jSONObject2.getJSONObject("input");
            String string = jSONObject2.getString("created_at");
            long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(string);
            AdminMessageWithOptionInputDM adminMessageWithOptionInputDM = new AdminMessageWithOptionInputDM(jSONObject2.getString("id"), jSONObject2.getString("body"), string, convertToEpochTime, parseMessageAuthor(jSONObject2.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), jSONObject2.getJSONObject("chatbot_info").toString(), jSONObject3.getBoolean("required"), jSONObject3.getString("label"), jSONObject3.optString("skip_label"), parseOptions(jSONObject3), parseOptionType(jSONObject3));
            adminMessageWithOptionInputDM.deliveryState = convertDeliveryStateToInt(jSONObject2.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            adminMessageWithOptionInputDM.isRedacted = jSONObject2.optBoolean("redacted", false);
            List<MessageDM> parseAdminAttachmentEntities = parseAdminAttachmentEntities(jSONObject);
            adminMessageWithOptionInputDM.attachmentCount = parseAdminAttachmentEntities.size();
            ArrayList arrayList2 = arrayList;
            arrayList2.add(adminMessageWithOptionInputDM);
            arrayList2.addAll(parseAdminAttachmentEntities);
            return arrayList2;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading admin text message with option input");
        }
    }

    private List<MessageDM> parseAdminMessageWithTextInputDM(JSONObject jSONObject, int i) {
        JSONObject jSONObject2 = jSONObject;
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject3 = jSONObject2.getJSONObject("input");
            String string = jSONObject2.getString("created_at");
            long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(string);
            AdminMessageWithTextInputDM adminMessageWithTextInputDM = new AdminMessageWithTextInputDM(jSONObject2.getString("id"), jSONObject2.getString("body"), string, convertToEpochTime, parseMessageAuthor(jSONObject2.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), jSONObject2.getJSONObject("chatbot_info").toString(), jSONObject3.getString("placeholder"), jSONObject3.getBoolean("required"), jSONObject3.getString("label"), jSONObject3.optString("skip_label"), i, false);
            adminMessageWithTextInputDM.deliveryState = convertDeliveryStateToInt(jSONObject2.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            adminMessageWithTextInputDM.isRedacted = jSONObject2.optBoolean("redacted", false);
            ArrayList arrayList2 = arrayList;
            arrayList2.add(adminMessageWithTextInputDM);
            arrayList2.addAll(parseAdminAttachmentEntities(jSONObject));
            return arrayList2;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading admin message with text input");
        }
    }

    private List<MessageDM> parseAdminResolutionMessageWithOptionInputDM(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("input");
            String string = jSONObject2.getString("created_at");
            long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(string);
            AdminResolutionMessageWithOptions adminResolutionMessageWithOptions = new AdminResolutionMessageWithOptions(jSONObject2.getString("id"), jSONObject2.getString("body"), string, convertToEpochTime, parseMessageAuthor(jSONObject2.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), jSONObject2.getJSONObject("chatbot_info").toString(), jSONObject3.getBoolean("required"), jSONObject3.getString("label"), jSONObject3.optString("skip_label"), parseOptions(jSONObject3), parseOptionType(jSONObject3));
            adminResolutionMessageWithOptions.deliveryState = convertDeliveryStateToInt(jSONObject2.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            adminResolutionMessageWithOptions.isRedacted = jSONObject2.optBoolean("redacted", false);
            List<MessageDM> parseAdminAttachmentEntities = parseAdminAttachmentEntities(jSONObject);
            adminResolutionMessageWithOptions.attachmentCount = parseAdminAttachmentEntities.size();
            ArrayList arrayList2 = arrayList;
            arrayList2.add(adminResolutionMessageWithOptions);
            arrayList2.addAll(parseAdminAttachmentEntities);
            return arrayList2;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading admin resolution message with option input");
        }
    }

    private void parseAndSetDataForUserSentMessages(MessageDM messageDM, JSONObject jSONObject) throws JSONException {
        messageDM.author = parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), !(messageDM instanceof ConfirmationRejectedMessageDM));
        messageDM.createdRequestId = jSONObject.optString("request_id");
    }

    private AvatarConfig parseAvatarKeys(JSONObject jSONObject) throws JSONException {
        return new AvatarConfig(jSONObject.optBoolean("savtr", false), jSONObject.optBoolean("pagnt", false), jSONObject.optString("af", ""), jSONObject.optBoolean("pbot", false), jSONObject.optString("bf", ""), jSONObject.optString("snn", ""), jSONObject.optString("turl", ""), (long) jSONObject.optInt("ce", AVATAR_IMAGE_CACHE_DEFAULT_INTERVAL));
    }

    private boolean parseDisableHelpshiftBrandingValue(JSONObject jSONObject) {
        if (jSONObject != null) {
            return !jSONObject.optBoolean("hl", true);
        }
        return false;
    }

    private List<FAQListMessageDM.FAQ> parseFAQList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            arrayList.add(new FAQListMessageDM.FAQ(jSONObject.getString("title"), jSONObject2.getString("publish_id"), jSONObject2.getString("language")));
        }
        return arrayList;
    }

    private FAQListMessageDM parseFAQListMessageDM(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("created_at");
            FAQListMessageDM fAQListMessageDM = new FAQListMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), parseFAQList(jSONObject.getJSONArray("faqs")), jSONObject.optString("faq_source"));
            fAQListMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            fAQListMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            return fAQListMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading faq list message");
        }
    }

    private MessageDM parseFAQListMessageWitOptionInputDM(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("input");
            String string = jSONObject2.getString("created_at");
            long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(string);
            FAQListMessageWithOptionInputDM fAQListMessageWithOptionInputDM = new FAQListMessageWithOptionInputDM(jSONObject2.getString("id"), jSONObject2.getString("body"), string, convertToEpochTime, parseMessageAuthor(jSONObject2.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), parseFAQList(jSONObject2.getJSONArray("faqs")), jSONObject2.optString("faq_source"), jSONObject2.getJSONObject("chatbot_info").toString(), jSONObject3.getBoolean("required"), jSONObject3.getString("label"), jSONObject3.optString("skip_label"), parseOptions(jSONObject3));
            fAQListMessageWithOptionInputDM.deliveryState = convertDeliveryStateToInt(jSONObject2.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            fAQListMessageWithOptionInputDM.isRedacted = jSONObject2.optBoolean("redacted", false);
            return fAQListMessageWithOptionInputDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading list message with option input");
        }
    }

    private FollowupAcceptedMessageDM parseFollowupAcceptedMessageDM(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("created_at");
            FollowupAcceptedMessageDM followupAcceptedMessageDM = new FollowupAcceptedMessageDM(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), true), jSONObject.getJSONObject("meta").getString("refers"), 2);
            followupAcceptedMessageDM.serverId = jSONObject.getString("id");
            followupAcceptedMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            followupAcceptedMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(followupAcceptedMessageDM, jSONObject);
            return followupAcceptedMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading follow-up accepted message");
        }
    }

    private FollowupRejectedMessageDM parseFollowupRejectedMessageDM(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("created_at");
            FollowupRejectedMessageDM followupRejectedMessageDM = new FollowupRejectedMessageDM(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), true), jSONObject.getJSONObject("meta").getString("refers"), 2);
            followupRejectedMessageDM.serverId = jSONObject.getString("id");
            followupRejectedMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            followupRejectedMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(followupRejectedMessageDM, jSONObject);
            return followupRejectedMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading follow-up rejected message");
        }
    }

    private void parseIsFeedbackMessage(MessageDM messageDM, JSONObject jSONObject) {
        messageDM.isFeedbackMessage = jSONObject.optBoolean("feedback_message", false);
    }

    private Author parseMessageAuthor(JSONObject jSONObject, boolean z) {
        Author.AuthorRole authorRole;
        if (z) {
            try {
                authorRole = Author.AuthorRole.LOCAL_USER;
            } catch (JSONException e) {
                throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading author of message");
            }
        } else {
            authorRole = Author.AuthorRole.SYSTEM;
        }
        if (jSONObject.has("role")) {
            authorRole = Author.AuthorRole.getEnum(jSONObject.getString("role"));
        }
        return new Author(jSONObject.getString("name"), jSONObject.getString("id"), authorRole);
    }

    private List<MessageDM> parseMessageDMs(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("type");
                String string2 = jSONObject.getString("origin");
                if ("admin".equals(string2)) {
                    parseAdminMessage(string, jSONObject, arrayList);
                } else if (ISwrveCommon.DEVICE_TYPE_MOBILE.equals(string2)) {
                    parseMobileMessage(string, jSONObject, arrayList);
                } else {
                    HSLogger.m3241e(TAG, "Unknown message type received.");
                }
            } catch (RootAPIException | JSONException e) {
                HSLogger.m3242e(TAG, "Exception while parsing messages: ", e);
            }
        }
        return arrayList;
    }

    private void parseMobileMessage(String str, JSONObject jSONObject, List<MessageDM> list) {
        ArrayList arrayList = new ArrayList();
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -904450649:
                    if (str.equals("rsp_txt_resolution_msg_with_option_input")) {
                        c = 16;
                        break;
                    }
                    break;
                case -872275554:
                    if (str.equals("rsp_txt_csat_msg_with_option_input")) {
                        c = 17;
                        break;
                    }
                    break;
                case -831290677:
                    if (str.equals("rsp_txt_msg_with_email_input")) {
                        c = 11;
                        break;
                    }
                    break;
                case -657647885:
                    if (str.equals("rsp_faq_list_msg_with_option_input")) {
                        c = 15;
                        break;
                    }
                    break;
                case -545696551:
                    if (str.equals(BotControlActions.BOT_CANCELLED)) {
                        c = 18;
                        break;
                    }
                    break;
                case -94670724:
                    if (str.equals("rsp_txt_msg_with_numeric_input")) {
                        c = 12;
                        break;
                    }
                    break;
                case 3121:
                    if (str.equals("ar")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3123:
                    if (str.equals("at")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3166:
                    if (str.equals("ca")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3631:
                    if (str.equals("ra")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3640:
                    if (str.equals("rj")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3664:
                    if (str.equals("sc")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3670:
                    if (str.equals("si")) {
                        c = 8;
                        break;
                    }
                    break;
                case 108893:
                    if (str.equals("ncr")) {
                        c = 2;
                        break;
                    }
                    break;
                case 115312:
                    if (str.equals("txt")) {
                        c = 0;
                        break;
                    }
                    break;
                case 493654943:
                    if (str.equals("rsp_txt_msg_with_txt_input")) {
                        c = 10;
                        break;
                    }
                    break;
                case 919037346:
                    if (str.equals("rsp_empty_msg_with_txt_input")) {
                        c = 9;
                        break;
                    }
                    break;
                case 1826087580:
                    if (str.equals("rsp_txt_msg_with_option_input")) {
                        c = 14;
                        break;
                    }
                    break;
                case 2071762039:
                    if (str.equals("rsp_txt_msg_with_dt_input")) {
                        c = 13;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    arrayList.add(parseReadableUserMessage(jSONObject.toString()));
                    break;
                case 1:
                    arrayList.add(parseAcceptedAppReviewMessageDM(jSONObject.toString()));
                    break;
                case 2:
                    arrayList.add(parseConfirmationRejectedMessageDM(jSONObject.toString()));
                    break;
                case 3:
                    arrayList.add(parseConfirmationAcceptedMessageDM(jSONObject.toString()));
                    break;
                case 4:
                    arrayList.add(parseScreenshotMessageDM(jSONObject));
                    break;
                case 5:
                    arrayList.add(parseUserAttachmentMessageDM(jSONObject));
                    break;
                case 6:
                    arrayList.add(parseFollowupAcceptedMessageDM(jSONObject));
                    break;
                case 7:
                    arrayList.add(parseFollowupRejectedMessageDM(jSONObject));
                    break;
                case 8:
                    arrayList.add(parseUserSmartIntentMessage(jSONObject.toString()));
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    arrayList.add(parseResponseMessageForTextInput(jSONObject.toString()));
                    break;
                case 14:
                case 15:
                case 16:
                    arrayList.add(parseResponseMessageForOptionInput(jSONObject.toString()));
                    break;
                case 17:
                    arrayList.add(parseResponseMessageForCSATInput(jSONObject.toString()));
                    break;
                case 18:
                    arrayList.add(parseBotControlMessage(jSONObject.toString(), false));
                    break;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                parseIsFeedbackMessage((MessageDM) it.next(), jSONObject);
            }
            list.addAll(arrayList);
        } catch (RootAPIException e) {
            HSLogger.m3242e(TAG, "Exception while parsing messages: ", e);
        }
    }

    private OptionInput.Type parseOptionType(JSONObject jSONObject) throws JSONException {
        return OptionInput.Type.getType(jSONObject.optString("type"), jSONObject.getJSONArray("options").length());
    }

    private List<OptionInput.Option> parseOptions(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("options");
        int min = Math.min(jSONArray.length(), 500);
        for (int i = 0; i < min; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            arrayList.add(new OptionInput.Option(jSONObject2.getString("title"), jSONObject2.getJSONObject("data").toString()));
        }
        return arrayList;
    }

    private PeriodicReview parsePeriodicReview(JSONObject jSONObject) throws JSONException {
        return new PeriodicReview(jSONObject.optBoolean(AnalyticsEventKey.SEARCH_QUERY), jSONObject.optInt("i"), jSONObject.optString("t", ""));
    }

    private List<CSATRatingsInput.Rating> parseRatingsInput(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("ratings");
        int min = Math.min(jSONArray.length(), 500);
        for (int i = 0; i < min; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
            arrayList.add(new CSATRatingsInput.Rating(jSONObject2.getString("title"), jSONObject3.optInt("value", 1), jSONObject3.toString()));
        }
        return arrayList;
    }

    private RequestAppReviewMessageDM parseRequestAppReviewMessageDM(JSONObject jSONObject) {
        boolean z;
        try {
            JSONObject optJSONObject = jSONObject.getJSONObject("meta").optJSONObject(AnalyticsEventKey.RESPONSE);
            boolean optBoolean = optJSONObject != null ? optJSONObject.optBoolean("state") : false;
            if (!jSONObject.optBoolean("invisible")) {
                if (!optBoolean) {
                    z = false;
                    String string = jSONObject.getString("created_at");
                    RequestAppReviewMessageDM requestAppReviewMessageDM = new RequestAppReviewMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), z);
                    requestAppReviewMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
                    requestAppReviewMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
                    return requestAppReviewMessageDM;
                }
            }
            z = true;
            String string2 = jSONObject.getString("created_at");
            RequestAppReviewMessageDM requestAppReviewMessageDM2 = new RequestAppReviewMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string2, HSDateFormatSpec.convertToEpochTime(string2), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), z);
            requestAppReviewMessageDM2.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            requestAppReviewMessageDM2.isRedacted = jSONObject.optBoolean("redacted", false);
            return requestAppReviewMessageDM2;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading request review message");
        }
    }

    private RequestForReopenMessageDM parseRequestForReopenMessageDM(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("created_at");
            RequestForReopenMessageDM requestForReopenMessageDM = new RequestForReopenMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false));
            requestForReopenMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            requestForReopenMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            return requestForReopenMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading reopen message");
        }
    }

    private List<MessageDM> parseRequestScreenshotMessageDM(JSONObject jSONObject) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject optJSONObject = jSONObject.getJSONObject("meta").optJSONObject(AnalyticsEventKey.RESPONSE);
            boolean z = optJSONObject != null ? optJSONObject.getBoolean("state") : false;
            String string = jSONObject.getString("created_at");
            RequestScreenshotMessageDM requestScreenshotMessageDM = new RequestScreenshotMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), z);
            requestScreenshotMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            requestScreenshotMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            arrayList.add(requestScreenshotMessageDM);
            arrayList.addAll(parseAdminAttachmentEntities(jSONObject));
            return arrayList;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading request screenshot message");
        }
    }

    private List<SmartIntentDTO> parseSmartIntents(String str, JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length == 0) {
            return arrayList;
        }
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("id");
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            List<SmartIntentDTO> list = null;
            if (optJSONArray != null) {
                list = parseSmartIntents(string, optJSONArray);
            }
            arrayList.add(new SmartIntentDTO(jSONObject.getString("label"), string, str, list));
        }
        return arrayList;
    }

    private UnsupportedAdminMessageWithInputDM parseUnsupportedAdminMessageWithInput(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("created_at");
            return new UnsupportedAdminMessageWithInputDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), jSONObject.getString("type"), jSONObject.getJSONObject("chatbot_info").toString(), jSONObject.getJSONObject("input").toString());
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading unsupported admin message with input");
        }
    }

    public AcceptedAppReviewMessageDM parseAcceptedAppReviewMessageDM(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("created_at");
            AcceptedAppReviewMessageDM acceptedAppReviewMessageDM = new AcceptedAppReviewMessageDM(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), true), jSONObject.getJSONObject("meta").getString("refers"), 2);
            acceptedAppReviewMessageDM.serverId = jSONObject.getString("id");
            acceptedAppReviewMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            acceptedAppReviewMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(acceptedAppReviewMessageDM, jSONObject);
            return acceptedAppReviewMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading accepted review message");
        }
    }

    public WebSocketAuthData parseAuthToken(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new WebSocketAuthData(jSONObject.getString("token"), jSONObject.getString("endpoint"));
        } catch (JSONException e) {
            HSLogger.m3242e(TAG, "Exception in parsing auth token", e);
            return null;
        }
    }

    public MessageDM parseBotControlMessage(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            String string2 = jSONObject.getString("id");
            String jSONObject2 = jSONObject.getJSONObject("chatbot_info").toString();
            boolean optBoolean = jSONObject.optBoolean("redacted", false);
            String string3 = jSONObject.getString("created_at");
            long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(string3);
            if (z) {
                AdminBotControlMessageDM adminBotControlMessageDM = new AdminBotControlMessageDM(string2, jSONObject.getString("body"), string3, convertToEpochTime, parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), string, jSONObject2);
                adminBotControlMessageDM.hasNextBot = jSONObject.optBoolean("has_next_bot", false);
                adminBotControlMessageDM.isRedacted = optBoolean;
                return adminBotControlMessageDM;
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("meta");
            String string4 = jSONObject3.getString("chatbot_cancelled_reason");
            String string5 = jSONObject3.getString("refers");
            String str2 = string;
            UserBotControlMessageDM userBotControlMessageDM = r3;
            UserBotControlMessageDM userBotControlMessageDM2 = new UserBotControlMessageDM(jSONObject.getString("body"), string3, convertToEpochTime, parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), true), str2, string4, jSONObject2, string5, 2);
            userBotControlMessageDM.serverId = string2;
            userBotControlMessageDM.isRedacted = optBoolean;
            parseAndSetDataForUserSentMessages(userBotControlMessageDM, jSONObject);
            return userBotControlMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading bot control messages.");
        }
    }

    public RootServerConfig parseConfigResponse(String str) {
        Long l;
        Long l2;
        Long l3;
        boolean z;
        String str2;
        String str3;
        boolean z2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            AvatarConfig avatarConfig = null;
            Long valueOf = jSONObject.has("last_redaction_at") ? Long.valueOf(jSONObject.getLong("last_redaction_at")) : null;
            Long valueOf2 = jSONObject.has("profile_created_at") ? Long.valueOf(jSONObject.getLong("profile_created_at")) : null;
            long optLong = jSONObject.optLong("pfi", 0) / 1000;
            long optLong2 = jSONObject.optLong("pri", 0) / 1000;
            boolean optBoolean = jSONObject.optBoolean("afp", false);
            if (jSONObject.has("si")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("si");
                boolean z3 = jSONObject2.getBoolean(CleverCacheSettings.KEY_ENABLED);
                Long valueOf3 = Long.valueOf(jSONObject2.optLong("tree_sla", 600000));
                Long valueOf4 = Long.valueOf(jSONObject2.optLong("model_sla", 600000));
                l = Long.valueOf(jSONObject2.optLong("cache_sla", 259200000));
                z = z3;
                l2 = valueOf3;
                l3 = valueOf4;
            } else {
                l3 = null;
                l2 = null;
                l = null;
                z = false;
            }
            ArrayList<ArrayList<String>> nestedJsonArrayToNestedArrayList = HSJSONUtils.nestedJsonArrayToNestedArrayList(jSONObject.optString("wa", "[[\"*/*\"]]"));
            int optInt = jSONObject.optInt("ll", LogLevel.FATAL.getValue());
            if (jSONObject.has("hdr")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("hdr");
                boolean optBoolean2 = jSONObject3.optBoolean("sh", false);
                String optString = jSONObject3.optString("htxt", "");
                str2 = jSONObject3.optString("hurl", "");
                z2 = optBoolean2;
                str3 = optString;
            } else {
                str3 = "";
                str2 = str3;
                z2 = false;
            }
            if (jSONObject.has("avtr")) {
                avatarConfig = parseAvatarKeys(jSONObject.getJSONObject("avtr"));
            }
            return new RootServerConfig(jSONObject.optBoolean("rne", false), jSONObject.optBoolean("pfe", true), jSONObject.optBoolean("csat", false), jSONObject.optBoolean("dia", false), parseDisableHelpshiftBrandingValue(jSONObject.optJSONObject("t")), jSONObject.optBoolean(UserTable.Columns.ISSUE_EXISTS, true), jSONObject.optInt("dbgl", 100), jSONObject.optInt("bcl", 100), jSONObject.optString("rurl", ""), parsePeriodicReview(jSONObject.getJSONObject("pr")), jSONObject.optBoolean("ic", false), jSONObject.optString("gm", ""), jSONObject.optBoolean("tyi", true), jSONObject.optBoolean("rq", false), jSONObject.optBoolean("conversation_history_enabled", false), valueOf, valueOf2, jSONObject.optBoolean("allow_user_attachments", true), optLong, optLong2, optBoolean, z, l3, l2, l, nestedJsonArrayToNestedArrayList, optInt, z2, str3, str2, avatarConfig, jSONObject.optBoolean("asae", true), jSONObject.optLong("pasi", 0));
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while fetching config");
        }
    }

    public ConfirmationAcceptedMessageDM parseConfirmationAcceptedMessageDM(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("created_at");
            ConfirmationAcceptedMessageDM confirmationAcceptedMessageDM = new ConfirmationAcceptedMessageDM(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), true), 2);
            confirmationAcceptedMessageDM.serverId = jSONObject.getString("id");
            confirmationAcceptedMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            confirmationAcceptedMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(confirmationAcceptedMessageDM, jSONObject);
            return confirmationAcceptedMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading confirmation accepted message");
        }
    }

    public ConfirmationRejectedMessageDM parseConfirmationRejectedMessageDM(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("created_at");
            ConfirmationRejectedMessageDM confirmationRejectedMessageDM = new ConfirmationRejectedMessageDM(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), false), 2);
            confirmationRejectedMessageDM.serverId = jSONObject.getString("id");
            confirmationRejectedMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            confirmationRejectedMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(confirmationRejectedMessageDM, jSONObject);
            return confirmationRejectedMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading confirmation rejected message");
        }
    }

    public ConversationHistory parseConversationHistory(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(ConversationTable.TABLE_NAME);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(parseReadableConversation(jSONArray.getJSONObject(i).toString()));
            }
            return new ConversationHistory(arrayList, jSONObject.getBoolean("has_older_messages"));
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading conversation history");
        }
    }

    public ConversationInbox parseConversationInbox(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(ConversationTable.TABLE_NAME);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(parseReadableConversation(jSONArray.getJSONObject(i).toString()));
            }
            Boolean bool = null;
            if (jSONObject.has("has_older_messages")) {
                bool = Boolean.valueOf(jSONObject.getBoolean("has_older_messages"));
            }
            return new ConversationInbox(jSONObject.getString("cursor"), arrayList, jSONObject.getBoolean(UserTable.Columns.ISSUE_EXISTS), bool);
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading conversation inbox");
        }
    }

    public String parseErrorMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has(NotificationCompat.CATEGORY_MESSAGE) ? jSONObject.getString(NotificationCompat.CATEGORY_MESSAGE) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public FollowupAcceptedMessageDM parseFollowupAcceptedMessage(String str) {
        try {
            return parseFollowupAcceptedMessageDM(new JSONObject(str));
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading follow-up accepted message");
        }
    }

    public FollowupRejectedMessageDM parseFollowupRejectedMessage(String str) {
        try {
            return parseFollowupRejectedMessageDM(new JSONObject(str));
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading follow-up rejected message");
        }
    }

    public Conversation parseReadableConversation(String str) {
        ArrayList<String> arrayList;
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                List<MessageDM> parseMessageDMs = parseMessageDMs(jSONObject.getJSONArray("messages"));
                int size = parseMessageDMs.size() - 1;
                while (true) {
                    arrayList = null;
                    if (size < 0) {
                        str2 = null;
                        break;
                    }
                    MessageDM messageDM = parseMessageDMs.get(size);
                    if (!(messageDM instanceof AdminAttachmentMessageDM) && !(messageDM instanceof AdminImageAttachmentMessageDM)) {
                        str2 = messageDM.getCreatedAt();
                        break;
                    }
                    size--;
                }
                IssueState fromInt = IssueState.fromInt(jSONObject.getInt("state"));
                String string = jSONObject.getString("created_at");
                long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(string);
                String string2 = jSONObject.getString("type");
                Conversation conversation = new Conversation(jSONObject.optString("title", ""), fromInt, string, convertToEpochTime, jSONObject.getString(ConversationTable.Columns.UPDATED_AT), jSONObject.getString("publish_id"), str2, string2, jSONObject.isNull("acid") ? null : jSONObject.getString("acid"));
                conversation.isRedacted = jSONObject.optBoolean("redacted", false);
                conversation.serverId = jSONObject.isNull(AnalyticsEventKey.ISSUE_ID) ? null : jSONObject.getString(AnalyticsEventKey.ISSUE_ID);
                conversation.preConversationServerId = jSONObject.isNull(AnalyticsEventKey.PREISSUE_ID) ? null : jSONObject.getString(AnalyticsEventKey.PREISSUE_ID);
                conversation.issueType = string2;
                conversation.createdRequestId = jSONObject.optString("request_id");
                if (!jSONObject.isNull("intent")) {
                    arrayList = HSJSONUtils.jsonArrayToStringArrayList(jSONObject.getString("intent"));
                }
                conversation.smartIntentIds = arrayList;
                if (IssueType.ISSUE.equals(string2)) {
                    conversation.csatState = jSONObject.optBoolean("csat_received") ? ConversationCSATState.SUBMITTED_SYNCED : ConversationCSATState.NONE;
                }
                if (jSONObject.has("resolution_question_expiry_at")) {
                    conversation.resolutionExpiryAt = Long.valueOf(jSONObject.getLong("resolution_question_expiry_at"));
                }
                if (jSONObject.has(ConversationTable.Columns.CSAT_EXPIRY_AT)) {
                    conversation.csatExpiryAt = Long.valueOf(jSONObject.getLong(ConversationTable.Columns.CSAT_EXPIRY_AT));
                }
                conversation.isFeedbackBotEnabled = jSONObject.optBoolean(ConversationTable.Columns.FEEDBACK_BOT_ENABLED, false);
                conversation.shouldAllowNewConversationCreation = jSONObject.optBoolean("show_new_conversation_button", false);
                conversation.setMessageDMs(parseMessageDMs);
                return conversation;
            } catch (JSONException e) {
                e = e;
                throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception in reading conversation");
            }
        } catch (JSONException e2) {
            e = e2;
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception in reading conversation");
        }
    }

    public UserMessageDM parseReadableUserMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("created_at");
            UserMessageDM userMessageDM = new UserMessageDM(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), true));
            userMessageDM.serverId = jSONObject.getString("id");
            userMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            userMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(userMessageDM, jSONObject);
            parseIsFeedbackMessage(userMessageDM, jSONObject);
            return userMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user text message");
        }
    }

    public UserResponseMessageForCSATInput parseResponseMessageForCSATInput(String str) {
        String str2;
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("new_conv_started", false);
            JSONObject optJSONObject = jSONObject.optJSONObject("rating_data");
            if (optJSONObject == null) {
                str2 = JsonUtils.EMPTY_JSON;
            } else {
                str2 = optJSONObject.toString();
            }
            String str3 = str2;
            if (optJSONObject == null) {
                i = 0;
            } else {
                i = optJSONObject.optInt("value");
            }
            String string = jSONObject.getString("created_at");
            UserResponseMessageForCSATInput userResponseMessageForCSATInput = new UserResponseMessageForCSATInput(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), true), i, optBoolean, jSONObject.getJSONObject("chatbot_info").toString(), str3, jSONObject.getJSONObject("meta").getString("refers"), 2);
            userResponseMessageForCSATInput.serverId = jSONObject.getString("id");
            userResponseMessageForCSATInput.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(userResponseMessageForCSATInput, jSONObject);
            parseIsFeedbackMessage(userResponseMessageForCSATInput, jSONObject);
            return userResponseMessageForCSATInput;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user response for csat input");
        }
    }

    public UserResponseMessageForOptionInput parseResponseMessageForOptionInput(String str) {
        MessageType messageType;
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String string = jSONObject2.getString("type");
            char c = 65535;
            int hashCode = string.hashCode();
            if (hashCode != -904450649) {
                if (hashCode != -657647885) {
                    if (hashCode == 1826087580) {
                        if (string.equals("rsp_txt_msg_with_option_input")) {
                            c = 0;
                        }
                    }
                } else if (string.equals("rsp_faq_list_msg_with_option_input")) {
                    c = 1;
                }
            } else if (string.equals("rsp_txt_resolution_msg_with_option_input")) {
                c = 2;
            }
            if (c == 0) {
                messageType = MessageType.ADMIN_TEXT_WITH_OPTION_INPUT;
            } else if (c == 1) {
                messageType = MessageType.FAQ_LIST_WITH_OPTION_INPUT;
            } else if (c != 2) {
                return null;
            } else {
                messageType = MessageType.ADMIN_RESOLUTION_QUESTION_MESSAGE;
            }
            MessageType messageType2 = messageType;
            boolean z = jSONObject2.getBoolean(LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED);
            if (z) {
                jSONObject = JsonUtils.EMPTY_JSON;
            } else {
                jSONObject = jSONObject2.getJSONObject("option_data").toString();
            }
            String str2 = jSONObject;
            String string2 = jSONObject2.getString("created_at");
            UserResponseMessageForOptionInput userResponseMessageForOptionInput = new UserResponseMessageForOptionInput(jSONObject2.getString("body"), string2, HSDateFormatSpec.convertToEpochTime(string2), parseMessageAuthor(jSONObject2.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), true), jSONObject2.getJSONObject("chatbot_info").toString(), z, str2, jSONObject2.getJSONObject("meta").getString("refers"), messageType2);
            userResponseMessageForOptionInput.serverId = jSONObject2.getString("id");
            userResponseMessageForOptionInput.isRedacted = jSONObject2.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(userResponseMessageForOptionInput, jSONObject2);
            parseIsFeedbackMessage(userResponseMessageForOptionInput, jSONObject2);
            return userResponseMessageForOptionInput;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user response for option input");
        }
    }

    public UserResponseMessageForTextInputDM parseResponseMessageForTextInput(String str) {
        boolean z;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            char c = 65535;
            int i = 3;
            switch (string.hashCode()) {
                case -831290677:
                    if (string.equals("rsp_txt_msg_with_email_input")) {
                        c = 2;
                        break;
                    }
                    break;
                case -94670724:
                    if (string.equals("rsp_txt_msg_with_numeric_input")) {
                        c = 3;
                        break;
                    }
                    break;
                case 493654943:
                    if (string.equals("rsp_txt_msg_with_txt_input")) {
                        c = 1;
                        break;
                    }
                    break;
                case 919037346:
                    if (string.equals("rsp_empty_msg_with_txt_input")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2071762039:
                    if (string.equals("rsp_txt_msg_with_dt_input")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c == 1) {
                    i = 1;
                } else if (c == 2) {
                    i = 2;
                } else if (c != 3) {
                    if (c != 4) {
                        return null;
                    }
                    i = 4;
                }
                z = false;
            } else {
                i = 1;
                z = true;
            }
            boolean z2 = !z && jSONObject.getBoolean(LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED);
            JSONObject jSONObject2 = jSONObject.getJSONObject("meta");
            String string2 = jSONObject.getString("created_at");
            UserResponseMessageForTextInputDM userResponseMessageForTextInputDM = new UserResponseMessageForTextInputDM(jSONObject.getString("body"), string2, HSDateFormatSpec.convertToEpochTime(string2), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), true), i, jSONObject.getJSONObject("chatbot_info").toString(), z2, jSONObject2.getString("refers"), z);
            if (i == 4 && !z2) {
                userResponseMessageForTextInputDM.dateInMillis = jSONObject2.getLong("dt");
                userResponseMessageForTextInputDM.timeZoneId = jSONObject2.optString("timezone");
            }
            userResponseMessageForTextInputDM.serverId = jSONObject.getString("id");
            userResponseMessageForTextInputDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(userResponseMessageForTextInputDM, jSONObject);
            parseIsFeedbackMessage(userResponseMessageForTextInputDM, jSONObject);
            return userResponseMessageForTextInputDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user response for text input");
        }
    }

    public ScreenshotMessageDM parseScreenshotMessageDM(String str) {
        try {
            return parseScreenshotMessageDM(new JSONObject(str));
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user screenshot message");
        }
    }

    public FaqCore parseSingleFAQ(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new FaqCore(jSONObject.getString("id"), jSONObject.getString("publish_id"), jSONObject.getString("language"), jSONObject.getString("section_id"), jSONObject.getString("title"), jSONObject.getString("body"), 0, Boolean.valueOf(jSONObject.getString("is_rtl").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)), jSONObject.has("stags") ? HSJSONUtils.jsonArrayToStringArrayList(jSONObject.getString("stags")) : new ArrayList<>(), jSONObject.has("issue_tags") ? HSJSONUtils.jsonArrayToStringArrayList(jSONObject.getString("issue_tags")) : new ArrayList<>());
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading single faq");
        }
    }

    public SISearchModelDTO parseSmartIntentSearchModel(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("weights");
            JSONArray jSONArray = jSONObject.getJSONArray("intent_ids");
            int i = jSONObject.getInt("version");
            List<String> convertJSONArrayToStringList = HSJSONUtils.convertJSONArrayToStringList(jSONArray);
            List<Double> doubleListFromJSONArray = HSJSONUtils.getDoubleListFromJSONArray(jSONObject2.getJSONArray("label_base_probabilities"));
            if (convertJSONArrayToStringList.size() == doubleListFromJSONArray.size()) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("vocabulary");
                JSONArray jSONArray3 = jSONObject2.getJSONArray("word_label_probabilities");
                if (jSONArray2.length() == jSONArray3.length()) {
                    HashMap hashMap = new HashMap();
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        hashMap.put(jSONArray2.getString(i2), HSJSONUtils.getDoubleListFromJSONArray(jSONArray3.getJSONArray(i2)));
                    }
                    JSONObject jSONObject3 = jSONObject.getJSONObject("parameters");
                    return new SISearchModelDTO(Integer.valueOf(i), Double.valueOf(jSONObject3.getDouble(SmartIntentModelsTable.Columns.CONFIDENCE_THRESHOLD)), Double.valueOf(jSONObject3.getDouble(SmartIntentModelsTable.Columns.MAX_COMBINED_CONFIDENCE)), convertJSONArrayToStringList, doubleListFromJSONArray, hashMap);
                }
                throw new JSONException("Mismatch in vocabulary and wordLabelProbability array");
            }
            throw new JSONException("Mismatch in LeafIntentIds and baseProbabilities list");
        } catch (Exception e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading smart intent model");
        }
    }

    public SITreeDTO parseSmartIntentTree(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            List<SmartIntentDTO> parseSmartIntents = parseSmartIntents((String) null, jSONObject.getJSONArray(ViewIndexer.TREE_PARAM));
            int i = jSONObject.getInt("version");
            JSONObject jSONObject2 = jSONObject.getJSONObject("translations");
            return new SITreeDTO(jSONObject.getString("id"), i, jSONObject2.getString(SmartIntentTreeTable.Columns.SI_TREE_PROMPT_TITLE), jSONObject2.getString("typing_hint"), jSONObject2.getString(SmartIntentTreeTable.Columns.SI_TREE_SEARCH_TITLE), jSONObject2.getString(SmartIntentTreeTable.Columns.SI_TREE_EMPTY_SEARCH_TITLE), jSONObject2.getString("empty_search_desc"), jSONObject.getBoolean(AnalyticsEventKey.SMART_INTENT_ENFORCE_INTENT_SELECTION), HSJSONUtils.convertJSONArrayToStringList(jSONObject.getJSONArray("token_delimiters")), parseSmartIntents);
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading smart intent tree");
        }
    }

    public UserAttachmentMessageDM parseUserAttachmentMessageDM(String str) {
        try {
            return parseUserAttachmentMessageDM(new JSONObject(str));
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user attachment message");
        }
    }

    public MessageDM parseUserSmartIntentMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("created_at");
            JSONArray optJSONArray = jSONObject.optJSONArray("intent_labels");
            UserSmartIntentMessageDM userSmartIntentMessageDM = new UserSmartIntentMessageDM(optJSONArray != null ? HSJSONUtils.convertJSONArrayToStringList(optJSONArray) : new ArrayList(), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), true));
            userSmartIntentMessageDM.serverId = jSONObject.getString("id");
            userSmartIntentMessageDM.body = jSONObject.getString("body");
            userSmartIntentMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            userSmartIntentMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(userSmartIntentMessageDM, jSONObject);
            return userSmartIntentMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user smart intent message");
        }
    }

    public WebSocketMessage parseWebSocketMessage(String str) {
        WSTypingActionMessage wSTypingActionMessage;
        WSTypingActionMessage wSTypingActionMessage2 = null;
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i = jSONArray.getInt(0);
            if (i == 100) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(2);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject = new JSONObject(jSONArray2.getJSONObject(i2).getString(PaintCompat.EM_STRING));
                    if ("agent_type_activity".equals(jSONObject.getString("stream"))) {
                        String string = jSONObject.getString("action");
                        if (VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE.equals(string)) {
                            wSTypingActionMessage = new WSTypingActionMessage(true, TimeUnit.SECONDS.toMillis(jSONObject.getLong("ttl")));
                        } else if ("stop".equals(string)) {
                            wSTypingActionMessage = new WSTypingActionMessage(false, 0);
                        }
                        wSTypingActionMessage2 = wSTypingActionMessage;
                    }
                }
                return wSTypingActionMessage2;
            } else if (i != 107) {
                return null;
            } else {
                return new WSPingMessage(TimeUnit.SECONDS.toMillis(jSONArray.getLong(1)));
            }
        } catch (JSONException e) {
            HSLogger.m3242e(TAG, "Exception in parsing web-socket message", e);
            return null;
        }
    }

    private ScreenshotMessageDM parseScreenshotMessageDM(JSONObject jSONObject) {
        boolean z;
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("meta").getJSONArray("attachments").getJSONObject(0);
            String string = jSONObject2.getString("created_at");
            long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(string);
            ScreenshotMessageDM screenshotMessageDM = new ScreenshotMessageDM(jSONObject3.has("body") ? jSONObject3.getString("body") : jSONObject2.getString("body"), string, convertToEpochTime, parseMessageAuthor(jSONObject2.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), true), jSONObject3.getString("content-type"), jSONObject3.optString("thumbnail", ""), jSONObject3.getString("file-name"), jSONObject3.getString("url"), jSONObject3.getInt("size"), jSONObject3.optBoolean("secure?", false));
            screenshotMessageDM.serverId = jSONObject2.getString("id");
            screenshotMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject2.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            if (!jSONObject2.optBoolean("redacted", false)) {
                if (!jSONObject3.optBoolean("redacted", false)) {
                    z = false;
                    screenshotMessageDM.isRedacted = z;
                    screenshotMessageDM.isZipped = jSONObject3.optBoolean("zipped", false);
                    parseAndSetDataForUserSentMessages(screenshotMessageDM, jSONObject2);
                    parseIsFeedbackMessage(screenshotMessageDM, jSONObject2);
                    return screenshotMessageDM;
                }
            }
            z = true;
            screenshotMessageDM.isRedacted = z;
            screenshotMessageDM.isZipped = jSONObject3.optBoolean("zipped", false);
            parseAndSetDataForUserSentMessages(screenshotMessageDM, jSONObject2);
            parseIsFeedbackMessage(screenshotMessageDM, jSONObject2);
            return screenshotMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading screenshot message");
        }
    }

    private UserAttachmentMessageDM parseUserAttachmentMessageDM(JSONObject jSONObject) {
        boolean z;
        JSONObject jSONObject2 = jSONObject;
        try {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("meta").getJSONArray("attachments").getJSONObject(0);
            String string = jSONObject2.getString("created_at");
            long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(string);
            UserAttachmentMessageDM userAttachmentMessageDM = new UserAttachmentMessageDM(jSONObject3.has("body") ? jSONObject3.getString("body") : jSONObject2.getString("body"), string, convertToEpochTime, parseMessageAuthor(jSONObject2.getJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR), true), jSONObject3.getInt("size"), jSONObject3.getString("content-type"), jSONObject3.getString("url"), jSONObject3.getString("file-name"), jSONObject3.optBoolean("secure?", false));
            userAttachmentMessageDM.serverId = jSONObject2.getString("id");
            userAttachmentMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject2.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            if (!jSONObject2.optBoolean("redacted", false)) {
                if (!jSONObject3.optBoolean("redacted", false)) {
                    z = false;
                    userAttachmentMessageDM.isRedacted = z;
                    userAttachmentMessageDM.isZipped = jSONObject3.optBoolean("zipped", false);
                    parseAndSetDataForUserSentMessages(userAttachmentMessageDM, jSONObject2);
                    parseIsFeedbackMessage(userAttachmentMessageDM, jSONObject2);
                    return userAttachmentMessageDM;
                }
            }
            z = true;
            userAttachmentMessageDM.isRedacted = z;
            userAttachmentMessageDM.isZipped = jSONObject3.optBoolean("zipped", false);
            parseAndSetDataForUserSentMessages(userAttachmentMessageDM, jSONObject2);
            parseIsFeedbackMessage(userAttachmentMessageDM, jSONObject2);
            return userAttachmentMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user attachment message");
        }
    }
}
