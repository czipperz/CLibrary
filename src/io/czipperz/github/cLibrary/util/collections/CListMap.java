package io.czipperz.github.cLibrary.util.collections;

import java.security.InvalidParameterException;

/**
 * @author czipperz on 4/8/15.
 */
public class CListMap<K, T> implements Iterable<T>, Serializable {
    private List<T> items;
    private List<K> keys;

    public CListMap() { this(new ArrayList<K>(), new ArrayList<T>()); }

    public CListMap(int i) { this(new ArrayList<K>(i), new ArrayList<T>(i)); }

    public CListMap(K[] k, T[] t) { this(CArrayHelper.toArrayList(k), CArrayHelper.toArrayList(t)); }

    public CListMap(List<K> items, List<T> keys) {
        if(items.size() != keys.size())
            throw new InvalidParameterException("Items and Keys must be of same length");
        this.items = items;
        this.keys = keys;
    }

    public CListMap<K, T> clear() {
        items.clear();
        keys.clear();
        return this;
    }

    public T get(K k) { return getItem(k); }

    public T getItem(K k) { return items.get(keys.indexOf(k)); }

    public K getKey(T t) { return keys.get(items.indexOf(t)); }

    public int indexOf(K k) { return indexKey(k); }

    public int indexKey(K k) { return keys.indexOf(k); }

    public int indexItem(T t) { return items.indexOf(t); }

    public boolean containsItem(T l) { return items.contains(l); }

    public boolean containsKey(K k) { return keys.contains(k); }

    public T getItem(int i) { return items.get(i); }

    public K getKey(int i) { return keys.get(i); }

    public boolean isEmpty() {
        if(items.isEmpty()) {
            keys.clear();
            return true;
        }
        if(keys.isEmpty()) {
            items.clear();
            return true;
        }
        return false;
    }

    public CListMap<K, T> put(K key, T item) {
        items.add(item);
        keys.add(key);
        return this;
    }

    public CListMap<K, T> putAll(List<K> keys, List<T> items) {
        if(items.size() != keys.size())
            throw new InvalidParameterException();
        this.items.addAll items;
        this.keys.addAll keys;
        return this;
    }

    public int size() { return items.size(); }

    public Iterator<T> iterator() { return iteratorItems(); }

    public Iterator<T> iteratorItems() { return items.iterator(); }

    public Iterator<K> iteratorKeys() { return keys.iterator(); }

    public List<T> getItems() { return this.items;     }
    public List<T> getKeys() { return this.keys;     }
}
