package io.czipperz.github.cLibrary.util.collections

import java.security.InvalidParameterException

/**
* @author czipperz on 4/8/15.
*/
class CSet<E> extends TreeSet<E> {
	CSet() {

	}
	CSet(Collection<? extends E> col) {
		super(col)
	}
	CSet(Comparator<? extends E> comp) {
		super(comp)
	}
	CSet(SortedSet<E> set) {
		super(set)
	}

	E get(int index) {
		Iterator<E> it = iterator()
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Index out of bounds!")
		int i = 0
		E e = null
		while(it.hasNext() ? (e = it.next()) != null : false)
			if(i++ == index)
				return e
		null
	}

	int indexOf(E e) {
		Iterator<E> it = iterator()
		int i = 0
		E a = null
		while(it.hasNext() ? (a = it.next()) != null : false) {
			if(a == e)
				return i
			i++
		}
		throw new InvalidParameterException("Set doesn't contain the parameter.")
	}
}
