package androidx.sqlite.p005db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.p005db.SupportSQLiteStatement;

/* renamed from: androidx.sqlite.db.framework.FrameworkSQLiteStatement */
public class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {
    public final SQLiteStatement mDelegate;

    public FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.mDelegate = sQLiteStatement;
    }

    public void execute() {
        this.mDelegate.execute();
    }

    public long executeInsert() {
        return this.mDelegate.executeInsert();
    }

    public int executeUpdateDelete() {
        return this.mDelegate.executeUpdateDelete();
    }

    public long simpleQueryForLong() {
        return this.mDelegate.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        return this.mDelegate.simpleQueryForString();
    }
}
