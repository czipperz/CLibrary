package io.github.czipperz.cLibrary.util.collections

import sun.awt.util.IdentityLinkedList

import java.security.InvalidParameterException

/**
 * Created by czipperz on 4/8/15.
 */
class CListMap<K, T> implements Iterable<T>, Serializable {
	List<T> items
	List<K> keys

	CListMap(int i) {
		this(new ArrayList<T>(i), new ArrayList<K>(i))
	}

	CListMap(K[] k, T[] t) {
		this(CArrayHelper.toArrayList(t), CArrayHelper.toArrayList(t))
	}

	public CListMap(List<T> items = new ArrayList<>(), List<K> keys = new ArrayList<>()) {
		if(items.size() != keys.size())
			throw new InvalidParameterException("Items and Keys must be of same length")
		this.items = items;
		this.keys = keys;
	}

	public CListMap<K, T> clear() {
		items.clear()
		keys.clear()
		this
	}

	public T get(K k) {
		getItem k
	}

	public T getItem(K k) {
		items.get keys.indexOf(k)
	}

	public K getKey(T t) {
		keys.get items.indexOf(t)
	}

	public int indexOf(K k) {
		indexKey k
	}

	public int indexKey(K k) {
		keys.indexOf k
	}

	public int indexItem(T t) {
		items.indexOf t
	}

	public boolean containsItem(T l) {
		items.contains l
	}

	public boolean containsKey(K k) {
		keys.contains k
	}

	public T getItem(int i) {
		items.get i
	}

	public K getKey(int i) {
		keys.get i
	}

	public boolean isEmpty() {
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

	public CListMap<K, T> put(K key, T item) {
		items.add item
		keys.add key
		this
	}

	public CListMap<K, T> putAll(List<K> keys, List<T> items) {
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
