package com.swrve.sdk.messaging.view;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.swrve.sdk.QaUser;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.SwrveTextTemplating;
import com.swrve.sdk.config.SwrveInAppMessageConfig;
import com.swrve.sdk.exceptions.SwrveSDKTextTemplatingException;
import com.swrve.sdk.messaging.SwrveActionType;
import com.swrve.sdk.messaging.SwrveButton;
import com.swrve.sdk.messaging.SwrveMessage;
import com.swrve.sdk.messaging.SwrveMessageFormat;
import com.swrve.sdk.messaging.p036ui.SwrveInAppMessageActivity;
import java.util.Map;

public class SwrveMessageView extends RelativeLayout {
    public final SwrveInAppMessageActivity activity;
    public final SwrveMessageFormat format;
    public SwrveInAppMessageConfig inAppConfig;
    public Map<String, String> inAppPersonalization;
    public int minSampleSize = 1;
    public float scale;

    public SwrveMessageView(SwrveInAppMessageActivity swrveInAppMessageActivity, SwrveMessage swrveMessage, SwrveMessageFormat swrveMessageFormat, int i, SwrveInAppMessageConfig swrveInAppMessageConfig, Map<String, String> map) throws SwrveMessageViewBuildException {
        super(swrveInAppMessageActivity);
        this.activity = swrveInAppMessageActivity;
        this.format = swrveMessageFormat;
        if (i > 0 && i % 2 == 0) {
            this.minSampleSize = i;
        }
        this.inAppPersonalization = map;
        this.inAppConfig = swrveInAppMessageConfig;
        initializeLayout(swrveInAppMessageActivity, swrveMessage, swrveMessageFormat);
    }

    private void dismiss() {
        Context context = getContext();
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    private String resolveUrlPersonalization(String str, SwrveMessage swrveMessage, boolean z) {
        if (SwrveHelper.isNullOrEmpty(str)) {
            SwrveLogger.m2755i("cannot resolve url personalization", new Object[0]);
            return null;
        }
        try {
            String apply = SwrveTextTemplating.apply(str, this.inAppPersonalization);
            if (SwrveHelper.isNotNullOrEmpty(apply)) {
                String sha1 = SwrveHelper.sha1(apply.getBytes());
                String str2 = swrveMessage.getCacheDir().getAbsolutePath() + "/" + sha1;
                if (SwrveHelper.hasFileAccess(str2)) {
                    return str2;
                }
                SwrveLogger.m2755i("Personalized asset not found in cache: " + sha1, new Object[0]);
                QaUser.assetFailedToDisplay(swrveMessage.getCampaign().getId(), swrveMessage.getId(), sha1, str, apply, z, "Asset not found in cache");
            }
        } catch (SwrveSDKTextTemplatingException e) {
            SwrveLogger.m2753e("Cannot resolve personalized asset: ", e, new Object[0]);
            QaUser.assetFailedToDisplay(swrveMessage.getCampaign().getId(), swrveMessage.getId(), (String) null, str, (String) null, z, "Could not resolve url personalization");
        } catch (Exception e2) {
            SwrveLogger.m2753e("Cannot resolve personalized asset: ", e2, new Object[0]);
        }
        return null;
    }

    public SwrveMessageFormat getFormat() {
        return this.format;
    }

    /* JADX WARNING: type inference failed for: r3v17, types: [android.widget.ImageView, android.view.View, com.swrve.sdk.messaging.view.SwrveBaseInteractableView] */
    /* JADX WARNING: type inference failed for: r8v4, types: [com.swrve.sdk.messaging.view.SwrveImageView, androidx.appcompat.widget.AppCompatImageView] */
    /* JADX WARNING: type inference failed for: r16v4, types: [com.swrve.sdk.messaging.view.SwrvePersonalizedTextView] */
    /* JADX WARNING: type inference failed for: r16v5, types: [com.swrve.sdk.messaging.view.SwrveButtonView] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b0 A[Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ca A[Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01d5 A[Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01ef A[Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0353 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0354  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initializeLayout(android.content.Context r25, com.swrve.sdk.messaging.SwrveMessage r26, com.swrve.sdk.messaging.SwrveMessageFormat r27) throws com.swrve.sdk.messaging.view.SwrveMessageViewBuildException {
        /*
            r24 = this;
            r1 = r24
            r0 = r26
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            int r4 = com.swrve.sdk.SwrveHelper.getDisplayWidth(r25)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r5 = com.swrve.sdk.SwrveHelper.getDisplayHeight(r25)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.Integer r6 = r27.getBackgroundColor()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r6 != 0) goto L_0x0022
            com.swrve.sdk.config.SwrveInAppMessageConfig r6 = r1.inAppConfig     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r6 = r6.getDefaultBackgroundColor()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
        L_0x0022:
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r1.setBackgroundColor(r6)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            float r6 = r27.getScale()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r1.scale = r6     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            android.graphics.Point r6 = r27.getSize()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r6 = r6.x     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r1.setMinimumWidth(r6)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            android.graphics.Point r6 = r27.getSize()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r6 = r6.y     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r1.setMinimumHeight(r6)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r7 = -1
            r6.<init>(r7, r7)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r1.setLayoutParams(r6)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.util.List r6 = r27.getImages()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
        L_0x0052:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r8 = "Do not have read access to message asset for:"
            java.lang.String r9 = "Could not decode bitmap from file:"
            java.lang.String r10 = "Do not have read access to message asset for:%s"
            java.lang.String r11 = "/"
            r12 = 1
            if (r7 == 0) goto L_0x0178
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            com.swrve.sdk.messaging.SwrveImage r7 = (com.swrve.sdk.messaging.SwrveImage) r7     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r13.<init>()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.io.File r14 = r26.getCacheDir()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r14 = r14.getAbsolutePath()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r13.append(r14)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r13.append(r11)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r14 = r7.getFile()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r13.append(r14)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r14 = r7.getDynamicImageUrl()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            boolean r14 = com.swrve.sdk.SwrveHelper.isNotNullOrEmpty(r14)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r14 == 0) goto L_0x00a9
            java.lang.String r14 = r7.getDynamicImageUrl()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r15 = r7.getFile()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            boolean r15 = com.swrve.sdk.SwrveHelper.isNotNullOrEmpty(r15)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r14 = r1.resolveUrlPersonalization(r14, r0, r15)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            boolean r15 = com.swrve.sdk.SwrveHelper.isNotNullOrEmpty(r14)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r15 == 0) goto L_0x00a9
            r13 = 1
            r13 = r14
            r14 = 1
            goto L_0x00aa
        L_0x00a9:
            r14 = 0
        L_0x00aa:
            boolean r15 = com.swrve.sdk.SwrveHelper.hasFileAccess(r13)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r15 != 0) goto L_0x00ca
            java.lang.Object[] r7 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r7[r3] = r13     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            com.swrve.sdk.SwrveLogger.m2754e(r10, r7)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r7.<init>()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r7.append(r8)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r7.append(r13)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r2.add(r7)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            goto L_0x0052
        L_0x00ca:
            int r15 = r1.minSampleSize     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            com.swrve.sdk.SwrveImageScaler$BitmapResult r15 = com.swrve.sdk.SwrveImageScaler.decodeSampledBitmapFromFile(r13, r4, r5, r15)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r15 == 0) goto L_0x0166
            android.graphics.Bitmap r16 = r15.getBitmap()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r16 == 0) goto L_0x0166
            java.lang.String r8 = r7.getText()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            boolean r9 = com.swrve.sdk.SwrveHelper.isNullOrEmpty((java.lang.String) r8)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r9 == 0) goto L_0x00f1
            com.swrve.sdk.messaging.view.SwrveImageView r8 = new com.swrve.sdk.messaging.view.SwrveImageView     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r9 = r25
            r8.<init>(r9)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            android.graphics.Bitmap r10 = r15.getBitmap()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r8.setImageBitmap(r10)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            goto L_0x0112
        L_0x00f1:
            r9 = r25
            java.util.Map<java.lang.String, java.lang.String> r10 = r1.inAppPersonalization     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r20 = com.swrve.sdk.SwrveTextTemplating.apply(r8, r10)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            com.swrve.sdk.messaging.view.SwrvePersonalizedTextView r8 = new com.swrve.sdk.messaging.view.SwrvePersonalizedTextView     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            com.swrve.sdk.messaging.SwrveActionType r18 = com.swrve.sdk.messaging.SwrveActionType.Dismiss     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            com.swrve.sdk.config.SwrveInAppMessageConfig r10 = r1.inAppConfig     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r21 = r15.getWidth()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r22 = r15.getHeight()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r23 = 0
            r16 = r8
            r17 = r25
            r19 = r10
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
        L_0x0112:
            android.widget.RelativeLayout$LayoutParams r10 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r11 = r15.getWidth()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r13 = r15.getHeight()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r10.<init>(r11, r13)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            android.graphics.Point r11 = r7.getPosition()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r11 = r11.x     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r10.leftMargin = r11     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            android.graphics.Point r11 = r7.getPosition()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r11 = r11.y     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r10.topMargin = r11     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r14 == 0) goto L_0x014d
            android.graphics.Point r11 = r7.getSize()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r11 = r11.x     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r10.width = r11     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            android.graphics.Point r7 = r7.getSize()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r7 = r7.y     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r10.height = r7     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r8.setLayoutParams(r10)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            android.widget.ImageView$ScaleType r7 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r8.setScaleType(r7)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r8.setAdjustViewBounds(r12)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            goto L_0x0161
        L_0x014d:
            int r7 = r15.getWidth()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r10.width = r7     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            int r7 = r15.getHeight()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r10.height = r7     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r8.setLayoutParams(r10)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            android.widget.ImageView$ScaleType r7 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r8.setScaleType(r7)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
        L_0x0161:
            r1.addView(r8)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            goto L_0x0052
        L_0x0166:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r6.<init>()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r6.append(r9)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r6.append(r13)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r2.add(r6)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
        L_0x0178:
            java.util.List r6 = r27.getButtons()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
        L_0x0180:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r7 == 0) goto L_0x034d
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            com.swrve.sdk.messaging.SwrveButton r7 = (com.swrve.sdk.messaging.SwrveButton) r7     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r13.<init>()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.io.File r14 = r26.getCacheDir()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r14 = r14.getAbsolutePath()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r13.append(r14)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r13.append(r11)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r14 = r7.getImage()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r13.append(r14)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r14 = r7.getDynamicImageUrl()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            boolean r14 = com.swrve.sdk.SwrveHelper.isNotNullOrEmpty(r14)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r14 == 0) goto L_0x01ce
            java.lang.String r14 = r7.getDynamicImageUrl()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r15 = r7.getImage()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            boolean r15 = com.swrve.sdk.SwrveHelper.isNotNullOrEmpty(r15)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r14 = r1.resolveUrlPersonalization(r14, r0, r15)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            boolean r15 = com.swrve.sdk.SwrveHelper.isNotNullOrEmpty(r14)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r15 == 0) goto L_0x01ce
            r13 = 1
            r13 = r14
            r14 = 1
            goto L_0x01cf
        L_0x01ce:
            r14 = 0
        L_0x01cf:
            boolean r15 = com.swrve.sdk.SwrveHelper.hasFileAccess(r13)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r15 != 0) goto L_0x01ef
            java.lang.Object[] r7 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r7[r3] = r13     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            com.swrve.sdk.SwrveLogger.m2754e(r10, r7)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r7.<init>()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r7.append(r8)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r7.append(r13)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            r2.add(r7)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            goto L_0x0180
        L_0x01ef:
            int r12 = r1.minSampleSize     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            com.swrve.sdk.SwrveImageScaler$BitmapResult r12 = com.swrve.sdk.SwrveImageScaler.decodeSampledBitmapFromFile(r13, r4, r5, r12)     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r12 == 0) goto L_0x02ed
            android.graphics.Bitmap r15 = r12.getBitmap()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            if (r15 == 0) goto L_0x02ed
            java.lang.String r3 = r7.getAction()     // Catch:{ Exception -> 0x032a, OutOfMemoryError -> 0x0306 }
            com.swrve.sdk.messaging.SwrveActionType r13 = r7.getActionType()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            com.swrve.sdk.messaging.SwrveActionType r15 = com.swrve.sdk.messaging.SwrveActionType.Custom     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            if (r13 == r15) goto L_0x0211
            com.swrve.sdk.messaging.SwrveActionType r13 = r7.getActionType()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            com.swrve.sdk.messaging.SwrveActionType r15 = com.swrve.sdk.messaging.SwrveActionType.CopyToClipboard     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            if (r13 != r15) goto L_0x021d
        L_0x0211:
            boolean r13 = com.swrve.sdk.SwrveHelper.isNullOrEmpty((java.lang.String) r3)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            if (r13 != 0) goto L_0x021d
            java.util.Map<java.lang.String, java.lang.String> r13 = r1.inAppPersonalization     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            java.lang.String r3 = com.swrve.sdk.SwrveTextTemplating.apply(r3, r13)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
        L_0x021d:
            r23 = r3
            java.lang.String r3 = r7.getText()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            boolean r13 = com.swrve.sdk.SwrveHelper.isNullOrEmpty((java.lang.String) r3)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            if (r13 == 0) goto L_0x024c
            com.swrve.sdk.messaging.view.SwrveButtonView r3 = new com.swrve.sdk.messaging.view.SwrveButtonView     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            com.swrve.sdk.messaging.SwrveActionType r18 = r7.getActionType()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            com.swrve.sdk.config.SwrveInAppMessageConfig r13 = r1.inAppConfig     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            int r19 = r13.getFocusColor()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            com.swrve.sdk.config.SwrveInAppMessageConfig r13 = r1.inAppConfig     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            int r20 = r13.getClickColor()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r16 = r3
            r17 = r25
            r21 = r23
            r16.<init>(r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            android.graphics.Bitmap r13 = r12.getBitmap()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r3.setImageBitmap(r13)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            goto L_0x026f
        L_0x024c:
            java.util.Map<java.lang.String, java.lang.String> r13 = r1.inAppPersonalization     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            java.lang.String r20 = com.swrve.sdk.SwrveTextTemplating.apply(r3, r13)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            com.swrve.sdk.messaging.view.SwrvePersonalizedTextView r3 = new com.swrve.sdk.messaging.view.SwrvePersonalizedTextView     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            com.swrve.sdk.messaging.SwrveActionType r18 = r7.getActionType()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            com.swrve.sdk.config.SwrveInAppMessageConfig r13 = r1.inAppConfig     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            int r21 = r12.getWidth()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            int r22 = r12.getHeight()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r16 = r3
            r17 = r25
            r19 = r13
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r13 = 1
            r3.setFocusable(r13)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
        L_0x026f:
            java.lang.String r13 = r7.getName()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r3.setTag(r13)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            android.widget.RelativeLayout$LayoutParams r13 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            int r15 = r12.getWidth()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            int r0 = r12.getHeight()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r13.<init>(r15, r0)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            android.graphics.Point r0 = r7.getPosition()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            int r0 = r0.x     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r13.leftMargin = r0     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            android.graphics.Point r0 = r7.getPosition()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            int r0 = r0.y     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r13.topMargin = r0     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            if (r14 == 0) goto L_0x02b2
            android.graphics.Point r0 = r7.getSize()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            int r0 = r0.x     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r13.width = r0     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            android.graphics.Point r0 = r7.getSize()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            int r0 = r0.y     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r13.height = r0     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r3.setLayoutParams(r13)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r3.setScaleType(r0)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r0 = 1
            r3.setAdjustViewBounds(r0)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            goto L_0x02c6
        L_0x02b2:
            int r0 = r12.getWidth()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r13.width = r0     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            int r0 = r12.getHeight()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r13.height = r0     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r3.setLayoutParams(r13)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r3.setScaleType(r0)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
        L_0x02c6:
            com.swrve.sdk.messaging.view.-$$Lambda$SwrveMessageView$RDfXMvALXNBcMYx_bbPv3yailNE r0 = new com.swrve.sdk.messaging.view.-$$Lambda$SwrveMessageView$RDfXMvALXNBcMYx_bbPv3yailNE     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r0.<init>(r7, r3)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r3.setOnClickListener(r0)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r1.addView(r3)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            android.content.Context r0 = r24.getContext()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            java.lang.String r7 = "uimode"
            java.lang.Object r0 = r0.getSystemService(r7)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            android.app.UiModeManager r0 = (android.app.UiModeManager) r0     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            int r0 = r0.getCurrentModeType()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r7 = 4
            if (r0 != r7) goto L_0x02e7
            r3.requestFocus()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
        L_0x02e7:
            r3 = 0
            r12 = 1
            r0 = r26
            goto L_0x0180
        L_0x02ed:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r0.<init>()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r0.append(r9)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r0.append(r13)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            r2.add(r0)     // Catch:{ Exception -> 0x0303, OutOfMemoryError -> 0x0300 }
            goto L_0x034d
        L_0x0300:
            r0 = move-exception
            r3 = 0
            goto L_0x0307
        L_0x0303:
            r0 = move-exception
            r3 = 0
            goto L_0x032b
        L_0x0306:
            r0 = move-exception
        L_0x0307:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "OutOfMemoryError while initializing SwrveMessageView layout"
            com.swrve.sdk.SwrveLogger.m2753e(r4, r0, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "OutOfMemoryError while initializing SwrveMessageView layout:"
            r3.append(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.add(r0)
            r24.dismiss()
            goto L_0x034d
        L_0x032a:
            r0 = move-exception
        L_0x032b:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "Error while initializing SwrveMessageView layout"
            com.swrve.sdk.SwrveLogger.m2753e(r4, r0, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error while initializing SwrveMessageView layout:"
            r3.append(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.add(r0)
            r24.dismiss()
        L_0x034d:
            int r0 = r2.size()
            if (r0 > 0) goto L_0x0354
            return
        L_0x0354:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r3 = r2.toString()
            java.lang.String r4 = "reason"
            r0.put(r4, r3)
            r24.dismiss()
            com.swrve.sdk.messaging.view.SwrveMessageViewBuildException r0 = new com.swrve.sdk.messaging.view.SwrveMessageViewBuildException
            java.lang.String r3 = "There was an error creating the view caused by:\n"
            java.lang.StringBuilder r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r3)
            java.lang.String r2 = r2.toString()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            goto L_0x037d
        L_0x037c:
            throw r0
        L_0x037d:
            goto L_0x037c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.messaging.view.SwrveMessageView.initializeLayout(android.content.Context, com.swrve.sdk.messaging.SwrveMessage, com.swrve.sdk.messaging.SwrveMessageFormat):void");
    }

    public /* synthetic */ void lambda$initializeLayout$0$SwrveMessageView(SwrveButton swrveButton, SwrveBaseInteractableView swrveBaseInteractableView, View view) {
        try {
            dismiss();
            if (swrveButton.getActionType() == SwrveActionType.Install) {
                this.activity.notifyOfInstallButtonPress(swrveButton);
            } else if (swrveButton.getActionType() == SwrveActionType.Custom) {
                this.activity.notifyOfCustomButtonPress(swrveButton, swrveBaseInteractableView.getAction());
            } else if (swrveButton.getActionType() == SwrveActionType.CopyToClipboard) {
                this.activity.notifyOfClipboardButtonPress(swrveButton, swrveBaseInteractableView.getAction());
            } else if (swrveButton.getActionType() == SwrveActionType.Dismiss) {
                this.activity.notifyOfDismissButtonPress(swrveButton);
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Error in onClick handler.", e, new Object[0]);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            int childCount = getChildCount();
            double d = (double) i;
            double d2 = (double) (i3 - i);
            Double.isNaN(d2);
            Double.isNaN(d);
            int i5 = (int) ((d2 / 2.0d) + d);
            double d3 = (double) i2;
            double d4 = (double) (i4 - i2);
            Double.isNaN(d4);
            Double.isNaN(d3);
            int i6 = (int) ((d4 / 2.0d) + d3);
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                    int i8 = layoutParams.width / 2;
                    int i9 = layoutParams.height / 2;
                    if (this.scale != 1.0f) {
                        childAt.layout(((int) (this.scale * ((float) (layoutParams.leftMargin - i8)))) + i5, ((int) (this.scale * ((float) (layoutParams.topMargin - i9)))) + i6, ((int) (this.scale * ((float) (layoutParams.leftMargin + i8)))) + i5, ((int) (this.scale * ((float) (layoutParams.topMargin + i9)))) + i6);
                    } else {
                        childAt.layout((layoutParams.leftMargin - i8) + i5, (layoutParams.topMargin - i9) + i6, layoutParams.leftMargin + i8 + i5, layoutParams.topMargin + i9 + i6);
                    }
                }
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Error while onLayout in SwrveMessageView", e, new Object[0]);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
