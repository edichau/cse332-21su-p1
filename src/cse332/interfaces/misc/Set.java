package cse332.interfaces.misc;

import java.util.Iterator;

public abstract class Set<E> implements Iterable<E> {
    protected Dictionary<E, Boolean> map;
    
    @SuppressWarnings("unused")
    private Set(){}
    
    protected Set(Dictionary<E, Boolean> backingMap) {
        this.map = backingMap;
    }

    public final void add(E e) {
        this.map.insert(e, true);
    }

    public final void delete(E e) {
        this.map.delete(e);
    }

    public final boolean contains(E e) {
        return this.map.find(e) != null;
    }
    
    public final int size() {
        return this.map.size();
    }

    public final boolean isEmpty() {
        return this.size() == 0;
    }
    
    public Iterator<E> iterator() {
        return this.map.iterator();
    }
    
    public void clear() {
        this.map.clear();
    }
    
    public String toString() {
        return this.map.toString();
    }
}
