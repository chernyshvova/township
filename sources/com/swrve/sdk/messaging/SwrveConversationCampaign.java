package com.swrve.sdk.messaging;

import com.swrve.sdk.ISwrveCampaignManager;
import com.swrve.sdk.QaCampaignInfo;
import com.swrve.sdk.SwrveAssetsQueueItem;
import com.swrve.sdk.SwrveCampaignDisplayer;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.conversations.SwrveConversation;
import com.swrve.sdk.conversations.engine.model.ButtonControl;
import com.swrve.sdk.conversations.engine.model.ChoiceInputItem;
import com.swrve.sdk.conversations.engine.model.Content;
import com.swrve.sdk.conversations.engine.model.ConversationAtom;
import com.swrve.sdk.conversations.engine.model.ConversationPage;
import com.swrve.sdk.conversations.engine.model.MultiValueInput;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;
import com.swrve.sdk.conversations.p035ui.ConversationActivity;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveConversationCampaign extends SwrveBaseCampaign implements Serializable {
    public SwrveConversation conversation;

    /* renamed from: com.swrve.sdk.messaging.SwrveConversationCampaign$1 */
    public static /* synthetic */ class C17031 {

        /* renamed from: $SwitchMap$com$swrve$sdk$conversations$engine$model$ConversationAtom$TYPE */
        public static final /* synthetic */ int[] f2796x6c668315;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001e */
        static {
            /*
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE[] r0 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2796x6c668315 = r0
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r1 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.CONTENT_IMAGE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = f2796x6c668315     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r1 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.CONTENT_HTML     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 0
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r0 = f2796x6c668315     // Catch:{ NoSuchFieldError -> 0x001e }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r1 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.INPUT_STARRATING     // Catch:{ NoSuchFieldError -> 0x001e }
                r1 = 5
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                int[] r0 = f2796x6c668315     // Catch:{ NoSuchFieldError -> 0x0025 }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r1 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.INPUT_MULTIVALUE     // Catch:{ NoSuchFieldError -> 0x0025 }
                r1 = 4
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0025 }
            L_0x0025:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.messaging.SwrveConversationCampaign.C17031.<clinit>():void");
        }
    }

    public SwrveConversationCampaign(ISwrveCampaignManager iSwrveCampaignManager, SwrveCampaignDisplayer swrveCampaignDisplayer, JSONObject jSONObject, Set<SwrveAssetsQueueItem> set) throws JSONException {
        super(iSwrveCampaignManager, swrveCampaignDisplayer, jSONObject);
        if (jSONObject.has(ConversationActivity.EXTRA_CONVERSATION_KEY)) {
            SwrveConversation createConversation = createConversation(this, jSONObject.getJSONObject(ConversationActivity.EXTRA_CONVERSATION_KEY), iSwrveCampaignManager);
            this.conversation = createConversation;
            Iterator<ConversationPage> it = createConversation.getPages().iterator();
            while (it.hasNext()) {
                ConversationPage next = it.next();
                Iterator<ConversationAtom> it2 = next.getContent().iterator();
                while (it2.hasNext()) {
                    ConversationAtom next2 = it2.next();
                    int ordinal = next2.getType().ordinal();
                    if (ordinal != 0) {
                        if (ordinal == 1) {
                            queueImageAsset(set, (Content) next2);
                        } else if (ordinal == 4) {
                            MultiValueInput multiValueInput = (MultiValueInput) next2;
                            queueFontAsset(set, multiValueInput.getStyle());
                            Iterator<ChoiceInputItem> it3 = multiValueInput.getValues().iterator();
                            while (it3.hasNext()) {
                                queueFontAsset(set, it3.next().getStyle());
                            }
                        } else if (ordinal != 5) {
                        }
                    }
                    queueFontAsset(set, next2.getStyle());
                }
                Iterator<ButtonControl> it4 = next.getControls().iterator();
                while (it4.hasNext()) {
                    queueFontAsset(set, it4.next().getStyle());
                }
            }
        }
    }

    private void queueFontAsset(Set<SwrveAssetsQueueItem> set, ConversationStyle conversationStyle) {
        if (conversationStyle != null && SwrveHelper.isNotNullOrEmpty(conversationStyle.getFontFile()) && SwrveHelper.isNotNullOrEmpty(conversationStyle.getFontDigest()) && !conversationStyle.isSystemFont()) {
            set.add(new SwrveAssetsQueueItem(getId(), conversationStyle.getFontFile(), conversationStyle.getFontDigest(), false, false));
        }
    }

    private void queueImageAsset(Set<SwrveAssetsQueueItem> set, Content content) {
        set.add(new SwrveAssetsQueueItem(getId(), content.getValue(), content.getValue(), true, false));
    }

    public boolean areAssetsReady(Set<String> set) {
        return this.conversation.areAssetsReady(set);
    }

    public SwrveConversation createConversation(SwrveConversationCampaign swrveConversationCampaign, JSONObject jSONObject, ISwrveCampaignManager iSwrveCampaignManager) throws JSONException {
        return new SwrveConversation(swrveConversationCampaign, jSONObject, iSwrveCampaignManager);
    }

    public QaCampaignInfo.CAMPAIGN_TYPE getCampaignType() {
        return QaCampaignInfo.CAMPAIGN_TYPE.CONVERSATION;
    }

    public SwrveConversation getConversation() {
        return this.conversation;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r9 = r7.conversation;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.swrve.sdk.conversations.SwrveConversation getConversationForEvent(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, java.util.Date r10, java.util.Map<java.lang.Integer, com.swrve.sdk.QaCampaignInfo> r11) {
        /*
            r7 = this;
            com.swrve.sdk.SwrveCampaignDisplayer r0 = r7.campaignDisplayer
            r6 = 1
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            boolean r9 = r0.shouldShowCampaign(r1, r2, r3, r4, r5, r6)
            r10 = 1
            r11 = 0
            if (r9 == 0) goto L_0x0022
            com.swrve.sdk.conversations.SwrveConversation r9 = r7.conversation
            if (r9 == 0) goto L_0x0022
            com.swrve.sdk.ISwrveCampaignManager r0 = r7.campaignManager
            java.util.Set r0 = r0.getAssetsOnDisk()
            boolean r9 = r9.areAssetsReady(r0)
            if (r9 == 0) goto L_0x0022
            r9 = 1
            goto L_0x0023
        L_0x0022:
            r9 = 0
        L_0x0023:
            if (r9 == 0) goto L_0x003a
            r9 = 2
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r9[r11] = r8
            int r8 = r7.f2795id
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9[r10] = r8
            java.lang.String r8 = "%s matches a trigger in %s"
            com.swrve.sdk.SwrveLogger.m2755i(r8, r9)
            com.swrve.sdk.conversations.SwrveConversation r8 = r7.conversation
            return r8
        L_0x003a:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.messaging.SwrveConversationCampaign.getConversationForEvent(java.lang.String, java.util.Map, java.util.Date, java.util.Map):com.swrve.sdk.conversations.SwrveConversation");
    }

    public boolean supportsOrientation(SwrveOrientation swrveOrientation) {
        return true;
    }

    public boolean areAssetsReady(Set<String> set, Map<String, String> map) {
        return this.conversation.areAssetsReady(set);
    }
}
