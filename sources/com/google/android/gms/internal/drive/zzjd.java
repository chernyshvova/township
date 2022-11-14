package com.google.android.gms.internal.drive;

import java.util.NoSuchElementException;

public final class zzjd extends zzjf {
    public final int limit = this.zznu.size();
    public int position = 0;
    public final /* synthetic */ zzjc zznu;

    public zzjd(zzjc zzjc) {
        this.zznu = zzjc;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zznu.zzt(i);
        }
        throw new NoSuchElementException();
    }
}
