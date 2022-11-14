package com.helpshift.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    public static final int MAX_WILDCARD_COUNT = 900;

    public static <T> List<List<T>> createBatches(int i, List<T> list) {
        ArrayList arrayList = new ArrayList();
        if (i > list.size()) {
            arrayList.add(list);
        } else {
            int i2 = 0;
            int i3 = i;
            while (i3 <= list.size() && i2 <= i3) {
                List<T> subList = list.subList(i2, i3);
                i2 += i;
                i3 = Math.min(subList.size() + i3, list.size());
                if (subList.size() > 0) {
                    arrayList.add(subList);
                }
            }
        }
        return arrayList;
    }

    public static boolean exists(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) FROM ");
        sb.append(str);
        sb.append(" WHERE ");
        sb.append(str2);
        sb.append(" LIMIT 1");
        return android.database.DatabaseUtils.longForQuery(sQLiteDatabase, sb.toString(), strArr) > 0;
    }

    public static String makePlaceholders(int i) {
        if (i < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder((i * 2) - 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static boolean parseBooleanColumnSafe(Cursor cursor, String str, boolean z) {
        Boolean parseBooleanColumnSafe = parseBooleanColumnSafe(cursor, str);
        if (parseBooleanColumnSafe == null) {
            return z;
        }
        return parseBooleanColumnSafe.booleanValue();
    }

    public static <T> T parseColumnSafe(Cursor cursor, String str, Class<T> cls) {
        T cast;
        try {
            int columnIndex = cursor.getColumnIndex(str);
            if (cls == Long.class) {
                if (cursor.isNull(columnIndex)) {
                    return null;
                }
                cast = cls.cast(Long.valueOf(cursor.getLong(columnIndex)));
            } else if (cls == Integer.class) {
                if (cursor.isNull(columnIndex)) {
                    return null;
                }
                cast = cls.cast(Integer.valueOf(cursor.getInt(columnIndex)));
            } else if (cls != String.class) {
                return null;
            } else {
                cast = cls.cast(cursor.getString(cursor.getColumnIndex(str)));
            }
            return cast;
        } catch (Exception e) {
            HSLogger.m3242e("DatabaseUtils", "Error in parse long column : " + str, e);
            return null;
        }
    }

    public static Boolean parseBooleanColumnSafe(Cursor cursor, String str) {
        Integer num = (Integer) parseColumnSafe(cursor, str, Integer.class);
        if (num == null) {
            return null;
        }
        boolean z = true;
        if (num.intValue() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
