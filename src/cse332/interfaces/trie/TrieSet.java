package cse332.interfaces.trie;

import cse332.interfaces.misc.Set;

public abstract class TrieSet<A, E extends BString<A>> extends Set<E> {
    protected TrieSet(TrieMap<A, E, Boolean> backingMap) {
        super(backingMap);
    }

    @SuppressWarnings("unchecked")
    public final boolean findPrefix(E e) {
        return ((TrieMap<A, E, Boolean>) this.map).findPrefix(e);
    }
}
