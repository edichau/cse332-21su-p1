package cse332.interfaces.trie;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import cse332.interfaces.worklists.FixedSizeFIFOWorkList;
import datastructures.worklists.CircularArrayFIFOQueue;

public abstract class BString<Alphabet> implements Iterable<Alphabet> {
    protected FixedSizeFIFOWorkList<Alphabet> str;

    public BString(Alphabet[] str) {
    	this.str = new CircularArrayFIFOQueue<Alphabet>(str.length);
    	for (int i = 0; i < str.length; i++) {
    		this.str.add(str[i]);
    	}
    }
    
    public BString(FixedSizeFIFOWorkList<Alphabet> q) {
    	this.str = q;
    }
    
    public final Iterator<Alphabet> iterator() {
        return str.iterator();
    }
    
    @SuppressWarnings("unchecked")
    public static <A, X extends BString<A>> Class<A> getLetterType(Class<X> clz) {
        try {
            return (Class<A>) clz.getMethod("getLetterType", (Class<?>[])null).invoke(null, (Object[])null);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException e) {
        	e.printStackTrace();
            System.err.println(clz.getName() + " does not have a getLetterType() method");
            System.exit(1);
            
            /* This is not reachable... */
            return null;
        }
        
    }
    
    public int size() {
        return str.size();
    }
    
    public final boolean isEmpty() {
        return str.size() == 0;
    }
        
    public String toString() {
        StringBuilder build = new StringBuilder();
        for (Alphabet chr : this) {
            build.append(chr);
        }
        return build.toString();
    }

    protected static Character[] wrap(char[] arr) {
        Character[] out = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            out[i] = arr[i];
        }
        return out;
    }       

    protected static Byte[] wrap(byte[] arr) {
        Byte[] out = new Byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            out[i] = arr[i];
        }
        return out;
    }
}
