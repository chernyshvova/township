package dagger.internal;

public final class InstanceFactory<T> implements Object<T> {
    public final T instance;

    public InstanceFactory(T t) {
        this.instance = t;
    }

    public T get() {
        return this.instance;
    }
}
