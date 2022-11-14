package kotlin.collections;

import com.android.billingclient.api.zzam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Collections.kt */
public class CollectionsKt__CollectionsKt {
    public static final <T> ArrayList<T> arrayListOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new ArrayAsCollection(tArr, true));
    }

    public static final <T> boolean contains(Iterable<? extends T> iterable, T t) {
        int i;
        Intrinsics.checkNotNullParameter(iterable, "$this$contains");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        Intrinsics.checkNotNullParameter(iterable, "$this$indexOf");
        if (!(iterable instanceof List)) {
            Iterator<? extends T> it = iterable.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                Object next = it.next();
                if (i2 < 0) {
                    throw new ArithmeticException("Index overflow has happened.");
                } else if (Intrinsics.areEqual(t, next)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            i = ((List) iterable).indexOf(t);
        }
        if (i >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> List<T> filterNotNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$filterNotNull");
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullParameter(iterable, "$this$filterNotNullTo");
        Intrinsics.checkNotNullParameter(arrayList, "destination");
        for (Object next : iterable) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static final <T> T first(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$first");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T last(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$last");
        if (!list.isEmpty()) {
            Intrinsics.checkNotNullParameter(list, "$this$lastIndex");
            return list.get(list.size() - 1);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> List<T> listOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (tArr.length > 0) {
            return zzam.asList(tArr);
        }
        return EmptyList.INSTANCE;
    }

    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size == 0) {
            return EmptyList.INSTANCE;
        }
        if (size != 1) {
            return list;
        }
        return zzam.listOf(list.get(0));
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "$this$plus");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    public static final <T> List<T> sortedWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return toList(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        if (array != null) {
            Intrinsics.checkNotNullParameter(array, "$this$sortWith");
            Intrinsics.checkNotNullParameter(comparator, "comparator");
            if (array.length > 1) {
                Arrays.sort(array, comparator);
            }
            return zzam.asList(array);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Iterable<? extends T> iterable, C c) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c, "destination");
        for (Object add : iterable) {
            c.add(add);
        }
        return c;
    }

    public static final <T> List<T> toList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return optimizeReadOnlyList(toMutableList(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return EmptyList.INSTANCE;
        }
        if (size != 1) {
            return toMutableList(collection);
        }
        return zzam.listOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return toMutableList((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        toCollection(iterable, arrayList);
        return arrayList;
    }

    public static final <T> Set<T> toMutableSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toMutableSet");
        return new LinkedHashSet((Collection) iterable);
    }

    public static final <T> Set<T> toSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toSet");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return EmptySet.INSTANCE;
            }
            if (size != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(zzam.mapCapacity(collection.size()));
                toCollection(iterable, linkedHashSet);
                return linkedHashSet;
            }
            return zzam.setOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        toCollection(iterable, linkedHashSet2);
        Intrinsics.checkNotNullParameter(linkedHashSet2, "$this$optimizeReadOnlySet");
        int size2 = linkedHashSet2.size();
        if (size2 == 0) {
            return EmptySet.INSTANCE;
        }
        if (size2 != 1) {
            return linkedHashSet2;
        }
        return zzam.setOf(linkedHashSet2.iterator().next());
    }

    public static final <T> List<T> plus(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "$this$plus");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        zzam.addAll(arrayList2, iterable);
        return arrayList2;
    }

    public static final <T> List<T> toMutableList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }
}
