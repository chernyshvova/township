package com.swrve.sdk;

import androidx.core.app.NotificationCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.share.internal.VideoUploader;
import com.swrve.sdk.conversations.engine.model.ChoiceInputResponse;
import com.swrve.sdk.conversations.engine.model.UserInputResult;
import com.swrve.sdk.conversations.p035ui.ConversationActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class SwrveConversationEventHelper {
    public static Map<String, String> customPayload;
    public ISwrveConversationSDK swrveConversationSDK = ((ISwrveConversationSDK) SwrveCommon.getInstance());

    public static Map<String, String> getCustomPayload() {
        return customPayload;
    }

    public static void setCustomPayload(Map<String, String> map) {
        if (map == null) {
            SwrveLogger.m2752d("Swrve removing custom payload", new Object[0]);
            customPayload = map;
        } else if (map.size() > 5) {
            SwrveLogger.m2754e("Swrve custom payload rejected, attempted to add more than 5 key pair values", new Object[0]);
        } else if (!validatePayloadKeys(map)) {
            SwrveLogger.m2754e("Swrve custom payload rejected, attempted to add a key which is already reserved for Swrve internal events", new Object[0]);
        } else {
            customPayload = map;
        }
    }

    public static boolean validatePayloadKeys(Map map) {
        if (map == null) {
            return true;
        }
        HashSet hashSet = new HashSet(map.keySet());
        HashSet hashSet2 = new HashSet();
        hashSet2.add("event");
        hashSet2.add("to");
        hashSet2.add("page");
        hashSet2.add(ConversationActivity.EXTRA_CONVERSATION_KEY);
        hashSet2.add("control");
        hashSet2.add("fragment");
        hashSet2.add("result");
        hashSet2.add("name");
        hashSet2.add("id");
        hashSet.addAll(hashSet2);
        if (hashSet.size() == hashSet2.size() + map.size()) {
            return true;
        }
        return false;
    }

    public void conversationCallActionCalledByUser(SwrveBaseConversation swrveBaseConversation, String str, String str2) {
        queueEventPageAction(swrveBaseConversation, NotificationCompat.CATEGORY_CALL, str, "control", str2);
    }

    public void conversationDeeplinkActionCalledByUser(SwrveBaseConversation swrveBaseConversation, String str, String str2) {
        queueEventPageAction(swrveBaseConversation, "deeplink", str, "control", str2);
    }

    public void conversationEncounteredError(SwrveBaseConversation swrveBaseConversation, String str, Exception exc) {
        try {
            String eventForConversation = getEventForConversation(swrveBaseConversation, "error");
            if (exc != null) {
                SwrveLogger.m2753e("Sending error conversation event: %s", exc, eventForConversation);
            } else {
                SwrveLogger.m2754e("Sending error conversations event: (No Exception) %s", new Object[0]);
            }
            queueEvent(swrveBaseConversation, "error", str);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in SwrveConversationSDK", e, new Object[0]);
        }
    }

    public void conversationEventsCommitedByUser(SwrveBaseConversation swrveBaseConversation, ArrayList<UserInputResult> arrayList) {
        Map<String, String> customPayload2;
        try {
            if (this.swrveConversationSDK != null) {
                Iterator<UserInputResult> it = arrayList.iterator();
                while (it.hasNext()) {
                    UserInputResult next = it.next();
                    HashMap hashMap = new HashMap();
                    hashMap.put("fragment", next.getFragmentTag());
                    if (next.isSingleChoice()) {
                        hashMap.put("result", ((ChoiceInputResponse) next.getResult()).getAnswerID());
                    } else if (next.isStarRating()) {
                        hashMap.put("result", String.valueOf(next.getResult()));
                    }
                    String type = next.getType();
                    String eventForConversation = getEventForConversation(swrveBaseConversation, type);
                    if ((UserInputResult.TYPE_STAR_RATING.equals(type) || UserInputResult.TYPE_SINGLE_CHOICE.equals(type) || UserInputResult.TYPE_VIDEO_PLAY.equals(type)) && (customPayload2 = getCustomPayload()) != null) {
                        hashMap.putAll(customPayload2);
                    }
                    this.swrveConversationSDK.queueConversationEvent(eventForConversation, type, next.getPageTag(), next.getConversationId(), hashMap);
                }
                return;
            }
            SwrveLogger.m2754e("The SwrveConversationSDK is null, so cannot send events.", new Object[0]);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in SwrveConversationSDK.", e, new Object[0]);
        }
    }

    public void conversationLinkVisitActionCalledByUser(SwrveBaseConversation swrveBaseConversation, String str, String str2) {
        queueEventPageAction(swrveBaseConversation, "visit", str, "control", str2);
    }

    public void conversationPageWasViewedByUser(SwrveBaseConversation swrveBaseConversation, String str) {
        queueEventPageAction(swrveBaseConversation, "impression", str);
    }

    public void conversationTransitionedToOtherPage(SwrveBaseConversation swrveBaseConversation, String str, String str2, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("control", str3);
            hashMap.put("to", str2);
            queueEvent(swrveBaseConversation, NotificationCompat.CATEGORY_NAVIGATION, str, hashMap);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in SwrveConversationSDK", e, new Object[0]);
        }
    }

    public void conversationWasCancelledByUser(SwrveBaseConversation swrveBaseConversation, String str) {
        queueEventPageAction(swrveBaseConversation, "cancel", str);
    }

    public void conversationWasFinishedByUser(SwrveBaseConversation swrveBaseConversation, String str, String str2) {
        queueEventPageAction(swrveBaseConversation, "done", str, "control", str2);
    }

    public void conversationWasStartedByUser(SwrveBaseConversation swrveBaseConversation, String str) {
        queueEventPageAction(swrveBaseConversation, VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE, str);
    }

    public String getEventForConversation(SwrveBaseConversation swrveBaseConversation, String str) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Swrve.Conversations.Conversation-");
        outline24.append(swrveBaseConversation.getId());
        outline24.append(CodelessMatcher.CURRENT_CLASS_NAME);
        outline24.append(str);
        return outline24.toString();
    }

    public void queueEvent(SwrveBaseConversation swrveBaseConversation, String str, String str2, Map<String, String> map) {
        if (swrveBaseConversation != null && this.swrveConversationSDK != null) {
            this.swrveConversationSDK.queueConversationEvent(getEventForConversation(swrveBaseConversation, str), str, str2, swrveBaseConversation.getId(), map);
        }
    }

    public void queueEventPageAction(SwrveBaseConversation swrveBaseConversation, String str, String str2, String str3, String str4) {
        HashMap hashMap = null;
        if (!(str3 == null || str4 == null)) {
            try {
                hashMap = new HashMap();
                hashMap.put(str3, str4);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in SwrveConversationSDK", e, new Object[0]);
                return;
            }
        }
        queueEvent(swrveBaseConversation, str, str2, hashMap);
    }

    public void sendQueuedEvents() {
        ISwrveConversationSDK iSwrveConversationSDK = this.swrveConversationSDK;
        if (iSwrveConversationSDK != null) {
            iSwrveConversationSDK.sendQueuedEvents();
        }
    }

    public void queueEvent(SwrveBaseConversation swrveBaseConversation, String str, String str2) {
        queueEvent(swrveBaseConversation, str, str2, (Map<String, String>) null);
    }

    public void queueEventPageAction(SwrveBaseConversation swrveBaseConversation, String str, String str2) {
        queueEventPageAction(swrveBaseConversation, str, str2, (String) null, (String) null);
    }
}
