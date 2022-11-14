package com.google.android.gms.common.api;

import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class DataBufferResponse<T, R extends AbstractDataBuffer<T> & Result> extends Response<R> implements DataBuffer<T> {
    @KeepForSdk
    public DataBufferResponse() {
    }

    public void close() {
        ((AbstractDataBuffer) getResult()).close();
    }

    @RecentlyNonNull
    public T get(int i) {
        return ((AbstractDataBuffer) getResult()).get(i);
    }

    public int getCount() {
        return ((AbstractDataBuffer) getResult()).getCount();
    }

    @RecentlyNullable
    public Bundle getMetadata() {
        return ((AbstractDataBuffer) getResult()).getMetadata();
    }

    public boolean isClosed() {
        return ((AbstractDataBuffer) getResult()).isClosed();
    }

    @RecentlyNonNull
    public Iterator<T> iterator() {
        return ((AbstractDataBuffer) getResult()).iterator();
    }

    public void release() {
        ((AbstractDataBuffer) getResult()).release();
    }

    @RecentlyNonNull
    public Iterator<T> singleRefIterator() {
        return ((AbstractDataBuffer) getResult()).singleRefIterator();
    }

    @KeepForSdk
    public DataBufferResponse(@RecentlyNonNull R r) {
        super(r);
    }
}
