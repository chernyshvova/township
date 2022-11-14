package com.vungle.warren.model;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import com.vungle.warren.persistence.DBAdapter;
import com.vungle.warren.persistence.IdColumns;

public class AnalyticUrlDBAdapter implements DBAdapter<AnalyticUrl> {
    public static final String CREATE_ANALYTICS_URL_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS analytic_url(_id INTEGER PRIMARY KEY AUTOINCREMENT,  item_id TEXT UNIQUE)";

    public interface AnalyticsUrlColumns extends IdColumns {
        public static final String TABLE_NAME = "analytic_url";
    }

    public String tableName() {
        return AnalyticsUrlColumns.TABLE_NAME;
    }

    @NonNull
    public AnalyticUrl fromContentValues(ContentValues contentValues) {
        return new AnalyticUrl(contentValues.getAsString("item_id"));
    }

    public ContentValues toContentValues(AnalyticUrl analyticUrl) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", analyticUrl.url);
        return contentValues;
    }
}
