package com.vungle.warren.p037ui;

import androidx.annotation.NonNull;
import com.vungle.warren.model.Report;
import com.vungle.warren.persistence.Repository;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.vungle.warren.ui.DurationRecorder */
public class DurationRecorder {
    public AtomicBoolean paused = new AtomicBoolean(true);
    public final Repository.SaveCallback repoCallback;
    public final Report report;
    public final Repository repository;
    public long startMillis;

    public DurationRecorder(@NonNull Report report2, @NonNull Repository repository2, @NonNull Repository.SaveCallback saveCallback) {
        this.report = report2;
        this.repository = repository2;
        this.repoCallback = saveCallback;
    }

    private void save() {
        this.report.setAdDuration(System.currentTimeMillis() - this.startMillis);
        this.repository.save(this.report, this.repoCallback);
    }

    public void start() {
        if (this.paused.getAndSet(false)) {
            this.startMillis = System.currentTimeMillis() - this.report.getAdDuration();
        }
    }

    public void stop() {
        if (!this.paused.getAndSet(true)) {
            save();
        }
    }

    public void update() {
        if (!this.paused.get()) {
            save();
        }
    }
}
