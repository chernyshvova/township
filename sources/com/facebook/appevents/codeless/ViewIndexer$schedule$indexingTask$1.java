package com.facebook.appevents.codeless;

import java.util.TimerTask;

/* compiled from: ViewIndexer.kt */
public final class ViewIndexer$schedule$indexingTask$1 extends TimerTask {
    public final /* synthetic */ ViewIndexer this$0;

    public ViewIndexer$schedule$indexingTask$1(ViewIndexer viewIndexer) {
        this.this$0 = viewIndexer;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x008a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            com.facebook.appevents.codeless.ViewIndexer r0 = r7.this$0     // Catch:{ Exception -> 0x00a4 }
            java.lang.ref.WeakReference r0 = com.facebook.appevents.codeless.ViewIndexer.access$getActivityReference$p(r0)     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x00a4 }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x00a4 }
            com.facebook.appevents.internal.AppEventUtility r1 = com.facebook.appevents.internal.AppEventUtility.INSTANCE     // Catch:{ Exception -> 0x00a4 }
            android.view.View r1 = com.facebook.appevents.internal.AppEventUtility.getRootView(r0)     // Catch:{ Exception -> 0x00a4 }
            if (r0 == 0) goto L_0x00a3
            if (r1 != 0) goto L_0x0018
            goto L_0x00a3
        L_0x0018:
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = "activity.javaClass.simpleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x00a4 }
            com.facebook.appevents.codeless.CodelessManager r2 = com.facebook.appevents.codeless.CodelessManager.INSTANCE     // Catch:{ Exception -> 0x00a4 }
            boolean r2 = com.facebook.appevents.codeless.CodelessManager.getIsAppIndexingEnabled$facebook_core_release()     // Catch:{ Exception -> 0x00a4 }
            if (r2 != 0) goto L_0x002e
            return
        L_0x002e:
            com.facebook.internal.InternalSettings r2 = com.facebook.internal.InternalSettings.INSTANCE     // Catch:{ Exception -> 0x00a4 }
            boolean r2 = com.facebook.internal.InternalSettings.isUnityApp()     // Catch:{ Exception -> 0x00a4 }
            if (r2 == 0) goto L_0x003c
            com.facebook.appevents.codeless.internal.UnityReflection r0 = com.facebook.appevents.codeless.internal.UnityReflection.INSTANCE     // Catch:{ Exception -> 0x00a4 }
            com.facebook.appevents.codeless.internal.UnityReflection.captureViewHierarchy()     // Catch:{ Exception -> 0x00a4 }
            return
        L_0x003c:
            java.util.concurrent.FutureTask r2 = new java.util.concurrent.FutureTask     // Catch:{ Exception -> 0x00a4 }
            com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker r3 = new com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker     // Catch:{ Exception -> 0x00a4 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00a4 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00a4 }
            com.facebook.appevents.codeless.ViewIndexer r3 = r7.this$0     // Catch:{ Exception -> 0x00a4 }
            android.os.Handler r3 = com.facebook.appevents.codeless.ViewIndexer.access$getUiThreadHandler$p(r3)     // Catch:{ Exception -> 0x00a4 }
            r3.post(r2)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r3 = ""
            r4 = 1
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x005d }
            java.lang.Object r2 = r2.get(r4, r6)     // Catch:{ Exception -> 0x005d }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x005d }
            r3 = r2
            goto L_0x0067
        L_0x005d:
            r2 = move-exception
            java.lang.String r4 = com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r5 = "Failed to take screenshot."
            android.util.Log.e(r4, r5, r2)     // Catch:{ Exception -> 0x00a4 }
        L_0x0067:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a4 }
            r2.<init>()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r4 = "screenname"
            r2.put(r4, r0)     // Catch:{ JSONException -> 0x008a }
            java.lang.String r0 = "screenshot"
            r2.put(r0, r3)     // Catch:{ JSONException -> 0x008a }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x008a }
            r0.<init>()     // Catch:{ JSONException -> 0x008a }
            com.facebook.appevents.codeless.internal.ViewHierarchy r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE     // Catch:{ JSONException -> 0x008a }
            org.json.JSONObject r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.getDictionaryOfView(r1)     // Catch:{ JSONException -> 0x008a }
            r0.put(r1)     // Catch:{ JSONException -> 0x008a }
            java.lang.String r1 = "view"
            r2.put(r1, r0)     // Catch:{ JSONException -> 0x008a }
            goto L_0x0093
        L_0x008a:
            java.lang.String r0 = com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r1 = "Failed to create JSONObject"
            android.util.Log.e(r0, r1)     // Catch:{ Exception -> 0x00a4 }
        L_0x0093:
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r1 = "viewTree.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x00a4 }
            com.facebook.appevents.codeless.ViewIndexer r1 = r7.this$0     // Catch:{ Exception -> 0x00a4 }
            com.facebook.appevents.codeless.ViewIndexer.access$sendToServer(r1, r0)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00ae
        L_0x00a3:
            return
        L_0x00a4:
            r0 = move-exception
            java.lang.String r1 = com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()
            java.lang.String r2 = "UI Component tree indexing failure!"
            android.util.Log.e(r1, r2, r0)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1.run():void");
    }
}
