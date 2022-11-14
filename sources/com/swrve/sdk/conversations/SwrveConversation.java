package com.swrve.sdk.conversations;

import com.swrve.sdk.ISwrveCampaignManager;
import com.swrve.sdk.SwrveBaseConversation;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.conversations.engine.model.ButtonControl;
import com.swrve.sdk.conversations.engine.model.ChoiceInputItem;
import com.swrve.sdk.conversations.engine.model.Content;
import com.swrve.sdk.conversations.engine.model.ControlBase;
import com.swrve.sdk.conversations.engine.model.ConversationAtom;
import com.swrve.sdk.conversations.engine.model.ConversationPage;
import com.swrve.sdk.conversations.engine.model.MultiValueInput;
import com.swrve.sdk.conversations.engine.model.styles.ConversationStyle;
import com.swrve.sdk.messaging.SwrveConversationCampaign;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SwrveConversation extends SwrveBaseConversation implements Serializable {
    public transient SwrveConversationCampaign campaign;

    /* renamed from: com.swrve.sdk.conversations.SwrveConversation$1 */
    public static /* synthetic */ class C16981 {

        /* renamed from: $SwitchMap$com$swrve$sdk$conversations$engine$model$ConversationAtom$TYPE */
        public static final /* synthetic */ int[] f2787x6c668315;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|(2:3|4)|5|7|8|9|10|11|12|14) */
        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|7|8|9|10|11|12|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001e */
        static {
            /*
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE[] r0 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2787x6c668315 = r0
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r1 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.CONTENT_IMAGE     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = f2787x6c668315     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r1 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.CONTENT_HTML     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 0
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r0 = 5
                int[] r1 = f2787x6c668315     // Catch:{ NoSuchFieldError -> 0x001e }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r2 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.INPUT_STARRATING     // Catch:{ NoSuchFieldError -> 0x001e }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                int[] r1 = f2787x6c668315     // Catch:{ NoSuchFieldError -> 0x0025 }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r2 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.INPUT_MULTIVALUE     // Catch:{ NoSuchFieldError -> 0x0025 }
                r2 = 4
                r1[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0025 }
            L_0x0025:
                int[] r1 = f2787x6c668315     // Catch:{ NoSuchFieldError -> 0x002c }
                com.swrve.sdk.conversations.engine.model.ConversationAtom$TYPE r2 = com.swrve.sdk.conversations.engine.model.ConversationAtom.TYPE.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x002c }
                r2 = 6
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x002c }
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.conversations.SwrveConversation.C16981.<clinit>():void");
        }
    }

    public SwrveConversation(SwrveConversationCampaign swrveConversationCampaign, JSONObject jSONObject, ISwrveCampaignManager iSwrveCampaignManager) throws JSONException {
        super(jSONObject, iSwrveCampaignManager.getCacheDir());
        this.campaign = swrveConversationCampaign;
    }

    private boolean isAssetInCache(Set<String> set, String str) {
        return !SwrveHelper.isNullOrEmpty(str) && set.contains(str);
    }

    private boolean isFontAssetInCache(Set<String> set, ConversationStyle conversationStyle) {
        if (conversationStyle == null || conversationStyle.isSystemFont() || !SwrveHelper.isNotNullOrEmpty(conversationStyle.getFontFile()) || isAssetInCache(set, conversationStyle.getFontFile())) {
            return true;
        }
        SwrveLogger.m2755i("Conversation font asset not yet downloaded: %s", conversationStyle.getFontFile());
        return false;
    }

    public boolean areAssetsReady(Set<String> set) {
        ArrayList<ConversationPage> arrayList = this.pages;
        if (arrayList != null) {
            Iterator<ConversationPage> it = arrayList.iterator();
            while (it.hasNext()) {
                ConversationPage next = it.next();
                Iterator<ConversationAtom> it2 = next.getContent().iterator();
                while (it2.hasNext()) {
                    ConversationAtom next2 = it2.next();
                    int ordinal = next2.getType().ordinal();
                    if (ordinal != 0) {
                        if (ordinal == 1) {
                            Content content = (Content) next2;
                            if (!isAssetInCache(set, content.getValue())) {
                                SwrveLogger.m2755i("Conversation asset not yet downloaded: %s", content.getValue());
                                return false;
                            }
                        } else if (ordinal == 4) {
                            MultiValueInput multiValueInput = (MultiValueInput) next2;
                            if (!isFontAssetInCache(set, multiValueInput.getStyle())) {
                                return false;
                            }
                            Iterator<ChoiceInputItem> it3 = multiValueInput.getValues().iterator();
                            while (it3.hasNext()) {
                                if (!isFontAssetInCache(set, it3.next().getStyle())) {
                                    return false;
                                }
                            }
                            continue;
                        } else if (ordinal != 5) {
                            continue;
                        }
                    }
                    if (!isFontAssetInCache(set, next2.getStyle())) {
                        return false;
                    }
                }
                Iterator<ButtonControl> it4 = next.getControls().iterator();
                while (true) {
                    if (it4.hasNext()) {
                        if (!isFontAssetInCache(set, it4.next().getStyle())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public SwrveConversationCampaign getCampaign() {
        return this.campaign;
    }

    public ConversationPage getFirstPage() {
        ArrayList<ConversationPage> arrayList = this.pages;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.pages.get(0);
    }

    public ConversationPage getPageForControl(ControlBase controlBase) {
        Iterator<ConversationPage> it = this.pages.iterator();
        while (it.hasNext()) {
            ConversationPage next = it.next();
            if (next.hasTag(controlBase.getTarget())) {
                return next;
            }
        }
        return null;
    }
}
