package com.vungle.warren;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.vungle.warren.tasks.JobCreator;
import com.vungle.warren.tasks.JobInfo;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.tasks.runnable.JobRunnable;
import com.vungle.warren.tasks.utility.ThreadPriorityHelper;
import com.vungle.warren.utility.NetworkProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class VungleJobRunner implements JobRunner {
    public static final String TAG = VungleJobRunner.class.getSimpleName();
    public static Handler handler = new Handler(Looper.getMainLooper());
    public JobCreator creator;
    public Executor executor;
    public final NetworkProvider.NetworkListener networkListener = new NetworkProvider.NetworkListener() {
        public void onChanged(int i) {
            VungleJobRunner.this.executePendingJobs();
        }
    };
    public final NetworkProvider networkProvider;
    public long nextCheck = RecyclerView.FOREVER_NS;
    public List<PendingJob> pendingJobs;
    public Runnable pendingRunnable;
    public final ThreadPriorityHelper threadPriorityHelper;

    public static class PendingJob {
        public JobInfo info;
        public final long uptimeMillis;

        public PendingJob(long j, JobInfo jobInfo) {
            this.uptimeMillis = j;
            this.info = jobInfo;
        }
    }

    public static class PendingRunnable implements Runnable {
        public WeakReference<VungleJobRunner> runner;

        public PendingRunnable(WeakReference<VungleJobRunner> weakReference) {
            this.runner = weakReference;
        }

        public void run() {
            VungleJobRunner vungleJobRunner = (VungleJobRunner) this.runner.get();
            if (vungleJobRunner != null) {
                vungleJobRunner.executePendingJobs();
            }
        }
    }

    public VungleJobRunner(@NonNull JobCreator jobCreator, @NonNull Executor executor2, @Nullable ThreadPriorityHelper threadPriorityHelper2, @NonNull NetworkProvider networkProvider2) {
        this.creator = jobCreator;
        this.executor = executor2;
        this.threadPriorityHelper = threadPriorityHelper2;
        this.pendingJobs = new CopyOnWriteArrayList();
        this.networkProvider = networkProvider2;
        this.pendingRunnable = new PendingRunnable(new WeakReference(this));
    }

    /* access modifiers changed from: private */
    public synchronized void executePendingJobs() {
        synchronized (this) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = Long.MAX_VALUE;
            long j2 = 0;
            for (PendingJob next : this.pendingJobs) {
                if (uptimeMillis >= next.uptimeMillis) {
                    boolean z = true;
                    if (next.info.getRequiredNetworkType() == 1 && this.networkProvider.getCurrentNetworkType() == -1) {
                        z = false;
                        j2++;
                    }
                    if (z) {
                        this.pendingJobs.remove(next);
                        this.executor.execute(new JobRunnable(next.info, this.creator, this, this.threadPriorityHelper));
                    }
                } else {
                    j = Math.min(j, next.uptimeMillis);
                }
            }
            if (!(j == RecyclerView.FOREVER_NS || j == this.nextCheck)) {
                handler.removeCallbacks(this.pendingRunnable);
                handler.postAtTime(this.pendingRunnable, TAG, j);
            }
            this.nextCheck = j;
            if (j2 > 0) {
                this.networkProvider.addListener(this.networkListener);
            } else {
                this.networkProvider.removeListener(this.networkListener);
            }
        }
    }

    public synchronized void cancelPendingJob(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        for (PendingJob next : this.pendingJobs) {
            if (next.info.getJobTag().equals(str)) {
                arrayList.add(next);
            }
        }
        this.pendingJobs.removeAll(arrayList);
    }

    public synchronized void execute(@NonNull JobInfo jobInfo) {
        JobInfo copy = jobInfo.copy();
        String jobTag = copy.getJobTag();
        long delay = copy.getDelay();
        copy.setDelay(0);
        if (copy.getUpdateCurrent()) {
            for (PendingJob next : this.pendingJobs) {
                if (next.info.getJobTag().equals(jobTag)) {
                    String str = TAG;
                    Log.d(str, "replacing pending job with new " + jobTag);
                    this.pendingJobs.remove(next);
                }
            }
        }
        this.pendingJobs.add(new PendingJob(SystemClock.uptimeMillis() + delay, copy));
        executePendingJobs();
    }
}
