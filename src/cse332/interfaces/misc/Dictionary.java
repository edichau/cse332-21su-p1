package cse332.interfaces.misc;

import java.util.Iterator;

/**
 * An object that maps keys to values.
 * A Dictionary cannot contain duplicate keys; each key can map to at most one value.
 * 
 * Dictionaries may not contain null keys or values.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author  Adam Blank
 */
public abstract class Dictionary<K, V> implements Iterable<K> {
    protected int size;
    
    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     * @throws IllegalArgumentException if either key or value is null.
     */
    public abstract V insert(K key, V value);

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or
     *         {@code null} if this map contains no mapping for the key
     * @throws IllegalArgumentException if key is null.
     */
    public abstract V find(K key);

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param  key key whose mapping is to be removed from the map
     * @throws IllegalArgumentException if key is null.
     */    
    public abstract void delete(K key);

    /**
     * Resets the state of this map to be the same as if the constructor were just called. 
     */
    public abstract void clear();

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns <tt>true</tt> if this map contains no key-value mappings.
     *
     * @return <tt>true</tt> if this map contains no key-value mappings
     */
    public final boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * An iterator over the keys of the map
     */
    public abstract Iterator<K> iterator();
    
    /**
     * Subclasses *must* override toString()
     */
    public abstract String toString();
}
