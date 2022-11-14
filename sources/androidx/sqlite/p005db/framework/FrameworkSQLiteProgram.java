package androidx.sqlite.p005db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.p005db.SupportSQLiteProgram;

/* renamed from: androidx.sqlite.db.framework.FrameworkSQLiteProgram */
public class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    public final SQLiteProgram mDelegate;

    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.mDelegate = sQLiteProgram;
    }

    public void bindBlob(int i, byte[] bArr) {
        this.mDelegate.bindBlob(i, bArr);
    }

    public void bindDouble(int i, double d) {
        this.mDelegate.bindDouble(i, d);
    }

    public void bindLong(int i, long j) {
        this.mDelegate.bindLong(i, j);
    }

    public void bindNull(int i) {
        this.mDelegate.bindNull(i);
    }

    public void bindString(int i, String str) {
        this.mDelegate.bindString(i, str);
    }

    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    public void close() {
        this.mDelegate.close();
    }
}
