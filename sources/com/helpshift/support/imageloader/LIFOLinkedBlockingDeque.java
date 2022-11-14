package com.helpshift.support.imageloader;

import java.util.concurrent.LinkedBlockingDeque;

public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
    public boolean offer(T t) {
        return super.offerFirst(t);
    }

    public T remove() {
        return super.removeFirst();
    }
}
