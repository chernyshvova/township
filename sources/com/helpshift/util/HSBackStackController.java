package com.helpshift.util;

import java.util.Stack;

public class HSBackStackController<T> {
    public Stack<T> viewStateBackStack = new Stack<>();

    public synchronized boolean addItem(T t) {
        return this.viewStateBackStack.add(t);
    }

    public synchronized void clear() {
        this.viewStateBackStack.clear();
    }

    public synchronized T getLastItemOfType(Class cls) {
        if (isEmpty()) {
            return null;
        }
        for (int size = this.viewStateBackStack.size() - 1; size >= 0; size--) {
            T t = this.viewStateBackStack.get(size);
            if (cls.isInstance(t)) {
                return t;
            }
        }
        return null;
    }

    public synchronized T getTopItem() {
        if (isEmpty()) {
            return null;
        }
        return this.viewStateBackStack.peek();
    }

    public synchronized boolean isEmpty() {
        return this.viewStateBackStack.isEmpty();
    }

    public synchronized boolean isTopItemOfType(Class cls) {
        Object topItem = getTopItem();
        if (topItem == null) {
            return false;
        }
        return cls.isInstance(topItem);
    }

    public synchronized T popTopItem() {
        if (isEmpty()) {
            return null;
        }
        return this.viewStateBackStack.pop();
    }

    public synchronized T popTopItem(Class cls) {
        if (!isTopItemOfType(cls)) {
            return null;
        }
        return popTopItem();
    }
}
