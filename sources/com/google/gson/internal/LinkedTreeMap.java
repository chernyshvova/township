package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    };
    public Comparator<? super K> comparator;
    public LinkedTreeMap<K, V>.EntrySet entrySet;
    public final Node<K, V> header = new Node<>();
    public LinkedTreeMap<K, V>.KeySet keySet;
    public int modCount = 0;
    public Node<K, V> root;
    public int size = 0;

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>(this) {
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                public Object next() {
                    return nextNode();
                }
            };
        }

        public boolean remove(Object obj) {
            Node findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    public final class KeySet extends AbstractSet<K> {
        public KeySet() {
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedTreeMap.this.findByObject(obj) != null;
        }

        public Iterator<K> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>(this) {
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                public K next() {
                    return nextNode().key;
                }
            };
        }

        public boolean remove(Object obj) {
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            Node findByObject = linkedTreeMap.findByObject(obj);
            if (findByObject != null) {
                linkedTreeMap.removeInternal(findByObject, true);
            }
            if (findByObject != null) {
                return true;
            }
            return false;
        }

        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        public int expectedModCount;
        public Node<K, V> lastReturned = null;
        public Node<K, V> next;

        public LinkedTreeMapIterator() {
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            this.next = linkedTreeMap.header.next;
            this.expectedModCount = linkedTreeMap.modCount;
        }

        public final boolean hasNext() {
            return this.next != LinkedTreeMap.this.header;
        }

        public final Node<K, V> nextNode() {
            Node<K, V> node = this.next;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node == linkedTreeMap.header) {
                throw new NoSuchElementException();
            } else if (linkedTreeMap.modCount == this.expectedModCount) {
                this.next = node.next;
                this.lastReturned = node;
                return node;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() {
            Node<K, V> node = this.lastReturned;
            if (node != null) {
                LinkedTreeMap.this.removeInternal(node, true);
                this.lastReturned = null;
                this.expectedModCount = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    static {
        Class<LinkedTreeMap> cls = LinkedTreeMap.class;
    }

    public LinkedTreeMap() {
        Comparator<Comparable> comparator2 = NATURAL_ORDER;
        this.comparator = comparator2;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node<K, V> node = this.header;
        node.prev = node;
        node.next = node;
    }

    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet entrySet2 = this.entrySet;
        if (entrySet2 != null) {
            return entrySet2;
        }
        LinkedTreeMap<K, V>.EntrySet entrySet3 = new EntrySet();
        this.entrySet = entrySet3;
        return entrySet3;
    }

    public Node<K, V> find(K k, boolean z) {
        int i;
        Node<K, V> node;
        Comparator<? super K> comparator2 = this.comparator;
        Node<K, V> node2 = this.root;
        if (node2 != null) {
            Comparable comparable = comparator2 == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(node2.key);
                } else {
                    i = comparator2.compare(k, node2.key);
                }
                if (i == 0) {
                    return node2;
                }
                Node<K, V> node3 = i < 0 ? node2.left : node2.right;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        Node<K, V> node4 = this.header;
        if (node2 != null) {
            node = new Node<>(node2, k, node4, node4.prev);
            if (i < 0) {
                node2.left = node;
            } else {
                node2.right = node;
            }
            rebalance(node2, true);
        } else if (comparator2 != NATURAL_ORDER || (k instanceof Comparable)) {
            node = new Node<>(node2, k, node4, node4.prev);
            this.root = node;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.size++;
        this.modCount++;
        return node;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if ((r3 == r5 || (r3 != null && r3.equals(r5))) != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.internal.LinkedTreeMap.Node<K, V> findByEntry(java.util.Map.Entry<?, ?> r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r5.getKey()
            com.google.gson.internal.LinkedTreeMap$Node r0 = r4.findByObject(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0023
            V r3 = r0.value
            java.lang.Object r5 = r5.getValue()
            if (r3 == r5) goto L_0x001f
            if (r3 == 0) goto L_0x001d
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r5 = 0
            goto L_0x0020
        L_0x001f:
            r5 = 1
        L_0x0020:
            if (r5 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            if (r1 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.findByEntry(java.util.Map$Entry):com.google.gson.internal.LinkedTreeMap$Node");
    }

    public Node<K, V> findByObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public V get(Object obj) {
        Node findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.value;
        }
        return null;
    }

    public Set<K> keySet() {
        LinkedTreeMap<K, V>.KeySet keySet2 = this.keySet;
        if (keySet2 != null) {
            return keySet2;
        }
        LinkedTreeMap<K, V>.KeySet keySet3 = new KeySet();
        this.keySet = keySet3;
        return keySet3;
    }

    public V put(K k, V v) {
        if (k != null) {
            Node find = find(k, true);
            V v2 = find.value;
            find.value = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public final void rebalance(Node<K, V> node, boolean z) {
        while (node != null) {
            Node<K, V> node2 = node.left;
            Node<K, V> node3 = node.right;
            int i = 0;
            int i2 = node2 != null ? node2.height : 0;
            int i3 = node3 != null ? node3.height : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                Node<K, V> node4 = node3.left;
                Node<K, V> node5 = node3.right;
                int i5 = node5 != null ? node5.height : 0;
                if (node4 != null) {
                    i = node4.height;
                }
                int i6 = i - i5;
                if (i6 == -1 || (i6 == 0 && !z)) {
                    rotateLeft(node);
                } else {
                    rotateRight(node3);
                    rotateLeft(node);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                Node<K, V> node6 = node2.left;
                Node<K, V> node7 = node2.right;
                int i7 = node7 != null ? node7.height : 0;
                if (node6 != null) {
                    i = node6.height;
                }
                int i8 = i - i7;
                if (i8 == 1 || (i8 == 0 && !z)) {
                    rotateRight(node);
                } else {
                    rotateLeft(node2);
                    rotateRight(node);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                node.height = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                node.height = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    public V remove(Object obj) {
        Node findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        if (findByObject != null) {
            return findByObject.value;
        }
        return null;
    }

    public void removeInternal(Node<K, V> node, boolean z) {
        Node<K, V> node2;
        int i;
        Node<K, V> node3;
        if (z) {
            Node<K, V> node4 = node.prev;
            node4.next = node.next;
            node.next.prev = node4;
        }
        Node<K, V> node5 = node.left;
        Node<K, V> node6 = node.right;
        Node<K, V> node7 = node.parent;
        int i2 = 0;
        if (node5 == null || node6 == null) {
            if (node5 != null) {
                replaceInParent(node, node5);
                node.left = null;
            } else if (node6 != null) {
                replaceInParent(node, node6);
                node.right = null;
            } else {
                replaceInParent(node, (Node<K, V>) null);
            }
            rebalance(node7, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (node5.height > node6.height) {
            Node<K, V> node8 = node5.right;
            while (true) {
                Node<K, V> node9 = node8;
                node2 = node5;
                node5 = node9;
                if (node5 == null) {
                    break;
                }
                node8 = node5.right;
            }
        } else {
            Node<K, V> node10 = node6.left;
            while (true) {
                Node<K, V> node11 = node6;
                node6 = node10;
                node3 = node11;
                if (node6 == null) {
                    break;
                }
                node10 = node6.left;
            }
            node2 = node3;
        }
        removeInternal(node2, false);
        Node<K, V> node12 = node.left;
        if (node12 != null) {
            i = node12.height;
            node2.left = node12;
            node12.parent = node2;
            node.left = null;
        } else {
            i = 0;
        }
        Node<K, V> node13 = node.right;
        if (node13 != null) {
            i2 = node13.height;
            node2.right = node13;
            node13.parent = node2;
            node.right = null;
        }
        node2.height = Math.max(i, i2) + 1;
        replaceInParent(node, node2);
    }

    public final void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 == null) {
            this.root = node2;
        } else if (node3.left == node) {
            node3.left = node2;
        } else {
            node3.right = node2;
        }
    }

    public final void rotateLeft(Node<K, V> node) {
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node3.left;
        Node<K, V> node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        int i = 0;
        int max = Math.max(node2 != null ? node2.height : 0, node4 != null ? node4.height : 0) + 1;
        node.height = max;
        if (node5 != null) {
            i = node5.height;
        }
        node3.height = Math.max(max, i) + 1;
    }

    public final void rotateRight(Node<K, V> node) {
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node2.left;
        Node<K, V> node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        int i = 0;
        int max = Math.max(node3 != null ? node3.height : 0, node5 != null ? node5.height : 0) + 1;
        node.height = max;
        if (node4 != null) {
            i = node4.height;
        }
        node2.height = Math.max(max, i) + 1;
    }

    public int size() {
        return this.size;
    }

    public static final class Node<K, V> implements Map.Entry<K, V> {
        public int height;
        public final K key;
        public Node<K, V> left;
        public Node<K, V> next;
        public Node<K, V> parent;
        public Node<K, V> prev;
        public Node<K, V> right;
        public V value;

        public Node() {
            this.key = null;
            this.prev = this;
            this.next = this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0032
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.key
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                V r0 = r3.value
                if (r0 != 0) goto L_0x0027
                java.lang.Object r4 = r4.getValue()
                if (r4 != 0) goto L_0x0032
                goto L_0x0031
            L_0x0027:
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0032
            L_0x0031:
                r1 = 1
            L_0x0032:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.Node.equals(java.lang.Object):boolean");
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public int hashCode() {
            K k = this.key;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.value;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public Node(Node<K, V> node, K k, Node<K, V> node2, Node<K, V> node3) {
            this.parent = node;
            this.key = k;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }
    }
}
