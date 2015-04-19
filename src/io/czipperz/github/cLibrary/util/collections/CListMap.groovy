package io.czipperz.github.cLibrary.util.collections

import java.security.InvalidParameterException

/**
* @author czipperz on 4/8/15.
*/
class CListMap<K, T> implements Iterable<T>, Serializable {
	List<T> items
	List<K> keys

	CListMap() {
		this(new ArrayList<K>(), new ArrayList<T>())
	}

	CListMap(int i) {
		this(new ArrayList<K>(i), new ArrayList<T>(i))
	}

	CListMap(K[] k, T[] t) {
		this(CArrayHelper.toArrayList(k), CArrayHelper.toArrayList(t))
	}

	CListMap(List<K> items, List<T> keys) {
		if(items.size() != keys.size())
			throw new InvalidParameterException("Items and Keys must be of same length")
		this.items = items;
		this.keys = keys;
	}

	CListMap<K, T> clear() {
		items.clear()
		keys.clear()
		this
	}

	T get(K k) {
		getItem k
	}

	T getItem(K k) {
		items.get keys.indexOf(k)
	}

	K getKey(T t) {
		keys.get items.indexOf(t)
	}

	int indexOf(K k) {
		indexKey k
	}

	int indexKey(K k) {
		keys.indexOf k
	}

	int indexItem(T t) {
		items.indexOf t
	}

	boolean containsItem(T l) {
		items.contains l
	}

	boolean containsKey(K k) {
		keys.contains k
	}

	T getItem(int i) {
		items.get i
	}

	K getKey(int i) {
		keys.get i
	}

	boolean isEmpty() {
		if(items.isEmpty()) {
			keys.clear()
			return true
		}
		if(keys.isEmpty()) {
			items.clear()
			return true
		}
		return false
	}

	CListMap<K, T> put(K key, T item) {
		items.add item
		keys.add key
		this
	}

	CListMap<K, T> putAll(List<K> keys, List<T> items) {
		if(items.size() != keys.size())
			throw new InvalidParameterException()
		this.items.addAll items
		this.keys.addAll keys
		this
	}

	int size() {
		items.size()
	}

	Iterator<T> iterator() {
		iteratorItems()
	}

	Iterator<T> iteratorItems() {
		items.iterator()
	}

	Iterator<K> iteratorKeys() {
		keys.iterator()
	}
}
