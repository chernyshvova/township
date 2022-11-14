package com.helpshift.common.conversation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.account.dao.UserDB;
import com.helpshift.common.dao.DAOResult;
import com.helpshift.conversation.activeconversation.message.AcceptedAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminBotControlMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminCSATMessageWithOptions;
import com.helpshift.conversation.activeconversation.message.AdminMessageWithOptionInputDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageWithTextInputDM;
import com.helpshift.conversation.activeconversation.message.AdminResolutionMessageWithOptions;
import com.helpshift.conversation.activeconversation.message.AttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.Author;
import com.helpshift.conversation.activeconversation.message.AutoRetriableMessageDM;
import com.helpshift.conversation.activeconversation.message.ConfirmationAcceptedMessageDM;
import com.helpshift.conversation.activeconversation.message.ConfirmationRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageWithOptionInputDM;
import com.helpshift.conversation.activeconversation.message.FollowupAcceptedMessageDM;
import com.helpshift.conversation.activeconversation.message.FollowupRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.ImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.MessageType;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.UserBotControlMessageDM;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForCSATInput;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForOptionInput;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForTextInputDM;
import com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM;
import com.helpshift.conversation.activeconversation.message.input.CSATRatingsInput;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.conversation.activeconversation.message.input.TextInput;
import com.helpshift.conversation.activeconversation.model.Action;
import com.helpshift.conversation.activeconversation.model.ActionCard;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.dto.dao.ConversationInboxRecord;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.p042db.conversation.ConversationDBHelper;
import com.helpshift.p042db.conversation.ConversationDatabaseContract;
import com.helpshift.p042db.conversation.tables.ActionCardTable;
import com.helpshift.p042db.conversation.tables.ActionTable;
import com.helpshift.p042db.conversation.tables.ConversationInboxTable;
import com.helpshift.p042db.conversation.tables.ConversationTable;
import com.helpshift.p042db.conversation.tables.MessagesTable;
import com.helpshift.support.Faq;
import com.helpshift.support.constants.FaqsTable;
import com.helpshift.util.DatabaseUtils;
import com.helpshift.util.HSJSONUtils;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConversationDB {
    public static final String TAG = "Helpshift_ConverDB";
    public static ConversationDB instance;
    public final String KEY_ATTACHMENT_COUNT = "attachment_count";
    public final String KEY_BOT_ACTION_TYPE = "bot_action_type";
    public final String KEY_BOT_ENDED_REASON = "bot_ended_reason";
    public final String KEY_CHATBOT_INFO = "chatbot_info";
    public final String KEY_CONTENT_TYPE = FirebaseAnalytics.Param.CONTENT_TYPE;
    public final String KEY_CONVERSATION_ENDED_DELEGATE_SENT = "ended_delegate_sent";
    public final String KEY_CSAT_FEEDBACK = "csat_feedback";
    public final String KEY_CSAT_RATING = "csat_rating";
    public final String KEY_CSAT_STATE = "csat_state";
    public final String KEY_DATE_TIME = "dt";
    public final String KEY_FAQS = "faqs";
    public final String KEY_FAQS_SOURCE = "faq_source";
    public final String KEY_FAQ_LANGUAGE = "faq_language";
    public final String KEY_FAQ_PUBLISH_ID = "faq_publish_id";
    public final String KEY_FAQ_TITLE = "faq_title";
    public final String KEY_FILE_NAME = "file_name";
    public final String KEY_FILE_PATH = "filePath";
    public final String KEY_FOLLOW_UP_REJECTED_OPEN_CONVERSATION = "rejected_conv_id";
    public final String KEY_FOLLOW_UP_REJECTED_REASON = "rejected_reason";
    public final String KEY_HAS_NEXT_BOT = "has_next_bot";
    public final String KEY_IMAGE_ATTACHMENT_COMPRESSION_COPYING_DONE = "image_copy_done";
    public final String KEY_IMAGE_ATTACHMENT_DRAFT_FILE_PATH = "image_draft_file_path";
    public final String KEY_IMAGE_ATTACHMENT_DRAFT_ORIGINAL_NAME = "image_draft_orig_name";
    public final String KEY_IMAGE_ATTACHMENT_DRAFT_ORIGINAL_SIZE = "image_draft_orig_size";
    public final String KEY_IMAGE_ATTACHMENT_TYPE = "attachment_type";
    public final String KEY_INCREMENT_MESSAGE_COUNT = "increment_message_count";
    public final String KEY_INPUT_KEYBOARD = "input_keyboard";
    public final String KEY_INPUT_LABEL = "input_label";
    public final String KEY_INPUT_OPTIONS = "input_options";
    public final String KEY_INPUT_PLACEHOLDER = "input_placeholder";
    public final String KEY_INPUT_REQUIRED = "input_required";
    public final String KEY_INPUT_SEND_FEEDBACK_LABEL = "input_send_feedback_label";
    public final String KEY_INPUT_SKIP_LABEL = "input_skip_label";
    public final String KEY_INPUT_START_CONV_LABEL = "input_start_conv_label";
    public final String KEY_IS_ANSWERED = "is_answered";
    public final String KEY_IS_AUTO_FILLED_PREISSUE = "is_autofilled_preissue";
    public final String KEY_IS_FEED_BACK_MESSAGE = "is_feedback_message";
    public final String KEY_IS_MESSAGE_EMPTY = "is_message_empty";
    public final String KEY_IS_RESPONSE_SKIPPED = "is_response_skipped";
    public final String KEY_IS_SUGGESTION_READ_EVENT_SENT = "is_suggestion_read_event_sent";
    public final String KEY_IS_USER_ATTACHMENT_REJECTED = "is_user_attachment_rejected";
    public final String KEY_IS_USER_ATTACHMENT_ZIPPED = "is_user_attachment_zipped";
    public final String KEY_MESSAGE_SYNC_STATUS = "message_sync_status";
    public final String KEY_NEW_CONV_STARTED_CSAT = "new_conv_started_csat";
    public final String KEY_OPTION_DATA = "option_data";
    public final String KEY_OPTION_TITLE = "option_title";
    public final String KEY_OPTION_TYPE = "option_type";
    public final String KEY_ORIGINAL_MESSAGE_ID = "original_message_server_id";
    public final String KEY_RATING_VALUE = "rating_value";
    public final String KEY_READ_AT = "read_at";
    public final String KEY_REFERRED_MESSAGE_ID = "referredMessageId";
    public final String KEY_REFERRED_MESSAGE_TYPE = "referred_message_type";
    public final String KEY_SECURE_ATTACHMENT = "is_secure";
    public final String KEY_SEEN_AT_MESSAGE_CURSOR = "seen_cursor";
    public final String KEY_SEEN_SYNC_STATUS = "seen_sync_status";
    public final String KEY_SELECTED_OPTION_DATA = "selected_option_data";
    public final String KEY_SHOW_NEW_CONV_BUTTON = "show_new_conv_button";
    public final String KEY_SIZE = "size";
    public final String KEY_SMART_INTENT_IDs = "smart_intent_ids";
    public final String KEY_SMART_INTENT_LABELS = "intent_labels";
    public final String KEY_SMART_INTENT_TREE_ID = "smart_intent_tree_id";
    public final String KEY_SMART_INTENT_USER_QUERY = "smart_intent_user_query";
    public final String KEY_SUGGESTION_READ_FAQ_PUBLISH_ID = "suggestion_read_faq_publish_id";
    public final String KEY_THUMBNAIL_FILE_PATH = "thumbnailFilePath";
    public final String KEY_THUMBNAIL_URL = "thumbnail_url";
    public final String KEY_TIMEZONE_ID = "timezone_id";
    public final String KEY_URL = "url";
    public final ConversationDBHelper dbHelper;

    /* renamed from: com.helpshift.common.conversation.ConversationDB$1 */
    public static /* synthetic */ class C24931 {

        /* renamed from: $SwitchMap$com$helpshift$conversation$activeconversation$message$MessageType */
        public static final /* synthetic */ int[] f3328x18a4a544;

        /* JADX WARNING: Can't wrap try/catch for region: R(55:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|45|46|47|48|49|50|51|52|53|54|55|56|(2:57|58)|59|(2:61|62)|63|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(3:79|80|82)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|45|46|47|48|49|50|51|52|53|54|55|56|(2:57|58)|59|(2:61|62)|63|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(3:79|80|82)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(67:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(69:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0081 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00af */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x00b5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x00bb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x00c3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x00cb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x00d3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x00db */
        static {
            /*
                com.helpshift.conversation.activeconversation.message.MessageType[] r0 = com.helpshift.conversation.activeconversation.message.MessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3328x18a4a544 = r0
                r1 = 1
                com.helpshift.conversation.activeconversation.message.MessageType r2 = com.helpshift.conversation.activeconversation.message.MessageType.USER_TEXT     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r2 = 21
                int[] r3 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x0018 }
                com.helpshift.conversation.activeconversation.message.MessageType r4 = com.helpshift.conversation.activeconversation.message.MessageType.USER_RESP_FOR_TEXT_INPUT     // Catch:{ NoSuchFieldError -> 0x0018 }
                r3[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0018 }
            L_0x0018:
                r3 = 3
                r4 = 22
                int[] r5 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x0021 }
                com.helpshift.conversation.activeconversation.message.MessageType r6 = com.helpshift.conversation.activeconversation.message.MessageType.USER_RESP_FOR_OPTION_INPUT     // Catch:{ NoSuchFieldError -> 0x0021 }
                r5[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                r5 = 4
                int[] r6 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x002a }
                com.helpshift.conversation.activeconversation.message.MessageType r7 = com.helpshift.conversation.activeconversation.message.MessageType.USER_RESP_FOR_CSAT     // Catch:{ NoSuchFieldError -> 0x002a }
                r7 = 32
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r6 = 5
                int[] r7 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.helpshift.conversation.activeconversation.message.MessageType r8 = com.helpshift.conversation.activeconversation.message.MessageType.USER_SMART_INTENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                r8 = 29
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r7 = 6
                int[] r8 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x003a }
                com.helpshift.conversation.activeconversation.message.MessageType r9 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_TEXT     // Catch:{ NoSuchFieldError -> 0x003a }
                r8[r1] = r7     // Catch:{ NoSuchFieldError -> 0x003a }
            L_0x003a:
                r1 = 7
                r8 = 13
                int[] r9 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.helpshift.conversation.activeconversation.message.MessageType r10 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_TEXT_WITH_TEXT_INPUT     // Catch:{ NoSuchFieldError -> 0x0043 }
                r9[r8] = r1     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                r9 = 8
                r10 = 14
                int[] r11 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x004d }
                com.helpshift.conversation.activeconversation.message.MessageType r12 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_TEXT_WITH_OPTION_INPUT     // Catch:{ NoSuchFieldError -> 0x004d }
                r11[r10] = r9     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                r11 = 9
                int[] r12 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x0057 }
                com.helpshift.conversation.activeconversation.message.MessageType r13 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_RESOLUTION_QUESTION_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0057 }
                r13 = 30
                r12[r13] = r11     // Catch:{ NoSuchFieldError -> 0x0057 }
            L_0x0057:
                r12 = 10
                int[] r13 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x0061 }
                com.helpshift.conversation.activeconversation.message.MessageType r14 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_CSAT_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0061 }
                r14 = 31
                r13[r14] = r12     // Catch:{ NoSuchFieldError -> 0x0061 }
            L_0x0061:
                r13 = 11
                r14 = 15
                int[] r15 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x006b }
                com.helpshift.conversation.activeconversation.message.MessageType r16 = com.helpshift.conversation.activeconversation.message.MessageType.FAQ_LIST     // Catch:{ NoSuchFieldError -> 0x006b }
                r15[r14] = r13     // Catch:{ NoSuchFieldError -> 0x006b }
            L_0x006b:
                r15 = 12
                r16 = 16
                int[] r17 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x0075 }
                com.helpshift.conversation.activeconversation.message.MessageType r18 = com.helpshift.conversation.activeconversation.message.MessageType.FAQ_LIST_WITH_OPTION_INPUT     // Catch:{ NoSuchFieldError -> 0x0075 }
                r17[r16] = r15     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                int[] r17 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x007b }
                com.helpshift.conversation.activeconversation.message.MessageType r18 = com.helpshift.conversation.activeconversation.message.MessageType.ACCEPTED_APP_REVIEW     // Catch:{ NoSuchFieldError -> 0x007b }
                r17[r0] = r8     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x0081 }
                com.helpshift.conversation.activeconversation.message.MessageType r8 = com.helpshift.conversation.activeconversation.message.MessageType.REQUESTED_APP_REVIEW     // Catch:{ NoSuchFieldError -> 0x0081 }
                r0[r3] = r10     // Catch:{ NoSuchFieldError -> 0x0081 }
            L_0x0081:
                int[] r0 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x0087 }
                com.helpshift.conversation.activeconversation.message.MessageType r3 = com.helpshift.conversation.activeconversation.message.MessageType.FOLLOWUP_ACCEPTED     // Catch:{ NoSuchFieldError -> 0x0087 }
                r0[r5] = r14     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x008d }
                com.helpshift.conversation.activeconversation.message.MessageType r3 = com.helpshift.conversation.activeconversation.message.MessageType.FOLLOWUP_REJECTED     // Catch:{ NoSuchFieldError -> 0x008d }
                r0[r6] = r16     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                int[] r0 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x0095 }
                com.helpshift.conversation.activeconversation.message.MessageType r3 = com.helpshift.conversation.activeconversation.message.MessageType.CONFIRMATION_ACCEPTED     // Catch:{ NoSuchFieldError -> 0x0095 }
                r3 = 17
                r0[r7] = r3     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r0 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x009d }
                com.helpshift.conversation.activeconversation.message.MessageType r3 = com.helpshift.conversation.activeconversation.message.MessageType.CONFIRMATION_REJECTED     // Catch:{ NoSuchFieldError -> 0x009d }
                r3 = 18
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x009d }
            L_0x009d:
                r0 = 19
                int[] r1 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x00a5 }
                com.helpshift.conversation.activeconversation.message.MessageType r3 = com.helpshift.conversation.activeconversation.message.MessageType.SCREENSHOT     // Catch:{ NoSuchFieldError -> 0x00a5 }
                r1[r9] = r0     // Catch:{ NoSuchFieldError -> 0x00a5 }
            L_0x00a5:
                r1 = 20
                r3 = 27
                int[] r5 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x00af }
                com.helpshift.conversation.activeconversation.message.MessageType r6 = com.helpshift.conversation.activeconversation.message.MessageType.USER_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x00af }
                r5[r3] = r1     // Catch:{ NoSuchFieldError -> 0x00af }
            L_0x00af:
                int[] r5 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x00b5 }
                com.helpshift.conversation.activeconversation.message.MessageType r6 = com.helpshift.conversation.activeconversation.message.MessageType.REQUESTED_SCREENSHOT     // Catch:{ NoSuchFieldError -> 0x00b5 }
                r5[r11] = r2     // Catch:{ NoSuchFieldError -> 0x00b5 }
            L_0x00b5:
                int[] r2 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x00bb }
                com.helpshift.conversation.activeconversation.message.MessageType r5 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x00bb }
                r2[r12] = r4     // Catch:{ NoSuchFieldError -> 0x00bb }
            L_0x00bb:
                int[] r2 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x00c3 }
                com.helpshift.conversation.activeconversation.message.MessageType r4 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_IMAGE_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x00c3 }
                r4 = 23
                r2[r13] = r4     // Catch:{ NoSuchFieldError -> 0x00c3 }
            L_0x00c3:
                int[] r2 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x00cb }
                com.helpshift.conversation.activeconversation.message.MessageType r4 = com.helpshift.conversation.activeconversation.message.MessageType.REQUEST_FOR_REOPEN     // Catch:{ NoSuchFieldError -> 0x00cb }
                r4 = 24
                r2[r15] = r4     // Catch:{ NoSuchFieldError -> 0x00cb }
            L_0x00cb:
                int[] r2 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x00d3 }
                com.helpshift.conversation.activeconversation.message.MessageType r4 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_BOT_CONTROL     // Catch:{ NoSuchFieldError -> 0x00d3 }
                r4 = 25
                r2[r0] = r4     // Catch:{ NoSuchFieldError -> 0x00d3 }
            L_0x00d3:
                int[] r0 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x00db }
                com.helpshift.conversation.activeconversation.message.MessageType r2 = com.helpshift.conversation.activeconversation.message.MessageType.USER_BOT_CONTROL     // Catch:{ NoSuchFieldError -> 0x00db }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00db }
            L_0x00db:
                int[] r0 = f3328x18a4a544     // Catch:{ NoSuchFieldError -> 0x00e3 }
                com.helpshift.conversation.activeconversation.message.MessageType r1 = com.helpshift.conversation.activeconversation.message.MessageType.ADMIN_ACTION_CARD     // Catch:{ NoSuchFieldError -> 0x00e3 }
                r1 = 28
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00e3 }
            L_0x00e3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.C24931.<clinit>():void");
        }
    }

    public class AttachmentInfo {
        public final String contentType;
        public final String fileName;
        public final String filePath;
        public final boolean isRejected;
        public final boolean isSecure;
        public final boolean isZipped;
        public final int size;
        public final String url;

        public AttachmentInfo(JSONObject jSONObject) {
            this.fileName = jSONObject.optString("file_name", (String) null);
            this.contentType = jSONObject.optString(FirebaseAnalytics.Param.CONTENT_TYPE, (String) null);
            this.url = jSONObject.optString("url", (String) null);
            this.size = jSONObject.optInt("size", 0);
            this.filePath = jSONObject.optString("filePath", (String) null);
            this.isSecure = jSONObject.optBoolean("is_secure", false);
            this.isZipped = jSONObject.optBoolean("is_user_attachment_zipped", false);
            this.isRejected = jSONObject.optBoolean("is_user_attachment_rejected", false);
        }
    }

    public class ImageAttachmentInfo extends AttachmentInfo {
        public final String thumbnailFilePath;
        public final String thumbnailUrl;

        public ImageAttachmentInfo(JSONObject jSONObject) {
            super(jSONObject);
            this.thumbnailUrl = jSONObject.optString("thumbnail_url", (String) null);
            this.thumbnailFilePath = jSONObject.optString("thumbnailFilePath", (String) null);
        }
    }

    public ConversationDB(Context context) {
        this.dbHelper = new ConversationDBHelper(context, new ConversationDatabaseContract());
    }

    private ContentValues actionCardToContentValues(ActionCard actionCard, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_id", str);
        contentValues.put("title", actionCard.title);
        contentValues.put(ActionCardTable.Columns.IMAGE_URL, actionCard.imageUrl);
        contentValues.put(ActionCardTable.Columns.IS_IMAGE_SECURE, Integer.valueOf(actionCard.isSecure ? 1 : 0));
        contentValues.put(ActionCardTable.Columns.FILE_PATH, actionCard.filePath);
        return contentValues;
    }

    private ContentValues actionToContentValues(Action action, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ActionTable.Columns.ACTION_CARD_ID, Long.valueOf(j));
        contentValues.put(ActionTable.Columns.ACTION_SHA, action.actionSHA);
        contentValues.put(ActionTable.Columns.TITLE, action.actionTitle);
        contentValues.put("action_type", action.actionType.getValue());
        contentValues.put(ActionTable.Columns.DATA, new JSONObject(action.actionData).toString());
        return contentValues;
    }

    private void buildJsonObjectForAttachmentMessage(JSONObject jSONObject, AttachmentMessageDM attachmentMessageDM) throws JSONException {
        jSONObject.put(FirebaseAnalytics.Param.CONTENT_TYPE, attachmentMessageDM.contentType);
        jSONObject.put("file_name", attachmentMessageDM.fileName);
        jSONObject.put("filePath", attachmentMessageDM.filePath);
        jSONObject.put("url", attachmentMessageDM.attachmentUrl);
        jSONObject.put("size", attachmentMessageDM.size);
        jSONObject.put("is_secure", attachmentMessageDM.isSecureAttachment);
        jSONObject.put("is_user_attachment_zipped", attachmentMessageDM.isZipped);
        jSONObject.put("is_user_attachment_rejected", attachmentMessageDM.isRejected);
    }

    private void buildMetaForActionCardMessage(JSONObject jSONObject, AdminActionCardMessageDM adminActionCardMessageDM) throws JSONException {
        jSONObject.put("original_message_server_id", adminActionCardMessageDM.originalMessageServerId);
    }

    private void buildMetaForAdminBotControlMessage(JSONObject jSONObject, AdminBotControlMessageDM adminBotControlMessageDM) throws JSONException {
        jSONObject.put("bot_action_type", adminBotControlMessageDM.actionType);
        jSONObject.put("has_next_bot", adminBotControlMessageDM.hasNextBot);
    }

    private JSONObject buildMetaForAttachmentCount(JSONObject jSONObject, int i) throws JSONException {
        jSONObject.put("attachment_count", i);
        return jSONObject;
    }

    private void buildMetaForAutoRetriableMessage(JSONObject jSONObject, AutoRetriableMessageDM autoRetriableMessageDM) throws JSONException {
        jSONObject.put("message_sync_status", autoRetriableMessageDM.getSyncStatus());
    }

    private void buildMetaForBotInfo(JSONObject jSONObject, String str) throws JSONException {
        jSONObject.put("chatbot_info", str);
    }

    private void buildMetaForCSATInput(JSONObject jSONObject, CSATRatingsInput cSATRatingsInput) throws JSONException {
        buildMetaForBotInfo(jSONObject, cSATRatingsInput.botInfo);
        jSONObject.put("input_required", cSATRatingsInput.required);
        jSONObject.put("input_label", cSATRatingsInput.inputLabel);
        jSONObject.put("input_skip_label", cSATRatingsInput.skipLabel);
        jSONObject.put("input_send_feedback_label", cSATRatingsInput.sendFeedbackLabel);
        jSONObject.put("input_start_conv_label", cSATRatingsInput.startNewConversationLabel);
        jSONObject.put("show_new_conv_button", cSATRatingsInput.showNewConversationButton);
        if (cSATRatingsInput.ratings != null) {
            JSONArray jSONArray = new JSONArray();
            for (CSATRatingsInput.Rating next : cSATRatingsInput.ratings) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("option_title", next.title);
                jSONObject2.put("rating_value", next.value);
                jSONObject2.put("option_data", next.jsonData);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("input_options", jSONArray);
        }
        jSONObject.put("option_type", cSATRatingsInput.type.toString());
    }

    private void buildMetaForDateTime(JSONObject jSONObject, UserResponseMessageForTextInputDM userResponseMessageForTextInputDM) throws JSONException {
        if (userResponseMessageForTextInputDM.keyboard == 4) {
            jSONObject.put("dt", userResponseMessageForTextInputDM.dateInMillis);
            jSONObject.put("timezone_id", userResponseMessageForTextInputDM.timeZoneId);
        }
    }

    private void buildMetaForFAQList(JSONObject jSONObject, FAQListMessageDM fAQListMessageDM) throws JSONException {
        if (fAQListMessageDM.faqs != null) {
            JSONArray jSONArray = new JSONArray();
            for (FAQListMessageDM.FAQ next : fAQListMessageDM.faqs) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("faq_title", next.title);
                jSONObject2.put("faq_publish_id", next.publishId);
                jSONObject2.put("faq_language", next.language);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("faqs", jSONArray);
        }
    }

    private void buildMetaForFAQListSource(JSONObject jSONObject, FAQListMessageDM fAQListMessageDM) throws JSONException {
        String str = fAQListMessageDM.source;
        if (str != null) {
            jSONObject.put("faq_source", str);
        }
    }

    private void buildMetaForFeedbackMessageProperties(JSONObject jSONObject, MessageDM messageDM) throws JSONException {
        jSONObject.put("is_feedback_message", messageDM.isFeedbackMessage);
    }

    private void buildMetaForFollowUpRejected(JSONObject jSONObject, FollowupRejectedMessageDM followupRejectedMessageDM) throws JSONException {
        jSONObject.put("referredMessageId", followupRejectedMessageDM.referredMessageId);
        jSONObject.put("rejected_reason", followupRejectedMessageDM.reason);
        jSONObject.put("rejected_conv_id", followupRejectedMessageDM.openConversationId);
    }

    private void buildMetaForImageAttachmentMessage(JSONObject jSONObject, ImageAttachmentMessageDM imageAttachmentMessageDM) throws JSONException {
        buildJsonObjectForAttachmentMessage(jSONObject, imageAttachmentMessageDM);
        jSONObject.put("thumbnail_url", imageAttachmentMessageDM.thumbnailUrl);
        jSONObject.put("thumbnailFilePath", imageAttachmentMessageDM.thumbnailFilePath);
        jSONObject.put("is_secure", imageAttachmentMessageDM.isSecureAttachment);
    }

    private void buildMetaForInput(JSONObject jSONObject, TextInput textInput) throws JSONException {
        buildMetaForBotInfo(jSONObject, textInput.botInfo);
        jSONObject.put("input_required", textInput.required);
        jSONObject.put("input_skip_label", textInput.skipLabel);
        jSONObject.put("input_label", textInput.inputLabel);
        jSONObject.put("input_placeholder", textInput.placeholder);
        buildMetaForInputKeyboard(jSONObject, textInput.keyboard);
    }

    private void buildMetaForInputKeyboard(JSONObject jSONObject, int i) throws JSONException {
        jSONObject.put("input_keyboard", i);
    }

    private void buildMetaForIntentLabels(JSONObject jSONObject, UserSmartIntentMessageDM userSmartIntentMessageDM) throws JSONException {
        jSONObject.put("intent_labels", HSJSONUtils.listToJsonArray(userSmartIntentMessageDM.intentLabels));
    }

    private void buildMetaForIsAnswered(JSONObject jSONObject, boolean z) throws JSONException {
        jSONObject.put("is_answered", z);
    }

    private void buildMetaForIsMessageEmpty(JSONObject jSONObject, boolean z) throws JSONException {
        jSONObject.put("is_message_empty", z);
    }

    private void buildMetaForIsNewConvClickedCSAT(JSONObject jSONObject, boolean z) throws JSONException {
        jSONObject.put("new_conv_started_csat", z);
    }

    private void buildMetaForIsResponseSkipped(JSONObject jSONObject, boolean z) throws JSONException {
        jSONObject.put("is_response_skipped", z);
    }

    private void buildMetaForIsSuggestionsReadEvent(JSONObject jSONObject, FAQListMessageDM fAQListMessageDM) throws JSONException {
        jSONObject.put("is_suggestion_read_event_sent", fAQListMessageDM.isSuggestionsReadEventSent);
        jSONObject.put("suggestion_read_faq_publish_id", fAQListMessageDM.suggestionsReadFAQPublishId);
    }

    private void buildMetaForMessageSeenData(JSONObject jSONObject, MessageDM messageDM) throws JSONException {
        jSONObject.put("seen_cursor", messageDM.seenAtMessageCursor);
        jSONObject.put("seen_sync_status", messageDM.isMessageSeenSynced);
        jSONObject.put("read_at", messageDM.readAt);
    }

    private void buildMetaForMessageSyncState(JSONObject jSONObject, int i) throws JSONException {
        jSONObject.put("message_sync_status", i);
    }

    private void buildMetaForRatingValue(JSONObject jSONObject, int i) throws JSONException {
        jSONObject.put("rating_value", i);
    }

    private void buildMetaForReferredMessageId(JSONObject jSONObject, String str) throws JSONException {
        jSONObject.put("referredMessageId", str);
    }

    private void buildMetaForReferredMessageType(JSONObject jSONObject, MessageType messageType) throws JSONException {
        jSONObject.put("referred_message_type", messageType.getValue());
    }

    private void buildMetaForScreenshotAttachmentMessage(JSONObject jSONObject, ScreenshotMessageDM screenshotMessageDM) throws JSONException {
        buildJsonObjectForAttachmentMessage(jSONObject, screenshotMessageDM);
        jSONObject.put("thumbnail_url", screenshotMessageDM.thumbnailUrl);
        jSONObject.put("referredMessageId", screenshotMessageDM.refersMessageId);
        jSONObject.put("is_secure", screenshotMessageDM.isSecureAttachment);
        jSONObject.put("is_user_attachment_zipped", screenshotMessageDM.isZipped);
        jSONObject.put("is_user_attachment_rejected", screenshotMessageDM.isRejected);
    }

    private void buildMetaForSelectedOptionData(JSONObject jSONObject, String str) throws JSONException {
        jSONObject.put("selected_option_data", str);
    }

    private void buildMetaForUserBotControlMessage(JSONObject jSONObject, UserBotControlMessageDM userBotControlMessageDM) throws JSONException {
        jSONObject.put("bot_action_type", userBotControlMessageDM.actionType);
        jSONObject.put("chatbot_info", userBotControlMessageDM.botInfo);
        jSONObject.put("bot_ended_reason", userBotControlMessageDM.reason);
        jSONObject.put("referredMessageId", userBotControlMessageDM.refersMessageId);
    }

    private ContentValues conversationInboxRecordToContentValues(ConversationInboxRecord conversationInboxRecord) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_local_id", Long.valueOf(conversationInboxRecord.userLocalId));
        contentValues.put(ConversationInboxTable.Columns.FORM_NAME, conversationInboxRecord.formName);
        contentValues.put(ConversationInboxTable.Columns.FORM_EMAIL, conversationInboxRecord.formEmail);
        contentValues.put(ConversationInboxTable.Columns.DESCRIPTION_DRAFT, conversationInboxRecord.description);
        contentValues.put(ConversationInboxTable.Columns.DESCRIPTION_DRAFT_TIMESTAMP, Long.valueOf(conversationInboxRecord.descriptionTimeStamp));
        contentValues.put(ConversationInboxTable.Columns.DESCRIPTION_TYPE, Integer.valueOf(conversationInboxRecord.descriptionType));
        contentValues.put(ConversationInboxTable.Columns.ARCHIVAL_TEXT, conversationInboxRecord.archivalText);
        contentValues.put(ConversationInboxTable.Columns.REPLY_TEXT, conversationInboxRecord.replyText);
        contentValues.put(ConversationInboxTable.Columns.PERSIST_MESSAGE_BOX, Integer.valueOf(conversationInboxRecord.persistMessageBox ? 1 : 0));
        contentValues.put(ConversationInboxTable.Columns.LAST_SYNC_TIMESTAMP, conversationInboxRecord.lastSyncTimestamp);
        Boolean bool = conversationInboxRecord.hasOlderMessages;
        if (bool != null) {
            contentValues.put("has_older_messages", Integer.valueOf(bool.booleanValue() ? 1 : 0));
        }
        contentValues.put("last_conv_redaction_time", conversationInboxRecord.lastConversationsRedactionTime);
        try {
            contentValues.put(ConversationInboxTable.Columns.ATTACHMENT_DRAFT, getImageAttachmentDraftMeta(conversationInboxRecord.imageAttachmentDraft));
        } catch (JSONException e) {
            HSLogger.m3242e(TAG, "Error in generating meta string for image attachment", e);
        }
        return contentValues;
    }

    private ConversationInboxRecord cursorToConversationInboxRecord(Cursor cursor) {
        Cursor cursor2 = cursor;
        return new ConversationInboxRecord(cursor2.getLong(cursor2.getColumnIndex("user_local_id")), cursor2.getString(cursor2.getColumnIndex(ConversationInboxTable.Columns.FORM_NAME)), cursor2.getString(cursor2.getColumnIndex(ConversationInboxTable.Columns.FORM_EMAIL)), cursor2.getString(cursor2.getColumnIndex(ConversationInboxTable.Columns.DESCRIPTION_DRAFT)), cursor2.getLong(cursor2.getColumnIndex(ConversationInboxTable.Columns.DESCRIPTION_DRAFT_TIMESTAMP)), parseAndGetImageAttachmentDraft(cursor2.getString(cursor2.getColumnIndex(ConversationInboxTable.Columns.ATTACHMENT_DRAFT))), cursor2.getInt(cursor2.getColumnIndex(ConversationInboxTable.Columns.DESCRIPTION_TYPE)), cursor2.getString(cursor2.getColumnIndex(ConversationInboxTable.Columns.ARCHIVAL_TEXT)), cursor2.getString(cursor2.getColumnIndex(ConversationInboxTable.Columns.REPLY_TEXT)), cursor2.getInt(cursor2.getColumnIndex(ConversationInboxTable.Columns.PERSIST_MESSAGE_BOX)) == 1, cursor2.getString(cursor2.getColumnIndex(ConversationInboxTable.Columns.LAST_SYNC_TIMESTAMP)), DatabaseUtils.parseBooleanColumnSafe(cursor2, "has_older_messages"), (Long) DatabaseUtils.parseColumnSafe(cursor2, "last_conv_redaction_time", Long.class));
    }

    private Faq cursorToFaq(Cursor cursor) {
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("question_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("publish_id"));
        String string3 = cursor.getString(cursor.getColumnIndex("language"));
        String string4 = cursor.getString(cursor.getColumnIndex("section_id"));
        String string5 = cursor.getString(cursor.getColumnIndex("title"));
        String string6 = cursor.getString(cursor.getColumnIndex("body"));
        int i = cursor.getInt(cursor.getColumnIndex("helpful"));
        boolean z = true;
        if (cursor.getInt(cursor.getColumnIndex("rtl")) != 1) {
            z = false;
        }
        return new Faq(j, string, string2, string3, string4, string5, string6, i, Boolean.valueOf(z), HSJSONUtils.jsonArrayToStringArrayList(cursor.getString(cursor.getColumnIndex("tags"))), HSJSONUtils.jsonArrayToStringArrayList(cursor.getString(cursor.getColumnIndex("c_tags"))));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v58, resolved type: com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v69, resolved type: com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v70, resolved type: com.helpshift.conversation.activeconversation.message.AdminBotControlMessageDM} */
    /* JADX WARNING: type inference failed for: r7v1, types: [com.helpshift.conversation.activeconversation.message.MessageDM] */
    /* JADX WARNING: type inference failed for: r22v3 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r7v21 */
    /* JADX WARNING: type inference failed for: r7v26 */
    /* JADX WARNING: type inference failed for: r7v28 */
    /* JADX WARNING: type inference failed for: r13v34, types: [com.helpshift.conversation.activeconversation.message.UserBotControlMessageDM] */
    /* JADX WARNING: type inference failed for: r7v29 */
    /* JADX WARNING: type inference failed for: r13v36, types: [com.helpshift.conversation.activeconversation.message.UserMessageDM] */
    /* JADX WARNING: type inference failed for: r13v37, types: [com.helpshift.conversation.activeconversation.message.UserResponseMessageForTextInputDM] */
    /* JADX WARNING: type inference failed for: r13v38, types: [com.helpshift.conversation.activeconversation.message.UserResponseMessageForOptionInput] */
    /* JADX WARNING: type inference failed for: r13v39, types: [com.helpshift.conversation.activeconversation.message.UserResponseMessageForCSATInput] */
    /* JADX WARNING: type inference failed for: r15v39, types: [com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM] */
    /* JADX WARNING: type inference failed for: r11v21, types: [com.helpshift.conversation.activeconversation.message.AdminMessageDM] */
    /* JADX WARNING: type inference failed for: r11v22, types: [com.helpshift.conversation.activeconversation.message.AdminMessageWithTextInputDM] */
    /* JADX WARNING: type inference failed for: r11v23, types: [com.helpshift.conversation.activeconversation.message.AdminMessageWithOptionInputDM] */
    /* JADX WARNING: type inference failed for: r11v24, types: [com.helpshift.conversation.activeconversation.message.AdminResolutionMessageWithOptions] */
    /* JADX WARNING: type inference failed for: r11v25, types: [com.helpshift.conversation.activeconversation.message.AdminCSATMessageWithOptions] */
    /* JADX WARNING: type inference failed for: r11v26, types: [com.helpshift.conversation.activeconversation.message.FAQListMessageDM] */
    /* JADX WARNING: type inference failed for: r11v27, types: [com.helpshift.conversation.activeconversation.message.FAQListMessageWithOptionInputDM] */
    /* JADX WARNING: type inference failed for: r13v40, types: [com.helpshift.conversation.activeconversation.message.AcceptedAppReviewMessageDM] */
    /* JADX WARNING: type inference failed for: r11v28, types: [com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM] */
    /* JADX WARNING: type inference failed for: r13v41, types: [com.helpshift.conversation.activeconversation.message.FollowupAcceptedMessageDM] */
    /* JADX WARNING: type inference failed for: r13v42, types: [com.helpshift.conversation.activeconversation.message.FollowupRejectedMessageDM] */
    /* JADX WARNING: type inference failed for: r13v43, types: [com.helpshift.conversation.activeconversation.message.ConfirmationAcceptedMessageDM] */
    /* JADX WARNING: type inference failed for: r13v44, types: [com.helpshift.conversation.activeconversation.message.ConfirmationRejectedMessageDM] */
    /* JADX WARNING: type inference failed for: r13v45, types: [com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM] */
    /* JADX WARNING: type inference failed for: r13v46, types: [com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM] */
    /* JADX WARNING: type inference failed for: r11v29, types: [com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM] */
    /* JADX WARNING: type inference failed for: r11v30, types: [com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM] */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x01a7, code lost:
        r30 = r2;
        r28 = r7;
        r31 = r9;
        r7 = r1;
        r9 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0208, code lost:
        r7 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0313, code lost:
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x05f3, code lost:
        r7 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x06ff, code lost:
        r7.conversationLocalId = java.lang.Long.valueOf(r31);
        r7.localId = java.lang.Long.valueOf(r28);
        r7.deliveryState = r27;
        r7.isRedacted = r30;
        parseAndSetMessageSeenData(r7, r9);
        parseFeedbackMessageData(r7, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0719, code lost:
        return r7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.helpshift.conversation.activeconversation.message.MessageDM cursorToMessageDM(android.database.Cursor r34) {
        /*
            r33 = this;
            r6 = r33
            r0 = r34
            java.lang.String r1 = "_id"
            int r1 = r0.getColumnIndex(r1)
            long r7 = r0.getLong(r1)
            java.lang.String r1 = "conversation_id"
            int r1 = r0.getColumnIndex(r1)
            long r9 = r0.getLong(r1)
            java.lang.String r1 = "server_id"
            int r1 = r0.getColumnIndex(r1)
            java.lang.String r12 = r0.getString(r1)
            java.lang.String r1 = "body"
            int r1 = r0.getColumnIndex(r1)
            java.lang.String r14 = r0.getString(r1)
            java.lang.String r1 = "meta"
            int r1 = r0.getColumnIndex(r1)
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "type"
            int r2 = r0.getColumnIndex(r2)
            java.lang.String r2 = r0.getString(r2)
            java.lang.String r3 = "created_at"
            int r3 = r0.getColumnIndex(r3)
            java.lang.String r17 = r0.getString(r3)
            java.lang.String r3 = "author_name"
            int r3 = r0.getColumnIndex(r3)
            java.lang.String r3 = r0.getString(r3)
            java.lang.String r4 = "author_role"
            int r4 = r0.getColumnIndex(r4)
            java.lang.String r4 = r0.getString(r4)
            java.lang.String r5 = "author_id"
            int r5 = r0.getColumnIndex(r5)
            java.lang.String r5 = r0.getString(r5)
            java.lang.String r11 = "local_avatar_image_path"
            int r11 = r0.getColumnIndex(r11)
            java.lang.String r11 = r0.getString(r11)
            java.lang.String r13 = "epoch_time_created_at"
            int r13 = r0.getColumnIndex(r13)
            boolean r15 = r0.isNull(r13)
            r18 = 0
            if (r15 == 0) goto L_0x0083
            r15 = r18
            goto L_0x0087
        L_0x0083:
            long r15 = r0.getLong(r13)
        L_0x0087:
            int r13 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r13 > 0) goto L_0x008f
            long r15 = com.helpshift.common.util.HSDateFormatSpec.convertToEpochTime(r17)
        L_0x008f:
            r18 = r15
            java.lang.String r13 = "md_state"
            int r13 = r0.getColumnIndex(r13)
            int r15 = r0.getInt(r13)
            r13 = 0
            r16 = r15
            java.lang.String r15 = "is_redacted"
            boolean r15 = com.helpshift.util.DatabaseUtils.parseBooleanColumnSafe(r0, r15, r13)
            com.helpshift.conversation.activeconversation.message.MessageType r0 = com.helpshift.conversation.activeconversation.message.MessageType.fromValue(r2)
            org.json.JSONObject r13 = r6.jsonify(r1)
            int r0 = r0.ordinal()
            r1 = 0
            switch(r0) {
                case 0: goto L_0x06dc;
                case 1: goto L_0x05d0;
                case 2: goto L_0x03f8;
                case 3: goto L_0x03cd;
                case 4: goto L_0x039e;
                case 5: goto L_0x036c;
                case 6: goto L_0x0341;
                case 7: goto L_0x0316;
                case 8: goto L_0x02c1;
                case 9: goto L_0x024e;
                case 10: goto L_0x020b;
                case 11: goto L_0x01b1;
                case 12: goto L_0x017b;
                case 13: goto L_0x058c;
                case 14: goto L_0x0542;
                case 15: goto L_0x0473;
                case 16: goto L_0x0427;
                case 17: goto L_0x00b4;
                case 18: goto L_0x00b4;
                case 19: goto L_0x013f;
                case 20: goto L_0x00f5;
                case 21: goto L_0x0696;
                case 22: goto L_0x065b;
                case 23: goto L_0x00b4;
                case 24: goto L_0x00b4;
                case 25: goto L_0x00b4;
                case 26: goto L_0x00b4;
                case 27: goto L_0x0279;
                case 28: goto L_0x00b5;
                case 29: goto L_0x05f7;
                case 30: goto L_0x04f8;
                case 31: goto L_0x04ac;
                case 32: goto L_0x061c;
                default: goto L_0x00b4;
            }
        L_0x00b4:
            return r1
        L_0x00b5:
            com.helpshift.conversation.activeconversation.model.ActionCard r20 = r6.readActionCard(r12)
            if (r20 != 0) goto L_0x00bc
            return r1
        L_0x00bc:
            java.lang.String r0 = "original_message_server_id"
            java.lang.String r1 = ""
            java.lang.String r21 = r6.getStringFromJson(r13, r0, r1)
            com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM r22 = new com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM
            r23 = 0
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r23
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            r11 = r22
            r2 = r13
            r13 = r14
            r14 = r17
            r3 = r15
            r1 = r16
            r15 = r18
            r17 = r0
            r18 = r21
            r19 = r20
            r11.<init>(r12, r13, r14, r15, r17, r18, r19)
            r27 = r1
            r30 = r3
            r28 = r7
            r31 = r9
            r7 = r22
            r9 = r2
            goto L_0x06ff
        L_0x00f5:
            r2 = r13
            r1 = r16
            java.lang.String r20 = r6.parseBotActionTypeFromMeta(r2)
            java.lang.String r21 = r6.parseBotInfoFromMeta(r2)
            java.lang.String r22 = r6.parseBotEndedReasonFromMeta(r2)
            java.lang.String r23 = r6.parseReferredMessageIdFromMeta(r2)
            int r24 = r6.parseAndGetMessageSyncState(r12, r2)
            com.helpshift.conversation.activeconversation.message.UserBotControlMessageDM r13 = new com.helpshift.conversation.activeconversation.message.UserBotControlMessageDM
            r16 = 1
            r0 = r33
            r27 = r1
            r1 = r3
            r3 = r2
            r2 = r5
            r5 = r3
            r3 = r4
            r4 = r11
            r11 = r5
            r5 = r16
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            r1 = r13
            r2 = r15
            r15 = r17
            r16 = r18
            r18 = r0
            r19 = r20
            r20 = r22
            r22 = r23
            r23 = r24
            r13.<init>(r14, r15, r16, r18, r19, r20, r21, r22, r23)
            r1.serverId = r12
            r30 = r2
            r28 = r7
            r31 = r9
            r9 = r11
            goto L_0x0208
        L_0x013f:
            r2 = r15
            r27 = r16
            r15 = r13
            java.lang.String r20 = r6.parseBotActionTypeFromMeta(r15)
            java.lang.String r21 = r6.parseBotInfoFromMeta(r15)
            java.lang.Boolean r22 = r6.parseHasNextBotFromMeta(r15)
            com.helpshift.conversation.activeconversation.message.AdminBotControlMessageDM r13 = new com.helpshift.conversation.activeconversation.message.AdminBotControlMessageDM
            r16 = 0
            r0 = r33
            r1 = r3
            r3 = r2
            r2 = r5
            r5 = r3
            r3 = r4
            r4 = r11
            r11 = r5
            r5 = r16
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            r2 = r11
            r11 = r13
            r1 = r13
            r13 = r14
            r14 = r17
            r3 = r15
            r15 = r18
            r17 = r0
            r18 = r20
            r19 = r21
            r11.<init>(r12, r13, r14, r15, r17, r18, r19)
            boolean r0 = r22.booleanValue()
            r1.hasNextBot = r0
            goto L_0x01a7
        L_0x017b:
            r2 = r15
            r27 = r16
            r15 = r13
            com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM r13 = new com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM
            r16 = 0
            r0 = r33
            r1 = r3
            r3 = r2
            r2 = r5
            r5 = r3
            r3 = r4
            r4 = r11
            r11 = r5
            r5 = r16
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            r2 = r11
            r11 = r13
            r1 = r13
            r13 = r14
            r14 = r17
            r3 = r15
            r15 = r18
            r17 = r0
            r11.<init>(r12, r13, r14, r15, r17)
            boolean r0 = r6.parseIsAnsweredFromMeta(r3)
            r1.setAnswered(r0)
        L_0x01a7:
            r30 = r2
            r28 = r7
            r31 = r9
            r7 = r1
            r9 = r3
            goto L_0x06ff
        L_0x01b1:
            r2 = r15
            r27 = r16
            r15 = r13
            com.helpshift.common.conversation.ConversationDB$ImageAttachmentInfo r13 = r6.parseImageAttachmentInfoFromMeta(r15)
            com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM r1 = new com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM
            r16 = 0
            r0 = r33
            r34 = r1
            r1 = r3
            r3 = r2
            r2 = r5
            r5 = r3
            r3 = r4
            r4 = r11
            r11 = r5
            r5 = r16
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            java.lang.String r1 = r13.url
            java.lang.String r2 = r13.fileName
            java.lang.String r3 = r13.thumbnailUrl
            java.lang.String r4 = r13.contentType
            boolean r5 = r13.isSecure
            r28 = r7
            int r7 = r13.size
            r8 = r11
            r11 = r34
            r30 = r8
            r8 = r13
            r13 = r14
            r14 = r17
            r31 = r9
            r9 = r15
            r15 = r18
            r17 = r0
            r18 = r1
            r19 = r2
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r7
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23)
            java.lang.String r0 = r8.filePath
            r1 = r34
            r1.filePath = r0
            java.lang.String r0 = r8.thumbnailFilePath
            r1.thumbnailFilePath = r0
            r1.updateState()
        L_0x0208:
            r7 = r1
            goto L_0x06ff
        L_0x020b:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.common.conversation.ConversationDB$AttachmentInfo r7 = r6.parseAttachmentInfoFromMeta(r9)
            com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM r8 = new com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM
            r10 = 0
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r10
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            int r1 = r7.size
            java.lang.String r2 = r7.contentType
            java.lang.String r3 = r7.url
            java.lang.String r4 = r7.fileName
            boolean r5 = r7.isSecure
            r11 = r8
            r13 = r14
            r14 = r17
            r15 = r18
            r17 = r0
            r18 = r1
            r19 = r2
            r20 = r3
            r21 = r4
            r22 = r5
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r21, r22)
            java.lang.String r0 = r7.filePath
            r8.filePath = r0
            r8.updateState()
            goto L_0x0313
        L_0x024e:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM r22 = new com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM
            r7 = 0
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r7
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            boolean r1 = r6.parseIsAnsweredFromMeta(r9)
            r11 = r22
            r13 = r14
            r14 = r17
            r15 = r18
            r17 = r0
            r18 = r1
            r11.<init>(r12, r13, r14, r15, r17, r18)
            goto L_0x05f3
        L_0x0279:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.common.conversation.ConversationDB$AttachmentInfo r7 = r6.parseAttachmentInfoFromMeta(r9)
            com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM r8 = new com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM
            r10 = 1
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r10
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            int r1 = r7.size
            java.lang.String r2 = r7.contentType
            java.lang.String r3 = r7.url
            java.lang.String r4 = r7.fileName
            boolean r5 = r7.isSecure
            r13 = r8
            r15 = r17
            r16 = r18
            r18 = r0
            r19 = r1
            r20 = r2
            r21 = r3
            r22 = r4
            r23 = r5
            r13.<init>(r14, r15, r16, r18, r19, r20, r21, r22, r23)
            java.lang.String r0 = r7.filePath
            r8.filePath = r0
            r8.serverId = r12
            boolean r0 = r7.isZipped
            r8.isZipped = r0
            boolean r0 = r7.isRejected
            r8.isRejected = r0
            goto L_0x0313
        L_0x02c1:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.common.conversation.ConversationDB$ImageAttachmentInfo r7 = r6.parseImageAttachmentInfoFromMeta(r9)
            com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM r8 = new com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM
            r10 = 1
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r10
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            java.lang.String r1 = r7.contentType
            java.lang.String r2 = r7.thumbnailUrl
            java.lang.String r3 = r7.fileName
            java.lang.String r4 = r7.url
            int r5 = r7.size
            boolean r10 = r7.isSecure
            r13 = r8
            r15 = r17
            r16 = r18
            r18 = r0
            r19 = r1
            r20 = r2
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r10
            r13.<init>(r14, r15, r16, r18, r19, r20, r21, r22, r23, r24)
            java.lang.String r0 = r7.filePath
            r8.filePath = r0
            r8.serverId = r12
            java.lang.String r0 = r6.parseReferredMessageIdFromMeta(r9)
            r8.setRefersMessageId(r0)
            boolean r0 = r7.isZipped
            r8.isZipped = r0
            boolean r0 = r7.isRejected
            r8.isRejected = r0
        L_0x0313:
            r7 = r8
            goto L_0x06ff
        L_0x0316:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.ConfirmationRejectedMessageDM r7 = new com.helpshift.conversation.activeconversation.message.ConfirmationRejectedMessageDM
            r8 = 0
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            int r1 = r6.parseAndGetMessageSyncState(r12, r9)
            r13 = r7
            r15 = r17
            r16 = r18
            r18 = r0
            r19 = r1
            r13.<init>(r14, r15, r16, r18, r19)
            r7.serverId = r12
            goto L_0x06ff
        L_0x0341:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.ConfirmationAcceptedMessageDM r7 = new com.helpshift.conversation.activeconversation.message.ConfirmationAcceptedMessageDM
            r8 = 1
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            int r1 = r6.parseAndGetMessageSyncState(r12, r9)
            r13 = r7
            r15 = r17
            r16 = r18
            r18 = r0
            r19 = r1
            r13.<init>(r14, r15, r16, r18, r19)
            r7.serverId = r12
            goto L_0x06ff
        L_0x036c:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.FollowupRejectedMessageDM r7 = new com.helpshift.conversation.activeconversation.message.FollowupRejectedMessageDM
            r8 = 1
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            java.lang.String r1 = r6.parseReferredMessageIdFromMeta(r9)
            int r20 = r6.parseAndGetMessageSyncState(r12, r9)
            r13 = r7
            r15 = r17
            r16 = r18
            r18 = r0
            r19 = r1
            r13.<init>(r14, r15, r16, r18, r19, r20)
            r7.serverId = r12
            r6.parseAndSetFollowUpRejectedDataFromMeta(r7, r9)
            goto L_0x06ff
        L_0x039e:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.FollowupAcceptedMessageDM r7 = new com.helpshift.conversation.activeconversation.message.FollowupAcceptedMessageDM
            r8 = 1
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            java.lang.String r1 = r6.parseReferredMessageIdFromMeta(r9)
            int r20 = r6.parseAndGetMessageSyncState(r12, r9)
            r13 = r7
            r15 = r17
            r16 = r18
            r18 = r0
            r19 = r1
            r13.<init>(r14, r15, r16, r18, r19, r20)
            r7.serverId = r12
            goto L_0x06ff
        L_0x03cd:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM r22 = new com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM
            r7 = 0
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r7
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            boolean r1 = r6.parseIsAnsweredFromMeta(r9)
            r11 = r22
            r13 = r14
            r14 = r17
            r15 = r18
            r17 = r0
            r18 = r1
            r11.<init>(r12, r13, r14, r15, r17, r18)
            goto L_0x05f3
        L_0x03f8:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.AcceptedAppReviewMessageDM r7 = new com.helpshift.conversation.activeconversation.message.AcceptedAppReviewMessageDM
            r8 = 1
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            java.lang.String r1 = r6.parseReferredMessageIdFromMeta(r9)
            int r20 = r6.parseAndGetMessageSyncState(r12, r9)
            r13 = r7
            r15 = r17
            r16 = r18
            r18 = r0
            r19 = r1
            r13.<init>(r14, r15, r16, r18, r19, r20)
            r7.serverId = r12
            goto L_0x06ff
        L_0x0427:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.FAQListMessageWithOptionInputDM r7 = new com.helpshift.conversation.activeconversation.message.FAQListMessageWithOptionInputDM
            r8 = 0
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            java.util.List r1 = r6.parseFAQListFromMeta(r9)
            java.lang.String r2 = r6.parseFAQListSourceFromMeta(r9)
            java.lang.String r20 = r6.parseBotInfoFromMeta(r9)
            boolean r21 = r6.parseInputRequiredFromMeta(r9)
            java.lang.String r22 = r6.parseInputLabelFromMeta(r9)
            java.lang.String r23 = r6.parseInputSkipLabelFromMeta(r9)
            java.util.List r24 = r6.parseInputOptionsFromMeta(r9)
            boolean r25 = r6.parseIsSuggestionsReadEventSent(r9)
            java.lang.String r26 = r6.parseSuggestionReadFAQPublishId(r9)
            r11 = r7
            r13 = r14
            r14 = r17
            r15 = r18
            r17 = r0
            r18 = r1
            r19 = r2
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x06ff
        L_0x0473:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.FAQListMessageDM r22 = new com.helpshift.conversation.activeconversation.message.FAQListMessageDM
            r7 = 0
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r7
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            java.util.List r1 = r6.parseFAQListFromMeta(r9)
            java.lang.String r2 = r6.parseFAQListSourceFromMeta(r9)
            boolean r20 = r6.parseIsSuggestionsReadEventSent(r9)
            java.lang.String r21 = r6.parseSuggestionReadFAQPublishId(r9)
            r11 = r22
            r13 = r14
            r14 = r17
            r15 = r18
            r17 = r0
            r18 = r1
            r19 = r2
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r21)
            goto L_0x05f3
        L_0x04ac:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            java.util.List r25 = r6.parseCSATInputRatingsFromMeta(r9)
            com.helpshift.conversation.activeconversation.message.AdminCSATMessageWithOptions r7 = new com.helpshift.conversation.activeconversation.message.AdminCSATMessageWithOptions
            r8 = 0
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            java.lang.String r1 = r6.parseBotInfoFromMeta(r9)
            boolean r2 = r6.parseInputRequiredFromMeta(r9)
            java.lang.String r20 = r6.parseInputLabelFromMeta(r9)
            java.lang.String r21 = r6.parseInputSkipLabelFromMeta(r9)
            java.lang.String r22 = r6.parseSendFeedbackLabelFromMeta(r9)
            boolean r23 = r6.parseShowConvButtonFromMeta(r9)
            java.lang.String r24 = r6.parseStartNewConversationLabelFromMeta(r9)
            com.helpshift.conversation.activeconversation.message.input.CSATRatingsInput$Type r26 = r6.parseCSATRatingInputTypeFromMeta(r9)
            r11 = r7
            r13 = r14
            r14 = r17
            r15 = r18
            r17 = r0
            r18 = r1
            r19 = r2
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x06ff
        L_0x04f8:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            java.util.List r22 = r6.parseInputOptionsFromMeta(r9)
            com.helpshift.conversation.activeconversation.message.AdminResolutionMessageWithOptions r7 = new com.helpshift.conversation.activeconversation.message.AdminResolutionMessageWithOptions
            r8 = 0
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            java.lang.String r1 = r6.parseBotInfoFromMeta(r9)
            boolean r2 = r6.parseInputRequiredFromMeta(r9)
            java.lang.String r20 = r6.parseInputLabelFromMeta(r9)
            java.lang.String r21 = r6.parseInputSkipLabelFromMeta(r9)
            int r3 = r22.size()
            com.helpshift.conversation.activeconversation.message.input.OptionInput$Type r23 = r6.parseInputOptionTypeFromMeta(r9, r3)
            r11 = r7
            r13 = r14
            r14 = r17
            r15 = r18
            r17 = r0
            r18 = r1
            r19 = r2
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23)
            int r0 = r6.parseAttachmentCountFromMeta(r9)
            r7.attachmentCount = r0
            goto L_0x06ff
        L_0x0542:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            java.util.List r22 = r6.parseInputOptionsFromMeta(r9)
            com.helpshift.conversation.activeconversation.message.AdminMessageWithOptionInputDM r7 = new com.helpshift.conversation.activeconversation.message.AdminMessageWithOptionInputDM
            r8 = 0
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            java.lang.String r1 = r6.parseBotInfoFromMeta(r9)
            boolean r2 = r6.parseInputRequiredFromMeta(r9)
            java.lang.String r20 = r6.parseInputLabelFromMeta(r9)
            java.lang.String r21 = r6.parseInputSkipLabelFromMeta(r9)
            int r3 = r22.size()
            com.helpshift.conversation.activeconversation.message.input.OptionInput$Type r23 = r6.parseInputOptionTypeFromMeta(r9, r3)
            r11 = r7
            r13 = r14
            r14 = r17
            r15 = r18
            r17 = r0
            r18 = r1
            r19 = r2
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23)
            int r0 = r6.parseAttachmentCountFromMeta(r9)
            r7.attachmentCount = r0
            goto L_0x06ff
        L_0x058c:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.AdminMessageWithTextInputDM r7 = new com.helpshift.conversation.activeconversation.message.AdminMessageWithTextInputDM
            r8 = 0
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            java.lang.String r1 = r6.parseBotInfoFromMeta(r9)
            java.lang.String r2 = r6.parseInputPlaceholderFromMeta(r9)
            boolean r20 = r6.parseInputRequiredFromMeta(r9)
            java.lang.String r21 = r6.parseInputLabelFromMeta(r9)
            java.lang.String r22 = r6.parseInputSkipLabelFromMeta(r9)
            int r23 = r6.parseInputKeyboardFromMeta(r9)
            boolean r24 = r6.parseIsMessageEmptyFromMeta(r9)
            r11 = r7
            r13 = r14
            r14 = r17
            r15 = r18
            r17 = r0
            r18 = r1
            r19 = r2
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24)
            goto L_0x06ff
        L_0x05d0:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.AdminMessageDM r22 = new com.helpshift.conversation.activeconversation.message.AdminMessageDM
            r7 = 0
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r7
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            r11 = r22
            r13 = r14
            r14 = r17
            r15 = r18
            r17 = r0
            r11.<init>(r12, r13, r14, r15, r17)
        L_0x05f3:
            r7 = r22
            goto L_0x06ff
        L_0x05f7:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM r7 = new com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM
            java.util.List r16 = r6.parseIntentLabelFromMeta(r9)
            r8 = 1
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r20 = r0.getAuthor(r1, r2, r3, r4, r5)
            r15 = r7
            r15.<init>(r16, r17, r18, r20)
            r7.body = r14
            r7.serverId = r12
            goto L_0x06ff
        L_0x061c:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.UserResponseMessageForCSATInput r7 = new com.helpshift.conversation.activeconversation.message.UserResponseMessageForCSATInput
            r8 = 1
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            int r1 = r6.parseRatingValueFromMeta(r9)
            boolean r20 = r6.parseIsNewConvClickCSATFromMeta(r9)
            java.lang.String r21 = r6.parseBotInfoFromMeta(r9)
            java.lang.String r22 = r6.parseSelectedOptionDataFromMeta(r9)
            java.lang.String r23 = r6.parseReferredMessageIdFromMeta(r9)
            int r24 = r6.parseAndGetMessageSyncState(r12, r9)
            r13 = r7
            r15 = r17
            r16 = r18
            r18 = r0
            r19 = r1
            r13.<init>(r14, r15, r16, r18, r19, r20, r21, r22, r23, r24)
            r7.serverId = r12
            goto L_0x06ff
        L_0x065b:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.UserResponseMessageForOptionInput r7 = new com.helpshift.conversation.activeconversation.message.UserResponseMessageForOptionInput
            r8 = 1
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            java.lang.String r1 = r6.parseBotInfoFromMeta(r9)
            boolean r20 = r6.parseIsResponseSkippedFromMeta(r9)
            java.lang.String r21 = r6.parseSelectedOptionDataFromMeta(r9)
            java.lang.String r22 = r6.parseReferredMessageIdFromMeta(r9)
            com.helpshift.conversation.activeconversation.message.MessageType r23 = r6.parseReferredMessageTypeFromMeta(r9)
            r13 = r7
            r15 = r17
            r16 = r18
            r18 = r0
            r19 = r1
            r13.<init>(r14, r15, r16, r18, r19, r20, r21, r22, r23)
            r7.serverId = r12
            goto L_0x06ff
        L_0x0696:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.UserResponseMessageForTextInputDM r7 = new com.helpshift.conversation.activeconversation.message.UserResponseMessageForTextInputDM
            r8 = 1
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            int r1 = r6.parseInputKeyboardFromMeta(r9)
            java.lang.String r20 = r6.parseBotInfoFromMeta(r9)
            boolean r21 = r6.parseIsResponseSkippedFromMeta(r9)
            java.lang.String r22 = r6.parseReferredMessageIdFromMeta(r9)
            boolean r23 = r6.parseIsMessageEmptyFromMeta(r9)
            r13 = r7
            r15 = r17
            r16 = r18
            r18 = r0
            r19 = r1
            r13.<init>(r14, r15, r16, r18, r19, r20, r21, r22, r23)
            r7.serverId = r12
            long r0 = r6.parseDateTimeFromMeta(r9)
            r7.dateInMillis = r0
            java.lang.String r0 = r6.parseTimeZoneIdFromMeta(r9)
            r7.timeZoneId = r0
            goto L_0x06ff
        L_0x06dc:
            r28 = r7
            r31 = r9
            r9 = r13
            r30 = r15
            r27 = r16
            com.helpshift.conversation.activeconversation.message.UserMessageDM r7 = new com.helpshift.conversation.activeconversation.message.UserMessageDM
            r8 = 1
            r0 = r33
            r1 = r3
            r2 = r5
            r3 = r4
            r4 = r11
            r5 = r8
            com.helpshift.conversation.activeconversation.message.Author r0 = r0.getAuthor(r1, r2, r3, r4, r5)
            r13 = r7
            r15 = r17
            r16 = r18
            r18 = r0
            r13.<init>(r14, r15, r16, r18)
            r7.serverId = r12
        L_0x06ff:
            java.lang.Long r0 = java.lang.Long.valueOf(r31)
            r7.conversationLocalId = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r28)
            r7.localId = r0
            r0 = r27
            r7.deliveryState = r0
            r0 = r30
            r7.isRedacted = r0
            r6.parseAndSetMessageSeenData(r7, r9)
            r6.parseFeedbackMessageData(r7, r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.cursorToMessageDM(android.database.Cursor):com.helpshift.conversation.activeconversation.message.MessageDM");
    }

    private Conversation cursorToReadableConversation(Cursor cursor) {
        Cursor cursor2 = cursor;
        Class cls = Long.class;
        Long valueOf = Long.valueOf(cursor2.getLong(cursor2.getColumnIndex("_id")));
        long j = cursor2.getLong(cursor2.getColumnIndex("user_local_id"));
        String string = cursor2.getString(cursor2.getColumnIndex("server_id"));
        String string2 = cursor2.getString(cursor2.getColumnIndex("publish_id"));
        String string3 = cursor2.getString(cursor2.getColumnIndex(ConversationTable.Columns.LOCAL_UUID));
        String string4 = cursor2.getString(cursor2.getColumnIndex("title"));
        String string5 = cursor2.getString(cursor2.getColumnIndex(ConversationTable.Columns.MESSAGE_CURSOR));
        boolean z = cursor2.getInt(cursor2.getColumnIndex(ConversationTable.Columns.IS_START_NEW_CONVERSATION_CLICKED)) == 1;
        String string6 = cursor2.getString(cursor2.getColumnIndex("meta"));
        String string7 = cursor2.getString(cursor2.getColumnIndex("created_at"));
        long j2 = cursor2.getLong(cursor2.getColumnIndex("epoch_time_created_at"));
        String string8 = cursor2.getString(cursor2.getColumnIndex(ConversationTable.Columns.UPDATED_AT));
        String string9 = cursor2.getString(cursor2.getColumnIndex(ConversationTable.Columns.PRE_CONVERSATION_SERVER_ID));
        long j3 = cursor2.getLong(cursor2.getColumnIndex(ConversationTable.Columns.LAST_USER_ACTIVITY_TIME));
        String str = string9;
        String string10 = cursor2.getString(cursor2.getColumnIndex(ConversationTable.Columns.ISSUE_TYPE));
        long j4 = j3;
        boolean parseBooleanColumnSafe = DatabaseUtils.parseBooleanColumnSafe(cursor2, ConversationTable.Columns.FULL_PRIVACY_ENABLED, false);
        IssueState fromInt = IssueState.fromInt(cursor2.getInt(cursor2.getColumnIndex("state")));
        boolean parseBooleanColumnSafe2 = DatabaseUtils.parseBooleanColumnSafe(cursor2, "is_redacted", false);
        String string11 = cursor2.getString(cursor2.getColumnIndex("acid"));
        boolean z2 = parseBooleanColumnSafe2;
        Long l = (Long) DatabaseUtils.parseColumnSafe(cursor2, ConversationTable.Columns.RESOLUTION_EXPIRY_AT, cls);
        Long l2 = (Long) DatabaseUtils.parseColumnSafe(cursor2, ConversationTable.Columns.CSAT_EXPIRY_AT, cls);
        String str2 = string11;
        boolean z3 = cursor2.getInt(cursor2.getColumnIndex(ConversationTable.Columns.FEEDBACK_BOT_ENABLED)) == 1;
        boolean z4 = cursor2.getInt(cursor2.getColumnIndex(ConversationTable.Columns.CAN_START_NEW_CONVERSATION)) == 1;
        boolean z5 = z3;
        String str3 = str;
        Long l3 = l2;
        boolean z6 = z2;
        Conversation conversation = r7;
        Conversation conversation2 = new Conversation(string4, fromInt, string7, j2, string8, string2, string5, string10, str2);
        conversation.serverId = string;
        conversation.preConversationServerId = str3;
        conversation.setLocalId(valueOf.longValue());
        conversation.localUUID = string3;
        conversation.state = fromInt;
        conversation.userLocalId = j;
        conversation.isStartNewConversationClicked = z;
        conversation.lastUserActivityTime = j4;
        conversation.wasFullPrivacyEnabledAtCreation = parseBooleanColumnSafe;
        conversation.isRedacted = z2;
        conversation.acid = str2;
        conversation.resolutionExpiryAt = l;
        conversation.csatExpiryAt = l3;
        conversation.isFeedbackBotEnabled = z5;
        conversation.shouldAllowNewConversationCreation = z4;
        parseAndSetMetaData(conversation, string6);
        return conversation;
    }

    private boolean exists(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) FROM ");
        sb.append(str);
        sb.append(" WHERE ");
        sb.append(str2);
        sb.append(" LIMIT 1");
        return android.database.DatabaseUtils.longForQuery(sQLiteDatabase, sb.toString(), strArr) > 0;
    }

    public static ContentValues faqToContentValues(Faq faq) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("question_id", faq.getId());
        contentValues.put("publish_id", faq.publish_id);
        contentValues.put("language", faq.language);
        contentValues.put("section_id", faq.section_publish_id);
        contentValues.put("title", faq.title);
        contentValues.put("body", faq.body);
        contentValues.put("helpful", Integer.valueOf(faq.is_helpful));
        contentValues.put("rtl", faq.is_rtl);
        contentValues.put("tags", String.valueOf(new JSONArray(faq.getTags())));
        contentValues.put("c_tags", String.valueOf(new JSONArray(faq.getCategoryTags())));
        return contentValues;
    }

    private Author getAuthor(String str, String str2, String str3, String str4, boolean z) {
        Author.AuthorRole authorRole;
        if (z) {
            authorRole = Author.AuthorRole.LOCAL_USER;
        } else {
            authorRole = Author.AuthorRole.getEnum(str3);
        }
        Author author = new Author(str, str2, authorRole);
        author.localAvatarImagePath = str4;
        return author;
    }

    private boolean getBooleanFromJson(@NonNull JSONObject jSONObject, String str, boolean z) {
        return jSONObject.optBoolean(str, z);
    }

    private String getConversationMeta(Conversation conversation) throws JSONException {
        ConversationCSATState conversationCSATState = conversation.csatState;
        JSONObject jSONObject = new JSONObject();
        String str = conversation.csatFeedback;
        int i = conversation.csatRating;
        jSONObject.put("csat_feedback", str);
        jSONObject.put("csat_rating", i);
        jSONObject.put("csat_state", conversationCSATState.getValue());
        jSONObject.put("increment_message_count", conversation.shouldIncrementMessageCount);
        jSONObject.put("ended_delegate_sent", conversation.isConversationEndedDelegateSent);
        jSONObject.put("is_autofilled_preissue", conversation.isAutoFilledPreIssue);
        if (StringUtils.isNotEmpty(conversation.smartIntentTreeId)) {
            jSONObject.put("smart_intent_tree_id", conversation.smartIntentTreeId);
        }
        if (StringUtils.isNotEmpty(conversation.smartIntentUserQuery)) {
            jSONObject.put("smart_intent_user_query", conversation.smartIntentUserQuery);
        }
        JSONArray listToJsonArray = HSJSONUtils.listToJsonArray(conversation.smartIntentIds);
        String jSONArray = listToJsonArray != null ? listToJsonArray.toString() : null;
        if (StringUtils.isNotEmpty(jSONArray)) {
            jSONObject.put("smart_intent_ids", jSONArray);
        }
        return jSONObject.toString();
    }

    private String getImageAttachmentDraftMeta(AttachmentPickerFile attachmentPickerFile) throws JSONException {
        if (attachmentPickerFile == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("image_draft_orig_name", attachmentPickerFile.originalFileName);
        jSONObject.put("image_draft_orig_size", attachmentPickerFile.originalFileSize);
        jSONObject.put("image_draft_file_path", attachmentPickerFile.filePath);
        jSONObject.put("attachment_type", attachmentPickerFile.attachmentType);
        jSONObject.put("image_copy_done", attachmentPickerFile.isFileCompressionAndCopyingDone);
        return jSONObject.toString();
    }

    public static synchronized ConversationDB getInstance(Context context) {
        ConversationDB conversationDB;
        synchronized (ConversationDB.class) {
            if (instance == null) {
                instance = new ConversationDB(context);
            }
            conversationDB = instance;
        }
        return conversationDB;
    }

    private int getIntFromJson(@NonNull JSONObject jSONObject, String str, int i) {
        return jSONObject.optInt(str, i);
    }

    private String getMessageMeta(MessageDM messageDM) throws JSONException {
        MessageType messageType = messageDM.messageType;
        JSONObject jSONObject = new JSONObject();
        switch (messageType.ordinal()) {
            case 1:
                buildMetaForMessageSeenData(jSONObject, messageDM);
                break;
            case 2:
                AcceptedAppReviewMessageDM acceptedAppReviewMessageDM = (AcceptedAppReviewMessageDM) messageDM;
                buildMetaForReferredMessageId(jSONObject, acceptedAppReviewMessageDM.referredMessageId);
                buildMetaForAutoRetriableMessage(jSONObject, acceptedAppReviewMessageDM);
                break;
            case 3:
                buildMetaForIsAnswered(jSONObject, ((RequestAppReviewMessageDM) messageDM).isAnswered);
                buildMetaForMessageSeenData(jSONObject, messageDM);
                break;
            case 4:
                FollowupAcceptedMessageDM followupAcceptedMessageDM = (FollowupAcceptedMessageDM) messageDM;
                buildMetaForReferredMessageId(jSONObject, followupAcceptedMessageDM.referredMessageId);
                buildMetaForAutoRetriableMessage(jSONObject, followupAcceptedMessageDM);
                break;
            case 5:
                FollowupRejectedMessageDM followupRejectedMessageDM = (FollowupRejectedMessageDM) messageDM;
                buildMetaForFollowUpRejected(jSONObject, followupRejectedMessageDM);
                buildMetaForAutoRetriableMessage(jSONObject, followupRejectedMessageDM);
                break;
            case 6:
                buildMetaForAutoRetriableMessage(jSONObject, (ConfirmationAcceptedMessageDM) messageDM);
                break;
            case 7:
                buildMetaForAutoRetriableMessage(jSONObject, (ConfirmationRejectedMessageDM) messageDM);
                break;
            case 8:
                buildMetaForScreenshotAttachmentMessage(jSONObject, (ScreenshotMessageDM) messageDM);
                break;
            case 9:
                buildMetaForIsAnswered(jSONObject, ((RequestScreenshotMessageDM) messageDM).isAnswered);
                buildMetaForMessageSeenData(jSONObject, messageDM);
                break;
            case 10:
                buildJsonObjectForAttachmentMessage(jSONObject, (AttachmentMessageDM) messageDM);
                buildMetaForMessageSeenData(jSONObject, messageDM);
                break;
            case 11:
                buildMetaForImageAttachmentMessage(jSONObject, (ImageAttachmentMessageDM) messageDM);
                buildMetaForMessageSeenData(jSONObject, messageDM);
                break;
            case 12:
                buildMetaForIsAnswered(jSONObject, ((RequestForReopenMessageDM) messageDM).isAnswered());
                buildMetaForMessageSeenData(jSONObject, messageDM);
                break;
            case 13:
                AdminMessageWithTextInputDM adminMessageWithTextInputDM = (AdminMessageWithTextInputDM) messageDM;
                buildMetaForMessageSeenData(jSONObject, messageDM);
                buildMetaForInput(jSONObject, adminMessageWithTextInputDM.input);
                buildMetaForIsMessageEmpty(jSONObject, adminMessageWithTextInputDM.isMessageEmpty);
                break;
            case 14:
                buildMetaForMessageSeenData(jSONObject, messageDM);
                AdminMessageWithOptionInputDM adminMessageWithOptionInputDM = (AdminMessageWithOptionInputDM) messageDM;
                buildMetaForInput(jSONObject, adminMessageWithOptionInputDM.input);
                buildMetaForAttachmentCount(jSONObject, adminMessageWithOptionInputDM.attachmentCount);
                break;
            case 15:
                buildMetaForMessageSeenData(jSONObject, messageDM);
                FAQListMessageDM fAQListMessageDM = (FAQListMessageDM) messageDM;
                buildMetaForFAQList(jSONObject, fAQListMessageDM);
                buildMetaForIsSuggestionsReadEvent(jSONObject, fAQListMessageDM);
                buildMetaForFAQListSource(jSONObject, fAQListMessageDM);
                break;
            case 16:
                buildMetaForMessageSeenData(jSONObject, messageDM);
                buildMetaForFAQList(jSONObject, (FAQListMessageDM) messageDM);
                FAQListMessageWithOptionInputDM fAQListMessageWithOptionInputDM = (FAQListMessageWithOptionInputDM) messageDM;
                buildMetaForInput(jSONObject, fAQListMessageWithOptionInputDM.input);
                buildMetaForIsSuggestionsReadEvent(jSONObject, fAQListMessageWithOptionInputDM);
                buildMetaForFAQListSource(jSONObject, fAQListMessageWithOptionInputDM);
                break;
            case 19:
                buildMetaForAdminBotControlMessage(jSONObject, (AdminBotControlMessageDM) messageDM);
                break;
            case 20:
                UserBotControlMessageDM userBotControlMessageDM = (UserBotControlMessageDM) messageDM;
                buildMetaForUserBotControlMessage(jSONObject, userBotControlMessageDM);
                buildMetaForAutoRetriableMessage(jSONObject, userBotControlMessageDM);
                break;
            case 21:
                UserResponseMessageForTextInputDM userResponseMessageForTextInputDM = (UserResponseMessageForTextInputDM) messageDM;
                buildMetaForBotInfo(jSONObject, userResponseMessageForTextInputDM.botInfo);
                buildMetaForInputKeyboard(jSONObject, userResponseMessageForTextInputDM.keyboard);
                buildMetaForIsResponseSkipped(jSONObject, userResponseMessageForTextInputDM.skipped);
                buildMetaForReferredMessageId(jSONObject, userResponseMessageForTextInputDM.getReferredMessageId());
                buildMetaForIsMessageEmpty(jSONObject, userResponseMessageForTextInputDM.isMessageEmpty);
                buildMetaForDateTime(jSONObject, userResponseMessageForTextInputDM);
                break;
            case 22:
                UserResponseMessageForOptionInput userResponseMessageForOptionInput = (UserResponseMessageForOptionInput) messageDM;
                buildMetaForBotInfo(jSONObject, userResponseMessageForOptionInput.botInfo);
                buildMetaForIsResponseSkipped(jSONObject, userResponseMessageForOptionInput.skipped);
                buildMetaForReferredMessageId(jSONObject, userResponseMessageForOptionInput.getReferredMessageId());
                buildMetaForReferredMessageType(jSONObject, userResponseMessageForOptionInput.referredMessageType);
                buildMetaForSelectedOptionData(jSONObject, userResponseMessageForOptionInput.optionData);
                break;
            case 27:
                buildJsonObjectForAttachmentMessage(jSONObject, (UserAttachmentMessageDM) messageDM);
                break;
            case 28:
                buildMetaForActionCardMessage(jSONObject, (AdminActionCardMessageDM) messageDM);
                break;
            case 29:
                buildMetaForIntentLabels(jSONObject, (UserSmartIntentMessageDM) messageDM);
                break;
            case 30:
                buildMetaForMessageSeenData(jSONObject, messageDM);
                AdminResolutionMessageWithOptions adminResolutionMessageWithOptions = (AdminResolutionMessageWithOptions) messageDM;
                buildMetaForInput(jSONObject, adminResolutionMessageWithOptions.input);
                buildMetaForAttachmentCount(jSONObject, adminResolutionMessageWithOptions.attachmentCount);
                break;
            case 31:
                buildMetaForMessageSeenData(jSONObject, messageDM);
                buildMetaForCSATInput(jSONObject, ((AdminCSATMessageWithOptions) messageDM).csatRatingsInput);
                break;
            case 32:
                UserResponseMessageForCSATInput userResponseMessageForCSATInput = (UserResponseMessageForCSATInput) messageDM;
                buildMetaForBotInfo(jSONObject, userResponseMessageForCSATInput.botInfo);
                buildMetaForIsNewConvClickedCSAT(jSONObject, userResponseMessageForCSATInput.isNewConversationStarted);
                buildMetaForReferredMessageId(jSONObject, userResponseMessageForCSATInput.getReferredMessageId());
                buildMetaForSelectedOptionData(jSONObject, userResponseMessageForCSATInput.optionData);
                buildMetaForRatingValue(jSONObject, userResponseMessageForCSATInput.rating);
                buildMetaForMessageSyncState(jSONObject, userResponseMessageForCSATInput.messageSyncState);
                break;
        }
        buildMetaForFeedbackMessageProperties(jSONObject, messageDM);
        return jSONObject.toString();
    }

    private String getStringFromJson(@NonNull JSONObject jSONObject, String str, String str2) {
        return jSONObject.optString(str, str2);
    }

    private void insertActionCard(SQLiteDatabase sQLiteDatabase, AdminActionCardMessageDM adminActionCardMessageDM) {
        try {
            long insert = sQLiteDatabase.insert(ActionCardTable.TABLE_NAME, (String) null, actionCardToContentValues(adminActionCardMessageDM.actionCard, adminActionCardMessageDM.serverId));
            adminActionCardMessageDM.actionCard.actionCardLocalId = Long.valueOf(insert);
            long insert2 = sQLiteDatabase.insert("actions", (String) null, actionToContentValues(adminActionCardMessageDM.actionCard.action, insert));
            adminActionCardMessageDM.actionCard.action.actionLocalId = Long.valueOf(insert2);
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error in insert action card", e);
        }
    }

    private long insertMessageInternal(SQLiteDatabase sQLiteDatabase, MessageDM messageDM, ContentValues contentValues) {
        long insert = sQLiteDatabase.insert("messages", (String) null, contentValues);
        if (messageDM.messageType == MessageType.ADMIN_ACTION_CARD) {
            insertActionCard(sQLiteDatabase, (AdminActionCardMessageDM) messageDM);
        }
        return insert;
    }

    private JSONObject jsonify(String str) {
        JSONObject jSONObject = new JSONObject();
        if (StringUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            HSLogger.m3242e(TAG, "Exception in jsonify", e);
            return jSONObject;
        }
    }

    private AttachmentPickerFile parseAndGetImageAttachmentDraft(String str) {
        AttachmentPickerFile attachmentPickerFile = null;
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("image_draft_orig_name", (String) null);
            Long valueOf = Long.valueOf(jSONObject.optLong("image_draft_orig_size", -1));
            String optString2 = jSONObject.optString("image_draft_file_path", (String) null);
            int optInt = jSONObject.optInt("attachment_type");
            boolean optBoolean = jSONObject.optBoolean("image_copy_done", false);
            if (valueOf.longValue() == -1) {
                valueOf = null;
            }
            AttachmentPickerFile attachmentPickerFile2 = new AttachmentPickerFile(optString2, optString, valueOf);
            try {
                attachmentPickerFile2.isFileCompressionAndCopyingDone = optBoolean;
                attachmentPickerFile2.attachmentType = optInt;
                return attachmentPickerFile2;
            } catch (JSONException e) {
                e = e;
                attachmentPickerFile = attachmentPickerFile2;
            }
        } catch (JSONException e2) {
            e = e2;
            HSLogger.m3242e(TAG, "Error in parseAndGetImageAttachmentDraft", e);
            return attachmentPickerFile;
        }
    }

    private int parseAndGetMessageSyncState(String str, @NonNull JSONObject jSONObject) {
        if (!StringUtils.isEmpty(str)) {
            return 2;
        }
        return jSONObject.optInt("message_sync_status", 1);
    }

    private void parseAndSetFollowUpRejectedDataFromMeta(FollowupRejectedMessageDM followupRejectedMessageDM, @NonNull JSONObject jSONObject) {
        int optInt = jSONObject.optInt("rejected_reason");
        String optString = jSONObject.optString("rejected_conv_id", (String) null);
        followupRejectedMessageDM.reason = optInt;
        followupRejectedMessageDM.openConversationId = optString;
    }

    private void parseAndSetMessageSeenData(MessageDM messageDM, @NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("read_at", "");
        String optString2 = jSONObject.optString("seen_cursor", (String) null);
        boolean optBoolean = jSONObject.optBoolean("seen_sync_status", false);
        messageDM.seenAtMessageCursor = optString2;
        messageDM.isMessageSeenSynced = optBoolean;
        messageDM.readAt = optString;
    }

    private void parseAndSetMetaData(Conversation conversation, String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("csat_rating", 0);
                int optInt2 = jSONObject.optInt("csat_state", ConversationCSATState.NONE.getValue());
                ArrayList<String> arrayList = null;
                String optString = jSONObject.optString("csat_feedback", (String) null);
                conversation.csatRating = optInt;
                conversation.csatState = ConversationCSATState.fromInt(optInt2);
                conversation.csatFeedback = optString;
                conversation.shouldIncrementMessageCount = jSONObject.optBoolean("increment_message_count", false);
                conversation.isConversationEndedDelegateSent = jSONObject.optBoolean("ended_delegate_sent", false);
                conversation.isAutoFilledPreIssue = jSONObject.optBoolean("is_autofilled_preissue", false);
                conversation.smartIntentTreeId = jSONObject.optString("smart_intent_tree_id", (String) null);
                conversation.smartIntentUserQuery = jSONObject.optString("smart_intent_user_query", (String) null);
                if (!jSONObject.isNull("smart_intent_ids")) {
                    arrayList = HSJSONUtils.jsonArrayToStringArrayList(jSONObject.getString("smart_intent_ids"));
                }
                conversation.smartIntentIds = arrayList;
            } catch (JSONException e) {
                HSLogger.m3242e(TAG, "Error in parseAndSetMetaData", e);
            }
        }
    }

    private int parseAttachmentCountFromMeta(@NonNull JSONObject jSONObject) {
        return getIntFromJson(jSONObject, "attachment_count", 0);
    }

    private AttachmentInfo parseAttachmentInfoFromMeta(@NonNull JSONObject jSONObject) {
        return new AttachmentInfo(jSONObject);
    }

    private String parseBotActionTypeFromMeta(JSONObject jSONObject) {
        return jSONObject.optString("bot_action_type", "");
    }

    private String parseBotEndedReasonFromMeta(JSONObject jSONObject) {
        return jSONObject.optString("bot_ended_reason", "");
    }

    private String parseBotInfoFromMeta(@NonNull JSONObject jSONObject) {
        return jSONObject.optString("chatbot_info", JsonUtils.EMPTY_JSON);
    }

    private List<CSATRatingsInput.Rating> parseCSATInputRatingsFromMeta(@NonNull JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("input_options");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                arrayList.add(new CSATRatingsInput.Rating(jSONObject2.getString("option_title"), jSONObject2.getInt("rating_value"), jSONObject2.getString("option_data")));
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    private CSATRatingsInput.Type parseCSATRatingInputTypeFromMeta(JSONObject jSONObject) {
        return CSATRatingsInput.Type.getType();
    }

    private long parseDateTimeFromMeta(@NonNull JSONObject jSONObject) {
        return jSONObject.optLong("dt", 0);
    }

    private List<FAQListMessageDM.FAQ> parseFAQListFromMeta(@NonNull JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("faqs");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                arrayList.add(new FAQListMessageDM.FAQ(jSONObject2.getString("faq_title"), jSONObject2.getString("faq_publish_id"), jSONObject2.getString("faq_language")));
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    private String parseFAQListSourceFromMeta(@NonNull JSONObject jSONObject) {
        try {
            return jSONObject.getString("faq_source");
        } catch (JSONException unused) {
            return "";
        }
    }

    private void parseFeedbackMessageData(MessageDM messageDM, JSONObject jSONObject) {
        messageDM.isFeedbackMessage = jSONObject.optBoolean("is_feedback_message", false);
    }

    private Boolean parseHasNextBotFromMeta(@NonNull JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean("has_next_bot", false));
    }

    private ImageAttachmentInfo parseImageAttachmentInfoFromMeta(@NonNull JSONObject jSONObject) {
        return new ImageAttachmentInfo(jSONObject);
    }

    private int parseInputKeyboardFromMeta(JSONObject jSONObject) {
        return getIntFromJson(jSONObject, "input_keyboard", 1);
    }

    private String parseInputLabelFromMeta(JSONObject jSONObject) {
        return getStringFromJson(jSONObject, "input_label", "");
    }

    private OptionInput.Type parseInputOptionTypeFromMeta(JSONObject jSONObject, int i) {
        return OptionInput.Type.getType(getStringFromJson(jSONObject, "option_type", ""), i);
    }

    private List<OptionInput.Option> parseInputOptionsFromMeta(@NonNull JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("input_options");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                arrayList.add(new OptionInput.Option(jSONObject2.getString("option_title"), jSONObject2.getString("option_data")));
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    private String parseInputPlaceholderFromMeta(JSONObject jSONObject) {
        return getStringFromJson(jSONObject, "input_placeholder", "");
    }

    private boolean parseInputRequiredFromMeta(JSONObject jSONObject) {
        return getBooleanFromJson(jSONObject, "input_required", false);
    }

    private String parseInputSkipLabelFromMeta(JSONObject jSONObject) {
        return getStringFromJson(jSONObject, "input_skip_label", "");
    }

    private List<String> parseIntentLabelFromMeta(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("intent_labels");
        return optJSONArray != null ? HSJSONUtils.convertJSONArrayToStringList(optJSONArray) : new ArrayList();
    }

    private boolean parseIsAnsweredFromMeta(@NonNull JSONObject jSONObject) {
        return jSONObject.optBoolean("is_answered", false);
    }

    private boolean parseIsMessageEmptyFromMeta(JSONObject jSONObject) {
        return getBooleanFromJson(jSONObject, "is_message_empty", false);
    }

    private boolean parseIsNewConvClickCSATFromMeta(JSONObject jSONObject) {
        return getBooleanFromJson(jSONObject, "new_conv_started_csat", false);
    }

    private boolean parseIsResponseSkippedFromMeta(JSONObject jSONObject) {
        return getBooleanFromJson(jSONObject, "is_response_skipped", false);
    }

    private boolean parseIsSuggestionsReadEventSent(JSONObject jSONObject) {
        return getBooleanFromJson(jSONObject, "is_suggestion_read_event_sent", false);
    }

    private int parseRatingValueFromMeta(JSONObject jSONObject) {
        return getIntFromJson(jSONObject, "rating_value", 1);
    }

    private String parseReferredMessageIdFromMeta(@NonNull JSONObject jSONObject) {
        return jSONObject.optString("referredMessageId", (String) null);
    }

    private MessageType parseReferredMessageTypeFromMeta(JSONObject jSONObject) {
        return MessageType.fromValue(getStringFromJson(jSONObject, "referred_message_type", ""));
    }

    private String parseSelectedOptionDataFromMeta(JSONObject jSONObject) {
        return getStringFromJson(jSONObject, "selected_option_data", JsonUtils.EMPTY_JSON);
    }

    private String parseSendFeedbackLabelFromMeta(JSONObject jSONObject) {
        return getStringFromJson(jSONObject, "input_send_feedback_label", "");
    }

    private boolean parseShowConvButtonFromMeta(JSONObject jSONObject) {
        return getBooleanFromJson(jSONObject, "show_new_conv_button", true);
    }

    private String parseStartNewConversationLabelFromMeta(JSONObject jSONObject) {
        return getStringFromJson(jSONObject, "input_start_conv_label", "");
    }

    private String parseSuggestionReadFAQPublishId(JSONObject jSONObject) {
        return getStringFromJson(jSONObject, "suggestion_read_faq_publish_id", "");
    }

    private String parseTimeZoneIdFromMeta(@NonNull JSONObject jSONObject) {
        return jSONObject.optString("timezone_id");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: com.helpshift.conversation.activeconversation.model.ActionCard} */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x010a, code lost:
        r11 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x010b, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0119, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r5.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x013b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x013c, code lost:
        com.helpshift.util.HSLogger.m3242e(TAG, "Error in read action card inside finally block", r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0119 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012a A[SYNTHETIC, Splitter:B:33:0x012a] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0137 A[SYNTHETIC, Splitter:B:40:0x0137] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.helpshift.conversation.activeconversation.model.ActionCard readActionCard(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "Error in read action card inside finally block"
            java.lang.String r1 = "Helpshift_ConverDB"
            r2 = 1
            java.lang.String[] r3 = new java.lang.String[r2]
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r4 = 0
            r3[r4] = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r4 = "SELECT "
            r11.append(r4)
            java.lang.String r4 = "action_cards._id"
            r11.append(r4)
            java.lang.String r5 = " AS ac_id, "
            r11.append(r5)
            java.lang.String r5 = "action_cards.title"
            r11.append(r5)
            java.lang.String r5 = ", "
            r11.append(r5)
            java.lang.String r6 = "action_cards.image_url"
            java.lang.String r7 = "action_cards.file_path"
            com.android.tools.p006r8.GeneratedOutlineSupport.outline34(r11, r6, r5, r7, r5)
            java.lang.String r6 = "action_cards.is_image_secure"
            java.lang.String r7 = "actions._id"
            java.lang.String r8 = " AS a_id, "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline34(r11, r6, r5, r7, r8)
            java.lang.String r6 = "actions.action_sha"
            java.lang.String r7 = "actions.action_title"
            com.android.tools.p006r8.GeneratedOutlineSupport.outline34(r11, r6, r5, r7, r5)
            java.lang.String r6 = "actions.action_type"
            java.lang.String r7 = "actions.action_data"
            java.lang.String r8 = " FROM "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline34(r11, r6, r5, r7, r8)
            java.lang.String r5 = "action_cards"
            java.lang.String r6 = " JOIN "
            java.lang.String r7 = "actions"
            java.lang.String r8 = " ON "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline34(r11, r5, r6, r7, r8)
            java.lang.String r5 = " = "
            java.lang.String r6 = "actions.action_card_id"
            java.lang.String r7 = " WHERE "
            com.android.tools.p006r8.GeneratedOutlineSupport.outline34(r11, r4, r5, r6, r7)
            java.lang.String r4 = "action_cards.message_id"
            java.lang.String r5 = " = ?  LIMIT 1"
            java.lang.String r11 = com.android.tools.p006r8.GeneratedOutlineSupport.outline18(r11, r4, r5)
            r4 = 0
            com.helpshift.db.conversation.ConversationDBHelper r5 = r10.dbHelper     // Catch:{ Exception -> 0x0121 }
            android.database.sqlite.SQLiteDatabase r5 = r5.getReadableDatabase()     // Catch:{ Exception -> 0x0121 }
            r5.beginTransaction()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            android.database.Cursor r11 = r5.rawQuery(r11, r3)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            boolean r3 = r11.moveToFirst()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            if (r3 == 0) goto L_0x010d
            java.lang.String r3 = "action_type"
            int r3 = r11.getColumnIndex(r3)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r3 = r11.getString(r3)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            com.helpshift.conversation.activeconversation.model.ActionType r3 = com.helpshift.conversation.activeconversation.model.ActionType.fromValue(r3)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r6 = "action_data"
            int r6 = r11.getColumnIndex(r6)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r6 = r11.getString(r6)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            org.json.JSONObject r6 = r10.jsonify(r6)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.util.Map r6 = com.helpshift.util.HSJSONUtils.toStringMap(r6)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            com.helpshift.conversation.activeconversation.model.Action r7 = new com.helpshift.conversation.activeconversation.model.Action     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r8 = "action_title"
            int r8 = r11.getColumnIndex(r8)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r8 = r11.getString(r8)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r9 = "action_sha"
            int r9 = r11.getColumnIndex(r9)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r9 = r11.getString(r9)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r7.<init>(r8, r9, r3, r6)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r3 = "a_id"
            int r3 = r11.getColumnIndex(r3)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            long r8 = r11.getLong(r3)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.Long r3 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r7.actionLocalId = r3     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            com.helpshift.conversation.activeconversation.model.ActionCard r3 = new com.helpshift.conversation.activeconversation.model.ActionCard     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r6 = "title"
            int r6 = r11.getColumnIndex(r6)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r6 = r11.getString(r6)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r8 = "image_url"
            int r8 = r11.getColumnIndex(r8)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r8 = r11.getString(r8)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r9 = "is_image_secure"
            int r9 = r11.getColumnIndex(r9)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            int r9 = r11.getInt(r9)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            if (r9 != r2) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r2 = 0
        L_0x00e9:
            r3.<init>(r6, r8, r2, r7)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r2 = "ac_id"
            int r2 = r11.getColumnIndex(r2)     // Catch:{ Exception -> 0x010a, all -> 0x0119 }
            long r6 = r11.getLong(r2)     // Catch:{ Exception -> 0x010a, all -> 0x0119 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x010a, all -> 0x0119 }
            r3.actionCardLocalId = r2     // Catch:{ Exception -> 0x010a, all -> 0x0119 }
            java.lang.String r2 = "file_path"
            int r2 = r11.getColumnIndex(r2)     // Catch:{ Exception -> 0x010a, all -> 0x0119 }
            java.lang.String r11 = r11.getString(r2)     // Catch:{ Exception -> 0x010a, all -> 0x0119 }
            r3.filePath = r11     // Catch:{ Exception -> 0x010a, all -> 0x0119 }
            r4 = r3
            goto L_0x010d
        L_0x010a:
            r11 = move-exception
            r4 = r3
            goto L_0x011c
        L_0x010d:
            r5.setTransactionSuccessful()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r5.endTransaction()     // Catch:{ Exception -> 0x0114 }
            goto L_0x0133
        L_0x0114:
            r11 = move-exception
            com.helpshift.util.HSLogger.m3242e(r1, r0, r11)
            goto L_0x0133
        L_0x0119:
            r11 = move-exception
            goto L_0x0135
        L_0x011b:
            r11 = move-exception
        L_0x011c:
            r2 = r4
            r4 = r5
            goto L_0x0123
        L_0x011f:
            r11 = move-exception
            goto L_0x0134
        L_0x0121:
            r11 = move-exception
            r2 = r4
        L_0x0123:
            java.lang.String r3 = "Error in read action card"
            com.helpshift.util.HSLogger.m3242e(r1, r3, r11)     // Catch:{ all -> 0x011f }
            if (r4 == 0) goto L_0x0132
            r4.endTransaction()     // Catch:{ Exception -> 0x012e }
            goto L_0x0132
        L_0x012e:
            r11 = move-exception
            com.helpshift.util.HSLogger.m3242e(r1, r0, r11)
        L_0x0132:
            r4 = r2
        L_0x0133:
            return r4
        L_0x0134:
            r5 = r4
        L_0x0135:
            if (r5 == 0) goto L_0x013f
            r5.endTransaction()     // Catch:{ Exception -> 0x013b }
            goto L_0x013f
        L_0x013b:
            r2 = move-exception
            com.helpshift.util.HSLogger.m3242e(r1, r0, r2)
        L_0x013f:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.readActionCard(java.lang.String):com.helpshift.conversation.activeconversation.model.ActionCard");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.helpshift.conversation.activeconversation.model.Conversation} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r11 != null) goto L_0x001e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0038 A[SYNTHETIC, Splitter:B:23:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.helpshift.conversation.activeconversation.model.Conversation readConversation(java.lang.String r11, java.lang.String[] r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            com.helpshift.db.conversation.ConversationDBHelper r1 = r10.dbHelper     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            android.database.sqlite.SQLiteDatabase r2 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            java.lang.String r3 = "issues"
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r11
            r6 = r12
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            boolean r12 = r11.moveToFirst()     // Catch:{ Exception -> 0x0022 }
            if (r12 == 0) goto L_0x001e
            com.helpshift.conversation.activeconversation.model.Conversation r0 = r10.cursorToReadableConversation(r11)     // Catch:{ Exception -> 0x0022 }
        L_0x001e:
            r11.close()     // Catch:{ all -> 0x003c }
            goto L_0x0032
        L_0x0022:
            r12 = move-exception
            goto L_0x0028
        L_0x0024:
            r12 = move-exception
            goto L_0x0036
        L_0x0026:
            r12 = move-exception
            r11 = r0
        L_0x0028:
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in read conversations with localId"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r12)     // Catch:{ all -> 0x0034 }
            if (r11 == 0) goto L_0x0032
            goto L_0x001e
        L_0x0032:
            monitor-exit(r10)
            return r0
        L_0x0034:
            r12 = move-exception
            r0 = r11
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ all -> 0x003c }
        L_0x003b:
            throw r12     // Catch:{ all -> 0x003c }
        L_0x003c:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x0040
        L_0x003f:
            throw r11
        L_0x0040:
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.readConversation(java.lang.String, java.lang.String[]):com.helpshift.conversation.activeconversation.model.Conversation");
    }

    private ContentValues readableConversationToContentValues(Conversation conversation) {
        int i;
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_local_id", Long.valueOf(conversation.userLocalId));
        contentValues.put("server_id", conversation.serverId);
        contentValues.put(ConversationTable.Columns.PRE_CONVERSATION_SERVER_ID, conversation.preConversationServerId);
        contentValues.put("publish_id", conversation.publishId);
        contentValues.put(ConversationTable.Columns.LOCAL_UUID, conversation.localUUID);
        contentValues.put("title", conversation.title);
        contentValues.put(ConversationTable.Columns.MESSAGE_CURSOR, conversation.messageCursor);
        contentValues.put(ConversationTable.Columns.IS_START_NEW_CONVERSATION_CLICKED, Integer.valueOf(conversation.isStartNewConversationClicked ? 1 : 0));
        contentValues.put("created_at", conversation.getCreatedAt());
        contentValues.put(ConversationTable.Columns.UPDATED_AT, conversation.updatedAt);
        contentValues.put("epoch_time_created_at", Long.valueOf(conversation.getEpochCreatedAtTime()));
        contentValues.put(ConversationTable.Columns.LAST_USER_ACTIVITY_TIME, Long.valueOf(conversation.lastUserActivityTime));
        contentValues.put(ConversationTable.Columns.ISSUE_TYPE, conversation.issueType);
        contentValues.put(ConversationTable.Columns.FULL_PRIVACY_ENABLED, Integer.valueOf(conversation.wasFullPrivacyEnabledAtCreation ? 1 : 0));
        IssueState issueState = conversation.state;
        if (issueState == null) {
            i = -1;
        } else {
            i = issueState.getValue();
        }
        contentValues.put("state", Integer.valueOf(i));
        contentValues.put("is_redacted", Integer.valueOf(conversation.isRedacted ? 1 : 0));
        contentValues.put("acid", conversation.acid);
        contentValues.put(ConversationTable.Columns.RESOLUTION_EXPIRY_AT, conversation.resolutionExpiryAt);
        contentValues.put(ConversationTable.Columns.CSAT_EXPIRY_AT, conversation.csatExpiryAt);
        contentValues.put(ConversationTable.Columns.FEEDBACK_BOT_ENABLED, Integer.valueOf(conversation.isFeedbackBotEnabled ? 1 : 0));
        contentValues.put(ConversationTable.Columns.CAN_START_NEW_CONVERSATION, Integer.valueOf(conversation.shouldAllowNewConversationCreation ? 1 : 0));
        try {
            contentValues.put("meta", getConversationMeta(conversation));
        } catch (JSONException e) {
            HSLogger.m3242e(TAG, "Error in generating meta string for conversation", e);
        }
        return contentValues;
    }

    private ContentValues readableMessageToContentValues(MessageDM messageDM) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("server_id", messageDM.serverId);
        contentValues.put(MessagesTable.Columns.CONVERSATION_ID, messageDM.conversationLocalId);
        contentValues.put("body", messageDM.body);
        contentValues.put("created_at", messageDM.getCreatedAt());
        contentValues.put("epoch_time_created_at", Long.valueOf(messageDM.getEpochCreatedAtTime()));
        contentValues.put("type", messageDM.messageType.getValue());
        contentValues.put(MessagesTable.Columns.DELIVERY_STATE, Integer.valueOf(messageDM.deliveryState));
        contentValues.put("is_redacted", Integer.valueOf(messageDM.isRedacted ? 1 : 0));
        Author author = messageDM.author;
        contentValues.put(MessagesTable.Columns.AUTHOR_NAME, author.authorName);
        contentValues.put(MessagesTable.Columns.AUTHOR_ID, author.authorId);
        Author.AuthorRole authorRole = author.role;
        contentValues.put(MessagesTable.Columns.AUTHOR_ROLE, authorRole != null ? authorRole.getValue() : null);
        contentValues.put(MessagesTable.Columns.AVATAR_IMAGE_LOCAL_PATH, author.localAvatarImagePath);
        try {
            contentValues.put("meta", getMessageMeta(messageDM));
        } catch (JSONException e) {
            HSLogger.m3242e(TAG, "Error in generating meta string for message", e);
        }
        return contentValues;
    }

    private void updateActionCard(SQLiteDatabase sQLiteDatabase, AdminActionCardMessageDM adminActionCardMessageDM) {
        ActionCard actionCard = adminActionCardMessageDM.actionCard;
        if (actionCard.actionCardLocalId == null) {
            insertActionCard(sQLiteDatabase, adminActionCardMessageDM);
            return;
        }
        try {
            sQLiteDatabase.update(ActionCardTable.TABLE_NAME, actionCardToContentValues(actionCard, adminActionCardMessageDM.serverId), UserDB.WHERE_LOCAL_ID_IS, new String[]{String.valueOf(adminActionCardMessageDM.actionCard.actionCardLocalId)});
            sQLiteDatabase.update("actions", actionToContentValues(adminActionCardMessageDM.actionCard.action, adminActionCardMessageDM.actionCard.actionCardLocalId.longValue()), UserDB.WHERE_LOCAL_ID_IS, new String[]{String.valueOf(adminActionCardMessageDM.actionCard.action.actionLocalId)});
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error in update action card", e);
        }
    }

    private void updateMessageInternal(SQLiteDatabase sQLiteDatabase, MessageDM messageDM, String str, String[] strArr) {
        sQLiteDatabase.update("messages", readableMessageToContentValues(messageDM), str, strArr);
        if (messageDM.messageType == MessageType.ADMIN_ACTION_CARD) {
            updateActionCard(sQLiteDatabase, (AdminActionCardMessageDM) messageDM);
        }
    }

    public synchronized void deleteConversationInboxData(long j) {
        try {
            this.dbHelper.getWritableDatabase().execSQL("delete from conversation_inbox where user_local_id = ?", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error in delete conversationInboxData with UserLocalId", e);
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        r1 = TAG;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r6 = "Exception in ending transaction deleteConversationWithLocalId : " + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0069, code lost:
        if (r3 != null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r3.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        com.helpshift.util.HSLogger.m3242e(TAG, "Exception in ending transaction deleteConversationWithLocalId : " + r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0086, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x0026, B:17:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void deleteConversationWithLocalId(long r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "_id = ?"
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ all -> 0x0087 }
            r2 = 0
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0087 }
            r1[r2] = r3     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "conversation_id = ?"
            r3 = 0
            com.helpshift.db.conversation.ConversationDBHelper r4 = r5.dbHelper     // Catch:{ Exception -> 0x0044 }
            android.database.sqlite.SQLiteDatabase r3 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0044 }
            r3.beginTransaction()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = "issues"
            r3.delete(r4, r0, r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = "messages"
            r3.delete(r0, r2, r1)     // Catch:{ Exception -> 0x0044 }
            r3.setTransactionSuccessful()     // Catch:{ Exception -> 0x0044 }
            r3.endTransaction()     // Catch:{ Exception -> 0x002a }
            goto L_0x0067
        L_0x002a:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r2.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = "Exception in ending transaction deleteConversationWithLocalId : "
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            r2.append(r6)     // Catch:{ all -> 0x0087 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0087 }
        L_0x003e:
            com.helpshift.util.HSLogger.m3242e(r1, r6, r0)     // Catch:{ all -> 0x0087 }
            goto L_0x0067
        L_0x0042:
            r0 = move-exception
            goto L_0x0069
        L_0x0044:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in delete conversation with localId"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x0042 }
            if (r3 == 0) goto L_0x0067
            r3.endTransaction()     // Catch:{ Exception -> 0x0052 }
            goto L_0x0067
        L_0x0052:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r2.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = "Exception in ending transaction deleteConversationWithLocalId : "
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            r2.append(r6)     // Catch:{ all -> 0x0087 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0087 }
            goto L_0x003e
        L_0x0067:
            monitor-exit(r5)
            return
        L_0x0069:
            if (r3 == 0) goto L_0x0086
            r3.endTransaction()     // Catch:{ Exception -> 0x006f }
            goto L_0x0086
        L_0x006f:
            r1 = move-exception
            java.lang.String r2 = "Helpshift_ConverDB"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r3.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r4 = "Exception in ending transaction deleteConversationWithLocalId : "
            r3.append(r4)     // Catch:{ all -> 0x0087 }
            r3.append(r6)     // Catch:{ all -> 0x0087 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0087 }
            com.helpshift.util.HSLogger.m3242e(r2, r6, r1)     // Catch:{ all -> 0x0087 }
        L_0x0086:
            throw r0     // Catch:{ all -> 0x0087 }
        L_0x0087:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x008b
        L_0x008a:
            throw r6
        L_0x008b:
            goto L_0x008a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.deleteConversationWithLocalId(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0082, code lost:
        if (r2 == null) goto L_0x0085;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void deleteConversations(long r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "issues._id"
            java.lang.String r1 = "issues.user_local_id"
            java.lang.String r2 = "messages.conversation_id"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r3.<init>()     // Catch:{ all -> 0x008d }
            java.lang.String r4 = "select "
            r3.append(r4)     // Catch:{ all -> 0x008d }
            r3.append(r0)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = " from  "
            r3.append(r0)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = "issues"
            r3.append(r0)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = "  where "
            r3.append(r0)     // Catch:{ all -> 0x008d }
            r3.append(r1)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = " = ?"
            r3.append(r0)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r1.<init>()     // Catch:{ all -> 0x008d }
            java.lang.String r3 = "delete from messages where "
            r1.append(r3)     // Catch:{ all -> 0x008d }
            r1.append(r2)     // Catch:{ all -> 0x008d }
            java.lang.String r2 = " IN  ( "
            r1.append(r2)     // Catch:{ all -> 0x008d }
            r1.append(r0)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = " )"
            r1.append(r0)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x008d }
            java.lang.String r1 = "delete from issues where user_local_id = ?"
            r2 = 0
            com.helpshift.db.conversation.ConversationDBHelper r3 = r7.dbHelper     // Catch:{ Exception -> 0x007a }
            android.database.sqlite.SQLiteDatabase r2 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x007a }
            r2.beginTransaction()     // Catch:{ Exception -> 0x007a }
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ Exception -> 0x007a }
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x007a }
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x007a }
            r2.execSQL(r0, r4)     // Catch:{ Exception -> 0x007a }
            java.lang.String[] r0 = new java.lang.String[r3]     // Catch:{ Exception -> 0x007a }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x007a }
            r0[r6] = r8     // Catch:{ Exception -> 0x007a }
            r2.execSQL(r1, r0)     // Catch:{ Exception -> 0x007a }
            r2.setTransactionSuccessful()     // Catch:{ Exception -> 0x007a }
        L_0x0074:
            r2.endTransaction()     // Catch:{ all -> 0x008d }
            goto L_0x0085
        L_0x0078:
            r8 = move-exception
            goto L_0x0087
        L_0x007a:
            r8 = move-exception
            java.lang.String r9 = "Helpshift_ConverDB"
            java.lang.String r0 = "Error in delete conversations with UserLocalId"
            com.helpshift.util.HSLogger.m3242e(r9, r0, r8)     // Catch:{ all -> 0x0078 }
            if (r2 == 0) goto L_0x0085
            goto L_0x0074
        L_0x0085:
            monitor-exit(r7)
            return
        L_0x0087:
            if (r2 == 0) goto L_0x008c
            r2.endTransaction()     // Catch:{ all -> 0x008d }
        L_0x008c:
            throw r8     // Catch:{ all -> 0x008d }
        L_0x008d:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x0091
        L_0x0090:
            throw r8
        L_0x0091:
            goto L_0x0090
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.deleteConversations(long):void");
    }

    public synchronized boolean deleteMessagesForConversation(long j) {
        try {
            this.dbHelper.getWritableDatabase().delete("messages", "conversation_id= ? ", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error deleting messages for : " + j, e);
            return false;
        }
        return true;
    }

    public synchronized void dropAndCreateDatabase() {
        this.dbHelper.dropAndCreateAllTables(this.dbHelper.getWritableDatabase());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.helpshift.support.Faq} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (r11 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0053, code lost:
        return null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e A[SYNTHETIC, Splitter:B:27:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.support.Faq getAdminFAQSuggestion(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = com.helpshift.util.StringUtils.isEmpty(r11)     // Catch:{ all -> 0x0054 }
            r1 = 0
            if (r0 != 0) goto L_0x0052
            boolean r0 = com.helpshift.util.StringUtils.isEmpty(r12)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x000f
            goto L_0x0052
        L_0x000f:
            com.helpshift.db.conversation.ConversationDBHelper r0 = r10.dbHelper     // Catch:{ Exception -> 0x003c, all -> 0x003a }
            android.database.sqlite.SQLiteDatabase r2 = r0.getReadableDatabase()     // Catch:{ Exception -> 0x003c, all -> 0x003a }
            java.lang.String r3 = "faq_suggestions"
            r4 = 0
            java.lang.String r5 = "publish_id = ? AND language = ?"
            r0 = 2
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ Exception -> 0x003c, all -> 0x003a }
            r0 = 0
            r6[r0] = r11     // Catch:{ Exception -> 0x003c, all -> 0x003a }
            r11 = 1
            r6[r11] = r12     // Catch:{ Exception -> 0x003c, all -> 0x003a }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x003c, all -> 0x003a }
            boolean r12 = r11.moveToFirst()     // Catch:{ Exception -> 0x0038 }
            if (r12 == 0) goto L_0x0034
            com.helpshift.support.Faq r1 = r10.cursorToFaq(r11)     // Catch:{ Exception -> 0x0038 }
        L_0x0034:
            r11.close()     // Catch:{ all -> 0x0054 }
            goto L_0x0048
        L_0x0038:
            r12 = move-exception
            goto L_0x003e
        L_0x003a:
            r12 = move-exception
            goto L_0x004c
        L_0x003c:
            r12 = move-exception
            r11 = r1
        L_0x003e:
            java.lang.String r0 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in getAdminFAQSuggestion"
            com.helpshift.util.HSLogger.m3242e(r0, r2, r12)     // Catch:{ all -> 0x004a }
            if (r11 == 0) goto L_0x0048
            goto L_0x0034
        L_0x0048:
            monitor-exit(r10)
            return r1
        L_0x004a:
            r12 = move-exception
            r1 = r11
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ all -> 0x0054 }
        L_0x0051:
            throw r12     // Catch:{ all -> 0x0054 }
        L_0x0052:
            monitor-exit(r10)
            return r1
        L_0x0054:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x0058
        L_0x0057:
            throw r11
        L_0x0058:
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.getAdminFAQSuggestion(java.lang.String, java.lang.String):com.helpshift.support.Faq");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0111, code lost:
        if (r2 != 0) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0117, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0121, code lost:
        if (r2 == 0) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0124, code lost:
        if (r2 != 0) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0129, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x014a, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0154, code lost:
        if (r14 == null) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x015a, code lost:
        if (r14 != null) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015c, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015f, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0160, code lost:
        if (r14 == null) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0172, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x017c, code lost:
        if (r14 == null) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0182, code lost:
        if (r14 != null) goto L_0x0184;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0184, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0187, code lost:
        throw r13;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:35:0x011e, B:61:0x0151, B:81:0x0179] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0140 A[SYNTHETIC, Splitter:B:54:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0168 A[SYNTHETIC, Splitter:B:74:0x0168] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x018a A[Catch:{ all -> 0x0172, all -> 0x014a, all -> 0x0117 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0113=Splitter:B:30:0x0113, B:64:0x0156=Splitter:B:64:0x0156, B:84:0x017e=Splitter:B:84:0x017e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.Map<java.lang.Long, java.lang.Integer> getMessagesCountForConversations(java.util.List<java.lang.Long> r13, java.lang.String[] r14) {
        /*
            r12 = this;
            monitor-enter(r12)
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x018c }
            r0.<init>()     // Catch:{ all -> 0x018c }
            java.util.Iterator r1 = r13.iterator()     // Catch:{ all -> 0x018c }
        L_0x000a:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x018c }
            if (r2 == 0) goto L_0x001f
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x018c }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x018c }
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x018c }
            r0.put(r2, r3)     // Catch:{ all -> 0x018c }
            goto L_0x000a
        L_0x001f:
            r1 = 900(0x384, float:1.261E-42)
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0135, all -> 0x0132 }
            r3.<init>(r13)     // Catch:{ Exception -> 0x0135, all -> 0x0132 }
            java.util.List r13 = com.helpshift.util.DatabaseUtils.createBatches(r1, r3)     // Catch:{ Exception -> 0x0135, all -> 0x0132 }
            com.helpshift.db.conversation.ConversationDBHelper r1 = r12.dbHelper     // Catch:{ Exception -> 0x0135, all -> 0x0132 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x0135, all -> 0x0132 }
            r1.beginTransaction()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
        L_0x0038:
            boolean r3 = r13.hasNext()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            if (r3 == 0) goto L_0x0105
            java.lang.Object r3 = r13.next()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.util.List r3 = (java.util.List) r3     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            int r4 = r3.size()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r4 = com.helpshift.util.DatabaseUtils.makePlaceholders(r4)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r5.<init>()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r6.<init>()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r7 = "conversation_id IN ("
            r6.append(r7)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r6.append(r4)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r4 = ")"
            r6.append(r4)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r5.append(r4)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r4.<init>()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
        L_0x0073:
            boolean r6 = r3.hasNext()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            if (r6 == 0) goto L_0x0087
            java.lang.Object r6 = r3.next()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r4.add(r6)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            goto L_0x0073
        L_0x0087:
            if (r14 == 0) goto L_0x00b3
            int r3 = r14.length     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r3 = com.helpshift.util.DatabaseUtils.makePlaceholders(r3)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r6.<init>()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r7 = "type IN ("
            r6.append(r7)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r6.append(r3)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r3 = ")"
            r6.append(r3)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r3 = r6.toString()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r6 = " AND "
            r5.append(r6)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r5.append(r3)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.util.List r3 = java.util.Arrays.asList(r14)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r4.addAll(r3)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
        L_0x00b3:
            int r3 = r4.size()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r4.toArray(r7)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r4 = "messages"
            java.lang.String r3 = "COUNT(*) AS COUNT"
            java.lang.String r6 = "conversation_id"
            java.lang.String[] r6 = new java.lang.String[]{r3, r6}     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r8 = r5.toString()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r9 = "conversation_id"
            r10 = 0
            r11 = 0
            r3 = r1
            r5 = r6
            r6 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            if (r3 == 0) goto L_0x0038
        L_0x00de:
            java.lang.String r3 = "conversation_id"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            long r3 = r2.getLong(r3)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r5 = "COUNT"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            int r5 = r2.getInt(r5)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            if (r3 != 0) goto L_0x00de
            goto L_0x0038
        L_0x0105:
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            boolean r13 = r1.inTransaction()     // Catch:{ Exception -> 0x0119 }
            if (r13 == 0) goto L_0x0111
            r1.endTransaction()     // Catch:{ Exception -> 0x0119 }
        L_0x0111:
            if (r2 == 0) goto L_0x0163
        L_0x0113:
            r2.close()     // Catch:{ all -> 0x018c }
            goto L_0x0163
        L_0x0117:
            r13 = move-exception
            goto L_0x0124
        L_0x0119:
            r13 = move-exception
            java.lang.String r14 = "Helpshift_ConverDB"
            java.lang.String r1 = "Error in get messages count inside finally block, "
            com.helpshift.util.HSLogger.m3242e(r14, r1, r13)     // Catch:{ all -> 0x0117 }
            if (r2 == 0) goto L_0x0163
            goto L_0x0113
        L_0x0124:
            if (r2 == 0) goto L_0x0129
            r2.close()     // Catch:{ all -> 0x018c }
        L_0x0129:
            throw r13     // Catch:{ all -> 0x018c }
        L_0x012a:
            r13 = move-exception
            r14 = r2
            r2 = r1
            goto L_0x0166
        L_0x012e:
            r13 = move-exception
            r14 = r2
            r2 = r1
            goto L_0x0137
        L_0x0132:
            r13 = move-exception
            r14 = r2
            goto L_0x0166
        L_0x0135:
            r13 = move-exception
            r14 = r2
        L_0x0137:
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r3 = "Error in get messages count"
            com.helpshift.util.HSLogger.m3242e(r1, r3, r13)     // Catch:{ all -> 0x0165 }
            if (r2 == 0) goto L_0x0160
            boolean r13 = r2.inTransaction()     // Catch:{ Exception -> 0x014c }
            if (r13 == 0) goto L_0x0160
            r2.endTransaction()     // Catch:{ Exception -> 0x014c }
            goto L_0x0160
        L_0x014a:
            r13 = move-exception
            goto L_0x015a
        L_0x014c:
            r13 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in get messages count inside finally block, "
            com.helpshift.util.HSLogger.m3242e(r1, r2, r13)     // Catch:{ all -> 0x014a }
            if (r14 == 0) goto L_0x0163
        L_0x0156:
            r14.close()     // Catch:{ all -> 0x018c }
            goto L_0x0163
        L_0x015a:
            if (r14 == 0) goto L_0x015f
            r14.close()     // Catch:{ all -> 0x018c }
        L_0x015f:
            throw r13     // Catch:{ all -> 0x018c }
        L_0x0160:
            if (r14 == 0) goto L_0x0163
            goto L_0x0156
        L_0x0163:
            monitor-exit(r12)
            return r0
        L_0x0165:
            r13 = move-exception
        L_0x0166:
            if (r2 == 0) goto L_0x0188
            boolean r0 = r2.inTransaction()     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x0188
            r2.endTransaction()     // Catch:{ Exception -> 0x0174 }
            goto L_0x0188
        L_0x0172:
            r13 = move-exception
            goto L_0x0182
        L_0x0174:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in get messages count inside finally block, "
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x0172 }
            if (r14 == 0) goto L_0x018b
        L_0x017e:
            r14.close()     // Catch:{ all -> 0x018c }
            goto L_0x018b
        L_0x0182:
            if (r14 == 0) goto L_0x0187
            r14.close()     // Catch:{ all -> 0x018c }
        L_0x0187:
            throw r13     // Catch:{ all -> 0x018c }
        L_0x0188:
            if (r14 == 0) goto L_0x018b
            goto L_0x017e
        L_0x018b:
            throw r13     // Catch:{ all -> 0x018c }
        L_0x018c:
            r13 = move-exception
            monitor-exit(r12)
            goto L_0x0190
        L_0x018f:
            throw r13
        L_0x0190:
            goto L_0x018f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.getMessagesCountForConversations(java.util.List, java.lang.String[]):java.util.Map");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r12 != null) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0053 A[SYNTHETIC, Splitter:B:27:0x0053] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Long getOldestConversationEpochCreatedAtTime(long r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r3 = "user_local_id = ?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ all -> 0x0057 }
            r0 = 0
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0057 }
            r4[r0] = r11     // Catch:{ all -> 0x0057 }
            r11 = 0
            com.helpshift.db.conversation.ConversationDBHelper r12 = r10.dbHelper     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            android.database.sqlite.SQLiteDatabase r0 = r12.getReadableDatabase()     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            java.lang.String r1 = "issues"
            java.lang.String r12 = "epoch_time_created_at"
            java.lang.String[] r2 = new java.lang.String[]{r12}     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            r5 = 0
            r6 = 0
            java.lang.String r7 = "epoch_time_created_at ASC"
            java.lang.String r8 = "1"
            android.database.Cursor r12 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            boolean r0 = r12.moveToFirst()     // Catch:{ Exception -> 0x003b }
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = "epoch_time_created_at"
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            java.lang.Object r0 = com.helpshift.util.DatabaseUtils.parseColumnSafe(r12, r0, r1)     // Catch:{ Exception -> 0x003b }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ Exception -> 0x003b }
            r11 = r0
        L_0x0037:
            r12.close()     // Catch:{ all -> 0x0057 }
            goto L_0x004e
        L_0x003b:
            r0 = move-exception
            goto L_0x0044
        L_0x003d:
            r12 = move-exception
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x0051
        L_0x0042:
            r0 = move-exception
            r12 = r11
        L_0x0044:
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in getting latest conversation created_at time"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x0050 }
            if (r12 == 0) goto L_0x004e
            goto L_0x0037
        L_0x004e:
            monitor-exit(r10)
            return r11
        L_0x0050:
            r11 = move-exception
        L_0x0051:
            if (r12 == 0) goto L_0x0056
            r12.close()     // Catch:{ all -> 0x0057 }
        L_0x0056:
            throw r11     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x005b
        L_0x005a:
            throw r11
        L_0x005b:
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.getOldestConversationEpochCreatedAtTime(long):java.lang.Long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0096, code lost:
        if (r11 != null) goto L_0x0082;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e A[SYNTHETIC, Splitter:B:26:0x009e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String getOldestMessageCursor(long r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "message_create_at"
            java.lang.String r1 = "issues.user_local_id"
            java.lang.String r2 = "issues._id"
            java.lang.String r3 = "messages.conversation_id"
            java.lang.String r4 = "messages.created_at"
            java.lang.String r5 = "messages.epoch_time_created_at"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r6.<init>()     // Catch:{ all -> 0x00a2 }
            java.lang.String r7 = "SELECT "
            r6.append(r7)     // Catch:{ all -> 0x00a2 }
            r6.append(r4)     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = " AS "
            r6.append(r4)     // Catch:{ all -> 0x00a2 }
            r6.append(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = " FROM "
            r6.append(r4)     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = "issues"
            r6.append(r4)     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = " INNER JOIN "
            r6.append(r4)     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = "messages"
            r6.append(r4)     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = " ON "
            r6.append(r4)     // Catch:{ all -> 0x00a2 }
            r6.append(r2)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = " = "
            r6.append(r2)     // Catch:{ all -> 0x00a2 }
            r6.append(r3)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = " WHERE "
            r6.append(r2)     // Catch:{ all -> 0x00a2 }
            r6.append(r1)     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = " = ? ORDER BY "
            r6.append(r1)     // Catch:{ all -> 0x00a2 }
            r6.append(r5)     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = "  ASC LIMIT 1"
            r6.append(r1)     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x00a2 }
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ all -> 0x00a2 }
            r3 = 0
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x00a2 }
            r2[r3] = r10     // Catch:{ all -> 0x00a2 }
            r10 = 0
            com.helpshift.db.conversation.ConversationDBHelper r11 = r9.dbHelper     // Catch:{ Exception -> 0x008d, all -> 0x0088 }
            android.database.sqlite.SQLiteDatabase r11 = r11.getReadableDatabase()     // Catch:{ Exception -> 0x008d, all -> 0x0088 }
            android.database.Cursor r11 = r11.rawQuery(r1, r2)     // Catch:{ Exception -> 0x008d, all -> 0x0088 }
            boolean r1 = r11.moveToFirst()     // Catch:{ Exception -> 0x0086 }
            if (r1 == 0) goto L_0x0082
            int r0 = r11.getColumnIndex(r0)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r10 = r11.getString(r0)     // Catch:{ Exception -> 0x0086 }
        L_0x0082:
            r11.close()     // Catch:{ all -> 0x00a2 }
            goto L_0x0099
        L_0x0086:
            r0 = move-exception
            goto L_0x008f
        L_0x0088:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x009c
        L_0x008d:
            r0 = move-exception
            r11 = r10
        L_0x008f:
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in read messages"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x009b }
            if (r11 == 0) goto L_0x0099
            goto L_0x0082
        L_0x0099:
            monitor-exit(r9)
            return r10
        L_0x009b:
            r10 = move-exception
        L_0x009c:
            if (r11 == 0) goto L_0x00a1
            r11.close()     // Catch:{ all -> 0x00a2 }
        L_0x00a1:
            throw r10     // Catch:{ all -> 0x00a2 }
        L_0x00a2:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x00a6
        L_0x00a5:
            throw r10
        L_0x00a6:
            goto L_0x00a5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.getOldestMessageCursor(long):java.lang.String");
    }

    public synchronized long insertConversation(Conversation conversation) {
        long j;
        j = -1;
        try {
            j = this.dbHelper.getWritableDatabase().insert(ConversationTable.TABLE_NAME, (String) null, readableConversationToContentValues(conversation));
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error in insert conversation", e);
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0087 A[SYNTHETIC, Splitter:B:40:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0097 A[SYNTHETIC, Splitter:B:49:0x0097] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.common.dao.DAOResult<java.util.List<java.lang.Long>> insertConversations(java.util.List<com.helpshift.conversation.activeconversation.model.Conversation> r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            int r0 = r7.size()     // Catch:{ all -> 0x00a4 }
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0010
            com.helpshift.common.dao.DAOResult r7 = new com.helpshift.common.dao.DAOResult     // Catch:{ all -> 0x00a4 }
            r7.<init>(r1, r2)     // Catch:{ all -> 0x00a4 }
            monitor-exit(r6)
            return r7
        L_0x0010:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00a4 }
            r0.<init>()     // Catch:{ all -> 0x00a4 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00a4 }
        L_0x0019:
            boolean r3 = r7.hasNext()     // Catch:{ all -> 0x00a4 }
            if (r3 == 0) goto L_0x002d
            java.lang.Object r3 = r7.next()     // Catch:{ all -> 0x00a4 }
            com.helpshift.conversation.activeconversation.model.Conversation r3 = (com.helpshift.conversation.activeconversation.model.Conversation) r3     // Catch:{ all -> 0x00a4 }
            android.content.ContentValues r3 = r6.readableConversationToContentValues(r3)     // Catch:{ all -> 0x00a4 }
            r0.add(r3)     // Catch:{ all -> 0x00a4 }
            goto L_0x0019
        L_0x002d:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00a4 }
            r7.<init>()     // Catch:{ all -> 0x00a4 }
            com.helpshift.db.conversation.ConversationDBHelper r3 = r6.dbHelper     // Catch:{ Exception -> 0x0077 }
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x0077 }
            r3.beginTransaction()     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0072, all -> 0x006f }
        L_0x003f:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            if (r4 == 0) goto L_0x0059
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            android.content.ContentValues r4 = (android.content.ContentValues) r4     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            java.lang.String r5 = "issues"
            long r4 = r3.insert(r5, r2, r4)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            r7.add(r4)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            goto L_0x003f
        L_0x0059:
            r3.setTransactionSuccessful()     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            r3.endTransaction()     // Catch:{ Exception -> 0x0060 }
            goto L_0x0068
        L_0x0060:
            r0 = move-exception
            java.lang.String r2 = "Helpshift_ConverDB"
            java.lang.String r3 = "Error in insert conversations inside finally block"
            com.helpshift.util.HSLogger.m3242e(r2, r3, r0)     // Catch:{ all -> 0x00a4 }
        L_0x0068:
            com.helpshift.common.dao.DAOResult r0 = new com.helpshift.common.dao.DAOResult     // Catch:{ all -> 0x00a4 }
            r0.<init>(r1, r7)     // Catch:{ all -> 0x00a4 }
            monitor-exit(r6)
            return r0
        L_0x006f:
            r7 = move-exception
            r2 = r3
            goto L_0x0095
        L_0x0072:
            r0 = move-exception
            r2 = r3
            goto L_0x0078
        L_0x0075:
            r7 = move-exception
            goto L_0x0095
        L_0x0077:
            r0 = move-exception
        L_0x0078:
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r3 = "Error in insert conversations"
            com.helpshift.util.HSLogger.m3242e(r1, r3, r0)     // Catch:{ all -> 0x0075 }
            com.helpshift.common.dao.DAOResult r0 = new com.helpshift.common.dao.DAOResult     // Catch:{ all -> 0x0075 }
            r1 = 0
            r0.<init>(r1, r7)     // Catch:{ all -> 0x0075 }
            if (r2 == 0) goto L_0x0093
            r2.endTransaction()     // Catch:{ Exception -> 0x008b }
            goto L_0x0093
        L_0x008b:
            r7 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in insert conversations inside finally block"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r7)     // Catch:{ all -> 0x00a4 }
        L_0x0093:
            monitor-exit(r6)
            return r0
        L_0x0095:
            if (r2 == 0) goto L_0x00a3
            r2.endTransaction()     // Catch:{ Exception -> 0x009b }
            goto L_0x00a3
        L_0x009b:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in insert conversations inside finally block"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x00a4 }
        L_0x00a3:
            throw r7     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r7 = move-exception
            monitor-exit(r6)
            goto L_0x00a8
        L_0x00a7:
            throw r7
        L_0x00a8:
            goto L_0x00a7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.insertConversations(java.util.List):com.helpshift.common.dao.DAOResult");
    }

    public synchronized long insertMessage(MessageDM messageDM) {
        long j;
        String str;
        j = -1;
        ContentValues readableMessageToContentValues = readableMessageToContentValues(messageDM);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.dbHelper.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            j = insertMessageInternal(sQLiteDatabase, messageDM, readableMessageToContentValues);
            sQLiteDatabase.setTransactionSuccessful();
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception e) {
                e = e;
                String str2 = TAG;
                String str3 = "Error in insert message inside finally block";
            }
        } catch (Exception e2) {
            try {
                HSLogger.m3242e(TAG, "Error in insert message", e2);
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        str = "Error in insert message inside finally block";
                        HSLogger.m3242e(TAG, str, e3);
                    }
                }
            }
        }
        return j;
        return j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0064, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        com.helpshift.util.HSLogger.m3242e(TAG, "Error in insert messages inside finally block", r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0092, code lost:
        if (r1 != null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0098, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        com.helpshift.util.HSLogger.m3242e(TAG, "Error in insert messages inside finally block", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a0, code lost:
        throw r10;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:19:0x0060, B:31:0x007a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.common.dao.DAOResult<java.util.List<java.lang.Long>> insertMessages(java.util.List<com.helpshift.conversation.activeconversation.message.MessageDM> r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r10.isEmpty()     // Catch:{ all -> 0x00a1 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0010
            com.helpshift.common.dao.DAOResult r10 = new com.helpshift.common.dao.DAOResult     // Catch:{ all -> 0x00a1 }
            r10.<init>(r2, r1)     // Catch:{ all -> 0x00a1 }
            monitor-exit(r9)
            return r10
        L_0x0010:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00a1 }
            r0.<init>()     // Catch:{ all -> 0x00a1 }
            java.util.Iterator r3 = r10.iterator()     // Catch:{ all -> 0x00a1 }
        L_0x0019:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00a1 }
            if (r4 == 0) goto L_0x002d
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00a1 }
            com.helpshift.conversation.activeconversation.message.MessageDM r4 = (com.helpshift.conversation.activeconversation.message.MessageDM) r4     // Catch:{ all -> 0x00a1 }
            android.content.ContentValues r4 = r9.readableMessageToContentValues(r4)     // Catch:{ all -> 0x00a1 }
            r0.add(r4)     // Catch:{ all -> 0x00a1 }
            goto L_0x0019
        L_0x002d:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00a1 }
            r3.<init>()     // Catch:{ all -> 0x00a1 }
            r4 = 0
            com.helpshift.db.conversation.ConversationDBHelper r5 = r9.dbHelper     // Catch:{ Exception -> 0x0075 }
            android.database.sqlite.SQLiteDatabase r1 = r5.getWritableDatabase()     // Catch:{ Exception -> 0x0075 }
            r1.beginTransaction()     // Catch:{ Exception -> 0x0075 }
            int r5 = r10.size()     // Catch:{ Exception -> 0x0075 }
            r6 = 0
        L_0x0041:
            if (r6 >= r5) goto L_0x005d
            java.lang.Object r7 = r10.get(r6)     // Catch:{ Exception -> 0x0075 }
            com.helpshift.conversation.activeconversation.message.MessageDM r7 = (com.helpshift.conversation.activeconversation.message.MessageDM) r7     // Catch:{ Exception -> 0x0075 }
            java.lang.Object r8 = r0.get(r6)     // Catch:{ Exception -> 0x0075 }
            android.content.ContentValues r8 = (android.content.ContentValues) r8     // Catch:{ Exception -> 0x0075 }
            long r7 = r9.insertMessageInternal(r1, r7, r8)     // Catch:{ Exception -> 0x0075 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x0075 }
            r3.add(r7)     // Catch:{ Exception -> 0x0075 }
            int r6 = r6 + 1
            goto L_0x0041
        L_0x005d:
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x0075 }
            r1.endTransaction()     // Catch:{ Exception -> 0x0064 }
            goto L_0x006c
        L_0x0064:
            r10 = move-exception
            java.lang.String r0 = "Helpshift_ConverDB"
            java.lang.String r1 = "Error in insert messages inside finally block"
            com.helpshift.util.HSLogger.m3242e(r0, r1, r10)     // Catch:{ all -> 0x00a1 }
        L_0x006c:
            com.helpshift.common.dao.DAOResult r10 = new com.helpshift.common.dao.DAOResult     // Catch:{ all -> 0x00a1 }
            r10.<init>(r2, r3)     // Catch:{ all -> 0x00a1 }
            monitor-exit(r9)
            return r10
        L_0x0073:
            r10 = move-exception
            goto L_0x0092
        L_0x0075:
            r10 = move-exception
            java.lang.String r0 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in insert messages"
            com.helpshift.util.HSLogger.m3242e(r0, r2, r10)     // Catch:{ all -> 0x0073 }
            com.helpshift.common.dao.DAOResult r10 = new com.helpshift.common.dao.DAOResult     // Catch:{ all -> 0x0073 }
            r10.<init>(r4, r3)     // Catch:{ all -> 0x0073 }
            if (r1 == 0) goto L_0x0090
            r1.endTransaction()     // Catch:{ Exception -> 0x0088 }
            goto L_0x0090
        L_0x0088:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in insert messages inside finally block"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x00a1 }
        L_0x0090:
            monitor-exit(r9)
            return r10
        L_0x0092:
            if (r1 == 0) goto L_0x00a0
            r1.endTransaction()     // Catch:{ Exception -> 0x0098 }
            goto L_0x00a0
        L_0x0098:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in insert messages inside finally block"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x00a1 }
        L_0x00a0:
            throw r10     // Catch:{ all -> 0x00a1 }
        L_0x00a1:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x00a5
        L_0x00a4:
            throw r10
        L_0x00a5:
            goto L_0x00a4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.insertMessages(java.util.List):com.helpshift.common.dao.DAOResult");
    }

    public synchronized void insertOrUpdateAdminFAQSuggestion(Faq faq) {
        ContentValues faqToContentValues = faqToContentValues(faq);
        String[] strArr = {faq.publish_id, faq.language};
        try {
            SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
            if (!exists(writableDatabase, FaqsTable.TABLE_NAME, "publish_id = ? AND language = ?", strArr)) {
                writableDatabase.insert(FaqsTable.TABLE_NAME, (String) null, faqToContentValues);
            } else {
                writableDatabase.update(FaqsTable.TABLE_NAME, faqToContentValues, "publish_id = ? AND language = ?", strArr);
            }
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error in insertOrUpdateAdminFAQSuggestion", e);
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (r11 != null) goto L_0x0028;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0044 A[SYNTHETIC, Splitter:B:26:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.conversation.dto.dao.ConversationInboxRecord readConversationInboxRecord(long r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r3 = "user_local_id = ?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ all -> 0x0048 }
            r0 = 0
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0048 }
            r4[r0] = r10     // Catch:{ all -> 0x0048 }
            r10 = 0
            com.helpshift.db.conversation.ConversationDBHelper r11 = r9.dbHelper     // Catch:{ Exception -> 0x0033, all -> 0x002e }
            android.database.sqlite.SQLiteDatabase r0 = r11.getReadableDatabase()     // Catch:{ Exception -> 0x0033, all -> 0x002e }
            java.lang.String r1 = "conversation_inbox"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0033, all -> 0x002e }
            boolean r0 = r11.moveToFirst()     // Catch:{ Exception -> 0x002c }
            if (r0 == 0) goto L_0x0028
            com.helpshift.conversation.dto.dao.ConversationInboxRecord r10 = r9.cursorToConversationInboxRecord(r11)     // Catch:{ Exception -> 0x002c }
        L_0x0028:
            r11.close()     // Catch:{ all -> 0x0048 }
            goto L_0x003f
        L_0x002c:
            r0 = move-exception
            goto L_0x0035
        L_0x002e:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x0042
        L_0x0033:
            r0 = move-exception
            r11 = r10
        L_0x0035:
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in read conversation inbox record"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x0041 }
            if (r11 == 0) goto L_0x003f
            goto L_0x0028
        L_0x003f:
            monitor-exit(r9)
            return r10
        L_0x0041:
            r10 = move-exception
        L_0x0042:
            if (r11 == 0) goto L_0x0047
            r11.close()     // Catch:{ all -> 0x0048 }
        L_0x0047:
            throw r10     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x004c
        L_0x004b:
            throw r10
        L_0x004c:
            goto L_0x004b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.readConversationInboxRecord(long):com.helpshift.conversation.dto.dao.ConversationInboxRecord");
    }

    public synchronized Conversation readConversationWithLocalId(Long l) {
        return readConversation(UserDB.WHERE_LOCAL_ID_IS, new String[]{String.valueOf(l)});
    }

    public synchronized Conversation readConversationWithServerId(String str) {
        return readConversation("server_id = ?", new String[]{String.valueOf(str)});
    }

    public synchronized DAOResult<List<Conversation>> readConversationsWithLocalId(long j) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor query = this.dbHelper.getReadableDatabase().query(ConversationTable.TABLE_NAME, (String[]) null, "user_local_id = ?", new String[]{String.valueOf(j)}, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                do {
                    arrayList.add(cursorToReadableConversation(query));
                } while (query.moveToNext());
            }
            query.close();
        } catch (Exception e) {
            try {
                HSLogger.m3242e(TAG, "Error in read conversations with localId", e);
                return new DAOResult<>(false, arrayList);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return new DAOResult<>(true, arrayList);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.helpshift.conversation.activeconversation.message.MessageDM} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.common.dao.DAOResult<com.helpshift.conversation.activeconversation.message.MessageDM> readMessageWithLocalId(java.lang.Long r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "_id = ?"
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ all -> 0x003a }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x003a }
            r3 = 0
            r2[r3] = r5     // Catch:{ all -> 0x003a }
            com.helpshift.common.dao.DAOResult r5 = r4.readMessages((java.lang.String) r0, (java.lang.String[]) r2)     // Catch:{ all -> 0x003a }
            boolean r0 = r5.isSuccess()     // Catch:{ all -> 0x003a }
            r2 = 0
            if (r0 != 0) goto L_0x001f
            com.helpshift.common.dao.DAOResult r5 = new com.helpshift.common.dao.DAOResult     // Catch:{ all -> 0x003a }
            r5.<init>(r3, r2)     // Catch:{ all -> 0x003a }
            monitor-exit(r4)
            return r5
        L_0x001f:
            java.lang.Object r5 = r5.getData()     // Catch:{ all -> 0x003a }
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x003a }
            boolean r0 = com.helpshift.util.ListUtils.isEmpty(r5)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x002c
            goto L_0x0033
        L_0x002c:
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x003a }
            r2 = r5
            com.helpshift.conversation.activeconversation.message.MessageDM r2 = (com.helpshift.conversation.activeconversation.message.MessageDM) r2     // Catch:{ all -> 0x003a }
        L_0x0033:
            com.helpshift.common.dao.DAOResult r5 = new com.helpshift.common.dao.DAOResult     // Catch:{ all -> 0x003a }
            r5.<init>(r1, r2)     // Catch:{ all -> 0x003a }
            monitor-exit(r4)
            return r5
        L_0x003a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.readMessageWithLocalId(java.lang.Long):com.helpshift.common.dao.DAOResult");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.helpshift.conversation.activeconversation.message.MessageDM} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.common.dao.DAOResult<com.helpshift.conversation.activeconversation.message.MessageDM> readMessageWithServerId(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "server_id = ?"
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ all -> 0x003a }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x003a }
            r3 = 0
            r2[r3] = r5     // Catch:{ all -> 0x003a }
            com.helpshift.common.dao.DAOResult r5 = r4.readMessages((java.lang.String) r0, (java.lang.String[]) r2)     // Catch:{ all -> 0x003a }
            boolean r0 = r5.isSuccess()     // Catch:{ all -> 0x003a }
            r2 = 0
            if (r0 != 0) goto L_0x001f
            com.helpshift.common.dao.DAOResult r5 = new com.helpshift.common.dao.DAOResult     // Catch:{ all -> 0x003a }
            r5.<init>(r3, r2)     // Catch:{ all -> 0x003a }
            monitor-exit(r4)
            return r5
        L_0x001f:
            java.lang.Object r5 = r5.getData()     // Catch:{ all -> 0x003a }
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x003a }
            boolean r0 = com.helpshift.util.ListUtils.isEmpty(r5)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x002c
            goto L_0x0033
        L_0x002c:
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x003a }
            r2 = r5
            com.helpshift.conversation.activeconversation.message.MessageDM r2 = (com.helpshift.conversation.activeconversation.message.MessageDM) r2     // Catch:{ all -> 0x003a }
        L_0x0033:
            com.helpshift.common.dao.DAOResult r5 = new com.helpshift.common.dao.DAOResult     // Catch:{ all -> 0x003a }
            r5.<init>(r1, r2)     // Catch:{ all -> 0x003a }
            monitor-exit(r4)
            return r5
        L_0x003a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.readMessageWithServerId(java.lang.String):com.helpshift.common.dao.DAOResult");
    }

    public synchronized DAOResult<List<MessageDM>> readMessages(long j) {
        return readMessages("conversation_id = ?", new String[]{String.valueOf(j)});
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0090, code lost:
        if (r2 != 0) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0096, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a0, code lost:
        if (r2 == 0) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a3, code lost:
        if (r2 != 0) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a8, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00cb, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d5, code lost:
        if (r1 == null) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00db, code lost:
        if (r1 != null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00dd, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00e0, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e1, code lost:
        if (r1 == null) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00f3, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00fd, code lost:
        if (r1 == null) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0103, code lost:
        if (r1 != null) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0105, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0108, code lost:
        throw r13;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:33:0x009d, B:59:0x00d2, B:79:0x00fa] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c1 A[SYNTHETIC, Splitter:B:52:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00e9 A[SYNTHETIC, Splitter:B:72:0x00e9] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010b A[Catch:{ all -> 0x00f3, all -> 0x00cb, all -> 0x0096 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0092=Splitter:B:28:0x0092, B:62:0x00d7=Splitter:B:62:0x00d7, B:82:0x00ff=Splitter:B:82:0x00ff} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.helpshift.conversation.activeconversation.message.MessageDM> readMessagesForConversations(java.util.Collection<java.lang.Long> r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x010d }
            r0.<init>()     // Catch:{ all -> 0x010d }
            r1 = 900(0x384, float:1.261E-42)
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r3.<init>(r13)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.util.List r13 = com.helpshift.util.DatabaseUtils.createBatches(r1, r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            com.helpshift.db.conversation.ConversationDBHelper r1 = r12.dbHelper     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r1.beginTransaction()     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
        L_0x001f:
            boolean r3 = r13.hasNext()     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            if (r3 == 0) goto L_0x0084
            java.lang.Object r3 = r13.next()     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            int r4 = r3.size()     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            java.lang.String r4 = com.helpshift.util.DatabaseUtils.makePlaceholders(r4)     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            r5.<init>()     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            java.lang.String r6 = "conversation_id IN ("
            r5.append(r6)     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            r5.append(r4)     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            java.lang.String r4 = ")"
            r5.append(r4)     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            java.lang.String r6 = r5.toString()     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            int r4 = r3.size()     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            r4 = 0
        L_0x0050:
            int r5 = r3.size()     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            if (r4 >= r5) goto L_0x0063
            java.lang.Object r5 = r3.get(r4)     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            r7[r4] = r5     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            int r4 = r4 + 1
            goto L_0x0050
        L_0x0063:
            java.lang.String r4 = "messages"
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r1
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            if (r3 == 0) goto L_0x001f
        L_0x0074:
            com.helpshift.conversation.activeconversation.message.MessageDM r3 = r12.cursorToMessageDM(r2)     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            if (r3 == 0) goto L_0x007d
            r0.add(r3)     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
        L_0x007d:
            boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            if (r3 != 0) goto L_0x0074
            goto L_0x001f
        L_0x0084:
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x00ae, all -> 0x00a9 }
            boolean r13 = r1.inTransaction()     // Catch:{ Exception -> 0x0098 }
            if (r13 == 0) goto L_0x0090
            r1.endTransaction()     // Catch:{ Exception -> 0x0098 }
        L_0x0090:
            if (r2 == 0) goto L_0x00e4
        L_0x0092:
            r2.close()     // Catch:{ all -> 0x010d }
            goto L_0x00e4
        L_0x0096:
            r13 = move-exception
            goto L_0x00a3
        L_0x0098:
            r13 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r3 = "Error in read messages inside finally block, "
            com.helpshift.util.HSLogger.m3242e(r1, r3, r13)     // Catch:{ all -> 0x0096 }
            if (r2 == 0) goto L_0x00e4
            goto L_0x0092
        L_0x00a3:
            if (r2 == 0) goto L_0x00a8
            r2.close()     // Catch:{ all -> 0x010d }
        L_0x00a8:
            throw r13     // Catch:{ all -> 0x010d }
        L_0x00a9:
            r13 = move-exception
            r11 = r2
            r2 = r1
            r1 = r11
            goto L_0x00e7
        L_0x00ae:
            r13 = move-exception
            r11 = r2
            r2 = r1
            r1 = r11
            goto L_0x00b8
        L_0x00b3:
            r13 = move-exception
            r1 = r2
            goto L_0x00e7
        L_0x00b6:
            r13 = move-exception
            r1 = r2
        L_0x00b8:
            java.lang.String r3 = "Helpshift_ConverDB"
            java.lang.String r4 = "Error in read messages"
            com.helpshift.util.HSLogger.m3242e(r3, r4, r13)     // Catch:{ all -> 0x00e6 }
            if (r2 == 0) goto L_0x00e1
            boolean r13 = r2.inTransaction()     // Catch:{ Exception -> 0x00cd }
            if (r13 == 0) goto L_0x00e1
            r2.endTransaction()     // Catch:{ Exception -> 0x00cd }
            goto L_0x00e1
        L_0x00cb:
            r13 = move-exception
            goto L_0x00db
        L_0x00cd:
            r13 = move-exception
            java.lang.String r2 = "Helpshift_ConverDB"
            java.lang.String r3 = "Error in read messages inside finally block, "
            com.helpshift.util.HSLogger.m3242e(r2, r3, r13)     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x00e4
        L_0x00d7:
            r1.close()     // Catch:{ all -> 0x010d }
            goto L_0x00e4
        L_0x00db:
            if (r1 == 0) goto L_0x00e0
            r1.close()     // Catch:{ all -> 0x010d }
        L_0x00e0:
            throw r13     // Catch:{ all -> 0x010d }
        L_0x00e1:
            if (r1 == 0) goto L_0x00e4
            goto L_0x00d7
        L_0x00e4:
            monitor-exit(r12)
            return r0
        L_0x00e6:
            r13 = move-exception
        L_0x00e7:
            if (r2 == 0) goto L_0x0109
            boolean r0 = r2.inTransaction()     // Catch:{ Exception -> 0x00f5 }
            if (r0 == 0) goto L_0x0109
            r2.endTransaction()     // Catch:{ Exception -> 0x00f5 }
            goto L_0x0109
        L_0x00f3:
            r13 = move-exception
            goto L_0x0103
        L_0x00f5:
            r0 = move-exception
            java.lang.String r2 = "Helpshift_ConverDB"
            java.lang.String r3 = "Error in read messages inside finally block, "
            com.helpshift.util.HSLogger.m3242e(r2, r3, r0)     // Catch:{ all -> 0x00f3 }
            if (r1 == 0) goto L_0x010c
        L_0x00ff:
            r1.close()     // Catch:{ all -> 0x010d }
            goto L_0x010c
        L_0x0103:
            if (r1 == 0) goto L_0x0108
            r1.close()     // Catch:{ all -> 0x010d }
        L_0x0108:
            throw r13     // Catch:{ all -> 0x010d }
        L_0x0109:
            if (r1 == 0) goto L_0x010c
            goto L_0x00ff
        L_0x010c:
            throw r13     // Catch:{ all -> 0x010d }
        L_0x010d:
            r13 = move-exception
            monitor-exit(r12)
            goto L_0x0111
        L_0x0110:
            throw r13
        L_0x0111:
            goto L_0x0110
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.readMessagesForConversations(java.util.Collection):java.util.List");
    }

    public synchronized Conversation readPreConversationWithServerId(String str) {
        return readConversation("pre_conv_server_id = ?", new String[]{String.valueOf(str)});
    }

    public synchronized void removeAdminFAQSuggestion(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.dbHelper.getWritableDatabase().delete(FaqsTable.TABLE_NAME, "publish_id = ? AND language = ?", new String[]{str, str2});
            } catch (Exception e) {
                HSLogger.m3242e(TAG, "Error in removeAdminFAQSuggestion", e);
            }
        }
        return;
    }

    public synchronized ConversationInboxRecord storeConversationInboxRecord(ConversationInboxRecord conversationInboxRecord) {
        String[] strArr = {String.valueOf(conversationInboxRecord.userLocalId)};
        ContentValues conversationInboxRecordToContentValues = conversationInboxRecordToContentValues(conversationInboxRecord);
        try {
            SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
            if (exists(writableDatabase, ConversationInboxTable.TABLE_NAME, "user_local_id = ?", strArr)) {
                writableDatabase.update(ConversationInboxTable.TABLE_NAME, conversationInboxRecordToContentValues, "user_local_id = ?", strArr);
            } else {
                writableDatabase.insert(ConversationInboxTable.TABLE_NAME, (String) null, conversationInboxRecordToContentValues);
            }
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error in store conversation inbox record", e);
        }
        return conversationInboxRecord;
    }

    public synchronized void updateConversation(Conversation conversation) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(conversation);
        updateConversations(arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        com.helpshift.util.HSLogger.m3242e(TAG, "Error in update conversations inside finally block", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0072, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008c, code lost:
        if (r3 != null) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r3.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0092, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        com.helpshift.util.HSLogger.m3242e(TAG, "Error in update conversations inside finally block", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009a, code lost:
        throw r11;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:19:0x0064, B:30:0x0079] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean updateConversations(java.util.List<com.helpshift.conversation.activeconversation.model.Conversation> r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            int r0 = r11.size()     // Catch:{ all -> 0x009b }
            r1 = 1
            if (r0 != 0) goto L_0x000a
            monitor-exit(r10)
            return r1
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x009b }
            r0.<init>()     // Catch:{ all -> 0x009b }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x009b }
            r2.<init>()     // Catch:{ all -> 0x009b }
            java.util.Iterator r3 = r11.iterator()     // Catch:{ all -> 0x009b }
        L_0x0018:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x009b }
            r5 = 0
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x009b }
            com.helpshift.conversation.activeconversation.model.Conversation r4 = (com.helpshift.conversation.activeconversation.model.Conversation) r4     // Catch:{ all -> 0x009b }
            android.content.ContentValues r6 = r10.readableConversationToContentValues(r4)     // Catch:{ all -> 0x009b }
            r0.add(r6)     // Catch:{ all -> 0x009b }
            java.lang.String[] r6 = new java.lang.String[r1]     // Catch:{ all -> 0x009b }
            java.lang.Long r4 = r4.localId     // Catch:{ all -> 0x009b }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x009b }
            r6[r5] = r4     // Catch:{ all -> 0x009b }
            r2.add(r6)     // Catch:{ all -> 0x009b }
            goto L_0x0018
        L_0x003a:
            r3 = 0
            java.lang.String r4 = "_id = ?"
            com.helpshift.db.conversation.ConversationDBHelper r6 = r10.dbHelper     // Catch:{ Exception -> 0x0074 }
            android.database.sqlite.SQLiteDatabase r3 = r6.getWritableDatabase()     // Catch:{ Exception -> 0x0074 }
            r3.beginTransaction()     // Catch:{ Exception -> 0x0074 }
            r6 = 0
        L_0x0047:
            int r7 = r11.size()     // Catch:{ Exception -> 0x0074 }
            if (r6 >= r7) goto L_0x0061
            java.lang.String r7 = "issues"
            java.lang.Object r8 = r0.get(r6)     // Catch:{ Exception -> 0x0074 }
            android.content.ContentValues r8 = (android.content.ContentValues) r8     // Catch:{ Exception -> 0x0074 }
            java.lang.Object r9 = r2.get(r6)     // Catch:{ Exception -> 0x0074 }
            java.lang.String[] r9 = (java.lang.String[]) r9     // Catch:{ Exception -> 0x0074 }
            r3.update(r7, r8, r4, r9)     // Catch:{ Exception -> 0x0074 }
            int r6 = r6 + 1
            goto L_0x0047
        L_0x0061:
            r3.setTransactionSuccessful()     // Catch:{ Exception -> 0x0074 }
            r3.endTransaction()     // Catch:{ Exception -> 0x0068 }
            goto L_0x0070
        L_0x0068:
            r11 = move-exception
            java.lang.String r0 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in update conversations inside finally block"
            com.helpshift.util.HSLogger.m3242e(r0, r2, r11)     // Catch:{ all -> 0x009b }
        L_0x0070:
            monitor-exit(r10)
            return r1
        L_0x0072:
            r11 = move-exception
            goto L_0x008c
        L_0x0074:
            r11 = move-exception
            java.lang.String r0 = "Helpshift_ConverDB"
            java.lang.String r1 = "Error in update conversations"
            com.helpshift.util.HSLogger.m3242e(r0, r1, r11)     // Catch:{ all -> 0x0072 }
            if (r3 == 0) goto L_0x008a
            r3.endTransaction()     // Catch:{ Exception -> 0x0082 }
            goto L_0x008a
        L_0x0082:
            r11 = move-exception
            java.lang.String r0 = "Helpshift_ConverDB"
            java.lang.String r1 = "Error in update conversations inside finally block"
            com.helpshift.util.HSLogger.m3242e(r0, r1, r11)     // Catch:{ all -> 0x009b }
        L_0x008a:
            monitor-exit(r10)
            return r5
        L_0x008c:
            if (r3 == 0) goto L_0x009a
            r3.endTransaction()     // Catch:{ Exception -> 0x0092 }
            goto L_0x009a
        L_0x0092:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in update conversations inside finally block"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x009b }
        L_0x009a:
            throw r11     // Catch:{ all -> 0x009b }
        L_0x009b:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x009f
        L_0x009e:
            throw r11
        L_0x009f:
            goto L_0x009e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.updateConversations(java.util.List):boolean");
    }

    public synchronized void updateLastUserActivityTimeInConversation(Long l, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConversationTable.Columns.LAST_USER_ACTIVITY_TIME, Long.valueOf(j));
        try {
            this.dbHelper.getWritableDatabase().update(ConversationTable.TABLE_NAME, contentValues, UserDB.WHERE_LOCAL_ID_IS, new String[]{String.valueOf(l)});
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error in updateLastUserActivityTimeInConversation", e);
        }
        return;
    }

    public synchronized void updateMessage(MessageDM messageDM) {
        String str;
        String[] strArr = {String.valueOf(messageDM.localId)};
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.dbHelper.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            updateMessageInternal(sQLiteDatabase, messageDM, UserDB.WHERE_LOCAL_ID_IS, strArr);
            sQLiteDatabase.setTransactionSuccessful();
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception e) {
                e = e;
                String str2 = TAG;
                String str3 = "Error in update message inside finally block";
            }
        } catch (Exception e2) {
            try {
                HSLogger.m3242e(TAG, "Error in update message", e2);
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        str = "Error in update message inside finally block";
                        HSLogger.m3242e(TAG, str, e3);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        com.helpshift.util.HSLogger.m3242e(TAG, "Error in update messages", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0060, code lost:
        if (r0 != null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0066, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        com.helpshift.util.HSLogger.m3242e(TAG, "Error in update messages", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        throw r8;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:14:0x0038, B:25:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean updateMessages(java.util.List<com.helpshift.conversation.activeconversation.message.MessageDM> r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r8.size()     // Catch:{ all -> 0x006f }
            r1 = 1
            if (r0 != 0) goto L_0x000a
            monitor-exit(r7)
            return r1
        L_0x000a:
            r0 = 0
            java.lang.String r2 = "_id = ?"
            r3 = 0
            com.helpshift.db.conversation.ConversationDBHelper r4 = r7.dbHelper     // Catch:{ Exception -> 0x0048 }
            android.database.sqlite.SQLiteDatabase r0 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0048 }
            r0.beginTransaction()     // Catch:{ Exception -> 0x0048 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x0048 }
        L_0x001b:
            boolean r4 = r8.hasNext()     // Catch:{ Exception -> 0x0048 }
            if (r4 == 0) goto L_0x0035
            java.lang.Object r4 = r8.next()     // Catch:{ Exception -> 0x0048 }
            com.helpshift.conversation.activeconversation.message.MessageDM r4 = (com.helpshift.conversation.activeconversation.message.MessageDM) r4     // Catch:{ Exception -> 0x0048 }
            java.lang.String[] r5 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0048 }
            java.lang.Long r6 = r4.localId     // Catch:{ Exception -> 0x0048 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x0048 }
            r5[r3] = r6     // Catch:{ Exception -> 0x0048 }
            r7.updateMessageInternal(r0, r4, r2, r5)     // Catch:{ Exception -> 0x0048 }
            goto L_0x001b
        L_0x0035:
            r0.setTransactionSuccessful()     // Catch:{ Exception -> 0x0048 }
            r0.endTransaction()     // Catch:{ Exception -> 0x003c }
            goto L_0x0044
        L_0x003c:
            r8 = move-exception
            java.lang.String r0 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in update messages"
            com.helpshift.util.HSLogger.m3242e(r0, r2, r8)     // Catch:{ all -> 0x006f }
        L_0x0044:
            monitor-exit(r7)
            return r1
        L_0x0046:
            r8 = move-exception
            goto L_0x0060
        L_0x0048:
            r8 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in update messages"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r8)     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x005e
            r0.endTransaction()     // Catch:{ Exception -> 0x0056 }
            goto L_0x005e
        L_0x0056:
            r8 = move-exception
            java.lang.String r0 = "Helpshift_ConverDB"
            java.lang.String r1 = "Error in update messages"
            com.helpshift.util.HSLogger.m3242e(r0, r1, r8)     // Catch:{ all -> 0x006f }
        L_0x005e:
            monitor-exit(r7)
            return r3
        L_0x0060:
            if (r0 == 0) goto L_0x006e
            r0.endTransaction()     // Catch:{ Exception -> 0x0066 }
            goto L_0x006e
        L_0x0066:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in update messages"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x006f }
        L_0x006e:
            throw r8     // Catch:{ all -> 0x006f }
        L_0x006f:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x0073
        L_0x0072:
            throw r8
        L_0x0073:
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.updateMessages(java.util.List):boolean");
    }

    public synchronized List<MessageDM> readMessages(long j, MessageType messageType) {
        return readMessages("conversation_id = ? AND type = ?", new String[]{String.valueOf(j), messageType.getValue()}).getData();
    }

    private DAOResult<List<MessageDM>> readMessages(String str, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor query = this.dbHelper.getReadableDatabase().query("messages", (String[]) null, str, strArr, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                do {
                    MessageDM cursorToMessageDM = cursorToMessageDM(query);
                    if (cursorToMessageDM != null) {
                        arrayList.add(cursorToMessageDM);
                    }
                } while (query.moveToNext());
            }
            query.close();
            return new DAOResult<>(true, arrayList);
        } catch (Exception e) {
            HSLogger.m3242e(TAG, "Error in read messages", e);
            DAOResult<List<MessageDM>> dAOResult = new DAOResult<>(false, arrayList);
            if (cursor != null) {
                cursor.close();
            }
            return dAOResult;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private void buildMetaForInput(JSONObject jSONObject, OptionInput optionInput) throws JSONException {
        buildMetaForBotInfo(jSONObject, optionInput.botInfo);
        jSONObject.put("input_required", optionInput.required);
        jSONObject.put("input_label", optionInput.inputLabel);
        jSONObject.put("input_skip_label", optionInput.skipLabel);
        if (optionInput.options != null) {
            JSONArray jSONArray = new JSONArray();
            for (OptionInput.Option next : optionInput.options) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("option_title", next.title);
                jSONObject2.put("option_data", next.jsonData);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("input_options", jSONArray);
        }
        jSONObject.put("option_type", optionInput.type.toString());
    }
}
