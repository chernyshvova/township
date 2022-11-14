package com.unity3d.scar.adapter.common;

public class DispatchGroup {
    public Runnable _runnable;
    public int _threadCount;

    public DispatchGroup() {
        this._threadCount = 0;
        this._threadCount = 0;
    }

    public synchronized void enter() {
        this._threadCount++;
    }

    public synchronized void leave() {
        Runnable runnable;
        int i = this._threadCount - 1;
        this._threadCount = i;
        if (i <= 0 && (runnable = this._runnable) != null) {
            runnable.run();
        }
    }
}
