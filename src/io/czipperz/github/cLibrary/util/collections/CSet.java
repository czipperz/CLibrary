package io.czipperz.github.cLibrary.util.collections;

import java.security.InvalidParameterException;

/**
 * @author czipperz on 4/8/15.
 */
public class CSet<E> extends TreeSet<E> {
    public CSet() {

    }
    public CSet(Collection<? extends E> col) {
        super(col);
    }
    public CSet(Comparator<? extends E> comp) {
        super(comp);
    }
    public CSet(SortedSet<E> set) {
        super(set);
    }

    public E get(int index) {
        Iterator<E> it = iterator(); 
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds!");
        int i = 0;
        E e = null;
        while(it.hasNext() ? (e = it.next()) != null : false) {
            if(i++ == index) {
                return e;
            }
        }
        return null;
    }

    public int indexOf(E e) {
        Iterator<E> it = iterator();
        int i = 0;
        E a = null;
        while(it.hasNext() ? (a = it.next()) != null : false) {
            if(a == e) {
                return i;
            }
            i++;
        }
        throw new InvalidParameterException("Set doesn't contain the parameter.");
    }
}
