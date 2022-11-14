package com.swrve.sdk;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.drive.DriveFile;
import com.swrve.sdk.notifications.model.SwrveNotification;
import com.swrve.sdk.notifications.model.SwrveNotificationButton;
import com.swrve.sdk.notifications.model.SwrveNotificationChannel;
import com.swrve.sdk.notifications.model.SwrveNotificationExpanded;
import com.swrve.sdk.notifications.model.SwrveNotificationMedia;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class SwrveNotificationBuilder {
    public static int deviceHeight;
    public static int deviceWidth;
    public String accentColorHex;
    public String campaignType;
    public final Context context;
    public NotificationChannel defaultNotificationChannel;
    public Bundle eventPayload;
    public int iconDrawableId;
    public int iconMaterialDrawableId;
    public int largeIconDrawableId;
    public final int minSampleSize = 1;
    public Bundle msg;
    public String msgText;
    public SwrveNotificationDetails notificationDetails = new SwrveNotificationDetails();
    public int notificationId;
    public String notificationTitle;
    public int requestCode;
    public SwrveNotification swrveNotification;
    public boolean usingFallbackDeeplink = false;

    /* renamed from: com.swrve.sdk.SwrveNotificationBuilder$1 */
    public static /* synthetic */ class C16871 {

        /* renamed from: $SwitchMap$com$swrve$sdk$notifications$model$SwrveNotification$VisibilityType */
        public static final /* synthetic */ int[] f2780xfe03ad73;

        /* renamed from: $SwitchMap$com$swrve$sdk$notifications$model$SwrveNotificationMedia$MediaType */
        public static final /* synthetic */ int[] f2781xac7ce701;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0023 */
        static {
            /*
                com.swrve.sdk.notifications.model.SwrveNotificationMedia$MediaType[] r0 = com.swrve.sdk.notifications.model.SwrveNotificationMedia.MediaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2781xac7ce701 = r0
                r1 = 0
                r2 = 1
                com.swrve.sdk.notifications.model.SwrveNotificationMedia$MediaType r3 = com.swrve.sdk.notifications.model.SwrveNotificationMedia.MediaType.IMAGE     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                com.swrve.sdk.notifications.model.SwrveNotification$VisibilityType[] r0 = com.swrve.sdk.notifications.model.SwrveNotification.VisibilityType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2780xfe03ad73 = r0
                com.swrve.sdk.notifications.model.SwrveNotification$VisibilityType r3 = com.swrve.sdk.notifications.model.SwrveNotification.VisibilityType.PUBLIC     // Catch:{ NoSuchFieldError -> 0x001c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r0 = 2
                int[] r1 = f2780xfe03ad73     // Catch:{ NoSuchFieldError -> 0x0023 }
                com.swrve.sdk.notifications.model.SwrveNotification$VisibilityType r3 = com.swrve.sdk.notifications.model.SwrveNotification.VisibilityType.PRIVATE     // Catch:{ NoSuchFieldError -> 0x0023 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r1 = f2780xfe03ad73     // Catch:{ NoSuchFieldError -> 0x002a }
                com.swrve.sdk.notifications.model.SwrveNotification$VisibilityType r2 = com.swrve.sdk.notifications.model.SwrveNotification.VisibilityType.SECRET     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveNotificationBuilder.C16871.<clinit>():void");
        }
    }

    public SwrveNotificationBuilder(Context context2, SwrveNotificationConfig swrveNotificationConfig) {
        this.context = context2;
        this.iconDrawableId = swrveNotificationConfig.getIconDrawableId();
        this.iconMaterialDrawableId = swrveNotificationConfig.getIconMaterialDrawableId();
        this.defaultNotificationChannel = swrveNotificationConfig.getDefaultNotificationChannel();
        this.largeIconDrawableId = swrveNotificationConfig.getLargeIconDrawableId();
        this.accentColorHex = swrveNotificationConfig.getAccentColorHex();
        this.notificationId = new Random().nextInt();
        this.requestCode = new Random().nextInt();
    }

    private void applyAccentColor(NotificationCompat.Builder builder) {
        if (!SwrveHelper.isNullOrEmpty(this.accentColorHex)) {
            try {
                builder.setColor(Color.parseColor(this.accentColorHex));
            } catch (Exception unused) {
                SwrveLogger.m2754e("Exception getting accent color for notification.", new Object[0]);
            }
        }
    }

    private NotificationCompat.Style buildDefaultStyle(SwrveNotification swrveNotification2) {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        SwrveNotificationExpanded expanded = swrveNotification2.getExpanded();
        NotificationCompat.BigTextStyle bigTextStyle2 = null;
        if (expanded != null) {
            if (SwrveHelper.isNotNullOrEmpty(expanded.getTitle())) {
                bigTextStyle.setBigContentTitle(expanded.getTitle());
                this.notificationDetails.setExpandedTitle(expanded.getTitle());
                bigTextStyle2 = bigTextStyle;
            }
            if (SwrveHelper.isNotNullOrEmpty(expanded.getBody())) {
                bigTextStyle.bigText(expanded.getBody());
                this.notificationDetails.setExpandedBody(expanded.getBody());
                return bigTextStyle;
            }
        }
        return bigTextStyle2;
    }

    private void buildLockScreen(NotificationCompat.Builder builder, SwrveNotification swrveNotification2) {
        if (Build.VERSION.SDK_INT >= 21 && SwrveHelper.isNotNullOrEmpty(swrveNotification2.getLockScreenMsg())) {
            builder.setTicker(swrveNotification2.getLockScreenMsg());
            builder.setContentText(swrveNotification2.getLockScreenMsg());
            Notification build = builder.build();
            build.visibility = 1;
            builder.setPublicVersion(build);
            builder.setTicker(this.msgText);
            if (SwrveHelper.isNotNullOrEmpty(swrveNotification2.getTicker())) {
                builder.setTicker(swrveNotification2.getTicker());
            }
            setMediaText(builder);
        }
    }

    private void buildMediaText(NotificationCompat.Builder builder) {
        NotificationCompat.Style buildNotificationStyle;
        SwrveNotificationMedia media = this.swrveNotification.getMedia();
        if (media != null && media.getType() != null && (buildNotificationStyle = buildNotificationStyle(media.getType(), Boolean.FALSE, this.swrveNotification)) != null) {
            builder.setStyle(buildNotificationStyle);
            setMediaText(builder);
            if (this.usingFallbackDeeplink) {
                this.msg.putString(SwrveNotificationInternalPayloadConstants.DEEPLINK_KEY, media.getFallbackSd());
            }
        }
    }

    private NotificationCompat.Style buildNotificationStyle(SwrveNotificationMedia.MediaType mediaType, Boolean bool, SwrveNotification swrveNotification2) {
        SwrveNotificationMedia media = swrveNotification2.getMedia();
        if (mediaType == null) {
            return null;
        }
        if (mediaType.ordinal() != 0) {
            return buildDefaultStyle(swrveNotification2);
        }
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        if (bool.booleanValue()) {
            Bitmap imageFromUrl = getImageFromUrl(media.getFallbackUrl());
            if (imageFromUrl == null) {
                return null;
            }
            bigPictureStyle.bigPicture(imageFromUrl);
            if (media.getFallbackSd() != null) {
                this.usingFallbackDeeplink = true;
            }
        } else if (!SwrveHelper.isNotNullOrEmpty(media.getUrl())) {
            return null;
        } else {
            Bitmap imageFromUrl2 = getImageFromUrl(media.getUrl());
            if (imageFromUrl2 == null) {
                return buildNotificationStyle(media.getFallbackType(), Boolean.TRUE, swrveNotification2);
            }
            bigPictureStyle.bigPicture(imageFromUrl2);
            this.notificationDetails.setMediaUrl(media.getUrl());
            this.notificationDetails.setMediaBitmap(imageFromUrl2);
        }
        SwrveNotificationExpanded expanded = swrveNotification2.getExpanded();
        if (expanded == null) {
            return bigPictureStyle;
        }
        if (SwrveHelper.isNotNullOrEmpty(expanded.getIconUrl())) {
            bigPictureStyle.bigLargeIcon(getImageFromUrl(expanded.getIconUrl()));
        }
        if (SwrveHelper.isNotNullOrEmpty(expanded.getTitle())) {
            bigPictureStyle.setBigContentTitle(expanded.getTitle());
            this.notificationDetails.setExpandedTitle(expanded.getTitle());
        }
        if (!SwrveHelper.isNotNullOrEmpty(expanded.getBody())) {
            return bigPictureStyle;
        }
        bigPictureStyle.setSummaryText(expanded.getBody());
        this.notificationDetails.setExpandedBody(expanded.getBody());
        return bigPictureStyle;
    }

    private void buildVisibility(NotificationCompat.Builder builder) {
        if (this.swrveNotification.getVisibility() != null) {
            int ordinal = this.swrveNotification.getVisibility().ordinal();
            if (ordinal == 0) {
                builder.setVisibility(1);
            } else if (ordinal == 1) {
                builder.setVisibility(0);
            } else if (ordinal != 2) {
                builder.setVisibility(1);
            } else {
                builder.setVisibility(-1);
            }
        }
    }

    private NotificationCompat.Action createNotificationAction(String str, int i, String str2, SwrveNotificationButton.ActionType actionType, String str3) {
        Intent createButtonIntent = createButtonIntent(this.context, this.msg);
        createButtonIntent.putExtra(SwrveNotificationConstants.CONTEXT_ID_KEY, str2);
        createButtonIntent.putExtra("action_type", actionType);
        createButtonIntent.putExtra(SwrveNotificationConstants.PUSH_ACTION_URL_KEY, str3);
        createButtonIntent.putExtra(SwrveNotificationConstants.BUTTON_TEXT_KEY, str);
        createButtonIntent.putExtra(SwrveNotificationConstants.EVENT_PAYLOAD, this.eventPayload);
        Context context2 = this.context;
        int i2 = this.requestCode;
        this.requestCode = i2 + 1;
        return new NotificationCompat.Action.Builder(i, (CharSequence) str, PendingIntent.getBroadcast(context2, i2, createButtonIntent, DriveFile.MODE_READ_ONLY)).build();
    }

    private String getFallbackNotificationTitle() {
        try {
            PackageManager packageManager = this.context.getPackageManager();
            CharSequence loadLabel = packageManager.getApplicationInfo(this.context.getPackageName(), 128).loadLabel(packageManager);
            if (loadLabel != null) {
                return loadLabel.toString();
            }
            return "";
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception getting fallback notification title.", e, new Object[0]);
            return "";
        }
    }

    private List<NotificationCompat.Action> getNotificationActions() {
        SwrveNotification fromJson;
        String string = this.msg.getString(SwrveNotificationInternalPayloadConstants.SWRVE_PAYLOAD_KEY);
        if (SwrveHelper.isNullOrEmpty(string) || (fromJson = SwrveNotification.fromJson(string)) == null || fromJson.getVersion() > 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<SwrveNotificationButton> buttons = fromJson.getButtons();
        if (buttons != null && !buttons.isEmpty()) {
            for (int i = 0; i < buttons.size(); i++) {
                SwrveNotificationButton swrveNotificationButton = buttons.get(i);
                arrayList.add(createNotificationAction(swrveNotificationButton.getTitle(), 0, String.valueOf(i), swrveNotificationButton.getActionType(), swrveNotificationButton.getAction()));
            }
        }
        return arrayList;
    }

    private NotificationCompat.Builder getNotificationBuilderFromSwrvePayload(NotificationCompat.Builder builder) {
        Bitmap imageFromUrl;
        if (this.swrveNotification.getVersion() > 1) {
            SwrveLogger.m2755i("Notification version is greater than version that this sdk can show. Showing default", new Object[0]);
            return builder;
        }
        if (SwrveHelper.isNotNullOrEmpty(this.swrveNotification.getTitle())) {
            this.notificationTitle = this.swrveNotification.getTitle();
            builder.setContentTitle(this.swrveNotification.getTitle());
            this.notificationDetails.setTitle(this.swrveNotification.getTitle());
        }
        if (SwrveHelper.isNotNullOrEmpty(this.swrveNotification.getSubtitle())) {
            builder.setSubText(this.swrveNotification.getSubtitle());
        }
        if (SwrveHelper.isNotNullOrEmpty(this.swrveNotification.getAccent())) {
            builder.setColor(Color.parseColor(this.swrveNotification.getAccent()));
        }
        if (SwrveHelper.isNotNullOrEmpty(this.swrveNotification.getIconUrl()) && (imageFromUrl = getImageFromUrl(this.swrveNotification.getIconUrl())) != null) {
            builder.setLargeIcon(imageFromUrl);
        }
        buildVisibility(builder);
        if (SwrveHelper.isNotNullOrEmpty(this.swrveNotification.getTicker())) {
            builder.setTicker(this.swrveNotification.getTicker());
        }
        if (this.swrveNotification.getPriority() != 0) {
            builder.setPriority(this.swrveNotification.getPriority());
        }
        NotificationCompat.Style buildDefaultStyle = buildDefaultStyle(this.swrveNotification);
        if (buildDefaultStyle != null) {
            builder.setStyle(buildDefaultStyle);
        }
        buildMediaText(builder);
        buildLockScreen(builder, this.swrveNotification);
        return builder;
    }

    @TargetApi(26)
    private String getNotificationChannelId() {
        NotificationChannel notificationChannel;
        String str = null;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.context.getSystemService(SwrveNotificationConstants.PUSH_BUNDLE);
        SwrveNotification swrveNotification2 = this.swrveNotification;
        if (swrveNotification2 != null) {
            if (SwrveHelper.isNotNullOrEmpty(swrveNotification2.getChannelId())) {
                String channelId = this.swrveNotification.getChannelId();
                if (notificationManager.getNotificationChannel(channelId) == null) {
                    SwrveLogger.m2758w("Notification channel %s from push payload does not exist, using params from payload or the default from config.", channelId);
                } else {
                    SwrveLogger.m2755i("Notification channel %s from push payload will be used instead of config.", channelId);
                    str = channelId;
                }
            }
            SwrveNotificationChannel channel = this.swrveNotification.getChannel();
            if (str == null && channel != null) {
                NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(channel.getId());
                String id = channel.getId();
                if (notificationChannel2 != null) {
                    SwrveLogger.m2755i("Notification channel %s from push payload already exists.", id);
                } else {
                    notificationManager.createNotificationChannel(new NotificationChannel(channel.getId(), channel.getName(), channel.getAndroidImportance()));
                }
                str = id;
            }
        }
        SwrveCommon.checkInstanceCreated();
        ISwrveCommon instance = SwrveCommon.getInstance();
        if (!(str != null || instance == null || (notificationChannel = this.defaultNotificationChannel) == null)) {
            if (notificationManager.getNotificationChannel(notificationChannel.getId()) == null) {
                SwrveLogger.m2755i("Notification channel from default config[%s] does not exist, creating it", this.defaultNotificationChannel.getId());
                notificationManager.createNotificationChannel(this.defaultNotificationChannel);
            }
            str = this.defaultNotificationChannel.getId();
        }
        if (str == null) {
            SwrveLogger.m2754e("Notification channel could not be found, the swrve notification cannot be shown.", new Object[0]);
        }
        return str;
    }

    private SwrveNotification parseBundle(Bundle bundle) {
        String string = bundle.getString(SwrveNotificationInternalPayloadConstants.SWRVE_PAYLOAD_KEY);
        if (!SwrveHelper.isNotNullOrEmpty(string)) {
            return null;
        }
        SwrveNotification fromJson = SwrveNotification.fromJson(string);
        if (fromJson == null || fromJson.getNotificationId() <= 0) {
            return fromJson;
        }
        this.notificationId = fromJson.getNotificationId();
        return fromJson;
    }

    private void setMediaText(NotificationCompat.Builder builder) {
        SwrveNotificationMedia media = this.swrveNotification.getMedia();
        if (media != null) {
            if (SwrveHelper.isNotNullOrEmpty(media.getTitle())) {
                this.notificationTitle = media.getTitle();
                builder.setContentTitle(media.getTitle());
                this.notificationDetails.setTitle(media.getTitle());
            }
            if (SwrveHelper.isNotNullOrEmpty(media.getSubtitle())) {
                builder.setSubText(media.getSubtitle());
            }
            if (SwrveHelper.isNotNullOrEmpty(media.getBody())) {
                builder.setContentText(media.getBody());
                this.notificationDetails.setBody(media.getBody());
                if (SwrveHelper.isNullOrEmpty(this.swrveNotification.getTicker())) {
                    builder.setTicker(media.getBody());
                }
            }
        }
    }

    public NotificationCompat.Builder build(String str, Bundle bundle, String str2, Bundle bundle2) {
        return build(str, bundle, parseBundle(bundle), str2, bundle2);
    }

    public Intent createButtonIntent(Context context2, Bundle bundle) {
        Intent intent = new Intent(context2, SwrveNotificationEngageReceiver.class);
        intent.putExtra(SwrveNotificationConstants.PUSH_BUNDLE, bundle);
        intent.putExtra("notification_id", this.notificationId);
        intent.putExtra(SwrveNotificationConstants.CAMPAIGN_TYPE, this.campaignType);
        return intent;
    }

    public Intent createIntent(Bundle bundle, String str, Bundle bundle2) {
        Intent intent = new Intent(this.context, SwrveNotificationEngageReceiver.class);
        intent.putExtra(SwrveNotificationConstants.PUSH_BUNDLE, bundle);
        intent.putExtra("notification_id", this.notificationId);
        intent.putExtra(SwrveNotificationConstants.CAMPAIGN_TYPE, str);
        intent.putExtra(SwrveNotificationConstants.EVENT_PAYLOAD, bundle2);
        return intent;
    }

    public PendingIntent createPendingIntent(Bundle bundle, String str, Bundle bundle2) {
        Intent createIntent = createIntent(bundle, str, bundle2);
        Context context2 = this.context;
        int i = this.requestCode;
        this.requestCode = i + 1;
        return PendingIntent.getBroadcast(context2, i, createIntent, DriveFile.MODE_READ_ONLY);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0093 A[SYNTHETIC, Splitter:B:31:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a2 A[SYNTHETIC, Splitter:B:38:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap downloadBitmapImageFromUrl(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "gzip"
            java.lang.String r1 = "Exception closing stream for downloading notification image."
            r2 = 1
            r3 = 0
            r4 = 0
            boolean r5 = com.swrve.sdk.SwrveHelper.isNotNullOrEmpty(r14)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            if (r5 == 0) goto L_0x001f
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r5.<init>(r14)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r5.toURI()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r6 = "Downloading notification image from: %s"
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r7[r4] = r14     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            com.swrve.sdk.SwrveLogger.m2755i(r6, r7)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            goto L_0x0020
        L_0x001f:
            r5 = r3
        L_0x0020:
            if (r5 == 0) goto L_0x0075
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r5.setDoInput(r2)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            com.swrve.sdk.ISwrveCommon r6 = com.swrve.sdk.SwrveCommon.getInstance()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            int r6 = r6.getHttpTimeout()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r5.setConnectTimeout(r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r6 = "Accept-Encoding"
            r5.setRequestProperty(r6, r0)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r5.connect()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            com.swrve.sdk.rest.SwrveFilterInputStream r6 = new com.swrve.sdk.rest.SwrveFilterInputStream     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.io.InputStream r7 = r5.getInputStream()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r5 = r5.getContentEncoding()     // Catch:{ Exception -> 0x0073 }
            if (r5 == 0) goto L_0x005f
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0073 }
            java.lang.String r5 = r5.toLowerCase(r7)     // Catch:{ Exception -> 0x0073 }
            boolean r0 = r5.contains(r0)     // Catch:{ Exception -> 0x0073 }
            if (r0 == 0) goto L_0x005f
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x0073 }
            r0.<init>(r6)     // Catch:{ Exception -> 0x0073 }
            r6 = r0
        L_0x005f:
            int r8 = deviceWidth     // Catch:{ Exception -> 0x0073 }
            int r9 = deviceHeight     // Catch:{ Exception -> 0x0073 }
            r10 = 1
            android.content.Context r0 = r13.context     // Catch:{ Exception -> 0x0073 }
            java.io.File r12 = r0.getCacheDir()     // Catch:{ Exception -> 0x0073 }
            r7 = r6
            r11 = r14
            android.graphics.Bitmap r3 = com.swrve.sdk.SwrveImageScaler.decodeSampledBitmapFromStream(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0073 }
            r14 = r3
            r3 = r6
            goto L_0x0076
        L_0x0073:
            r0 = move-exception
            goto L_0x0088
        L_0x0075:
            r14 = r3
        L_0x0076:
            if (r3 == 0) goto L_0x0082
            r3.close()     // Catch:{ Exception -> 0x007c }
            goto L_0x0082
        L_0x007c:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r4]
            com.swrve.sdk.SwrveLogger.m2753e(r1, r0, r2)
        L_0x0082:
            r3 = r14
            goto L_0x009d
        L_0x0084:
            r14 = move-exception
            goto L_0x00a0
        L_0x0086:
            r0 = move-exception
            r6 = r3
        L_0x0088:
            java.lang.String r5 = "Exception downloading notification image:%s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x009e }
            r2[r4] = r14     // Catch:{ all -> 0x009e }
            com.swrve.sdk.SwrveLogger.m2753e(r5, r0, r2)     // Catch:{ all -> 0x009e }
            if (r6 == 0) goto L_0x009d
            r6.close()     // Catch:{ Exception -> 0x0097 }
            goto L_0x009d
        L_0x0097:
            r14 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r4]
            com.swrve.sdk.SwrveLogger.m2753e(r1, r14, r0)
        L_0x009d:
            return r3
        L_0x009e:
            r14 = move-exception
            r3 = r6
        L_0x00a0:
            if (r3 == 0) goto L_0x00ac
            r3.close()     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00ac
        L_0x00a6:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r4]
            com.swrve.sdk.SwrveLogger.m2753e(r1, r0, r2)
        L_0x00ac:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.SwrveNotificationBuilder.downloadBitmapImageFromUrl(java.lang.String):android.graphics.Bitmap");
    }

    public Bitmap getImageFromCache(String str) {
        try {
            File file = new File(SwrveCommon.getInstance().getCacheDir(this.context), SwrveHelper.md5(str.toLowerCase(Locale.ENGLISH)));
            if (!file.exists() || !file.canRead()) {
                return null;
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
            SwrveLogger.m2756v("Using cached notification image:%s", str);
            return decodeFile;
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception trying to get notification image from cache.", e, new Object[0]);
            return null;
        }
    }

    public Bitmap getImageFromUrl(String str) {
        Bitmap imageFromCache = getImageFromCache(str);
        return imageFromCache == null ? downloadBitmapImageFromUrl(str) : imageFromCache;
    }

    public SwrveNotificationDetails getNotificationDetails() {
        return this.notificationDetails;
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    public Date getNow() {
        return new Date();
    }

    public NotificationCompat.Builder build(String str, Bundle bundle, SwrveNotification swrveNotification2, String str2, Bundle bundle2) {
        int i;
        Uri uri;
        this.msgText = str;
        this.msg = bundle;
        this.swrveNotification = swrveNotification2;
        this.campaignType = str2;
        this.eventPayload = bundle2;
        if (deviceWidth == 0 && deviceHeight == 0) {
            deviceWidth = SwrveHelper.getDisplayWidth(this.context);
            int displayHeight = SwrveHelper.getDisplayHeight(this.context);
            deviceHeight = displayHeight;
            int i2 = deviceWidth;
            if (i2 > displayHeight) {
                deviceWidth = displayHeight;
                deviceHeight = i2;
            }
        }
        if (!(Build.VERSION.SDK_INT >= 21) || (i = this.iconMaterialDrawableId) < 0) {
            i = this.iconDrawableId;
        }
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this.context, getNotificationChannelId()).setSmallIcon(i).setStyle(new NotificationCompat.BigTextStyle().bigText(this.msgText)).setTicker(this.msgText).setContentText(this.msgText).setAutoCancel(true);
        this.notificationDetails.setBody(this.msgText);
        if (this.largeIconDrawableId >= 0) {
            autoCancel.setLargeIcon(BitmapFactory.decodeResource(this.context.getResources(), this.largeIconDrawableId));
        }
        applyAccentColor(autoCancel);
        String string = bundle.getString("sound");
        if (!SwrveHelper.isNullOrEmpty(string)) {
            if (string.equalsIgnoreCase("default")) {
                uri = RingtoneManager.getDefaultUri(2);
            } else {
                String packageName = this.context.getApplicationContext().getPackageName();
                uri = Uri.parse("android.resource://" + packageName + "/raw/" + string);
            }
            autoCancel.setSound(uri);
        }
        if (swrveNotification2 != null) {
            autoCancel = getNotificationBuilderFromSwrvePayload(autoCancel);
        }
        List<NotificationCompat.Action> notificationActions = getNotificationActions();
        if (notificationActions != null && notificationActions.size() > 0) {
            for (NotificationCompat.Action addAction : notificationActions) {
                autoCancel.addAction(addAction);
            }
        }
        if (SwrveHelper.isNullOrEmpty(this.notificationTitle)) {
            String fallbackNotificationTitle = getFallbackNotificationTitle();
            SwrveLogger.m2752d("No notification title in configured from server payload so using app name:%s", fallbackNotificationTitle);
            autoCancel.setContentTitle(fallbackNotificationTitle);
            this.notificationDetails.setTitle(fallbackNotificationTitle);
        }
        autoCancel.setContentIntent(createPendingIntent(bundle, str2, bundle2));
        return autoCancel;
    }
}
