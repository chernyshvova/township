package com.playrix.engine;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.facebook.LegacyTokenHelper;
import java.util.Map;

public class GlobalVarsMigration {

    @SuppressLint({"CommitPrefEdits"})
    public static class Entry {
        public boolean boolValue;
        public float floatValue;
        public long longValue;
        public String name;
        public String stringValue;
        public String type;
    }

    public static Entry[] getAll() {
        SharedPreferences preferences = Engine.getPreferences();
        if (preferences == null) {
            return null;
        }
        Map<String, ?> all = preferences.getAll();
        Entry[] entryArr = new Entry[all.size()];
        int i = 0;
        for (Map.Entry next : all.entrySet()) {
            Entry entry = new Entry();
            entry.name = (String) next.getKey();
            Object value = next.getValue();
            if (value != null) {
                if (value instanceof Boolean) {
                    entry.type = LegacyTokenHelper.TYPE_BOOLEAN;
                    entry.boolValue = ((Boolean) value).booleanValue();
                } else if (value instanceof Integer) {
                    entry.type = LegacyTokenHelper.TYPE_INTEGER;
                    entry.longValue = (long) ((Integer) value).intValue();
                } else if (value instanceof Long) {
                    entry.type = "int64";
                    entry.longValue = ((Long) value).longValue();
                } else if (value instanceof Float) {
                    entry.type = LegacyTokenHelper.TYPE_FLOAT;
                    entry.floatValue = ((Float) value).floatValue();
                } else if (value instanceof String) {
                    entry.type = LegacyTokenHelper.TYPE_STRING;
                    entry.stringValue = (String) value;
                }
                entryArr[i] = entry;
                i++;
            }
        }
        return entryArr;
    }

    public static boolean setAll(Entry[] entryArr) {
        SharedPreferences preferences;
        if (entryArr == null || (preferences = Engine.getPreferences()) == null) {
            return false;
        }
        SharedPreferences.Editor edit = preferences.edit();
        edit.clear();
        for (Entry entry : entryArr) {
            if (entry != null) {
                if (entry.type.equals(LegacyTokenHelper.TYPE_BOOLEAN)) {
                    edit.putBoolean(entry.name, entry.boolValue);
                } else if (entry.type.equals(LegacyTokenHelper.TYPE_INTEGER)) {
                    edit.putInt(entry.name, (int) entry.longValue);
                } else if (entry.type.equals("int64")) {
                    edit.putLong(entry.name, entry.longValue);
                } else if (entry.type.equals(LegacyTokenHelper.TYPE_FLOAT)) {
                    edit.putFloat(entry.name, entry.floatValue);
                } else if (!entry.type.equals(LegacyTokenHelper.TYPE_STRING)) {
                    return false;
                } else {
                    edit.putString(entry.name, entry.stringValue);
                }
            }
        }
        edit.apply();
        return true;
    }
}
