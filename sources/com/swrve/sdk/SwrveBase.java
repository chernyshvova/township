package com.swrve.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.app.NotificationManagerCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.drive.DriveFile;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.p042db.legacy_profile.tables.ProfileTable;
import com.helpshift.p042db.network.tables.UrlMetadataTable;
import com.swrve.sdk.config.SwrveConfig;
import com.swrve.sdk.config.SwrveConfigBase;
import com.swrve.sdk.config.SwrveInAppMessageConfig;
import com.swrve.sdk.conversations.SwrveConversation;
import com.swrve.sdk.conversations.SwrveConversationListener;
import com.swrve.sdk.conversations.p035ui.ConversationActivity;
import com.swrve.sdk.exceptions.NoUserIdSwrveException;
import com.swrve.sdk.exceptions.SwrveSDKTextTemplatingException;
import com.swrve.sdk.localstorage.SQLiteLocalStorage;
import com.swrve.sdk.messaging.SwrveActionType;
import com.swrve.sdk.messaging.SwrveBaseCampaign;
import com.swrve.sdk.messaging.SwrveBaseMessage;
import com.swrve.sdk.messaging.SwrveButton;
import com.swrve.sdk.messaging.SwrveCampaignState;
import com.swrve.sdk.messaging.SwrveClipboardButtonListener;
import com.swrve.sdk.messaging.SwrveConversationCampaign;
import com.swrve.sdk.messaging.SwrveCustomButtonListener;
import com.swrve.sdk.messaging.SwrveDismissButtonListener;
import com.swrve.sdk.messaging.SwrveEmbeddedCampaign;
import com.swrve.sdk.messaging.SwrveEmbeddedMessage;
import com.swrve.sdk.messaging.SwrveInAppCampaign;
import com.swrve.sdk.messaging.SwrveInstallButtonListener;
import com.swrve.sdk.messaging.SwrveMessage;
import com.swrve.sdk.messaging.SwrveMessageFormat;
import com.swrve.sdk.messaging.SwrveMessageListener;
import com.swrve.sdk.messaging.SwrveOrientation;
import com.swrve.sdk.messaging.p036ui.SwrveInAppMessageActivity;
import com.swrve.sdk.rest.IRESTClient;
import com.swrve.sdk.rest.IRESTResponseListener;
import com.swrve.sdk.rest.RESTResponse;
import com.vungle.warren.downloader.AssetDownloader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class SwrveBase<T, C extends SwrveConfigBase> extends SwrveImp<T, C> implements ISwrveBase<T, C>, ISwrveCommon, ISwrveConversationSDK {
    public SwrveBase(Application application, int i, String str, C c) {
        super(application, i, str, c);
        SwrveCommon.setSwrveCommon(this);
    }

    public static String _getVersion() {
        return SwrveImp.version;
    }

    private String getStringFromDate(Date date) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(HSDateFormatSpec.STORAGE_TIME_PATTERN);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    private String getUnidentifiedUserId(String str, SwrveUser swrveUser) {
        if (swrveUser != null) {
            return swrveUser.getSwrveUserId();
        }
        String userId = this.multiLayerLocalStorage.getUserBySwrveUserId(getUserId()) == null ? getUserId() : UUID.randomUUID().toString();
        this.multiLayerLocalStorage.saveUser(new SwrveUser(userId, str, false));
        return userId;
    }

    public static String getVersion() {
        try {
            return _getVersion();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    private boolean identifyCachedUser(SwrveUser swrveUser, SwrveIdentityResponse swrveIdentityResponse) {
        if (swrveUser == null || !swrveUser.isVerified()) {
            return false;
        }
        switchUser(swrveUser.getSwrveUserId());
        if (swrveIdentityResponse != null) {
            swrveIdentityResponse.onSuccess("Loaded from cache", swrveUser.getSwrveUserId());
        }
        return true;
    }

    private void identifyUnknownUser(final String str, final SwrveIdentityResponse swrveIdentityResponse, SwrveUser swrveUser) {
        final String unidentifiedUserId = getUnidentifiedUserId(str, swrveUser);
        this.identifiedOnAnotherDevice = false;
        this.profileManager.identify(str, unidentifiedUserId, getDeviceId(), new SwrveIdentityResponse() {
            public void onError(int i, String str) {
                if (i == 403) {
                    SwrveBase swrveBase = SwrveBase.this;
                    swrveBase.multiLayerLocalStorage.deleteUser(swrveBase.getUserId());
                }
                SwrveBase.this.switchUser(unidentifiedUserId);
                SwrveIdentityResponse swrveIdentityResponse = swrveIdentityResponse;
                if (swrveIdentityResponse != null) {
                    swrveIdentityResponse.onError(i, str);
                }
            }

            public void onSuccess(String str, String str2) {
                SwrveBase.this.multiLayerLocalStorage.saveUser(new SwrveUser(str2, str, true));
                if (!unidentifiedUserId.equalsIgnoreCase(str2)) {
                    SwrveBase.this.identifiedOnAnotherDevice = true;
                }
                SwrveBase.this.switchUser(str2);
                SwrveIdentityResponse swrveIdentityResponse = swrveIdentityResponse;
                if (swrveIdentityResponse != null) {
                    swrveIdentityResponse.onSuccess(str, str2);
                }
            }
        });
    }

    private void initCacheDir(Activity activity) {
        File cacheDir = getCacheDir(activity);
        this.swrveAssetsManager.setStorageDir(cacheDir);
        SwrveLogger.m2752d("Using cache directory at %s", cacheDir.getPath());
    }

    private void initUserJoinedTimeAndFirstSession() {
        if (SwrveHelper.isNullOrEmpty(this.multiLayerLocalStorage.getCacheEntry(this.profileManager.getUserId(), ISwrveCommon.CACHE_USER_JOINED_TIME))) {
            this.multiLayerLocalStorage.setCacheEntry(this.profileManager.getUserId(), ISwrveCommon.CACHE_USER_JOINED_TIME, String.valueOf(this.initialisedTime.getTime()));
            if (!this.identifiedOnAnotherDevice) {
                _event(ISwrveCommon.EVENT_FIRST_SESSION);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isValidEventName(java.lang.String r5) {
        /*
            r4 = this;
            com.swrve.sdk.SwrveBase$4 r0 = new com.swrve.sdk.SwrveBase$4
            r0.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0009:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L_0x002c
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            if (r5 == 0) goto L_0x001e
            boolean r3 = r5.startsWith(r1)
            if (r3 == 0) goto L_0x0009
        L_0x001e:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r3 = 0
            r0[r3] = r1
            r0[r2] = r5
            java.lang.String r5 = "Event names cannot begin with %s* This event will not be sent. Eventname:%s"
            com.swrve.sdk.SwrveLogger.m2754e(r5, r0)
            return r3
        L_0x002c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveBase.isValidEventName(java.lang.String):boolean");
    }

    private void setDefaultMessageListener() {
        setMessageListener(new SwrveMessageListener() {
            public void onMessage(SwrveMessage swrveMessage) {
                onMessage(swrveMessage, (Map<String, String>) null);
            }

            public void onMessage(SwrveMessage swrveMessage, Map<String, String> map) {
                WeakReference<Context> weakReference = SwrveBase.this.context;
                if (weakReference != null) {
                    Context context = (Context) weakReference.get();
                    if (context == null) {
                        SwrveLogger.m2754e("Can't display a in-app message without a context", new Object[0]);
                        return;
                    }
                    SwrveBase swrveBase = SwrveBase.this;
                    Map<String, String> retrievePersonalizationProperties = swrveBase.retrievePersonalizationProperties(swrveBase.lastEventPayloadUsed, map);
                    if (!swrveMessage.supportsOrientation(SwrveBase.this.getDeviceOrientation())) {
                        SwrveLogger.m2755i("Can't display the in-app message as it doesn't support the current orientation", new Object[0]);
                    } else if (SwrveMessageTextTemplatingChecks.checkTextTemplating(swrveMessage, retrievePersonalizationProperties)) {
                        Intent intent = new Intent(context, SwrveInAppMessageActivity.class);
                        intent.addFlags(DriveFile.MODE_READ_ONLY);
                        intent.putExtra("message_id", swrveMessage.getId());
                        if (retrievePersonalizationProperties != null) {
                            intent.putExtra(SwrveInAppMessageActivity.SWRVE_PERSONALISATION_KEY, new HashMap(retrievePersonalizationProperties));
                        }
                        context.startActivity(intent);
                    }
                }
            }
        });
    }

    public void _buttonWasPressedByUser(SwrveButton swrveButton) {
        if (swrveButton.getActionType() != SwrveActionType.Dismiss) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Swrve.Messages.Message-");
            outline24.append(swrveButton.getMessage().getId());
            outline24.append(".click");
            String sb = outline24.toString();
            SwrveLogger.m2755i("Sending click event: %s(%s)", sb, swrveButton.getName());
            HashMap hashMap = new HashMap();
            hashMap.put("name", swrveButton.getName());
            hashMap.put("embedded", "false");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("name", sb);
            queueEvent(this.profileManager.getUserId(), "event", hashMap2, hashMap, false);
        }
    }

    public void _currencyGiven(String str, double d) {
        HashMap outline28 = GeneratedOutlineSupport.outline28("given_currency", str);
        outline28.put("given_amount", Double.toString(d));
        queueEvent("currency_given", outline28, (Map<String, String>) null);
    }

    public void _embeddedMessageButtonWasPressed(SwrveEmbeddedMessage swrveEmbeddedMessage, String str) {
        if (swrveEmbeddedMessage != null) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Swrve.Messages.Message-");
            outline24.append(swrveEmbeddedMessage.getId());
            outline24.append(".click");
            String sb = outline24.toString();
            SwrveLogger.m2755i("Sending click event: %s(%s)", sb, str);
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            hashMap.put("embedded", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            queueEvent(this.profileManager.getUserId(), "event", GeneratedOutlineSupport.outline28("name", sb), hashMap, false);
        }
    }

    public void _embeddedMessageWasShownToUser(SwrveEmbeddedMessage swrveEmbeddedMessage) {
        if (swrveEmbeddedMessage != null) {
            this.campaignDisplayer.setMessageMinDelayThrottle(getNow());
            this.campaignDisplayer.decrementMessagesLeftToShow();
            SwrveEmbeddedCampaign campaign = swrveEmbeddedMessage.getCampaign();
            if (campaign != null) {
                campaign.messageWasShownToUser();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("embedded", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            queueMessageImpressionEvent(swrveEmbeddedMessage, hashMap);
        }
    }

    public void _event(String str) {
        _event(str, (Map<String, String>) null);
    }

    public void _flushToDisk() {
        storageExecutorExecute(new Runnable() {
            public final void run() {
                SwrveBase.this.lambda$_flushToDisk$4$SwrveBase();
            }
        });
    }

    public String _getApiKey() {
        return this.apiKey;
    }

    public String _getAppStoreURLForApp(int i) {
        return this.appStoreURLs.get(i);
    }

    @SuppressLint({"UseSparseArrays"})
    public SwrveBaseMessage _getBaseMessageForEvent(String str, Map<String, String> map, SwrveOrientation swrveOrientation) {
        SwrveBaseMessage swrveBaseMessage;
        SwrveBaseMessage swrveBaseMessage2;
        Iterator it;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Object obj;
        String str2 = str;
        Map<String, String> map2 = map;
        SwrveOrientation swrveOrientation2 = swrveOrientation;
        Date now = getNow();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Map<String, String> retrievePersonalizationProperties = retrievePersonalizationProperties(this.lastEventPayloadUsed, (Map<String, String>) null);
        List<SwrveBaseCampaign> list = this.campaigns;
        if (list != null) {
            if (!this.campaignDisplayer.checkAppCampaignRules(list.size(), "message", str, map, now)) {
                return null;
            }
            synchronized (this.campaigns) {
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                for (SwrveBaseCampaign next : this.campaigns) {
                    if (next instanceof SwrveInAppCampaign) {
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList4;
                        obj = ((SwrveInAppCampaign) next).getMessageForEvent(str, map, now, hashMap2, retrievePersonalizationProperties);
                    } else {
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList4;
                        obj = next instanceof SwrveEmbeddedCampaign ? ((SwrveEmbeddedCampaign) next).getMessageForEvent(str2, map2, now, hashMap2) : null;
                    }
                    if (obj != null) {
                        arrayList3.add(obj);
                    }
                    arrayList4 = arrayList3;
                    arrayList5 = arrayList2;
                }
                ArrayList arrayList6 = arrayList5;
                ArrayList arrayList7 = arrayList4;
                Iterator it2 = arrayList7.iterator();
                int i = Integer.MAX_VALUE;
                while (it2.hasNext()) {
                    SwrveBaseMessage swrveBaseMessage3 = (SwrveBaseMessage) it2.next();
                    if (swrveBaseMessage3.getPriority() <= i) {
                        if (swrveBaseMessage3.getPriority() < i) {
                            arrayList6.clear();
                        }
                        i = swrveBaseMessage3.getPriority();
                        arrayList = arrayList6;
                        arrayList.add(swrveBaseMessage3);
                    } else {
                        arrayList = arrayList6;
                    }
                    arrayList6 = arrayList;
                }
                ArrayList arrayList8 = arrayList6;
                Collections.shuffle(arrayList8);
                Iterator it3 = arrayList8.iterator();
                swrveBaseMessage2 = null;
                SwrveBaseCampaign swrveBaseCampaign = null;
                while (swrveBaseCampaign == null && it3.hasNext()) {
                    SwrveBaseMessage swrveBaseMessage4 = (SwrveBaseMessage) it3.next();
                    if (swrveBaseMessage4.supportsOrientation(swrveOrientation2)) {
                        it = it3;
                        swrveBaseCampaign = swrveBaseMessage4.getCampaign();
                        swrveBaseMessage2 = swrveBaseMessage4;
                    } else if (QaUser.isLoggingEnabled()) {
                        int id = swrveBaseMessage4.getCampaign().getId();
                        hashMap.put(Integer.valueOf(id), Integer.valueOf(swrveBaseMessage4.getId()));
                        it = it3;
                        hashMap2.put(Integer.valueOf(id), new QaCampaignInfo((long) id, (long) swrveBaseMessage4.getId(), swrveBaseMessage4.getCampaign().getCampaignType(), false, "Message didn't support the given orientation: " + swrveOrientation2));
                    } else {
                        it = it3;
                    }
                    it3 = it;
                }
                if (!(!QaUser.isLoggingEnabled() || swrveBaseCampaign == null || swrveBaseMessage2 == null)) {
                    Iterator it4 = arrayList7.iterator();
                    while (it4.hasNext()) {
                        SwrveBaseMessage swrveBaseMessage5 = (SwrveBaseMessage) it4.next();
                        if (swrveBaseMessage5 != swrveBaseMessage2) {
                            int id2 = swrveBaseMessage5.getCampaign().getId();
                            if (!hashMap.containsKey(Integer.valueOf(id2))) {
                                hashMap.put(Integer.valueOf(id2), Integer.valueOf(swrveBaseMessage5.getId()));
                                hashMap2.put(Integer.valueOf(id2), new QaCampaignInfo((long) id2, (long) swrveBaseMessage5.getId(), swrveBaseMessage5.getCampaign().getCampaignType(), false, "Campaign " + swrveBaseCampaign.getId() + " was selected for display ahead of this campaign"));
                            }
                        }
                    }
                }
            }
            swrveBaseMessage = swrveBaseMessage2;
        } else {
            swrveBaseMessage = null;
        }
        QaUser.campaignTriggeredMessage(str2, map2, swrveBaseMessage != null, hashMap2);
        if (swrveBaseMessage == null) {
            SwrveLogger.m2758w("Not showing message: no candidate messages for %s", str2);
        }
        return swrveBaseMessage;
    }

    public File _getCacheDir() {
        return this.swrveAssetsManager.getStorageDir();
    }

    public C _getConfig() {
        return this.config;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: com.swrve.sdk.conversations.SwrveConversation} */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r12v2, types: [com.swrve.sdk.messaging.SwrveBaseCampaign] */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r12v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"UseSparseArrays"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.swrve.sdk.conversations.SwrveConversation _getConversationForEvent(java.lang.String r23, java.util.Map<java.lang.String, java.lang.String> r24) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            r8 = r24
            java.util.Date r9 = r22.getNow()
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.List<com.swrve.sdk.messaging.SwrveBaseCampaign> r2 = r1.campaigns
            r12 = 0
            r13 = 0
            if (r2 == 0) goto L_0x0114
            com.swrve.sdk.SwrveCampaignDisplayer r3 = r1.campaignDisplayer
            int r4 = r2.size()
            java.lang.String r5 = "conversation"
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r23
            r6 = r24
            r7 = r9
            boolean r2 = r2.checkAppCampaignRules(r3, r4, r5, r6, r7)
            if (r2 != 0) goto L_0x0031
            return r12
        L_0x0031:
            java.util.List<com.swrve.sdk.messaging.SwrveBaseCampaign> r2 = r1.campaigns
            monitor-enter(r2)
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0111 }
            r3.<init>()     // Catch:{ all -> 0x0111 }
            r4 = 2147483647(0x7fffffff, float:NaN)
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0111 }
            r5.<init>()     // Catch:{ all -> 0x0111 }
            java.util.List<com.swrve.sdk.messaging.SwrveBaseCampaign> r6 = r1.campaigns     // Catch:{ all -> 0x0111 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0111 }
        L_0x0047:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0111 }
            if (r7 == 0) goto L_0x0079
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0111 }
            com.swrve.sdk.messaging.SwrveBaseCampaign r7 = (com.swrve.sdk.messaging.SwrveBaseCampaign) r7     // Catch:{ all -> 0x0111 }
            boolean r14 = r7 instanceof com.swrve.sdk.messaging.SwrveConversationCampaign     // Catch:{ all -> 0x0111 }
            if (r14 == 0) goto L_0x0047
            com.swrve.sdk.messaging.SwrveConversationCampaign r7 = (com.swrve.sdk.messaging.SwrveConversationCampaign) r7     // Catch:{ all -> 0x0111 }
            com.swrve.sdk.conversations.SwrveConversation r7 = r7.getConversationForEvent(r0, r8, r9, r11)     // Catch:{ all -> 0x0111 }
            if (r7 == 0) goto L_0x0047
            r3.add(r7)     // Catch:{ all -> 0x0111 }
            int r14 = r7.getPriority()     // Catch:{ all -> 0x0111 }
            if (r14 > r4) goto L_0x0047
            int r14 = r7.getPriority()     // Catch:{ all -> 0x0111 }
            if (r14 >= r4) goto L_0x0071
            r5.clear()     // Catch:{ all -> 0x0111 }
        L_0x0071:
            int r4 = r7.getPriority()     // Catch:{ all -> 0x0111 }
            r5.add(r7)     // Catch:{ all -> 0x0111 }
            goto L_0x0047
        L_0x0079:
            int r4 = r5.size()     // Catch:{ all -> 0x0111 }
            if (r4 <= 0) goto L_0x0093
            java.util.Collections.shuffle(r5)     // Catch:{ all -> 0x0111 }
            java.lang.Object r4 = r5.get(r13)     // Catch:{ all -> 0x0111 }
            com.swrve.sdk.conversations.SwrveConversation r4 = (com.swrve.sdk.conversations.SwrveConversation) r4     // Catch:{ all -> 0x0111 }
            java.lang.Object r5 = r5.get(r13)     // Catch:{ all -> 0x0111 }
            com.swrve.sdk.conversations.SwrveConversation r5 = (com.swrve.sdk.conversations.SwrveConversation) r5     // Catch:{ all -> 0x0111 }
            com.swrve.sdk.messaging.SwrveConversationCampaign r12 = r5.getCampaign()     // Catch:{ all -> 0x0111 }
            goto L_0x0094
        L_0x0093:
            r4 = r12
        L_0x0094:
            boolean r5 = com.swrve.sdk.QaUser.isLoggingEnabled()     // Catch:{ all -> 0x0111 }
            if (r5 == 0) goto L_0x010e
            if (r12 == 0) goto L_0x010e
            if (r4 == 0) goto L_0x010e
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0111 }
        L_0x00a2:
            boolean r5 = r3.hasNext()     // Catch:{ all -> 0x0111 }
            if (r5 == 0) goto L_0x010e
            java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x0111 }
            com.swrve.sdk.conversations.SwrveConversation r5 = (com.swrve.sdk.conversations.SwrveConversation) r5     // Catch:{ all -> 0x0111 }
            if (r5 == r4) goto L_0x00a2
            com.swrve.sdk.messaging.SwrveConversationCampaign r6 = r5.getCampaign()     // Catch:{ all -> 0x0111 }
            int r6 = r6.getId()     // Catch:{ all -> 0x0111 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0111 }
            boolean r7 = r10.containsKey(r7)     // Catch:{ all -> 0x0111 }
            if (r7 != 0) goto L_0x00a2
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0111 }
            int r9 = r5.getId()     // Catch:{ all -> 0x0111 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0111 }
            r10.put(r7, r9)     // Catch:{ all -> 0x0111 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0111 }
            r7.<init>()     // Catch:{ all -> 0x0111 }
            java.lang.String r9 = "Campaign "
            r7.append(r9)     // Catch:{ all -> 0x0111 }
            int r9 = r12.getId()     // Catch:{ all -> 0x0111 }
            r7.append(r9)     // Catch:{ all -> 0x0111 }
            java.lang.String r9 = " was selected for display ahead of this campaign"
            r7.append(r9)     // Catch:{ all -> 0x0111 }
            java.lang.String r21 = r7.toString()     // Catch:{ all -> 0x0111 }
            com.swrve.sdk.messaging.SwrveConversationCampaign r5 = r5.getCampaign()     // Catch:{ all -> 0x0111 }
            com.swrve.sdk.conversations.SwrveConversation r5 = r5.getConversation()     // Catch:{ all -> 0x0111 }
            int r5 = r5.getId()     // Catch:{ all -> 0x0111 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0111 }
            com.swrve.sdk.QaCampaignInfo r9 = new com.swrve.sdk.QaCampaignInfo     // Catch:{ all -> 0x0111 }
            long r14 = (long) r6     // Catch:{ all -> 0x0111 }
            long r5 = (long) r5     // Catch:{ all -> 0x0111 }
            com.swrve.sdk.QaCampaignInfo$CAMPAIGN_TYPE r19 = com.swrve.sdk.QaCampaignInfo.CAMPAIGN_TYPE.CONVERSATION     // Catch:{ all -> 0x0111 }
            r20 = 0
            r15 = r14
            r14 = r9
            r17 = r5
            r14.<init>(r15, r17, r19, r20, r21)     // Catch:{ all -> 0x0111 }
            r11.put(r7, r9)     // Catch:{ all -> 0x0111 }
            goto L_0x00a2
        L_0x010e:
            monitor-exit(r2)     // Catch:{ all -> 0x0111 }
            r12 = r4
            goto L_0x0114
        L_0x0111:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0111 }
            throw r0
        L_0x0114:
            r2 = 1
            if (r12 == 0) goto L_0x0119
            r3 = 1
            goto L_0x011a
        L_0x0119:
            r3 = 0
        L_0x011a:
            com.swrve.sdk.QaUser.campaignTriggeredConversation(r0, r8, r3, r11)
            if (r12 != 0) goto L_0x0128
            java.lang.String r3 = "Not showing message: no candidate messages for %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r13] = r0
            com.swrve.sdk.SwrveLogger.m2758w(r3, r2)
        L_0x0128:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveBase._getConversationForEvent(java.lang.String, java.util.Map):com.swrve.sdk.conversations.SwrveConversation");
    }

    public JSONObject _getDeviceInfo() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ISwrveCommon.SWRVE_DEVICE_NAME, getDeviceName());
        jSONObject.put(ISwrveCommon.SWRVE_OS_VERSION, Build.VERSION.RELEASE);
        Context context = (Context) this.context.get();
        if (context != null) {
            try {
                jSONObject.put(ISwrveCommon.SWRVE_DEVICE_WIDTH, this.deviceWidth);
                jSONObject.put(ISwrveCommon.SWRVE_DEVICE_HEIGHT, this.deviceHeight);
                jSONObject.put(ISwrveCommon.SWRVE_DEVICE_DPI, (double) this.deviceDpi);
                jSONObject.put(ISwrveCommon.SWRVE_ANDROID_DEVICE_XDPI, (double) this.androidDeviceXdpi);
                jSONObject.put(ISwrveCommon.SWRVE_ANDROID_DEVICE_YDPI, (double) this.androidDeviceYdpi);
                jSONObject.put(ISwrveCommon.SWRVE_CONVERSATION_VERSION, 4);
                if (!SwrveHelper.isNullOrEmpty(this.simOperatorName)) {
                    jSONObject.put(ISwrveCommon.SWRVE_SIM_OPERATOR_NAME, this.simOperatorName);
                }
                if (!SwrveHelper.isNullOrEmpty(this.simOperatorIsoCountryCode)) {
                    jSONObject.put(ISwrveCommon.SWRVE_SIM_OPERATOR_ISO_COUNTRY, this.simOperatorIsoCountryCode);
                }
                if (!SwrveHelper.isNullOrEmpty(this.simOperatorCode)) {
                    jSONObject.put(ISwrveCommon.SWRVE_SIM_OPERATOR_CODE, this.simOperatorCode);
                }
                if (!SwrveHelper.isNullOrEmpty(this.androidId)) {
                    jSONObject.put(ISwrveCommon.SWRVE_ANDROID_ID, this.androidId);
                }
                jSONObject.put(ISwrveCommon.SWRVE_DEVICE_TYPE, SwrveHelper.getPlatformDeviceType(context));
            } catch (Exception e) {
                SwrveLogger.m2753e("Get device screen info failed", e, new Object[0]);
            }
            jSONObject.put(ISwrveCommon.SWRVE_OS, getPlatformOS(context));
            jSONObject.put(ISwrveCommon.SWRVE_LANGUAGE, this.language);
            jSONObject.put(ISwrveCommon.SWRVE_DEVICE_REGION, Locale.getDefault().getCountry());
            jSONObject.put(ISwrveCommon.SWRVE_SDK_VERSION, SwrveImp.PLATFORM + SwrveImp.version);
            jSONObject.put(ISwrveCommon.SWRVE_APP_STORE, this.config.getAppStore());
            jSONObject.put(ISwrveCommon.SWRVE_SDK_FLAVOUR, Swrve.FLAVOUR);
            String lowerCase = this.config.getInitMode().toString().toLowerCase(Locale.ENGLISH);
            if (this.config.isAutoStartLastUser()) {
                lowerCase = GeneratedOutlineSupport.outline16(lowerCase, "_auto");
            }
            jSONObject.put(ISwrveCommon.SWRVE_INIT_MODE, lowerCase);
            jSONObject.put(ISwrveCommon.SWRVE_TRACKING_STATE, this.profileManager.getTrackingState());
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            jSONObject.put(ISwrveCommon.SWRVE_TIMEZONE_NAME, gregorianCalendar.getTimeZone().getID());
            jSONObject.put(ISwrveCommon.SWRVE_UTC_OFFSET_SECONDS, gregorianCalendar.getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
            jSONObject.put(ISwrveCommon.SWRVE_INSTALL_DATE, SwrveHelper.getAppInstallTime((Context) this.context.get()));
            NotificationManagerCompat from = NotificationManagerCompat.from(context);
            boolean areNotificationsEnabled = from.areNotificationsEnabled();
            jSONObject.put(ISwrveCommon.SWRVE_NOTIFICATIONS_ENABLED, areNotificationsEnabled);
            jSONObject.put(ISwrveCommon.SWRVE_NOTIFICATIONS_IMPORTANCE, from.getImportance());
            if (areNotificationsEnabled) {
                jSONObject.put(ISwrveCommon.SWRVE_NOTIFICATIONS_BUTTONS, true);
                jSONObject.put(ISwrveCommon.SWRVE_NOTIFICATIONS_ATTACHMENT, true);
                jSONObject.put(ISwrveCommon.SWRVE_CAN_RECEIVE_AUTH_PUSH, true);
            }
        }
        extraDeviceInfo(jSONObject);
        return jSONObject;
    }

    public SwrveEmbeddedMessage _getEmbeddedMessageForId(int i) {
        List<SwrveBaseCampaign> list = this.campaigns;
        SwrveEmbeddedMessage swrveEmbeddedMessage = null;
        if (list != null && list.size() > 0) {
            synchronized (this.campaigns) {
                Iterator<SwrveBaseCampaign> it = this.campaigns.iterator();
                while (it.hasNext() && swrveEmbeddedMessage == null) {
                    SwrveBaseCampaign next = it.next();
                    if (next instanceof SwrveEmbeddedCampaign) {
                        SwrveEmbeddedMessage message = ((SwrveEmbeddedCampaign) next).getMessage();
                        if (i == message.getId()) {
                            swrveEmbeddedMessage = message;
                        }
                    }
                }
            }
        }
        if (swrveEmbeddedMessage == null) {
            SwrveLogger.m2755i("Not returning embedded message: no candidate embedded messages", new Object[0]);
        }
        return swrveEmbeddedMessage;
    }

    public Date _getInitialisedTime() {
        return this.initialisedTime;
    }

    public String _getJoined() {
        openLocalStorageConnection();
        return this.multiLayerLocalStorage.getCacheEntry(this.profileManager.getUserId(), ISwrveCommon.CACHE_USER_JOINED_TIME);
    }

    public String _getLanguage() {
        return this.language;
    }

    public SwrveMessage _getMessageForId(int i) {
        List<SwrveBaseCampaign> list = this.campaigns;
        SwrveMessage swrveMessage = null;
        if (list != null && list.size() > 0) {
            synchronized (this.campaigns) {
                Iterator<SwrveBaseCampaign> it = this.campaigns.iterator();
                while (it.hasNext() && swrveMessage == null) {
                    SwrveBaseCampaign next = it.next();
                    if (next instanceof SwrveInAppCampaign) {
                        swrveMessage = ((SwrveInAppCampaign) next).getMessageForId(i);
                    }
                }
            }
        }
        if (swrveMessage == null) {
            SwrveLogger.m2755i("Not showing messages: no candidate messages", new Object[0]);
        }
        return swrveMessage;
    }

    public String _getPersonalizedEmbeddedMessageData(SwrveEmbeddedMessage swrveEmbeddedMessage, Map<String, String> map) {
        if (swrveEmbeddedMessage == null) {
            return null;
        }
        try {
            if (swrveEmbeddedMessage.getType() == SwrveEmbeddedMessage.EMBEDDED_CAMPAIGN_TYPE.JSON) {
                return SwrveTextTemplating.applytoJSON(swrveEmbeddedMessage.getData(), map);
            }
            return SwrveTextTemplating.apply(swrveEmbeddedMessage.getData(), map);
        } catch (SwrveSDKTextTemplatingException e) {
            SwrveEmbeddedCampaign campaign = swrveEmbeddedMessage.getCampaign();
            QaUser.embeddedPersonalizationFailed(campaign.getId(), swrveEmbeddedMessage.getId(), swrveEmbeddedMessage.getData(), "Failed to resolve personalization");
            SwrveLogger.m2753e("Campaign id:%s Could not resolve, error with personalization", e, Integer.valueOf(campaign.getId()));
            return null;
        }
    }

    public String _getPersonalizedText(String str, Map<String, String> map) {
        if (str == null) {
            return null;
        }
        try {
            return SwrveTextTemplating.apply(str, map);
        } catch (SwrveSDKTextTemplatingException e) {
            SwrveLogger.m2753e("Could not resolve, error with personalization", e, new Object[0]);
            return null;
        }
    }

    public void _getRealTimeUserProperties(SwrveRealTimeUserPropertiesListener swrveRealTimeUserPropertiesListener) {
        String str;
        try {
            str = this.multiLayerLocalStorage.getSecureCacheEntryForUser(this.profileManager.getUserId(), ISwrveCommon.CACHE_REALTIME_USER_PROPERTIES, getUniqueKey(getUserId()));
        } catch (SecurityException e) {
            swrveRealTimeUserPropertiesListener.onRealTimeUserPropertiesError(e);
            str = null;
        }
        if (!SwrveHelper.isNullOrEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                HashMap hashMap = new HashMap();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        hashMap.put(next, jSONObject.getString(next));
                    } catch (Exception e2) {
                        SwrveLogger.m2753e("Could not load realtime user property for key: " + next, e2, new Object[0]);
                        swrveRealTimeUserPropertiesListener.onRealTimeUserPropertiesError(e2);
                    }
                }
                swrveRealTimeUserPropertiesListener.onRealTimeUserPropertiesSuccess(hashMap, str);
            } catch (Exception e3) {
                swrveRealTimeUserPropertiesListener.onRealTimeUserPropertiesError(e3);
            }
        }
    }

    public SwrveResourceManager _getResourceManager() {
        return this.resourceManager;
    }

    public void _getUserResources(SwrveUserResourcesListener swrveUserResourcesListener) {
        String str;
        try {
            str = this.multiLayerLocalStorage.getSecureCacheEntryForUser(this.profileManager.getUserId(), ISwrveCommon.CACHE_RESOURCES, getUniqueKey(getUserId()));
        } catch (SecurityException e) {
            SwrveLogger.m2755i("Signature for %s invalid; could not retrieve data from cache", ISwrveCommon.CACHE_RESOURCES);
            HashMap hashMap = new HashMap();
            hashMap.put("name", "Swrve.signature_invalid");
            queueEvent(this.profileManager.getUserId(), "event", hashMap, (Map<String, String>) null, false);
            swrveUserResourcesListener.onUserResourcesError(e);
            str = null;
        }
        if (!SwrveHelper.isNullOrEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                HashMap hashMap2 = new HashMap();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    hashMap2.put(jSONObject.getString(ProfileTable.Columns.COLUMN_UID), SwrveHelper.JSONToMap(jSONObject));
                }
                swrveUserResourcesListener.onUserResourcesSuccess(hashMap2, str);
            } catch (Exception e2) {
                swrveUserResourcesListener.onUserResourcesError(e2);
            }
        }
    }

    public void _getUserResourcesDiff(SwrveUserResourcesDiffListener swrveUserResourcesDiffListener) {
        restClientExecutorExecute(new Runnable(getUserId(), this, swrveUserResourcesDiffListener) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ SwrveBase f$2;
            public final /* synthetic */ SwrveUserResourcesDiffListener f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                SwrveBase.this.lambda$_getUserResourcesDiff$2$SwrveBase(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    public void _iap(int i, String str, double d, String str2) {
        iap(i, str, d, str2, new SwrveIAPRewards());
    }

    public void _identify(String str, SwrveIdentityResponse swrveIdentityResponse) {
        if (SwrveHelper.isNullOrEmpty(str)) {
            SwrveLogger.m2752d("External user id cannot be null or empty", new Object[0]);
            if (swrveIdentityResponse != null) {
                swrveIdentityResponse.onError(-1, "External user id cannot be null or empty");
                return;
            }
            return;
        }
        openLocalStorageConnection();
        if (isStarted()) {
            sendQueuedEvents();
        }
        pauseEventSending();
        SwrveUser userByExternalUserId = this.multiLayerLocalStorage.getUserByExternalUserId(str);
        if (identifyCachedUser(userByExternalUserId, swrveIdentityResponse)) {
            SwrveLogger.m2752d("Identity API call skipped, user loaded from cache. Event sending reenabled", new Object[0]);
        } else {
            identifyUnknownUser(str, swrveIdentityResponse, userByExternalUserId);
        }
    }

    public void _messageWasShownToUser(SwrveMessageFormat swrveMessageFormat) {
        if (swrveMessageFormat != null) {
            this.campaignDisplayer.setMessageMinDelayThrottle(getNow());
            this.campaignDisplayer.decrementMessagesLeftToShow();
            SwrveMessage message = swrveMessageFormat.getMessage();
            SwrveInAppCampaign campaign = message.getCampaign();
            if (campaign != null) {
                campaign.messageWasShownToUser();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("embedded", "false");
            queueMessageImpressionEvent(message, hashMap);
        }
    }

    public void _onPause() {
        SwrveLogger.m2755i("onPause", new Object[0]);
        flushToDisk();
        generateNewSessionInterval();
        saveCampaignsState(this.profileManager.getUserId());
    }

    public void _onResume(Activity activity) {
        boolean z = false;
        SwrveLogger.m2755i("onResume", new Object[0]);
        this.foregroundActivity = activity.getClass().getCanonicalName();
        if (getSessionTime() > this.lastSessionTick) {
            z = true;
        }
        if (z) {
            sessionStart();
        } else if (this.config.isSendQueuedEventsOnResume()) {
            sendQueuedEvents();
        }
        generateNewSessionInterval();
        startCampaignsAndResourcesTimer(z);
        disableAutoShowAfterDelay();
        this.campaignInfluence.processInfluenceData(getContext(), this);
        loadCampaignFromNotification();
    }

    public void _onStop(Activity activity) {
        if (this.foregroundActivity.equals(activity.getClass().getCanonicalName())) {
            this.foregroundActivity = "";
            shutdownCampaignsAndResourcesTimer();
        }
    }

    public void _purchase(String str, String str2, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("item", str);
        hashMap.put("currency", str2);
        hashMap.put("cost", Integer.toString(i));
        hashMap.put(FirebaseAnalytics.Param.QUANTITY, Integer.toString(i2));
        queueEvent(FirebaseAnalytics.Event.PURCHASE, hashMap, (Map<String, String>) null);
    }

    public void _refreshCampaignsAndResources() {
        if (!this.config.isAutoDownloadCampaignsAndResources()) {
            Date now = getNow();
            if (this.campaignsAndResourcesLastRefreshed == null || now.compareTo(new Date(this.campaignsAndResourcesLastRefreshed.getTime() + ((long) this.campaignsAndResourcesFlushFrequency.intValue()))) >= 0) {
                this.campaignsAndResourcesLastRefreshed = now;
            } else {
                SwrveLogger.m2755i("Request to retrieve campaign and user resource data was rate-limited", new Object[0]);
                return;
            }
        }
        final String userId = getUserId();
        restClientExecutorExecute(new Runnable() {
            public void run() {
                Map<String, String> contentRequestParams = SwrveBase.this.getContentRequestParams(userId);
                if (SwrveBase.this.config.isABTestDetailsEnabled()) {
                    contentRequestParams.put("ab_test_details", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
                if (!SwrveHelper.isNullOrEmpty(SwrveBase.this.campaignsAndResourcesLastETag)) {
                    contentRequestParams.put(UrlMetadataTable.Columns.ETAG, SwrveBase.this.campaignsAndResourcesLastETag);
                }
                try {
                    IRESTClient iRESTClient = SwrveBase.this.restClient;
                    iRESTClient.get(SwrveBase.this.config.getContentUrl() + SwrveImp.USER_CONTENT_ACTION, contentRequestParams, new IRESTResponseListener() {
                        public void firstRefreshFinished() {
                            SwrveBase swrveBase = SwrveBase.this;
                            if (!swrveBase.campaignsAndResourcesInitialized) {
                                swrveBase.campaignsAndResourcesInitialized = true;
                                swrveBase.lambda$downloadAssets$7$SwrveImp();
                                SwrveBase.this.invokeResourceListener();
                            }
                        }

                        public void onException(Exception exc) {
                            firstRefreshFinished();
                            SwrveLogger.m2753e("Error downloading resources and campaigns", exc, new Object[0]);
                        }

                        public void onResponse(RESTResponse rESTResponse) {
                            JSONObject optJSONObject;
                            if (rESTResponse.responseCode == 200) {
                                SharedPreferences.Editor edit = ((Context) SwrveBase.this.context.get()).getSharedPreferences(ISwrveCommon.SDK_PREFS_NAME, 0).edit();
                                String headerValue = rESTResponse.getHeaderValue(AssetDownloader.ETAG);
                                if (!SwrveHelper.isNullOrEmpty(headerValue)) {
                                    C16733 r10 = C16733.this;
                                    SwrveBase swrveBase = SwrveBase.this;
                                    swrveBase.campaignsAndResourcesLastETag = headerValue;
                                    swrveBase.multiLayerLocalStorage.setCacheEntry(userId, ISwrveCommon.CACHE_ETAG, headerValue);
                                }
                                boolean z = true;
                                try {
                                    JSONObject jSONObject = new JSONObject(rESTResponse.responseBody);
                                    if (jSONObject.toString().equals(JsonUtils.EMPTY_JSON)) {
                                        SwrveLogger.m2752d("SwrveSDK etag has not changed", new Object[0]);
                                    } else if (jSONObject.has("qa")) {
                                        SwrveLogger.m2755i("SwrveSDK You are a QA user!", new Object[0]);
                                        JSONObject jSONObject2 = jSONObject.getJSONObject("qa");
                                        boolean isResetDevice = QaUser.isResetDevice();
                                        boolean optBoolean = jSONObject2.optBoolean("reset_device_state", false);
                                        if (!isResetDevice && optBoolean) {
                                            z = false;
                                        }
                                        SwrveBase.this.updateQaUser(jSONObject2.toString());
                                    } else {
                                        SwrveBase.this.updateQaUser("");
                                    }
                                    if (jSONObject.has("flush_frequency")) {
                                        SwrveBase.this.campaignsAndResourcesFlushFrequency = Integer.valueOf(jSONObject.getInt("flush_frequency"));
                                        edit.putInt(ISwrveCommon.SDK_PREFS_KEY_FLUSH_FREQ, SwrveBase.this.campaignsAndResourcesFlushFrequency.intValue());
                                    }
                                    if (jSONObject.has("flush_refresh_delay")) {
                                        SwrveBase.this.campaignsAndResourcesFlushRefreshDelay = Integer.valueOf(jSONObject.getInt("flush_refresh_delay"));
                                        edit.putInt(ISwrveCommon.SDK_PREFS_KEY_FLUSH_DELAY, SwrveBase.this.campaignsAndResourcesFlushRefreshDelay.intValue());
                                    }
                                    if (jSONObject.has("campaigns")) {
                                        JSONObject jSONObject3 = jSONObject.getJSONObject("campaigns");
                                        SwrveBase.this.saveCampaignsInCache(jSONObject3);
                                        SwrveBase.this.loadCampaignsFromJSON(userId, jSONObject3, SwrveBase.this.campaignsState, z);
                                        SwrveBase.this.lambda$downloadAssets$7$SwrveImp();
                                        if (!(SwrveBase.this.resourceManager == null || !jSONObject3.has("ab_test_details") || (optJSONObject = jSONObject3.optJSONObject("ab_test_details")) == null)) {
                                            SwrveBase.this.resourceManager.setABTestDetailsFromJSON(optJSONObject);
                                        }
                                    }
                                    if (jSONObject.has("user_resources")) {
                                        JSONArray jSONArray = jSONObject.getJSONArray("user_resources");
                                        SwrveBase.this.resourceManager.setResourcesFromJSON(jSONArray);
                                        SwrveBase.this.saveResourcesInCache(jSONArray);
                                    }
                                    if (jSONObject.has("real_time_user_properties")) {
                                        JSONObject jSONObject4 = jSONObject.getJSONObject("real_time_user_properties");
                                        SwrveBase.this.realTimeUserProperties = SwrveHelper.JSONToMap(jSONObject4);
                                        SwrveBase.this.saveRealTimeUserPropertiesInCache(jSONObject4);
                                    }
                                    if ((jSONObject.has("user_resources") || jSONObject.has("real_time_user_properties")) && SwrveBase.this.campaignsAndResourcesInitialized) {
                                        SwrveBase.this.invokeResourceListener();
                                    }
                                } catch (JSONException e) {
                                    SwrveLogger.m2754e("SwrveSDK unable to decode user_content JSON : \"%s\".", rESTResponse.responseBody);
                                    throw e;
                                } catch (JSONException e2) {
                                    SwrveLogger.m2753e("Could not parse JSON for campaigns and resources", e2, new Object[0]);
                                }
                                edit.apply();
                            }
                            firstRefreshFinished();
                        }
                    });
                } catch (UnsupportedEncodingException e) {
                    SwrveLogger.m2753e("Could not update resources and campaigns, invalid parameters", e, new Object[0]);
                }
            }
        });
    }

    public void _sendQueuedEvents(String str, String str2, boolean z) {
        if (this.profileManager.getTrackingState() == SwrveTrackingState.EVENT_SENDING_PAUSED) {
            SwrveLogger.m2752d("SwrveSDK tracking state:EVENT_SENDING_PAUSED so cannot send events now.", new Object[0]);
        } else if (SwrveHelper.isNotNullOrEmpty(str) && SwrveHelper.isNotNullOrEmpty(str2)) {
            restClientExecutorExecute(new Runnable(str, z, str2) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ boolean f$2;
                public final /* synthetic */ String f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    SwrveBase.this.lambda$_sendQueuedEvents$3$SwrveBase(this.f$1, this.f$2, this.f$3);
                }
            });
        }
    }

    public void _sessionEnd() {
        queueEvent("session_end", (Map<String, Object>) null, (Map<String, String>) null);
    }

    public void _sessionStart() {
        restClientExecutorExecute(new Runnable(getSessionTime()) {
            public final /* synthetic */ long f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SwrveBase.this.lambda$_sessionStart$1$SwrveBase(this.f$1);
            }
        });
        SwrveSessionListener swrveSessionListener = this.sessionListener;
        if (swrveSessionListener != null) {
            swrveSessionListener.sessionStarted();
        }
    }

    public void _setConversationListener(SwrveConversationListener swrveConversationListener) {
        this.conversationListener = swrveConversationListener;
        if (swrveConversationListener != null) {
            this.eventListener = new SwrveEventListener(this, this.messageListener, swrveConversationListener, this.embeddedMessageListener);
        } else {
            this.eventListener = null;
        }
    }

    public void _setLanguage(Locale locale) {
        this.language = SwrveHelper.toLanguageTag(locale);
    }

    public void _setMessageListener(SwrveMessageListener swrveMessageListener) {
        this.messageListener = swrveMessageListener;
        if (swrveMessageListener != null) {
            this.eventListener = new SwrveEventListener(this, swrveMessageListener, this.conversationListener, this.embeddedMessageListener);
        } else {
            this.eventListener = null;
        }
    }

    public void _setResourcesListener(SwrveResourcesListener swrveResourcesListener) {
        this.resourcesListener = swrveResourcesListener;
    }

    public void _shutdown() {
        SwrveLogger.m2755i("Shutting down the SDK", new Object[0]);
        this.initialisedTime = null;
        ExecutorService executorService = this.restClientExecutor;
        if (executorService != null) {
            try {
                executorService.shutdown();
                this.restClientExecutor.awaitTermination(5, TimeUnit.SECONDS);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception occurred shutting down restClientExecutor", e, new Object[0]);
            }
        }
        ExecutorService executorService2 = this.storageExecutor;
        if (executorService2 != null) {
            try {
                executorService2.shutdown();
                this.storageExecutor.awaitTermination(5, TimeUnit.SECONDS);
            } catch (Exception e2) {
                SwrveLogger.m2753e("Exception occurred shutting down storageExecutor", e2, new Object[0]);
            }
        }
        shutdownCampaignsAndResourcesTimer();
        ExecutorService executorService3 = this.lifecycleExecutor;
        if (executorService3 != null) {
            try {
                executorService3.shutdown();
                this.lifecycleExecutor.awaitTermination(5, TimeUnit.SECONDS);
            } catch (Exception e3) {
                SwrveLogger.m2753e("Exception occurred shutting down lifecycleExecutorQueue", e3, new Object[0]);
            }
        }
        unregisterActivityLifecycleCallbacks();
    }

    public void _stopTracking() {
        this.started = false;
        this.profileManager.setTrackingState(SwrveTrackingState.STOPPED);
        queueDeviceUpdateNow(this.profileManager.getUserId(), this.profileManager.getSessionToken(), true);
        shutdownCampaignsAndResourcesTimer();
        clearAllAuthenticatedNotifications();
        Activity activityContext = getActivityContext();
        if (activityContext == null) {
            return;
        }
        if ((activityContext instanceof SwrveInAppMessageActivity) || (activityContext instanceof ConversationActivity)) {
            activityContext.finish();
        }
    }

    public void _userUpdate(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("attributes", new JSONObject(map));
            queueEvent(ISwrveCommon.BATCH_EVENT_KEY_USER, hashMap, (Map<String, String>) null);
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: JSONException when encoding user attributes. Not queueing.", e, new Object[0]);
        }
    }

    public abstract void beforeSendDeviceInfo(Context context);

    public void buttonWasPressedByUser(SwrveButton swrveButton) {
        if (isSdkReady()) {
            try {
                _buttonWasPressedByUser(swrveButton);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void clearAllAuthenticatedNotifications() {
        NotificationManager notificationManager = (NotificationManager) ((Context) this.context.get()).getSystemService(SwrveNotificationConstants.PUSH_BUNDLE);
        for (Integer intValue : this.multiLayerLocalStorage.getNotificationsAuthenticated()) {
            notificationManager.cancel(intValue.intValue());
        }
        this.multiLayerLocalStorage.deleteNotificationsAuthenticated();
    }

    public void currencyGiven(String str, double d) {
        if (isSdkReady()) {
            try {
                _currencyGiven(str, d);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void embeddedMessageButtonWasPressed(SwrveEmbeddedMessage swrveEmbeddedMessage, String str) {
        if (isSdkReady()) {
            try {
                _embeddedMessageButtonWasPressed(swrveEmbeddedMessage, str);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void embeddedMessageWasShownToUser(SwrveEmbeddedMessage swrveEmbeddedMessage) {
        if (isSdkReady()) {
            try {
                _embeddedMessageWasShownToUser(swrveEmbeddedMessage);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void enableEventSending() {
        this.profileManager.setTrackingState(SwrveTrackingState.STARTED);
        startCampaignsAndResourcesTimer(false);
        sendQueuedEvents();
    }

    public void event(String str) {
        if (isSdkReady()) {
            try {
                if (isValidEventName(str)) {
                    _event(str);
                }
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public abstract void extraDeviceInfo(JSONObject jSONObject) throws JSONException;

    public void fetchNotificationCampaigns(Set<Long> set) {
        try {
            initSwrveDeepLinkManager();
            this.swrveDeeplinkManager.fetchOfflineCampaigns(set);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception fetching notifications campaigns", e, new Object[0]);
        }
    }

    public void flushToDisk() {
        if (isSdkReady()) {
            try {
                _flushToDisk();
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public SwrveMessage getAdMesage() {
        SwrveDeeplinkManager swrveDeeplinkManager = this.swrveDeeplinkManager;
        SwrveMessage swrveMessage = swrveDeeplinkManager != null ? swrveDeeplinkManager.getSwrveMessage() : null;
        if (swrveMessage == null) {
            SwrveLogger.m2755i("Not showing messages: no candidate messages", new Object[0]);
        }
        return swrveMessage;
    }

    public String getApiKey() {
        try {
            return _getApiKey();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public int getAppId() {
        return this.appId;
    }

    public String getAppStoreURLForApp(int i) {
        if (!isSdkReady()) {
            return null;
        }
        try {
            return _getAppStoreURLForApp(i);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public /* bridge */ /* synthetic */ Set getAssetsOnDisk() {
        return super.getAssetsOnDisk();
    }

    public SwrveBaseMessage getBaseMessageForEvent(String str) {
        try {
            return getBaseMessageForEvent(str, new HashMap(), SwrveOrientation.Both);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public String getBatchURL() {
        return getEventsServer() + SwrveImp.BATCH_EVENTS_ACTION;
    }

    public File getCacheDir(Context context) {
        File cacheDir = this.config.getCacheDir();
        if (cacheDir == null) {
            return context.getCacheDir();
        }
        if (!checkPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
            if (context instanceof Activity) {
                requestPermissions((Activity) context, strArr);
            }
            cacheDir = context.getCacheDir();
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public String getCachedData(String str, String str2) {
        try {
            return new SQLiteLocalStorage((Context) this.context.get(), this.config.getDbName(), this.config.getMaxSqliteDbSize()).getSecureCacheEntryForUser(str, str2, getUniqueKey(str));
        } catch (Exception e) {
            SwrveLogger.m2753e("Error getting cached data. userId:" + str + " key:" + str2, e, new Object[0]);
            return null;
        }
    }

    public SwrveClipboardButtonListener getClipboardButtonListener() {
        SwrveInAppMessageConfig inAppMessageConfig = this.config.getInAppMessageConfig();
        if (inAppMessageConfig != null) {
            return inAppMessageConfig.getClipboardButtonListener();
        }
        return null;
    }

    public C getConfig() {
        try {
            return _getConfig();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public Map<String, String> getContentRequestParams(String str) {
        String cacheEntry = this.multiLayerLocalStorage.getCacheEntry(str, ISwrveCommon.CACHE_USER_JOINED_TIME);
        HashMap hashMap = new HashMap();
        hashMap.put("api_key", this.apiKey);
        hashMap.put(ISwrveCommon.BATCH_EVENT_KEY_USER, this.profileManager.getUserId());
        hashMap.put("app_version", this.appVersion);
        hashMap.put("joined", cacheEntry);
        hashMap.put("version", String.valueOf(9));
        hashMap.put("conversation_version", String.valueOf(4));
        hashMap.put("language", this.language);
        hashMap.put("app_store", this.config.getAppStore());
        hashMap.put("embedded_campaign_version", String.valueOf(1));
        hashMap.put("in_app_version", String.valueOf(4));
        hashMap.put("device_width", String.valueOf(this.deviceWidth));
        hashMap.put("device_height", String.valueOf(this.deviceHeight));
        hashMap.put("device_dpi", String.valueOf(this.deviceDpi));
        hashMap.put("android_device_xdpi", String.valueOf(this.androidDeviceXdpi));
        hashMap.put("android_device_ydpi", String.valueOf(this.androidDeviceYdpi));
        hashMap.put("orientation", this.config.getOrientation().toString().toLowerCase(Locale.US));
        hashMap.put("device_name", getDeviceName());
        hashMap.put("os_version", Build.VERSION.RELEASE);
        Context context = (Context) this.context.get();
        if (context != null) {
            hashMap.put("os", getPlatformOS(context));
            hashMap.put("device_type", SwrveHelper.getPlatformDeviceType(context));
        }
        return hashMap;
    }

    public String getContentURL() {
        return this.config.getContentUrl().toString();
    }

    public SwrveConversation getConversationForEvent(String str, Map<String, String> map) {
        try {
            return _getConversationForEvent(str, map);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public SwrveCustomButtonListener getCustomButtonListener() {
        SwrveInAppMessageConfig inAppMessageConfig = this.config.getInAppMessageConfig();
        if (inAppMessageConfig != null) {
            return inAppMessageConfig.getCustomButtonListener();
        }
        return null;
    }

    public NotificationChannel getDefaultNotificationChannel() {
        C c = this.config;
        if (c == null || c.getNotificationConfig() == null) {
            return null;
        }
        return this.config.getNotificationConfig().getDefaultNotificationChannel();
    }

    public String getDeviceId() {
        openLocalStorageConnection();
        return SwrveLocalStorageUtil.getDeviceId(this.multiLayerLocalStorage);
    }

    public JSONObject getDeviceInfo() {
        if (!isSdkReady()) {
            return new JSONObject();
        }
        try {
            return _getDeviceInfo();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public SwrveDismissButtonListener getDismissButtonListener() {
        SwrveInAppMessageConfig inAppMessageConfig = this.config.getInAppMessageConfig();
        if (inAppMessageConfig != null) {
            return inAppMessageConfig.getDismissButtonListener();
        }
        return null;
    }

    public SwrveEmbeddedMessage getEmbeddedMessageForId(int i) {
        try {
            return _getEmbeddedMessageForId(i);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public String getEventsServer() {
        return this.config.getEventsUrl().toString();
    }

    public String getExternalUserId() {
        if (!isSdkReady()) {
            return null;
        }
        SwrveUser userBySwrveUserId = this.multiLayerLocalStorage.getUserBySwrveUserId(getUserId());
        if (userBySwrveUserId == null) {
            return "";
        }
        return userBySwrveUserId.getExternalUserId();
    }

    public int getFlushRefreshDelay() {
        return ((Context) this.context.get()).getSharedPreferences(ISwrveCommon.SDK_PREFS_NAME, 0).getInt(ISwrveCommon.SDK_PREFS_KEY_FLUSH_DELAY, 5000);
    }

    public int getHttpTimeout() {
        return this.config.getHttpTimeout();
    }

    public Date getInitialisedTime() {
        if (!isSdkReady()) {
            return new Date();
        }
        try {
            return _getInitialisedTime();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public SwrveInstallButtonListener getInstallButtonListener() {
        SwrveInAppMessageConfig inAppMessageConfig = this.config.getInAppMessageConfig();
        if (inAppMessageConfig != null) {
            return inAppMessageConfig.getInstallButtonListener();
        }
        return null;
    }

    public String getJoined() {
        try {
            return _getJoined();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public String getLanguage() {
        try {
            return _getLanguage();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public List<SwrveBaseCampaign> getMessageCenterCampaigns(SwrveOrientation swrveOrientation, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        if (!isSdkReady()) {
            return arrayList;
        }
        Map<String, String> retrievePersonalizationProperties = retrievePersonalizationProperties((Map<String, String>) null, map);
        List<SwrveBaseCampaign> list = this.campaigns;
        if (list != null) {
            synchronized (list) {
                for (int i = 0; i < this.campaigns.size(); i++) {
                    SwrveBaseCampaign swrveBaseCampaign = this.campaigns.get(i);
                    if (swrveBaseCampaign.isMessageCenter() && swrveBaseCampaign.getStatus() != SwrveCampaignState.Status.Deleted && swrveBaseCampaign.isActive(getNow()) && swrveBaseCampaign.supportsOrientation(swrveOrientation) && swrveBaseCampaign.areAssetsReady(getAssetsOnDisk(), retrievePersonalizationProperties)) {
                        if (swrveBaseCampaign instanceof SwrveInAppCampaign) {
                            SwrveMessage message = ((SwrveInAppCampaign) swrveBaseCampaign).getMessage();
                            if (message.supportsOrientation(swrveOrientation) ? SwrveMessageTextTemplatingChecks.checkTextTemplating(message, retrievePersonalizationProperties) : true) {
                                arrayList.add(swrveBaseCampaign);
                            }
                        } else {
                            arrayList.add(swrveBaseCampaign);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public SwrveMessage getMessageForId(int i) {
        try {
            return _getMessageForId(i);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public synchronized int getNextSequenceNumber() {
        int i;
        openLocalStorageConnection();
        String cacheEntry = this.multiLayerLocalStorage.getCacheEntry(this.profileManager.getUserId(), ISwrveCommon.CACHE_SEQNUM);
        i = 1;
        if (!SwrveHelper.isNullOrEmpty(cacheEntry)) {
            i = 1 + Integer.parseInt(cacheEntry);
        }
        this.multiLayerLocalStorage.setCacheEntry(this.profileManager.getUserId(), ISwrveCommon.CACHE_SEQNUM, Integer.toString(i));
        return i;
    }

    public SwrveNotificationConfig getNotificationConfig() {
        return this.config.getNotificationConfig();
    }

    public SwrvePushNotificationListener getNotificationListener() {
        return this.config.getNotificationListener();
    }

    public /* bridge */ /* synthetic */ Date getNow() {
        return super.getNow();
    }

    public String getPersonalizedEmbeddedMessageData(SwrveEmbeddedMessage swrveEmbeddedMessage, Map<String, String> map) {
        if (!isSdkReady()) {
            return null;
        }
        try {
            return _getPersonalizedEmbeddedMessageData(swrveEmbeddedMessage, map);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public String getPersonalizedText(String str, Map<String, String> map) {
        if (!isSdkReady()) {
            return null;
        }
        try {
            return _getPersonalizedText(str, map);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public abstract String getPlatformOS(Context context);

    public void getRealTimeUserProperties(SwrveRealTimeUserPropertiesListener swrveRealTimeUserPropertiesListener) {
        if (isSdkReady()) {
            try {
                _getRealTimeUserProperties(swrveRealTimeUserPropertiesListener);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public SwrveResourceManager getResourceManager() {
        if (!isSdkReady()) {
            return new SwrveResourceManager();
        }
        try {
            return _getResourceManager();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public String getSessionKey() {
        return this.profileManager.getSessionToken();
    }

    public SwrveSilentPushListener getSilentPushListener() {
        return this.config.getSilentPushListener();
    }

    public SwrveBackgroundEventSender getSwrveBackgroundEventSender(Context context) {
        return new SwrveBackgroundEventSender(this, context);
    }

    public SwrveEventsManager getSwrveEventsManager(String str, String str2, String str3) {
        return new SwrveEventsManagerImp((Context) this.context.get(), this.config, this.restClient, str, this.appVersion, str3, str2);
    }

    public String getSwrveSDKVersion() {
        return SwrveImp.version;
    }

    public /* bridge */ /* synthetic */ String getUniqueKey(String str) {
        return super.getUniqueKey(str);
    }

    public String getUserId() {
        try {
            return this.profileManager.getUserId();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public void getUserResources(SwrveUserResourcesListener swrveUserResourcesListener) {
        if (isSdkReady()) {
            try {
                _getUserResources(swrveUserResourcesListener);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void getUserResourcesDiff(SwrveUserResourcesDiffListener swrveUserResourcesDiffListener) {
        if (isSdkReady()) {
            try {
                _getUserResourcesDiff(swrveUserResourcesDiffListener);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void handleDeeplink(Bundle bundle) {
        if (isSdkReady() && SwrveDeeplinkManager.isSwrveDeeplink(bundle)) {
            initSwrveDeepLinkManager();
            this.swrveDeeplinkManager.handleDeeplink(bundle);
        }
    }

    public void handleDeferredDeeplink(Bundle bundle) {
        if (isSdkReady() && SwrveDeeplinkManager.isSwrveDeeplink(bundle)) {
            initSwrveDeepLinkManager();
            this.swrveDeeplinkManager.handleDeferredDeeplink(bundle);
        }
    }

    public void iap(int i, String str, double d, String str2) {
        if (isSdkReady()) {
            try {
                _iap(i, str, d, str2);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void identify(String str, SwrveIdentityResponse swrveIdentityResponse) {
        if (this.config.getInitMode() != SwrveInitMode.MANAGED) {
            try {
                _identify(str, swrveIdentityResponse);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        } else {
            throw new RuntimeException("Cannot call Identify when running on SwrveInitMode.MANAGED mode");
        }
    }

    public synchronized void init(Activity activity) throws IllegalArgumentException {
        if (this.profileManager.getTrackingState() == SwrveTrackingState.STOPPED) {
            this.initialised = false;
        }
        this.profileManager.setTrackingState(SwrveTrackingState.STARTED);
        this.started = true;
        if (!this.initialised) {
            this.initialised = true;
            try {
                String userId = this.profileManager.getUserId();
                this.initialisedTime = getNow();
                this.lastSessionTick = getSessionTime();
                this.autoShowMessagesEnabled = true;
                disableAutoShowAfterDelay();
                this.appStoreURLs = new SparseArray<>();
                initCacheDir(activity);
                openLocalStorageConnection();
                beforeSendDeviceInfo((Context) this.application.get());
                if (this.resourceManager == null) {
                    this.resourceManager = new SwrveResourceManager();
                }
                initResources(userId);
                sessionStart();
                generateNewSessionInterval();
                initUserJoinedTimeAndFirstSession();
                SharedPreferences sharedPreferences = activity.getSharedPreferences(ISwrveCommon.SDK_PREFS_NAME, 0);
                String string = sharedPreferences.getString("swrve.referrer_id", (String) null);
                if (!SwrveHelper.isNullOrEmpty(string)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("swrve.referrer_id", string);
                    SwrveLogger.m2755i("Received install referrer, so sending userUpdate:%s", hashMap);
                    userUpdate(hashMap);
                    sharedPreferences.edit().remove("swrve.referrer_id").apply();
                }
                buildDeviceInfo((Context) this.application.get());
                queueDeviceUpdateNow(userId, this.profileManager.getSessionToken(), true);
                if (SwrveHelper.isNullOrEmpty(this.language)) {
                    SwrveHelper.logAndThrowException("Language needed to use in-app messages");
                } else if (SwrveHelper.isNullOrEmpty(this.config.getAppStore())) {
                    SwrveHelper.logAndThrowException("App store needed to use in-app messages");
                }
                initRealTimeUserProperties(userId);
                if (!(this.config.getInAppMessageConfig() == null || this.config.getInAppMessageConfig().getPersonalizationProvider() == null)) {
                    this.personalizationProvider = this.config.getInAppMessageConfig().getPersonalizationProvider();
                }
                initCampaigns(userId);
                if (this.messageListener == null) {
                    setDefaultMessageListener();
                }
                if (!(this.config.getEmbeddedMessageConfig() == null || this.config.getEmbeddedMessageConfig().getEmbeddedMessageListener() == null)) {
                    this.embeddedMessageListener = this.config.getEmbeddedMessageConfig().getEmbeddedMessageListener();
                }
                if (this.conversationListener == null) {
                    setConversationListener(new SwrveConversationListener() {
                        public final void onMessage(SwrveConversation swrveConversation) {
                            SwrveBase.this.lambda$init$0$SwrveBase(swrveConversation);
                        }
                    });
                }
                initABTestDetails(userId);
                this.campaignsAndResourcesFlushFrequency = Integer.valueOf(sharedPreferences.getInt(ISwrveCommon.SDK_PREFS_KEY_FLUSH_FREQ, 60000));
                this.campaignsAndResourcesFlushRefreshDelay = Integer.valueOf(getFlushRefreshDelay());
                this.campaignsAndResourcesLastETag = this.multiLayerLocalStorage.getCacheEntry(userId, ISwrveCommon.CACHE_ETAG);
                startCampaignsAndResourcesTimer(true);
                SwrveLogger.m2755i("Init finished", new Object[0]);
            } catch (Exception e) {
                SwrveLogger.m2753e("Swrve init failed", e, new Object[0]);
            }
        } else {
            return;
        }
        return;
    }

    public void initSwrveDeepLinkManager() {
        if (this.swrveDeeplinkManager == null) {
            this.swrveDeeplinkManager = new SwrveDeeplinkManager(getContentRequestParams(this.profileManager.getUserId()), (SwrveConfig) getConfig(), getContext(), this.swrveAssetsManager, this.restClient);
        }
    }

    public boolean isSdkReady() {
        if (this.profileManager.getTrackingState() == SwrveTrackingState.STOPPED) {
            SwrveLogger.m2758w("Warning: SwrveSDK is stopped and needs to be started before calling this api.", new Object[0]);
            return false;
        } else if (isStarted()) {
            return true;
        } else {
            SwrveLogger.m2758w("Warning: SwrveSDK needs to be started before calling this api.", new Object[0]);
            return false;
        }
    }

    public boolean isStarted() {
        return this.started;
    }

    public boolean isTrackingStateStopped() {
        try {
            return this.profileManager.getTrackingState() == SwrveTrackingState.STOPPED;
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return true;
        }
    }

    public /* synthetic */ void lambda$_flushToDisk$4$SwrveBase() {
        try {
            SwrveLogger.m2755i("Flushing to disk", new Object[0]);
            if (this.multiLayerLocalStorage != null) {
                this.multiLayerLocalStorage.flush();
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Flush to disk failed", e, new Object[0]);
        }
    }

    public /* synthetic */ void lambda$_getUserResourcesDiff$2$SwrveBase(String str, SwrveBase swrveBase, SwrveUserResourcesDiffListener swrveUserResourcesDiffListener) {
        SwrveUserResourcesDiffListener swrveUserResourcesDiffListener2 = swrveUserResourcesDiffListener;
        if (this.profileManager.getUserId() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("api_key", this.apiKey);
            hashMap.put(ISwrveCommon.BATCH_EVENT_KEY_USER, this.profileManager.getUserId());
            hashMap.put("app_version", this.appVersion);
            hashMap.put("joined", String.valueOf(Long.parseLong(this.multiLayerLocalStorage.getCacheEntry(str, ISwrveCommon.CACHE_USER_JOINED_TIME))));
            try {
                SwrveLogger.m2755i("Contacting AB Test server %s", this.config.getContentUrl());
                IRESTClient iRESTClient = this.restClient;
                final SwrveUserResourcesDiffListener swrveUserResourcesDiffListener3 = swrveUserResourcesDiffListener;
                iRESTClient.get(this.config.getContentUrl() + SwrveImp.USER_RESOURCES_DIFF_ACTION, hashMap, new RESTCacheResponseListener(swrveBase, this.multiLayerLocalStorage, str, ISwrveCommon.CACHE_RESOURCES_DIFF, SwrveImp.EMPTY_JSON_ARRAY) {
                    public void onException(Exception exc) {
                        SwrveLogger.m2753e("AB Test exception", exc, new Object[0]);
                        swrveUserResourcesDiffListener3.onUserResourcesDiffError(exc);
                    }

                    public void onResponseCached(int i, String str) {
                        SwrveLogger.m2755i("Got AB Test response code %s", Integer.valueOf(i));
                        if (!SwrveHelper.isNullOrEmpty(str)) {
                            SwrveBase.this.processUserResourcesDiffData(str, swrveUserResourcesDiffListener3);
                        }
                    }
                });
            } catch (Exception e) {
                SwrveLogger.m2753e("AB Test exception", e, new Object[0]);
                swrveUserResourcesDiffListener2.onUserResourcesDiffError(e);
            }
        } else {
            SwrveLogger.m2754e("Error: No user specified", new Object[0]);
            swrveUserResourcesDiffListener2.onUserResourcesDiffError(new NoUserIdSwrveException());
        }
    }

    public /* synthetic */ void lambda$_sendQueuedEvents$3$SwrveBase(String str, boolean z, String str2) {
        if (this.multiLayerLocalStorage.hasQueuedEvents(str)) {
            if (z) {
                this.eventsWereSent = true;
            }
            getSwrveEventsManager(str, getDeviceId(), str2).sendStoredEvents(this.multiLayerLocalStorage);
            return;
        }
        SwrveLogger.m2752d("SwrveSDK no event to send", new Object[0]);
    }

    public /* synthetic */ void lambda$init$0$SwrveBase(SwrveConversation swrveConversation) {
        WeakReference<Context> weakReference = this.context;
        if (weakReference != null) {
            ConversationActivity.showConversation((Context) weakReference.get(), swrveConversation, this.config.getOrientation());
            swrveConversation.getCampaign().messageWasShownToUser();
        }
    }

    public /* synthetic */ void lambda$onActivityCreated$5$SwrveBase(Activity activity) {
        if (isStarted()) {
            onCreate(activity);
        }
    }

    public /* synthetic */ void lambda$onActivityPaused$7$SwrveBase() {
        if (isStarted()) {
            onPause();
        }
    }

    public /* synthetic */ void lambda$onActivityResumed$6$SwrveBase(Activity activity) {
        if (isStarted()) {
            onResume(activity);
        }
    }

    public /* synthetic */ void lambda$onActivityStopped$8$SwrveBase(Activity activity) {
        if (isStarted()) {
            onStop(activity);
        }
    }

    public void loadCampaignFromNotification() {
        if (this.notificationSwrveCampaignId != null) {
            Bundle bundle = new Bundle();
            bundle.putString("campaign", this.notificationSwrveCampaignId);
            initSwrveDeepLinkManager();
            this.swrveDeeplinkManager.handleDeeplink(bundle);
            this.notificationSwrveCampaignId = null;
        }
    }

    public void markMessageCenterCampaignAsSeen(SwrveBaseCampaign swrveBaseCampaign) {
        if (isSdkReady() && swrveBaseCampaign != null) {
            swrveBaseCampaign.setStatus(SwrveCampaignState.Status.Seen);
            saveCampaignsState(getUserId());
        }
    }

    public void messageWasShownToUser(SwrveMessageFormat swrveMessageFormat) {
        if (isSdkReady()) {
            try {
                _messageWasShownToUser(swrveMessageFormat);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        bindToActivity(activity);
        lifecycleExecutorExecute(new Runnable(activity) {
            public final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SwrveBase.this.lambda$onActivityCreated$5$SwrveBase(this.f$1);
            }
        });
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        lifecycleExecutorExecute(new Runnable() {
            public final void run() {
                SwrveBase.this.lambda$onActivityPaused$7$SwrveBase();
            }
        });
    }

    public void onActivityResumed(Activity activity) {
        bindToActivity(activity);
        lifecycleExecutorExecute(new Runnable(activity) {
            public final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SwrveBase.this.lambda$onActivityResumed$6$SwrveBase(this.f$1);
            }
        });
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
        lifecycleExecutorExecute(new Runnable(activity) {
            public final /* synthetic */ Activity f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SwrveBase.this.lambda$onActivityStopped$8$SwrveBase(this.f$1);
            }
        });
    }

    public void onCreate(Activity activity) throws IllegalArgumentException {
        if (!this.initialised) {
            init(activity);
        }
    }

    public void onPause() {
        try {
            _onPause();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
        }
    }

    public void onResume(Activity activity) {
        try {
            _onResume(activity);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
        }
    }

    public void onStop(Activity activity) {
        try {
            _onStop(activity);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
        }
    }

    public void openLocalStorageConnection() {
        try {
            if (this.multiLayerLocalStorage == null || this.multiLayerLocalStorage.getSecondaryStorage() == null || !(this.multiLayerLocalStorage.getSecondaryStorage() instanceof SQLiteLocalStorage)) {
                this.multiLayerLocalStorage.setSecondaryStorage(new SQLiteLocalStorage((Context) this.context.get(), this.config.getDbName(), this.config.getMaxSqliteDbSize()));
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Swrve error opening database.", e, new Object[0]);
        }
    }

    public void pauseEventSending() {
        this.profileManager.setTrackingState(SwrveTrackingState.EVENT_SENDING_PAUSED);
        shutdownCampaignsAndResourcesTimer();
    }

    public void purchase(String str, String str2, int i, int i2) {
        if (isSdkReady()) {
            try {
                _purchase(str, str2, i, i2);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void queueConversationEvent(String str, String str2, String str3, int i, Map<String, String> map) {
        if (isSdkReady()) {
            if (map == null) {
                map = new HashMap<>();
            }
            Map<String, String> map2 = map;
            map2.put("event", str2);
            map2.put(ConversationActivity.EXTRA_CONVERSATION_KEY, Integer.toString(i));
            map2.put("page", str3);
            SwrveLogger.m2752d("Sending view conversation event: %s", str);
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            queueEvent(this.profileManager.getUserId(), "event", hashMap, map2, false);
        }
    }

    public void queueMessageImpressionEvent(SwrveBaseMessage swrveBaseMessage, Map<String, String> map) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Swrve.Messages.Message-");
        outline24.append(swrveBaseMessage.getId());
        outline24.append(".impression");
        String sb = outline24.toString();
        SwrveLogger.m2755i(GeneratedOutlineSupport.outline16("Sending view event: %s", sb), new Object[0]);
        HashMap hashMap = new HashMap();
        hashMap.put("name", sb);
        queueEvent(this.profileManager.getUserId(), "event", hashMap, map, false);
        saveCampaignsState(this.profileManager.getUserId());
    }

    public void queuePausedEvents() {
        synchronized (this.pausedEvents) {
            for (EventQueueItem next : this.pausedEvents) {
                queueEvent(next.userId, next.eventType, next.parameters, next.payload, next.triggerEventListener);
            }
            if (this.pausedEvents.size() > 0) {
                sendQueuedEvents();
            }
            this.pausedEvents.clear();
        }
    }

    public void refreshCampaignsAndResources() {
        if (isSdkReady()) {
            try {
                _refreshCampaignsAndResources();
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void removeMessageCenterCampaign(SwrveBaseCampaign swrveBaseCampaign) {
        if (isSdkReady() && swrveBaseCampaign != null) {
            swrveBaseCampaign.setStatus(SwrveCampaignState.Status.Deleted);
            saveCampaignsState(getUserId());
        }
    }

    public void saveEvent(String str) {
        try {
            openLocalStorageConnection();
            this.multiLayerLocalStorage.addEvent(getUserId(), str);
            this.multiLayerLocalStorage.flush();
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: Exception saving event to storage.", e, new Object[0]);
        }
    }

    public void saveNotificationAuthenticated(int i) {
        this.multiLayerLocalStorage.saveNotificationAuthenticated(i);
    }

    public void sendEventsInBackground(Context context, String str, ArrayList<String> arrayList) {
        QaUser.wrappedEvents(new ArrayList(arrayList));
        getSwrveBackgroundEventSender(context).send(str, arrayList);
    }

    public void sendQueuedEvents() {
        if (isSdkReady()) {
            try {
                _sendQueuedEvents(this.profileManager.getUserId(), this.profileManager.getSessionToken(), true);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    /* renamed from: sendSessionStart */
    public void lambda$_sessionStart$1$SwrveBase(long j) {
        List<String> createSessionStartEvent = EventHelper.createSessionStartEvent(j, getNextSequenceNumber());
        try {
            getSwrveEventsManager(this.profileManager.getUserId(), SwrveLocalStorageUtil.getDeviceId(this.multiLayerLocalStorage), this.profileManager.getSessionToken()).storeAndSendEvents(createSessionStartEvent, this.multiLayerLocalStorage.getPrimaryStorage());
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception sending session start event", e, new Object[0]);
        }
        ISwrveEventListener iSwrveEventListener = this.eventListener;
        if (iSwrveEventListener != null) {
            iSwrveEventListener.onEvent(EventHelper.getEventName("session_start", (Map<String, Object>) null), (Map<String, String>) null);
        }
        QaUser.wrappedEvents(createSessionStartEvent);
    }

    public void sessionEnd() {
        if (isSdkReady()) {
            try {
                _sessionEnd();
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void sessionStart() {
        if (isSdkReady()) {
            try {
                _sessionStart();
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void setConversationListener(SwrveConversationListener swrveConversationListener) {
        try {
            _setConversationListener(swrveConversationListener);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
        }
    }

    public void setCustomPayloadForConversationInput(Map map) {
        if (isSdkReady()) {
            SwrveConversationEventHelper.setCustomPayload(map);
        }
    }

    public void setLanguage(Locale locale) {
        try {
            _setLanguage(locale);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
        }
    }

    public void setMessageListener(SwrveMessageListener swrveMessageListener) {
        try {
            _setMessageListener(swrveMessageListener);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
        }
    }

    public void setNotificationSwrveCampaignId(String str) {
        if (isSdkReady()) {
            this.notificationSwrveCampaignId = str;
        }
    }

    public void setResourcesListener(SwrveResourcesListener swrveResourcesListener) {
        try {
            _setResourcesListener(swrveResourcesListener);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
        }
    }

    public void setSessionListener(SwrveSessionListener swrveSessionListener) {
        this.sessionListener = swrveSessionListener;
    }

    public boolean showMessageCenterCampaign(SwrveBaseCampaign swrveBaseCampaign) {
        return showMessageCenterCampaign(swrveBaseCampaign, (Map<String, String>) null);
    }

    public void shutdown() {
        try {
            _shutdown();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
        }
    }

    public void start(Activity activity) {
        if (!isStarted()) {
            this.profileManager.persistUser();
            clearAllAuthenticatedNotifications();
            init(activity);
        }
    }

    public void stopTracking() {
        try {
            _stopTracking();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
        }
    }

    public void switchUser(String str) {
        if (!isStarted() || (!SwrveHelper.isNullOrEmpty(str) && !str.equals(getUserId()))) {
            clearAllAuthenticatedNotifications();
            this.profileManager.setUserId(str);
            this.profileManager.updateSessionToken();
            if (getActivityContext() != null) {
                this.initialised = false;
                QaUser.update();
                init(getActivityContext());
                queuePausedEvents();
                return;
            }
            SwrveLogger.m2752d("Switching user before activity loaded, unable to call init", new Object[0]);
            return;
        }
        enableEventSending();
        queuePausedEvents();
    }

    public void userUpdate(Map<String, String> map) {
        if (isSdkReady()) {
            try {
                _userUpdate(map);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void _event(String str, Map<String, String> map) {
        HashMap outline28 = GeneratedOutlineSupport.outline28("name", str);
        if (map != null) {
            try {
                if (map.size() > 0) {
                    new JSONObject(map);
                }
            } catch (Exception e) {
                SwrveLogger.m2753e("SwrveSDK: JSONException when encoding payload event. Not queueing.", e, new Object[0]);
                return;
            }
        }
        queueEvent("event", outline28, map);
    }

    public boolean showMessageCenterCampaign(SwrveBaseCampaign swrveBaseCampaign, Map<String, String> map) {
        SwrveConversationListener swrveConversationListener;
        SwrveMessageListener swrveMessageListener;
        if (!isSdkReady()) {
            return false;
        }
        if (swrveBaseCampaign instanceof SwrveInAppCampaign) {
            Map<String, String> retrievePersonalizationProperties = retrievePersonalizationProperties((Map<String, String>) null, map);
            SwrveInAppCampaign swrveInAppCampaign = (SwrveInAppCampaign) swrveBaseCampaign;
            if (swrveInAppCampaign == null || swrveInAppCampaign.getMessage() == null || (swrveMessageListener = this.messageListener) == null) {
                SwrveLogger.m2754e("No in-app message or message listener.", new Object[0]);
            } else {
                swrveMessageListener.onMessage(swrveInAppCampaign.getMessage(), retrievePersonalizationProperties);
                return true;
            }
        } else if (swrveBaseCampaign instanceof SwrveConversationCampaign) {
            SwrveConversationCampaign swrveConversationCampaign = (SwrveConversationCampaign) swrveBaseCampaign;
            if (swrveConversationCampaign == null || swrveConversationCampaign.getConversation() == null || (swrveConversationListener = this.conversationListener) == null) {
                SwrveLogger.m2754e("No conversation campaign or conversation listener.", new Object[0]);
            } else {
                swrveConversationListener.onMessage(swrveConversationCampaign.getConversation());
                return true;
            }
        } else if (swrveBaseCampaign instanceof SwrveEmbeddedCampaign) {
            SwrveEmbeddedCampaign swrveEmbeddedCampaign = (SwrveEmbeddedCampaign) swrveBaseCampaign;
            if (swrveEmbeddedCampaign == null || this.embeddedMessageListener == null) {
                SwrveLogger.m2754e("No embedded message or embedded message listener.", new Object[0]);
            } else {
                this.embeddedMessageListener.onMessage(getContext(), swrveEmbeddedCampaign.getMessage(), retrievePersonalizationProperties((Map<String, String>) null, map));
                return true;
            }
        }
        return false;
    }

    public void _iap(int i, String str, double d, String str2, SwrveIAPRewards swrveIAPRewards) {
        _iap(i, str, d, str2, swrveIAPRewards, "", "", "unknown_store");
    }

    public SwrveBaseMessage getBaseMessageForEvent(String str, Map<String, String> map) {
        try {
            return _getBaseMessageForEvent(str, map, SwrveOrientation.Both);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public void iap(int i, String str, double d, String str2, SwrveIAPRewards swrveIAPRewards) {
        if (isSdkReady()) {
            try {
                _iap(i, str, d, str2, swrveIAPRewards);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void userUpdate(String str, Date date) {
        if (isSdkReady()) {
            try {
                _userUpdate(str, date);
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public void _userUpdate(String str, Date date) {
        HashMap hashMap = new HashMap();
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str, getStringFromDate(date));
            hashMap.put("attributes", new JSONObject(hashMap2));
            queueEvent(ISwrveCommon.BATCH_EVENT_KEY_USER, hashMap, (Map<String, String>) null);
        } catch (Exception e) {
            SwrveLogger.m2753e("SwrveSDK: JSONException when encoding user date attributes. Not queueing.", e, new Object[0]);
        }
    }

    public void event(String str, Map<String, String> map) {
        if (isSdkReady()) {
            try {
                if (isValidEventName(str)) {
                    _event(str, map);
                }
            } catch (Exception e) {
                SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            }
        }
    }

    public SwrveBaseMessage getBaseMessageForEvent(String str, Map<String, String> map, SwrveOrientation swrveOrientation) {
        try {
            return _getBaseMessageForEvent(str, map, swrveOrientation);
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public void start(Activity activity, String str) {
        if (this.config.getInitMode() == SwrveInitMode.AUTO) {
            throw new RuntimeException("Cannot call start method when running on SwrveInitMode.AUTO mode");
        } else if (!isStarted()) {
            this.profileManager.setUserId(str);
            this.profileManager.updateSessionToken();
            clearAllAuthenticatedNotifications();
            init(activity);
        } else {
            switchUser(str);
        }
    }

    public File getCacheDir() {
        try {
            return _getCacheDir();
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception thrown in Swrve SDK", e, new Object[0]);
            return null;
        }
    }

    public List<SwrveBaseCampaign> getMessageCenterCampaigns() {
        return getMessageCenterCampaigns(getDeviceOrientation(), (Map<String, String>) null);
    }

    public List<SwrveBaseCampaign> getMessageCenterCampaigns(SwrveOrientation swrveOrientation) {
        return getMessageCenterCampaigns(swrveOrientation, (Map<String, String>) null);
    }

    public List<SwrveBaseCampaign> getMessageCenterCampaigns(Map<String, String> map) {
        return getMessageCenterCampaigns(getDeviceOrientation(), map);
    }
}
