package kotlin.collections;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Maps.kt */
public final class EmptyMap implements Map, Serializable, KMappedMarker {
    public static final EmptyMap INSTANCE = new EmptyMap();
    public static final long serialVersionUID = 8246714829545688274L;

    private final Object readResolve() {
        return INSTANCE;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(Object obj) {
        return false;
    }

    public final boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            Intrinsics.checkNotNullParameter((Void) obj, "value");
        }
        return false;
    }

    public final Set<Map.Entry> entrySet() {
        return EmptySet.INSTANCE;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    public final Object get(Object obj) {
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public final Set<Object> keySet() {
        return EmptySet.INSTANCE;
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return 0;
    }

    public String toString() {
        return JsonUtils.EMPTY_JSON;
    }

    public final Collection values() {
        return EmptyList.INSTANCE;
    }
}
