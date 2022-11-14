package com.vungle.warren.persistence;

import android.content.ContentValues;
import androidx.annotation.NonNull;

public interface DBAdapter<T> {
    @NonNull
    T fromContentValues(ContentValues contentValues);

    String tableName();

    ContentValues toContentValues(T t);
}
