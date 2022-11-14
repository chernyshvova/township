package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.p005db.SupportSQLiteDatabase;
import androidx.sqlite.p005db.SupportSQLiteOpenHelper;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper {
    @NonNull
    public final Context mContext;
    @Nullable
    public final String mCopyFromAssetPath;
    @Nullable
    public final File mCopyFromFile;
    @Nullable
    public DatabaseConfiguration mDatabaseConfiguration;
    public final int mDatabaseVersion;
    @NonNull
    public final SupportSQLiteOpenHelper mDelegate;
    public boolean mVerified;

    public SQLiteCopyOpenHelper(@NonNull Context context, @Nullable String str, @Nullable File file, int i, @NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.mContext = context;
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mDatabaseVersion = i;
        this.mDelegate = supportSQLiteOpenHelper;
    }

    private void copyDatabaseFile(File file) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.mCopyFromAssetPath != null) {
            readableByteChannel = Channels.newChannel(this.mContext.getAssets().open(this.mCopyFromAssetPath));
        } else if (this.mCopyFromFile != null) {
            readableByteChannel = new FileInputStream(this.mCopyFromFile).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.mContext.getCacheDir());
        createTempFile.deleteOnExit();
        FileUtil.copy(readableByteChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to create directories for ");
            outline24.append(file.getAbsolutePath());
            throw new IOException(outline24.toString());
        } else if (!createTempFile.renameTo(file)) {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Failed to move intermediate file (");
            outline242.append(createTempFile.getAbsolutePath());
            outline242.append(") to destination (");
            outline242.append(file.getAbsolutePath());
            outline242.append(").");
            throw new IOException(outline242.toString());
        }
    }

    private void verifyDatabaseFile() {
        String databaseName = getDatabaseName();
        File databasePath = this.mContext.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.mDatabaseConfiguration;
        CopyLock copyLock = new CopyLock(databaseName, this.mContext.getFilesDir(), databaseConfiguration == null || databaseConfiguration.multiInstanceInvalidation);
        try {
            copyLock.lock();
            if (!databasePath.exists()) {
                copyDatabaseFile(databasePath);
                copyLock.unlock();
            } else if (this.mDatabaseConfiguration == null) {
                copyLock.unlock();
            } else {
                try {
                    int readVersion = DBUtil.readVersion(databasePath);
                    if (readVersion == this.mDatabaseVersion) {
                        copyLock.unlock();
                    } else if (this.mDatabaseConfiguration.isMigrationRequired(readVersion, this.mDatabaseVersion)) {
                        copyLock.unlock();
                    } else {
                        if (this.mContext.deleteDatabase(databaseName)) {
                            try {
                                copyDatabaseFile(databasePath);
                            } catch (IOException e) {
                                Log.w(Room.LOG_TAG, "Unable to copy database file.", e);
                            }
                        } else {
                            Log.w(Room.LOG_TAG, "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                        }
                        copyLock.unlock();
                    }
                } catch (IOException e2) {
                    Log.w(Room.LOG_TAG, "Unable to read database version.", e2);
                    copyLock.unlock();
                }
            }
        } catch (IOException e3) {
            throw new RuntimeException("Unable to copy database file.", e3);
        } catch (Throwable th) {
            copyLock.unlock();
            throw th;
        }
    }

    public synchronized void close() {
        this.mDelegate.close();
        this.mVerified = false;
    }

    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    public synchronized SupportSQLiteDatabase getReadableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile();
            this.mVerified = true;
        }
        return this.mDelegate.getReadableDatabase();
    }

    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile();
            this.mVerified = true;
        }
        return this.mDelegate.getWritableDatabase();
    }

    public void setDatabaseConfiguration(@Nullable DatabaseConfiguration databaseConfiguration) {
        this.mDatabaseConfiguration = databaseConfiguration;
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.mDelegate.setWriteAheadLoggingEnabled(z);
    }
}
