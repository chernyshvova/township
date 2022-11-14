package com.google.android.gms.common.data;

import androidx.annotation.RecentlyNonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class DataBufferIterator<T> implements Iterator<T> {
    @RecentlyNonNull
    public final DataBuffer<T> zaa;
    public int zab = -1;

    public DataBufferIterator(@RecentlyNonNull DataBuffer<T> dataBuffer) {
        this.zaa = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
    }

    public boolean hasNext() {
        return this.zab < this.zaa.getCount() - 1;
    }

    @RecentlyNonNull
    public T next() {
        if (hasNext()) {
            DataBuffer<T> dataBuffer = this.zaa;
            int i = this.zab + 1;
            this.zab = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException(GeneratedOutlineSupport.outline9(46, "Cannot advance the iterator beyond ", this.zab));
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
