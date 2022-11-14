package com.playrix.engine;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class Shortcuts {
    public static final int RESULT_FAILED = 1;
    public static final int RESULT_RATE_LIMITED = 2;
    public static final int RESULT_SUCCEED = 0;
    public static final int RESULT_UNAVAILABLE = 3;
    public static final String SCHEDULED_TASK_ADD = "add";
    public static final String SCHEDULED_TASK_REMOVE = "remove";
    public static final String SHORTCUT_DISABLED_MESSAGE_ID_KEY = "disabledMessageId";
    public static final String SHORTCUT_ICON_ID_KEY = "iconId";
    public static final String SHORTCUT_ID_INTENT_KEY = "com.playrix.engine.ShortcutId";
    public static final String SHORTCUT_ID_KEY = "id";
    public static final String SHORTCUT_LONG_LABEL_ID_KEY = "longLabelId";
    public static final String SHORTCUT_PAYLOAD_INTENT_KEY = "com.playrix.engine.ShortcutPayload";
    public static final String SHORTCUT_PAYLOAD_KEY = "payload";
    public static final String SHORTCUT_SCHEDULED_TASK_KEY = "task";
    public static final String SHORTCUT_SHORT_LABEL_ID_KEY = "shortLabelId";
    public static final String TAG = "[Shortcuts] ";
    public static String currentDisabledMessageId = null;
    public static ShortcutManager manager = null;
    public static final Scheduler scheduler = new Scheduler(Receiver.class, "Engine.Shorcuts.RequestId");
    public static int shortcutsLimit = Integer.MAX_VALUE;

    public static class Receiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            final JSONObject dataFromIntent = Scheduler.getDataFromIntent(intent);
            if (dataFromIntent != null) {
                Engine.runOnGLThread(new Runnable() {
                    public void run() {
                        int i;
                        String optString = dataFromIntent.optString(Shortcuts.SHORTCUT_SCHEDULED_TASK_KEY, (String) null);
                        if (Shortcuts.SCHEDULED_TASK_ADD.equals(optString)) {
                            i = Shortcuts.addShortcut(dataFromIntent.optString("id", (String) null), dataFromIntent.optString(Shortcuts.SHORTCUT_SHORT_LABEL_ID_KEY, (String) null), dataFromIntent.optString(Shortcuts.SHORTCUT_LONG_LABEL_ID_KEY, (String) null), dataFromIntent.optString(Shortcuts.SHORTCUT_ICON_ID_KEY, (String) null), dataFromIntent.optString("payload", (String) null));
                        } else {
                            i = Shortcuts.SCHEDULED_TASK_REMOVE.equals(optString) ? Shortcuts.disableShortcut(dataFromIntent.optString("id", (String) null)) : 1;
                        }
                        if (i != 0) {
                            StringBuilder outline27 = GeneratedOutlineSupport.outline27("[Shortcuts] Error scheduled shortcut task '", optString, "' result (");
                            outline27.append(String.valueOf(i));
                            outline27.append(") : ");
                            outline27.append(dataFromIntent.toString());
                            Logger.logError(outline27.toString());
                        }
                    }
                });
            }
        }
    }

    public static class Shortcut {
        public final String disabledMessageId;
        public final String iconId;

        /* renamed from: id */
        public final String f3611id;
        public final boolean isDynamic;
        public final boolean isEnabled;
        public final boolean isPinned;
        public final long lastChangedTimestamp;
        public final String longLabelId;
        public final String payload;
        public final String shortLabelId;

        @TargetApi(25)
        public Shortcut(ShortcutInfo shortcutInfo) {
            this.f3611id = shortcutInfo.getId();
            PersistableBundle extras = shortcutInfo.getExtras();
            if (extras != null) {
                this.shortLabelId = extras.getString(Shortcuts.SHORTCUT_SHORT_LABEL_ID_KEY, (String) null);
                this.longLabelId = extras.getString(Shortcuts.SHORTCUT_LONG_LABEL_ID_KEY, (String) null);
                this.iconId = extras.getString(Shortcuts.SHORTCUT_ICON_ID_KEY, (String) null);
                this.payload = extras.getString("payload", (String) null);
                this.disabledMessageId = extras.getString(Shortcuts.SHORTCUT_DISABLED_MESSAGE_ID_KEY, (String) null);
            } else {
                this.shortLabelId = null;
                this.longLabelId = null;
                this.iconId = null;
                this.payload = null;
                this.disabledMessageId = null;
            }
            this.lastChangedTimestamp = shortcutInfo.getLastChangedTimestamp();
            this.isDynamic = shortcutInfo.isDynamic();
            this.isPinned = shortcutInfo.isPinned();
            this.isEnabled = shortcutInfo.isEnabled();
        }
    }

    @TargetApi(25)
    public static int addShortcut(String str, String str2, String str3, String str4, String str5) {
        if (manager == null) {
            return 3;
        }
        int min = Math.min(shortcutsLimit, getMaxShortcutCount());
        if (min <= 0) {
            return 1;
        }
        try {
            ShortcutInfo createShortcutInfo = createShortcutInfo(str, str2, str3, str4, str5, (String) null);
            if (createShortcutInfo == null) {
                return 1;
            }
            int removeOldShortcuts = removeOldShortcuts(min, str);
            if (removeOldShortcuts != 0) {
                return removeOldShortcuts;
            }
            return manager.addDynamicShortcuts(Collections.singletonList(createShortcutInfo)) ? 0 : 2;
        } catch (Exception e) {
            logException("Error add shortcut '" + str + "'", e);
            return 1;
        }
    }

    @TargetApi(25)
    public static void addShortcutsToMap(List<ShortcutInfo> list, Map<String, ShortcutInfo> map) {
        for (ShortcutInfo next : list) {
            map.put(next.getId(), next);
        }
    }

    public static void cancelScheduledShortcuts() {
        scheduler.cancelAll();
    }

    @TargetApi(23)
    public static Icon createIcon(String str) {
        Context context = Engine.getContext();
        String packageName = context.getPackageName();
        int identifier = context.getResources().getIdentifier(str, "mipmap", packageName);
        if (identifier == 0 && (identifier = context.getResources().getIdentifier(str, "drawable", packageName)) == 0) {
            return null;
        }
        return Icon.createWithResource(context, identifier);
    }

    @TargetApi(25)
    public static ShortcutInfo createShortcutInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            if (TextUtils.isEmpty(str)) {
                Logger.logError("[Shortcuts] Empty shortcut id");
                return null;
            }
            String nativeLocalize = nativeLocalize(str2);
            if (TextUtils.isEmpty(nativeLocalize)) {
                Logger.logError("[Shortcuts] Can't localize shortcut label id " + str2);
                return null;
            }
            ShortcutInfo.Builder builder = new ShortcutInfo.Builder(Engine.getContext(), str);
            builder.setExtras(storeShortcutParameters(str2, str3, str4, str5, str6));
            builder.setActivity(new ComponentName(Engine.getContext(), Engine.getLaunchActivityName()));
            builder.setShortLabel(nativeLocalize);
            String nativeLocalize2 = nativeLocalize(str3);
            if (!TextUtils.isEmpty(nativeLocalize2)) {
                builder.setLongLabel(nativeLocalize2);
            }
            String nativeLocalize3 = nativeLocalize(str6);
            if (!TextUtils.isEmpty(nativeLocalize3)) {
                builder.setDisabledMessage(nativeLocalize3);
            }
            Intent createLaunchIntent = Engine.createLaunchIntent();
            createLaunchIntent.putExtra(SHORTCUT_ID_INTENT_KEY, str);
            createLaunchIntent.putExtra(SHORTCUT_PAYLOAD_INTENT_KEY, str5);
            builder.setIntent(createLaunchIntent);
            String nativeTranslateImage = nativeTranslateImage(str4);
            if (!TextUtils.isEmpty(nativeTranslateImage)) {
                Icon createIcon = createIcon(nativeTranslateImage);
                if (createIcon != null) {
                    builder.setIcon(createIcon);
                } else {
                    Logger.logError("[Shortcuts] Can't find icon with resource id " + nativeTranslateImage);
                }
            }
            return builder.build();
        } catch (Exception e) {
            logException("Error make shortcut '" + str + "'", e);
            return null;
        }
    }

    @TargetApi(25)
    public static int disableShortcut(String str) {
        return disableShortcuts(Collections.singletonList(str));
    }

    @TargetApi(25)
    public static int disableShortcuts(List<String> list) {
        if (manager == null) {
            return 3;
        }
        try {
            String nativeLocalize = nativeLocalize(currentDisabledMessageId);
            if (TextUtils.isEmpty(nativeLocalize)) {
                manager.disableShortcuts(list);
                return 0;
            }
            manager.disableShortcuts(list, nativeLocalize);
            return 0;
        } catch (Exception e) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Error disable shortcuts '");
            outline24.append(list.toString());
            outline24.append("'");
            logException(outline24.toString(), e);
            return 1;
        }
    }

    @TargetApi(25)
    public static ShortcutInfo findShortcutInfo(List<ShortcutInfo> list, String str) {
        for (ShortcutInfo next : list) {
            if (str.equals(next.getId())) {
                return next;
            }
        }
        return null;
    }

    @TargetApi(25)
    public static int getMaxShortcutCount() {
        ShortcutManager shortcutManager = manager;
        if (shortcutManager == null) {
            return 3;
        }
        try {
            return shortcutManager.getMaxShortcutCountPerActivity();
        } catch (Exception e) {
            logException("Error get max shortcut count", e);
            return 0;
        }
    }

    @TargetApi(25)
    public static Shortcut[] getShortcuts() {
        if (manager == null) {
            return new Shortcut[0];
        }
        try {
            HashMap hashMap = new HashMap();
            for (ShortcutInfo next : manager.getDynamicShortcuts()) {
                hashMap.put(next.getId(), new Shortcut(next));
            }
            for (ShortcutInfo next2 : manager.getPinnedShortcuts()) {
                hashMap.put(next2.getId(), new Shortcut(next2));
            }
            return (Shortcut[]) hashMap.values().toArray(new Shortcut[0]);
        } catch (Exception e) {
            logException("Error get shortcuts", e);
            return new Shortcut[0];
        }
    }

    public static void handleActivation(Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                final String string = extras.getString(SHORTCUT_ID_INTENT_KEY);
                final String string2 = extras.getString(SHORTCUT_PAYLOAD_INTENT_KEY);
                if (!TextUtils.isEmpty(string)) {
                    Engine.runOnGLThread(new Runnable() {
                        public void run() {
                            Shortcuts.nativeOnShortcut(string, string2);
                        }
                    });
                    intent.removeExtra(SHORTCUT_ID_INTENT_KEY);
                    intent.removeExtra(SHORTCUT_PAYLOAD_INTENT_KEY);
                }
            }
        } catch (Exception e) {
            logException("Error handleActivation", e);
        }
    }

    @TargetApi(25)
    public static boolean initialize() {
        if (Build.VERSION.SDK_INT < 25) {
            return false;
        }
        if (manager != null) {
            return true;
        }
        try {
            manager = (ShortcutManager) Engine.getContext().getSystemService("shortcut");
        } catch (Exception e) {
            logException("Error get shortcut manager", e);
        }
        if (manager == null) {
            return false;
        }
        return NativeThread.getInstance().queueInitalizeEvent(new Runnable() {
            public void run() {
                ProcessLifecycleOwner.get().getLifecycle().addObserver(new LifecycleObserver() {
                    @OnLifecycleEvent(Lifecycle.Event.ON_START)
                    public void onProcessStart() {
                        Engine.runOnGLThread(new Runnable() {
                            public void run() {
                                Shortcuts.nativeOnProcessStart();
                            }
                        });
                    }
                });
            }
        });
    }

    @TargetApi(25)
    public static boolean isRateLimitingActive() {
        ShortcutManager shortcutManager = manager;
        if (shortcutManager == null) {
            return false;
        }
        try {
            return shortcutManager.isRateLimitingActive();
        } catch (Exception e) {
            logException("Error check rate limiting", e);
            return false;
        }
    }

    public static void logException(String str, Exception exc) {
        StringBuilder outline27 = GeneratedOutlineSupport.outline27(TAG, str, " : ");
        outline27.append(exc.getMessage());
        Logger.logError(outline27.toString());
    }

    public static native String nativeLocalize(String str);

    public static native void nativeOnLocaleChanged();

    public static native void nativeOnProcessStart();

    public static native void nativeOnShortcut(String str, String str2);

    public static native String nativeTranslateImage(String str);

    public static void onLocaleChanged() {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                Shortcuts.nativeOnLocaleChanged();
            }
        });
    }

    @TargetApi(25)
    public static int removeAllShortcuts() {
        ShortcutManager shortcutManager = manager;
        if (shortcutManager == null) {
            return 3;
        }
        try {
            shortcutManager.removeAllDynamicShortcuts();
            List<ShortcutInfo> pinnedShortcuts = manager.getPinnedShortcuts();
            if (pinnedShortcuts.size() == 0) {
                return 0;
            }
            ArrayList arrayList = new ArrayList(pinnedShortcuts.size());
            for (ShortcutInfo id : pinnedShortcuts) {
                arrayList.add(id.getId());
            }
            return disableShortcuts(arrayList);
        } catch (Exception e) {
            logException("Error remove all shortcuts", e);
            return 1;
        }
    }

    @TargetApi(25)
    public static int removeOldShortcuts(int i, String str) {
        ShortcutManager shortcutManager = manager;
        if (shortcutManager == null) {
            return 3;
        }
        try {
            List<ShortcutInfo> dynamicShortcuts = shortcutManager.getDynamicShortcuts();
            int size = dynamicShortcuts.size();
            ShortcutInfo shortcutInfo = null;
            if (!TextUtils.isEmpty(str) && (shortcutInfo = findShortcutInfo(dynamicShortcuts, str)) == null) {
                size++;
            }
            if (size <= i) {
                return 0;
            }
            Collections.sort(dynamicShortcuts, new Comparator<ShortcutInfo>() {
                public int compare(ShortcutInfo shortcutInfo, ShortcutInfo shortcutInfo2) {
                    return Long.compare(shortcutInfo.getLastChangedTimestamp(), shortcutInfo2.getLastChangedTimestamp());
                }
            });
            ArrayList arrayList = new ArrayList(size);
            for (ShortcutInfo next : dynamicShortcuts) {
                if (next != shortcutInfo) {
                    arrayList.add(next.getId());
                    size--;
                    if (size <= i) {
                        break;
                    }
                }
            }
            return disableShortcuts(arrayList);
        } catch (Exception e) {
            logException("Error remove old shortcuts", e);
            return 1;
        }
    }

    @TargetApi(25)
    public static int reportShortcutUsed(String str) {
        ShortcutManager shortcutManager = manager;
        if (shortcutManager == null) {
            return 3;
        }
        try {
            shortcutManager.reportShortcutUsed(str);
            return 0;
        } catch (Exception e) {
            logException("Error report shortcut used '" + str + "'", e);
            return 1;
        }
    }

    public static int scheduleAddShortcut(long j, String str, String str2, String str3, String str4, String str5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SHORTCUT_SCHEDULED_TASK_KEY, SCHEDULED_TASK_ADD);
            jSONObject.put("id", str);
            jSONObject.put(SHORTCUT_SHORT_LABEL_ID_KEY, str2);
            jSONObject.put(SHORTCUT_LONG_LABEL_ID_KEY, str3);
            jSONObject.put(SHORTCUT_ICON_ID_KEY, str4);
            jSONObject.put("payload", str5);
            return scheduler.schedule(System.currentTimeMillis() + j, jSONObject) ^ true ? 1 : 0;
        } catch (Exception e) {
            logException("Error schedule shortcut '" + str + "'", e);
            return 1;
        }
    }

    public static int scheduleDisableShortcut(long j, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SHORTCUT_SCHEDULED_TASK_KEY, SCHEDULED_TASK_REMOVE);
            jSONObject.put("id", str);
            return scheduler.schedule(System.currentTimeMillis() + j, jSONObject) ^ true ? 1 : 0;
        } catch (Exception e) {
            logException("Error schedule shortcut '" + str + "'", e);
            return 1;
        }
    }

    public static void setDisabledMessageId(String str) {
        currentDisabledMessageId = str;
    }

    public static int setShortcutsLimit(int i) {
        shortcutsLimit = i;
        return removeOldShortcuts(Math.min(i, getMaxShortcutCount()), (String) null);
    }

    @TargetApi(21)
    public static PersistableBundle storeShortcutParameters(String str, String str2, String str3, String str4, String str5) {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(SHORTCUT_SHORT_LABEL_ID_KEY, str);
        persistableBundle.putString(SHORTCUT_LONG_LABEL_ID_KEY, str2);
        persistableBundle.putString(SHORTCUT_ICON_ID_KEY, str3);
        persistableBundle.putString("payload", str4);
        persistableBundle.putString(SHORTCUT_DISABLED_MESSAGE_ID_KEY, str5);
        return persistableBundle;
    }

    @TargetApi(25)
    public static int updateShortcuts() {
        if (manager == null) {
            return 3;
        }
        try {
            HashMap hashMap = new HashMap();
            addShortcutsToMap(manager.getDynamicShortcuts(), hashMap);
            addShortcutsToMap(manager.getPinnedShortcuts(), hashMap);
            ArrayList arrayList = new ArrayList(hashMap.size());
            for (ShortcutInfo shortcut : hashMap.values()) {
                Shortcut shortcut2 = new Shortcut(shortcut);
                ShortcutInfo createShortcutInfo = createShortcutInfo(shortcut2.f3611id, shortcut2.shortLabelId, shortcut2.longLabelId, shortcut2.iconId, shortcut2.payload, shortcut2.disabledMessageId);
                if (createShortcutInfo != null) {
                    arrayList.add(createShortcutInfo);
                } else {
                    disableShortcut(shortcut2.f3611id);
                }
            }
            if (arrayList.size() <= 0 || manager.updateShortcuts(arrayList)) {
                return 0;
            }
            return 2;
        } catch (Exception e) {
            logException("Error update shortcuts", e);
            return 1;
        }
    }
}
