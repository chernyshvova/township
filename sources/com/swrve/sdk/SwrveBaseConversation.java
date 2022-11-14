package com.swrve.sdk;

import com.swrve.sdk.conversations.engine.model.ControlBase;
import com.swrve.sdk.conversations.engine.model.ConversationPage;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class SwrveBaseConversation implements Serializable {
    public File cacheDir;

    /* renamed from: id */
    public int f2779id;
    public String name;
    public ArrayList<ConversationPage> pages;
    public int priority = 9999;

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SwrveBaseConversation(org.json.JSONObject r4, java.io.File r5) throws org.json.JSONException {
        /*
            r3 = this;
            java.lang.String r0 = "id"
            r3.<init>()
            r1 = 9999(0x270f, float:1.4012E-41)
            r3.priority = r1
            r3.cacheDir = r5
            r5 = 0
            int r1 = r4.getInt(r0)     // Catch:{ Exception -> 0x0014 }
            r3.setId(r1)     // Catch:{ Exception -> 0x0014 }
            goto L_0x002b
        L_0x0014:
            java.lang.String r0 = r4.getString(r0)     // Catch:{ Exception -> 0x0024 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0024 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0024 }
            r3.setId(r0)     // Catch:{ Exception -> 0x0024 }
            goto L_0x002b
        L_0x0024:
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = "Could not cast String into ID"
            com.swrve.sdk.SwrveLogger.m2754e(r1, r0)
        L_0x002b:
            java.lang.String r0 = "name"
            java.lang.String r0 = r4.getString(r0)
            r3.setName(r0)
            java.lang.String r0 = "pages"
            org.json.JSONArray r0 = r4.getJSONArray(r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x003f:
            int r2 = r0.length()
            if (r5 >= r2) goto L_0x0053
            org.json.JSONObject r2 = r0.getJSONObject(r5)
            com.swrve.sdk.conversations.engine.model.ConversationPage r2 = com.swrve.sdk.conversations.engine.model.ConversationPage.fromJson(r2)
            r1.add(r2)
            int r5 = r5 + 1
            goto L_0x003f
        L_0x0053:
            r3.setPages(r1)
            java.lang.String r5 = "priority"
            boolean r0 = r4.has(r5)
            if (r0 == 0) goto L_0x0065
            int r4 = r4.getInt(r5)
            r3.setPriority(r4)
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveBaseConversation.<init>(org.json.JSONObject, java.io.File):void");
    }

    public File getCacheDir() {
        return this.cacheDir;
    }

    public ConversationPage getFirstPage() {
        return this.pages.get(0);
    }

    public int getId() {
        return this.f2779id;
    }

    public String getName() {
        return this.name;
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

    public ArrayList<ConversationPage> getPages() {
        return this.pages;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setId(int i) {
        this.f2779id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPages(ArrayList<ConversationPage> arrayList) {
        this.pages = arrayList;
    }

    public void setPriority(int i) {
        this.priority = i;
    }
}
