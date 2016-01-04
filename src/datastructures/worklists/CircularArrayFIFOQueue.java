package datastructures.worklists;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.FixedSizeFIFOWorkList;

/**
 * See cse332/interfaces/worklists/FixedSizeLIFOWorkList.java
 * for method specifications.
 */
public class CircularArrayFIFOQueue<E> extends FixedSizeFIFOWorkList<E> {
    public CircularArrayFIFOQueue(int capacity) {
        super(capacity);
        throw new NotYetImplementedException();
    }

    @Override
    public void add(E work) {
        throw new NotYetImplementedException();
    }

    @Override
    public E peek() {
        throw new NotYetImplementedException();
    }
    
    @Override
    public E peek(int i) {
        throw new NotYetImplementedException();
    }
    
    @Override
    public E next() {
        throw new NotYetImplementedException();
    }
    
    @Override
    public void update(int i, E value) {
        throw new NotYetImplementedException();
    }
    
    @Override
    public int size() {
        throw new NotYetImplementedException();
    }
    
    @Override
    public void clear() {
        throw new NotYetImplementedException();
    }
}
