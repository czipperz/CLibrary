package com.czipperz.cLibrary.util.collections;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * An Array-Map.  This is Map that stores its data as two ArrayLists.  <code>&#60K, T&#62</code> where <code>&#60T&#62</code> is the <code>i<strong>T</strong>ems</code> and <code>&#60K&#62</code> is the <code><strong>K</strong>eys</code>.
 * @author Chris Gregory
 * @param <K> - <strong>K</strong>eys
 * @param <T> - i<strong>T</strong>ems
 */
public class CListMap<K, T> implements Iterable<T>, Serializable {
	private static final long serialVersionUID = -5168955016838216215L;
	private List<T> items;
	private List<K> keys;

	public CListMap(int i) {
		this(new ArrayList<T>(i), new ArrayList<K>(i));
	}

	public CListMap(K[] k, T[] t) {
		this(CArrayHelper.toArrayList(t), CArrayHelper.toArrayList(k));
	}
	
	public CListMap(List<T> items, List<K> keys) {
		if(items.size() != keys.size())
			throw new InvalidParameterException("Items and Keys must be of same length");
		this.items = items;
		this.keys = keys;
	}
	
	public CListMap() {
		this(new ArrayList<T>(), new ArrayList<K>());
	}

	public CListMap<K, T> clear() {
		items.clear();
		keys.clear();
		return this;
	}
	
	public T get(K k) {
		return items.get(keys.indexOf(k));
	}
	
	public T getItem(K k) {
		return items.get(keys.indexOf(k));
	}
	
	public K getKey(T t) {
		return keys.get(items.indexOf(t));
	}

	public int indexOf(K k) {
		return keys.indexOf(k);
	}

	public int indexKey(K k) {
		return keys.indexOf(k);
	}
	
	public int indexItem(T t) {
		return items.indexOf(t);
	}
	
	public boolean containsKey(K k) {
		return keys.contains(k);
	}

	public boolean containsItem(T t) {
		return items.contains(t);
	}
	
	public T getItem(int i) {
		return items.get(i);
	}

	public K getKey(int i) {
		return keys.get(i);
	}

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

	public List<T> getItems() {
		return items;
	}
	
	public List<K> getKeys() {
		return keys;
	}

	public CListMap<K, T> put(K key, T item) {
		items.add(item);
		keys.add(key);
		return this;
	}

	public CListMap<K, T> putAll(List<K> keys, List<T> items) {
		if(items.size() != keys.size()) {
			throw new InvalidParameterException();
		}
		this.items.addAll(items);
		this.keys.addAll(keys);
		return this;
	}
	
	public CListMap<K, T> putAll(Map<K, T> o) {
		return this;
	}
	
	public CListMap<K, T> putAll(CListMap<K, T> o) {
		for(int i = 0; i < o.size(); i++) {
			this.put(o.getKey(i), o.getItem(i));
		}
		return this;
	}

	public CListMap<K, T> remove(Object o) {
		if(items.contains(o)) {
			int index = items.indexOf(o);
			items.remove(index);
			keys.remove(index);
			return this;
		} else if(keys.contains(o)) {
			int index = keys.indexOf(o);
			items.remove(index);
			keys.remove(o);
		}
		throw new InvalidParameterException("No instance in CListMap.");
	}

	public int size() {
		return items.size();
	}

	public Iterator<T> iterator() {
		return iteratorItems();
	}

	public Iterator<T> iteratorItems() {
		return items.iterator();
	}
	
	public Iterator<K> iteratorKeys() {
		return keys.iterator();
	}
}
