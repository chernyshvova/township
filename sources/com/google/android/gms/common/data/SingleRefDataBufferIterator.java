package com.google.android.gms.common.data;

import androidx.annotation.RecentlyNonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    public T zac;

    public SingleRefDataBufferIterator(@RecentlyNonNull DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @RecentlyNonNull
    public T next() {
        if (hasNext()) {
            int i = this.zab + 1;
            this.zab = i;
            if (i == 0) {
                T checkNotNull = Preconditions.checkNotNull(this.zaa.get(0));
                this.zac = checkNotNull;
                if (!(checkNotNull instanceof DataBufferRef)) {
                    String valueOf = String.valueOf(this.zac.getClass());
                    throw new IllegalStateException(GeneratedOutlineSupport.outline12(valueOf.length() + 44, "DataBuffer reference of type ", valueOf, " is not movable"));
                }
            } else {
                ((DataBufferRef) Preconditions.checkNotNull(this.zac)).zaa(this.zab);
            }
            return this.zac;
        }
        throw new NoSuchElementException(GeneratedOutlineSupport.outline9(46, "Cannot advance the iterator beyond ", this.zab));
    }
}
