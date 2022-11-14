package com.vungle.warren.utility;

import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.concurrent.Executor;

public class AsyncFileUtils {
    public static volatile Executor taskExecutor = new SDKExecutors().getTaskExecutor();

    public static class ExistenceOperation {
        public final FileExistenceTask task;

        public ExistenceOperation(@NonNull FileExistenceTask fileExistenceTask) {
            this.task = fileExistenceTask;
        }

        public void cancel() {
            this.task.clear();
            this.task.cancel(true);
        }
    }

    public interface FileExistCallback {
        void status(boolean z);
    }

    public static class FileExistenceTask extends AsyncTask<Void, Void, Boolean> {
        public FileExistCallback callback;
        public final File file;

        public FileExistenceTask(@Nullable File file2, @NonNull FileExistCallback fileExistCallback) {
            this.file = file2;
            this.callback = fileExistCallback;
        }

        /* access modifiers changed from: private */
        public synchronized void clear() {
            this.callback = null;
        }

        public Boolean doInBackground(Void... voidArr) {
            File file2 = this.file;
            return Boolean.valueOf(file2 != null && file2.exists());
        }

        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            synchronized (this) {
                if (this.callback != null) {
                    this.callback.status(bool.booleanValue());
                }
            }
        }
    }

    public static ExistenceOperation isFileExistAsync(@Nullable File file, @NonNull FileExistCallback fileExistCallback) {
        FileExistenceTask fileExistenceTask = new FileExistenceTask(file, fileExistCallback);
        ExistenceOperation existenceOperation = new ExistenceOperation(fileExistenceTask);
        fileExistenceTask.executeOnExecutor(taskExecutor, new Void[0]);
        return existenceOperation;
    }

    public static void setTaskExecutor(Executor executor) {
        taskExecutor = executor;
    }
}
